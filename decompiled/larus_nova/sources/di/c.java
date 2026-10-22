package di;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f468687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f468688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f468689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f468690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f468691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f468692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f468693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f468694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f468695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f468696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f468697k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f468698l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f468699m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f468700n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f468701o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Integer f468702p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f468703q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Integer f468704r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f468705s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Long f468706t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f468707u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f468708v;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L50;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f468687a, r101.f468687a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f468688b, r101.f468688b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f468689c, r101.f468689c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468690d, r101.f468690d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f468691e, r101.f468691e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f468692f, r101.f468692f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f468693g, r101.f468693g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f468694h, r101.f468694h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f468695i, r101.f468695i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f468696j, r101.f468696j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f468697k, r101.f468697k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f468698l, r101.f468698l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f468699m, r101.f468699m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f468700n, r101.f468700n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f468701o, r101.f468701o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f468702p, r101.f468702p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f468703q, r101.f468703q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f468704r, r101.f468704r) == true) goto L42;
        return false;
    L42:
        if (this.f468705s == r101.f468705s) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.f468706t, r101.f468706t) == true) goto L46;
        return false;
    L46:
        if (this.f468707u == r101.f468707u) goto L48;
        return false;
    L48:
        if (this.f468708v == r101.f468708v) goto L76;
        return false;
    L76:
        return true;
    L50:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f468687a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f468688b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f468689c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f468690d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f468691e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f468692f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f468693g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f468694h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.f468695i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f468696j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.f468697k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.f468698l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.f468699m;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.f468700n;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.f468701o;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        Integer r146 = this.f468702p;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        Integer r149 = this.f468703q;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        Integer r152 = this.f468704r;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        long r155 = this.f468705s;
        int r156 = (r154 + ((int) (r155 ^ (r155 >>> 32)))) * 31;
        Long r157 = this.f468706t;
        if (r157 == null) goto L77;
        r101 = r157.hashCode();
    L77:
        int r158 = (r156 + r101) * 31;
        long r159 = this.f468707u;
        int r160 = (r158 + ((int) (r159 ^ (r159 >>> 32)))) * 31;
        long r161 = this.f468708v;
        return r160 + ((int) (r161 ^ (r161 >>> 32)));
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
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
        return "Duration(beforeStream=" + this.f468687a + ", bodyRecv=" + this.f468688b + ", connectDelay=" + this.f468689c + ", createStream=" + this.f468690d + ", dispatch=" + this.f468691e + ", dns=" + this.f468692f + ", edge=" + this.f468693g + ", headerRecv=" + this.f468694h + ", inner=" + this.f468695i + ", origin=" + this.f468696j + ", proxy=" + this.f468697k + ", rtt=" + this.f468698l + ", securityCallback=" + this.f468699m + ", send=" + this.f468700n + ", ssl=" + this.f468701o + ", tcp=" + this.f468702p + ", ttfb=" + this.f468703q + ", ttAgw=" + this.f468704r + ", preRequestDuration=" + this.f468705s + ", netTotalDuration=" + this.f468706t + ", afterRequestDuration=" + this.f468707u + ", responseSerializerDuration=" + this.f468708v + ")";
    }

    public final Map<String, Object> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("before_stream", this.f468687a), TuplesKt.to("body_recv", this.f468688b), TuplesKt.to("connect_delay", this.f468689c), TuplesKt.to("create_stream", this.f468690d), TuplesKt.to("dispatch", this.f468691e), TuplesKt.to(MultiProcessFileUtils.KEY_DNS, this.f468692f), TuplesKt.to("edge", this.f468693g), TuplesKt.to("header_recv", this.f468694h), TuplesKt.to(RNParamRegisterEventHandler.SRC_INNER, this.f468695i), TuplesKt.to(PlayerResolution.SDKKEY.ORIGIN, this.f468696j), TuplesKt.to("proxy", this.f468697k), TuplesKt.to("rtt", this.f468698l), TuplesKt.to("security_callback", this.f468699m), TuplesKt.to("send", this.f468700n), TuplesKt.to(TTVideoEngineInterface.PLAY_API_KEY_SSL, this.f468701o), TuplesKt.to("tcp", this.f468702p), TuplesKt.to(MonitorConstants.TTFB, this.f468703q), TuplesKt.to("pre_request_duration", Long.valueOf(this.f468705s)), TuplesKt.to("net_total_duration", this.f468706t), TuplesKt.to("after_request_duration", Long.valueOf(this.f468707u)), TuplesKt.to("response_serializer_duration", Long.valueOf(this.f468708v))});
    }

    public c(Integer r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, Integer r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, Integer r116, Integer r117, Integer r118, Integer r119, Integer r210, Integer r211, long r212, Long r213, long r214, long r215) {
        this.f468687a = r100;
        this.f468688b = r101;
        this.f468689c = r102;
        this.f468690d = r103;
        this.f468691e = r104;
        this.f468692f = r105;
        this.f468693g = r110;
        this.f468694h = r111;
        this.f468695i = r112;
        this.f468696j = r113;
        this.f468697k = r114;
        this.f468698l = r115;
        this.f468699m = r116;
        this.f468700n = r117;
        this.f468701o = r118;
        this.f468702p = r119;
        this.f468703q = r210;
        this.f468704r = r211;
        this.f468705s = r212;
        this.f468706t = r213;
        this.f468707u = r214;
        this.f468708v = r215;
    }
}
