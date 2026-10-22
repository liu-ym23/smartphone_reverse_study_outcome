package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public class MapField<K, V> implements MutabilityOracle {
    private final Converter<K, V> converter;
    private volatile boolean isMutable;
    private List<Message> listData;
    private MutatabilityAwareMap<K, V> mapData;
    private volatile StorageMode mode;

    public interface Converter<K, V> {
        Message convertKeyAndValueToMessage(K r100, V r101);

        void convertMessageToKeyAndValue(Message r100, Map<K, V> r101);

        Message getMessageDefaultInstance();
    }

    public static class ImmutableMessageConverter<K, V> implements Converter<K, V> {
        private final MapEntry<K, V> defaultEntry;

        @Override // com.google.protobuf.MapField.Converter
        public Message getMessageDefaultInstance() {
            return this.defaultEntry;
        }

        public ImmutableMessageConverter(MapEntry<K, V> r100) {
            this.defaultEntry = r100;
        }

        @Override // com.google.protobuf.MapField.Converter
        public Message convertKeyAndValueToMessage(K r100, V r101) {
            return this.defaultEntry.newBuilderForType().setKey(r100).setValue(r101).buildPartial();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MapField.Converter
        public void convertMessageToKeyAndValue(Message r100, Map<K, V> r101) {
            MapEntry r102 = (MapEntry) r100;
            r101.put(r102.getKey(), r102.getValue());
        }
    }

    public static class MutatabilityAwareMap<K, V> implements Map<K, V> {
        private final Map<K, V> delegate;
        private final MutabilityOracle mutabilityOracle;

        public static class MutatabilityAwareCollection<E> implements Collection<E> {
            private final Collection<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            @Override // java.util.Collection
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Collection
            public int hashCode() {
                return this.delegate.hashCode();
            }

            @Override // java.util.Collection
            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            @Override // java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new MutatabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
            }

            @Override // java.util.Collection
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Collection
            public Object[] toArray() {
                return this.delegate.toArray();
            }

            public String toString() {
                return this.delegate.toString();
            }

            @Override // java.util.Collection
            public boolean add(E r100) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean addAll(Collection<? extends E> r100) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean contains(Object r100) {
                return this.delegate.contains(r100);
            }

            @Override // java.util.Collection
            public boolean containsAll(Collection<?> r100) {
                return this.delegate.containsAll(r100);
            }

            @Override // java.util.Collection
            public boolean equals(Object r100) {
                return this.delegate.equals(r100);
            }

            @Override // java.util.Collection
            public boolean remove(Object r100) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(r100);
            }

            @Override // java.util.Collection
            public boolean removeAll(Collection<?> r100) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(r100);
            }

            @Override // java.util.Collection
            public boolean retainAll(Collection<?> r100) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(r100);
            }

            @Override // java.util.Collection
            public <T> T[] toArray(T[] r100) {
                return (T[]) this.delegate.toArray(r100);
            }

            public MutatabilityAwareCollection(MutabilityOracle r100, Collection<E> r101) {
                this.mutabilityOracle = r100;
                this.delegate = r101;
            }
        }

        public static class MutatabilityAwareIterator<E> implements Iterator<E> {
            private final Iterator<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.delegate.hasNext();
            }

            public int hashCode() {
                return this.delegate.hashCode();
            }

            @Override // java.util.Iterator
            public E next() {
                return this.delegate.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.remove();
            }

            public String toString() {
                return this.delegate.toString();
            }

            public boolean equals(Object r100) {
                return this.delegate.equals(r100);
            }

            public MutatabilityAwareIterator(MutabilityOracle r100, Iterator<E> r101) {
                this.mutabilityOracle = r100;
                this.delegate = r101;
            }
        }

        public static class MutatabilityAwareSet<E> implements Set<E> {
            private final Set<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            @Override // java.util.Set, java.util.Collection
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Set, java.util.Collection
            public int hashCode() {
                return this.delegate.hashCode();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new MutatabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
            }

            @Override // java.util.Set, java.util.Collection
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Set, java.util.Collection
            public Object[] toArray() {
                return this.delegate.toArray();
            }

            public String toString() {
                return this.delegate.toString();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean add(E r100) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.add(r100);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean addAll(Collection<? extends E> r100) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.addAll(r100);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean contains(Object r100) {
                return this.delegate.contains(r100);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean containsAll(Collection<?> r100) {
                return this.delegate.containsAll(r100);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean equals(Object r100) {
                return this.delegate.equals(r100);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean remove(Object r100) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(r100);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean removeAll(Collection<?> r100) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(r100);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean retainAll(Collection<?> r100) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(r100);
            }

            @Override // java.util.Set, java.util.Collection
            public <T> T[] toArray(T[] r100) {
                return (T[]) this.delegate.toArray(r100);
            }

            public MutatabilityAwareSet(MutabilityOracle r100, Set<E> r101) {
                this.mutabilityOracle = r100;
                this.delegate = r101;
            }
        }

        @Override // java.util.Map
        public void clear() {
            this.mutabilityOracle.ensureMutable();
            this.delegate.clear();
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new MutatabilityAwareSet(this.mutabilityOracle, this.delegate.entrySet());
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.delegate.hashCode();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.delegate.isEmpty();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            return new MutatabilityAwareSet(this.mutabilityOracle, this.delegate.keySet());
        }

        @Override // java.util.Map
        public int size() {
            return this.delegate.size();
        }

        public String toString() {
            return this.delegate.toString();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return new MutatabilityAwareCollection(this.mutabilityOracle, this.delegate.values());
        }

        @Override // java.util.Map
        public boolean containsKey(Object r100) {
            return this.delegate.containsKey(r100);
        }

        @Override // java.util.Map
        public boolean containsValue(Object r100) {
            return this.delegate.containsValue(r100);
        }

        @Override // java.util.Map
        public boolean equals(Object r100) {
            return this.delegate.equals(r100);
        }

        @Override // java.util.Map
        public V get(Object r100) {
            return this.delegate.get(r100);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> r100) {
            this.mutabilityOracle.ensureMutable();
            Iterator<? extends K> r101 = r100.keySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            K r102 = r101.next();
            Internal.checkNotNull(r102);
            Internal.checkNotNull(r100.get(r102));
            goto L4
        L6:
            this.delegate.putAll(r100);
        }

        @Override // java.util.Map
        public V remove(Object r100) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.remove(r100);
        }

        public MutatabilityAwareMap(MutabilityOracle r100, Map<K, V> r101) {
            this.mutabilityOracle = r100;
            this.delegate = r101;
        }

        @Override // java.util.Map
        public V put(K r100, V r101) {
            this.mutabilityOracle.ensureMutable();
            Internal.checkNotNull(r100);
            Internal.checkNotNull(r101);
            return this.delegate.put(r100, r101);
        }
    }

    public static final enum StorageMode extends java.lang.Enum<StorageMode> {
        private static final /* synthetic */ StorageMode[] $VALUES = null;
        public static final StorageMode BOTH = null;
        public static final StorageMode LIST = null;
        public static final StorageMode MAP = null;

        static {
            StorageMode r100 = new StorageMode("MAP", 0);
            MAP = r100;
            StorageMode r101 = new StorageMode("LIST", 1);
            LIST = r101;
            StorageMode r102 = new StorageMode("BOTH", 2);
            BOTH = r102;
            $VALUES = new StorageMode[]{r100, r101, r102};
        }

        public static StorageMode[] values() {
            return (StorageMode[]) $VALUES.clone();
        }

        public static StorageMode valueOf(String r100) {
            return (StorageMode) a.a(StorageMode.class, r100);
        }

        private StorageMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public void clear() {
        this.mapData = new MutatabilityAwareMap(this, new LinkedHashMap());
        this.mode = StorageMode.MAP;
    }

    public MapField<K, V> copy() {
        return new MapField(this.converter, StorageMode.MAP, MapFieldLite.copy(getMap()));
    }

    public List<Message> getList() {
        StorageMode r100 = this.mode;
        StorageMode r101 = StorageMode.MAP;
        if (r100 != r101) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mode != r101) goto L8;
        this.listData = convertMapToList(this.mapData);     // Catch: Throwable -> L10
        this.mode = StorageMode.BOTH;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return Collections.unmodifiableList(this.listData);
    }

    public Map<K, V> getMap() {
        StorageMode r100 = this.mode;
        StorageMode r101 = StorageMode.LIST;
        if (r100 != r101) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mode != r101) goto L8;
        this.mapData = convertListToMap(this.listData);     // Catch: Throwable -> L10
        this.mode = StorageMode.BOTH;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return Collections.unmodifiableMap(this.mapData);
    }

    public Message getMapEntryMessageDefaultInstance() {
        return this.converter.getMessageDefaultInstance();
    }

    public List<Message> getMutableList() {
        StorageMode r100 = this.mode;
        StorageMode r101 = StorageMode.LIST;
        if (r100 == r101) goto L9;
        if (this.mode != StorageMode.MAP) goto L7;
        this.listData = convertMapToList(this.mapData);
    L7:
        this.mapData = null;
        this.mode = r101;
    L9:
        return this.listData;
    }

    public Map<K, V> getMutableMap() {
        StorageMode r100 = this.mode;
        StorageMode r101 = StorageMode.MAP;
        if (r100 == r101) goto L9;
        if (this.mode != StorageMode.LIST) goto L7;
        this.mapData = convertListToMap(this.listData);
    L7:
        this.listData = null;
        this.mode = r101;
    L9:
        return this.mapData;
    }

    @Override // com.google.protobuf.MutabilityOracle
    public void ensureMutable() {
        if (isMutable() == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(getMap());
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    private MutatabilityAwareMap<K, V> convertListToMap(List<Message> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Message> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        convertMessageToKeyAndValue(r102.next(), r101);
        goto L4
    L7:
        return new MutatabilityAwareMap(this, r101);
    }

    private List<Message> convertMapToList(MutatabilityAwareMap<K, V> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<K, V>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<K, V> r103 = r102.next();
        r101.add(convertKeyAndValueToMessage(r103.getKey(), r103.getValue()));
        goto L4
    L6:
        return r101;
    }

    public static <K, V> MapField<K, V> emptyMapField(MapEntry<K, V> r100) {
        return new MapField(r100, StorageMode.MAP, Collections.emptyMap());
    }

    public static <K, V> MapField<K, V> newMapField(MapEntry<K, V> r100) {
        return new MapField(r100, StorageMode.MAP, new LinkedHashMap());
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof MapField) == true) goto L7;
        return false;
    L7:
        return MapFieldLite.equals(getMap(), ((MapField) r100).getMap());
    }

    public void mergeFrom(MapField<K, V> r100) {
        getMutableMap().putAll(MapFieldLite.copy(r100.getMap()));
    }

    private Message convertKeyAndValueToMessage(K r100, V r101) {
        return this.converter.convertKeyAndValueToMessage(r100, r101);
    }

    private void convertMessageToKeyAndValue(Message r100, Map<K, V> r101) {
        this.converter.convertMessageToKeyAndValue(r100, r101);
    }

    private MapField(Converter<K, V> r100, StorageMode r101, Map<K, V> r102) {
        this.converter = r100;
        this.isMutable = true;
        this.mode = r101;
        this.mapData = new MutatabilityAwareMap(this, r102);
        this.listData = null;
    }

    private MapField(MapEntry<K, V> r100, StorageMode r101, Map<K, V> r102) {
        this(new ImmutableMessageConverter(r100), r101, r102);
    }
}
