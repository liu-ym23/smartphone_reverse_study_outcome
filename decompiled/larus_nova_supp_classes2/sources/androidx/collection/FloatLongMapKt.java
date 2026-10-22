package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a2\u0010\u0012\u001a\u00020\u00032\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a:\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"EmptyFloatLongMap", "Landroidx/collection/MutableFloatLongMap;", "emptyFloatLongMap", "Landroidx/collection/FloatLongMap;", "floatLongMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableFloatLongMapOf", "buildFloatLongMap", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FloatLongMapKt {
    private static final MutableFloatLongMap EmptyFloatLongMap = null;

    static {
        EmptyFloatLongMap = new MutableFloatLongMap(0);
    }

    public static final MutableFloatLongMap mutableFloatLongMapOf() {
        return new MutableFloatLongMap(0, 1, null);
    }

    public static final FloatLongMap emptyFloatLongMap() {
        return EmptyFloatLongMap;
    }

    public static final FloatLongMap floatLongMapOf() {
        return EmptyFloatLongMap;
    }

    public static final FloatLongMap buildFloatLongMap(Function1<? super MutableFloatLongMap, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "builderAction");
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r4.invoke(r0);
        return r0;
    }

    public static final FloatLongMap buildFloatLongMap(int r1, Function1<? super MutableFloatLongMap, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "builderAction");
        MutableFloatLongMap r0 = new MutableFloatLongMap(r1);
        r2.invoke(r0);
        return r0;
    }

    public static final FloatLongMap floatLongMapOf(float r4, long r5) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        return r0;
    }

    public static final MutableFloatLongMap mutableFloatLongMapOf(float r4, long r5) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        return r0;
    }

    public static final FloatLongMap floatLongMapOf(float r4, long r5, float r7, long r8) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        return r0;
    }

    public static final MutableFloatLongMap mutableFloatLongMapOf(float r4, long r5, float r7, long r8) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        return r0;
    }

    public static final FloatLongMap floatLongMapOf(float r4, long r5, float r7, long r8, float r10, long r11) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        return r0;
    }

    public static final MutableFloatLongMap mutableFloatLongMapOf(float r4, long r5, float r7, long r8, float r10, long r11) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        return r0;
    }

    public static final FloatLongMap floatLongMapOf(float r4, long r5, float r7, long r8, float r10, long r11, float r13, long r14) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        return r0;
    }

    public static final MutableFloatLongMap mutableFloatLongMapOf(float r4, long r5, float r7, long r8, float r10, long r11, float r13, long r14) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        return r0;
    }

    public static final FloatLongMap floatLongMapOf(float r4, long r5, float r7, long r8, float r10, long r11, float r13, long r14, float r16, long r17) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        r0.set(r16, r17);
        return r0;
    }

    public static final MutableFloatLongMap mutableFloatLongMapOf(float r4, long r5, float r7, long r8, float r10, long r11, float r13, long r14, float r16, long r17) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        r0.set(r16, r17);
        return r0;
    }
}
