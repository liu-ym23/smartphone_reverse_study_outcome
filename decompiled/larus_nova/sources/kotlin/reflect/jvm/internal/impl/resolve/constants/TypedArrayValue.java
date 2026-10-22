package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public final class TypedArrayValue extends ArrayValue {
    private final KotlinType type;

    private static final KotlinType _init_$lambda$0(KotlinType r100, ModuleDescriptor r101) {
        Intrinsics.checkNotNullParameter(r100, "$type");
        Intrinsics.checkNotNullParameter(r101, "it");
        return r100;
    }

    public static /* synthetic */ KotlinType accessor$TypedArrayValue$lambda0(KotlinType r100, ModuleDescriptor r101) {
        return _init_$lambda$0(r100, r101);
    }

    public final KotlinType getType() {
        return this.type;
    }

    public TypedArrayValue(List<? extends ConstantValue<?>> r100, final KotlinType r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "type");
        super(r100, new TypedArrayValue$$Lambda$0(r101));
        this.type = r101;
    }
}
