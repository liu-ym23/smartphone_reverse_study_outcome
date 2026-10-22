package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public class ArrayValue extends ConstantValue<List<? extends ConstantValue<?>>> {
    private final Function1<ModuleDescriptor, KotlinType> computeType;

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        KotlinType r101 = this.computeType.invoke(r100);
        if (KotlinBuiltIns.isArray(r101) == false) goto L5;
    L7:
        return r101;
    L5:
        if (KotlinBuiltIns.isPrimitiveArray(r101) == true) goto L7;
        KotlinBuiltIns.isUnsignedArrayType(r101);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayValue(List<? extends ConstantValue<?>> r100, Function1<? super ModuleDescriptor, ? extends KotlinType> r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "computeType");
        super(r100);
        this.computeType = r101;
    }
}
