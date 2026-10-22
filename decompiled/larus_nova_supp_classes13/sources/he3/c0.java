package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lhe3/c0;", "", "Lhe3/d0;", "baseInfo", "Lhe3/d0;", "getBaseInfo", "()Lhe3/d0;", "Lhe3/g0;", "playInfo", "Lhe3/g0;", "getPlayInfo", "()Lhe3/g0;", "Lhe3/e0;", "coverInfo", "Lhe3/e0;", "getCoverInfo", "()Lhe3/e0;", "Lhe3/f0;", "linkInfo", "Lhe3/f0;", "a", "()Lhe3/f0;", "Lhe3/i0;", "statisticsInfo", "Lhe3/i0;", "getStatisticsInfo", "()Lhe3/i0;", "Lhe3/j0;", "tagInfo", "Lhe3/j0;", "getTagInfo", "()Lhe3/j0;", "Lhe3/h0;", "productInfo", "Lhe3/h0;", "getProductInfo", "()Lhe3/h0;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName("base_info")
    private final d0 baseInfo;

    @SerializedName("cover_info")
    private final e0 coverInfo;

    @SerializedName("link_info")
    private final f0 linkInfo;

    @SerializedName("play_info")
    private final g0 playInfo;

    @SerializedName("product_info")
    private final h0 productInfo;

    @SerializedName("statistics_info")
    private final i0 statisticsInfo;

    @SerializedName("tag_info")
    private final j0 tagInfo;

    public c0() {
        this.baseInfo = null;
        this.playInfo = null;
        this.coverInfo = null;
        this.linkInfo = null;
        this.statisticsInfo = null;
        this.tagInfo = null;
        this.productInfo = null;
    }

    public final f0 a() {
        return this.linkInfo;
    }
}
