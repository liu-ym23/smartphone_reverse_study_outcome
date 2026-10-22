package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003JE\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017¨\u0006\u001e"}, d2 = {"com/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle", "", "", "component1", "component2", "component3", "component4", "component5", "color", "colorDark", "colorLight", "colorFrom", "colorTo", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getColor", "()Ljava/lang/String;", "getColorDark", "getColorLight", "getColorFrom", "getColorTo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonModel$CommonColorStyle {
    private final String color;
    private final String colorDark;
    private final String colorFrom;
    private final String colorLight;
    private final String colorTo;

    public CommonModel$CommonColorStyle() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CommonModel$CommonColorStyle copy$default(CommonModel$CommonColorStyle r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.color;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.colorDark;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.colorLight;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.colorFrom;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.colorTo;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.color;
    }

    public final String component2() {
        return this.colorDark;
    }

    public final String component3() {
        return this.colorLight;
    }

    public final String component4() {
        return this.colorFrom;
    }

    public final String component5() {
        return this.colorTo;
    }

    public final CommonModel$CommonColorStyle copy(String r8, String r9, String r10, String r11, String r12) {
        return new CommonModel$CommonColorStyle(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CommonModel$CommonColorStyle) == false) goto L16;
        CommonModel$CommonColorStyle r4 = (CommonModel$CommonColorStyle) r3;
        if (Intrinsics.areEqual(this.color, r4.color) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.colorDark, r4.colorDark) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.colorLight, r4.colorLight) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.colorFrom, r4.colorFrom) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.colorTo, r4.colorTo) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.color;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.colorDark;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.colorLight;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.colorFrom;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.colorTo;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
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
        return "CommonColorStyle(color=" + this.color + ", colorDark=" + this.colorDark + ", colorLight=" + this.colorLight + ", colorFrom=" + this.colorFrom + ", colorTo=" + this.colorTo + ")";
    }

    public final String getColor() {
        return this.color;
    }

    public final String getColorDark() {
        return this.colorDark;
    }

    public final String getColorFrom() {
        return this.colorFrom;
    }

    public final String getColorLight() {
        return this.colorLight;
    }

    public final String getColorTo() {
        return this.colorTo;
    }

    public CommonModel$CommonColorStyle(String r1, String r2, String r3, String r4, String r5) {
        this.color = r1;
        this.colorDark = r2;
        this.colorLight = r3;
        this.colorFrom = r4;
        this.colorTo = r5;
    }

    public /* synthetic */ CommonModel$CommonColorStyle(String r5, String r6, String r7, String r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        String r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
