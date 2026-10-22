package com.bytedance.android.shopping.api.mall.opt;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R.\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/opt/e;", "", "", "preloadEnable", "Z", "c", "()Z", "", "preloadCacheSize", "J", "getPreloadCacheSize", "()J", "", "preloadCount", "I", "b", "()I", "scrollCancelPreload", "d", "justVideoCardPlaying", "getJustVideoCardPlaying", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mallVideoPreloadConfig", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("just_video_card_playing")
    private final boolean justVideoCardPlaying;

    @SerializedName("mall_video_preload_config")
    private final ArrayList<Integer> mallVideoPreloadConfig;

    @SerializedName("preload_cache_size")
    private final long preloadCacheSize;

    @SerializedName("preload_count")
    private final int preloadCount;

    @SerializedName("preload_enable")
    private final boolean preloadEnable;

    @SerializedName("scroll_cancel_preload")
    private final boolean scrollCancelPreload;

    public static final class a {
    }

    static {
    }

    public e() {
        this(null);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L18;
        e r7 = (e) r6;
        if (this.preloadEnable == r7.preloadEnable) goto L8;
        return false;
    L8:
        if (this.preloadCacheSize == r7.preloadCacheSize) goto L10;
        return false;
    L10:
        if (this.preloadCount == r7.preloadCount) goto L12;
        return false;
    L12:
        if (this.scrollCancelPreload == r7.scrollCancelPreload) goto L14;
        return false;
    L14:
        if (this.justVideoCardPlaying == r7.justVideoCardPlaying) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.mallVideoPreloadConfig, r7.mallVideoPreloadConfig) == true) goto L28;
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
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public final int hashCode() {
        boolean r0 = this.preloadEnable;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        long r3 = this.preloadCacheSize;
        int r4 = ((((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.preloadCount) * 31;
        boolean r5 = this.scrollCancelPreload;
        ?? r6 = r5;
        if (r5 == false) goto L8;
        r6 = 1;
    L8:
        int r7 = (r4 + r6) * 31;
        boolean r8 = this.justVideoCardPlaying;
        if (r8 == true) goto L12;
        r1 = r8;
    L12:
        int r9 = (r7 + r1) * 31;
        ArrayList<Integer> r10 = this.mallVideoPreloadConfig;
        if (r10 == null) goto L15;
        int r11 = r10.hashCode();
    L17:
        return r9 + r11;
    L15:
        r11 = 0;
        goto L17
    }

    public final String toString() {
        return "MallVideoPreloadConfig(preloadEnable=" + this.preloadEnable + ", preloadCacheSize=" + this.preloadCacheSize + ", preloadCount=" + this.preloadCount + ", scrollCancelPreload=" + this.scrollCancelPreload + ", justVideoCardPlaying=" + this.justVideoCardPlaying + ", mallVideoPreloadConfig=" + this.mallVideoPreloadConfig + ")";
    }

    public final ArrayList<Integer> a() {
        return this.mallVideoPreloadConfig;
    }

    public final int b() {
        return this.preloadCount;
    }

    public final boolean c() {
        return this.preloadEnable;
    }

    public final boolean d() {
        return this.scrollCancelPreload;
    }

    public e(Object r5) {
        ArrayList<Integer> r6 = CollectionsKt.arrayListOf(new Integer[]{51044});
        this.preloadEnable = false;
        this.preloadCacheSize = 0;
        this.preloadCount = 0;
        this.scrollCancelPreload = false;
        this.justVideoCardPlaying = false;
        this.mallVideoPreloadConfig = r6;
    }
}
