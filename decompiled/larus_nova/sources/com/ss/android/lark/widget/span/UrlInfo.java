package com.ss.android.lark.widget.span;

import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class UrlInfo extends TextStyleInfo {
    public String content;
    public String href;
    public String urlPreviewId;

    @Override // com.ss.android.lark.widget.span.TextStyleInfo, com.ss.android.lark.widget.span.SpanInfo
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.href, this.content, this.urlPreviewId});
    }

    public UrlInfo() {
        this.href = "";
        this.isIndependent = false;
    }

    @Override // com.ss.android.lark.widget.span.TextStyleInfo, com.ss.android.lark.widget.span.SpanInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L22:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L22;
        if (super.equals(r100) == true) goto L13;
        return false;
    L13:
        UrlInfo r101 = (UrlInfo) r100;
        if (Objects.equals(this.href, r101.href) == true) goto L16;
    L20:
        return false;
    L16:
        if (Objects.equals(this.content, r101.content) == false) goto L20;
        if (Objects.equals(this.urlPreviewId, r101.urlPreviewId) == false) goto L20;
        return true;
    }
}
