package kotlin.jvm.internal;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
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
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class Reflection {
    private static final KClass[] EMPTY_K_CLASS_ARRAY = null;
    static final String REFLECTION_NOT_AVAILABLE = " (Kotlin reflection is not available)";
    private static final ReflectionFactory factory = null;

    static {
        ReflectionFactory r100 = null;
        r100 = (ReflectionFactory) INVOKESTATIC_kotlin_jvm_internal_Reflection_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();     // Catch: Throwable -> L5
    L6:
        if (r100 != null) goto L9;
        r100 = new ReflectionFactory();
    L9:
        factory = r100;
        EMPTY_K_CLASS_ARRAY = new KClass[0];
    }

    public Reflection() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_kotlin_jvm_internal_Reflection_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static KClass createKotlinClass(Class r100) {
        return factory.createKotlinClass(r100);
    }

    public static KFunction function(FunctionReference r100) {
        return factory.function(r100);
    }

    public static KClass getOrCreateKotlinClass(Class r100) {
        return factory.getOrCreateKotlinClass(r100);
    }

    public static KClass[] getOrCreateKotlinClasses(Class[] r100) {
        int r101 = r100.length;
        if (r101 == 0) goto L5;
        KClass[] r102 = new KClass[r101];
        int r103 = 0;
    L7:
        if (r103 >= r101) goto L9;
        r102[r103] = getOrCreateKotlinClass(r100[r103]);
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    L5:
        return EMPTY_K_CLASS_ARRAY;
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class r100) {
        return factory.getOrCreateKotlinPackage(r100, "");
    }

    public static KType mutableCollectionType(KType r100) {
        return factory.mutableCollectionType(r100);
    }

    public static KMutableProperty0 mutableProperty0(MutablePropertyReference0 r100) {
        return factory.mutableProperty0(r100);
    }

    public static KMutableProperty1 mutableProperty1(MutablePropertyReference1 r100) {
        return factory.mutableProperty1(r100);
    }

    public static KMutableProperty2 mutableProperty2(MutablePropertyReference2 r100) {
        return factory.mutableProperty2(r100);
    }

    public static KType nothingType(KType r100) {
        return factory.nothingType(r100);
    }

    public static KType nullableTypeOf(Class r100) {
        return factory.typeOf(getOrCreateKotlinClass(r100), Collections.emptyList(), true);
    }

    public static KProperty0 property0(PropertyReference0 r100) {
        return factory.property0(r100);
    }

    public static KProperty1 property1(PropertyReference1 r100) {
        return factory.property1(r100);
    }

    public static KProperty2 property2(PropertyReference2 r100) {
        return factory.property2(r100);
    }

    public static String renderLambdaToString(FunctionBase r100) {
        return factory.renderLambdaToString(r100);
    }

    public static KType typeOf(Class r100) {
        return factory.typeOf(getOrCreateKotlinClass(r100), Collections.emptyList(), false);
    }

    public static KType nullableTypeOf(KClassifier r100) {
        return factory.typeOf(r100, Collections.emptyList(), true);
    }

    public static String renderLambdaToString(Lambda r100) {
        return factory.renderLambdaToString(r100);
    }

    public static KType typeOf(KClassifier r100) {
        return factory.typeOf(r100, Collections.emptyList(), false);
    }

    public static KClass createKotlinClass(Class r100, String r101) {
        return factory.createKotlinClass(r100, r101);
    }

    public static KClass getOrCreateKotlinClass(Class r100, String r101) {
        return factory.getOrCreateKotlinClass(r100, r101);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class r100, String r101) {
        return factory.getOrCreateKotlinPackage(r100, r101);
    }

    public static KType nullableTypeOf(Class r100, KTypeProjection r101) {
        return factory.typeOf(getOrCreateKotlinClass(r100), Collections.singletonList(r101), true);
    }

    public static KType platformType(KType r100, KType r101) {
        return factory.platformType(r100, r101);
    }

    public static void setUpperBounds(KTypeParameter r100, KType r101) {
        factory.setUpperBounds(r100, Collections.singletonList(r101));
    }

    public static KType typeOf(Class r100, KTypeProjection r101) {
        return factory.typeOf(getOrCreateKotlinClass(r100), Collections.singletonList(r101), false);
    }

    public static KType nullableTypeOf(Class r100, KTypeProjection... r101) {
        return factory.typeOf(getOrCreateKotlinClass(r100), ArraysKt.toList(r101), true);
    }

    public static void setUpperBounds(KTypeParameter r100, KType... r101) {
        factory.setUpperBounds(r100, ArraysKt.toList(r101));
    }

    public static KType typeOf(Class r100, KTypeProjection... r101) {
        return factory.typeOf(getOrCreateKotlinClass(r100), ArraysKt.toList(r101), false);
    }

    public static KType nullableTypeOf(Class r100, KTypeProjection r101, KTypeProjection r102) {
        return factory.typeOf(getOrCreateKotlinClass(r100), Arrays.asList(new KTypeProjection[]{r101, r102}), true);
    }

    public static KType typeOf(Class r100, KTypeProjection r101, KTypeProjection r102) {
        return factory.typeOf(getOrCreateKotlinClass(r100), Arrays.asList(new KTypeProjection[]{r101, r102}), false);
    }

    public static KTypeParameter typeParameter(Object r100, String r101, KVariance r102, boolean r103) {
        return factory.typeParameter(r100, r101, r102, r103);
    }
}
