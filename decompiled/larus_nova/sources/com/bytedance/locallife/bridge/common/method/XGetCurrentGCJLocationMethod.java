package com.bytedance.locallife.bridge.common.method;

import android.app.Activity;
import android.content.Context;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class XGetCurrentGCJLocationMethod extends ko6.g implements kt6.j, com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f257048k = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompletionBlock<ko6.g.c> f257049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f257050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f257051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f257052h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f257053i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f257054j;

    public static final class a {
    }

    public final class b implements kt6.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ XGetCurrentGCJLocationMethod f257055a;

        public b(XGetCurrentGCJLocationMethod r100) {
            this.f257055a = r100;
        }

        @Override // kt6.j
        public final void a(kt6.l r100) {
            c(r100, null);
        }

        @Override // kt6.j
        public final void b(kt6.k r100) {
            Intrinsics.checkNotNullParameter(r100, "locationException");
            c(null, r100);
        }

        public final void c(kt6.l r100, kt6.k r101) {
            if (r100 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L10;
            XGetCurrentGCJLocationMethod r103 = this.f257055a;
            int r104 = XGetCurrentGCJLocationMethod.f257048k;
            r103.j(r100, 1, null);
            return;
        L10:
            int r105 = XGetCurrentGCJLocationMethod.f257048k;
            this.f257055a.j(r100, 0, "exception = " + r101 + " | result = " + r100);
            return;
        L5:
            if (r100.a() != true) goto L7;
            r102 = true;
            goto L8
        }
    }

    static {
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public final void h() {
        Context r100 = this.f257050f;
        final kt6.g r101 = HostServiceUtilsKt.M();
        if ((r100 instanceof Activity) == false) goto L30;
        int r102 = 1;
        if (r101.l() == true) goto L7;
        this.f257054j = 1;
        r101.c((Activity) r100, TokenCert.Companion.with("bpea-getCurrentGCJLocation_Xjsb_requestpermission"), new XGetCurrentGCJLocationMethod$getLocationWithDialog$1(this, r101), new XGetCurrentGCJLocationMethod$getLocationWithDialog$2(this));
        return;
    L7:
        kt6.g r103 = HostServiceUtilsKt.M();
        Unit r104 = null;
        boolean r105 = false;
        if (this.f257052h == false) goto L22;
        String r106 = this.f257053i;
        if (r106 != null) goto L12;
    L13:
        r105 = true;
    L15:
        if ((true ^ r105) == true) goto L18;
        r106 = null;
    L18:
        if (r106 == null) goto L20;
        r103.i(TokenCert.Companion.with("bpea-getCurrentGCJLocation_Xjsb_handleAlreadyGranted_forceLocate_with_auth_new").auth(r106), this);
        r104 = Unit.INSTANCE;
    L20:
        if (r104 != null) goto L33;
        r103.i(TokenCert.Companion.with("bpea-getCurrentGCJLocation_Xjsb_handleAlreadyGranted_forceLocate"), this);
        return;
    L33:
        return;
    L12:
        if (r106.length() != 0) goto L15;
    L22:
        kt6.l r107 = r103.b(TokenCert.Companion.with("bpea-getCurrentGCJLocation_Xjsb_handleAlreadyGranted_getLocationFromCache"));
        if (r107 != null) goto L25;
    L27:
        r102 = 0;
    L28:
        j(r107, r102, null);
        return;
    L25:
        if (r107.a() != true) goto L27;
    L30:
        i();
    }

    public final void i() {
        kt6.g r100 = HostServiceUtilsKt.M();
        boolean r101 = false;
        Unit r102 = null;
        if (r100.j() == true) goto L5;
        j(null, 0, "getLocationWithoutDialog...未通过定位前置校验！isLocationPermissionsGranted = " + r100.l() + ", isLocationServiceEnabled = " + r100.d());
        return;
    L5:
        if (this.f257052h == false) goto L19;
        String r103 = this.f257053i;
        if (r103 != null) goto L9;
    L10:
        r101 = true;
    L12:
        if ((!r101) == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L17;
        r100.i(TokenCert.Companion.with("bpea-getCurrentGCJLocation_xbridge_silent_true_forcelocate_true_with_auth_new").auth(r103), this);
        r102 = Unit.INSTANCE;
    L17:
        if (r102 != null) goto L22;
        r100.i(TokenCert.Companion.with("bpea-getCurrentGCJLocation_xbridge_silent_true_forcelocate_true"), this);
        return;
    L22:
        return;
    L9:
        if (r103.length() != 0) goto L12;
    L19:
        r100.r(TokenCert.Companion.with("bpea-getCurrentGCJLocation_Xjsb_silent_getcache"), new b(this));
    }

    public XGetCurrentGCJLocationMethod() {
    }

    @Override // kt6.j
    public final void a(kt6.l r100) {
        int r101 = 1;
        if (r100.a() == true) goto L6;
        r101 = 0;
    L6:
        j(r100, r101, null);
    }

    @Override // kt6.j
    public final void b(kt6.k r100) {
        Intrinsics.checkNotNullParameter(r100, "locationException");
        j(null, 0, null);
    }

    @Override // v56.c
    public final void e(XBaseParamModel r100, v56.a r101, XBridgePlatformType r102) {
        ko6.g.b r103 = (ko6.g.b) r100;
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.f257050f = mo6.a.f514592a.getContext(this.f553273a);     // Catch: Exception -> L18
        this.f257049e = r101;     // Catch: Exception -> L18
        boolean r104 = true;
        if (r103.getSilent().intValue() != 1) goto L6;
        boolean r105 = true;
    L7:
        Number r106 = r103.getForceLocate();     // Catch: Exception -> L18
        if (r106 != null) goto L10;
    L12:
        r104 = false;
    L13:
        this.f257052h = r104;     // Catch: Exception -> L18
        this.f257053i = r103.getForceLocateAuth();     // Catch: Exception -> L18
        this.f257051g = false;     // Catch: Exception -> L18
        if (r105 == true) goto L16;
        h();     // Catch: Exception -> L18
        return;
    L16:
        i();     // Catch: Exception -> L18
        return;
    L10:
        if (r106.intValue() != 1) goto L12;
    L6:
        r105 = false;
    L18:
        e = move-exception;
        e.printStackTrace();
        CompletionBlock.a.a(r101, 0, null, null, 6);
    }

    public final void j(kt6.l r110, int r111, String r112) throws Exception {
        qs6.b r100 = HostServiceUtilsKt.k();
        r100.e("TAGGG", "onResponse被执行...");
        if (this.f257051g == false) goto L5;
        return;
    L5:
        kt6.f r101 = HostServiceUtilsKt.s();
        String r102 = r101.e();
        if (HostServiceUtilsKt.M().j() == false) goto L8;
        String r103 = "0";
    L9:
        Intrinsics.checkNotNullParameter(ko6.g.d.class, "<this>");
        ko6.g.d r104 = (ko6.g.d) com.bytedance.ies.xbridge.utils.g.c(ko6.g.d.class);
        if (r110 == null) goto L13;
        String r105 = Double.valueOf(r110.f506060a).toString();
        if (r105 == null) goto L13;
    L14:
        r104.setLatitude(r105);
        if (r110 == null) goto L18;
        String r106 = Double.valueOf(r110.f506061b).toString();
        if (r106 == null) goto L18;
    L19:
        r104.setLongitude(r106);
        r104.setPopSelect(Integer.valueOf(this.f257054j));
        r104.setCityCode(r102);
        r104.setCityName(r101.d());
        CompletionBlock<ko6.g.c> r107 = null;
        if (r110 == null) goto L22;
        String r108 = r110.f506062c;
    L23:
        r104.setRealCityName(r108);
        Intrinsics.checkNotNullParameter(ko6.g.c.class, "<this>");
        ko6.g.c r109 = (ko6.g.c) com.bytedance.ies.xbridge.utils.g.c(ko6.g.c.class);
        if (r110 == null) goto L27;
        String r113 = Double.valueOf(r110.f506060a).toString();
        if (r113 == null) goto L27;
    L28:
        r109.setLatitude(r113);
        if (r110 == null) goto L34;
        String r114 = Double.valueOf(r110.f506061b).toString();
        if (r114 == null) goto L34;
        r103 = r114;
    L34:
        r109.setLongitude(r103);
        r109.setPopSelect(Integer.valueOf(this.f257054j));
        r109.setCityCode(r102);
        r109.setCityName(r101.d());
        if (r110 == null) goto L37;
        String r115 = r110.f506062c;
    L38:
        r109.setRealCityName(r115);
        r109.setData(r104);
        r109.setCode(Integer.valueOf(r111));
        if (r112 != null) goto L41;
        r112 = "";
    L41:
        r109.setDesc(r112);
        zt6.a r116 = HostServiceUtilsKt.c0();
        if (r116 == null) goto L44;
        r116.c();
        boolean r117 = true;
    L46:
        if (r117 == true) goto L52;
        r100.e("TAGGG", "抖音场景...");
        CompletionBlock<ko6.g.c> r118 = this.f257049e;
        if (r118 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("bridgeCallback");
    L51:
        r107.onRawSuccess(r109);
    L61:
        this.f257051g = true;
        return;
    L50:
        r107 = r118;
        goto L51
    L52:
        StringBuilder r119 = new StringBuilder("头条场景... ");
        r119.append(r109.getCityCode());
        r119.append(", ");
        ko6.g.d r120 = r109.getData();
        if (r120 == null) goto L55;
        String r121 = r120.getCityCode();
    L56:
        r119.append(r121);
        r100.e("TAGGG", r119.toString());
        CompletionBlock<ko6.g.c> r122 = this.f257049e;
        if (r122 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("bridgeCallback");
    L60:
        CompletionBlock.a.b(r107, r109);
        goto L61
    L59:
        r107 = r122;
        goto L60
    L55:
        r121 = null;
        goto L56
    L44:
        r117 = false;
        goto L46
    L37:
        r115 = null;
    L27:
        r113 = r103;
        goto L28
    L22:
        r108 = null;
    L18:
        r106 = r103;
    L13:
        r105 = r103;
        goto L14
    L8:
        r103 = "";
        goto L9
    }
}
