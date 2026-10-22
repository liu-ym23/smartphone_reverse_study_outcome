package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes42.dex */
public final class ArgumentList extends ArrayList<TypeArgumentMarker> implements TypeArgumentListMarker {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public ArgumentList(int r100) {
        super(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof TypeArgumentMarker) == true) goto L7;
        return false;
    L7:
        return contains((TypeArgumentMarker) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof TypeArgumentMarker) == true) goto L7;
        return -1;
    L7:
        return indexOf((TypeArgumentMarker) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof TypeArgumentMarker) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((TypeArgumentMarker) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof TypeArgumentMarker) == true) goto L7;
        return false;
    L7:
        return remove((TypeArgumentMarker) r100);
    }

    public /* bridge */ boolean contains(TypeArgumentMarker r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(TypeArgumentMarker r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(TypeArgumentMarker r100) {
        return super.lastIndexOf(r100);
    }

    public /* bridge */ boolean remove(TypeArgumentMarker r100) {
        return super.remove(r100);
    }
}
