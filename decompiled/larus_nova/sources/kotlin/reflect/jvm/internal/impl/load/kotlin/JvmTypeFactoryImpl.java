package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes42.dex */
final class JvmTypeFactoryImpl implements JvmTypeFactory<JvmType> {
    public static final JvmTypeFactoryImpl INSTANCE = null;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[PrimitiveType.values().length];
            r100[PrimitiveType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[PrimitiveType.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[PrimitiveType.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[PrimitiveType.SHORT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[PrimitiveType.INT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[PrimitiveType.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[PrimitiveType.LONG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[PrimitiveType.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        INSTANCE = new JvmTypeFactoryImpl();
    }

    private JvmTypeFactoryImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: getJavaLangClassType, reason: avoid collision after fix types in other method */
    public JvmType getJavaLangClassType2() {
        return createObjectType2("java/lang/Class");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType getJavaLangClassType() {
        return getJavaLangClassType2();
    }

    /* JADX INFO: renamed from: boxType, reason: avoid collision after fix types in other method */
    public JvmType boxType2(JvmType r100) {
        Intrinsics.checkNotNullParameter(r100, "possiblyPrimitiveType");
        if ((r100 instanceof JvmType.Primitive) == false) goto L8;
        JvmType.Primitive r101 = (JvmType.Primitive) r100;
        if (r101.getJvmPrimitiveType() != null) goto L7;
        return r100;
    L7:
        return createObjectType2(JvmClassName.byFqNameWithoutInnerClasses(r101.getJvmPrimitiveType().getWrapperFqName()).getInternalName());
    L8:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: createFromString, reason: avoid collision after fix types in other method */
    public JvmType createFromString2(String r110) {
        Intrinsics.checkNotNullParameter(r110, "representation");
        r110.length();
        char r100 = r110.charAt(0);
        JvmPrimitiveType[] r101 = JvmPrimitiveType.values();
        int r102 = r101.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L12;
        JvmPrimitiveType r104 = r101[r103];
        if (r104.getDesc().charAt(0) != r100) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L13;
        r103 = r103 + 1;
    L13:
        if (r104 == null) goto L17;
        return new JvmType.Primitive(r104);
    L17:
        if (r100 != 'V') goto L20;
        return new JvmType.Primitive(null);
    L20:
        if (r100 != '[') goto L24;
        JvmType r106 = new JvmType.Array(createFromString2(r110.substring(1)));
    L30:
        return r106;
    L24:
        if (r100 != 'L') goto L26;
        StringsKt.endsWith$default(r110, ';', false, 2, null);
    L26:
        r106 = new JvmType.Object(r110.substring(1, r110.length() - 1));
        goto L30
    L8:
        r105 = false;
        goto L9
    L12:
        r104 = null;
        goto L13
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: createObjectType, reason: avoid collision after fix types in other method */
    public JvmType createObjectType2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "internalName");
        return new JvmType.Object(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: createPrimitiveType, reason: avoid collision after fix types in other method */
    public JvmType createPrimitiveType2(PrimitiveType r100) {
        Intrinsics.checkNotNullParameter(r100, "primitiveType");
        switch(WhenMappings.$EnumSwitchMapping$0[r100.ordinal()]) {
            case 1: goto L14;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L15:
        return JvmType.Companion.getDOUBLE$descriptors_jvm();
    L16:
        return JvmType.Companion.getLONG$descriptors_jvm();
    L17:
        return JvmType.Companion.getFLOAT$descriptors_jvm();
    L18:
        return JvmType.Companion.getINT$descriptors_jvm();
    L19:
        return JvmType.Companion.getSHORT$descriptors_jvm();
    L20:
        return JvmType.Companion.getBYTE$descriptors_jvm();
    L21:
        return JvmType.Companion.getCHAR$descriptors_jvm();
    L14:
        return JvmType.Companion.getBOOLEAN$descriptors_jvm();
    }

    /* JADX INFO: renamed from: toString, reason: avoid collision after fix types in other method */
    public String toString2(JvmType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if ((r100 instanceof JvmType.Array) == false) goto L6;
        return "[" + toString2(((JvmType.Array) r100).getElementType());
    L6:
        if ((r100 instanceof JvmType.Primitive) == false) goto L13;
        JvmPrimitiveType r101 = ((JvmType.Primitive) r100).getJvmPrimitiveType();
        if (r101 == null) goto L11;
        String r102 = r101.getDesc();
        if (r102 == null) goto L11;
        return r102;
    L11:
        return "V";
    L13:
        if ((r100 instanceof JvmType.Object) == false) goto L17;
        return "L" + ((JvmType.Object) r100).getInternalName() + ';';
    L17:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType boxType(JvmType r100) {
        return boxType2(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType createFromString(String r100) {
        return createFromString2(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType createObjectType(String r100) {
        return createObjectType2(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType createPrimitiveType(PrimitiveType r100) {
        return createPrimitiveType2(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ String toString(JvmType r100) {
        return toString2(r100);
    }
}
