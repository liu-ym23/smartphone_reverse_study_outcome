package lb2;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012¨\u0006!"}, d2 = {"Llb2/a;", "", "", "imageSampleEnable", "Z", "d", "()Z", "setImageSampleEnable", "(Z)V", "imageCacheEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setImageCacheEnable", "", "imageCacheTotalSizeInMB", "I", "c", "()I", "setImageCacheTotalSizeInMB", "(I)V", "imageCacheSingleSizeInKB", "b", "setImageCacheSingleSizeInKB", "ninePatchCacheEnable", "e", "setNinePatchCacheEnable", "ninePatchCacheTotalSizeInMB", ce.f26391f, "setNinePatchCacheTotalSizeInMB", "ninePatchCacheSingleSizeInKB", "f", "setNinePatchCacheSingleSizeInKB", "<init>", "()V", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("image_cache_enable")
    private boolean imageCacheEnable;

    @SerializedName("image_cache_single_kb")
    private int imageCacheSingleSizeInKB;

    @SerializedName("image_cache_total_mb")
    private int imageCacheTotalSizeInMB;

    @SerializedName("image_sample_enable")
    private boolean imageSampleEnable;

    @SerializedName("nine_patch_cache_enable")
    private boolean ninePatchCacheEnable;

    @SerializedName("nine_patch_cache_single_kb")
    private int ninePatchCacheSingleSizeInKB;

    @SerializedName("nine_patch_cache_total_mb")
    private int ninePatchCacheTotalSizeInMB;

    public a() {
        this.imageSampleEnable = true;
        this.imageCacheEnable = true;
        this.imageCacheTotalSizeInMB = 7;
        this.imageCacheSingleSizeInKB = 500;
        this.ninePatchCacheEnable = true;
        this.ninePatchCacheTotalSizeInMB = 3;
        this.ninePatchCacheSingleSizeInKB = 500;
    }

    public final boolean a() {
        return this.imageCacheEnable;
    }

    public final int b() {
        return this.imageCacheSingleSizeInKB;
    }

    public final int c() {
        return this.imageCacheTotalSizeInMB;
    }

    public final boolean d() {
        return this.imageSampleEnable;
    }

    public final boolean e() {
        return this.ninePatchCacheEnable;
    }

    public final int f() {
        return this.ninePatchCacheSingleSizeInKB;
    }

    public final int g() {
        return this.ninePatchCacheTotalSizeInMB;
    }
}
