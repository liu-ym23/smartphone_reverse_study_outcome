package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes5.dex */
public interface SignaturePropagator {
    public static final SignaturePropagator DO_NOTHING = null;

    /* JADX INFO: loaded from: classes42.dex */
    public static class PropagatedSignature {
        private final boolean hasStableParameterNames;
        private final KotlinType receiverType;
        private final KotlinType returnType;
        private final List<String> signatureErrors;
        private final List<TypeParameterDescriptor> typeParameters;
        private final List<ValueParameterDescriptor> valueParameters;

        private static /* synthetic */ void $$$reportNull$$$0(int r110) {
            if (r110 == 4) goto L8;
            if (r110 == 5) goto L8;
            if (r110 == 6) goto L8;
            if (r110 == 7) goto L8;
            String r100 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L10:
            if (r110 == 4) goto L15;
            if (r110 == 5) goto L15;
            if (r110 == 6) goto L15;
            if (r110 == 7) goto L15;
            int r101 = 3;
        L16:
            Object[] r102 = new Object[r101];
            switch(r110) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L19;
                case 6: goto L19;
                case 7: goto L19;
                default: goto L18;
            };
        L18:
            r102[0] = "returnType";
        L24:
            if (r110 == 4) goto L32;
            if (r110 == 5) goto L31;
            if (r110 == 6) goto L30;
            if (r110 == 7) goto L29;
            r102[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
        L33:
            if (r110 == 4) goto L38;
            if (r110 == 5) goto L38;
            if (r110 == 6) goto L38;
            if (r110 == 7) goto L38;
            r102[2] = "<init>";
        L38:
            String r103 = String.format(r100, r102);
            if (r110 == 4) goto L45;
            if (r110 == 5) goto L45;
            if (r110 == 6) goto L45;
            if (r110 == 7) goto L45;
            throw new IllegalArgumentException(r103);
        L45:
            throw new IllegalStateException(r103);
        L29:
            r102[1] = "getErrors";
            goto L33
        L30:
            r102[1] = "getTypeParameters";
            goto L33
        L31:
            r102[1] = "getValueParameters";
            goto L33
        L32:
            r102[1] = "getReturnType";
            goto L33
        L19:
            r102[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            goto L24
        L20:
            r102[0] = "signatureErrors";
            goto L24
        L21:
            r102[0] = "typeParameters";
            goto L24
        L22:
            r102[0] = "valueParameters";
        L15:
            r101 = 2;
        L8:
            r100 = "@NotNull method %s.%s must not return null";
            goto L10
        }

        public List<String> getErrors() {
            List<String> r100 = this.signatureErrors;
            if (r100 != null) goto L5;
            $$$reportNull$$$0(7);
        L5:
            return r100;
        }

        public KotlinType getReturnType() {
            KotlinType r100 = this.returnType;
            if (r100 != null) goto L5;
            $$$reportNull$$$0(4);
        L5:
            return r100;
        }

        public List<TypeParameterDescriptor> getTypeParameters() {
            List<TypeParameterDescriptor> r100 = this.typeParameters;
            if (r100 != null) goto L5;
            $$$reportNull$$$0(6);
        L5:
            return r100;
        }

        public List<ValueParameterDescriptor> getValueParameters() {
            List<ValueParameterDescriptor> r100 = this.valueParameters;
            if (r100 != null) goto L5;
            $$$reportNull$$$0(5);
        L5:
            return r100;
        }

        public KotlinType getReceiverType() {
            return this.receiverType;
        }

        public boolean hasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        public PropagatedSignature(KotlinType r100, KotlinType r101, List<ValueParameterDescriptor> r102, List<TypeParameterDescriptor> r103, List<String> r104, boolean r105) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r102 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r103 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            if (r104 != null) goto L10;
            $$$reportNull$$$0(3);
        L10:
            this.returnType = r100;
            this.receiverType = r101;
            this.valueParameters = r102;
            this.typeParameters = r103;
            this.signatureErrors = r104;
            this.hasStableParameterNames = r105;
        }
    }

    void reportSignatureErrors(CallableMemberDescriptor r100, List<String> r101);

    PropagatedSignature resolvePropagatedSignature(JavaMethod r100, ClassDescriptor r101, KotlinType r102, KotlinType r103, List<ValueParameterDescriptor> r104, List<TypeParameterDescriptor> r105);

    static {
        DO_NOTHING = new AnonymousClass1();
    }
}
