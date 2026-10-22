package com.ss.android.bytedcert.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.Window;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public class CommonDialog extends SSDialog {
    private OnDialogClickListener listener;
    private TextView mTvCancel;
    private TextView mTvConfirm;
    private TextView mTvMessage;
    private TextView mTvTitle;

    public interface OnDialogClickListener {
        void onCancel(DialogInterface r100);

        void onConfirm(DialogInterface r100);
    }

    private void initView() {
        setContentView(R.layout.byted_common_dialog);
        this.mTvMessage = (TextView) findViewById(R.id.tv_message);
        this.mTvCancel = (TextView) findViewById(R.id.tv_cancel);
        this.mTvConfirm = (TextView) findViewById(R.id.tv_confirm);
        this.mTvTitle = (TextView) findViewById(R.id.tv_title);
        this.mTvCancel.setOnClickListener(new AnonymousClass1(this));
        this.mTvConfirm.setOnClickListener(new AnonymousClass2(this));
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void initWindow() {
        Window r100 = getWindow();
        if (r100 == null) goto L6;
        r100.setLayout(-2, -2);
        r100.setGravity(17);
        r100.setWindowAnimations(R.style.byted_btn_fade);
        return;
    }

    public CommonDialog(Activity r100) {
        this(r100, true);
    }

    public static /* synthetic */ OnDialogClickListener access$000(CommonDialog r100) {
        return r100.listener;
    }

    public CommonDialog setCancelText(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.mTvCancel.setVisibility(8);
    L6:
        return this;
    L5:
        this.mTvCancel.setVisibility(0);
        this.mTvCancel.setText(r100);
        goto L6
    }

    public CommonDialog setConfirmText(String r100) {
        this.mTvConfirm.setText(r100);
        return this;
    }

    public CommonDialog setConfirmTypeFace(Typeface r100) {
        this.mTvConfirm.setTypeface(r100);
        return this;
    }

    public CommonDialog setListener(OnDialogClickListener r100) {
        this.listener = r100;
        return this;
    }

    public CommonDialog setMessage(String r100) {
        this.mTvMessage.setText(r100);
        return this;
    }

    public CommonDialog setTitle(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.mTvTitle.setVisibility(8);
    L6:
        return this;
    L5:
        this.mTvTitle.setVisibility(0);
        this.mTvTitle.setText(r100);
        goto L6
    }

    public CommonDialog(Activity r100, boolean r101) {
        super(r100, R.style.byted_common_dialog_style);
        initView();
        initWindow();
        setCancelable(r101);
    }
}
