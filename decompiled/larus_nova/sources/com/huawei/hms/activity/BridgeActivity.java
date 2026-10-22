package com.huawei.hms.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.SafeIntent;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import v19.f;

/* JADX INFO: loaded from: classes23.dex */
public class BridgeActivity extends Activity {
    public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
    public static final String EXTRA_DELEGATE_UPDATE_INFO = "intent.extra.update.info";
    public static final String EXTRA_INTENT = "intent.extra.intent";
    public static final String EXTRA_IS_FULLSCREEN = "intent.extra.isfullscreen";
    public static final String EXTRA_RESULT = "intent.extra.RESULT";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f276843b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBridgeActivityDelegate f276844a;

    public class a implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f276845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BridgeActivity f276846b;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_huawei_hms_activity_BridgeActivity$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        public a(BridgeActivity r100, ViewGroup r101) {
            this.f276846b = r100;
            this.f276845a = r101;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View r100, WindowInsets r101) {
            Object r102 = INVOKESTATIC_com_huawei_hms_activity_BridgeActivity$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx").getMethod("getDisplaySideRegion", new Class[]{WindowInsets.class}).invoke(null, new Object[]{r101});     // Catch: IllegalAccessException -> L10 Throwable -> L12 ClassNotFoundException -> L14 InvocationTargetException -> L16
            if (r102 != null) goto L6;
            HMSLog.i("BridgeActivity", "sideRegion is null");     // Catch: IllegalAccessException -> L10 Throwable -> L12 ClassNotFoundException -> L14 InvocationTargetException -> L16
        L20:
        L19:
            return r100.onApplyWindowInsets(r101);
        L6:
            Rect r103 = (Rect) INVOKESTATIC_com_huawei_hms_activity_BridgeActivity$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.android.view.DisplaySideRegionEx").getMethod("getSafeInsets", new Class[0]).invoke(r102, new Object[0]);     // Catch: IllegalAccessException -> L10 Throwable -> L12 ClassNotFoundException -> L14 InvocationTargetException -> L16
            ViewGroup r104 = this.f276845a;     // Catch: IllegalAccessException -> L10 Throwable -> L12 ClassNotFoundException -> L14 InvocationTargetException -> L16
            if (r104 == null) goto L20;
            r104.setPadding(r103.left, 0, r103.right, 0);     // Catch: IllegalAccessException -> L10 Throwable -> L12 ClassNotFoundException -> L14 InvocationTargetException -> L16
        L12:
            e = move-exception;
            HMSLog.e("BridgeActivity", "An exception occurred while reading: onApplyWindowInsets" + e.getMessage());
            goto L19
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public void com_huawei_hms_activity_BridgeActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    public void finish() {
        com_huawei_hms_activity_BridgeActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r100) {
        com_huawei_hms_activity_BridgeActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // android.app.Activity
    public void onStop() {
        com_huawei_hms_activity_BridgeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    static {
        f276843b = a("ro.build.hw_emui_api_level", 0);
    }

    private void e() {
    L9:
        th = move-exception;
        HMSLog.w("BridgeActivity", "requestWindowFeature " + th.getMessage());
        return;
    L4:
        if (getWindow() != null) goto L7;
        HMSLog.w("BridgeActivity", "requestHideTitle, window is null.");     // Catch: Throwable -> L9
        return;
    L7:
        requestWindowFeature(1);     // Catch: Throwable -> L9
    }

    public void com_huawei_hms_activity_BridgeActivity__finish$___twin___() {
        HMSLog.i("BridgeActivity", "Enter finish.");
        super.finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        String r100 = new SafeIntent(getIntent()).getStringExtra(CommonCode.MapKey.TRANSACTION_ID);     // Catch: Throwable -> L5
        ResolutionFlagUtil.getInstance().removeResolutionFlag(r100);     // Catch: Throwable -> L5
    L7:
        IBridgeActivityDelegate r101 = this.f276844a;
        if (r101 == null) goto L10;
        r101.onBridgeActivityDestroy();
    L10:
        HMSLog.i("BridgeActivity", "BridgeActivity onDestroy");
        return;
    L5:
        th = move-exception;
        HMSLog.w("BridgeActivity", "get transaction_id from intent fail: ".concat(th.getClass().getSimpleName()));
        goto L7
    }

    private void a() {
    L8:
        th = move-exception;
        HMSLog.e("BridgeActivity", "finishBridgeActivity has an exception", th);
        throw new IllegalArgumentException("finishBridgeActivity has an exception ", th);
    L3:
        if (isFinishing() == false) goto L5;
        return;
    L5:
        if (isDestroyed() == true) goto L14;
        setResult(1, null);     // Catch: Throwable -> L8
        finish();     // Catch: Throwable -> L8
        return;
    }

    private void b() {
        View r100 = getWindow().findViewById(R.id.content);
        if (r100 != null) goto L5;
    L24:
        HMSLog.e("BridgeActivity", "rootView is null or not ViewGroup");
        return;
    L5:
        if ((r100 instanceof ViewGroup) == false) goto L24;
        ViewGroup r101 = (ViewGroup) r100;
        WindowManager.LayoutParams r102 = getWindow().getAttributes();
        Class r103 = INVOKESTATIC_com_huawei_hms_activity_BridgeActivity_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");     // Catch: Throwable -> L10 InstantiationException -> L12 ClassCastException -> L14 InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20
        r103.getMethod("setDisplaySideMode", new Class[]{Integer.TYPE}).invoke(r103.getDeclaredConstructor(new Class[]{WindowManager.LayoutParams.class}).newInstance(new Object[]{r102}), new Object[]{1});     // Catch: Throwable -> L10 InstantiationException -> L12 ClassCastException -> L14 InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20
    L22:
        INVOKEVIRTUAL_com_huawei_hms_activity_BridgeActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()).setOnApplyWindowInsetsListener(new a(this, r101));
        return;
    L10:
        e = move-exception;
        HMSLog.e("BridgeActivity", "An exception occurred while reading: setDisplaySideMode" + e.getMessage());
        goto L22
    }

    private boolean c() {
        Intent r100 = getIntent();
        if (r100 != null) goto L7;
        HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null intent.");
        return false;
    L7:
        if (r100.getBooleanExtra("intent.extra.isfullscreen", false) == false) goto L35;
        getWindow().setFlags(1024, 1024);
    L35:
        String r101 = r100.getStringExtra(EXTRA_DELEGATE_CLASS_NAME);     // Catch: Throwable -> L20 IllegalStateException -> L22 ClassNotFoundException -> L24 IllegalAccessException -> L26 InstantiationException -> L28 ClassCastException -> L30
        if (r101 == null) goto L18;
        IBridgeActivityDelegate r102 = (IBridgeActivityDelegate) INVOKESTATIC_com_huawei_hms_activity_BridgeActivity_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101).asSubclass(IBridgeActivityDelegate.class).newInstance();     // Catch: Throwable -> L20 IllegalStateException -> L22 ClassNotFoundException -> L24 IllegalAccessException -> L26 InstantiationException -> L28 ClassCastException -> L30
        this.f276844a = r102;     // Catch: Throwable -> L20 IllegalStateException -> L22 ClassNotFoundException -> L24 IllegalAccessException -> L26 InstantiationException -> L28 ClassCastException -> L30
        r102.onBridgeActivityCreate(this);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        HMSLog.e("BridgeActivity", "onBridgeActivityCreate Exception." + th.getMessage());
        return false;
    L18:
        HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null or non class object.");     // Catch: Throwable -> L20 IllegalStateException -> L22 ClassNotFoundException -> L24 IllegalAccessException -> L26 InstantiationException -> L28 ClassCastException -> L30
        return false;
    L30:
        e = e;
    L31:
        HMSLog.e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e.getMessage());
        return false;
    L24:
        e = e;
    L26:
        e = e;
    L22:
        e = e;
    L28:
        e = e;
    L20:
        HMSLog.e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance, throwable occur.");
        return false;
    }

