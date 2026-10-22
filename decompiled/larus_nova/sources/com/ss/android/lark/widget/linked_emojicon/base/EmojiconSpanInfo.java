package com.ss.android.lark.widget.linked_emojicon.base;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fB!\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006("}, d2 = {"Lcom/ss/android/lark/widget/linked_emojicon/base/EmojiconSpanInfo;", "Ljava/io/Serializable;", "resourceId", "", "key", "", "size", "alignment", "textSize", "spanStart", "spanEnd", "<init>", "(ILjava/lang/String;IIIII)V", "span", "Lcom/ss/android/lark/widget/linked_emojicon/base/EmojiconSpan;", "(Lcom/ss/android/lark/widget/linked_emojicon/base/EmojiconSpan;II)V", "getResourceId", "()I", "getKey", "()Ljava/lang/String;", "getSize", "getAlignment", "getTextSize", "getSpanStart", "getSpanEnd", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmojiconSpanInfo implements Serializable {
    public static final a Companion = null;
    private final int alignment;
    private final String key;
    private final int resourceId;
    private final int size;
    private final int spanEnd;
    private final int spanStart;
    private final int textSize;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ EmojiconSpanInfo copy$default(EmojiconSpanInfo r100, int r101, String r102, int r103, int r104, int r110, int r111, int r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.resourceId;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.key;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.size;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.alignment;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.textSize;
    L17:
        int r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.spanStart;
    L20:
        int r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.spanEnd;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.resourceId;
    }

    public final String component2() {
        return this.key;
    }

    public final int component3() {
        return this.size;
    }

    public final int component4() {
        return this.alignment;
    }

    public final int component5() {
        return this.textSize;
    }

    public final int component6() {
        return this.spanStart;
    }

    public final int component7() {
        return this.spanEnd;
    }

    public final EmojiconSpanInfo copy(int r110, String r111, int r112, int r113, int r114, int r115, int r116) {
        Intrinsics.checkNotNullParameter(r111, "key");
        return new EmojiconSpanInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EmojiconSpanInfo) == true) goto L8;
        return false;
    L8:
        EmojiconSpanInfo r101 = (EmojiconSpanInfo) r100;
        if (this.resourceId == r101.resourceId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L15;
        return false;
    L15:
        if (this.size == r101.size) goto L18;
        return false;
    L18:
        if (this.alignment == r101.alignment) goto L21;
        return false;
    L21:
        if (this.textSize == r101.textSize) goto L24;
        return false;
    L24:
        if (this.spanStart == r101.spanStart) goto L27;
        return false;
    L27:
        if (this.spanEnd == r101.spanEnd) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.resourceId * 31) + this.key.hashCode()) * 31) + this.size) * 31) + this.alignment) * 31) + this.textSize) * 31) + this.spanStart) * 31) + this.spanEnd;
    }

    public String toString() {
        return "EmojiconSpanInfo(resourceId=" + this.resourceId + ", key=" + this.key + ", size=" + this.size + ", alignment=" + this.alignment + ", textSize=" + this.textSize + ", spanStart=" + this.spanStart + ", spanEnd=" + this.spanEnd + ')';
    }

    public final int getAlignment() {
        return this.alignment;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getResourceId() {
        return this.resourceId;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getSpanEnd() {
        return this.spanEnd;
    }

    public final int getSpanStart() {
        return this.spanStart;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public EmojiconSpanInfo(com.ss.android.lark.widget.linked_emojicon.base.a r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "span");
        r110.getClass();
        this(0, r110.f446381j, r110.f446373b, r110.getVerticalAlignment(), r110.f446374c, r111, r112);
    }

    public EmojiconSpanInfo(int r100, String r101, int r102, int r103, int r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r101, "key");
        this.resourceId = r100;
        this.key = r101;
        this.size = r102;
        this.alignment = r103;
        this.textSize = r104;
        this.spanStart = r105;
        this.spanEnd = r106;
    }
}
