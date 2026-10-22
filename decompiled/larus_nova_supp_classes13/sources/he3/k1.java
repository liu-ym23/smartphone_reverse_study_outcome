package he3;

import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\f\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010¨\u0006\""}, d2 = {"Lhe3/k1;", "", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "cover", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "a", "()Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "setCover", "(Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;)V", "", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedUrlModel;", "images", "Ljava/util/List;", "b", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "coverWhiteBg", "getCoverWhiteBg", "coverLong", "getCoverLong", "coverPromotion", "getCoverPromotion", "coverRecommend", "getCoverRecommend", "Lhe3/s1;", "replayInfo", "Lhe3/s1;", "getReplayInfo", "()Lhe3/s1;", "Lhe3/e2;", "productVideos", "c", "e", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k1 {

    @SerializedName("cover")
    private ImageURL cover;

    @SerializedName("cover_long")
    private final ImageURL coverLong;

    @SerializedName("cover_promotion")
    private final ImageURL coverPromotion;

    @SerializedName("cover_recommend")
    private final ImageURL coverRecommend;

    @SerializedName("cover_white_bg")
    private final ImageURL coverWhiteBg;

    @SerializedName("images")
    private List<InFeedUrlModel> images;

    @SerializedName("product_videos")
    private List<e2> productVideos;

    @SerializedName("replay_info")
    private final s1 replayInfo;

    public k1() {
        this.cover = null;
        this.images = null;
        this.coverWhiteBg = null;
        this.coverLong = null;
        this.coverPromotion = null;
        this.coverRecommend = null;
        this.replayInfo = null;
        this.productVideos = null;
    }

    public final ImageURL a() {
        return this.cover;
    }

    public final List<InFeedUrlModel> b() {
        return this.images;
    }

    public final List<e2> c() {
        return this.productVideos;
    }

    public final void d(List<InFeedUrlModel> r1) {
        this.images = r1;
    }

    public final void e(List<e2> r1) {
        this.productVideos = r1;
    }
}
