package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public final class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final ByteBuffer EMPTY_BYTE_BUFFER = null;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM = null;
    static final Charset ISO_8859_1 = null;
    static final Charset UTF_8 = null;

    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean r100);

        boolean getBoolean(int r100);

        @Override // 
        ProtobufList<Boolean> mutableCopyWithCapacity(int r100);

        boolean setBoolean(int r100, boolean r101);
    }

    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double r100);

        double getDouble(int r100);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Double> mutableCopyWithCapacity(int r100);

        double setDouble(int r100, double r101);
    }

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int r100);
    }

    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float r100);

        float getFloat(int r100);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Float> mutableCopyWithCapacity(int r100);

        float setFloat(int r100, float r101);
    }

    public interface IntList extends ProtobufList<Integer> {
        void addInt(int r100);

        int getInt(int r100);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Integer> mutableCopyWithCapacity(int r100);

        int setInt(int r100, int r101);
    }

    public static class ListAdapter<F, T> extends AbstractList<T> {
        private final Converter<F, T> converter;
        private final List<F> fromList;

        public interface Converter<F, T> {
            T convert(F r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r100) {
            return this.converter.convert((F) ListProtector.get(this.fromList, r100));
        }

        public ListAdapter(List<F> r100, Converter<F, T> r101) {
            this.fromList = r100;
            this.converter = r101;
        }
    }

    public interface LongList extends ProtobufList<Long> {
        void addLong(long r100);

        long getLong(int r100);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Long> mutableCopyWithCapacity(int r100);

        long setLong(int r100, long r101);
    }

    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {
        private final Map<K, RealValue> realMap;
        private final Converter<RealValue, V> valueConverter;

        public interface Converter<A, B> {
            A doBackward(B r100);

            B doForward(A r100);
        }

        public class EntryAdapter implements Map.Entry<K, V> {
            private final Map.Entry<K, RealValue> realEntry;
            final /* synthetic */ MapAdapter this$0;

            @Override // java.util.Map.Entry
            public K getKey() {
                return this.realEntry.getKey();
            }

            @Override // java.util.Map.Entry
            public V getValue() {
                return (V) MapAdapter.access$000(this.this$0).doForward(this.realEntry.getValue());
            }

            @Override // java.util.Map.Entry
            public V setValue(V r100) {
                RealValue r101 = this.realEntry.setValue((RealValue) MapAdapter.access$000(this.this$0).doBackward(r100));
                if (r101 != null) goto L7;
                return null;
            L7:
                return (V) MapAdapter.access$000(this.this$0).doForward(r101);
            }

            public EntryAdapter(MapAdapter r100, Map.Entry<K, RealValue> r101) {
                this.this$0 = r100;
                this.realEntry = r101;
            }
        }

        public class IteratorAdapter implements Iterator<Map.Entry<K, V>> {
            private final Iterator<Map.Entry<K, RealValue>> realIterator;
            final /* synthetic */ MapAdapter this$0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.realIterator.hasNext();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return new EntryAdapter(this.this$0, this.realIterator.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.realIterator.remove();
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }

            public IteratorAdapter(MapAdapter r100, Iterator<Map.Entry<K, RealValue>> r101) {
                this.this$0 = r100;
                this.realIterator = r101;
            }
        }

        public class SetAdapter extends AbstractSet<Map.Entry<K, V>> {
            private final Set<Map.Entry<K, RealValue>> realSet;
            final /* synthetic */ MapAdapter this$0;

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return new IteratorAdapter(this.this$0, this.realSet.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.realSet.size();
            }

            public SetAdapter(MapAdapter r100, Set<Map.Entry<K, RealValue>> r101) {
                this.this$0 = r100;
                this.realSet = r101;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new SetAdapter(this, this.realMap.entrySet());
        }

        public static /* synthetic */ Converter access$000(MapAdapter r100) {
            return r100.valueConverter;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object r100) {
            RealValue r101 = this.realMap.get(r100);
            if (r101 != null) goto L7;
            return null;
        L7:
            return this.valueConverter.doForward(r101);
        }

        public MapAdapter(Map<K, RealValue> r100, Converter<RealValue, V> r101) {
            this.realMap = r100;
            this.valueConverter = r101;
        }

        public static <T extends EnumLite> Converter<Integer, T> newEnumConverter(final EnumLiteMap<T> r100, final T r101) {
            return (Converter<Integer, T>) new AnonymousClass1(r100, r101);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r100, V r101) {
            RealValue r102 = this.realMap.put(r100, this.valueConverter.doBackward(r101));
            if (r102 != null) goto L7;
            return null;
        L7:
            return this.valueConverter.doForward(r102);
        }
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int r100);
    }

    private Internal() {
    }

    public static int hashBoolean(boolean r100) {
        if (r100 == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    public static int hashLong(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    static {
        UTF_8 = Charset.forName("UTF-8");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        byte[] r100 = new byte[0];
        EMPTY_BYTE_ARRAY = r100;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(r100);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(r100);
    }

    public static byte[] byteArrayDefaultValue(String r100) {
        return r100.getBytes(ISO_8859_1);
    }

    public static ByteBuffer byteBufferDefaultValue(String r100) {
        return ByteBuffer.wrap(byteArrayDefaultValue(r100));
    }

    public static ByteString bytesDefaultValue(String r100) {
        return ByteString.copyFrom(r100.getBytes(ISO_8859_1));
    }

    public static <T> T checkNotNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw null;
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer r100) {
        ByteBuffer r101 = r100.duplicate();
        r101.clear();
        ByteBuffer r102 = ByteBuffer.allocate(r101.capacity());
        r102.put(r101);
        r102.clear();
        return r102;
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> r100) {
        java.lang.reflect.Method r101 = r100.getMethod("getDefaultInstance", new Class[0]);     // Catch: Exception -> L4
        return (T) r101.invoke(r101, new Object[0]);
    L4:
        e = move-exception;
        throw new RuntimeException("Failed to get default instance for " + r100, e);
    }

    public static int hashCode(List<byte[]> r100) {
        Iterator<byte[]> r101 = r100.iterator();
        int r102 = 1;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = (r102 * 31) + hashCode(r101.next());
        goto L4
    L6:
        return r102;
    }

    public static int hashCodeByteBuffer(ByteBuffer r100) {
        if (r100.hasArray() == false) goto L9;
        int r101 = partialHash(r100.capacity(), r100.array(), r100.arrayOffset(), r100.capacity());
        if (r101 != 0) goto L8;
        return 1;
    L8:
        return r101;
    L9:
        int r102 = 4096;
        if (r100.capacity() > 4096) goto L13;
        r102 = r100.capacity();
    L13:
        byte[] r103 = new byte[r102];
        ByteBuffer r104 = r100.duplicate();
        r104.clear();
        int r105 = r100.capacity();
    L15:
        if (r104.remaining() <= 0) goto L21;
        if (r104.remaining() > r102) goto L19;
        int r106 = r104.remaining();
    L20:
        r104.get(r103, 0, r106);
        r105 = partialHash(r105, r103, 0, r106);
        goto L15
    L19:
        r106 = r102;
        goto L20
    L21:
        if (r105 != 0) goto L24;
        return 1;
    L24:
        return r105;
    }

    public static int hashEnum(EnumLite r100) {
        return r100.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> r100) {
        Iterator<? extends EnumLite> r101 = r100.iterator();
        int r102 = 1;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = (r102 * 31) + hashEnum(r101.next());
        goto L4
    L6:
        return r102;
    }

    public static boolean isValidUtf8(ByteString r100) {
        return r100.isValidUtf8();
    }

    public static String stringDefaultValue(String r100) {
        return new String(r100.getBytes(ISO_8859_1), UTF_8);
    }

    public static byte[] toByteArray(String r100) {
        return r100.getBytes(UTF_8);
    }

    public static String toStringUtf8(byte[] r100) {
        return new String(r100, UTF_8);
    }

    public static int hashCode(byte[] r100) {
        return hashCode(r100, 0, r100.length);
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> r100) {
        Iterator<ByteBuffer> r101 = r100.iterator();
        int r102 = 1;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = (r102 * 31) + hashCodeByteBuffer(r101.next());
        goto L4
    L6:
        return r102;
    }

    public static boolean isValidUtf8(byte[] r100) {
        return Utf8.isValidUtf8(r100);
    }

    public static <T> T checkNotNull(T r100, String r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(r101);
    }

    public static boolean equals(List<byte[]> r100, List<byte[]> r101) {
        if (r100.size() == r101.size()) goto L5;
        return false;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= r100.size()) goto L12;
        if (Arrays.equals((byte[]) ListProtector.get(r100, r102), (byte[]) ListProtector.get(r101, r102)) == false) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> r100, List<ByteBuffer> r101) {
        if (r100.size() == r101.size()) goto L5;
        return false;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= r100.size()) goto L12;
        if (equalsByteBuffer((ByteBuffer) ListProtector.get(r100, r102), (ByteBuffer) ListProtector.get(r101, r102)) == false) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static Object mergeMessage(Object r100, Object r101) {
        return ((MessageLite) r100).toBuilder().mergeFrom((MessageLite) r101).buildPartial();
    }

    public static boolean equalsByteBuffer(ByteBuffer r100, ByteBuffer r101) {
        if (r100.capacity() == r101.capacity()) goto L7;
        return false;
    L7:
        return r100.duplicate().clear().equals(r101.duplicate().clear());
    }

    public static int hashCode(byte[] r100, int r101, int r102) {
        int r103 = partialHash(r102, r100, r101, r102);
        if (r103 != 0) goto L6;
        return 1;
    L6:
        return r103;
    }

    public static int partialHash(int r100, byte[] r101, int r102, int r103) {
        int r104 = r102;
    L4:
        if (r104 >= (r102 + r103)) goto L6;
        r100 = (r100 * 31) + r101[r104];
        r104 = r104 + 1;
        goto L4
    L6:
        return r100;
    }
}
