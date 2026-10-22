package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"com/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "component1", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "component2", "layoutStyle", "textStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc;", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "getLayoutStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "getTextStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "<init>", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonModel$ModuleDesc {
    private final CommonModel$LayoutStyle layoutStyle;
    private final CommonModel$CusTextStyle textStyle;

    public static /* synthetic */ CommonModel$ModuleDesc copy$default(CommonModel$ModuleDesc r0, CommonModel$LayoutStyle r1, CommonModel$CusTextStyle r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.layoutStyle;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.textStyle;
    L9:
        return r0.copy(r1, r2);
    }

    public final CommonModel$LayoutStyle component1() {
        return this.layoutStyle;
    }

    public final CommonModel$CusTextStyle component2() {
        return this.textStyle;
    }

    public final CommonModel$ModuleDesc copy(CommonModel$LayoutStyle r2, CommonModel$CusTextStyle r3) {
        Intrinsics.checkNotNullParameter(r2, "layoutStyle");
        Intrinsics.checkNotNullParameter(r3, "textStyle");
        return new CommonModel$ModuleDesc(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CommonModel$ModuleDesc) == false) goto L10;
        CommonModel$ModuleDesc r4 = (CommonModel$ModuleDesc) r3;
        if (Intrinsics.areEqual(this.layoutStyle, r4.layoutStyle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textStyle, r4.textStyle) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        CommonModel$LayoutStyle r0 = this.layoutStyle;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        CommonModel$CusTextStyle r4 = this.textStyle;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ModuleDesc(layoutStyle=" + this.layoutStyle + ", textStyle=" + this.textStyle + ")";
    }

    public final CommonModel$LayoutStyle getLayoutStyle() {
        return this.layoutStyle;
    }

    public final CommonModel$CusTextStyle getTextStyle() {
        return this.textStyle;
    }

    public CommonModel$ModuleDesc(CommonModel$LayoutStyle r2, CommonModel$CusTextStyle r3) {
        Intrinsics.checkNotNullParameter(r2, "layoutStyle");
        Intrinsics.checkNotNullParameter(r3, "textStyle");
        this.layoutStyle = r2;
        this.textStyle = r3;
    }
}
