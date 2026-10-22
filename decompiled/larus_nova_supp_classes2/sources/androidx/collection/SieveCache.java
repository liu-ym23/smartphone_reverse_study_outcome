package androidx.collection;

import androidx.autofill.HintConstants;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002Bâ\u0001\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u00128\b\u0002\u0010\u0007\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\b\u0012%\b\u0002\u0010\r\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000e\u0012d\b\u0002\u0010\u000f\u001a^\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u00104\u001a\u00020\u0013J\u0006\u00105\u001a\u00020\u0013J\u0006\u00106\u001a\u00020\u0013J\u0006\u00107\u001a\u00020\u0013J\u0010\u00108\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u00109\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u0005H\u0002J\b\u0010:\u001a\u00020\u0015H\u0002J\u0018\u0010;\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010<J\u001e\u0010=\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H\u0086\n¢\u0006\u0002\u0010>J\u001d\u0010?\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001¢\u0006\u0002\u0010@J'\u0010A\u001a\u00020\u00152\u001a\u0010B\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0\u001d¢\u0006\u0002\u0010DJ \u0010A\u001a\u00020\u00152\u0018\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0EJ \u0010A\u001a\u00020\u00152\u0018\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0FJ\u001a\u0010A\u001a\u00020\u00152\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010HJ\u001a\u0010A\u001a\u00020\u00152\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010IJ\u001a\u0010A\u001a\u00020\u00152\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000J\u001d\u0010J\u001a\u00020\u00152\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010CH\u0086\nJ*\u0010J\u001a\u00020\u00152\u001a\u0010B\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0\u001dH\u0086\n¢\u0006\u0002\u0010DJ#\u0010J\u001a\u00020\u00152\u0018\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0EH\u0086\nJ#\u0010J\u001a\u00020\u00152\u0018\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0FH\u0086\nJ\u001d\u0010J\u001a\u00020\u00152\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010HH\u0086\nJ\u001d\u0010J\u001a\u00020\u00152\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010IH\u0086\nJ\u001d\u0010J\u001a\u00020\u00152\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0086\nJ\u0015\u0010L\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010<J\u001b\u0010L\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001¢\u0006\u0002\u0010MJ \u0010N\u001a\u00020\u00152\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00130\bJ\u0016\u0010P\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010QJ\u001e\u0010P\u001a\u00020\u00152\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001dH\u0086\n¢\u0006\u0002\u0010RJ\u0017\u0010P\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000EH\u0086\nJ\u0017\u0010P\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000FH\u0086\nJ\u0017\u0010P\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000SH\u0086\nJ\u0017\u0010P\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000TH\u0086\nJ\u0006\u0010U\u001a\u00020\u0015J\u0010\u0010V\u001a\u00020\u00152\b\b\u0001\u0010\u0004\u001a\u00020\u0005J\u000e\u0010W\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005JD\u0010X\u001a\u00020\u001526\u0010Y\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00150\bH\u0086\bø\u0001\u0000J/\u0010Z\u001a\u00020\u00152!\u0010Y\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00150\u000eH\u0086\bø\u0001\u0000J/\u0010[\u001a\u00020\u00152!\u0010Y\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00150\u000eH\u0086\bø\u0001\u0000J&\u0010\\\u001a\u00020\u00132\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00130\bH\u0086\bø\u0001\u0000J&\u00104\u001a\u00020\u00132\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00130\bH\u0086\bø\u0001\u0000J\u0006\u0010/\u001a\u00020\u0005J&\u0010/\u001a\u00020\u00052\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00130\bH\u0086\bø\u0001\u0000J\u0016\u0010]\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010^J\u0013\u0010_\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010^J\u0013\u0010`\u001a\u00020\u00132\u0006\u0010\f\u001a\u00028\u0001¢\u0006\u0002\u0010^J\b\u0010a\u001a\u00020\u0005H\u0002J\u0011\u0010b\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u0005H\u0082\bJ\u0017\u0010d\u001a\u0004\u0018\u00018\u00012\u0006\u0010c\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010eJ\u0011\u0010f\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u0005H\u0082\bJ\u0011\u0010g\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u0005H\u0082\bJ\u0015\u0010h\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010iJ\u0015\u0010j\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010iJ\u0010\u0010k\u001a\u00020\u00052\u0006\u0010l\u001a\u00020\u0005H\u0002J\r\u0010m\u001a\u00020\u0015H\u0000¢\u0006\u0002\bnJ\r\u0010o\u001a\u00020\u0015H\u0000¢\u0006\u0002\bpJ\u0015\u0010q\u001a\u00020\u00152\u0006\u0010r\u001a\u00020\u0005H\u0000¢\u0006\u0002\bsJ\u0010\u0010t\u001a\u00020\u00152\u0006\u0010u\u001a\u00020\u0019H\u0002J\u0010\u0010t\u001a\u00020\u00152\u0006\u0010u\u001a\u00020vH\u0002J/\u0010w\u001a\u00020\u00152!\u0010Y\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020\u00150\u000eH\u0081\bø\u0001\u0000J\b\u0010x\u001a\u00020\u0005H\u0016J\u0013\u0010y\u001a\u00020\u00132\b\u0010z\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010{\u001a\u00020|H\u0016R>\u0010\u0007\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000Rj\u0010\u000f\u001a^\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u00020\u00198\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001d8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u001f\u0012\u0004\b\u001e\u0010\u001bR\"\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001d8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u001f\u0012\u0004\b!\u0010\u001bR\u000e\u0010\"\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b.\u0010-R\u001a\u0010/\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010-R\u0011\u00102\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b3\u0010-\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006}"}, d2 = {"Landroidx/collection/SieveCache;", "K", "", "V", "maxSize", "", "initialCapacity", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "key", "value", "createValueFromKey", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "oldValue", "newValue", "", "evicted", "", "<init>", "(IILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "metadata", "", "getMetadata$annotations", "()V", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", "values", "getValues$annotations", "nodes", "_capacity", "growthLimit", "_count", "_maxSize", "_size", "head", "tail", "hand", "size", "getSize", "()I", "getMaxSize", "count", "getCount$annotations", "getCount", "capacity", "getCapacity", "any", "none", "isEmpty", "isNotEmpty", "initializeStorage", "initializeMetadata", "initializeGrowth", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "pairs", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "", "Lkotlin/sequences/Sequence;", "from", "", "Landroidx/collection/ScatterMap;", "plusAssign", "pair", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeIf", "predicate", "minusAssign", "(Ljava/lang/Object;)V", "([Ljava/lang/Object;)V", "Landroidx/collection/ScatterSet;", "Landroidx/collection/ObjectList;", "evictAll", "resize", "trimToSize", "forEach", "block", "forEachKey", "forEachValue", "all", "contains", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "findEvictionCandidate", "moveNodeToHead", "index", "removeValueAt", "(I)Ljava/lang/Object;", "removeNode", "markNodeVisited", "findKeyIndex", "(Ljava/lang/Object;)I", "findInsertIndex", "findFirstAvailableSlot", "hash1", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "fixupNodes", "mapping", "", "forEachIndexed", "hashCode", "equals", "other", "toString", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SieveCache<K, V> {
    private int _capacity;
    private int _count;
    private int _maxSize;
    private int _size;
    private final Function1<K, V> createValueFromKey;
    private int growthLimit;
    private int hand;
    private int head;
    public Object[] keys;
    public long[] metadata;
    private long[] nodes;
    private final Function4<K, V, V, Boolean, Unit> onEntryRemoved;
    private final Function2<K, V, Integer> sizeOf;
    private int tail;
    public Object[] values;

    private static final int _init_$lambda$0(Object r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        return 1;
    }

    public static /* synthetic */ int a(Object r0, Object r1) {
        return _init_$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit b(Object r0, Object r1, Object r2, boolean r3) {
        return _init_$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void getCount$annotations() {
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    private final int findEvictionCandidate() {
        long[] r0 = this.nodes;
        int r1 = this.hand;
        int r2 = Integer.MAX_VALUE;
        if (r1 != Integer.MAX_VALUE) goto L7;
        r1 = this.tail;
    L7:
        if (r1 == Integer.MAX_VALUE) goto L14;
        long r6 = r0[r1];
        if (((int) ((r6 >> 62) & 1)) == 0) goto L14;
        int r4 = (int) (SieveCacheKt.NodeLinkMask & (r6 >> 31));
        r0[r1] = r6 & 4611686018427387903L;
        if (r4 != Integer.MAX_VALUE) goto L12;
        r1 = this.tail;
        goto L7
    L12:
        r1 = r4;
    L14:
        int r3 = (int) (SieveCacheKt.NodeLinkMask & (r0[r1] >> 31));
        if (r3 == Integer.MAX_VALUE) goto L17;
        r2 = r3;
    L17:
        this.hand = r2;
        return r1;
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - getCount();
    }

    public final void adjustStorage$collection() {
        if (this._capacity > 8) goto L5;
    L7:
        resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
        return;
    L5:
        if (Long.compare(ULong.constructor-impl(ULong.constructor-impl(getCount()) * 32) ^ Long.MIN_VALUE, ULong.constructor-impl(ULong.constructor-impl(this._capacity) * 25) ^ Long.MIN_VALUE) > 0) goto L7;
        dropDeletes$collection();
    }

    public final boolean any() {
        if (this._count == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void dropDeletes$collection() {
        long[] r1 = this.metadata;
        if (r1 != null) goto L5;
        return;
    L5:
        int r2 = this._capacity;
        Object[] r3 = this.keys;
        Object[] r4 = this.values;
        long[] r5 = this.nodes;
        long[] r6 = new long[r2];
        ArraysKt.fill(r6, SieveCacheKt.InvalidMapping, 0, r2);
        int r10 = (r2 + 7) >> 3;
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L8;
        long r12 = r1[r11] & (-9187201950435737472L);
        r1[r11] = (-72340172838076674L) & ((~r12) + (r12 >>> 7));
        r11 = r11 + 1;
        goto L6
    L8:
        int r13 = ArraysKt.getLastIndex(r1);
        int r14 = r13 - 1;
        r1[r14] = (r1[r14] & 72057594037927935L) | (-72057594037927936L);
        r1[r13] = r1[0];
        int r15 = 0;
    L9:
        if (r15 == r2) goto L40;
        int r16 = r15 >> 3;
        int r17 = (r15 & 7) << 3;
        long r18 = (r1[r16] >> r17) & 255;
        if (r18 == 128) goto L12;
        if (r18 != 254) goto L12;
        Object r19 = r3[r15];
        if (r19 == null) goto L19;
        int r110 = r19.hashCode();
    L20:
        int r111 = r110 * ScatterMapKt.MurmurHashC1;
        int r112 = r111 ^ (r111 << 16);
        int r113 = r112 >>> 7;
        int r9 = findFirstAvailableSlot(r113);
        int r114 = r113 & r2;
        if ((((r9 - r114) & r2) / 8) != (((r15 - r114) & r2) / 8)) goto L27;
        Object[] r20 = r4;
        long[] r23 = r5;
        r1[r16] = (r1[r16] & (~(255 << r17))) | (((long) (r112 & 127)) << r17);
        if (r6[r15] != SieveCacheKt.InvalidMapping) goto L25;
        long r7 = r15;
        r6[r15] = r7 | (r7 << 32);
    L25:
        r1[r1.length - 1] = r1[0];
        r15 = r15 + 1;
        r4 = r20;
        r5 = r23;
        goto L9
    L27:
        Object[] r21 = r4;
        long[] r24 = r5;
        int r8 = r9 >> 3;
        long r22 = r1[r8];
        int r25 = (r9 & 7) << 3;
        if (((r22 >> r25) & 255) != 128) goto L34;
        r1[r8] = ((r112 & 127) << r25) | (r22 & (~(255 << r25)));
        r1[r16] = (r1[r16] & (~(255 << r17))) | (128 << r17);
        r3[r9] = r3[r15];
        r3[r15] = null;
        r21[r9] = r21[r15];
        r21[r15] = null;
        r24[r9] = r24[r15];
        r24[r15] = 4611686018427387903L;
        int r26 = (int) ((r6[r15] >> 32) & 4294967295L);
        if (r26 == Integer.MAX_VALUE) goto L32;
        r6[r26] = (r6[r26] & (-4294967296L)) | ((long) r9);
        r6[r15] = (r6[r15] & 4294967295L) | (-4294967296L);
        char r27 = ' ';
    L33:
        r6[r9] = Integer.MAX_VALUE | (((long) r15) << r27);
    L39:
        r1[r1.length - 1] = r1[0];
        r15 = r15 + 1;
        r4 = r21;
        r5 = r24;
        goto L9
    L32:
        r27 = ' ';
        r6[r15] = (((long) Integer.MAX_VALUE) << 32) | ((long) r9);
        goto L33
    L34:
        r1[r8] = (((long) (r112 & 127)) << r25) | (r22 & (~(255 << r25)));
        Object r28 = r3[r9];
        r3[r9] = r3[r15];
        r3[r15] = r28;
        Object r29 = r21[r9];
        r21[r9] = r21[r15];
        r21[r15] = r29;
        long r30 = r24[r9];
        r24[r9] = r24[r15];
        r24[r15] = r30;
        int r31 = (int) ((r6[r15] >> 32) & 4294967295L);
        if (r31 == Integer.MAX_VALUE) goto L37;
        long r115 = r9;
        r6[r31] = (r6[r31] & (-4294967296L)) | r115;
        r6[r15] = (r6[r15] & 4294967295L) | (r115 << 32);
    L38:
        r6[r9] = (((long) r31) << 32) | ((long) r15);
        r15 = r15 - 1;
        goto L39
    L37:
        long r32 = r9;
        r6[r15] = r32 | (r32 << 32);
        r31 = r15;
        goto L38
    L19:
        r110 = 0;
    L12:
        r15 = r15 + 1;
        goto L9
    L40:
        initializeGrowth();
        fixupNodes(r6);
    }

    public int hashCode() {
        Object[] r1 = this.keys;
        Object[] r2 = this.values;
        long[] r3 = this.metadata;
        int r4 = r3.length - 2;
        int r5 = 0;
        if (r4 < 0) goto L21;
        int r6 = 0;
        int r7 = 0;
    L5:
        long r8 = r3[r6];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r10 = 8 - ((~(r6 - r4)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L16;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L15;
        int r14 = (r6 << 3) + r12;
        Object r15 = r1[r14];
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r16 = r2[r14];
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        r7 = r7 + (r16.hashCode() ^ r15.hashCode());
    L15:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L16:
        if (r10 == 8) goto L17;
        return r7;
    L17:
        if (r6 == r4) goto L19;
        r6 = r6 + 1;
        goto L5
    L19:
        r5 = r7;
    L21:
        return r5;
    }

    public final boolean isEmpty() {
        if (this._count != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._count == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean none() {
        if (this._count != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "SieveCache[maxSize=" + this._maxSize + ", size=" + this._size + ", capacity=" + this._capacity + ", count=" + this._count + ']';
    }

    public final int count() {
        return getSize();
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getCount() {
        return this._count;
    }

    public final int getMaxSize() {
        return this._maxSize;
    }

    public final int getSize() {
        return this._size;
    }

    private final int findFirstAvailableSlot(int r10) {
        int r0 = this._capacity;
        int r11 = r10 & r0;
        int r1 = 0;
    L3:
        long[] r2 = this.metadata;
        int r3 = r11 >> 3;
        int r4 = (r11 & 7) << 3;
        long r5 = ((r2[r3 + 1] << (64 - r4)) & ((-r4) >> 63)) | (r2[r3] >>> r4);
        long r6 = (r5 & ((~r5) << 7)) & (-9187201950435737472L);
        if (r6 != 0) goto L6;
        r1 = r1 + 8;
        r11 = (r11 + r1) & r0;
        goto L3
    L6:
        return (r11 + (Long.numberOfTrailingZeros(r6) >> 3)) & r0;
    }

    private final int findInsertIndex(K r21) {
        if (r21 == null) goto L5;
        int r3 = r21.hashCode();
    L6:
        int r4 = r3 * ScatterMapKt.MurmurHashC1;
        int r5 = r4 ^ (r4 << 16);
        int r6 = r5 >>> 7;
        int r7 = r5 & 127;
        int r8 = this._capacity;
        int r9 = r6 & r8;
        int r10 = 0;
    L7:
        long[] r11 = this.metadata;
        int r12 = r9 >> 3;
        int r13 = (r9 & 7) << 3;
        long r14 = ((r11[r12 + 1] << (64 - r13)) & ((-r13) >> 63)) | (r11[r12] >>> r13);
        long r15 = r7;
        int r18 = r7;
        long r2 = r14 ^ (r15 * ScatterMapKt.BitmaskLsb);
        long r16 = ((~r2) & (r2 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r16 == 0) goto L11;
        boolean r19 = true;
    L12:
        if (r19 == false) goto L18;
        int r17 = (r9 + (Long.numberOfTrailingZeros(r16) >> 3)) & r8;
        if (Intrinsics.areEqual(this.keys[r17], r21) == true) goto L15;
        r16 = r16 & (r16 - 1);
        goto L9
    L15:
        return r17;
    L18:
        if (((((~r14) << 6) & r14) & (-9187201950435737472L)) != 0) goto L19;
        r10 = r10 + 8;
        r9 = (r9 + r10) & r8;
        r7 = r18;
        goto L7
    L19:
        int r1 = findFirstAvailableSlot(r6);
        if (this.growthLimit == 0) goto L22;
    L27:
        this._count++;
        int r20 = this.growthLimit;
        long[] r22 = this.metadata;
        int r23 = r1 >> 3;
        long r24 = r22[r23];
        int r25 = (r1 & 7) << 3;
        if (((r24 >> r25) & 255) != 128) goto L30;
        int r110 = 1;
    L31:
        this.growthLimit = r20 - r110;
        int r26 = this._capacity;
        long r27 = ((~(255 << r25)) & r24) | (r15 << r25);
        r22[r23] = r27;
        r22[(((r1 - 7) & r26) + (r26 & 7)) >> 3] = r27;
        return ~r1;
    L30:
        r110 = 0;
        goto L31
    L22:
        if (((this.metadata[r1 >> 3] >> ((r1 & 7) << 3)) & 255) != 254) goto L24;
        boolean r28 = true;
    L25:
        if (r28 == true) goto L27;
        adjustStorage$collection();
        r1 = findFirstAvailableSlot(r6);
        goto L27
    L24:
        r28 = false;
        goto L25
    L11:
        r19 = false;
        goto L12
    L5:
        r3 = 0;
        goto L6
    }

    private final int findKeyIndex(K r18) {
        if (r18 == null) goto L5;
        int r3 = r18.hashCode();
    L6:
        int r4 = r3 * ScatterMapKt.MurmurHashC1;
        int r5 = r4 ^ (r4 << 16);
        int r6 = r5 & 127;
        int r7 = this._capacity;
        int r8 = (r5 >>> 7) & r7;
        int r9 = 0;
    L7:
        long[] r10 = this.metadata;
        int r11 = r8 >> 3;
        int r12 = (r8 & 7) << 3;
        long r13 = ((r10[r11 + 1] << (64 - r12)) & ((-r12) >> 63)) | (r10[r11] >>> r12);
        long r14 = (((long) r6) * ScatterMapKt.BitmaskLsb) ^ r13;
        long r15 = ((~r14) & (r14 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r15 == 0) goto L11;
        boolean r16 = true;
    L12:
        if (r16 == false) goto L18;
        int r17 = ((Long.numberOfTrailingZeros(r15) >> 3) + r8) & r7;
        if (Intrinsics.areEqual(this.keys[r17], r18) == true) goto L15;
        r15 = r15 & (r15 - 1);
        goto L9
    L15:
        return r17;
    L18:
        if (((r13 & ((~r13) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r9 = r9 + 8;
        r8 = (r8 + r9) & r7;
        goto L7
    L19:
        return -1;
    L11:
        r16 = false;
        goto L12
    L5:
        r3 = 0;
        goto L6
    }

    private final void fixupNodes(long[] r14) {
        long[] r0 = this.nodes;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        int r5 = Integer.MAX_VALUE;
        if (r2 >= r1) goto L14;
        long r6 = r0[r2];
        int r10 = (int) ((r6 >> 31) & SieveCacheKt.NodeLinkMask);
        int r9 = (int) (SieveCacheKt.NodeLinkMask & r6);
        long r7 = r6 & SieveCacheKt.NodeMetaMask;
        if (r10 != Integer.MAX_VALUE) goto L8;
        int r11 = Integer.MAX_VALUE;
    L9:
        long r8 = (r7 | ((long) r11)) << 31;
        if (r9 == Integer.MAX_VALUE) goto L13;
        r5 = (int) (4294967295L & r14[r9]);
    L13:
        r0[r2] = ((long) r5) | r8;
        r2 = r2 + 1;
        goto L3
    L8:
        r11 = (int) (r14[r10] & 4294967295L);
        goto L9
    L14:
        int r3 = this.head;
        if (r3 == Integer.MAX_VALUE) goto L17;
        this.head = (int) (r14[r3] & 4294967295L);
    L17:
        int r4 = this.tail;
        if (r4 == Integer.MAX_VALUE) goto L20;
        this.tail = (int) (r14[r4] & 4294967295L);
    L20:
        int r12 = this.hand;
        if (r12 == Integer.MAX_VALUE) goto L27;
        this.hand = (int) (r14[r12] & 4294967295L);
        return;
    }

    private final void initializeMetadata(int r9) {
        if (r9 != 0) goto L4;
        long[] r10 = ScatterMapKt.EmptyGroup;
    L5:
        this.metadata = r10;
        initializeGrowth();
        return;
    L4:
        long[] r0 = new long[((((r9 + 1) + 7) + 7) & (-8)) >> 3];
        ArraysKt.fill$default(r0, -9187201950435737472L, 0, 0, 6, null);
        int r1 = r9 >> 3;
        long r4 = 255 << ((r9 & 7) << 3);
        r0[r1] = (r0[r1] & (~r4)) | r4;
        r10 = r0;
        goto L5
    }

    private final void initializeStorage(int r8) {
        if (r8 <= 0) goto L4;
        int r9 = Math.max(7, ScatterMapKt.normalizeCapacity(r8));
    L5:
        this._capacity = r9;
        initializeMetadata(r9);
        if (r9 != 0) goto L8;
        Object[] r0 = ContainerHelpersKt.EMPTY_OBJECTS;
    L9:
        this.keys = r0;
        if (r9 != 0) goto L12;
        Object[] r1 = ContainerHelpersKt.EMPTY_OBJECTS;
    L13:
        this.values = r1;
        if (r9 != 0) goto L16;
        long[] r10 = SieveCacheKt.getEmptyNodes();
    L17:
        this.nodes = r10;
        return;
    L16:
        r10 = new long[r9];
        ArraysKt.fill$default(r10, 4611686018427387903L, 0, 0, 6, null);
        goto L17
    L12:
        r1 = new Object[r9];
        goto L13
    L8:
        r0 = new Object[r9];
        goto L9
    L4:
        r9 = 0;
        goto L5
    }

    private final void markNodeVisited(int r6) {
        long[] r0 = this.nodes;
        r0[r6] = (r0[r6] & 4611686018427387903L) | SieveCacheKt.NodeVisitedBit;
    }

    private final void moveNodeToHead(int r11) {
        long[] r0 = this.nodes;
        int r1 = this.head;
        r0[r11] = (((long) r1) & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (r1 == Integer.MAX_VALUE) goto L5;
        long r6 = r0[r1] & SieveCacheKt.NodeMetaAndNextMask;
        r0[r1] = ((((long) r11) & SieveCacheKt.NodeLinkMask) << 31) | r6;
    L5:
        this.head = r11;
        if (this.tail != Integer.MAX_VALUE) goto L9;
        this.tail = r11;
        return;
    }

    private final void removeNode(int r13) {
        long[] r0 = this.nodes;
        long r1 = r0[r13];
        int r5 = (int) ((r1 >> 31) & SieveCacheKt.NodeLinkMask);
        int r2 = (int) (r1 & SieveCacheKt.NodeLinkMask);
        if (r5 == Integer.MAX_VALUE) goto L5;
        r0[r5] = (r0[r5] & SieveCacheKt.NodeMetaAndPreviousMask) | (((long) r2) & SieveCacheKt.NodeLinkMask);
    L6:
        if (r2 == Integer.MAX_VALUE) goto L8;
        long r8 = r0[r2] & SieveCacheKt.NodeMetaAndNextMask;
        r0[r2] = ((SieveCacheKt.NodeLinkMask & ((long) r5)) << 31) | r8;
    L10:
        if (this.hand != r13) goto L12;
        this.hand = r5;
    L12:
        r0[r13] = 4611686018427387903L;
        return;
    L8:
        this.tail = r5;
        goto L10
    L5:
        this.head = r2;
        goto L6
    }

    private final V removeValueAt(int r14) {
        this._count--;
        long[] r0 = this.metadata;
        int r1 = this._capacity;
        int r2 = r14 >> 3;
        int r3 = (r14 & 7) << 3;
        long r4 = (r0[r2] & (~(255 << r3))) | (254 << r3);
        r0[r2] = r4;
        r0[(((r14 - 7) & r1) + (r1 & 7)) >> 3] = r4;
        this.keys[r14] = null;
        Object[] r5 = this.values;
        V r6 = (V) r5[r14];
        r5[r14] = null;
        long[] r7 = this.nodes;
        long r8 = r7[r14];
        int r9 = (int) ((r8 >> 31) & SieveCacheKt.NodeLinkMask);
        int r10 = (int) (r8 & SieveCacheKt.NodeLinkMask);
        if (r9 == Integer.MAX_VALUE) goto L5;
        r7[r9] = (r7[r9] & SieveCacheKt.NodeMetaAndPreviousMask) | (((long) r10) & SieveCacheKt.NodeLinkMask);
    L6:
        if (r10 == Integer.MAX_VALUE) goto L8;
        r7[r10] = ((SieveCacheKt.NodeLinkMask & ((long) r9)) << 31) | (r7[r10] & SieveCacheKt.NodeMetaAndNextMask);
    L10:
        if (this.hand != r14) goto L12;
        this.hand = r9;
    L12:
        r7[r14] = 4611686018427387903L;
        return r6;
    L8:
        this.tail = r9;
        goto L10
    L5:
        this.head = r10;
        goto L6
    }

    public final boolean all(Function2<? super K, ? super V, Boolean> r20) {
        Intrinsics.checkNotNullParameter(r20, "predicate");
        Object[] r2 = this.keys;
        Object[] r3 = this.values;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L21;
        int r8 = 0;
    L5:
        long r9 = r4[r8];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r11 = 8 - ((~(r8 - r5)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L18;
        if ((255 & r9) >= 128) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L17;
        int r15 = (r8 << 3) + r13;
        Object r16 = r2[r15];
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r6 = r3[r15];
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        if (((Boolean) r20.invoke(r16, r6)).booleanValue() == true) goto L17;
        return false;
    L17:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L8
    L12:
        r14 = false;
        goto L13
    L18:
        if (r11 == 8) goto L19;
        return true;
    L19:
        if (r8 == r5) goto L30;
        r8 = r8 + 1;
        goto L5
    L30:
        return true;
    L21:
        return true;
    }

    public final boolean any(Function2<? super K, ? super V, Boolean> r20) {
        Intrinsics.checkNotNullParameter(r20, "predicate");
        Object[] r2 = this.keys;
        Object[] r3 = this.values;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L21;
        int r7 = 0;
    L5:
        long r8 = r4[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r10 = 8 - ((~(r7 - r5)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L18;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L17;
        int r14 = (r7 << 3) + r12;
        Object r15 = r2[r14];
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r16 = r3[r14];
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        if (((Boolean) r20.invoke(r15, r16)).booleanValue() == false) goto L17;
        return true;
    L17:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L18:
        if (r10 != 8) goto L21;
    L19:
        if (r7 == r5) goto L21;
        r7 = r7 + 1;
    L21:
        return false;
    }

    public final boolean contains(K r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (findKeyIndex(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean containsKey(K r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (findKeyIndex(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean containsValue(V r19) {
        Intrinsics.checkNotNullParameter(r19, "value");
        Object[] r2 = this.values;
        long[] r3 = this.metadata;
        int r4 = r3.length - 2;
        if (r4 < 0) goto L21;
        int r6 = 0;
    L5:
        long r7 = r3[r6];
        if (((((~r7) << 7) & r7) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r9 = 8 - ((~(r6 - r4)) >>> 31);
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L18;
        if ((255 & r7) >= 128) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L17;
        Object r13 = r2[(r6 << 3) + r11];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        if (Intrinsics.areEqual(r19, r13) == false) goto L17;
        return true;
    L17:
        r7 = r7 >> 8;
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = false;
        goto L13
    L18:
        if (r9 != 8) goto L21;
    L19:
        if (r6 == r4) goto L21;
        r6 = r6 + 1;
    L21:
        return false;
    }

    public final int count(Function2<? super K, ? super V, Boolean> r20) {
        Intrinsics.checkNotNullParameter(r20, "predicate");
        Object[] r2 = this.keys;
        Object[] r3 = this.values;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L22;
        int r7 = 0;
        int r8 = 0;
    L5:
        long r9 = r4[r7];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r11 = 8 - ((~(r7 - r5)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L18;
        if ((255 & r9) >= 128) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L17;
        int r15 = (r7 << 3) + r13;
        Object r16 = r2[r15];
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r6 = r3[r15];
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        if (((Boolean) r20.invoke(r16, r6)).booleanValue() == false) goto L17;
        r8 = r8 + 1;
    L17:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L8
    L12:
        r14 = false;
        goto L13
    L18:
        if (r11 == 8) goto L19;
        return r8;
    L19:
        if (r7 == r5) goto L21;
        r7 = r7 + 1;
        goto L5
    L21:
        int r10 = r8;
    L24:
        return r10;
    L22:
        r10 = 0;
        goto L24
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object r20) {
        if (r20 != this) goto L6;
        return true;
    L6:
        if ((r20 instanceof SieveCache) == true) goto L8;
        return false;
    L8:
        SieveCache r1 = (SieveCache) r20;
        if (r1.getSize() == getSize()) goto L11;
    L34:
        return false;
    L11:
        if (r1._count != this._count) goto L34;
        Object[] r3 = this.keys;
        Object[] r5 = this.values;
        long[] r6 = this.metadata;
        int r7 = r6.length - 2;
        if (r7 < 0) goto L32;
        int r8 = 0;
    L16:
        long r9 = r6[r8];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L30;
        int r11 = 8 - ((~(r8 - r7)) >>> 31);
        int r13 = 0;
    L19:
        if (r13 >= r11) goto L29;
        if ((255 & r9) >= 128) goto L23;
        boolean r14 = true;
    L24:
        if (r14 == false) goto L28;
        int r15 = (r8 << 3) + r13;
        Object r16 = r3[r15];
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r2 = r5[r15];
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        if (Intrinsics.areEqual(r2, r1.get(r16)) == true) goto L28;
        return false;
    L28:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L19
    L23:
        r14 = false;
        goto L24
    L29:
        if (r11 == 8) goto L30;
        return true;
    L30:
        if (r8 == r7) goto L42;
        r8 = r8 + 1;
        goto L16
    L42:
        return true;
    L32:
        return true;
    }

    public final void forEach(Function2<? super K, ? super V, Unit> r19) {
        Intrinsics.checkNotNullParameter(r19, "block");
        Object[] r2 = this.keys;
        Object[] r3 = this.values;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L19;
        int r7 = 0;
    L5:
        long r8 = r4[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r10 = 8 - ((~(r7 - r5)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L16;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L15;
        int r14 = (r7 << 3) + r12;
        Object r15 = r2[r14];
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r16 = r3[r14];
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        r19.invoke(r15, r16);
    L15:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L16:
        if (r10 == 8) goto L17;
        return;
    L17:
        if (r7 == r5) goto L26;
        r7 = r7 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> r15) {
        Intrinsics.checkNotNullParameter(r15, "block");
        long[] r0 = this.metadata;
        int r1 = r0.length - 2;
        if (r1 < 0) goto L20;
        int r3 = 0;
    L5:
        long r4 = r0[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L18;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L16;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L15;
        r15.invoke(Integer.valueOf((r3 << 3) + r8));
    L15:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L16:
        if (r6 == 8) goto L18;
        return;
    L18:
        if (r3 == r1) goto L26;
        r3 = r3 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachKey(Function1<? super K, Unit> r18) {
        Intrinsics.checkNotNullParameter(r18, "block");
        Object[] r2 = this.keys;
        long[] r3 = this.metadata;
        int r4 = r3.length - 2;
        if (r4 < 0) goto L19;
        int r6 = 0;
    L5:
        long r7 = r3[r6];
        if (((((~r7) << 7) & r7) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r9 = 8 - ((~(r6 - r4)) >>> 31);
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L16;
        if ((255 & r7) >= 128) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L15;
        Object r13 = r2[(r6 << 3) + r11];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        r18.invoke(r13);
    L15:
        r7 = r7 >> 8;
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = false;
        goto L13
    L16:
        if (r9 == 8) goto L17;
        return;
    L17:
        if (r6 == r4) goto L26;
        r6 = r6 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachValue(Function1<? super V, Unit> r18) {
        Intrinsics.checkNotNullParameter(r18, "block");
        Object[] r2 = this.values;
        long[] r3 = this.metadata;
        int r4 = r3.length - 2;
        if (r4 < 0) goto L19;
        int r6 = 0;
    L5:
        long r7 = r3[r6];
        if (((((~r7) << 7) & r7) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r9 = 8 - ((~(r6 - r4)) >>> 31);
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L16;
        if ((255 & r7) >= 128) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L15;
        Object r13 = r2[(r6 << 3) + r11];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        r18.invoke(r13);
    L15:
        r7 = r7 >> 8;
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = false;
        goto L13
    L16:
        if (r9 == 8) goto L17;
        return;
    L17:
        if (r6 == r4) goto L26;
        r6 = r6 + 1;
        goto L5
    L26:
        return;
    }

    public final V get(K r6) {
        Intrinsics.checkNotNullParameter(r6, "key");
        int r0 = findKeyIndex(r6);
        if (r0 < 0) goto L6;
        long[] r7 = this.nodes;
        r7[r0] = (r7[r0] & 4611686018427387903L) | SieveCacheKt.NodeVisitedBit;
        return (V) this.values[r0];
    L6:
        V r1 = (V) this.createValueFromKey.invoke(r6);
        if (r1 != null) goto L10;
        return null;
    L10:
        put(r6, r1);
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<K> r15) {
        Intrinsics.checkNotNullParameter(r15, "keys");
        Object[] r0 = r15.elements;
        long[] r16 = r15.metadata;
        int r1 = r16.length - 2;
        if (r1 < 0) goto L19;
        int r3 = 0;
    L5:
        long r4 = r16[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L16;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L15;
        remove(r0[(r3 << 3) + r8]);
    L15:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L16:
        if (r6 == 8) goto L17;
        return;
    L17:
        if (r3 == r1) goto L26;
        r3 = r3 + 1;
        goto L5
    L26:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(Pair<? extends K, ? extends V> r2) {
        Intrinsics.checkNotNullParameter(r2, "pair");
        put(r2.getFirst(), r2.getSecond());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(SieveCache<K, V> r17) {
        Intrinsics.checkNotNullParameter(r17, "from");
        Object[] r1 = r17.keys;
        Object[] r2 = r17.values;
        long[] r0 = r17.metadata;
        int r3 = r0.length - 2;
        if (r3 < 0) goto L24;
        int r5 = 0;
    L5:
        long r6 = r0[r5];
        if (((((~r6) << 7) & r6) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L21;
        int r8 = 8 - ((~(r5 - r3)) >>> 31);
        int r10 = 0;
    L8:
        if (r10 >= r8) goto L18;
        if ((255 & r6) >= 128) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L16;
        int r12 = (r5 << 3) + r10;
        Object r13 = r1[r12];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r14 = r2[r12];
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        put(r13, r14);
    L16:
        r6 = r6 >> 8;
        r10 = r10 + 1;
        goto L8
    L12:
        r11 = false;
        goto L13
    L18:
        if (r8 == 8) goto L21;
        return;
    L21:
        if (r5 == r3) goto L31;
        r5 = r5 + 1;
        goto L5
    L31:
        return;
    }

    public final V remove(K r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        int r0 = findKeyIndex(r5);
        if (r0 < 0) goto L9;
        V r1 = removeValueAt(r0);
        if (r1 != null) goto L7;
        return null;
    L7:
        this._size -= ((Number) this.sizeOf.invoke(r5, r1)).intValue();
        this.onEntryRemoved.invoke(r5, r1, null, Boolean.FALSE);
        return r1;
    L9:
        return null;
    }

    public final void removeIf(Function2<? super K, ? super V, Boolean> r15) {
        Intrinsics.checkNotNullParameter(r15, "predicate");
        long[] r0 = this.metadata;
        int r1 = r0.length - 2;
        if (r1 < 0) goto L24;
        int r3 = 0;
    L5:
        long r4 = r0[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L21;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L20;
        int r10 = (r3 << 3) + r8;
        Object r11 = this.keys[r10];
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r12 = this.values[r10];
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        if (((Boolean) r15.invoke(r11, r12)).booleanValue() == false) goto L20;
        V r13 = removeValueAt(r10);
        if (r13 == null) goto L18;
        this._size -= ((Number) this.sizeOf.invoke(r11, r13)).intValue();
        this.onEntryRemoved.invoke(r11, r13, null, Boolean.FALSE);
        goto L20
    L18:
        return;
    L20:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L21:
        if (r6 == 8) goto L22;
        return;
    L22:
        if (r3 == r1) goto L33;
        r3 = r3 + 1;
        goto L5
    L33:
        return;
    }

    public final void resize(int r1) {
        this._maxSize = r1;
        trimToSize(r1);
    }

    public final void resizeStorage$collection(int r26) {
        long[] r1 = this.metadata;
        Object[] r2 = this.keys;
        Object[] r3 = this.values;
        long[] r4 = this.nodes;
        int r5 = this._capacity;
        int[] r6 = new int[r5];
        initializeStorage(r26);
        long[] r7 = this.metadata;
        Object[] r8 = this.keys;
        Object[] r9 = this.values;
        long[] r10 = this.nodes;
        int r11 = this._capacity;
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L16;
        if (((r1[r13 >> 3] >> ((r13 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == false) goto L14;
        Object r15 = r2[r13];
        if (r15 == null) goto L12;
        int r16 = r15.hashCode();
    L13:
        int r17 = r16 * ScatterMapKt.MurmurHashC1;
        int r18 = r17 ^ (r17 << 16);
        int r12 = findFirstAvailableSlot(r18 >>> 7);
        long r19 = r18 & 127;
        int r110 = r12 >> 3;
        int r20 = (r12 & 7) << 3;
        int[] r24 = r6;
        long r21 = (r19 << r20) | (r7[r110] & (~(255 << r20)));
        r7[r110] = r21;
        r7[(((r12 - 7) & r11) + (r11 & 7)) >> 3] = r21;
        r8[r12] = r15;
        r9[r12] = r3[r13];
        r10[r12] = r4[r13];
        r24[r13] = r12;
    L15:
        r13 = r13 + 1;
        r1 = r1;
        r2 = r2;
        r5 = r5;
        r6 = r24;
        goto L3
    L12:
        r16 = 0;
        goto L13
    L14:
        r24 = r6;
        goto L15
    L7:
        r14 = false;
        goto L8
    L16:
        fixupNodes(r6);
    }

    public final void trimToSize(int r6) {
    L3:
        if (this._size <= r6) goto L14;
        if (getCount() == 0) goto L22;
        int r0 = findEvictionCandidate();
        if (r0 == Integer.MAX_VALUE) goto L9;
        Object r1 = this.keys[r0];
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        V r2 = removeValueAt(r0);
        if (r2 == null) goto L3;
        this._size -= ((Number) this.sizeOf.invoke(r1, r2)).intValue();
        this.onEntryRemoved.invoke(r1, r2, null, Boolean.TRUE);
        goto L3
    L9:
        return;
    L22:
        return;
    }

    private final void fixupNodes(int[] r12) {
        long[] r0 = this.nodes;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        int r3 = Integer.MAX_VALUE;
        if (r2 >= r1) goto L14;
        long r4 = r0[r2];
        int r8 = (int) ((r4 >> 31) & SieveCacheKt.NodeLinkMask);
        int r7 = (int) (SieveCacheKt.NodeLinkMask & r4);
        long r5 = r4 & SieveCacheKt.NodeMetaMask;
        if (r8 != Integer.MAX_VALUE) goto L8;
        int r9 = Integer.MAX_VALUE;
    L9:
        long r6 = (r5 | ((long) r9)) << 31;
        if (r7 == Integer.MAX_VALUE) goto L13;
        r3 = r12[r7];
    L13:
        r0[r2] = r6 | ((long) r3);
        r2 = r2 + 1;
        goto L3
    L8:
        r9 = r12[r8];
        goto L9
    L14:
        int r10 = this.head;
        if (r10 == Integer.MAX_VALUE) goto L17;
        this.head = r12[r10];
    L17:
        int r11 = this.tail;
        if (r11 == Integer.MAX_VALUE) goto L20;
        this.tail = r12[r11];
    L20:
        int r13 = this.hand;
        if (r13 == Integer.MAX_VALUE) goto L27;
        this.hand = r12[r13];
        return;
    }

    public final void minusAssign(Iterable<? extends K> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
        Iterator<? extends K> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        remove(r3.next());
        goto L4
    }

    public final void plusAssign(ScatterMap<K, V> r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        putAll(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(ScatterMap<K, V> r17) {
        Intrinsics.checkNotNullParameter(r17, "from");
        Object[] r1 = r17.keys;
        Object[] r2 = r17.values;
        long[] r0 = r17.metadata;
        int r3 = r0.length - 2;
        if (r3 < 0) goto L24;
        int r5 = 0;
    L5:
        long r6 = r0[r5];
        if (((((~r6) << 7) & r6) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L21;
        int r8 = 8 - ((~(r5 - r3)) >>> 31);
        int r10 = 0;
    L8:
        if (r10 >= r8) goto L18;
        if ((255 & r6) >= 128) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L16;
        int r12 = (r5 << 3) + r10;
        put(r1[r12], r2[r12]);
    L16:
        r6 = r6 >> 8;
        r10 = r10 + 1;
        goto L8
    L12:
        r11 = false;
        goto L13
    L18:
        if (r8 == 8) goto L21;
        return;
    L21:
        if (r5 == r3) goto L31;
        r5 = r5 + 1;
        goto L5
    L31:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(Sequence<? extends K> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        remove(r3.next());
        goto L4
    }

    public final void plusAssign(SieveCache<K, V> r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        putAll(r2);
    }

    public final void putAll(Map<K, ? extends V> r3) {
        Intrinsics.checkNotNullParameter(r3, "from");
        Iterator<Map.Entry<K, ? extends V>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<K, ? extends V> r0 = r4.next();
        put(r0.getKey(), r0.getValue());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<K> r4) {
        Intrinsics.checkNotNullParameter(r4, "keys");
        Object[] r0 = r4.content;
        int r5 = r4._size;
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        remove(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(Iterable<? extends Pair<? extends K, ? extends V>> r2) {
        Intrinsics.checkNotNullParameter(r2, "pairs");
        putAll(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(Iterable<? extends Pair<? extends K, ? extends V>> r3) {
        Intrinsics.checkNotNullParameter(r3, "pairs");
        Iterator<? extends Pair<? extends K, ? extends V>> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Pair<? extends K, ? extends V> r0 = r4.next();
        put(r0.component1(), r0.component2());
        goto L4
    }

    public final void minusAssign(K[] r4) {
        Intrinsics.checkNotNullParameter(r4, "keys");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        remove(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(Map<K, ? extends V> r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        putAll(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(Sequence<? extends Pair<? extends K, ? extends V>> r3) {
        Intrinsics.checkNotNullParameter(r3, "pairs");
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Pair r0 = (Pair) r4.next();
        put(r0.component1(), r0.component2());
        goto L4
    }

    public final void minusAssign(K r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        remove(r2);
    }

    public final void plusAssign(Sequence<? extends Pair<? extends K, ? extends V>> r2) {
        Intrinsics.checkNotNullParameter(r2, "pairs");
        putAll(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(Pair<? extends K, ? extends V>[] r5) {
        Intrinsics.checkNotNullParameter(r5, "pairs");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Pair<? extends K, ? extends V> r2 = r5[r1];
        put(r2.component1(), r2.component2());
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(Pair<? extends K, ? extends V>[] r2) {
        Intrinsics.checkNotNullParameter(r2, "pairs");
        putAll(r2);
    }

    public final V put(K r10, V r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "value");
        int r0 = findInsertIndex(r10);
        if (r0 >= 0) goto L5;
        r0 = ~r0;
    L5:
        Object[] r1 = this.values;
        V r2 = (V) r1[r0];
        r1[r0] = r11;
        this.keys[r0] = r10;
        int r3 = this._size + ((Number) this.sizeOf.invoke(r10, r11)).intValue();
        this._size = r3;
        if (r2 == null) goto L9;
        this._size = r3 - ((Number) this.sizeOf.invoke(r10, r2)).intValue();
        this.onEntryRemoved.invoke(r10, r2, r11, Boolean.FALSE);
        trimToSize(this._maxSize);
        return r2;
    L9:
        trimToSize(this._maxSize);
        long[] r12 = this.nodes;
        int r13 = this.head;
        r12[r0] = (((long) r13) & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (r13 == Integer.MAX_VALUE) goto L12;
        r12[r13] = (r12[r13] & SieveCacheKt.NodeMetaAndNextMask) | ((SieveCacheKt.NodeLinkMask & ((long) r0)) << 31);
    L12:
        this.head = r0;
        if (this.tail != Integer.MAX_VALUE) goto L15;
        this.tail = r0;
    L15:
        return r2;
    }

    public final boolean remove(K r4, V r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        int r0 = findKeyIndex(r4);
        if (r0 >= 0) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(this.values[r0], r5) == false) goto L11;
        V r6 = removeValueAt(r0);
        if (r6 != null) goto L9;
        return false;
    L9:
        this._size -= ((Number) this.sizeOf.invoke(r4, r6)).intValue();
        this.onEntryRemoved.invoke(r4, r6, null, Boolean.FALSE);
        return true;
    }

    public final void set(K r2, V r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        put(r2, r3);
    }

    private static final Unit _init_$lambda$1(Object r0, Object r1, Object r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r0, "<unused var>");
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SieveCache(int r2, int r3, Function2<? super K, ? super V, Integer> r4, Function1<? super K, ? extends V> r5, Function4<? super K, ? super V, ? super V, ? super Boolean, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "sizeOf");
        Intrinsics.checkNotNullParameter(r5, "createValueFromKey");
        Intrinsics.checkNotNullParameter(r6, "onEntryRemoved");
        this.sizeOf = r4;
        this.createValueFromKey = r5;
        this.onEntryRemoved = r6;
        this.metadata = ScatterMapKt.EmptyGroup;
        Object[] r7 = ContainerHelpersKt.EMPTY_OBJECTS;
        this.keys = r7;
        this.values = r7;
        this.nodes = SieveCacheKt.getEmptyNodes();
        this.head = Integer.MAX_VALUE;
        this.tail = Integer.MAX_VALUE;
        this.hand = Integer.MAX_VALUE;
        if (r2 <= 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == true) goto L8;
        RuntimeHelpersKt.throwIllegalArgumentException("maxSize must be > 0");
    L8:
        this._maxSize = r2;
        initializeStorage(ScatterMapKt.unloadedCapacity(r3));
        return;
    L5:
        r8 = false;
        goto L6
    }

    public /* synthetic */ SieveCache(int r7, int r8, Function2 r9, Function1 r10, Function4 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        int r2 = 6;
    L7:
        if ((r12 & 4) == 0) goto L9;
        r9 = new d();
    L9:
        Function2 r3 = r9;
        if ((r12 & 8) == 0) goto L12;
        r10 = AnonymousClass2.INSTANCE;
    L12:
        Function1 r4 = r10;
        if ((r12 & 16) == 0) goto L15;
        r11 = new e();
    L15:
        this(r7, r2, r3, r4, r11);
        return;
    L5:
        r2 = r8;
        goto L7
    }
}
