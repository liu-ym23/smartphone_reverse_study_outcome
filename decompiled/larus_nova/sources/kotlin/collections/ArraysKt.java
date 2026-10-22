package kotlin.collections;

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

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"kotlin/collections/ArraysKt__ArraysJVMKt", "kotlin/collections/ArraysKt__ArraysKt", "kotlin/collections/ArraysKt___ArraysJvmKt", "kotlin/collections/ArraysKt___ArraysKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class ArraysKt extends ArraysKt___ArraysKt {
    public static /* bridge */ /* synthetic */ boolean any(byte[] r100) {
        return ArraysKt___ArraysKt.any(r100);
    }

    public static /* bridge */ /* synthetic */ boolean any(int[] r100) {
        return ArraysKt___ArraysKt.any(r100);
    }

    public static /* bridge */ /* synthetic */ boolean any(long[] r100) {
        return ArraysKt___ArraysKt.any(r100);
    }

    public static /* bridge */ /* synthetic */ boolean any(short[] r100) {
        return ArraysKt___ArraysKt.any(r100);
    }

    public static /* bridge */ /* synthetic */ Iterable asIterable(double[] r100) {
        return ArraysKt___ArraysKt.asIterable(r100);
    }

    public static /* bridge */ /* synthetic */ Iterable asIterable(float[] r100) {
        return ArraysKt___ArraysKt.asIterable(r100);
    }

    public static /* bridge */ /* synthetic */ Iterable asIterable(int[] r100) {
        return ArraysKt___ArraysKt.asIterable(r100);
    }

    public static /* bridge */ /* synthetic */ Iterable asIterable(long[] r100) {
        return ArraysKt___ArraysKt.asIterable(r100);
    }

    public static /* bridge */ /* synthetic */ Iterable asIterable(Object[] r100) {
        return ArraysKt___ArraysKt.asIterable(r100);
    }

    public static /* bridge */ /* synthetic */ List asList(double[] r100) {
        return ArraysKt___ArraysJvmKt.asList(r100);
    }

    public static /* bridge */ /* synthetic */ List asList(int[] r100) {
        return ArraysKt___ArraysJvmKt.asList(r100);
    }

    public static /* bridge */ /* synthetic */ List asList(long[] r100) {
        return ArraysKt___ArraysJvmKt.asList(r100);
    }

    public static /* bridge */ /* synthetic */ List asList(Object[] r100) {
        return ArraysKt___ArraysJvmKt.asList(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence asSequence(Object[] r100) {
        return ArraysKt___ArraysKt.asSequence(r100);
    }

    public static /* bridge */ /* synthetic */ double average(long[] r100) {
        return ArraysKt___ArraysKt.average(r100);
    }

    public static /* bridge */ /* synthetic */ int binarySearch$default(float[] r100, float r101, int r102, int r103, int r104, Object r105) {
        return ArraysKt___ArraysJvmKt.binarySearch$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ boolean contains(byte[] r100, byte r101) {
        return ArraysKt___ArraysKt.contains(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean contains(char[] r100, char r101) {
        return ArraysKt___ArraysKt.contains(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean contains(int[] r100, int r101) {
        return ArraysKt___ArraysKt.contains(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean contains(long[] r100, long r101) {
        return ArraysKt___ArraysKt.contains(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean contains(Object[] r100, Object r101) {
        return ArraysKt___ArraysKt.contains(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean contains(short[] r100, short r101) {
        return ArraysKt___ArraysKt.contains(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean contains(boolean[] r100, boolean r101) {
        return ArraysKt___ArraysKt.contains(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean contentDeepEquals(Object[] r100, Object[] r101) {
        return ArraysKt__ArraysKt.contentDeepEquals(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int contentDeepHashCode(Object[] r100) {
        return ArraysKt__ArraysJVMKt.contentDeepHashCode(r100);
    }

    public static /* bridge */ /* synthetic */ String contentDeepToString(Object[] r100) {
        return ArraysKt__ArraysKt.contentDeepToString(r100);
    }

    public static /* bridge */ /* synthetic */ byte[] copyInto(byte[] r100, byte[] r101, int r102, int r103, int r104) {
        return ArraysKt___ArraysJvmKt.copyInto(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ char[] copyInto(char[] r100, char[] r101, int r102, int r103, int r104) {
        return ArraysKt___ArraysJvmKt.copyInto(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ double[] copyInto(double[] r100, double[] r101, int r102, int r103, int r104) {
        return ArraysKt___ArraysJvmKt.copyInto(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ float[] copyInto(float[] r100, float[] r101, int r102, int r103, int r104) {
        return ArraysKt___ArraysJvmKt.copyInto(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ int[] copyInto(int[] r100, int[] r101, int r102, int r103, int r104) {
        return ArraysKt___ArraysJvmKt.copyInto(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ long[] copyInto(long[] r100, long[] r101, int r102, int r103, int r104) {
        return ArraysKt___ArraysJvmKt.copyInto(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ Object[] copyInto(Object[] r100, Object[] r101, int r102, int r103, int r104) {
        return ArraysKt___ArraysJvmKt.copyInto(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ short[] copyInto(short[] r100, short[] r101, int r102, int r103, int r104) {
        return ArraysKt___ArraysJvmKt.copyInto(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ byte[] copyInto$default(byte[] r100, byte[] r101, int r102, int r103, int r104, int r105, Object r106) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* bridge */ /* synthetic */ double[] copyInto$default(double[] r100, double[] r101, int r102, int r103, int r104, int r105, Object r106) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* bridge */ /* synthetic */ float[] copyInto$default(float[] r100, float[] r101, int r102, int r103, int r104, int r105, Object r106) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* bridge */ /* synthetic */ int[] copyInto$default(int[] r100, int[] r101, int r102, int r103, int r104, int r105, Object r106) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* bridge */ /* synthetic */ long[] copyInto$default(long[] r100, long[] r101, int r102, int r103, int r104, int r105, Object r106) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* bridge */ /* synthetic */ Object[] copyInto$default(Object[] r100, Object[] r101, int r102, int r103, int r104, int r105, Object r106) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* bridge */ /* synthetic */ byte[] copyOfRange(byte[] r100, int r101, int r102) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ char[] copyOfRange(char[] r100, int r101, int r102) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ double[] copyOfRange(double[] r100, int r101, int r102) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ float[] copyOfRange(float[] r100, int r101, int r102) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ int[] copyOfRange(int[] r100, int r101, int r102) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ long[] copyOfRange(long[] r100, int r101, int r102) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ Object[] copyOfRange(Object[] r100, int r101, int r102) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ short[] copyOfRange(short[] r100, int r101, int r102) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ List distinct(Object[] r100) {
        return ArraysKt___ArraysKt.distinct(r100);
    }

    public static /* bridge */ /* synthetic */ List drop(Object[] r100, int r101) {
        return ArraysKt___ArraysKt.drop(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List dropLast(Object[] r100, int r101) {
        return ArraysKt___ArraysKt.dropLast(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void fill(byte[] r100, byte r101, int r102, int r103) {
        ArraysKt___ArraysJvmKt.fill(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ void fill(float[] r100, float r101, int r102, int r103) {
        ArraysKt___ArraysJvmKt.fill(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ void fill(int[] r100, int r101, int r102, int r103) {
        ArraysKt___ArraysJvmKt.fill(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ void fill(long[] r100, long r101, int r102, int r103) {
        ArraysKt___ArraysJvmKt.fill(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ void fill(Object[] r100, Object r101, int r102, int r103) {
        ArraysKt___ArraysJvmKt.fill(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ void fill(short[] r100, short r101, int r102, int r103) {
        ArraysKt___ArraysJvmKt.fill(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ void fill$default(byte[] r100, byte r101, int r102, int r103, int r104, Object r105) {
        ArraysKt___ArraysJvmKt.fill$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ void fill$default(float[] r100, float r101, int r102, int r103, int r104, Object r105) {
        ArraysKt___ArraysJvmKt.fill$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ void fill$default(int[] r100, int r101, int r102, int r103, int r104, Object r105) {
        ArraysKt___ArraysJvmKt.fill$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ void fill$default(long[] r100, long r101, int r102, int r103, int r104, Object r105) {
        ArraysKt___ArraysJvmKt.fill$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ void fill$default(Object[] r100, Object r101, int r102, int r103, int r104, Object r105) {
        ArraysKt___ArraysJvmKt.fill$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ List filterIsInstance(Object[] r100, Class r101) {
        return ArraysKt___ArraysJvmKt.filterIsInstance(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List filterNotNull(Object[] r100) {
        return ArraysKt___ArraysKt.filterNotNull(r100);
    }

    public static /* bridge */ /* synthetic */ byte first(byte[] r100) {
        return ArraysKt___ArraysKt.first(r100);
    }

    public static /* bridge */ /* synthetic */ float first(float[] r100) {
        return ArraysKt___ArraysKt.first(r100);
    }

    public static /* bridge */ /* synthetic */ int first(int[] r100) {
        return ArraysKt___ArraysKt.first(r100);
    }

    public static /* bridge */ /* synthetic */ long first(long[] r100) {
        return ArraysKt___ArraysKt.first(r100);
    }

    public static /* bridge */ /* synthetic */ Object first(Object[] r100) {
        return ArraysKt___ArraysKt.first(r100);
    }

    public static /* bridge */ /* synthetic */ short first(short[] r100) {
        return ArraysKt___ArraysKt.first(r100);
    }

    public static /* bridge */ /* synthetic */ boolean first(boolean[] r100) {
        return ArraysKt___ArraysKt.first(r100);
    }

    public static /* bridge */ /* synthetic */ Byte firstOrNull(byte[] r100) {
        return ArraysKt___ArraysKt.firstOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Float firstOrNull(float[] r100) {
        return ArraysKt___ArraysKt.firstOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Integer firstOrNull(int[] r100) {
        return ArraysKt___ArraysKt.firstOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Object firstOrNull(Object[] r100) {
        return ArraysKt___ArraysKt.firstOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(byte[] r100) {
        return ArraysKt___ArraysKt.getIndices(r100);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(int[] r100) {
        return ArraysKt___ArraysKt.getIndices(r100);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(long[] r100) {
        return ArraysKt___ArraysKt.getIndices(r100);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(Object[] r100) {
        return ArraysKt___ArraysKt.getIndices(r100);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(short[] r100) {
        return ArraysKt___ArraysKt.getIndices(r100);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(byte[] r100) {
        return ArraysKt___ArraysKt.getLastIndex(r100);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(float[] r100) {
        return ArraysKt___ArraysKt.getLastIndex(r100);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(int[] r100) {
        return ArraysKt___ArraysKt.getLastIndex(r100);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(long[] r100) {
        return ArraysKt___ArraysKt.getLastIndex(r100);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(Object[] r100) {
        return ArraysKt___ArraysKt.getLastIndex(r100);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(short[] r100) {
        return ArraysKt___ArraysKt.getLastIndex(r100);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(boolean[] r100) {
        return ArraysKt___ArraysKt.getLastIndex(r100);
    }

    public static /* bridge */ /* synthetic */ Boolean getOrNull(boolean[] r100, int r101) {
        return ArraysKt___ArraysKt.getOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Byte getOrNull(byte[] r100, int r101) {
        return ArraysKt___ArraysKt.getOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Float getOrNull(float[] r100, int r101) {
        return ArraysKt___ArraysKt.getOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Integer getOrNull(int[] r100, int r101) {
        return ArraysKt___ArraysKt.getOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Long getOrNull(long[] r100, int r101) {
        return ArraysKt___ArraysKt.getOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object getOrNull(Object[] r100, int r101) {
        return ArraysKt___ArraysKt.getOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int indexOf(byte[] r100, byte r101) {
        return ArraysKt___ArraysKt.indexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int indexOf(char[] r100, char r101) {
        return ArraysKt___ArraysKt.indexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int indexOf(int[] r100, int r101) {
        return ArraysKt___ArraysKt.indexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int indexOf(long[] r100, long r101) {
        return ArraysKt___ArraysKt.indexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int indexOf(Object[] r100, Object r101) {
        return ArraysKt___ArraysKt.indexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int indexOf(short[] r100, short r101) {
        return ArraysKt___ArraysKt.indexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Appendable joinTo$default(Object[] r100, Appendable r101, CharSequence r102, CharSequence r103, CharSequence r104, int r105, CharSequence r106, Function1 r107, int r108, Object r109) {
        return ArraysKt___ArraysKt.joinTo$default(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(byte[] r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r106, int r107, Object r108) {
        return ArraysKt___ArraysKt.joinToString$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(char[] r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r106, int r107, Object r108) {
        return ArraysKt___ArraysKt.joinToString$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(double[] r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r106, int r107, Object r108) {
        return ArraysKt___ArraysKt.joinToString$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(float[] r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r106, int r107, Object r108) {
        return ArraysKt___ArraysKt.joinToString$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(int[] r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r106, int r107, Object r108) {
        return ArraysKt___ArraysKt.joinToString$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(long[] r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r106, int r107, Object r108) {
        return ArraysKt___ArraysKt.joinToString$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(Object[] r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r106, int r107, Object r108) {
        return ArraysKt___ArraysKt.joinToString$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(short[] r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r106, int r107, Object r108) {
        return ArraysKt___ArraysKt.joinToString$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(boolean[] r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r106, int r107, Object r108) {
        return ArraysKt___ArraysKt.joinToString$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static /* bridge */ /* synthetic */ byte last(byte[] r100) {
        return ArraysKt___ArraysKt.last(r100);
    }

    public static /* bridge */ /* synthetic */ char last(char[] r100) {
        return ArraysKt___ArraysKt.last(r100);
    }

    public static /* bridge */ /* synthetic */ float last(float[] r100) {
        return ArraysKt___ArraysKt.last(r100);
    }

    public static /* bridge */ /* synthetic */ int last(int[] r100) {
        return ArraysKt___ArraysKt.last(r100);
    }

    public static /* bridge */ /* synthetic */ long last(long[] r100) {
        return ArraysKt___ArraysKt.last(r100);
    }

    public static /* bridge */ /* synthetic */ Object last(Object[] r100) {
        return ArraysKt___ArraysKt.last(r100);
    }

    public static /* bridge */ /* synthetic */ short last(short[] r100) {
        return ArraysKt___ArraysKt.last(r100);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(byte[] r100, byte r101) {
        return ArraysKt___ArraysKt.lastIndexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(int[] r100, int r101) {
        return ArraysKt___ArraysKt.lastIndexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(long[] r100, long r101) {
        return ArraysKt___ArraysKt.lastIndexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(Object[] r100, Object r101) {
        return ArraysKt___ArraysKt.lastIndexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(short[] r100, short r101) {
        return ArraysKt___ArraysKt.lastIndexOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Float lastOrNull(float[] r100) {
        return ArraysKt___ArraysKt.lastOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Integer lastOrNull(int[] r100) {
        return ArraysKt___ArraysKt.lastOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Object lastOrNull(Object[] r100) {
        return ArraysKt___ArraysKt.lastOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ List map(Object[] r100, Function1 r101) {
        return ArraysKt___ArraysKt.map(r100, r101);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static /* bridge */ /* synthetic */ Integer max(int[] r100) {
        return ArraysKt___ArraysJvmKt.max(r100);
    }

    public static /* bridge */ /* synthetic */ Float maxOrNull(float[] r100) {
        return ArraysKt___ArraysKt.maxOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Integer maxOrNull(int[] r100) {
        return ArraysKt___ArraysKt.maxOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ int maxOrThrow(int[] r100) {
        return ArraysKt___ArraysKt.maxOrThrow(r100);
    }

    public static /* bridge */ /* synthetic */ Float minOrNull(float[] r100) {
        return ArraysKt___ArraysKt.minOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Integer minOrNull(int[] r100) {
        return ArraysKt___ArraysKt.minOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ int minOrThrow(int[] r100) {
        return ArraysKt___ArraysKt.minOrThrow(r100);
    }

    public static /* bridge */ /* synthetic */ byte[] plus(byte[] r100, byte r101) {
        return ArraysKt___ArraysJvmKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ byte[] plus(byte[] r100, byte[] r101) {
        return ArraysKt___ArraysJvmKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int[] plus(int[] r100, int r101) {
        return ArraysKt___ArraysJvmKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int[] plus(int[] r100, int[] r101) {
        return ArraysKt___ArraysJvmKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ long[] plus(long[] r100, long r101) {
        return ArraysKt___ArraysJvmKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ long[] plus(long[] r100, long[] r101) {
        return ArraysKt___ArraysJvmKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object[] plus(Object[] r100, Object r101) {
        return ArraysKt___ArraysJvmKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object[] plus(Object[] r100, Collection r101) {
        return ArraysKt___ArraysJvmKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object[] plus(Object[] r100, Object[] r101) {
        return ArraysKt___ArraysJvmKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ short[] plus(short[] r100, short r101) {
        return ArraysKt___ArraysJvmKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ short[] plus(short[] r100, short[] r101) {
        return ArraysKt___ArraysJvmKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void reverse(byte[] r100) {
        ArraysKt___ArraysKt.reverse(r100);
    }

    public static /* bridge */ /* synthetic */ void reverse(byte[] r100, int r101, int r102) {
        ArraysKt___ArraysKt.reverse(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ void reverse(int[] r100) {
        ArraysKt___ArraysKt.reverse(r100);
    }

    public static /* bridge */ /* synthetic */ void reverse(int[] r100, int r101, int r102) {
        ArraysKt___ArraysKt.reverse(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ void reverse(long[] r100) {
        ArraysKt___ArraysKt.reverse(r100);
    }

    public static /* bridge */ /* synthetic */ void reverse(long[] r100, int r101, int r102) {
        ArraysKt___ArraysKt.reverse(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ void reverse(Object[] r100) {
        ArraysKt___ArraysKt.reverse(r100);
    }

    public static /* bridge */ /* synthetic */ void reverse(short[] r100) {
        ArraysKt___ArraysKt.reverse(r100);
    }

    public static /* bridge */ /* synthetic */ void reverse(short[] r100, int r101, int r102) {
        ArraysKt___ArraysKt.reverse(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ List reversed(Object[] r100) {
        return ArraysKt___ArraysKt.reversed(r100);
    }

    public static /* bridge */ /* synthetic */ byte[] reversedArray(byte[] r100) {
        return ArraysKt___ArraysKt.reversedArray(r100);
    }

    public static /* bridge */ /* synthetic */ int[] reversedArray(int[] r100) {
        return ArraysKt___ArraysKt.reversedArray(r100);
    }

    public static /* bridge */ /* synthetic */ long[] reversedArray(long[] r100) {
        return ArraysKt___ArraysKt.reversedArray(r100);
    }

    public static /* bridge */ /* synthetic */ short[] reversedArray(short[] r100) {
        return ArraysKt___ArraysKt.reversedArray(r100);
    }

    public static /* bridge */ /* synthetic */ byte single(byte[] r100) {
        return ArraysKt___ArraysKt.single(r100);
    }

    public static /* bridge */ /* synthetic */ char single(char[] r100) {
        return ArraysKt___ArraysKt.single(r100);
    }

    public static /* bridge */ /* synthetic */ int single(int[] r100) {
        return ArraysKt___ArraysKt.single(r100);
    }

    public static /* bridge */ /* synthetic */ long single(long[] r100) {
        return ArraysKt___ArraysKt.single(r100);
    }

    public static /* bridge */ /* synthetic */ Object single(Object[] r100) {
        return ArraysKt___ArraysKt.single(r100);
    }

    public static /* bridge */ /* synthetic */ short single(short[] r100) {
        return ArraysKt___ArraysKt.single(r100);
    }

    public static /* bridge */ /* synthetic */ Object singleOrNull(Object[] r100) {
        return ArraysKt___ArraysKt.singleOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ List slice(Object[] r100, IntRange r101) {
        return ArraysKt___ArraysKt.slice(r100, r101);
    }

    public static /* bridge */ /* synthetic */ byte[] sliceArray(byte[] r100, Collection r101) {
        return ArraysKt___ArraysKt.sliceArray(r100, r101);
    }

    public static /* bridge */ /* synthetic */ byte[] sliceArray(byte[] r100, IntRange r101) {
        return ArraysKt___ArraysKt.sliceArray(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int[] sliceArray(int[] r100, Collection r101) {
        return ArraysKt___ArraysKt.sliceArray(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int[] sliceArray(int[] r100, IntRange r101) {
        return ArraysKt___ArraysKt.sliceArray(r100, r101);
    }

    public static /* bridge */ /* synthetic */ long[] sliceArray(long[] r100, Collection r101) {
        return ArraysKt___ArraysKt.sliceArray(r100, r101);
    }

    public static /* bridge */ /* synthetic */ long[] sliceArray(long[] r100, IntRange r101) {
        return ArraysKt___ArraysKt.sliceArray(r100, r101);
    }

    public static /* bridge */ /* synthetic */ short[] sliceArray(short[] r100, Collection r101) {
        return ArraysKt___ArraysKt.sliceArray(r100, r101);
    }

    public static /* bridge */ /* synthetic */ short[] sliceArray(short[] r100, IntRange r101) {
        return ArraysKt___ArraysKt.sliceArray(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void sort(double[] r100, int r101, int r102) {
        ArraysKt___ArraysJvmKt.sort(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ void sort(float[] r100, int r101, int r102) {
        ArraysKt___ArraysJvmKt.sort(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ void sort(int[] r100) {
        ArraysKt___ArraysJvmKt.sort(r100);
    }

    public static /* bridge */ /* synthetic */ void sort(int[] r100, int r101, int r102) {
        ArraysKt___ArraysJvmKt.sort(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ void sort(long[] r100, int r101, int r102) {
        ArraysKt___ArraysJvmKt.sort(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ void sort(Object[] r100) {
        ArraysKt___ArraysJvmKt.sort(r100);
    }

    public static /* bridge */ /* synthetic */ void sortDescending(double[] r100, int r101, int r102) {
        ArraysKt___ArraysKt.sortDescending(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ void sortDescending(float[] r100) {
        ArraysKt___ArraysKt.sortDescending(r100);
    }

    public static /* bridge */ /* synthetic */ void sortDescending(float[] r100, int r101, int r102) {
        ArraysKt___ArraysKt.sortDescending(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ void sortDescending(int[] r100, int r101, int r102) {
        ArraysKt___ArraysKt.sortDescending(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ void sortDescending(long[] r100, int r101, int r102) {
        ArraysKt___ArraysKt.sortDescending(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ void sortWith(Object[] r100, Comparator r101) {
        ArraysKt___ArraysJvmKt.sortWith(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void sortWith(Object[] r100, Comparator r101, int r102, int r103) {
        ArraysKt___ArraysJvmKt.sortWith(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ float[] sortedArrayDescending(float[] r100) {
        return ArraysKt___ArraysKt.sortedArrayDescending(r100);
    }

    public static /* bridge */ /* synthetic */ List sortedWith(Object[] r100, Comparator r101) {
        return ArraysKt___ArraysKt.sortedWith(r100, r101);
    }

    public static /* bridge */ /* synthetic */ float sum(float[] r100) {
        return ArraysKt___ArraysKt.sum(r100);
    }

    public static /* bridge */ /* synthetic */ int sum(int[] r100) {
        return ArraysKt___ArraysKt.sum(r100);
    }

    public static /* bridge */ /* synthetic */ long sum(long[] r100) {
        return ArraysKt___ArraysKt.sum(r100);
    }

    public static /* bridge */ /* synthetic */ List take(byte[] r100, int r101) {
        return ArraysKt___ArraysKt.take(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List take(float[] r100, int r101) {
        return ArraysKt___ArraysKt.take(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List take(Object[] r100, int r101) {
        return ArraysKt___ArraysKt.take(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List takeLast(byte[] r100, int r101) {
        return ArraysKt___ArraysKt.takeLast(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List takeLast(Object[] r100, int r101) {
        return ArraysKt___ArraysKt.takeLast(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List takeLast(boolean[] r100, int r101) {
        return ArraysKt___ArraysKt.takeLast(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Collection toCollection(int[] r100, Collection r101) {
        return ArraysKt___ArraysKt.toCollection(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Collection toCollection(long[] r100, Collection r101) {
        return ArraysKt___ArraysKt.toCollection(r100, r101);
    }

    public static /* bridge */ /* synthetic */ float[] toFloatArray(Float[] r100) {
        return ArraysKt___ArraysKt.toFloatArray(r100);
    }

    public static /* bridge */ /* synthetic */ HashSet toHashSet(Object[] r100) {
        return ArraysKt___ArraysKt.toHashSet(r100);
    }

    public static /* bridge */ /* synthetic */ int[] toIntArray(Integer[] r100) {
        return ArraysKt___ArraysKt.toIntArray(r100);
    }

    public static /* bridge */ /* synthetic */ List toList(byte[] r100) {
        return ArraysKt___ArraysKt.toList(r100);
    }

    public static /* bridge */ /* synthetic */ List toList(char[] r100) {
        return ArraysKt___ArraysKt.toList(r100);
    }

    public static /* bridge */ /* synthetic */ List toList(double[] r100) {
        return ArraysKt___ArraysKt.toList(r100);
    }

    public static /* bridge */ /* synthetic */ List toList(float[] r100) {
        return ArraysKt___ArraysKt.toList(r100);
    }

    public static /* bridge */ /* synthetic */ List toList(int[] r100) {
        return ArraysKt___ArraysKt.toList(r100);
    }

    public static /* bridge */ /* synthetic */ List toList(long[] r100) {
        return ArraysKt___ArraysKt.toList(r100);
    }

    public static /* bridge */ /* synthetic */ List toList(Object[] r100) {
        return ArraysKt___ArraysKt.toList(r100);
    }

    public static /* bridge */ /* synthetic */ List toList(short[] r100) {
        return ArraysKt___ArraysKt.toList(r100);
    }

    public static /* bridge */ /* synthetic */ List toList(boolean[] r100) {
        return ArraysKt___ArraysKt.toList(r100);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(byte[] r100) {
        return ArraysKt___ArraysKt.toMutableList(r100);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(int[] r100) {
        return ArraysKt___ArraysKt.toMutableList(r100);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(Object[] r100) {
        return ArraysKt___ArraysKt.toMutableList(r100);
    }

    public static /* bridge */ /* synthetic */ Set toMutableSet(Object[] r100) {
        return ArraysKt___ArraysKt.toMutableSet(r100);
    }

    public static /* bridge */ /* synthetic */ Set toSet(int[] r100) {
        return ArraysKt___ArraysKt.toSet(r100);
    }

    public static /* bridge */ /* synthetic */ Set toSet(Object[] r100) {
        return ArraysKt___ArraysKt.toSet(r100);
    }

    public static /* bridge */ /* synthetic */ Iterable withIndex(Object[] r100) {
        return ArraysKt___ArraysKt.withIndex(r100);
    }

    public static /* bridge */ /* synthetic */ List zip(Object[] r100, Iterable r101) {
        return ArraysKt___ArraysKt.zip(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List zip(Object[] r100, Object[] r101) {
        return ArraysKt___ArraysKt.zip(r100, r101);
    }

    private ArraysKt() {
    }
}
