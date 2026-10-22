package com.ss.android.ugc.aweme.discover.model.commodity.aladdin;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/AladdinLogData;", "Ljava/io/Serializable;", "()V", "alaSrc", "", "getAlaSrc", "()Ljava/lang/String;", "setAlaSrc", "(Ljava/lang/String;)V", "docId", "getDocId", "setDocId", "secondTokenType", "getSecondTokenType", "setSecondTokenType", "subTokenType", "getSubTokenType", "setSubTokenType", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AladdinLogData implements Serializable {

    @SerializedName("ala_src")
    private String alaSrc;

    @SerializedName("doc_id")
    private String docId;

    @SerializedName("second_token_type")
    private String secondTokenType;

    @SerializedName("sub_token_type")
    private String subTokenType;

    public AladdinLogData() {
    }

    public final String getAlaSrc() {
        return this.alaSrc;
    }

    public final String getDocId() {
        return this.docId;
    }

    public final String getSecondTokenType() {
        return this.secondTokenType;
    }

    public final String getSubTokenType() {
        return this.subTokenType;
    }

    public final void setAlaSrc(String r100) {
        this.alaSrc = r100;
    }

    public final void setDocId(String r100) {
        this.docId = r100;
    }

    public final void setSecondTokenType(String r100) {
        this.secondTokenType = r100;
    }

    public final void setSubTokenType(String r100) {
        this.subTokenType = r100;
    }
}
