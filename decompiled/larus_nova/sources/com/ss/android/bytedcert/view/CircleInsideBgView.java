package com.ss.android.bytedcert.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import rsa.i;

/* JADX INFO: loaded from: classes34.dex */
public class CircleInsideBgView extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f407712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f407713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f407714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f407715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f407716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f407717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f407718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f407719h;

    public CircleInsideBgView(Context r100) {
        this(r100, null, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        getDrawingRect(this.f407714c);
        this.f407712a = this.f407714c.centerX();
        this.f407713b = this.f407714c.centerY();
        int r101 = r100.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        float r102 = i.d(getContext());
        r100.drawCircle(this.f407712a, this.f407713b, r102, this.f407717f);
        Rect r103 = this.f407715d;
        Rect r104 = this.f407714c;
        r103.left = r104.left;
        r103.right = r104.right;
        int r105 = (int) (this.f407713b - r102);
        r103.top = r105;
        r103.bottom = (int) (r105 + i.b(getContext(), 40.0f));
        r100.drawRect(this.f407715d, this.f407718g);
        Rect r106 = this.f407716e;
        Rect r107 = this.f407714c;
        r106.left = r107.left;
        r106.right = r107.right;
        r106.top = this.f407715d.bottom;
        r106.bottom = (int) (this.f407713b + r102);
        r100.drawRect(r106, this.f407719h);
        r100.restoreToCount(r101);
    }

    public CircleInsideBgView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        if (r102 <= r103) goto L5;
        r103 = r102;
    L7:
        setMeasuredDimension(r102, r103);
        return;
    L5:
        if (r102 >= r103) goto L7;
        r102 = r103;
        goto L7
    }

    public CircleInsideBgView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f407715d = new Rect();
        this.f407716e = new Rect();
        Paint r103 = new Paint();
        this.f407717f = r103;
        Paint r104 = new Paint();
        this.f407718g = r104;
        Paint r105 = new Paint();
        this.f407719h = r105;
        this.f407714c = new Rect();
        r103.setAntiAlias(true);
        r103.setColor(FakePickerAvatarCreator.GREEN);
        r105.setAntiAlias(true);
        r105.setColor(-65536);
        r105.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        r104.setAntiAlias(true);
        r104.setColor(getResources().getColor(R.color.byted_transparent_gray));
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        setElevation(i.b(getContext(), 8.0f));
    }
}
