package io.github.alexzhirkevich.compottie.internal.animation;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;

/* JADX INFO: loaded from: classes41.dex */
@Serializable
public final class y1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f491194c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Float> f491195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Float> f491196b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<y1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f491197a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final nuc.g2 f491198b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f491198b;
        }

        static {
            a r100 = new a();
            f491197a = r100;
            nuc.g2 r101 = new nuc.g2("io.github.alexzhirkevich.compottie.internal.animation.BezierInterpolation", r100, 2);
            r101.j("x", false);
            r101.j("y", false);
            f491198b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = y1.f491194c;
            return new juc.d[]{r100[0].getValue(), r100[1].getValue()};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return nuc.i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            nuc.g2 r100 = f491198b;
            muc.c r111 = r110.beginStructure(r100);
            Lazy<juc.d<Object>>[] r101 = y1.f491194c;
            List r102 = null;
            if (r111.decodeSequentially() == false) goto L5;
            List r103 = (List) r111.decodeSerializableElement(r100, 0, r101[0].getValue(), null);
            List r104 = (List) r111.decodeSerializableElement(r100, 1, r101[1].getValue(), null);
            int r105 = 3;
        L17:
            r111.endStructure(r100);
            return new y1(r105, r103, r104);
        L5:
            List r106 = null;
            int r107 = 0;
            boolean r108 = true;
        L6:
            if (r108 == false) goto L16;
            int r109 = r111.decodeElementIndex(r100);
            if (r109 != (-1)) goto L9;
            r108 = false;
            goto L6
        L9:
            if (r109 != 0) goto L10;
            r106 = (List) r111.decodeSerializableElement(r100, 0, r101[0].getValue(), r106);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r109 != 1) goto L13;
            r102 = (List) r111.decodeSerializableElement(r100, 1, r101[1].getValue(), r102);
            r107 = r107 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r109);
        L16:
            r105 = r107;
            r104 = r102;
            r103 = r106;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            y1 r102 = (y1) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            nuc.g2 r103 = f491198b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = y1.f491194c;
            r104.encodeSerializableElement(r103, 0, r105[0].getValue(), r102.f491195a);
            r104.encodeSerializableElement(r103, 1, r105[1].getValue(), r102.f491196b);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<y1> serializer() {
            return a.f491197a;
        }
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f491194c = new Lazy[]{LazyKt.lazy(r100, new w1()), LazyKt.lazy(r100, new x1())};
    }

    public y1(int r100, List r101, List r102) {
        if (3 != (r100 & 3)) goto L6;
        this.f491195a = r101;
        this.f491196b = r102;
        return;
    L6:
        nuc.b2.b(r100, 3, a.f491198b);
        throw null;
    }
}
