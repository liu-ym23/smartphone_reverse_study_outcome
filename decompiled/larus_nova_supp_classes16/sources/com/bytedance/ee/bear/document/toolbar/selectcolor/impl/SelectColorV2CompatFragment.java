package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.document.toolbar.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import sa5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectColorV2CompatFragment extends SelectColorV2Fragment implements sa5.d {
    public sa5.b q;

    @Override // com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorV2Fragment
    public final View getContentView() {
        return n.b.a.a(super.getContentView(), 2131100548);
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

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        sa5.b r0 = this.q;
        if (r0 == null) goto L6;
        r0.d(this);
        return;
    }

    public SelectColorV2CompatFragment() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorV2Fragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        sa5.b r3 = (sa5.b) m.a.a(getActivity(), sa5.b.class);
        this.q = r3;
        if (r3 == null) goto L6;
        r3.e(this);
        return;
    }

    @Override // com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorV2Fragment
    public final Dialog onCreateDialog(Bundle r3) {
        setStyle(0, 2131953407);
        Dialog r4 = super.onCreateDialog(r3);
        if (r4.getWindow() == null) goto L5;
        r4.getWindow().setWindowAnimations(2131953379);
    L5:
        return r4;
    }
}
