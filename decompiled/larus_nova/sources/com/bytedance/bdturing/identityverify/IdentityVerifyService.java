package com.bytedance.bdturing.identityverify;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.verify.ITuringVerifyService;
import com.bytedance.ee.space.sync.PushAction$ESubType;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.nio.charset.Charset;
import java.util.HashMap;
import jc4.m;
import kotlin.text.Charsets;
import org.json.JSONObject;
import qb4.c0;
import qb4.f;
import qb4.n;
import ub4.i;
import ub4.j;

/* JADX INFO: loaded from: classes3.dex */
public class IdentityVerifyService extends sb4.a implements ITuringVerifyService {
    private static final String MSG_SUCCESS = "certificate_success";
    private static final String TAG = "CertifyService";
    private static final String TWO_FACTOR_VERIFY_FLOW = "webcast_risk_auth";
    private static volatile IdentityVerifyService sInstance;
    private boolean isOnVerify;
    private i mDialog;
    private ub4.a mDialogCallback;
    private jc4.a mRequest;
    private String mResultTicket;
    private String mSubType;

    /* JADX INFO: loaded from: classes13.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jc4.a f201800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f201801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Activity f201802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f201803d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ IdentityVerifyService f201804e;

        public final void a() {
            jc4.a r100 = this.f201800a;
            if (((jc4.f) r100).f498112t == true) goto L5;
        L12:
            IdentityVerifyService.access$200(this.f201804e, this.f201802c, r100, this.f201803d);
            return;
        L5:
            if (this.f201801b == true) goto L12;
            com.bytedance.bdturing.setting.e r101 = com.bytedance.bdturing.setting.e.f202077a;
            boolean r102 = false;
            if (com.bytedance.bdturing.setting.e.e("common").optInt("identity_use_dialog_v2", 0) != 1) goto L9;
            r102 = true;
        L9:
            if (r102 == false) goto L11;
            IdentityVerifyService.access$000(this.f201804e, this.f201802c, this.f201800a, this.f201803d);
            return;
        L11:
            IdentityVerifyService.access$100(this.f201804e, this.f201802c, this.f201800a, this.f201803d);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(IdentityVerifyService r100, jc4.a r101, boolean r102, Activity r103, f r104) {
            this.f201804e = r100;
            this.f201800a = r101;
            this.f201801b = r102;
            this.f201802c = r103;
            this.f201803d = r104;
        }
    }

    /* JADX INFO: loaded from: classes13.dex */
    public class b implements ub4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jc4.a f201805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f201806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f201807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ IdentityVerifyService f201808d;

        @Override // ub4.a
        public final void onCancel() {
            int r100 = n.f532367a;
            EventReport.k(1, IdentityVerifyService.access$300(this.f201808d));
            this.f201806b.getApplication().unregisterActivityLifecycleCallbacks(this.f201808d);
            IdentityVerifyService.access$500(this.f201808d, false);
            JSONObject r101 = new JSONObject();
            hc4.d.b(r101, "errorMsg", "cert verify cancel by user");
            IdentityVerifyService.access$600(this.f201808d, false, r101, this.f201807c);
        }

        @Override // ub4.a
        public final void onConfirm() {
            EventReport.k(0, IdentityVerifyService.access$300(this.f201808d));
            IdentityVerifyService.access$400(this.f201808d, (jc4.f) this.f201805a, this.f201806b, this.f201807c);
        }

