package kotlin.reflect.jvm.internal.impl.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes5.dex */
public class LazyStringArrayList extends AbstractList<String> implements RandomAccess, LazyStringList {
    public static final LazyStringList EMPTY = null;
    private final List<Object> list;

    static {
        EMPTY = new LazyStringArrayList().getUnmodifiableView();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.list.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return new UnmodifiableLazyStringList(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    public LazyStringArrayList() {
        this.list = new ArrayList();
    }

    public LazyStringArrayList(LazyStringList r100) {
        this.list = new ArrayList(r100.size());
        addAll(r100);
    }

    private static ByteString asByteString(Object r100) {
        if ((r100 instanceof ByteString) == false) goto L7;
        return (ByteString) r100;
    L7:
        if ((r100 instanceof String) == false) goto L11;
        return ByteString.copyFromUtf8((String) r100);
    L11:
        return ByteString.copyFrom((byte[]) r100);
    }

    private static String asString(Object r100) {
        if ((r100 instanceof String) == false) goto L7;
        return (String) r100;
    L7:
        if ((r100 instanceof ByteString) == false) goto L11;
        return ((ByteString) r100).toStringUtf8();
    L11:
        return Internal.toStringUtf8((byte[]) r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public void add(ByteString r100) {
        this.list.add(r100);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> r100) {
        return addAll(size(), r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int r100) {
        Object r101 = ListProtector.get(this.list, r100);
        if ((r101 instanceof String) == false) goto L7;
        return (String) r101;
    L7:
        if ((r101 instanceof ByteString) == false) goto L12;
        ByteString r102 = (ByteString) r101;
        String r103 = r102.toStringUtf8();
        if (r102.isValidUtf8() == false) goto L11;
        ListProtector.set(this.list, r100, r103);
    L11:
        return r103;
    L12:
        byte[] r104 = (byte[]) r101;
        String r105 = Internal.toStringUtf8(r104);
        if (Internal.isValidUtf8(r104) == false) goto L15;
        ListProtector.set(this.list, r100, r105);
    L15:
        return r105;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public ByteString getByteString(int r100) {
        Object r101 = ListProtector.get(this.list, r100);
        ByteString r102 = asByteString(r101);
        if (r102 == r101) goto L5;
        ListProtector.set(this.list, r100, r102);
    L5:
        return r102;
    }

    @Override // java.util.AbstractList, java.util.List
    public String remove(int r100) {
        Object r101 = ListProtector.remove(this.list, r100);
        ((AbstractList) this).modCount++;
        return asString(r101);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r100) {
        return get(r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r100) {
        return remove(r100);
    }

    public void add(int r100, String r101) {
        ListProtector.add(this.list, r100, r101);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r100, Collection<? extends String> r101) {
        if ((r101 instanceof LazyStringList) == false) goto L5;
        r101 = ((LazyStringList) r101).getUnderlyingElements();
    L5:
        boolean r102 = this.list.addAll(r100, r101);
        ((AbstractList) this).modCount++;
        return r102;
    }

    public String set(int r100, String r101) {
        return asString(ListProtector.set(this.list, r100, r101));
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r100, Object r101) {
        add(r100, (String) r101);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r100, Object r101) {
        return set(r100, (String) r101);
    }
}
