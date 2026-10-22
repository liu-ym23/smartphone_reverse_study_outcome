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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class Reflection {
    private static final KClass[] EMPTY_K_CLASS_ARRAY = null;
    static final String REFLECTION_NOT_AVAILABLE = " (Kotlin reflection is not available)";
    private static final ReflectionFactory factory = null;

    static {
        ReflectionFactory r0 = null;
        r0 = (ReflectionFactory) INVOKESTATIC_kotlin_jvm_internal_Reflection_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();     // Catch: Throwable -> L5
    L6:
        if (r0 != null) goto L9;
        r0 = new ReflectionFactory();
    L9:
        factory = r0;
        EMPTY_K_CLASS_ARRAY = new KClass[0];
    }

    public Reflection() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_kotlin_jvm_internal_Reflection_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static KClass createKotlinClass(Class r1) {
        return factory.createKotlinClass(r1);
    }

    public static KFunction function(FunctionReference r1) {
        return factory.function(r1);
    }

    public static KClass getOrCreateKotlinClass(Class r1) {
        return factory.getOrCreateKotlinClass(r1);
    }

    public static KClass[] getOrCreateKotlinClasses(Class[] r4) {
        int r0 = r4.length;
        if (r0 == 0) goto L5;
        KClass[] r1 = new KClass[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = getOrCreateKotlinClass(r4[r2]);
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    L5:
        return EMPTY_K_CLASS_ARRAY;
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class r2) {
        return factory.getOrCreateKotlinPackage(r2, XmlPullParser.NO_NAMESPACE);
    }

    public static KType mutableCollectionType(KType r1) {
        return factory.mutableCollectionType(r1);
    }

    public static KMutableProperty0 mutableProperty0(MutablePropertyReference0 r1) {
        return factory.mutableProperty0(r1);
    }

    public static KMutableProperty1 mutableProperty1(MutablePropertyReference1 r1) {
        return factory.mutableProperty1(r1);
    }

    public static KMutableProperty2 mutableProperty2(MutablePropertyReference2 r1) {
        return factory.mutableProperty2(r1);
    }

    public static KType nothingType(KType r1) {
        return factory.nothingType(r1);
    }

    public static KType nullableTypeOf(Class r3) {
        return factory.typeOf(getOrCreateKotlinClass(r3), Collections.emptyList(), true);
    }

    public static KProperty0 property0(PropertyReference0 r1) {
        return factory.property0(r1);
    }

    public static KProperty1 property1(PropertyReference1 r1) {
        return factory.property1(r1);
    }

    public static KProperty2 property2(PropertyReference2 r1) {
        return factory.property2(r1);
    }

    public static String renderLambdaToString(FunctionBase r1) {
        return factory.renderLambdaToString(r1);
    }

    public static KType typeOf(Class r3) {
        return factory.typeOf(getOrCreateKotlinClass(r3), Collections.emptyList(), false);
    }

    public static KType nullableTypeOf(KClassifier r3) {
        return factory.typeOf(r3, Collections.emptyList(), true);
    }

    public static String renderLambdaToString(Lambda r1) {
        return factory.renderLambdaToString(r1);
    }

    public static KType typeOf(KClassifier r3) {
        return factory.typeOf(r3, Collections.emptyList(), false);
    }

    public static KClass createKotlinClass(Class r1, String r2) {
        return factory.createKotlinClass(r1, r2);
    }

    public static KClass getOrCreateKotlinClass(Class r1, String r2) {
        return factory.getOrCreateKotlinClass(r1, r2);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class r1, String r2) {
        return factory.getOrCreateKotlinPackage(r1, r2);
    }

    public static KType nullableTypeOf(Class r2, KTypeProjection r3) {
        return factory.typeOf(getOrCreateKotlinClass(r2), Collections.singletonList(r3), true);
    }

    public static KType platformType(KType r1, KType r2) {
        return factory.platformType(r1, r2);
    }

    public static void setUpperBounds(KTypeParameter r1, KType r2) {
        factory.setUpperBounds(r1, Collections.singletonList(r2));
    }

    public static KType typeOf(Class r2, KTypeProjection r3) {
        return factory.typeOf(getOrCreateKotlinClass(r2), Collections.singletonList(r3), false);
    }

    public static KType nullableTypeOf(Class r2, KTypeProjection... r3) {
        return factory.typeOf(getOrCreateKotlinClass(r2), ArraysKt.toList(r3), true);
    }

    public static void setUpperBounds(KTypeParameter r1, KType... r2) {
        factory.setUpperBounds(r1, ArraysKt.toList(r2));
    }

    public static KType typeOf(Class r2, KTypeProjection... r3) {
        return factory.typeOf(getOrCreateKotlinClass(r2), ArraysKt.toList(r3), false);
    }

    public static KType nullableTypeOf(Class r3, KTypeProjection r4, KTypeProjection r5) {
        return factory.typeOf(getOrCreateKotlinClass(r3), Arrays.asList(new KTypeProjection[]{r4, r5}), true);
    }

    public static KType typeOf(Class r3, KTypeProjection r4, KTypeProjection r5) {
        return factory.typeOf(getOrCreateKotlinClass(r3), Arrays.asList(new KTypeProjection[]{r4, r5}), false);
    }

    public static KTypeParameter typeParameter(Object r1, String r2, KVariance r3, boolean r4) {
        return factory.typeParameter(r1, r2, r3, r4);
    }
}
