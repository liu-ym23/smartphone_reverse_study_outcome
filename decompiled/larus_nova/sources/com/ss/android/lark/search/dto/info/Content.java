package com.ss.android.lark.search.dto.info;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/search/dto/info/Content;", "Ljava/io/Serializable;", "content", "", "start", "", "<init>", "(Ljava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "getStart", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Content implements Serializable {
    private final String content;
    private final int start;

    public static /* synthetic */ Content copy$default(Content r100, String r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.content;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.start;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.content;
    }

    public final int component2() {
        return this.start;
    }

    public final Content copy(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return new Content(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Content) == true) goto L8;
        return false;
    L8:
        Content r101 = (Content) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (this.start == r101.start) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + this.start;
    }

    public String toString() {
        return "Content(content=" + this.content + ", start=" + this.start + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final int getStart() {
        return this.start;
    }

    public Content(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.content = r100;
        this.start = r101;
    }
}
