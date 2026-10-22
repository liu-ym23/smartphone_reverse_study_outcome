package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.core.app.TaskStackBuilder$SupportParentable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dc9.d;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class AppCompatActivity extends FragmentActivity implements AppCompatCallback, TaskStackBuilder$SupportParentable, ActionBarDrawerToggle$DelegateProvider {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AppCompatDelegate mDelegate;
    private Resources mResources;

    public static /* synthetic */ void access$000(FragmentActivity r0, Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    public void androidx_appcompat_app_AppCompatActivity__finish$___twin___() {
        super.finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        androidx_appcompat_app_AppCompatActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        androidx_appcompat_app_AppCompatActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    public void onNightModeChanged(int r1) {
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder r1) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode r1) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode r1) {
    }

    public void onSupportContentChanged() {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback r1) {
        return null;
    }

    public void setSupportProgress(int r1) {
    }

    public void setSupportProgressBarIndeterminate(boolean r1) {
    }

    public void setSupportProgressBarIndeterminateVisibility(boolean r1) {
    }

    public void setSupportProgressBarVisibility(boolean r1) {
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate != null) goto L6;
        this.mDelegate = AppCompatDelegate.create(this, this);
    L6:
        return this.mDelegate;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mResources == null) goto L5;
    L7:
        Resources r0 = this.mResources;
        if (r0 == null) goto L10;
        return r0;
    L10:
        return super.getResources();
    L5:
        if (VectorEnabledTintResources.shouldBeUsed() == false) goto L7;
        this.mResources = new VectorEnabledTintResources(this, super.getResources());
        goto L7
    }

    public AppCompatActivity() {
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().registerSavedStateProvider(DELEGATE_TAG, new 1(this));
        addOnContextAvailableListener(new 2(this));
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
        ViewTreeViewModelStoreOwner.set(INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
        ViewTreeSavedStateRegistryOwner.set(INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
    }

    public void androidx_appcompat_app_AppCompatActivity__onDestroy$___twin___() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar r0 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r0 != null) goto L6;
    L7:
        super.closeOptionsMenu();
        return;
    L6:
        if (r0.closeOptionsMenu() == false) goto L7;
        return;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle$DelegateProvider
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return getDelegate().getDrawerToggleDelegate();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    @Override // androidx.core.app.TaskStackBuilder$SupportParentable
    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getDelegate().onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    public boolean onSupportNavigateUp() {
        Intent r0 = getSupportParentActivityIntent();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (supportShouldUpRecreateTask(r0) == false) goto L10;
        TaskStackBuilder r1 = TaskStackBuilder.create(this);
        onCreateSupportNavigateUpTaskStack(r1);
        onPrepareSupportNavigateUpTaskStack(r1);
        r1.startActivities();
        ActivityCompat.finishAffinity(this);     // Catch: IllegalStateException -> L9
        return true;
    L9:
        finish();
        return true;
    L10:
        supportNavigateUpTo(r0);
        return true;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar r0 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r0 != null) goto L6;
    L7:
        super.openOptionsMenu();
        return;
    L6:
        if (r0.openOptionsMenu() == false) goto L7;
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public AppCompatActivity(int r1) {
        super(r1);
        initDelegate();
    }

    public static View INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static void androidx_appcompat_app_AppCompatActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(AppCompatActivity r11) {
        r11.androidx_appcompat_app_AppCompatActivity__finish$___twin___();
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

    public static void androidx_appcompat_app_AppCompatActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(AppCompatActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.androidx_appcompat_app_AppCompatActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    private boolean performMenuItemShortcut(KeyEvent r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return false;
    L5:
        if (r3.isCtrlPressed() == false) goto L7;
        return false;
    L7:
        if (KeyEvent.metaStateHasNoModifiers(r3.getMetaState()) == false) goto L9;
        return false;
    L9:
        if (r3.getRepeatCount() == 0) goto L11;
        return false;
    L11:
        if (KeyEvent.isModifierKey(r3.getKeyCode()) == true) goto L25;
        Window r0 = getWindow();
        if (r0 != null) goto L15;
        return false;
    L15:
        if (INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r0) != null) goto L17;
        return false;
    L17:
        if (INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r0).dispatchKeyShortcutEvent(r3) == false) goto L28;
        return true;
    L28:
        return false;
    L25:
        return false;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r2) {
        super.attachBaseContext(getDelegate().attachBaseContext2(r2));
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r4) {
        int r0 = r4.getKeyCode();
        ActionBar r1 = getSupportActionBar();
        if (r0 != 82) goto L10;
        if (r1 == null) goto L10;
        if (r1.onMenuKeyEvent(r4) == false) goto L10;
        return true;
    L10:
        return super.dispatchKeyEvent(r4);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int r2) {
        return (T) getDelegate().findViewById(r2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r3) {
        INVOKESPECIAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r3);
        if (this.mResources == null) goto L5;
        DisplayMetrics r0 = INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(super.getResources());
        this.mResources.updateConfiguration(r3, r0);
    L5:
        getDelegate().onConfigurationChanged(r3);
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder r1) {
        r1.addParentStack(this);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle r2) {
        super.onPostCreate(r2);
        getDelegate().onPostCreate(r2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int r2) {
        initViewTreeOwners();
        getDelegate().setContentView(r2);
    }

    public void setSupportActionBar(Toolbar r2) {
        getDelegate().setSupportActionBar(r2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int r2) {
        super.setTheme(r2);
        getDelegate().setTheme(r2);
    }

    public ActionMode startSupportActionMode(ActionMode.Callback r2) {
        return getDelegate().startSupportActionMode(r2);
    }

    public void supportNavigateUpTo(Intent r1) {
        NavUtils.navigateUpTo(this, r1);
    }

    public boolean supportRequestWindowFeature(int r2) {
        return getDelegate().requestWindowFeature(r2);
    }

    public boolean supportShouldUpRecreateTask(Intent r1) {
        return NavUtils.shouldUpRecreateTask(this, r1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r2) {
        initViewTreeOwners();
        getDelegate().setContentView(r2);
    }

    public static void INVOKESPECIAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(FragmentActivity r3, Configuration r4) {
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View r2, ViewGroup.LayoutParams r3) {
        initViewTreeOwners();
        getDelegate().addContentView(r2, r3);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r2, KeyEvent r3) {
        if (performMenuItemShortcut(r3) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int r2, MenuItem r3) {
        if (super.onMenuItemSelected(r2, r3) == false) goto L6;
        return true;
    L6:
        ActionBar r4 = getSupportActionBar();
        if (r3.getItemId() != 16908332) goto L13;
        if (r4 != null) goto L10;
        return false;
    L10:
        if ((r4.getDisplayOptions() & 4) != 0) goto L12;
        return false;
    L12:
        return onSupportNavigateUp();
    L13:
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int r1, Menu r2) {
        return super.onMenuOpened(r1, r2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r1, Menu r2) {
        super.onPanelClosed(r1, r2);
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence r1, int r2) {
        super.onTitleChanged(r1, r2);
        getDelegate().setTitle(r1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        initViewTreeOwners();
        getDelegate().setContentView(r2, r3);
    }
}
