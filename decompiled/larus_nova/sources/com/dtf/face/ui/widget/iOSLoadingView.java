package com.dtf.face.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: classes22.dex */
public class iOSLoadingView extends View {
    private static final String TAG = null;
    private String[] color;
    private int heigheRect;
    private int height;
    private int pos;
    private Rect rect;
    private Paint rectPaint;
    private int width;
    private int widthRect;

    static {
        TAG = "iOSLoadingView";
    }

    private void init() {
        this.rectPaint = new Paint(1);
    }

    public iOSLoadingView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.rect != null) goto L5;
        int r101 = this.width;
        int r102 = this.widthRect;
        this.rect = new Rect((r101 - r102) / 2, 0, (r101 + r102) / 2, this.heigheRect);
    L5:
        int r103 = 0;
    L7:
        if (r103 >= 12) goto L23;
        int r104 = this.pos;
        int r105 = r103 - r104;
        if (r105 < 5) goto L11;
        this.rectPaint.setColor(ColorProtector.parseColor(this.color[5]));
    L22:
        r100.drawRect(this.rect, this.rectPaint);
        float r106 = this.width / 2;
        r100.rotate(30.0f, r106, r106);
        r103 = r103 + 1;
        goto L7
    L11:
        if (r105 < 0) goto L15;
        if (r105 >= 5) goto L15;
        this.rectPaint.setColor(ColorProtector.parseColor(this.color[r105]));
    L15:
        if (r105 < (-7)) goto L19;
        if (r105 >= 0) goto L19;
        this.rectPaint.setColor(ColorProtector.parseColor(this.color[5]));
    L19:
        if (r105 < (-11)) goto L22;
        if (r105 >= (-7)) goto L22;
        this.rectPaint.setColor(ColorProtector.parseColor(this.color[(r103 + 12) - r104]));
        goto L22
    L23:
        int r107 = this.pos + 1;
        this.pos = r107;
        if (r107 <= 11) goto L26;
        this.pos = 0;
    L26:
        postInvalidateDelayed(100);
    }

    public iOSLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getMode(r101);
        if (r102 == Integer.MIN_VALUE) goto L7;
        if (r103 == Integer.MIN_VALUE) goto L7;
        this.width = View.MeasureSpec.getSize(r100);
        int r104 = View.MeasureSpec.getSize(r101);
        this.height = r104;
        this.width = Math.min(this.width, r104);
    L8:
        int r105 = this.width;
        int r106 = r105 / 12;
        this.widthRect = r106;
        this.heigheRect = r106 * 4;
        setMeasuredDimension(r105, r105);
        return;
    L7:
        this.width = 200;
        goto L8
    }

    public iOSLoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.pos = 0;
        this.color = new String[]{"#bbbbbb", "#aaaaaa", "#999999", "#888888", "#777777", "#666666"};
        init();
    }
}
