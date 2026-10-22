package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0087\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0087\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0006H\u0087\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0087\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0087\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0087\u0002\u001a\u0015\u0010\t\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0087\u0002\u001a!\u0010\n\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0087\n\u001a\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0087\n\u001a\u0019\u0010\n\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0006H\u0087\n\u001a\u0019\u0010\n\u001a\u00020\u0007*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0087\n\u001a\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0087\n\u001a\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0087\n\u001a0\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f*\u0012\u0012\u0004\u0012\u0002H\f0\rj\b\u0012\u0004\u0012\u0002H\f`\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\n¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0087\u0002\u001a!\u0010\u0012\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0087\n\u001a\u001d\u0010\u0012\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0087\n\u001a\u0019\u0010\u0012\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0006H\u0087\n\u001a\u0019\u0010\u0012\u001a\u00020\u0007*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0087\n\u001a\u001d\u0010\u0012\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0087\n\u001a\u001d\u0010\u0012\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0087\n\u001a!\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0087\n\u001a\u001d\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0087\n\u001a\u0019\u0010\u0013\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0006H\u0087\n\u001a\u0019\u0010\u0013\u001a\u00020\u0007*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0087\n\u001a\u001d\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0087\n\u001a\u001d\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0087\n\u001a!\u0010\u0014\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0087\n\u001a\u001d\u0010\u0014\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0087\n\u001a\u0019\u0010\u0014\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0006H\u0087\n\u001a\u0019\u0010\u0014\u001a\u00020\u0007*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0087\n\u001a\u001d\u0010\u0014\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0087\n\u001a\u001d\u0010\u0014\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0087\n\u001a8\u0010\u0015\u001a\u0002H\f\"\u0004\b\u0000\u0010\f*\u0012\u0012\u0004\u0012\u0002H\f0\u0016j\b\u0012\u0004\u0012\u0002H\f`\u00172\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u0002H\fH\u0087\n¢\u0006\u0002\u0010\u0019\u001aJ\u0010\u0015\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\u001c*\u001e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c0\u001dj\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c`\u001e2\u0006\u0010\u001f\u001a\u0002H\u001b2\u0006\u0010\u0018\u001a\u0002H\u001cH\u0087\n¢\u0006\u0002\u0010 \u001a!\u0010!\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0087\n\u001a\u001d\u0010!\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0087\n\u001a\u0019\u0010!\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0006H\u0087\n\u001a\u0019\u0010!\u001a\u00020\u0007*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0087\n\u001a\u001d\u0010!\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0087\n\u001a\u001d\u0010!\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0087\n¨\u0006\""}, d2 = {"compareTo", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "other", "", "", "", "", "dec", "div", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "index", "(Ljava/util/List;I)Ljava/lang/Object;", "inc", "minus", "plus", "rem", "set", "", "Lcom/bytedance/revenue/platform/api/core/KmpMutableList;", "value", "(Ljava/util/List;ILjava/lang/Object;)Ljava/lang/Object;", "", "K", "V", "", "Lcom/bytedance/revenue/platform/api/core/KmpMutableMap;", "key", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "times", "lib-kmp-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class Hacks_jvmAndroidSharedKt {
    public static final long dec(long r100) {
        return r100 - 1;
    }

    private static final double div(long r100, double r101) {
        return r100 / r101;
    }

    private static final float div(long r100, float r101) {
        return r100 / r101;
    }

    public static final long inc(long r100) {
        return r100 + 1;
    }

    private static final double minus(long r100, double r101) {
        return r100 - r101;
    }

    private static final float minus(long r100, float r101) {
        return r100 - r101;
    }

    private static final long minus(long r100, byte r101) {
        return r100 - ((long) r101);
    }

    private static final long minus(long r100, int r101) {
        return r100 - ((long) r101);
    }

    private static final long minus(long r100, long r101) {
        return r100 - r101;
    }

    private static final long minus(long r100, short r101) {
        return r100 - ((long) r101);
    }

    private static final double plus(long r100, double r101) {
        return r100 + r101;
    }

    private static final float plus(long r100, float r101) {
        return r100 + r101;
    }

    private static final long plus(long r100, byte r101) {
        return r100 + ((long) r101);
    }

    private static final long plus(long r100, int r101) {
        return r100 + ((long) r101);
    }

    private static final long plus(long r100, long r101) {
        return r100 + r101;
    }

    private static final long plus(long r100, short r101) {
        return r100 + ((long) r101);
    }

    private static final double rem(long r100, double r101) {
        return r100 % r101;
    }

    private static final float rem(long r100, float r101) {
        return r100 % r101;
    }

    private static final double times(long r100, double r101) {
        return r100 * r101;
    }

    private static final float times(long r100, float r101) {
        return r100 * r101;
    }

    private static final long times(long r100, byte r101) {
        return r100 * ((long) r101);
    }

    private static final long times(long r100, int r101) {
        return r100 * ((long) r101);
    }

    private static final long times(long r100, long r101) {
        return r100 * r101;
    }

    private static final long times(long r100, short r101) {
        return r100 * ((long) r101);
    }

    public static final int compareTo(long r100, byte r101) {
        return Intrinsics.compare(r100, r101);
    }

    private static final long div(long r100, byte r101) {
        return r100 / ((long) r101);
    }

    private static final <T> T get(List<? extends T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (T) ListProtector.get(r100, r101);
    }

    private static final long rem(long r100, byte r101) {
        return r100 % ((long) r101);
    }

    public static final int compareTo(long r100, double r101) {
        return Double.compare(r100, r101);
    }

    private static final long div(long r100, int r101) {
        return r100 / ((long) r101);
    }

    private static final long rem(long r100, int r101) {
        return r100 % ((long) r101);
    }

    public static final int compareTo(long r100, float r101) {
        return Float.compare(r100, r101);
    }

    private static final long div(long r100, short r101) {
        return r100 / ((long) r101);
    }

    private static final long rem(long r100, short r101) {
        return r100 % ((long) r101);
    }

    public static final int compareTo(long r100, int r101) {
        return Intrinsics.compare(r100, r101);
    }

    private static final long div(long r100, long r101) {
        return r100 / r101;
    }

    private static final long rem(long r100, long r101) {
        return r100 % r101;
    }

    public static final int compareTo(long r100, short r101) {
        return Intrinsics.compare(r100, r101);
    }

    public static final int compareTo(long r100, long r101) {
        return Intrinsics.compare(r100, r101);
    }

    private static final <T> T set(List<T> r100, int r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (T) ListProtector.set(r100, r101, r102);
    }

    private static final <K, V> void set(Map<K, V> r100, K r101, V r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put(r101, r102);
    }
}
