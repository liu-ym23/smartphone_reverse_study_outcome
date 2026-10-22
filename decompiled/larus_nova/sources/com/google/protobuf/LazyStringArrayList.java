package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes23.dex */
public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {
    public static final LazyStringList EMPTY = null;
    private static final LazyStringArrayList EMPTY_LIST = null;
    private final List<Object> list;

    public static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        private final LazyStringArrayList list;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        public ByteArrayListView(LazyStringArrayList r100) {
            this.list = r100;
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] get(int r100) {
            return this.list.getByteArray(r100);
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] remove(int r100) {
            String r101 = this.list.remove(r100);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$100(r101);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r100) {
            return get(r100);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int r100) {
            return remove(r100);
        }

        public void add(int r100, byte[] r101) {
            LazyStringArrayList.access$200(this.list, r100, r101);
            ((AbstractList) this).modCount++;
        }

        public byte[] set(int r100, byte[] r101) {
            Object r102 = LazyStringArrayList.access$000(this.list, r100, r101);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$100(r102);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ void add(int r100, Object r101) {
            add(r100, (byte[]) r101);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r100, Object r101) {
            return set(r100, (byte[]) r101);
        }
    }

    public static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        private final LazyStringArrayList list;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        public ByteStringListView(LazyStringArrayList r100) {
            this.list = r100;
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString get(int r100) {
            return this.list.getByteString(r100);
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString remove(int r100) {
            String r101 = this.list.remove(r100);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$400(r101);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r100) {
            return get(r100);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int r100) {
            return remove(r100);
        }

        public void add(int r100, ByteString r101) {
            LazyStringArrayList.access$500(this.list, r100, r101);
            ((AbstractList) this).modCount++;
        }

        public ByteString set(int r100, ByteString r101) {
            Object r102 = LazyStringArrayList.access$300(this.list, r100, r101);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$400(r102);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ void add(int r100, Object r101) {
            add(r100, (ByteString) r101);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r100, Object r101) {
            return set(r100, (ByteString) r101);
        }
    }

    static {
        LazyStringArrayList r100 = new LazyStringArrayList();
        EMPTY_LIST = r100;
        r100.makeImmutable();
        EMPTY = r100;
    }

    public LazyStringArrayList() {
        this(10);
    }

    @Override // com.google.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return new ByteArrayListView(this);
    }

    @Override // com.google.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return new ByteStringListView(this);
    }

    @Override // com.google.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ensureIsMutable();
        this.list.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        if (isModifiable() == true) goto L5;
        return this;
    L5:
        return new UnmodifiableLazyStringList(this);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.protobuf.AbstractProtobufList, com.google.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    public static LazyStringArrayList emptyList() {
        return EMPTY_LIST;
    }

    public LazyStringArrayList(LazyStringList r100) {
        this.list = new ArrayList(r100.size());
        addAll(r100);
    }

    public static /* synthetic */ byte[] access$100(Object r100) {
        return asByteArray(r100);
    }

    public static /* synthetic */ ByteString access$400(Object r100) {
        return asByteString(r100);
    }

    private static byte[] asByteArray(Object r100) {
        if ((r100 instanceof byte[]) == false) goto L7;
        return (byte[]) r100;
    L7:
        if ((r100 instanceof String) == false) goto L11;
        return Internal.toByteArray((String) r100);
    L11:
        return ((ByteString) r100).toByteArray();
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

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString r100) {
        ensureIsMutable();
        this.list.add(r100);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> r100) {
        return addAll(size(), r100);
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> r100) {
        ensureIsMutable();
        boolean r101 = this.list.addAll(r100);
        ((AbstractList) this).modCount++;
        return r101;
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> r100) {
        ensureIsMutable();
        boolean r101 = this.list.addAll(r100);
        ((AbstractList) this).modCount++;
        return r101;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object r100) {
        return super.equals(r100);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int r100) {
        Object r101 = ListProtector.get(this.list, r100);
        byte[] r102 = asByteArray(r101);
        if (r102 == r101) goto L5;
        ListProtector.set(this.list, r100, r102);
    L5:
        return r102;
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int r100) {
        Object r101 = ListProtector.get(this.list, r100);
        ByteString r102 = asByteString(r101);
        if (r102 == r101) goto L5;
        ListProtector.set(this.list, r100, r102);
    L5:
        return r102;
    }

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int r100) {
        return ListProtector.get(this.list, r100);
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(LazyStringList r100) {
        ensureIsMutable();
        Iterator<?> r101 = r100.getUnderlyingElements().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Object r102 = r101.next();
        if ((r102 instanceof byte[]) == true) goto L7;
        this.list.add(r102);
        goto L4
    L7:
        byte[] r103 = (byte[]) r102;
        this.list.add(Arrays.copyOf(r103, r103.length));
        goto L4
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public LazyStringArrayList mutableCopyWithCapacity(int r100) {
        if (r100 < size()) goto L7;
        ArrayList r101 = new ArrayList(r100);
        r101.addAll(this.list);
        return new LazyStringArrayList(r101);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String remove(int r100) {
        ensureIsMutable();
        Object r101 = ListProtector.remove(this.list, r100);
        ((AbstractList) this).modCount++;
        return asString(r101);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection r100) {
        return super.removeAll(r100);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection r100) {
        return super.retainAll(r100);
    }

    public LazyStringArrayList(int r100) {
        this(new ArrayList(r100));
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] r100) {
        ensureIsMutable();
        this.list.add(r100);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r100) {
        return get(r100);
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public /* bridge */ /* synthetic */ Internal.ProtobufList mutableCopyWithCapacity(int r100) {
        return mutableCopyWithCapacity(r100);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r100) {
        return remove(r100);
    }

    public LazyStringArrayList(List<String> r100) {
        this(new ArrayList(r100));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object r100) {
        return super.remove(r100);
    }

    private LazyStringArrayList(ArrayList<Object> r100) {
        this.list = r100;
    }

    private void add(int r100, ByteString r101) {
        ensureIsMutable();
        ListProtector.add(this.list, r100, r101);
        ((AbstractList) this).modCount++;
    }

    private Object setAndReturn(int r100, ByteString r101) {
        ensureIsMutable();
        return ListProtector.set(this.list, r100, r101);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public boolean addAll(int r100, Collection<? extends String> r101) {
        ensureIsMutable();
        if ((r101 instanceof LazyStringList) == false) goto L5;
        r101 = ((LazyStringList) r101).getUnderlyingElements();
    L5:
        boolean r102 = this.list.addAll(r100, r101);
        ((AbstractList) this).modCount++;
        return r102;
    }

    public String set(int r100, String r101) {
        ensureIsMutable();
        return asString(ListProtector.set(this.list, r100, r101));
    }

    private Object setAndReturn(int r100, byte[] r101) {
        ensureIsMutable();
        return ListProtector.set(this.list, r100, r101);
    }

    public void add(int r100, String r101) {
        ensureIsMutable();
        ListProtector.add(this.list, r100, r101);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r100, Object r101) {
        return set(r100, (String) r101);
    }

    private void add(int r100, byte[] r101) {
        ensureIsMutable();
        ListProtector.add(this.list, r100, r101);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r100, ByteString r101) {
        setAndReturn(r100, r101);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r100, Object r101) {
        add(r100, (String) r101);
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r100, byte[] r101) {
        setAndReturn(r100, r101);
    }

    public static /* synthetic */ Object access$000(LazyStringArrayList r100, int r101, byte[] r102) {
        return r100.setAndReturn(r101, r102);
    }

    public static /* synthetic */ void access$200(LazyStringArrayList r100, int r101, byte[] r102) {
        r100.add(r101, r102);
    }

    public static /* synthetic */ Object access$300(LazyStringArrayList r100, int r101, ByteString r102) {
        return r100.setAndReturn(r101, r102);
    }

    public static /* synthetic */ void access$500(LazyStringArrayList r100, int r101, ByteString r102) {
        r100.add(r101, r102);
    }
}
