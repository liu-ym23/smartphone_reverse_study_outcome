package com.bytedance.bdturing.senseless;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cc4.g;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.verify.ITuringVerifyService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import jc4.m;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.c0;
import qb4.f;
import qb4.n;
import sb4.k;
import sb4.l;

/* JADX INFO: loaded from: classes3.dex */
public class SenselessVerifyService implements ITuringVerifyService {
    private static final String SEC_REPORT_SCENE = "verify_center";
    private static volatile SenselessVerifyService sInstance;
    private boolean asyncReportRunning;
    private k mDlg;
    private com.bytedance.bdturing.senseless.a mReportDog;
    private jc4.a mRequest;
    private boolean preReportRunning;

    /* JADX INFO: loaded from: classes14.dex */
    public class a implements com.bytedance.bdturing.senseless.a.InterfaceC2912a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f202007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f202008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f202009c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f202010d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ f f202011e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ SenselessVerifyService f202012f;

        @Override // com.bytedance.bdturing.senseless.a.InterfaceC2912a
        public final void T0() {
            jc4.a r100 = SenselessVerifyService.access$000(this.f202012f);
            JSONObject r101 = new JSONObject();
            r101.put("key", "senseless_report_timeout");     // Catch: JSONException -> L5
            EventReport.w("turing_verify_sdk", r101, r100);
        L7:
            SenselessVerifyService.access$100(this.f202012f, "", "", this.f202007a, this.f202008b, this.f202009c, this.f202010d, this.f202011e);
            return;
        L5:
            e = move-exception;
            int r102 = n.f532367a;
            Intrinsics.checkNotNullParameter(e, "e");
            e.printStackTrace();
            goto L7
        }

