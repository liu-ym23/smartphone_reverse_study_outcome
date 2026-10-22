package nuc;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: loaded from: classes42.dex */
public final class x0 implements KType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KType f520799a;

    @Override // kotlin.reflect.KAnnotatedElement
    public final List<Annotation> getAnnotations() {
        return this.f520799a.getAnnotations();
    }

    @Override // kotlin.reflect.KType
    public final List<KTypeProjection> getArguments() {
        return this.f520799a.getArguments();
    }

    @Override // kotlin.reflect.KType
    public final KClassifier getClassifier() {
        return this.f520799a.getClassifier();
    }

    public final int hashCode() {
        return this.f520799a.hashCode();
    }

    @Override // kotlin.reflect.KType
    public final boolean isMarkedNullable() {
        return this.f520799a.isMarkedNullable();
    }

    public final String toString() {
        return "KTypeWrapper: " + this.f520799a;
    }

    public x0(KType r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f520799a = r100;
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        KType r101 = this.f520799a;
        KClassifier r102 = null;
        if ((r100 instanceof x0) == false) goto L8;
        x0 r103 = (x0) r100;
    L9:
        if (r103 == null) goto L11;
        KType r104 = r103.f520799a;
    L13:
        if (Intrinsics.areEqual(r101, r104) == true) goto L15;
        return false;
    L15:
        KClassifier r105 = getClassifier();
        if ((r105 instanceof KClass) == true) goto L18;
    L29:
        return false;
    L18:
        if ((r100 instanceof KType) == false) goto L20;
        KType r106 = (KType) r100;
    L21:
        if (r106 == null) goto L23;
        r102 = r106.getClassifier();
    L23:
        if (r102 == null) goto L29;
        if ((r102 instanceof KClass) == false) goto L29;
        return Intrinsics.areEqual(JvmClassMappingKt.getJavaClass((KClass) r105), JvmClassMappingKt.getJavaClass((KClass) r102));
    L20:
        r106 = null;
        goto L21
    L11:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L9
    }
}
