package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: loaded from: classes42.dex */
public final class InlineClassRepresentation<Type extends SimpleTypeMarker> extends ValueClassRepresentation<Type> {
    private final Name underlyingPropertyName;
    private final Type underlyingType;

    public String toString() {
        return "InlineClassRepresentation(underlyingPropertyName=" + this.underlyingPropertyName + ", underlyingType=" + this.underlyingType + ')';
    }

    public final Name getUnderlyingPropertyName() {
        return this.underlyingPropertyName;
    }

    public final Type getUnderlyingType() {
        return this.underlyingType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation
    public boolean containsPropertyWithName(Name r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return Intrinsics.areEqual(this.underlyingPropertyName, r100);
    }

    public InlineClassRepresentation(Name r100, Type r101) {
        Intrinsics.checkNotNullParameter(r100, "underlyingPropertyName");
        Intrinsics.checkNotNullParameter(r101, "underlyingType");
        super(null);
        this.underlyingPropertyName = r100;
        this.underlyingType = r101;
    }
}
