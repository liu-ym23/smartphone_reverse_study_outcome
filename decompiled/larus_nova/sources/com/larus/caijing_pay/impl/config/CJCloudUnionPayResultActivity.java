package com.larus.caijing_pay.impl.config;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.api.kvstore.CJKVStoreService;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInCloudUnionPayService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.huawei.hms.android.SystemUtils;
import com.huawei.nfc.sdk.service.HwOpenPayTask;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.unionpay.i;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;
import v19.f;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0014J\"\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0014J \u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u001c\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\nH\u0002J\u0018\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\fH\u0014J\u0010\u0010%\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010&\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/caijing_pay/impl/config/CJCloudUnionPayResultActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "countDownTimer", "Landroid/os/CountDownTimer;", "canClickFinish", "", "isFailDialogShow", "tn", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "dealUserClick", "onResume", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "notifyResult", "result", "onPause", "reportAppInvokeEvent", "isSuccess", "errorCode", "errorMsg", "reportUnionpayFrontCallback", "hasCallbackResult", "reportEvent", "eventName", "params", "isInstalled", LiveCommonConstants.REASON_ON_DEDTROY, "recordResult", "isRepeatTNAndSuccess", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJCloudUnionPayResultActivity extends FlowCommonAppCompatActivity {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f321290k = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f321291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f321292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f321293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f321294j;

    public static final class a {
    }

    public static final class b extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJCloudUnionPayResultActivity f321295a;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            CJCloudUnionPayResultActivity r100 = this.f321295a;
            int r101 = CJCloudUnionPayResultActivity.f321290k;
            r100.N1("fail_timeout_countdown");
            this.f321295a.f321293i = true;
        }

        public b(CJCloudUnionPayResultActivity r100) {
            this.f321295a = r100;
            super(10000, 2000);
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
            if (r100 >= 5000) goto L6;
            this.f321295a.f321292h = true;
            return;
        }
    }

    static {
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(CJCloudUnionPayResultActivity.class.getName()));
    L5:
        super.onDestroy();
        b r100 = this.f321291g;
        if (r100 == null) goto L8;
        r100.cancel();
    L8:
        this.f321294j = "";
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        b r100 = this.f321291g;
        if (r100 == null) goto L6;
        r100.cancel();
    L6:
        if (this.f321293i == true) goto L31;
        JSONObject r101 = new JSONObject();
        int r102 = 1;
        r101.put("result", 1);     // Catch: Throwable -> L20
        ve4.a.f554342a.getClass();     // Catch: Throwable -> L20
        PlugInCloudUnionPayService r103 = (PlugInCloudUnionPayService) ve4.a.a(PlugInCloudUnionPayService.class);     // Catch: Throwable -> L20
        if (r103 == null) goto L11;
        boolean r104 = r103.isInstalled(this);     // Catch: Throwable -> L20
    L12:
        if (r104 == true) goto L15;
        r102 = 0;
    L15:
        r101.put("is_install", r102);     // Catch: Throwable -> L20
        r101.put("error_code", "success");     // Catch: Throwable -> L20
        r101.put("error_message", "");     // Catch: Throwable -> L20
        String r105 = this.f321294j;     // Catch: Throwable -> L20
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        r101.put("orderinfo", r105);     // Catch: Throwable -> L20
        r101.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_POP_TYPE, "");     // Catch: Throwable -> L20
    L22:
        String r106 = r101.toString();
        ve4.a.f554342a.getClass();
        PlugInCloudUnionPayService r107 = (PlugInCloudUnionPayService) ve4.a.a(PlugInCloudUnionPayService.class);
        if (r107 == null) goto L25;
        Object r108 = r107.currentSession();
    L26:
        if (r107 == null) goto L32;
        r107.reportEvent(r108, "wallet_cashier_unionpay_app_invoke", r106);
        return;
    L32:
        return;
    L25:
        r108 = null;
        goto L26
    L11:
        r104 = false;
    L20:
        th = move-exception;
        FLogger.f375446a.e("reportAppInvokeEvent", "reportAppInvokeEvent error: " + th);
        goto L22
    }

    public CJCloudUnionPayResultActivity() {
        this.f321294j = "";
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(CJCloudUnionPayResultActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == c.f346341a) goto L9;
        c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
    }

    public final void N1(String r100) {
        ve4.a.f554342a.getClass();
        PlugInCloudUnionPayService r101 = (PlugInCloudUnionPayService) ve4.a.a(PlugInCloudUnionPayService.class);
        if (r101 == null) goto L5;
        Object r102 = r101.currentSession();
    L6:
        if (r101 == null) goto L8;
        r101.notifyResult(r102, r100);
    L8:
        finish();
        return;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v64, types: [T, java.lang.String] */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r110);
        findViewById(R.id.content).setOnTouchListener(new bx8.a(this));
        b r111 = new b(this);
        this.f321291g = r111;
        r111.start();
        Bundle r112 = getIntent().getExtras();
        String r100 = "";
        if (r112 == null) goto L14;
        String r113 = r112.getString("payData");
        if (r113 == null) goto L14;
    L15:
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = CustomAlbumViewModel.DEFAULT_TAB_ID;
        boolean r102 = false;
        if (r113.length() <= 0) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L22;
        JSONObject r104 = new JSONObject(r113);
        r101.element = r104.optString("__cloud_union_pay_env", CustomAlbumViewModel.DEFAULT_TAB_ID);
        this.f321294j = r104.optString("tn");
    L22:
        if (this.f321294j.length() <= 0) goto L24;
        boolean r114 = true;
    L25:
        if (r114 == false) goto L135;
        ve4.a.f554342a.getClass();
        CJHostService r115 = (CJHostService) ve4.a.a(CJHostService.class);
        if (((CharSequence) r101.element).length() != 0) goto L29;
        boolean r116 = true;
    L30:
        if (r116 == false) goto L32;
        r101.element = CustomAlbumViewModel.DEFAULT_TAB_ID;
    L32:
        SharedPreferences r117 = ((CJKVStoreService) ve4.a.d(CJKVStoreService.class)).getSharedPreference("cj_cloud_union_pay_sp_name", 0);
        String r105 = r117.getString("cj_cloud_union_pay_tn_key", "");
        if (r105 != null) goto L36;
        r105 = "";
    L36:
        if (this.f321294j.length() != 0) goto L38;
        boolean r106 = true;
    L40:
        if (r106 == false) goto L43;
    L51:
        boolean r118 = false;
    L52:
        if (r118 == false) goto L54;
        N1("success");
        return;
    L54:
        String r119 = this.f321294j;
        String r107 = (String) r101.element;
        String r108 = com.unionpay.a.f462126a;
        com.unionpay.a.f462135j = new WeakReference(this);
        com.unionpay.a.f462136k = r119;
        String r120 = null;
        com.unionpay.a.f462137l = null;
        com.unionpay.a.f462138m = null;
        com.unionpay.a.f462139n = r107;
        com.unionpay.a.f462132g = "";
        com.unionpay.a.f462131f = "";
        if (TextUtils.isEmpty("") == false) goto L57;
        com.unionpay.a.f462133h = "0";
    L58:
        com.unionpay.a.f462126a = null;
        com.unionpay.a.f462127b = null;
        com.unionpay.a.f462128c = null;
        com.unionpay.a.f462130e = "";
        WeakReference r109 = com.unionpay.a.f462135j;
        if (r109 != null) goto L61;
        return;
    L61:
        if (r109.get() != null) goto L64;
        return;
    L64:
        if (TextUtils.isEmpty(com.unionpay.a.f462131f) == true) goto L66;
    L69:
        com.unionpay.a.f462134i = true;
        if ("02".equalsIgnoreCase(com.unionpay.a.f462132g) == false) goto L72;
        com.unionpay.a.f462131f = "samsung_out";
    L72:
        com.unionpay.a.f462140o = 0;
        com.unionpay.a.f462141p = false;
        com.unionpay.a.f462142q = false;
        com.unionpay.a.a();     // Catch: Throwable -> L75
    L77:
        String r121 = UPUtils.a(com.unionpay.a.k(), FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY + com.unionpay.a.f462132g);
        String r122 = UPUtils.a(com.unionpay.a.k(), "mode" + com.unionpay.a.f462132g);
        String r123 = UPUtils.a(com.unionpay.a.k(), SRStrategy.KEY_ORIGIN_RESOLUTION + com.unionpay.a.f462132g);
        if (TextUtils.isEmpty(r121) == false) goto L80;
    L142:
        if (TextUtils.isEmpty(com.unionpay.a.f462132g) == false) goto L120;
        JSONArray r124 = new JSONArray(com.unionpay.a.f462145t);     // Catch: Exception -> L125
    L123:
        com.unionpay.a.f462148w = com.unionpay.a.e(r124);     // Catch: Exception -> L125
        goto L126
    L120:
        if ("04".equals(com.unionpay.a.f462132g) == false) goto L122;
        r124 = new JSONArray(com.unionpay.a.f462147v);     // Catch: Exception -> L125
        goto L123
    L122:
        r124 = new JSONArray(com.unionpay.a.f462146u);     // Catch: Exception -> L125
    L126:
        com.unionpay.a.f462144s = new Handler(com.unionpay.a.f462149x);
        if (TextUtils.isEmpty(com.unionpay.a.f462132g) == true) goto L134;
        HashMap r125 = com.unionpay.utils.b.f462195a;
        r102 = SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER);     // Catch: Exception -> L131
    L132:
        if (r102 == false) goto L134;
        HwOpenPayTask r126 = new HwOpenPayTask(com.unionpay.a.k());
        com.unionpay.a.f462144s.sendEmptyMessageDelayed(1004, 1000);
        r126.supportCapacity("UNIONONLINEPAY", new i());
        return;
    L134:
        com.unionpay.a.h("0");
        return;
    L80:
        if (TextUtils.isEmpty(r122) == true) goto L142;
        if (TextUtils.isEmpty(r123) == true) goto L142;
        JSONObject r127 = new JSONObject(r121);     // Catch: Exception -> L137
        String r128 = g.b(r127, "sign");     // Catch: Exception -> L137
        int r129 = CastIntegerProtector.parseInt(r122);     // Catch: Exception -> L86
    L87:
        String r130 = new String(Base64.decode(JSONObjectProtectorUtils.getString(r127, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY), 2));     // Catch: Exception -> L137
        if (r127.has("sePayConf") == false) goto L90;
        String r131 = new String(Base64.decode(JSONObjectProtectorUtils.getString(r127, "sePayConf"), 2));     // Catch: Exception -> L137
    L92:
        if (TextUtils.isEmpty(r131) == true) goto L95;
        r100 = r131;
    L95:
        String r132 = com.unionpay.utils.b.d(UPUtils.b(r130 + r100 + r123));     // Catch: Exception -> L137
        r120 = UPUtils.c(UPUtils.forConfig(r129, r128));     // Catch: Throwable -> L98
    L101:
        if (TextUtils.isEmpty(r120) == true) goto L142;
        if (r120.equals(r132) == false) goto L142;
        if (TextUtils.isEmpty(com.unionpay.a.f462132g) == false) goto L108;
        com.unionpay.a.f462145t = r130;     // Catch: Exception -> L137
    L112:
        if (TextUtils.isEmpty(com.unionpay.a.f462130e) == true) goto L142;
        String r133 = UPUtils.a(com.unionpay.a.k(), "se_configs" + com.unionpay.a.f462130e);     // Catch: Exception -> L137
        if (TextUtils.isEmpty(r133) == true) goto L142;
        com.unionpay.a.i(r133);     // Catch: Exception -> L137
        goto L142
    L108:
        if ("04".equals(com.unionpay.a.f462132g) == false) goto L110;
        com.unionpay.a.f462147v = r130;     // Catch: Exception -> L137
        goto L112
    L110:
        com.unionpay.a.f462146u = r130;     // Catch: Exception -> L137
    L98:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L137
        goto L101
    L90:
        r131 = "";
    L86:
        r129 = 0;
    L75:
        th = move-exception;
        th.printStackTrace();
        goto L77
    L66:
        if (TextUtils.isEmpty(com.unionpay.a.f462132g) == false) goto L69;
        com.unionpay.a.f462134i = false;
        goto L72
    L57:
        com.unionpay.a.f462133h = "1";
        goto L58
    L43:
        if (this.f321294j.equals(r105) == false) goto L51;
        String r134 = r117.getString("cj_cloud_union_pay_result_key", "");
        if (r134 != null) goto L49;
        r134 = "";
    L49:
        if (r134.equals("success") == false) goto L51;
        r118 = true;
        goto L52
    L38:
        r106 = false;
        goto L40
    L29:
        r116 = false;
        goto L30
    L135:
        N1("fail_tn_empty");
        return;
    L24:
        r114 = false;
        goto L25
    L18:
        r103 = false;
    L14:
        r113 = "";
        goto L15
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r102 != null) goto L6;
        finish();
        return;
    L6:
        Bundle r103 = r102.getExtras();
        String r104 = "";
        if (r103 == null) goto L10;
        String r105 = r103.getString("pay_result");
        if (r105 == null) goto L10;
    L11:
        ve4.a r106 = ve4.a.f554342a;
        r106.getClass();
        boolean r107 = false;
        SharedPreferences.Editor r108 = ((CJKVStoreService) ve4.a.d(CJKVStoreService.class)).getSharedPreference("cj_cloud_union_pay_sp_name", 0).edit();
        if (r108 == null) goto L18;
        String r109 = this.f321294j;
        if (r109 == null) goto L17;
        r104 = r109;
    L17:
        r108.putString("cj_cloud_union_pay_tn_key", r104);
    L18:
        if (r108 == null) goto L20;
        r108.putString("cj_cloud_union_pay_result_key", r105);
    L20:
        if (r108 == null) goto L22;
        r108.apply();
    L22:
        JSONObject r110 = new JSONObject();
        r110.put("result", 1);     // Catch: Throwable -> L38
        r106.getClass();     // Catch: Throwable -> L38
        PlugInCloudUnionPayService r111 = (PlugInCloudUnionPayService) ve4.a.a(PlugInCloudUnionPayService.class);     // Catch: Throwable -> L38
        if (r111 == null) goto L26;
        boolean r112 = r111.isInstalled(this);     // Catch: Throwable -> L38
    L27:
        if (r112 == false) goto L29;
        int r113 = 1;
    L30:
        r110.put("is_install", r113);     // Catch: Throwable -> L38
        if (r105.length() != 0) goto L33;
        r107 = true;
    L33:
        if (r107 == false) goto L35;
        String r114 = "no_data";
    L36:
        r110.put("error_code", r114);     // Catch: Throwable -> L38
    L40:
        String r115 = r110.toString();
        ve4.a.f554342a.getClass();
        PlugInCloudUnionPayService r116 = (PlugInCloudUnionPayService) ve4.a.a(PlugInCloudUnionPayService.class);
        if (r116 == null) goto L43;
        Object r117 = r116.currentSession();
    L44:
        if (r116 == null) goto L46;
        r116.reportEvent(r117, "wallet_cashier_unionpay_front_callback", r115);
    L46:
        N1(r105);
        return;
    L43:
        r117 = null;
        goto L44
    L35:
        r114 = r105;
        goto L36
    L29:
        r113 = 0;
        goto L30
    L26:
        r112 = false;
    L38:
        th = move-exception;
        FLogger.f375446a.e("reportUnionpayFrontCallback", "reportUnionpayFrontCallback error: " + th);
    L10:
        r105 = "";
        goto L11
    }
}
