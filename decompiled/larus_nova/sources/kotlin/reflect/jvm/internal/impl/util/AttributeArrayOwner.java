package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AttributeArrayOwner<K, T> extends AbstractArrayMapOwner<K, T> {
    private ArrayMap<T> arrayMap;

    public AttributeArrayOwner() {
        EmptyArrayMap r100 = EmptyArrayMap.INSTANCE;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        this(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    public final ArrayMap<T> getArrayMap() {
        return this.arrayMap;
    }

    public AttributeArrayOwner(ArrayMap<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "arrayMap");
        this.arrayMap = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    public final void registerComponent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "keyQualifiedName");
        Intrinsics.checkNotNullParameter(r101, "value");
        int r102 = getTypeRegistry().getId(r100);
        int r103 = this.arrayMap.getSize();
        if (r103 != 0) goto L5;
        this.arrayMap = new OneElementArrayMap(r101, r102);
        return;
    L5:
        if (r103 != 1) goto L12;
        ArrayMap<T> r104 = this.arrayMap;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        OneElementArrayMap r105 = (OneElementArrayMap) r104;
        if (r105.getIndex() != r102) goto L11;
        this.arrayMap = new OneElementArrayMap(r101, r102);
        return;
    L11:
        ArrayMapImpl r106 = new ArrayMapImpl();
        this.arrayMap = r106;
        r106.set(r105.getIndex(), r105.getValue());
    L12:
        this.arrayMap.set(r102, r101);
    }
}
