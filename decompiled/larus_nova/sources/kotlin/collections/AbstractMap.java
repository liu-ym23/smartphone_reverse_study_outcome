package kotlin.collections;

import com.alipay.sdk.m.n.a;
import com.alipay.sdk.m.u.i;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b'\u0018\u0000 )*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001)B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0013\u001a\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\u0018\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\rH\u0016J#\u0010#\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001fH\u0002J\u001c\u0010&\u001a\u00020'2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016H\bR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0088\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006*"}, d2 = {"Lkotlin/collections/AbstractMap;", "K", "V", "", "()V", "_keys", "", "_values", "", "keys", "getKeys", "()Ljava/util/Set;", "size", "", "getSize", "()I", "values", "getValues", "()Ljava/util/Collection;", "containsEntry", "", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "isEmpty", "toString", "", "o", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractMap<K, V> implements Map<K, V>, KMappedMarker {
    public static final Companion Companion = null;
    private volatile Set<? extends K> _keys;
    private volatile Collection<? extends V> _values;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b\bJ\u001d\u0010\t\u001a\u00020\n2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0000¢\u0006\u0002\b\u000bJ\u001d\u0010\f\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0000¢\u0006\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/collections/AbstractMap$Companion;", "", "()V", "entryEquals", "", "e", "", "other", "entryEquals$kotlin_stdlib", "entryHashCode", "", "entryHashCode$kotlin_stdlib", "entryToString", "", "entryToString$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final int entryHashCode$kotlin_stdlib(Map.Entry<?, ?> r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            Object r101 = r100.getKey();
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            Object r104 = r100.getValue();
            if (r104 == null) goto L10;
            r102 = r104.hashCode();
        L10:
            return r103 ^ r102;
        L5:
            r103 = 0;
            goto L6
        }

        public final String entryToString$kotlin_stdlib(Map.Entry<?, ?> r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            StringBuilder r101 = new StringBuilder();
            r101.append(r100.getKey());
            r101.append(a.f25612h);
            r101.append(r100.getValue());
            return r101.toString();
        }

        public final boolean entryEquals$kotlin_stdlib(Map.Entry<?, ?> r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "e");
            if ((r101 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r102 = (Map.Entry) r101;
            if (Intrinsics.areEqual(r100.getKey(), r102.getKey()) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(r100.getValue(), r102.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract Set getEntries();

    @Override // java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public V put(K r100, V r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public V remove(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Set<K> getKeys() {
        if (this._keys != null) goto L5;
        this._keys = new AbstractMap$keys$1(this);
    L5:
        Set<? extends K> r100 = this._keys;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public Collection<V> getValues() {
        if (this._values != null) goto L5;
        this._values = new C123251(this);
    L5:
        Collection<? extends V> r100 = this._values;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public int getSize() {
        return entrySet().size();
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        return CollectionsKt.joinToString$default(entrySet(), ", ", "{", i.f25855d, 0, null, new AnonymousClass1(this), 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public AbstractMap() {
    }

    private final Map.Entry<K, V> implFindEntry(K r100) {
        Iterator<T> r101 = entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((Map.Entry) r102).getKey(), r100) == false) goto L4;
    L10:
        return (Map.Entry) r102;
    L8:
        r102 = null;
        goto L10
    }

    private final String toString(Map.Entry<? extends K, ? extends V> r100) {
        return toString(r100.getKey()) + a.f25612h + toString(r100.getValue());
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<?, ?> r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Object r101 = r100.getKey();
        Object r102 = r100.getValue();
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        V r103 = get(r101);
        if (Intrinsics.areEqual(r102, r103) == true) goto L8;
        return false;
    L8:
        if (r103 != null) goto L12;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
        if (containsKey(r101) == true) goto L14;
        return false;
    L14:
        return true;
    L12:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object r100) {
        if (implFindEntry(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object r100) {
        Set<Map.Entry<K, V>> r101 = entrySet();
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((Map.Entry) r102.next()).getValue(), r100) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return false;
    }

    @Override // java.util.Map
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Map) == true) goto L8;
        return false;
    L8:
        Map r101 = (Map) r100;
        if (size() == r101.size()) goto L11;
        return false;
    L11:
        Set<Map.Entry<K, V>> r102 = r101.entrySet();
        if ((r102 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r103 = r102.iterator();
    L18:
        if (r103.hasNext() == false) goto L27;
        if (containsEntry$kotlin_stdlib((Map.Entry) r103.next()) == true) goto L18;
        return false;
    L27:
        return true;
    L14:
        if (r102.isEmpty() == false) goto L16;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object r100) {
        Map.Entry<K, V> r101 = implFindEntry(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    }

    private final String toString(Object r100) {
        if (r100 != this) goto L5;
        return "(this Map)";
    L5:
        return String.valueOf(r100);
    }

    public static final /* synthetic */ String access$toString(AbstractMap r100, Map.Entry r101) {
        return r100.toString(r101);
    }
}
