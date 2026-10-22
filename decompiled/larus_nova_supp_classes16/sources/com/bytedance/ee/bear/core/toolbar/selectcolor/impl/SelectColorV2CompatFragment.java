package com.bytedance.ee.bear.core.toolbar.selectcolor.impl;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import gx4.c;
import sa5.b;
import sa5.d;
import sa5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectColorV2CompatFragment extends SelectColorV2Fragment implements d {
    public b q;

    @Override // com.bytedance.ee.bear.core.toolbar.selectcolor.impl.SelectColorV2Fragment
    public final View getContentView() {
        return c.b.a.a(super.getContentView(), 2131100548);
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
        b r0 = this.q;
        if (r0 == null) goto L6;
        r0.d(this);
        return;
    }

    public SelectColorV2CompatFragment() {
    }

    @Override // com.bytedance.ee.bear.core.toolbar.selectcolor.impl.SelectColorV2Fragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        b r3 = (b) m.a.a(getActivity(), b.class);
        this.q = r3;
        if (r3 == null) goto L6;
        r3.e(this);
        return;
    }

    @Override // com.bytedance.ee.bear.core.toolbar.selectcolor.impl.SelectColorV2Fragment
    public final Dialog onCreateDialog(Bundle r3) {
        setStyle(0, 2131953786);
        Dialog r4 = super.onCreateDialog(r3);
        if (r4.getWindow() == null) goto L5;
        r4.getWindow().setWindowAnimations(2131953785);
    L5:
        return r4;
    }
}
