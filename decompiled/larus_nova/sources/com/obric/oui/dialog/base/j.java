package com.obric.oui.dialog.base;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final /* synthetic */ class j implements xma.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractDialogModal f400721a;

    public /* synthetic */ j(r r100) {
        this.f400721a = r100;
    }

    public final xma.e a(xma.e r100) {
        AbstractDialogModal r101 = this.f400721a;
        Intrinsics.checkNotNullParameter(r101, "this$0");
        boolean r102 = zma.a.g(r101.getContext());
        int r103 = r100.f564561a.f(8).f564557d;
        zma.a r104 = zma.a.f572881a;
        boolean r105 = zma.a.h(r101.getContext());
        Context r106 = r101.getContext();
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        Activity r107 = r104.getActivity(r106);
        if (Build.VERSION.SDK_INT < 24) goto L7;
        if (r107 == null) goto L7;
        boolean r108 = r107.isInMultiWindowMode();
    L8:
        boolean r109 = true;
        if (r108 == true) goto L13;
        if (r105 == true) goto L13;
        boolean r110 = false;
    L14:
        if (r110 == false) goto L16;
        int r111 = 0;
    L17:
        if (r102 == true) goto L21;
        if (r110 == true) goto L21;
        r109 = false;
    L21:
        if (r109 == false) goto L23;
        int r112 = r101.getContext().getResources().getDimensionPixelSize(R.dimen.oui_dialog_layout_margin);
    L24:
        if (r109 == true) goto L27;
        r112 = Math.max(r112, r111);
    L27:
        int r113 = r101.getContext().getResources().getDimensionPixelSize(R.dimen.oui_dialog_layout_margin_to_ime);
        wma.b.g("AbstractDialogModal", Intrinsics.stringPlus("onApplyWindowInsets, update, imeBottom: ", Integer.valueOf(r103)));
        ViewGroup.LayoutParams r114 = r101.getDialogRootView().getLayoutParams();
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == false) goto L30;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
    L31:
        if (r115 != null) goto L34;
    L42:
        return r100;
    L34:
        if (r101.f400675a == false) goto L37;
        r115.bottomMargin = 0;
        r101.getDialogRootView().setLayoutParams(r115);
        r101.getDialogRootView().setTranslationY(0.0f);
        r101.getDialogRootView().setPadding(r101.getDialogRootView().getPaddingLeft(), r101.getDialogRootView().getPaddingTop(), r101.getDialogRootView().getPaddingRight(), r103);
        goto L42
    L37:
        if (r115.bottomMargin == r112) goto L39;
        r115.bottomMargin = r112;
        r101.getDialogRootView().setLayoutParams(r115);
    L39:
        if (r103 <= 0) goto L41;
        r101.a(-(((r103 + r111) + r113) - r115.bottomMargin));
        goto L42
    L41:
        r101.a(0);
        goto L42
    L30:
        r115 = null;
        goto L31
    L23:
        r112 = r101.getContext().getResources().getDimensionPixelSize(R.dimen.oui_dialog_layout_margin_with_three_button_mode);
        goto L24
    L16:
        r111 = zma.a.e(r101.getContext());
    L13:
        r110 = true;
    L7:
        r108 = false;
        goto L8
    }
}
