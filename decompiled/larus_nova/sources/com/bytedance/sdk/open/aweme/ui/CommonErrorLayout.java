package com.bytedance.sdk.open.aweme.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes22.dex */
public class CommonErrorLayout extends FrameLayout {
    private TextView errTipsTV;
    private TextView retryTV;

    public CommonErrorLayout(Context r100) {
        this(r100, null, 0);
    }

    public CommonErrorLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CommonErrorLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init();
    }

    private void init() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.layout_aweme_open_common_error, this, true);
        this.errTipsTV = (TextView) r100.findViewById(R.id.error_tips);
        this.retryTV = (TextView) r100.findViewById(R.id.error_retry_click);
    }

    public void setErrTip(String r100) {
        this.errTipsTV.setText(r100);
    }

    public void setErrTipsTextColor(int r100) {
        this.errTipsTV.setTextColor(r100);
    }

    public void setRetryClick(View.OnClickListener r100) {
        this.retryTV.setOnClickListener(r100);
    }

    public void setRetryText(String r100) {
        this.retryTV.setText(r100);
    }

    public void setRetryVisible(int r100) {
        this.retryTV.setVisibility(r100);
    }
}
