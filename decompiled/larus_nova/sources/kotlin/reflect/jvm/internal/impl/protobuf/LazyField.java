package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class LazyField extends LazyFieldLite {
    private final MessageLite defaultInstance;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.LazyField$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes42.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static class LazyEntry<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, LazyField> entry;

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.entry.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField r100 = this.entry.getValue();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getValue();
        }

        private LazyEntry(Map.Entry<K, LazyField> r100) {
            this.entry = r100;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object r100) {
            if ((r100 instanceof MessageLite) == false) goto L7;
            return this.entry.getValue().setValue((MessageLite) r100);
        L7:
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        public /* synthetic */ LazyEntry(Map.Entry r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> iterator;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> r100 = this.iterator.next();
            if ((r100.getValue() instanceof LazyField) == true) goto L5;
            return r100;
        L5:
            return new LazyEntry(r100, null);
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        public LazyIterator(Iterator<Map.Entry<K, Object>> r100) {
            this.iterator = r100;
        }
    }

    public MessageLite getValue() {
        return getValue(this.defaultInstance);
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue().toString();
    }

    public boolean equals(Object r100) {
        return getValue().equals(r100);
    }
}
