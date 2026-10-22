package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/KOLInfo;", "Ljava/io/Serializable;", "()V", "avatar", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getAvatar", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "setAvatar", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textSplitIndex", "", "getTextSplitIndex", "()I", "setTextSplitIndex", "(I)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class KOLInfo implements Serializable {

    @SerializedName("avatar")
    private UrlModel avatar;

    @SerializedName("text")
    private String text;

    @SerializedName("text_split_index")
    private int textSplitIndex;

    public KOLInfo() {
        this.textSplitIndex = -1;
    }

    public final UrlModel getAvatar() {
        return this.avatar;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextSplitIndex() {
        return this.textSplitIndex;
    }

    public final void setAvatar(UrlModel r100) {
        this.avatar = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextSplitIndex(int r100) {
        this.textSplitIndex = r100;
    }
}
