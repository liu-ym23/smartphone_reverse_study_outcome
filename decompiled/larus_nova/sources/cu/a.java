package cu;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.common.collection.ObservableList;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

/* JADX INFO: loaded from: classes44.dex */
public final class a<E> extends ObservableList<E> implements KMutableList {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<E> f465407c;

    @Override // java.util.List
    public final void add(int r100, E r101) {
        ListProtector.add(this.f465407c, r100, r101);
    }

    @Override // java.util.List
    public final boolean addAll(int r100, Collection<? extends E> r101) {
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        return this.f465407c.addAll(r100, r101);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f465407c.addAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f465407c.clear();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r100) {
        return this.f465407c.contains(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f465407c.containsAll(r100);
    }

    @Override // java.util.List
    public final E get(int r100) {
        return (E) ListProtector.get(this.f465407c, r100);
    }

    @Override // java.util.List
    public final int indexOf(Object r100) {
        return this.f465407c.indexOf(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f465407c.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return this.f465407c.iterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r100) {
        return this.f465407c.lastIndexOf(r100);
    }

    @Override // java.util.List
    public final ListIterator<E> listIterator() {
        return this.f465407c.listIterator();
    }

    @Override // java.util.List
    public final ListIterator<E> listIterator(int r100) {
        return this.f465407c.listIterator(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f465407c.removeAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return this.f465407c.retainAll(r100);
    }

    @Override // java.util.List
    public final E set(int r100, E r101) {
        return (E) ListProtector.set(this.f465407c, r100, r101);
    }

    @Override // java.util.List
    public final List<E> subList(int r100, int r101) {
        return this.f465407c.subList(r100, r101);
    }

    public a(List<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        super(r100);
        this.f465407c = r100;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(E r100) {
        boolean r101 = this.f465407c.add(r100);
        ObservableList.DataChangeType r102 = ObservableList.DataChangeType.ADD;
        Intrinsics.checkNotNullParameter(r102, "type");
        Iterator<T> r103 = this.f56509a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((Function2) r103.next()).invoke(r102, r100);
        goto L4
    L6:
        return r101;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r100) {
        boolean r101 = this.f465407c.remove(r100);
        ObservableList.DataChangeType r102 = ObservableList.DataChangeType.REMOVE;
        Intrinsics.checkNotNullParameter(r102, "type");
        Iterator<T> r103 = this.f56509a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((Function2) r103.next()).invoke(r102, r100);
        goto L4
    L6:
        return r101;
    }

    @Override // java.util.List
    public final E remove(int r100) {
        return (E) ListProtector.remove(this.f465407c, r100);
    }
}
