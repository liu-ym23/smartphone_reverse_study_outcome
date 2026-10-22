package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ FormsQRCodePanelFragmentV2 a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        FormsQRCodePanelFragmentV2 r0 = this.a;
        View r1 = r0.n;
        View r2 = null;
        if (r1 != null) goto L9;
        View r3 = r0.getView();
        if (r3 == null) goto L7;
        r1 = r3.findViewById(2131383504);
    L8:
        r0.n = (LinearLayout) r1;
        goto L9
    L7:
        r1 = null;
    L9:
        int r4 = ((LinearLayout) r1).getHeight();
        int r5 = UIUtils.dp2px(r0.requireContext(), 90.0f);
        int r6 = r4 - r5;
        View r7 = r0.o;
        if (r7 != null) goto L16;
        View r8 = r0.getView();
        if (r8 == null) goto L14;
        r7 = r8.findViewById(2131367738);
    L15:
        r0.o = r7;
        goto L16
    L14:
        r7 = null;
    L16:
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        if ((r9 instanceof FrameLayout.LayoutParams) == false) goto L19;
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r9;
    L20:
        if (r10 != null) goto L22;
        r10 = new FrameLayout.LayoutParams(-1, r6);
    L22:
        r10.height = r6;
        r10.topMargin = r5;
        View r11 = r0.o;
        if (r11 != null) goto L28;
        View r12 = r0.getView();
        if (r12 == null) goto L27;
        r2 = r12.findViewById(2131367738);
    L27:
        r0.o = r2;
        r11 = r2;
    L28:
        r11.setLayoutParams(r10);
        this.a.V90().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L19:
        r10 = null;
        goto L20
    }

    public r(FormsQRCodePanelFragmentV2 r1) {
        this.a = r1;
    }
}
