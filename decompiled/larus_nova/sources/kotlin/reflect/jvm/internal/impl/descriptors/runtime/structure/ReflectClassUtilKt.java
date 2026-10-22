package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class ReflectClassUtilKt {
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES = null;
    private static final List<KClass<? extends Object>> PRIMITIVE_CLASSES = null;
    private static final Map<Class<? extends Object>, Class<? extends Object>> PRIMITIVE_TO_WRAPPER = null;
    private static final Map<Class<? extends Object>, Class<? extends Object>> WRAPPER_TO_PRIMITIVE = null;

    public static /* synthetic */ ParameterizedType accessor$ReflectClassUtilKt$lambda0(ParameterizedType r100) {
        return _get_parameterizedTypeArguments_$lambda$3(r100);
    }

    public static /* synthetic */ Sequence accessor$ReflectClassUtilKt$lambda1(ParameterizedType r100) {
        return _get_parameterizedTypeArguments_$lambda$4(r100);
    }

    static {
        int r100 = 0;
        List<KClass<? extends Object>> r101 = CollectionsKt.listOf(new KClass[]{Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE)});
        PRIMITIVE_CLASSES = r101;
        List<KClass<? extends Object>> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        KClass r110 = (KClass) r104.next();
        r103.add(TuplesKt.to(JvmClassMappingKt.getJavaObjectType(r110), JvmClassMappingKt.getJavaPrimitiveType(r110)));
        goto L4
    L6:
        WRAPPER_TO_PRIMITIVE = MapsKt.toMap(r103);
        List<KClass<? extends Object>> r105 = PRIMITIVE_CLASSES;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        KClass r111 = (KClass) r107.next();
        r106.add(TuplesKt.to(JvmClassMappingKt.getJavaPrimitiveType(r111), JvmClassMappingKt.getJavaObjectType(r111)));
        goto L8
    L10:
        PRIMITIVE_TO_WRAPPER = MapsKt.toMap(r106);
        List r108 = CollectionsKt.listOf(new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r112 = r108.iterator();
    L12:
        if (r112.hasNext() == false) goto L17;
        Object r113 = r112.next();
        int r114 = r100 + 1;
        if (r100 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        r109.add(TuplesKt.to((Class) r113, Integer.valueOf(r100)));
        r100 = r114;
        goto L12
    L17:
        FUNCTION_CLASSES = MapsKt.toMap(r109);
    }

    private static final ParameterizedType _get_parameterizedTypeArguments_$lambda$3(ParameterizedType r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Type r101 = r100.getOwnerType();
        if ((r101 instanceof ParameterizedType) == true) goto L7;
        return null;
    L7:
        return (ParameterizedType) r101;
    }

    private static final Sequence _get_parameterizedTypeArguments_$lambda$4(ParameterizedType r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return ArraysKt.asSequence(r100.getActualTypeArguments());
    }

    public static final ClassId getClassId(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isPrimitive() == true) goto L28;
        if (r100.isArray() == true) goto L26;
        if (r100.getEnclosingMethod() == null) goto L9;
    L23:
        FqName r101 = new FqName(r100.getName());
        return new ClassId(r101.parent(), FqName.topLevel(r101.shortName()), true);
    L9:
        if (r100.getEnclosingConstructor() != null) goto L23;
        if (r100.getSimpleName().length() != 0) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L23;
        Class<?> r103 = r100.getDeclaringClass();
        if (r103 == null) goto L30;
        ClassId r104 = getClassId(r103);
        if (r104 == null) goto L30;
        ClassId r105 = r104.createNestedClassId(Name.identifier(r100.getSimpleName()));
        if (r105 == null) goto L30;
        return r105;
    L30:
        return ClassId.Companion.topLevel(new FqName(r100.getName()));
    L13:
        r102 = false;
        goto L14
    L26:
        throw new IllegalArgumentException("Can't compute ClassId for array type: " + r100);
    L28:
        throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + r100);
    }

    public static final String getDesc(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isPrimitive() == false) goto L37;
        String r101 = r100.getName();
        switch(r101.hashCode()) {
            case -1325958191: goto L32;
            case 104431: goto L29;
            case 3039496: goto L26;
            case 3052374: goto L23;
            case 3327612: goto L20;
            case 3625364: goto L17;
            case 64711720: goto L14;
            case 97526364: goto L11;
            case 109413500: goto L8;
            default: goto L35;
        };
    L8:
        if (r101.equals("short") == false) goto L35;
        return ExifInterface.LATITUDE_SOUTH;
    L11:
        if (r101.equals("float") == false) goto L35;
        return FaceService.girlLabel;
    L14:
        if (r101.equals("boolean") == false) goto L35;
        return "Z";
    L17:
        if (r101.equals("void") == false) goto L35;
        return "V";
    L20:
        if (r101.equals("long") == false) goto L35;
        return "J";
    L23:
        if (r101.equals("char") == false) goto L35;
        return "C";
    L26:
        if (r101.equals("byte") == false) goto L35;
        return "B";
    L29:
        if (r101.equals("int") == false) goto L35;
        return "I";
    L32:
        if (r101.equals(ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L35;
        return "D";
    L35:
        throw new IllegalArgumentException("Unsupported primitive type: " + r100);
    L37:
        if (r100.isArray() == false) goto L40;
        return StringsKt.replace$default(r100.getName(), '.', '/', false, 4, null);
    L40:
        return "L" + StringsKt.replace$default(r100.getName(), '.', '/', false, 4, null) + ';';
    }

    public static final Integer getFunctionClassArity(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return FUNCTION_CLASSES.get(r100);
    }

    public static final List<Type> getParameterizedTypeArguments(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof ParameterizedType) == false) goto L5;
        ParameterizedType r101 = (ParameterizedType) r100;
        if (r101.getOwnerType() != null) goto L11;
        return ArraysKt.toList(r101.getActualTypeArguments());
    L11:
        return SequencesKt.toList(SequencesKt.flatMap(SequencesKt.generateSequence(r100, ReflectClassUtilKt$$Lambda$0.INSTANCE), ReflectClassUtilKt$$Lambda$1.INSTANCE));
    L5:
        return CollectionsKt.emptyList();
    }

    public static final Class<?> getPrimitiveByWrapper(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return WRAPPER_TO_PRIMITIVE.get(r100);
    }

    public static final ClassLoader getSafeClassLoader(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ClassLoader r101 = r100.getClassLoader();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return ClassLoader.getSystemClassLoader();
    }

    public static final Class<?> getWrapperByPrimitive(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return PRIMITIVE_TO_WRAPPER.get(r100);
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Enum.class.isAssignableFrom(r100);
    }
}
