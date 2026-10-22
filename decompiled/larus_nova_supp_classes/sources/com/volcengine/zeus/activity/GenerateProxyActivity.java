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
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.volcengine.zeus.plugin.Plugin;
import dc9.d;
import el9.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class GenerateProxyActivity extends Activity implements b {
    public Plugin mPlugin;
    public GeneratePluginActivity mTargetActivity;

    public static /* synthetic */ boolean access$000(Activity r0) {
        return super.hasWindowFocus();
    }

    public static /* synthetic */ Class access$001(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    @Override // android.app.Activity, com.volcengine.zeus.activity.b
    public void finish() {
        com_volcengine_zeus_activity_GenerateProxyActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public abstract String getPluginPkgName();

    @Override // android.app.Activity
    public void onCreate(Bundle r1) {
        com_volcengine_zeus_activity_GenerateProxyActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.closeContextMenu();
        return;
    L5:
        super.closeContextMenu();
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.closeOptionsMenu();
        return;
    L5:
        super.closeOptionsMenu();
    }

    public void com_volcengine_zeus_activity_GenerateProxyActivity__finish$___twin___() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.finish();
        return;
    L5:
        super.finish();
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.enterPictureInPictureMode();
        return;
    L5:
        super.enterPictureInPictureMode();
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.finishAffinity();
        return;
    L5:
        super.finishAffinity();
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.finishAfterTransition();
        return;
    L5:
        super.finishAfterTransition();
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.finishAndRemoveTask();
        return;
    L5:
        super.finishAndRemoveTask();
    }

    @Override // android.app.Activity
    public ActionBar getActionBar() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getActionBar();
    L7:
        return super.getActionBar();
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getCallingActivity();
    L7:
        return super.getCallingActivity();
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getCallingPackage();
    L7:
        return super.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getChangingConfigurations();
    L7:
        return super.getChangingConfigurations();
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getComponentName();
    L7:
        return super.getComponentName();
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getContentScene();
    L7:
        return super.getContentScene();
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getContentTransitionManager();
    L7:
        return super.getContentTransitionManager();
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getCurrentFocus();
    L7:
        return super.getCurrentFocus();
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getFragmentManager();
    L7:
        return super.getFragmentManager();
    }

    @Override // android.app.Activity, com.volcengine.zeus.activity.b
    public Intent getIntent() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getIntent();
    L7:
        return super.getIntent();
    }

    @Override // android.app.Activity
    public Object getLastNonConfigurationInstance() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getLastNonConfigurationInstance();
    L7:
        return super.getLastNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getLayoutInflater();
    L7:
        return super.getLayoutInflater();
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getLoaderManager();
    L7:
        return super.getLoaderManager();
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getLocalClassName();
    L7:
        return super.getLocalClassName();
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getMaxNumPictureInPictureActions();
    L7:
        return super.getMaxNumPictureInPictureActions();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getMenuInflater();
    L7:
        return super.getMenuInflater();
    }

    @Override // android.app.Activity
    public Intent getParentActivityIntent() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getParentActivityIntent();
    L7:
        return super.getParentActivityIntent();
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getReferrer();
    L7:
        return super.getReferrer();
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getRequestedOrientation();
    L7:
        return super.getRequestedOrientation();
    }

    @Override // android.app.Activity
    public int getTaskId() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getTaskId();
    L7:
        return super.getTaskId();
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getVoiceInteractor();
    L7:
        return super.getVoiceInteractor();
    }

    @Override // android.app.Activity, com.volcengine.zeus.activity.b
    public Window getWindow() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getWindow();
    L7:
        return super.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getWindowManager();
    L7:
        return super.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return INVOKEVIRTUAL_com_volcengine_zeus_activity_GenerateProxyActivity_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(r0);
    L7:
        return INVOKESPECIAL_com_volcengine_zeus_activity_GenerateProxyActivity_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.invalidateOptionsMenu();
        return;
    L5:
        super.invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.isActivityTransitionRunning();
    L7:
        return super.isActivityTransitionRunning();
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.isChangingConfigurations();
    L7:
        return super.isChangingConfigurations();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.isDestroyed();
    L7:
        return super.isDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.isFinishing();
    L7:
        return super.isFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.isImmersive();
    L7:
        return super.isImmersive();
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.isInMultiWindowMode();
    L7:
        return super.isInMultiWindowMode();
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.isInPictureInPictureMode();
    L7:
        return super.isInPictureInPictureMode();
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.isLocalVoiceInteractionSupported();
    L7:
        return super.isLocalVoiceInteractionSupported();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.isTaskRoot();
    L7:
        return super.isTaskRoot();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.isVoiceInteraction();
    L7:
        return super.isVoiceInteraction();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.isVoiceInteractionRoot();
    L7:
        return super.isVoiceInteractionRoot();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onAttachedToWindow();
        return;
    L5:
        super.onAttachedToWindow();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onBackPressed();
        return;
    L5:
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onContentChanged();
        return;
    L5:
        super.onContentChanged();
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onCreateDescription();
    L7:
        return super.onCreateDescription();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onDestroy();
        return;
    L5:
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onDetachedFromWindow();
        return;
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onEnterAnimationComplete();
        return;
    L5:
        super.onEnterAnimationComplete();
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onLocalVoiceInteractionStarted();
        return;
    L5:
        super.onLocalVoiceInteractionStarted();
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onLocalVoiceInteractionStopped();
        return;
    L5:
        super.onLocalVoiceInteractionStopped();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onLowMemory();
        return;
    L5:
        super.onLowMemory();
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onNavigateUp();
    L7:
        return super.onNavigateUp();
    }

    @Override // android.app.Activity
    public void onPause() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onPause();
        return;
    L5:
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onPictureInPictureRequested();
    L7:
        return super.onPictureInPictureRequested();
    }

    @Override // android.app.Activity
    public void onPostResume() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onPostResume();
        return;
    L5:
        super.onPostResume();
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onProvideReferrer();
    L7:
        return super.onProvideReferrer();
    }

    @Override // android.app.Activity
    public void onRestart() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onRestart();
        return;
    L5:
        super.onRestart();
    }

    @Override // android.app.Activity
    public void onResume() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onResume();
        return;
    L5:
        super.onResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onSearchRequested();
    L7:
        return super.onSearchRequested();
    }

    @Override // android.app.Activity
    public void onStart() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onStart();
        return;
    L5:
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onStateNotSaved();
        return;
    L5:
        super.onStateNotSaved();
    }

    @Override // android.app.Activity
    public void onStop() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onStop();
        return;
    L5:
        super.onStop();
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onUserInteraction();
        return;
    L5:
        super.onUserInteraction();
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onUserLeaveHint();
        return;
    L5:
        super.onUserLeaveHint();
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onVisibleBehindCanceled();
        return;
    L5:
        super.onVisibleBehindCanceled();
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.openOptionsMenu();
        return;
    L5:
        super.openOptionsMenu();
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.postponeEnterTransition();
        return;
    L5:
        super.postponeEnterTransition();
    }

    @Override // android.app.Activity
    public void recreate() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.recreate();
        return;
    L5:
        super.recreate();
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.releaseInstance();
    L7:
        return super.releaseInstance();
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.reportFullyDrawn();
        return;
    L5:
        super.reportFullyDrawn();
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.showLockTaskEscapeMessage();
        return;
    L5:
        super.showLockTaskEscapeMessage();
    }

    @Override // android.app.Activity
    public void startLockTask() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startLockTask();
        return;
    L5:
        super.startLockTask();
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startPostponedEnterTransition();
        return;
    L5:
        super.startPostponedEnterTransition();
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.stopLocalVoiceInteraction();
        return;
    L5:
        super.stopLocalVoiceInteraction();
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.stopLockTask();
        return;
    L5:
        super.stopLockTask();
    }

    public ActionBar zeusSuperGetActionBar() {
        return super.getActionBar();
    }

    public ComponentName zeusSuperGetCallingActivity() {
        return super.getCallingActivity();
    }

    public String zeusSuperGetCallingPackage() {
        return super.getCallingPackage();
    }

    public int zeusSuperGetChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public ComponentName zeusSuperGetComponentName() {
        return super.getComponentName();
    }

    public Scene zeusSuperGetContentScene() {
        return super.getContentScene();
    }

    public TransitionManager zeusSuperGetContentTransitionManager() {
        return super.getContentTransitionManager();
    }

    public View zeusSuperGetCurrentFocus() {
        return super.getCurrentFocus();
    }

    public FragmentManager zeusSuperGetFragmentManager() {
        return super.getFragmentManager();
    }

    public Intent zeusSuperGetIntent() {
        return super.getIntent();
    }

    public Object zeusSuperGetLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }

    public LayoutInflater zeusSuperGetLayoutInflater() {
        return super.getLayoutInflater();
    }

    public LoaderManager zeusSuperGetLoaderManager() {
        return super.getLoaderManager();
    }

    public String zeusSuperGetLocalClassName() {
        return super.getLocalClassName();
    }

    public int zeusSuperGetMaxNumPictureInPictureActions() {
        return super.getMaxNumPictureInPictureActions();
    }

    public MenuInflater zeusSuperGetMenuInflater() {
        return super.getMenuInflater();
    }

    public Intent zeusSuperGetParentActivityIntent() {
        return super.getParentActivityIntent();
    }

    public Uri zeusSuperGetReferrer() {
        return super.getReferrer();
    }

    public int zeusSuperGetRequestedOrientation() {
        return super.getRequestedOrientation();
    }

    public int zeusSuperGetTaskId() {
        return super.getTaskId();
    }

    public VoiceInteractor zeusSuperGetVoiceInteractor() {
        return super.getVoiceInteractor();
    }

    public Window zeusSuperGetWindow() {
        return super.getWindow();
    }

    public WindowManager zeusSuperGetWindowManager() {
        return super.getWindowManager();
    }

    public boolean zeusSuperHasWindowFocus() {
        return INVOKESPECIAL_com_volcengine_zeus_activity_GenerateProxyActivity_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(this);
    }

    public boolean zeusSuperIsActivityTransitionRunning() {
        return super.isActivityTransitionRunning();
    }

    public boolean zeusSuperIsChangingConfigurations() {
        return super.isChangingConfigurations();
    }

    public boolean zeusSuperIsDestroyed() {
        return super.isDestroyed();
    }

    public boolean zeusSuperIsFinishing() {
        return super.isFinishing();
    }

    public boolean zeusSuperIsImmersive() {
        return super.isImmersive();
    }

    public boolean zeusSuperIsInMultiWindowMode() {
        return super.isInMultiWindowMode();
    }

    public boolean zeusSuperIsInPictureInPictureMode() {
        return super.isInPictureInPictureMode();
    }

    public boolean zeusSuperIsLocalVoiceInteractionSupported() {
        return super.isLocalVoiceInteractionSupported();
    }

    public boolean zeusSuperIsTaskRoot() {
        return super.isTaskRoot();
    }

    public boolean zeusSuperIsVoiceInteraction() {
        return super.isVoiceInteraction();
    }

    public boolean zeusSuperIsVoiceInteractionRoot() {
        return super.isVoiceInteractionRoot();
    }

    public CharSequence zeusSuperOnCreateDescription() {
        return super.onCreateDescription();
    }

    public boolean zeusSuperOnNavigateUp() {
        return super.onNavigateUp();
    }

    public boolean zeusSuperOnPictureInPictureRequested() {
        return super.onPictureInPictureRequested();
    }

    public Uri zeusSuperOnProvideReferrer() {
        return super.onProvideReferrer();
    }

    public boolean zeusSuperOnSearchRequested() {
        return super.onSearchRequested();
    }

    public boolean zeusSuperReleaseInstance() {
        return super.releaseInstance();
    }

    public GenerateProxyActivity() {
    }

    @Override // com.volcengine.zeus.activity.b
    public Plugin getPlugin() {
        return this.mPlugin;
    }

    public void zeusSuperCloseContextMenu() {
        super.closeContextMenu();
    }

    public void zeusSuperCloseOptionsMenu() {
        super.closeOptionsMenu();
    }

    public void zeusSuperEnterPictureInPictureMode() {
        super.enterPictureInPictureMode();
    }

    public void zeusSuperFinish() {
        super.finish();
    }

    public void zeusSuperFinishAffinity() {
        super.finishAffinity();
    }

    public void zeusSuperFinishAfterTransition() {
        super.finishAfterTransition();
    }

    public void zeusSuperFinishAndRemoveTask() {
        super.finishAndRemoveTask();
    }

    public void zeusSuperInvalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    public void zeusSuperOnAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void zeusSuperOnBackPressed() {
        super.onBackPressed();
    }

    public void zeusSuperOnContentChanged() {
        super.onContentChanged();
    }

    public void zeusSuperOnDestroy() {
        super.onDestroy();
    }

    public void zeusSuperOnDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void zeusSuperOnEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }

    public void zeusSuperOnLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
    }

    public void zeusSuperOnLocalVoiceInteractionStopped() {
        super.onLocalVoiceInteractionStopped();
    }

    public void zeusSuperOnLowMemory() {
        super.onLowMemory();
    }

    public void zeusSuperOnPause() {
        super.onPause();
    }

    public void zeusSuperOnPostResume() {
        super.onPostResume();
    }

    public void zeusSuperOnRestart() {
        super.onRestart();
    }

    public void zeusSuperOnResume() {
        super.onResume();
    }

    public void zeusSuperOnStart() {
        super.onStart();
    }

    public void zeusSuperOnStateNotSaved() {
        super.onStateNotSaved();
    }

    public void zeusSuperOnStop() {
        super.onStop();
    }

    public void zeusSuperOnUserInteraction() {
        super.onUserInteraction();
    }

    public void zeusSuperOnUserLeaveHint() {
        super.onUserLeaveHint();
    }

    public void zeusSuperOnVisibleBehindCanceled() {
        super.onVisibleBehindCanceled();
    }

    public void zeusSuperOpenOptionsMenu() {
        super.openOptionsMenu();
    }

    public void zeusSuperPostponeEnterTransition() {
        super.postponeEnterTransition();
    }

    public void zeusSuperRecreate() {
        super.recreate();
    }

    public void zeusSuperReportFullyDrawn() {
        super.reportFullyDrawn();
    }

    public void zeusSuperShowLockTaskEscapeMessage() {
        super.showLockTaskEscapeMessage();
    }

    public void zeusSuperStartLockTask() {
        super.startLockTask();
    }

    public void zeusSuperStartPostponedEnterTransition() {
        super.startPostponedEnterTransition();
    }

    public void zeusSuperStopLocalVoiceInteraction() {
        super.stopLocalVoiceInteraction();
    }

    public void zeusSuperStopLockTask() {
        super.stopLockTask();
    }

    public static boolean INVOKESPECIAL_com_volcengine_zeus_activity_GenerateProxyActivity_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(Activity r3) {
        boolean r4 = access$000(r3);
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "hasWindowFocus");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "hasWindowFocus");
    L7:
        return r4;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_volcengine_zeus_activity_GenerateProxyActivity_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$001(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$001(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static boolean INVOKEVIRTUAL_com_volcengine_zeus_activity_GenerateProxyActivity_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(GeneratePluginActivity r3) {
        boolean r4 = r3.hasWindowFocus();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "hasWindowFocus");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "hasWindowFocus");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_volcengine_zeus_activity_GenerateProxyActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(GenerateProxyActivity r11) {
        r11.com_volcengine_zeus_activity_GenerateProxyActivity__finish$___twin___();
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

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r1) {
        d.b(this, r1);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public void com_volcengine_zeus_activity_GenerateProxyActivity__onCreate$___twin___(Bundle r1) {
        d.e(this, r1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.dispatchGenericMotionEvent(r2);
    L7:
        return super.dispatchGenericMotionEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.dispatchKeyEvent(r2);
    L7:
        return super.dispatchKeyEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.dispatchKeyShortcutEvent(r2);
    L7:
        return super.dispatchKeyShortcutEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.dispatchPopulateAccessibilityEvent(r2);
    L7:
        return super.dispatchPopulateAccessibilityEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.dispatchTouchEvent(r2);
    L7:
        return super.dispatchTouchEvent(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.dispatchTrackballEvent(r2);
    L7:
        return super.dispatchTrackballEvent(r2);
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(PictureInPictureParams r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.enterPictureInPictureMode(r2);
    L7:
        return super.enterPictureInPictureMode(r2);
    }

    @Override // android.app.Activity
    public View findViewById(int r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.findViewById(r2);
    L7:
        return super.findViewById(r2);
    }

    @Override // android.app.Activity
    public void finishActivity(int r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.finishActivity(r2);
        return;
    L5:
        super.finishActivity(r2);
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.finishFromChild(r2);
        return;
    L5:
        super.finishFromChild(r2);
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getPreferences(r2);
    L7:
        return super.getPreferences(r2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.getSystemService(r2);
    L7:
        return super.getSystemService(r2);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.moveTaskToBack(r2);
    L7:
        return super.moveTaskToBack(r2);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.navigateUpTo(r2);
    L7:
        return super.navigateUpTo(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onActionModeFinished(r2);
        return;
    L5:
        super.onActionModeFinished(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onActionModeStarted(r2);
        return;
    L5:
        super.onActionModeStarted(r2);
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onAttachFragment(r2);
        return;
    L5:
        super.onAttachFragment(r2);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        INVOKEVIRTUAL_com_volcengine_zeus_activity_GenerateProxyActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(r0, r2);
        return;
    L5:
        super.onConfigurationChanged(r2);
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onContextItemSelected(r2);
    L7:
        return super.onContextItemSelected(r2);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onContextMenuClosed(r2);
        return;
    L5:
        super.onContextMenuClosed(r2);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onCreateDialog(r2);
    L7:
        return super.onCreateDialog(r2);
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onCreateNavigateUpTaskStack(r2);
        return;
    L5:
        super.onCreateNavigateUpTaskStack(r2);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onCreateOptionsMenu(r2);
    L7:
        return super.onCreateOptionsMenu(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onCreatePanelView(r2);
    L7:
        return super.onCreatePanelView(r2);
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onGenericMotionEvent(r2);
    L7:
        return super.onGenericMotionEvent(r2);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onMultiWindowModeChanged(r2);
        return;
    L5:
        super.onMultiWindowModeChanged(r2);
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onNavigateUpFromChild(r2);
    L7:
        return super.onNavigateUpFromChild(r2);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onNewIntent(r2);
        return;
    L5:
        super.onNewIntent(r2);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onOptionsItemSelected(r2);
    L7:
        return super.onOptionsItemSelected(r2);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onOptionsMenuClosed(r2);
        return;
    L5:
        super.onOptionsMenuClosed(r2);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onPictureInPictureModeChanged(r2);
        return;
    L5:
        super.onPictureInPictureModeChanged(r2);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onPostCreate(r2);
        return;
    L5:
        super.onPostCreate(r2);
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onPrepareNavigateUpTaskStack(r2);
        return;
    L5:
        super.onPrepareNavigateUpTaskStack(r2);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onPrepareOptionsMenu(r2);
    L7:
        return super.onPrepareOptionsMenu(r2);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onProvideAssistContent(r2);
        return;
    L5:
        super.onProvideAssistContent(r2);
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onProvideAssistData(r2);
        return;
    L5:
        super.onProvideAssistData(r2);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onRestoreInstanceState(r2);
        return;
    L5:
        super.onRestoreInstanceState(r2);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onSaveInstanceState(r2);
    L6:
        ProxyActivityUtilsKt.trimSavedInstanceState(r2);
        return;
    L5:
        super.onSaveInstanceState(r2);
        goto L6
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onSearchRequested(r2);
    L7:
        return super.onSearchRequested(r2);
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onTopResumedActivityChanged(r2);
        return;
    L5:
        super.onTopResumedActivityChanged(r2);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onTouchEvent(r2);
    L7:
        return super.onTouchEvent(r2);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onTrackballEvent(r2);
    L7:
        return super.onTrackballEvent(r2);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onTrimMemory(r2);
        return;
    L5:
        super.onTrimMemory(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onWindowAttributesChanged(r2);
        return;
    L5:
        super.onWindowAttributesChanged(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onWindowFocusChanged(r2);
        return;
    L5:
        super.onWindowFocusChanged(r2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onWindowStartingActionMode(r2);
    L7:
        return super.onWindowStartingActionMode(r2);
    }

    @Override // android.app.Activity
    public void openContextMenu(View r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.openContextMenu(r2);
        return;
    L5:
        super.openContextMenu(r2);
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.registerActivityLifecycleCallbacks(r2);
        return;
    L5:
        super.registerActivityLifecycleCallbacks(r2);
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.registerForContextMenu(r2);
        return;
    L5:
        super.registerForContextMenu(r2);
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.requestDragAndDropPermissions(r2);
    L7:
        return super.requestDragAndDropPermissions(r2);
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.requestVisibleBehind(r2);
    L7:
        return super.requestVisibleBehind(r2);
    }

    @Override // android.app.Activity
    public void setActionBar(Toolbar r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setActionBar(r2);
        return;
    L5:
        super.setActionBar(r2);
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setContentTransitionManager(r2);
        return;
    L5:
        super.setContentTransitionManager(r2);
    }

    @Override // android.app.Activity
    public void setContentView(int r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setContentView(r2);
        return;
    L5:
        super.setContentView(r2);
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(SharedElementCallback r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setEnterSharedElementCallback(r2);
        return;
    L5:
        super.setEnterSharedElementCallback(r2);
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(SharedElementCallback r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setExitSharedElementCallback(r2);
        return;
    L5:
        super.setExitSharedElementCallback(r2);
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setFinishOnTouchOutside(r2);
        return;
    L5:
        super.setFinishOnTouchOutside(r2);
    }

    @Override // android.app.Activity
    public void setImmersive(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setImmersive(r2);
        return;
    L5:
        super.setImmersive(r2);
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setInheritShowWhenLocked(r2);
        return;
    L5:
        super.setInheritShowWhenLocked(r2);
    }

    @Override // android.app.Activity
    public void setIntent(Intent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setIntent(r2);
        return;
    L5:
        super.setIntent(r2);
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(PictureInPictureParams r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setPictureInPictureParams(r2);
        return;
    L5:
        super.setPictureInPictureParams(r2);
    }

    @Override // com.volcengine.zeus.activity.b
    public void setPlugin(Plugin r1) {
        this.mPlugin = r1;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setRequestedOrientation(r2);
        return;
    L5:
        super.setRequestedOrientation(r2);
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setShowWhenLocked(r2);
        return;
    L5:
        super.setShowWhenLocked(r2);
    }

    @Override // com.volcengine.zeus.activity.b
    public void setTargetActivity(IPluginActivity r1) {
        this.mTargetActivity = (GeneratePluginActivity) r1;
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setTaskDescription(r2);
        return;
    L5:
        super.setTaskDescription(r2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setTheme(r2);
        return;
    L5:
        super.setTheme(r2);
    }

    @Override // android.app.Activity
    public void setTitle(int r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setTitle(r2);
        return;
    L5:
        super.setTitle(r2);
    }

    @Override // android.app.Activity
    public void setTitleColor(int r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setTitleColor(r2);
        return;
    L5:
        super.setTitleColor(r2);
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.setTranslucent(r2);
    L7:
        return super.setTranslucent(r2);
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setTurnScreenOn(r2);
        return;
    L5:
        super.setTurnScreenOn(r2);
    }

    @Override // android.app.Activity
    public void setVisible(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setVisible(r2);
        return;
    L5:
        super.setVisible(r2);
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return com_volcengine_zeus_activity_GenerateProxyActivity_com_volcengine_zeus_activity_GeneratePluginActivity_shouldShowRequestPermissionRationale(r0, r2);
    L7:
        return com_volcengine_zeus_activity_GenerateProxyActivity_android_app_Activity_shouldShowRequestPermissionRationale_super(this, r2);
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.shouldUpRecreateTask(r2);
    L7:
        return super.shouldUpRecreateTask(r2);
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.showAssist(r2);
    L7:
        return super.showAssist(r2);
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.startActionMode(r2);
    L7:
        return super.startActionMode(r2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startActivities(r2);
        return;
    L5:
        super.startActivities(r2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startActivity(r2);
        return;
    L5:
        super.startActivity(r2);
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(Bundle r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startLocalVoiceInteraction(r2);
        return;
    L5:
        super.startLocalVoiceInteraction(r2);
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startManagingCursor(r2);
        return;
    L5:
        super.startManagingCursor(r2);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.startNextMatchingActivity(r2);
    L7:
        return super.startNextMatchingActivity(r2);
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.stopManagingCursor(r2);
        return;
    L5:
        super.stopManagingCursor(r2);
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.takeKeyEvents(r2);
        return;
    L5:
        super.takeKeyEvents(r2);
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.unregisterActivityLifecycleCallbacks(r2);
        return;
    L5:
        super.unregisterActivityLifecycleCallbacks(r2);
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.unregisterForContextMenu(r2);
        return;
    L5:
        super.unregisterForContextMenu(r2);
    }

    @Override // com.volcengine.zeus.activity.b
    public void zeusSuperAttachBaseContext(Context r1) {
        super.attachBaseContext(r1);
    }

    public boolean zeusSuperDispatchGenericMotionEvent(MotionEvent r1) {
        return super.dispatchGenericMotionEvent(r1);
    }

    public boolean zeusSuperDispatchKeyEvent(KeyEvent r1) {
        return super.dispatchKeyEvent(r1);
    }

    public boolean zeusSuperDispatchKeyShortcutEvent(KeyEvent r1) {
        return super.dispatchKeyShortcutEvent(r1);
    }

    public boolean zeusSuperDispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
        return super.dispatchPopulateAccessibilityEvent(r1);
    }

    public boolean zeusSuperDispatchTouchEvent(MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    public boolean zeusSuperDispatchTrackballEvent(MotionEvent r1) {
        return super.dispatchTrackballEvent(r1);
    }

    public boolean zeusSuperEnterPictureInPictureMode(PictureInPictureParams r1) {
        return super.enterPictureInPictureMode(r1);
    }

    public View zeusSuperFindViewById(int r1) {
        return super.findViewById(r1);
    }

    public void zeusSuperFinishActivity(int r1) {
        super.finishActivity(r1);
    }

    public void zeusSuperFinishFromChild(Activity r1) {
        super.finishFromChild(r1);
    }

    public SharedPreferences zeusSuperGetPreferences(int r1) {
        return super.getPreferences(r1);
    }

    public Object zeusSuperGetSystemService(String r1) {
        return super.getSystemService(r1);
    }

    public boolean zeusSuperMoveTaskToBack(boolean r1) {
        return super.moveTaskToBack(r1);
    }

    public boolean zeusSuperNavigateUpTo(Intent r1) {
        return super.navigateUpTo(r1);
    }

    public void zeusSuperOnActionModeFinished(ActionMode r1) {
        super.onActionModeFinished(r1);
    }

    public void zeusSuperOnActionModeStarted(ActionMode r1) {
        super.onActionModeStarted(r1);
    }

    public void zeusSuperOnAttachFragment(Fragment r1) {
        super.onAttachFragment(r1);
    }

    public void zeusSuperOnConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    public boolean zeusSuperOnContextItemSelected(MenuItem r1) {
        return super.onContextItemSelected(r1);
    }

    public void zeusSuperOnContextMenuClosed(Menu r1) {
        super.onContextMenuClosed(r1);
    }

    @Override // com.volcengine.zeus.activity.b
    public void zeusSuperOnCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public Dialog zeusSuperOnCreateDialog(int r1) {
        return super.onCreateDialog(r1);
    }

    public void zeusSuperOnCreateNavigateUpTaskStack(TaskStackBuilder r1) {
        super.onCreateNavigateUpTaskStack(r1);
    }

    public boolean zeusSuperOnCreateOptionsMenu(Menu r1) {
        return super.onCreateOptionsMenu(r1);
    }

    public View zeusSuperOnCreatePanelView(int r1) {
        return super.onCreatePanelView(r1);
    }

    public boolean zeusSuperOnGenericMotionEvent(MotionEvent r1) {
        return super.onGenericMotionEvent(r1);
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean r1) {
        super.onMultiWindowModeChanged(r1);
    }

    public boolean zeusSuperOnNavigateUpFromChild(Activity r1) {
        return super.onNavigateUpFromChild(r1);
    }

    public void zeusSuperOnNewIntent(Intent r1) {
        super.onNewIntent(r1);
    }

    public boolean zeusSuperOnOptionsItemSelected(MenuItem r1) {
        return super.onOptionsItemSelected(r1);
    }

    public void zeusSuperOnOptionsMenuClosed(Menu r1) {
        super.onOptionsMenuClosed(r1);
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean r1) {
        super.onPictureInPictureModeChanged(r1);
    }

    public void zeusSuperOnPostCreate(Bundle r1) {
        super.onPostCreate(r1);
    }

    public void zeusSuperOnPrepareNavigateUpTaskStack(TaskStackBuilder r1) {
        super.onPrepareNavigateUpTaskStack(r1);
    }

    public boolean zeusSuperOnPrepareOptionsMenu(Menu r1) {
        return super.onPrepareOptionsMenu(r1);
    }

    public void zeusSuperOnProvideAssistContent(AssistContent r1) {
        super.onProvideAssistContent(r1);
    }

    public void zeusSuperOnProvideAssistData(Bundle r1) {
        super.onProvideAssistData(r1);
    }

    public void zeusSuperOnRestoreInstanceState(Bundle r1) {
        super.onRestoreInstanceState(r1);
    }

    public void zeusSuperOnSaveInstanceState(Bundle r1) {
        super.onSaveInstanceState(r1);
    }

    public boolean zeusSuperOnSearchRequested(SearchEvent r1) {
        return super.onSearchRequested(r1);
    }

    public void zeusSuperOnTopResumedActivityChanged(boolean r1) {
        super.onTopResumedActivityChanged(r1);
    }

    public boolean zeusSuperOnTouchEvent(MotionEvent r1) {
        return super.onTouchEvent(r1);
    }

    public boolean zeusSuperOnTrackballEvent(MotionEvent r1) {
        return super.onTrackballEvent(r1);
    }

    public void zeusSuperOnTrimMemory(int r1) {
        super.onTrimMemory(r1);
    }

    public void zeusSuperOnWindowAttributesChanged(WindowManager.LayoutParams r1) {
        super.onWindowAttributesChanged(r1);
    }

    public void zeusSuperOnWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
    }

    public ActionMode zeusSuperOnWindowStartingActionMode(ActionMode.Callback r1) {
        return super.onWindowStartingActionMode(r1);
    }

    public void zeusSuperOpenContextMenu(View r1) {
        super.openContextMenu(r1);
    }

    public void zeusSuperRegisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks r1) {
        super.registerActivityLifecycleCallbacks(r1);
    }

    public void zeusSuperRegisterForContextMenu(View r1) {
        super.registerForContextMenu(r1);
    }

    public DragAndDropPermissions zeusSuperRequestDragAndDropPermissions(DragEvent r1) {
        return super.requestDragAndDropPermissions(r1);
    }

    public boolean zeusSuperRequestVisibleBehind(boolean r1) {
        return super.requestVisibleBehind(r1);
    }

    public void zeusSuperSetActionBar(Toolbar r1) {
        super.setActionBar(r1);
    }

    public void zeusSuperSetContentTransitionManager(TransitionManager r1) {
        super.setContentTransitionManager(r1);
    }

    public void zeusSuperSetContentView(int r1) {
        super.setContentView(r1);
    }

    public void zeusSuperSetEnterSharedElementCallback(SharedElementCallback r1) {
        super.setEnterSharedElementCallback(r1);
    }

    public void zeusSuperSetExitSharedElementCallback(SharedElementCallback r1) {
        super.setExitSharedElementCallback(r1);
    }

    public void zeusSuperSetFinishOnTouchOutside(boolean r1) {
        super.setFinishOnTouchOutside(r1);
    }

    public void zeusSuperSetImmersive(boolean r1) {
        super.setImmersive(r1);
    }

    public void zeusSuperSetInheritShowWhenLocked(boolean r1) {
        super.setInheritShowWhenLocked(r1);
    }

    public void zeusSuperSetIntent(Intent r1) {
        super.setIntent(r1);
    }

    public void zeusSuperSetPictureInPictureParams(PictureInPictureParams r1) {
        super.setPictureInPictureParams(r1);
    }

    public void zeusSuperSetRequestedOrientation(int r1) {
        super.setRequestedOrientation(r1);
    }

    public void zeusSuperSetShowWhenLocked(boolean r1) {
        super.setShowWhenLocked(r1);
    }

    public void zeusSuperSetTaskDescription(ActivityManager.TaskDescription r1) {
        super.setTaskDescription(r1);
    }

    @Override // com.volcengine.zeus.activity.b
    public void zeusSuperSetTheme(int r1) {
        super.setTheme(r1);
    }

    public void zeusSuperSetTitle(int r1) {
        super.setTitle(r1);
    }

    public void zeusSuperSetTitleColor(int r1) {
        super.setTitleColor(r1);
    }

    public boolean zeusSuperSetTranslucent(boolean r1) {
        return super.setTranslucent(r1);
    }

    public void zeusSuperSetTurnScreenOn(boolean r1) {
        super.setTurnScreenOn(r1);
    }

    public void zeusSuperSetVisible(boolean r1) {
        super.setVisible(r1);
    }

    public boolean zeusSuperShouldShowRequestPermissionRationale(String r1) {
        return com_volcengine_zeus_activity_GenerateProxyActivity_android_app_Activity_shouldShowRequestPermissionRationale_super(this, r1);
    }

    public boolean zeusSuperShouldUpRecreateTask(Intent r1) {
        return super.shouldUpRecreateTask(r1);
    }

    public boolean zeusSuperShowAssist(Bundle r1) {
        return super.showAssist(r1);
    }

    public ActionMode zeusSuperStartActionMode(ActionMode.Callback r1) {
        return super.startActionMode(r1);
    }

    public void zeusSuperStartActivities(Intent[] r1) {
        super.startActivities(r1);
    }

    public void zeusSuperStartActivity(Intent r1) {
        super.startActivity(r1);
    }

    public void zeusSuperStartLocalVoiceInteraction(Bundle r1) {
        super.startLocalVoiceInteraction(r1);
    }

    public void zeusSuperStartManagingCursor(Cursor r1) {
        super.startManagingCursor(r1);
    }

    public boolean zeusSuperStartNextMatchingActivity(Intent r1) {
        return super.startNextMatchingActivity(r1);
    }

    public void zeusSuperStopManagingCursor(Cursor r1) {
        super.stopManagingCursor(r1);
    }

    public void zeusSuperTakeKeyEvents(boolean r1) {
        super.takeKeyEvents(r1);
    }

    public void zeusSuperUnregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks r1) {
        super.unregisterActivityLifecycleCallbacks(r1);
    }

    public void zeusSuperUnregisterForContextMenu(View r1) {
        super.unregisterForContextMenu(r1);
    }

    @Override // android.app.Activity
    public void setContentView(View r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setContentView(r2);
        return;
    L5:
        super.setContentView(r2);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence r2) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setTitle(r2);
        return;
    L5:
        super.setTitle(r2);
    }

    public void zeusSuperSetContentView(View r1) {
        super.setContentView(r1);
    }

    public void zeusSuperSetTitle(CharSequence r1) {
        super.setTitle(r1);
    }

    public static void INVOKEVIRTUAL_com_volcengine_zeus_activity_GenerateProxyActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(GeneratePluginActivity r3, Configuration r4) {
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

    private static boolean com_volcengine_zeus_activity_GenerateProxyActivity_android_app_Activity_shouldShowRequestPermissionRationale_super(Activity r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b("auto_cert_com_volcengine_zeus_activity_GenerateProxyActivity_android_app_Activity_shouldShowRequestPermissionRationale_super");
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
        f06.d r4 = r7.preInvoke(102609, "android/app/Activity", "shouldShowRequestPermissionRationale", r18, r1, "boolean", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Boolean) r4.b).booleanValue();
    L21:
        return super.shouldShowRequestPermissionRationale(r19);
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

    public static void com_volcengine_zeus_activity_GenerateProxyActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(GenerateProxyActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_volcengine_zeus_activity_GenerateProxyActivity__onCreate$___twin___(r2);
    }

    private static boolean com_volcengine_zeus_activity_GenerateProxyActivity_com_volcengine_zeus_activity_GeneratePluginActivity_shouldShowRequestPermissionRationale(GeneratePluginActivity r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b("auto_cert_com_volcengine_zeus_activity_GenerateProxyActivity_com_volcengine_zeus_activity_GeneratePluginActivity_shouldShowRequestPermissionRationale");
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
        f06.d r4 = r7.preInvoke(102609, "com/volcengine/zeus/activity/GeneratePluginActivity", "shouldShowRequestPermissionRationale", r18, r1, "boolean", r11);     // Catch: Exception -> L22
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

    @Override // android.app.Activity
    public void addContentView(View r2, ViewGroup.LayoutParams r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.addContentView(r2, r3);
        return;
    L5:
        super.addContentView(r2, r3);
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity r2, int r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.finishActivityFromChild(r2, r3);
        return;
    L5:
        super.finishActivityFromChild(r2, r3);
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity r2, Intent r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.navigateUpToFromChild(r2, r3);
    L7:
        return super.navigateUpToFromChild(r2, r3);
    }

    @Override // android.app.Activity
    public void onActivityReenter(int r2, Intent r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onActivityReenter(r2, r3);
        return;
    L5:
        super.onActivityReenter(r2, r3);
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(Activity r2, CharSequence r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onChildTitleChanged(r2, r3);
        return;
    L5:
        super.onChildTitleChanged(r2, r3);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r2, PersistableBundle r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onCreate(r2, r3);
        return;
    L5:
        super.onCreate(r2, r3);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int r2, Bundle r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onCreateDialog(r2, r3);
    L7:
        return super.onCreateDialog(r2, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r2, Menu r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onCreatePanelMenu(r2, r3);
    L7:
        return super.onCreatePanelMenu(r2, r3);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap r2, Canvas r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onCreateThumbnail(r2, r3);
    L7:
        return super.onCreateThumbnail(r2, r3);
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal r2, Consumer r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onGetDirectActions(r2, r3);
        return;
    L5:
        super.onGetDirectActions(r2, r3);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r2, KeyEvent r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onKeyDown(r2, r3);
    L7:
        return super.onKeyDown(r2, r3);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int r2, KeyEvent r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onKeyLongPress(r2, r3);
    L7:
        return super.onKeyLongPress(r2, r3);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int r2, KeyEvent r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onKeyShortcut(r2, r3);
    L7:
        return super.onKeyShortcut(r2, r3);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r2, KeyEvent r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onKeyUp(r2, r3);
    L7:
        return super.onKeyUp(r2, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int r2, Menu r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onMenuOpened(r2, r3);
    L7:
        return super.onMenuOpened(r2, r3);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean r2, Configuration r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onMultiWindowModeChanged(r2, r3);
        return;
    L5:
        super.onMultiWindowModeChanged(r2, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r2, Menu r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onPanelClosed(r2, r3);
        return;
    L5:
        super.onPanelClosed(r2, r3);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean r2, Configuration r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onPictureInPictureModeChanged(r2, r3);
        return;
    L5:
        super.onPictureInPictureModeChanged(r2, r3);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle r2, PersistableBundle r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onPostCreate(r2, r3);
        return;
    L5:
        super.onPostCreate(r2, r3);
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int r2, Dialog r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onPrepareDialog(r2, r3);
        return;
    L5:
        super.onPrepareDialog(r2, r3);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle r2, PersistableBundle r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onRestoreInstanceState(r2, r3);
        return;
    L5:
        super.onRestoreInstanceState(r2, r3);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle r2, PersistableBundle r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onSaveInstanceState(r2, r3);
    L6:
        ProxyActivityUtilsKt.trimSavedInstanceState(r2);
        return;
    L5:
        super.onSaveInstanceState(r2, r3);
        goto L6
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence r2, int r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onTitleChanged(r2, r3);
        return;
    L5:
        super.onTitleChanged(r2, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r2, int r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onWindowStartingActionMode(r2, r3);
    L7:
        return super.onWindowStartingActionMode(r2, r3);
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int r2, int r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.overridePendingTransition(r2, r3);
        return;
    L5:
        super.overridePendingTransition(r2, r3);
    }

    @Override // android.app.Activity
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setContentView(r2, r3);
        return;
    L5:
        super.setContentView(r2, r3);
    }

    @Override // android.app.Activity
    public void setLocusContext(LocusId r2, Bundle r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setLocusContext(r2, r3);
        return;
    L5:
        super.setLocusContext(r2, r3);
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean r2, ComponentName r3) throws PackageManager.NameNotFoundException {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.setVrModeEnabled(r2, r3);
        return;
    L5:
        super.setVrModeEnabled(r2, r3);
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback r2, int r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.startActionMode(r2, r3);
    L7:
        return super.startActionMode(r2, r3);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r2, Bundle r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startActivities(r2, r3);
        return;
    L5:
        super.startActivities(r2, r3);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r2, Bundle r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startActivity(r2, r3);
        return;
    L5:
        super.startActivity(r2, r3);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent r2, int r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startActivityForResult(r2, r3);
        return;
    L5:
        super.startActivityForResult(r2, r3);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent r2, int r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.startActivityIfNeeded(r2, r3);
    L7:
        return super.startActivityIfNeeded(r2, r3);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent r2, Bundle r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.startNextMatchingActivity(r2, r3);
    L7:
        return super.startNextMatchingActivity(r2, r3);
    }

    @Override // android.app.Activity
    public void triggerSearch(String r2, Bundle r3) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.triggerSearch(r2, r3);
        return;
    L5:
        super.triggerSearch(r2, r3);
    }

    public void zeusSuperAddContentView(View r1, ViewGroup.LayoutParams r2) {
        super.addContentView(r1, r2);
    }

    public boolean zeusSuperConvertToTranslucent(Activity.TranslucentConversionListener r8, ActivityOptions r9) {
        Method r1 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{INVOKESTATIC_com_volcengine_zeus_activity_GenerateProxyActivity_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.Activity$TranslucentConversionListener"), ActivityOptions.class});     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        return ((Boolean) r1.invoke(this, new Object[]{r8, r9})).booleanValue();
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void zeusSuperFinishActivityFromChild(Activity r1, int r2) {
        super.finishActivityFromChild(r1, r2);
    }

    public boolean zeusSuperNavigateUpToFromChild(Activity r1, Intent r2) {
        return super.navigateUpToFromChild(r1, r2);
    }

    public void zeusSuperOnActivityReenter(int r1, Intent r2) {
        super.onActivityReenter(r1, r2);
    }

    public void zeusSuperOnChildTitleChanged(Activity r1, CharSequence r2) {
        super.onChildTitleChanged(r1, r2);
    }

    public void zeusSuperOnCreate(Bundle r1, PersistableBundle r2) {
        super.onCreate(r1, r2);
    }

    public Dialog zeusSuperOnCreateDialog(int r1, Bundle r2) {
        return super.onCreateDialog(r1, r2);
    }

    public boolean zeusSuperOnCreatePanelMenu(int r1, Menu r2) {
        return super.onCreatePanelMenu(r1, r2);
    }

    public boolean zeusSuperOnCreateThumbnail(Bitmap r1, Canvas r2) {
        return super.onCreateThumbnail(r1, r2);
    }

    public void zeusSuperOnGetDirectActions(CancellationSignal r1, Consumer r2) {
        super.onGetDirectActions(r1, r2);
    }

    public boolean zeusSuperOnKeyDown(int r1, KeyEvent r2) {
        return super.onKeyDown(r1, r2);
    }

    public boolean zeusSuperOnKeyLongPress(int r1, KeyEvent r2) {
        return super.onKeyLongPress(r1, r2);
    }

    public boolean zeusSuperOnKeyShortcut(int r1, KeyEvent r2) {
        return super.onKeyShortcut(r1, r2);
    }

    public boolean zeusSuperOnKeyUp(int r1, KeyEvent r2) {
        return super.onKeyUp(r1, r2);
    }

    public boolean zeusSuperOnMenuOpened(int r1, Menu r2) {
        return super.onMenuOpened(r1, r2);
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean r1, Configuration r2) {
        super.onMultiWindowModeChanged(r1, r2);
    }

    public void zeusSuperOnPanelClosed(int r1, Menu r2) {
        super.onPanelClosed(r1, r2);
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean r1, Configuration r2) {
        super.onPictureInPictureModeChanged(r1, r2);
    }

    public void zeusSuperOnPostCreate(Bundle r1, PersistableBundle r2) {
        super.onPostCreate(r1, r2);
    }

    public void zeusSuperOnPrepareDialog(int r1, Dialog r2) {
        super.onPrepareDialog(r1, r2);
    }

    public void zeusSuperOnRestoreInstanceState(Bundle r1, PersistableBundle r2) {
        super.onRestoreInstanceState(r1, r2);
    }

    public void zeusSuperOnSaveInstanceState(Bundle r1, PersistableBundle r2) {
        super.onSaveInstanceState(r1, r2);
    }

    public void zeusSuperOnTitleChanged(CharSequence r1, int r2) {
        super.onTitleChanged(r1, r2);
    }

    public ActionMode zeusSuperOnWindowStartingActionMode(ActionMode.Callback r1, int r2) {
        return super.onWindowStartingActionMode(r1, r2);
    }

    public void zeusSuperOverridePendingTransition(int r1, int r2) {
        super.overridePendingTransition(r1, r2);
    }

    public void zeusSuperSetContentView(View r1, ViewGroup.LayoutParams r2) {
        super.setContentView(r1, r2);
    }

    public void zeusSuperSetLocusContext(LocusId r1, Bundle r2) {
        super.setLocusContext(r1, r2);
    }

    public void zeusSuperSetVrModeEnabled(boolean r1, ComponentName r2) throws PackageManager.NameNotFoundException {
        super.setVrModeEnabled(r1, r2);
    }

    public ActionMode zeusSuperStartActionMode(ActionMode.Callback r1, int r2) {
        return super.startActionMode(r1, r2);
    }

    public void zeusSuperStartActivities(Intent[] r1, Bundle r2) {
        super.startActivities(r1, r2);
    }

    public void zeusSuperStartActivity(Intent r1, Bundle r2) {
        super.startActivity(r1, r2);
    }

    public void zeusSuperStartActivityForResult(Intent r1, int r2) {
        super.startActivityForResult(r1, r2);
    }

    public boolean zeusSuperStartActivityIfNeeded(Intent r1, int r2) {
        return super.startActivityIfNeeded(r1, r2);
    }

    public boolean zeusSuperStartNextMatchingActivity(Intent r1, Bundle r2) {
        return super.startNextMatchingActivity(r1, r2);
    }

    public void zeusSuperTriggerSearch(String r1, Bundle r2) {
        super.triggerSearch(r1, r2);
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int r2, Intent r3, int r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.createPendingResult(r2, r3, r4);
    L7:
        return super.createPendingResult(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void onActivityResult(int r2, int r3, Intent r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onActivityResult(r2, r3, r4);
        return;
    L5:
        super.onActivityResult(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme r2, int r3, boolean r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onApplyThemeResource(r2, r3, r4);
        return;
    L5:
        super.onApplyThemeResource(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu r2, View r3, ContextMenu.ContextMenuInfo r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onCreateContextMenu(r2, r3, r4);
        return;
    L5:
        super.onCreateContextMenu(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String r2, Context r3, AttributeSet r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onCreateView(r2, r3, r4);
    L7:
        return super.onCreateView(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int r2, int r3, KeyEvent r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onKeyMultiple(r2, r3, r4);
    L7:
        return super.onKeyMultiple(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int r2, Dialog r3, Bundle r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onPrepareDialog(r2, r3, r4);
        return;
    L5:
        super.onPrepareDialog(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r2, View r3, Menu r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onPreparePanel(r2, r3, r4);
    L7:
        return super.onPreparePanel(r2, r3, r4);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List r2, Menu r3, int r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onProvideKeyboardShortcuts(r2, r3, r4);
        return;
    L5:
        super.onProvideKeyboardShortcuts(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        com_volcengine_zeus_activity_GenerateProxyActivity_com_volcengine_zeus_activity_GeneratePluginActivity_onRequestPermissionsResult(r0, r2, r3, r4);
        return;
    L5:
        com_volcengine_zeus_activity_GenerateProxyActivity_android_app_Activity_onRequestPermissionsResult_super(this, r2, r3, r4);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent r2, int r3, Bundle r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startActivityForResult(r2, r3, r4);
        return;
    L5:
        super.startActivityForResult(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity r2, Intent r3, int r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startActivityFromChild(r2, r3, r4);
        return;
    L5:
        super.startActivityFromChild(r2, r3, r4);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment r2, Intent r3, int r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startActivityFromFragment(r2, r3, r4);
        return;
    L5:
        super.startActivityFromFragment(r2, r3, r4);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent r2, int r3, Bundle r4) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.startActivityIfNeeded(r2, r3, r4);
    L7:
        return super.startActivityIfNeeded(r2, r3, r4);
    }

    public PendingIntent zeusSuperCreatePendingResult(int r1, Intent r2, int r3) {
        return super.createPendingResult(r1, r2, r3);
    }

    public void zeusSuperOnActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
    }

    public void zeusSuperOnApplyThemeResource(Resources.Theme r1, int r2, boolean r3) {
        super.onApplyThemeResource(r1, r2, r3);
    }

    public void zeusSuperOnCreateContextMenu(ContextMenu r1, View r2, ContextMenu.ContextMenuInfo r3) {
        super.onCreateContextMenu(r1, r2, r3);
    }

    public View zeusSuperOnCreateView(String r1, Context r2, AttributeSet r3) {
        return super.onCreateView(r1, r2, r3);
    }

    public boolean zeusSuperOnKeyMultiple(int r1, int r2, KeyEvent r3) {
        return super.onKeyMultiple(r1, r2, r3);
    }

    public void zeusSuperOnPrepareDialog(int r1, Dialog r2, Bundle r3) {
        super.onPrepareDialog(r1, r2, r3);
    }

    public boolean zeusSuperOnPreparePanel(int r1, View r2, Menu r3) {
        return super.onPreparePanel(r1, r2, r3);
    }

    public void zeusSuperOnProvideKeyboardShortcuts(List r1, Menu r2, int r3) {
        super.onProvideKeyboardShortcuts(r1, r2, r3);
    }

    public void zeusSuperOnRequestPermissionsResult(int r1, String[] r2, int[] r3) {
        com_volcengine_zeus_activity_GenerateProxyActivity_android_app_Activity_onRequestPermissionsResult_super(this, r1, r2, r3);
    }

    public void zeusSuperStartActivityForResult(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    public void zeusSuperStartActivityFromChild(Activity r1, Intent r2, int r3) {
        super.startActivityFromChild(r1, r2, r3);
    }

    public void zeusSuperStartActivityFromFragment(Fragment r1, Intent r2, int r3) {
        super.startActivityFromFragment(r1, r2, r3);
    }

    public boolean zeusSuperStartActivityIfNeeded(Intent r1, int r2, Bundle r3) {
        return super.startActivityIfNeeded(r1, r2, r3);
    }

    private static void com_volcengine_zeus_activity_GenerateProxyActivity_android_app_Activity_onRequestPermissionsResult_super(Activity r18, int r19, String[] r20, int[] r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19), r20, r21};
        f06.b r11 = new f06.b();
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
        f06.d r4 = r7.preInvoke(102611, "android/app/Activity", "onRequestPermissionsResult", r18, r1, "void", r11);     // Catch: Exception -> L21
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

    private static void com_volcengine_zeus_activity_GenerateProxyActivity_com_volcengine_zeus_activity_GeneratePluginActivity_onRequestPermissionsResult(GeneratePluginActivity r18, int r19, String[] r20, int[] r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19), r20, r21};
        f06.b r11 = new f06.b();
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
        f06.d r4 = r7.preInvoke(102611, "com/volcengine/zeus/activity/GeneratePluginActivity", "onRequestPermissionsResult", r18, r1, "void", r11);     // Catch: Exception -> L21
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

    @Override // android.app.Activity
    public void dump(String r2, FileDescriptor r3, PrintWriter r4, String[] r5) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.dump(r2, r3, r4, r5);
        return;
    L5:
        super.dump(r2, r3, r4, r5);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View r2, String r3, Context r4, AttributeSet r5) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L7;
        return r0.onCreateView(r2, r3, r4, r5);
    L7:
        return super.onCreateView(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String r2, Bundle r3, CancellationSignal r4, Consumer r5) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.onPerformDirectAction(r2, r3, r4, r5);
        return;
    L5:
        super.onPerformDirectAction(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity r2, Intent r3, int r4, Bundle r5) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startActivityFromChild(r2, r3, r4, r5);
        return;
    L5:
        super.startActivityFromChild(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment r2, Intent r3, int r4, Bundle r5) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startActivityFromFragment(r2, r3, r4, r5);
        return;
    L5:
        super.startActivityFromFragment(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    public void startSearch(String r2, boolean r3, Bundle r4, boolean r5) {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startSearch(r2, r3, r4, r5);
        return;
    L5:
        super.startSearch(r2, r3, r4, r5);
    }

    public void zeusSuperDump(String r1, FileDescriptor r2, PrintWriter r3, String[] r4) {
        super.dump(r1, r2, r3, r4);
    }

    public View zeusSuperOnCreateView(View r1, String r2, Context r3, AttributeSet r4) {
        return super.onCreateView(r1, r2, r3, r4);
    }

    public void zeusSuperOnPerformDirectAction(String r1, Bundle r2, CancellationSignal r3, Consumer r4) {
        super.onPerformDirectAction(r1, r2, r3, r4);
    }

    public void zeusSuperStartActivityFromChild(Activity r1, Intent r2, int r3, Bundle r4) {
        super.startActivityFromChild(r1, r2, r3, r4);
    }

    public void zeusSuperStartActivityFromFragment(Fragment r1, Intent r2, int r3, Bundle r4) {
        super.startActivityFromFragment(r1, r2, r3, r4);
    }

    public void zeusSuperStartSearch(String r1, boolean r2, Bundle r3, boolean r4) {
        super.startSearch(r1, r2, r3, r4);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender r7, Intent r8, int r9, int r10, int r11) throws IntentSender.SendIntentException {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startIntentSender(r7, r8, r9, r10, r11);
        return;
    L5:
        super.startIntentSender(r7, r8, r9, r10, r11);
    }

    public void zeusSuperStartIntentSender(IntentSender r1, Intent r2, int r3, int r4, int r5) throws IntentSender.SendIntentException {
        super.startIntentSender(r1, r2, r3, r4, r5);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender r8, Intent r9, int r10, int r11, int r12, Bundle r13) throws IntentSender.SendIntentException {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startIntentSender(r8, r9, r10, r11, r12, r13);
        return;
    L5:
        super.startIntentSender(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender r8, int r9, Intent r10, int r11, int r12, int r13) throws IntentSender.SendIntentException {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startIntentSenderForResult(r8, r9, r10, r11, r12, r13);
        return;
    L5:
        super.startIntentSenderForResult(r8, r9, r10, r11, r12, r13);
    }

    public void zeusSuperStartIntentSender(IntentSender r1, Intent r2, int r3, int r4, int r5, Bundle r6) throws IntentSender.SendIntentException {
        super.startIntentSender(r1, r2, r3, r4, r5, r6);
    }

    public void zeusSuperStartIntentSenderForResult(IntentSender r1, int r2, Intent r3, int r4, int r5, int r6) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(r1, r2, r3, r4, r5, r6);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender r9, int r10, Intent r11, int r12, int r13, int r14, Bundle r15) throws IntentSender.SendIntentException {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startIntentSenderForResult(r9, r10, r11, r12, r13, r14, r15);
        return;
    L5:
        super.startIntentSenderForResult(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity r9, IntentSender r10, int r11, Intent r12, int r13, int r14, int r15) throws IntentSender.SendIntentException {
        GeneratePluginActivity r0 = this.mTargetActivity;
        if (r0 == null) goto L5;
        r0.startIntentSenderFromChild(r9, r10, r11, r12, r13, r14, r15);
        return;
    L5:
        super.startIntentSenderFromChild(r9, r10, r11, r12, r13, r14, r15);
    }

    public void zeusSuperStartIntentSenderForResult(IntentSender r1, int r2, Intent r3, int r4, int r5, int r6, Bundle r7) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(r1, r2, r3, r4, r5, r6, r7);
    }

    public void zeusSuperStartIntentSenderFromChild(Activity r1, IntentSender r2, int r3, Intent r4, int r5, int r6, int r7) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(r1, r2, r3, r4, r5, r6, r7);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity r11, IntentSender r12, int r13, Intent r14, int r15, int r16, int r17, Bundle r18) throws IntentSender.SendIntentException {
        GeneratePluginActivity r1 = this.mTargetActivity;
        if (r1 == null) goto L5;
        r1.startIntentSenderFromChild(r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    L5:
        super.startIntentSenderFromChild(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public void zeusSuperStartIntentSenderFromChild(Activity r1, IntentSender r2, int r3, Intent r4, int r5, int r6, int r7, Bundle r8) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(r1, r2, r3, r4, r5, r6, r7, r8);
    }
}
