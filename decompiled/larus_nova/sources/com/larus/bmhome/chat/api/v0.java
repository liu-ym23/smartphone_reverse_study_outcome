package com.larus.bmhome.chat.api;

import android.view.ViewGroup;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f297255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f297256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f297257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f297258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f297259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f297260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f297261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ic8.x f297262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f297263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f297264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, String> f297265k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, Object> f297266l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f297267m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f297268n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f297269o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f297270p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, Object> f297271q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v0) == true) goto L8;
        return false;
    L8:
        v0 r101 = (v0) r100;
        if (Intrinsics.areEqual(this.f297255a, r101.f297255a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f297256b, r101.f297256b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f297257c, r101.f297257c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f297258d, r101.f297258d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f297259e, r101.f297259e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f297260f, r101.f297260f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f297261g, r101.f297261g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f297262h, r101.f297262h) == true) goto L33;
        return false;
    L33:
        if (this.f297263i == r101.f297263i) goto L36;
        return false;
    L36:
        if (this.f297264j == r101.f297264j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f297265k, r101.f297265k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f297266l, r101.f297266l) == true) goto L45;
        return false;
    L45:
        if (this.f297267m == r101.f297267m) goto L48;
        return false;
    L48:
        if (this.f297268n == r101.f297268n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f297269o, r101.f297269o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f297270p, r101.f297270p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f297271q, r101.f297271q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f297255a.hashCode() * 31;
        String r101 = this.f297256b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f297257c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f297258d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f297259e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f297260f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        ViewGroup r117 = this.f297261g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        ic8.x r120 = this.f297262h;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (((((r119 + r121) * 31) + this.f297263i) * 31) + this.f297264j) * 31;
        Map<String, String> r123 = this.f297265k;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        Map<String, Object> r126 = this.f297266l;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        int r129 = 1231;
        if (this.f297267m == false) goto L41;
        int r130 = 1231;
    L42:
        int r131 = (r128 + r130) * 31;
        if (this.f297268n == true) goto L46;
        r129 = 1237;
    L46:
        int r132 = (r131 + r129) * 31;
        String r133 = this.f297269o;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        String r136 = this.f297270p;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (r135 + r137) * 31;
        Map<String, Object> r139 = this.f297271q;
        if (r139 == null) goto L59;
        r102 = r139.hashCode();
    L59:
        return r138 + r102;
    L53:
        r137 = r136.hashCode();
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L41:
        r130 = 1237;
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "WidgetRenderData(msgId=" + this.f297255a + ", botId=" + this.f297256b + ", convId=" + this.f297257c + ", sectionId=" + this.f297258d + ", replyId=" + this.f297259e + ", renderData=" + this.f297260f + ", parent=" + this.f297261g + ", widgetLifeObserver=" + this.f297262h + ", currentPosition=" + this.f297263i + ", maxWidth=" + this.f297264j + ", ext=" + this.f297265k + ", params=" + this.f297266l + ", enableCache=" + this.f297267m + ", enableRecycler=" + this.f297268n + ", templateUrl=" + this.f297269o + ", widgetTheme=" + this.f297270p + ", extra=" + this.f297271q + ')';
    }

    public static v0 a(v0 r210, String r211, int r212) {
        Map<String, Object> r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = r210.f297255a;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = r210.f297256b;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = r210.f297257c;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = r210.f297258d;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = r210.f297259e;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r110 = r210.f297260f;
    L27:
        if ((r212 & 64) == 0) goto L29;
        ViewGroup r111 = r210.f297261g;
    L31:
        if ((r212 & 128) == 0) goto L33;
        ic8.x r112 = r210.f297262h;
    L35:
        if ((r212 & 256) == 0) goto L37;
        int r113 = r210.f297263i;
    L39:
        if ((r212 & 512) == 0) goto L41;
        int r114 = r210.f297264j;
    L43:
        if ((r212 & 1024) == 0) goto L45;
        Map<String, String> r115 = r210.f297265k;
    L47:
        if ((r212 & 2048) == 0) goto L49;
        Map<String, Object> r116 = r210.f297266l;
    L51:
        if ((r212 & 4096) == 0) goto L53;
        boolean r117 = r210.f297267m;
    L55:
        if ((r212 & 8192) == 0) goto L57;
        boolean r118 = r210.f297268n;
    L59:
        if ((r212 & 16384) == 0) goto L61;
        String r119 = r210.f297269o;
    L63:
        if ((32768 & r212) == 0) goto L65;
        String r213 = r210.f297270p;
    L67:
        if ((r212 & 65536) == 0) goto L69;
        r100 = r210.f297271q;
    L69:
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.MSGID);
        return new v0(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r213, r100);
    L65:
        r213 = null;
        goto L67
    L61:
        r119 = null;
        goto L63
    L57:
        r118 = false;
        goto L59
    L53:
        r117 = false;
        goto L55
    L49:
        r116 = null;
        goto L51
    L45:
        r115 = null;
        goto L47
    L41:
        r114 = 0;
        goto L43
    L37:
        r113 = 0;
        goto L39
    L33:
        r112 = null;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = r211;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public v0(String r100, String r101, String r102, String r103, String r104, String r105, ViewGroup r110, ic8.x r111, int r112, int r113, Map<String, String> r114, Map<String, ? extends Object> r115, boolean r116, boolean r117, String r118, String r119, Map<String, ? extends Object> r210) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        this.f297255a = r100;
        this.f297256b = r101;
        this.f297257c = r102;
        this.f297258d = r103;
        this.f297259e = r104;
        this.f297260f = r105;
        this.f297261g = r110;
        this.f297262h = r111;
        this.f297263i = r112;
        this.f297264j = r113;
        this.f297265k = r114;
        this.f297266l = r115;
        this.f297267m = r116;
        this.f297268n = r117;
        this.f297269o = r118;
        this.f297270p = r119;
        this.f297271q = r210;
    }

    public /* synthetic */ v0(String r210, String r211, String r212, String r213, String r214, String r215, ViewGroup r216, ic8.x r217, int r310, int r311, Map r312, Map r313, boolean r314, boolean r315, String r316, String r317, Map r318, int r319) {
        if ((r319 & 4096) == 0) goto L5;
        boolean r110 = true;
    L7:
        if ((r319 & 8192) == 0) goto L9;
        boolean r111 = true;
    L11:
        if ((r319 & 16384) == 0) goto L13;
        String r112 = null;
    L15:
        if ((32768 & r319) == 0) goto L17;
        String r113 = null;
    L19:
        if ((r319 & 65536) == 0) goto L21;
        Map r218 = null;
    L22:
        this(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r110, r111, r112, r113, r218);
        return;
    L21:
        r218 = r318;
        goto L22
    L17:
        r113 = r317;
        goto L19
    L13:
        r112 = r316;
        goto L15
    L9:
        r111 = r315;
        goto L11
    L5:
        r110 = r314;
        goto L7
    }
}
