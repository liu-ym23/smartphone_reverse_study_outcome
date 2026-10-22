package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes5.dex */
public interface TypeAttributeTranslator {

    /* JADX INFO: loaded from: classes42.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ TypeAttributes toAttributes$default(TypeAttributeTranslator r100, Annotations r101, TypeConstructor r102, DeclarationDescriptor r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r104 & 4) == 0) goto L10;
            r103 = null;
        L10:
            return r100.toAttributes(r101, r102, r103);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toAttributes");
        }
    }

    TypeAttributes toAttributes(Annotations r100, TypeConstructor r101, DeclarationDescriptor r102);
}
