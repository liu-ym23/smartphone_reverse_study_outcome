package gd9;

import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f480965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f480966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f480967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f480968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f480969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BufferedSource f480970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Throwable f480971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f480972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f480973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f480974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f480975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Long f480976l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Object> f480977m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f480965a, r101.f480965a) == true) goto L12;
        return false;
    L12:
        if (this.f480966b == r101.f480966b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f480967c, r101.f480967c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f480968d, r101.f480968d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f480969e, r101.f480969e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f480970f, r101.f480970f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f480971g, r101.f480971g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f480972h, r101.f480972h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f480973i, r101.f480973i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f480974j, r101.f480974j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f480975k, r101.f480975k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f480976l, r101.f480976l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f480977m, r101.f480977m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f480965a.hashCode() * 31) + this.f480966b) * 31;
        Map<String, String> r101 = this.f480967c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f480968d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f480969e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        BufferedSource r111 = this.f480970f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Throwable r114 = this.f480971g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f480972h;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Long r120 = this.f480973i;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        f r123 = this.f480974j;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        Long r126 = this.f480975k;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        Long r129 = this.f480976l;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        Map<String, Object> r132 = this.f480977m;
        if (r132 == null) goto L47;
        r102 = r132.hashCode();
    L47:
        return r131 + r102;
    L41:
        r130 = r129.hashCode();
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
        return "FlowNetResult(url=" + this.f480965a + ", status=" + this.f480966b + ", headers=" + this.f480967c + ", body=" + this.f480968d + ", message=" + this.f480969e + ", stream=" + this.f480970f + ", exception=" + this.f480971g + ", originRequestUrl=" + this.f480972h + ", errorCode=" + this.f480973i + ", networkMetrics=" + this.f480974j + ", requestBodyBytes=" + this.f480975k + ", responseBodyBytes=" + this.f480976l + ", bizExtraInfo=" + this.f480977m + ')';
    }

    public final String a() {
        Map<String, String> r100 = this.f480967c;
        if (r100 == null) goto L5;
        String r101 = r100.get(NetResponse.HEADER_KEY_LOG_ID);
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean c() {
        int r100 = this.f480966b;
        if (200 <= r100) goto L5;
        return false;
    L5:
        if (r100 >= 300) goto L9;
        return true;
    L9:
        return false;
    }

    public static e b(e r110, BufferedSource r111, Long r210, int r211) {
        Map<String, Object> r100 = null;
        if ((r211 & 1) == 0) goto L5;
        String r101 = r110.f480965a;
    L7:
        if ((r211 & 2) == 0) goto L9;
        int r102 = r110.f480966b;
    L11:
        if ((r211 & 4) == 0) goto L13;
        Map<String, String> r103 = r110.f480967c;
    L15:
        if ((r211 & 8) == 0) goto L17;
        String r104 = r110.f480968d;
    L19:
        if ((r211 & 16) == 0) goto L21;
        String r105 = r110.f480969e;
    L23:
        if ((r211 & 32) == 0) goto L25;
        BufferedSource r112 = r110.f480970f;
    L27:
        if ((r211 & 64) == 0) goto L29;
        Throwable r113 = r110.f480971g;
    L31:
        if ((r211 & 128) == 0) goto L33;
        String r114 = r110.f480972h;
    L35:
        if ((r211 & 256) == 0) goto L37;
        Long r115 = r110.f480973i;
    L39:
        if ((r211 & 512) == 0) goto L41;
        f r116 = r110.f480974j;
    L43:
        if ((r211 & 1024) == 0) goto L45;
        Long r117 = r110.f480975k;
    L47:
        if ((r211 & 2048) == 0) goto L49;
        Long r118 = r110.f480976l;
    L51:
        if ((r211 & 4096) == 0) goto L53;
        r100 = r110.f480977m;
    L53:
        Intrinsics.checkNotNullParameter(r101, "url");
        return new e(r101, r102, r103, r104, r105, r112, r113, r114, r115, r116, r117, r118, r100);
    L49:
        r118 = null;
        goto L51
    L45:
        r117 = r210;
        goto L47
    L41:
        r116 = null;
        goto L43
    L37:
        r115 = null;
        goto L39
    L33:
        r114 = null;
        goto L35
    L29:
        r113 = null;
        goto L31
    L25:
        r112 = r111;
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
        r102 = 0;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public e(String r100, int r101, Map<String, String> r102, String r103, String r104, BufferedSource r105, Throwable r106, String r107, Long r110, f r111, Long r112, Long r113, Map<String, Object> r114) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f480965a = r100;
        this.f480966b = r101;
        this.f480967c = r102;
        this.f480968d = r103;
        this.f480969e = r104;
        this.f480970f = r105;
        this.f480971g = r106;
        this.f480972h = r107;
        this.f480973i = r110;
        this.f480974j = r111;
        this.f480975k = r112;
        this.f480976l = r113;
        this.f480977m = r114;
    }

    public /* synthetic */ e(String r110, int r111, Map r210, String r211, String r212, BufferedSource r213, Throwable r214, String r215, Long r216, f r217, Long r218, Long r219, Map r310, int r311) {
        if ((r311 & 32) == 0) goto L5;
        BufferedSource r100 = null;
    L7:
        if ((r311 & 64) == 0) goto L9;
        Throwable r112 = null;
    L11:
        if ((r311 & 128) == 0) goto L13;
        String r113 = null;
    L15:
        if ((r311 & 256) == 0) goto L17;
        Long r114 = null;
    L19:
        if ((r311 & 512) == 0) goto L21;
        f r115 = null;
    L23:
        if ((r311 & 1024) == 0) goto L25;
        Long r116 = null;
    L27:
        if ((r311 & 2048) == 0) goto L29;
        Long r117 = null;
    L31:
        if ((r311 & 4096) == 0) goto L33;
        Map r118 = null;
    L34:
        this(r110, r111, r210, r211, r212, r100, r112, r113, r114, r115, r116, r117, r118);
        return;
    L33:
        r118 = r310;
        goto L34
    L29:
        r117 = r219;
        goto L31
    L25:
        r116 = r218;
        goto L27
    L21:
        r115 = r217;
        goto L23
    L17:
        r114 = r216;
        goto L19
    L13:
        r113 = r215;
        goto L15
    L9:
        r112 = r214;
        goto L11
    L5:
        r100 = r213;
        goto L7
    }
}
