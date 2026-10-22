package com.larksuite.component.ui.imageview;

import android.graphics.Paint;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f284187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f284188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f284189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f284190d;

    public final float a() {
        float r100 = this.f284189c;
        float r101 = 0.0f;
        if (r100 < 0.0f) goto L5;
        return r100;
    L5:
        CharSequence r102 = this.f284188b;
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L15;
        r101 = this.f284187a.measureText(r102, 0, r102.length());
    L15:
        this.f284189c = r101;
        return r101;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    }

    public b() {
        TextPaint r100 = new TextPaint(1);
        this.f284187a = r100;
        this.f284189c = -1.0f;
        this.f284190d = -1.0f;
        r100.setTextAlign(Paint.Align.CENTER);
    }
}
