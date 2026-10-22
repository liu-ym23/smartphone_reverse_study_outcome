package com.bytedance.ee.bear.document.toolbar;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseSubToolbarFragment extends BaseAntiScreenshotsDialogFragment implements ocb.a {
    public View getContentView() {
        return new View(getContext());
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (getActivity() != null) goto L5;
    L7:
        super.onDestroy();
        return;
    L5:
        if (getActivity().getSupportFragmentManager().isDestroyed() == true) goto L7;
        pcb.a.AbstractC7181a.b(getActivity()).a(this);
        goto L7
    }

    public BaseSubToolbarFragment() {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        pcb.a.AbstractC7181a.b(getActivity()).c(this);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.requestWindowFeature(1);
        View r102 = getContentView();
        com.bytedance.ee.util.ui.l.b(r102, R.color.bg_body);
        ViewGroup r103 = (ViewGroup) r102.getParent();
        if (r103 == null) goto L5;
        r103.removeAllViews();
        com.bytedance.ee.util.ui.l.b(r103, R.color.bg_body);
    L5:
        r101.setContentView(r102);
        if (r101.getWindow() == null) goto L12;
        WindowManager.LayoutParams r104 = r101.getWindow().getAttributes();
        r104.type = 1000;
        r104.width = -1;
        int r105 = pcb.a.AbstractC7181a.b(getActivity()).keyBoardRawHeight();
        if (r105 >= 300) goto L11;
        r105 = com.bytedance.ee.util.ui.n.d(300);
    L11:
        r104.height = r105;
        r104.softInputMode = 1;
        r104.flags = (r104.flags | MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME) & (-3);
        r104.gravity = 80;
        r101.getWindow().setAttributes(r104);
        r101.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        r101.setCanceledOnTouchOutside(false);
    L12:
        return r101;
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        if (r101 <= 0) goto L16;
        Dialog r103 = getDialog();
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.isShowing() == false) goto L18;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L19;
        View r105 = r104.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L14;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r106 = ThreadMethodProxy.currentThread();
        if (r106 == com.larus.home.impl.utils.c.f346341a) goto L14;
        com.larus.home.impl.utils.c.a(r106, "getDecorView");
    L14:
        WindowManager.LayoutParams r107 = r104.getAttributes();
        r107.height = r101;
        r104.getWindowManager().updateViewLayout(r105, r107);
        return;
    L19:
        return;
    L18:
        return;
    }
}
