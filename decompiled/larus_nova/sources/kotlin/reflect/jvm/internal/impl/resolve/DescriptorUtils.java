package kotlin.reflect.jvm.internal.impl.resolve;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes5.dex */
public class DescriptorUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final FqName JVM_NAME = null;

    private static /* synthetic */ void $$$reportNull$$$0(int r210) {
        switch(r210) {
            case 4: goto L4;
            case 7: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            case 12: goto L4;
            case 22: goto L4;
            case 40: goto L4;
            case 42: goto L4;
            case 43: goto L4;
            case 47: goto L4;
            case 49: goto L4;
            case 50: goto L4;
            case 51: goto L4;
            case 52: goto L4;
            case 53: goto L4;
            case 60: goto L4;
            case 62: goto L4;
            case 63: goto L4;
            case 65: goto L4;
            case 72: goto L4;
            case 76: goto L4;
            case 83: goto L4;
            case 84: goto L4;
            case 86: goto L4;
            case 89: goto L4;
            case 94: goto L4;
            case 96: goto L4;
            default: goto L3;
        };
    L3:
        String r100 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r210) {
            case 4: goto L8;
            case 7: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 12: goto L8;
            case 22: goto L8;
            case 40: goto L8;
            case 42: goto L8;
            case 43: goto L8;
            case 47: goto L8;
            case 49: goto L8;
            case 50: goto L8;
            case 51: goto L8;
            case 52: goto L8;
            case 53: goto L8;
            case 60: goto L8;
            case 62: goto L8;
            case 63: goto L8;
            case 65: goto L8;
            case 72: goto L8;
            case 76: goto L8;
            case 83: goto L8;
            case 84: goto L8;
            case 86: goto L8;
            case 89: goto L8;
            case 94: goto L8;
            case 96: goto L8;
            default: goto L7;
        };
    L7:
        int r101 = 3;
    L9:
        Object[] r102 = new Object[r101];
        switch(r210) {
            case 1: goto L35;
            case 2: goto L35;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L35;
            case 6: goto L35;
            case 7: goto L34;
            case 8: goto L35;
            case 9: goto L34;
            case 10: goto L34;
            case 11: goto L35;
            case 12: goto L34;
            case 13: goto L35;
            case 14: goto L35;
            case 15: goto L35;
            case 16: goto L33;
            case 17: goto L32;
            case 18: goto L31;
            case 19: goto L31;
            case 20: goto L30;
            case 21: goto L35;
            case 22: goto L34;
            case 23: goto L35;
            case 24: goto L35;
            case 25: goto L29;
            case 26: goto L28;
            case 27: goto L27;
            case 28: goto L28;
            case 29: goto L27;
            case 30: goto L26;
            case 31: goto L25;
            case 32: goto L26;
            case 33: goto L27;
            case 34: goto L35;
            case 35: goto L35;
            case 36: goto L35;
            case 37: goto L24;
            case 38: goto L23;
            case 39: goto L23;
            case 40: goto L34;
            case 41: goto L23;
            case 42: goto L34;
            case 43: goto L34;
            case 44: goto L23;
            case 45: goto L26;
            case 46: goto L22;
            case 47: goto L34;
            case 48: goto L23;
            case 49: goto L34;
            case 50: goto L34;
            case 51: goto L34;
            case 52: goto L34;
            case 53: goto L34;
            case 54: goto L23;
            case 55: goto L21;
            case 56: goto L20;
            case 57: goto L35;
            case 58: goto L35;
            case 59: goto L35;
            case 60: goto L34;
            case 61: goto L35;
            case 62: goto L34;
            case 63: goto L34;
            case 64: goto L35;
            case 65: goto L34;
            case 66: goto L19;
            case 67: goto L26;
            case 68: goto L23;
            case 69: goto L23;
            case 70: goto L23;
            case 71: goto L18;
            case 72: goto L34;
            case 73: goto L17;
            case 74: goto L16;
            case 75: goto L15;
            case 76: goto L34;
            case 77: goto L23;
            case 78: goto L23;
            case 79: goto L14;
            case 80: goto L14;
            case 81: goto L14;
            case 82: goto L35;
            case 83: goto L34;
            case 84: goto L34;
            case 85: goto L13;
            case 86: goto L34;
            case 87: goto L13;
            case 88: goto L12;
            case 89: goto L34;
            case 90: goto L13;
            case 91: goto L12;
            case 92: goto L13;
            case 93: goto L12;
            case 94: goto L34;
            case 95: goto L35;
            case 96: goto L34;
            case 97: goto L35;
            default: goto L11;
        };
    L11:
        r102[0] = "containingDeclaration";
    L37:
        switch(r210) {
            case 4: goto L57;
            case 7: goto L56;
            case 9: goto L55;
            case 10: goto L55;
            case 12: goto L54;
            case 22: goto L53;
            case 40: goto L52;
            case 42: goto L51;
            case 43: goto L51;
            case 47: goto L50;
            case 49: goto L49;
            case 50: goto L49;
            case 51: goto L49;
            case 52: goto L49;
            case 53: goto L49;
            case 60: goto L48;
            case 62: goto L47;
            case 63: goto L47;
            case 65: goto L46;
            case 72: goto L45;
            case 76: goto L44;
            case 83: goto L43;
            case 84: goto L43;
            case 86: goto L42;
            case 89: goto L41;
            case 94: goto L40;
            case 96: goto L39;
            default: goto L38;
        };
    L38:
        r102[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
    L58:
        switch(r210) {
            case 1: goto L115;
            case 2: goto L114;
            case 3: goto L113;
            case 4: goto L116;
            case 5: goto L112;
            case 6: goto L111;
            case 7: goto L116;
            case 8: goto L110;
            case 9: goto L116;
            case 10: goto L116;
            case 11: goto L109;
            case 12: goto L116;
            case 13: goto L108;
            case 14: goto L107;
            case 15: goto L106;
            case 16: goto L105;
            case 17: goto L105;
            case 18: goto L104;
            case 19: goto L104;
            case 20: goto L103;
            case 21: goto L102;
            case 22: goto L116;
            case 23: goto L103;
            case 24: goto L101;
            case 25: goto L100;
            case 26: goto L99;
            case 27: goto L99;
            case 28: goto L98;
            case 29: goto L98;
            case 30: goto L97;
            case 31: goto L97;
            case 32: goto L96;
            case 33: goto L96;
            case 34: goto L95;
            case 35: goto L94;
            case 36: goto L93;
            case 37: goto L92;
            case 38: goto L91;
            case 39: goto L90;
            case 40: goto L116;
            case 41: goto L89;
            case 42: goto L116;
            case 43: goto L116;
            case 44: goto L88;
            case 45: goto L87;
            case 46: goto L86;
            case 47: goto L116;
            case 48: goto L85;
            case 49: goto L116;
            case 50: goto L116;
            case 51: goto L116;
            case 52: goto L116;
            case 53: goto L116;
            case 54: goto L84;
            case 55: goto L84;
            case 56: goto L84;
            case 57: goto L83;
            case 58: goto L82;
            case 59: goto L81;
            case 60: goto L116;
            case 61: goto L80;
            case 62: goto L116;
            case 63: goto L116;
            case 64: goto L79;
            case 65: goto L116;
            case 66: goto L78;
            case 67: goto L78;
            case 68: goto L77;
            case 69: goto L76;
            case 70: goto L75;
            case 71: goto L74;
            case 72: goto L116;
            case 73: goto L73;
            case 74: goto L73;
            case 75: goto L72;
            case 76: goto L116;
            case 77: goto L71;
            case 78: goto L70;
            case 79: goto L69;
            case 80: goto L68;
            case 81: goto L67;
            case 82: goto L66;
            case 83: goto L116;
            case 84: goto L116;
            case 85: goto L65;
            case 86: goto L116;
            case 87: goto L64;
            case 88: goto L64;
            case 89: goto L116;
            case 90: goto L63;
            case 91: goto L63;
            case 92: goto L62;
            case 93: goto L62;
            case 94: goto L116;
            case 95: goto L61;
            case 96: goto L116;
            case 97: goto L60;
            default: goto L59;
        };
    L59:
        r102[2] = "getDispatchReceiverParameterIfNeeded";
        goto L116
    L60:
        r102[2] = "isMethodOfAny";
        goto L116
    L61:
        r102[2] = "getDirectMember";
        goto L116
    L62:
        r102[2] = "getPropertyByName";
        goto L116
    L63:
        r102[2] = "getFunctionByNameOrNull";
        goto L116
    L64:
        r102[2] = "getFunctionByName";
        goto L116
    L65:
        r102[2] = "getAllDescriptors";
        goto L116
    L66:
        r102[2] = "getContainingSourceFile";
        goto L116
    L67:
        r102[2] = "hasJvmNameAnnotation";
        goto L116
    L68:
        r102[2] = "findJvmNameAnnotation";
        goto L116
    L69:
        r102[2] = "getJvmName";
        goto L116
    L70:
        r102[2] = "canHaveDeclaredConstructors";
        goto L116
    L71:
        r102[2] = "isSingletonOrAnonymousObject";
        goto L116
    L72:
        r102[2] = "getAllOverriddenDeclarations";
        goto L116
    L73:
        r102[2] = "collectAllOverriddenDescriptors";
        goto L116
    L74:
        r102[2] = "getAllOverriddenDescriptors";
        goto L116
    L75:
        r102[2] = "classCanHaveOpenMembers";
        goto L116
    L76:
        r102[2] = "classCanHaveAbstractDeclaration";
        goto L116
    L77:
        r102[2] = "classCanHaveAbstractFakeOverride";
        goto L116
    L78:
        r102[2] = "shouldRecordInitializerForProperty";
        goto L116
    L79:
        r102[2] = "unwrapFakeOverrideToAnyDeclaration";
        goto L116
    L80:
        r102[2] = "unwrapSubstitutionOverride";
        goto L116
    L81:
        r102[2] = "unwrapFakeOverride";
        goto L116
    L82:
        r102[2] = "isTopLevelOrInnerClass";
        goto L116
    L83:
        r102[2] = "isStaticNestedClass";
        goto L116
    L84:
        r102[2] = "getInnerClassByName";
        goto L116
    L85:
        r102[2] = "getDefaultConstructorVisibility";
        goto L116
    L86:
        r102[2] = "getClassDescriptorForTypeConstructor";
        goto L116
    L87:
        r102[2] = "getClassDescriptorForType";
        goto L116
    L88:
        r102[2] = "getSuperClassDescriptor";
        goto L116
    L89:
        r102[2] = "getSuperClassType";
        goto L116
    L90:
        r102[2] = "getSuperclassDescriptors";
        goto L116
    L91:
        r102[2] = "hasAbstractMembers";
        goto L116
    L92:
        r102[2] = "isKindOf";
        goto L116
    L93:
        r102[2] = "isEnumEntry";
        goto L116
    L94:
        r102[2] = "isAnonymousFunction";
        goto L116
    L95:
        r102[2] = "isAnonymousObject";
        goto L116
    L96:
        r102[2] = "isSubtypeOfClass";
        goto L116
    L97:
        r102[2] = "isSameClass";
        goto L116
    L98:
        r102[2] = "isSubclass";
        goto L116
    L99:
        r102[2] = "isDirectSubclass";
        goto L116
    L100:
        r102[2] = "isAncestor";
        goto L116
    L101:
        r102[2] = "getContainingClass";
        goto L116
    L102:
        r102[2] = "getContainingModule";
        goto L116
    L103:
        r102[2] = "getContainingModuleOrNull";
        goto L116
    L104:
        r102[2] = "getParentOfType";
        goto L116
    L105:
        r102[2] = "areInSameModule";
        goto L116
    L106:
        r102[2] = "isStaticDeclaration";
        goto L116
    L107:
        r102[2] = "isOverride";
        goto L116
    L108:
        r102[2] = "isExtension";
        goto L116
    L109:
        r102[2] = "getClassIdForNonLocalClass";
        goto L116
    L110:
        r102[2] = "getFqNameFromTopLevelClass";
        goto L116
    L111:
        r102[2] = "getFqNameUnsafe";
        goto L116
    L112:
        r102[2] = "getFqNameSafeIfPossible";
        goto L116
    L113:
        r102[2] = "getFqNameSafe";
        goto L116
    L114:
        r102[2] = "getFqName";
        goto L116
    L115:
        r102[2] = "isLocal";
    L116:
        String r103 = String.format(r100, r102);
        switch(r210) {
            case 4: goto L120;
            case 7: goto L120;
            case 9: goto L120;
            case 10: goto L120;
            case 12: goto L120;
            case 22: goto L120;
            case 40: goto L120;
            case 42: goto L120;
            case 43: goto L120;
            case 47: goto L120;
            case 49: goto L120;
            case 50: goto L120;
            case 51: goto L120;
            case 52: goto L120;
            case 53: goto L120;
            case 60: goto L120;
            case 62: goto L120;
            case 63: goto L120;
            case 65: goto L120;
            case 72: goto L120;
            case 76: goto L120;
            case 83: goto L120;
            case 84: goto L120;
            case 86: goto L120;
            case 89: goto L120;
            case 94: goto L120;
            case 96: goto L120;
            default: goto L121;
        };
    L121:
        throw new IllegalArgumentException(r103);
    L120:
        throw new IllegalStateException(r103);
    L39:
        r102[1] = "getDirectMember";
        goto L58
    L40:
        r102[1] = "getPropertyByName";
        goto L58
    L41:
        r102[1] = "getFunctionByName";
        goto L58
    L42:
        r102[1] = "getAllDescriptors";
        goto L58
    L43:
        r102[1] = "getContainingSourceFile";
        goto L58
    L44:
        r102[1] = "getAllOverriddenDeclarations";
        goto L58
    L45:
        r102[1] = "getAllOverriddenDescriptors";
        goto L58
    L46:
        r102[1] = "unwrapFakeOverrideToAnyDeclaration";
        goto L58
    L47:
        r102[1] = "unwrapSubstitutionOverride";
        goto L58
    L48:
        r102[1] = "unwrapFakeOverride";
        goto L58
    L49:
        r102[1] = "getDefaultConstructorVisibility";
        goto L58
    L50:
        r102[1] = "getClassDescriptorForTypeConstructor";
        goto L58
    L51:
        r102[1] = "getSuperClassType";
        goto L58
    L52:
        r102[1] = "getSuperclassDescriptors";
        goto L58
    L53:
        r102[1] = "getContainingModule";
        goto L58
    L54:
        r102[1] = "getClassIdForNonLocalClass";
        goto L58
    L55:
        r102[1] = "getFqNameFromTopLevelClass";
        goto L58
    L56:
        r102[1] = "getFqNameUnsafe";
        goto L58
    L57:
        r102[1] = "getFqNameSafe";
        goto L58
    L12:
        r102[0] = "name";
        goto L37
    L13:
        r102[0] = "scope";
        goto L37
    L14:
        r102[0] = "annotated";
        goto L37
    L15:
        r102[0] = "memberDescriptor";
        goto L37
    L16:
        r102[0] = "result";
        goto L37
    L17:
        r102[0] = "current";
        goto L37
    L18:
        r102[0] = "f";
        goto L37
    L19:
        r102[0] = "variable";
        goto L37
    L20:
        r102[0] = "location";
        goto L37
    L21:
        r102[0] = "innerClassName";
        goto L37
    L22:
        r102[0] = "typeConstructor";
        goto L37
    L23:
        r102[0] = "classDescriptor";
        goto L37
    L24:
        r102[0] = "classKind";
        goto L37
    L25:
        r102[0] = "other";
        goto L37
    L26:
        r102[0] = "type";
        goto L37
    L27:
        r102[0] = "superClass";
        goto L37
    L28:
        r102[0] = "subClass";
        goto L37
    L29:
        r102[0] = "declarationDescriptor";
        goto L37
    L30:
        r102[0] = "kotlinType";
        goto L37
    L31:
        r102[0] = "aClass";
        goto L37
    L32:
        r102[0] = "second";
        goto L37
    L33:
        r102[0] = SoloKtvContext.SOLO_PAGE_FIRST;
        goto L37
    L34:
        r102[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
        goto L37
    L35:
        r102[0] = "descriptor";
        goto L37
    L8:
        r101 = 2;
        goto L9
    L4:
        r100 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
        JVM_NAME = new FqName("kotlin.jvm.JvmName");
    }

    private DescriptorUtils() {
    }

    public static <D extends CallableDescriptor> Set<D> getAllOverriddenDescriptors(D r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(71);
    L4:
        LinkedHashSet r101 = new LinkedHashSet();
        collectAllOverriddenDescriptors(r100.getOriginal(), r101);
        return r101;
    }

    public static ClassDescriptor getClassDescriptorForType(KotlinType r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(45);
    L5:
        return getClassDescriptorForTypeConstructor(r100.getConstructor());
    }

    public static ClassDescriptor getClassDescriptorForTypeConstructor(TypeConstructor r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(46);
    L4:
        ClassDescriptor r101 = (ClassDescriptor) r100.mo10732getDeclarationDescriptor();
        if (r101 != null) goto L7;
        $$$reportNull$$$0(47);
    L7:
        return r101;
    }

    public static ModuleDescriptor getContainingModule(DeclarationDescriptor r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(21);
    L4:
        ModuleDescriptor r101 = getContainingModuleOrNull(r100);
        if (r101 != null) goto L7;
        $$$reportNull$$$0(22);
    L7:
        return r101;
    }

    public static ModuleDescriptor getContainingModuleOrNull(DeclarationDescriptor r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(23);
    L4:
        if (r100 == null) goto L14;
        if ((r100 instanceof ModuleDescriptor) == true) goto L8;
        if ((r100 instanceof PackageViewDescriptor) == true) goto L12;
        r100 = r100.getContainingDeclaration();
        goto L4
    L12:
        return ((PackageViewDescriptor) r100).getModule();
    L8:
        return (ModuleDescriptor) r100;
    L14:
        return null;
    }

    public static SourceFile getContainingSourceFile(DeclarationDescriptor r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(82);
    L5:
        if ((r100 instanceof PropertySetterDescriptor) == false) goto L8;
        r100 = ((PropertySetterDescriptor) r100).getCorrespondingProperty();
    L8:
        if ((r100 instanceof DeclarationDescriptorWithSource) == false) goto L13;
        SourceFile r101 = ((DeclarationDescriptorWithSource) r100).getSource().getContainingFile();
        if (r101 != null) goto L12;
        $$$reportNull$$$0(83);
    L12:
        return r101;
    L13:
        SourceFile r102 = SourceFile.NO_SOURCE_FILE;
        if (r102 != null) goto L16;
        $$$reportNull$$$0(84);
    L16:
        return r102;
    }

    public static ReceiverParameterDescriptor getDispatchReceiverParameterIfNeeded(DeclarationDescriptor r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        if ((r100 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return ((ClassDescriptor) r100).getThisAsReceiverParameter();
    }

    public static FqNameUnsafe getFqName(DeclarationDescriptor r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        FqName r101 = getFqNameSafeIfPossible(r100);
        if (r101 == null) goto L8;
        return r101.toUnsafe();
    L8:
        return getFqNameUnsafe(r100);
    }

    public static FqName getFqNameSafe(DeclarationDescriptor r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        FqName r101 = getFqNameSafeIfPossible(r100);
        if (r101 != null) goto L8;
        r101 = getFqNameUnsafe(r100).toSafe();
    L8:
        if (r101 != null) goto L10;
        $$$reportNull$$$0(4);
    L10:
        return r101;
    }

    private static FqName getFqNameSafeIfPossible(DeclarationDescriptor r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        if ((r100 instanceof ModuleDescriptor) == true) goto L20;
        if (ErrorUtils.isError(r100) == true) goto L20;
        if ((r100 instanceof PackageViewDescriptor) == false) goto L14;
        return ((PackageViewDescriptor) r100).getFqName();
    L14:
        if ((r100 instanceof PackageFragmentDescriptor) == true) goto L16;
        return null;
    L16:
        return ((PackageFragmentDescriptor) r100).getFqName();
    L20:
        return FqName.ROOT;
    }

    private static FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        FqNameUnsafe r101 = getFqName(r100.getContainingDeclaration()).child(r100.getName());
        if (r101 != null) goto L7;
        $$$reportNull$$$0(7);
    L7:
        return r101;
    }

    public static ClassDescriptor getSuperClassDescriptor(ClassDescriptor r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(44);
    L4:
        Iterator<KotlinType> r101 = r100.getTypeConstructor().mo10733getSupertypes().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ClassDescriptor r102 = getClassDescriptorForType(r101.next());
        if (r102.getKind() == ClassKind.INTERFACE) goto L6;
        return r102;
    L10:
        return null;
    }

    public static boolean isAnnotationClass(DeclarationDescriptor r100) {
        return isKindOf(r100, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean isAnonymousObject(DeclarationDescriptor r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(34);
    L5:
        if (isClass(r100) == true) goto L7;
    L9:
        return false;
    L7:
        if (r100.getName().equals(SpecialNames.NO_NAME_PROVIDED) == false) goto L9;
        return true;
    }

    public static boolean isClass(DeclarationDescriptor r100) {
        return isKindOf(r100, ClassKind.CLASS);
    }

    public static boolean isClassOrEnumClass(DeclarationDescriptor r100) {
        if (isClass(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (isEnumClass(r100) == true) goto L8;
        return false;
    }

    public static boolean isCompanionObject(DeclarationDescriptor r100) {
        if (isKindOf(r100, ClassKind.OBJECT) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ClassDescriptor) r100).isCompanionObject() == false) goto L7;
        return true;
    }

    public static boolean isDescriptorWithLocalVisibility(DeclarationDescriptor r100) {
        if ((r100 instanceof DeclarationDescriptorWithVisibility) == true) goto L5;
    L7:
        return false;
    L5:
        if (((DeclarationDescriptorWithVisibility) r100).getVisibility() != DescriptorVisibilities.LOCAL) goto L7;
        return true;
    }

    public static boolean isEnumClass(DeclarationDescriptor r100) {
        return isKindOf(r100, ClassKind.ENUM_CLASS);
    }

    public static boolean isEnumEntry(DeclarationDescriptor r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(36);
    L5:
        return isKindOf(r100, ClassKind.ENUM_ENTRY);
    }

    public static boolean isInterface(DeclarationDescriptor r100) {
        return isKindOf(r100, ClassKind.INTERFACE);
    }

    public static boolean isLocal(DeclarationDescriptor r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        if (r100 == null) goto L13;
        if (isAnonymousObject(r100) == true) goto L12;
        if (isDescriptorWithLocalVisibility(r100) == true) goto L12;
        r100 = r100.getContainingDeclaration();
    L12:
        return true;
    L13:
        return false;
    }

    public static boolean isSealedClass(DeclarationDescriptor r100) {
        if (isKindOf(r100, ClassKind.CLASS) == true) goto L7;
        if (isKindOf(r100, ClassKind.INTERFACE) == true) goto L7;
    L9:
        return false;
    L7:
        if (((ClassDescriptor) r100).getModality() != Modality.SEALED) goto L9;
        return true;
    }

    public static boolean isTopLevelDeclaration(DeclarationDescriptor r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if ((r100.getContainingDeclaration() instanceof PackageFragmentDescriptor) == false) goto L6;
        return true;
    }

    public static <D extends CallableMemberDescriptor> D unwrapFakeOverride(D r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(59);
    L5:
        if (r100.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L11;
        Collection<? extends CallableMemberDescriptor> r101 = r100.getOverriddenDescriptors();
        if (r101.isEmpty() == true) goto L10;
        r100 = (D) r101.iterator().next();
        goto L5
    L10:
        throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + r100);
    L11:
        return r100;
    }

    public static <D extends DeclarationDescriptorWithVisibility> D unwrapFakeOverrideToAnyDeclaration(D r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(64);
    L5:
        if ((r100 instanceof CallableMemberDescriptor) == true) goto L7;
        if (r100 != null) goto L10;
        $$$reportNull$$$0(65);
    L10:
        return r100;
    L7:
        return unwrapFakeOverride((CallableMemberDescriptor) r100);
    }

    public static ModuleDescriptor getContainingModuleOrNull(KotlinType r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(20);
    L4:
        ClassifierDescriptor r101 = r100.getConstructor().mo10732getDeclarationDescriptor();
        if (r101 != null) goto L9;
        return null;
    L9:
        return getContainingModuleOrNull(r101);
    }

    public static boolean areInSameModule(DeclarationDescriptor r100, DeclarationDescriptor r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(16);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(17);
    L7:
        return getContainingModule(r100).equals(getContainingModule(r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <D extends CallableDescriptor> void collectAllOverriddenDescriptors(D r100, Set<D> r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(73);
    L4:
        if (r101 != 0) goto L7;
        $$$reportNull$$$0(74);
    L7:
        if (r101.contains(r100) == false) goto L9;
        return;
    L9:
        Iterator<? extends CallableDescriptor> r102 = r100.getOriginal().getOverriddenDescriptors().iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        CallableDescriptor r103 = r102.next().getOriginal();
        collectAllOverriddenDescriptors(r103, r101);
        r101.add(r103);
        goto L11
    }

    public static DescriptorVisibility getDefaultConstructorVisibility(ClassDescriptor r100, boolean r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(48);
    L4:
        ClassKind r102 = r100.getKind();
        if (r102 != ClassKind.ENUM_CLASS) goto L7;
    L30:
        DescriptorVisibility r103 = DescriptorVisibilities.PRIVATE;
        if (r103 != null) goto L33;
        $$$reportNull$$$0(49);
    L33:
        return r103;
    L7:
        if (r102.isSingleton() == true) goto L30;
        if (isSealedClass(r100) == false) goto L21;
        if (r101 == false) goto L16;
        DescriptorVisibility r104 = DescriptorVisibilities.PROTECTED;
        if (r104 != null) goto L15;
        $$$reportNull$$$0(50);
    L15:
        return r104;
    L16:
        DescriptorVisibility r105 = DescriptorVisibilities.PRIVATE;
        if (r105 != null) goto L19;
        $$$reportNull$$$0(51);
    L19:
        return r105;
    L21:
        if (isAnonymousObject(r100) == false) goto L26;
        DescriptorVisibility r106 = DescriptorVisibilities.DEFAULT_VISIBILITY;
        if (r106 != null) goto L25;
        $$$reportNull$$$0(52);
    L25:
        return r106;
    L26:
        DescriptorVisibility r107 = DescriptorVisibilities.PUBLIC;
        if (r107 != null) goto L29;
        $$$reportNull$$$0(53);
    L29:
        return r107;
    }

    public static <D extends DeclarationDescriptor> D getParentOfType(DeclarationDescriptor r100, Class<D> r101) {
        if (r101 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        return (D) getParentOfType(r100, r101, true);
    }

    public static boolean isDirectSubclass(ClassDescriptor r100, ClassDescriptor r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(27);
    L6:
        Iterator<KotlinType> r102 = r100.getTypeConstructor().mo10733getSupertypes().iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        if (isSameClass(r102.next(), r101.getOriginal()) == false) goto L8;
        return true;
    L13:
        return false;
    }

    private static boolean isKindOf(DeclarationDescriptor r100, ClassKind r101) {
        if (r101 != null) goto L5;
        $$$reportNull$$$0(37);
    L5:
        if ((r100 instanceof ClassDescriptor) == true) goto L7;
    L9:
        return false;
    L7:
        if (((ClassDescriptor) r100).getKind() != r101) goto L9;
        return true;
    }

    private static boolean isSameClass(KotlinType r100, DeclarationDescriptor r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(30);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(31);
    L6:
        ClassifierDescriptor r102 = r100.getConstructor().mo10732getDeclarationDescriptor();
        if (r102 == null) goto L16;
        DeclarationDescriptor r103 = r102.getOriginal();
        if ((r103 instanceof ClassifierDescriptor) == true) goto L11;
        return false;
    L11:
        if ((r101 instanceof ClassifierDescriptor) == true) goto L13;
        return false;
    L13:
        if (((ClassifierDescriptor) r101).getTypeConstructor().equals(((ClassifierDescriptor) r103).getTypeConstructor()) == false) goto L20;
        return true;
    L20:
        return false;
    L16:
        return false;
    }

    public static boolean isSubclass(ClassDescriptor r100, ClassDescriptor r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(28);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(29);
    L7:
        return isSubtypeOfClass(r100.getDefaultType(), r101.getOriginal());
    }

    public static boolean isSubtypeOfClass(KotlinType r100, DeclarationDescriptor r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(32);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(33);
    L7:
        if (isSameClass(r100, r101) == false) goto L9;
        return true;
    L9:
        Iterator<KotlinType> r102 = r100.getConstructor().mo10733getSupertypes().iterator();
    L11:
        if (r102.hasNext() == false) goto L15;
        if (isSubtypeOfClass(r102.next(), r101) == false) goto L11;
        return true;
    L15:
        return false;
    }

    public static boolean shouldRecordInitializerForProperty(VariableDescriptor r100, KotlinType r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(66);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(67);
    L7:
        if (r100.isVar() == false) goto L9;
        return false;
    L9:
        if (KotlinTypeKt.isError(r101) == false) goto L12;
        return false;
    L12:
        if (TypeUtils.acceptsNullable(r101) == false) goto L14;
        return true;
    L14:
        KotlinBuiltIns r102 = DescriptorUtilsKt.getBuiltIns(r100);
        if (KotlinBuiltIns.isPrimitiveType(r101) == true) goto L24;
        KotlinTypeChecker r103 = KotlinTypeChecker.DEFAULT;
        if (r103.equalTypes(r102.getStringType(), r101) == true) goto L24;
        if (r103.equalTypes(r102.getNumber().getDefaultType(), r101) == true) goto L24;
        if (r103.equalTypes(r102.getAnyType(), r101) == true) goto L24;
        if (UnsignedTypes.isUnsignedType(r101) == true) goto L24;
        return false;
    L24:
        return true;
    }

    public static <D extends DeclarationDescriptor> D getParentOfType(DeclarationDescriptor r100, Class<D> r101, boolean r102) {
        if (r101 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        if (r100 != null) goto L7;
        return null;
    L7:
        if (r102 == false) goto L9;
        r100 = (D) r100.getContainingDeclaration();
    L9:
        if (r100 == null) goto L14;
        if (r101.isInstance(r100) == true) goto L12;
        r100 = (D) r100.getContainingDeclaration();
        goto L9
    L12:
        return (D) r100;
    L14:
        return null;
    }
}
