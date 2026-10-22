package com.ss.android.dypay.utils;

import android.os.Bundle;
import com.android.ttcjpaysdk.bdpay.counter.outer.CJCallbackOuterManager;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f408492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f408493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f408494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f408495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f408496e;

    public static final class a extends Lambda implements Function1<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f408497a;

        public a(Bundle r100) {
            this.f408497a = r100;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public String invoke(String r100) {
            String r101 = r100;
            return r101 + com.alipay.sdk.m.n.a.f25612h + this.f408497a.get(r101);
        }
    }

    public g(vta.b r100) {
        this.f408492a = "CALLING";
        this.f408495d = 500;
        this.f408496e = 10000;
        if (r100 != null) goto L21;
    L11:
        if (r100 == null) goto L23;
        vta.h r101 = r100.f557248a;     // Catch: Throwable -> L20
        if (r101 == null) goto L24;
        String r102 = r101.f557282j;     // Catch: Throwable -> L20
        if (r102 == null) goto L25;
        Long r103 = StringsKt.toLongOrNull(r102);     // Catch: Throwable -> L20
        if (r103 == null) goto L26;
        this.f408496e = r103.longValue();     // Catch: Throwable -> L20
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L21:
        vta.h r104 = r100.f557248a;     // Catch: Throwable -> L20
        if (r104 == null) goto L11;
        String r105 = r104.f557281i;     // Catch: Throwable -> L20
        if (r105 == null) goto L11;
        Long r106 = StringsKt.toLongOrNull(r105);     // Catch: Throwable -> L20
        if (r106 == null) goto L11;
        this.f408495d = r106.longValue();     // Catch: Throwable -> L20
        goto L11
    }

    public final void a(int r110, Bundle r111) {
        boolean r100 = false;
        if (r111 == null) goto L6;
        r100 = r111.getBoolean(CJCallbackOuterManager.KEY_STOP_HEART_BEAT, false);
    L6:
        if (r111 == null) goto L10;
        String r112 = CollectionsKt.joinToString$default(r111.keySet(), "_", null, null, 0, null, new a(r111), 30, null);
        if (r112 == null) goto L10;
    L11:
        switch(r110) {
            case 1000: goto L16;
            case 1001: goto L15;
            case 1002: goto L14;
            case 1003: goto L13;
            default: goto L12;
        };
    L12:
        String r113 = String.valueOf(r110);
    L19:
        this.f408492a = r113;
    L20:
        b(this, "", null, r112, 2);
        if (r100 == false) goto L27;
        c("DY_NOTIFY_CANCEL", r112);
        return;
    L27:
        return;
    L13:
        r113 = "CASHIER_IMP";
        goto L19
    L14:
        r113 = "PULL_END";
        goto L19
    L15:
        r113 = "PULL_START";
        goto L19
    L16:
        this.f408492a = "CALL_SUCCESS";
        JSONObject r101 = sta.a.f543575a;
        JSONObject r102 = new JSONObject();
        r102.put("code", Integer.valueOf(r110));     // Catch: Exception -> L24
    L18:
        sta.a.e(SearchResultParam.ENTER_PAGE_TYPE_MIDDLE_PAGE, "dy_start_success_callback", r112, r102, null, 48);
    L10:
        r112 = "";
        goto L11
    }

    public final void c(String r100, String r101) {
        f r102 = this.f408493b;
        if (r102 == null) goto L62;
        r102.cancel();
        String r103 = null;
        this.f408493b = null;
        int r104 = r100.hashCode();
        if (r104 == 92337256) goto L23;
        if (r104 == 1217049094) goto L20;
        if (r104 == 1601032716) goto L17;
        if (r104 == 1928066479) goto L14;
    L25:
        int r105 = -1;
    L26:
        sta.a r106 = sta.a.f543576b;
        JSONObject r107 = new JSONObject();
        r107.put("out_link_node", this.f408492a);     // Catch: Exception -> L48
    L60:
        r107.put("count", Integer.valueOf(this.f408494c));     // Catch: Exception -> L49
    L54:
        r107.put("beat_status", Integer.valueOf(r105));     // Catch: Exception -> L50
    L52:
        r107.put("beat_duration", Long.valueOf(((long) this.f408494c) * this.f408495d));     // Catch: Exception -> L35
    L36:
        if (r101 != null) goto L38;
    L46:
        sta.a.f(r106, "out_wallet_cashier_rd_heart_beat", r107);
        return;
    L38:
        if (r101.length() <= 0) goto L40;
        boolean r108 = true;
    L41:
        if (r108 == false) goto L43;
        r103 = r101;
    L43:
        if (r103 == null) goto L46;
        r107.put("extra_params", r101);     // Catch: Exception -> L51
        goto L46
    L40:
        r108 = false;
        goto L41
    L14:
        if (r100.equals("ACTIVITY_DESTROY_CANCEL") == false) goto L25;
        r105 = 5;
        goto L26
    L17:
        if (r100.equals("ON_ACTIVITY_RESULT_CANCEL") == false) goto L25;
        r105 = 4;
        goto L26
    L20:
        if (r100.equals("DY_NOTIFY_CANCEL") == false) goto L25;
        r105 = 2;
        goto L26
    L23:
        if (r100.equals("COUNTDOWN_CANCEL") == false) goto L25;
        r105 = 3;
        goto L26
    }

    public static void b(g r100, String r101, Integer r102, String r103, int r110) {
        String r104 = null;
        if ((r110 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r110 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.getClass();
        sta.a r111 = sta.a.f543576b;
        JSONObject r105 = new JSONObject();
        r105.put("out_link_node", r100.f408492a);     // Catch: Exception -> L41
    L52:
        r105.put("from", r101);     // Catch: Exception -> L13
    L14:
        if (r102 == null) goto L21;
        r102.intValue();
        r105.put("count", r102);     // Catch: Exception -> L42
    L54:
        r105.put("beat_duration", Long.valueOf(((long) r102.intValue()) * r100.f408495d));     // Catch: Exception -> L20
    L21:
        int r106 = 0;
        if (r103 == null) goto L35;
        if (r103.length() <= 0) goto L26;
        boolean r107 = true;
    L27:
        if (r107 == false) goto L29;
        r104 = r103;
    L29:
        if (r104 == null) goto L35;
        r105.put("extra_params", r103);     // Catch: Exception -> L33
        goto L35
    L26:
        r107 = false;
    L35:
        if (r102 == null) goto L50;
        r106 = 1;
    L50:
        r105.put("beat_status", Integer.valueOf(r106));     // Catch: Exception -> L43
    L39:
        sta.a.f(r111, "out_wallet_cashier_rd_heart_beat", r105);
    }
}
