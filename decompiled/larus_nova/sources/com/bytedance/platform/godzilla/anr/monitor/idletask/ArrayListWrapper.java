package com.bytedance.platform.godzilla.anr.monitor.idletask;

import android.os.MessageQueue;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import n57.c;

/* JADX INFO: loaded from: classes21.dex */
public class ArrayListWrapper extends ArrayList<MessageQueue.IdleHandler> {
    private ArrayList<MessageQueue.IdleHandler> mOriginalArrayList;

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        throw new RuntimeException("Reach method clear");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        throw new RuntimeException("Reach method isEmpty");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<MessageQueue.IdleHandler> iterator() {
        return this.mOriginalArrayList.iterator();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<MessageQueue.IdleHandler> listIterator() {
        throw new RuntimeException("Reach method listIterator");
    }

    @Override // java.util.Collection
    public Stream<MessageQueue.IdleHandler> parallelStream() {
        throw new RuntimeException("Reach method parallelStream");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mOriginalArrayList.size();
    }

    @Override // java.util.ArrayList, java.util.Collection, java.lang.Iterable, java.util.List
    public Spliterator<MessageQueue.IdleHandler> spliterator() {
        throw new RuntimeException("Reach method spliterator");
    }

    @Override // java.util.Collection
    public Stream<MessageQueue.IdleHandler> stream() {
        throw new RuntimeException("Reach method stream");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        throw new RuntimeException("Reach method toArray");
    }

    @Override // java.util.ArrayList
    public void trimToSize() {
        throw new RuntimeException("Reach method trimToSize");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return super.toString();
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public ArrayListWrapper(ArrayList<MessageQueue.IdleHandler> r100) {
        this.mOriginalArrayList = r100;
    }

    public boolean add(MessageQueue.IdleHandler r100) {
        if (r100 == null) goto L8;
        if ((r100 instanceof c) == true) goto L8;
        return this.mOriginalArrayList.add(new c(r100));
    L8:
        return this.mOriginalArrayList.add(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends MessageQueue.IdleHandler> r100) {
        throw new RuntimeException("Reach method addAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r100) {
        throw new RuntimeException("Reach method contains");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> r100) {
        throw new RuntimeException("Reach method containsAll");
    }

    @Override // java.util.ArrayList
    public void ensureCapacity(int r100) {
        throw new RuntimeException("Reach method ensureCapacity");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r100) {
        return super.equals(r100);
    }

    @Override // java.util.ArrayList, java.lang.Iterable
    public void forEach(Consumer<? super MessageQueue.IdleHandler> r100) {
        throw new RuntimeException("Reach method forEach");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public MessageQueue.IdleHandler get(int r100) {
        throw new RuntimeException("Reach method get");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int indexOf(Object r100) {
        throw new RuntimeException("Reach method indexOf");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r100) {
        throw new RuntimeException("Reach method lastIndexOf");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<MessageQueue.IdleHandler> listIterator(int r100) {
        throw new RuntimeException("Reach method listIterator");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r100) {
        if (this.mOriginalArrayList.remove(r100) == false) goto L6;
        return true;
    L6:
        Iterator<MessageQueue.IdleHandler> r101 = this.mOriginalArrayList.iterator();
    L8:
        if (r101.hasNext() == false) goto L14;
        MessageQueue.IdleHandler r102 = r101.next();
        if ((r102 instanceof c) == false) goto L8;
        c r103 = (c) r102;
        if (r103.f518041a != r100) goto L8;
    L15:
        if (r103 != null) goto L17;
        return false;
    L17:
        return this.mOriginalArrayList.remove(r103);
    L14:
        r103 = null;
        goto L15
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r100) {
        throw new RuntimeException("Reach method removeAll");
    }

    @Override // java.util.ArrayList, java.util.Collection
    public boolean removeIf(Predicate<? super MessageQueue.IdleHandler> r100) {
        throw new RuntimeException("Reach method removeIf");
    }

    @Override // java.util.ArrayList, java.util.List
    public void replaceAll(UnaryOperator<MessageQueue.IdleHandler> r100) {
        throw new RuntimeException("Reach method replaceAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r100) {
        throw new RuntimeException("Reach method retainAll");
    }

    @Override // java.util.ArrayList, java.util.List
    public void sort(Comparator<? super MessageQueue.IdleHandler> r100) {
        throw new RuntimeException("Reach method sort");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r100) {
        return (T[]) this.mOriginalArrayList.toArray(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r100) {
        return add((MessageQueue.IdleHandler) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r100) {
        return get(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public MessageQueue.IdleHandler remove(int r100) {
        return (MessageQueue.IdleHandler) ListProtector.remove(this.mOriginalArrayList, r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r100) {
        return remove(r100);
    }

    public void add(int r100, MessageQueue.IdleHandler r101) {
        throw new RuntimeException("Reach method add");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int r100, Collection<? extends MessageQueue.IdleHandler> r101) {
        throw new RuntimeException("Reach method addAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    public void removeRange(int r100, int r101) {
        throw new RuntimeException("Reach method removeRange");
    }

    public MessageQueue.IdleHandler set(int r100, MessageQueue.IdleHandler r101) {
        throw new RuntimeException("Reach method set");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public List<MessageQueue.IdleHandler> subList(int r100, int r101) {
        throw new RuntimeException("Reach method subList");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r100, Object r101) {
        add(r100, (MessageQueue.IdleHandler) r101);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r100, Object r101) {
        return set(r100, (MessageQueue.IdleHandler) r101);
    }
}
