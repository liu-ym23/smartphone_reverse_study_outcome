package com.volcengine.zeus.activity;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.SharedElementCallback;
import android.app.TaskStackBuilder;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.volcengine.zeus.plugin.Plugin;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import mqc.a;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class GeneratePluginActivity extends Activity implements IPluginActivity {
    public Plugin mPlugin;
    public GenerateProxyActivity mProxyActivity;

    @Override // android.app.Activity
    public void finish() {
        com_volcengine_zeus_activity_GeneratePluginActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // android.app.Activity, com.volcengine.zeus.activity.IPluginActivity
    public void onCreate(Bundle r1) {
        com_volcengine_zeus_activity_GeneratePluginActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    @Override // android.app.Activity
    public void onStop() {
        com_volcengine_zeus_activity_GeneratePluginActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        this.mProxyActivity.zeusSuperCloseContextMenu();
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        this.mProxyActivity.zeusSuperCloseOptionsMenu();
    }

    public void com_volcengine_zeus_activity_GeneratePluginActivity__finish$___twin___() {
        this.mProxyActivity.zeusSuperFinish();
    }

    public void com_volcengine_zeus_activity_GeneratePluginActivity__onStop$___twin___() {
        this.mProxyActivity.zeusSuperOnStop();
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        this.mProxyActivity.zeusSuperEnterPictureInPictureMode();
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        this.mProxyActivity.zeusSuperFinishAffinity();
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        this.mProxyActivity.zeusSuperFinishAfterTransition();
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        this.mProxyActivity.zeusSuperFinishAndRemoveTask();
    }

    @Override // android.app.Activity
    public ActionBar getActionBar() {
        return this.mProxyActivity.zeusSuperGetActionBar();
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        return this.mProxyActivity.zeusSuperGetCallingActivity();
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        return this.mProxyActivity.zeusSuperGetCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        return this.mProxyActivity.zeusSuperGetChangingConfigurations();
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        return this.mProxyActivity.zeusSuperGetComponentName();
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        return this.mProxyActivity.zeusSuperGetContentScene();
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        return this.mProxyActivity.zeusSuperGetContentTransitionManager();
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        return this.mProxyActivity.zeusSuperGetCurrentFocus();
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        return this.mProxyActivity.zeusSuperGetFragmentManager();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        return this.mProxyActivity.zeusSuperGetIntent();
    }

    @Override // android.app.Activity
    public Object getLastNonConfigurationInstance() {
        return this.mProxyActivity.zeusSuperGetLastNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        return this.mProxyActivity.zeusSuperGetLayoutInflater();
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        return this.mProxyActivity.zeusSuperGetLoaderManager();
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        return this.mProxyActivity.zeusSuperGetLocalClassName();
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        return this.mProxyActivity.zeusSuperGetMaxNumPictureInPictureActions();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.mProxyActivity.zeusSuperGetMenuInflater();
    }

    @Override // android.app.Activity
    public Intent getParentActivityIntent() {
        return this.mProxyActivity.zeusSuperGetParentActivityIntent();
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        return this.mProxyActivity.zeusSuperGetReferrer();
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        return this.mProxyActivity.zeusSuperGetRequestedOrientation();
    }

    @Override // android.app.Activity
    public int getTaskId() {
        return this.mProxyActivity.zeusSuperGetTaskId();
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        return this.mProxyActivity.zeusSuperGetVoiceInteractor();
    }

    @Override // android.app.Activity
    public Window getWindow() {
        return this.mProxyActivity.zeusSuperGetWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        return this.mProxyActivity.zeusSuperGetWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        return this.mProxyActivity.zeusSuperHasWindowFocus();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        this.mProxyActivity.zeusSuperInvalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        return this.mProxyActivity.zeusSuperIsActivityTransitionRunning();
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        return this.mProxyActivity.zeusSuperIsChangingConfigurations();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        return this.mProxyActivity.zeusSuperIsDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        return this.mProxyActivity.zeusSuperIsFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return this.mProxyActivity.zeusSuperIsImmersive();
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        return this.mProxyActivity.zeusSuperIsInMultiWindowMode();
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        return this.mProxyActivity.zeusSuperIsInPictureInPictureMode();
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        return this.mProxyActivity.zeusSuperIsLocalVoiceInteractionSupported();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        return this.mProxyActivity.zeusSuperIsTaskRoot();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        return this.mProxyActivity.zeusSuperIsVoiceInteraction();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        return this.mProxyActivity.zeusSuperIsVoiceInteractionRoot();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mProxyActivity.zeusSuperOnAttachedToWindow();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mProxyActivity.zeusSuperOnBackPressed();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        this.mProxyActivity.zeusSuperOnContentChanged();
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        return this.mProxyActivity.zeusSuperOnCreateDescription();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.mProxyActivity.zeusSuperOnDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mProxyActivity.zeusSuperOnDetachedFromWindow();
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        this.mProxyActivity.zeusSuperOnEnterAnimationComplete();
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        this.mProxyActivity.zeusSuperOnLocalVoiceInteractionStarted();
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        this.mProxyActivity.zeusSuperOnLocalVoiceInteractionStopped();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mProxyActivity.zeusSuperOnLowMemory();
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        return this.mProxyActivity.zeusSuperOnNavigateUp();
    }

    @Override // android.app.Activity
    public void onPause() {
        this.mProxyActivity.zeusSuperOnPause();
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        return this.mProxyActivity.zeusSuperOnPictureInPictureRequested();
    }

    @Override // android.app.Activity
    public void onPostResume() {
        this.mProxyActivity.zeusSuperOnPostResume();
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        return this.mProxyActivity.zeusSuperOnProvideReferrer();
    }

    @Override // android.app.Activity
    public void onRestart() {
        this.mProxyActivity.zeusSuperOnRestart();
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mProxyActivity.zeusSuperOnResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mProxyActivity.zeusSuperOnSearchRequested();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mProxyActivity.zeusSuperOnStart();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mProxyActivity.zeusSuperOnStateNotSaved();
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        this.mProxyActivity.zeusSuperOnUserInteraction();
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        this.mProxyActivity.zeusSuperOnUserLeaveHint();
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        this.mProxyActivity.zeusSuperOnVisibleBehindCanceled();
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        this.mProxyActivity.zeusSuperOpenOptionsMenu();
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        this.mProxyActivity.zeusSuperPostponeEnterTransition();
    }

    @Override // android.app.Activity
    public void recreate() {
        this.mProxyActivity.zeusSuperRecreate();
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        return this.mProxyActivity.zeusSuperReleaseInstance();
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        this.mProxyActivity.zeusSuperReportFullyDrawn();
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        this.mProxyActivity.zeusSuperShowLockTaskEscapeMessage();
    }

    @Override // android.app.Activity
    public void startLockTask() {
        this.mProxyActivity.zeusSuperStartLockTask();
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        this.mProxyActivity.zeusSuperStartPostponedEnterTransition();
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        this.mProxyActivity.zeusSuperStopLocalVoiceInteraction();
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        this.mProxyActivity.zeusSuperStopLockTask();
    }

    public GeneratePluginActivity() {
    }

    public static View INVOKEVIRTUAL_com_volcengine_zeus_activity_GeneratePluginActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void com_volcengine_zeus_activity_GeneratePluginActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(GeneratePluginActivity r1) {
        r1.com_volcengine_zeus_activity_GeneratePluginActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_volcengine_zeus_activity_GeneratePluginActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_volcengine_zeus_activity_GeneratePluginActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(GeneratePluginActivity r11) {
        r11.com_volcengine_zeus_activity_GeneratePluginActivity__finish$___twin___();
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

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, com.volcengine.zeus.activity.IPluginActivity
    public void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
        a.b(this, this.mProxyActivity);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public void com_volcengine_zeus_activity_GeneratePluginActivity__onCreate$___twin___(Bundle r2) {
        this.mProxyActivity.zeusSuperOnCreate(r2);
        jqc.b.a(getLayoutInflater());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r2) {
        return this.mProxyActivity.zeusSuperDispatchGenericMotionEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r2) {
        return this.mProxyActivity.zeusSuperDispatchKeyEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r2) {
        return this.mProxyActivity.zeusSuperDispatchKeyShortcutEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r2) {
        return this.mProxyActivity.zeusSuperDispatchPopulateAccessibilityEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r2) {
        return this.mProxyActivity.zeusSuperDispatchTouchEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r2) {
        return this.mProxyActivity.zeusSuperDispatchTrackballEvent(r2);
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(PictureInPictureParams r2) {
        return this.mProxyActivity.zeusSuperEnterPictureInPictureMode(r2);
    }

    @Override // android.app.Activity
    public View findViewById(int r2) {
        return this.mProxyActivity.zeusSuperFindViewById(r2);
    }

    @Override // android.app.Activity
    public void finishActivity(int r2) {
        this.mProxyActivity.zeusSuperFinishActivity(r2);
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity r2) {
        this.mProxyActivity.zeusSuperFinishFromChild(r2);
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int r2) {
        return this.mProxyActivity.zeusSuperGetPreferences(r2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r2) {
        return this.mProxyActivity.zeusSuperGetSystemService(r2);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean r2) {
        return this.mProxyActivity.zeusSuperMoveTaskToBack(r2);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent r2) {
        return this.mProxyActivity.zeusSuperNavigateUpTo(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode r2) {
        this.mProxyActivity.zeusSuperOnActionModeFinished(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode r2) {
        this.mProxyActivity.zeusSuperOnActionModeStarted(r2);
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment r2) {
        this.mProxyActivity.zeusSuperOnAttachFragment(r2);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r2) {
        this.mProxyActivity.zeusSuperOnConfigurationChanged(r2);
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem r2) {
        return this.mProxyActivity.zeusSuperOnContextItemSelected(r2);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu r2) {
        this.mProxyActivity.zeusSuperOnContextMenuClosed(r2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int r2) {
        return this.mProxyActivity.zeusSuperOnCreateDialog(r2);
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder r2) {
        this.mProxyActivity.zeusSuperOnCreateNavigateUpTaskStack(r2);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu r2) {
        return this.mProxyActivity.zeusSuperOnCreateOptionsMenu(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int r2) {
        return this.mProxyActivity.zeusSuperOnCreatePanelView(r2);
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent r2) {
        return this.mProxyActivity.zeusSuperOnGenericMotionEvent(r2);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean r2) {
        this.mProxyActivity.zeusSuperOnMultiWindowModeChanged(r2);
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity r2) {
        return this.mProxyActivity.zeusSuperOnNavigateUpFromChild(r2);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent r2) {
        this.mProxyActivity.zeusSuperOnNewIntent(r2);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem r2) {
        return this.mProxyActivity.zeusSuperOnOptionsItemSelected(r2);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu r2) {
        this.mProxyActivity.zeusSuperOnOptionsMenuClosed(r2);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean r2) {
        this.mProxyActivity.zeusSuperOnPictureInPictureModeChanged(r2);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle r2) {
        this.mProxyActivity.zeusSuperOnPostCreate(r2);
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder r2) {
        this.mProxyActivity.zeusSuperOnPrepareNavigateUpTaskStack(r2);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu r2) {
        return this.mProxyActivity.zeusSuperOnPrepareOptionsMenu(r2);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent r2) {
        this.mProxyActivity.zeusSuperOnProvideAssistContent(r2);
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle r2) {
        this.mProxyActivity.zeusSuperOnProvideAssistData(r2);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle r2) {
        this.mProxyActivity.zeusSuperOnRestoreInstanceState(r2);     // Catch: Throwable -> L4
        return;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle r2) {
        this.mProxyActivity.zeusSuperOnSaveInstanceState(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent r2) {
        return this.mProxyActivity.zeusSuperOnSearchRequested(r2);
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean r2) {
        this.mProxyActivity.zeusSuperOnTopResumedActivityChanged(r2);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent r2) {
        return this.mProxyActivity.zeusSuperOnTouchEvent(r2);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent r2) {
        return this.mProxyActivity.zeusSuperOnTrackballEvent(r2);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int r2) {
        this.mProxyActivity.zeusSuperOnTrimMemory(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r2) {
        this.mProxyActivity.zeusSuperOnWindowAttributesChanged(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r2) {
        this.mProxyActivity.zeusSuperOnWindowFocusChanged(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r2) {
        return this.mProxyActivity.zeusSuperOnWindowStartingActionMode(r2);
    }

    @Override // android.app.Activity
    public void openContextMenu(View r2) {
        this.mProxyActivity.zeusSuperOpenContextMenu(r2);
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks r2) {
        this.mProxyActivity.zeusSuperRegisterActivityLifecycleCallbacks(r2);
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View r2) {
        this.mProxyActivity.zeusSuperRegisterForContextMenu(r2);
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent r2) {
        return this.mProxyActivity.zeusSuperRequestDragAndDropPermissions(r2);
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean r2) {
        return this.mProxyActivity.zeusSuperRequestVisibleBehind(r2);
    }

    @Override // android.app.Activity
    public void setActionBar(Toolbar r2) {
        this.mProxyActivity.zeusSuperSetActionBar(r2);
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager r2) {
        this.mProxyActivity.zeusSuperSetContentTransitionManager(r2);
    }

    @Override // android.app.Activity
    public void setContentView(int r2) {
        ZeusTransformUtils.clearConstructorCache();
        this.mProxyActivity.zeusSuperSetContentView(r2);
        ZeusTransformUtils.clearConstructorCache();
        d.c(this, findViewById(R.id.content));
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(SharedElementCallback r2) {
        this.mProxyActivity.zeusSuperSetEnterSharedElementCallback(r2);
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(SharedElementCallback r2) {
        this.mProxyActivity.zeusSuperSetExitSharedElementCallback(r2);
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean r2) {
        this.mProxyActivity.zeusSuperSetFinishOnTouchOutside(r2);
    }

    @Override // android.app.Activity
    public void setImmersive(boolean r2) {
        this.mProxyActivity.zeusSuperSetImmersive(r2);
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean r2) {
        this.mProxyActivity.zeusSuperSetInheritShowWhenLocked(r2);
    }

    @Override // android.app.Activity
    public void setIntent(Intent r2) {
        this.mProxyActivity.zeusSuperSetIntent(r2);
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(PictureInPictureParams r2) {
        this.mProxyActivity.zeusSuperSetPictureInPictureParams(r2);
    }

    @Override // com.volcengine.zeus.activity.IPluginActivity
    public void setProxyTheme2Plugin(int r1) {
        super.setTheme(r1);     // Catch: Exception -> L4
        return;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int r2) {
        this.mProxyActivity.zeusSuperSetRequestedOrientation(r2);
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean r2) {
        this.mProxyActivity.zeusSuperSetShowWhenLocked(r2);
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription r2) {
        this.mProxyActivity.zeusSuperSetTaskDescription(r2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int r2) {
        this.mProxyActivity.zeusSuperSetTheme(r2);
    }

    @Override // android.app.Activity
    public void setTitle(int r2) {
        this.mProxyActivity.zeusSuperSetTitle(r2);
    }

    @Override // android.app.Activity
    public void setTitleColor(int r2) {
        this.mProxyActivity.zeusSuperSetTitleColor(r2);
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean r2) {
        return this.mProxyActivity.zeusSuperSetTranslucent(r2);
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean r2) {
        this.mProxyActivity.zeusSuperSetTurnScreenOn(r2);
    }

    @Override // android.app.Activity
    public void setVisible(boolean r2) {
        this.mProxyActivity.zeusSuperSetVisible(r2);
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String r2) {
        return this.mProxyActivity.zeusSuperShouldShowRequestPermissionRationale(r2);
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent r2) {
        return this.mProxyActivity.zeusSuperShouldUpRecreateTask(r2);
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle r2) {
        return this.mProxyActivity.zeusSuperShowAssist(r2);
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback r2) {
        return this.mProxyActivity.zeusSuperStartActionMode(r2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r2) {
        this.mProxyActivity.zeusSuperStartActivities(r2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r2) {
        this.mProxyActivity.zeusSuperStartActivity(r2);
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(Bundle r2) {
        this.mProxyActivity.zeusSuperStartLocalVoiceInteraction(r2);
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor r2) {
        this.mProxyActivity.zeusSuperStartManagingCursor(r2);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent r2) {
        return this.mProxyActivity.zeusSuperStartNextMatchingActivity(r2);
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor r2) {
        this.mProxyActivity.zeusSuperStopManagingCursor(r2);
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean r2) {
        this.mProxyActivity.zeusSuperTakeKeyEvents(r2);
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks r2) {
        this.mProxyActivity.zeusSuperUnregisterActivityLifecycleCallbacks(r2);
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View r2) {
        this.mProxyActivity.zeusSuperUnregisterForContextMenu(r2);
    }

    @Override // android.app.Activity
    public void setContentView(View r2) {
        this.mProxyActivity.zeusSuperSetContentView(r2);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence r2) {
        this.mProxyActivity.zeusSuperSetTitle(r2);
    }

    public static void com_volcengine_zeus_activity_GeneratePluginActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(GeneratePluginActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_volcengine_zeus_activity_GeneratePluginActivity__onCreate$___twin___(r2);
    }

    @Override // com.volcengine.zeus.activity.IPluginActivity
    public void _requestPermissions(String[] r2, int r3) {
        this.mProxyActivity.requestPermissions(r2, r3);
    }

    @Override // android.app.Activity
    public void addContentView(View r2, ViewGroup.LayoutParams r3) {
        this.mProxyActivity.zeusSuperAddContentView(r2, r3);
    }

    public boolean convertToTranslucent(Activity.TranslucentConversionListener r2, ActivityOptions r3) {
        return this.mProxyActivity.zeusSuperConvertToTranslucent(r2, r3);
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity r2, int r3) {
        this.mProxyActivity.zeusSuperFinishActivityFromChild(r2, r3);
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity r2, Intent r3) {
        return this.mProxyActivity.zeusSuperNavigateUpToFromChild(r2, r3);
    }

    @Override // android.app.Activity
    public void onActivityReenter(int r2, Intent r3) {
        this.mProxyActivity.zeusSuperOnActivityReenter(r2, r3);
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(Activity r2, CharSequence r3) {
        this.mProxyActivity.zeusSuperOnChildTitleChanged(r2, r3);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r2, PersistableBundle r3) {
        this.mProxyActivity.zeusSuperOnCreate(r2, r3);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int r2, Bundle r3) {
        return this.mProxyActivity.zeusSuperOnCreateDialog(r2, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r2, Menu r3) {
        return this.mProxyActivity.zeusSuperOnCreatePanelMenu(r2, r3);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap r2, Canvas r3) {
        return this.mProxyActivity.zeusSuperOnCreateThumbnail(r2, r3);
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal r2, Consumer r3) {
        this.mProxyActivity.zeusSuperOnGetDirectActions(r2, r3);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r2, KeyEvent r3) {
        return this.mProxyActivity.zeusSuperOnKeyDown(r2, r3);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int r2, KeyEvent r3) {
        return this.mProxyActivity.zeusSuperOnKeyLongPress(r2, r3);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int r2, KeyEvent r3) {
        return this.mProxyActivity.zeusSuperOnKeyShortcut(r2, r3);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r2, KeyEvent r3) {
        return this.mProxyActivity.zeusSuperOnKeyUp(r2, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int r2, Menu r3) {
        return this.mProxyActivity.zeusSuperOnMenuOpened(r2, r3);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean r2, Configuration r3) {
        this.mProxyActivity.zeusSuperOnMultiWindowModeChanged(r2, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r2, Menu r3) {
        this.mProxyActivity.zeusSuperOnPanelClosed(r2, r3);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean r2, Configuration r3) {
        this.mProxyActivity.zeusSuperOnPictureInPictureModeChanged(r2, r3);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle r2, PersistableBundle r3) {
        this.mProxyActivity.zeusSuperOnPostCreate(r2, r3);
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int r2, Dialog r3) {
        this.mProxyActivity.zeusSuperOnPrepareDialog(r2, r3);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle r2, PersistableBundle r3) {
        this.mProxyActivity.zeusSuperOnRestoreInstanceState(r2, r3);     // Catch: Throwable -> L4
        return;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle r2, PersistableBundle r3) {
        this.mProxyActivity.zeusSuperOnSaveInstanceState(r2, r3);
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence r2, int r3) {
        this.mProxyActivity.zeusSuperOnTitleChanged(r2, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r2, int r3) {
        return this.mProxyActivity.zeusSuperOnWindowStartingActionMode(r2, r3);
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int r2, int r3) {
        this.mProxyActivity.zeusSuperOverridePendingTransition(r2, r3);
    }

    @Override // android.app.Activity
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        this.mProxyActivity.zeusSuperSetContentView(r2, r3);
    }

    @Override // android.app.Activity
    public void setLocusContext(LocusId r2, Bundle r3) {
        this.mProxyActivity.zeusSuperSetLocusContext(r2, r3);
    }

    @Override // com.volcengine.zeus.activity.IPluginActivity
    public void setPluginProxyActivity(b r1, Plugin r2) {
        this.mProxyActivity = (GenerateProxyActivity) r1;
        this.mPlugin = r2;
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean r2, ComponentName r3) throws PackageManager.NameNotFoundException {
        this.mProxyActivity.zeusSuperSetVrModeEnabled(r2, r3);
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback r2, int r3) {
        return this.mProxyActivity.zeusSuperStartActionMode(r2, r3);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r2, Bundle r3) {
        this.mProxyActivity.zeusSuperStartActivities(r2, r3);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r2, Bundle r3) {
        this.mProxyActivity.zeusSuperStartActivity(r2, r3);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent r2, int r3) {
        this.mProxyActivity.zeusSuperStartActivityForResult(r2, r3);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent r2, int r3) {
        return this.mProxyActivity.zeusSuperStartActivityIfNeeded(r2, r3);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent r2, Bundle r3) {
        return this.mProxyActivity.zeusSuperStartNextMatchingActivity(r2, r3);
    }

    @Override // android.app.Activity
    public void triggerSearch(String r2, Bundle r3) {
        this.mProxyActivity.zeusSuperTriggerSearch(r2, r3);
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int r2, Intent r3, int r4) {
        return this.mProxyActivity.zeusSuperCreatePendingResult(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void onActivityResult(int r2, int r3, Intent r4) {
        this.mProxyActivity.zeusSuperOnActivityResult(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme r2, int r3, boolean r4) {
        this.mProxyActivity.zeusSuperOnApplyThemeResource(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu r2, View r3, ContextMenu.ContextMenuInfo r4) {
        this.mProxyActivity.zeusSuperOnCreateContextMenu(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String r2, Context r3, AttributeSet r4) {
        return this.mProxyActivity.zeusSuperOnCreateView(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int r2, int r3, KeyEvent r4) {
        return this.mProxyActivity.zeusSuperOnKeyMultiple(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int r2, Dialog r3, Bundle r4) {
        this.mProxyActivity.zeusSuperOnPrepareDialog(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r2, View r3, Menu r4) {
        return this.mProxyActivity.zeusSuperOnPreparePanel(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List r2, Menu r3, int r4) {
        this.mProxyActivity.zeusSuperOnProvideKeyboardShortcuts(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        this.mProxyActivity.zeusSuperOnRequestPermissionsResult(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent r2, int r3, Bundle r4) {
        this.mProxyActivity.zeusSuperStartActivityForResult(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity r2, Intent r3, int r4) {
        this.mProxyActivity.zeusSuperStartActivityFromChild(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment r2, Intent r3, int r4) {
        this.mProxyActivity.zeusSuperStartActivityFromFragment(r2, r3, r4);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent r2, int r3, Bundle r4) {
        return this.mProxyActivity.zeusSuperStartActivityIfNeeded(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void dump(String r2, FileDescriptor r3, PrintWriter r4, String[] r5) {
        this.mProxyActivity.zeusSuperDump(r2, r3, r4, r5);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View r2, String r3, Context r4, AttributeSet r5) {
        return this.mProxyActivity.zeusSuperOnCreateView(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String r2, Bundle r3, CancellationSignal r4, Consumer r5) {
        this.mProxyActivity.zeusSuperOnPerformDirectAction(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity r2, Intent r3, int r4, Bundle r5) {
        this.mProxyActivity.zeusSuperStartActivityFromChild(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment r2, Intent r3, int r4, Bundle r5) {
        this.mProxyActivity.zeusSuperStartActivityFromFragment(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void startSearch(String r2, boolean r3, Bundle r4, boolean r5) {
        this.mProxyActivity.zeusSuperStartSearch(r2, r3, r4, r5);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender r7, Intent r8, int r9, int r10, int r11) throws IntentSender.SendIntentException {
        this.mProxyActivity.zeusSuperStartIntentSender(r7, r8, r9, r10, r11);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender r8, Intent r9, int r10, int r11, int r12, Bundle r13) throws IntentSender.SendIntentException {
        this.mProxyActivity.zeusSuperStartIntentSender(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender r8, int r9, Intent r10, int r11, int r12, int r13) throws IntentSender.SendIntentException {
        this.mProxyActivity.zeusSuperStartIntentSenderForResult(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender r9, int r10, Intent r11, int r12, int r13, int r14, Bundle r15) throws IntentSender.SendIntentException {
        this.mProxyActivity.zeusSuperStartIntentSenderForResult(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity r9, IntentSender r10, int r11, Intent r12, int r13, int r14, int r15) throws IntentSender.SendIntentException {
        this.mProxyActivity.zeusSuperStartIntentSenderFromChild(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity r11, IntentSender r12, int r13, Intent r14, int r15, int r16, int r17, Bundle r18) throws IntentSender.SendIntentException {
        this.mProxyActivity.zeusSuperStartIntentSenderFromChild(r11, r12, r13, r14, r15, r16, r17, r18);
    }
}
