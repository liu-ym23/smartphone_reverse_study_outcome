package com.ss.android.lark.cameraview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.camera_export.CameraFG;

/* JADX INFO: loaded from: classes34.dex */
public class FocusView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f410823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f410824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f410825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f410826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f410827e;

    public FocusView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        int r100 = this.f410824b;
        int r101 = this.f410826d;
        int r102 = this.f410825c;
        r110.drawRect(r100 - r101, r102 - r101, r100 + r101, r102 + r101, this.f410827e);
        r110.drawLine(2.0f, getHeight() / 2, this.f410823a / 10, getHeight() / 2, this.f410827e);
        r110.drawLine(getWidth() - 2, getHeight() / 2, getWidth() - (this.f410823a / 10), getHeight() / 2, this.f410827e);
        r110.drawLine(getWidth() / 2, 2.0f, getWidth() / 2, this.f410823a / 10, this.f410827e);
        r110.drawLine(getWidth() / 2, getHeight() - 2, getWidth() / 2, getHeight() - (this.f410823a / 10), this.f410827e);
    }

    public FocusView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = this.f410823a;
        this.f410824b = (int) (((double) r102) / 2.0d);
        this.f410825c = (int) (((double) r102) / 2.0d);
        this.f410826d = ((int) (((double) r102) / 2.0d)) - 2;
        setMeasuredDimension(r102, r102);
    }

    public FocusView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        if (CameraFG.getEnableBigScreenCompat() == false) goto L5;
        this.f410823a = UIUtils.dp2px(r100, 100.0f);
    L6:
        Paint r103 = new Paint();
        this.f410827e = r103;
        r103.setAntiAlias(true);
        r103.setDither(true);
        r103.setColor(-300503530);
        r103.setStrokeWidth(4.0f);
        r103.setStyle(Paint.Style.STROKE);
        return;
    L5:
        this.f410823a = DeviceUtils.getScreenWidth(r100) / 3;
        goto L6
    }
}
