package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000e\u001aG\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0002\u0010\u0011\u001aW\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0002\u0010\u0014\u001ag\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u0002H\u00052\u0006\u0010\u0016\u001a\u00020\n¢\u0006\u0002\u0010\u0017\u001a\u0012\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0019\u001a7\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u001a\u001aG\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0002\u0010\u001b\u001aW\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0002\u0010\u001c\u001ag\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u0002H\u00052\u0006\u0010\u0016\u001a\u00020\n¢\u0006\u0002\u0010\u001d\u001aD\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u001d\u0010\u001f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aL\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010#\u001a\u00020$2\u001d\u0010\u001f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\"\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, d2 = {"EmptyObjectLongMap", "Landroidx/collection/MutableObjectLongMap;", "", "emptyObjectLongMap", "Landroidx/collection/ObjectLongMap;", "K", "objectLongMap", "objectLongMapOf", "key1", "value1", "", "(Ljava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "key2", "value2", "(Ljava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "key3", "value3", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "key4", "value4", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "key5", "value5", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "mutableObjectLongMapOf", "(Ljava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "buildObjectLongMap", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ObjectLongMapKt {
    private static final MutableObjectLongMap<Object> EmptyObjectLongMap = null;

    static {
        EmptyObjectLongMap = new MutableObjectLongMap(0);
    }

    public static final <K> ObjectLongMap<K> emptyObjectLongMap() {
        MutableObjectLongMap<Object> r0 = EmptyObjectLongMap;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.emptyObjectLongMap>");
        return r0;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf() {
        return new MutableObjectLongMap(0, 1, null);
    }

    public static final <K> ObjectLongMap<K> objectLongMap() {
        MutableObjectLongMap<Object> r0 = EmptyObjectLongMap;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.objectLongMap>");
        return r0;
    }

    public static final <K> ObjectLongMap<K> buildObjectLongMap(Function1<? super MutableObjectLongMap<K>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "builderAction");
        MutableObjectLongMap r0 = new MutableObjectLongMap(0, 1, null);
        r4.invoke(r0);
        return r0;
    }

    public static final <K> ObjectLongMap<K> buildObjectLongMap(int r1, Function1<? super MutableObjectLongMap<K>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "builderAction");
        MutableObjectLongMap r0 = new MutableObjectLongMap(r1);
        r2.invoke(r0);
        return r0;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K r4, long r5) {
        MutableObjectLongMap<K> r0 = new MutableObjectLongMap(0, 1, null);
        r0.set(r4, r5);
        return r0;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K r4, long r5) {
        MutableObjectLongMap r0 = new MutableObjectLongMap(0, 1, null);
        r0.set(r4, r5);
        return r0;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K r4, long r5, K r7, long r8) {
        MutableObjectLongMap<K> r0 = new MutableObjectLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        return r0;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K r4, long r5, K r7, long r8) {
        MutableObjectLongMap r0 = new MutableObjectLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        return r0;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K r4, long r5, K r7, long r8, K r10, long r11) {
        MutableObjectLongMap<K> r0 = new MutableObjectLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        return r0;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K r4, long r5, K r7, long r8, K r10, long r11) {
        MutableObjectLongMap r0 = new MutableObjectLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        return r0;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K r4, long r5, K r7, long r8, K r10, long r11, K r13, long r14) {
        MutableObjectLongMap<K> r0 = new MutableObjectLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        return r0;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K r4, long r5, K r7, long r8, K r10, long r11, K r13, long r14) {
        MutableObjectLongMap r0 = new MutableObjectLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        return r0;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K r4, long r5, K r7, long r8, K r10, long r11, K r13, long r14, K r16, long r17) {
        MutableObjectLongMap<K> r0 = new MutableObjectLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        r0.set(r16, r17);
        return r0;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K r4, long r5, K r7, long r8, K r10, long r11, K r13, long r14, K r16, long r17) {
        MutableObjectLongMap r0 = new MutableObjectLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        r0.set(r16, r17);
        return r0;
    }
}
