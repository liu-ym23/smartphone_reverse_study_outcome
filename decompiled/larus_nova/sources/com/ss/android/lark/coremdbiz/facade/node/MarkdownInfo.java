package com.ss.android.lark.coremdbiz.facade.node;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/coremdbiz/facade/node/MarkdownInfo;", "Ljava/io/Serializable;", "content", "", "<init>", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownInfo implements Serializable {
    private final String content;

    public static /* synthetic */ MarkdownInfo copy$default(MarkdownInfo r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.content;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.content;
    }

    public final MarkdownInfo copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return new MarkdownInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MarkdownInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.content, ((MarkdownInfo) r100).content) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return "MarkdownInfo(content=" + this.content + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public MarkdownInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.content = r100;
    }
}
