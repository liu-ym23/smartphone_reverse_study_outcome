package com.ss.android.lark.biz.core.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/ss/android/lark/biz/core/api/VEBaseScanResult;", "Ljava/io/Serializable;", "content", "", "left", "", "top", "right", "bottom", "baseCodeType", "Lcom/ss/android/lark/biz/core/api/BaseCodeType;", "<init>", "(Ljava/lang/String;FFFFLcom/ss/android/lark/biz/core/api/BaseCodeType;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getLeft", "()F", "setLeft", "(F)V", "getTop", "setTop", "getRight", "setRight", "getBottom", "setBottom", "getBaseCodeType", "()Lcom/ss/android/lark/biz/core/api/BaseCodeType;", "setBaseCodeType", "(Lcom/ss/android/lark/biz/core/api/BaseCodeType;)V", "toString", "isEmpty", "", "qrcode-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VEBaseScanResult implements Serializable {
    private BaseCodeType baseCodeType;
    private float bottom;
    private String content;
    private float left;
    private float right;
    private float top;

    public VEBaseScanResult() {
        this(null, 0.0f, 0.0f, 0.0f, 0.0f, null, 63, null);
    }

    public final boolean isEmpty() {
        if (this.content.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return true;
    L8:
        if (this.right > this.left) goto L10;
        return true;
    L10:
        if (this.bottom <= this.top) goto L16;
        return false;
    L16:
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public String toString() {
        return "content:" + this.content + ",left:" + this.left + ",top:" + this.top + ",right" + this.right + ",bottom:" + this.bottom;
    }

    public final BaseCodeType getBaseCodeType() {
        return this.baseCodeType;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final String getContent() {
        return this.content;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    public final void setBaseCodeType(BaseCodeType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseCodeType = r100;
    }

    public final void setBottom(float r100) {
        this.bottom = r100;
    }

    public final void setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
    }

    public final void setLeft(float r100) {
        this.left = r100;
    }

    public final void setRight(float r100) {
        this.right = r100;
    }

    public final void setTop(float r100) {
        this.top = r100;
    }

    public VEBaseScanResult(String r100, float r101, float r102, float r103, float r104, BaseCodeType r105) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r105, "baseCodeType");
        this.content = r100;
        this.left = r101;
        this.top = r102;
        this.right = r103;
        this.bottom = r104;
        this.baseCodeType = r105;
    }

    public /* synthetic */ VEBaseScanResult(String r100, float r101, float r102, float r103, float r104, BaseCodeType r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = "";
    L5:
        float r105 = 0.0f;
        if ((r111 & 2) == 0) goto L8;
        float r113 = 0.0f;
    L10:
        if ((r111 & 4) == 0) goto L12;
        float r106 = 0.0f;
    L14:
        if ((r111 & 8) == 0) goto L16;
        float r107 = 0.0f;
    L18:
        if ((r111 & 16) != 0) goto L22;
        r105 = r104;
    L22:
        if ((r111 & 32) == 0) goto L24;
        r110 = BaseCodeType.QRCODE;
    L24:
        BaseCodeType r108 = r110;
        this(r100, r113, r106, r107, r105, r108);
        return;
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}
