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
public final class t {
    public static final b Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f491588b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f491589c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f491590d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte f491591e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f491592f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f491593a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f491594a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r0 f491595b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{nuc.l.f520729a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f491595b;
        }

        static {
            a r100 = new a();
            f491594a = r100;
            r0 r101 = new r0("io.github.alexzhirkevich.compottie.internal.shapes.MergeMode", r100);
            r101.j("mode", false);
            f491595b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            return new t(r100.decodeInline(f491595b).decodeByte());
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            byte r102 = ((t) r101).f491593a;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            muc.f r103 = r100.encodeInline(f491595b);
            if (r103 == null) goto L7;
            r103.encodeByte(r102);
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<t> serializer() {
            return a.f491594a;
        }
    }

    public final int hashCode() {
        return this.f491593a;
    }

    static {
        Companion = new b();
        f491588b = 1;
        f491589c = 2;
        f491590d = 3;
        f491591e = 4;
        f491592f = 5;
    }

    public final String toString() {
        return "MergeMode(mode=" + this.f491593a + ')';
    }

    public /* synthetic */ t(byte r100) {
        this.f491593a = r100;
    }

    public final boolean equals(Object r100) {
        byte r101 = this.f491593a;
        if ((r100 instanceof t) == true) goto L6;
        return false;
    L6:
        if (r101 != ((t) r100).f491593a) goto L11;
        return true;
    L11:
        return false;
    }
}
