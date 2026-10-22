package w95;

import android.content.Context;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bytedance.ee.util.ui.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    public static LruBitmapPool a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r0 = (n.v() * n.t()) * 4;
        int r4 = new MemorySizeCalculator.Builder(r3).setArrayPoolSize(0).setMemoryCacheScreens(0.0f).setBitmapPoolScreens(4.0f).build().getBitmapPoolSize();
        if (r4 <= r0) goto L6;
        tt5.a.h("PresentationBitmapPool", "enable bitmapPool. targetBitmapPoolSize: " + r4);
        return new LruBitmapPool(r4);
    L6:
        return null;
    }
}
