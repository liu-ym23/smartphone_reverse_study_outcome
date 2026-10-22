package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public class Flags {
    public static final FlagField<ProtoBuf.Class.Kind> CLASS_KIND = null;
    public static final BooleanFlagField DECLARES_DEFAULT_VALUE = null;
    public static final BooleanFlagField DEFINITELY_NOT_NULL_TYPE = null;
    public static final BooleanFlagField HAS_ANNOTATIONS = null;
    public static final BooleanFlagField HAS_CONSTANT = null;
    public static final BooleanFlagField HAS_ENUM_ENTRIES = null;
    public static final BooleanFlagField HAS_GETTER = null;
    public static final BooleanFlagField HAS_SETTER = null;
    public static final BooleanFlagField IS_CONST = null;
    public static final BooleanFlagField IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = null;
    public static final BooleanFlagField IS_CROSSINLINE = null;
    public static final BooleanFlagField IS_DATA = null;
    public static final BooleanFlagField IS_DELEGATED = null;
    public static final BooleanFlagField IS_EXPECT_CLASS = null;
    public static final BooleanFlagField IS_EXPECT_FUNCTION = null;
    public static final BooleanFlagField IS_EXPECT_PROPERTY = null;
    public static final BooleanFlagField IS_EXTERNAL_ACCESSOR = null;
    public static final BooleanFlagField IS_EXTERNAL_CLASS = null;
    public static final BooleanFlagField IS_EXTERNAL_FUNCTION = null;
    public static final BooleanFlagField IS_EXTERNAL_PROPERTY = null;
    public static final BooleanFlagField IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = null;
    public static final BooleanFlagField IS_FUN_INTERFACE = null;
    public static final BooleanFlagField IS_INFIX = null;
    public static final BooleanFlagField IS_INLINE = null;
    public static final BooleanFlagField IS_INLINE_ACCESSOR = null;
    public static final BooleanFlagField IS_INNER = null;
    public static final BooleanFlagField IS_LATEINIT = null;
    public static final BooleanFlagField IS_NEGATED = null;
    public static final BooleanFlagField IS_NOINLINE = null;
    public static final BooleanFlagField IS_NOT_DEFAULT = null;
    public static final BooleanFlagField IS_NULL_CHECK_PREDICATE = null;
    public static final BooleanFlagField IS_OPERATOR = null;
    public static final BooleanFlagField IS_SECONDARY = null;
    public static final BooleanFlagField IS_SUSPEND = null;
    public static final BooleanFlagField IS_TAILREC = null;
    public static final BooleanFlagField IS_UNSIGNED = null;
    public static final BooleanFlagField IS_VALUE_CLASS = null;
    public static final BooleanFlagField IS_VAR = null;
    public static final FlagField<ProtoBuf.MemberKind> MEMBER_KIND = null;
    public static final FlagField<ProtoBuf.Modality> MODALITY = null;
    public static final BooleanFlagField SUSPEND_TYPE = null;
    public static final FlagField<ProtoBuf.Visibility> VISIBILITY = null;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes42.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BooleanFlagField extends FlagField<Boolean> {
        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", MonitorConstants.CONNECT_TYPE_GET}));
        }

        public BooleanFlagField(int r100) {
            super(r100, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public Boolean get(int r100) {
            boolean r101 = true;
            if ((r100 & (1 << this.offset)) != 0) goto L6;
            r101 = false;
        L6:
            Boolean r102 = Boolean.valueOf(r101);
            if (r102 != null) goto L9;
            $$$reportNull$$$0(0);
        L9:
            return r102;
        }

        /* JADX INFO: renamed from: toFlags, reason: avoid collision after fix types in other method */
        public int toFlags2(Boolean r100) {
            if (r100.booleanValue() == true) goto L7;
            return 0;
        L7:
            return 1 << this.offset;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ Boolean get(int r100) {
            return get(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ int toFlags(Boolean r100) {
            return toFlags2(r100);
        }
    }

    public static class EnumLiteFlagField<E extends Internal.EnumLite> extends FlagField<E> {
        private final E[] values;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"}));
        }

        private static <E> int bitWidth(E[] r100) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            int r101 = r100.length - 1;
            if (r101 != 0) goto L7;
            return 1;
        L7:
            int r102 = 31;
        L8:
            if (r102 < 0) goto L15;
            if (((1 << r102) & r101) != 0) goto L12;
            r102 = r102 - 1;
            goto L8
        L12:
            return r102 + 1;
        L15:
            throw new IllegalStateException("Empty enum: " + r100.getClass());
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public E get(int r100) {
            int r101 = (1 << this.bitWidth) - 1;
            int r102 = this.offset;
            int r103 = (r100 & (r101 << r102)) >> r102;
            E[] r104 = this.values;
            int r105 = r104.length;
            int r106 = 0;
        L3:
            if (r106 >= r105) goto L8;
            E r107 = r104[r106];
            if (r107.getNumber() == r103) goto L6;
            r106 = r106 + 1;
            goto L3
        L6:
            return r107;
        L8:
            return null;
        }

        public int toFlags(E r100) {
            return r100.getNumber() << this.offset;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ Object get(int r100) {
            return get(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ int toFlags(Object r100) {
            return toFlags((Internal.EnumLite) r100);
        }

        public EnumLiteFlagField(int r100, E[] r101) {
            super(r100, bitWidth(r101), null);
            this.values = r101;
        }
    }

    public static abstract class FlagField<E> {
        public final int bitWidth;
        public final int offset;

        public abstract E get(int r100);

        public abstract int toFlags(E r100);

        public static BooleanFlagField booleanFirst() {
            return new BooleanFlagField(0);
        }

        public static BooleanFlagField booleanAfter(FlagField<?> r100) {
            return new BooleanFlagField(r100.offset + r100.bitWidth);
        }

        private FlagField(int r100, int r101) {
            this.offset = r100;
            this.bitWidth = r101;
        }

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/Internal$EnumLite;>(Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$FlagField<*>;[TE;)Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$FlagField<TE;>; */
        public static FlagField after(FlagField r100, Internal.EnumLite[] r101) {
            return new EnumLiteFlagField(r100.offset + r100.bitWidth, r101);
        }

        public /* synthetic */ FlagField(int r100, int r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        Object[] r101 = new Object[3];
        if (r100 == 1) goto L18;
        if (r100 != 2) goto L6;
        r101[0] = "kind";
    L19:
        r101[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch(r100) {
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L24;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L23;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L22;
            default: goto L21;
        };
    L21:
        r101[2] = "getClassFlags";
    L27:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r101));
    L22:
        r101[2] = "getAccessorFlags";
        goto L27
    L23:
        r101[2] = "getPropertyFlags";
        goto L27
    L24:
        r101[2] = "getFunctionFlags";
        goto L27
    L25:
        r101[2] = "getConstructorFlags";
        goto L27
    L6:
        if (r100 == 5) goto L18;
        if (r100 != 6) goto L10;
    L16:
        r101[0] = "memberKind";
        goto L19
    L10:
        if (r100 == 8) goto L18;
        if (r100 == 9) goto L16;
        if (r100 == 11) goto L18;
        r101[0] = RemoteMessageConst.Notification.VISIBILITY;
    L18:
        r101[0] = "modality";
        goto L19
    }

    static {
        BooleanFlagField r100 = FlagField.booleanFirst();
        SUSPEND_TYPE = r100;
        DEFINITELY_NOT_NULL_TYPE = FlagField.booleanAfter(r100);
        BooleanFlagField r101 = FlagField.booleanFirst();
        HAS_ANNOTATIONS = r101;
        FlagField<ProtoBuf.Visibility> r102 = FlagField.after(r101, ProtoBuf.Visibility.values());
        VISIBILITY = r102;
        FlagField<ProtoBuf.Modality> r103 = FlagField.after(r102, ProtoBuf.Modality.values());
        MODALITY = r103;
        FlagField<ProtoBuf.Class.Kind> r104 = FlagField.after(r103, ProtoBuf.Class.Kind.values());
        CLASS_KIND = r104;
        BooleanFlagField r105 = FlagField.booleanAfter(r104);
        IS_INNER = r105;
        BooleanFlagField r106 = FlagField.booleanAfter(r105);
        IS_DATA = r106;
        BooleanFlagField r107 = FlagField.booleanAfter(r106);
        IS_EXTERNAL_CLASS = r107;
        BooleanFlagField r108 = FlagField.booleanAfter(r107);
        IS_EXPECT_CLASS = r108;
        BooleanFlagField r109 = FlagField.booleanAfter(r108);
        IS_VALUE_CLASS = r109;
        BooleanFlagField r110 = FlagField.booleanAfter(r109);
        IS_FUN_INTERFACE = r110;
        HAS_ENUM_ENTRIES = FlagField.booleanAfter(r110);
        BooleanFlagField r111 = FlagField.booleanAfter(r102);
        IS_SECONDARY = r111;
        IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = FlagField.booleanAfter(r111);
        FlagField<ProtoBuf.MemberKind> r112 = FlagField.after(r103, ProtoBuf.MemberKind.values());
        MEMBER_KIND = r112;
        BooleanFlagField r113 = FlagField.booleanAfter(r112);
        IS_OPERATOR = r113;
        BooleanFlagField r114 = FlagField.booleanAfter(r113);
        IS_INFIX = r114;
        BooleanFlagField r115 = FlagField.booleanAfter(r114);
        IS_INLINE = r115;
        BooleanFlagField r116 = FlagField.booleanAfter(r115);
        IS_TAILREC = r116;
        BooleanFlagField r117 = FlagField.booleanAfter(r116);
        IS_EXTERNAL_FUNCTION = r117;
        BooleanFlagField r118 = FlagField.booleanAfter(r117);
        IS_SUSPEND = r118;
        BooleanFlagField r119 = FlagField.booleanAfter(r118);
        IS_EXPECT_FUNCTION = r119;
        IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = FlagField.booleanAfter(r119);
        BooleanFlagField r120 = FlagField.booleanAfter(r112);
        IS_VAR = r120;
        BooleanFlagField r121 = FlagField.booleanAfter(r120);
        HAS_GETTER = r121;
        BooleanFlagField r122 = FlagField.booleanAfter(r121);
        HAS_SETTER = r122;
        BooleanFlagField r123 = FlagField.booleanAfter(r122);
        IS_CONST = r123;
        BooleanFlagField r124 = FlagField.booleanAfter(r123);
        IS_LATEINIT = r124;
        BooleanFlagField r125 = FlagField.booleanAfter(r124);
        HAS_CONSTANT = r125;
        BooleanFlagField r126 = FlagField.booleanAfter(r125);
        IS_EXTERNAL_PROPERTY = r126;
        BooleanFlagField r127 = FlagField.booleanAfter(r126);
        IS_DELEGATED = r127;
        IS_EXPECT_PROPERTY = FlagField.booleanAfter(r127);
        BooleanFlagField r128 = FlagField.booleanAfter(r101);
        DECLARES_DEFAULT_VALUE = r128;
        BooleanFlagField r129 = FlagField.booleanAfter(r128);
        IS_CROSSINLINE = r129;
        IS_NOINLINE = FlagField.booleanAfter(r129);
        BooleanFlagField r130 = FlagField.booleanAfter(r103);
        IS_NOT_DEFAULT = r130;
        BooleanFlagField r131 = FlagField.booleanAfter(r130);
        IS_EXTERNAL_ACCESSOR = r131;
        IS_INLINE_ACCESSOR = FlagField.booleanAfter(r131);
        BooleanFlagField r132 = FlagField.booleanFirst();
        IS_NEGATED = r132;
        IS_NULL_CHECK_PREDICATE = FlagField.booleanAfter(r132);
        IS_UNSIGNED = FlagField.booleanFirst();
    }

    public static int getAccessorFlags(boolean r100, ProtoBuf.Visibility r101, ProtoBuf.Modality r102, boolean r103, boolean r104, boolean r105) {
        if (r101 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        if (r102 != null) goto L7;
        $$$reportNull$$$0(11);
    L7:
        return ((((HAS_ANNOTATIONS.toFlags2(Boolean.valueOf(r100)) | MODALITY.toFlags(r102)) | VISIBILITY.toFlags(r101)) | IS_NOT_DEFAULT.toFlags2(Boolean.valueOf(r103))) | IS_EXTERNAL_ACCESSOR.toFlags2(Boolean.valueOf(r104))) | IS_INLINE_ACCESSOR.toFlags2(Boolean.valueOf(r105));
    }
}
