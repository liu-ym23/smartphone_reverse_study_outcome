package d64;

import android.app.ActivityManager;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements Supplier<MemoryCacheParams> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActivityManager f467193a;

    @Override // com.facebook.common.internal.Supplier
    public final MemoryCacheParams get() {
        int r100 = Math.min(this.f467193a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (r100 >= 33554432) goto L6;
        int r101 = 4194304;
    L10:
        return new MemoryCacheParams(r101, 128, r101 / 12, Integer.MAX_VALUE, Integer.MAX_VALUE);
    L6:
        if (r100 >= 67108864) goto L8;
        r101 = BmLocated.ALIGN_LEFT_BOTTOM;
        goto L10
    L8:
        r101 = r100 / 8;
        goto L10
    }

    public b(ActivityManager r100) {
        this.f467193a = r100;
    }
}
