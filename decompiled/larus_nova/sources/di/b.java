package di;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f468670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f468671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f468672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f468673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f468674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f468675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f468676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f468677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f468678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f468679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f468680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f468681l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f468682m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f468683n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f468684o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Integer f468685p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f468686q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L40;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f468670a, r101.f468670a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f468671b, r101.f468671b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f468672c, r101.f468672c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468673d, r101.f468673d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f468674e, r101.f468674e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f468675f, r101.f468675f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f468676g, r101.f468676g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f468677h, r101.f468677h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f468678i, r101.f468678i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f468679j, r101.f468679j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f468680k, r101.f468680k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f468681l, r101.f468681l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f468682m, r101.f468682m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f468683n, r101.f468683n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f468684o, r101.f468684o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f468685p, r101.f468685p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f468686q, r101.f468686q) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f468670a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f468671b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f468672c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f468673d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f468674e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f468675f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f468676g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f468677h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f468678i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f468679j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f468680k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f468681l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.f468682m;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.f468683n;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.f468684o;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        Integer r146 = this.f468685p;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        Integer r149 = this.f468686q;
        if (r149 == null) goto L70;
        r101 = r149.hashCode();
    L70:
        return r148 + r101;
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Dimension(path=" + this.f468670a + ", method=" + this.f468671b + ", code=" + this.f468672c + ", receivedBytes=" + this.f468673d + ", sentBytes=" + this.f468674e + ", socketReused=" + this.f468675f + ", connectionInfo=" + this.f468676g + ", netThreadPriority=" + this.f468677h + ", ttnetVersion=" + this.f468678i + ", priorityLevel=" + this.f468679j + ", requestCompressType=" + this.f468680k + ", responseCompressType=" + this.f468681l + ", downlinkThroughput=" + this.f468682m + ", effectiveNetType=" + this.f468683n + ", httpRtt=" + this.f468684o + ", tcpRtt=" + this.f468685p + ", realNetType=" + this.f468686q + ")";
    }

    public final Map<String, Object> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("path", this.f468670a), TuplesKt.to(com.alipay.sdk.m.p.e.f25671s, this.f468671b), TuplesKt.to("code", this.f468672c), TuplesKt.to(StreamTrafficObservable.STREAM_RECEIVEDBYTES, this.f468673d), TuplesKt.to(StreamTrafficObservable.STREAM_SENTBYTES, this.f468674e), TuplesKt.to("socket_reused", this.f468675f), TuplesKt.to("connection_info", this.f468676g), TuplesKt.to("net_thread_priority", this.f468677h), TuplesKt.to("ttnet_version", this.f468678i), TuplesKt.to("priority_level", this.f468679j), TuplesKt.to("request_compress_type", this.f468680k), TuplesKt.to("response_compress_type", this.f468681l), TuplesKt.to("downlink_throughput", this.f468682m), TuplesKt.to("effective_net_type", this.f468683n), TuplesKt.to("http_rtt", this.f468684o), TuplesKt.to("tcp_rtt", this.f468685p), TuplesKt.to("real_net_type", this.f468686q)});
    }

    public b(String r100, String r101, Integer r102, Integer r103, Integer r104, Integer r105, Integer r106, Integer r110, String r111, Integer r112, String r113, String r114, Integer r115, Integer r116, Integer r117, Integer r118, Integer r119) {
        this.f468670a = r100;
        this.f468671b = r101;
        this.f468672c = r102;
        this.f468673d = r103;
        this.f468674e = r104;
        this.f468675f = r105;
        this.f468676g = r106;
        this.f468677h = r110;
        this.f468678i = r111;
        this.f468679j = r112;
        this.f468680k = r113;
        this.f468681l = r114;
        this.f468682m = r115;
        this.f468683n = r116;
        this.f468684o = r117;
        this.f468685p = r118;
        this.f468686q = r119;
    }
}
