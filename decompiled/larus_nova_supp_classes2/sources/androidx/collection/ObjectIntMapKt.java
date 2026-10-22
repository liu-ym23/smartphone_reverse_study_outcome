package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000e\u001aG\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0002\u0010\u0011\u001aW\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0002\u0010\u0014\u001ag\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u0002H\u00052\u0006\u0010\u0016\u001a\u00020\n¢\u0006\u0002\u0010\u0017\u001a\u0012\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0019\u001a7\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u001a\u001aG\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0002\u0010\u001b\u001aW\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0002\u0010\u001c\u001ag\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u0002H\u00052\u0006\u0010\u0016\u001a\u00020\n¢\u0006\u0002\u0010\u001d\u001aD\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u001d\u0010\u001f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aL\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010#\u001a\u00020\n2\u001d\u0010\u001f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\"\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"EmptyObjectIntMap", "Landroidx/collection/MutableObjectIntMap;", "", "emptyObjectIntMap", "Landroidx/collection/ObjectIntMap;", "K", "objectIntMap", "objectIntMapOf", "key1", "value1", "", "(Ljava/lang/Object;I)Landroidx/collection/ObjectIntMap;", "key2", "value2", "(Ljava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/ObjectIntMap;", "key3", "value3", "(Ljava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/ObjectIntMap;", "key4", "value4", "(Ljava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/ObjectIntMap;", "key5", "value5", "(Ljava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/ObjectIntMap;", "mutableObjectIntMapOf", "(Ljava/lang/Object;I)Landroidx/collection/MutableObjectIntMap;", "(Ljava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/MutableObjectIntMap;", "(Ljava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/MutableObjectIntMap;", "(Ljava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/MutableObjectIntMap;", "(Ljava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/MutableObjectIntMap;", "buildObjectIntMap", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ObjectIntMapKt {
    private static final MutableObjectIntMap<Object> EmptyObjectIntMap = null;

    static {
        EmptyObjectIntMap = new MutableObjectIntMap(0);
    }

    public static final <K> ObjectIntMap<K> emptyObjectIntMap() {
        MutableObjectIntMap<Object> r0 = EmptyObjectIntMap;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.ObjectIntMap<K of androidx.collection.ObjectIntMapKt.emptyObjectIntMap>");
        return r0;
    }

    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf() {
        return new MutableObjectIntMap(0, 1, null);
    }

    public static final <K> ObjectIntMap<K> objectIntMap() {
        MutableObjectIntMap<Object> r0 = EmptyObjectIntMap;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.ObjectIntMap<K of androidx.collection.ObjectIntMapKt.objectIntMap>");
        return r0;
    }

    public static final <K> ObjectIntMap<K> buildObjectIntMap(Function1<? super MutableObjectIntMap<K>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "builderAction");
        MutableObjectIntMap r0 = new MutableObjectIntMap(0, 1, null);
        r4.invoke(r0);
        return r0;
    }

    public static final <K> ObjectIntMap<K> buildObjectIntMap(int r1, Function1<? super MutableObjectIntMap<K>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "builderAction");
        MutableObjectIntMap r0 = new MutableObjectIntMap(r1);
        r2.invoke(r0);
        return r0;
    }

    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K r4, int r5) {
        MutableObjectIntMap<K> r0 = new MutableObjectIntMap(0, 1, null);
        r0.set(r4, r5);
        return r0;
    }

    public static final <K> ObjectIntMap<K> objectIntMapOf(K r4, int r5) {
        MutableObjectIntMap r0 = new MutableObjectIntMap(0, 1, null);
        r0.set(r4, r5);
        return r0;
    }

    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K r4, int r5, K r6, int r7) {
        MutableObjectIntMap<K> r0 = new MutableObjectIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        return r0;
    }

    public static final <K> ObjectIntMap<K> objectIntMapOf(K r4, int r5, K r6, int r7) {
        MutableObjectIntMap r0 = new MutableObjectIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        return r0;
    }

    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K r4, int r5, K r6, int r7, K r8, int r9) {
        MutableObjectIntMap<K> r0 = new MutableObjectIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        return r0;
    }

    public static final <K> ObjectIntMap<K> objectIntMapOf(K r4, int r5, K r6, int r7, K r8, int r9) {
        MutableObjectIntMap r0 = new MutableObjectIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        return r0;
    }

    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K r4, int r5, K r6, int r7, K r8, int r9, K r10, int r11) {
        MutableObjectIntMap<K> r0 = new MutableObjectIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        return r0;
    }

    public static final <K> ObjectIntMap<K> objectIntMapOf(K r4, int r5, K r6, int r7, K r8, int r9, K r10, int r11) {
        MutableObjectIntMap r0 = new MutableObjectIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        return r0;
    }

    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K r4, int r5, K r6, int r7, K r8, int r9, K r10, int r11, K r12, int r13) {
        MutableObjectIntMap<K> r0 = new MutableObjectIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        r0.set(r12, r13);
        return r0;
    }

    public static final <K> ObjectIntMap<K> objectIntMapOf(K r4, int r5, K r6, int r7, K r8, int r9, K r10, int r11, K r12, int r13) {
        MutableObjectIntMap r0 = new MutableObjectIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        r0.set(r12, r13);
        return r0;
    }
}
