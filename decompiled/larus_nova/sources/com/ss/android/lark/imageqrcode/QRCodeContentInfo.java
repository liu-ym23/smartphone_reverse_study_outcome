package com.ss.android.lark.imageqrcode;

import android.graphics.RectF;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/imageqrcode/QRCodeContentInfo;", "Ljava/io/Serializable;", "content", "", "leftRatio", "", "topRatio", "rightRatio", "bottomRatio", "<init>", "(Ljava/lang/String;FFFF)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getLeftRatio", "()F", "setLeftRatio", "(F)V", "getTopRatio", "setTopRatio", "getRightRatio", "setRightRatio", "getBottomRatio", "setBottomRatio", "toString", "isEmpty", "", "isVisible", "isCenterVisible", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QRCodeContentInfo implements Serializable {
    private float bottomRatio;
    private String content;
    private float leftRatio;
    private float rightRatio;
    private float topRatio;

    public QRCodeContentInfo() {
        this(null, 0.0f, 0.0f, 0.0f, 0.0f, 31, null);
    }

    public final boolean isCenterVisible() {
        RectF r100 = new RectF(this.leftRatio, this.topRatio, this.rightRatio, this.bottomRatio);
        return new RectF(0.0f, 0.0f, 1.0f, 1.0f).contains(r100.centerX(), r100.centerY());
    }

    public final boolean isEmpty() {
        if (this.content.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return true;
    L8:
        if (this.rightRatio > this.leftRatio) goto L10;
        return true;
    L10:
        if (this.bottomRatio <= this.topRatio) goto L16;
        return false;
    L16:
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public final boolean isVisible() {
        return new RectF(0.0f, 0.0f, 1.0f, 1.0f).intersect(new RectF(this.leftRatio, this.topRatio, this.rightRatio, this.bottomRatio));
    }

    public String toString() {
        return "content:" + this.content + ",leftRatio:" + this.leftRatio + ",topRatio:" + this.topRatio + ",rightRatio" + this.rightRatio + ",bottomRatio:" + this.bottomRatio;
    }

    public final float getBottomRatio() {
        return this.bottomRatio;
    }

    public final String getContent() {
        return this.content;
    }

    public final float getLeftRatio() {
        return this.leftRatio;
    }

    public final float getRightRatio() {
        return this.rightRatio;
    }

    public final float getTopRatio() {
        return this.topRatio;
    }

    public final void setBottomRatio(float r100) {
        this.bottomRatio = r100;
    }

    public final void setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
    }

    public final void setLeftRatio(float r100) {
        this.leftRatio = r100;
    }

    public final void setRightRatio(float r100) {
        this.rightRatio = r100;
    }

    public final void setTopRatio(float r100) {
        this.topRatio = r100;
    }

    public QRCodeContentInfo(String r100, float r101, float r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.content = r100;
        this.leftRatio = r101;
        this.topRatio = r102;
        this.rightRatio = r103;
        this.bottomRatio = r104;
    }

    public /* synthetic */ QRCodeContentInfo(String r100, float r101, float r102, float r103, float r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = "";
    L5:
        float r106 = 0.0f;
        if ((r105 & 2) == 0) goto L8;
        float r111 = 0.0f;
    L10:
        if ((r105 & 4) == 0) goto L12;
        float r107 = 0.0f;
    L14:
        if ((r105 & 8) == 0) goto L16;
        float r108 = 0.0f;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