        public b(IdentityVerifyService r100, jc4.a r101, Activity r102, f r103) {
            this.f201808d = r100;
            this.f201805a = r101;
            this.f201806b = r102;
            this.f201807c = r103;
        }
    }

    /* JADX INFO: loaded from: classes13.dex */
    public class c implements ub4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jc4.a f201809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f201810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f201811c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ IdentityVerifyService f201812d;

        @Override // ub4.a
        public final void onCancel() {
            int r100 = n.f532367a;
            EventReport.k(1, IdentityVerifyService.access$300(this.f201812d));
            this.f201810b.getApplication().unregisterActivityLifecycleCallbacks(this.f201812d);
            IdentityVerifyService.access$500(this.f201812d, false);
            JSONObject r101 = new JSONObject();
            hc4.d.b(r101, "errorMsg", "cert verify cancel by user");
            IdentityVerifyService.access$600(this.f201812d, false, r101, this.f201811c);
        }

        @Override // ub4.a
        public final void onConfirm() {
            int r100 = n.f532367a;
            EventReport.k(0, IdentityVerifyService.access$300(this.f201812d));
            IdentityVerifyService.access$400(this.f201812d, (jc4.f) this.f201809a, this.f201810b, this.f201811c);
        }

        public c(IdentityVerifyService r100, jc4.a r101, Activity r102, f r103) {
            this.f201812d = r100;
            this.f201809a = r101;
            this.f201810b = r102;
            this.f201811c = r103;
        }
    }

    /* JADX INFO: loaded from: classes13.dex */
    public class d implements ub4.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f201813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jc4.f f201814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IdentityVerifyService f201815c;

        public d(IdentityVerifyService r100, f r101, jc4.f r102) {
            this.f201815c = r100;
            this.f201813a = r101;
            this.f201814b = r102;
        }
    }

    /* JADX INFO: loaded from: classes13.dex */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jc4.f f201816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f201817b;

        public final void a() {
            String r100 = this.f201816a.f();     // Catch: Exception -> L25
            if (TextUtils.isEmpty(r100) == true) goto L32;
            JSONObject r101 = new JSONObject();     // Catch: Exception -> L25
            BdTuringConfig r102 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L25
            JSONObject r103 = null;
            if (r102 == null) goto L8;
            String r104 = r102.getAppId();     // Catch: Exception -> L25
        L9:
            long r105 = 0;
        L14:
            e = move-exception;
            e.printStackTrace();     // Catch: Exception -> L25
        L16:
            r101.put("aid", r105);     // Catch: Exception -> L25
            r101.put("scene", this.f201816a.f498107o);     // Catch: Exception -> L25
            r101.put("detail", this.f201816a.f498110r);     // Catch: Exception -> L25
            JSONObject r106 = this.f201817b;     // Catch: Exception -> L25
            if (r106 == null) goto L20;
            r103 = r106.optJSONObject("ext_data");     // Catch: Exception -> L25
        L20:
            if (r103 == null) goto L22;
            String r107 = r103.optString("ticket");     // Catch: Exception -> L25
        L23:
            r101.put("ticket", r107);     // Catch: Exception -> L25
            String r108 = r101.toString();     // Catch: Exception -> L25
            Charset r109 = Charsets.UTF_8;     // Catch: Exception -> L25
            byte[] r110 = r108.getBytes(r109);     // Catch: Exception -> L25
            ec4.b r111 = qb4.b.c.f532315a.f532302a.getHttpClient();     // Catch: Exception -> L25
            HashMap r112 = new HashMap();     // Catch: Exception -> L25
            r112.put("Content-Type", "application/json; charset=utf-8");     // Catch: Exception -> L25
            new JSONObject(new String(r111.post(r100, r112, r110), r109)).optInt("err_code", -1);     // Catch: Exception -> L25
            int r113 = n.f532367a;     // Catch: Exception -> L25
            return;
        L22:
            r107 = "";
            goto L23
        L11:
            if (TextUtils.isEmpty(r104) == true) goto L16;
            r105 = CastLongProtector.parseLong(r104);     // Catch: Exception -> L14
        L8:
            r104 = null;
            goto L9
        L32:
            return;
        L25:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(jc4.f r100, JSONObject r101) {
            this.f201816a = r100;
            this.f201817b = r101;
        }
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public synchronized boolean isOnVerify() {
        monitor-enter(this);
        boolean r100 = this.isOnVerify;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService, ic4.a
    public boolean isProcess(int r100) {
        if (14 != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public boolean isSenseless() {
        return false;
    }

    public static IdentityVerifyService getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(IdentityVerifyService.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new IdentityVerifyService();     // Catch: Throwable -> L11
    L9:
        monitor-exit(IdentityVerifyService.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private IdentityVerifyService() {
        this.mSubType = "";
        this.mResultTicket = "";
        this.mDialogCallback = null;
    }

    public ub4.a getDialogCallback() {
        return this.mDialogCallback;
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdturing_identityverify_IdentityVerifyService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(i r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdturing_identityverify_IdentityVerifyService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(i r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static /* synthetic */ jc4.a access$300(IdentityVerifyService r100) {
        return r100.mRequest;
    }

    private synchronized void setVerifySate(boolean r100) {
        monitor-enter(this);
        EventReport.e(r100, "IdentityVerifyService", this.mRequest);     // Catch: Throwable -> L6
        this.isOnVerify = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // sb4.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r100) {
        i r101 = this.mDialog;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isShowing() == true) goto L7;
        return;
    L7:
        if (this.mDialog.f549357a != r100) goto L12;
        setVerifySate(false);
        INVOKEVIRTUAL_com_bytedance_bdturing_identityverify_IdentityVerifyService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.mDialog);
        this.mDialog = null;
        return;
    }

    public static /* synthetic */ void access$500(IdentityVerifyService r100, boolean r101) {
        r100.setVerifySate(r101);
    }

    private boolean isVerifySuccess(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L12;
        int r102 = r100.optInt("error_code", -1);
        String r103 = r100.optString("error_msg");
        JSONObject r104 = r100.optJSONObject("ext_data");
        if (r104 == null) goto L6;
        String r105 = r104.optString("ticket");
    L7:
        this.mResultTicket = r105;
        if ("certificate_success".equals(r103) == false) goto L11;
        if (r102 != 0) goto L11;
        return true;
    L11:
        hc4.d.b(r101, "errorCode", Integer.valueOf(r102));
        hc4.d.b(r101, "errorMsg", r103);
        goto L12
    L6:
        r105 = "";
    L12:
        return false;
    }

    private void reportVerifyResult(JSONObject r100, jc4.f r101) {
        c0.a.f532328a.a(new e(r101, r100));
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService, ic4.a
    public boolean execute(jc4.a r110, f r111) {
        if ((r110 instanceof m) == false) goto L5;
        boolean r100 = r110.f498096g;
        jc4.a r101 = ((m) r110).f498122o;
    L7:
        if (r101 != null) goto L9;
    L20:
        JSONObject r112 = new JSONObject();
        hc4.d.b(r112, "errorMsg", "request type is not CertifyRequest!");
        r111.onFail(996, r112);
        return true;
    L9:
        if ((r101 instanceof jc4.f) == false) goto L20;
        if (isOnVerify() == false) goto L15;
        r111.onFail(998, null);
        bc4.b.a().d(r110);
        EventReport.S(r110, "IdentityVerifyService");
        return true;
    L15:
        Activity r102 = r110.getActivity();
        this.mRequest = r110;
        if (r102 == null) goto L18;
        r102.runOnUiThread(new a(this, r101, r100, r102, r111));
    L19:
        return true;
    L18:
        int r113 = n.f532367a;
        JSONObject r114 = new JSONObject();
        hc4.d.b(r114, "errorMsg", "topActivity is null");
        noticeResult(false, r114, r111);
        goto L19
    L5:
        r101 = null;
        r100 = false;
        goto L7
    }

    public static /* synthetic */ boolean access$700(IdentityVerifyService r100, JSONObject r101, JSONObject r102) {
        return r100.isVerifySuccess(r101, r102);
    }

    public static /* synthetic */ void access$800(IdentityVerifyService r100, JSONObject r101, jc4.f r102) {
        r100.reportVerifyResult(r101, r102);
    }

    private void doVerify(jc4.f r110, Activity r111, f r112) {
        String r100 = r110.f498107o;
        String r101 = r110.f498109q;
        String r102 = r110.f498108p;
        if (r110.f498106n <= 0) goto L5;
        String r103 = r110.f498106n + "";
    L6:
        this.mSubType = r110.f498113u;
        qb4.b r104 = qb4.b.c.f532315a;
        BdTuringConfig r105 = r104.f532302a;
        if (r105 == null) goto L9;
        ub4.b r106 = r105.getIdentityVerifyDepend();
    L11:
        if (r106 != null) goto L21;
        int r113 = n.f532367a;
        JSONObject r114 = new JSONObject();
        hc4.d.b(r114, "msg", "certVerifyDepend is null");
        noticeResult(false, r114, r112);
        return;
    L21:
        HashMap r107 = new HashMap();     // Catch: Exception -> L17
        r107.put("scene", r100);     // Catch: Exception -> L17
        r107.put(BytedCertConstant.CertKey.FLOW, r102);     // Catch: Exception -> L17
        r107.put("cert_app_id", r103);     // Catch: Exception -> L17
        r107.put("mode", "0");     // Catch: Exception -> L17
        r107.put("source", r101);     // Catch: Exception -> L17
        r107.put("use_new_api", "true");     // Catch: Exception -> L17
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L17
        r108.put("detail", r110.f498110r);     // Catch: Exception -> L17
        r107.put("biz_info", r108.toString());     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r110.f498111s) == true) goto L15;
        r107.put("ticket", r110.f498111s);     // Catch: Exception -> L17
    L15:
        r104.f532302a.getRegionType();     // Catch: Exception -> L17
        BdTuringConfig.RegionType r109 = BdTuringConfig.RegionType.REGION_BOE;     // Catch: Exception -> L17
        j r115 = new j(r111, r107);     // Catch: Exception -> L17
        r104.f532302a.getThemeConfig();     // Catch: Exception -> L17
        r106.a(r115, new d(this, r112, r110));     // Catch: Exception -> L17
        EventReport.m(0, this.mRequest);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        EventReport.m(1, this.mRequest);
        JSONObject r116 = new JSONObject();
        hc4.d.b(r116, "msg", "load cert sdk failed");
        noticeResult(false, r116, r112);
        return;
    L9:
        r106 = null;
        goto L11
    L5:
        r103 = qb4.b.c.f532315a.f532302a.getAppId();
        goto L6
    }

    private void noticeResult(boolean r100, JSONObject r101, f r102) {
        setVerifySate(false);
        this.mDialog = null;
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        JSONObject r103 = new JSONObject();
        hc4.d.b(r103, PushAction$ESubType.KEY_NAME, this.mSubType);
        hc4.d.b(r103, "ticket", this.mResultTicket);
        hc4.d.b(r101, "notify_data", r103);
        if (r102 == null) goto L18;
        if (r100 == false) goto L9;
        r102.onSuccess(0, r101);     // Catch: Exception -> L11
    L14:
        return;
    L9:
        r102.onFail(1, r101);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private void verifyWithDialog(Activity r100, jc4.a r101, f r102) {
        r100.getApplication().unregisterActivityLifecycleCallbacks(this);     // Catch: Exception -> L9
        this.mDialog = new i(r100, new b(this, r101, r100, r102));     // Catch: Exception -> L9
        if (r100.isFinishing() == false) goto L6;
        return;
    L6:
        if (this.mDialog.isShowing() == true) goto L19;
        r100.getApplication().registerActivityLifecycleCallbacks(this);     // Catch: Exception -> L9
        INVOKEVIRTUAL_com_bytedance_bdturing_identityverify_IdentityVerifyService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.mDialog);     // Catch: Exception -> L9
        EventReport.l(0, this.mRequest);     // Catch: Exception -> L9
        setVerifySate(true);     // Catch: Exception -> L9
        return;
    L19:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        EventReport.l(1, this.mRequest);
        if (r100 == null) goto L13;
        r100.getApplication().unregisterActivityLifecycleCallbacks(this);
    L13:
        if (r102 == null) goto L20;
        JSONObject r103 = new JSONObject();
        hc4.d.b(r103, "errorMsg", "hand cert verify fail");
        r102.onFail(1, r103);
        return;
    }

    private void verifyWithDialogV2(Activity r100, jc4.a r101, f r102) {
        this.mDialogCallback = new c(this, r101, r100, r102);     // Catch: Exception -> L5
        r100.startActivity(new Intent(r100, IdentityDialogActivity.class));     // Catch: Exception -> L5
        EventReport.l(0, this.mRequest);     // Catch: Exception -> L5
        setVerifySate(true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        EventReport.l(1, this.mRequest);
        if (r100 == null) goto L9;
        r100.getApplication().unregisterActivityLifecycleCallbacks(this);
    L9:
        if (r102 == null) goto L14;
        JSONObject r103 = new JSONObject();
        hc4.d.b(r103, "errorMsg", "hand cert verify fail");
        r102.onFail(1, r103);
        return;
    }

    private void verifyWithOutDialog(Activity r100, jc4.a r101, f r102) {
        EventReport.l(2, this.mRequest);     // Catch: Exception -> L4
        setVerifySate(true);     // Catch: Exception -> L4
        doVerify((jc4.f) r101, r100, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        JSONObject r103 = new JSONObject();
        hc4.d.b(r103, "errorMsg", "doVerify exception");
        noticeResult(false, r103, r102);
    }

    public static /* synthetic */ void access$000(IdentityVerifyService r100, Activity r101, jc4.a r102, f r103) {
        r100.verifyWithDialogV2(r101, r102, r103);
    }

    public static /* synthetic */ void access$100(IdentityVerifyService r100, Activity r101, jc4.a r102, f r103) {
        r100.verifyWithDialog(r101, r102, r103);
    }

    public static /* synthetic */ void access$200(IdentityVerifyService r100, Activity r101, jc4.a r102, f r103) {
        r100.verifyWithOutDialog(r101, r102, r103);
    }

    public static /* synthetic */ void access$400(IdentityVerifyService r100, jc4.f r101, Activity r102, f r103) {
        r100.doVerify(r101, r102, r103);
    }

    public static /* synthetic */ void access$600(IdentityVerifyService r100, boolean r101, JSONObject r102, f r103) {
        r100.noticeResult(r101, r102, r103);
    }
}
