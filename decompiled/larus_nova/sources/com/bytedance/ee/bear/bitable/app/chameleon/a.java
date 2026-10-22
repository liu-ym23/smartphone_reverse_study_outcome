package com.bytedance.ee.bear.bitable.app.chameleon;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f206896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f206897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f206898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f206899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f206900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f206901f;

    public a(ViewGroup r100, ViewGroup r101, ViewGroup r102, ViewGroup r103) {
        FrameLayout r104 = new FrameLayout(r100.getContext());
        FrameLayout r105 = new FrameLayout(r100.getContext());
        Intrinsics.checkNotNullParameter(r100, "rootContainer");
        Intrinsics.checkNotNullParameter(r101, "contentContainer");
        Intrinsics.checkNotNullParameter(r102, "webContainer");
        Intrinsics.checkNotNullParameter(r103, "businessOverlayContainer");
        Intrinsics.checkNotNullParameter(r104, "drawerContainer");
        Intrinsics.checkNotNullParameter(r105, "permissionContainer");
        this.f206896a = r100;
        this.f206897b = r101;
        this.f206898c = r102;
        this.f206899d = r103;
        this.f206900e = r104;
        this.f206901f = r105;
        r104.setId(R.id.bitable_app_drawer_container);
        r104.setVisibility(8);
        r105.setId(R.id.permission_forbid_layout);
        r105.setVisibility(8);
        r100.addView(r104, new ViewGroup.LayoutParams(-1, -1));
        r103.addView(r105, new ViewGroup.LayoutParams(-1, -1));
    }
}
