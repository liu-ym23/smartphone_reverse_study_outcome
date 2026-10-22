package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/larus/platform/model/CompressionConfig;", "", "shortSideCompressThreshold", "", "longSideCompressThreshold", "compressQuality", "compressFormat", "", "compressQualityWithAlpha", "compressFormatWithAlpha", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getShortSideCompressThreshold", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLongSideCompressThreshold", "getCompressQuality", "getCompressFormat", "()Ljava/lang/String;", "getCompressQualityWithAlpha", "getCompressFormatWithAlpha", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p0 {

    @SerializedName("compress_format")
    private final String compressFormat;

    @SerializedName("compress_format_with_alpha")
    private final String compressFormatWithAlpha;

    @SerializedName("compress_quality")
    private final Integer compressQuality;

    @SerializedName("compress_quality_with_alpha")
    private final Integer compressQualityWithAlpha;

    @SerializedName("long_side_compress_threshold")
    private final Integer longSideCompressThreshold;

    @SerializedName("short_side_compress_threshold")
    private final Integer shortSideCompressThreshold;

    public p0() {
        this.shortSideCompressThreshold = 2160;
        this.longSideCompressThreshold = 4096;
        this.compressQuality = 100;
        this.compressFormat = null;
        this.compressQualityWithAlpha = null;
        this.compressFormatWithAlpha = null;
    }

    public final String a() {
        return this.compressFormat;
    }

    public final String b() {
        return this.compressFormatWithAlpha;
    }

    public final Integer c() {
        return this.compressQuality;
    }

    public final Integer d() {
        return this.compressQualityWithAlpha;
    }

    public final Integer e() {
        return this.longSideCompressThreshold;
    }

    public final Integer f() {
        return this.shortSideCompressThreshold;
    }
}
