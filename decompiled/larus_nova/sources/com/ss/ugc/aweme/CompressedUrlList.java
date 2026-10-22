package com.ss.ugc.aweme;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/ugc/aweme/CompressedUrlList;", "Ljava/io/Serializable;", "()V", "enable", "", "paramCommon", "", "uriCommon", "urlList", "", "getEnable", "()Ljava/lang/Boolean;", "getParamCommon", "getUriCommon", "getUrlList", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CompressedUrlList implements Serializable {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("param_common")
    public String paramCommon;

    @SerializedName("uri_common")
    public String uriCommon;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    public List<String> urlList;

    public CompressedUrlList() {
    }

    public final Boolean getEnable() {
        return Boolean.valueOf(this.enable);
    }

    public final String getParamCommon() {
        return this.paramCommon;
    }

    public final String getUriCommon() {
        return this.uriCommon;
    }

    public final List<String> getUrlList() {
        return this.urlList;
    }
}
