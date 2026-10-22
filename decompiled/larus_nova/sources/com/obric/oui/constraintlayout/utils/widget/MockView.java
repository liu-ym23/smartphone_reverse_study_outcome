package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes34.dex */
public class MockView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f400310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f400311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f400312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f400313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f400314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f400315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f400316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f400317h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f400318i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f400319j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f400320k;

    public MockView(Context r100) {
        super(r100);
        this.f400310a = new Paint();
        this.f400311b = new Paint();
        this.f400312c = new Paint();
        this.f400313d = true;
        this.f400314e = true;
        this.f400315f = null;
        this.f400316g = new Rect();
        this.f400317h = Color.argb(255, 0, 0, 0);
        this.f400318i = Color.argb(255, 200, 200, 200);
        this.f400319j = Color.argb(255, 50, 50, 50);
        this.f400320k = 4;
        a(r100, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas r110) {
        super.onDraw(r110);
        int r100 = getWidth();
        int r101 = getHeight();
        if (this.f400313d == false) goto L5;
        r100 = r100 - 1;
        r101 = r101 - 1;
        float r111 = r100;
        float r112 = r101;
        r110.drawLine(0.0f, 0.0f, r111, r112, this.f400310a);
        r110.drawLine(0.0f, r112, r111, 0.0f, this.f400310a);
        r110.drawLine(0.0f, 0.0f, r111, 0.0f, this.f400310a);
        r110.drawLine(r111, 0.0f, r111, r112, this.f400310a);
        r110.drawLine(r111, r112, 0.0f, r112, this.f400310a);
        r110.drawLine(0.0f, r112, 0.0f, 0.0f, this.f400310a);
    L5:
        String r102 = this.f400315f;
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.f400314e == false) goto L12;
        this.f400311b.getTextBounds(r102, 0, r102.length(), this.f400316g);
        float r103 = (r100 - this.f400316g.width()) / 2.0f;
        float r104 = ((r101 - this.f400316g.height()) / 2.0f) + this.f400316g.height();
        this.f400316g.offset((int) r103, (int) r104);
        Rect r105 = this.f400316g;
        int r106 = r105.left;
        int r107 = this.f400320k;
        r105.set(r106 - r107, r105.top - r107, r105.right + r107, r105.bottom + r107);
        r110.drawRect(this.f400316g, this.f400312c);
        r110.drawText(this.f400315f, r103, r104, this.f400311b);
        return;
    }

    public MockView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f400310a = new Paint();
        this.f400311b = new Paint();
        this.f400312c = new Paint();
        this.f400313d = true;
        this.f400314e = true;
        this.f400315f = null;
        this.f400316g = new Rect();
        this.f400317h = Color.argb(255, 0, 0, 0);
        this.f400318i = Color.argb(255, 200, 200, 200);
        this.f400319j = Color.argb(255, 50, 50, 50);
        this.f400320k = 4;
        a(r100, r101);
    }

    public final void a(Context r100, AttributeSet r101) {
        if (r101 == null) goto L26;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.mock_diagonalsColor, R.attr.mock_label, R.attr.mock_labelBackgroundColor, R.attr.mock_labelColor, R.attr.mock_showDiagonals, R.attr.mock_showLabel});
        int r103 = r102.getIndexCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L24;
        int r105 = r102.getIndex(r104);
        if (r105 != 1) goto L10;
        this.f400315f = r102.getString(r105);
    L23:
        r104 = r104 + 1;
        goto L5
    L10:
        if (r105 != 4) goto L12;
        this.f400313d = r102.getBoolean(r105, this.f400313d);
        goto L23
    L12:
        if (r105 != 0) goto L15;
        this.f400317h = r102.getColor(r105, this.f400317h);
        goto L23
    L15:
        if (r105 != 2) goto L18;
        this.f400319j = r102.getColor(r105, this.f400319j);
        goto L23
    L18:
        if (r105 != 3) goto L21;
        this.f400318i = r102.getColor(r105, this.f400318i);
        goto L23
    L21:
        if (r105 != 5) goto L23;
        this.f400314e = r102.getBoolean(r105, this.f400314e);
        goto L23
    L24:
        r102.recycle();
    L26:
        if (this.f400315f == null) goto L31;
    L28:
        this.f400310a.setColor(this.f400317h);
        this.f400310a.setAntiAlias(true);
        this.f400311b.setColor(this.f400318i);
        this.f400311b.setAntiAlias(true);
        this.f400312c.setColor(this.f400319j);
        float r106 = this.f400320k;
        Resources r107 = getResources();
        this.f400320k = Math.round(r106 * (WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).xdpi / 160.0f));
        return;
    L31:
        this.f400315f = r100.getResources().getResourceEntryName(getId());     // Catch: Exception -> L30
        goto L28
    }

    public MockView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f400310a = new Paint();
        this.f400311b = new Paint();
        this.f400312c = new Paint();
        this.f400313d = true;
        this.f400314e = true;
        this.f400315f = null;
        this.f400316g = new Rect();
        this.f400317h = Color.argb(255, 0, 0, 0);
        this.f400318i = Color.argb(255, 200, 200, 200);
        this.f400319j = Color.argb(255, 50, 50, 50);
        this.f400320k = 4;
        a(r100, r101);
    }
}
