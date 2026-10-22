package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes42.dex */
public final class LongValue extends IntegerValueConstant<Long> {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return getValue().longValue() + ".toLong()";
    }

    public LongValue(long r100) {
        super(Long.valueOf(r100));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        return r100.getBuiltIns().getLongType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor r100) {
        return getType(r100);
    }
}
