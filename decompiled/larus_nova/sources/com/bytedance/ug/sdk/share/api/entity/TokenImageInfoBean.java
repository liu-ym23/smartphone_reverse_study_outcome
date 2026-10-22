package com.bytedance.ug.sdk.share.api.entity;

import com.bytedance.ug.sdk.share.impl.model.b;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class TokenImageInfoBean implements Serializable {

    @SerializedName("height")
    private int mHeight;

    @SerializedName("uri")
    private String mUri;

    @SerializedName("url")
    private String mUrl;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private List<b> mUrlList;

    @SerializedName("width")
    private int mWidth;

    public TokenImageInfoBean() {
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getUri() {
        return this.mUri;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public List<b> getUrlList() {
        return this.mUrlList;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setHeight(int r100) {
        this.mHeight = r100;
    }

    public void setUri(String r100) {
        this.mUri = r100;
    }

    public void setUrl(String r100) {
        this.mUrl = r100;
    }

    public void setUrlList(List<b> r100) {
        this.mUrlList = r100;
    }

    public void setWidth(int r100) {
        this.mWidth = r100;
    }
}
