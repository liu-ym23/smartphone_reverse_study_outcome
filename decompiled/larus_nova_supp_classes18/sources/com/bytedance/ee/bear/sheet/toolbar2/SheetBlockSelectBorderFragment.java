package com.bytedance.ee.bear.sheet.toolbar2;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment;
import com.bytedance.ee.bear.document.toolbar.n;
import com.bytedance.ee.bear.sheet.borderline.BorderLinePanelView;
import com.bytedance.ee.bear.sheet.borderline.BorderLineViewModel;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import nn5.f;
import sa5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetBlockSelectBorderFragment extends BaseSubToolbarFragment implements BorderLinePanelView.b, sa5.d {
    public static final /* synthetic */ int l = 0;
    public View h;
    public BorderLinePanelView i;
    public BorderLineViewModel j;
    public sa5.b k;

    public class a extends CommonActionPanelLayout.b {
        public final /* synthetic */ SheetBlockSelectBorderFragment a;

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public final void b() {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public a(SheetBlockSelectBorderFragment r1) {
            this.a = r1;
        }
    }

    public final View getContentView() {
        final CommonActionPanelLayout r0 = (CommonActionPanelLayout) LayoutInflater.from(getContext()).inflate(2131564524, null);
        r0.setOnActionListener(new a(this));
        this.h = r0.getTopBar();
        BorderLinePanelView r1 = (BorderLinePanelView) r0.findViewById(2131364342);
        this.i = r1;
        r1.setDelegate(this);
        this.j.getBorderLineData().observe(this, new f(this, r0));
        return n.b.a.a(r0, 2131100548);
    }

    public final boolean onBackPressed() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return true;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L12;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return true;
    L12:
        return true;
    }

    public final void onDestroy() {
        super.onDestroy();
        sa5.b r0 = this.k;
        if (r0 == null) goto L6;
        r0.d(this);
        return;
    }

    static {
    }

    public SheetBlockSelectBorderFragment() {
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        getActivity();
        this.j = (BorderLineViewModel) q.a(this, BorderLineViewModel.class);
        sa5.b r3 = (sa5.b) m.a.a(getActivity(), sa5.b.class);
        this.k = r3;
        if (r3 == null) goto L6;
        r3.e(this);
        return;
    }

    public final Dialog onCreateDialog(Bundle r5) {
        setStyle(0, 2131953407);
        Dialog r6 = super.onCreateDialog(r5);
        Window r0 = r6.getWindow();
        if (r0 == null) goto L5;
        WindowManager.LayoutParams r2 = r0.getAttributes();
        this.h.measure(0, 0);
        r2.height += this.h.getMeasuredHeight();
        r0.setWindowAnimations(2131953379);
        r0.setAttributes(r2);
    L5:
        return r6;
    }

    @Override // com.bytedance.ee.bear.sheet.borderline.BorderLinePanelView.b
    public final void P30(String r2, String r3, String r4) {
        BorderLineViewModel r0 = this.j;
        if (r0 == null) goto L6;
        r0.onBorderLineSelected(r2, r3, r4);
        return;
    }
}
