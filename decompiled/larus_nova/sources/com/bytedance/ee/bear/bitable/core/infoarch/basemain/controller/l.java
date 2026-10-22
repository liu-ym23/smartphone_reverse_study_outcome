package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ee.bear.bitable.core.infoarch.basemain.view.OfficeBaseMainInfoArchViewHolder;
import com.bytedance.ee.bear.bitable.core.infoarch.basemain.view.OfficeBaseMainOverlayType;
import com.bytedance.ee.bear.bitable.core.infoarch.basemain.view.OfficeBaseMainTopLayout;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.BitableNativeViewContainer;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeBaseMainInfoArchViewHolder f210434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.core.infoarch.g f210435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f210436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f210437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f210438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CoordinatorLayout.Behavior<?> f210439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f210440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r f210441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f210442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f210443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f210444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f210445l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f210446m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f210447n;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f210448a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f210449b = null;

        static {
            int[] r100 = new int[OfficeBaseMainOverlayType.values().length];
            r100[OfficeBaseMainOverlayType.LINKED_DOCX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r100[OfficeBaseMainOverlayType.FORM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[OfficeBaseMainOverlayType.NATIVE_VIEW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            f210448a = r100;
            int[] r101 = new int[OfficeBaseMainContentTopMode.values().length];
            r101[OfficeBaseMainContentTopMode.BELOW_CHROME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r101[OfficeBaseMainContentTopMode.EDGE_TO_EDGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r101[OfficeBaseMainContentTopMode.BELOW_STATUS_BAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            f210449b = r101;
        }
    }

    public final boolean b() {
        com.bytedance.ee.bear.bitable.core.infoarch.g r100 = this.f210435b;
        if (r100.f210554b == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.f210555c == true) goto L7;
        return true;
    }

    public final void f() {
        OfficeBaseMainTopLayout r100 = this.f210434a.f210513j;
        Boolean r101 = this.f210442i;
        Boolean r102 = Boolean.TRUE;
        Drawable r103 = null;
        if (Intrinsics.areEqual(r101, r102) == false) goto L6;
    L17:
        Drawable r104 = null;
    L22:
        r100.setBackground(r104);
        ViewGroup r105 = this.f210434a.f210509f;
        if (this.f210444k == true) goto L26;
    L50:
        r105.setBackground(r103);
        if (Intrinsics.areEqual(this.f210442i, r102) == false) goto L53;
    L58:
        boolean r106 = true;
    L59:
        if (r106 == true) goto L61;
    L79:
        this.f210434a.f210509f.setClipToOutline(false);
        this.f210434a.f210509f.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        this.f210434a.f210509f.invalidateOutline();
        return;
    L61:
        if (this.f210444k == false) goto L79;
        if (this.f210435b.f210553a == true) goto L65;
    L67:
        boolean r107 = false;
    L68:
        if (r107 == false) goto L72;
        if (this.f210445l == false) goto L79;
    L72:
        if (this.f210435b.f210553a == false) goto L76;
        if (this.f210445l == false) goto L79;
    L76:
        if (this.f210443j == false) goto L79;
        float r108 = com.bytedance.ee.util.ui.n.c(24.0f);
        this.f210434a.f210509f.setClipToOutline(true);
        this.f210434a.f210509f.setOutlineProvider(new n(r108));
        this.f210434a.f210509f.invalidateOutline();
        return;
    L65:
        if (b() == false) goto L67;
        r107 = true;
        goto L68
    L53:
        if (this.f210446m == true) goto L55;
    L57:
        r106 = false;
        goto L59
    L55:
        if (b() == false) goto L57;
    L26:
        if (this.f210446m == false) goto L31;
        if (b() == false) goto L31;
        r103 = this.f210437d;
    L31:
        if (Intrinsics.areEqual(this.f210442i, r102) == false) goto L50;
        if (this.f210445l == false) goto L36;
        r103 = this.f210437d;
        goto L50
    L36:
        if (this.f210435b.f210553a == true) goto L38;
    L40:
        boolean r109 = false;
    L41:
        if (r109 == true) goto L50;
        if (this.f210435b.f210553a == false) goto L46;
    L49:
        r103 = this.f210436c;
        goto L50
    L46:
        if (this.f210443j == false) goto L49;
        r103 = this.f210437d;
        goto L50
    L38:
        if (b() == false) goto L40;
        r109 = true;
        goto L41
    L6:
        if (this.f210446m == false) goto L11;
        if (b() == true) goto L17;
    L11:
        if (this.f210435b.f210553a == true) goto L13;
    L15:
        boolean r110 = false;
    L16:
        if (r110 == true) goto L17;
        if (this.f210435b.f210553a == false) goto L21;
        r104 = this.f210436c;
        goto L22
    L21:
        r104 = this.f210437d;
        goto L22
    L13:
        if (b() == false) goto L15;
        r110 = true;
        goto L16
    }

    public final void h() {
        ViewGroup.LayoutParams r100 = this.f210434a.f210512i.getLayoutParams();
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.topMargin == 0) goto L12;
        r101.topMargin = 0;
        this.f210434a.f210512i.setLayoutParams(r101);
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void c(r r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneState");
        this.f210441h = r100;
        this.f210444k = r100.f210481j;
        this.f210445l = r100.f210482k;
        int r101 = 0;
        if (r100.f210473b == true) goto L11;
        int r102 = OfficeBaseMainHeaderAppBarBehavior.f210312e;
        OfficeBaseMainHeaderAppBarBehavior r103 = OfficeBaseMainHeaderAppBarBehavior.a.a(this.f210434a.f210505b);
        if (r103 == null) goto L10;
        AppBarLayout r104 = this.f210434a.f210505b;
        Intrinsics.checkNotNullParameter(r104, "appBarLayout");
        ValueAnimator r105 = r103.f210315c;
        if (r105 == null) goto L9;
        r105.cancel();
    L9:
        r103.f210315c = null;
        r103.c(r104, false, false);
    L10:
        this.f210434a.f210505b.setTranslationY(0.0f);
        this.f210434a.f210505b.setAlpha(1.0f);
    L11:
        AppBarLayout r106 = this.f210434a.f210505b;
        if (r100.f210473b == true) goto L15;
        r101 = 8;
    L15:
        r106.setVisibility(r101);
        e(r100.f210474c);
        a(r100.f210475d, r100.f210483l);
        d(r100.f210479h, r100.f210480i);
    }

    public final void e(boolean r100) {
        ViewGroup.LayoutParams r101 = this.f210434a.f210512i.getLayoutParams();
        int r102 = 0;
        if (r100 == false) goto L5;
        int r103 = this.f210440g;
    L7:
        if (r101.height == r103) goto L9;
        r101.height = r103;
        this.f210434a.f210512i.setLayoutParams(r101);
    L9:
        ViewGroup r104 = this.f210434a.f210512i;
        if (r100 == false) goto L12;
        int r105 = 0;
    L13:
        r104.setVisibility(r105);
        OfficeBaseMainTopLayout r106 = this.f210434a.f210513j;
        if (r100 == true) goto L17;
        r102 = 8;
    L17:
        r106.setVisibility(r102);
        h();
        return;
    L12:
        r105 = 8;
        goto L13
    L5:
        r103 = 0;
        goto L7
    }

    public final void g(boolean r100) {
        BitableNativeViewContainer r101 = this.f210434a.f210519p;
        if (this.f210446m == false) goto L7;
        if (r100 == false) goto L7;
        boolean r102 = false;
    L8:
        r101.setBackgroundAllowed(r102);
        return;
    L7:
        r102 = true;
        goto L8
    }

    public final void a(boolean r100, OfficeBaseMainContentTopMode r101) {
        ViewGroup.LayoutParams r102 = this.f210434a.f210509f.getLayoutParams();
        CoordinatorLayout.Behavior r103 = null;
        if ((r102 instanceof CoordinatorLayout.LayoutParams) == false) goto L5;
        CoordinatorLayout.LayoutParams r104 = (CoordinatorLayout.LayoutParams) r102;
    L6:
        if (r104 == null) goto L33;
        if (r100 == true) goto L10;
        r103 = this.f210439f;
    L10:
        int r105 = a.f210449b[r101.ordinal()];
        boolean r106 = false;
        boolean r107 = true;
        if (r105 != 1) goto L13;
    L19:
        int r108 = 0;
    L21:
        if (r104.getBehavior() == r103) goto L24;
        r104.setBehavior(r103);
        r106 = true;
    L24:
        if (((ViewGroup.MarginLayoutParams) r104).topMargin == r108) goto L27;
        ((ViewGroup.MarginLayoutParams) r104).topMargin = r108;
        r106 = true;
    L27:
        if (((ViewGroup.MarginLayoutParams) r104).height == (-1)) goto L29;
        ((ViewGroup.MarginLayoutParams) r104).height = -1;
    L30:
        if (r107 == false) goto L34;
        this.f210434a.f210509f.setLayoutParams(r104);
        this.f210434a.f210509f.requestLayout();
        return;
    L34:
        return;
    L29:
        r107 = r106;
        goto L30
    L13:
        if (r105 == 2) goto L19;
        if (r105 != 3) goto L18;
        r108 = this.f210447n;
        goto L21
    L18:
        throw new NoWhenBranchMatchedException();
    L33:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void d(boolean r100, boolean r101) {
        if (Intrinsics.areEqual(this.f210442i, Boolean.valueOf(r100)) == true) goto L5;
    L8:
        this.f210442i = Boolean.valueOf(r100);
        this.f210443j = r101;
        OfficeBaseMainTopLayout r102 = this.f210434a.f210513j;
        if (r100 == false) goto L11;
        int r103 = 8;
    L12:
        r102.setVisibility(r103);
        this.f210434a.f210509f.setClipChildren(true);
        this.f210434a.f210509f.setClipToPadding(true);
        f();
        return;
    L11:
        r103 = 0;
        goto L12
    L5:
        if (this.f210443j != r101) goto L8;
        f();
    }

    public l(Context r100, OfficeBaseMainInfoArchViewHolder r101, com.bytedance.ee.bear.bitable.core.infoarch.g r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        Intrinsics.checkNotNullParameter(r102, "state");
        this.f210434a = r101;
        this.f210435b = r102;
        this.f210436c = AppCompatResources.getDrawable(r100, R.drawable.bitable_pin_bg_without_radius);
        this.f210437d = AppCompatResources.getDrawable(r100, R.drawable.bitable_pin_bg_with_radius);
        this.f210440g = r101.f210512i.getLayoutParams().height;
        this.f210443j = true;
        this.f210444k = true;
        this.f210447n = com.bytedance.ee.util.ui.k.e(r100);
    }
}
