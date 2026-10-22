package com.bytedance.ee.bear.office.common.upload;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f235363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f235364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f235365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f235366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f235367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f235368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f235369g;

    public final void a(int r100) {
        if (this.f235369g != r100) goto L5;
        return;
    L5:
        this.f235369g = r100;
        this.f235363a.setPadding(this.f235365c, this.f235366d + r100, this.f235367e, this.f235368f);
    }

    public g(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "contentTarget");
        this.f235363a = r100;
        this.f235364b = r101;
        this.f235365c = r100.getPaddingLeft();
        this.f235366d = r100.getPaddingTop();
        this.f235367e = r100.getPaddingRight();
        this.f235368f = r100.getPaddingBottom();
    }
}
