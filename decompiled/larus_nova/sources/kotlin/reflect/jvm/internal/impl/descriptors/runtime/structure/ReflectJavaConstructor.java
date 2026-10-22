package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* JADX INFO: loaded from: classes42.dex */
public final class ReflectJavaConstructor extends ReflectJavaMember implements JavaConstructor {
    private final Constructor<?> member;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public /* bridge */ /* synthetic */ Member getMember() {
        return getMember();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Constructor<?>>[] r100 = getMember().getTypeParameters();
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(new ReflectJavaTypeParameter(r100[r103]));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor
    public List<JavaValueParameter> getValueParameters() {
        Type[] r100 = getMember().getGenericParameterTypes();
        Intrinsics.checkNotNull(r100);
        if (r100.length != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        Class<?> r102 = getMember().getDeclaringClass();
        if (r102.getDeclaringClass() != null) goto L12;
    L14:
        Annotation[][] r103 = getMember().getParameterAnnotations();
        if (r103.length < r100.length) goto L22;
        if (r103.length <= r100.length) goto L19;
        Intrinsics.checkNotNull(r103);
        r103 = (Annotation[][]) ArraysKt.copyOfRange(r103, r103.length - r100.length, r103.length);
    L19:
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNull(r103);
        return getValueParameters(r100, r103, getMember().isVarArgs());
    L22:
        throw new IllegalStateException("Illegal generic signature: " + getMember());
    L12:
        if (Modifier.isStatic(r102.getModifiers()) == true) goto L14;
        r100 = (Type[]) ArraysKt.copyOfRange(r100, 1, r100.length);
        goto L14
    L8:
        return CollectionsKt.emptyList();
    L5:
        r101 = false;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Constructor<?> getMember() {
        return this.member;
    }

    public ReflectJavaConstructor(Constructor<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "member");
        this.member = r100;
    }
}
