package com.ss.android.lark.myai.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import zz7.b;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/myai/view/MyAIShareActionView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textPaint", "Landroid/text/TextPaint;", "shareText", "", BdpAwemeConstant.KEY_SHARE_ICON, "Landroid/graphics/drawable/Drawable;", "shareIconSize", "iconTextSpace", "expectedHeight", "horizontalPadding", "shareIconTop", "shareIconBottom", "showTextIconLeft", "showTextIconRight", "hideTextIconLeft", "hideTextIconRight", "showText", "", "textX", "", "textY", "expectedWidth", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "myai-export-officesdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyAIShareActionView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f432915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f432916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f432917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f432918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f432919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f432920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f432921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f432922h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f432923i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f432924j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f432925k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f432926l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f432927m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f432928n;

    public MyAIShareActionView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MyAIShareActionView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f432917c.draw(r100);
        if (this.f432925k == false) goto L6;
        r100.drawText(this.f432916b, this.f432926l, this.f432927m, this.f432915a);
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        if (View.MeasureSpec.getMode(r100) != 0) goto L5;
        this.f432925k = true;
        int r102 = this.f432928n;
    L10:
        if (this.f432925k == false) goto L12;
        this.f432917c.setBounds(this.f432921g, this.f432919e, this.f432922h, this.f432920f);
    L13:
        setMeasuredDimension(r102, this.f432918d);
        return;
    L12:
        this.f432917c.setBounds(this.f432923i, this.f432919e, this.f432924j, this.f432920f);
        goto L13
    L5:
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = this.f432928n;
        if (r103 < r104) goto L8;
        this.f432925k = true;
        r102 = r104;
        goto L10
    L8:
        this.f432925k = false;
        r102 = this.f432918d;
        goto L10
    }

    public MyAIShareActionView(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        TextPaint r112 = new TextPaint(1);
        this.f432915a = r112;
        String r101 = r100.getString(R.string.MyAI_IM_ShareReply_Button);
        this.f432916b = r101;
        this.f432917c = UDIconUtils.getIconDrawable(r100, R.drawable.ud_icon_forward_outlined, UDColorUtils.getColor(r100, R.color.icon_n2));
        int r102 = b.g(r100, 18);
        int r103 = b.g(r100, 2);
        int r104 = b.g(r100, 24);
        this.f432918d = r104;
        int r105 = b.g(r100, 4);
        int r106 = (r104 - r102) / 2;
        this.f432919e = r106;
        this.f432920f = r106 + r102;
        this.f432921g = r105;
        int r107 = r105 + r102;
        this.f432922h = r107;
        int r108 = b.g(r100, 3);
        this.f432923i = r108;
        this.f432924j = r108 + r102;
        this.f432925k = true;
        this.f432926l = r107 + r103;
        r112.setColor(UDColorUtils.getColor(r100, R.color.text_caption));
        r112.setTextSize(b.g(r100, 14));
        this.f432928n = ((MathKt.roundToInt(r112.measureText(r101)) + (r105 * 2)) + r102) + r103;
        Paint.FontMetrics r109 = r112.getFontMetrics();
        float r113 = r109.bottom;
        this.f432927m = ((r104 / 2) + ((r113 - r109.top) / 2)) - r113;
    }

    public /* synthetic */ MyAIShareActionView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
