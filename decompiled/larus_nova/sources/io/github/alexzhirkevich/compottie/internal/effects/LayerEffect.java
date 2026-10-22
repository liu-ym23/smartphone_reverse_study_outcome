package io.github.alexzhirkevich.compottie.internal.effects;

import androidx.compose.ui.graphics.Paint;
import asc.h;
import asc.j;
import asc.k;
import asc.l;
import asc.m;
import asc.o;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.json.JsonClassDiscriminator;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes41.dex */
@JsonClassDiscriminator(discriminator = "ty")
@Serializable
public abstract class LayerEffect {
    public static final a Companion = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<d<Object>> f491299c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f491300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f491301b;

    @Serializable
    public static final class UnsupportedEffect extends LayerEffect {
        public static final Companion Companion = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Lazy<d<Object>>[] f491302h = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<EffectValue<k2<Object>>> f491303d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f491304e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f491305f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f491306g;

        public static final class Companion {
            public Companion() {
            }

            public final d<UnsupportedEffect> serializer() {
                return a.f491307a;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements m0<UnsupportedEffect> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f491307a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f491308b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final f getDescriptor() {
                return f491308b;
            }

            static {
                a r100 = new a();
                f491307a = r100;
                g2 r101 = new g2("io.github.alexzhirkevich.compottie.internal.effects.LayerEffect.UnsupportedEffect", r100, 4);
                r101.j("values", true);
                r101.j("name", true);
                r101.j("index", true);
                r101.j("enabled", true);
                r101.l(new LayerEffect$UnsupportedEffect$Companion$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0("ty"));
                f491308b = r101;
            }

            @Override // nuc.m0
            public final d<?>[] childSerializers() {
                return new d[]{UnsupportedEffect.f491302h[0].getValue(), kuc.a.d(v2.f520790a), kuc.a.d(w0.f520792a), i.f520705a};
            }

            @Override // nuc.m0
            public final d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(e r210) {
                Intrinsics.checkNotNullParameter(r210, "decoder");
                g2 r100 = f491308b;
                c r101 = r210.beginStructure(r100);
                Lazy<d<Object>>[] r102 = UnsupportedEffect.f491302h;
                if (r101.decodeSequentially() == false) goto L5;
                List r103 = (List) r101.decodeSerializableElement(r100, 0, r102[0].getValue(), null);
                String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
                List r110 = r103;
                String r111 = r104;
                Integer r112 = (Integer) r101.decodeNullableSerializableElement(r100, 2, w0.f520792a, null);
                boolean r113 = r101.decodeBooleanElement(r100, 3);
                int r114 = 15;
            L21:
                r101.endStructure(r100);
                return new UnsupportedEffect(r114, r110, r111, r112, r113);
            L5:
                List r105 = null;
                String r115 = null;
                Integer r116 = null;
                boolean r106 = false;
                int r107 = 0;
                boolean r117 = true;
            L6:
                if (r117 == false) goto L20;
                int r118 = r101.decodeElementIndex(r100);
                if (r118 != (-1)) goto L9;
                r117 = false;
                goto L6
            L9:
                if (r118 != 0) goto L10;
                r105 = (List) r101.decodeSerializableElement(r100, 0, r102[0].getValue(), r105);
                r107 = r107 | 1;
                goto L6
            L10:
                if (r118 != 1) goto L11;
                r115 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r115);
                r107 = r107 | 2;
                goto L6
            L11:
                if (r118 != 2) goto L12;
                r116 = (Integer) r101.decodeNullableSerializableElement(r100, 2, w0.f520792a, r116);
                r107 = r107 | 4;
                goto L6
            L12:
                if (r118 != 3) goto L15;
                r106 = r101.decodeBooleanElement(r100, 3);
                r107 = r107 | 8;
                goto L6
            L15:
                throw new UnknownFieldException(r118);
            L20:
                r113 = r106;
                r114 = r107;
                r110 = r105;
                r111 = r115;
                r112 = r116;
                goto L21
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                UnsupportedEffect r102 = (UnsupportedEffect) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f491308b;
                muc.d r104 = r100.beginStructure(r103);
                Lazy<d<Object>>[] r105 = UnsupportedEffect.f491302h;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeSerializableElement(r103, 0, r105[0].getValue(), r102.f491303d);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                boolean r108 = true;
            L18:
                if (r108 == false) goto L21;
                r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f491304e);
            L21:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
            L25:
                boolean r109 = true;
            L27:
                if (r109 == false) goto L30;
                r104.encodeNullableSerializableElement(r103, 2, w0.f520792a, r102.f491305f);
            L30:
                if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
            L34:
                r106 = true;
            L35:
                if (r106 == false) goto L37;
                r104.encodeBooleanElement(r103, 3, r102.f491306g);
            L37:
                r104.endStructure(r103);
                return;
            L33:
                if (r102.f491306g == true) goto L35;
            L24:
                if (r102.f491305f != null) goto L25;
                r109 = false;
                goto L27
            L15:
                if (r102.f491304e != null) goto L16;
                r108 = false;
                goto L18
            L6:
                if (Intrinsics.areEqual(r102.f491303d, CollectionsKt.emptyList()) == false) goto L7;
                r107 = false;
                goto L9
            }
        }

