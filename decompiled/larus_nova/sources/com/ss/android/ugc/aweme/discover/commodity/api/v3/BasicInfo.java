package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.SubInfo;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 ¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/BasicInfo;", "Ljava/io/Serializable;", "()V", "ecomSearchAllPassThrough", "", "getEcomSearchAllPassThrough", "()Ljava/lang/String;", "setEcomSearchAllPassThrough", "(Ljava/lang/String;)V", "enterFrom", "getEnterFrom", "setEnterFrom", SubInfo.KEY_FORMAT, "getFormat", "setFormat", "hasSidebar", "", "getHasSidebar", "()Z", "setHasSidebar", "(Z)V", "imageQueryUri", "getImageQueryUri", "setImageQueryUri", "keyword", "getKeyword", "setKeyword", "queryCorrectType", "", "getQueryCorrectType", "()I", "setQueryCorrectType", "(I)V", "resultFrom", "getResultFrom", "setResultFrom", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BasicInfo implements Serializable {

    @SerializedName("ecom_search_all_pass_through")
    private String ecomSearchAllPassThrough;

    @SerializedName("enter_from")
    private String enterFrom;

    @SerializedName(SubInfo.KEY_FORMAT)
    private String format;

    @SerializedName("has_sidebar")
    private boolean hasSidebar;

    @SerializedName("image_query_uri")
    private String imageQueryUri;

    @SerializedName("keyword")
    private String keyword;

    @SerializedName("query_correct_type")
    private int queryCorrectType;

    @SerializedName("result_from")
    private int resultFrom;

    public BasicInfo() {
        this.queryCorrectType = 1;
    }

    public final String getEcomSearchAllPassThrough() {
        return this.ecomSearchAllPassThrough;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getFormat() {
        return this.format;
    }

    public final boolean getHasSidebar() {
        return this.hasSidebar;
    }

    public final String getImageQueryUri() {
        return this.imageQueryUri;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final int getQueryCorrectType() {
        return this.queryCorrectType;
    }

    public final int getResultFrom() {
        return this.resultFrom;
    }

    public final void setEcomSearchAllPassThrough(String r100) {
        this.ecomSearchAllPassThrough = r100;
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }

    public final void setFormat(String r100) {
        this.format = r100;
    }

    public final void setHasSidebar(boolean r100) {
        this.hasSidebar = r100;
    }

    public final void setImageQueryUri(String r100) {
        this.imageQueryUri = r100;
    }

    public final void setKeyword(String r100) {
        this.keyword = r100;
    }

    public final void setQueryCorrectType(int r100) {
        this.queryCorrectType = r100;
    }

    public final void setResultFrom(int r100) {
        this.resultFrom = r100;
    }
}
