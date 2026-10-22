package com.ss.android.ugc.aweme.discover.model.suggest;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0000R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/suggest/Params;", "Ljava/io/Serializable;", "()V", "engineInfo", "", "getEngineInfo", "()Ljava/lang/String;", "setEngineInfo", "(Ljava/lang/String;)V", "extraInfo", "Lcom/ss/android/ugc/aweme/discover/model/suggest/CommentExtraInfo;", "getExtraInfo", "()Lcom/ss/android/ugc/aweme/discover/model/suggest/CommentExtraInfo;", "setExtraInfo", "(Lcom/ss/android/ugc/aweme/discover/model/suggest/CommentExtraInfo;)V", "recallSource", "getRecallSource", "setRecallSource", "recommendReason", "getRecommendReason", "setRecommendReason", "wordImg", "getWordImg", "setWordImg", "copyForStore", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Params implements Serializable {

    @SerializedName("info")
    private String engineInfo;

    @SerializedName("extra_info")
    private CommentExtraInfo extraInfo;

    @SerializedName("reason")
    private String recallSource;

    @SerializedName("recommend_reason")
    private String recommendReason;

    @SerializedName("image_url")
    private String wordImg;

    public final Params copyForStore() {
        Params r100 = new Params();
        r100.wordImg = this.wordImg;
        CommentExtraInfo r101 = this.extraInfo;
        if (r101 == null) goto L5;
        CommentExtraInfo r102 = r101.copyForStore();
    L6:
        r100.extraInfo = r102;
        r100.recallSource = this.recallSource;
        r100.engineInfo = this.engineInfo;
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    public Params() {
        this.recommendReason = "";
        this.engineInfo = "";
    }

    public final String getEngineInfo() {
        return this.engineInfo;
    }

    public final CommentExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final String getRecallSource() {
        return this.recallSource;
    }

    public final String getRecommendReason() {
        return this.recommendReason;
    }

    public final String getWordImg() {
        return this.wordImg;
    }

    public final void setEngineInfo(String r100) {
        this.engineInfo = r100;
    }

    public final void setExtraInfo(CommentExtraInfo r100) {
        this.extraInfo = r100;
    }

    public final void setRecallSource(String r100) {
        this.recallSource = r100;
    }

    public final void setRecommendReason(String r100) {
        this.recommendReason = r100;
    }

    public final void setWordImg(String r100) {
        this.wordImg = r100;
    }
}
