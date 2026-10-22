package com.bytedance.ee.bear.office.common.upload;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeUploadUiController {
    public final ViewGroup a;
    public final i0 b;
    public final int c;
    public final d d;
    public final OfficeUploadListPanel e;
    public List<u> f;

    public static void a(OfficeUploadUiController r4) {
        if ((r4.a instanceof FrameLayout) == false) goto L5;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, e.a(((FrameLayout) r4.a).getContext(), 56));
        r0.gravity = 48;
        r0.leftMargin = e.a(((FrameLayout) r4.a).getContext(), 16);
        r0.rightMargin = e.a(((FrameLayout) r4.a).getContext(), 16);
        r0.topMargin = e.a(((FrameLayout) r4.a).getContext(), 16) + r4.c;
        ViewGroup.LayoutParams r1 = r0;
    L6:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r1, "layoutParams");
        if (r4.d.getParent() != null) goto L10;
        r4.a.addView(r4.d, r1);
        return;
    L10:
        return;
    L5:
        r1 = new ViewGroup.LayoutParams(-1, e.a(r4.a.getContext(), 56));
        goto L6
    }

    public final void b(List<u> r10) {
        Intrinsics.checkNotNullParameter(r10, "items");
        this.f = r10;
        d r1 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "items");
        k0.a.getClass();
        OfficeUploadBannerState r0 = k0.a(r10);
        OfficeUploadBannerState r2 = OfficeUploadBannerState.IDLE;
        int r3 = 0;
        if (r0 != r2) goto L5;
        int r5 = 8;
    L6:
        r1.setVisibility(r5);
        if (r0 == r2) goto L39;
        r1.d.setText(k0.b(r1.getContext(), r10));
        ProgressBar r4 = r1.a;
        boolean r6 = true;
        if (r0 != OfficeUploadBannerState.UPLOADING) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        int r8 = 0;
    L16:
        r4.setVisibility(r8);
        ImageView r9 = r1.b;
        OfficeUploadBannerState r11 = OfficeUploadBannerState.SUCCESS;
        if (r0 != r11) goto L19;
        boolean r12 = true;
    L20:
        if (r12 == false) goto L22;
        int r13 = 0;
    L23:
        r9.setVisibility(r13);
        ImageView r14 = r1.c;
        OfficeUploadBannerState r15 = OfficeUploadBannerState.WARNING;
        if (r0 != r15) goto L26;
        boolean r16 = true;
    L27:
        if (r16 == false) goto L29;
        int r17 = 0;
    L30:
        r14.setVisibility(r17);
        ImageView r18 = r1.e;
        if (r0 == r11) goto L35;
        if (r0 == r15) goto L35;
        r6 = false;
    L35:
        if (r6 == true) goto L38;
        r3 = 8;
    L38:
        r18.setVisibility(r3);
        goto L39
    L29:
        r17 = 8;
        goto L30
    L26:
        r16 = false;
        goto L27
    L22:
        r13 = 8;
        goto L23
    L19:
        r12 = false;
        goto L20
    L15:
        r8 = 8;
        goto L16
    L12:
        r7 = false;
    L39:
        this.e.a(r10);
        if (r10.isEmpty() == false) goto L43;
        this.e.setVisibility(8);
        return;
    L43:
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public OfficeUploadUiController(ViewGroup r2, i0 r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "actionListener");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        d r5 = new d(r2.getContext());
        this.d = r5;
        OfficeUploadListPanel r6 = new OfficeUploadListPanel(r2.getContext());
        this.e = r6;
        this.f = CollectionsKt.emptyList();
        r5.setOnBannerClickListener(new AnonymousClass2(this));
        r5.setOnCloseClickListener(new AnonymousClass3(this));
        r6.setOnRemoveClickListener(new AnonymousClass4(this));
        r6.setOnRetryClickListener(new AnonymousClass5(this));
    }
}
