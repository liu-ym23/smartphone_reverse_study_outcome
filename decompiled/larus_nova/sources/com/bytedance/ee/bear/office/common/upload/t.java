package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeUploadActionType f235419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0 f235420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f235421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f235422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f235423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Boolean> f235424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<PermissionResponse> f235425g;

    public t() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.f235419a == r101.f235419a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f235420b, r101.f235420b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f235421c, r101.f235421c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f235422d, r101.f235422d) == true) goto L21;
        return false;
    L21:
        if (this.f235423e == r101.f235423e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f235424f, r101.f235424f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f235425g, r101.f235425g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f235419a.hashCode() * 31) + this.f235420b.hashCode()) * 31) + this.f235421c.hashCode()) * 31) + this.f235422d.hashCode()) * 31;
        if (this.f235423e == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.f235424f.hashCode()) * 31) + this.f235425g.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeUploadGuardContext(actionType=" + this.f235419a + ", target=" + this.f235420b + ", ownerReadyProvider=" + this.f235421c + ", networkConnectedProvider=" + this.f235422d + ", menuConfigEnabled=" + this.f235423e + ", parentWritableProvider=" + this.f235424f + ", permissionResponseProvider=" + this.f235425g + ')';
    }

    public t(OfficeUploadActionType r100, g0 r101, Function0 r102, Function0 r103, Function0 r104) {
        OfficeUploadGuardContext$2 r105 = OfficeUploadGuardContext$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "ownerReadyProvider");
        Intrinsics.checkNotNullParameter(r103, "networkConnectedProvider");
        Intrinsics.checkNotNullParameter(r104, "parentWritableProvider");
        Intrinsics.checkNotNullParameter(r105, "permissionResponseProvider");
        this.f235419a = r100;
        this.f235420b = r101;
        this.f235421c = r102;
        this.f235422d = r103;
        this.f235423e = true;
        this.f235424f = r104;
        this.f235425g = r105;
    }
}
