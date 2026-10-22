package kotlin.jvm;

import androidx.exifinterface.media.ExifInterface;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u001f\u001a\u00020 \"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0014*\u0006\u0012\u0002\b\u00030!¢\u0006\u0002\u0010\"\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\";\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\b\u0012\u0004\u0012\u0002H\b0\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"-\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"&\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0015\";\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"+\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012\"-\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012\"+\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"annotationClass", "Lkotlin/reflect/KClass;", ExifInterface.GPS_DIRECTION_TRUE, "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "declaringJavaClass", "Ljava/lang/Class;", ExifInterface.LONGITUDE_EAST, "", "getDeclaringJavaClass$annotations", "(Ljava/lang/Enum;)V", "getDeclaringJavaClass", "(Ljava/lang/Enum;)Ljava/lang/Class;", "java", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class JvmClassMappingKt {
    public static /* synthetic */ void getDeclaringJavaClass$annotations(Enum r100) {
    }

    public static /* synthetic */ void getJavaClass$annotations(KClass r100) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void getRuntimeClassOfKClassInstance$annotations(KClass r100) {
    }

    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(T r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        KClass<? extends T> r101 = getKotlinClass(r100.annotationType());
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return r101;
    }

    private static final <E extends Enum<E>> Class<E> getDeclaringJavaClass(Enum<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getDeclaringClass();
    }

    public static final <T> Class<T> getJavaClass(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Class<T> r101 = (Class<T>) ((ClassBasedDeclarationContainer) r100).getJClass();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return r101;
    }

    public static final <T> Class<T> getJavaObjectType(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Class<T> r101 = (Class<T>) ((ClassBasedDeclarationContainer) r100).getJClass();
        if (r101.isPrimitive() == true) goto L6;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return r101;
    L6:
        String r102 = r101.getName();
        switch(r102.hashCode()) {
            case -1325958191: goto L42;
            case 104431: goto L38;
            case 3039496: goto L34;
            case 3052374: goto L30;
            case 3327612: goto L26;
            case 3625364: goto L22;
            case 64711720: goto L18;
            case 97526364: goto L14;
            case 109413500: goto L10;
            default: goto L45;
        };
    L45:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return r101;
    L10:
        if (r102.equals("short") == false) goto L45;
        r101 = (Class<T>) Short.class;
        goto L45
    L14:
        if (r102.equals("float") == false) goto L45;
        r101 = (Class<T>) Float.class;
        goto L45
    L18:
        if (r102.equals("boolean") == false) goto L45;
        r101 = (Class<T>) Boolean.class;
        goto L45
    L22:
        if (r102.equals("void") == false) goto L45;
        r101 = (Class<T>) Void.class;
        goto L45
    L26:
        if (r102.equals("long") == false) goto L45;
        r101 = (Class<T>) Long.class;
        goto L45
    L30:
        if (r102.equals("char") == false) goto L45;
        r101 = (Class<T>) Character.class;
        goto L45
    L34:
        if (r102.equals("byte") == false) goto L45;
        r101 = (Class<T>) Byte.class;
        goto L45
    L38:
        if (r102.equals("int") == false) goto L45;
        r101 = (Class<T>) Integer.class;
        goto L45
    L42:
        if (r102.equals(ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L45;
        r101 = (Class<T>) Double.class;
        goto L45
    }

    public static final <T> Class<T> getJavaPrimitiveType(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Class<T> r101 = (Class<T>) ((ClassBasedDeclarationContainer) r100).getJClass();
        if (r101.isPrimitive() == false) goto L6;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
        return r101;
    L6:
        String r102 = r101.getName();
        switch(r102.hashCode()) {
            case -2056817302: goto L42;
            case -527879800: goto L38;
            case -515992664: goto L34;
            case 155276373: goto L30;
            case 344809556: goto L26;
            case 398507100: goto L22;
            case 398795216: goto L18;
            case 399092968: goto L14;
            case 761287205: goto L10;
            default: goto L45;
        };
    L45:
        return null;
    L10:
        if (r102.equals("java.lang.Double") == false) goto L45;
        return Double.TYPE;
    L14:
        if (r102.equals("java.lang.Void") == false) goto L45;
        return Void.TYPE;
    L18:
        if (r102.equals("java.lang.Long") == false) goto L45;
        return Long.TYPE;
    L22:
        if (r102.equals("java.lang.Byte") == false) goto L45;
        return Byte.TYPE;
    L26:
        if (r102.equals("java.lang.Boolean") == false) goto L45;
        return Boolean.TYPE;
    L30:
        if (r102.equals("java.lang.Character") == false) goto L45;
        return Character.TYPE;
    L34:
        if (r102.equals("java.lang.Short") == false) goto L45;
        return Short.TYPE;
    L38:
        if (r102.equals("java.lang.Float") == false) goto L45;
        return Float.TYPE;
    L42:
        if (r102.equals("java.lang.Integer") == false) goto L45;
        return Integer.TYPE;
    }

    public static final <T> KClass<T> getKotlinClass(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Reflection.getOrCreateKotlinClass(r100);
    }

    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Class<KClass<T>> r101 = (Class<KClass<T>>) r100.getClass();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return r101;
    }

    public static final /* synthetic */ boolean isArrayOf(Object[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Object.class.isAssignableFrom(r100.getClass().getComponentType());
    }

    public static final <T> Class<T> getJavaClass(T r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Class<T> r101 = (Class<T>) r100.getClass();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return r101;
    }
}
