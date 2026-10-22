package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes36.dex */
public class AudioWaveView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f460799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f460800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f460801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f460802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f460803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f460804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f460805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f460806h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f460807i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f460808j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f460809k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f460810l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f460811m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f460812n;

    public int getProgress() {
        return this.f460811m;
    }

    public byte[] getWaveformBytes() {
        return this.f460810l;
    }

    public AudioWaveView(Context r100) {
        super(r100);
        this.f460799a = new Paint(1);
        this.f460800b = new Paint(1);
        this.f460801c = Color.rgb(255, 255, 255);
        this.f460802d = Color.argb(51, 255, 255, 255);
        this.f460803e = UIHelper.dp2px(2.0f);
        float r101 = UIHelper.dp2px(5.0f);
        this.f460804f = r101;
        this.f460805g = (UIHelper.dp2px(22.0f) - r101) / 2.0f;
        this.f460806h = UIHelper.dp2px(2.0f);
        this.f460807i = UIHelper.dp2px(4.0f);
        this.f460812n = 100;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        byte[] r100 = this.f460810l;
        if (r100 == null) goto L35;
        int r101 = this.f460808j;
        if (r101 == 0) goto L44;
        float r102 = r101 / (this.f460803e + this.f460807i);
        if (r102 > 0.1f) goto L10;
        return;
    L10:
        int r103 = 5;
        int r104 = (r100.length * 8) / 5;
        float r105 = r104 / r102;
        this.f460799a.setColor(this.f460802d);
        this.f460800b.setColor(this.f460801c);
        int r106 = 2;
        int r107 = this.f460809k / 2;
        float r108 = 0.0f;
        int r109 = 0;
        int r110 = 0;
        int r111 = 0;
    L11:
        if (r109 >= r104) goto L45;
        if (r109 == r110) goto L14;
        int r211 = r104;
    L34:
        r109 = r109 + 1;
        r104 = r211;
        r103 = 5;
        r106 = 2;
        goto L11
    L14:
        int r112 = r110;
        int r113 = 0;
    L15:
        if (r110 != r112) goto L17;
        r108 = r108 + r105;
        r112 = (int) r108;
        r113 = r113 + 1;
        goto L15
    L17:
        int r114 = r109 * 5;
        int r115 = r114 / 8;
        int r116 = r114 - (r115 * 8);
        int r117 = 8 - r116;
        int r118 = 5 - r117;
        byte r119 = (byte) ((this.f460810l[r115] >> r116) & ((r106 << (Math.min(r103, r117) - 1)) - 1));
        if (r118 <= 0) goto L22;
        int r120 = r115 + 1;
        byte[] r121 = this.f460810l;
        if (r120 >= r121.length) goto L22;
        r119 = (byte) (((byte) (r119 << r118)) | (r121[r120] & ((r106 << (r118 - 1)) - 1)));
    L22:
        float r122 = this.f460808j * ((this.f460811m * 1.0f) / this.f460812n);
        int r123 = 0;
    L23:
        if (r123 >= r113) goto L33;
        float r124 = this.f460803e;
        float r125 = (int) (r111 * (this.f460807i + r124));
        if (r125 <= r122) goto L27;
    L29:
        int r212 = r104;
        float r126 = r107;
        float r127 = r119;
        float r128 = r126 - Math.max(this.f460804f / 2.0f, (this.f460805g * r127) / 31.0f);
        float r129 = r125 + this.f460803e;
        float r213 = r126 + Math.max(this.f460804f / 2.0f, (this.f460805g * r127) / 31.0f);
        float r130 = this.f460806h;
        r210.drawRoundRect(r125, r128, r129, r213, r130, r130, this.f460799a);
        if (r125 > r122) goto L32;
        float r131 = r126 - Math.max(this.f460804f / 2.0f, (this.f460805g * r127) / 31.0f);
        float r214 = r126 + Math.max(this.f460804f / 2.0f, (this.f460805g * r127) / 31.0f);
        float r132 = this.f460806h;
        r210.drawRoundRect(r125, r131, r122, r214, r132, r132, this.f460800b);
    L32:
        r111 = r111 + 1;
        r123 = r123 + 1;
        r104 = r212;
        goto L23
    L27:
        if ((r124 + r125) > r122) goto L29;
        float r133 = r107;
        r212 = r104;
        float r134 = r119;
        float r135 = r133 - Math.max(this.f460804f / 2.0f, (this.f460805g * r134) / 31.0f);
        float r136 = r125 + this.f460803e;
        float r215 = r133 + Math.max(this.f460804f / 2.0f, (this.f460805g * r134) / 31.0f);
        float r137 = this.f460806h;
        r210.drawRoundRect(r125, r135, r136, r215, r137, r137, this.f460800b);
        goto L32
    L33:
        r211 = r104;
        r110 = r112;
        goto L34
    L45:
        return;
    L44:
        return;
    }

    public void setProgress(int r100) {
        this.f460811m = r100;
        invalidate();
    }

    public void setWaveformBytes(byte[] r100) {
        if (r100 != null) goto L4;
    L7:
        this.f460810l = new byte[64];
    L8:
        invalidate();
        return;
    L4:
        if (r100.length == 0) goto L7;
        this.f460810l = r100;
        goto L8
    }

    public AudioWaveView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f460799a = new Paint(1);
        this.f460800b = new Paint(1);
        this.f460801c = Color.rgb(255, 255, 255);
        this.f460802d = Color.argb(51, 255, 255, 255);
        this.f460803e = UIHelper.dp2px(2.0f);
        float r102 = UIHelper.dp2px(5.0f);
        this.f460804f = r102;
        this.f460805g = (UIHelper.dp2px(22.0f) - r102) / 2.0f;
        this.f460806h = UIHelper.dp2px(2.0f);
        this.f460807i = UIHelper.dp2px(4.0f);
        this.f460812n = 100;
    }

    public AudioWaveView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f460799a = new Paint(1);
        this.f460800b = new Paint(1);
        this.f460801c = Color.rgb(255, 255, 255);
        this.f460802d = Color.argb(51, 255, 255, 255);
        this.f460803e = UIHelper.dp2px(2.0f);
        float r103 = UIHelper.dp2px(5.0f);
        this.f460804f = r103;
        this.f460805g = (UIHelper.dp2px(22.0f) - r103) / 2.0f;
        this.f460806h = UIHelper.dp2px(2.0f);
        this.f460807i = UIHelper.dp2px(4.0f);
        this.f460812n = 100;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f460808j = r100;
        this.f460809k = r101;
    }
}
