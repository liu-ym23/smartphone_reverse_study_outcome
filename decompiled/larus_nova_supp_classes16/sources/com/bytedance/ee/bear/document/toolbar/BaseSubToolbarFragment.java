package com.bytedance.ee.bear.document.toolbar;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseSubToolbarFragment extends BaseAntiScreenshotsDialogFragment implements ocb.a {
    public View getContentView() {
        return new View(getContext());
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public void onDestroy() {
        if (getActivity() != null) goto L5;
    L7:
        super.onDestroy();
        return;
    L5:
        if (getActivity().getSupportFragmentManager().isDestroyed() == true) goto L7;
        pcb.a.a.b(getActivity()).a(this);
        goto L7
    }

    public BaseSubToolbarFragment() {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        pcb.a.a.b(getActivity()).c(this);
    }

    public Dialog onCreateDialog(Bundle r5) {
        Dialog r6 = super.onCreateDialog(r5);
        r6.requestWindowFeature(1);
        View r1 = getContentView();
        com.bytedance.ee.util.ui.l.b(r1, 2131100548);
        ViewGroup r3 = (ViewGroup) r1.getParent();
        if (r3 == null) goto L5;
        r3.removeAllViews();
        com.bytedance.ee.util.ui.l.b(r3, 2131100548);
    L5:
        r6.setContentView(r1);
        if (r6.getWindow() == null) goto L12;
        WindowManager.LayoutParams r2 = r6.getWindow().getAttributes();
        r2.type = UploadResult.UPLOAD_CACELL;
        r2.width = -1;
        int r4 = pcb.a.a.b(getActivity()).keyBoardRawHeight();
        if (r4 >= 300) goto L11;
        r4 = com.bytedance.ee.util.ui.n.d(300);
    L11:
        r2.height = r4;
        r2.softInputMode = 1;
        r2.flags = (r2.flags | 264) & (-3);
        r2.gravity = 80;
        r6.getWindow().setAttributes(r2);
        r6.getWindow().setBackgroundDrawableResource(R.color.transparent);
        r6.setCanceledOnTouchOutside(false);
    L12:
        return r6;
    }

    public final void onKeyboardHeightChanged(pcb.a r4, int r5, int r6) {
        if (r5 <= 0) goto L16;
        Dialog r7 = getDialog();
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.isShowing() == false) goto L18;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L19;
        View r9 = r8.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L14;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L14:
        WindowManager.LayoutParams r1 = r8.getAttributes();
        r1.height = r5;
        r8.getWindowManager().updateViewLayout(r9, r1);
        return;
    L19:
        return;
    L18:
        return;
    }
}
