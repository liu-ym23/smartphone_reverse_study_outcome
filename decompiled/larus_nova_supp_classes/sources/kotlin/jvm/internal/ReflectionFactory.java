package kotlin.jvm.internal;

import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ReflectionFactory {
    private static final String KOTLIN_JVM_FUNCTIONS = "kotlin.jvm.functions.";

    public ReflectionFactory() {
    }

    public KFunction function(FunctionReference r1) {
        return r1;
    }

    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 r1) {
        return r1;
    }

    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 r1) {
        return r1;
    }

    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 r1) {
        return r1;
    }

    public KProperty0 property0(PropertyReference0 r1) {
        return r1;
    }

    public KProperty1 property1(PropertyReference1 r1) {
        return r1;
    }

    public KProperty2 property2(PropertyReference2 r1) {
        return r1;
    }

    public KClass createKotlinClass(Class r2) {
        return new ClassReference(r2);
    }

    public KClass getOrCreateKotlinClass(Class r2) {
        return new ClassReference(r2);
    }

    public KType mutableCollectionType(KType r5) {
        TypeReference r0 = (TypeReference) r5;
        return new TypeReference(r5.getClassifier(), r5.getArguments(), r0.getPlatformTypeUpperBound$kotlin_stdlib(), r0.getFlags$kotlin_stdlib() | 2);
    }

    public KType nothingType(KType r5) {
        TypeReference r0 = (TypeReference) r5;
        return new TypeReference(r5.getClassifier(), r5.getArguments(), r0.getPlatformTypeUpperBound$kotlin_stdlib(), r0.getFlags$kotlin_stdlib() | 4);
    }

    public String renderLambdaToString(FunctionBase r2) {
        String r3 = r2.getClass().getGenericInterfaces()[0].toString();
        if (r3.startsWith(KOTLIN_JVM_FUNCTIONS) == true) goto L5;
        return r3;
    L5:
        return r3.substring(21);
    }

    public String renderLambdaToString(Lambda r1) {
        return renderLambdaToString(r1);
    }

    public KClass createKotlinClass(Class r1, String r2) {
        return new ClassReference(r1);
    }

    public KClass getOrCreateKotlinClass(Class r1, String r2) {
        return new ClassReference(r1);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class r2, String r3) {
        return new PackageReference(r2, r3);
    }

    public KType platformType(KType r4, KType r5) {
        return new TypeReference(r4.getClassifier(), r4.getArguments(), r5, ((TypeReference) r4).getFlags$kotlin_stdlib());
    }

    public void setUpperBounds(KTypeParameter r1, List<KType> r2) {
        ((TypeParameterReference) r1).setUpperBounds(r2);
    }

    public KType typeOf(KClassifier r2, List<KTypeProjection> r3, boolean r4) {
        return new TypeReference(r2, r3, r4);
    }

    public KTypeParameter typeParameter(Object r2, String r3, KVariance r4, boolean r5) {
        return new TypeParameterReference(r2, r3, r4, r5);
    }
}
