package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class SettingDividerView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f461058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f461059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f461060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f461061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f461062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f461063f;

    public SettingDividerView(Context r100) {
        super(r100);
        a(null);
    }

    public final void a(AttributeSet r100) {
        if (r100 != null) goto L5;
        this.f461058a = getResources().getColor(R.color.bg_body);
        this.f461059b = getResources().getColor(R.color.line_divider_default);
        this.f461060c = 0.0f;
        this.f461061d = 0.0f;
    L6:
        Paint r101 = new Paint();
        this.f461062e = r101;
        r101.setColor(this.f461058a);
        this.f461062e.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r102 = new Paint();
        this.f461063f = r102;
        r102.setColor(this.f461059b);
        this.f461063f.setStyle(Paint.Style.FILL_AND_STROKE);
        return;
    L5:
        TypedArray r103 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.blank_color, R.attr.left_blank_width, R.attr.right_blank_width, R.attr.solid_color});
        this.f461058a = r103.getColor(0, getResources().getColor(R.color.bg_body));
        this.f461059b = r103.getColor(3, getResources().getColor(R.color.line_divider_default));
        this.f461060c = r103.getDimension(1, 0.0f);
        this.f461061d = r103.getDimension(2, 0.0f);
        r103.recycle();
        goto L6
    }

    @Override // android.view.View
    public final void draw(Canvas r110) {
        float r100 = this.f461060c;
        if (r100 <= 0.0f) goto L6;
        r110.drawRect(0.0f, 0.0f, r100, getHeight(), this.f461062e);
    L6:
        if (this.f461061d <= 0.0f) goto L8;
        r110.drawRect(getWidth() - this.f461061d, 0.0f, getWidth(), getHeight(), this.f461062e);
    L8:
        r110.drawRect(this.f461060c, 0.0f, getWidth() - this.f461061d, getHeight(), this.f461063f);
    }

    public void setBlankColor(int r100) {
        this.f461058a = r100;
        this.f461062e.setColor(r100);
        invalidate();
    }

    public void setLeftBlankWidth(float r100) {
        this.f461060c = r100;
        invalidate();
    }

    public void setRightBlankWidth(float r100) {
        this.f461061d = r100;
        invalidate();
    }

    public void setSolidColor(int r100) {
        this.f461059b = r100;
        this.f461063f.setColor(r100);
        invalidate();
    }

    public SettingDividerView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r101);
    }

    public SettingDividerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r101);
    }
}
