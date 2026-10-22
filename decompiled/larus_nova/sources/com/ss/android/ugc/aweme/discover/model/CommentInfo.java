package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CommentInfo;", "Ljava/io/Serializable;", "()V", "avatarList", "", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getAvatarList", "()Ljava/util/List;", "setAvatarList", "(Ljava/util/List;)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textSplitIndex", "", "getTextSplitIndex", "()I", "setTextSplitIndex", "(I)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentInfo implements Serializable {

    @SerializedName("avatar_list")
    private List<? extends UrlModel> avatarList;

    @SerializedName("text")
    private String text;

    @SerializedName("text_split_index")
    private int textSplitIndex;

    public CommentInfo() {
        this.textSplitIndex = -1;
    }

    public final List<UrlModel> getAvatarList() {
        return this.avatarList;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextSplitIndex() {
        return this.textSplitIndex;
    }

    public final void setAvatarList(List<? extends UrlModel> r100) {
        this.avatarList = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextSplitIndex(int r100) {
        this.textSplitIndex = r100;
    }
}
