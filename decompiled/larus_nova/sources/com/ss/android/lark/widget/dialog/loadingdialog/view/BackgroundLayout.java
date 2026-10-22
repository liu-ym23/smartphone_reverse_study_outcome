package com.ss.android.lark.widget.dialog.loadingdialog.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import j08.b;

/* JADX INFO: loaded from: classes38.dex */
public class BackgroundLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f445813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f445814b;

    public final void a() {
        b(b.b(getContext().getResources().getColor(R.color.lkui_N900), 0.7f), this.f445813a);
    }

    public BackgroundLayout(Context r100) {
        super(r100);
        a();
    }

    public void setBaseColor(int r100) {
        this.f445814b = r100;
        b(r100, this.f445813a);
    }

    public void setCornerRadius(float r100) {
        float r101 = UIUtils.dp2px(getContext(), r100);
        this.f445813a = r101;
        b(this.f445814b, r101);
    }

    public BackgroundLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public final void b(int r100, float r101) {
        GradientDrawable r102 = new GradientDrawable();
        r102.setShape(0);
        r102.setColor(r100);
        r102.setCornerRadius(r101);
        setBackground(r102);
    }

    public BackgroundLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
