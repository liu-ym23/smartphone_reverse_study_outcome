package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.arch.core.util.Function;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ActivityResultCaller {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = null;
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    ViewModelProvider.Factory mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<OnPreAttachedListener> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    Runnable mPostponedDurationRunnable;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    SavedStateRegistryController mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;
    String mWho;

    private void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        toString();
    L6:
        if (this.mView == null) goto L8;
        restoreViewState(this.mSavedFragmentState);
    L8:
        this.mSavedFragmentState = null;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return HasDefaultViewModelProviderFactory.-CC.$default$getDefaultViewModelCreationExtras(this);
    }

    public final Fragment getTargetFragment() {
        return getTargetFragment(true);
    }

    public void onAttachFragment(Fragment r1) {
    }

    public boolean onContextItemSelected(MenuItem r1) {
        return false;
    }

    public Animation onCreateAnimation(int r1, boolean r2, int r3) {
        return null;
    }

    public Animator onCreateAnimator(int r1, boolean r2, int r3) {
        return null;
    }

    public void onCreateOptionsMenu(Menu r1, MenuInflater r2) {
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public void onHiddenChanged(boolean r1) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean r1) {
    }

    public boolean onOptionsItemSelected(MenuItem r1) {
        return false;
    }

    public void onOptionsMenuClosed(Menu r1) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean r1) {
    }

    public void onPrepareOptionsMenu(Menu r1) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean r1) {
    }

    public void onRequestPermissionsResult(int r1, String[] r2, int[] r3) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle r1) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View r1, Bundle r2) {
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled == false) goto L9;
        if (this.mChildFragmentManager.isDestroyed() == true) goto L10;
        this.mChildFragmentManager.dispatchDestroy();
        this.mChildFragmentManager = new FragmentManagerImpl();
        return;
    L10:
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    static {
        USE_DEFAULT_TRANSITION = new Object();
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo != null) goto L6;
        this.mAnimationInfo = new AnimationInfo();
    L6:
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        Lifecycle.State r0 = this.mMaxState;
        if (r0 == Lifecycle.State.INITIALIZED) goto L10;
        if (this.mParentFragment == null) goto L10;
        return Math.min(r0.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    L10:
        return r0.ordinal();
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mDefaultFactory = null;
    }

    public FragmentContainer createFragmentContainer() {
        return new 4(this);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final FragmentActivity getActivity() {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (FragmentActivity) r0.getActivity();
    }

    public boolean getAllowEnterTransitionOverlap() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L8;
        Boolean r1 = r0.mAllowEnterTransitionOverlap;
        if (r1 == null) goto L8;
        return r1.booleanValue();
    L8:
        return true;
    }

    public boolean getAllowReturnTransitionOverlap() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L8;
        Boolean r1 = r0.mAllowReturnTransitionOverlap;
        if (r1 == null) goto L8;
        return r1.booleanValue();
    L8:
        return true;
    }

    public View getAnimatingAway() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mAnimatingAway;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost == null) goto L7;
        return this.mChildFragmentManager;
    L7:
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getContext();
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager == null) goto L22;
        if (this.mDefaultFactory != null) goto L20;
        Context r0 = requireContext().getApplicationContext();
    L8:
        if ((r0 instanceof ContextWrapper) == false) goto L13;
        if ((r0 instanceof Application) == true) goto L11;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L8
    L11:
        Application r1 = (Application) r0;
    L14:
        if (r1 == null) goto L16;
    L18:
        this.mDefaultFactory = new SavedStateViewModelFactory(r1, this, getArguments());
        goto L20
    L16:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L18;
        Objects.toString(requireContext().getApplicationContext());
        goto L18
    L13:
        r1 = null;
    L20:
        return this.mDefaultFactory;
    L22:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    int getEnterAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mEnterAnim;
    }

    public Object getEnterTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mEnterTransition;
    }

    public SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mEnterTransitionCallback;
    }

    int getExitAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mExitAnim;
    }

    public Object getExitTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mExitTransition;
    }

    public SharedElementCallback getExitTransitionCallback() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mExitTransitionCallback;
    }

    public View getFocusedView() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mFocusedView;
    }

    public final Object getHost() {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.onGetHost();
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater r0 = this.mLayoutInflater;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return performGetLayoutInflater(null);
    }

    public int getNextTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mNextTransition;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager r0 = this.mFragmentManager;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public boolean getPopDirection() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.mIsPop;
    }

    public int getPopEnterAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mPopEnterAnim;
    }

    public int getPopExitAnim() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.mPopExitAnim;
    }

    public float getPostOnViewCreatedAlpha() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        return r0.mPostOnViewCreatedAlpha;
    }

    public Object getReenterTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L6;
        return null;
    L6:
        Object r1 = r0.mReenterTransition;
        if (r1 == USE_DEFAULT_TRANSITION) goto L9;
        return r1;
    L9:
        return getExitTransition();
    }

    public Object getReturnTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L6;
        return null;
    L6:
        Object r1 = r0.mReturnTransition;
        if (r1 == USE_DEFAULT_TRANSITION) goto L9;
        return r1;
    L9:
        return getEnterTransition();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public Object getSharedElementEnterTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L6;
        return null;
    L6:
        Object r1 = r0.mSharedElementReturnTransition;
        if (r1 == USE_DEFAULT_TRANSITION) goto L9;
        return r1;
    L9:
        return getSharedElementEnterTransition();
    }

    public ArrayList<String> getSharedElementSourceNames() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L9;
        ArrayList<String> r1 = r0.mSharedElementSourceNames;
        if (r1 == null) goto L9;
        return r1;
    L9:
        return new ArrayList();
    }

    public ArrayList<String> getSharedElementTargetNames() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L9;
        ArrayList<String> r1 = r0.mSharedElementTargetNames;
        if (r1 == null) goto L9;
        return r1;
    L9:
        return new ArrayList();
    }

    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner r0 = this.mViewLifecycleOwner;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) goto L11;
        if (getMinimumMaxLifecycleState() == Lifecycle.State.INITIALIZED.ordinal()) goto L9;
        return this.mFragmentManager.getViewModelStore(this);
    L9:
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    L11:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final boolean isAdded() {
        if (this.mHost != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mAdded == false) goto L7;
        return true;
    }

    public final boolean isHidden() {
        if (this.mHidden == true) goto L10;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 != null) goto L7;
    L9:
        return false;
    L7:
        if (r0.isParentHidden(this.mParentFragment) == false) goto L9;
    L10:
        return true;
    }

    public final boolean isInBackStack() {
        if (this.mBackStackNesting <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMenuVisible() {
        if (this.mMenuVisible == false) goto L9;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 != null) goto L7;
    L8:
        return true;
    L7:
        if (r0.isParentMenuVisible(this.mParentFragment) == true) goto L8;
    L9:
        return false;
    }

    public boolean isPostponed() {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.mEnterTransitionPostponed;
    }

    public final boolean isResumed() {
        if (this.mState < 7) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isStateSaved() {
        FragmentManager r0 = this.mFragmentManager;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isStateSaved();
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    public void performAttach() {
        Iterator<OnPreAttachedListener> r0 = this.mOnPreAttachedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPreAttached();
        goto L4
    L6:
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.attachController(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.getContext());
        if (this.mCalled == false) goto L11;
        this.mFragmentManager.dispatchOnAttachFragment(this);
        this.mChildFragmentManager.dispatchAttach();
        return;
    L11:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
    }

    public void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled == false) goto L6;
        return;
    L6:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void performDestroyView() {
        this.mChildFragmentManager.dispatchDestroyView();
        if (this.mView != null) goto L5;
    L7:
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled == false) goto L12;
        LoaderManager.getInstance(this).markForRedelivery();
        this.mPerformedCreateView = false;
        return;
    L12:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    L5:
        if (this.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        goto L7
    }

    public void performPause() {
        this.mChildFragmentManager.dispatchPause();
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    L5:
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    public void performPrimaryNavigationFragmentChanged() {
        boolean r0 = this.mFragmentManager.isPrimaryNavigation(this);
        Boolean r1 = this.mIsPrimaryNavigationFragment;
        if (r1 != null) goto L5;
    L6:
        this.mIsPrimaryNavigationFragment = Boolean.valueOf(r0);
        onPrimaryNavigationFragmentChanged(r0);
        this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
        return;
    L5:
        if (r1.booleanValue() != r0) goto L6;
    }

    public void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled == false) goto L10;
        LifecycleRegistry r0 = this.mLifecycleRegistry;
        Lifecycle.Event r1 = Lifecycle.Event.ON_RESUME;
        r0.handleLifecycleEvent(r1);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(r1);
    L7:
        this.mChildFragmentManager.dispatchResume();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    public void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled == false) goto L10;
        LifecycleRegistry r0 = this.mLifecycleRegistry;
        Lifecycle.Event r1 = Lifecycle.Event.ON_START;
        r0.handleLifecycleEvent(r1);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(r1);
    L7:
        this.mChildFragmentManager.dispatchStart();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    public void performStop() {
        this.mChildFragmentManager.dispatchStop();
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    L5:
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.dispatchViewCreated();
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        if (ensureAnimationInfo().mEnterTransitionPostponed == true) goto L8;
        return;
    L8:
        if (this.mHost != null) goto L11;
        ensureAnimationInfo().mEnterTransitionPostponed = false;
        return;
    L11:
        if (Looper.myLooper() == this.mHost.getHandler().getLooper()) goto L13;
        this.mHost.getHandler().postAtFrontOfQueue(new 2(this));
        return;
    L13:
        callStartTransitionListener(true);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append(getClass().getSimpleName());
        r0.append("{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append("} (");
        r0.append(this.mWho);
        if (this.mFragmentId == 0) goto L6;
        r0.append(" id=0x");
        r0.append(Integer.toHexString(this.mFragmentId));
    L6:
        if (this.mTag == null) goto L8;
        r0.append(" tag=");
        r0.append(this.mTag);
    L8:
        r0.append(")");
        return r0.toString();
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new 1(this);
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList();
        initLifecycle();
    }

    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final boolean getRetainInstance() {
        FragmentStrictMode.onGetRetainInstanceUsage(this);
        return this.mRetainInstance;
    }

    public final int getTargetRequestCode() {
        FragmentStrictMode.onGetTargetFragmentRequestCodeUsage(this);
        return this.mTargetRequestCode;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        initLifecycle();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isVisible() {
        if (isAdded() == true) goto L5;
    L13:
        return false;
    L5:
        if (isHidden() == true) goto L13;
        View r0 = this.mView;
        if (r0 == null) goto L13;
        if (r0.getWindowToken() == null) goto L13;
        if (this.mView.getVisibility() != 0) goto L13;
        return true;
    }

    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.dispatchLowMemory();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context r0 = getContext();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object r0 = getHost();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Fragment requireParentFragment() {
        Fragment r0 = getParentFragment();
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (getContext() != null) goto L9;
        throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
    L9:
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View r0 = getView();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final String getTag() {
        return this.mTag;
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public Fragment(int r1) {
        this();
        this.mContentLayoutId = r1;
    }

    private Fragment getTargetFragment(boolean r2) {
        if (r2 == false) goto L4;
        FragmentStrictMode.onGetTargetFragmentUsage(this);
    L4:
        Fragment r3 = this.mTarget;
        if (r3 == null) goto L7;
        return r3;
    L7:
        FragmentManager r4 = this.mFragmentManager;
        if (r4 == null) goto L13;
        String r0 = this.mTargetWho;
        if (r0 != null) goto L12;
        return null;
    L12:
        return r4.findActiveFragment(r0);
    L13:
        return null;
    }

    private void registerOnPreAttachListener(OnPreAttachedListener r2) {
        if (this.mState < 0) goto L5;
        r2.onPreAttached();
        return;
    L5:
        this.mOnPreAttachedListeners.add(r2);
    }

    public void callStartTransitionListener(boolean r3) {
        AnimationInfo r0 = this.mAnimationInfo;
        if (r0 == null) goto L6;
        r0.mEnterTransitionPostponed = false;
    L6:
        if (this.mView == null) goto L16;
        ViewGroup r1 = this.mContainer;
        if (r1 == null) goto L17;
        FragmentManager r2 = this.mFragmentManager;
        if (r2 == null) goto L18;
        SpecialEffectsController r4 = SpecialEffectsController.getOrCreateController(r1, r2);
        r4.markPostponedState();
        if (r3 == false) goto L14;
        this.mHost.getHandler().post(new 3(this, r4));
        return;
    L14:
        r4.executePendingOperations();
        return;
    L18:
        return;
    L17:
        return;
    }

    public final boolean equals(Object r1) {
        return super.equals(r1);
    }

    public Fragment findFragmentByWho(String r2) {
        if (r2.equals(this.mWho) == false) goto L6;
        return this;
    L6:
        return this.mChildFragmentManager.findFragmentByWho(r2);
    }

    public LayoutInflater getLayoutInflater(Bundle r2) {
        FragmentHostCallback<?> r3 = this.mHost;
        if (r3 == null) goto L7;
        LayoutInflater r4 = r3.onGetLayoutInflater();
        LayoutInflaterCompat.setFactory2(r4, this.mChildFragmentManager.getLayoutInflaterFactory());
        return r4;
    L7:
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public final String getString(int r2) {
        return getResources().getString(r2);
    }

    public final CharSequence getText(int r2) {
        return getResources().getText(r2);
    }

    public void onActivityCreated(Bundle r1) {
        this.mCalled = true;
    }

    public void onAttach(Context r2) {
        this.mCalled = true;
        FragmentHostCallback<?> r3 = this.mHost;
        if (r3 != null) goto L5;
        Activity r4 = null;
    L6:
        if (r4 == null) goto L9;
        this.mCalled = false;
        onAttach(r4);
        return;
    L9:
        return;
    L5:
        r4 = r3.getActivity();
        goto L6
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        this.mCalled = true;
    }

    public void onCreate(Bundle r2) {
        this.mCalled = true;
        restoreChildFragmentState(r2);
        if (this.mChildFragmentManager.isStateAtLeast(1) == true) goto L6;
        this.mChildFragmentManager.dispatchCreate();
        return;
    }

    public LayoutInflater onGetLayoutInflater(Bundle r1) {
        return getLayoutInflater(r1);
    }

    public void onViewStateRestored(Bundle r1) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle r3) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(r3);
        if (this.mCalled == false) goto L7;
        restoreViewState();
        this.mChildFragmentManager.dispatchActivityCreated();
        return;
    L7:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public void performConfigurationChanged(Configuration r2) {
        onConfigurationChanged(r2);
        this.mChildFragmentManager.dispatchConfigurationChanged(r2);
    }

    public boolean performContextItemSelected(MenuItem r2) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (onContextItemSelected(r2) == false) goto L9;
        return true;
    L9:
        return this.mChildFragmentManager.dispatchContextItemSelected(r2);
    }

    public void performCreate(Bundle r4) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.addObserver(new 5(this));
        this.mSavedStateRegistryController.performRestore(r4);
        onCreate(r4);
        this.mIsCreated = true;
        if (this.mCalled == false) goto L7;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L7:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    public LayoutInflater performGetLayoutInflater(Bundle r1) {
        LayoutInflater r2 = onGetLayoutInflater(r1);
        this.mLayoutInflater = r2;
        return r2;
    }

    public void performMultiWindowModeChanged(boolean r2) {
        onMultiWindowModeChanged(r2);
        this.mChildFragmentManager.dispatchMultiWindowModeChanged(r2);
    }

    public boolean performOptionsItemSelected(MenuItem r2) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L13;
        if (this.mMenuVisible == false) goto L13;
        if (onOptionsItemSelected(r2) == false) goto L13;
        return true;
    L13:
        return this.mChildFragmentManager.dispatchOptionsItemSelected(r2);
    }

    public void performOptionsMenuClosed(Menu r2) {
        if (this.mHidden == false) goto L5;
        return;
    L5:
        if (this.mHasMenu == true) goto L7;
    L9:
        this.mChildFragmentManager.dispatchOptionsMenuClosed(r2);
        return;
    L7:
        if (this.mMenuVisible == false) goto L9;
        onOptionsMenuClosed(r2);
        goto L9
    }

    public void performPictureInPictureModeChanged(boolean r2) {
        onPictureInPictureModeChanged(r2);
        this.mChildFragmentManager.dispatchPictureInPictureModeChanged(r2);
    }

    public boolean performPrepareOptionsMenu(Menu r3) {
        boolean r1 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        onPrepareOptionsMenu(r3);
        r1 = true;
    L10:
        return r1 | this.mChildFragmentManager.dispatchPrepareOptionsMenu(r3);
    }

    public void performSaveInstanceState(Bundle r3) {
        onSaveInstanceState(r3);
        this.mSavedStateRegistryController.performSave(r3);
        Parcelable r0 = this.mChildFragmentManager.saveAllStateInternal();
        if (r0 == null) goto L6;
        r3.putParcelable("android:support:fragments", r0);
        return;
    }

    public void registerForContextMenu(View r1) {
        r1.setOnCreateContextMenuListener(this);
    }

    public void restoreChildFragmentState(Bundle r2) {
        if (r2 == null) goto L7;
        Parcelable r3 = r2.getParcelable("android:support:fragments");
        if (r3 == null) goto L8;
        this.mChildFragmentManager.restoreSaveStateInternal(r3);
        this.mChildFragmentManager.dispatchCreate();
        return;
    L8:
        return;
    }

    public final void restoreViewState(Bundle r4) {
        SparseArray<Parcelable> r0 = this.mSavedViewState;
        if (r0 == null) goto L6;
        this.mView.restoreHierarchyState(r0);
        this.mSavedViewState = null;
    L6:
        if (this.mView == null) goto L8;
        this.mViewLifecycleOwner.performRestore(this.mSavedViewRegistryState);
        this.mSavedViewRegistryState = null;
    L8:
        this.mCalled = false;
        onViewStateRestored(r4);
        if (this.mCalled == false) goto L15;
        if (this.mView == null) goto L16;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L16:
        return;
    L15:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void setAllowEnterTransitionOverlap(boolean r2) {
        AnimationInfo r0 = ensureAnimationInfo();
        r0.mAllowEnterTransitionOverlap = Boolean.valueOf(r2);
    }

    public void setAllowReturnTransitionOverlap(boolean r2) {
        AnimationInfo r0 = ensureAnimationInfo();
        r0.mAllowReturnTransitionOverlap = Boolean.valueOf(r2);
    }

    public void setArguments(Bundle r2) {
        if (this.mFragmentManager != null) goto L5;
    L9:
        this.mArguments = r2;
        return;
    L5:
        if (isStateSaved() == false) goto L9;
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(SharedElementCallback r2) {
        ensureAnimationInfo().mEnterTransitionCallback = r2;
    }

    public void setEnterTransition(Object r2) {
        ensureAnimationInfo().mEnterTransition = r2;
    }

    public void setExitSharedElementCallback(SharedElementCallback r2) {
        ensureAnimationInfo().mExitTransitionCallback = r2;
    }

    public void setExitTransition(Object r2) {
        ensureAnimationInfo().mExitTransition = r2;
    }

    public void setFocusedView(View r2) {
        ensureAnimationInfo().mFocusedView = r2;
    }

    public void setHasOptionsMenu(boolean r2) {
        if (this.mHasMenu == r2) goto L10;
        this.mHasMenu = r2;
        if (isAdded() == true) goto L7;
        return;
    L7:
        if (isHidden() == true) goto L12;
        this.mHost.onSupportInvalidateOptionsMenu();
        return;
    L12:
        return;
    }

    public void setInitialSavedState(SavedState r2) {
        if (this.mFragmentManager != null) goto L12;
        if (r2 == null) goto L8;
        Bundle r3 = r2.mState;
        if (r3 == null) goto L8;
    L9:
        this.mSavedFragmentState = r3;
        return;
    L8:
        r3 = null;
        goto L9
    L12:
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean r2) {
        if (this.mMenuVisible == r2) goto L12;
        this.mMenuVisible = r2;
        if (this.mHasMenu == true) goto L7;
        return;
    L7:
        if (isAdded() == true) goto L9;
        return;
    L9:
        if (isHidden() == true) goto L15;
        this.mHost.onSupportInvalidateOptionsMenu();
        return;
    L15:
        return;
    }

    public void setNextTransition(int r2) {
        if (this.mAnimationInfo != null) goto L6;
        if (r2 != 0) goto L6;
        return;
    L6:
        ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = r2;
    }

    public void setPopDirection(boolean r2) {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        ensureAnimationInfo().mIsPop = r2;
    }

    public void setPostOnViewCreatedAlpha(float r2) {
        ensureAnimationInfo().mPostOnViewCreatedAlpha = r2;
    }

    public void setReenterTransition(Object r2) {
        ensureAnimationInfo().mReenterTransition = r2;
    }

    public void setRetainInstance(boolean r2) {
        FragmentStrictMode.onSetRetainInstanceUsage(this);
        this.mRetainInstance = r2;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 == null) goto L7;
        if (r2 == false) goto L6;
        r0.addRetainedFragment(this);
        return;
    L6:
        r0.removeRetainedFragment(this);
        return;
    L7:
        this.mRetainInstanceChangedWhileDetached = true;
    }

    public void setReturnTransition(Object r2) {
        ensureAnimationInfo().mReturnTransition = r2;
    }

    public void setSharedElementEnterTransition(Object r2) {
        ensureAnimationInfo().mSharedElementEnterTransition = r2;
    }

    public void setSharedElementReturnTransition(Object r2) {
        ensureAnimationInfo().mSharedElementReturnTransition = r2;
    }

    public void setUserVisibleHint(boolean r4) {
        FragmentStrictMode.onSetUserVisibleHint(this, r4);
        if (this.mUserVisibleHint == true) goto L14;
        if (r4 == false) goto L14;
        if (this.mState >= 5) goto L14;
        if (this.mFragmentManager == null) goto L14;
        if (isAdded() == false) goto L14;
        if (this.mIsCreated == false) goto L14;
        FragmentManager r0 = this.mFragmentManager;
        r0.performPendingDeferredStart(r0.createOrGetFragmentStateManager(this));
    L14:
        this.mUserVisibleHint = r4;
        if (this.mState >= 5) goto L18;
        if (r4 == true) goto L18;
        boolean r1 = true;
    L19:
        this.mDeferStart = r1;
        if (this.mSavedFragmentState == null) goto L23;
        this.mSavedUserVisibleHint = Boolean.valueOf(r4);
        return;
    L23:
        return;
    L18:
        r1 = false;
        goto L19
    }

    public boolean shouldShowRequestPermissionRationale(String r2) {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.onShouldShowRequestPermissionRationale(r2);
    }

    public void startActivity(Intent r2) {
        startActivity(r2, null);
    }

    public void unregisterForContextMenu(View r2) {
        r2.setOnCreateContextMenuListener(null);
    }

    public void onAttach(Activity r1) {
        this.mCalled = true;
    }

    public static Fragment instantiate(Context r1, String r2) {
        return instantiate(r1, r2, null);
    }

    public final String getString(int r2, Object... r3) {
        return getResources().getString(r2, r3);
    }

    public boolean performCreateOptionsMenu(Menu r3, MenuInflater r4) {
        boolean r1 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        onCreateOptionsMenu(r3, r4);
        r1 = true;
    L10:
        return r1 | this.mChildFragmentManager.dispatchCreateOptionsMenu(r3, r4);
    }

    public final void postponeEnterTransition(long r3, TimeUnit r5) {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 == null) goto L5;
        Handler r1 = r0.getHost().getHandler();
    L6:
        r1.removeCallbacks(this.mPostponedDurationRunnable);
        r1.postDelayed(this.mPostponedDurationRunnable, r5.toMillis(r3));
        return;
    L5:
        r1 = new Handler(Looper.getMainLooper());
        goto L6
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r2, ActivityResultCallback<O> r3) {
        return prepareCallInternal(r2, new 6(this), r3);
    }

    public final void requestPermissions(String[] r2, int r3) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchRequestPermissions(this, r2, r3);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void setSharedElementNames(ArrayList<String> r2, ArrayList<String> r3) {
        ensureAnimationInfo();
        AnimationInfo r0 = this.mAnimationInfo;
        r0.mSharedElementSourceNames = r2;
        r0.mSharedElementTargetNames = r3;
    }

    public void setTargetFragment(Fragment r4, int r5) {
        if (r4 == null) goto L4;
        FragmentStrictMode.onSetTargetFragmentUsage(this, r4, r5);
    L4:
        FragmentManager r0 = this.mFragmentManager;
        if (r4 == null) goto L7;
        FragmentManager r2 = r4.mFragmentManager;
    L8:
        if (r0 == null) goto L14;
        if (r2 == null) goto L14;
        if (r0 == r2) goto L14;
        throw new IllegalArgumentException("Fragment " + r4 + " must share the same FragmentManager to be set as a target fragment");
    L14:
        Fragment r1 = r4;
    L15:
        if (r1 == null) goto L21;
        if (r1.equals(this) == true) goto L20;
        r1 = r1.getTargetFragment(false);
        goto L15
    L20:
        throw new IllegalArgumentException("Setting " + r4 + " as the target of " + this + " would create a target cycle");
    L21:
        if (r4 != null) goto L24;
        this.mTargetWho = null;
        this.mTarget = null;
    L29:
        this.mTargetRequestCode = r5;
        return;
    L24:
        if (this.mFragmentManager != null) goto L26;
    L28:
        this.mTargetWho = null;
        this.mTarget = r4;
        goto L29
    L26:
        if (r4.mFragmentManager == null) goto L28;
        this.mTargetWho = r4.mWho;
        this.mTarget = null;
        goto L29
    L7:
        r2 = null;
        goto L8
    }

    public void startActivity(Intent r3, Bundle r4) {
        FragmentHostCallback<?> r0 = this.mHost;
        if (r0 == null) goto L7;
        r0.onStartActivityFromFragment(this, r3, -1, r4);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startActivityForResult(Intent r2, int r3) {
        startActivityForResult(r2, r3, null);
    }

    public static Fragment instantiate(Context r4, String r5, Bundle r6) {
        Fragment r7 = (Fragment) FragmentFactory.loadFragmentClass(r4.getClassLoader(), r5).getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 InstantiationException -> L16
        if (r6 == null) goto L6;
        r6.setClassLoader(r7.getClass().getClassLoader());     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 InstantiationException -> L16
        r7.setArguments(r6);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 InstantiationException -> L16
    L6:
        return r7;
    L13:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r5 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L16:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r5 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L10:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r5 + ": could not find Fragment constructor", e);
    L7:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r5 + ": calling Fragment constructor caused an exception", e);
    }

    private <I, O> ActivityResultLauncher<I> prepareCallInternal(ActivityResultContract<I, O> r9, Function<Void, ActivityResultRegistry> r10, ActivityResultCallback<O> r11) {
        if (this.mState > 1) goto L7;
        AtomicReference r0 = new AtomicReference();
        registerOnPreAttachListener(new 8(this, r10, r0, r9, r11));
        return new 9(this, r0, r9);
    L7:
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    public void onActivityResult(int r1, int r2, Intent r3) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        toString();
        Objects.toString(r3);
        return;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu r2, View r3, ContextMenu.ContextMenuInfo r4) {
        requireActivity().onCreateContextMenu(r2, r3, r4);
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        int r5 = this.mContentLayoutId;
        if (r5 != 0) goto L5;
        return null;
    L5:
        return r2.inflate(r5, r3, false);
    }

    public void onInflate(Context r2, AttributeSet r3, Bundle r4) {
        this.mCalled = true;
        FragmentHostCallback<?> r5 = this.mHost;
        if (r5 != null) goto L5;
        Activity r6 = null;
    L6:
        if (r6 == null) goto L9;
        this.mCalled = false;
        onInflate(r6, r3, r4);
        return;
    L9:
        return;
    L5:
        r6 = r5.getActivity();
        goto L6
    }

    public void performCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, getViewModelStore());
        View r6 = onCreateView(r3, r4, r5);
        this.mView = r6;
        if (r6 == null) goto L6;
        this.mViewLifecycleOwner.initialize();
        ViewTreeLifecycleOwner.set(this.mView, this.mViewLifecycleOwner);
        ViewTreeViewModelStoreOwner.set(this.mView, this.mViewLifecycleOwner);
        ViewTreeSavedStateRegistryOwner.set(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
        return;
    L6:
        if (this.mViewLifecycleOwner.isInitialized() == true) goto L10;
        this.mViewLifecycleOwner = null;
        return;
    L10:
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r2, ActivityResultRegistry r3, ActivityResultCallback<O> r4) {
        return prepareCallInternal(r2, new 7(this, r3), r4);
    }

    public void startActivityForResult(Intent r2, int r3, Bundle r4) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchStartActivityForResult(this, r2, r3, r4);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void onInflate(Activity r1, AttributeSet r2, Bundle r3) {
        this.mCalled = true;
    }

    public void dump(String r3, FileDescriptor r4, PrintWriter r5, String[] r6) {
        r5.print(r3);
        r5.print("mFragmentId=#");
        r5.print(Integer.toHexString(this.mFragmentId));
        r5.print(" mContainerId=#");
        r5.print(Integer.toHexString(this.mContainerId));
        r5.print(" mTag=");
        r5.println(this.mTag);
        r5.print(r3);
        r5.print("mState=");
        r5.print(this.mState);
        r5.print(" mWho=");
        r5.print(this.mWho);
        r5.print(" mBackStackNesting=");
        r5.println(this.mBackStackNesting);
        r5.print(r3);
        r5.print("mAdded=");
        r5.print(this.mAdded);
        r5.print(" mRemoving=");
        r5.print(this.mRemoving);
        r5.print(" mFromLayout=");
        r5.print(this.mFromLayout);
        r5.print(" mInLayout=");
        r5.println(this.mInLayout);
        r5.print(r3);
        r5.print("mHidden=");
        r5.print(this.mHidden);
        r5.print(" mDetached=");
        r5.print(this.mDetached);
        r5.print(" mMenuVisible=");
        r5.print(this.mMenuVisible);
        r5.print(" mHasMenu=");
        r5.println(this.mHasMenu);
        r5.print(r3);
        r5.print("mRetainInstance=");
        r5.print(this.mRetainInstance);
        r5.print(" mUserVisibleHint=");
        r5.println(this.mUserVisibleHint);
        if (this.mFragmentManager == null) goto L6;
        r5.print(r3);
        r5.print("mFragmentManager=");
        r5.println(this.mFragmentManager);
    L6:
        if (this.mHost == null) goto L9;
        r5.print(r3);
        r5.print("mHost=");
        r5.println(this.mHost);
    L9:
        if (this.mParentFragment == null) goto L12;
        r5.print(r3);
        r5.print("mParentFragment=");
        r5.println(this.mParentFragment);
    L12:
        if (this.mArguments == null) goto L15;
        r5.print(r3);
        r5.print("mArguments=");
        r5.println(this.mArguments);
    L15:
        if (this.mSavedFragmentState == null) goto L18;
        r5.print(r3);
        r5.print("mSavedFragmentState=");
        r5.println(this.mSavedFragmentState);
    L18:
        if (this.mSavedViewState == null) goto L21;
        r5.print(r3);
        r5.print("mSavedViewState=");
        r5.println(this.mSavedViewState);
    L21:
        if (this.mSavedViewRegistryState == null) goto L23;
        r5.print(r3);
        r5.print("mSavedViewRegistryState=");
        r5.println(this.mSavedViewRegistryState);
    L23:
        Fragment r0 = getTargetFragment(false);
        if (r0 == null) goto L26;
        r5.print(r3);
        r5.print("mTarget=");
        r5.print(r0);
        r5.print(" mTargetRequestCode=");
        r5.println(this.mTargetRequestCode);
    L26:
        r5.print(r3);
        r5.print("mPopDirection=");
        r5.println(getPopDirection());
        if (getEnterAnim() == 0) goto L30;
        r5.print(r3);
        r5.print("getEnterAnim=");
        r5.println(getEnterAnim());
    L30:
        if (getExitAnim() == 0) goto L33;
        r5.print(r3);
        r5.print("getExitAnim=");
        r5.println(getExitAnim());
    L33:
        if (getPopEnterAnim() == 0) goto L36;
        r5.print(r3);
        r5.print("getPopEnterAnim=");
        r5.println(getPopEnterAnim());
    L36:
        if (getPopExitAnim() == 0) goto L39;
        r5.print(r3);
        r5.print("getPopExitAnim=");
        r5.println(getPopExitAnim());
    L39:
        if (this.mContainer == null) goto L42;
        r5.print(r3);
        r5.print("mContainer=");
        r5.println(this.mContainer);
    L42:
        if (this.mView == null) goto L45;
        r5.print(r3);
        r5.print("mView=");
        r5.println(this.mView);
    L45:
        if (getAnimatingAway() == null) goto L48;
        r5.print(r3);
        r5.print("mAnimatingAway=");
        r5.println(getAnimatingAway());
    L48:
        if (getContext() == null) goto L50;
        LoaderManager.getInstance(this).dump(r3, r4, r5, r6);
    L50:
        r5.print(r3);
        r5.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.dump(r3 + "  ", r4, r5, r6);
    }

    public void setAnimations(int r2, int r3, int r4, int r5) {
        if (this.mAnimationInfo != null) goto L9;
        if (r2 != 0) goto L9;
        if (r3 != 0) goto L9;
        if (r4 != 0) goto L9;
        if (r5 != 0) goto L9;
        return;
    L9:
        ensureAnimationInfo().mEnterAnim = r2;
        ensureAnimationInfo().mExitAnim = r3;
        ensureAnimationInfo().mPopEnterAnim = r4;
        ensureAnimationInfo().mPopExitAnim = r5;
    }

    public void startIntentSenderForResult(IntentSender r11, int r12, Intent r13, int r14, int r15, int r16, Bundle r17) throws IntentSender.SendIntentException {
        if (this.mHost == null) goto L10;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L7;
        toString();
        Objects.toString(r11);
        Objects.toString(r13);
        Objects.toString(r17);
    L7:
        getParentFragmentManager().launchStartIntentSenderForResult(this, r11, r12, r13, r14, r15, r16, r17);
        return;
    L10:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
}
