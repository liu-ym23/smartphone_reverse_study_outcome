package com.ss.android.ugc.aweme.feed.model;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.VideoTag;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R(\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00028G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/ss/android/ugc/aweme/feed/model/Video;", "Ljava/io/Serializable;", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getOriginCover", "originCover", "", "setOriginCover", "", "isOriginCoverValid", "isCoverValid", "Lcom/ss/android/ugc/aweme/discover/model/VideoTag;", "videoTag", "Lcom/ss/android/ugc/aweme/discover/model/VideoTag;", "", "videoTags", "Ljava/util/List;", "_originCover", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "cover", "", "playAddr", "Ljava/lang/Object;", "getPlayAddr", "()Ljava/lang/Object;", "setPlayAddr", "(Ljava/lang/Object;)V", "", "height", "I", "width", "", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "Ljava/lang/String;", "value", "_getOriginCover", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "_setOriginCover", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public class Video implements Serializable {

    @SerializedName("origin_cover")
    public UrlModel _originCover;

    @SerializedName("cover")
    public UrlModel cover;

    @SerializedName("height")
    public int height;
    private Object playAddr;

    @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
    public String ratio;

    @SerializedName("tag")
    public VideoTag videoTag;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    public List<VideoTag> videoTags;

    @SerializedName("width")
    public int width;

    public Video() {
    }

    public final boolean isCoverValid() {
        UrlModel r100 = this.cover;
        if (r100 == null) goto L7;
        List<String> r101 = r100.getUrlList();
        if (r101 == null) goto L7;
        boolean r102 = r101.isEmpty();
    L9:
        return !r102;
    L7:
        r102 = true;
        goto L9
    }

    public final boolean isOriginCoverValid() {
        UrlModel r100 = this._originCover;
        if (r100 == null) goto L7;
        List<String> r101 = r100.getUrlList();
        if (r101 == null) goto L7;
        boolean r102 = r101.isEmpty();
    L9:
        return !r102;
    L7:
        r102 = true;
        goto L9
    }

    public final UrlModel _getOriginCover() {
        return getOriginCover();
    }

    public final UrlModel getOriginCover() {
        if (isOriginCoverValid() == true) goto L9;
        if (isCoverValid() == false) goto L9;
        return this.cover;
    L9:
        return this._originCover;
    }

    public final Object getPlayAddr() {
        return this.playAddr;
    }

    public final void _setOriginCover(UrlModel r100) {
        setOriginCover(r100);
    }

    public final void setOriginCover(UrlModel r100) {
        this._originCover = r100;
    }

    public final void setPlayAddr(Object r100) {
        this.playAddr = r100;
    }
}
