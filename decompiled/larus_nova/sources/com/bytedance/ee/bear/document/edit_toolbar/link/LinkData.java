package com.bytedance.ee.bear.document.edit_toolbar.link;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/document/edit_toolbar/link/LinkData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "text", "getText", "setText", "url", "getUrl", "setUrl", "srcObjToken", "getSrcObjToken", "setSrcObjToken", "srcObjType", "", "getSrcObjType", "()Ljava/lang/Integer;", "setSrcObjType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkData implements NonProguard {
    private String srcObjToken;
    private Integer srcObjType;
    private String text;
    private String type;
    private String url;

    public LinkData() {
    }

    public String toString() {
        return "LinkData(type=" + this.type + ", text=" + this.text + ", url=" + this.url + ')';
    }

    public final String getSrcObjToken() {
        return this.srcObjToken;
    }

    public final Integer getSrcObjType() {
        return this.srcObjType;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setSrcObjToken(String r100) {
        this.srcObjToken = r100;
    }

    public final void setSrcObjType(Integer r100) {
        this.srcObjType = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
