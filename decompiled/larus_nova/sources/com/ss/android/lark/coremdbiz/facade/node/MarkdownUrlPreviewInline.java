package com.ss.android.lark.coremdbiz.facade.node;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/ss/android/lark/coremdbiz/facade/node/MarkdownUrlPreviewInline;", "Ljava/io/Serializable;", "previewId", "", "originUrl", "clickUrl", "title", "iconKey", "iconType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPreviewId", "()Ljava/lang/String;", "getOriginUrl", "getClickUrl", "getTitle", "getIconKey", "getIconType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownUrlPreviewInline implements Serializable {
    private final String clickUrl;
    private final String iconKey;
    private final String iconType;
    private final String originUrl;
    private final String previewId;
    private final String title;

    public static /* synthetic */ MarkdownUrlPreviewInline copy$default(MarkdownUrlPreviewInline r100, String r101, String r102, String r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.previewId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.originUrl;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.clickUrl;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.title;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.iconKey;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.iconType;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.previewId;
    }

    public final String component2() {
        return this.originUrl;
    }

    public final String component3() {
        return this.clickUrl;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.iconKey;
    }

    public final String component6() {
        return this.iconType;
    }

    public final MarkdownUrlPreviewInline copy(String r100, String r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "previewId");
        Intrinsics.checkNotNullParameter(r110, "originUrl");
        Intrinsics.checkNotNullParameter(r111, "clickUrl");
        Intrinsics.checkNotNullParameter(r112, "title");
        return new MarkdownUrlPreviewInline(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MarkdownUrlPreviewInline) == true) goto L8;
        return false;
    L8:
        MarkdownUrlPreviewInline r101 = (MarkdownUrlPreviewInline) r100;
        if (Intrinsics.areEqual(this.previewId, r101.previewId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.originUrl, r101.originUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.clickUrl, r101.clickUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconKey, r101.iconKey) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconType, r101.iconType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.previewId.hashCode() * 31) + this.originUrl.hashCode()) * 31) + this.clickUrl.hashCode()) * 31) + this.title.hashCode()) * 31;
        String r101 = this.iconKey;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.iconType;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "MarkdownUrlPreviewInline(previewId=" + this.previewId + ", originUrl=" + this.originUrl + ", clickUrl=" + this.clickUrl + ", title=" + this.title + ", iconKey=" + this.iconKey + ", iconType=" + this.iconType + ')';
    }

    public final String getClickUrl() {
        return this.clickUrl;
    }

    public final String getIconKey() {
        return this.iconKey;
    }

    public final String getIconType() {
        return this.iconType;
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final String getPreviewId() {
        return this.previewId;
    }

    public final String getTitle() {
        return this.title;
    }

    public MarkdownUrlPreviewInline(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "previewId");
        Intrinsics.checkNotNullParameter(r101, "originUrl");
        Intrinsics.checkNotNullParameter(r102, "clickUrl");
        Intrinsics.checkNotNullParameter(r103, "title");
        this.previewId = r100;
        this.originUrl = r101;
        this.clickUrl = r102;
        this.title = r103;
        this.iconKey = r104;
        this.iconType = r105;
    }

    public /* synthetic */ MarkdownUrlPreviewInline(String r110, String r111, String r112, String r113, String r114, String r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 16) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r116 & 32) == 0) goto L9;
        String r101 = null;
    L10:
        this(r110, r111, r112, r113, r100, r101);
        return;
    L9:
        r101 = r115;
        goto L10
    L5:
        r100 = r114;
        goto L7
    }
}
