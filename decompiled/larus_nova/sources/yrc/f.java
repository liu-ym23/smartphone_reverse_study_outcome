package yrc;

import io.github.alexzhirkevich.compottie.assets.LottieFontSpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import nuc.i2;
import nuc.m0;
import nuc.r0;

/* JADX INFO: loaded from: classes41.dex */
@JvmInline
@Serializable
public final class f {
    public static final b Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f568962b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f568963c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f568964d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f568965a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f568966a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r0 f568967b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{nuc.l.f520729a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f568967b;
        }

        static {
            a r100 = new a();
            f568966a = r100;
            r0 r101 = new r0("io.github.alexzhirkevich.compottie.internal.assets.FontOrigin", r100);
            r101.j("type", false);
            f568967b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            return new f(r100.decodeInline(f568967b).decodeByte());
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            byte r102 = ((f) r101).f568965a;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            muc.f r103 = r100.encodeInline(f568967b);
            if (r103 == null) goto L7;
            r103.encodeByte(r102);
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f> serializer() {
            return a.f568966a;
        }
    }

    public final int hashCode() {
        return this.f568965a;
    }

    static {
        Companion = new b();
        f568962b = 1;
        f568963c = 2;
        f568964d = 3;
    }

    public final String toString() {
        return "FontOrigin(type=" + this.f568965a + ')';
    }

    public final byte getType() {
        return this.f568965a;
    }

    public /* synthetic */ f(byte r100) {
        this.f568965a = r100;
    }

    public static final LottieFontSpec.FontOrigin a(byte r100) {
        boolean r101 = true;
        if (r100 != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return LottieFontSpec.FontOrigin.Local;
    L9:
        if (r100 != f568962b) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L15;
        return LottieFontSpec.FontOrigin.CssUrl;
    L15:
        if (r100 != f568963c) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        return LottieFontSpec.FontOrigin.ScriptUrl;
    L21:
        if (r100 == f568964d) goto L24;
        r101 = false;
    L24:
        if (r101 == false) goto L27;
        return LottieFontSpec.FontOrigin.FontUrl;
    L27:
        return LottieFontSpec.FontOrigin.Unknown;
    L17:
        r104 = false;
        goto L18
    L11:
        r103 = false;
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    public final boolean equals(Object r100) {
        byte r101 = this.f568965a;
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (r101 != ((f) r100).f568965a) goto L11;
        return true;
    L11:
        return false;
    }
}
