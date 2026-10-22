package kotlinx.serialization.json.internal;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes5.dex */
public final class i0 implements kotlinx.serialization.modules.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f505417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f505418b;

    @Override // kotlinx.serialization.modules.g
    public final <T> void a(KClass<T> r100, Function1<? super List<? extends juc.d<?>>, ? extends juc.d<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base> void c(KClass<Base> r100, Function1<? super String, ? extends juc.c<? extends Base>> r101) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "defaultDeserializerProvider");
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base> void d(KClass<Base> r100, Function1<? super Base, ? extends juc.n<? super Base>> r101) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "defaultSerializerProvider");
    }

    public i0(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "discriminator");
        this.f505417a = r100;
        this.f505418b = r101;
    }

    @Override // kotlinx.serialization.modules.g
    public final <T> void b(KClass<T> r100, final juc.d<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        Intrinsics.checkNotNullParameter(r101, "serializer");
        a(r100, new kotlinx.serialization.modules.f(r101));
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base, Sub extends Base> void e(KClass<Base> r100, KClass<Sub> r101, juc.d<Sub> r102) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "actualClass");
        Intrinsics.checkNotNullParameter(r102, "actualSerializer");
        luc.f r103 = r102.getDescriptor();
        luc.o r104 = r103.getKind();
        if ((r104 instanceof luc.d) == true) goto L30;
        if (Intrinsics.areEqual(r104, luc.o.a.f510875a) == true) goto L30;
        if (this.f505417a == true) goto L18;
        if (Intrinsics.areEqual(r104, luc.p.b.f510878a) == true) goto L28;
        if (Intrinsics.areEqual(r104, luc.p.c.f510879a) == true) goto L28;
        if ((r104 instanceof luc.e) == true) goto L28;
        if ((r104 instanceof luc.o.b) == false) goto L18;
    L28:
        throw new IllegalArgumentException("Serializer for " + r101.getSimpleName() + " of kind " + r104 + " cannot be serialized polymorphically with class discriminator.");
    L18:
        if (this.f505417a == true) goto L26;
        int r105 = r103.d();
        int r106 = 0;
    L20:
        if (r106 >= r105) goto L33;
        String r107 = r103.b(r106);
        if (Intrinsics.areEqual(r107, this.f505418b) == true) goto L25;
        r106 = r106 + 1;
        goto L20
    L25:
        throw new IllegalArgumentException("Polymorphic serializer for " + r101 + " has property '" + r107 + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
    L33:
        return;
    L26:
        return;
    L30:
        throw new IllegalArgumentException("Serializer for " + r101.getSimpleName() + " can't be registered as a subclass for polymorphic serialization because its kind " + r104 + " is not concrete. To work with multiple hierarchies, register it as a base class.");
    }
}
