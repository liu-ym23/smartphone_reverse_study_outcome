package d11;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class d {
    public final String A;
    public final HashMap<String, String> B;
    public final m C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f466281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f466282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f466283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f466284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f466285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f466286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f466287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IRoom f466288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f466289i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f466290j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f466291k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f466292l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f466293m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f466294n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f466295o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f466296p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<String> f466297q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f466298r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f466299s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f466300t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f466301u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f466302v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f466303w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f466304x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f466305y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f466306z;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L64;
        d r101 = (d) r100;
        if (this.f466281a == r101.f466281a) goto L8;
        return false;
    L8:
        if (this.f466282b == r101.f466282b) goto L10;
        return false;
    L10:
        if (this.f466283c == r101.f466283c) goto L12;
        return false;
    L12:
        if (this.f466284d == r101.f466284d) goto L14;
        return false;
    L14:
        if (this.f466285e == r101.f466285e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f466286f, r101.f466286f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f466287g, r101.f466287g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f466288h, r101.f466288h) == true) goto L22;
        return false;
    L22:
        if (this.f466289i == r101.f466289i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f466290j, r101.f466290j) == true) goto L26;
        return false;
    L26:
        if (this.f466291k == r101.f466291k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f466292l, r101.f466292l) == true) goto L30;
        return false;
    L30:
        if (this.f466293m == r101.f466293m) goto L32;
        return false;
    L32:
        if (this.f466294n == r101.f466294n) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f466295o, r101.f466295o) == true) goto L36;
        return false;
    L36:
        if (this.f466296p == r101.f466296p) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f466297q, r101.f466297q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f466298r, r101.f466298r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f466299s, r101.f466299s) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.f466300t, r101.f466300t) == true) goto L46;
        return false;
    L46:
        if (this.f466301u == r101.f466301u) goto L48;
        return false;
    L48:
        if (this.f466302v == r101.f466302v) goto L50;
        return false;
    L50:
        if (this.f466303w == r101.f466303w) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.f466304x, r101.f466304x) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f466305y, r101.f466305y) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.f466306z, r101.f466306z) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.C, r101.C) == true) goto L97;
        return false;
    L97:
        return true;
    L64:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f466281a * 31;
        long r101 = this.f466282b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f466283c;
        int r104 = (((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f466284d) * 31) + this.f466285e) * 31;
        String r105 = this.f466286f;
        int r106 = 0;
        if (r105 == null) goto L5;
        int r107 = r105.hashCode();
    L6:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f466287g;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        int r111 = (r108 + r110) * 31;
        IRoom r112 = this.f466288h;
        if (r112 == null) goto L13;
        int r113 = r112.hashCode();
    L14:
        int r114 = (((r111 + r113) * 31) + this.f466289i) * 31;
        String r115 = this.f466290j;
        if (r115 == null) goto L17;
        int r116 = r115.hashCode();
    L18:
        int r117 = (((r114 + r116) * 31) + this.f466291k) * 31;
        String r118 = this.f466292l;
        if (r118 == null) goto L21;
        int r119 = r118.hashCode();
    L22:
        long r120 = this.f466293m;
        int r121 = (((((r117 + r119) * 31) + ((int) (r120 ^ (r120 >>> 32)))) * 31) + this.f466294n) * 31;
        Integer r122 = this.f466295o;
        if (r122 == null) goto L25;
        int r123 = r122.hashCode();
    L26:
        int r124 = (((r121 + r123) * 31) + this.f466296p) * 31;
        List<String> r125 = this.f466297q;
        if (r125 == null) goto L29;
        int r126 = r125.hashCode();
    L30:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f466298r;
        if (r128 == null) goto L33;
        int r129 = r128.hashCode();
    L34:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f466299s;
        if (r131 == null) goto L37;
        int r132 = r131.hashCode();
    L38:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f466300t;
        if (r134 == null) goto L41;
        int r135 = r134.hashCode();
    L42:
        int r136 = (((((r133 + r135) * 31) + this.f466301u) * 31) + this.f466302v) * 31;
        long r137 = this.f466303w;
        int r138 = (r136 + ((int) (r137 ^ (r137 >>> 32)))) * 31;
        String r139 = this.f466304x;
        if (r139 == null) goto L45;
        int r140 = r139.hashCode();
    L46:
        int r141 = (r138 + r140) * 31;
        String r142 = this.f466305y;
        if (r142 == null) goto L49;
        int r143 = r142.hashCode();
    L50:
        int r144 = (r141 + r143) * 31;
        String r145 = this.f466306z;
        if (r145 == null) goto L53;
        int r146 = r145.hashCode();
    L54:
        int r147 = (r144 + r146) * 31;
        String r148 = this.A;
        if (r148 == null) goto L57;
        int r149 = r148.hashCode();
    L58:
        int r150 = (r147 + r149) * 31;
        HashMap<String, String> r151 = this.B;
        if (r151 == null) goto L61;
        int r152 = r151.hashCode();
    L62:
        int r153 = (r150 + r152) * 31;
        m r154 = this.C;
        if (r154 == null) goto L66;
        r106 = r154.hashCode();
    L66:
        return r153 + r106;
    L61:
        r152 = 0;
        goto L62
    L57:
        r149 = 0;
        goto L58
    L53:
        r146 = 0;
        goto L54
    L49:
        r143 = 0;
        goto L50
    L45:
        r140 = 0;
        goto L46
    L41:
        r135 = 0;
        goto L42
    L37:
        r132 = 0;
        goto L38
    L33:
        r129 = 0;
        goto L34
    L29:
        r126 = 0;
        goto L30
    L25:
        r123 = 0;
        goto L26
    L21:
        r119 = 0;
        goto L22
    L17:
        r116 = 0;
        goto L18
    L13:
        r113 = 0;
        goto L14
    L9:
        r110 = 0;
        goto L10
    L5:
        r107 = 0;
        goto L6
    }

    public final String toString() {
        return "InviteParams(scene=" + this.f466281a + ", roomId=" + this.f466282b + ", toRoomId=" + this.f466283c + ", inviteType=" + this.f466284d + ", matchType=" + this.f466285e + ", toUserId=" + this.f466286f + ", secToUserId=" + this.f466287g + ", targetRoom=" + this.f466288h + ", bizType=" + this.f466289i + ", theme=" + this.f466290j + ", duration=" + this.f466291k + ", activityName=" + this.f466292l + ", matchSubType=" + this.f466293m + ", inviteSource=" + this.f466294n + ", multiPkMode=" + this.f466295o + ", inviteeScene=" + this.f466296p + ", inviteeUserIds=" + this.f466297q + ", battleConfigSettingStr=" + this.f466298r + ", panelType=" + this.f466299s + ", battleAttachedInfo=" + this.f466300t + ", inviterRoomStatus=" + this.f466301u + ", inviteIndex=" + this.f466302v + ", stayDuration=" + this.f466303w + ", requestID=" + this.f466304x + ", clientAttachedInfo=" + this.f466305y + ", openGameAppId=" + this.f466306z + ", serverAttachedInfo=" + this.A + ", logMap=" + this.B + ", streamInfoParams=" + this.C + ")";
    }

    public final j a(long r110) {
        Class<?> r100 = ((JsonAdapter) j.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r101 = vh7.b.f554981a;
        Constructor r102 = r101.get(r100);
        int r103 = 0;
        if (r102 != null) goto L12;
        r102 = r100.getConstructor(new Class[0]);
        if (r102 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r104 = r101.putIfAbsent(r100, (Constructor<? extends SerializableObjectJsonAdapterBase>) r102);
        if (r104 == null) goto L12;
        r102 = r104;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r105 = ((SerializableObjectJsonAdapterBase) r102.newInstance(new Object[0])).createInstance();
        if (r105 == null) goto L61;
        j r106 = (j) r105;
        r106.setRoomId(this.f466282b);
        r106.f(this.f466283c);
        String r107 = this.f466286f;
        long r108 = 0;
        if (r107 == null) goto L19;
        Long r109 = StringsKt.toLongOrNull(r107);
        if (r109 == null) goto L19;
        long r111 = r109.longValue();
    L20:
        r106.setToUserId(r111);
        r106.s8(String.valueOf(this.f466285e));
        r106.setDuration(this.f466291k);
        String r112 = this.f466290j;
        String r113 = "";
        if (r112 != null) goto L23;
        r112 = "";
    L23:
        r106.setTheme(r112);
        String r114 = this.f466287g;
        if (r114 != null) goto L26;
        r114 = "";
    L26:
        r106.g(r114);
        r106.A7(this.f466284d);
        r106.setScene(this.f466281a);
        r106.e1(this.f466292l);
        r106.d9((int) this.f466293m);
        r106.k3(this.f466294n);
        Integer r115 = this.f466295o;
        if (r115 == null) goto L29;
        r103 = r115.intValue();
    L29:
        r106.J(r103);
        r106.m7(this.f466296p);
        String r116 = this.f466298r;
        if (r116 != null) goto L32;
        r116 = "";
    L32:
        r106.d8(r116);
        r106.p9(this.f466301u);
        String r117 = this.f466300t;
        if (r117 != null) goto L35;
        r117 = "";
    L35:
        r106.setBattleAttachedInfo(r117);
        r106.h(this.f466305y);
        r106.n(this.f466306z);
        r106.setChannelId(r110);
        r106.setBizType(this.f466289i);
        m r118 = this.C;
        if (r118 == null) goto L49;
        Integer r119 = r118.f466335a;
        if (r119 == null) goto L40;
        long r120 = r119.intValue();
    L41:
        r106.F(r120);
        Integer r121 = r118.f466336b;
        if (r121 == null) goto L44;
        long r122 = r121.intValue();
    L45:
        r106.E(r122);
        Integer r123 = r118.f466337c;
        if (r123 == null) goto L48;
        r108 = r123.intValue();
    L48:
        r106.B(r108);
        goto L49
    L44:
        r122 = 0;
        goto L45
    L40:
        r120 = 0;
    L49:
        String r124 = this.f466286f;
        if (r124 != null) goto L52;
        r124 = "";
    L52:
        r106.setToOpenId(r124);
        List<String> r125 = this.f466297q;
        if (r125 == null) goto L58;
        String r126 = CollectionsKt.joinToString$default(r125, ",", null, null, 0, null, null, 62, null);
        if (r126 == null) goto L58;
        r113 = r126;
    L58:
        r106.G4(r113);
        return r106;
    L19:
        r111 = 0;
        goto L20
    L61:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.connect.params.ServerInviteParams");
    }

    public d(int r210, long r211, long r212, int r310, int r311, String r312, String r313, IRoom r314, int r315, String r316, int r317, String r318, long r410, int r411, Integer r412, int r413, List r414, String r415, String r416, String r417, int r418, int r510, long r511, String r512, String r513, String r514, HashMap r515, m r516, int r517) {
        if ((r517 & 512) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r517 & 1024) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r517 & 2048) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r517 & 4096) == 0) goto L17;
        long r110 = 0;
    L19:
        if ((r517 & 8192) == 0) goto L21;
        int r103 = 0;
    L23:
        if ((r517 & 16384) == 0) goto L25;
        Integer r111 = null;
    L27:
        if ((32768 & r517) == 0) goto L29;
        int r112 = 0;
    L31:
        if ((65536 & r517) == 0) goto L33;
        List r113 = null;
    L35:
        if ((r517 & 131072) == 0) goto L37;
        String r104 = "";
    L39:
        if ((r517 & 262144) == 0) goto L41;
        String r105 = null;
    L43:
        if ((524288 & r517) == 0) goto L45;
        String r106 = "";
    L47:
        if ((r517 & 1048576) == 0) goto L49;
        int r114 = 0;
    L51:
        if ((r517 & 2097152) == 0) goto L53;
        int r107 = 0;
    L55:
        if ((r517 & 4194304) == 0) goto L57;
        long r115 = 0;
    L59:
        if ((r517 & 8388608) == 0) goto L61;
        String r108 = r3;
    L63:
        if ((r517 & 16777216) == 0) goto L65;
        String r116 = r3;
    L67:
        if ((r517 & 33554432) == 0) goto L69;
        String r109 = r3;
    L71:
        if ((r517 & 67108864) == 0) goto L73;
        String r117 = "";
    L75:
        if ((r517 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L77;
        HashMap r213 = null;
    L79:
        if ((r517 & 268435456) == 0) goto L81;
        m r214 = null;
    L82:
        Intrinsics.checkNotNullParameter(r102, "activityName");
        Intrinsics.checkNotNullParameter(r108, "requestID");
        Intrinsics.checkNotNullParameter(r116, "clientAttachedInfo");
        Intrinsics.checkNotNullParameter(r109, "openGameAppId");
        Intrinsics.checkNotNullParameter(r117, "serverAttachedInfo");
        this.f466281a = r210;
        this.f466282b = r211;
        this.f466283c = r212;
        this.f466284d = r310;
        this.f466285e = r311;
        this.f466286f = r312;
        this.f466287g = r313;
        this.f466288h = r314;
        this.f466289i = r315;
        this.f466290j = r100;
        this.f466291k = r101;
        this.f466292l = r102;
        this.f466293m = r110;
        this.f466294n = r103;
        this.f466295o = r111;
        this.f466296p = r112;
        this.f466297q = r113;
        this.f466298r = r104;
        this.f466299s = r105;
        this.f466300t = r106;
        this.f466301u = r114;
        this.f466302v = r107;
        this.f466303w = r115;
        this.f466304x = r108;
        this.f466305y = r116;
        this.f466306z = r109;
        this.A = r117;
        this.B = r213;
        this.C = r214;
        return;
    L81:
        r214 = r516;
        goto L82
    L77:
        r213 = r515;
        goto L79
    L73:
        r117 = null;
        goto L75
    L69:
        r109 = r514;
        goto L71
    L65:
        r116 = r513;
        goto L67
    L61:
        r108 = r512;
        goto L63
    L57:
        r115 = r511;
        goto L59
    L53:
        r107 = r510;
        goto L55
    L49:
        r114 = r418;
        goto L51
    L45:
        r106 = r417;
        goto L47
    L41:
        r105 = r416;
        goto L43
    L37:
        r104 = r415;
        goto L39
    L33:
        r113 = r414;
        goto L35
    L29:
        r112 = r413;
        goto L31
    L25:
        r111 = r412;
        goto L27
    L21:
        r103 = r411;
        goto L23
    L17:
        r110 = r410;
        goto L19
    L13:
        r102 = r318;
        goto L15
    L9:
        r101 = r317;
        goto L11
    L5:
        r100 = r316;
        goto L7
    }
}
