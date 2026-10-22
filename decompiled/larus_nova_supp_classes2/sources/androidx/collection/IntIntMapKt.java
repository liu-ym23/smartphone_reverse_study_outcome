package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0016\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\u001a2\u0010\u0011\u001a\u00020\u00032\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u0015H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a:\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00062\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u0015H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"EmptyIntIntMap", "Landroidx/collection/MutableIntIntMap;", "emptyIntIntMap", "Landroidx/collection/IntIntMap;", "intIntMapOf", "key1", "", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableIntIntMapOf", "buildIntIntMap", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IntIntMapKt {
    private static final MutableIntIntMap EmptyIntIntMap = null;

    static {
        EmptyIntIntMap = new MutableIntIntMap(0);
    }

    public static final MutableIntIntMap mutableIntIntMapOf() {
        return new MutableIntIntMap(0, 1, null);
    }

    public static final IntIntMap emptyIntIntMap() {
        return EmptyIntIntMap;
    }

    public static final IntIntMap intIntMapOf() {
        return EmptyIntIntMap;
    }

    public static final IntIntMap buildIntIntMap(Function1<? super MutableIntIntMap, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "builderAction");
        MutableIntIntMap r0 = new MutableIntIntMap(0, 1, null);
        r4.invoke(r0);
        return r0;
    }

    public static final IntIntMap buildIntIntMap(int r1, Function1<? super MutableIntIntMap, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "builderAction");
        MutableIntIntMap r0 = new MutableIntIntMap(r1);
        r2.invoke(r0);
        return r0;
    }

    public static final IntIntMap intIntMapOf(int r4, int r5) {
        MutableIntIntMap r0 = new MutableIntIntMap(0, 1, null);
        r0.set(r4, r5);
        return r0;
    }

    public static final MutableIntIntMap mutableIntIntMapOf(int r4, int r5) {
        MutableIntIntMap r0 = new MutableIntIntMap(0, 1, null);
        r0.set(r4, r5);
        return r0;
    }

    public static final IntIntMap intIntMapOf(int r4, int r5, int r6, int r7) {
        MutableIntIntMap r0 = new MutableIntIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        return r0;
    }

    public static final MutableIntIntMap mutableIntIntMapOf(int r4, int r5, int r6, int r7) {
        MutableIntIntMap r0 = new MutableIntIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        return r0;
    }

    public static final IntIntMap intIntMapOf(int r4, int r5, int r6, int r7, int r8, int r9) {
        MutableIntIntMap r0 = new MutableIntIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        return r0;
    }

    public static final MutableIntIntMap mutableIntIntMapOf(int r4, int r5, int r6, int r7, int r8, int r9) {
        MutableIntIntMap r0 = new MutableIntIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        return r0;
    }

    public static final IntIntMap intIntMapOf(int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        MutableIntIntMap r0 = new MutableIntIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        return r0;
    }

    public static final MutableIntIntMap mutableIntIntMapOf(int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        MutableIntIntMap r0 = new MutableIntIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        return r0;
    }

    public static final IntIntMap intIntMapOf(int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13) {
        MutableIntIntMap r0 = new MutableIntIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        r0.set(r12, r13);
        return r0;
    }

    public static final MutableIntIntMap mutableIntIntMapOf(int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13) {
        MutableIntIntMap r0 = new MutableIntIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        r0.set(r12, r13);
        return r0;
    }
}
