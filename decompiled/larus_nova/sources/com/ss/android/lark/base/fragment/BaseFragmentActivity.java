package com.ss.android.lark.base.fragment;

import android.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.window.embedding.ActivityFilter;
import androidx.window.embedding.ActivityRule;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larksuite.component.air.WindowInsetsCompatAirActivity;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.RomUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.b0;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.activity.ActivityAnimationManager;
import com.ss.android.lark.base.embedded.LKSplitController;
import com.ss.android.lark.base.embedded.d;
import com.ss.android.lark.base.embedded.g;
import com.ss.android.lark.base.watermark.IWatermarkable;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.forsetiutils.ForsetiEmbeddedUtils;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.h;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.slideback.b;
import com.ss.android.lark.utils.CarUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import uwa.c;
import v19.f;

/* JADX INFO: loaded from: classes34.dex */
public abstract class BaseFragmentActivity extends WindowInsetsCompatAirActivity implements IWatermarkable, gib.a {
    private static final String FONT_TAG = "BaseFragmentActivity";
    private static final String IS_SAVE_SYSTEM_FONT_SCALE_FLAG = "isSaveSystemFontScaleFlag";
    public static final String KEY_TRANSITION = "transition";
    private static final Object PRESENT = null;
    protected String PARENT_TAG;
    private d embeddedController;
    private boolean enableColorNavigationBar;
    private boolean enableFragmentSavedStateRemoval;
    private g.b forsetiParams;
    private boolean isShowBlackOnWhiteStatusBar;
    protected Bundle mBundle;
    protected CallbackManager mCallbackManager;
    private b mSlideHelper;
    private Map<a, Object> mUserInteractionListeners;
    private g screenOrientationEvaluator;
    public boolean useDefaultAnimation;

    public interface a {
        void a();
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ void access$001(WindowInsetsCompatAirActivity r100, Configuration r101) {
        super.onConfigurationChanged(r101);
    }

    public static /* synthetic */ void access$002(WindowInsetsCompatAirActivity r100, BroadcastReceiver r101) {
        super.unregisterReceiver(r101);
    }

    public void disableBlackStatusBarBeforeOnCreate() {
        this.isShowBlackOnWhiteStatusBar = false;
    }

    public void disableColorNavigationBarBeforeOnCreate() {
        this.enableColorNavigationBar = false;
    }

    public void disableFragmentSavedStateRemoval() {
        this.enableFragmentSavedStateRemoval = false;
    }

    @Override // com.ss.android.lark.base.watermark.IWatermarkable
    public boolean enableGlobalWatermark() {
        return true;
    }

    @Override // com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_ss_android_lark_base_fragment_BaseFragmentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // com.ss.android.lark.base.watermark.IWatermarkable
    public int getWatermarkMode() {
        return 0;
    }

    public boolean isNeedLoginStatus() {
        return true;
    }

    public boolean isSlideEnable() {
        return false;
    }

    @Override // com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        com_ss_android_lark_base_fragment_BaseFragmentActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_ss_android_lark_base_fragment_BaseFragmentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    static {
        PRESENT = new Object();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private void initWindow() {
        if (Build.VERSION.SDK_INT > 23) goto L6;
        return;
    L6:
        if (((ViewGroup) getWindow().findViewById(R.id.content)) == null) goto L8;
        return;
    L8:
        StringBuilder r100 = new StringBuilder("start fix find contentParent by id npe\n");
        Window r101 = getWindow();     // Catch: Throwable -> L15
        Field r102 = b0.a(INVOKESTATIC_com_ss_android_lark_base_fragment_BaseFragmentActivity_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.policy.PhoneWindow"), "mContentParent");     // Catch: Throwable -> L15
        r102.setAccessible(true);     // Catch: Throwable -> L15
        ViewGroup r103 = (ViewGroup) r102.get(r101);     // Catch: Throwable -> L15
        if (r103 == null) goto L12;
        r103.setId(R.id.content);     // Catch: Throwable -> L15
        r100.append("fix success!\n");     // Catch: Throwable -> L15
    L13:
        Log.e("FixContentParentNpe", new Exception(r100.toString()), true);     // Catch: Throwable -> L15
        return;
    L12:
        r100.append("contentParent is null\n");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r100.append("fix failed!\n");
        r100.append(th.getMessage());
        Log.e("FixContentParentNpe", new Exception(r100.toString()), true);
    }

    public void com_ss_android_lark_base_fragment_BaseFragmentActivity__onDestroy$___twin___() {
        this.mCallbackManager.cancelCallbacks();
        d r100 = this.embeddedController;
        if (r100.f409750b.e() == false) goto L5;
        r100.f409750b.f(r100.f409751c);
    L5:
        super.onDestroy();
    }

    public ActivityAnimationManager.AnimationConfig getEnterAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_SLIDE_RIGHT_IN);
    }

