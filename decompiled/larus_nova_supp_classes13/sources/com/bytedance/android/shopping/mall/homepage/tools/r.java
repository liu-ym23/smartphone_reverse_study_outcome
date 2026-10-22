package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/tools/r;", "", "", "prefetchImageThread", "I", "c", "()I", "prefetchImageFirstCount", "b", "", "prefetchFirst", "Z", "a", "()Z", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {
    public static final r a = null;

    @SerializedName("gyl_prefetch_first")
    private final boolean prefetchFirst;

    @SerializedName("gyl_prefetch_image_count")
    private final int prefetchImageFirstCount;

    @SerializedName("prefetch_image_thread")
    private final int prefetchImageThread;

    public static final class a {
    }

    public r() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r) == false) goto L12;
        r r4 = (r) r3;
        if (this.prefetchImageThread == r4.prefetchImageThread) goto L8;
        return false;
    L8:
        if (this.prefetchImageFirstCount == r4.prefetchImageFirstCount) goto L10;
        return false;
    L10:
        if (this.prefetchFirst == r4.prefetchFirst) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        int r0 = ((this.prefetchImageThread * 31) + this.prefetchImageFirstCount) * 31;
        boolean r1 = this.prefetchFirst;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return r0 + r2;
    }

    public final String toString() {
        return "MallFirstScreenPrefetchImageSetting(prefetchImageThread=" + this.prefetchImageThread + ", prefetchImageFirstCount=" + this.prefetchImageFirstCount + ", prefetchFirst=" + this.prefetchFirst + ")";
    }

    static {
        int r0 = s93.c.a;
        Object r1 = new r(0);
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L10;
        yj.g r3 = r2.getHostAB();
        if (r3 == null) goto L10;
        Object r4 = r3.a("mall_first_screen_prefetch_image", r1);
        if (r4 == null) goto L10;
        r1 = r4;
    L10:
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : mall_first_screen_prefetch_image, Value: " + r1);
        a = (r) r1;
    }

    public final boolean a() {
        return this.prefetchFirst;
    }

    public final int b() {
        return this.prefetchImageFirstCount;
    }

    public final int c() {
        return this.prefetchImageThread;
    }

    public r(int r2) {
        this.prefetchImageThread = 0;
        this.prefetchImageFirstCount = 4;
        this.prefetchFirst = false;
    }
}
