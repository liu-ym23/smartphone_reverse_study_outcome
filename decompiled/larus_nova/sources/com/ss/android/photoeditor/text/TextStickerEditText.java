package com.ss.android.photoeditor.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.suite.lark.emm.design.edittext.SCAppCompatEditText;

/* JADX INFO: loaded from: classes38.dex */
public class TextStickerEditText extends SCAppCompatEditText {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f449519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f449520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Path f449521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f449522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f449523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f449524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f449525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f449526i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f449527j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f449528k;

    private String[] getTextStr() {
        if (TextUtils.isEmpty(getText()) == false) goto L6;
        return null;
    L6:
        Layout r100 = getLayout();
        String r101 = getText().toString();
        String[] r102 = new String[getLineCount()];
        int r103 = 0;
        int r104 = 0;
    L8:
        if (r103 >= getLineCount()) goto L10;
        int r105 = r100.getLineEnd(r103);
        r102[r103] = r101.substring(r104, r105);
        r100.getLineBounds(r103, new Rect());
        r103 = r103 + 1;
        r104 = r105;
        goto L8
    L10:
        return r102;
    }

    public TextStickerEditText(Context r100) {
        this(r100, null);
    }

    private void setAligin(int r100) {
        this.f449524g = r100;
        if (r100 != 1) goto L6;
        setGravity(3);
        return;
    L6:
        if (r100 != 2) goto L8;
        setGravity(17);
        return;
    L8:
        if (r100 != 3) goto L13;
        setGravity(5);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r210) {
        int r100 = 1;
        if (getLineCount() <= 1) goto L5;
        setAligin(1);
    L7:
        if (this.f449523f == 1) goto L94;
        if (TextUtils.isEmpty(getText().toString()) == true) goto L94;
        this.f449520c.setColor(this.f449522e);
        String[] r101 = getTextStr();
        if (r101 == null) goto L94;
        if (r101.length == 0) goto L94;
        int r102 = r101.length;
        Point[][] r103 = new Point[r102][];
        int r104 = ((int) getTextSize()) / 4;
        if (this.f449524g != 1) goto L19;
        this.f449525h = getPaddingLeft();
    L19:
        if (this.f449524g != 3) goto L22;
        this.f449525h = getMeasuredWidth() - getPaddingRight();
    L22:
        if (this.f449524g != 2) goto L24;
        this.f449525h = getMeasuredWidth() / 2;
    L24:
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
    L25:
        if (r110 >= r102) goto L73;
        Layout r105 = getLayout();
        this.f449527j = r105.getLineDescent(r110) - r105.getLineAscent(r110);
        int r106 = (int) getPaint().measureText(r101[r110]);
        int r107 = this.f449525h;
        int r116 = r106 / 2;
        int r108 = this.f449519b * 2;
        int r117 = (r107 - r116) - r108;
        int r118 = (r107 + r116) + r108;
        int r109 = this.f449524g;
        if (r109 != r100) goto L30;
        r117 = r107 - r108;
        r118 = (r107 + r106) + r108;
    L30:
        if (r109 != 3) goto L33;
        r117 = (r107 - r106) - r108;
        r118 = r107 + r108;
    L33:
        if (TextUtils.isEmpty(r101[r110]) == false) goto L35;
    L36:
        int r119 = getMeasuredWidth() / 2;
        int r120 = this.f449524g;
        if (r120 != 1) goto L40;
        r119 = this.f449519b;
    L40:
        if (r120 != 3) goto L42;
        r119 = getMeasuredWidth() - this.f449519b;
    L42:
        r118 = r119;
        r117 = r118;
    L44:
        if (Math.abs(r106 - r111) >= r104) goto L57;
        int r121 = this.f449524g;
        if (r121 != 1) goto L50;
        if (r112 <= 0) goto L57;
    L58:
        if (r110 == 0) goto L60;
    L62:
        if (r110 != 0) goto L65;
        int r122 = this.f449526i;
        int r123 = this.f449519b;
        r114 = r122 - r123;
        int r124 = (r123 + r114) + this.f449527j;
    L69:
        r103[r110] = new Point[]{new Point(r113, r114), new Point(r112, r114), new Point(r112, r124), new Point(r113, r124)};
        if (r106 <= r115) goto L72;
        r115 = r106;
    L72:
        r110 = r110 + 1;
        r114 = r124;
        r111 = r106;
        r100 = 1;
        goto L25
    L65:
        if (r110 != (r102 - 1)) goto L68;
        int r125 = this.f449527j + r114;
        int r126 = this.f449519b;
    L67:
        r124 = r125 + r126;
        goto L69
    L68:
        r124 = this.f449527j + r114;
        goto L69
    L60:
        if (r102 != 1) goto L62;
        int r127 = this.f449526i;
        r126 = this.f449519b;
        r114 = r127 - r126;
        r125 = (r126 + r114) + this.f449527j;
        goto L67
    L50:
        if (r121 != 3) goto L54;
        if (r113 <= 0) goto L57;
    L54:
        if (r121 != 2) goto L57;
        if (r113 > 0) goto L58;
    L57:
        r112 = r118;
        r113 = r117;
        goto L58
    L35:
        if (r101[r110].trim().length() != 0) goto L44;
    L73:
        this.f449521d.reset();
        int r128 = 0;
    L74:
        if (r128 >= r102) goto L82;
        if (r128 != 0) goto L77;
        Path r129 = this.f449521d;
        Point r130 = r103[r128][0];
        r129.moveTo(r130.x, r130.y);
    L77:
        Path r131 = this.f449521d;
        Point r132 = r103[r128][1];
        r131.lineTo(r132.x, r132.y);
        Point[] r133 = r103[r128];
        int r134 = r133[0].x;
        Point r135 = r133[1];
        int r136 = r135.x;
        if (r134 != r136) goto L80;
        this.f449521d.lineTo(r136, r135.y);
        Path r137 = this.f449521d;
        char r138 = 2;
        Point r139 = r103[r128][2];
        r137.lineTo(r139.x, r139.y);
    L81:
        Path r140 = this.f449521d;
        Point r141 = r103[r128][r138];
        r140.lineTo(r141.x, r141.y);
        r128 = r128 + 1;
        goto L74
    L80:
        r138 = 2;
        goto L81
    L82:
        char r142 = 1;
        int r143 = r102 - 1;
    L83:
        if (r143 < 0) goto L92;
        Point[] r144 = r103[r143];
        if (r144[0].x != r144[r142].x) goto L87;
        Path r145 = this.f449521d;
        char r146 = 3;
        Point r147 = r144[3];
        r145.lineTo(r147.x, r147.y);
    L88:
        Path r148 = this.f449521d;
        Point r149 = r103[r143][r146];
        r148.lineTo(r149.x, r149.y);
        Point[] r150 = r103[r143];
        Point r151 = r150[0];
        int r152 = r151.x;
        if (r152 != r150[1].x) goto L91;
        this.f449521d.lineTo(r152, r151.y);
    L91:
        Path r153 = this.f449521d;
        Point r154 = r103[r143][0];
        r153.lineTo(r154.x, r154.y);
        r143 = r143 - 1;
        r142 = 1;
        goto L83
    L87:
        r146 = 3;
        goto L88
    L92:
        Path r155 = this.f449521d;
        Point r156 = r103[0][1];
        r155.lineTo(r156.x, r156.y);
        r210.drawPath(this.f449521d, this.f449520c);
    L94:
        super.onDraw(r210);
        return;
    L5:
        setAligin(2);
        goto L7
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int r100) {
        if (r100 <= 0) goto L5;
        super.setMaxWidth(r100);
        return;
    }

    public TextStickerEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f449519b = 0;
        this.f449522e = -1;
        this.f449523f = 1;
        this.f449524g = 2;
        Resources r102 = r100.getResources();
        this.f449519b = (int) ((6.0f * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
        Resources r103 = r100.getResources();
        this.f449528k = (int) ((8.0f * WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density) + 0.5f);
        Paint r104 = new Paint();
        this.f449520c = r104;
        r104.setColor(-1);
        this.f449520c.setStyle(Paint.Style.FILL);
        this.f449520c.setAntiAlias(true);
        this.f449520c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.f449520c.setPathEffect(new CornerPathEffect(this.f449528k));
        this.f449521d = new Path();
        setLayerType(1, null);
        setLineSpacing(this.f449519b, getLineSpacingMultiplier());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f449525h = getMeasuredWidth() / 2;
        this.f449526i = getPaddingTop();
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        float r104 = getLineSpacingExtra();
        float r105 = getLineSpacingMultiplier();
        setLineSpacing(0.0f, 1.0f);
        setLineSpacing(r104, r105);
    }
}
