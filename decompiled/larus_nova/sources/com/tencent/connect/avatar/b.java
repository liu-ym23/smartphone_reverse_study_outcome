package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes40.dex */
public class b extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Rect f461528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f461529b;

    private void b() {
        this.f461529b = new Paint();
    }

    public Rect a() {
        if (this.f461528a != null) goto L6;
        this.f461528a = new Rect();
        int r100 = getMeasuredWidth();
        int r101 = getMeasuredHeight();
        int r102 = Math.min(Math.min((r101 - 60) - 80, r100), 640);
        int r103 = (r100 - r102) / 2;
        int r104 = (r101 - r102) / 2;
        this.f461528a.set(r103, r104, r103 + r102, r102 + r104);
    L6:
        return this.f461528a;
    }

    public b(Context r100) {
        super(r100);
        b();
    }

    @Override // android.view.View
    public void onDraw(Canvas r210) {
        super.onDraw(r210);
        Rect r100 = a();
        int r101 = getMeasuredWidth();
        int r102 = getMeasuredHeight();
        this.f461529b.setStyle(Paint.Style.FILL);
        this.f461529b.setColor(Color.argb(100, 0, 0, 0));
        float r103 = r101;
        r210.drawRect(0.0f, 0.0f, r103, r100.top, this.f461529b);
        r210.drawRect(0.0f, r100.bottom, r103, r102, this.f461529b);
        r210.drawRect(0.0f, r100.top, r100.left, r100.bottom, this.f461529b);
        r210.drawRect(r100.right, r100.top, r103, r100.bottom, this.f461529b);
        r210.drawColor(Color.argb(100, 0, 0, 0));
        this.f461529b.setStyle(Paint.Style.STROKE);
        this.f461529b.setColor(-1);
        r210.drawRect(r100.left, r100.top, r100.right - 1, r100.bottom, this.f461529b);
    }
}
