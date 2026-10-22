package zd0;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements yd0.c<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f571285a;

    public b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        this.f571285a = r100;
    }

    @Override // yd0.c
    public final void a(yd0.b r100) {
        c r101 = (c) r100;
        Intrinsics.checkNotNullParameter(r101, "bgView");
        this.f571285a.removeView(r101.f571286a);
    }

    @Override // yd0.c
    public final void b(yd0.b r100) {
        c r101 = (c) r100;
        Intrinsics.checkNotNullParameter(r101, "bgView");
        ViewGroup.LayoutParams r102 = new ViewGroup.LayoutParams(-1, -1);
        r101.f571286a.setLayoutParams(r102);
        this.f571285a.addView(r101.f571286a, r102);
    }

    @Override // yd0.b
    public final void setVisible(boolean r100) {
        ViewGroup r101 = this.f571285a;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }
}
