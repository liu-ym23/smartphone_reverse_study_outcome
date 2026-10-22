package w95;

import android.content.Context;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    public static LruBitmapPool a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = (n.v() * n.t()) * 4;
        int r102 = new MemorySizeCalculator.Builder(r100).setArrayPoolSize(0).setMemoryCacheScreens(0.0f).setBitmapPoolScreens(4.0f).build().getBitmapPoolSize();
        if (r102 <= r101) goto L6;
        tt5.a.h("PresentationBitmapPool", "enable bitmapPool. targetBitmapPoolSize: " + r102);
        return new LruBitmapPool(r102);
    L6:
        return null;
    }
}
