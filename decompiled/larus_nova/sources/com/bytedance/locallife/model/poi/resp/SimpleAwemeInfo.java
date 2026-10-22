package com.bytedance.locallife.model.poi.resp;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/SimpleAwemeInfo;", "Ljava/io/Serializable;", "()V", "aid", "", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "author", "Lcom/bytedance/locallife/model/poi/resp/User;", "getAuthor", "()Lcom/bytedance/locallife/model/poi/resp/User;", "setAuthor", "(Lcom/bytedance/locallife/model/poi/resp/User;)V", "getAuthorUid", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SimpleAwemeInfo implements Serializable {

    @SerializedName(SimilarProductParam.AWEME_ID)
    private String aid;

    @SerializedName("author")
    private User author;

    public SimpleAwemeInfo() {
    }

    public final String getAuthorUid() {
        User r100 = this.author;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getUid();
    }

    public final String getAid() {
        return this.aid;
    }

    public final User getAuthor() {
        return this.author;
    }

    public final void setAid(String r100) {
        this.aid = r100;
    }

    public final void setAuthor(User r100) {
        this.author = r100;
    }
}
