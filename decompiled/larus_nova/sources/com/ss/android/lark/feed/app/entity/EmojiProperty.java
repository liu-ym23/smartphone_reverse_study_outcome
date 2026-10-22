package com.ss.android.lark.feed.app.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0016J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/EmojiProperty;", "Lcom/ss/android/lark/feed/app/entity/DigestElement;", "emojiKey", "", "defaultContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmojiKey", "()Ljava/lang/String;", "getDefaultContent", "isItemSame", "", "other", "isContentSame", "component1", "component2", "copy", "equals", "", "hashCode", "", "toString", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmojiProperty extends DigestElement {
    private final String defaultContent;
    private final String emojiKey;

    public static /* synthetic */ EmojiProperty copy$default(EmojiProperty r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.emojiKey;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.defaultContent;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.emojiKey;
    }

    public final String component2() {
        return this.defaultContent;
    }

    public final EmojiProperty copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "emojiKey");
        return new EmojiProperty(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EmojiProperty) == true) goto L8;
        return false;
    L8:
        EmojiProperty r101 = (EmojiProperty) r100;
        if (Intrinsics.areEqual(this.emojiKey, r101.emojiKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultContent, r101.defaultContent) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.emojiKey.hashCode() * 31;
        String r101 = this.defaultContent;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "EmojiProperty(emojiKey=" + this.emojiKey + ", defaultContent=" + this.defaultContent + ')';
    }

    public final String getDefaultContent() {
        return this.defaultContent;
    }

    public final String getEmojiKey() {
        return this.emojiKey;
    }

    public boolean isContentSame(DigestElement r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if ((r100 instanceof EmojiProperty) == true) goto L5;
        return false;
    L5:
        EmojiProperty r101 = (EmojiProperty) r100;
        if (Intrinsics.areEqual(this.emojiKey, r101.emojiKey) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.defaultContent, r101.defaultContent) == false) goto L12;
        return true;
    L12:
        return false;
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

    public EmojiProperty(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "emojiKey");
        super(null);
        this.emojiKey = r100;
        this.defaultContent = r101;
    }
}
