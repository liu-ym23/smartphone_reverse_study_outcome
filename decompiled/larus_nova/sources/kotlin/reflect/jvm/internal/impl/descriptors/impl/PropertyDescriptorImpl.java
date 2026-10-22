package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: classes5.dex */
public class PropertyDescriptorImpl extends VariableDescriptorWithInitializerImpl implements PropertyDescriptor {
    private FieldDescriptor backingField;
    private List<ReceiverParameterDescriptor> contextReceiverParameters;
    private FieldDescriptor delegateField;
    private ReceiverParameterDescriptor dispatchReceiverParameter;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private PropertyGetterDescriptorImpl getter;
    private final boolean isActual;
    private final boolean isConst;
    private final boolean isDelegated;
    private final boolean isExpect;
    private final boolean isExternal;
    private final CallableMemberDescriptor.Kind kind;
    private final boolean lateInit;
    private final Modality modality;
    private final PropertyDescriptor original;
    private Collection<? extends PropertyDescriptor> overriddenProperties;
    private PropertySetterDescriptor setter;
    private boolean setterProjectedOut;
    private List<TypeParameterDescriptor> typeParameters;
    private DescriptorVisibility visibility;

    /* JADX INFO: loaded from: classes42.dex */
    public class CopyConfiguration {
        private boolean copyOverrides;
        private ReceiverParameterDescriptor dispatchReceiverParameter;
        private CallableMemberDescriptor.Kind kind;
        private Modality modality;
        private Name name;
        private List<TypeParameterDescriptor> newTypeParameters;
        private PropertyDescriptor original;
        private DeclarationDescriptor owner;
        private boolean preserveSourceElement;
        private KotlinType returnType;
        private TypeSubstitution substitution;
        final /* synthetic */ PropertyDescriptorImpl this$0;
        private DescriptorVisibility visibility;

