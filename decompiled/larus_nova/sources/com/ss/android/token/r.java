package com.ss.android.token;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bd_sec_tee.core.TeeProvider;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.sdk.account.devicetransfer.AccountDeviceTransferManager;
import com.bytedance.sdk.account.settings.AccountHostSettingsManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AuthTokenMultiProcessSharedProvider.b f449787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f449788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Context f449789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile f0 f449790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile e0 f449791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile String f449792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile String f449793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile String f449794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile long f449795i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f449796j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile boolean f449797k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f449798l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Handler f449799m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile q f449800n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final r f449801o = null;

    /* JADX INFO: loaded from: classes38.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f449802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f449803b;

        public a(Ref.ObjectRef r100, Ref.ObjectRef r101) {
            this.f449802a = r100;
            this.f449803b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            TTTokenMonitor.m((String) this.f449802a.element, ((e0) this.f449803b.element).f449730f);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public r() {
    }

    static {
        f449801o = new r();
        f449791e = new e0();
        f449792f = "";
        f449794h = "";
        f449798l = new Object();
        f449799m = new Handler(Looper.getMainLooper());
    }

    public static void b() {
        boolean r100 = true;
        if ((!StringsKt.isBlank(f449791e.f449725a)) == false) goto L36;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.Q == false) goto L37;
        com.bytedance.sdk.account.settings.common.a.a();
        String r101 = com.bytedance.sdk.account.settings.common.a.R;
        if ((!StringsKt.isBlank(r101)) == false) goto L9;
        String r102 = r101;
    L10:
        if (r102 == null) goto L38;
        List r103 = StringsKt.split$default(r102, new String[]{","}, false, 0, 6, null);
        if (r103 == null) goto L39;
        List r104 = r103;
        if ((r104 instanceof Collection) == true) goto L16;
    L18:
        Iterator r105 = r104.iterator();
    L20:
        if (r105.hasNext() == false) goto L24;
        if ((!StringsKt.contains$default(f449791e.f449725a, (String) r105.next(), false, 2, null)) == false) goto L20;
    L25:
        tb7.a.b("TokenFactory", "loadDataFromSp, token not match rule: " + r100);
        String r106 = f449791e.f449725a;
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L28
        r107.put("token", com.bytedance.sdk.account.utils.r.c(r106));     // Catch: Throwable -> L28
        com.bytedance.sdk.account.monitor.a.a("passport_token_value_error", r107);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        tb7.a.c("AccountMonitorUtil", "onTokenValueError", th);
        return;
    L24:
        r100 = false;
        goto L25
    L16:
        if (r104.isEmpty() == false) goto L18;
    L39:
        return;
    L38:
        return;
    L9:
        r102 = null;
        goto L10
    L37:
        return;
    }

    public static e0 e() {
        if (f449788b == true) goto L10;
        f0 r100 = f449790d;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("tokenObjectProviderHelper");
    L9:
        return r100.c();
    L10:
        return f449791e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v36, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v6, types: [T, com.ss.android.token.e0] */
    /* JADX WARN: Type inference failed for: r15v3, types: [T, com.ss.android.token.e0] */
    /* JADX WARN: Type inference failed for: r15v5, types: [T, com.ss.android.token.e0] */
    /* JADX WARN: Type inference failed for: r1v27, types: [T, com.ss.android.token.e0] */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, java.lang.String] */
    public static void f() {
        if (f449788b == true) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis();
        Object r101 = f449798l;
        monitor-enter(r101);
        AuthTokenMultiProcessSharedProvider.b r102 = f449787a;     // Catch: Throwable -> L105
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L10:
        String r103 = r102.f("token_encrypted");     // Catch: Throwable -> L105
        Ref.ObjectRef r104 = new Ref.ObjectRef();     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r105 = f449787a;     // Catch: Throwable -> L105
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L13:
        r104.element = r105.f(LoginVerifyService.X_TT_TOKEN);     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r106 = f449787a;     // Catch: Throwable -> L105
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L16:
        f449795i = r106.e();     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r107 = f449787a;     // Catch: Throwable -> L105
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L19:
        String r108 = r107.f("token_tlb_tag");     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r110 = f449787a;     // Catch: Throwable -> L105
        if (r110 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L22:
        int r111 = r110.d("is_login", -1);     // Catch: Throwable -> L105
        String r112 = "";
        String r113 = "";
        String r114 = "";
        Ref.ObjectRef r115 = new Ref.ObjectRef();     // Catch: Throwable -> L105
        if (((String) r104.element).length() <= 0) goto L25;
        boolean r116 = true;
    L27:
        if (r103.length() <= 0) goto L29;
        boolean r109 = true;
    L30:
        if (r116 == true) goto L34;
        if (r109 == true) goto L34;
    L33:
        String r117 = r112;
        String r210 = r113;
        com.bytedance.sdk.account.settings.common.a.a();     // Catch: Throwable -> L105
        boolean r118 = com.bytedance.sdk.account.settings.common.a.U;     // Catch: Throwable -> L105
        com.bytedance.sdk.account.settings.common.a.a();     // Catch: Throwable -> L105
        boolean r119 = com.bytedance.sdk.account.settings.common.a.V;     // Catch: Throwable -> L105
        if (r118 == false) goto L50;
        if (r109 == false) goto L50;
        r104.element = i(r103);     // Catch: Throwable -> L105
    L50:
        if (TextUtils.isEmpty(r114) == true) goto L52;
        TicketTrackData.Serialized r120 = new TicketTrackData.Serialized(r114);     // Catch: Throwable -> L105
    L53:
        TicketTrackData.Serialized r211 = r120;
        boolean r121 = r116;
        ?? r122 = new e0((String) r104.element, r117, r210, r211, r108, r111);     // Catch: Throwable -> L105
        r115.element = r122;     // Catch: Throwable -> L105
        r122.f449730f = r103;     // Catch: Throwable -> L105
        if (r118 == false) goto L64;
        if (r109 == true) goto L64;
        if (r121 == false) goto L64;
        ?? r123 = new e0((String) r104.element, r117, r210, r211, r108, r111);     // Catch: Throwable -> L105
        r115.element = r123;     // Catch: Throwable -> L105
        c(r123);     // Catch: Throwable -> L105
        tb7.a.d("TokenFactory", "loadDataFromSp, compensate encrypt token: " + ((e0) r115.element).a());     // Catch: Throwable -> L105
        h("compensate_encrypt", (e0) r115.element);     // Catch: Throwable -> L105
        if (AccountHostSettingsManager.f269319d.a() <= 0) goto L62;
        WeakHandler r124 = TokenFactory.j().f449670j;     // Catch: Throwable -> L105
        if (r124 == null) goto L63;
        r124.postDelayed(new a(r104, r115), 5000);     // Catch: Throwable -> L105
    L63:
        boolean r125 = true;
    L65:
        if (r119 == true) goto L69;
        if (r121 == true) goto L69;
        if (r109 == false) goto L69;
        ?? r126 = new e0(i(r103), r117, r210, r211, r108, r111);     // Catch: Throwable -> L105
        r115.element = r126;     // Catch: Throwable -> L105
        r126.f449730f = r103;     // Catch: Throwable -> L105
        tb7.a.d("TokenFactory", "loadDataFromSp, compensate plain text token: " + ((e0) r115.element).a());     // Catch: Throwable -> L105
        h("compensate_plaintext", (e0) r115.element);     // Catch: Throwable -> L105
        boolean r127 = true;
    L70:
        if (r118 == true) goto L74;
        if (r121 == false) goto L74;
        if (r109 == false) goto L74;
        r115.element = new e0((String) r104.element, r117, r210, r211, r108, r111);     // Catch: Throwable -> L105
        tb7.a.d("TokenFactory", "loadDataFromSp, clean encrypt token: " + ((e0) r115.element).a());     // Catch: Throwable -> L105
        h("clean_encrypt", (e0) r115.element);     // Catch: Throwable -> L105
        boolean r128 = true;
    L75:
        if (r119 == false) goto L79;
        if (r121 == false) goto L79;
        if (r109 == false) goto L79;
        e0 r129 = new e0("", r117, r210, r211, r108, 0);     // Catch: Throwable -> L105
        r129.f449730f = r103;     // Catch: Throwable -> L105
        tb7.a.d("TokenFactory", "loadDataFromSp, clean plain text token: " + r129.a());     // Catch: Throwable -> L105
        h("clean_plaintext", r129);     // Catch: Throwable -> L105
        boolean r130 = true;
    L80:
        e0 r131 = (e0) r115.element;     // Catch: Throwable -> L105
        String r132 = r131.f449725a;     // Catch: Throwable -> L105
        if (TextUtils.isEmpty(r132) == false) goto L83;
        String r133 = "";
        boolean r134 = false;
    L84:
        r131.f449729e = r133;     // Catch: Throwable -> L105
        f449791e = (e0) r115.element;     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r135 = f449787a;     // Catch: Throwable -> L105
        if (r135 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L87:
        f449792f = r135.f("mfa_token");     // Catch: Throwable -> L105
        f449796j = System.currentTimeMillis() - r100;     // Catch: Throwable -> L105
        String r136 = (String) r104.element;     // Catch: Throwable -> L105
        if ((!Intrinsics.areEqual("change.token", r136)) == true) goto L90;
    L92:
        f449797k = r134;     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r137 = f449787a;     // Catch: Throwable -> L105
        if (r137 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L95:
        f449793g = r137.f("x-tt-token-last");     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r138 = f449787a;     // Catch: Throwable -> L105
        if (r138 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L98:
        f449794h = r138.f("device_transfer_tee_pub_key");     // Catch: Throwable -> L105
        Unit r139 = Unit.INSTANCE;     // Catch: Throwable -> L105
        monitor-exit(r101);
        AuthTokenMultiProcessSharedProvider.b r140 = f449787a;
        if (r140 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");
    L103:
        r140.c("first_beat", true);
        tb7.a.d("TokenFactory", "loadDataFromSp. token: " + f449791e.a() + ", mfaToken: " + com.bytedance.sdk.account.utils.n.b(f449792f, 4) + ", isTokenValid: " + f449797k + ", loadTokenDuration: " + f449796j + ", mLastSameUserToken: " + com.bytedance.sdk.account.utils.n.b(f449793g, 4) + ", logTagEnableEncrypt: " + r118 + ", logTagHasEncryptToken: " + r109 + ", logTagNeedCompensateEncrypt: " + r125 + ", logTagNeedCleanEncrypt: " + r128 + ", logTagClosePlainText: " + r119 + ", logTagHasPlainTextToken: " + r121 + ", logTagNeedCompensatePlainText: " + r127 + ", logTagNeedCleanPlainText: " + r130 + ", mDeviceTransferTeePubKey: " + f449794h + ", tokenTimestamp: " + f449795i);
        return;
    L90:
        if (TextUtils.isEmpty(r136) == true) goto L92;
        r134 = true;
        goto L92
    L83:
        int r141 = bc7.a.f18591a;     // Catch: Throwable -> L105
        r134 = false;
        r133 = String.valueOf(bc7.a.a(r132.getBytes(), 0));     // Catch: Throwable -> L105
    L79:
        r130 = false;
    L74:
        r128 = false;
    L69:
        r127 = false;
        goto L70
    L62:
        TTTokenMonitor.m((String) r104.element, ((e0) r115.element).f449730f);     // Catch: Throwable -> L105
    L64:
        r125 = false;
        goto L65
    L52:
        r120 = null;
    L34:
        AuthTokenMultiProcessSharedProvider.b r142 = f449787a;     // Catch: Throwable -> L105
        if (r142 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L37:
        r112 = r142.f("ts_sign");     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r143 = f449787a;     // Catch: Throwable -> L105
        if (r143 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L40:
        r113 = r143.f("attest_ts_sign");     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r144 = f449787a;     // Catch: Throwable -> L105
        if (r144 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L43:
        r114 = r144.f("track_data");     // Catch: Throwable -> L105
        goto L33
    L29:
        r109 = false;
        goto L30
    L25:
        r116 = false;
    L105:
        th = move-exception;
        throw th;
    }

    public final Context getContext() {
        Context r100 = f449789c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    public static String d() {
        return e().f449725a;
    }

    public static void c(e0 r100) {
        int r101 = 0;
        if (r100.f449725a.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L24;
        String r103 = r100.f449730f;
        if (r103 != null) goto L10;
    L15:
        String r104 = r100.f449725a;
        if (r104 == null) goto L23;
        String r105 = StringsKt.reversed(r104).toString();
        StringBuilder r106 = new StringBuilder();
        int r107 = r105.length();
    L18:
        if (r101 >= r107) goto L20;
        r106.append((char) (r105.charAt(r101) + (r101 % 5)));
        r101 = r101 + 1;
        goto L18
    L20:
        r100.f449730f = r106.toString();
        return;
    L23:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L10:
        if (r103.length() <= 0) goto L12;
        boolean r108 = true;
    L13:
        if (r108 != true) goto L15;
        return;
    L12:
        r108 = false;
        goto L13
    L24:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @JvmStatic
    public static final String i(String r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.append((char) (r100.charAt(r103) - (r103 % 5)));
        r103 = r103 + 1;
        goto L3
    L5:
        String r104 = r101.toString();
        if (r104 == null) goto L10;
        return StringsKt.reversed(r104).toString();
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final int a(String r100, String r101) {
        boolean r102 = false;
        if (Intrinsics.areEqual(r100, r101) == false) goto L6;
        return 0;
    L6:
        if (r100.length() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return -1;
    L12:
        if (r101.length() != 0) goto L14;
        r102 = true;
    L14:
        if (r102 == false) goto L16;
        return 1;
    L16:
        return 2;
    L8:
        r103 = false;
        goto L9
    }

    public static /* synthetic */ void h(String r100, e0 r101) {
        g(r100, r101, false, null);
    }

    public static void g(String r100, e0 r110, boolean r111, AuthTokenMultiProcessSharedProvider.a r112) {
        if (r112 != null) goto L5;
        boolean r101 = true;
    L6:
        if (r112 != null) goto L12;
        AuthTokenMultiProcessSharedProvider.b r113 = f449787a;
        if (r113 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");
    L11:
        r112 = r113.b();
    L12:
        r112.c(LoginVerifyService.X_TT_TOKEN, r110.f449725a);
        r112.c("token_encrypted", r110.f449730f);
        r112.c("ts_sign", r110.f449726b);
        r112.c("attest_ts_sign", r110.f449727c);
        r112.c("token_tlb_tag", r110.f449731g);
        if (r111 == false) goto L15;
        f449795i = System.currentTimeMillis();
        long r102 = f449795i;
        r112.f449628b.put("x-tt-token-timestamp", Long.valueOf(r102));
    L15:
        com.bytedance.sdk.account.utils.j<TicketTrackData> r103 = r110.f449728d;
        if (r103 == null) goto L20;
        String r104 = r103.a();
        if (r104 == null) goto L20;
    L21:
        r112.c("track_data", r104);
        String r114 = "";
        if (AccountDeviceTransferManager.f() == true) goto L49;
    L31:
        r112.c("device_transfer_tee_pub_key", r114);
        int r105 = r110.f449732h;
        r112.f449628b.put("is_login", Integer.valueOf(r105));
        if (r101 == false) goto L48;
        Object r115 = f449798l;
        monitor-enter(r115);
        r112.a();     // Catch: Throwable -> L45
        String r106 = r110.f449725a;     // Catch: Throwable -> L45
        String r107 = r110.f449726b;     // Catch: Throwable -> L45
        String r108 = r110.f449731g;     // Catch: Throwable -> L45
        com.bytedance.sdk.account.settings.common.a.a();     // Catch: Throwable -> L45
        long r109 = com.bytedance.sdk.account.settings.common.a.f269377b0;     // Catch: Throwable -> L45
        if (r109 <= 0) goto L42;
        q r116 = f449800n;     // Catch: Throwable -> L45
        if (r116 == null) goto L41;
        f449799m.removeCallbacks(r116);     // Catch: Throwable -> L45
    L41:
        q r117 = new q(SystemClock.elapsedRealtime(), r100, r106, r107, r108);     // Catch: Throwable -> L45
        f449800n = r117;     // Catch: Throwable -> L45
        f449799m.postDelayed(r117, r109);     // Catch: Throwable -> L45
    L42:
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r115);
        return;
    L45:
        th = move-exception;
        throw th;
    L48:
        return;
    L49:
        AccountDeviceTransferManager.f268883h.getClass();     // Catch: Exception -> L28
        Lazy r119 = AccountDeviceTransferManager.f268882g;     // Catch: Exception -> L28
        KProperty r120 = AccountDeviceTransferManager.f268880e[1];     // Catch: Exception -> L28
        r114 = ((TeeProvider) r119.getValue()).a("device_transfer", null).f199578b;     // Catch: Exception -> L28
        if (r114 != null) goto L30;
        r114 = "";
    L30:
        r112.c("device_transfer_tee_pub_key", r114);
    L28:
        e = move-exception;
        tb7.a.f("TokenFactory", "get device transfer tee pub key error", e);
        r114 = "";
    L20:
        r104 = "";
        goto L21
    L5:
        r101 = false;
        goto L6
    }
}
