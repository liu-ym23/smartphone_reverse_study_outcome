package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes42.dex */
public interface AnnotationDescriptor {

    public static final class DefaultImpls {
        public static FqName getFqName(AnnotationDescriptor r100) {
            ClassDescriptor r101 = DescriptorUtilsKt.getAnnotationClass(r100);
            if (r101 != null) goto L5;
            return null;
        L5:
            if (ErrorUtils.isError(r101) == false) goto L8;
            r101 = null;
        L8:
            if (r101 != null) goto L10;
            return null;
        L10:
            return DescriptorUtilsKt.fqNameOrNull(r101);
        }
    }

    Map<Name, ConstantValue<?>> getAllValueArguments();

    FqName getFqName();

    SourceElement getSource();

    KotlinType getType();
}