        private static /* synthetic */ void $$$reportNull$$$0(int r210) {
            if (r210 == 1) goto L16;
            if (r210 == 2) goto L16;
            if (r210 == 3) goto L16;
            if (r210 == 5) goto L16;
            if (r210 == 7) goto L16;
            if (r210 == 9) goto L16;
            if (r210 == 11) goto L16;
            if (r210 == 19) goto L16;
            if (r210 == 13) goto L16;
            if (r210 == 14) goto L16;
            if (r210 == 16) goto L16;
            if (r210 == 17) goto L16;
            String r110 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L17:
            if (r210 == 1) goto L30;
            if (r210 == 2) goto L30;
            if (r210 == 3) goto L30;
            if (r210 == 5) goto L30;
            if (r210 == 7) goto L30;
            if (r210 == 9) goto L30;
            if (r210 == 11) goto L30;
            if (r210 == 19) goto L30;
            if (r210 == 13) goto L30;
            if (r210 == 14) goto L30;
            if (r210 == 16) goto L30;
            if (r210 == 17) goto L30;
            int r111 = 3;
        L31:
            Object[] r112 = new Object[r111];
            switch(r210) {
                case 1: goto L41;
                case 2: goto L41;
                case 3: goto L41;
                case 4: goto L40;
                case 5: goto L41;
                case 6: goto L39;
                case 7: goto L41;
                case 8: goto L38;
                case 9: goto L41;
                case 10: goto L37;
                case 11: goto L41;
                case 12: goto L36;
                case 13: goto L41;
                case 14: goto L41;
                case 15: goto L35;
                case 16: goto L41;
                case 17: goto L41;
                case 18: goto L34;
                case 19: goto L41;
                default: goto L33;
            };
        L33:
            r112[0] = "owner";
        L43:
            if (r210 == 1) goto L67;
            if (r210 == 2) goto L66;
            if (r210 == 3) goto L65;
            if (r210 == 5) goto L64;
            if (r210 == 7) goto L63;
            if (r210 == 9) goto L62;
            if (r210 == 11) goto L61;
            if (r210 == 19) goto L60;
            if (r210 == 13) goto L59;
            if (r210 == 14) goto L58;
            if (r210 == 16) goto L57;
            if (r210 == 17) goto L56;
            r112[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
        L68:
            switch(r210) {
                case 1: goto L77;
                case 2: goto L77;
                case 3: goto L77;
                case 4: goto L76;
                case 5: goto L77;
                case 6: goto L75;
                case 7: goto L77;
                case 8: goto L74;
                case 9: goto L77;
                case 10: goto L73;
                case 11: goto L77;
                case 12: goto L72;
                case 13: goto L77;
                case 14: goto L77;
                case 15: goto L71;
                case 16: goto L77;
                case 17: goto L77;
                case 18: goto L70;
                case 19: goto L77;
                default: goto L69;
            };
        L69:
            r112[2] = "setOwner";
            goto L77
        L70:
            r112[2] = "setName";
            goto L77
        L71:
            r112[2] = "setSubstitution";
            goto L77
        L72:
            r112[2] = "setTypeParameters";
            goto L77
        L73:
            r112[2] = "setKind";
            goto L77
        L74:
            r112[2] = "setVisibility";
            goto L77
        L75:
            r112[2] = "setModality";
            goto L77
        L76:
            r112[2] = "setReturnType";
        L77:
            String r113 = String.format(r110, r112);
            if (r210 == 1) goto L92;
            if (r210 == 2) goto L92;
            if (r210 == 3) goto L92;
            if (r210 == 5) goto L92;
            if (r210 == 7) goto L92;
            if (r210 == 9) goto L92;
            if (r210 == 11) goto L92;
            if (r210 == 19) goto L92;
            if (r210 == 13) goto L92;
            if (r210 == 14) goto L92;
            if (r210 == 16) goto L92;
            if (r210 == 17) goto L92;
            throw new IllegalArgumentException(r113);
        L92:
            throw new IllegalStateException(r113);
        L56:
            r112[1] = "setCopyOverrides";
            goto L68
        L57:
            r112[1] = "setSubstitution";
            goto L68
        L58:
            r112[1] = "setDispatchReceiverParameter";
            goto L68
        L59:
            r112[1] = "setTypeParameters";
            goto L68
        L60:
            r112[1] = "setName";
            goto L68
        L61:
            r112[1] = "setKind";
            goto L68
        L62:
            r112[1] = "setVisibility";
            goto L68
        L63:
            r112[1] = "setModality";
            goto L68
        L64:
            r112[1] = "setReturnType";
            goto L68
        L65:
            r112[1] = "setPreserveSourceElement";
            goto L68
        L66:
            r112[1] = "setOriginal";
            goto L68
        L67:
            r112[1] = "setOwner";
            goto L68
        L34:
            r112[0] = "name";
            goto L43
        L35:
            r112[0] = "substitution";
            goto L43
        L36:
            r112[0] = "typeParameters";
            goto L43
        L37:
            r112[0] = "kind";
            goto L43
        L38:
            r112[0] = RemoteMessageConst.Notification.VISIBILITY;
            goto L43
        L39:
            r112[0] = "modality";
            goto L43
        L40:
            r112[0] = "type";
            goto L43
        L41:
            r112[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
        L30:
            r111 = 2;
        L16:
            r110 = "@NotNull method %s.%s must not return null";
            goto L17
        }

        public PropertyDescriptor build() {
            return this.this$0.doSubstitute(this);
        }

        public PropertyGetterDescriptor getOriginalGetter() {
            PropertyDescriptor r100 = this.original;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getGetter();
        }

        public PropertySetterDescriptor getOriginalSetter() {
            PropertyDescriptor r100 = this.original;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getSetter();
        }

        public CopyConfiguration(PropertyDescriptorImpl r100) {
            this.this$0 = r100;
            this.owner = r100.getContainingDeclaration();
            this.modality = r100.getModality();
            this.visibility = r100.getVisibility();
            this.original = null;
            this.preserveSourceElement = false;
            this.kind = r100.getKind();
            this.substitution = TypeSubstitution.EMPTY;
            this.copyOverrides = true;
            this.dispatchReceiverParameter = PropertyDescriptorImpl.access$000(r100);
            this.newTypeParameters = null;
            this.name = r100.getName();
            this.returnType = r100.getType();
        }

        public static /* synthetic */ DeclarationDescriptor access$100(CopyConfiguration r100) {
            return r100.owner;
        }

        public static /* synthetic */ KotlinType access$1000(CopyConfiguration r100) {
            return r100.returnType;
        }

        public static /* synthetic */ ReceiverParameterDescriptor access$1100(CopyConfiguration r100) {
            return r100.dispatchReceiverParameter;
        }

        public static /* synthetic */ boolean access$1200(CopyConfiguration r100) {
            return r100.copyOverrides;
        }

        public static /* synthetic */ Modality access$200(CopyConfiguration r100) {
            return r100.modality;
        }

        public static /* synthetic */ DescriptorVisibility access$300(CopyConfiguration r100) {
            return r100.visibility;
        }

        public static /* synthetic */ PropertyDescriptor access$400(CopyConfiguration r100) {
            return r100.original;
        }

        public static /* synthetic */ CallableMemberDescriptor.Kind access$500(CopyConfiguration r100) {
            return r100.kind;
        }

        public static /* synthetic */ Name access$600(CopyConfiguration r100) {
            return r100.name;
        }

        public static /* synthetic */ boolean access$700(CopyConfiguration r100) {
            return r100.preserveSourceElement;
        }

        public static /* synthetic */ List access$800(CopyConfiguration r100) {
            return r100.newTypeParameters;
        }

        public static /* synthetic */ TypeSubstitution access$900(CopyConfiguration r100) {
            return r100.substitution;
        }

        public CopyConfiguration setCopyOverrides(boolean r100) {
            this.copyOverrides = r100;
            return this;
        }

        public CopyConfiguration setKind(CallableMemberDescriptor.Kind r100) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(10);
        L4:
            this.kind = r100;
            return this;
        }

        public CopyConfiguration setModality(Modality r100) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(6);
        L4:
            this.modality = r100;
            return this;
        }

