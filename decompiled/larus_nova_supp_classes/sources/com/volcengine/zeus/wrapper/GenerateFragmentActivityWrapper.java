package com.volcengine.zeus.wrapper;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
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
import androidx.core.app.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.volcengine.zeus.PluginContext;
import dc9.d;
import f06.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class GenerateFragmentActivityWrapper extends FragmentActivity implements a {
    public FragmentActivity mOriginActivity;
    public PluginContext pluginContext;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_volcengine_zeus_wrapper_GenerateFragmentActivityWrapper_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        this.mOriginActivity.closeContextMenu();
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        this.mOriginActivity.closeOptionsMenu();
    }

    public void com_volcengine_zeus_wrapper_GenerateFragmentActivityWrapper__finish$___twin___() {
        this.mOriginActivity.finish();
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        this.mOriginActivity.enterPictureInPictureMode();
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        this.mOriginActivity.finishAffinity();
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        this.mOriginActivity.finishAfterTransition();
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        this.mOriginActivity.finishAndRemoveTask();
    }

    @Override // android.app.Activity
    public ActionBar getActionBar() {
        return this.mOriginActivity.getActionBar();
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        return this.mOriginActivity.getCallingActivity();
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        return this.mOriginActivity.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        return this.mOriginActivity.getChangingConfigurations();
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        return this.mOriginActivity.getComponentName();
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        return this.mOriginActivity.getContentScene();
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        return this.mOriginActivity.getContentTransitionManager();
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        return this.mOriginActivity.getCurrentFocus();
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        return this.mOriginActivity.getFragmentManager();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        return this.mOriginActivity.getIntent();
    }

    @Override // android.app.Activity
    public Object getLastNonConfigurationInstance() {
        return this.mOriginActivity.getLastNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        return this.mOriginActivity.getLayoutInflater();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mOriginActivity.getLifecycle();
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        return this.mOriginActivity.getLoaderManager();
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        return this.mOriginActivity.getLocalClassName();
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        return this.mOriginActivity.getMaxNumPictureInPictureActions();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.mOriginActivity.getMenuInflater();
    }

    @Override // android.app.Activity
    public Intent getParentActivityIntent() {
        return this.mOriginActivity.getParentActivityIntent();
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        return this.mOriginActivity.getReferrer();
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        return this.mOriginActivity.getRequestedOrientation();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public androidx.fragment.app.FragmentManager getSupportFragmentManager() {
        return this.mOriginActivity.getSupportFragmentManager();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public androidx.loader.app.LoaderManager getSupportLoaderManager() {
        return this.mOriginActivity.getSupportLoaderManager();
    }

    @Override // android.app.Activity
    public int getTaskId() {
        return this.mOriginActivity.getTaskId();
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return this.mOriginActivity.getViewModelStore();
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        return this.mOriginActivity.getVoiceInteractor();
    }

    @Override // android.app.Activity
    public Window getWindow() {
        return this.mOriginActivity.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        return this.mOriginActivity.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        return INVOKEVIRTUAL_com_volcengine_zeus_wrapper_GenerateFragmentActivityWrapper_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(this.mOriginActivity);
    }

    public int hashCode() {
        return this.mOriginActivity.hashCode();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        this.mOriginActivity.invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        return this.mOriginActivity.isActivityTransitionRunning();
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        return this.mOriginActivity.isChangingConfigurations();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        return this.mOriginActivity.isDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        return this.mOriginActivity.isFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return this.mOriginActivity.isImmersive();
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        return this.mOriginActivity.isInMultiWindowMode();
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        return this.mOriginActivity.isInPictureInPictureMode();
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        return this.mOriginActivity.isLocalVoiceInteractionSupported();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        return this.mOriginActivity.isTaskRoot();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        return this.mOriginActivity.isVoiceInteraction();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        return this.mOriginActivity.isVoiceInteractionRoot();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mOriginActivity.onAttachedToWindow();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.mOriginActivity.onBackPressed();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        this.mOriginActivity.onContentChanged();
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        return this.mOriginActivity.onCreateDescription();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mOriginActivity.onDetachedFromWindow();
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        this.mOriginActivity.onEnterAnimationComplete();
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        this.mOriginActivity.onLocalVoiceInteractionStarted();
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        this.mOriginActivity.onLocalVoiceInteractionStopped();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mOriginActivity.onLowMemory();
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        return this.mOriginActivity.onNavigateUp();
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        return this.mOriginActivity.onPictureInPictureRequested();
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        return this.mOriginActivity.onProvideReferrer();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mOriginActivity.onSearchRequested();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStateNotSaved() {
        this.mOriginActivity.onStateNotSaved();
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        this.mOriginActivity.onUserInteraction();
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        this.mOriginActivity.onVisibleBehindCanceled();
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        this.mOriginActivity.openOptionsMenu();
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        this.mOriginActivity.postponeEnterTransition();
    }

    @Override // android.app.Activity
    public void recreate() {
        this.mOriginActivity.recreate();
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        return this.mOriginActivity.releaseInstance();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void reportFullyDrawn() {
        this.mOriginActivity.reportFullyDrawn();
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        this.mOriginActivity.showLockTaskEscapeMessage();
    }

    @Override // android.app.Activity
    public void startLockTask() {
        this.mOriginActivity.startLockTask();
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        this.mOriginActivity.startPostponedEnterTransition();
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        this.mOriginActivity.stopLocalVoiceInteraction();
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        this.mOriginActivity.stopLockTask();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportFinishAfterTransition() {
        this.mOriginActivity.supportFinishAfterTransition();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        this.mOriginActivity.supportInvalidateOptionsMenu();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportPostponeEnterTransition() {
        this.mOriginActivity.supportPostponeEnterTransition();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportStartPostponedEnterTransition() {
        this.mOriginActivity.supportStartPostponedEnterTransition();
    }

    public GenerateFragmentActivityWrapper() {
    }

    public static boolean INVOKEVIRTUAL_com_volcengine_zeus_wrapper_GenerateFragmentActivityWrapper_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(FragmentActivity r3) {
        boolean r4 = r3.hasWindowFocus();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "hasWindowFocus");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "hasWindowFocus");
    L7:
        return r4;
    }

    public static void com_volcengine_zeus_wrapper_GenerateFragmentActivityWrapper_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(GenerateFragmentActivityWrapper r11) {
        r11.com_volcengine_zeus_wrapper_GenerateFragmentActivityWrapper__finish$___twin___();
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

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r2) {
        return this.mOriginActivity.dispatchGenericMotionEvent(r2);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r2) {
        return this.mOriginActivity.dispatchKeyEvent(r2);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r2) {
        return this.mOriginActivity.dispatchKeyShortcutEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r2) {
        return this.mOriginActivity.dispatchPopulateAccessibilityEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r2) {
        return this.mOriginActivity.dispatchTouchEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r2) {
        return this.mOriginActivity.dispatchTrackballEvent(r2);
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(PictureInPictureParams r2) {
        return this.mOriginActivity.enterPictureInPictureMode(r2);
    }

    @Override // android.app.Activity
    public View findViewById(int r2) {
        return this.mOriginActivity.findViewById(r2);
    }

    @Override // android.app.Activity
    public void finishActivity(int r2) {
        this.mOriginActivity.finishActivity(r2);
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity r2) {
        this.mOriginActivity.finishFromChild(r2);
    }

    @Override // androidx.core.app.ComponentActivity
    public ComponentActivity.ExtraData getExtraData(Class r2) {
        return this.mOriginActivity.getExtraData(r2);
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int r2) {
        return this.mOriginActivity.getPreferences(r2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r2) {
        return this.pluginContext.getSystemService(r2);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean r2) {
        return this.mOriginActivity.moveTaskToBack(r2);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent r2) {
        return this.mOriginActivity.navigateUpTo(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode r2) {
        this.mOriginActivity.onActionModeFinished(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode r2) {
        this.mOriginActivity.onActionModeStarted(r2);
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment r2) {
        this.mOriginActivity.onAttachFragment(r2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r2) {
        INVOKEVIRTUAL_com_volcengine_zeus_wrapper_GenerateFragmentActivityWrapper_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this.mOriginActivity, r2);
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem r2) {
        return this.mOriginActivity.onContextItemSelected(r2);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu r2) {
        this.mOriginActivity.onContextMenuClosed(r2);
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder r2) {
        this.mOriginActivity.onCreateNavigateUpTaskStack(r2);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu r2) {
        return this.mOriginActivity.onCreateOptionsMenu(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int r2) {
        return this.mOriginActivity.onCreatePanelView(r2);
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent r2) {
        return this.mOriginActivity.onGenericMotionEvent(r2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean r2) {
        this.mOriginActivity.onMultiWindowModeChanged(r2);
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity r2) {
        return this.mOriginActivity.onNavigateUpFromChild(r2);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem r2) {
        return this.mOriginActivity.onOptionsItemSelected(r2);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu r2) {
        this.mOriginActivity.onOptionsMenuClosed(r2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean r2) {
        this.mOriginActivity.onPictureInPictureModeChanged(r2);
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder r2) {
        this.mOriginActivity.onPrepareNavigateUpTaskStack(r2);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu r2) {
        return this.mOriginActivity.onPrepareOptionsMenu(r2);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent r2) {
        this.mOriginActivity.onProvideAssistContent(r2);
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle r2) {
        this.mOriginActivity.onProvideAssistData(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent r2) {
        return this.mOriginActivity.onSearchRequested(r2);
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean r2) {
        this.mOriginActivity.onTopResumedActivityChanged(r2);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent r2) {
        return this.mOriginActivity.onTouchEvent(r2);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent r2) {
        return this.mOriginActivity.onTrackballEvent(r2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int r2) {
        this.mOriginActivity.onTrimMemory(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r2) {
        this.mOriginActivity.onWindowAttributesChanged(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r2) {
        this.mOriginActivity.onWindowFocusChanged(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r2) {
        return this.mOriginActivity.onWindowStartingActionMode(r2);
    }

    @Override // android.app.Activity
    public void openContextMenu(View r2) {
        this.mOriginActivity.openContextMenu(r2);
    }

    @Override // androidx.core.app.ComponentActivity
    public void putExtraData(ComponentActivity.ExtraData r2) {
        this.mOriginActivity.putExtraData(r2);
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks r2) {
        this.mOriginActivity.registerActivityLifecycleCallbacks(r2);
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View r2) {
        this.mOriginActivity.registerForContextMenu(r2);
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent r2) {
        return this.mOriginActivity.requestDragAndDropPermissions(r2);
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean r2) {
        return this.mOriginActivity.requestVisibleBehind(r2);
    }

    @Override // android.app.Activity
    public void setActionBar(Toolbar r2) {
        this.mOriginActivity.setActionBar(r2);
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager r2) {
        this.mOriginActivity.setContentTransitionManager(r2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int r2) {
        this.mOriginActivity.setContentView(r2);
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(SharedElementCallback r2) {
        this.mOriginActivity.setEnterSharedElementCallback(r2);
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(SharedElementCallback r2) {
        this.mOriginActivity.setExitSharedElementCallback(r2);
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean r2) {
        this.mOriginActivity.setFinishOnTouchOutside(r2);
    }

    @Override // android.app.Activity
    public void setImmersive(boolean r2) {
        this.mOriginActivity.setImmersive(r2);
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean r2) {
        this.mOriginActivity.setInheritShowWhenLocked(r2);
    }

    @Override // android.app.Activity
    public void setIntent(Intent r2) {
        this.mOriginActivity.setIntent(r2);
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(PictureInPictureParams r2) {
        this.mOriginActivity.setPictureInPictureParams(r2);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int r2) {
        this.mOriginActivity.setRequestedOrientation(r2);
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean r2) {
        this.mOriginActivity.setShowWhenLocked(r2);
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription r2) {
        this.mOriginActivity.setTaskDescription(r2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int r2) {
        this.mOriginActivity.setTheme(r2);
    }

    @Override // android.app.Activity
    public void setTitle(int r2) {
        this.mOriginActivity.setTitle(r2);
    }

    @Override // android.app.Activity
    public void setTitleColor(int r2) {
        this.mOriginActivity.setTitleColor(r2);
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean r2) {
        return this.mOriginActivity.setTranslucent(r2);
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean r2) {
        this.mOriginActivity.setTurnScreenOn(r2);
    }

    @Override // android.app.Activity
    public void setVisible(boolean r2) {
        this.mOriginActivity.setVisible(r2);
    }

    @Override // com.volcengine.zeus.wrapper.a
    public void setWrapperActivityTheme(int r1) {
        super.setTheme(r1);     // Catch: Exception -> L4
        return;
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String r2) {
        return com_volcengine_zeus_wrapper_GenerateFragmentActivityWrapper_androidx_fragment_app_FragmentActivity_shouldShowRequestPermissionRationale(this.mOriginActivity, r2);
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent r2) {
        return this.mOriginActivity.shouldUpRecreateTask(r2);
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle r2) {
        return this.mOriginActivity.showAssist(r2);
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback r2) {
        return this.mOriginActivity.startActionMode(r2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r2) {
        this.mOriginActivity.startActivities(r2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r2) {
        this.mOriginActivity.startActivity(r2);
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(Bundle r2) {
        this.mOriginActivity.startLocalVoiceInteraction(r2);
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor r2) {
        this.mOriginActivity.startManagingCursor(r2);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent r2) {
        return this.mOriginActivity.startNextMatchingActivity(r2);
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor r2) {
        this.mOriginActivity.stopManagingCursor(r2);
    }

    @Override // androidx.core.app.ComponentActivity, androidx.core.view.KeyEventDispatcher$Component
    public boolean superDispatchKeyEvent(KeyEvent r2) {
        return this.mOriginActivity.superDispatchKeyEvent(r2);
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean r2) {
        this.mOriginActivity.takeKeyEvents(r2);
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks r2) {
        this.mOriginActivity.unregisterActivityLifecycleCallbacks(r2);
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View r2) {
        this.mOriginActivity.unregisterForContextMenu(r2);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(androidx.fragment.app.Fragment r2) {
        this.mOriginActivity.onAttachFragment(r2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r2) {
        this.mOriginActivity.setContentView(r2);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void setEnterSharedElementCallback(androidx.core.app.SharedElementCallback r2) {
        this.mOriginActivity.setEnterSharedElementCallback(r2);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void setExitSharedElementCallback(androidx.core.app.SharedElementCallback r2) {
        this.mOriginActivity.setExitSharedElementCallback(r2);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence r2) {
        this.mOriginActivity.setTitle(r2);
    }

    public static void INVOKEVIRTUAL_com_volcengine_zeus_wrapper_GenerateFragmentActivityWrapper_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(FragmentActivity r3, Configuration r4) {
        r3.onConfigurationChanged(r4);
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

    private static boolean com_volcengine_zeus_wrapper_GenerateFragmentActivityWrapper_androidx_fragment_app_FragmentActivity_shouldShowRequestPermissionRationale(FragmentActivity r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b("auto_cert_com_volcengine_zeus_wrapper_GenerateFragmentActivityWrapper_androidx_fragment_app_FragmentActivity_shouldShowRequestPermissionRationale");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102609);
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
        f06.d r4 = r7.preInvoke(102609, "androidx/fragment/app/FragmentActivity", "shouldShowRequestPermissionRationale", r18, r1, "boolean", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Boolean) r4.b).booleanValue();
    L21:
        return r18.shouldShowRequestPermissionRationale(r19);
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View r2, ViewGroup.LayoutParams r3) {
        this.mOriginActivity.addContentView(r2, r3);
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity r2, int r3) {
        this.mOriginActivity.finishActivityFromChild(r2, r3);
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity r2, Intent r3) {
        return this.mOriginActivity.navigateUpToFromChild(r2, r3);
    }

    @Override // android.app.Activity
    public void onActivityReenter(int r2, Intent r3) {
        this.mOriginActivity.onActivityReenter(r2, r3);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r2, PersistableBundle r3) {
        this.mOriginActivity.onCreate(r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r2, Menu r3) {
        return this.mOriginActivity.onCreatePanelMenu(r2, r3);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap r2, Canvas r3) {
        return this.mOriginActivity.onCreateThumbnail(r2, r3);
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal r2, Consumer r3) {
        this.mOriginActivity.onGetDirectActions(r2, r3);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r2, KeyEvent r3) {
        return this.mOriginActivity.onKeyDown(r2, r3);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int r2, KeyEvent r3) {
        return this.mOriginActivity.onKeyLongPress(r2, r3);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int r2, KeyEvent r3) {
        return this.mOriginActivity.onKeyShortcut(r2, r3);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r2, KeyEvent r3) {
        return this.mOriginActivity.onKeyUp(r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r2, MenuItem r3) {
        return this.mOriginActivity.onMenuItemSelected(r2, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int r2, Menu r3) {
        return this.mOriginActivity.onMenuOpened(r2, r3);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean r2, Configuration r3) {
        this.mOriginActivity.onMultiWindowModeChanged(r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r2, Menu r3) {
        this.mOriginActivity.onPanelClosed(r2, r3);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean r2, Configuration r3) {
        this.mOriginActivity.onPictureInPictureModeChanged(r2, r3);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle r2, PersistableBundle r3) {
        this.mOriginActivity.onPostCreate(r2, r3);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle r2, PersistableBundle r3) {
        this.mOriginActivity.onRestoreInstanceState(r2, r3);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle r2, PersistableBundle r3) {
        this.mOriginActivity.onSaveInstanceState(r2, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r2, int r3) {
        return this.mOriginActivity.onWindowStartingActionMode(r2, r3);
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int r2, int r3) {
        this.mOriginActivity.overridePendingTransition(r2, r3);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        this.mOriginActivity.setContentView(r2, r3);
    }

    @Override // android.app.Activity
    public void setLocusContext(LocusId r2, Bundle r3) {
        this.mOriginActivity.setLocusContext(r2, r3);
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean r2, ComponentName r3) throws PackageManager.NameNotFoundException {
        this.mOriginActivity.setVrModeEnabled(r2, r3);
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback r2, int r3) {
        return this.mOriginActivity.startActionMode(r2, r3);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r2, Bundle r3) {
        this.mOriginActivity.startActivities(r2, r3);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r2, Bundle r3) {
        this.mOriginActivity.startActivity(r2, r3);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r2, int r3) {
        this.mOriginActivity.startActivityForResult(r2, r3);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent r2, int r3) {
        return this.mOriginActivity.startActivityIfNeeded(r2, r3);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent r2, Bundle r3) {
        return this.mOriginActivity.startNextMatchingActivity(r2, r3);
    }

    @Override // android.app.Activity
    public void triggerSearch(String r2, Bundle r3) {
        this.mOriginActivity.triggerSearch(r2, r3);
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int r2, Intent r3, int r4) {
        return this.mOriginActivity.createPendingResult(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu r2, View r3, ContextMenu.ContextMenuInfo r4) {
        this.mOriginActivity.onCreateContextMenu(r2, r3, r4);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String r2, Context r3, AttributeSet r4) {
        return this.mOriginActivity.onCreateView(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int r2, int r3, KeyEvent r4) {
        return this.mOriginActivity.onKeyMultiple(r2, r3, r4);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r2, View r3, Menu r4) {
        return this.mOriginActivity.onPreparePanel(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List r2, Menu r3, int r4) {
        this.mOriginActivity.onProvideKeyboardShortcuts(r2, r3, r4);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        com_volcengine_zeus_wrapper_GenerateFragmentActivityWrapper_androidx_fragment_app_FragmentActivity_onRequestPermissionsResult(this.mOriginActivity, r2, r3, r4);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r2, int r3, Bundle r4) {
        this.mOriginActivity.startActivityForResult(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity r2, Intent r3, int r4) {
        this.mOriginActivity.startActivityFromChild(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment r2, Intent r3, int r4) {
        this.mOriginActivity.startActivityFromFragment(r2, r3, r4);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent r2, int r3, Bundle r4) {
        return this.mOriginActivity.startActivityIfNeeded(r2, r3, r4);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startActivityFromFragment(androidx.fragment.app.Fragment r2, Intent r3, int r4) {
        this.mOriginActivity.startActivityFromFragment(r2, r3, r4);
    }

    private static void com_volcengine_zeus_wrapper_GenerateFragmentActivityWrapper_androidx_fragment_app_FragmentActivity_onRequestPermissionsResult(FragmentActivity r18, int r19, String[] r20, int[] r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19), r20, r21};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102611);
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
        f06.d r4 = r7.preInvoke(102611, "androidx/fragment/app/FragmentActivity", "onRequestPermissionsResult", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.onRequestPermissionsResult(r19, r20, r21);
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(String r2, FileDescriptor r3, PrintWriter r4, String[] r5) {
        this.mOriginActivity.dump(r2, r3, r4, r5);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View r2, String r3, Context r4, AttributeSet r5) {
        return this.mOriginActivity.onCreateView(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String r2, Bundle r3, CancellationSignal r4, Consumer r5) {
        this.mOriginActivity.onPerformDirectAction(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity r2, Intent r3, int r4, Bundle r5) {
        this.mOriginActivity.startActivityFromChild(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment r2, Intent r3, int r4, Bundle r5) {
        this.mOriginActivity.startActivityFromFragment(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void startSearch(String r2, boolean r3, Bundle r4, boolean r5) {
        this.mOriginActivity.startSearch(r2, r3, r4, r5);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startActivityFromFragment(androidx.fragment.app.Fragment r2, Intent r3, int r4, Bundle r5) {
        this.mOriginActivity.startActivityFromFragment(r2, r3, r4, r5);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender r7, Intent r8, int r9, int r10, int r11) throws IntentSender.SendIntentException {
        this.mOriginActivity.startIntentSender(r7, r8, r9, r10, r11);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender r8, Intent r9, int r10, int r11, int r12, Bundle r13) throws IntentSender.SendIntentException {
        this.mOriginActivity.startIntentSender(r8, r9, r10, r11, r12, r13);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender r8, int r9, Intent r10, int r11, int r12, int r13) throws IntentSender.SendIntentException {
        this.mOriginActivity.startIntentSenderForResult(r8, r9, r10, r11, r12, r13);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender r9, int r10, Intent r11, int r12, int r13, int r14, Bundle r15) throws IntentSender.SendIntentException {
        this.mOriginActivity.startIntentSenderForResult(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity r9, IntentSender r10, int r11, Intent r12, int r13, int r14, int r15) throws IntentSender.SendIntentException {
        this.mOriginActivity.startIntentSenderFromChild(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity r11, IntentSender r12, int r13, Intent r14, int r15, int r16, int r17, Bundle r18) throws IntentSender.SendIntentException {
        this.mOriginActivity.startIntentSenderFromChild(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startIntentSenderFromFragment(androidx.fragment.app.Fragment r11, IntentSender r12, int r13, Intent r14, int r15, int r16, int r17, Bundle r18) throws IntentSender.SendIntentException {
        this.mOriginActivity.startIntentSenderFromFragment(r11, r12, r13, r14, r15, r16, r17, r18);
    }
}
