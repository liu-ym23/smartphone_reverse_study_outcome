package kotlin.collections;

import android.util.EventsUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"kotlin/collections/ArraysKt__ArraysJVMKt", "kotlin/collections/ArraysKt__ArraysKt", "kotlin/collections/ArraysKt___ArraysJvmKt", "kotlin/collections/ArraysKt___ArraysKt"}, k = 4, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA)
public final class ArraysKt extends ArraysKt___ArraysKt {
    public static /* bridge */ /* synthetic */ boolean any(byte[] r0) {
        return ArraysKt___ArraysKt.any(r0);
    }

    public static /* bridge */ /* synthetic */ boolean any(int[] r0) {
        return ArraysKt___ArraysKt.any(r0);
    }

    public static /* bridge */ /* synthetic */ boolean any(long[] r0) {
        return ArraysKt___ArraysKt.any(r0);
    }

    public static /* bridge */ /* synthetic */ boolean any(short[] r0) {
        return ArraysKt___ArraysKt.any(r0);
    }

    public static /* bridge */ /* synthetic */ Iterable asIterable(double[] r0) {
        return ArraysKt___ArraysKt.asIterable(r0);
    }

    public static /* bridge */ /* synthetic */ Iterable asIterable(float[] r0) {
        return ArraysKt___ArraysKt.asIterable(r0);
    }

    public static /* bridge */ /* synthetic */ Iterable asIterable(int[] r0) {
        return ArraysKt___ArraysKt.asIterable(r0);
    }

    public static /* bridge */ /* synthetic */ Iterable asIterable(long[] r0) {
        return ArraysKt___ArraysKt.asIterable(r0);
    }

    public static /* bridge */ /* synthetic */ Iterable asIterable(Object[] r0) {
        return ArraysKt___ArraysKt.asIterable(r0);
    }

    public static /* bridge */ /* synthetic */ List asList(double[] r0) {
        return ArraysKt___ArraysJvmKt.asList(r0);
    }

    public static /* bridge */ /* synthetic */ List asList(int[] r0) {
        return ArraysKt___ArraysJvmKt.asList(r0);
    }

    public static /* bridge */ /* synthetic */ List asList(long[] r0) {
        return ArraysKt___ArraysJvmKt.asList(r0);
    }

