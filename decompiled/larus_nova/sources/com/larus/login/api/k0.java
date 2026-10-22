package com.larus.login.api;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f357061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f357062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f357063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f357064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f357065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f357066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b0 f357067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f357068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Bundle f357069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f357070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f357071k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f357072l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f357073m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f357074n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function3<String, String, NotifyBinderDialogType, Unit> f357075o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f357076p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f357077q;

    public k0() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.f357061a, r101.f357061a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f357062b, r101.f357062b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f357063c, r101.f357063c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f357064d, r101.f357064d) == true) goto L21;
        return false;
    L21:
        if (this.f357065e == r101.f357065e) goto L24;
        return false;
    L24:
        if (this.f357066f == r101.f357066f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f357067g, r101.f357067g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f357068h, r101.f357068h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f357069i, r101.f357069i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f357070j, r101.f357070j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f357071k, r101.f357071k) == true) goto L42;
        return false;
    L42:
        if (this.f357072l == r101.f357072l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f357073m, r101.f357073m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f357074n, r101.f357074n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f357075o, r101.f357075o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f357076p, r101.f357076p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f357077q, r101.f357077q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f357061a.hashCode() * 31) + this.f357062b.hashCode()) * 31) + this.f357063c.hashCode()) * 31) + this.f357064d.hashCode()) * 31;
        int r101 = 1231;
        if (this.f357065e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f357066f == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (((((((r103 + r101) * 31) + this.f357067g.hashCode()) * 31) + this.f357068h.hashCode()) * 31) + this.f357069i.hashCode()) * 31;
        i r105 = this.f357070j;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        i r109 = this.f357071k;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        long r111 = this.f357072l;
        int r112 = (((((r108 + r110) * 31) + ((int) (r111 ^ (r111 >>> 32)))) * 31) + this.f357073m.hashCode()) * 31;
        b r113 = this.f357074n;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Function3<String, String, NotifyBinderDialogType, Unit> r116 = this.f357075o;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f357076p;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f357077q;
        if (r122 == null) goto L35;
        r106 = r122.hashCode();
    L35:
        return r121 + r106;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ToBindDouYinInfo(activity=" + this.f357061a + ", sourcePage=" + this.f357062b + ", sourceMethod=" + this.f357063c + ", popUpType=" + this.f357064d + ", goMarket=" + this.f357065e + ", forceRequestServer=" + this.f357066f + ", callback=" + this.f357067g + ", extraEventParams=" + this.f357068h + ", tokenPassThroughExtraInfo=" + this.f357069i + ", notifyBinderBasicConfig=" + this.f357070j + ", checkNeedBinderBasicConfig=" + this.f357071k + ", loadingStartDelay=" + this.f357072l + ", bindResultToastConfig=" + this.f357073m + ", authPanelEventCallback=" + this.f357074n + ", onDialogShow=" + this.f357075o + ", requiredScopes=" + this.f357076p + ", optionalScopes=" + this.f357077q + ')';
    }

    public final b0 a() {
        return this.f357067g;
    }

    public final Map<String, Object> b() {
        return this.f357068h;
    }

    public final long c() {
        return this.f357072l;
    }

    public final String d() {
        return this.f357063c;
    }

    public final String e() {
        return this.f357062b;
    }

    public final Bundle f() {
        return this.f357069i;
    }

    public final FragmentActivity getActivity() {
        return this.f357061a;
    }

    public k0(FragmentActivity r110, String r210, String r211, String r212, boolean r213, boolean r214, b0 r215, Map r216, Bundle r217, i r218, i r219, long r310, d r311, com.larus.login.api.ecommerce.i.a r312, Function3 r313, String r314, String r315, int r316) {
        if ((r316 & 8) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r316 & 128) == 0) goto L9;
        Map r101 = MapsKt.emptyMap();
    L11:
        if ((r316 & 256) == 0) goto L13;
        Bundle r102 = new Bundle();
    L15:
        if ((r316 & 512) == 0) goto L17;
        i r103 = null;
    L19:
        if ((r316 & 1024) == 0) goto L21;
        i r111 = null;
    L23:
        if ((r316 & 2048) == 0) goto L25;
        long r112 = 0;
    L27:
        if ((r316 & 4096) == 0) goto L29;
        d r113 = new d(false, 7);
    L31:
        if ((r316 & 8192) == 0) goto L33;
        com.larus.login.api.ecommerce.i.a r114 = null;
    L35:
        if ((r316 & 16384) == 0) goto L37;
        Function3 r115 = null;
    L39:
        if ((r316 & 32768) == 0) goto L41;
        String r116 = null;
    L43:
        if ((r316 & 65536) == 0) goto L45;
        String r117 = null;
    L46:
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r210, "sourcePage");
        Intrinsics.checkNotNullParameter(r211, "sourceMethod");
        Intrinsics.checkNotNullParameter(r100, "popUpType");
        Intrinsics.checkNotNullParameter(r215, "callback");
        Intrinsics.checkNotNullParameter(r101, "extraEventParams");
        Intrinsics.checkNotNullParameter(r102, "tokenPassThroughExtraInfo");
        Intrinsics.checkNotNullParameter(r113, "bindResultToastConfig");
        this.f357061a = r110;
        this.f357062b = r210;
        this.f357063c = r211;
        this.f357064d = r100;
        this.f357065e = r213;
        this.f357066f = r214;
        this.f357067g = r215;
        this.f357068h = r101;
        this.f357069i = r102;
        this.f357070j = r103;
        this.f357071k = r111;
        this.f357072l = r112;
        this.f357073m = r113;
        this.f357074n = r114;
        this.f357075o = r115;
        this.f357076p = r116;
        this.f357077q = r117;
        return;
    L45:
        r117 = r315;
        goto L46
    L41:
        r116 = r314;
        goto L43
    L37:
        r115 = r313;
        goto L39
    L33:
        r114 = r312;
        goto L35
    L29:
        r113 = r311;
        goto L31
    L25:
        r112 = r310;
        goto L27
    L21:
        r111 = r219;
        goto L23
    L17:
        r103 = r218;
        goto L19
    L13:
        r102 = r217;
        goto L15
    L9:
        r101 = r216;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }
}
