package com.larus.doc.sdk.impl.generalbiz.notify;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/notify/DocStateEvent;", "", "<init>", "()V", "isEmpty", "", "()Ljava/lang/Boolean;", "setEmpty", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "contentLength", "", "getContentLength", "()Ljava/lang/Integer;", "setContentLength", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isGenerating", "setGenerating", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocStateEvent {

    @SerializedName("contentLength")
    private Integer contentLength;

    @SerializedName("isEmpty")
    private Boolean isEmpty;

    @SerializedName("isGenerating")
    private Boolean isGenerating;

    public DocStateEvent() {
        Boolean r100 = Boolean.FALSE;
        this.isEmpty = r100;
        this.contentLength = 0;
        this.isGenerating = r100;
    }

    public final Integer getContentLength() {
        return this.contentLength;
    }

    public final Boolean isEmpty() {
        return this.isEmpty;
    }

    public final Boolean isGenerating() {
        return this.isGenerating;
    }

    public final void setContentLength(Integer r100) {
        this.contentLength = r100;
    }

    public final void setEmpty(Boolean r100) {
        this.isEmpty = r100;
    }

    public final void setGenerating(Boolean r100) {
        this.isGenerating = r100;
    }
}
