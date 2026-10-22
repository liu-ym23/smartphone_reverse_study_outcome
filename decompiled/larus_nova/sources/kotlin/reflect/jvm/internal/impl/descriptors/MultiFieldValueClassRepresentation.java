package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: loaded from: classes42.dex */
public final class MultiFieldValueClassRepresentation<Type extends SimpleTypeMarker> extends ValueClassRepresentation<Type> {
    private final Map<Name, Type> map;
    private final List<Pair<Name, Type>> underlyingPropertyNamesToTypes;

    public String toString() {
        return "MultiFieldValueClassRepresentation(underlyingPropertyNamesToTypes=" + getUnderlyingPropertyNamesToTypes() + ')';
    }

    public List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes() {
        return this.underlyingPropertyNamesToTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultiFieldValueClassRepresentation(List<? extends Pair<Name, ? extends Type>> r100) {
        Intrinsics.checkNotNullParameter(r100, "underlyingPropertyNamesToTypes");
        super(null);
        this.underlyingPropertyNamesToTypes = r100;
        Map<Name, Type> r101 = MapsKt.toMap(getUnderlyingPropertyNamesToTypes());
        if (r101.size() != getUnderlyingPropertyNamesToTypes().size()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        this.map = r101;
        return;
    L10:
        throw new IllegalArgumentException("Some properties have the same names".toString());
    L5:
        r102 = false;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation
    public boolean containsPropertyWithName(Name r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.map.containsKey(r100);
    }
}
