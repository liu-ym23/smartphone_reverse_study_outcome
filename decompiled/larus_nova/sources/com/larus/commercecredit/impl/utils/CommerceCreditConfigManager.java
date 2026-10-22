package com.larus.commercecredit.impl.utils;

import com.bytedance.keva.Keva;
import com.ixigua.lib.track.TrackParams;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.commercecredit.api.CreditInfoScene;
import com.larus.commercecredit.api.ICommerceCreditService;
import com.larus.commercecredit.impl.page.i0;
import com.larus.minor.api.IMinorService;
import com.larus.platform.api.m4;
import com.larus.platform.model.EnableStatus;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import hq9.m0;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class CommerceCreditConfigManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CommerceCreditConfigManager f325801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f325802b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f325803c = null;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            CommerceCreditConfigManager.a(CommerceCreditConfigManager.f325801a, "CommerceCreditConfigManager_onLogin");
            ICommerceCreditService.f325667a.getClass();
            ICommerceCreditService r101 = ICommerceCreditService.a.a();
            if (r101 == null) goto L6;
            r101.h("CommerceCreditConfigManager-onLogIn", DowngradeSource.AFTER_LAUNCH);
            return;
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            CommerceCreditConfigManager.a(CommerceCreditConfigManager.f325801a, "CommerceCreditConfigManager_onLogout");
        }
    }

    public static final class b implements m4 {
        public b() {
        }

        @Override // com.larus.platform.api.m4
        public final void S1() {
            CommerceCreditConfigManager.a(CommerceCreditConfigManager.f325801a, "CommerceCreditConfigManager_onMinorModeOn");
        }

        @Override // com.larus.platform.api.m4
        public final void b1() {
            CommerceCreditConfigManager.a(CommerceCreditConfigManager.f325801a, "CommerceCreditConfigManager_onMinorModeOff");
        }
    }

    public CommerceCreditConfigManager() {
    }

    static {
        f325801a = new CommerceCreditConfigManager();
        AccountService r100 = AccountService.f365697a;
        r100.E(new a());
        r100.H(new b());
        f325802b = new AtomicBoolean(false);
        f325803c = new AtomicBoolean(false);
    }

    public static boolean f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L7;
        FLogger.f375446a.i("CommerceCreditConfigManager", "isCommerceCreditEnabled: not login with scene=" + r100);
        return false;
    L7:
        if (IMinorService.f359156a.a() == false) goto L10;
        FLogger.f375446a.i("CommerceCreditConfigManager", "isCommerceCreditEnabled: minor mode with scene=" + r100);
        return false;
    L10:
        m0 r101 = z2.f365865a.O0();
        FLogger.f375446a.i("CommerceCreditConfigManager", "isCommerceCreditEnabled: scene=" + r100 + " enable=" + r101.b() + " creditVersion=" + r101.a());
        if (Intrinsics.areEqual(r101.b(), EnableStatus.ENABLE.getStatus()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final void a(CommerceCreditConfigManager r100, String r101) {
        r100.getClass();
        FLogger.f375446a.i("CommerceCreditConfigManager", "resetConfig scene=".concat(r101));
        com.larus.commercecredit.impl.model.c.f325723c.setValue(null);
    }

    public static boolean g(long r100, long r101) {
        if (r101 != 0) goto L5;
        return true;
    L5:
        Calendar r102 = Calendar.getInstance();
        r102.setTimeInMillis(r100);
        Calendar r103 = Calendar.getInstance();
        r103.setTimeInMillis(r101);
        if (r102.get(1) == r103.get(1)) goto L8;
        return true;
    L8:
        if (r102.get(2) == r103.get(2)) goto L10;
        return true;
    L10:
        if (r102.get(5) != r103.get(5)) goto L16;
        return false;
    L16:
        return true;
    }

    public static Object h(String r100, String r101, Continuation r102) {
        FLogger.f375446a.i("CommerceCreditConfigManager", "joinGroupFromZlink scene=" + r101 + " text=" + r100);
        Object r103 = BuildersKt.withContext(Dispatchers.getIO(), new CommerceCreditConfigManager$joinGroupFromZlink$2(r100, r101, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public static Object i(DowngradeSource r100, com.larus.commercecredit.impl.b r101, Continuation r102) {
        Object r103 = BuildersKt.withContext(Dispatchers.getIO(), new CommerceCreditConfigManager$openCommerceCreditGuide$2(r100, r101, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public final Object k(String r110, DowngradeSource r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof CommerceCreditConfigManager$sendUserActivityCrossDay$1) == false) goto L7;
        CommerceCreditConfigManager$sendUserActivityCrossDay$1 r100 = (CommerceCreditConfigManager$sendUserActivityCrossDay$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L36 Exception -> L38
    L40:
        f325803c.set(false);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r102);
        if (z2.f365865a.O0().c() == true) goto L21;
        FLogger.f375446a.d("CommerceCreditConfigManager", "sendUserActivityCrossDay: scene=" + r110 + " setting config disable");
        return Unit.INSTANCE;
    L21:
        if (f325803c.compareAndSet(false, true) == true) goto L24;
        FLogger.f375446a.d("CommerceCreditConfigManager", "sendUserActivityCrossDay:  scene=" + r110 + " request already in progress, skip duplicate");
        return Unit.INSTANCE;
    L24:
        long r113 = System.currentTimeMillis();     // Catch: Throwable -> L36 Exception -> L38
        com.larus.commercecredit.impl.model.c r106 = com.larus.commercecredit.impl.model.c.f325721a;     // Catch: Throwable -> L36 Exception -> L38
        Keva r107 = com.larus.commercecredit.impl.model.c.c();     // Catch: Throwable -> L36 Exception -> L38
        long r114 = 0;
        if (r107 == null) goto L27;
        r114 = r107.getLong("user_activity_timestamp", 0);     // Catch: Throwable -> L36 Exception -> L38
    L27:
        boolean r108 = g(r113, r114);     // Catch: Throwable -> L36 Exception -> L38
        FLogger r109 = FLogger.f375446a;     // Catch: Throwable -> L36 Exception -> L38
        StringBuilder r115 = new StringBuilder("sendUserActivityCrossDay: scene=");     // Catch: Throwable -> L36 Exception -> L38
        r115.append(r110);     // Catch: Throwable -> L36 Exception -> L38
        r115.append(" isCrossDay=");     // Catch: Throwable -> L36 Exception -> L38
        if (r108 == false) goto L30;
        boolean r116 = true;
    L31:
        r115.append(r116);     // Catch: Throwable -> L36 Exception -> L38
        r115.append(" curTime=");     // Catch: Throwable -> L36 Exception -> L38
        r115.append(r113);     // Catch: Throwable -> L36 Exception -> L38
        r115.append(" lastTime=");     // Catch: Throwable -> L36 Exception -> L38
        r115.append(r114);     // Catch: Throwable -> L36 Exception -> L38
        r109.d("CommerceCreditConfigManager", r115.toString());     // Catch: Throwable -> L36 Exception -> L38
        if (r108 == false) goto L40;
        r100.L$0 = r110;     // Catch: Throwable -> L36 Exception -> L38
        r100.label = 1;     // Catch: Throwable -> L36 Exception -> L38
        if (j(r110, r111, null, r100) != r103) goto L40;
        return r103;
    L30:
        r116 = false;
    L36:
        th = move-exception;
        f325803c.set(false);
        throw th;
    L38:
        e = move-exception;
        FLogger.f375446a.e("CommerceCreditConfigManager", "sendUserActivityCrossDay: scene=" + r110 + " error=" + ExceptionsKt.stackTraceToString(e));     // Catch: Throwable -> L36
    L7:
        r100 = new CommerceCreditConfigManager$sendUserActivityCrossDay$1(this, r112);
        goto L8
    }

    public static Object d(String r100, String r101, i0 r102, Continuation r103) {
        if (f("getGroupInvitationInfo scene=" + r100 + " campaignKey=" + r101) == true) goto L6;
        r102.invoke(null);
        return Unit.INSTANCE;
    L6:
        Object r104 = BuildersKt.withContext(Dispatchers.getIO(), new CommerceCreditConfigManager$getGroupInvitationInfo$2(r100, r101, r102, null), r103);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r104;
    L10:
        return Unit.INSTANCE;
    }

    public static Object j(String r100, DowngradeSource r101, Function2 r102, Continuation r103) {
        if (f("sendUserActivity: scene=" + r100) == false) goto L5;
        Object r104 = BuildersKt.withContext(Dispatchers.getIO(), new CommerceCreditConfigManager$sendUserActivity$2(r100, r101, r102, null), r103);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r104;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public static Object c(String r100, String r101, boolean r110, Function3 r111, Continuation r112) {
        if (f("getGroupInfo scene=" + r100 + " campaignKey=" + r101 + " isSupportFromLocal=" + r110) == true) goto L6;
        r111.invoke(null, null, Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L6:
        Object r102 = BuildersKt.withContext(Dispatchers.getIO(), new CommerceCreditConfigManager$getGroupInfo$2(r110, r101, r100, r111, null), r112);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r102;
    L10:
        return Unit.INSTANCE;
    }

    public static Object b(CreditInfoScene r100, boolean r101, boolean r110, String r111, String r112, Function3 r113, Continuation r114, int r115) {
        if ((r115 & 2) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r115 & 4) == 0) goto L9;
        boolean r103 = true;
    L11:
        if ((r115 & 8) == 0) goto L14;
        r111 = null;
    L14:
        if ((r115 & 16) == 0) goto L16;
        r112 = null;
    L16:
        String r104 = r100.getScene();
        if (o0.d(r111) == false) goto L20;
        r104 = r104 + '_' + r111;
    L20:
        if (o0.d(r112) == false) goto L22;
        r104 = r104 + '_' + r112;
    L22:
        String r105 = r104;
        if (f("getAllCreditInfo scene=" + r105 + " needTasks=" + r102 + " isSupportFromLocal=" + r103) == true) goto L26;
        r113.invoke(null, null, Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L26:
        return BuildersKt.withContext(Dispatchers.getIO(), new CommerceCreditConfigManager$getAllCreditInfo$2(r103, r105, r102, r113, null), r114);
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public static void e(String r110, long r111, String r210, String r211, String r212, String r213, String r214, long r215, long r216, com.larus.network.http.a r310, int r311) {
        String r100 = null;
        if ((r311 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r311 & 2) == 0) goto L9;
        long r102 = System.currentTimeMillis();
    L11:
        if ((r311 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r311 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r311 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r311 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r311 & 64) == 0) goto L29;
        String r112 = null;
    L31:
        if ((r311 & 128) == 0) goto L33;
        long r113 = -1;
    L35:
        if ((r311 & 256) == 0) goto L37;
        long r114 = -1;
    L39:
        if ((r310 instanceof com.larus.network.http.f) == false) goto L50;
        com.larus.network.http.f r107 = (com.larus.network.http.f) r310;
        long r115 = r107.f360157d.getCode();
        String r108 = r107.f360157d.getMessage();
        if (r108 != null) goto L43;
    L46:
        boolean r109 = true;
    L47:
        if (r109 == false) goto L49;
        CommerceCreditErrorCode.Companion.getClass();
        r108 = CommerceCreditErrorCode.a.a(r115);
    L49:
        String r116 = r108;
        FLogger.f375446a.i("CommerceCreditConfigManager", "request failed scene=" + r101 + " with error code=" + r107.f360157d.getCode() + " msg=" + r107.f360157d.getMessage());
        String r117 = "0";
        r100 = r116;
        long r118 = r115;
    L51:
        long r119 = System.currentTimeMillis() - r102;
        int r120 = sz8.b.f544050a;
        JSONObject r121 = new JSONObject();
        Intrinsics.checkNotNullParameter(r121, "params");
    L86:
        e = move-exception;
        FLogger.f375446a.e("CommerceCreditMetricsHelper", "error in CommerceCreditMetricsHelper mobCommerceCreditMetric " + e.getLocalizedMessage());
    L88:
        TrackParams r122 = new TrackParams().merge(r121);
        by7.a r123 = new by7.a("commerce_credit_metric_event");
        r123.f21463a.merge(r122);
        r123.b();
        return;
    L53:
        if (o0.d(r101) == false) goto L56;
        r121.put("scene", r101);     // Catch: JSONException -> L86
    L56:
        if (o0.d(r117) == false) goto L58;
        r121.put("req_status", r117);     // Catch: JSONException -> L86
    L58:
        r121.put("error_code", r118);     // Catch: JSONException -> L86
        if (o0.d(r100) == false) goto L62;
        r121.put("error_msg", r100);     // Catch: JSONException -> L86
    L62:
        if (r119 < 0) goto L65;
        r121.put("duration", r119);     // Catch: JSONException -> L86
    L65:
        if (o0.d(r103) == false) goto L68;
        r121.put("event_type", r103);     // Catch: JSONException -> L86
    L68:
        if (o0.d(r105) == false) goto L71;
        r121.put("is_pull_tasks", r105);     // Catch: JSONException -> L86
    L71:
        if (o0.d(r106) == false) goto L74;
        r121.put("is_first_visit", r106);     // Catch: JSONException -> L86
    L74:
        if (o0.d(r112) == false) goto L77;
        r121.put("has_local_data", r112);     // Catch: JSONException -> L86
    L77:
        if (r113 < 0) goto L79;
        r121.put("total_credit_num", r113);     // Catch: JSONException -> L86
    L79:
        long r124 = r114;
        if (r124 < 0) goto L83;
        r121.put("active_time", r124);     // Catch: JSONException -> L86
    L83:
        if (o0.d(r104) == false) goto L88;
        r121.put("campaign_key", r104);     // Catch: JSONException -> L86
        goto L88
    L43:
        if (r108.length() == 0) goto L46;
        r109 = false;
        goto L47
    L50:
        r117 = "1";
        r118 = -1;
        goto L51
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r112 = r214;
        goto L31
    L25:
        r106 = r213;
        goto L27
    L21:
        r105 = r212;
        goto L23
    L17:
        r104 = r211;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
