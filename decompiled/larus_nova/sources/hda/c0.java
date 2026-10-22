package hda;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f484641a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f484642b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ExecutorService f484643c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f484644d = null;

    public static final class a extends LruCache<String, Bitmap> {
        public a(int r100) {
            super(r100);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, Bitmap r101) {
            Bitmap r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "value");
            return RangesKt.coerceAtLeast(r102.getByteCount() / 1024, 1);
        }
    }

    static {
        f484641a = new Handler(Looper.getMainLooper());
        f484642b = new AtomicInteger();
        f484643c = PThreadExecutorsUtils.newFixedThreadPool(2, new z());
        f484644d = new a(RangesKt.coerceIn(((int) (Runtime.getRuntime().maxMemory() / ((long) 1024))) / 16, 8192, 32768));
    }
}
