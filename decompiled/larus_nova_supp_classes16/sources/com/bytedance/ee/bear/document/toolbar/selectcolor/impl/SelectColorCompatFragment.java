package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.toolbar.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import sa5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectColorCompatFragment extends SelectColorFragment implements sa5.d {
    public sa5.b l;

    @Override // com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorFragment
    public final SelectColorViewModel Z90() {
        return (SelectColorViewModel) q.a(this, SelectColorViewModel.class);
    }

    @Override // com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorFragment, com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment
    public final View getContentView() {
        return n.b.a.a(super.getContentView(), 2131103449);
    }

    @Override // sa5.d
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

    @Override // com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        sa5.b r0 = this.l;
        if (r0 == null) goto L6;
        r0.d(this);
        return;
    }

    public SelectColorCompatFragment() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorFragment, com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        sa5.b r3 = (sa5.b) m.a.a(getActivity(), sa5.b.class);
        this.l = r3;
        if (r3 == null) goto L6;
        r3.e(this);
        return;
    }

    @Override // com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorFragment, com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment
    public final Dialog onCreateDialog(Bundle r6) {
        setStyle(0, 2131953407);
        Dialog r7 = super.onCreateDialog(r6);
        Window r0 = r7.getWindow();
        if (r0 == null) goto L5;
        WindowManager.LayoutParams r1 = r0.getAttributes();
        r1.height = ((int) (r1.height + getResources().getDimension(2131168470))) + com.bytedance.ee.util.ui.n.d(6);
        r0.setWindowAnimations(2131953379);
        r0.setAttributes(r1);
    L5:
        return r7;
    }
}
