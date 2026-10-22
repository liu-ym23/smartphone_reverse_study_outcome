package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007¨\u0006\u0018"}, d2 = {"maxOf", ExifInterface.GPS_DIRECTION_TRUE, "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    public ComparisonsKt___ComparisonsJvmKt() {
    }

    public static final <T extends Comparable<? super T>> T maxOf(T r100, T... r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        T r104 = r100;
        r100 = (T) maxOf(r104, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static final <T extends Comparable<? super T>> T minOf(T r100, T... r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        T r104 = r100;
        r100 = (T) minOf(r104, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static final byte maxOf(byte r100, byte... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = (byte) Math.max(r100, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static final byte minOf(byte r100, byte... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = (byte) Math.min(r100, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static final short maxOf(short r100, short... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = (short) Math.max(r100, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static final short minOf(short r100, short... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = (short) Math.min(r100, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static final double maxOf(double r100, double... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = Math.max(r100, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static final double minOf(double r100, double... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = Math.min(r100, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static float maxOf(float r100, float... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = Math.max(r100, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static float minOf(float r100, float... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = Math.min(r100, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static int maxOf(int r100, int... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = Math.max(r100, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static final int minOf(int r100, int... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = Math.min(r100, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static long maxOf(long r100, long... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = Math.max(r100, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static final long minOf(long r100, long... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = Math.min(r100, r101[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public static <T extends Comparable<? super T>> T maxOf(T r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        if (r100.compareTo(r101) < 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    public static final <T extends Comparable<? super T>> T minOf(T r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        if (r100.compareTo(r101) > 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    private static final byte maxOf(byte r100, byte r101) {
        return (byte) Math.max(r100, r101);
    }

    private static final byte minOf(byte r100, byte r101) {
        return (byte) Math.min(r100, r101);
    }

    private static final short maxOf(short r100, short r101) {
        return (short) Math.max(r100, r101);
    }

    private static final short minOf(short r100, short r101) {
        return (short) Math.min(r100, r101);
    }

    private static final double maxOf(double r100, double r101) {
        return Math.max(r100, r101);
    }

    private static final double minOf(double r100, double r101) {
        return Math.min(r100, r101);
    }

    private static final float maxOf(float r100, float r101) {
        return Math.max(r100, r101);
    }

    private static final float minOf(float r100, float r101) {
        return Math.min(r100, r101);
    }

    private static final int maxOf(int r100, int r101) {
        return Math.max(r100, r101);
    }

    private static final int minOf(int r100, int r101) {
        return Math.min(r100, r101);
    }

    private static final long maxOf(long r100, long r101) {
        return Math.max(r100, r101);
    }

    private static final long minOf(long r100, long r101) {
        return Math.min(r100, r101);
    }

    public static final <T extends Comparable<? super T>> T maxOf(T r100, T r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        Intrinsics.checkNotNullParameter(r102, "c");
        return (T) maxOf(r100, maxOf(r101, r102));
    }

    public static final <T extends Comparable<? super T>> T minOf(T r100, T r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        Intrinsics.checkNotNullParameter(r102, "c");
        return (T) minOf(r100, minOf(r101, r102));
    }

    private static final byte maxOf(byte r100, byte r101, byte r102) {
        return (byte) Math.max(r100, Math.max(r101, r102));
    }

    private static final byte minOf(byte r100, byte r101, byte r102) {
        return (byte) Math.min(r100, Math.min(r101, r102));
    }

    private static final short maxOf(short r100, short r101, short r102) {
        return (short) Math.max(r100, Math.max(r101, r102));
    }

    private static final short minOf(short r100, short r101, short r102) {
        return (short) Math.min(r100, Math.min(r101, r102));
    }

    private static final double maxOf(double r100, double r101, double r102) {
        return Math.max(r100, Math.max(r101, r102));
    }

    private static final double minOf(double r100, double r101, double r102) {
        return Math.min(r100, Math.min(r101, r102));
    }

    private static final float maxOf(float r100, float r101, float r102) {
        return Math.max(r100, Math.max(r101, r102));
    }

    private static final float minOf(float r100, float r101, float r102) {
        return Math.min(r100, Math.min(r101, r102));
    }

    private static final int maxOf(int r100, int r101, int r102) {
        return Math.max(r100, Math.max(r101, r102));
    }

    private static final int minOf(int r100, int r101, int r102) {
        return Math.min(r100, Math.min(r101, r102));
    }

    private static final long maxOf(long r100, long r101, long r102) {
        return Math.max(r100, Math.max(r101, r102));
    }

    private static final long minOf(long r100, long r101, long r102) {
        return Math.min(r100, Math.min(r101, r102));
    }
}
