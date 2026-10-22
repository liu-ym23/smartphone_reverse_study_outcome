package el4;

import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class a {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f473010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f473011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f473012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f473013d;

    /* JADX INFO: renamed from: el4.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes15.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C5786a implements m0<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5786a f473014a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f473015b = null;

        public C5786a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            return new d[]{r100, r100, r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f473015b;
        }

        static {
            C5786a r100 = new C5786a();
            f473014a = r100;
            g2 r101 = new g2("com.bytedance.dorax.kmp.config.DoraKMPConfig", r100, 4);
            r101.j("enable", true);
            r101.j("tx_enable", true);
            r101.j("rx_enable", true);
            r101.j("etc", true);
            f473015b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f473015b;
            c r101 = r110.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            int r102 = r101.decodeIntElement(r100, 0);
            int r103 = r101.decodeIntElement(r100, 1);
            int r104 = r101.decodeIntElement(r100, 2);
            int r111 = r102;
            int r112 = r104;
            int r113 = r103;
            int r114 = r101.decodeIntElement(r100, 3);
            int r115 = 15;
        L21:
            r101.endStructure(r100);
            return new a(r115, r111, r113, r112, r114);
        L5:
            int r105 = 0;
            int r106 = 0;
            int r107 = 0;
            int r108 = 0;
            int r116 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r105 = r101.decodeIntElement(r100, 0);
            r116 = r116 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r107 = r101.decodeIntElement(r100, 1);
            r116 = r116 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r106 = r101.decodeIntElement(r100, 2);
            r116 = r116 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r108 = r101.decodeIntElement(r100, 3);
            r116 = r116 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r111 = r105;
            r112 = r106;
            r113 = r107;
            r114 = r108;
            r115 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            a r102 = (a) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f473015b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = a.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeIntElement(r103, 0, r102.f473010a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeIntElement(r103, 1, r102.f473011b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeIntElement(r103, 2, r102.f473012c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            r106 = true;
        L35:
            if (r106 == false) goto L37;
            r104.encodeIntElement(r103, 3, r102.f473013d);
        L37:
            r104.endStructure(r103);
            return;
        L33:
            if (r102.f473013d == 0) goto L35;
        L24:
            if (r102.f473012c != 0) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f473011b != 0) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f473010a != 0) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<a> serializer() {
            return C5786a.f473014a;
        }
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f473010a == r101.f473010a) goto L12;
        return false;
    L12:
        if (this.f473011b == r101.f473011b) goto L15;
        return false;
    L15:
        if (this.f473012c == r101.f473012c) goto L18;
        return false;
    L18:
        if (this.f473013d == r101.f473013d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f473010a * 31) + this.f473011b) * 31) + this.f473012c) * 31) + this.f473013d;
    }

    public final String toString() {
        return "DoraKMPConfig(enable=" + this.f473010a + ", txEnable=" + this.f473011b + ", rxEnable=" + this.f473012c + ", etc=" + this.f473013d + ')';
    }

    static {
        Companion = new b();
    }

    public a(int r100) {
        this.f473010a = 0;
        this.f473011b = 0;
        this.f473012c = 0;
        this.f473013d = 0;
    }

    public a(int r100, int r101, int r102, int r103, int r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, C5786a.f473015b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f473010a = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f473011b = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f473012c = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f473013d = 0;
        return;
    L19:
        this.f473013d = r104;
        return;
    L15:
        this.f473012c = r103;
        goto L17
    L11:
        this.f473011b = r102;
        goto L13
    L7:
        this.f473010a = r101;
        goto L9
    }
}
