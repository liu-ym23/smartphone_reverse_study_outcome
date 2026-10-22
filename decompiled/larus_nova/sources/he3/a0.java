package he3;

import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lhe3/a0;", "", "", "", "cover", "Ljava/util/List;", "getCover", "()Ljava/util/List;", "setCover", "(Ljava/util/List;)V", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedUrlModel;", "images", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setImages", "Lhe3/e2;", "productVideos", "c", "setProductVideos", "Lhe3/c0;", "live", "Lhe3/c0;", "b", "()Lhe3/c0;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("cover")
    private List<String> cover;

    @SerializedName("images")
    private List<InFeedUrlModel> images;

    @SerializedName("live")
    private final c0 live;

    @SerializedName("product_videos")
    private List<e2> productVideos;

    public a0() {
        this.cover = null;
        this.images = null;
        this.productVideos = null;
        this.live = null;
    }

    public final List<InFeedUrlModel> a() {
        return this.images;
    }

    public final c0 b() {
        return this.live;
    }

    public final List<e2> c() {
        return this.productVideos;
    }
}
