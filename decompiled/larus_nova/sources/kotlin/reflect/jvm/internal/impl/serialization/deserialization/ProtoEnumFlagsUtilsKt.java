package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: loaded from: classes5.dex */
public final class ProtoEnumFlagsUtilsKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

        static {
            int[] r100 = new int[ProtoBuf.MemberKind.values().length];
            r100[ProtoBuf.MemberKind.DECLARATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L56:
            r100[ProtoBuf.MemberKind.FAKE_OVERRIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L64:
            r100[ProtoBuf.MemberKind.DELEGATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L44:
            r100[ProtoBuf.MemberKind.SYNTHESIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L10:
            $EnumSwitchMapping$0 = r100;
            int[] r101 = new int[CallableMemberDescriptor.Kind.values().length];
            r101[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L58:
            r101[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L38:
            r101[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L46:
            r101[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L15:
            $EnumSwitchMapping$1 = r101;
            int[] r102 = new int[ProtoBuf.Visibility.values().length];
            r102[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L40:
            r102[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L48:
            r102[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L54:
            r102[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L62:
            r102[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L42:
            r102[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L22:
            $EnumSwitchMapping$2 = r102;
        }
    }

    public static final DescriptorVisibility descriptorVisibility(ProtoEnumFlags r100, ProtoBuf.Visibility r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
        int r102 = -1;
    L6:
        switch(r102) {
            case 1: goto L14;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            default: goto L15;
        };
    L15:
        return DescriptorVisibilities.PRIVATE;
    L16:
        return DescriptorVisibilities.LOCAL;
    L17:
        return DescriptorVisibilities.PUBLIC;
    L18:
        return DescriptorVisibilities.PROTECTED;
    L19:
        return DescriptorVisibilities.PRIVATE_TO_THIS;
    L20:
        return DescriptorVisibilities.PRIVATE;
    L14:
        return DescriptorVisibilities.INTERNAL;
    L5:
        r102 = WhenMappings.$EnumSwitchMapping$2[r101.ordinal()];
        goto L6
    }

    public static final CallableMemberDescriptor.Kind memberKind(ProtoEnumFlags r100, ProtoBuf.MemberKind r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 == 1) goto L19;
        if (r102 == 2) goto L23;
        if (r102 == 3) goto L22;
        if (r102 == 4) goto L21;
        return CallableMemberDescriptor.Kind.DECLARATION;
    L21:
        return CallableMemberDescriptor.Kind.SYNTHESIZED;
    L22:
        return CallableMemberDescriptor.Kind.DELEGATION;
    L23:
        return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
    L19:
        return CallableMemberDescriptor.Kind.DECLARATION;
    L5:
        r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        goto L7
    }
}
