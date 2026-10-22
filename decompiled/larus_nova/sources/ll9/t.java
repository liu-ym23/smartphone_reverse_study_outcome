package ll9;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.multitask_management.api.data.quick_access.NodeType;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class t {
    public static final b Companion = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f509773k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NodeType f509774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f509776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f509777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f509778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f509779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f509780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ll9.a f509781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f509782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f509783j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f509784a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f509785b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f509785b;
        }

        static {
            a r100 = new a();
            f509784a = r100;
            g2 r101 = new g2("com.larus.multitask_management.api.data.quick_access.QuickAccessNode", r100, 10);
            r101.j("node_type", true);
            r101.j("reference_id", true);
            r101.j("title", true);
            r101.j("icon_url", true);
            r101.j(BdpAppEventConstant.PARAMS_SUB_TITLE, true);
            r101.j("dark_icon_url", true);
            r101.j("preview_url", true);
            r101.j("action", true);
            r101.j("extra_info", true);
            r101.j("update_time_us", true);
            f509785b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = t.f509773k;
            v2 r101 = v2.f520790a;
            return new juc.d[]{n.f509758a, r101, r101, r101, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(ll9.a.C6709a.f509712a), kuc.a.d(r100[8].getValue()), kuc.a.d(g1.f520681a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f509785b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = t.f509773k;
            int r103 = 8;
            NodeType r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            NodeType r104 = (NodeType) r101.decodeSerializableElement(r100, 0, n.f509758a, null);
            String r111 = r101.decodeStringElement(r100, 1);
            String r112 = r101.decodeStringElement(r100, 2);
            String r105 = r101.decodeStringElement(r100, 3);
            v2 r113 = v2.f520790a;
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 4, r113, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 5, r113, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 6, r113, null);
            ll9.a r108 = (ll9.a) r101.decodeNullableSerializableElement(r100, 7, ll9.a.C6709a.f509712a, null);
            Map r115 = (Map) r101.decodeNullableSerializableElement(r100, 8, r102[8].getValue(), null);
            NodeType r109 = r104;
            Long r116 = (Long) r101.decodeNullableSerializableElement(r100, 9, g1.f520681a, null);
            String r117 = r106;
            String r118 = r107;
            ll9.a r119 = r108;
            String r120 = r114;
            int r121 = 1023;
            String r122 = r112;
            String r123 = r111;
            String r124 = r105;
        L28:
            r101.endStructure(r100);
            return new t(r121, r109, r123, r122, r124, r120, r117, r118, r119, r115, r116);
        L5:
            Long r125 = null;
            Map r126 = null;
            String r127 = null;
            String r128 = null;
            ll9.a r129 = null;
            String r130 = null;
            String r131 = null;
            String r211 = null;
            String r212 = null;
            int r132 = 0;
            boolean r213 = true;
        L6:
            if (r213 == false) goto L27;
            int r133 = r101.decodeElementIndex(r100);
            switch(r133) {
                case -1: goto L26;
                case 0: goto L24;
                case 1: goto L22;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L17;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r133);
        L26:
            r213 = false;
            goto L6
        L11:
            r125 = (Long) r101.decodeNullableSerializableElement(r100, 9, g1.f520681a, r125);
            r132 = r132 | 512;
        L25:
            r103 = 8;
            goto L6
        L12:
            r126 = (Map) r101.decodeNullableSerializableElement(r100, r103, r102[r103].getValue(), r126);
            r132 = r132 | 256;
            goto L25
        L13:
            r129 = (ll9.a) r101.decodeNullableSerializableElement(r100, 7, ll9.a.C6709a.f509712a, r129);
            r132 = r132 | 128;
            goto L25
        L14:
            r127 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r127);
            r132 = r132 | 64;
            goto L25
        L15:
            r128 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r128);
            r132 = r132 | 32;
            goto L25
        L17:
            r130 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r130);
            r132 = r132 | 16;
            goto L25
        L19:
            r131 = r101.decodeStringElement(r100, 3);
            r132 = r132 | 8;
            goto L25
        L20:
            r211 = r101.decodeStringElement(r100, 2);
            r132 = r132 | 4;
            goto L25
        L22:
            r212 = r101.decodeStringElement(r100, 1);
            r132 = r132 | 2;
            goto L25
        L24:
            r132 = r132 | 1;
            r110 = (NodeType) r101.decodeSerializableElement(r100, 0, n.f509758a, r110);
            goto L25
        L27:
            r121 = r132;
            r116 = r125;
            r115 = r126;
            r119 = r129;
            r109 = r110;
            r120 = r130;
            r123 = r212;
            r118 = r127;
            r117 = r128;
            r124 = r131;
            r122 = r211;
            goto L28
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            t r102 = (t) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f509785b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = t.f509773k;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeSerializableElement(r103, 0, n.f509758a, r102.f509774a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeStringElement(r103, 1, r102.f509775b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeStringElement(r103, 2, r102.f509776c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeStringElement(r103, 3, r102.f509777d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeNullableSerializableElement(r103, 4, v2.f520790a, r102.f509778e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r104.encodeNullableSerializableElement(r103, 5, v2.f520790a, r102.f509779f);
        L57:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
        L61:
            boolean r113 = true;
        L63:
            if (r113 == false) goto L66;
            r104.encodeNullableSerializableElement(r103, 6, v2.f520790a, r102.f509780g);
        L66:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r104.encodeNullableSerializableElement(r103, 7, ll9.a.C6709a.f509712a, r102.f509781h);
        L75:
            if (r104.shouldEncodeElementDefault(r103, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r104.encodeNullableSerializableElement(r103, 8, r105[8].getValue(), r102.f509782i);
        L84:
            if (r104.shouldEncodeElementDefault(r103, 9) == false) goto L87;
        L88:
            r106 = true;
        L89:
            if (r106 == false) goto L91;
            r104.encodeNullableSerializableElement(r103, 9, g1.f520681a, r102.f509783j);
        L91:
            r104.endStructure(r103);
            return;
        L87:
            if (r102.f509783j == null) goto L89;
        L78:
            if (r102.f509782i != null) goto L79;
            r115 = false;
            goto L81
        L69:
            if (Intrinsics.areEqual(r102.f509781h, new ll9.a(0)) == false) goto L70;
            r114 = false;
            goto L72
        L60:
            if (r102.f509780g != null) goto L61;
            r113 = false;
            goto L63
        L51:
            if (r102.f509779f != null) goto L52;
            r112 = false;
            goto L54
        L42:
            if (r102.f509778e != null) goto L43;
            r111 = false;
            goto L45
        L33:
            if (Intrinsics.areEqual(r102.f509777d, "") == false) goto L34;
            r110 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r102.f509776c, "") == false) goto L25;
            r109 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r102.f509775b, "") == false) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f509774a != NodeType.UNKNOWN) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<t> serializer() {
            return a.f509784a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.f509774a == r101.f509774a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509775b, r101.f509775b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f509776c, r101.f509776c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f509777d, r101.f509777d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f509778e, r101.f509778e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f509779f, r101.f509779f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f509780g, r101.f509780g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f509781h, r101.f509781h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f509782i, r101.f509782i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f509783j, r101.f509783j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f509774a.hashCode() * 31) + this.f509775b.hashCode()) * 31) + this.f509776c.hashCode()) * 31) + this.f509777d.hashCode()) * 31;
        String r101 = this.f509778e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f509779f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f509780g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        ll9.a r111 = this.f509781h;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Map<String, String> r114 = this.f509782i;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Long r117 = this.f509783j;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
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
        return "QuickAccessNode(nodeType=" + this.f509774a + ", referenceId=" + this.f509775b + ", title=" + this.f509776c + ", iconUrl=" + this.f509777d + ", subTitle=" + this.f509778e + ", darkIconUrl=" + this.f509779f + ", previewUrl=" + this.f509780g + ", action=" + this.f509781h + ", extraInfo=" + this.f509782i + ", updateTimeUs=" + this.f509783j + ')';
    }

    static {
        Companion = new b();
        f509773k = new Lazy[]{null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new s()), null};
    }

    public t() {
        this(NodeType.UNKNOWN, "", "", "", null, null, null, new ll9.a(0), null, null);
    }

    public t(NodeType r100, String r101, String r102, String r103, String r104, String r105, String r106, ll9.a r107, Map<String, String> r110, Long r111) {
        Intrinsics.checkNotNullParameter(r100, "nodeType");
        Intrinsics.checkNotNullParameter(r101, "referenceId");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, "iconUrl");
        this.f509774a = r100;
        this.f509775b = r101;
        this.f509776c = r102;
        this.f509777d = r103;
        this.f509778e = r104;
        this.f509779f = r105;
        this.f509780g = r106;
        this.f509781h = r107;
        this.f509782i = r110;
        this.f509783j = r111;
    }

    public t(int r100, NodeType r101, String r102, String r103, String r104, String r105, String r110, String r111, ll9.a r112, Map r113, Long r114) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f509785b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = NodeType.UNKNOWN;
    L7:
        this.f509774a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f509775b = "";
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f509776c = "";
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f509777d = "";
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.f509778e = null;
    L24:
        if ((r100 & 32) != 0) goto L26;
        this.f509779f = null;
    L28:
        if ((r100 & 64) != 0) goto L30;
        this.f509780g = null;
    L32:
        if ((r100 & 128) != 0) goto L34;
        this.f509781h = new ll9.a(0);
    L36:
        if ((r100 & 256) != 0) goto L38;
        this.f509782i = null;
    L40:
        if ((r100 & 512) != 0) goto L42;
        this.f509783j = null;
        return;
    L42:
        this.f509783j = r114;
        return;
    L38:
        this.f509782i = r113;
        goto L40
    L34:
        this.f509781h = r112;
        goto L36
    L30:
        this.f509780g = r111;
        goto L32
    L26:
        this.f509779f = r110;
        goto L28
    L22:
        this.f509778e = r105;
        goto L24
    L18:
        this.f509777d = r104;
        goto L20
    L14:
        this.f509776c = r103;
        goto L16
    L10:
        this.f509775b = r102;
        goto L12
    }
}