    private void d() {
        e();
        Window r100 = getWindow();
        if (f276843b < 9) goto L5;
        r100.addFlags(67108864);
        a(r100, true);
    L5:
        INVOKEVIRTUAL_com_huawei_hms_activity_BridgeActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setSystemUiVisibility(0);
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        Intent r100 = UIUtil.modifyIntentBehaviorsSafe(super.getIntent());
        if (r100 != null) goto L5;
        return null;
    L5:
        return new SafeIntent(r100);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        HMSLog.e("BridgeActivity", "super.onResume has an exception", th);
        a();
    }

    public BridgeActivity() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_activity_BridgeActivity_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static View INVOKEVIRTUAL_com_huawei_hms_activity_BridgeActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = Thread.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void com_huawei_hms_activity_BridgeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(BridgeActivity r100) {
        r100.com_huawei_hms_activity_BridgeActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_huawei_hms_activity_BridgeActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_huawei_hms_activity_BridgeActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(BridgeActivity r110) {
        r110.com_huawei_hms_activity_BridgeActivity__finish$___twin___();
        if ((r110 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((r110 instanceof ChatWindowActivity) == false) goto L8;
        return;
    L8:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(r110.getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(r110);     // Catch: Throwable -> L53
        if (r103 != null) goto L13;
    L16:
        r102.put(r110, Long.valueOf(r101));     // Catch: Throwable -> L53
        monitor-exit(r102);     // Catch: Throwable -> L53
    L50:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L19:
        if (((FragmentActivity) r110).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r100.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) r110).getLifecycle().getCurrentState());     // Catch: Throwable -> L50
        return;
    L23:
        if (r110.isFinishing() == true) goto L27;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L50
        return;
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(r110) == true) goto L31;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L50
        return;
    L31:
        if (ActivityLancet.isOnlyActivityInTask(r110) == true) goto L35;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L50
        return;
    L35:
        if (ActivityLancet.isExcludedActivity(r110) == false) goto L39;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L50
        return;
    L39:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L41;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L50
        return;
    L41:
        Intent r104 = r110.getPackageManager().getLaunchIntentForPackage(r110.getPackageName());     // Catch: Throwable -> L50
        if (r104 != null) goto L44;
        return;
    L44:
        r104.addFlags(268435456);     // Catch: Throwable -> L50
        r104.addFlags(2097152);     // Catch: Throwable -> L50
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r110);     // Catch: Throwable -> L50
        r110.startActivity(r104);     // Catch: Throwable -> L47
        r110.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L47
    L61:
        return;
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L50
        return;
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    }

