package com.bytedance.ee.bear.document.ai.myai;

import com.alipay.sdk.m.x.d;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\fH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/myai/DocMeta;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "has_cover", "", "getHas_cover", "()Ljava/lang/Boolean;", "setHas_cover", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "has_content", "getHas_content", "setHas_content", "has_comment", "getHas_comment", "setHas_comment", "has_mention_me", "getHas_mention_me", "setHas_mention_me", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocMeta implements NonProguard {
    private Boolean has_comment;
    private Boolean has_content;
    private Boolean has_cover;
    private Boolean has_mention_me;
    private String title;

    public DocMeta() {
    }

    public String toString() {
        return "DocMeta(has_cover=" + this.has_cover + ", title=" + this.title + ", has_content=" + this.has_content + ", has_comment=" + this.has_comment + ", has_mention_me=" + this.has_mention_me + ')';
    }

    public final Boolean getHas_comment() {
        return this.has_comment;
    }

    public final Boolean getHas_content() {
        return this.has_content;
    }

    public final Boolean getHas_cover() {
        return this.has_cover;
    }

    public final Boolean getHas_mention_me() {
        return this.has_mention_me;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setHas_comment(Boolean r100) {
        this.has_comment = r100;
    }

    public final void setHas_content(Boolean r100) {
        this.has_content = r100;
    }

    public final void setHas_cover(Boolean r100) {
        this.has_cover = r100;
    }

    public final void setHas_mention_me(Boolean r100) {
        this.has_mention_me = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
