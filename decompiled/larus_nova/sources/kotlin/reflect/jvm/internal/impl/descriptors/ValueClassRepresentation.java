package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ValueClassRepresentation<Type extends SimpleTypeMarker> {
    private ValueClassRepresentation() {
    }

    public /* synthetic */ ValueClassRepresentation(DefaultConstructorMarker r100) {
        this();
    }

    public abstract boolean containsPropertyWithName(Name r100);

    public final <Other extends SimpleTypeMarker> ValueClassRepresentation<Other> mapUnderlyingType(Function1<? super Type, ? extends Other> r100) {
        Intrinsics.checkNotNullParameter(r100, "transform");
        if ((this instanceof InlineClassRepresentation) == false) goto L6;
        InlineClassRepresentation r101 = (InlineClassRepresentation) this;
        return new InlineClassRepresentation(r101.getUnderlyingPropertyName(), r100.invoke(r101.getUnderlyingType()));
    L6:
        if ((this instanceof MultiFieldValueClassRepresentation) == false) goto L14;
        List<Pair<Name, Type>> r102 = ((MultiFieldValueClassRepresentation) this).getUnderlyingPropertyNamesToTypes();
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L12;
        Pair r105 = (Pair) r104.next();
        r103.add(TuplesKt.to((Name) r105.component1(), r100.invoke((SimpleTypeMarker) r105.component2())));
        goto L9
    L12:
        return new MultiFieldValueClassRepresentation(r103);
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
