package com.bytedance.ee.bear.middleground.permission.apply;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f233031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f233032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f233033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f233034d;

    public j1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j1) == true) goto L8;
        return false;
    L8:
        j1 r101 = (j1) r100;
        if (this.f233031a == r101.f233031a) goto L12;
        return false;
    L12:
        if (this.f233032b == r101.f233032b) goto L15;
        return false;
    L15:
        if (this.f233033c == r101.f233033c) goto L18;
        return false;
    L18:
        if (this.f233034d == r101.f233034d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f233031a * 31) + this.f233032b) * 31) + this.f233033c) * 31) + this.f233034d;
    }

    public final String toString() {
        return "PermissionForbidUiConfig(layoutRes=" + this.f233031a + ", noPreviewIconRes=" + this.f233032b + ", noAccessIconRes=" + this.f233033c + ", negativeLoadFailedIconRes=" + this.f233034d + ')';
    }

    public /* synthetic */ j1(int r100) {
        this(R.layout.permission_forbid, R.drawable.ccm_empty_neutral_no_preview, R.drawable.ccm_empty_neutral_no_access, R.drawable.ccm_empty_negative_load_failed);
    }

    public j1(int r100, int r101, int r102, int r103) {
        this.f233031a = r100;
        this.f233032b = r101;
        this.f233033c = r102;
        this.f233034d = r103;
    }
}