    public ActivityAnimationManager.AnimationConfig getExitAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_SLIDE_RIGHT_OUT);
    }

    public BaseFragmentActivity() {
        this.mUserInteractionListeners = new ConcurrentHashMap();
        this.useDefaultAnimation = true;
        this.mCallbackManager = new CallbackManager();
        this.isShowBlackOnWhiteStatusBar = true;
        this.enableColorNavigationBar = true;
        this.enableFragmentSavedStateRemoval = true;
    }

    private void setupTransition() {
        getWindow().requestFeature(13);
        if (getIntent().getBooleanExtra("transition", false) == false) goto L6;
        this.useDefaultAnimation = false;
        ActivityAnimationManager.doAnimationWithDefault(this, new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_HOLD), null);
        return;
    }

    public void com_ss_android_lark_base_fragment_BaseFragmentActivity__finish$___twin___() {
        super.finish();
        if (isDoAnimationWithDefault() == false) goto L6;
        ActivityAnimationManager.doAnimationWithDefault(this, getExitAnimationConfig(), new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_SLIDE_LEFT_OUT));
        return;
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        uwa.a.InterfaceC7940a r100 = uwa.a.a();
        Intent r101 = super.getIntent();
        if (r100 == null) goto L5;
        r101 = r100.injectGetIntent(super.getIntent());
    L5:
        setIntent(r101);
        return r101;
    }

    @Override // com.larksuite.component.air.WindowInsetsCompatAirActivity
    public void initDefaultNavBarColor() {
        h r100 = WindowInsetsUtils.c(this);
        if (this.enableColorNavigationBar == false) goto L6;
        r100.i(UIUtils.getColor(this, com.larus.nova.R.color.bg_body));
        return;
    }

    @Override // com.larksuite.component.air.WindowInsetsCompatAirActivity
    public void initDefaultStatusBarColor() {
        h r100 = WindowInsetsUtils.c(this);
        if (this.isShowBlackOnWhiteStatusBar == false) goto L6;
        r100.b(UIUtils.getColor(this, com.larus.nova.R.color.bg_body));
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (isActivityRunning(this) == false) goto L11;
        super.onBackPressed();     // Catch: IllegalStateException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        finishAfterTransition();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        uwa.a.InterfaceC7940a r100 = uwa.a.a();
        if (r100 == null) goto L6;
        r100.afterOnPause(this);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        uwa.a.InterfaceC7940a r100 = uwa.a.a();
        if (r100 == null) goto L6;
        r100.afterOnResume(this);
        return;
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        super.onUserInteraction();
        Iterator<a> r100 = this.mUserInteractionListeners.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().a();
        goto L4
    }

    public CallbackManager getCallbackManager() {
        return this.mCallbackManager;
    }

    public boolean isDoAnimationWithDefault() {
        return this.useDefaultAnimation;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_lark_base_fragment_BaseFragmentActivity_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void com_ss_android_lark_base_fragment_BaseFragmentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(BaseFragmentActivity r110) {
        r110.com_ss_android_lark_base_fragment_BaseFragmentActivity__finish$___twin___();
        if ((r110 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(r110.getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(r110);     // Catch: Throwable -> L50
        if (r103 != null) goto L10;
    L13:
        r102.put(r110, Long.valueOf(r101));     // Catch: Throwable -> L50
        monitor-exit(r102);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r110.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r100.i("ActivityLancet", "quit !resume, current state = " + r110.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r110.isFinishing() == true) goto L24;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r110) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r110) == true) goto L32;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r110) == false) goto L36;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r104 = r110.getPackageManager().getLaunchIntentForPackage(r110.getPackageName());     // Catch: Throwable -> L47
        if (r104 != null) goto L41;
        return;
    L41:
        r104.addFlags(268435456);     // Catch: Throwable -> L47
        r104.addFlags(2097152);     // Catch: Throwable -> L47
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r110);     // Catch: Throwable -> L47
        r110.startActivity(r104);     // Catch: Throwable -> L44
        r110.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    public static void com_ss_android_lark_base_fragment_BaseFragmentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(BaseFragmentActivity r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L7:
        r100.com_ss_android_lark_base_fragment_BaseFragmentActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r100) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r100);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r100.getClass().getName()));
        goto L7
    }

    private static boolean isActivityRunning(Activity r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isDestroyed() == false) goto L8;
        return false;
    L8:
        if (r100.isFinishing() == true) goto L12;
        return true;
    L12:
        return false;
    }

    private void setStatusBarColor(int r100) {
        WindowInsetsUtils.c(this).b(r100);
    }

    public void addUserInteractionListener(a r100) {
        this.mUserInteractionListeners.put(r100, PRESENT);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r100) {
        uwa.a.InterfaceC7940a r101 = uwa.a.a();
        if (r101 == null) goto L5;
        r100 = r101.injectBaseContext(r100);
    L5:
        Log.d(FONT_TAG, "now, system font scale is " + r100.getResources().getConfiguration().fontScale);
        super.attachBaseContext(r100);
    }

    @Override // gib.a
    public void clearExternalRequestedOrientation(Fragment r100) {
        g r101 = this.screenOrientationEvaluator;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        r101.f409759d.remove(r100);
        if (CarUtils.c() == true) goto L11;
        Collection<Integer> r102 = r101.f409759d.values();
        if (r102.isEmpty() == true) goto L8;
        r101.a(r102.iterator().next().intValue());
        return;
    L8:
        r101.a(r101.f409758c);
        return;
    }

    public void com_ss_android_lark_base_fragment_BaseFragmentActivity__onCreate$___twin___(Bundle r110) {
        if (DevEnvUtil.isDebugMode(getApplicationContext()) == false) goto L6;
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedRegistrationObjects().detectActivityLeaks().penaltyLog().build());
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
    L6:
        if (this.enableFragmentSavedStateRemoval == false) goto L11;
        if (r110 == null) goto L11;
        Bundle r100 = r110.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        if (r100 == null) goto L11;
        r100.remove("android:support:fragments");
    L11:
        setupTransition();
        super.onCreate(r110);
        if (isDoAnimationWithDefault() == true) goto L14;
    L16:
        if (r110 != null) goto L18;
        r110 = getIntent().getExtras();
    L18:
        this.mBundle = r110;
        if (r110 != null) goto L22;
        this.mBundle = new Bundle();
    L22:
        if (Build.VERSION.SDK_INT >= 26) goto L24;
        disableColorNavigationBarBeforeOnCreate();
    L24:
        setupWindowInsets();
        uwa.a.InterfaceC7940a r111 = uwa.a.a();
        if (r111 == null) goto L27;
        r111.afterOnCreate(this, isNeedLoginStatus());
    L27:
        this.embeddedController = new d(this);
        Lazy r101 = ForsetiConfig.f424749a;
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = true;
        if (ForsetiConfig.b() == true) goto L30;
        boolean r103 = false;
    L49:
        Lazy r104 = ForsetiEmbeddedUtils.f424756a;
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (((Boolean) ForsetiEmbeddedUtils.f424757b.getValue()).booleanValue() == false) goto L52;
    L55:
        this.forsetiParams = new g.b(r103, r102, ForsetiEmbeddedUtils.c());
        g r112 = new g(this, this.forsetiParams);
        this.screenOrientationEvaluator = r112;
        r112.b(r112.f409756a.getResources().getConfiguration());
        this.screenOrientationEvaluator.f409758c = getRequestedOrientation();
        return;
    L52:
        if (ForsetiEmbeddedUtils.g(this) == true) goto L55;
        r102 = false;
        goto L55
    L30:
        boolean r105 = FeatureGatingModule.getFeatureGatingService().isEnable("lark.navigation.optimize_huawei_pad_full_screen_disabled");
        boolean r106 = FeatureGatingModule.getFeatureGatingService().isEnable("lark.navigation.optimize_huawei_pad_full_screen_triple_fold_disabled");
        boolean r107 = FeatureGatingModule.getFeatureGatingService().isEnable("lark.navigation.optimize_huawei_car_full_screen_disabled");
        if (r105 == true) goto L40;
        Lazy r108 = ForsetiEmbeddedUtils.f424756a;
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (((Boolean) ForsetiEmbeddedUtils.f424757b.getValue()).booleanValue() == false) goto L35;
    L38:
        boolean r109 = true;
    L39:
        if (r109 == false) goto L40;
    L46:
        r103 = true;
    L48:
        Log.i("ForsetiConfig", "optimizeHuaweiPadFullScreen: " + r103 + ", disabled = " + r105 + ", disabledTripleFold = " + r106 + ", disabledHuaweiCar = " + r107);
        goto L49
    L35:
        if (ForsetiEmbeddedUtils.g(this) == true) goto L38;
        r109 = false;
    L40:
        if (r106 == false) goto L42;
    L43:
        if (r107 == false) goto L45;
    L47:
        r103 = false;
        goto L48
    L45:
        if (ForsetiEmbeddedUtils.g(this) == false) goto L47;
    L42:
        if (ForsetiEmbeddedUtils.c() == true) goto L46;
    L14:
        if (this.useDefaultAnimation == false) goto L16;
        ActivityAnimationManager.doAnimationWithDefault(this, getEnterAnimationConfig(), new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_SLIDE_RIGHT_IN));
        goto L16
    }

    @Override // gib.a
    public int getExternalRequestedOrientation(Fragment r100) {
        g r101 = this.screenOrientationEvaluator;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        if (CarUtils.c() == true) goto L10;
        Integer r102 = r101.f409759d.get(r100);
        if (r102 == null) goto L9;
        return r102.intValue();
    L9:
        return r101.f409756a.getRequestedOrientation();
    L10:
        return r101.f409756a.getRequestedOrientation();
    }

    @Override // com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        INVOKESPECIAL_com_ss_android_lark_base_fragment_BaseFragmentActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r100);
        g r101 = this.screenOrientationEvaluator;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        r101.b(r100);
    }

    @Override // com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle r100) {
        super.onPostCreate(r100);
        setSlideEnable(isSlideEnable());
    }

    public Bundle parseArguments(Intent r100) {
        if (r100 != null) goto L6;
        return Bundle.EMPTY;
    L6:
        if (r100.getExtras() != null) goto L10;
        return Bundle.EMPTY;
    L10:
        return r100.getExtras();
    }

    public void removeUserInteractionListener(a r100) {
        this.mUserInteractionListeners.remove(r100);
    }

    public void setDarkTextStatusBar(int r100) {
        if (uwa.a.f551951a == null) goto L5;
    L14:
        uwa.a.f551951a.getClass();
        Intrinsics.checkNotNullParameter(this, "activity");
        if (RomUtils.l(true, this, getWindow()) == false) goto L20;
        WindowInsetsUtils.c(this).b(r100);
        return;
    L20:
        return;
    L5:
        monitor-enter(uwa.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (uwa.a.f551951a != null) goto L9;
        uwa.a.f551951a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(uwa.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    public void setLightTextStatusBar(int r100) {
        if (uwa.a.f551951a == null) goto L5;
    L14:
        uwa.a.f551951a.getClass();
        Intrinsics.checkNotNullParameter(this, "activity");
        if (RomUtils.l(false, this, getWindow()) == false) goto L20;
        WindowInsetsUtils.c(this).b(r100);
        return;
    L20:
        return;
    L5:
        monitor-enter(uwa.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (uwa.a.f551951a != null) goto L9;
        uwa.a.f551951a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(uwa.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int r100) {
        g r101 = this.screenOrientationEvaluator;
        if (r101.f409760e == true) goto L5;
        r101.f409758c = r100;
    L5:
        Log.i(this.PARENT_TAG, "setRequestedOrientation: " + r100);
        super.setRequestedOrientation(r100);
    }

    public void setSlideEnable(boolean r100) {
        if (r100 == true) goto L4;
        return;
    L4:
        if (this.mSlideHelper != null) goto L8;
        this.mSlideHelper = new b(this);
        return;
    }

    public void setStatusBarByParseColor(int r100) {
        setStatusBarColor(r100);
    }

    public void setStatusBarColorResource(int r100) {
        setStatusBarColor(UIUtils.getColor(this, r100));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection r100) {
        super.unbindService(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r101 = this.PARENT_TAG;
        if (this.PARENT_TAG != null) goto L8;
        r101 = FONT_TAG;
    L8:
        Log.e(r101, e.getMessage());
        e.printStackTrace();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver r100) {
        INVOKESPECIAL_com_ss_android_lark_base_fragment_BaseFragmentActivity_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this, r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r101 = this.PARENT_TAG;
        if (this.PARENT_TAG != null) goto L8;
        r101 = FONT_TAG;
    L8:
        Log.e(r101, e.getMessage());
        e.printStackTrace();
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKESPECIAL_com_ss_android_lark_base_fragment_BaseFragmentActivity_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(WindowInsetsCompatAirActivity r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        access$002(r100, r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        access$002(r100, r101);     // Catch: Exception -> L8
        return;
    }

    public static void INVOKESPECIAL_com_ss_android_lark_base_fragment_BaseFragmentActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(WindowInsetsCompatAirActivity r100, Configuration r101) {
        access$001(r100, r101);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L22;
        int r102 = r100.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r101 == null) goto L8;
        Integer r103 = Integer.valueOf(r101.orientation);     // Catch: Throwable -> L17
    L9:
        if (r103 != null) goto L12;
    L14:
        if (r102 != 3) goto L24;
        r100.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:" + r100.getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r103.intValue() != r102) goto L14;
        return;
    L8:
        r103 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    public static void com_ss_android_lark_base_fragment_BaseFragmentActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(BaseFragmentActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r100) == false) goto L8;
        f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.com_ss_android_lark_base_fragment_BaseFragmentActivity__onCreate$___twin___(r101);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r100, KeyEvent r101) {
        uwa.a.InterfaceC7940a r102 = uwa.a.a();
        if (r102 == null) goto L9;
        if (r102.onDetectKeyEvent(this, r101) == true) goto L9;
        return super.onKeyUp(r100, r101);
    L9:
        return super.onKeyUp(r100, r101);
    }

    @Override // gib.a
    public void setExternalRequestedOrientation(Fragment r100, int r101) {
        g r102 = this.screenOrientationEvaluator;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        if (CarUtils.c() == true) goto L7;
        Integer r103 = Integer.valueOf(r101);
        r102.f409759d.put(r100, r103);
        r102.a(r101);
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r100, int r101, Bundle r102) {
        d r103 = this.embeddedController;
        r103.getClass();
        if (r101 == (-1)) goto L13;
        ComponentName r104 = r100.getComponent();
        if (r104 == null) goto L13;
        PackageManager r105 = r103.f409749a.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L15
        ActivityInfo r106 = r105.getActivityInfo(r104, 0);     // Catch: PackageManager.NameNotFoundException -> L15
        ApplicationInfo r107 = r105.getApplicationInfo(r103.f409749a.getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L15
        if (TextUtils.equals(r106.processName, r107.processName) == false) goto L13;
        LinkedHashSet r108 = new LinkedHashSet(1);     // Catch: PackageManager.NameNotFoundException -> L15
        r108.add(new ActivityFilter(r104, null));     // Catch: PackageManager.NameNotFoundException -> L15
        ActivityRule r109 = new ActivityRule(r108, true);     // Catch: PackageManager.NameNotFoundException -> L15
        LKSplitController r110 = r103.f409750b;     // Catch: PackageManager.NameNotFoundException -> L15
        r110.getClass();     // Catch: PackageManager.NameNotFoundException -> L15
        Intrinsics.checkNotNullParameter(r109, com.heytap.mcssdk.constant.b.f276366p);     // Catch: PackageManager.NameNotFoundException -> L15
        if (LKSplitController.f409741d == false) goto L12;
        r110.c().registerRule(r109);     // Catch: PackageManager.NameNotFoundException -> L15
    L12:
        r103.f409749a.getApplication().registerActivityLifecycleCallbacks(new com.ss.android.lark.base.embedded.c(r104, r109));     // Catch: PackageManager.NameNotFoundException -> L15
    L13:
        super.startActivityForResult(r100, r101, r102);
    }
}