        @Override // io.github.alexzhirkevich.compottie.internal.effects.LayerEffect
        public final void a(Paint r100, prc.f r101, o r102) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            Intrinsics.checkNotNullParameter(r101, "animationState");
            Intrinsics.checkNotNullParameter(r102, "effectState");
        }

        static {
            Companion = new Companion();
            f491302h = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new m()), null, null, null};
        }

        @Override // io.github.alexzhirkevich.compottie.internal.effects.LayerEffect
        public final LayerEffect b() {
            return new UnsupportedEffect();
        }

        public UnsupportedEffect() {
            this.f491303d = CollectionsKt.emptyList();
            this.f491306g = true;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.effects.LayerEffect
        public final boolean c() {
            return this.f491306g;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.effects.LayerEffect
        public final Integer d() {
            return this.f491305f;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.effects.LayerEffect
        public final String e() {
            return this.f491304e;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.effects.LayerEffect
        public final List<EffectValue<k2<Object>>> f() {
            return this.f491303d;
        }

        public UnsupportedEffect(int r100, List r101, String r102, Integer r103, boolean r104) {
            int r105 = 0;
            if ((r100 & 0) != 0) goto L20;
            super(r105);
            if ((r100 & 1) != 0) goto L7;
            r101 = CollectionsKt.emptyList();
        L7:
            this.f491303d = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f491304e = null;
        L12:
            if ((r100 & 4) != 0) goto L14;
            this.f491305f = null;
        L16:
            if ((r100 & 8) != 0) goto L18;
            this.f491306g = true;
            return;
        L18:
            this.f491306g = r104;
            return;
        L14:
            this.f491305f = r103;
            goto L16
        L10:
            this.f491304e = r102;
            goto L12
        L20:
            b2.b(r100, 0, a.f491308b);
            throw null;
        }
    }

    public static final class a {
        public a() {
        }

        public final d<LayerEffect> serializer() {
            return (d) LayerEffect.f491299c.getValue();
        }
    }

    public abstract void a(Paint r100, prc.f r101, o r102);

    public abstract LayerEffect b();

    public abstract boolean c();

    public abstract Integer d();

    public abstract String e();

    public abstract List<EffectValue<?>> f();

    static {
        Companion = new a();
        f491299c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new j());
    }

    public LayerEffect() {
        this.f491300a = LazyKt.lazy(new h(this));
        this.f491301b = LazyKt.lazy(new asc.i(this));
    }

    public /* synthetic */ LayerEffect(int r100) {
        this.f491300a = LazyKt.lazy(new k(this));
        this.f491301b = LazyKt.lazy(new l(this));
    }
}
