package he3;

import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.bytedance.android.shopping.infeed.data.idl.ProductRecReasonCustom;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000bR\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u000bR\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b'\u0010\u000bR\u001c\u0010(\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b)\u0010\u000bR\u001c\u0010+\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006¨\u00063"}, d2 = {"Lhe3/q1;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "", "typeName", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "content", "b", "setContent", "(Ljava/lang/String;)V", "contentColor", "c", "setContentColor", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "cover", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "d", "()Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "link", "getLink", "author", "getAuthor", "secAuthorId", "getSecAuthorId", "rankId", "getRankId", "rankNo", "getRankNo", "sellingPointsInfo", "getSellingPointsInfo", "commentCounts", "getCommentCounts", "tagTrackParam", ce.f26391f, "header", "f", "Lcom/bytedance/android/shopping/infeed/data/idl/ProductRecReasonCustom;", "custom", "Lcom/bytedance/android/shopping/infeed/data/idl/ProductRecReasonCustom;", "e", "()Lcom/bytedance/android/shopping/infeed/data/idl/ProductRecReasonCustom;", "carouselFrame", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q1 {

    @SerializedName("author")
    private final String author;

    @SerializedName("carousel_frame")
    private final Integer carouselFrame;

    @SerializedName("comment_counts")
    private final Integer commentCounts;

    @SerializedName("content")
    private String content;

    @SerializedName("content_color")
    private String contentColor;

    @SerializedName("cover")
    private final ImageURL cover;

    @SerializedName("custom")
    private final ProductRecReasonCustom custom;

    @SerializedName("header")
    private final String header;

    @SerializedName("link")
    private final String link;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RANK_ID)
    private final String rankId;

    @SerializedName("rank_no")
    private final Integer rankNo;

    @SerializedName("sec_author_id")
    private final String secAuthorId;

    @SerializedName("selling_points_info")
    private final String sellingPointsInfo;

    @SerializedName("tag_track_param")
    private final String tagTrackParam;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("type_name")
    private final String typeName;

    public q1() {
    }

    public final Integer a() {
        return this.carouselFrame;
    }

    public final String b() {
        return this.content;
    }

    public final String c() {
        return this.contentColor;
    }

    public final ImageURL d() {
        return this.cover;
    }

    public final ProductRecReasonCustom e() {
        return this.custom;
    }

    public final String f() {
        return this.header;
    }

    public final String g() {
        return this.tagTrackParam;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String h() {
        return this.typeName;
    }
}