        public a(SenselessVerifyService r100, boolean r101, String r102, String r103, String r104, f r105) {
            this.f202012f = r100;
            this.f202007a = r101;
            this.f202008b = r102;
            this.f202009c = r103;
            this.f202010d = r104;
            this.f202011e = r105;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class b implements com.bytedance.bdturing.senseless.d.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f202013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f202014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f202015c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f202016d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f202017e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ SenselessVerifyService f202018f;

        @Override // com.bytedance.bdturing.senseless.d.e
        public final void onSuccess() {
            SenselessVerifyService.access$200(this.f202018f);
            SenselessVerifyService.access$302(this.f202018f, false);
            EventReport.E(SenselessVerifyService.access$000(this.f202018f), 0, "pre_collect", "");
            if (this.f202013a == false) goto L6;
            this.f202014b.onSuccess(0, null);
            return;
        }

        @Override // com.bytedance.bdturing.senseless.d.e
        public final void onFail(int r100, JSONObject r110) {
            EventReport.E(SenselessVerifyService.access$000(this.f202018f), r100, "pre_collect", r110.toString());
            SenselessVerifyService.access$200(this.f202018f);
            if (this.f202013a == true) goto L5;
            SenselessVerifyService.access$302(this.f202018f, false);
            return;
        L5:
            if (r100 == 10) goto L7;
            String r101 = r110.optString("message");
            String r102 = r110.optString("sec_message");
            SenselessVerifyService.access$100(this.f202018f, r101, r102, this.f202013a, this.f202015c, this.f202016d, this.f202017e, this.f202014b);
            return;
        L7:
            SenselessVerifyService.access$302(this.f202018f, false);
            this.f202014b.onFail(10, r110);
        }

        public b(SenselessVerifyService r100, boolean r101, f r102, String r103, String r104, String r105) {
            this.f202018f = r100;
            this.f202013a = r101;
            this.f202014b = r102;
            this.f202015c = r103;
            this.f202016d = r104;
            this.f202017e = r105;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class c implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f202019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f202020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f202021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f202022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f202023e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ SenselessVerifyService f202024f;

        @Override // sb4.l
        public final void a() {
            EventReport.D(1, SenselessVerifyService.access$000(this.f202024f));
            c(SenselessVerifyService.access$400(this.f202024f));
            SenselessVerifyService.access$402(this.f202024f, null);
            SenselessVerifyService.access$302(this.f202024f, false);
            f r100 = this.f202019a;
            if (r100 == null) goto L6;
            r100.onFail(1, null);
            return;
        }

        @Override // sb4.l
        public final void b() {
            c(SenselessVerifyService.access$400(this.f202024f));
            SenselessVerifyService.access$402(this.f202024f, null);
            EventReport.D(0, SenselessVerifyService.access$000(this.f202024f));
            SenselessVerifyService.access$500(this.f202024f, this.f202020b, this.f202021c, this.f202022d, this.f202023e, this.f202019a);
        }

        @Override // sb4.l
        public final void onCancel() {
            EventReport.D(1, SenselessVerifyService.access$000(this.f202024f));
            c(SenselessVerifyService.access$400(this.f202024f));
            SenselessVerifyService.access$402(this.f202024f, null);
            SenselessVerifyService.access$302(this.f202024f, false);
            f r100 = this.f202019a;
            if (r100 == null) goto L6;
            r100.onFail(1, null);
            return;
        }

        public static void c(k r100) {
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

        public c(SenselessVerifyService r100, f r101, boolean r102, String r103, String r104, String r105) {
            this.f202024f = r100;
            this.f202019a = r101;
            this.f202020b = r102;
            this.f202021c = r103;
            this.f202022d = r104;
            this.f202023e = r105;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class d implements com.bytedance.bdturing.senseless.d.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SenselessVerifyService f202025a;

        @Override // com.bytedance.bdturing.senseless.d.e
        public final void onSuccess() {
            EventReport.E(SenselessVerifyService.access$000(this.f202025a), 0, "async_collect", "");
            SenselessVerifyService.access$602(this.f202025a, false);
        }

        public d(SenselessVerifyService r100) {
            this.f202025a = r100;
        }

        @Override // com.bytedance.bdturing.senseless.d.e
        public final void onFail(int r100, JSONObject r101) {
            EventReport.E(SenselessVerifyService.access$000(this.f202025a), r100, "async_collect", r101.toString());
            SenselessVerifyService.access$602(this.f202025a, false);
        }
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public synchronized boolean isOnVerify() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.preReportRunning == true) goto L9;
        if (this.asyncReportRunning == true) goto L9;
        boolean r100 = false;
    L10:
        monitor-exit(this);
        return r100;
    L9:
        r100 = true;
        goto L10
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService, ic4.a
    public boolean isProcess(int r100) {
        if (18 != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public boolean isSenseless() {
        return true;
    }

    public static SenselessVerifyService getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(SenselessVerifyService.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SenselessVerifyService();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SenselessVerifyService.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void stopWatchDog() {
        com.bytedance.bdturing.senseless.a r100 = this.mReportDog;
        if (r100 == null) goto L8;
        r100.f202027b = false;
        c0.b r101 = c0.a.f532328a.f532327b;
        if (r101 == null) goto L9;
        r101.removeCallbacks(r100);
        return;
    L9:
        return;
    }

    private SenselessVerifyService() {
        this.preReportRunning = false;
        this.asyncReportRunning = false;
    }

    private void doSecReport() {
        JSONObject r100 = cc4.b.a();
        boolean r101 = false;
        if (r100 == null) goto L5;
        r101 = r100.optBoolean("trigger_sec_sdk", false);
    L5:
        if (r101 == true) goto L7;
        return;
    L7:
        BdTuringConfig r102 = qb4.b.c.f532315a.f532302a;
        if (r102 == null) goto L11;
        r102.getSecDepend();
        return;
    }

    public jc4.a getRiskRequest() {
        return this.mRequest;
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdturing_senseless_SenselessVerifyService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(k r100) {
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

    public static /* synthetic */ jc4.a access$000(SenselessVerifyService r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ void access$200(SenselessVerifyService r100) {
        r100.stopWatchDog();
    }

    public static /* synthetic */ k access$400(SenselessVerifyService r100) {
        return r100.mDlg;
    }

    public static /* synthetic */ boolean access$302(SenselessVerifyService r100, boolean r101) {
        r100.preReportRunning = r101;
        return r101;
    }

    public static /* synthetic */ k access$402(SenselessVerifyService r100, k r101) {
        r100.mDlg = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$602(SenselessVerifyService r100, boolean r101) {
        r100.asyncReportRunning = r101;
        return r101;
    }

    private void startAsyncReport(String r110, String r111) {
        this.asyncReportRunning = true;
        if (cc4.b.a().optBoolean("collect_touch_event", false) == false) goto L11;
        g r100 = g.d();
        r100.f23280c = true;
        BdTuringConfig r101 = qb4.b.c.f532315a.f532302a;
        if (r101 == null) goto L7;
        Activity r102 = r101.getTopActivity();
    L8:
        if (r102 == null) goto L11;
        r100.k(r102);
        goto L11
    L7:
        r102 = null;
    L11:
        if (cc4.b.a().optBoolean("collect_page_history", false) == false) goto L13;
        g.d().f23281d = true;
    L13:
        com.bytedance.bdturing.senseless.d r103 = com.bytedance.bdturing.senseless.d.b();
        d r104 = new d(this);
        r103.getClass();
        long r105 = cc4.b.a().optLong("async_collect_time_out");
        if (r105 > 0) goto L17;
        r105 = 10000;
    L17:
        r103.f202038b = r105;
        com.bytedance.bdturing.senseless.a r106 = r103.f202037a;
        if (r106 == null) goto L22;
        r106.f202027b = false;
        c0.b r107 = c0.a.f532328a.f532327b;
        if (r107 == null) goto L22;
        r107.removeCallbacks(r106);
    L22:
        com.bytedance.bdturing.senseless.a r108 = new com.bytedance.bdturing.senseless.a(new com.bytedance.bdturing.senseless.b(r103, r110, r111, r104));
        r103.f202037a = r108;
        long r112 = r103.f202038b;
        if (r108.f202027b == true) goto L26;
        r108.f202027b = true;
        c0.a.f532328a.b(r108, r112);
    L26:
        r103.f202040d = System.currentTimeMillis();
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService, ic4.a
    public boolean execute(jc4.a r110, f r111) {
        if ((r110 instanceof m) == false) goto L5;
        jc4.a r100 = ((m) r110).f498122o;
    L7:
        if (r100 != null) goto L9;
    L17:
        JSONObject r112 = new JSONObject();
        hc4.d.b(r112, "errorMsg", "request type is not available!");
        r111.onFail(996, r112);
        return true;
    L9:
        if ((r100 instanceof jc4.n) == false) goto L17;
        if (isOnVerify() == false) goto L15;
        r111.onFail(998, null);
        bc4.b.a().d(r110);
        EventReport.S(r110, "SenselessVerifyService");
        return true;
    L15:
        this.mRequest = r110;
        jc4.n r101 = (jc4.n) r100;
        doVerify(Intrinsics.areEqual("nocaptcha", r101.f498124n), r101.f498093d, r101.f498124n, r101.f498125o, r111);
        return true;
    L5:
        r100 = null;
        goto L7
    }

    private void doVerify(boolean r100, String r101, String r102, String r103, f r104) {
        doSecReport();
        if (r100 == true) goto L6;
        if (r104 == null) goto L6;
        r104.onFail(1, null);
    L6:
        reportPreCollectData(r100, r101, r102, r103, r104);
        startAsyncReport(r102, r103);
    }

    private void reportPreCollectData(boolean r110, String r111, String r112, String r210, f r211) {
        this.preReportRunning = true;
        if (r110 == false) goto L16;
        com.bytedance.bdturing.senseless.a r100 = this.mReportDog;
        if (r100 == null) goto L9;
        r100.f202027b = false;
        c0.b r101 = c0.a.f532328a.f532327b;
        if (r101 == null) goto L9;
        r101.removeCallbacks(r100);
    L9:
        this.mReportDog = new com.bytedance.bdturing.senseless.a(new a(this, r110, r111, r112, r210, r211));
        long r102 = 2000;
        long r103 = cc4.b.a().optLong("report_time_out", 2000);
        if (r103 <= 0) goto L12;
        r102 = r103;
    L12:
        com.bytedance.bdturing.senseless.a r104 = this.mReportDog;
        if (r104.f202027b == true) goto L16;
        r104.f202027b = true;
        c0.a.f532328a.b(r104, r102);
    L16:
        com.bytedance.bdturing.senseless.d r113 = com.bytedance.bdturing.senseless.d.b();
        b r114 = new b(this, r110, r211, r111, r112, r210);
        r113.f202041e = 0;
        com.bytedance.bdturing.senseless.d.d(r112, r210, new com.bytedance.bdturing.senseless.c(r113, r114, r112, r210), 0);
    }

    public static /* synthetic */ void access$500(SenselessVerifyService r100, boolean r101, String r102, String r103, String r104, f r105) {
        r100.reportPreCollectData(r101, r102, r103, r104, r105);
    }

    private void showFailDlg(String r110, String r111, boolean r112, String r113, String r114, String r210, f r211) {
        if (this.mDlg == null) goto L5;
        return;
    L5:
        BdTuringConfig r100 = qb4.b.c.f532315a.f532302a;
        if (r100 == null) goto L8;
        Activity r101 = r100.getTopActivity();
    L10:
        if (r101 == null) goto L26;
        sb4.b r115 = new sb4.b();
        if (TextUtils.isEmpty(r110) == false) goto L14;
        String r102 = r101.getString(R.string.turing_net_error_title);
    L15:
        r115.f541211a = r102;
        StringBuilder r103 = new StringBuilder();
        if (TextUtils.isEmpty(r111) == false) goto L18;
        String r104 = r101.getString(R.string.turing_net_error_content);
    L19:
        r103.append(r104);
        r103.append("\n\n");
        r103.append(r113);
        r115.f541212b = r103.toString();
        r115.f541213c = r101.getString(R.string.turing_net_error_close);
        r115.f541214d = r101.getString(R.string.turing_net_error_retry);
        k r116 = new k(r101, r115, true, new c(this, r211, r112, r113, r114, r210));
        this.mDlg = r116;
        INVOKEVIRTUAL_com_bytedance_bdturing_senseless_SenselessVerifyService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r116);
        jc4.a r105 = this.mRequest;
        JSONObject r106 = new JSONObject();
        r106.put("key", "senseless_dialog_display");     // Catch: JSONException -> L24
        if (TextUtils.isEmpty("") == true) goto L23;
        r106.put("custom", "");     // Catch: JSONException -> L24
    L23:
        EventReport.w("turing_verify_sdk", r106, r105);
        return;
    L24:
        e = move-exception;
        int r107 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        return;
    L18:
        r104 = r111;
        goto L19
    L14:
        r102 = r110;
        goto L15
    L26:
        this.preReportRunning = false;
        if (r211 == null) goto L34;
        r211.onFail(1, null);
        return;
    L34:
        return;
    L8:
        r101 = null;
        goto L10
    }

    public static /* synthetic */ void access$100(SenselessVerifyService r100, String r101, String r102, boolean r103, String r104, String r105, String r106, f r107) {
        r100.showFailDlg(r101, r102, r103, r104, r105, r106, r107);
    }
}
