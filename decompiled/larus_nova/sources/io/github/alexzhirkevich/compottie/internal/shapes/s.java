package io.github.alexzhirkevich.compottie.internal.shapes;

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
public final class s {
    public static final b Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f491582b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f491583c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f491584d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f491585a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<s> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f491586a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r0 f491587b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{nuc.l.f520729a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f491587b;
        }

        static {
            a r100 = new a();
            f491586a = r100;
            r0 r101 = new r0("io.github.alexzhirkevich.compottie.internal.shapes.LineJoin", r100);
            r101.j("type", false);
            f491587b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            return new s(r100.decodeInline(f491587b).decodeByte());
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            byte r102 = ((s) r101).f491585a;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            muc.f r103 = r100.encodeInline(f491587b);
            if (r103 == null) goto L7;
            r103.encodeByte(r102);
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<s> serializer() {
            return a.f491586a;
        }
    }

    public final int hashCode() {
        return this.f491585a;
    }

    static {
        Companion = new b();
        f491582b = 1;
        f491583c = 2;
        f491584d = 3;
    }

    public final String toString() {
        return "LineJoin(type=" + this.f491585a + ')';
    }

    public final byte getType() {
        return this.f491585a;
    }

    public /* synthetic */ s(byte r100) {
        this.f491585a = r100;
    }

    public final boolean equals(Object r100) {
        byte r101 = this.f491585a;
        if ((r100 instanceof s) == true) goto L6;
        return false;
    L6:
        if (r101 != ((s) r100).f491585a) goto L11;
        return true;
    L11:
        return false;
    }
}
