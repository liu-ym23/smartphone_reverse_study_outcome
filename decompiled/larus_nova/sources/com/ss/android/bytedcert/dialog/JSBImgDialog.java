package com.ss.android.bytedcert.dialog;

import android.app.Activity;
import android.view.Window;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public class JSBImgDialog extends SSDialog {
    private TextView mTextView;

    private void initView() {
        setContentView(R.layout.byted_jsb_img_dialog);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        TextView r100 = (TextView) findViewById(R.id.i_know);
        this.mTextView = r100;
        if (r100 == null) goto L6;
        r100.setOnClickListener(new AnonymousClass1(this));
        return;
    }

    public void initWindow() {
        Window r100 = getWindow();
        if (r100 == null) goto L6;
        r100.setLayout(-2, -2);
        r100.setGravity(17);
        r100.setWindowAnimations(R.style.byted_btn_fade);
        return;
    }

    public JSBImgDialog(Activity r100) {
        super(r100, R.style.byted_common_dialog_style);
        initView();
        initWindow();
    }
}
