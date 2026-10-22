package androidx.activity;

import android.R;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dc9.d;
import f06.b;
import g06.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, MenuHost, FullyDrawnReporterOwner {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final ContextAwareHelper mContextAwareHelper;
    private ViewModelProvider.Factory mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final FullyDrawnReporter mFullyDrawnReporter;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    final ReportFullyDrawnExecutor mReportFullyDrawnExecutor;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    public static /* synthetic */ void access$000(androidx.core.app.ComponentActivity r0, Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    public static /* synthetic */ Bundle t1(ComponentActivity r0) {
        return r0.lambda$new$1();
    }

    public static /* synthetic */ void u1(ComponentActivity r0, Context r1) {
        r0.lambda$new$2(r1);
    }

    public static /* synthetic */ Unit v1(ComponentActivity r0) {
        return r0.lambda$new$0();
    }

    public void androidx_activity_ComponentActivity__finish$___twin___() {
        super.finish();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        androidx_activity_ComponentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        androidx_activity_ComponentActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    private ReportFullyDrawnExecutor createFullyDrawnExecutor() {
        return new ReportFullyDrawnExecutorApi16Impl(this);
    }

    private /* synthetic */ Bundle lambda$new$1() {
        Bundle r0 = new Bundle();
        this.mActivityResultRegistry.onSaveInstanceState(r0);
        return r0;
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore != null) goto L11;
        NonConfigurationInstances r0 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r0 == null) goto L8;
        this.mViewModelStore = r0.viewModelStore;
    L8:
        if (this.mViewModelStore != null) goto L12;
        this.mViewModelStore = new ViewModelStore();
        return;
    L12:
        return;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras r0 = new MutableCreationExtras();
        if (getApplication() == null) goto L5;
        r0.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, getApplication());
    L5:
        r0.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        r0.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getIntent() != null) goto L8;
    L10:
        return r0;
    L8:
        if (getIntent().getExtras() == null) goto L10;
        r0.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getIntent().getExtras());
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory != null) goto L10;
        Application r1 = getApplication();
        if (getIntent() == null) goto L7;
        Bundle r2 = getIntent().getExtras();
    L8:
        this.mDefaultFactory = new SavedStateViewModelFactory(r1, this, r2);
        goto L10
    L7:
        r2 = null;
    L10:
        return this.mDefaultFactory;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher != null) goto L6;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new 5(this));
        getLifecycle().addObserver(new 6(this));
    L6:
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Override // androidx.activity.contextaware.ContextAware
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.peekAvailableContext();
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(new a(this));
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController r0 = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = r0;
        this.mOnBackPressedDispatcher = null;
        ReportFullyDrawnExecutor r1 = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = r1;
        this.mFullyDrawnReporter = new FullyDrawnReporter(r1, new b(this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new 1(this);
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) goto L10;
        int r2 = Build.VERSION.SDK_INT;
        getLifecycle().addObserver(new 2(this));
        getLifecycle().addObserver(new 3(this));
        getLifecycle().addObserver(new 4(this));
        r0.performAttach();
        SavedStateHandleSupport.enableSavedStateHandles(this);
        if (r2 > 23) goto L7;
        getLifecycle().addObserver(new ImmLeaksCleaner(this));
    L7:
        getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new c(this));
        addOnContextAvailableListener(new d(this));
        return;
    L10:
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private /* synthetic */ Unit lambda$new$0() {
        reportFullyDrawn();
        return null;
    }

    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances r0 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.custom;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) goto L7;
        ensureViewModelStore();
        return this.mViewModelStore;
    L7:
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void initializeViewTreeOwners() {
        ViewTreeLifecycleOwner.set(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
        ViewTreeViewModelStoreOwner.set(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
        ViewTreeSavedStateRegistryOwner.set(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
        ViewTreeOnBackPressedDispatcherOwner.set(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
        ViewTreeFullyDrawnReporterOwner.set(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        Object r0 = onRetainCustomNonConfigurationInstance();
        ViewModelStore r1 = this.mViewModelStore;
        if (r1 != null) goto L7;
        NonConfigurationInstances r2 = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (r2 == null) goto L7;
        r1 = r2.viewModelStore;
    L7:
        if (r1 != null) goto L11;
        if (r0 != null) goto L11;
        return null;
    L11:
        NonConfigurationInstances r3 = new NonConfigurationInstances();
        r3.custom = r0;
        r3.viewModelStore = r1;
        return r3;
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
    L8:
        th = move-exception;
        Trace.endSection();
        throw th;
    L3:
        if (Trace.isEnabled() == false) goto L5;
        Trace.beginSection("reportFullyDrawn() for ComponentActivity");     // Catch: Throwable -> L8
    L5:
        super.reportFullyDrawn();     // Catch: Throwable -> L8
        this.mFullyDrawnReporter.fullyDrawnReported();     // Catch: Throwable -> L8
        Trace.endSection();
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.activity.FullyDrawnReporterOwner
    public FullyDrawnReporter getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    public ComponentActivity(int r1) {
        this();
        this.mContentLayoutId = r1;
    }

    public static View INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static /* synthetic */ void access$001(ComponentActivity r0) {
        super.onBackPressed();
    }

    public static /* synthetic */ OnBackPressedDispatcher access$100(ComponentActivity r0) {
        return r0.mOnBackPressedDispatcher;
    }

    public static void androidx_activity_ComponentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(ComponentActivity r11) {
        r11.androidx_activity_ComponentActivity__finish$___twin___();
        if ((r11 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((r11 instanceof ChatWindowActivity) == false) goto L8;
        return;
    L8:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(r11.getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(r11);     // Catch: Throwable -> L53
        if (r6 != null) goto L13;
    L16:
        r5.put(r11, Long.valueOf(r3));     // Catch: Throwable -> L53
        monitor-exit(r5);     // Catch: Throwable -> L53
    L50:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L19:
        if (((FragmentActivity) r11).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r2.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) r11).getLifecycle().getCurrentState());     // Catch: Throwable -> L50
        return;
    L23:
        if (r11.isFinishing() == true) goto L27;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L50
        return;
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L31;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L50
        return;
    L31:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L35;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L50
        return;
    L35:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L39;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L50
        return;
    L39:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L41;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L50
        return;
    L41:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L50
        if (r1 != null) goto L44;
        return;
    L44:
        r1.addFlags(268435456);     // Catch: Throwable -> L50
        r1.addFlags(2097152);     // Catch: Throwable -> L50
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L50
        r11.startActivity(r1);     // Catch: Throwable -> L47
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L47
    L61:
        return;
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L50
        return;
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$2(Context r2) {
        Bundle r3 = getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (r3 == null) goto L6;
        this.mActivityResultRegistry.onRestoreInstanceState(r3);
        return;
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider r2) {
        this.mMenuHostHelper.addMenuProvider(r2);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(Consumer<Configuration> r2) {
        this.mOnConfigurationChangedListeners.add(r2);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void addOnContextAvailableListener(OnContextAvailableListener r2) {
        this.mContextAwareHelper.addOnContextAvailableListener(r2);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> r2) {
        this.mOnMultiWindowModeChangedListeners.add(r2);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void addOnNewIntentListener(Consumer<Intent> r2) {
        this.mOnNewIntentListeners.add(r2);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> r2) {
        this.mOnPictureInPictureModeChangedListeners.add(r2);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(Consumer<Integer> r2) {
        this.mOnTrimMemoryListeners.add(r2);
    }

    public void androidx_activity_ComponentActivity__onCreate$___twin___(Bundle r2) {
        this.mSavedStateRegistryController.performRestore(r2);
        this.mContextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(r2);
        ReportFragment.injectIfNeededIn(this);
        int r3 = this.mContentLayoutId;
        if (r3 == 0) goto L6;
        setContentView(r3);
        return;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r3) {
        INVOKESPECIAL_androidx_activity_ComponentActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r3);
        Iterator<Consumer<Configuration>> r0 = this.mOnConfigurationChangedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().accept(r3);
        goto L4
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean r4) {
        if (this.mDispatchingOnMultiWindowModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<MultiWindowModeChangedInfo>> r0 = this.mOnMultiWindowModeChangedListeners.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().accept(new MultiWindowModeChangedInfo(r4));
        goto L7
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent r3) {
        super.onNewIntent(r3);
        Iterator<Consumer<Intent>> r0 = this.mOnNewIntentListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().accept(r3);
        goto L4
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean r4) {
        if (this.mDispatchingOnPictureInPictureModeChanged == false) goto L5;
        return;
    L5:
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r0 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().accept(new PictureInPictureModeChangedInfo(r4));
        goto L7
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle r3) {
        LifecycleRegistry r0 = getLifecycle();
        if ((r0 instanceof LifecycleRegistry) == false) goto L5;
        r0.setCurrentState(Lifecycle.State.CREATED);
    L5:
        super.onSaveInstanceState(r3);
        this.mSavedStateRegistryController.performSave(r3);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int r4) {
        super.onTrimMemory(r4);
        Iterator<Consumer<Integer>> r0 = this.mOnTrimMemoryListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().accept(Integer.valueOf(r4));
        goto L4
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(MenuProvider r2) {
        this.mMenuHostHelper.removeMenuProvider(r2);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(Consumer<Configuration> r2) {
        this.mOnConfigurationChangedListeners.remove(r2);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void removeOnContextAvailableListener(OnContextAvailableListener r2) {
        this.mContextAwareHelper.removeOnContextAvailableListener(r2);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> r2) {
        this.mOnMultiWindowModeChangedListeners.remove(r2);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void removeOnNewIntentListener(Consumer<Intent> r2) {
        this.mOnNewIntentListeners.remove(r2);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> r2) {
        this.mOnPictureInPictureModeChangedListeners.remove(r2);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(Consumer<Integer> r2) {
        this.mOnTrimMemoryListeners.remove(r2);
    }

    @Override // android.app.Activity
    public void setContentView(int r3) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()));
        super.setContentView(r3);
    }

    @Override // android.app.Activity
    public void setContentView(View r3) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()));
        super.setContentView(r3);
    }

    public static void INVOKESPECIAL_androidx_activity_ComponentActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(androidx.core.app.ComponentActivity r3, Configuration r4) {
        access$000(r3, r4);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (d.a() == true) goto L22;
        int r2 = r3.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r4 == null) goto L8;
        Integer r5 = Integer.valueOf(r4.orientation);     // Catch: Throwable -> L17
    L9:
        if (r5 != null) goto L12;
    L14:
        if (r2 != 3) goto L24;
        r3.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + r3.getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r5.intValue() != r2) goto L14;
        return;
    L8:
        r5 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    public static void androidx_activity_ComponentActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(ComponentActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.androidx_activity_ComponentActivity__onCreate$___twin___(r2);
    }

    @Override // android.app.Activity
    public void addContentView(View r3, ViewGroup.LayoutParams r4) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()));
        super.addContentView(r3, r4);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider r2, LifecycleOwner r3) {
        this.mMenuHostHelper.addMenuProvider(r2, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r2, Menu r3) {
        if (r2 != 0) goto L6;
        super.onCreatePanelMenu(r2, r3);
        this.mMenuHostHelper.onCreateMenu(r3, getMenuInflater());
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r2, MenuItem r3) {
        if (super.onMenuItemSelected(r2, r3) == false) goto L6;
        return true;
    L6:
        if (r2 == 0) goto L8;
        return false;
    L8:
        return this.mMenuHostHelper.onMenuItemSelected(r3);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean r4, Configuration r5) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        super.onMultiWindowModeChanged(r4, r5);     // Catch: Throwable -> L9
        this.mDispatchingOnMultiWindowModeChanged = false;
        Iterator<Consumer<MultiWindowModeChangedInfo>> r0 = this.mOnMultiWindowModeChangedListeners.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().accept(new MultiWindowModeChangedInfo(r4, r5));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnMultiWindowModeChanged = false;
        throw th;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r2, Menu r3) {
        this.mMenuHostHelper.onMenuClosed(r3);
        super.onPanelClosed(r2, r3);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean r4, Configuration r5) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        super.onPictureInPictureModeChanged(r4, r5);     // Catch: Throwable -> L9
        this.mDispatchingOnPictureInPictureModeChanged = false;
        Iterator<Consumer<PictureInPictureModeChangedInfo>> r0 = this.mOnPictureInPictureModeChangedListeners.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().accept(new PictureInPictureModeChangedInfo(r4, r5));
        goto L6
    L8:
        return;
    L9:
        th = move-exception;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        throw th;
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r2, ActivityResultCallback<O> r3) {
        return registerForActivityResult(r2, this.mActivityResultRegistry, r3);
    }

    @Override // android.app.Activity
    public void setContentView(View r3, ViewGroup.LayoutParams r4) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(INVOKEVIRTUAL_androidx_activity_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()));
        super.setContentView(r3, r4);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent r1, int r2) {
        super.startActivityForResult(r1, r2);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider r2, LifecycleOwner r3, Lifecycle.State r4) {
        this.mMenuHostHelper.addMenuProvider(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void onActivityResult(int r2, int r3, Intent r4) {
        if (this.mActivityResultRegistry.dispatchResult(r2, r3, r4) == true) goto L6;
        super.onActivityResult(r2, r3, r4);
        return;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r1, View r2, Menu r3) {
        if (r1 != 0) goto L6;
        super.onPreparePanel(r1, r2, r3);
        this.mMenuHostHelper.onPrepareMenu(r3);
        return true;
    L6:
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int r4, String[] r5, int[] r6) {
        if (this.mActivityResultRegistry.dispatchResult(r4, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", r5).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", r6)) == false) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        androidx_activity_ComponentActivity_androidx_core_app_ComponentActivity_onRequestPermissionsResult_super(this, r4, r5, r6);
        return;
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r3, ActivityResultRegistry r4, ActivityResultCallback<O> r5) {
        return r4.register("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, r3, r5);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    private static void androidx_activity_ComponentActivity_androidx_core_app_ComponentActivity_onRequestPermissionsResult_super(androidx.core.app.ComponentActivity r18, int r19, String[] r20, int[] r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19), r20, r21};
        b r11 = new b();
        a r2 = (a) ApiHookConfig.b.get(102611);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102611, "androidx/core/app/ComponentActivity", "onRequestPermissionsResult", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        super.onRequestPermissionsResult(r19, r20, r21);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender r1, int r2, Intent r3, int r4, int r5, int r6) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(r1, r2, r3, r4, r5, r6);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender r1, int r2, Intent r3, int r4, int r5, int r6, Bundle r7) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(r1, r2, r3, r4, r5, r6, r7);
    }
}
