package com.ss.android.cert.manager.permission.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public class PermissionItemView extends LinearLayout {
    TextView tvDesc;
    TextView tvUsage;

    public PermissionItemView(Context r100) {
        this(r100, null);
    }

    private void initView(Context r100) {
        View r101 = LayoutInflater.from(r100).inflate(R.layout.item_permission, this);
        this.tvDesc = (TextView) r101.findViewById(R.id.tv_desc);
        this.tvUsage = (TextView) r101.findViewById(R.id.tv_usage);
    }

    public PermissionItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public void setContent(String r100, String r101) {
        this.tvDesc.setText(r100);
        this.tvUsage.setText(r101);
    }

    public PermissionItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        initView(r100);
    }
}
