package com.bytedance.locallife.host.search;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/host/search/Params;", "Ljava/io/Serializable;", "()V", "extraInfo", "Lcom/bytedance/locallife/host/search/CommentExtraInfo;", "getExtraInfo", "()Lcom/bytedance/locallife/host/search/CommentExtraInfo;", "recallSource", "", "getRecallSource", "()Ljava/lang/String;", "wordImg", "getWordImg", "setWordImg", "(Ljava/lang/String;)V", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class Params implements Serializable {

    @SerializedName("extra_info")
    private final CommentExtraInfo extraInfo;

    @SerializedName("reason")
    private final String recallSource;

    @SerializedName("image_url")
    private String wordImg;

    public Params() {
    }

    public final CommentExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final String getRecallSource() {
        return this.recallSource;
    }

    public final String getWordImg() {
        return this.wordImg;
    }

    public final void setWordImg(String r100) {
        this.wordImg = r100;
    }
}
