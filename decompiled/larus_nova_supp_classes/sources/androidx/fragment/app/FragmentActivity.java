package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityCompat$OnRequestPermissionsResultCallback;
import androidx.core.app.ActivityCompat$RequestPermissionsRequestCodeValidator;
import androidx.core.app.SharedElementCallback;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.loader.app.LoaderManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import dc9.d;
import f06.b;
import g06.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class FragmentActivity extends ComponentActivity implements ActivityCompat$OnRequestPermissionsResultCallback, ActivityCompat$RequestPermissionsRequestCodeValidator {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry;
    final FragmentController mFragments;
    boolean mResumed;
    boolean mStopped;

    public static /* synthetic */ void access$000(ComponentActivity r0, Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    public static /* synthetic */ void w1(FragmentActivity r0, Context r1) {
        r0.lambda$init$1(r1);
    }

    public static /* synthetic */ Bundle x1(FragmentActivity r0) {
        return r0.lambda$init$0();
    }

    public void androidx_fragment_app_FragmentActivity__finish$___twin___() {
        super.finish();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        androidx_fragment_app_FragmentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onAttachFragment(Fragment r1) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        androidx_fragment_app_FragmentActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    @Override // androidx.core.app.ActivityCompat$RequestPermissionsRequestCodeValidator
    public final void validateRequestPermissionsRequestCode(int r1) {
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.noteStateNotSaved();
        super.onResume();
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.mFragments.dispatchResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.noteStateNotSaved();
        super.onStart();
        this.mStopped = false;
        if (this.mCreated == true) goto L5;
        this.mCreated = true;
        this.mFragments.dispatchActivityCreated();
    L5:
        this.mFragments.execPendingActions();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.mFragments.dispatchStart();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    public FragmentActivity() {
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().registerSavedStateProvider(LIFECYCLE_TAG, new a(this));
        addOnContextAvailableListener(new b(this));
    }

    private /* synthetic */ Bundle lambda$init$0() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    public void markFragmentsCreated() {
    L3:
        if (markState(getSupportFragmentManager(), Lifecycle.State.CREATED) == true) goto L3;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.dispatchDestroy();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.dispatchLowMemory();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.dispatchPause();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.dispatchStop();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    public FragmentActivity(int r1) {
        super(r1);
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    public static void androidx_fragment_app_FragmentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(FragmentActivity r11) {
        r11.androidx_fragment_app_FragmentActivity__finish$___twin___();
        if ((r11 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(r11.getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(r11);     // Catch: Throwable -> L50
        if (r6 != null) goto L10;
    L13:
        r5.put(r11, Long.valueOf(r3));     // Catch: Throwable -> L50
        monitor-exit(r5);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r11.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r2.i("ActivityLancet", "quit !resume, current state = " + r11.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r11.isFinishing() == true) goto L24;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L32;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L36;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L47
        if (r1 != null) goto L41;
        return;
    L41:
        r1.addFlags(268435456);     // Catch: Throwable -> L47
        r1.addFlags(2097152);     // Catch: Throwable -> L47
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L47
        r11.startActivity(r1);     // Catch: Throwable -> L44
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$init$1(Context r2) {
        this.mFragments.attachHost(null);
    }

    public void androidx_fragment_app_FragmentActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.mFragments.dispatchCreate();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r2) {
        this.mFragments.noteStateNotSaved();
        INVOKESPECIAL_androidx_fragment_app_FragmentActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r2);
        this.mFragments.dispatchConfigurationChanged(r2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean r2) {
        this.mFragments.dispatchMultiWindowModeChanged(r2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent r2) {
        this.mFragments.noteStateNotSaved();
        super.onNewIntent(r2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean r2) {
        this.mFragments.dispatchPictureInPictureModeChanged(r2);
    }

    public void setEnterSharedElementCallback(SharedElementCallback r1) {
        ActivityCompat.setEnterSharedElementCallback(this, r1);
    }

    public void setExitSharedElementCallback(SharedElementCallback r1) {
        ActivityCompat.setExitSharedElementCallback(this, r1);
    }

    public static void INVOKESPECIAL_androidx_fragment_app_FragmentActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(ComponentActivity r3, Configuration r4) {
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

    public static void androidx_fragment_app_FragmentActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(FragmentActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.androidx_fragment_app_FragmentActivity__onCreate$___twin___(r2);
    }

    private static boolean markState(FragmentManager r5, Lifecycle.State r6) {
        Iterator r7 = r5.getFragments().iterator();
        boolean r0 = false;
    L4:
        if (r7.hasNext() == false) goto L19;
        Fragment r1 = (Fragment) r7.next();
        if (r1 == null) goto L4;
        if (r1.getHost() == null) goto L11;
        r0 = r0 | markState(r1.getChildFragmentManager(), r6);
    L11:
        FragmentViewLifecycleOwner r2 = r1.mViewLifecycleOwner;
        if (r2 == null) goto L17;
        if (r2.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L17;
        r1.mViewLifecycleOwner.setCurrentState(r6);
        r0 = true;
    L17:
        if (r1.mLifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L4;
        r1.mLifecycleRegistry.setCurrentState(r6);
        r0 = true;
        goto L4
    L19:
        return r0;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r3, Menu r4) {
        if (r3 != 0) goto L6;
        return super.onCreatePanelMenu(r3, r4) | this.mFragments.dispatchCreateOptionsMenu(r4, getMenuInflater());
    L6:
        return super.onCreatePanelMenu(r3, r4);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r2, MenuItem r3) {
        if (super.onMenuItemSelected(r2, r3) == false) goto L6;
        return true;
    L6:
        if (r2 == 0) goto L14;
        if (r2 == 6) goto L12;
        return false;
    L12:
        return this.mFragments.dispatchContextItemSelected(r3);
    L14:
        return this.mFragments.dispatchOptionsItemSelected(r3);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r2, Menu r3) {
        if (r2 != 0) goto L4;
        this.mFragments.dispatchOptionsMenuClosed(r3);
    L4:
        super.onPanelClosed(r2, r3);
    }

    public boolean onPrepareOptionsPanel(View r2, Menu r3) {
        return super.onPreparePanel(0, r2, r3);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r2, int r3, Intent r4) {
        this.mFragments.noteStateNotSaved();
        super.onActivityResult(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String r2, Context r3, AttributeSet r4) {
        View r0 = dispatchFragmentsOnCreateView(null, r2, r3, r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.onCreateView(r2, r3, r4);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r1, View r2, Menu r3) {
        if (r1 != 0) goto L6;
        return onPrepareOptionsPanel(r2, r3) | this.mFragments.dispatchPrepareOptionsMenu(r3);
    L6:
        return super.onPreparePanel(r1, r2, r3);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        this.mFragments.noteStateNotSaved();
        androidx_fragment_app_FragmentActivity_androidx_activity_ComponentActivity_onRequestPermissionsResult_super(this, r2, r3, r4);
    }

    public void startActivityFromFragment(Fragment r2, Intent r3, int r4) {
        startActivityFromFragment(r2, r3, r4, null);
    }

    private static void androidx_fragment_app_FragmentActivity_androidx_activity_ComponentActivity_onRequestPermissionsResult_super(ComponentActivity r18, int r19, String[] r20, int[] r21) {
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
        f06.d r4 = r7.preInvoke(102611, "androidx/activity/ComponentActivity", "onRequestPermissionsResult", r18, r1, "void", r11);     // Catch: Exception -> L21
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

    public final View dispatchFragmentsOnCreateView(View r2, String r3, Context r4, AttributeSet r5) {
        return this.mFragments.onCreateView(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void dump(String r3, FileDescriptor r4, PrintWriter r5, String[] r6) {
        super.dump(r3, r4, r5, r6);
        r5.print(r3);
        r5.print("Local FragmentActivity ");
        r5.print(Integer.toHexString(System.identityHashCode(this)));
        r5.println(" State:");
        String r0 = r3 + "  ";
        r5.print(r0);
        r5.print("mCreated=");
        r5.print(this.mCreated);
        r5.print(" mResumed=");
        r5.print(this.mResumed);
        r5.print(" mStopped=");
        r5.print(this.mStopped);
        if (getApplication() == null) goto L5;
        LoaderManager.getInstance(this).dump(r0, r4, r5, r6);
    L5:
        this.mFragments.getSupportFragmentManager().dump(r3, r4, r5, r6);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View r2, String r3, Context r4, AttributeSet r5) {
        View r0 = dispatchFragmentsOnCreateView(r2, r3, r4, r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.onCreateView(r2, r3, r4, r5);
    }

    public void startActivityFromFragment(Fragment r2, Intent r3, int r4, Bundle r5) {
        if (r4 != (-1)) goto L6;
        ActivityCompat.startActivityForResult(this, r3, -1, r5);
        return;
    L6:
        r2.startActivityForResult(r3, r4, r5);
    }

    public void startIntentSenderFromFragment(Fragment r10, IntentSender r11, int r12, Intent r13, int r14, int r15, int r16, Bundle r17) throws IntentSender.SendIntentException {
        if (r12 != (-1)) goto L6;
        ActivityCompat.startIntentSenderForResult(this, r11, r12, r13, r14, r15, r16, r17);
        return;
    L6:
        r10.startIntentSenderForResult(r11, r12, r13, r14, r15, r16, r17);
    }
}
