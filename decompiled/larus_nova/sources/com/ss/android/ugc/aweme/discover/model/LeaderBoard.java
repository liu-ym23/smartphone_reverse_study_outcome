package com.ss.android.ugc.aweme.discover.model;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/LeaderBoard;", "Ljava/io/Serializable;", "()V", "schema", "", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "textSplitIndex", "", "getTextSplitIndex", "()I", "setTextSplitIndex", "(I)V", "title", "getTitle", d.f25925o, "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LeaderBoard implements Serializable {

    @SerializedName("schema")
    private String schema;

    @SerializedName("text_split_index")
    private int textSplitIndex;

    @SerializedName("title")
    private String title;

    public LeaderBoard() {
        this.textSplitIndex = -1;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final int getTextSplitIndex() {
        return this.textSplitIndex;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setTextSplitIndex(int r100) {
        this.textSplitIndex = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
