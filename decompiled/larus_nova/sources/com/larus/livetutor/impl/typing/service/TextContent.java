package com.larus.livetutor.impl.typing.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lw8.l;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/livetutor/impl/typing/service/TextContent;", "", "text", "", "markdown", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "<init>", "(Ljava/lang/CharSequence;Lcom/larus/business/markdown/api/model/MarkdownContent;)V", "getText", "()Ljava/lang/CharSequence;", "getMarkdown", "()Lcom/larus/business/markdown/api/model/MarkdownContent;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextContent {
    private final l markdown;
    private final CharSequence text;

    public static /* synthetic */ TextContent copy$default(TextContent r100, CharSequence r101, l r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.markdown;
    L9:
        return r100.copy(r101, r102);
    }

    public final CharSequence component1() {
        return this.text;
    }

    public final l component2() {
        return this.markdown;
    }

    public final TextContent copy(CharSequence r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        return new TextContent(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextContent) == true) goto L8;
        return false;
    L8:
        TextContent r101 = (TextContent) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.markdown, r101.markdown) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.text.hashCode() * 31;
        l r101 = this.markdown;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "TextContent(text=" + this.text + ", markdown=" + this.markdown + ')';
    }

    public final l getMarkdown() {
        return this.markdown;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public TextContent(CharSequence r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.text = r100;
        this.markdown = r101;
    }
}