    public static void setFullScreenWindowLayoutInDisplayCutout(Window r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 28) goto L7;
        WindowManager.LayoutParams r101 = r100.getAttributes();
        r101.layoutInDisplayCutoutMode = 1;
        r100.setAttributes(r101);
        INVOKEVIRTUAL_com_huawei_hms_activity_BridgeActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setSystemUiVisibility(1280);
        return;
    L7:
        WindowManager.LayoutParams r102 = r100.getAttributes();
        Class r103 = INVOKESTATIC_com_huawei_hms_activity_BridgeActivity_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.android.view.LayoutParamsEx");     // Catch: Throwable -> L10
        Object r104 = r103.getConstructor(new Class[]{WindowManager.LayoutParams.class}).newInstance(new Object[]{r102});     // Catch: Throwable -> L10
        r103.getMethod("addHwFlags", new Class[]{Integer.TYPE}).invoke(r104, new Object[]{65536});     // Catch: Throwable -> L10
        return;
    L10:
        HMSLog.e("BridgeActivity", "com.huawei.android.view.LayoutParamsEx fail");
    }

    public void com_huawei_hms_activity_BridgeActivity__onCreate$___twin___(Bundle r100) {
        e();
        super.onCreate(r100);
        HMSLog.i("BridgeActivity", "BridgeActivity onCreate");
        if (getIntent() != null) goto L6;
        setResult(1, null);
        finish();
        return;
    L6:
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        d();
        b();
        if (ResourceLoaderUtil.getmContext() != null) goto L9;
        ResourceLoaderUtil.setmContext(getApplicationContext());
    L9:
        setFullScreenWindowLayoutInDisplayCutout(getWindow());
        if (c() == true) goto L13;
        setResult(1, null);
        finish();
        return;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        IBridgeActivityDelegate r101 = this.f276844a;
        if (r101 == null) goto L6;
        r101.onBridgeConfigurationChanged();
        return;
    }

    private static void a(Window r100, boolean r101) {
        r100.getClass().getMethod("setHwFloating", new Class[]{Boolean.TYPE}).invoke(r100, new Object[]{Boolean.valueOf(r101)});     // Catch: InvocationTargetException -> L4 IllegalArgumentException -> L6 Throwable -> L8 NoSuchMethodException -> L10
        return;
    L8:
        e = move-exception;
        HMSLog.e("BridgeActivity", "In setHwFloating, Failed to call Window.setHwFloating()." + e.getMessage());
    }

    public static void com_huawei_hms_activity_BridgeActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(BridgeActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r100) == false) goto L8;
        f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.com_huawei_hms_activity_BridgeActivity__onCreate$___twin___(r101);
    }

    public static Intent getIntentStartBridgeActivity(Activity r100, String r101) {
        Intent r102 = new Intent(r100, BridgeActivity.class);
        r102.putExtra(EXTRA_DELEGATE_CLASS_NAME, r101);
        r102.putExtra("intent.extra.isfullscreen", UIUtil.isActivityFullscreen(r100));
        return r102;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r100, KeyEvent r101) {
        IBridgeActivityDelegate r102 = this.f276844a;
        if (r102 == null) goto L6;
        r102.onKeyUp(r100, r101);
    L6:
        return super.onKeyUp(r100, r101);
    }

    private static int a(String r100, int r101) {
        Class r102 = INVOKESTATIC_com_huawei_hms_activity_BridgeActivity_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Throwable -> L4
        return ((Integer) r102.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r102, new Object[]{r100, Integer.valueOf(r101)})).intValue();
    L4:
        HMSLog.e("BridgeActivity", "An exception occurred while reading: EMUI_SDK_INT");
        return r101;
    }

    public static Intent getIntentStartBridgeActivity(Context r100, String r101) {
        Intent r102 = new Intent(r100, BridgeActivity.class);
        r102.putExtra(EXTRA_DELEGATE_CLASS_NAME, r101);
        r102.putExtra("intent.extra.isfullscreen", false);
        return r102;
    }

    @Override // android.app.Activity
    public void onActivityResult(int r100, int r101, Intent r102) {
        SafeIntent r103 = new SafeIntent(r102);
        super.onActivityResult(r100, r101, r103);
        IBridgeActivityDelegate r104 = this.f276844a;
        if (r104 == null) goto L14;
        boolean r105 = r104.onBridgeActivityResult(r100, r101, r103);     // Catch: Throwable -> L6
    L7:
        if (r105 == false) goto L9;
        return;
    L9:
        if (isFinishing() == true) goto L16;
        setResult(r101, UIUtil.modifyIntentBehaviorsSafe(r103));
        finish();
        return;
    L16:
        return;
    L6:
        HMSLog.w("BridgeActivity", "onBridgeActivityResult failed, throwable occur.");
        r105 = false;
        goto L7
    }
}
