package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\u0016\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\nJ\u0016\u0010\u0018\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\nJ\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020'HÖ\u0001R\"\u0010\u0002\u001a\u00020\u0003X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u00020\u0003X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/MovableDocumentInfo;", "", "documentId", "Lkotlin/UInt;", "documentVersion", "width", "", "height", "(IIFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDocumentId-pVg5ArA", "()I", "setDocumentId-WZ4Q5Ns", "(I)V", "I", "getDocumentVersion-pVg5ArA", "setDocumentVersion-WZ4Q5Ns", "getHeight", "()F", "setHeight", "(F)V", "getWidth", "setWidth", "component1", "component1-pVg5ArA", "component2", "component2-pVg5ArA", "component3", "component4", "copy", "copy-SOCY_n4", "(IIFF)Lcom/bytedance/lark/lark_markdown_render_android/MovableDocumentInfo;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/MovableDocumentInfo;", "toString", "", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MovableDocumentInfo {
    private int documentId;
    private int documentVersion;
    private float height;
    private float width;

    public /* synthetic */ MovableDocumentInfo(int r100, int r101, float r102, float r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: copy-SOCY_n4$default, reason: not valid java name */
    public static /* synthetic */ MovableDocumentInfo m8419copySOCY_n4$default(MovableDocumentInfo r100, int r101, int r102, float r103, float r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.documentId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.documentVersion;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.width;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.height;
    L15:
        return r100.m8422copySOCY_n4(r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: component1-pVg5ArA, reason: not valid java name */
    public final int m8420component1pVg5ArA() {
        return this.documentId;
    }

    /* JADX INFO: renamed from: component2-pVg5ArA, reason: not valid java name */
    public final int m8421component2pVg5ArA() {
        return this.documentVersion;
    }

    public final float component3() {
        return this.width;
    }

    public final float component4() {
        return this.height;
    }

    /* JADX INFO: renamed from: copy-SOCY_n4, reason: not valid java name */
    public final MovableDocumentInfo m8422copySOCY_n4(int r100, int r101, float r110, float r111) {
        return new MovableDocumentInfo(r100, r101, r110, r111, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MovableDocumentInfo) == true) goto L8;
        return false;
    L8:
        MovableDocumentInfo r101 = (MovableDocumentInfo) r100;
        if (this.documentId == r101.documentId) goto L12;
        return false;
    L12:
        if (this.documentVersion == r101.documentVersion) goto L15;
        return false;
    L15:
        if (Float.compare(this.width, r101.width) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.height, r101.height) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((UInt.m9556hashCodeimpl(this.documentId) * 31) + UInt.m9556hashCodeimpl(this.documentVersion)) * 31) + Float.floatToIntBits(this.width)) * 31) + Float.floatToIntBits(this.height);
    }

    public String toString() {
        return "MovableDocumentInfo(documentId=" + UInt.m9590toStringimpl(this.documentId) + ", documentVersion=" + UInt.m9590toStringimpl(this.documentVersion) + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public final lark_markdown_render.proto.MovableDocumentInfo into() {
        return new lark_markdown_render.proto.MovableDocumentInfo(Integer.valueOf(this.documentId), Integer.valueOf(this.documentVersion), Float.valueOf(this.width), Float.valueOf(this.height));
    }

    /* JADX INFO: renamed from: getDocumentId-pVg5ArA, reason: not valid java name */
    public final int m8423getDocumentIdpVg5ArA() {
        return this.documentId;
    }

    /* JADX INFO: renamed from: getDocumentVersion-pVg5ArA, reason: not valid java name */
    public final int m8424getDocumentVersionpVg5ArA() {
        return this.documentVersion;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: setDocumentId-WZ4Q5Ns, reason: not valid java name */
    public final void m8425setDocumentIdWZ4Q5Ns(int r100) {
        this.documentId = r100;
    }

    /* JADX INFO: renamed from: setDocumentVersion-WZ4Q5Ns, reason: not valid java name */
    public final void m8426setDocumentVersionWZ4Q5Ns(int r100) {
        this.documentVersion = r100;
    }

    public final void setHeight(float r100) {
        this.height = r100;
    }

    public final void setWidth(float r100) {
        this.width = r100;
    }

    private MovableDocumentInfo(int r100, int r101, float r102, float r103) {
        this.documentId = r100;
        this.documentVersion = r101;
        this.width = r102;
        this.height = r103;
    }
}
