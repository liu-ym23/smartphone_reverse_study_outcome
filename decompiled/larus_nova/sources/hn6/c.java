package hn6;

import com.bytedance.locallife.biz.btm.btm_checker.interfaces.CheckReason;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CheckReason f486116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f486117c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f486115a == r101.f486115a) goto L12;
        return false;
    L12:
        if (this.f486116b == r101.f486116b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486117c, r101.f486117c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f486115a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        CheckReason r102 = this.f486116b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return ((r101 + r103) * 31) + this.f486117c.hashCode();
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "CheckResp(isPass=" + this.f486115a + ", reason=" + this.f486116b + ", req=" + this.f486117c + ')';
    }

    public c(boolean r100, CheckReason r101, b r102) {
        Intrinsics.checkNotNullParameter(r102, HiAnalyticsConstant.Direction.REQUEST);
        this.f486115a = r100;
        this.f486116b = r101;
        this.f486117c = r102;
    }
}
