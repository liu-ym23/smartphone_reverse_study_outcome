package com.huawei.hms.hwid.internal.ui.activity;

import android.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.hwid.ao;
import com.huawei.hms.hwid.ar;
import com.huawei.hms.hwid.as;
import com.huawei.hms.hwid.f;
import com.huawei.hms.hwid.q;
import com.huawei.hms.hwid.s;
import com.huawei.hms.hwid.y;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.api.entity.hwid.HuaweiIdSignInRequest;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService;
import com.huawei.hms.ui.SafeIntent;
import com.huawei.hms.utils.HMSPackageManager;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class HwIdSignInHubActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f277513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HuaweiIdSignInRequest f277514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HuaweiIdAuthResult f277515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private s f277516e;

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public void com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity__finish$___twin___() {
        super.finish();
    }

    public void com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    public void finish() {
        com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r100) {
        com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // android.app.Activity
    public void onStop() {
        com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    private void a() {
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "checkMinVersion start.", true);
        q.a(this, new AnonymousClass1(this));
    }

    private void b() {
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "startSignInActivity", true);
        startActivityForResult(c(), 16587);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        this.f277513b = true;
        as.d("[HUAWEIIDSDK]HwIdSignInClientHub", "Launch sign in Intent failed. hms is probably being updated：".concat(e.getClass().getSimpleName()), true);
        a(17);
    }

    private Intent c() {
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "getJosSignInIntent", true);
        Intent r100 = getIntent();
        String r101 = r100.getStringExtra("HUAWEIID_CP_CLIENTINFO");
        String r102 = r100.getStringExtra("HUAWEIID_SIGNIN_REQUEST");
        String r103 = r100.getStringExtra("exParams");
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "getJosSignInIntent. exParams is null " + TextUtils.isEmpty(r103), true);
        if (TextUtils.isEmpty(r103) == false) goto L19;
    L8:
        String r104 = r100.getAction();
        s r105 = s.a(r101);     // Catch: Exception -> L14
        ForegroundIntentBuilder r106 = new ForegroundIntentBuilder(this).setAction(r104).setRequestBody(r102).setKitSdkVersion(60900100);     // Catch: Exception -> L14
        if (r105.c() == null) goto L12;
        r106.setSubAppId(r105.c());     // Catch: Exception -> L14
    L12:
        Intent r107 = r106.build();     // Catch: Exception -> L14
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "get package name of hms is " + HMSPackageManager.getInstance(this).getHMSPackageName(), true);     // Catch: Exception -> L14
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "Current package name is " + getPackageName(), true);     // Catch: Exception -> L14
        r107.setPackage(getPackageName());     // Catch: Exception -> L14
        return r107;
    L14:
        e = move-exception;
        as.d("[HUAWEIIDSDK]HwIdSignInClientHub", "getSignInIntent failed because:".concat(e.getClass().getSimpleName()), true);
        return new Intent();
    L19:
        JSONObject r108 = new JSONObject(r102);     // Catch: JSONException -> L6
        r108.put("exParams", r103);     // Catch: JSONException -> L6
        r102 = r108.toString();     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "getJosSignInIntent Exception ".concat(e.getClass().getSimpleName()), true);
        goto L8
    }

    public HwIdSignInHubActivity() {
        this.f277512a = null;
        this.f277513b = false;
        this.f277514c = null;
        this.f277515d = null;
    }

    public static View INVOKEVIRTUAL_com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = Thread.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    private void a(int r110) {
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "onSignInAccountFailed: retCode：" + r110, true);
        String r100 = this.f277512a;
        if (r100 == null) goto L7;
        s r101 = this.f277516e;
        if (r101 == null) goto L7;
        HiAnalyticsClient.reportExit(this, CommonNaming.signinIntent, r100, r101.a(), ar.a(r110), r110, (int) this.f277516e.b());
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "report: api=hwid.signinintentversion=" + this.f277516e.b(), true);
    L7:
        Status r102 = new Status(r110);
        HuaweiIdAuthResult r111 = new HuaweiIdAuthResult();
        r111.setStatus(r102);
        Intent r103 = new Intent();
        r103.putExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID, r111.toJson());     // Catch: JSONException -> L10
    L11:
        setResult(0, r103);
        finish();
        return;
    L10:
        as.d("[HUAWEIIDSDK]HwIdSignInClientHub", "convert result to json failed", true);
        goto L11
    }

    public static void com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(HwIdSignInHubActivity r100) {
        r100.com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(HwIdSignInHubActivity r110) {
        r110.com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity__finish$___twin___();
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

    public void com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity__onCreate$___twin___(Bundle r100) {
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", WidgetCostModule.TYPE_ON_CREATE, true);
        super.onCreate(r100);
        Intent r101 = getIntent();
        if (a(r101) == false) goto L6;
        a(0, "invalid intent");
        return;
    L6:
        SafeIntent r102 = new SafeIntent(r101);
        boolean r103 = r102.getBooleanExtra("intent.extra.isfullscreen", false);
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "isActivityFullScreen is :" + r103, true);
        if (r103 == false) goto L9;
        f.a(getWindow());
        getWindow().setFlags(1024, 1024);
    L10:
        String r104 = r102.getAction();
        if (TextUtils.equals("com.huawei.hms.jos.signIn", r104) == true) goto L18;
        String r105 = "unknow Action:";
        if (r104 == null) goto L16;
        r105 = "unknow Action:" + r104;
    L16:
        a(0, r105);
        return;
    L18:
        String r106 = r102.getStringExtra("HUAWEIID_CP_CLIENTINFO");
        this.f277514c = HuaweiIdSignInRequest.fromJson(r102.getStringExtra("HUAWEIID_SIGNIN_REQUEST"));     // Catch: JSONException -> L21
    L23:
        if (TextUtils.isEmpty(r106) == false) goto L43;
        a(0, "Activity started with invalid cp client info");
        return;
    L43:
        this.f277516e = s.a(r106);     // Catch: JSONException -> L28
    L30:
        if (this.f277514c != null) goto L32;
    L39:
        a(0, "Activity started with invalid sign in request info");
        return;
    L32:
        if (this.f277516e == null) goto L39;
        ao.a(this);
        if (r100 == null) goto L37;
        restoreInstanceState(r100);
        return;
    L37:
        this.f277512a = HiAnalyticsClient.reportEntry(this, CommonNaming.signinIntent, 60900100);
        a();
        return;
    L28:
        this.f277516e = null;
        as.d("[HUAWEIIDSDK]HwIdSignInClientHub", "onCreate: JsonException", true);
    L21:
        this.f277514c = null;
        as.d("[HUAWEIIDSDK]HwIdSignInClientHub", "onCreate: JsonException", true);
        goto L23
    L9:
        f.a(this);
        goto L10
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        String r101 = this.f277512a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r100.putString("HiAnalyticsTransId", r101);
        return;
    L8:
        return;
    }

    public void restoreInstanceState(Bundle r100) {
        if (r100 == null) goto L5;
        this.f277512a = r100.getString("HiAnalyticsTransId");
        return;
    }

    private boolean a(Intent r100) {
        if (r100 == null) goto L11;
        r100.getStringExtra("ANYTHING");     // Catch: Exception -> L8
        return false;
    L12:
        return true;
    L11:
        return true;
    }

    public static /* synthetic */ void a(HwIdSignInHubActivity r100) {
        r100.b();
    }

    private void a(int r100, String r101) {
        as.d("[HUAWEIIDSDK]HwIdSignInClientHub", r101, true);
        setResult(0);
        finish();
    }

    public static void com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(HwIdSignInHubActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(r100) == false) goto L8;
        v19.f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.com_huawei_hms_hwid_internal_ui_activity_HwIdSignInHubActivity__onCreate$___twin___(r101);
    }

    public static /* synthetic */ void a(HwIdSignInHubActivity r100, int r101) {
        r100.a(r101);
    }

    @Override // android.app.Activity
    public void onActivityResult(int r110, int r111, Intent r112) {
        super.onActivityResult(r110, r111, r112);
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "onActivityResult: requestCode：" + r110 + " , resultCode：" + r111, true);
        if (r112 == null) goto L5;
        SafeIntent r100 = new SafeIntent(r112);
    L7:
        if (this.f277513b == false) goto L9;
        return;
    L9:
        if (r110 == 16587) goto L11;
        return;
    L11:
        if (r100 == null) goto L24;
        String r113 = r112.getStringExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID);
        if (r113 == null) goto L24;
        this.f277515d = new HuaweiIdAuthResult().fromJson(r113);     // Catch: JSONException -> L16
        y.a().a(this.f277515d.getHuaweiId(), this.f277514c.getHuaweiIdAuthParams());     // Catch: JSONException -> L16
        int r101 = this.f277515d.getStatus().getStatusCode();     // Catch: JSONException -> L16
    L17:
        String r102 = this.f277512a;
        if (r102 == null) goto L22;
        s r114 = this.f277516e;
        if (r114 == null) goto L22;
        HiAnalyticsClient.reportExit(this, CommonNaming.signinIntent, r102, r114.a(), ar.a(r101), r101, (int) this.f277516e.b());
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "report: api=hwid.signinintentversion=" + this.f277516e.b(), true);
    L22:
        setResult(r111, r100);
        finish();
        return;
    L16:
        this.f277515d = null;
        as.d("[HUAWEIIDSDK]HwIdSignInClientHub", "onActivityResult: JsonException", true);
        r101 = 8;
    L24:
        if (r111 > 0) goto L27;
        r111 = 8;
    L27:
        a(r111);
        return;
    L5:
        r100 = null;
        goto L7
    }
}
