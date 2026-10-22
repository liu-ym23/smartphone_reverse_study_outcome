package kotlin.reflect.jvm.internal.impl.resolve;

import com.amap.api.col.s.ce;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public class OverridingUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final OverridingUtil DEFAULT = null;
    private static final KotlinTypeChecker.TypeConstructorEquality DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = null;
    private static final List<ExternalOverridabilityCondition> EXTERNAL_CONDITIONS = null;
    private final Function2<KotlinType, KotlinType, Boolean> customSubtype;
    private final KotlinTypeChecker.TypeConstructorEquality equalityAxioms;
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeRefiner kotlinTypeRefiner;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$descriptors$Modality = null;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result = null;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result = null;

        static {
            int[] r100 = new int[Modality.values().length];
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality = r100;
            r100[Modality.FINAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.SEALED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L36:
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.OPEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L46:
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.ABSTRACT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L9:
            int[] r101 = new int[OverrideCompatibilityInfo.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result = r101;
            r101[OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L32:
            $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[OverrideCompatibilityInfo.Result.CONFLICT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L34:
            $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[OverrideCompatibilityInfo.Result.INCOMPATIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L13:
            int[] r102 = new int[ExternalOverridabilityCondition.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result = r102;
            r102[ExternalOverridabilityCondition.Result.OVERRIDABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L44:
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.INCOMPATIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L28:
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static class OverrideCompatibilityInfo {
        private static final OverrideCompatibilityInfo SUCCESS = null;
        private final String debugMessage;
        private final Result overridable;

        /* JADX INFO: loaded from: classes5.dex */
        public static final enum Result extends Enum<Result> {
            private static final /* synthetic */ Result[] $VALUES = null;
            public static final Result CONFLICT = null;
            public static final Result INCOMPATIBLE = null;
            public static final Result OVERRIDABLE = null;

            static {
                Result r100 = new Result("OVERRIDABLE", 0);
                OVERRIDABLE = r100;
                Result r101 = new Result("INCOMPATIBLE", 1);
                INCOMPATIBLE = r101;
                Result r102 = new Result("CONFLICT", 2);
                CONFLICT = r102;
                $VALUES = new Result[]{r100, r101, r102};
            }

            public static Result[] values() {
                return (Result[]) $VALUES.clone();
            }

            public static Result valueOf(String r100) {
                return (Result) a.a(Result.class, r100);
            }

            private Result(String r100, int r101) {
                super(r100, r101);
            }
        }

        private static /* synthetic */ void $$$reportNull$$$0(int r110) {
            if (r110 == 1) goto L8;
            if (r110 == 2) goto L8;
            if (r110 == 3) goto L8;
            if (r110 == 4) goto L8;
            String r100 = "@NotNull method %s.%s must not return null";
        L9:
            if (r110 == 1) goto L14;
            if (r110 == 2) goto L14;
            if (r110 == 3) goto L14;
            if (r110 == 4) goto L14;
            int r101 = 2;
        L15:
            Object[] r102 = new Object[r101];
            if (r110 == 1) goto L22;
            if (r110 == 2) goto L22;
            if (r110 == 3) goto L21;
            if (r110 == 4) goto L22;
            r102[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
        L23:
            switch(r110) {
                case 1: goto L27;
                case 2: goto L27;
                case 3: goto L27;
                case 4: goto L27;
                case 5: goto L26;
                case 6: goto L25;
                default: goto L24;
            };
        L24:
            r102[1] = "success";
        L28:
            if (r110 == 1) goto L35;
            if (r110 == 2) goto L34;
            if (r110 == 3) goto L33;
            if (r110 == 4) goto L33;
        L36:
            String r103 = String.format(r100, r102);
            if (r110 == 1) goto L43;
            if (r110 == 2) goto L43;
            if (r110 == 3) goto L43;
            if (r110 == 4) goto L43;
            throw new IllegalStateException(r103);
        L43:
            throw new IllegalArgumentException(r103);
        L33:
            r102[2] = "<init>";
            goto L36
        L34:
            r102[2] = "conflict";
            goto L36
        L35:
            r102[2] = "incompatible";
            goto L36
        L25:
            r102[1] = "getDebugMessage";
            goto L28
        L26:
            r102[1] = "getResult";
            goto L28
        L27:
            r102[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
            goto L28
        L21:
            r102[0] = "success";
        L22:
            r102[0] = "debugMessage";
        L14:
            r101 = 3;
        L8:
            r100 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            goto L9
        }

        static {
            SUCCESS = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        }

        public static OverrideCompatibilityInfo success() {
            OverrideCompatibilityInfo r100 = SUCCESS;
            if (r100 != null) goto L5;
            $$$reportNull$$$0(0);
        L5:
            return r100;
        }

        public Result getResult() {
            Result r100 = this.overridable;
            if (r100 != null) goto L5;
            $$$reportNull$$$0(5);
        L5:
            return r100;
        }

        public String toString() {
            return this.overridable + ": " + this.debugMessage;
        }

        public static OverrideCompatibilityInfo conflict(String r100) {
            if (r100 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return new OverrideCompatibilityInfo(Result.CONFLICT, r100);
        }

        public static OverrideCompatibilityInfo incompatible(String r100) {
            if (r100 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, r100);
        }

        public OverrideCompatibilityInfo(Result r100, String r101) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(3);
        L4:
            if (r101 != null) goto L6;
            $$$reportNull$$$0(4);
        L6:
            this.overridable = r100;
            this.debugMessage = r101;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r210) {
        if (r210 == 11) goto L17;
        if (r210 == 12) goto L17;
        if (r210 == 16) goto L17;
        if (r210 == 21) goto L17;
        if (r210 == 93) goto L17;
        if (r210 == 96) goto L17;
        if (r210 == 101) goto L17;
        if (r210 == 42) goto L17;
        if (r210 == 43) goto L17;
        switch(r210) {
            case 24: goto L17;
            case 25: goto L17;
            case 26: goto L17;
            case 27: goto L17;
            default: goto L13;
        };
    L13:
        switch(r210) {
            case 30: goto L17;
            case 31: goto L17;
            case 32: goto L17;
            case 33: goto L17;
            case 34: goto L17;
            case 35: goto L17;
            case 36: goto L17;
            case 37: goto L17;
            default: goto L14;
        };
    L14:
        switch(r210) {
            case 78: goto L17;
            case 79: goto L17;
            case 80: goto L17;
            case 81: goto L17;
            case 82: goto L17;
            default: goto L15;
        };
    L15:
        switch(r210) {
            case 88: goto L17;
            case 89: goto L17;
            case 90: goto L17;
            default: goto L16;
        };
    L16:
        String r110 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L19:
        if (r210 == 11) goto L33;
        if (r210 == 12) goto L33;
        if (r210 == 16) goto L33;
        if (r210 == 21) goto L33;
        if (r210 == 93) goto L33;
        if (r210 == 96) goto L33;
        if (r210 == 101) goto L33;
        if (r210 == 42) goto L33;
        if (r210 == 43) goto L33;
        switch(r210) {
            case 24: goto L33;
            case 25: goto L33;
            case 26: goto L33;
            case 27: goto L33;
            default: goto L29;
        };
    L29:
        switch(r210) {
            case 30: goto L33;
            case 31: goto L33;
            case 32: goto L33;
            case 33: goto L33;
            case 34: goto L33;
            case 35: goto L33;
            case 36: goto L33;
            case 37: goto L33;
            default: goto L30;
        };
    L30:
        switch(r210) {
            case 78: goto L33;
            case 79: goto L33;
            case 80: goto L33;
            case 81: goto L33;
            case 82: goto L33;
            default: goto L31;
        };
    L31:
        switch(r210) {
            case 88: goto L33;
            case 89: goto L33;
            case 90: goto L33;
            default: goto L32;
        };
    L32:
        int r111 = 3;
    L34:
        Object[] r112 = new Object[r111];
        switch(r210) {
            case 1: goto L80;
            case 2: goto L79;
            case 3: goto L36;
            case 4: goto L78;
            case 5: goto L77;
            case 6: goto L36;
            case 7: goto L80;
            case 8: goto L76;
            case 9: goto L76;
            case 10: goto L75;
            case 11: goto L74;
            case 12: goto L74;
            case 13: goto L73;
            case 14: goto L72;
            case 15: goto L71;
            case 16: goto L74;
            case 17: goto L71;
            case 18: goto L70;
            case 19: goto L69;
            case 20: goto L68;
            case 21: goto L74;
            case 22: goto L69;
            case 23: goto L68;
            case 24: goto L74;
            case 25: goto L74;
            case 26: goto L74;
            case 27: goto L74;
            case 28: goto L69;
            case 29: goto L68;
            case 30: goto L74;
            case 31: goto L74;
            case 32: goto L74;
            case 33: goto L74;
            case 34: goto L74;
            case 35: goto L74;
            case 36: goto L74;
            case 37: goto L74;
            case 38: goto L69;
            case 39: goto L68;
            case 40: goto L67;
            case 41: goto L66;
            case 42: goto L74;
            case 43: goto L74;
            case 44: goto L65;
            case 45: goto L64;
            case 46: goto L63;
            case 47: goto L62;
            case 48: goto L61;
            case 49: goto L63;
            case 50: goto L60;
            case 51: goto L59;
            case 52: goto L58;
            case 53: goto L57;
            case 54: goto L56;
            case 55: goto L55;
            case 56: goto L54;
            case 57: goto L53;
            case 58: goto L52;
            case 59: goto L57;
            case 60: goto L56;
            case 61: goto L51;
            case 62: goto L57;
            case 63: goto L51;
            case 64: goto L56;
            case 65: goto L50;
            case 66: goto L49;
            case 67: goto L50;
            case 68: goto L49;
            case 69: goto L48;
            case 70: goto L47;
            case 71: goto L50;
            case 72: goto L46;
            case 73: goto L49;
            case 74: goto L45;
            case 75: goto L63;
            case 76: goto L44;
            case 77: goto L43;
            case 78: goto L74;
            case 79: goto L74;
            case 80: goto L74;
            case 81: goto L74;
            case 82: goto L74;
            case 83: goto L44;
            case 84: goto L57;
            case 85: goto L56;
            case 86: goto L47;
            case 87: goto L57;
            case 88: goto L74;
            case 89: goto L74;
            case 90: goto L74;
            case 91: goto L47;
            case 92: goto L42;
            case 93: goto L74;
            case 94: goto L57;
            case 95: goto L41;
            case 96: goto L74;
            case 97: goto L40;
            case 98: goto L39;
            case 99: goto L43;
            case 100: goto L38;
            case 101: goto L74;
            case 102: goto L40;
            case 103: goto L39;
            case 104: goto L56;
            case 105: goto L37;
            case 106: goto L37;
            case 107: goto L47;
            default: goto L36;
        };
    L36:
        r112[0] = "kotlinTypeRefiner";
    L82:
        if (r210 == 11) goto L105;
        if (r210 == 12) goto L105;
        if (r210 == 16) goto L104;
        if (r210 == 21) goto L103;
        if (r210 == 93) goto L102;
        if (r210 == 96) goto L101;
        if (r210 == 101) goto L100;
        if (r210 == 42) goto L99;
        if (r210 == 43) goto L99;
        switch(r210) {
            case 24: goto L103;
            case 25: goto L103;
            case 26: goto L103;
            case 27: goto L103;
            default: goto L92;
        };
    L92:
        switch(r210) {
            case 30: goto L98;
            case 31: goto L98;
            case 32: goto L98;
            case 33: goto L98;
            case 34: goto L98;
            case 35: goto L98;
            case 36: goto L98;
            case 37: goto L98;
            default: goto L93;
        };
    L93:
        switch(r210) {
            case 78: goto L97;
            case 79: goto L97;
            case 80: goto L97;
            case 81: goto L97;
            case 82: goto L97;
            default: goto L94;
        };
    L94:
        switch(r210) {
            case 88: goto L96;
            case 89: goto L96;
            case 90: goto L96;
            default: goto L95;
        };
    L95:
        r112[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
    L106:
        switch(r210) {
            case 1: goto L139;
            case 2: goto L139;
            case 3: goto L138;
            case 4: goto L138;
            case 5: goto L137;
            case 6: goto L137;
            case 7: goto L137;
            case 8: goto L136;
            case 9: goto L135;
            case 10: goto L135;
            case 11: goto L140;
            case 12: goto L140;
            case 13: goto L134;
            case 14: goto L134;
            case 15: goto L133;
            case 16: goto L140;
            case 17: goto L132;
            case 18: goto L132;
            case 19: goto L131;
            case 20: goto L131;
            case 21: goto L140;
            case 22: goto L131;
            case 23: goto L131;
            case 24: goto L140;
            case 25: goto L140;
            case 26: goto L140;
            case 27: goto L140;
            case 28: goto L130;
            case 29: goto L130;
            case 30: goto L140;
            case 31: goto L140;
            case 32: goto L140;
            case 33: goto L140;
            case 34: goto L140;
            case 35: goto L140;
            case 36: goto L140;
            case 37: goto L140;
            case 38: goto L129;
            case 39: goto L129;
            case 40: goto L128;
            case 41: goto L128;
            case 42: goto L140;
            case 43: goto L140;
            case 44: goto L127;
            case 45: goto L127;
            case 46: goto L127;
            case 47: goto L126;
            case 48: goto L126;
            case 49: goto L126;
            case 50: goto L125;
            case 51: goto L125;
            case 52: goto L125;
            case 53: goto L125;
            case 54: goto L125;
            case 55: goto L124;
            case 56: goto L124;
            case 57: goto L123;
            case 58: goto L123;
            case 59: goto L123;
            case 60: goto L123;
            case 61: goto L122;
            case 62: goto L121;
            case 63: goto L121;
            case 64: goto L121;
            case 65: goto L120;
            case 66: goto L120;
            case 67: goto L119;
            case 68: goto L119;
            case 69: goto L118;
            case 70: goto L118;
            case 71: goto L117;
            case 72: goto L117;
            case 73: goto L117;
            case 74: goto L117;
            case 75: goto L117;
            case 76: goto L116;
            case 77: goto L116;
            case 78: goto L140;
            case 79: goto L140;
            case 80: goto L140;
            case 81: goto L140;
            case 82: goto L140;
            case 83: goto L115;
            case 84: goto L115;
            case 85: goto L115;
            case 86: goto L114;
            case 87: goto L114;
            case 88: goto L140;
            case 89: goto L140;
            case 90: goto L140;
            case 91: goto L113;
            case 92: goto L113;
            case 93: goto L140;
            case 94: goto L112;
            case 95: goto L112;
            case 96: goto L140;
            case 97: goto L111;
            case 98: goto L111;
            case 99: goto L111;
            case 100: goto L111;
            case 101: goto L140;
            case 102: goto L111;
            case 103: goto L111;
            case 104: goto L111;
            case 105: goto L110;
            case 106: goto L109;
            case 107: goto L108;
            default: goto L107;
        };
    L107:
        r112[2] = "createWithTypeRefiner";
        goto L140
    L108:
        r112[2] = "findMaxVisibility";
        goto L140
    L109:
        r112[2] = "computeVisibilityToInherit";
        goto L140
    L110:
        r112[2] = "resolveUnknownVisibilityForMember";
        goto L140
    L111:
        r112[2] = "extractMembersOverridableInBothWays";
        goto L140
    L112:
        r112[2] = "filterVisibleFakeOverrides";
        goto L140
    L113:
        r112[2] = "getMinimalModality";
        goto L140
    L114:
        r112[2] = "determineModalityForFakeOverride";
        goto L140
    L115:
        r112[2] = "createAndBindFakeOverride";
        goto L140
    L116:
        r112[2] = "selectMostSpecificMember";
        goto L140
    L117:
        r112[2] = "isReturnTypeMoreSpecific";
        goto L140
    L118:
        r112[2] = "isMoreSpecificThenAllOf";
        goto L140
    L119:
        r112[2] = "isVisibilityMoreSpecific";
        goto L140
    L120:
        r112[2] = "isMoreSpecific";
        goto L140
    L121:
        r112[2] = "createAndBindFakeOverrides";
        goto L140
    L122:
        r112[2] = "allHasSameContainingDeclaration";
        goto L140
    L123:
        r112[2] = "extractAndBindOverridesForMember";
        goto L140
    L124:
        r112[2] = "isVisibleForOverride";
        goto L140
    L125:
        r112[2] = "generateOverridesInFunctionGroup";
        goto L140
    L126:
        r112[2] = "areTypeParametersEquivalent";
        goto L140
    L127:
        r112[2] = "areTypesEquivalent";
        goto L140
    L128:
        r112[2] = "createTypeCheckerState";
        goto L140
    L129:
        r112[2] = "getBasicOverridabilityProblem";
        goto L140
    L130:
        r112[2] = "isOverridableByWithoutExternalConditions";
        goto L140
    L131:
        r112[2] = "isOverridableBy";
        goto L140
    L132:
        r112[2] = "collectOverriddenDeclarations";
        goto L140
    L133:
        r112[2] = "getOverriddenDeclarations";
        goto L140
    L134:
        r112[2] = "overrides";
        goto L140
    L135:
        r112[2] = "filterOverrides";
        goto L140
    L136:
        r112[2] = "filterOutOverridden";
        goto L140
    L137:
        r112[2] = "<init>";
        goto L140
    L138:
        r112[2] = "create";
        goto L140
    L139:
        r112[2] = "createWithTypePreparatorAndCustomSubtype";
    L140:
        String r113 = String.format(r110, r112);
        if (r210 == 11) goto L156;
        if (r210 == 12) goto L156;
        if (r210 == 16) goto L156;
        if (r210 == 21) goto L156;
        if (r210 == 93) goto L156;
        if (r210 == 96) goto L156;
        if (r210 == 101) goto L156;
        if (r210 == 42) goto L156;
        if (r210 == 43) goto L156;
        switch(r210) {
            case 24: goto L156;
            case 25: goto L156;
            case 26: goto L156;
            case 27: goto L156;
            default: goto L151;
        };
    L151:
        switch(r210) {
            case 30: goto L156;
            case 31: goto L156;
            case 32: goto L156;
            case 33: goto L156;
            case 34: goto L156;
            case 35: goto L156;
            case 36: goto L156;
            case 37: goto L156;
            default: goto L152;
        };
    L152:
        switch(r210) {
            case 78: goto L156;
            case 79: goto L156;
            case 80: goto L156;
            case 81: goto L156;
            case 82: goto L156;
            default: goto L153;
        };
    L153:
        switch(r210) {
            case 88: goto L156;
            case 89: goto L156;
            case 90: goto L156;
            default: goto L157;
        };
    L157:
        throw new IllegalArgumentException(r113);
    L156:
        throw new IllegalStateException(r113);
    L96:
        r112[1] = "determineModalityForFakeOverride";
        goto L106
    L97:
        r112[1] = "selectMostSpecificMember";
        goto L106
    L98:
        r112[1] = "isOverridableByWithoutExternalConditions";
    L99:
        r112[1] = "createTypeCheckerState";
        goto L106
    L100:
        r112[1] = "extractMembersOverridableInBothWays";
        goto L106
    L101:
        r112[1] = "filterVisibleFakeOverrides";
        goto L106
    L102:
        r112[1] = "getMinimalModality";
    L103:
        r112[1] = "isOverridableBy";
        goto L106
    L104:
        r112[1] = "getOverriddenDeclarations";
    L105:
        r112[1] = "filterOverrides";
        goto L106
    L37:
        r112[0] = "memberDescriptor";
        goto L82
    L38:
        r112[0] = "onConflict";
        goto L82
    L39:
        r112[0] = "extractFrom";
        goto L82
    L40:
        r112[0] = "overrider";
        goto L82
    L41:
        r112[0] = "toFilter";
        goto L82
    L42:
        r112[0] = "classModality";
        goto L82
    L43:
        r112[0] = "descriptorByHandle";
        goto L82
    L44:
        r112[0] = "overridables";
        goto L82
    L45:
        r112[0] = "bReturnType";
        goto L82
    L46:
        r112[0] = "aReturnType";
        goto L82
    L47:
        r112[0] = "descriptors";
        goto L82
    L48:
        r112[0] = "candidate";
        goto L82
    L49:
        r112[0] = "b";
        goto L82
    L50:
        r112[0] = BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY;
        goto L82
    L51:
        r112[0] = "notOverridden";
        goto L82
    L52:
        r112[0] = "descriptorsFromSuper";
        goto L82
    L53:
        r112[0] = "fromCurrent";
        goto L82
    L54:
        r112[0] = "fromSuper";
        goto L82
    L55:
        r112[0] = "overriding";
        goto L82
    L56:
        r112[0] = BdpAppEventConstant.PARAMS_STRATEGY_NAME;
        goto L82
    L57:
        r112[0] = "current";
        goto L82
    L58:
        r112[0] = "membersFromCurrent";
        goto L82
    L59:
        r112[0] = "membersFromSupertypes";
        goto L82
    L60:
        r112[0] = "name";
        goto L82
    L61:
        r112[0] = "subTypeParameter";
        goto L82
    L62:
        r112[0] = "superTypeParameter";
        goto L82
    L63:
        r112[0] = "typeCheckerState";
        goto L82
    L64:
        r112[0] = "typeInSub";
        goto L82
    L65:
        r112[0] = "typeInSuper";
        goto L82
    L66:
        r112[0] = "secondParameters";
        goto L82
    L67:
        r112[0] = "firstParameters";
        goto L82
    L68:
        r112[0] = "subDescriptor";
        goto L82
    L69:
        r112[0] = "superDescriptor";
        goto L82
    L70:
        r112[0] = "result";
        goto L82
    L71:
        r112[0] = "descriptor";
        goto L82
    L72:
        r112[0] = ce.f26391f;
        goto L82
    L73:
        r112[0] = "f";
        goto L82
    L74:
        r112[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
        goto L82
    L75:
        r112[0] = "transformFirst";
        goto L82
    L76:
        r112[0] = "candidateSet";
        goto L82
    L77:
        r112[0] = "axioms";
        goto L82
    L78:
        r112[0] = "equalityAxioms";
        goto L82
    L79:
        r112[0] = "customSubtype";
        goto L82
    L80:
        r112[0] = "kotlinTypePreparator";
    L33:
        r111 = 2;
    L17:
        r110 = "@NotNull method %s.%s must not return null";
        goto L19
    }

    static {
        EXTERNAL_CONDITIONS = CollectionsKt.toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
        KotlinTypeChecker.TypeConstructorEquality r100 = new AnonymousClass1();
        DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = r100;
        DEFAULT = new OverridingUtil(r100, KotlinTypeRefiner.Default.INSTANCE, KotlinTypePreparator.Default.INSTANCE, null);
    }

    private static boolean allHasSameContainingDeclaration(Collection<CallableMemberDescriptor> r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(61);
    L5:
        if (r100.size() >= 2) goto L8;
        return true;
    L8:
        final DeclarationDescriptor r101 = r100.iterator().next().getContainingDeclaration();
        return CollectionsKt.all(r100, new AnonymousClass3(r101));
    }

    private static List<KotlinType> compiledValueParameters(CallableDescriptor r100) {
        ReceiverParameterDescriptor r101 = r100.getExtensionReceiverParameter();
        ArrayList r102 = new ArrayList();
        if (r101 == null) goto L5;
        r102.add(r101.getType());
    L5:
        Iterator<ValueParameterDescriptor> r103 = r100.getValueParameters().iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r102.add(r103.next().getType());
        goto L7
    L9:
        return r102;
    }

    private static DescriptorVisibility computeVisibilityToInherit(CallableMemberDescriptor r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(106);
    L4:
        Collection<? extends CallableMemberDescriptor> r101 = r100.getOverriddenDescriptors();
        DescriptorVisibility r102 = findMaxVisibility(r101);
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r100.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L19;
        Iterator<? extends CallableMemberDescriptor> r103 = r101.iterator();
    L11:
        if (r103.hasNext() == false) goto L17;
        CallableMemberDescriptor r104 = r103.next();
        if (r104.getModality() == Modality.ABSTRACT) goto L11;
        if (r104.getVisibility().equals(r102) == true) goto L11;
        return null;
    L17:
        return r102;
    L19:
        return r102.normalize();
    }

    public static OverridingUtil createWithTypeRefiner(KotlinTypeRefiner r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, r100, KotlinTypePreparator.Default.INSTANCE, null);
    }

    public static <D extends CallableDescriptor> Set<D> filterOutOverridden(Set<D> r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        if (r100.isEmpty() == false) goto L7;
    L9:
        boolean r101 = false;
    L11:
        return filterOverrides(r100, r101, null, new AnonymousClass2());
    L7:
        if (DescriptorUtilsKt.isTypeRefinementEnabled(DescriptorUtilsKt.getModule(r100.iterator().next())) == false) goto L9;
        r101 = true;
        goto L11
    }

    public static DescriptorVisibility findMaxVisibility(Collection<? extends CallableMemberDescriptor> r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(107);
    L5:
        if (r100.isEmpty() == true) goto L7;
        Iterator<? extends CallableMemberDescriptor> r101 = r100.iterator();
    L9:
        DescriptorVisibility r102 = null;
    L11:
        if (r101.hasNext() == false) goto L21;
        DescriptorVisibility r103 = r101.next().getVisibility();
        if (r102 == null) goto L14;
        Integer r104 = DescriptorVisibilities.compare(r103, r102);
        if (r104 == null) goto L9;
        if (r104.intValue() <= 0) goto L11;
    L14:
        r102 = r103;
        goto L11
    L21:
        if (r102 != null) goto L23;
        return null;
    L23:
        Iterator<? extends CallableMemberDescriptor> r105 = r100.iterator();
    L25:
        if (r105.hasNext() == false) goto L31;
        Integer r106 = DescriptorVisibilities.compare(r102, r105.next().getVisibility());
        if (r106 == null) goto L30;
        if (r106.intValue() >= 0) goto L25;
    L30:
        return null;
    L31:
        return r102;
    L7:
        return DescriptorVisibilities.DEFAULT_VISIBILITY;
    }

    public static Set<CallableMemberDescriptor> getOverriddenDeclarations(CallableMemberDescriptor r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(15);
    L4:
        LinkedHashSet r101 = new LinkedHashSet();
        collectOverriddenDeclarations(r100, r101);
        return r101;
    }

    private static OverrideCompatibilityInfo checkReceiverAndParameterCount(CallableDescriptor r100, CallableDescriptor r101) {
        boolean r102 = true;
        if (r100.getExtensionReceiverParameter() != null) goto L5;
        boolean r103 = true;
    L7:
        if (r101.getExtensionReceiverParameter() == null) goto L10;
        r102 = false;
    L10:
        if (r103 == r102) goto L14;
        return OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
    L14:
        if (r100.getValueParameters().size() != r101.getValueParameters().size()) goto L16;
        return null;
    L16:
        return OverrideCompatibilityInfo.incompatible("Value parameter number mismatch");
    L5:
        r103 = false;
        goto L7
    }

    private static void collectOverriddenDeclarations(CallableMemberDescriptor r100, Set<CallableMemberDescriptor> r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(17);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(18);
    L7:
        if (r100.getKind().isReal() == false) goto L10;
        r101.add(r100);
        return;
    L10:
        if (r100.getOverriddenDescriptors().isEmpty() == true) goto L17;
        Iterator<? extends CallableMemberDescriptor> r102 = r100.getOverriddenDescriptors().iterator();
    L13:
        if (r102.hasNext() == false) goto L19;
        collectOverriddenDeclarations(r102.next(), r101);
        goto L13
    L19:
        return;
    L17:
        throw new IllegalStateException("No overridden descriptors found for (fake override) " + r100);
    }

    public static OverridingUtil create(KotlinTypeRefiner r100, KotlinTypeChecker.TypeConstructorEquality r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return new OverridingUtil(r101, r100, KotlinTypePreparator.Default.INSTANCE, null);
    }

    private TypeCheckerState createTypeCheckerState(List<TypeParameterDescriptor> r100, List<TypeParameterDescriptor> r110) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(40);
    L4:
        if (r110 != null) goto L7;
        $$$reportNull$$$0(41);
    L7:
        if (r100.isEmpty() == false) goto L12;
        TypeCheckerState r101 = new OverridingUtilTypeSystemContext(null, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true);
        if (r101 != null) goto L11;
        $$$reportNull$$$0(42);
    L11:
        return r101;
    L12:
        HashMap r102 = new HashMap();
        int r103 = 0;
    L14:
        if (r103 >= r100.size()) goto L16;
        r102.put(((TypeParameterDescriptor) ListProtector.get(r100, r103)).getTypeConstructor(), ((TypeParameterDescriptor) ListProtector.get(r110, r103)).getTypeConstructor());
        r103 = r103 + 1;
        goto L14
    L16:
        TypeCheckerState r104 = new OverridingUtilTypeSystemContext(r102, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true);
        if (r104 != null) goto L19;
        $$$reportNull$$$0(43);
    L19:
        return r104;
    }

    private static Modality determineModalityForFakeOverride(Collection<CallableMemberDescriptor> r100, ClassDescriptor r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(86);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(87);
    L6:
        Iterator<CallableMemberDescriptor> r102 = r100.iterator();
        boolean r103 = false;
        boolean r104 = false;
        boolean r105 = false;
    L8:
        if (r102.hasNext() == false) goto L27;
        CallableMemberDescriptor r106 = r102.next();
        int r107 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$descriptors$Modality[r106.getModality().ordinal()];
        if (r107 == 1) goto L22;
        if (r107 == 2) goto L21;
        if (r107 != 3) goto L16;
        r104 = true;
        goto L8
    L16:
        if (r107 != 4) goto L8;
        r105 = true;
        goto L8
    L21:
        throw new IllegalStateException("Member cannot have SEALED modality: " + r106);
    L22:
        Modality r108 = Modality.FINAL;
        if (r108 != null) goto L25;
        $$$reportNull$$$0(88);
    L25:
        return r108;
    L27:
        if (r101.isExpect() == true) goto L29;
    L33:
        if (r104 == false) goto L39;
        if (r105 == true) goto L39;
        Modality r109 = Modality.OPEN;
        if (r109 != null) goto L38;
        $$$reportNull$$$0(89);
    L38:
        return r109;
    L39:
        if (r104 == true) goto L47;
        if (r105 == false) goto L47;
        if (r103 == false) goto L43;
        Modality r110 = r101.getModality();
    L44:
        if (r110 != null) goto L46;
        $$$reportNull$$$0(90);
    L46:
        return r110;
    L43:
        r110 = Modality.ABSTRACT;
    L47:
        HashSet r111 = new HashSet();
        Iterator<CallableMemberDescriptor> r112 = r100.iterator();
    L49:
        if (r112.hasNext() == false) goto L52;
        r111.addAll(getOverriddenDeclarations(r112.next()));
        goto L49
    L52:
        return getMinimalModality(filterOutOverridden(r111), r103, r101.getModality());
    L29:
        if (r101.getModality() == Modality.ABSTRACT) goto L33;
        if (r101.getModality() == Modality.SEALED) goto L33;
        r103 = true;
        goto L33
    }

    public static Collection<CallableMemberDescriptor> filterVisibleFakeOverrides(final ClassDescriptor r100, Collection<CallableMemberDescriptor> r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(94);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(95);
    L6:
        List r102 = CollectionsKt.filter(r101, new AnonymousClass5(r100));
        if (r102 != null) goto L9;
        $$$reportNull$$$0(96);
    L9:
        return r102;
    }

    public static OverrideCompatibilityInfo getBasicOverridabilityProblem(CallableDescriptor r100, CallableDescriptor r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(38);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(39);
    L6:
        boolean r102 = r100 instanceof FunctionDescriptor;
        if (r102 == true) goto L9;
    L10:
        boolean r103 = r100 instanceof PropertyDescriptor;
        if (r103 == true) goto L13;
    L16:
        if (r102 == true) goto L22;
        if (r103 == true) goto L22;
        throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + r100);
    L22:
        if (r100.getName().equals(r101.getName()) == false) goto L24;
        OverrideCompatibilityInfo r104 = checkReceiverAndParameterCount(r100, r101);
        if (r104 == null) goto L28;
        return r104;
    L28:
        return null;
    L24:
        return OverrideCompatibilityInfo.incompatible("Name mismatch");
    L13:
        if ((r101 instanceof PropertyDescriptor) == true) goto L16;
    L15:
        return OverrideCompatibilityInfo.incompatible("Member kind mismatch");
    L9:
        if ((r101 instanceof FunctionDescriptor) == false) goto L15;
        goto L10
    }

    public static OverrideCompatibilityInfo.Result getBothWaysOverridability(CallableDescriptor r100, CallableDescriptor r101) {
        OverridingUtil r102 = DEFAULT;
        OverrideCompatibilityInfo.Result r103 = r102.isOverridableBy(r101, r100, null).getResult();
        OverrideCompatibilityInfo.Result r104 = r102.isOverridableBy(r100, r101, null).getResult();
        OverrideCompatibilityInfo.Result r105 = OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (r103 != r105) goto L6;
        if (r104 != r105) goto L6;
        return r105;
    L6:
        OverrideCompatibilityInfo.Result r106 = OverrideCompatibilityInfo.Result.CONFLICT;
        if (r103 == r106) goto L12;
        if (r104 != r106) goto L11;
        return r106;
    L11:
        return OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    L12:
        return r106;
    }

    private static boolean isAccessorMoreSpecific(PropertyAccessorDescriptor r100, PropertyAccessorDescriptor r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return true;
    L6:
        return isVisibilityMoreSpecific(r100, r101);
    L7:
        return true;
    }

    public static boolean isMoreSpecific(CallableDescriptor r100, CallableDescriptor r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(65);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(66);
    L6:
        KotlinType r102 = r100.getReturnType();
        KotlinType r103 = r101.getReturnType();
        if (isVisibilityMoreSpecific(r100, r101) == true) goto L9;
        return false;
    L9:
        TypeCheckerState r104 = DEFAULT.createTypeCheckerState(r100.getTypeParameters(), r101.getTypeParameters());
        if ((r100 instanceof FunctionDescriptor) == false) goto L14;
        return isReturnTypeMoreSpecific(r100, r102, r101, r103, r104);
    L14:
        if ((r100 instanceof PropertyDescriptor) == false) goto L33;
        PropertyDescriptor r105 = (PropertyDescriptor) r100;
        PropertyDescriptor r106 = (PropertyDescriptor) r101;
        if (isAccessorMoreSpecific(r105.getSetter(), r106.getSetter()) == true) goto L19;
        return false;
    L19:
        if (r105.isVar() == false) goto L25;
        if (r106.isVar() == false) goto L25;
        return AbstractTypeChecker.INSTANCE.equalTypes(r104, r102.unwrap(), r103.unwrap());
    L25:
        if (r105.isVar() == true) goto L29;
        if (r106.isVar() == false) goto L29;
        return false;
    L29:
        if (isReturnTypeMoreSpecific(r100, r102, r101, r103, r104) == false) goto L35;
        return true;
    L35:
        return false;
    L33:
        throw new IllegalArgumentException("Unexpected callable: " + r100.getClass());
    }

    private static boolean isMoreSpecificThenAllOf(CallableDescriptor r100, Collection<CallableDescriptor> r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(69);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(70);
    L6:
        Iterator<CallableDescriptor> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        if (isMoreSpecific(r100, r102.next()) == true) goto L8;
        return false;
    L13:
        return true;
    }

    private static boolean isVisibilityMoreSpecific(DeclarationDescriptorWithVisibility r100, DeclarationDescriptorWithVisibility r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(67);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(68);
    L6:
        Integer r102 = DescriptorVisibilities.compare(r100.getVisibility(), r101.getVisibility());
        if (r102 != null) goto L9;
    L12:
        return true;
    L9:
        if (r102.intValue() >= 0) goto L12;
        return false;
    }

    public static void resolveUnknownVisibilityForMember(CallableMemberDescriptor r100, Function1<CallableMemberDescriptor, Unit> r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(105);
    L4:
        Iterator<? extends CallableMemberDescriptor> r102 = r100.getOverriddenDescriptors().iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        CallableMemberDescriptor r103 = r102.next();
        if (r103.getVisibility() != DescriptorVisibilities.INHERITED) goto L6;
        resolveUnknownVisibilityForMember(r103, r101);
        goto L6
    L11:
        if (r100.getVisibility() == DescriptorVisibilities.INHERITED) goto L13;
        return;
    L13:
        DescriptorVisibility r104 = computeVisibilityToInherit(r100);
        if (r104 != null) goto L18;
        if (r101 == null) goto L17;
        r101.invoke(r100);
    L17:
        DescriptorVisibility r105 = DescriptorVisibilities.PUBLIC;
    L20:
        if ((r100 instanceof PropertyDescriptorImpl) == false) goto L30;
        ((PropertyDescriptorImpl) r100).setVisibility(r105);
        Iterator<PropertyAccessorDescriptor> r106 = ((PropertyDescriptor) r100).getAccessors().iterator();
    L23:
        if (r106.hasNext() == false) goto L46;
        PropertyAccessorDescriptor r107 = r106.next();
        if (r104 != null) goto L27;
        Function1<CallableMemberDescriptor, Unit> r108 = null;
    L28:
        resolveUnknownVisibilityForMember(r107, r108);
        goto L23
    L27:
        r108 = r101;
        goto L28
    L46:
        return;
    L30:
        if ((r100 instanceof FunctionDescriptorImpl) == false) goto L32;
        ((FunctionDescriptorImpl) r100).setVisibility(r105);
        return;
    L32:
        PropertyAccessorDescriptorImpl r109 = (PropertyAccessorDescriptorImpl) r100;
        r109.setVisibility(r105);
        if (r105 == r109.getCorrespondingProperty().getVisibility()) goto L45;
        r109.setDefault(false);
        return;
    L45:
        return;
    L18:
        r105 = r104;
        goto L20
    }

    public static <H> H selectMostSpecificMember(Collection<H> r100, Function1<H, CallableDescriptor> r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(76);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(77);
    L7:
        if (r100.size() != 1) goto L12;
        H r102 = (H) CollectionsKt.first(r100);
        if (r102 != null) goto L11;
        $$$reportNull$$$0(78);
    L11:
        return r102;
    L12:
        ArrayList r103 = new ArrayList(2);
        List r104 = CollectionsKt.map(r100, r101);
        H r105 = (H) CollectionsKt.first(r100);
        CallableDescriptor r106 = r101.invoke(r105);
        Iterator<H> r107 = r100.iterator();
    L14:
        if (r107.hasNext() == false) goto L24;
        H r108 = r107.next();
        CallableDescriptor r109 = r101.invoke(r108);
        if (isMoreSpecificThenAllOf(r109, r104) == false) goto L19;
        r103.add(r108);
    L19:
        if (isMoreSpecific(r109, r106) == false) goto L14;
        if (isMoreSpecific(r106, r109) == true) goto L14;
        r105 = r108;
        goto L14
    L24:
        if (r103.isEmpty() == false) goto L29;
        if (r105 != null) goto L27;
        $$$reportNull$$$0(79);
    L27:
        return r105;
    L29:
        if (r103.size() != 1) goto L34;
        H r110 = (H) CollectionsKt.first(r103);
        if (r110 != null) goto L33;
        $$$reportNull$$$0(80);
    L33:
        return r110;
    L34:
        Iterator r111 = r103.iterator();
    L36:
        if (r111.hasNext() == false) goto L40;
        H r112 = (H) r111.next();
        if (FlexibleTypesKt.isFlexible(r101.invoke(r112).getReturnType()) == true) goto L36;
    L41:
        if (r112 == null) goto L43;
        return r112;
    L43:
        H r113 = (H) CollectionsKt.first(r103);
        if (r113 != null) goto L46;
        $$$reportNull$$$0(82);
    L46:
        return r113;
    L40:
        r112 = null;
        goto L41
    }

    private static boolean areTypeParametersEquivalent(TypeParameterDescriptor r100, TypeParameterDescriptor r101, TypeCheckerState r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(47);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(48);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(49);
    L8:
        List<KotlinType> r103 = r100.getUpperBounds();
        ArrayList r104 = new ArrayList(r101.getUpperBounds());
        if (r103.size() == r104.size()) goto L11;
        return false;
    L11:
        Iterator<KotlinType> r105 = r103.iterator();
    L13:
        if (r105.hasNext() == false) goto L21;
        KotlinType r106 = r105.next();
        ListIterator r107 = r104.listIterator();
    L16:
        if (r107.hasNext() == false) goto L20;
        if (areTypesEquivalent(r106, (KotlinType) r107.next(), r102) == false) goto L16;
        r107.remove();
        goto L13
    L20:
        return false;
    L21:
        return true;
    }

    private static boolean areTypesEquivalent(KotlinType r100, KotlinType r101, TypeCheckerState r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(44);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(45);
    L6:
        if (r102 != null) goto L9;
        $$$reportNull$$$0(46);
    L9:
        if (KotlinTypeKt.isError(r100) == true) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L17;
        return true;
    L17:
        return AbstractTypeChecker.INSTANCE.equalTypes(r102, r100.unwrap(), r101.unwrap());
    L11:
        if (KotlinTypeKt.isError(r101) == false) goto L13;
        r103 = true;
        goto L14
    }

    private static void createAndBindFakeOverride(Collection<CallableMemberDescriptor> r100, ClassDescriptor r101, OverridingStrategy r110) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(83);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(84);
    L6:
        if (r110 != null) goto L8;
        $$$reportNull$$$0(85);
    L8:
        Collection<CallableMemberDescriptor> r102 = filterVisibleFakeOverrides(r101, r100);
        boolean r103 = r102.isEmpty();
        if (r103 == true) goto L12;
        r100 = r102;
    L12:
        Modality r104 = determineModalityForFakeOverride(r100, r101);
        if (r103 == false) goto L15;
        DescriptorVisibility r105 = DescriptorVisibilities.INVISIBLE_FAKE;
    L16:
        DescriptorVisibility r106 = r105;
        CallableMemberDescriptor r107 = ((CallableMemberDescriptor) selectMostSpecificMember(r100, new AnonymousClass4())).copy(r101, r104, r106, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        r110.setOverriddenDescriptors(r107, r100);
        r110.addFakeOverride(r107);
        return;
    L15:
        r105 = DescriptorVisibilities.INHERITED;
        goto L16
    }

    private static void createAndBindFakeOverrides(ClassDescriptor r100, Collection<CallableMemberDescriptor> r101, OverridingStrategy r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(62);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(63);
    L6:
        if (r102 != null) goto L9;
        $$$reportNull$$$0(64);
    L9:
        if (allHasSameContainingDeclaration(r101) == false) goto L15;
        Iterator<CallableMemberDescriptor> r103 = r101.iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        createAndBindFakeOverride(Collections.singleton(r103.next()), r100, r102);
        goto L12
    L14:
        return;
    L15:
        LinkedList r104 = new LinkedList(r101);
    L17:
        if (r104.isEmpty() == true) goto L19;
        createAndBindFakeOverride(extractMembersOverridableInBothWays(VisibilityUtilKt.findMemberWithMaxVisibility(r104), r104, r102), r100, r102);
        goto L17
    }

    private static Collection<CallableMemberDescriptor> extractMembersOverridableInBothWays(final CallableMemberDescriptor r100, Queue<CallableMemberDescriptor> r101, final OverridingStrategy r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(102);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(103);
    L6:
        if (r102 != null) goto L9;
        $$$reportNull$$$0(104);
    L9:
        return extractMembersOverridableInBothWays(r100, r101, new AnonymousClass6(), new AnonymousClass7(r102, r100));
    }

    private static Modality getMinimalModality(Collection<CallableMemberDescriptor> r100, boolean r101, Modality r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(91);
    L4:
        if (r102 != null) goto L6;
        $$$reportNull$$$0(92);
    L6:
        Modality r103 = Modality.ABSTRACT;
        Iterator<CallableMemberDescriptor> r104 = r100.iterator();
    L8:
        if (r104.hasNext() == false) goto L18;
        CallableMemberDescriptor r105 = r104.next();
        if (r101 == true) goto L12;
    L14:
        Modality r106 = r105.getModality();
    L16:
        if (r106.compareTo(r103) >= 0) goto L8;
        r103 = r106;
        goto L8
    L12:
        if (r105.getModality() != Modality.ABSTRACT) goto L14;
        r106 = r102;
        goto L16
    L18:
        if (r103 != null) goto L20;
        $$$reportNull$$$0(93);
    L20:
        return r103;
    }

    public static boolean isVisibleForOverride(MemberDescriptor r100, MemberDescriptor r101, boolean r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(55);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(56);
    L7:
        if (DescriptorVisibilities.isPrivate(r101.getVisibility()) == false) goto L9;
    L11:
        return false;
    L9:
        if (DescriptorVisibilities.isVisibleIgnoringReceiver(r101, r100, r102) == false) goto L11;
        return true;
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor r100, CallableDescriptor r101, ClassDescriptor r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(20);
    L6:
        OverrideCompatibilityInfo r103 = isOverridableBy(r100, r101, r102, false);
        if (r103 != null) goto L9;
        $$$reportNull$$$0(21);
    L9:
        return r103;
    }

    public OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(CallableDescriptor r110, CallableDescriptor r111, boolean r112) {
        if (r110 != null) goto L4;
        $$$reportNull$$$0(28);
    L4:
        if (r111 != null) goto L6;
        $$$reportNull$$$0(29);
    L6:
        OverrideCompatibilityInfo r100 = getBasicOverridabilityProblem(r110, r111);
        if (r100 == null) goto L9;
        return r100;
    L9:
        List<KotlinType> r101 = compiledValueParameters(r110);
        List<KotlinType> r102 = compiledValueParameters(r111);
        List<TypeParameterDescriptor> r103 = r110.getTypeParameters();
        List<TypeParameterDescriptor> r104 = r111.getTypeParameters();
        int r105 = 0;
        if (r103.size() != r104.size()) goto L12;
        TypeCheckerState r106 = createTypeCheckerState(r103, r104);
        int r107 = 0;
    L26:
        if (r107 >= r103.size()) goto L34;
        if (areTypeParametersEquivalent((TypeParameterDescriptor) ListProtector.get(r103, r107), (TypeParameterDescriptor) ListProtector.get(r104, r107), r106) == false) goto L29;
        r107 = r107 + 1;
        goto L26
    L29:
        OverrideCompatibilityInfo r113 = OverrideCompatibilityInfo.incompatible("Type parameter bounds mismatch");
        if (r113 != null) goto L32;
        $$$reportNull$$$0(33);
    L32:
        return r113;
    L34:
        int r108 = 0;
    L36:
        if (r108 >= r101.size()) goto L45;
        if (areTypesEquivalent((KotlinType) ListProtector.get(r101, r108), (KotlinType) ListProtector.get(r102, r108), r106) == false) goto L39;
        r108 = r108 + 1;
        goto L36
    L39:
        OverrideCompatibilityInfo r114 = OverrideCompatibilityInfo.incompatible("Value parameter type mismatch");
        if (r114 != null) goto L42;
        $$$reportNull$$$0(34);
    L42:
        return r114;
    L45:
        if ((r110 instanceof FunctionDescriptor) == true) goto L47;
    L54:
        if (r112 == false) goto L70;
        KotlinType r115 = r110.getReturnType();
        KotlinType r116 = r111.getReturnType();
        if (r115 == null) goto L70;
        if (r116 == null) goto L70;
        if (KotlinTypeKt.isError(r116) == true) goto L61;
    L63:
        if (r105 != 0) goto L70;
        if (AbstractTypeChecker.INSTANCE.isSubtypeOf(r106, r116.unwrap(), r115.unwrap()) == true) goto L70;
        OverrideCompatibilityInfo r117 = OverrideCompatibilityInfo.conflict("Return type mismatch");
        if (r117 != null) goto L69;
        $$$reportNull$$$0(36);
    L69:
        return r117;
    L61:
        if (KotlinTypeKt.isError(r115) == false) goto L63;
        r105 = 1;
    L70:
        OverrideCompatibilityInfo r118 = OverrideCompatibilityInfo.success();
        if (r118 != null) goto L73;
        $$$reportNull$$$0(37);
    L73:
        return r118;
    L47:
        if ((r111 instanceof FunctionDescriptor) == false) goto L54;
        if (((FunctionDescriptor) r110).isSuspend() == ((FunctionDescriptor) r111).isSuspend()) goto L54;
        OverrideCompatibilityInfo r119 = OverrideCompatibilityInfo.conflict("Incompatible suspendability");
        if (r119 != null) goto L53;
        $$$reportNull$$$0(35);
    L53:
        return r119;
    L12:
        if (r105 >= r101.size()) goto L20;
        if (KotlinTypeChecker.DEFAULT.equalTypes((KotlinType) ListProtector.get(r101, r105), (KotlinType) ListProtector.get(r102, r105)) == false) goto L15;
        r105 = r105 + 1;
        goto L12
    L15:
        OverrideCompatibilityInfo r120 = OverrideCompatibilityInfo.incompatible("Type parameter number mismatch");
        if (r120 != null) goto L18;
        $$$reportNull$$$0(31);
    L18:
        return r120;
    L20:
        OverrideCompatibilityInfo r121 = OverrideCompatibilityInfo.conflict("Type parameter number mismatch");
        if (r121 != null) goto L23;
        $$$reportNull$$$0(32);
    L23:
        return r121;
    }

    private OverridingUtil(KotlinTypeChecker.TypeConstructorEquality r100, KotlinTypeRefiner r101, KotlinTypePreparator r102, Function2<KotlinType, KotlinType, Boolean> r103) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(6);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(7);
    L8:
        this.equalityAxioms = r100;
        this.kotlinTypeRefiner = r101;
        this.kotlinTypePreparator = r102;
        this.customSubtype = r103;
    }

    private Collection<CallableMemberDescriptor> extractAndBindOverridesForMember(CallableMemberDescriptor r100, Collection<? extends CallableMemberDescriptor> r101, ClassDescriptor r102, OverridingStrategy r110) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(57);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(58);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(59);
    L8:
        if (r110 != null) goto L10;
        $$$reportNull$$$0(60);
    L10:
        ArrayList r103 = new ArrayList(r101.size());
        SmartSet r104 = SmartSet.create();
        Iterator<? extends CallableMemberDescriptor> r105 = r101.iterator();
    L12:
        if (r105.hasNext() == false) goto L24;
        CallableMemberDescriptor r106 = r105.next();
        OverrideCompatibilityInfo.Result r107 = isOverridableBy(r106, r100, r102).getResult();
        boolean r108 = isVisibleForOverride(r100, r106, false);
        int r109 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[r107.ordinal()];
        if (r109 != 1) goto L16;
        if (r108 == false) goto L23;
        r104.add(r106);
    L23:
        r103.add(r106);
        goto L12
    L16:
        if (r109 != 2) goto L12;
        if (r108 == false) goto L20;
        r110.overrideConflict(r106, r100);
    L20:
        r103.add(r106);
        goto L12
    L24:
        r110.setOverriddenDescriptors(r100, r104);
        return r103;
    }

    public static <H> Collection<H> extractMembersOverridableInBothWays(H r100, Collection<H> r101, Function1<H, CallableDescriptor> r102, Function1<H, Unit> r103) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(97);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(98);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(99);
    L8:
        if (r103 != null) goto L10;
        $$$reportNull$$$0(100);
    L10:
        ArrayList r104 = new ArrayList();
        r104.add(r100);
        CallableDescriptor r105 = r102.invoke(r100);
        Iterator<H> r106 = r101.iterator();
    L12:
        if (r106.hasNext() == false) goto L22;
        H r107 = r106.next();
        CallableDescriptor r108 = r102.invoke(r107);
        if (r100 == r107) goto L15;
        OverrideCompatibilityInfo.Result r109 = getBothWaysOverridability(r105, r108);
        if (r109 == OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L18;
        if (r109 != OverrideCompatibilityInfo.Result.CONFLICT) goto L12;
        r103.invoke(r107);
        r106.remove();
        goto L12
    L18:
        r104.add(r107);
        r106.remove();
        goto L12
    L15:
        r106.remove();
        goto L12
    L22:
        return r104;
    }

    public static <D> Set<D> filterOverrides(Set<D> r100, boolean r101, Function0<?> r102, Function2<? super D, ? super D, Pair<CallableDescriptor, CallableDescriptor>> r110) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        if (r110 != null) goto L7;
        $$$reportNull$$$0(10);
    L7:
        if (r100.size() > 1) goto L9;
        return r100;
    L9:
        LinkedHashSet r103 = new LinkedHashSet();
        Iterator<D> r104 = r100.iterator();
    L11:
        if (r104.hasNext() == false) goto L25;
        Object r105 = r104.next();
        if (r102 == null) goto L15;
        r102.invoke();
    L15:
        Iterator r106 = r103.iterator();
    L17:
        if (r106.hasNext() == false) goto L24;
        Pair<CallableDescriptor, CallableDescriptor> r107 = r110.invoke(r105, (Object) r106.next());
        CallableDescriptor r108 = r107.component1();
        CallableDescriptor r109 = r107.component2();
        if (overrides(r108, r109, r101, true) == true) goto L20;
        if (overrides(r109, r108, r101, true) == false) goto L17;
    L20:
        r106.remove();
        goto L17
    L24:
        r103.add(r105);
        goto L11
    L25:
        return r103;
    }

    public static <D extends CallableDescriptor> boolean overrides(D r100, D r101, boolean r102, boolean r103) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(14);
    L7:
        if (r100.equals(r101) == false) goto L9;
    L11:
        CallableDescriptor r104 = r101.getOriginal();
        Iterator r105 = DescriptorUtils.getAllOverriddenDescriptors(r100).iterator();
    L13:
        if (r105.hasNext() == false) goto L17;
        CallableDescriptor r106 = (CallableDescriptor) r105.next();
        if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(r104, r106, r102, r103) == false) goto L13;
        return true;
    L17:
        return false;
    L9:
        if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(r100.getOriginal(), r101.getOriginal(), r102, r103) == false) goto L11;
        return true;
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor r100, CallableDescriptor r110, ClassDescriptor r111, boolean r112) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(22);
    L4:
        if (r110 != null) goto L6;
        $$$reportNull$$$0(23);
    L6:
        OverrideCompatibilityInfo r113 = isOverridableByWithoutExternalConditions(r100, r110, r112);
        if (r113.getResult() != OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L9;
        boolean r101 = true;
    L10:
        Iterator<ExternalOverridabilityCondition> r102 = EXTERNAL_CONDITIONS.iterator();
    L12:
        if (r102.hasNext() == false) goto L29;
        ExternalOverridabilityCondition r103 = r102.next();
        if (r103.getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) goto L12;
        if (r101 == false) goto L20;
        if (r103.getContract() == ExternalOverridabilityCondition.Contract.SUCCESS_ONLY) goto L12;
    L20:
        int r104 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[r103.isOverridable(r100, r110, r111).ordinal()];
        if (r104 != 1) goto L22;
        r101 = true;
        goto L12
    L22:
        if (r104 != 2) goto L12;
        OverrideCompatibilityInfo r105 = OverrideCompatibilityInfo.incompatible("External condition");
        if (r105 != null) goto L27;
        $$$reportNull$$$0(24);
    L27:
        return r105;
    L29:
        if (r101 == true) goto L31;
        return r113;
    L31:
        Iterator<ExternalOverridabilityCondition> r114 = EXTERNAL_CONDITIONS.iterator();
    L33:
        if (r114.hasNext() == false) goto L47;
        ExternalOverridabilityCondition r106 = r114.next();
        if (r106.getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) goto L33;
        int r107 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[r106.isOverridable(r100, r110, r111).ordinal()];
        if (r107 == 1) goto L46;
        if (r107 != 2) goto L33;
        OverrideCompatibilityInfo r108 = OverrideCompatibilityInfo.incompatible("External condition");
        if (r108 != null) goto L44;
        $$$reportNull$$$0(26);
    L44:
        return r108;
    L46:
        throw new IllegalStateException("Contract violation in " + r106.getClass().getName() + " condition. It's not supposed to end with success");
    L47:
        OverrideCompatibilityInfo r109 = OverrideCompatibilityInfo.success();
        if (r109 != null) goto L50;
        $$$reportNull$$$0(27);
    L50:
        return r109;
    L9:
        r101 = false;
        goto L10
    }

    private static boolean isReturnTypeMoreSpecific(CallableDescriptor r100, KotlinType r101, CallableDescriptor r102, KotlinType r103, TypeCheckerState r104) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(71);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(72);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(73);
    L8:
        if (r103 != null) goto L10;
        $$$reportNull$$$0(74);
    L10:
        if (r104 != null) goto L13;
        $$$reportNull$$$0(75);
    L13:
        return AbstractTypeChecker.INSTANCE.isSubtypeOf(r104, r101.unwrap(), r103.unwrap());
    }

    public void generateOverridesInFunctionGroup(Name r100, Collection<? extends CallableMemberDescriptor> r101, Collection<? extends CallableMemberDescriptor> r102, ClassDescriptor r103, OverridingStrategy r104) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(50);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(51);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(52);
    L8:
        if (r103 != null) goto L10;
        $$$reportNull$$$0(53);
    L10:
        if (r104 != null) goto L12;
        $$$reportNull$$$0(54);
    L12:
        LinkedHashSet r105 = new LinkedHashSet(r101);
        Iterator<? extends CallableMemberDescriptor> r106 = r102.iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        r105.removeAll(extractAndBindOverridesForMember(r106.next(), r101, r103, r104));
        goto L14
    L16:
        createAndBindFakeOverrides(r103, r105, r104);
    }
}
