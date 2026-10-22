package uza;

import com.ss.android.lark.biz.officesdk.im.share.IOfficeSDKSharePanelType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IOfficeSDKSharePanelType f552233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f552234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f552235c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f552233a == r101.f552233a) goto L12;
        return false;
    L12:
        if (this.f552234b == r101.f552234b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f552235c, r101.f552235c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f552233a.hashCode() * 31;
        if (this.f552234b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f552235c;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SharePanelItem(type=" + this.f552233a + ", enableStatus=" + this.f552234b + ", disableTip=" + this.f552235c + ')';
    }

    public final IOfficeSDKSharePanelType getType() {
        return this.f552233a;
    }

    public c(IOfficeSDKSharePanelType r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f552233a = r100;
        this.f552234b = r101;
        this.f552235c = r102;
    }
}
