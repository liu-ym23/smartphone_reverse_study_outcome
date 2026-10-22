package com.bytedance.ug.sdk.share.impl.model;

import com.bytedance.ug.sdk.share.api.entity.UrlList;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class b {

    @SerializedName("height")
    public int height;

    @SerializedName("type")
    public int imageType;

    @SerializedName("uri")
    public String uri;

    @SerializedName("url")
    public String url;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    public List<UrlList> urlList;

    @SerializedName("width")
    public int width;

    public b() {
    }
}
