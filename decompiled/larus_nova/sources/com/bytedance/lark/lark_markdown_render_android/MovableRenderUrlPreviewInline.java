package com.bytedance.lark.lark_markdown_render_android;

import com.alipay.sdk.m.x.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006'"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderUrlPreviewInline;", "", "previewId", "", "originUrl", "clickUrl", "title", "iconKey", "iconType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClickUrl", "()Ljava/lang/String;", "setClickUrl", "(Ljava/lang/String;)V", "getIconKey", "setIconKey", "getIconType", "setIconType", "getOriginUrl", "setOriginUrl", "getPreviewId", "setPreviewId", "getTitle", d.f25925o, "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/MovableRenderUrlPreviewInline;", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MovableRenderUrlPreviewInline {
    private String clickUrl;
    private String iconKey;
    private String iconType;
    private String originUrl;
    private String previewId;
    private String title;

    public static /* synthetic */ MovableRenderUrlPreviewInline copy$default(MovableRenderUrlPreviewInline r100, String r101, String r102, String r103, String r104, String r105, String r110, int r111, Object r112) {
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

    public final MovableRenderUrlPreviewInline copy(String r100, String r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "previewId");
        Intrinsics.checkNotNullParameter(r110, "originUrl");
        Intrinsics.checkNotNullParameter(r111, "clickUrl");
        Intrinsics.checkNotNullParameter(r112, "title");
        return new MovableRenderUrlPreviewInline(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MovableRenderUrlPreviewInline) == true) goto L8;
        return false;
    L8:
        MovableRenderUrlPreviewInline r101 = (MovableRenderUrlPreviewInline) r100;
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
        return "MovableRenderUrlPreviewInline(previewId=" + this.previewId + ", originUrl=" + this.originUrl + ", clickUrl=" + this.clickUrl + ", title=" + this.title + ", iconKey=" + this.iconKey + ", iconType=" + this.iconType + ')';
    }

    public final lark_markdown_render.proto.MovableRenderUrlPreviewInline into() {
        return new lark_markdown_render.proto.MovableRenderUrlPreviewInline(this.previewId, this.originUrl, this.clickUrl, this.title, this.iconKey, this.iconType);
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

    public final void setClickUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.clickUrl = r100;
    }

    public final void setIconKey(String r100) {
        this.iconKey = r100;
    }

    public final void setIconType(String r100) {
        this.iconType = r100;
    }

    public final void setOriginUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.originUrl = r100;
    }

    public final void setPreviewId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.previewId = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public MovableRenderUrlPreviewInline(String r100, String r101, String r102, String r103, String r104, String r105) {
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
}
