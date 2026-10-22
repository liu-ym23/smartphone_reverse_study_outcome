package com.bytedance.ee.bear.office.common.upload;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeUploadUiController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f235318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f235319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f235320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f235321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OfficeUploadListPanel f235322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<u> f235323f;

    public static void a(OfficeUploadUiController r100) {
        if ((r100.f235318a instanceof FrameLayout) == false) goto L5;
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, e.a(((FrameLayout) r100.f235318a).getContext(), 56));
        r101.gravity = 48;
        r101.leftMargin = e.a(((FrameLayout) r100.f235318a).getContext(), 16);
        r101.rightMargin = e.a(((FrameLayout) r100.f235318a).getContext(), 16);
        r101.topMargin = e.a(((FrameLayout) r100.f235318a).getContext(), 16) + r100.f235320c;
        ViewGroup.LayoutParams r102 = r101;
    L6:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "layoutParams");
        if (r100.f235321d.getParent() != null) goto L10;
        r100.f235318a.addView(r100.f235321d, r102);
        return;
    L10:
        return;
    L5:
        r102 = new ViewGroup.LayoutParams(-1, e.a(r100.f235318a.getContext(), 56));
        goto L6
    }

    public final void b(List<u> r110) {
        Intrinsics.checkNotNullParameter(r110, "items");
        this.f235323f = r110;
        d r100 = this.f235321d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "items");
        k0.f235400a.getClass();
        OfficeUploadBannerState r101 = k0.a(r110);
        OfficeUploadBannerState r102 = OfficeUploadBannerState.IDLE;
        int r103 = 0;
        if (r101 != r102) goto L5;
        int r104 = 8;
    L6:
        r100.setVisibility(r104);
        if (r101 == r102) goto L39;
        r100.f235349d.setText(k0.b(r100.getContext(), r110));
        ProgressBar r105 = r100.f235346a;
        boolean r106 = true;
        if (r101 != OfficeUploadBannerState.UPLOADING) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L15;
        int r108 = 0;
    L16:
        r105.setVisibility(r108);
        ImageView r109 = r100.f235347b;
        OfficeUploadBannerState r111 = OfficeUploadBannerState.SUCCESS;
        if (r101 != r111) goto L19;
        boolean r112 = true;
    L20:
        if (r112 == false) goto L22;
        int r113 = 0;
    L23:
        r109.setVisibility(r113);
        ImageView r114 = r100.f235348c;
        OfficeUploadBannerState r115 = OfficeUploadBannerState.WARNING;
        if (r101 != r115) goto L26;
        boolean r116 = true;
    L27:
        if (r116 == false) goto L29;
        int r117 = 0;
    L30:
        r114.setVisibility(r117);
        ImageView r118 = r100.f235350e;
        if (r101 == r111) goto L35;
        if (r101 == r115) goto L35;
        r106 = false;
    L35:
        if (r106 == true) goto L38;
        r103 = 8;
    L38:
        r118.setVisibility(r103);
        goto L39
    L29:
        r117 = 8;
        goto L30
    L26:
        r116 = false;
        goto L27
    L22:
        r113 = 8;
        goto L23
    L19:
        r112 = false;
        goto L20
    L15:
        r108 = 8;
        goto L16
    L12:
        r107 = false;
    L39:
        this.f235322e.a(r110);
        if (r110.isEmpty() == false) goto L43;
        this.f235322e.setVisibility(8);
        return;
    L43:
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public OfficeUploadUiController(ViewGroup r100, i0 r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "actionListener");
        this.f235318a = r100;
        this.f235319b = r101;
        this.f235320c = r102;
        d r103 = new d(r100.getContext());
        this.f235321d = r103;
        OfficeUploadListPanel r104 = new OfficeUploadListPanel(r100.getContext());
        this.f235322e = r104;
        this.f235323f = CollectionsKt.emptyList();
        r103.setOnBannerClickListener(new AnonymousClass2(this));
        r103.setOnCloseClickListener(new AnonymousClass3(this));
        r104.setOnRemoveClickListener(new AnonymousClass4(this));
        r104.setOnRetryClickListener(new AnonymousClass5(this));
    }
}
