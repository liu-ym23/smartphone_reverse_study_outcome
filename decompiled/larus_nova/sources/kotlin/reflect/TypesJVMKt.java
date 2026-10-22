package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\u0015"}, d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TypesJVMKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[KVariance.values().length];
            r100[KVariance.IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[KVariance.INVARIANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static /* synthetic */ void getJavaType$annotations(KType r100) {
    }

    private static /* synthetic */ void getJavaType$annotations(KTypeProjection r100) {
    }

    public static final /* synthetic */ String access$typeToString(Type r100) {
        return typeToString(r100);
    }

    private static final Type getJavaType(KTypeProjection r100) {
        KVariance r101 = r100.getVariance();
        if (r101 == null) goto L5;
        KType r102 = r100.getType();
        Intrinsics.checkNotNull(r102);
        int r103 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L19;
        if (r103 != 3) goto L14;
        return new WildcardTypeImpl(computeJavaType(r102, true), null);
    L14:
        throw new NoWhenBranchMatchedException();
    L19:
        return computeJavaType(r102, true);
    L17:
        return new WildcardTypeImpl(null, computeJavaType(r102, true));
    L5:
        return WildcardTypeImpl.Companion.getSTAR();
    }

    private static final String typeToString(Type r100) {
        if ((r100 instanceof Class) == false) goto L10;
        Class r101 = (Class) r100;
        if (r101.isArray() == false) goto L7;
        Sequence r102 = SequencesKt.generateSequence(r100, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
        String r103 = ((Class) SequencesKt.last(r102)).getName() + StringsKt.repeat("[]", SequencesKt.count(r102));
    L8:
        Intrinsics.checkNotNull(r103);
        return r103;
    L7:
        r103 = r101.getName();
        goto L8
    L10:
        return r100.toString();
    }

    public static final Type getJavaType(KType r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof KTypeBase) == false) goto L8;
        Type r101 = ((KTypeBase) r100).getJavaType();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return computeJavaType$default(r100, false, 1, null);
    }

    public static final /* synthetic */ Type access$computeJavaType(KType r100, boolean r101) {
        return computeJavaType(r100, r101);
    }

    private static final Type computeJavaType(KType r100, boolean r101) {
        KClassifier r102 = r100.getClassifier();
        if ((r102 instanceof KTypeParameter) == false) goto L7;
        return new TypeVariableImpl((KTypeParameter) r102);
    L7:
        if ((r102 instanceof KClass) == false) goto L46;
        KClass r103 = (KClass) r102;
        if (r101 == false) goto L11;
        Class r104 = JvmClassMappingKt.getJavaObjectType(r103);
    L12:
        List<KTypeProjection> r105 = r100.getArguments();
        if (r105.isEmpty() == false) goto L16;
        return r104;
    L16:
        if (r104.isArray() == false) goto L44;
        if (r104.getComponentType().isPrimitive() == false) goto L20;
        return r104;
    L20:
        KTypeProjection r106 = (KTypeProjection) CollectionsKt.singleOrNull(r105);
        if (r106 == null) goto L42;
        KVariance r107 = r106.component1();
        KType r108 = r106.component2();
        if (r107 != null) goto L25;
        int r109 = -1;
    L26:
        if (r109 != (-1)) goto L28;
        return r104;
    L28:
        if (r109 != 1) goto L30;
        return r104;
    L30:
        if (r109 != 2) goto L32;
    L36:
        Intrinsics.checkNotNull(r108);
        Type r110 = computeJavaType$default(r108, false, 1, null);
        if ((r110 instanceof Class) == false) goto L40;
        return r104;
    L40:
        return new GenericArrayTypeImpl(r110);
    L32:
        if (r109 == 3) goto L36;
        throw new NoWhenBranchMatchedException();
    L25:
        r109 = WhenMappings.$EnumSwitchMapping$0[r107.ordinal()];
        goto L26
    L42:
        throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + r100);
    L44:
        return createPossiblyInnerType(r104, r105);
    L11:
        r104 = JvmClassMappingKt.getJavaClass(r103);
        goto L12
    L46:
        throw new UnsupportedOperationException("Unsupported type classifier: " + r100);
    }

    private static final Type createPossiblyInnerType(Class<?> r100, List<KTypeProjection> r101) {
        Class<?> r102 = r100.getDeclaringClass();
        if (r102 != null) goto L11;
        List<KTypeProjection> r103 = r101;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L9;
        r104.add(getJavaType((KTypeProjection) r105.next()));
        goto L6
    L9:
        return new ParameterizedTypeImpl(r100, null, r104);
    L11:
        if (Modifier.isStatic(r100.getModifiers()) == false) goto L18;
        List<KTypeProjection> r106 = r101;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L14:
        if (r108.hasNext() == false) goto L17;
        r107.add(getJavaType((KTypeProjection) r108.next()));
        goto L14
    L17:
        return new ParameterizedTypeImpl(r100, r102, r107);
    L18:
        int r109 = r100.getTypeParameters().length;
        Type r110 = createPossiblyInnerType(r102, r101.subList(r109, r101.size()));
        List<KTypeProjection> r111 = r101.subList(0, r109);
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r113 = r111.iterator();
    L20:
        if (r113.hasNext() == false) goto L23;
        r112.add(getJavaType((KTypeProjection) r113.next()));
        goto L20
    L23:
        return new ParameterizedTypeImpl(r100, r110, r112);
    }

    public static /* synthetic */ Type computeJavaType$default(KType r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return computeJavaType(r100, r101);
    }
}
