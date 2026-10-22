package tc3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Ltc3/c;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "firstScreenPreloadEnable", "d", "firstScreenPrerenderEnable", "e", "", "feedPreloadEnable", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "", "feedPreloadWindow", "I", "c", "()I", "preloadCacheSize", "f", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("feed_preload_enable")
    private final Long feedPreloadEnable;

    @SerializedName("feed_preload_window")
    private final int feedPreloadWindow;

    @SerializedName("first_screen_preload_enable")
    private final boolean firstScreenPreloadEnable;

    @SerializedName("first_screen_prerender_enable")
    private final boolean firstScreenPrerenderEnable;

    @SerializedName("preload_cache_size")
    private final int preloadCacheSize;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.firstScreenPreloadEnable == r101.firstScreenPreloadEnable) goto L10;
        return false;
    L10:
        if (this.firstScreenPrerenderEnable == r101.firstScreenPrerenderEnable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feedPreloadEnable, r101.feedPreloadEnable) == true) goto L14;
        return false;
    L14:
        if (this.feedPreloadWindow == r101.feedPreloadWindow) goto L16;
        return false;
    L16:
        if (this.preloadCacheSize == r101.preloadCacheSize) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.firstScreenPreloadEnable;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.firstScreenPrerenderEnable;
        if (r107 == true) goto L12;
        r101 = r107;
    L12:
        int r108 = (r106 + r101) * 31;
        Long r109 = this.feedPreloadEnable;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L17:
        return ((((r108 + r110) * 31) + this.feedPreloadWindow) * 31) + this.preloadCacheSize;
    L15:
        r110 = 0;
        goto L17
    }

    public final String toString() {
        return "DeepFeedSliceVideoEarlyWarmConfig(enable=" + this.enable + ", firstScreenPreloadEnable=" + this.firstScreenPreloadEnable + ", firstScreenPrerenderEnable=" + this.firstScreenPrerenderEnable + ", feedPreloadEnable=" + this.feedPreloadEnable + ", feedPreloadWindow=" + this.feedPreloadWindow + ", preloadCacheSize=" + this.preloadCacheSize + ")";
    }

    public final boolean a() {
        return this.enable;
    }

    public final Long b() {
        return this.feedPreloadEnable;
    }

    public final int c() {
        return this.feedPreloadWindow;
    }

    public final boolean d() {
        return this.firstScreenPreloadEnable;
    }

    public final boolean e() {
        return this.firstScreenPrerenderEnable;
    }

    public final int f() {
        return this.preloadCacheSize;
    }

    public c(int r100) {
        this.enable = false;
        this.firstScreenPreloadEnable = false;
        this.firstScreenPrerenderEnable = false;
        this.feedPreloadEnable = null;
        this.feedPreloadWindow = 2;
        this.preloadCacheSize = 200;
    }
}