    public static /* bridge */ /* synthetic */ List asList(Object[] r0) {
        return ArraysKt___ArraysJvmKt.asList(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence asSequence(Object[] r0) {
        return ArraysKt___ArraysKt.asSequence(r0);
    }

    public static /* bridge */ /* synthetic */ double average(long[] r2) {
        return ArraysKt___ArraysKt.average(r2);
    }

    public static /* bridge */ /* synthetic */ int binarySearch$default(float[] r0, float r1, int r2, int r3, int r4, Object r5) {
        return ArraysKt___ArraysJvmKt.binarySearch$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ boolean contains(byte[] r0, byte r1) {
        return ArraysKt___ArraysKt.contains(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean contains(char[] r0, char r1) {
        return ArraysKt___ArraysKt.contains(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean contains(int[] r0, int r1) {
        return ArraysKt___ArraysKt.contains(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean contains(long[] r0, long r1) {
        return ArraysKt___ArraysKt.contains(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean contains(Object[] r0, Object r1) {
        return ArraysKt___ArraysKt.contains(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean contains(short[] r0, short r1) {
        return ArraysKt___ArraysKt.contains(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean contains(boolean[] r0, boolean r1) {
        return ArraysKt___ArraysKt.contains(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean contentDeepEquals(Object[] r0, Object[] r1) {
        return ArraysKt__ArraysKt.contentDeepEquals(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int contentDeepHashCode(Object[] r0) {
        return ArraysKt__ArraysJVMKt.contentDeepHashCode(r0);
    }

    public static /* bridge */ /* synthetic */ String contentDeepToString(Object[] r0) {
        return ArraysKt__ArraysKt.contentDeepToString(r0);
    }

    public static /* bridge */ /* synthetic */ byte[] copyInto(byte[] r0, byte[] r1, int r2, int r3, int r4) {
        return ArraysKt___ArraysJvmKt.copyInto(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ char[] copyInto(char[] r0, char[] r1, int r2, int r3, int r4) {
        return ArraysKt___ArraysJvmKt.copyInto(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ double[] copyInto(double[] r0, double[] r1, int r2, int r3, int r4) {
        return ArraysKt___ArraysJvmKt.copyInto(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ float[] copyInto(float[] r0, float[] r1, int r2, int r3, int r4) {
        return ArraysKt___ArraysJvmKt.copyInto(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ int[] copyInto(int[] r0, int[] r1, int r2, int r3, int r4) {
        return ArraysKt___ArraysJvmKt.copyInto(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ long[] copyInto(long[] r0, long[] r1, int r2, int r3, int r4) {
        return ArraysKt___ArraysJvmKt.copyInto(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ Object[] copyInto(Object[] r0, Object[] r1, int r2, int r3, int r4) {
        return ArraysKt___ArraysJvmKt.copyInto(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ short[] copyInto(short[] r0, short[] r1, int r2, int r3, int r4) {
        return ArraysKt___ArraysJvmKt.copyInto(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ byte[] copyInto$default(byte[] r0, byte[] r1, int r2, int r3, int r4, int r5, Object r6) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* bridge */ /* synthetic */ double[] copyInto$default(double[] r0, double[] r1, int r2, int r3, int r4, int r5, Object r6) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* bridge */ /* synthetic */ float[] copyInto$default(float[] r0, float[] r1, int r2, int r3, int r4, int r5, Object r6) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* bridge */ /* synthetic */ int[] copyInto$default(int[] r0, int[] r1, int r2, int r3, int r4, int r5, Object r6) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* bridge */ /* synthetic */ long[] copyInto$default(long[] r0, long[] r1, int r2, int r3, int r4, int r5, Object r6) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* bridge */ /* synthetic */ Object[] copyInto$default(Object[] r0, Object[] r1, int r2, int r3, int r4, int r5, Object r6) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* bridge */ /* synthetic */ byte[] copyOfRange(byte[] r0, int r1, int r2) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ char[] copyOfRange(char[] r0, int r1, int r2) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ double[] copyOfRange(double[] r0, int r1, int r2) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ float[] copyOfRange(float[] r0, int r1, int r2) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ int[] copyOfRange(int[] r0, int r1, int r2) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ long[] copyOfRange(long[] r0, int r1, int r2) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ Object[] copyOfRange(Object[] r0, int r1, int r2) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ short[] copyOfRange(short[] r0, int r1, int r2) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ List distinct(Object[] r0) {
        return ArraysKt___ArraysKt.distinct(r0);
    }

    public static /* bridge */ /* synthetic */ List drop(Object[] r0, int r1) {
        return ArraysKt___ArraysKt.drop(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List dropLast(Object[] r0, int r1) {
        return ArraysKt___ArraysKt.dropLast(r0, r1);
    }

    public static /* bridge */ /* synthetic */ void fill(byte[] r0, byte r1, int r2, int r3) {
        ArraysKt___ArraysJvmKt.fill(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ void fill(float[] r0, float r1, int r2, int r3) {
        ArraysKt___ArraysJvmKt.fill(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ void fill(int[] r0, int r1, int r2, int r3) {
        ArraysKt___ArraysJvmKt.fill(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ void fill(long[] r0, long r1, int r3, int r4) {
        ArraysKt___ArraysJvmKt.fill(r0, r1, r3, r4);
    }

    public static /* bridge */ /* synthetic */ void fill(Object[] r0, Object r1, int r2, int r3) {
        ArraysKt___ArraysJvmKt.fill(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ void fill(short[] r0, short r1, int r2, int r3) {
        ArraysKt___ArraysJvmKt.fill(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ void fill$default(byte[] r0, byte r1, int r2, int r3, int r4, Object r5) {
        ArraysKt___ArraysJvmKt.fill$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ void fill$default(float[] r0, float r1, int r2, int r3, int r4, Object r5) {
        ArraysKt___ArraysJvmKt.fill$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ void fill$default(int[] r0, int r1, int r2, int r3, int r4, Object r5) {
        ArraysKt___ArraysJvmKt.fill$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ void fill$default(long[] r0, long r1, int r3, int r4, int r5, Object r6) {
        ArraysKt___ArraysJvmKt.fill$default(r0, r1, r3, r4, r5, r6);
    }

    public static /* bridge */ /* synthetic */ void fill$default(Object[] r0, Object r1, int r2, int r3, int r4, Object r5) {
        ArraysKt___ArraysJvmKt.fill$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ List filterIsInstance(Object[] r0, Class r1) {
        return ArraysKt___ArraysJvmKt.filterIsInstance(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List filterNotNull(Object[] r0) {
        return ArraysKt___ArraysKt.filterNotNull(r0);
    }

    public static /* bridge */ /* synthetic */ byte first(byte[] r0) {
        return ArraysKt___ArraysKt.first(r0);
    }

    public static /* bridge */ /* synthetic */ float first(float[] r0) {
        return ArraysKt___ArraysKt.first(r0);
    }

    public static /* bridge */ /* synthetic */ int first(int[] r0) {
        return ArraysKt___ArraysKt.first(r0);
    }

    public static /* bridge */ /* synthetic */ long first(long[] r2) {
        return ArraysKt___ArraysKt.first(r2);
    }

    public static /* bridge */ /* synthetic */ Object first(Object[] r0) {
        return ArraysKt___ArraysKt.first(r0);
    }

    public static /* bridge */ /* synthetic */ short first(short[] r0) {
        return ArraysKt___ArraysKt.first(r0);
    }

    public static /* bridge */ /* synthetic */ boolean first(boolean[] r0) {
        return ArraysKt___ArraysKt.first(r0);
    }

    public static /* bridge */ /* synthetic */ Byte firstOrNull(byte[] r0) {
        return ArraysKt___ArraysKt.firstOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Float firstOrNull(float[] r0) {
        return ArraysKt___ArraysKt.firstOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Integer firstOrNull(int[] r0) {
        return ArraysKt___ArraysKt.firstOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Object firstOrNull(Object[] r0) {
        return ArraysKt___ArraysKt.firstOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(byte[] r0) {
        return ArraysKt___ArraysKt.getIndices(r0);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(int[] r0) {
        return ArraysKt___ArraysKt.getIndices(r0);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(long[] r0) {
        return ArraysKt___ArraysKt.getIndices(r0);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(Object[] r0) {
        return ArraysKt___ArraysKt.getIndices(r0);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(short[] r0) {
        return ArraysKt___ArraysKt.getIndices(r0);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(byte[] r0) {
        return ArraysKt___ArraysKt.getLastIndex(r0);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(float[] r0) {
        return ArraysKt___ArraysKt.getLastIndex(r0);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(int[] r0) {
        return ArraysKt___ArraysKt.getLastIndex(r0);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(long[] r0) {
        return ArraysKt___ArraysKt.getLastIndex(r0);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(Object[] r0) {
        return ArraysKt___ArraysKt.getLastIndex(r0);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(short[] r0) {
        return ArraysKt___ArraysKt.getLastIndex(r0);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(boolean[] r0) {
        return ArraysKt___ArraysKt.getLastIndex(r0);
    }

    public static /* bridge */ /* synthetic */ Boolean getOrNull(boolean[] r0, int r1) {
        return ArraysKt___ArraysKt.getOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Byte getOrNull(byte[] r0, int r1) {
        return ArraysKt___ArraysKt.getOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Float getOrNull(float[] r0, int r1) {
        return ArraysKt___ArraysKt.getOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Integer getOrNull(int[] r0, int r1) {
        return ArraysKt___ArraysKt.getOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Long getOrNull(long[] r0, int r1) {
        return ArraysKt___ArraysKt.getOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object getOrNull(Object[] r0, int r1) {
        return ArraysKt___ArraysKt.getOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int indexOf(byte[] r0, byte r1) {
        return ArraysKt___ArraysKt.indexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int indexOf(char[] r0, char r1) {
        return ArraysKt___ArraysKt.indexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int indexOf(int[] r0, int r1) {
        return ArraysKt___ArraysKt.indexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int indexOf(long[] r0, long r1) {
        return ArraysKt___ArraysKt.indexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int indexOf(Object[] r0, Object r1) {
        return ArraysKt___ArraysKt.indexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int indexOf(short[] r0, short r1) {
        return ArraysKt___ArraysKt.indexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Appendable joinTo$default(Object[] r0, Appendable r1, CharSequence r2, CharSequence r3, CharSequence r4, int r5, CharSequence r6, Function1 r7, int r8, Object r9) {
        return ArraysKt___ArraysKt.joinTo$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(byte[] r0, CharSequence r1, CharSequence r2, CharSequence r3, int r4, CharSequence r5, Function1 r6, int r7, Object r8) {
        return ArraysKt___ArraysKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(char[] r0, CharSequence r1, CharSequence r2, CharSequence r3, int r4, CharSequence r5, Function1 r6, int r7, Object r8) {
        return ArraysKt___ArraysKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(double[] r0, CharSequence r1, CharSequence r2, CharSequence r3, int r4, CharSequence r5, Function1 r6, int r7, Object r8) {
        return ArraysKt___ArraysKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(float[] r0, CharSequence r1, CharSequence r2, CharSequence r3, int r4, CharSequence r5, Function1 r6, int r7, Object r8) {
        return ArraysKt___ArraysKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(int[] r0, CharSequence r1, CharSequence r2, CharSequence r3, int r4, CharSequence r5, Function1 r6, int r7, Object r8) {
        return ArraysKt___ArraysKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(long[] r0, CharSequence r1, CharSequence r2, CharSequence r3, int r4, CharSequence r5, Function1 r6, int r7, Object r8) {
        return ArraysKt___ArraysKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(Object[] r0, CharSequence r1, CharSequence r2, CharSequence r3, int r4, CharSequence r5, Function1 r6, int r7, Object r8) {
        return ArraysKt___ArraysKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(short[] r0, CharSequence r1, CharSequence r2, CharSequence r3, int r4, CharSequence r5, Function1 r6, int r7, Object r8) {
        return ArraysKt___ArraysKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(boolean[] r0, CharSequence r1, CharSequence r2, CharSequence r3, int r4, CharSequence r5, Function1 r6, int r7, Object r8) {
        return ArraysKt___ArraysKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* bridge */ /* synthetic */ byte last(byte[] r0) {
        return ArraysKt___ArraysKt.last(r0);
    }

    public static /* bridge */ /* synthetic */ char last(char[] r0) {
        return ArraysKt___ArraysKt.last(r0);
    }

    public static /* bridge */ /* synthetic */ float last(float[] r0) {
        return ArraysKt___ArraysKt.last(r0);
    }

    public static /* bridge */ /* synthetic */ int last(int[] r0) {
        return ArraysKt___ArraysKt.last(r0);
    }

    public static /* bridge */ /* synthetic */ long last(long[] r2) {
        return ArraysKt___ArraysKt.last(r2);
    }

    public static /* bridge */ /* synthetic */ Object last(Object[] r0) {
        return ArraysKt___ArraysKt.last(r0);
    }

    public static /* bridge */ /* synthetic */ short last(short[] r0) {
        return ArraysKt___ArraysKt.last(r0);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(byte[] r0, byte r1) {
        return ArraysKt___ArraysKt.lastIndexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(int[] r0, int r1) {
        return ArraysKt___ArraysKt.lastIndexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(long[] r0, long r1) {
        return ArraysKt___ArraysKt.lastIndexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(Object[] r0, Object r1) {
        return ArraysKt___ArraysKt.lastIndexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(short[] r0, short r1) {
        return ArraysKt___ArraysKt.lastIndexOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Float lastOrNull(float[] r0) {
        return ArraysKt___ArraysKt.lastOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Integer lastOrNull(int[] r0) {
        return ArraysKt___ArraysKt.lastOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Object lastOrNull(Object[] r0) {
        return ArraysKt___ArraysKt.lastOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ List map(Object[] r0, Function1 r1) {
        return ArraysKt___ArraysKt.map(r0, r1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static /* bridge */ /* synthetic */ Integer max(int[] r0) {
        return ArraysKt___ArraysJvmKt.max(r0);
    }

    public static /* bridge */ /* synthetic */ Float maxOrNull(float[] r0) {
        return ArraysKt___ArraysKt.maxOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Integer maxOrNull(int[] r0) {
        return ArraysKt___ArraysKt.maxOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ int maxOrThrow(int[] r0) {
        return ArraysKt___ArraysKt.maxOrThrow(r0);
    }

    public static /* bridge */ /* synthetic */ Float minOrNull(float[] r0) {
        return ArraysKt___ArraysKt.minOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Integer minOrNull(int[] r0) {
        return ArraysKt___ArraysKt.minOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ int minOrThrow(int[] r0) {
        return ArraysKt___ArraysKt.minOrThrow(r0);
    }

    public static /* bridge */ /* synthetic */ byte[] plus(byte[] r0, byte r1) {
        return ArraysKt___ArraysJvmKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ byte[] plus(byte[] r0, byte[] r1) {
        return ArraysKt___ArraysJvmKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int[] plus(int[] r0, int r1) {
        return ArraysKt___ArraysJvmKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int[] plus(int[] r0, int[] r1) {
        return ArraysKt___ArraysJvmKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ long[] plus(long[] r0, long r1) {
        return ArraysKt___ArraysJvmKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ long[] plus(long[] r0, long[] r1) {
        return ArraysKt___ArraysJvmKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object[] plus(Object[] r0, Object r1) {
        return ArraysKt___ArraysJvmKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object[] plus(Object[] r0, Collection r1) {
        return ArraysKt___ArraysJvmKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object[] plus(Object[] r0, Object[] r1) {
        return ArraysKt___ArraysJvmKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ short[] plus(short[] r0, short r1) {
        return ArraysKt___ArraysJvmKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ short[] plus(short[] r0, short[] r1) {
        return ArraysKt___ArraysJvmKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ void reverse(byte[] r0) {
        ArraysKt___ArraysKt.reverse(r0);
    }

    public static /* bridge */ /* synthetic */ void reverse(byte[] r0, int r1, int r2) {
        ArraysKt___ArraysKt.reverse(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ void reverse(int[] r0) {
        ArraysKt___ArraysKt.reverse(r0);
    }

    public static /* bridge */ /* synthetic */ void reverse(int[] r0, int r1, int r2) {
        ArraysKt___ArraysKt.reverse(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ void reverse(long[] r0) {
        ArraysKt___ArraysKt.reverse(r0);
    }

    public static /* bridge */ /* synthetic */ void reverse(long[] r0, int r1, int r2) {
        ArraysKt___ArraysKt.reverse(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ void reverse(Object[] r0) {
        ArraysKt___ArraysKt.reverse(r0);
    }

    public static /* bridge */ /* synthetic */ void reverse(short[] r0) {
        ArraysKt___ArraysKt.reverse(r0);
    }

    public static /* bridge */ /* synthetic */ void reverse(short[] r0, int r1, int r2) {
        ArraysKt___ArraysKt.reverse(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ List reversed(Object[] r0) {
        return ArraysKt___ArraysKt.reversed(r0);
    }

    public static /* bridge */ /* synthetic */ byte[] reversedArray(byte[] r0) {
        return ArraysKt___ArraysKt.reversedArray(r0);
    }

    public static /* bridge */ /* synthetic */ int[] reversedArray(int[] r0) {
        return ArraysKt___ArraysKt.reversedArray(r0);
    }

    public static /* bridge */ /* synthetic */ long[] reversedArray(long[] r0) {
        return ArraysKt___ArraysKt.reversedArray(r0);
    }

    public static /* bridge */ /* synthetic */ short[] reversedArray(short[] r0) {
        return ArraysKt___ArraysKt.reversedArray(r0);
    }

    public static /* bridge */ /* synthetic */ byte single(byte[] r0) {
        return ArraysKt___ArraysKt.single(r0);
    }

    public static /* bridge */ /* synthetic */ char single(char[] r0) {
        return ArraysKt___ArraysKt.single(r0);
    }

    public static /* bridge */ /* synthetic */ int single(int[] r0) {
        return ArraysKt___ArraysKt.single(r0);
    }

    public static /* bridge */ /* synthetic */ long single(long[] r2) {
        return ArraysKt___ArraysKt.single(r2);
    }

    public static /* bridge */ /* synthetic */ Object single(Object[] r0) {
        return ArraysKt___ArraysKt.single(r0);
    }

    public static /* bridge */ /* synthetic */ short single(short[] r0) {
        return ArraysKt___ArraysKt.single(r0);
    }

    public static /* bridge */ /* synthetic */ Object singleOrNull(Object[] r0) {
        return ArraysKt___ArraysKt.singleOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ List slice(Object[] r0, IntRange r1) {
        return ArraysKt___ArraysKt.slice(r0, r1);
    }

    public static /* bridge */ /* synthetic */ byte[] sliceArray(byte[] r0, Collection r1) {
        return ArraysKt___ArraysKt.sliceArray(r0, r1);
    }

    public static /* bridge */ /* synthetic */ byte[] sliceArray(byte[] r0, IntRange r1) {
        return ArraysKt___ArraysKt.sliceArray(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int[] sliceArray(int[] r0, Collection r1) {
        return ArraysKt___ArraysKt.sliceArray(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int[] sliceArray(int[] r0, IntRange r1) {
        return ArraysKt___ArraysKt.sliceArray(r0, r1);
    }

    public static /* bridge */ /* synthetic */ long[] sliceArray(long[] r0, Collection r1) {
        return ArraysKt___ArraysKt.sliceArray(r0, r1);
    }

    public static /* bridge */ /* synthetic */ long[] sliceArray(long[] r0, IntRange r1) {
        return ArraysKt___ArraysKt.sliceArray(r0, r1);
    }

    public static /* bridge */ /* synthetic */ short[] sliceArray(short[] r0, Collection r1) {
        return ArraysKt___ArraysKt.sliceArray(r0, r1);
    }

    public static /* bridge */ /* synthetic */ short[] sliceArray(short[] r0, IntRange r1) {
        return ArraysKt___ArraysKt.sliceArray(r0, r1);
    }

    public static /* bridge */ /* synthetic */ void sort(double[] r0, int r1, int r2) {
        ArraysKt___ArraysJvmKt.sort(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ void sort(float[] r0, int r1, int r2) {
        ArraysKt___ArraysJvmKt.sort(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ void sort(int[] r0) {
        ArraysKt___ArraysJvmKt.sort(r0);
    }

    public static /* bridge */ /* synthetic */ void sort(int[] r0, int r1, int r2) {
        ArraysKt___ArraysJvmKt.sort(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ void sort(long[] r0, int r1, int r2) {
        ArraysKt___ArraysJvmKt.sort(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ void sort(Object[] r0) {
        ArraysKt___ArraysJvmKt.sort(r0);
    }

    public static /* bridge */ /* synthetic */ void sortDescending(double[] r0, int r1, int r2) {
        ArraysKt___ArraysKt.sortDescending(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ void sortDescending(float[] r0) {
        ArraysKt___ArraysKt.sortDescending(r0);
    }

    public static /* bridge */ /* synthetic */ void sortDescending(float[] r0, int r1, int r2) {
        ArraysKt___ArraysKt.sortDescending(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ void sortDescending(int[] r0, int r1, int r2) {
        ArraysKt___ArraysKt.sortDescending(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ void sortDescending(long[] r0, int r1, int r2) {
        ArraysKt___ArraysKt.sortDescending(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ void sortWith(Object[] r0, Comparator r1) {
        ArraysKt___ArraysJvmKt.sortWith(r0, r1);
    }

    public static /* bridge */ /* synthetic */ void sortWith(Object[] r0, Comparator r1, int r2, int r3) {
        ArraysKt___ArraysJvmKt.sortWith(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ float[] sortedArrayDescending(float[] r0) {
        return ArraysKt___ArraysKt.sortedArrayDescending(r0);
    }

    public static /* bridge */ /* synthetic */ List sortedWith(Object[] r0, Comparator r1) {
        return ArraysKt___ArraysKt.sortedWith(r0, r1);
    }

    public static /* bridge */ /* synthetic */ float sum(float[] r0) {
        return ArraysKt___ArraysKt.sum(r0);
    }

    public static /* bridge */ /* synthetic */ int sum(int[] r0) {
        return ArraysKt___ArraysKt.sum(r0);
    }

    public static /* bridge */ /* synthetic */ long sum(long[] r2) {
        return ArraysKt___ArraysKt.sum(r2);
    }

    public static /* bridge */ /* synthetic */ List take(byte[] r0, int r1) {
        return ArraysKt___ArraysKt.take(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List take(float[] r0, int r1) {
        return ArraysKt___ArraysKt.take(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List take(Object[] r0, int r1) {
        return ArraysKt___ArraysKt.take(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List takeLast(byte[] r0, int r1) {
        return ArraysKt___ArraysKt.takeLast(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List takeLast(Object[] r0, int r1) {
        return ArraysKt___ArraysKt.takeLast(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List takeLast(boolean[] r0, int r1) {
        return ArraysKt___ArraysKt.takeLast(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Collection toCollection(int[] r0, Collection r1) {
        return ArraysKt___ArraysKt.toCollection(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Collection toCollection(long[] r0, Collection r1) {
        return ArraysKt___ArraysKt.toCollection(r0, r1);
    }

    public static /* bridge */ /* synthetic */ float[] toFloatArray(Float[] r0) {
        return ArraysKt___ArraysKt.toFloatArray(r0);
    }

    public static /* bridge */ /* synthetic */ HashSet toHashSet(Object[] r0) {
        return ArraysKt___ArraysKt.toHashSet(r0);
    }

    public static /* bridge */ /* synthetic */ int[] toIntArray(Integer[] r0) {
        return ArraysKt___ArraysKt.toIntArray(r0);
    }

    public static /* bridge */ /* synthetic */ List toList(byte[] r0) {
        return ArraysKt___ArraysKt.toList(r0);
    }

    public static /* bridge */ /* synthetic */ List toList(char[] r0) {
        return ArraysKt___ArraysKt.toList(r0);
    }

    public static /* bridge */ /* synthetic */ List toList(double[] r0) {
        return ArraysKt___ArraysKt.toList(r0);
    }

    public static /* bridge */ /* synthetic */ List toList(float[] r0) {
        return ArraysKt___ArraysKt.toList(r0);
    }

    public static /* bridge */ /* synthetic */ List toList(int[] r0) {
        return ArraysKt___ArraysKt.toList(r0);
    }

    public static /* bridge */ /* synthetic */ List toList(long[] r0) {
        return ArraysKt___ArraysKt.toList(r0);
    }

    public static /* bridge */ /* synthetic */ List toList(Object[] r0) {
        return ArraysKt___ArraysKt.toList(r0);
    }

    public static /* bridge */ /* synthetic */ List toList(short[] r0) {
        return ArraysKt___ArraysKt.toList(r0);
    }

    public static /* bridge */ /* synthetic */ List toList(boolean[] r0) {
        return ArraysKt___ArraysKt.toList(r0);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(byte[] r0) {
        return ArraysKt___ArraysKt.toMutableList(r0);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(int[] r0) {
        return ArraysKt___ArraysKt.toMutableList(r0);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(Object[] r0) {
        return ArraysKt___ArraysKt.toMutableList(r0);
    }

    public static /* bridge */ /* synthetic */ Set toMutableSet(Object[] r0) {
        return ArraysKt___ArraysKt.toMutableSet(r0);
    }

    public static /* bridge */ /* synthetic */ Set toSet(int[] r0) {
        return ArraysKt___ArraysKt.toSet(r0);
    }

    public static /* bridge */ /* synthetic */ Set toSet(Object[] r0) {
        return ArraysKt___ArraysKt.toSet(r0);
    }

    public static /* bridge */ /* synthetic */ Iterable withIndex(Object[] r0) {
        return ArraysKt___ArraysKt.withIndex(r0);
    }

    public static /* bridge */ /* synthetic */ List zip(Object[] r0, Iterable r1) {
        return ArraysKt___ArraysKt.zip(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List zip(Object[] r0, Object[] r1) {
        return ArraysKt___ArraysKt.zip(r0, r1);
    }

    private ArraysKt() {
    }
}
