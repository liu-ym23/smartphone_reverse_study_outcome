package d11;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f466321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f466322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f466323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f466324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f466325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f466326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f466327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f466328h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f466329i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f466330j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f466331k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f466332l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f466333m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m f466334n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L34;
        g r101 = (g) r100;
        if (this.f466321a == r101.f466321a) goto L8;
        return false;
    L8:
        if (this.f466322b == r101.f466322b) goto L10;
        return false;
    L10:
        if (this.f466323c == r101.f466323c) goto L12;
        return false;
    L12:
        if (this.f466324d == r101.f466324d) goto L14;
        return false;
    L14:
        if (this.f466325e == r101.f466325e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f466326f, r101.f466326f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f466327g, r101.f466327g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f466328h, r101.f466328h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f466329i, r101.f466329i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f466330j, r101.f466330j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f466331k, r101.f466331k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f466332l, r101.f466332l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f466333m, r101.f466333m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f466334n, r101.f466334n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f466321a * 31) + this.f466322b) * 31;
        long r101 = this.f466323c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f466324d;
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f466325e) * 31;
        String r105 = this.f466326f;
        int r106 = 0;
        if (r105 == null) goto L5;
        int r107 = r105.hashCode();
    L6:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f466327g;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        int r111 = (r108 + r110) * 31;
        Boolean r112 = this.f466328h;
        if (r112 == null) goto L13;
        int r113 = r112.hashCode();
    L14:
        int r114 = (r111 + r113) * 31;
        Integer r115 = this.f466329i;
        if (r115 == null) goto L17;
        int r116 = r115.hashCode();
    L18:
        int r117 = (r114 + r116) * 31;
        a r118 = this.f466330j;
        if (r118 == null) goto L21;
        int r119 = r118.hashCode();
    L22:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f466331k;
        if (r121 == null) goto L25;
        int r122 = r121.hashCode();
    L26:
        int r123 = (r120 + r122) * 31;
        String r124 = this.f466332l;
        if (r124 == null) goto L29;
        int r125 = r124.hashCode();
    L30:
        int r126 = (r123 + r125) * 31;
        String r127 = this.f466333m;
        if (r127 == null) goto L33;
        int r128 = r127.hashCode();
    L34:
        int r129 = (r126 + r128) * 31;
        m r130 = this.f466334n;
        if (r130 == null) goto L38;
        r106 = r130.hashCode();
    L38:
        return r129 + r106;
    L33:
        r128 = 0;
        goto L34
    L29:
        r125 = 0;
        goto L30
    L25:
        r122 = 0;
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
        return "ReplyParams(scene=" + this.f466321a + ", bizType=" + this.f466322b + ", channelId=" + this.f466323c + ", roomId=" + this.f466324d + ", replyStats=" + this.f466325e + ", inviteUserId=" + this.f466326f + ", secInviteUserId=" + this.f466327g + ", auto=" + this.f466328h + ", multiPkMode=" + this.f466329i + ", anchorParams=" + this.f466330j + ", clientAttachInfoStr=" + this.f466331k + ", gameAppId=" + this.f466332l + ", battleAttachedInfoStr=" + this.f466333m + ", streamInfoParams=" + this.f466334n + ")";
    }

    public final l a() {
        Class<?> r100 = ((JsonAdapter) l.class.getAnnotation(JsonAdapter.class)).value();
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
        if (r105 == null) goto L47;
        l r106 = (l) r105;
        r106.setChannelId(this.f466323c);
        r106.F8(this.f466325e);
        r106.setRoomId(this.f466324d);
        r106.setBizType(this.f466322b);
        String r107 = this.f466326f;
        String r108 = "";
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        r106.R7(r107);
        String r109 = this.f466327g;
        if (r109 != null) goto L20;
        r109 = "";
    L20:
        r106.k7(r109);
        r106.setScene(this.f466321a);
        Integer r110 = this.f466329i;
        if (r110 == null) goto L23;
        r103 = r110.intValue();
    L23:
        r106.J(r103);
        r106.p4(this.f466330j.f466259i);
        r106.setMatchType(this.f466330j.f466251a);
        String r111 = this.f466331k;
        if (r111 == null) goto L27;
        r108 = r111;
    L27:
        r106.h(r108);
        r106.n(this.f466332l);
        m r112 = this.f466334n;
        long r113 = 0;
        if (r112 == null) goto L32;
        Integer r114 = r112.f466335a;
        if (r114 == null) goto L32;
        long r115 = r114.intValue();
    L33:
        r106.F(r115);
        m r116 = this.f466334n;
        if (r116 == null) goto L38;
        Integer r117 = r116.f466336b;
        if (r117 == null) goto L38;
        long r118 = r117.intValue();
    L39:
        r106.E(r118);
        m r119 = this.f466334n;
        if (r119 == null) goto L44;
        Integer r120 = r119.f466337c;
        if (r120 == null) goto L44;
        r113 = r120.intValue();
    L44:
        r106.B(r113);
        return r106;
    L38:
        r118 = 0;
    L32:
        r115 = 0;
        goto L33
    L47:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.connect.params.ServerReplyParams");
    }

    public g(int r100, int r101, long r102, long r110, int r111, String r112, String r113, Boolean r114, Integer r115, a r116, String r117, String r118, String r210, m r211) {
        Intrinsics.checkNotNullParameter(r116, "anchorParams");
        Intrinsics.checkNotNullParameter(r118, "gameAppId");
        this.f466321a = r100;
        this.f466322b = r101;
        this.f466323c = r102;
        this.f466324d = r110;
        this.f466325e = r111;
        this.f466326f = r112;
        this.f466327g = r113;
        this.f466328h = r114;
        this.f466329i = r115;
        this.f466330j = r116;
        this.f466331k = r117;
        this.f466332l = r118;
        this.f466333m = r210;
        this.f466334n = r211;
    }

    public /* synthetic */ g(int r310, int r311, long r312, long r313, int r314, String r315, String r316, Boolean r317, Integer r410, a r411, String r412, String r413, String r414, m r415, int r416) {
        if ((r416 & 128) == 0) goto L5;
        Boolean r110 = null;
    L7:
        if ((r416 & 256) == 0) goto L9;
        Integer r111 = null;
    L11:
        if ((r416 & 512) == 0) goto L13;
        a r112 = new a(0, 0, 0, null, false, false, false, null, 0, null, null, null, UnixStat.PERM_MASK);
    L15:
        if ((r416 & 1024) == 0) goto L17;
        String r113 = null;
    L19:
        if ((r416 & 2048) == 0) goto L21;
        String r114 = "";
    L23:
        if ((r416 & 4096) == 0) goto L25;
        String r115 = null;
    L27:
        if ((r416 & 8192) == 0) goto L29;
        m r116 = null;
    L30:
        this(r310, r311, r312, r313, r314, r315, r316, r110, r111, r112, r113, r114, r115, r116);
        return;
    L29:
        r116 = r415;
        goto L30
    L25:
        r115 = r414;
        goto L27
    L21:
        r114 = r413;
        goto L23
    L17:
        r113 = r412;
        goto L19
    L13:
        r112 = r411;
        goto L15
    L9:
        r111 = r410;
        goto L11
    L5:
        r110 = r317;
        goto L7
    }
}
