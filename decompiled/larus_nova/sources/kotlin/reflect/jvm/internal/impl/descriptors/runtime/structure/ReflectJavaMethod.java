package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* JADX INFO: loaded from: classes42.dex */
public final class ReflectJavaMethod extends ReflectJavaMember implements JavaMethod {
    private final Method member;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public ReflectJavaType getReturnType() {
        return ReflectJavaType.Factory.create(getMember().getGenericReturnType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public JavaAnnotationArgument getAnnotationParameterDefaultValue() {
        Object r100 = getMember().getDefaultValue();
        if (r100 != null) goto L5;
        return null;
    L5:
        return ReflectJavaAnnotationArgument.Factory.create(r100, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public boolean getHasAnnotationParameterDefaultValue() {
        if (getAnnotationParameterDefaultValue() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public /* bridge */ /* synthetic */ Member getMember() {
        return getMember();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Method>[] r100 = getMember().getTypeParameters();
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

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public List<JavaValueParameter> getValueParameters() {
        return getValueParameters(getMember().getGenericParameterTypes(), getMember().getParameterAnnotations(), getMember().isVarArgs());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Method getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public /* bridge */ /* synthetic */ JavaType getReturnType() {
        return getReturnType();
    }

    public ReflectJavaMethod(Method r100) {
        Intrinsics.checkNotNullParameter(r100, "member");
        this.member = r100;
    }
}
