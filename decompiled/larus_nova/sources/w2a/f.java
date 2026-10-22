package w2a;

import com.larus.im.bean.bot.MixVoice;
import com.ss.texturerender.TextureRenderKeys;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes32.dex */
@Serializable
public final class f {
    public static final b Companion = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f558066k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<MixVoice> f558067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f558068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f558069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f558070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f558071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f558072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f558073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f558074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f558075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f558076j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f558077a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f558078b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f558078b;
        }

        static {
            a r100 = new a();
            f558077a = r100;
            g2 r101 = new g2("com.larus.voice_setting.voice.mix.res.VoiceEditInfo", r100, 10);
            r101.j("mix_list", true);
            r101.j(TextureRenderKeys.KEY_IS_PITCH, true);
            r101.j("rate", true);
            r101.j("pitch_f64", true);
            r101.j("speech_rate_f64", true);
            r101.j("style_id", true);
            r101.j("preview_url", true);
            r101.j("added_voice_tab_name", true);
            r101.j("single_select_click_position", true);
            r101.j("enter_method", true);
            f558078b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            l0 r101 = l0.f520731a;
            v2 r102 = v2.f520790a;
            return new juc.d[]{kuc.a.d(f.f558066k[0].getValue()), r100, r100, r101, r101, kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r100), kuc.a.d(r102)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f558078b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = f.f558066k;
            int r103 = 8;
            int r104 = 7;
            int r110 = 0;
            if (r101.decodeSequentially() == false) goto L5;
            List r105 = (List) r101.decodeNullableSerializableElement(r100, 0, r102[0].getValue(), null);
            int r106 = r101.decodeIntElement(r100, 1);
            int r111 = r101.decodeIntElement(r100, 2);
            float r107 = r101.decodeFloatElement(r100, 3);
            float r112 = r101.decodeFloatElement(r100, 4);
            v2 r113 = v2.f520790a;
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 5, r113, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 6, r113, null);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 7, r113, null);
            Integer r115 = (Integer) r101.decodeNullableSerializableElement(r100, 8, w0.f520792a, null);
            float r116 = r107;
            String r117 = r108;
            String r118 = r109;
            String r119 = r114;
            String r120 = (String) r101.decodeNullableSerializableElement(r100, 9, r113, null);
            int r121 = r111;
            float r122 = r112;
            int r123 = 1023;
            List r124 = r105;
            int r125 = r106;
        L31:
            r101.endStructure(r100);
            return new f(r123, r124, r125, r121, r116, r122, r117, r118, r119, r115, r120);
        L5:
            String r126 = null;
            String r127 = null;
            Integer r128 = null;
            String r129 = null;
            String r130 = null;
            List r131 = null;
            int r132 = 0;
            float r133 = 0.0f;
            int r134 = 0;
            float r135 = 0.0f;
            boolean r211 = true;
        L6:
            if (r211 == false) goto L30;
            int r136 = r101.decodeElementIndex(r100);
            switch(r136) {
                case -1: goto L29;
                case 0: goto L27;
                case 1: goto L24;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L14;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r136);
        L29:
            r103 = 8;
            r104 = 7;
            r211 = false;
            goto L6
        L11:
            r126 = (String) r101.decodeNullableSerializableElement(r100, 9, v2.f520790a, r126);
            int r137 = r110 | 512;
        L13:
            r110 = r137;
        L28:
            r103 = 8;
            r104 = 7;
            goto L6
        L12:
            r128 = (Integer) r101.decodeNullableSerializableElement(r100, r103, w0.f520792a, r128);
            r137 = r110 | 256;
            goto L13
        L14:
            r129 = (String) r101.decodeNullableSerializableElement(r100, r104, v2.f520790a, r129);
            r110 = r110 | 128;
        L25:
            r132 = r132;
            goto L28
        L16:
            r127 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r127);
            r110 = r110 | 64;
            goto L25
        L17:
            r130 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r130);
            r110 = r110 | 32;
            goto L25
        L19:
            r135 = r101.decodeFloatElement(r100, 4);
            r110 = r110 | 16;
            goto L25
        L21:
            r110 = r110 | 8;
            r133 = r101.decodeFloatElement(r100, 3);
            int r212 = r134;
        L23:
            r134 = r212;
            r132 = r132;
            goto L25
        L22:
            r212 = r101.decodeIntElement(r100, 2);
            r110 = r110 | 4;
            goto L23
        L24:
            r132 = r101.decodeIntElement(r100, 1);
            r110 = r110 | 2;
            goto L25
        L27:
            r131 = (List) r101.decodeNullableSerializableElement(r100, 0, r102[0].getValue(), r131);
            r110 = r110 | 1;
            goto L28
        L30:
            List r138 = r131;
            r120 = r126;
            r115 = r128;
            r119 = r129;
            r123 = r110;
            r116 = r133;
            r122 = r135;
            r125 = r132;
            r118 = r127;
            r124 = r138;
            int r213 = r134;
            r117 = r130;
            r121 = r213;
            goto L31
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            f r102 = (f) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f558078b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = f.f558066k;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, r105[0].getValue(), r102.f558067a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeIntElement(r103, 1, r102.f558068b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeIntElement(r103, 2, r102.f558069c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeFloatElement(r103, 3, r102.f558070d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeFloatElement(r103, 4, r102.f558071e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r104.encodeNullableSerializableElement(r103, 5, v2.f520790a, r102.f558072f);
        L57:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
        L61:
            boolean r113 = true;
        L63:
            if (r113 == false) goto L66;
            r104.encodeNullableSerializableElement(r103, 6, v2.f520790a, r102.f558073g);
        L66:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r104.encodeNullableSerializableElement(r103, 7, v2.f520790a, r102.f558074h);
        L75:
            if (r104.shouldEncodeElementDefault(r103, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r104.encodeNullableSerializableElement(r103, 8, w0.f520792a, r102.f558075i);
        L84:
            if (r104.shouldEncodeElementDefault(r103, 9) == false) goto L87;
        L88:
            r106 = true;
        L89:
            if (r106 == false) goto L91;
            r104.encodeNullableSerializableElement(r103, 9, v2.f520790a, r102.f558076j);
        L91:
            r104.endStructure(r103);
            return;
        L87:
            if (r102.f558076j == null) goto L89;
        L78:
            if (r102.f558075i != null) goto L79;
            r115 = false;
            goto L81
        L69:
            if (r102.f558074h != null) goto L70;
            r114 = false;
            goto L72
        L60:
            if (r102.f558073g != null) goto L61;
            r113 = false;
            goto L63
        L51:
            if (r102.f558072f != null) goto L52;
            r112 = false;
            goto L54
        L42:
            if (Float.compare(r102.f558071e, 10.0f) != 0) goto L43;
            r111 = false;
            goto L45
        L33:
            if (Float.compare(r102.f558070d, 0.0f) != 0) goto L34;
            r110 = false;
            goto L36
        L24:
            if (r102.f558069c != 10) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f558068b != 0) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f558067a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f> serializer() {
            return a.f558077a;
        }
    }

    public f() {
        this(null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f558067a, r101.f558067a) == true) goto L12;
        return false;
    L12:
        if (this.f558068b == r101.f558068b) goto L15;
        return false;
    L15:
        if (this.f558069c == r101.f558069c) goto L18;
        return false;
    L18:
        if (Float.compare(this.f558070d, r101.f558070d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f558071e, r101.f558071e) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f558072f, r101.f558072f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f558073g, r101.f558073g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f558074h, r101.f558074h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f558075i, r101.f558075i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f558076j, r101.f558076j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        List<MixVoice> r100 = this.f558067a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((((r102 * 31) + this.f558068b) * 31) + this.f558069c) * 31) + Float.floatToIntBits(this.f558070d)) * 31) + Float.floatToIntBits(this.f558071e)) * 31;
        String r104 = this.f558072f;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f558073g;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f558074h;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f558075i;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f558076j;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceEditInfo(list=" + this.f558067a + ", pitch=" + this.f558068b + ", speechRate=" + this.f558069c + ", pitchF64=" + this.f558070d + ", speechRateF64=" + this.f558071e + ", styleId=" + this.f558072f + ", previewUrl=" + this.f558073g + ", lastAddedVoiceTabName=" + this.f558074h + ", clickPosition=" + this.f558075i + ", enterMethod=" + this.f558076j + ')';
    }

    static {
        Companion = new b();
        f558066k = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new e()), null, null, null, null, null, null, null, null, null};
    }

    public f(int r100, List r101, int r102, int r103, float r104, float r105, String r110, String r111, String r112, Integer r113, String r114) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f558078b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f558067a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f558068b = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f558069c = 10;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f558070d = 0.0f;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f558071e = 10.0f;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f558072f = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f558073g = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f558074h = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.f558075i = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.f558076j = null;
        return;
    L43:
        this.f558076j = r114;
        return;
    L39:
        this.f558075i = r113;
        goto L41
    L35:
        this.f558074h = r112;
        goto L37
    L31:
        this.f558073g = r111;
        goto L33
    L27:
        this.f558072f = r110;
        goto L29
    L23:
        this.f558071e = r105;
        goto L25
    L19:
        this.f558070d = r104;
        goto L21
    L15:
        this.f558069c = r103;
        goto L17
    L11:
        this.f558068b = r102;
        goto L13
    L7:
        this.f558067a = r101;
        goto L9
    }

    public f(List r100, int r101, int r102, float r103, float r104, String r105, String r106, String r110, Integer r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = 10;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = 0.0f;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = 10.0f;
    L18:
        if ((r113 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r113 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r113 & 128) == 0) goto L27;
        r110 = null;
    L27:
        if ((r113 & 256) == 0) goto L30;
        r111 = null;
    L30:
        if ((r113 & 512) == 0) goto L32;
        r112 = null;
    L32:
        this.f558067a = r100;
        this.f558068b = r101;
        this.f558069c = r102;
        this.f558070d = r103;
        this.f558071e = r104;
        this.f558072f = r105;
        this.f558073g = r106;
        this.f558074h = r110;
        this.f558075i = r111;
        this.f558076j = r112;
    }
}
