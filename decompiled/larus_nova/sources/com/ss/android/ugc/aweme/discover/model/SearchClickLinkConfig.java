package com.ss.android.ugc.aweme.discover.model;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/SearchClickLinkConfig;", "Ljava/io/Serializable;", "()V", "redirectTitle", "", "getRedirectTitle", "()Ljava/lang/String;", "setRedirectTitle", "(Ljava/lang/String;)V", "schema", "getSchema", "setSchema", "source", "getSource", "setSource", "text", "getText", "setText", "title", "getTitle", d.f25925o, "trade-search-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SearchClickLinkConfig implements Serializable {

    @SerializedName("redirectTitle")
    private String redirectTitle;

    @SerializedName("schema")
    private String schema;

    @SerializedName("source")
    private String source;

    @SerializedName("text")
    private String text;

    @SerializedName("title")
    private String title;

    public SearchClickLinkConfig() {
    }

    public final String getRedirectTitle() {
        return this.redirectTitle;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setRedirectTitle(String r100) {
        this.redirectTitle = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setSource(String r100) {
        this.source = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
