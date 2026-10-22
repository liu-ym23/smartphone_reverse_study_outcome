package com.ss.android.account.group_onekey.network;

import android.os.SystemClock;
import com.bytedance.sdk.account.impl.d0;
import com.ss.android.account.group_onekey.BaseAccountGroupAuthActivity;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;
import ta7.j;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements com.ss.android.token.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yqa.c f406304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f406305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f406306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f406307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f406308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f406309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f406310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f406311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ d f406312i;

    public static final class a extends ua7.a<xa7.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f406313a;

        public a(b r100) {
            this.f406313a = r100;
        }

        @Override // ua7.a
        public final void onResponse(ua7.b r100) {
            xa7.c r101 = (xa7.c) r100;
            StringBuilder r102 = new StringBuilder("requestGetToken(), onResponse, clientPkg=");
            r102.append(this.f406313a.f406309f);
            r102.append(", challenge=");
            r102.append(this.f406313a.f406306c);
            r102.append(", success=");
            JSONObject r103 = null;
            if (r101 == null) goto L5;
            Boolean r104 = Boolean.valueOf(r101.f549249c);
        L6:
            r102.append(r104);
            r102.append(", error=");
            if (r101 == null) goto L9;
            Integer r105 = Integer.valueOf(r101.f549253g);
        L10:
            r102.append(r105);
            r102.append(", errorMsg=");
            if (r101 == null) goto L13;
            String r106 = r101.f549255i;
        L14:
            r102.append(r106);
            tb7.a.d("AccountGroupNetworkHelper", r102.toString());
            this.f406313a.f406304a.f568884f = System.currentTimeMillis();
            yqa.c r107 = this.f406313a.f406304a;
            r107.f568885g = r107.f568884f - r107.f568883e;
            r107.f568879a = 0;
            if (r101 == null) goto L18;
            r103 = r101.f563072z;
        L18:
            if (r103 != null) goto L23;
            if (r101 == null) goto L21;
            int r108 = r101.f549253g;
        L22:
            r107.f568879a = r108;
            r107.f568880b = "server error:" + this.f406313a.f406304a.f568879a + ", data is null";
            return;
        L21:
            r108 = -3;
            goto L22
        L23:
            String r109 = r101.f563072z.optString("token");
            if (r109 != null) goto L28;
            r109 = "";
        L28:
            if (r109.length() <= 0) goto L30;
            boolean r110 = true;
        L31:
            if (r110 == false) goto L33;
            yqa.c r111 = this.f406313a.f406304a;
            r111.getClass();
            r111.f568881c = r109;
        L38:
            b r112 = this.f406313a;
            d r113 = r112.f406312i;
            if (r113 == null) goto L43;
            r113.a(r112.f406304a, false);
            return;
        L43:
            return;
        L33:
            yqa.c r114 = this.f406313a.f406304a;
            r114.f568879a = Integer.valueOf(r101.f549253g).intValue();
            StringBuilder r115 = new StringBuilder("server error:");
            r115.append(r114.f568879a);
            r115.append(',');
            String r116 = r101.f549255i;
            if (r116 != null) goto L37;
            r116 = "unknown";
        L37:
            r115.append(r116);
            r114.f568880b = r115.toString();
            goto L38
        L30:
            r110 = false;
            goto L31
        L13:
            r106 = null;
            goto L14
        L9:
            r105 = null;
            goto L10
        L5:
            r104 = null;
            goto L6
        }
    }

    @Override // com.ss.android.token.b
    public final void onError(String r100) {
        yqa.c r101 = this.f406304a;
        r101.f568882d = SystemClock.elapsedRealtime() - this.f406305b;
        r101.f568879a = -1;
        r101.f568880b = r100;
        d r102 = this.f406312i;
        if (r102 == null) goto L6;
        r102.a(this.f406304a, false);
        return;
    }

    @Override // com.ss.android.token.b
    public final void onSuccess(Map<String, String> r100) {
        this.f406304a.f568882d = SystemClock.elapsedRealtime() - this.f406305b;
        this.f406304a.f568883e = System.currentTimeMillis();
        if (r100 == null) goto L5;
        r100.put("x-uc-bypass-token", "1");
    L5:
        j r101 = d0.c();
        d0 r102 = (d0) r101;
        r102.b("/passport/safe/get_token/", r100, MapsKt.mapOf(new Pair[]{TuplesKt.to("local_account_sdk_skip_network_check", "1"), TuplesKt.to("token_challenge", this.f406306c), TuplesKt.to("token_challenge_method", this.f406307d), TuplesKt.to("client_aid", this.f406308e), TuplesKt.to("client_package", this.f406309f), TuplesKt.to("client_signature", this.f406310g), TuplesKt.to("login_scene", this.f406311h), TuplesKt.to("response_format_type", "app")}), new a(this));
    }

    public b(yqa.c r100, long r101, String r102, String r103, String r104, String r105, String r106, String r107, BaseAccountGroupAuthActivity.b r110) {
        this.f406304a = r100;
        this.f406305b = r101;
        this.f406306c = r102;
        this.f406307d = r103;
        this.f406308e = r104;
        this.f406309f = r105;
        this.f406310g = r106;
        this.f406311h = r107;
        this.f406312i = r110;
    }
}
