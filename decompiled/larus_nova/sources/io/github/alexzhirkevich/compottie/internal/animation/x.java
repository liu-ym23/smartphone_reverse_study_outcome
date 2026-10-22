package io.github.alexzhirkevich.compottie.internal.animation;

import com.amap.api.col.s.ce;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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
@Serializable(with = a0.class)
public abstract class x extends e2<Float> {
    public static final b Companion = null;

    @Serializable
    public static final class a extends x implements j2 {
        public static final b Companion = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Lazy<juc.d<Object>>[] f491162f = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<r2> f491163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f491164c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f491165d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final s1<Float, List<Float>, r2> f491166e;

        /* JADX INFO: renamed from: io.github.alexzhirkevich.compottie.internal.animation.x$a$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class C6303a implements nuc.m0<a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C6303a f491167a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final nuc.g2 f491168b = null;

            public C6303a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f491168b;
            }

            static {
                C6303a r100 = new C6303a();
                f491167a = r100;
                nuc.g2 r101 = new nuc.g2("io.github.alexzhirkevich.compottie.internal.animation.AnimatedNumber.Animated", r100, 3);
                r101.j(ce.f26396k, false);
                r101.j("x", true);
                r101.j("ix", true);
                f491168b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{a.f491162f[0].getValue(), kuc.a.d(nuc.v2.f520790a), kuc.a.d(nuc.w0.f520792a)};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return nuc.i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                nuc.g2 r100 = f491168b;
                muc.c r111 = r110.beginStructure(r100);
                Lazy<juc.d<Object>>[] r101 = a.f491162f;
                List r102 = null;
                if (r111.decodeSequentially() == false) goto L5;
                List r103 = (List) r111.decodeSerializableElement(r100, 0, r101[0].getValue(), null);
                String r104 = (String) r111.decodeNullableSerializableElement(r100, 1, nuc.v2.f520790a, null);
                Integer r105 = (Integer) r111.decodeNullableSerializableElement(r100, 2, nuc.w0.f520792a, null);
                int r106 = 7;
            L19:
                r111.endStructure(r100);
                return new a(r106, r103, r104, r105);
            L5:
                String r107 = null;
                Integer r108 = null;
                int r109 = 0;
                boolean r112 = true;
            L6:
                if (r112 == false) goto L18;
                int r113 = r111.decodeElementIndex(r100);
                if (r113 != (-1)) goto L9;
                r112 = false;
                goto L6
            L9:
                if (r113 != 0) goto L10;
                r102 = (List) r111.decodeSerializableElement(r100, 0, r101[0].getValue(), r102);
                r109 = r109 | 1;
                goto L6
            L10:
                if (r113 != 1) goto L11;
                r107 = (String) r111.decodeNullableSerializableElement(r100, 1, nuc.v2.f520790a, r107);
                r109 = r109 | 2;
                goto L6
            L11:
                if (r113 != 2) goto L14;
                r108 = (Integer) r111.decodeNullableSerializableElement(r100, 2, nuc.w0.f520792a, r108);
                r109 = r109 | 4;
                goto L6
            L14:
                throw new UnknownFieldException(r113);
            L18:
                r106 = r109;
                r103 = r102;
                r104 = r107;
                r105 = r108;
                goto L19
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                a r102 = (a) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                nuc.g2 r103 = f491168b;
                muc.d r104 = r100.beginStructure(r103);
                boolean r105 = false;
                r104.encodeSerializableElement(r103, 0, a.f491162f[0].getValue(), r102.f491163b);
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L6;
            L7:
                boolean r106 = true;
            L9:
                if (r106 == false) goto L12;
                r104.encodeNullableSerializableElement(r103, 1, nuc.v2.f520790a, r102.f491164c);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L15;
            L16:
                r105 = true;
            L17:
                if (r105 == false) goto L19;
                r104.encodeNullableSerializableElement(r103, 2, nuc.w0.f520792a, r102.f491165d);
            L19:
                r104.endStructure(r103);
                return;
            L15:
                if (r102.f491165d == null) goto L17;
            L6:
                if (r102.f491164c != null) goto L7;
                r106 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<a> serializer() {
                return C6303a.f491167a;
            }
        }

        static {
            Companion = new b();
            f491162f = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new v()), null, null};
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.x
        public final x i() {
            return new a(this.f491163b, this.f491164c, this.f491165d);
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.j2
        public final List<r2> c() {
            return this.f491163b;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.g2
        public final String f() {
            return this.f491164c;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.k2
        public final Integer getIndex() {
            return this.f491165d;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.k2
        public final Object d(prc.f r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            return this.f491166e.d(r100);
        }

        public a(List<r2> r100, String r101, Integer r102) {
            Intrinsics.checkNotNullParameter(r100, "keyframes");
            this.f491163b = r100;
            this.f491164c = r101;
            this.f491165d = r102;
            g();
            this.f491166e = new s1(r102, r100, Float.valueOf(1.0f), new w());
        }

        public a(int r100, List r101, String r102, Integer r103) {
            if (1 != (r100 & 1)) goto L14;
            this.f491163b = r101;
            if ((r100 & 2) != 0) goto L7;
            this.f491164c = null;
        L9:
            if ((r100 & 4) != 0) goto L11;
            this.f491165d = null;
        L12:
            g();
            this.f491166e = new s1(this.f491165d, r101, Float.valueOf(1.0f), new u());
            return;
        L11:
            this.f491165d = r103;
            goto L12
        L7:
            this.f491164c = r102;
            goto L9
        L14:
            nuc.b2.b(r100, 1, C6303a.f491168b);
            throw null;
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<x> serializer() {
            return a0.f490766c;
        }
    }

    @Serializable
    public static final class c extends x {
        public static final b Companion = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f491169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f491170c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f491171d;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<c> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f491172a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final nuc.g2 f491173b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{s2.f491159b, kuc.a.d(nuc.v2.f520790a), kuc.a.d(nuc.w0.f520792a)};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f491173b;
            }

            static {
                a r100 = new a();
                f491172a = r100;
                nuc.g2 r101 = new nuc.g2("io.github.alexzhirkevich.compottie.internal.animation.AnimatedNumber.Default", r100, 3);
                r101.j(ce.f26396k, false);
                r101.j("x", true);
                r101.j("ix", true);
                f491173b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return nuc.i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                nuc.g2 r100 = f491173b;
                muc.c r111 = r110.beginStructure(r100);
                float r101 = 0.0f;
                String r102 = null;
                if (r111.decodeSequentially() == false) goto L5;
                float r103 = ((Number) r111.decodeSerializableElement(r100, 0, s2.f491159b, Float.valueOf(0.0f))).floatValue();
                String r104 = (String) r111.decodeNullableSerializableElement(r100, 1, nuc.v2.f520790a, null);
                Integer r105 = (Integer) r111.decodeNullableSerializableElement(r100, 2, nuc.w0.f520792a, null);
                int r106 = 7;
            L19:
                r111.endStructure(r100);
                return new c(r106, r103, r104, r105);
            L5:
                Integer r107 = null;
                int r108 = 0;
                boolean r109 = true;
            L6:
                if (r109 == false) goto L18;
                int r112 = r111.decodeElementIndex(r100);
                if (r112 != (-1)) goto L9;
                r109 = false;
                goto L6
            L9:
                if (r112 != 0) goto L10;
                r101 = ((Number) r111.decodeSerializableElement(r100, 0, s2.f491159b, Float.valueOf(r101))).floatValue();
                r108 = r108 | 1;
                goto L6
            L10:
                if (r112 != 1) goto L11;
                r102 = (String) r111.decodeNullableSerializableElement(r100, 1, nuc.v2.f520790a, r102);
                r108 = r108 | 2;
                goto L6
            L11:
                if (r112 != 2) goto L14;
                r107 = (Integer) r111.decodeNullableSerializableElement(r100, 2, nuc.w0.f520792a, r107);
                r108 = r108 | 4;
                goto L6
            L14:
                throw new UnknownFieldException(r112);
            L18:
                r106 = r108;
                r103 = r101;
                r104 = r102;
                r105 = r107;
                goto L19
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                c r102 = (c) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                nuc.g2 r103 = f491173b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = c.Companion;
                boolean r106 = false;
                r104.encodeSerializableElement(r103, 0, s2.f491159b, Float.valueOf(r102.f491169b));
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeNullableSerializableElement(r103, 1, nuc.v2.f520790a, r102.f491170c);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L15;
            L16:
                r106 = true;
            L17:
                if (r106 == false) goto L19;
                r104.encodeNullableSerializableElement(r103, 2, nuc.w0.f520792a, r102.f491171d);
            L19:
                r104.endStructure(r103);
                return;
            L15:
                if (r102.f491171d == null) goto L17;
            L6:
                if (r102.f491170c != null) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<c> serializer() {
                return a.f491172a;
            }
        }

        static {
            Companion = new b();
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.x
        public final x i() {
            return new c(this.f491169b, this.f491170c, this.f491171d);
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.g2
        public final String f() {
            return this.f491170c;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.k2
        public final Integer getIndex() {
            return this.f491171d;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.k2
        public final Object d(prc.f r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            return Float.valueOf(this.f491169b);
        }

        public c(float r100, String r101, Integer r102) {
            this.f491169b = r100;
            this.f491170c = r101;
            this.f491171d = r102;
            g();
        }

        public c(int r100, float r101, String r102, Integer r103) {
            if (1 != (r100 & 1)) goto L14;
            this.f491169b = r101;
            if ((r100 & 2) != 0) goto L7;
            this.f491170c = null;
        L9:
            if ((r100 & 4) != 0) goto L11;
            this.f491171d = null;
        L12:
            g();
            return;
        L11:
            this.f491171d = r103;
            goto L12
        L7:
            this.f491170c = r102;
            goto L9
        L14:
            nuc.b2.b(r100, 1, a.f491173b);
            throw null;
        }
    }

    @Serializable
    public static final class d extends x {
        public static final b Companion = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f491174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f491175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f491176d;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<d> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f491177a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final nuc.g2 f491178b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.v2 r100 = nuc.v2.f520790a;
                return new juc.d[]{r100, kuc.a.d(r100), kuc.a.d(nuc.w0.f520792a)};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f491178b;
            }

            static {
                a r100 = new a();
                f491177a = r100;
                nuc.g2 r101 = new nuc.g2("io.github.alexzhirkevich.compottie.internal.animation.AnimatedNumber.Slottable", r100, 3);
                r101.j(WsConstants.KEY_SESSION_ID, false);
                r101.j("x", true);
                r101.j("ix", true);
                f491178b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return nuc.i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                nuc.g2 r100 = f491178b;
                muc.c r111 = r110.beginStructure(r100);
                String r101 = null;
                if (r111.decodeSequentially() == false) goto L5;
                String r102 = r111.decodeStringElement(r100, 0);
                String r103 = (String) r111.decodeNullableSerializableElement(r100, 1, nuc.v2.f520790a, null);
                Integer r104 = (Integer) r111.decodeNullableSerializableElement(r100, 2, nuc.w0.f520792a, null);
                int r105 = 7;
            L19:
                r111.endStructure(r100);
                return new d(r105, r102, r103, r104);
            L5:
                String r106 = null;
                Integer r107 = null;
                int r108 = 0;
                boolean r109 = true;
            L6:
                if (r109 == false) goto L18;
                int r112 = r111.decodeElementIndex(r100);
                if (r112 != (-1)) goto L9;
                r109 = false;
                goto L6
            L9:
                if (r112 != 0) goto L10;
                r101 = r111.decodeStringElement(r100, 0);
                r108 = r108 | 1;
                goto L6
            L10:
                if (r112 != 1) goto L11;
                r106 = (String) r111.decodeNullableSerializableElement(r100, 1, nuc.v2.f520790a, r106);
                r108 = r108 | 2;
                goto L6
            L11:
                if (r112 != 2) goto L14;
                r107 = (Integer) r111.decodeNullableSerializableElement(r100, 2, nuc.w0.f520792a, r107);
                r108 = r108 | 4;
                goto L6
            L14:
                throw new UnknownFieldException(r112);
            L18:
                r105 = r108;
                r102 = r101;
                r103 = r106;
                r104 = r107;
                goto L19
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                d r102 = (d) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                nuc.g2 r103 = f491178b;
                muc.d r104 = r100.beginStructure(r103);
                boolean r105 = false;
                r104.encodeStringElement(r103, 0, r102.f491174b);
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L6;
            L7:
                boolean r106 = true;
            L9:
                if (r106 == false) goto L12;
                r104.encodeNullableSerializableElement(r103, 1, nuc.v2.f520790a, r102.f491175c);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L15;
            L16:
                r105 = true;
            L17:
                if (r105 == false) goto L19;
                r104.encodeNullableSerializableElement(r103, 2, nuc.w0.f520792a, r102.f491176d);
            L19:
                r104.endStructure(r103);
                return;
            L15:
                if (r102.f491176d == null) goto L17;
            L6:
                if (r102.f491175c != null) goto L7;
                r106 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<d> serializer() {
                return a.f491177a;
            }
        }

        static {
            Companion = new b();
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.x
        public final x i() {
            return new d(this.f491174b, this.f491175c, this.f491176d);
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.g2
        public final String f() {
            return this.f491175c;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.k2
        public final Integer getIndex() {
            return this.f491176d;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.k2
        public final Object d(prc.f r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            prc.o r101 = r100.f530391a.f490694a.f490763m;
            String r102 = this.f491174b;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_SESSION_ID);
            x r103 = (x) r101.a(r102, x.Companion.serializer());
            if (r103 == null) goto L5;
            float r104 = r103.b(r100).floatValue();
        L7:
            return Float.valueOf(r104);
        L5:
            r104 = 0.0f;
            goto L7
        }

        public d(String r100, String r101, Integer r102) {
            Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_SESSION_ID);
            this.f491174b = r100;
            this.f491175c = r101;
            this.f491176d = r102;
        }

        public d(int r100, String r101, String r102, Integer r103) {
            if (1 != (r100 & 1)) goto L13;
            this.f491174b = r101;
            if ((r100 & 2) != 0) goto L7;
            this.f491175c = null;
        L9:
            if ((r100 & 4) != 0) goto L11;
            this.f491176d = null;
            return;
        L11:
            this.f491176d = r103;
            return;
        L7:
            this.f491175c = r102;
            goto L9
        L13:
            nuc.b2.b(r100, 1, a.f491178b);
            throw null;
        }
    }

    public abstract x i();

    static {
        Companion = new b();
    }

    public x() {
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.g2
    public final Object h(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if ((r100 instanceof Number) == false) goto L6;
        float r101 = ((Number) r100).floatValue();
    L9:
        return Float.valueOf(r101);
    L6:
        if ((r100 instanceof List) == false) goto L11;
        Object r102 = ListProtector.get((List) r100, 0);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Number");
        r101 = ((Number) r102).floatValue();
        goto L9
    L11:
        throw new IllegalStateException(("Failed to cast " + r100 + " to number").toString());
    }
}
