package com.ss.android.lark.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import com.ss.android.lark.widget.dialog.loadingdialog.LoadingDialog;

/* JADX INFO: loaded from: classes38.dex */
public class CommonLoadingDialog {
    private final int DIALOG_ANIMATION_SPEED;
    private final int DIALOG_CORNER_RADIUS;
    private final float DIALOG_DIM_AMOUNT;
    private final int DIALOG_LABEL_TEXT_SIZE;
    private final int DIALOG_SIZE;
    private final int DIALOG_VIEW_SIZE;
    private boolean mCancellable;
    private int mDialogSize;
    private String mLabel;
    private LoadingDialog mLoadingDialog;

    public void dismiss() {
        LoadingDialog r100 = this.mLoadingDialog;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.b() == false) goto L9;
        this.mLoadingDialog.a();
        return;
    }

    public CommonLoadingDialog() {
        this.DIALOG_SIZE = 100;
        this.DIALOG_VIEW_SIZE = 35;
        this.DIALOG_ANIMATION_SPEED = 2;
        this.DIALOG_DIM_AMOUNT = 0.5f;
        this.DIALOG_CORNER_RADIUS = 6;
        this.DIALOG_LABEL_TEXT_SIZE = 14;
        this.mDialogSize = 100;
    }

    private LoadingDialog init(Context r100) {
        LoadingDialog r101 = new LoadingDialog(r100);
        r101.c(LoadingDialog.Style.SPIN_INDETERMINATE);
        int r102 = this.mDialogSize;
        LoadingDialog.b r103 = r101.f445780a;
        r103.f445797j = r102;
        r103.f445798k = r102;
        if (r103.f445796i == null) goto L5;
        r103.b();
    L5:
        LoadingDialog.b r104 = r101.f445780a;
        r104.f445800m = 35;
        r104.f445801n = 35;
        if (r104.f445795h == null) goto L8;
        r104.c();
    L8:
        boolean r105 = this.mCancellable;
        r101.f445780a.setCancelable(r105);
        r101.f445780a.a(14.0f);
        String r106 = this.mLabel;
        LoadingDialog.b r107 = r101.f445780a;
        r107.f445793f = r106;
        TextView r108 = r107.f445791d;
        if (r108 == null) goto L13;
        if (r106 == null) goto L12;
        r108.setText(r106);
        r107.f445791d.setVisibility(0);
        goto L13
    L12:
        r108.setVisibility(8);
    L13:
        r101.f445783d = 6.0f;
        r101.f445785f = 2;
        r101.f445781b = 0.5f;
        return r101;
    }

    public void setCancellable(boolean r100) {
        this.mCancellable = r100;
    }

    public void setDialogSize(int r100) {
        this.mDialogSize = r100;
    }

    public void setLabel(String r100) {
        this.mLabel = r100;
    }

    public void show(Context r100) {
        if (this.mLoadingDialog != null) goto L6;
        LoadingDialog r101 = init(r100);
        this.mLoadingDialog = r101;
        r101.f445780a.getWindow().setFlags(8, 8);
    L6:
        if (this.mLoadingDialog.b() == false) goto L8;
        return;
    L8:
        if ((r100 instanceof Activity) == true) goto L10;
    L11:
        this.mLoadingDialog.d();
        return;
    L10:
        if (((Activity) r100).isFinishing() == false) goto L11;
    }
}
