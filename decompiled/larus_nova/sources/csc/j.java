package csc;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import nuc.i2;
import nuc.m0;
import nuc.r0;
import nuc.w0;

/* JADX INFO: loaded from: classes41.dex */
@JvmInline
@Serializable
public final class j {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f465262a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f465263a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r0 f465264b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{w0.f520792a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f465264b;
        }

        static {
            a r100 = new a();
            f465263a = r100;
            r0 r101 = new r0("io.github.alexzhirkevich.compottie.internal.helpers.text.TextGrouping", r100);
            r101.j("type", false);
            f465264b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            return new j(r100.decodeInline(f465264b).decodeInt());
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            int r102 = ((j) r101).f465262a;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            muc.f r103 = r100.encodeInline(f465264b);
            if (r103 == null) goto L7;
            r103.encodeInt(r102);
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<j> serializer() {
            return a.f465263a;
        }
    }

    public final int hashCode() {
        return this.f465262a;
    }

    static {
        Companion = new b();
    }

    public final String toString() {
        return "TextGrouping(type=" + this.f465262a + ')';
    }

    public final int getType() {
        return this.f465262a;
    }

    public /* synthetic */ j(int r100) {
        this.f465262a = r100;
    }

    public final boolean equals(Object r100) {
        int r101 = this.f465262a;
        if ((r100 instanceof j) == true) goto L6;
        return false;
    L6:
        if (r101 != ((j) r100).f465262a) goto L11;
        return true;
    L11:
        return false;
    }
}
