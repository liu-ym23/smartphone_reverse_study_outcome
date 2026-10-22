package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b-\u0010.J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003Jp\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u001a\u001a\u00020\rHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u0004R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010#R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010,¨\u0006/"}, d2 = {"com/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle", "", "", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "component6", "", "component7", "()Ljava/lang/Double;", "", "component8", "top", "bottom", "left", "right", "width", "height", "radius", "url", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/Integer;", "getTop", "getBottom", "setBottom", "(Ljava/lang/Integer;)V", "getLeft", "getRight", "getWidth", "getHeight", "Ljava/lang/Double;", "getRadius", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonModel$LayoutStyle {
    private Integer bottom;
    private final Integer height;
    private final Integer left;
    private final Double radius;
    private final Integer right;
    private final Integer top;
    private final String url;
    private final Integer width;

    public CommonModel$LayoutStyle() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ CommonModel$LayoutStyle copy$default(CommonModel$LayoutStyle r9, Integer r10, Integer r11, Integer r12, Integer r13, Integer r14, Integer r15, Double r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        Integer r2 = r9.top;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Integer r3 = r9.bottom;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Integer r4 = r9.left;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Integer r5 = r9.right;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Integer r6 = r9.width;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Integer r7 = r9.height;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Double r8 = r9.radius;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.url;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final Integer component1() {
        return this.top;
    }

    public final Integer component2() {
        return this.bottom;
    }

    public final Integer component3() {
        return this.left;
    }

    public final Integer component4() {
        return this.right;
    }

    public final Integer component5() {
        return this.width;
    }

    public final Integer component6() {
        return this.height;
    }

    public final Double component7() {
        return this.radius;
    }

    public final String component8() {
        return this.url;
    }

    public final CommonModel$LayoutStyle copy(Integer r11, Integer r12, Integer r13, Integer r14, Integer r15, Integer r16, Double r17, String r18) {
        return new CommonModel$LayoutStyle(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CommonModel$LayoutStyle) == false) goto L22;
        CommonModel$LayoutStyle r4 = (CommonModel$LayoutStyle) r3;
        if (Intrinsics.areEqual(this.top, r4.top) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bottom, r4.bottom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.left, r4.left) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.right, r4.right) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.width, r4.width) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.height, r4.height) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.radius, r4.radius) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.top;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.bottom;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.left;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.right;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.width;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.height;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Double r19 = this.radius;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.url;
        if (r22 == null) goto L34;
        r1 = r22.hashCode();
    L34:
        return r21 + r1;
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "LayoutStyle(top=" + this.top + ", bottom=" + this.bottom + ", left=" + this.left + ", right=" + this.right + ", width=" + this.width + ", height=" + this.height + ", radius=" + this.radius + ", url=" + this.url + ")";
    }

    public final Integer getBottom() {
        return this.bottom;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getLeft() {
        return this.left;
    }

    public final Double getRadius() {
        return this.radius;
    }

    public final Integer getRight() {
        return this.right;
    }

    public final Integer getTop() {
        return this.top;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setBottom(Integer r1) {
        this.bottom = r1;
    }

    public CommonModel$LayoutStyle(Integer r1, Integer r2, Integer r3, Integer r4, Integer r5, Integer r6, Double r7, String r8) {
        this.top = r1;
        this.bottom = r2;
        this.left = r3;
        this.right = r4;
        this.width = r5;
        this.height = r6;
        this.radius = r7;
        this.url = r8;
    }

    public /* synthetic */ CommonModel$LayoutStyle(Integer r10, Integer r11, Integer r12, Integer r13, Integer r14, Integer r15, Double r16, String r17, int r18, DefaultConstructorMarker r19) {
        String r2 = null;
        if ((r18 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Double r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
