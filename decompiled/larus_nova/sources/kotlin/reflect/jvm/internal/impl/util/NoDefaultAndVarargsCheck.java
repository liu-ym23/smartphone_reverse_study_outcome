package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: classes42.dex */
final class NoDefaultAndVarargsCheck implements Check {
    public static final NoDefaultAndVarargsCheck INSTANCE = null;
    private static final String description = null;

    private NoDefaultAndVarargsCheck() {
    }

    static {
        INSTANCE = new NoDefaultAndVarargsCheck();
        description = "should not have varargs or parameters with default values";
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "functionDescriptor");
        List<ValueParameterDescriptor> r101 = r100.getValueParameters();
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L25;
        ValueParameterDescriptor r103 = (ValueParameterDescriptor) r102.next();
        Intrinsics.checkNotNull(r103);
        if (DescriptorUtilsKt.declaresOrInheritsDefaultValue(r103) == false) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == true) goto L9;
        return false;
    L13:
        if (r103.getVarargElementType() != null) goto L15;
        r104 = true;
        goto L16
    L25:
        return true;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor r100) {
        return Check.DefaultImpls.invoke(this, r100);
    }
}