        public CopyConfiguration setOriginal(CallableMemberDescriptor r100) {
            this.original = (PropertyDescriptor) r100;
            return this;
        }

        public CopyConfiguration setOwner(DeclarationDescriptor r100) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.owner = r100;
            return this;
        }

        public CopyConfiguration setSubstitution(TypeSubstitution r100) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(15);
        L4:
            this.substitution = r100;
            return this;
        }

        public CopyConfiguration setVisibility(DescriptorVisibility r100) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(8);
        L4:
            this.visibility = r100;
            return this;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r110) {
        if (r110 == 28) goto L10;
        if (r110 == 38) goto L10;
        if (r110 == 39) goto L10;
        if (r110 == 41) goto L10;
        if (r110 == 42) goto L10;
        switch(r110) {
            case 21: goto L10;
            case 22: goto L10;
            case 23: goto L10;
            case 24: goto L10;
            case 25: goto L10;
            case 26: goto L10;
            default: goto L9;
        };
    L9:
        String r100 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L12:
        if (r110 == 28) goto L19;
        if (r110 == 38) goto L19;
        if (r110 == 39) goto L19;
        if (r110 == 41) goto L19;
        if (r110 == 42) goto L19;
        switch(r110) {
            case 21: goto L19;
            case 22: goto L19;
            case 23: goto L19;
            case 24: goto L19;
            case 25: goto L19;
            case 26: goto L19;
            default: goto L18;
        };
    L18:
        int r101 = 3;
    L20:
        Object[] r102 = new Object[r101];
        switch(r110) {
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L22;
            case 8: goto L42;
            case 9: goto L41;
            case 10: goto L40;
            case 11: goto L39;
            case 12: goto L38;
            case 13: goto L37;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L34;
            case 17: goto L35;
            case 18: goto L34;
            case 19: goto L33;
            case 20: goto L40;
            case 21: goto L32;
            case 22: goto L32;
            case 23: goto L32;
            case 24: goto L32;
            case 25: goto L32;
            case 26: goto L32;
            case 27: goto L31;
            case 28: goto L32;
            case 29: goto L30;
            case 30: goto L29;
            case 31: goto L28;
            case 32: goto L27;
            case 33: goto L26;
            case 34: goto L25;
            case 35: goto L38;
            case 36: goto L24;
            case 37: goto L37;
            case 38: goto L32;
            case 39: goto L32;
            case 40: goto L23;
            case 41: goto L32;
            case 42: goto L32;
            default: goto L22;
        };
    L22:
        r102[0] = "containingDeclaration";
    L44:
        if (r110 == 28) goto L61;
        if (r110 == 38) goto L60;
        if (r110 == 39) goto L59;
        if (r110 == 41) goto L58;
        if (r110 == 42) goto L57;
        switch(r110) {
            case 21: goto L56;
            case 22: goto L55;
            case 23: goto L54;
            case 24: goto L53;
            case 25: goto L52;
            case 26: goto L51;
            default: goto L50;
        };
    L50:
        r102[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
    L62:
        switch(r110) {
            case 7: goto L72;
            case 8: goto L72;
            case 9: goto L72;
            case 10: goto L72;
            case 11: goto L72;
            case 12: goto L72;
            case 13: goto L72;
            case 14: goto L71;
            case 15: goto L70;
            case 16: goto L70;
            case 17: goto L70;
            case 18: goto L70;
            case 19: goto L70;
            case 20: goto L69;
            case 21: goto L73;
            case 22: goto L73;
            case 23: goto L73;
            case 24: goto L73;
            case 25: goto L73;
            case 26: goto L73;
            case 27: goto L68;
            case 28: goto L73;
            case 29: goto L67;
            case 30: goto L66;
            case 31: goto L66;
            case 32: goto L65;
            case 33: goto L65;
            case 34: goto L65;
            case 35: goto L65;
            case 36: goto L65;
            case 37: goto L65;
            case 38: goto L73;
            case 39: goto L73;
            case 40: goto L64;
            case 41: goto L73;
            case 42: goto L73;
            default: goto L63;
        };
    L63:
        r102[2] = "<init>";
        goto L73
    L64:
        r102[2] = "setOverriddenDescriptors";
        goto L73
    L65:
        r102[2] = "createSubstitutedCopy";
        goto L73
    L66:
        r102[2] = "getSubstitutedInitialSignatureDescriptor";
        goto L73
    L67:
        r102[2] = "doSubstitute";
        goto L73
    L68:
        r102[2] = "substitute";
        goto L73
    L69:
        r102[2] = "setVisibility";
        goto L73
    L70:
        r102[2] = "setType";
        goto L73
    L71:
        r102[2] = "setInType";
        goto L73
    L72:
        r102[2] = "create";
    L73:
        String r103 = String.format(r100, r102);
        if (r110 == 28) goto L82;
        if (r110 == 38) goto L82;
        if (r110 == 39) goto L82;
        if (r110 == 41) goto L82;
        if (r110 == 42) goto L82;
        switch(r110) {
            case 21: goto L82;
            case 22: goto L82;
            case 23: goto L82;
            case 24: goto L82;
            case 25: goto L82;
            case 26: goto L82;
            default: goto L83;
        };
    L83:
        throw new IllegalArgumentException(r103);
    L82:
        throw new IllegalStateException(r103);
    L51:
        r102[1] = "getAccessors";
        goto L62
    L52:
        r102[1] = "getVisibility";
        goto L62
    L53:
        r102[1] = "getModality";
        goto L62
    L54:
        r102[1] = "getReturnType";
        goto L62
    L55:
        r102[1] = "getContextReceiverParameters";
        goto L62
    L56:
        r102[1] = "getTypeParameters";
        goto L62
    L57:
        r102[1] = "copy";
        goto L62
    L58:
        r102[1] = "getOverriddenDescriptors";
        goto L62
    L59:
        r102[1] = "getKind";
        goto L62
    L60:
        r102[1] = "getOriginal";
        goto L62
    L61:
        r102[1] = "getSourceToUseForCopy";
        goto L62
    L23:
        r102[0] = "overriddenDescriptors";
        goto L44
    L24:
        r102[0] = "newName";
        goto L44
    L25:
        r102[0] = "newVisibility";
        goto L44
    L26:
        r102[0] = "newModality";
        goto L44
    L27:
        r102[0] = "newOwner";
        goto L44
    L28:
        r102[0] = "accessorDescriptor";
        goto L44
    L29:
        r102[0] = "substitutor";
        goto L44
    L30:
        r102[0] = "copyConfiguration";
        goto L44
    L31:
        r102[0] = "originalSubstitutor";
        goto L44
    L32:
        r102[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
        goto L44
    L33:
        r102[0] = "contextReceiverParameters";
        goto L44
    L34:
        r102[0] = "typeParameters";
        goto L44
    L35:
        r102[0] = "outType";
        goto L44
    L36:
        r102[0] = "inType";
        goto L44
    L37:
        r102[0] = "source";
        goto L44
    L38:
        r102[0] = "kind";
        goto L44
    L39:
        r102[0] = "name";
        goto L44
    L40:
        r102[0] = RemoteMessageConst.Notification.VISIBILITY;
        goto L44
    L41:
        r102[0] = "modality";
        goto L44
    L42:
        r102[0] = "annotations";
    L19:
        r101 = 2;
    L10:
        r100 = "@NotNull method %s.%s must not return null";
        goto L12
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r100) {
        return null;
    }

    public void setInType(KotlinType r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(14);
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList r100 = new ArrayList(2);
        PropertyGetterDescriptorImpl r101 = this.getter;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        PropertySetterDescriptor r102 = this.setter;
        if (r102 == null) goto L8;
        r100.add(r102);
    L8:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> r100 = this.contextReceiverParameters;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(22);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind r100 = this.kind;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(39);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality r100 = this.modality;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(24);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor r100 = this.original;
        if (r100 != this) goto L5;
        PropertyDescriptor r101 = this;
    L6:
        if (r101 != null) goto L8;
        $$$reportNull$$$0(38);
    L8:
        return r101;
    L5:
        r101 = r100.getOriginal();
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> r100 = this.overriddenProperties;
        if (r100 != null) goto L6;
        r100 = Collections.emptyList();
    L6:
        if (r100 != null) goto L8;
        $$$reportNull$$$0(41);
    L8:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> r100 = this.typeParameters;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r100 = this.visibility;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(25);
    L5:
        return r100;
    }

    public CopyConfiguration newCopyBuilder() {
        return new CopyConfiguration(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public /* bridge */ /* synthetic */ PropertyGetterDescriptor getGetter() {
        return getGetter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType r100 = getType();
        if (r100 != null) goto L5;
        $$$reportNull$$$0(23);
    L5:
        return r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public FieldDescriptor getBackingField() {
        return this.backingField;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public FieldDescriptor getDelegateField() {
        return this.delegateField;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public PropertySetterDescriptor getSetter() {
        return this.setter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.isActual;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        return this.isConst;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors
    public boolean isDelegated() {
        return this.isDelegated;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.isExpect;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.isExternal;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return this.lateInit;
    }

    public boolean isSetterProjectedOut() {
        return this.setterProjectedOut;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public PropertyGetterDescriptorImpl getGetter() {
        return this.getter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ VariableDescriptor getOriginal() {
        return getOriginal();
    }

    public static /* synthetic */ ReceiverParameterDescriptor access$000(PropertyDescriptorImpl r100) {
        return r100.dispatchReceiverParameter;
    }

    public PropertyDescriptor doSubstitute(CopyConfiguration r210) {
        if (r210 != null) goto L5;
        $$$reportNull$$$0(29);
    L5:
        PropertyDescriptorImpl r100 = createSubstitutedCopy(CopyConfiguration.access$100(r210), CopyConfiguration.access$200(r210), CopyConfiguration.access$300(r210), CopyConfiguration.access$400(r210), CopyConfiguration.access$500(r210), CopyConfiguration.access$600(r210), getSourceToUseForCopy(CopyConfiguration.access$700(r210), CopyConfiguration.access$400(r210)));
        if (CopyConfiguration.access$800(r210) != null) goto L8;
        List<TypeParameterDescriptor> r101 = getTypeParameters();
    L9:
        ArrayList r110 = new ArrayList(r101.size());
        TypeSubstitutor r102 = DescriptorSubstitutor.substituteTypeParameters(r101, CopyConfiguration.access$900(r210), r100, r110);
        KotlinType r103 = CopyConfiguration.access$1000(r210);
        KotlinType r111 = r102.substitute(r103, Variance.OUT_VARIANCE);
        FieldDescriptorImpl r104 = null;
        if (r111 != null) goto L12;
        return null;
    L12:
        KotlinType r105 = r102.substitute(r103, Variance.IN_VARIANCE);
        if (r105 == null) goto L15;
        r100.setInType(r105);
    L15:
        ReceiverParameterDescriptor r106 = CopyConfiguration.access$1100(r210);
        if (r106 == null) goto L21;
        ReceiverParameterDescriptor r107 = r106.substitute(r102);
        if (r107 != null) goto L20;
        return null;
    L20:
        ReceiverParameterDescriptor r112 = r107;
    L22:
        ReceiverParameterDescriptor r108 = this.extensionReceiverParameter;
        if (r108 == null) goto L25;
        ReceiverParameterDescriptor r113 = substituteParameterDescriptor(r102, r100, r108);
    L26:
        ArrayList r114 = new ArrayList();
        Iterator<ReceiverParameterDescriptor> r109 = this.contextReceiverParameters.iterator();
    L28:
        if (r109.hasNext() == false) goto L32;
        ReceiverParameterDescriptor r115 = substituteContextParameterDescriptor(r102, r100, r109.next());
        if (r115 == null) goto L28;
        r114.add(r115);
        goto L28
    L32:
        r100.setType(r111, r110, r112, r113, r114);
        if (this.getter != null) goto L35;
        PropertyGetterDescriptorImpl r116 = null;
    L36:
        if (r116 == null) goto L43;
        KotlinType r117 = this.getter.getReturnType();
        r116.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(r102, this.getter));
        if (r117 == null) goto L40;
        KotlinType r118 = r102.substitute(r117, Variance.OUT_VARIANCE);
    L41:
        r116.initialize(r118);
        goto L43
    L40:
        r118 = null;
    L43:
        if (this.setter != null) goto L45;
        PropertySetterDescriptorImpl r119 = null;
    L46:
        if (r119 == null) goto L55;
        List<ValueParameterDescriptor> r120 = FunctionDescriptorImpl.getSubstitutedValueParameters(r119, this.setter.getValueParameters(), r102, false, false, null);
        if (r120 != null) goto L51;
        r100.setSetterProjectedOut(true);
        r120 = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter(r119, DescriptorUtilsKt.getBuiltIns(CopyConfiguration.access$100(r210)).getNothingType(), ((ValueParameterDescriptor) ListProtector.get(this.setter.getValueParameters(), 0)).getAnnotations()));
    L51:
        if (r120.size() != 1) goto L54;
        r119.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(r102, this.setter));
        r119.initialize((ValueParameterDescriptor) ListProtector.get(r120, 0));
        goto L55
    L54:
        throw new IllegalStateException();
    L55:
        FieldDescriptor r121 = this.backingField;
        if (r121 != null) goto L58;
        FieldDescriptorImpl r122 = null;
    L59:
        FieldDescriptor r123 = this.delegateField;
        if (r123 == null) goto L63;
        r104 = new FieldDescriptorImpl(r123.getAnnotations(), r100);
    L63:
        r100.initialize(r116, r119, r122, r104);
        if (CopyConfiguration.access$1200(r210) == false) goto L71;
        SmartSet r124 = SmartSet.create();
        Iterator<? extends PropertyDescriptor> r125 = getOverriddenDescriptors().iterator();
    L67:
        if (r125.hasNext() == false) goto L69;
        r124.add(r125.next().substitute(r102));
        goto L67
    L69:
        r100.setOverriddenDescriptors(r124);
    L71:
        if (isConst() == false) goto L75;
        Function0<NullableLazyValue<ConstantValue<?>>> r126 = this.compileTimeInitializerFactory;
        if (r126 == null) goto L75;
        r100.setCompileTimeInitializer(this.compileTimeInitializer, r126);
    L75:
        return r100;
    L58:
        r122 = new FieldDescriptorImpl(r121.getAnnotations(), r100);
        goto L59
    L45:
        r119 = new PropertySetterDescriptorImpl(r100, this.setter.getAnnotations(), CopyConfiguration.access$200(r210), normalizeVisibility(this.setter.getVisibility(), CopyConfiguration.access$500(r210)), this.setter.isDefault(), this.setter.isExternal(), this.setter.isInline(), CopyConfiguration.access$500(r210), r210.getOriginalSetter(), SourceElement.NO_SOURCE);
        goto L46
    L35:
        r116 = new PropertyGetterDescriptorImpl(r100, this.getter.getAnnotations(), CopyConfiguration.access$200(r210), normalizeVisibility(this.getter.getVisibility(), CopyConfiguration.access$500(r210)), this.getter.isDefault(), this.getter.isExternal(), this.getter.isInline(), CopyConfiguration.access$500(r210), r210.getOriginalGetter(), SourceElement.NO_SOURCE);
        goto L36
    L25:
        r113 = null;
        goto L26
    L21:
        r112 = null;
        goto L22
    L8:
        r101 = CopyConfiguration.access$800(r210);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r100) {
        if (r100 != 0) goto L4;
        $$$reportNull$$$0(40);
    L4:
        this.overriddenProperties = r100;
    }

    public void setSetterProjectedOut(boolean r100) {
        this.setterProjectedOut = r100;
    }

    public void setVisibility(DescriptorVisibility r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(20);
    L4:
        this.visibility = r100;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public PropertyDescriptor substitute(TypeSubstitutor r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(27);
    L5:
        if (r100.isEmpty() == false) goto L8;
        return this;
    L8:
        return newCopyBuilder().setSubstitution(r100.getSubstitution()).setOriginal(getOriginal()).build();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r100) {
        return substitute(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ VariableDescriptor substitute(TypeSubstitutor r100) {
        return substitute(r100);
    }

    private SourceElement getSourceToUseForCopy(boolean r100, PropertyDescriptor r101) {
        if (r100 == false) goto L7;
        if (r101 != null) goto L6;
        r101 = getOriginal();
    L6:
        SourceElement r102 = r101.getSource();
    L8:
        if (r102 != null) goto L10;
        $$$reportNull$$$0(28);
    L10:
        return r102;
    L7:
        r102 = SourceElement.NO_SOURCE;
        goto L8
    }

    private static FunctionDescriptor getSubstitutedInitialSignatureDescriptor(TypeSubstitutor r100, PropertyAccessorDescriptor r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(30);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(31);
    L7:
        if (r101.getInitialSignatureDescriptor() != null) goto L11;
        return null;
    L11:
        return r101.getInitialSignatureDescriptor().substitute(r100);
    }

    private static DescriptorVisibility normalizeVisibility(DescriptorVisibility r100, CallableMemberDescriptor.Kind r101) {
        if (r101 == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L5;
        return r100;
    L5:
        if (DescriptorVisibilities.isPrivate(r100.normalize()) == true) goto L7;
        return r100;
    L7:
        return DescriptorVisibilities.INVISIBLE_FAKE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r100, D r101) {
        return r100.visitPropertyDescriptor(this, r101);
    }

    public void initialize(PropertyGetterDescriptorImpl r100, PropertySetterDescriptor r101) {
        initialize(r100, r101, null, null);
    }

    private static ReceiverParameterDescriptor substituteContextParameterDescriptor(TypeSubstitutor r100, PropertyDescriptor r101, ReceiverParameterDescriptor r102) {
        KotlinType r103 = r100.substitute(r102.getType(), Variance.IN_VARIANCE);
        if (r103 != null) goto L7;
        return null;
    L7:
        return new ReceiverParameterDescriptorImpl(r101, new ContextReceiver(r101, r103, ((ImplicitContextReceiver) r102.getValue()).getCustomLabelName(), r102.getValue()), r102.getAnnotations());
    }

    private static ReceiverParameterDescriptor substituteParameterDescriptor(TypeSubstitutor r100, PropertyDescriptor r101, ReceiverParameterDescriptor r102) {
        KotlinType r103 = r100.substitute(r102.getType(), Variance.IN_VARIANCE);
        if (r103 != null) goto L7;
        return null;
    L7:
        return new ReceiverParameterDescriptorImpl(r101, new ExtensionReceiver(r101, r103, r102.getValue()), r102.getAnnotations());
    }

    public void initialize(PropertyGetterDescriptorImpl r100, PropertySetterDescriptor r101, FieldDescriptor r102, FieldDescriptor r103) {
        this.getter = r100;
        this.setter = r101;
        this.backingField = r102;
        this.delegateField = r103;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public PropertyDescriptor copy(DeclarationDescriptor r100, Modality r101, DescriptorVisibility r102, CallableMemberDescriptor.Kind r103, boolean r104) {
        PropertyDescriptor r105 = newCopyBuilder().setOwner(r100).setOriginal(null).setModality(r101).setVisibility(r102).setKind(r103).setCopyOverrides(r104).build();
        if (r105 != null) goto L5;
        $$$reportNull$$$0(42);
    L5:
        return r105;
    }

    public void setType(KotlinType r100, List<? extends TypeParameterDescriptor> r101, ReceiverParameterDescriptor r102, ReceiverParameterDescriptor r103, List<ReceiverParameterDescriptor> r104) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(17);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(18);
    L6:
        if (r104 != null) goto L8;
        $$$reportNull$$$0(19);
    L8:
        setOutType(r100);
        this.typeParameters = new ArrayList(r101);
        this.extensionReceiverParameter = r103;
        this.dispatchReceiverParameter = r102;
        this.contextReceiverParameters = r104;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r100, Modality r101, DescriptorVisibility r102, CallableMemberDescriptor.Kind r103, boolean r104) {
        return copy(r100, r101, r102, r103, r104);
    }

    public PropertyDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r110, Modality r111, DescriptorVisibility r210, PropertyDescriptor r211, CallableMemberDescriptor.Kind r212, Name r213, SourceElement r214) {
        if (r110 != null) goto L4;
        $$$reportNull$$$0(32);
    L4:
        if (r111 != null) goto L6;
        $$$reportNull$$$0(33);
    L6:
        if (r210 != null) goto L8;
        $$$reportNull$$$0(34);
    L8:
        if (r212 != null) goto L10;
        $$$reportNull$$$0(35);
    L10:
        if (r213 != null) goto L12;
        $$$reportNull$$$0(36);
    L12:
        if (r214 != null) goto L15;
        $$$reportNull$$$0(37);
    L15:
        return new PropertyDescriptorImpl(r110, r211, getAnnotations(), r111, r210, isVar(), r213, r212, r214, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
    }

    public static PropertyDescriptorImpl create(DeclarationDescriptor r110, Annotations r111, Modality r112, DescriptorVisibility r210, boolean r211, Name r212, CallableMemberDescriptor.Kind r213, SourceElement r214, boolean r215, boolean r216, boolean r217, boolean r218, boolean r219, boolean r310) {
        if (r110 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        if (r111 != null) goto L6;
        $$$reportNull$$$0(8);
    L6:
        if (r112 != null) goto L8;
        $$$reportNull$$$0(9);
    L8:
        if (r210 != null) goto L10;
        $$$reportNull$$$0(10);
    L10:
        if (r212 != null) goto L12;
        $$$reportNull$$$0(11);
    L12:
        if (r213 != null) goto L14;
        $$$reportNull$$$0(12);
    L14:
        if (r214 != null) goto L17;
        $$$reportNull$$$0(13);
    L17:
        return new PropertyDescriptorImpl(r110, null, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public PropertyDescriptorImpl(DeclarationDescriptor r110, PropertyDescriptor r111, Annotations r112, Modality r113, DescriptorVisibility r114, boolean r115, Name r116, CallableMemberDescriptor.Kind r117, SourceElement r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216) {
        if (r110 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        if (r112 != null) goto L7;
        $$$reportNull$$$0(1);
    L7:
        if (r113 != null) goto L9;
        $$$reportNull$$$0(2);
    L9:
        if (r114 != null) goto L11;
        $$$reportNull$$$0(3);
    L11:
        if (r116 != null) goto L13;
        $$$reportNull$$$0(4);
    L13:
        if (r117 != null) goto L15;
        $$$reportNull$$$0(5);
    L15:
        if (r210 != null) goto L17;
        $$$reportNull$$$0(6);
    L17:
        super(r110, r112, r116, null, r115, r210);
        this.overriddenProperties = null;
        this.contextReceiverParameters = Collections.emptyList();
        this.modality = r113;
        this.visibility = r114;
        if (r111 != null) goto L20;
        PropertyDescriptor r100 = this;
    L21:
        this.original = r100;
        this.kind = r117;
        this.lateInit = r211;
        this.isConst = r212;
        this.isExpect = r213;
        this.isActual = r214;
        this.isExternal = r215;
        this.isDelegated = r216;
        return;
    L20:
        r100 = r111;
        goto L21
    }
}
