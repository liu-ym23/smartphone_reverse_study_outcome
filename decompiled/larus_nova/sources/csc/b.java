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
public final class b {
    public static final C5580b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f465236a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f465237a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r0 f465238b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{nuc.l.f520729a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f465238b;
        }

        static {
            a r100 = new a();
            f465237a = r100;
            r0 r101 = new r0("io.github.alexzhirkevich.compottie.internal.helpers.text.TextCaps", r100);
            r101.j("type", false);
            f465238b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            return new b(r100.decodeInline(f465238b).decodeByte());
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            byte r102 = ((b) r101).f465236a;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            muc.f r103 = r100.encodeInline(f465238b);
            if (r103 == null) goto L7;
            r103.encodeByte(r102);
            return;
        }
    }

    /* JADX INFO: renamed from: csc.b$b, reason: collision with other inner class name */
    public static final class C5580b {
        public C5580b() {
        }

        public final juc.d<b> serializer() {
            return a.f465237a;
        }
    }

    public final int hashCode() {
        return this.f465236a;
    }

    static {
        Companion = new C5580b();
    }

    public final String toString() {
        return "TextCaps(type=" + this.f465236a + ')';
    }

    public final byte getType() {
        return this.f465236a;
    }

    public /* synthetic */ b(byte r100) {
        this.f465236a = r100;
    }

    public final boolean equals(Object r100) {
        byte r101 = this.f465236a;
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (r101 != ((b) r100).f465236a) goto L11;
        return true;
    L11:
        return false;
    }
}
