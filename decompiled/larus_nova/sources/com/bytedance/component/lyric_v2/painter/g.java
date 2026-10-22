package com.bytedance.component.lyric_v2.painter;

import android.graphics.Paint;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes15.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f203087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f203088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f203089c;

    public g() {
        Paint r100 = new Paint(1);
        r100.setStyle(Paint.Style.FILL_AND_STROKE);
        Unit r101 = Unit.INSTANCE;
        this.f203087a = r100;
        Paint r102 = new Paint(1);
        r102.setStyle(Paint.Style.FILL);
        this.f203088b = r102;
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f203089c = r103;
    }

    public static void a(Paint r100, pg4.c r101, Paint.Align r102, boolean r103) {
        if (r103 == false) goto L4;
        int r104 = ColorProtector.parseColor(r101.f529185q);
    L5:
        float r105 = 0.0f;
        if (r100.getColor() == r104) goto L8;
    L22:
        r100.setColor(r104);
        r100.setTextSize(r101.f529181m);
        r100.setFakeBoldText(r101.f529182n);
        r100.setLetterSpacing(r101.f529183o);
        if (r101.B == false) goto L26;
        if (r103 == true) goto L26;
        r105 = r101.f529184p;
    L26:
        r100.setStrokeWidth(r105);
        r100.setTextAlign(r102);
        if (r103 == false) goto L34;
        pg4.b r106 = r101.f529186r;
        if ((r106 instanceof pg4.a) == true) goto L31;
        r106 = null;
    L31:
        pg4.a r107 = (pg4.a) r106;
        r100.setShader(null);
        return;
    L34:
        return;
    L8:
        if (r100.getTextSize() != r101.f529181m) goto L22;
        if (r100.isFakeBoldText() != r101.f529182n) goto L22;
        if (r100.getLetterSpacing() != r101.f529183o) goto L22;
        float r108 = r100.getStrokeWidth();
        if (r101.B == false) goto L17;
        if (r103 == true) goto L17;
        float r109 = r101.f529184p;
    L19:
        if (r108 != r109) goto L22;
        if (r100.getTextAlign() != r102) goto L22;
        return;
    L17:
        r109 = 0.0f;
        goto L19
    L4:
        r104 = ColorProtector.parseColor(r101.f529180l);
        goto L5
    }
}
