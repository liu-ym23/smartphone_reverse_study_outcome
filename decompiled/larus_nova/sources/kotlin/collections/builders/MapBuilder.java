package kotlin.collections.builders;

import com.alipay.sdk.m.n.a;
import com.alipay.sdk.m.u.i;
import com.byted.cast.common.TeaEventTrack;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import faceverify.w;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u0080\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005:\f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBE\b\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0002\u0010\u0012J\u0017\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00028\u0000H\u0000¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0002¢\u0006\u0002\u00108J\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:J\r\u0010;\u001a\u00020<H\u0000¢\u0006\u0002\b=J\b\u0010>\u001a\u00020<H\u0016J\b\u0010?\u001a\u00020<H\u0002J\u0019\u0010@\u001a\u00020!2\n\u0010A\u001a\u0006\u0012\u0002\b\u00030BH\u0000¢\u0006\u0002\bCJ!\u0010D\u001a\u00020!2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FH\u0000¢\u0006\u0002\bGJ\u0015\u0010H\u001a\u00020!2\u0006\u00104\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010IJ\u0015\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010IJ\u0018\u0010L\u001a\u00020!2\u000e\u0010M\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030:H\u0002J\u0010\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020\bH\u0002J\u0010\u0010P\u001a\u00020<2\u0006\u0010Q\u001a\u00020\bH\u0002J\u0019\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0000¢\u0006\u0002\bTJ\u0013\u0010U\u001a\u00020!2\b\u0010M\u001a\u0004\u0018\u00010VH\u0096\u0002J\u0015\u0010W\u001a\u00020\b2\u0006\u00104\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\u0015\u0010X\u001a\u00020\b2\u0006\u0010K\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00106J\u0018\u0010Y\u001a\u0004\u0018\u00018\u00012\u0006\u00104\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010ZJ\u0015\u0010[\u001a\u00020\b2\u0006\u00104\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\b\u0010\\\u001a\u00020\bH\u0016J\b\u0010]\u001a\u00020!H\u0016J\u0019\u0010^\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010_H\u0000¢\u0006\u0002\b`J\u001f\u0010a\u001a\u0004\u0018\u00018\u00012\u0006\u00104\u001a\u00028\u00002\u0006\u0010K\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010bJ\u001e\u0010c\u001a\u00020<2\u0014\u0010d\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:H\u0016J\"\u0010e\u001a\u00020!2\u0018\u0010d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010F0BH\u0002J\u001c\u0010f\u001a\u00020!2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FH\u0002J\u0010\u0010g\u001a\u00020!2\u0006\u0010h\u001a\u00020\bH\u0002J\b\u0010i\u001a\u00020<H\u0002J\u0010\u0010j\u001a\u00020<2\u0006\u0010k\u001a\u00020\bH\u0002J\u0017\u0010l\u001a\u0004\u0018\u00018\u00012\u0006\u00104\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010ZJ!\u0010m\u001a\u00020!2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FH\u0000¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020<2\u0006\u0010p\u001a\u00020\bH\u0002J\u0010\u0010q\u001a\u00020<2\u0006\u0010r\u001a\u00020\bH\u0002J\u0017\u0010s\u001a\u00020!2\u0006\u00104\u001a\u00028\u0000H\u0000¢\u0006\u0004\bt\u0010IJ\u0017\u0010u\u001a\u00020!2\u0006\u0010v\u001a\u00028\u0001H\u0000¢\u0006\u0004\bw\u0010IJ\u0010\u0010x\u001a\u00020!2\u0006\u0010y\u001a\u00020\bH\u0002J\b\u0010z\u001a\u00020{H\u0016J\u0019\u0010|\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010}H\u0000¢\u0006\u0002\b~J\b\u0010\u007f\u001a\u00020VH\u0002R\u0014\u0010\u0013\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u001e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001aR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0015R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u00101\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "length", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "capacity", "getCapacity$kotlin_stdlib", "()I", "entries", "", "", "getEntries", "()Ljava/util/Set;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "hashShift", "hashSize", "getHashSize", "<set-?>", "", "isReadOnly", "isReadOnly$kotlin_stdlib", "()Z", "keys", "getKeys", "[Ljava/lang/Object;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "modCount", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "addKey", "key", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "allocateValuesArray", "()[Ljava/lang/Object;", "build", "", "checkIsMutable", "", "checkIsMutable$kotlin_stdlib", "clear", "compact", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", OfficeSDKRequestTag.KEY_NEW_USER, "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "equals", "", "findKey", "findValue", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/Object;)Ljava/lang/Object;", w.BLOB_ELEM_IMAGE_HASHCODE, "hashCode", "isEmpty", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "putAllEntries", "putEntry", "putRehash", RXScreenCaptureService.KEY_INDEX, "registerModification", "rehash", "newHashSize", "remove", "removeEntry", "removeEntry$kotlin_stdlib", "removeEntryAt", "index", "removeHashAt", "removedHash", "removeKey", "removeKey$kotlin_stdlib", "removeValue", "element", "removeValue$kotlin_stdlib", "shouldCompact", "extraCapacity", "toString", "", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "writeReplace", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    public static final Companion Companion = null;
    private static final MapBuilder Empty = null;
    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    private static final int MAGIC = -1640531527;
    private static final int TOMBSTONE = -1;
    private MapBuilderEntries<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private MapBuilderKeys<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private MapBuilderValues<V> valuesView;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", "", "()V", "Empty", "Lkotlin/collections/builders/MapBuilder;", "", "getEmpty$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "INITIAL_CAPACITY", "", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final MapBuilder getEmpty$kotlin_stdlib() {
            return MapBuilder.access$getEmpty$cp();
        }

        private final int computeHashSize(int r100) {
            return Integer.highestOneBit(RangesKt.coerceAtLeast(r100, 1) * 3);
        }

        private final int computeShift(int r100) {
            return Integer.numberOfLeadingZeros(r100) + 1;
        }

        public static final /* synthetic */ int access$computeHashSize(Companion r100, int r101) {
            return r100.computeHashSize(r101);
        }

        public static final /* synthetic */ int access$computeShift(Companion r100, int r101) {
            return r100.computeShift(r101);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", TeaEventTrack.ACTION_DRAMA_NEXT, "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        @Override // java.util.Iterator
        public EntryRef<K, V> next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L7;
            int r100 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r100 + 1);
            setLastIndex$kotlin_stdlib(r100);
            EntryRef<K, V> r101 = new EntryRef(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
            initNext$kotlin_stdlib();
            return r101;
        L7:
            throw new NoSuchElementException();
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L14;
            int r100 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r100 + 1);
            setLastIndex$kotlin_stdlib(r100);
            Object r101 = MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            int r102 = 0;
            if (r101 == null) goto L7;
            int r103 = r101.hashCode();
        L8:
            Object[] r104 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(r104);
            Object r105 = r104[getLastIndex$kotlin_stdlib()];
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            int r106 = r103 ^ r102;
            initNext$kotlin_stdlib();
            return r106;
        L7:
            r103 = 0;
            goto L8
        L14:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        public EntriesItr(MapBuilder<K, V> r100) {
            Intrinsics.checkNotNullParameter(r100, "map");
            super(r100);
        }

        public final void nextAppendString(StringBuilder r100) {
            Intrinsics.checkNotNullParameter(r100, "sb");
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L15;
            int r101 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r101 + 1);
            setLastIndex$kotlin_stdlib(r101);
            Object r102 = MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            if (r102 != getMap$kotlin_stdlib()) goto L7;
            r100.append("(this Map)");
        L8:
            r100.append(a.f25612h);
            Object[] r103 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(r103);
            Object r104 = r103[getLastIndex$kotlin_stdlib()];
            if (r104 != getMap$kotlin_stdlib()) goto L11;
            r100.append("(this Map)");
        L12:
            initNext$kotlin_stdlib();
            return;
        L11:
            r100.append(r104);
            goto L12
        L7:
            r100.append(r102);
            goto L8
        L15:
            throw new NoSuchElementException();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0015\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "(Lkotlin/collections/builders/MapBuilder;I)V", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", "", "other", "", "hashCode", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final int index;
        private final MapBuilder<K, V> map;

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) MapBuilder.access$getKeysArray$p(this.map)[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] r100 = MapBuilder.access$getValuesArray$p(this.map);
            Intrinsics.checkNotNull(r100);
            return (V) r100[this.index];
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder();
            r100.append(getKey());
            r100.append(a.f25612h);
            r100.append(getValue());
            return r100.toString();
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r100 = getKey();
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            V r103 = getValue();
            if (r103 == null) goto L10;
            r101 = r103.hashCode();
        L10:
            return r102 ^ r101;
        L5:
            r102 = 0;
            goto L6
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L9;
            Map.Entry r101 = (Map.Entry) r100;
            if (Intrinsics.areEqual(r101.getKey(), getKey()) == false) goto L9;
            if (Intrinsics.areEqual(r101.getValue(), getValue()) == false) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r100) {
            this.map.checkIsMutable$kotlin_stdlib();
            Object[] r101 = MapBuilder.access$allocateValuesArray(this.map);
            int r102 = this.index;
            V r103 = (V) r101[r102];
            r101[r102] = r100;
            return r103;
        }

        public EntryRef(MapBuilder<K, V> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "map");
            this.map = r100;
            this.index = r101;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\r\u0010\u0018\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0019J\u0006\u0010\u001a\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "expectedModCount", "", "index", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "checkForComodification", "", "checkForComodification$kotlin_stdlib", "hasNext", "", "initNext", "initNext$kotlin_stdlib", "remove", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class Itr<K, V> {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final MapBuilder<K, V> map;

        public final void checkForComodification$kotlin_stdlib() {
            if (MapBuilder.access$getModCount$p(this.map) != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        public final boolean hasNext() {
            if (this.index >= MapBuilder.access$getLength$p(this.map)) goto L5;
            return true;
        L5:
            return false;
        }

        public final void initNext$kotlin_stdlib() {
        L3:
            if (this.index >= MapBuilder.access$getLength$p(this.map)) goto L7;
            int[] r100 = MapBuilder.access$getPresenceArray$p(this.map);
            int r101 = this.index;
            if (r100[r101] >= 0) goto L10;
            this.index = r101 + 1;
            goto L3
        L10:
            return;
        }

        public final void remove() {
            checkForComodification$kotlin_stdlib();
            if (this.lastIndex == (-1)) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L10;
            this.map.checkIsMutable$kotlin_stdlib();
            MapBuilder.access$removeEntryAt(this.map, this.lastIndex);
            this.lastIndex = -1;
            this.expectedModCount = MapBuilder.access$getModCount$p(this.map);
            return;
        L10:
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        L5:
            r100 = false;
            goto L6
        }

        public final int getIndex$kotlin_stdlib() {
            return this.index;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.lastIndex;
        }

        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }

        public Itr(MapBuilder<K, V> r100) {
            Intrinsics.checkNotNullParameter(r100, "map");
            this.map = r100;
            this.lastIndex = -1;
            this.expectedModCount = MapBuilder.access$getModCount$p(r100);
            initNext$kotlin_stdlib();
        }

        public final void setIndex$kotlin_stdlib(int r100) {
            this.index = r100;
        }

        public final void setLastIndex$kotlin_stdlib(int r100) {
            this.lastIndex = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        @Override // java.util.Iterator
        public K next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L7;
            int r100 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r100 + 1);
            setLastIndex$kotlin_stdlib(r100);
            K r101 = (K) MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return r101;
        L7:
            throw new NoSuchElementException();
        }

        public KeysItr(MapBuilder<K, V> r100) {
            Intrinsics.checkNotNullParameter(r100, "map");
            super(r100);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {
        @Override // java.util.Iterator
        public V next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L7;
            int r100 = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(r100 + 1);
            setLastIndex$kotlin_stdlib(r100);
            Object[] r101 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(r101);
            V r102 = (V) r101[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return r102;
        L7:
            throw new NoSuchElementException();
        }

        public ValuesItr(MapBuilder<K, V> r100) {
            Intrinsics.checkNotNullParameter(r100, "map");
            super(r100);
        }
    }

    static {
        Companion = new Companion(null);
        MapBuilder r100 = new MapBuilder(0);
        r100.isReadOnly = true;
        Empty = r100;
    }

    public MapBuilder() {
        this(8);
    }

    private final V[] allocateValuesArray() {
        V[] r100 = this.valuesArray;
        if (r100 == null) goto L5;
        return r100;
    L5:
        V[] r101 = (V[]) ListBuilderKt.arrayOfUninitializedElements(getCapacity$kotlin_stdlib());
        this.valuesArray = r101;
        return r101;
    }

    private final void compact() {
        V[] r100 = this.valuesArray;
        int r101 = 0;
        int r102 = 0;
    L3:
        int r103 = this.length;
        if (r101 >= r103) goto L12;
        if (this.presenceArray[r101] < 0) goto L11;
        K[] r104 = this.keysArray;
        r104[r102] = r104[r101];
        if (r100 == null) goto L10;
        r100[r102] = r100[r101];
    L10:
        r102 = r102 + 1;
    L11:
        r101 = r101 + 1;
        goto L3
    L12:
        ListBuilderKt.resetRange(this.keysArray, r102, r103);
        if (r100 == null) goto L15;
        ListBuilderKt.resetRange(r100, r102, this.length);
    L15:
        this.length = r102;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final void registerModification() {
        this.modCount++;
    }

    private final Object writeReplace() {
        if (this.isReadOnly == false) goto L7;
        return new SerializedMap(this);
    L7:
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr(this);
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> r100 = this.entriesView;
        if (r100 != null) goto L6;
        MapBuilderEntries<K, V> r101 = new MapBuilderEntries(this);
        this.entriesView = r101;
        return r101;
    L6:
        return r100;
    }

    public Set<K> getKeys() {
        MapBuilderKeys<K> r100 = this.keysView;
        if (r100 != null) goto L6;
        MapBuilderKeys<K> r101 = new MapBuilderKeys(this);
        this.keysView = r101;
        return r101;
    L6:
        return r100;
    }

    public Collection<V> getValues() {
        MapBuilderValues<V> r100 = this.valuesView;
        if (r100 != null) goto L6;
        MapBuilderValues<V> r101 = new MapBuilderValues(this);
        this.valuesView = r101;
        return r101;
    L6:
        return r100;
    }

    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr(this);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder((size() * 3) + 2);
        r100.append("{");
        EntriesItr<K, V> r101 = entriesIterator$kotlin_stdlib();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r102 <= 0) goto L7;
        r100.append(", ");
    L7:
        r101.nextAppendString(r100);
        r102 = r102 + 1;
        goto L4
    L8:
        r100.append(i.f25855d);
        return r100.toString();
    }

    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr(this);
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) goto L7;
        MapBuilder r100 = Empty;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return r100;
    L7:
        return this;
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int r100 = this.length - 1;
        if (r100 < 0) goto L10;
        int r101 = 0;
    L5:
        int[] r102 = this.presenceArray;
        int r103 = r102[r101];
        if (r103 < 0) goto L8;
        this.hashArray[r103] = 0;
        r102[r101] = -1;
    L8:
        if (r101 == r100) goto L10;
        r101 = r101 + 1;
    L10:
        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        V[] r104 = this.valuesArray;
        if (r104 == null) goto L13;
        ListBuilderKt.resetRange(r104, 0, this.length);
    L13:
        this.size = 0;
        this.length = 0;
        registerModification();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public int hashCode() {
        EntriesItr<K, V> r100 = entriesIterator$kotlin_stdlib();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + r100.nextHashCode$kotlin_stdlib();
        goto L4
    L6:
        return r101;
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

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public static final /* synthetic */ MapBuilder access$getEmpty$cp() {
        return Empty;
    }

    public int getSize() {
        return this.size;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    public MapBuilder(int r100) {
        this(ListBuilderKt.arrayOfUninitializedElements(r100), null, new int[r100], new int[Companion.access$computeHashSize(Companion, r100)], 2, 0);
    }

    public static final /* synthetic */ Object[] access$allocateValuesArray(MapBuilder r100) {
        return r100.allocateValuesArray();
    }

    public static final /* synthetic */ Object[] access$getKeysArray$p(MapBuilder r100) {
        return r100.keysArray;
    }

    public static final /* synthetic */ int access$getLength$p(MapBuilder r100) {
        return r100.length;
    }

    public static final /* synthetic */ int access$getModCount$p(MapBuilder r100) {
        return r100.modCount;
    }

    public static final /* synthetic */ int[] access$getPresenceArray$p(MapBuilder r100) {
        return r100.presenceArray;
    }

    public static final /* synthetic */ Object[] access$getValuesArray$p(MapBuilder r100) {
        return r100.valuesArray;
    }

    private final boolean contentEquals(Map<?, ?> r100) {
        if (size() == r100.size()) goto L5;
    L7:
        return false;
    L5:
        if (containsAllEntries$kotlin_stdlib(r100.entrySet()) == false) goto L7;
        return true;
    }

    private final void ensureCapacity(int r100) {
        if (r100 < 0) goto L14;
        if (r100 <= getCapacity$kotlin_stdlib()) goto L15;
        int r101 = AbstractList.Companion.newCapacity$kotlin_stdlib(getCapacity$kotlin_stdlib(), r100);
        this.keysArray = (K[]) ListBuilderKt.copyOfUninitializedElements(this.keysArray, r101);
        V[] r102 = this.valuesArray;
        if (r102 == null) goto L8;
        V[] r103 = (V[]) ListBuilderKt.copyOfUninitializedElements(r102, r101);
    L9:
        this.valuesArray = r103;
        this.presenceArray = Arrays.copyOf(this.presenceArray, r101);
        int r104 = Companion.access$computeHashSize(Companion, r101);
        if (r104 <= getHashSize()) goto L16;
        rehash(r104);
        return;
    L16:
        return;
    L8:
        r103 = null;
        goto L9
    L15:
        return;
    L14:
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int r100) {
        if (shouldCompact(r100) == false) goto L5;
        rehash(getHashSize());
        return;
    L5:
        ensureCapacity(this.length + r100);
    }

    private final int findKey(K r100) {
        int r101 = hash(r100);
        int r102 = this.maxProbeDistance;
    L3:
        int r103 = this.hashArray[r101];
        if (r103 == 0) goto L5;
        if (r103 <= 0) goto L10;
        int r104 = r103 - 1;
        if (Intrinsics.areEqual(this.keysArray[r104], r100) == false) goto L10;
        return r104;
    L10:
        r102 = r102 - 1;
        if (r102 < 0) goto L12;
        int r105 = r101 - 1;
        if (r101 == 0) goto L15;
        r101 = r105;
        goto L3
    L15:
        r101 = getHashSize() - 1;
        goto L3
    L12:
        return -1;
    L5:
        return -1;
    }

    private final int findValue(V r100) {
        int r101 = this.length;
    L3:
        r101 = r101 - 1;
        if (r101 < 0) goto L10;
        if (this.presenceArray[r101] < 0) goto L3;
        V[] r102 = this.valuesArray;
        Intrinsics.checkNotNull(r102);
        if (Intrinsics.areEqual(r102[r101], r100) == false) goto L3;
        return r101;
    L10:
        return -1;
    }

    private final int hash(K r100) {
        if (r100 == null) goto L4;
        int r101 = r100.hashCode();
    L6:
        return (r101 * MAGIC) >>> this.hashShift;
    L4:
        r101 = 0;
        goto L6
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> r100) {
        boolean r101 = false;
        if (r100.isEmpty() == false) goto L5;
        return false;
    L5:
        ensureExtraCapacity(r100.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        if (putEntry(r102.next()) == false) goto L7;
        r101 = true;
        goto L7
    L11:
        return r101;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> r100) {
        int r101 = addKey$kotlin_stdlib(r100.getKey());
        V[] r102 = allocateValuesArray();
        if (r101 < 0) goto L6;
        r102[r101] = r100.getValue();
        return true;
    L6:
        int r103 = (-r101) - 1;
        V r104 = r102[r103];
        if (Intrinsics.areEqual(r100.getValue(), r104) == true) goto L10;
        r102[r103] = r100.getValue();
        return true;
    L10:
        return false;
    }

    private final boolean putRehash(int r100) {
        int r101 = hash(this.keysArray[r100]);
        int r102 = this.maxProbeDistance;
    L3:
        int[] r103 = this.hashArray;
        if (r103[r101] == 0) goto L5;
        r102 = r102 - 1;
        if (r102 < 0) goto L9;
        int r104 = r101 - 1;
        if (r101 == 0) goto L13;
        r101 = r104;
        goto L3
    L13:
        r101 = getHashSize() - 1;
        goto L3
    L9:
        return false;
    L5:
        r103[r101] = r100 + 1;
        this.presenceArray[r100] = r101;
        return true;
    }

    private final void rehash(int r100) {
        registerModification();
        if (this.length <= size()) goto L5;
        compact();
    L5:
        int r101 = 0;
        if (r100 == getHashSize()) goto L8;
        this.hashArray = new int[r100];
        this.hashShift = Companion.access$computeShift(Companion, r100);
    L10:
        if (r101 >= this.length) goto L16;
        int r102 = r101 + 1;
        if (putRehash(r101) == false) goto L15;
        r101 = r102;
        goto L10
    L15:
        throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
    L16:
        return;
    L8:
        ArraysKt.fill(this.hashArray, 0, 0, getHashSize());
        goto L10
    }

    private final void removeEntryAt(int r100) {
        ListBuilderKt.resetAt(this.keysArray, r100);
        V[] r101 = this.valuesArray;
        if (r101 == null) goto L5;
        ListBuilderKt.resetAt(r101, r100);
    L5:
        removeHashAt(this.presenceArray[r100]);
        this.presenceArray[r100] = -1;
        this.size = size() - 1;
        registerModification();
    }

    private final void removeHashAt(int r110) {
        int r100 = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
        int r101 = 0;
        int r102 = r110;
    L3:
        int r103 = r110 - 1;
        if (r110 != 0) goto L6;
        r110 = getHashSize() - 1;
    L7:
        r101 = r101 + 1;
        if (r101 > this.maxProbeDistance) goto L9;
        int[] r104 = this.hashArray;
        int r105 = r104[r110];
        if (r105 == 0) goto L13;
        if (r105 >= 0) goto L19;
        r104[r102] = -1;
    L18:
        r102 = r110;
        r101 = 0;
    L22:
        r100 = r100 - 1;
        if (r100 >= 0) goto L3;
        this.hashArray[r102] = -1;
        return;
    L19:
        int r106 = r105 - 1;
        if (((hash(this.keysArray[r106]) - r110) & (getHashSize() - 1)) < r101) goto L22;
        this.hashArray[r102] = r105;
        this.presenceArray[r106] = r102;
        goto L18
    L13:
        r104[r102] = 0;
        return;
    L9:
        this.hashArray[r102] = 0;
        return;
    L6:
        r110 = r103;
        goto L7
    }

    private final boolean shouldCompact(int r100) {
        int r101 = getCapacity$kotlin_stdlib();
        int r102 = this.length;
        int r103 = r101 - r102;
        int r104 = r102 - size();
        if (r103 < r100) goto L5;
    L9:
        return false;
    L5:
        if ((r103 + r104) < r100) goto L9;
        if (r104 < (getCapacity$kotlin_stdlib() / 4)) goto L9;
        return true;
    }

    public final int addKey$kotlin_stdlib(K r100) {
        checkIsMutable$kotlin_stdlib();
    L3:
        int r101 = hash(r100);
        int r102 = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
        int r103 = 0;
    L4:
        int r104 = this.hashArray[r101];
        if (r104 <= 0) goto L7;
        if (Intrinsics.areEqual(this.keysArray[r104 - 1], r100) == true) goto L16;
        r103 = r103 + 1;
        if (r103 > r102) goto L19;
        int r105 = r101 - 1;
        if (r101 == 0) goto L22;
        r101 = r105;
        goto L4
    L22:
        r101 = getHashSize() - 1;
        goto L4
    L19:
        rehash(getHashSize() * 2);
        goto L3
    L16:
        return -r104;
    L7:
        if (this.length < getCapacity$kotlin_stdlib()) goto L9;
        ensureExtraCapacity(1);
        goto L3
    L9:
        int r106 = this.length;
        int r107 = r106 + 1;
        this.length = r107;
        this.keysArray[r106] = r100;
        this.presenceArray[r106] = r101;
        this.hashArray[r101] = r107;
        this.size = size() + 1;
        registerModification();
        if (r103 <= this.maxProbeDistance) goto L12;
        this.maxProbeDistance = r103;
    L12:
        return r106;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "m");
        Iterator<?> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        if (r102 == null) goto L9;
        if (containsEntry$kotlin_stdlib((Map.Entry) r102) == true) goto L4;
    L9:
        return false;
    L10:
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        int r101 = findKey(r100.getKey());
        if (r101 >= 0) goto L6;
        return false;
    L6:
        V[] r102 = this.valuesArray;
        Intrinsics.checkNotNull(r102);
        return Intrinsics.areEqual(r102[r101], r100.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object r100) {
        if (findKey(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object r100) {
        if (findValue(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean equals(Object r100) {
        if (r100 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r100 instanceof Map) == true) goto L6;
    L8:
        return false;
    L6:
        if (contentEquals((Map) r100) == false) goto L8;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object r100) {
        int r101 = findKey(r100);
        if (r101 >= 0) goto L6;
        return null;
    L6:
        V[] r102 = this.valuesArray;
        Intrinsics.checkNotNull(r102);
        return r102[r101];
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(r100.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object r100) {
        checkIsMutable$kotlin_stdlib();
        int r101 = findKey(r100);
        if (r101 >= 0) goto L6;
        return null;
    L6:
        V[] r102 = this.valuesArray;
        Intrinsics.checkNotNull(r102);
        V r103 = r102[r101];
        removeEntryAt(r101);
        return r103;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        checkIsMutable$kotlin_stdlib();
        int r101 = findKey(r100.getKey());
        if (r101 >= 0) goto L5;
        return false;
    L5:
        V[] r102 = this.valuesArray;
        Intrinsics.checkNotNull(r102);
        if (Intrinsics.areEqual(r102[r101], r100.getValue()) == true) goto L8;
        return false;
    L8:
        removeEntryAt(r101);
        return true;
    }

    public final boolean removeKey$kotlin_stdlib(K r100) {
        checkIsMutable$kotlin_stdlib();
        int r101 = findKey(r100);
        if (r101 >= 0) goto L6;
        return false;
    L6:
        removeEntryAt(r101);
        return true;
    }

    public final boolean removeValue$kotlin_stdlib(V r100) {
        checkIsMutable$kotlin_stdlib();
        int r101 = findValue(r100);
        if (r101 >= 0) goto L6;
        return false;
    L6:
        removeEntryAt(r101);
        return true;
    }

    public static final /* synthetic */ void access$removeEntryAt(MapBuilder r100, int r101) {
        r100.removeEntryAt(r101);
    }

    @Override // java.util.Map
    public V put(K r100, V r101) {
        checkIsMutable$kotlin_stdlib();
        int r102 = addKey$kotlin_stdlib(r100);
        V[] r103 = allocateValuesArray();
        if (r102 >= 0) goto L6;
        int r104 = (-r102) - 1;
        V r105 = r103[r104];
        r103[r104] = r101;
        return r105;
    L6:
        r103[r102] = r101;
        return null;
    }

    private MapBuilder(K[] r100, V[] r101, int[] r102, int[] r103, int r104, int r105) {
        this.keysArray = r100;
        this.valuesArray = r101;
        this.presenceArray = r102;
        this.hashArray = r103;
        this.maxProbeDistance = r104;
        this.length = r105;
        this.hashShift = Companion.access$computeShift(Companion, getHashSize());
    }
}
