package com.ss.android.lark.feed.app.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/TextProperty;", "Lcom/ss/android/lark/feed/app/entity/DigestElement;", "content", "", "<init>", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "isItemSame", "", "other", "isContentSame", "component1", "copy", "equals", "", "hashCode", "", "toString", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextProperty extends DigestElement {
    private final String content;

    public static /* synthetic */ TextProperty copy$default(TextProperty r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.content;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.content;
    }

    public final TextProperty copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return new TextProperty(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextProperty) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.content, ((TextProperty) r100).content) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return "TextProperty(content=" + this.content + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public TextProperty(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(null);
        this.content = r100;
    }

    public boolean isContentSame(DigestElement r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if ((r100 instanceof TextProperty) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.content, ((TextProperty) r100).content);
    }

    @Override // com.ss.android.lark.feed.app.entity.DigestElement, y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((DigestElement) r100);
    }

    @Override // com.ss.android.lark.feed.app.entity.DigestElement, y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((DigestElement) r100);
    }

    public boolean isItemSame(DigestElement r100) {
        return Intrinsics.areEqual(this, r100);
    }
}
