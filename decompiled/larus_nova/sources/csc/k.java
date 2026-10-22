package csc;

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
public final class k {
    public static final b Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f465265b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f465266c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f465267d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte f465268e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f465269f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f465270a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f465271a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r0 f465272b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{nuc.l.f520729a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f465272b;
        }

        static {
            a r100 = new a();
            f465271a = r100;
            r0 r101 = new r0("io.github.alexzhirkevich.compottie.internal.helpers.text.TextJustify", r100);
            r101.j("type", false);
            f465272b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            return new k(r100.decodeInline(f465272b).decodeByte());
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            byte r102 = ((k) r101).f465270a;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            muc.f r103 = r100.encodeInline(f465272b);
            if (r103 == null) goto L7;
            r103.encodeByte(r102);
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<k> serializer() {
            return a.f465271a;
        }
    }

    public final int hashCode() {
        return this.f465270a;
    }

    static {
        Companion = new b();
        f465265b = 1;
        f465266c = 2;
        f465267d = 3;
        f465268e = 4;
        f465269f = 5;
    }

    public final String toString() {
        return "TextJustify(type=" + this.f465270a + ')';
    }

    public final byte getType() {
        return this.f465270a;
    }

    public /* synthetic */ k(byte r100) {
        this.f465270a = r100;
    }

    public final boolean equals(Object r100) {
        byte r101 = this.f465270a;
        if ((r100 instanceof k) == true) goto L6;
        return false;
    L6:
        if (r101 != ((k) r100).f465270a) goto L11;
        return true;
    L11:
        return false;
    }
}
