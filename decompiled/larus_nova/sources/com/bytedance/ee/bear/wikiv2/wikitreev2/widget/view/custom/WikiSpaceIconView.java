package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.e;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eJ\u0015\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0015J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010&\u001a\u0004\u0018\u00010'R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/custom/WikiSpaceIconView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mPaint", "Landroid/graphics/Paint;", "mTextString", "", "mTintColor", "Ljava/lang/Integer;", "mBitmapWidth", "mBitmapHeight", "setTextString", "", "textString", "setTintColor", "tintColor", "(Ljava/lang/Integer;)V", "setBitmapWidth", "width", "setBitmapHeight", "height", "getTextSize", "", "getBorderRadius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "isEmojiCharacter", "", "text", "createBitmap", "Landroid/graphics/Bitmap;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceIconView extends View {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f242427f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f242428g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f242429h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f242430i = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f242431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f242432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f242433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f242434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f242435e;

    public static final class a {
    }

    public WikiSpaceIconView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public WikiSpaceIconView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public WikiSpaceIconView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    static {
        f242427f = n.d(1);
        f242428g = n.d(8);
        f242429h = n.d(32);
        f242430i = n.G(18);
    }

    private final float getBorderRadius() {
        return (f242428g * this.f242434d) / f242429h;
    }

    private final float getTextSize() {
        return (f242430i * this.f242434d) / f242429h;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        Integer r101 = this.f242433c;
        if (r101 == null) goto L5;
        this.f242431a.setColor(getContext().getResources().getColor(r101.intValue()));
        this.f242431a.setStyle(Paint.Style.STROKE);
        Paint r102 = this.f242431a;
        float r103 = f242427f;
        r102.setStrokeWidth(r103);
        this.f242431a.setAntiAlias(true);
        r100.drawRoundRect(new RectF(r103, r103, this.f242434d - r103, this.f242435e - r103), getBorderRadius(), getBorderRadius(), this.f242431a);
    L5:
        this.f242431a.setColor(getContext().getResources().getColor(R.color.bg_float));
        this.f242431a.setStyle(Paint.Style.FILL);
        this.f242431a.setAntiAlias(true);
        float r104 = f242427f;
        r100.drawRoundRect(new RectF(r104, r104, this.f242434d - r104, this.f242435e - r104), getBorderRadius(), getBorderRadius(), this.f242431a);
        String r105 = this.f242432b;
        boolean r106 = false;
        if (r105 != null) goto L8;
    L11:
        boolean r107 = true;
    L12:
        if (r107 == true) goto L22;
        int r108 = 0;
    L16:
        if (r108 >= r105.length()) goto L22;
        if (yu5.a.b(r105.charAt(r108)) == true) goto L19;
        r108 = r108 + 1;
        goto L16
    L19:
        r106 = true;
    L22:
        if (r106 == true) goto L29;
        String r109 = this.f242432b;
        if (r109 == null) goto L38;
        String r110 = r109.toUpperCase(Locale.ROOT);
        Integer r111 = this.f242433c;
        if (r111 == null) goto L28;
        this.f242431a.setColor(getContext().getResources().getColor(r111.intValue()));
    L28:
        this.f242431a.setStyle(Paint.Style.FILL);
        this.f242431a.setTextSize(getTextSize());
        Paint r112 = this.f242431a;
        int r113 = e.f483540a;
        r112.setTypeface(e.b(getContext(), 1));
        Paint.FontMetrics r114 = this.f242431a.getFontMetrics();
        float r115 = 2;
        r100.drawText(r110, (this.f242434d - this.f242431a.measureText(r110)) / r115, (this.f242435e / 2) - ((r114.descent + r114.ascent) / r115), this.f242431a);
        return;
    L38:
        return;
    L29:
        String r116 = this.f242432b;
        if (r116 == null) goto L40;
        Integer r117 = this.f242433c;
        if (r117 == null) goto L34;
        this.f242431a.setColor(getContext().getResources().getColor(r117.intValue()));
    L34:
        this.f242431a.setStyle(Paint.Style.FILL);
        this.f242431a.setTextSize(getTextSize());
        Paint r118 = this.f242431a;
        int r119 = e.f483540a;
        r118.setTypeface(e.b(getContext(), 1));
        Paint.FontMetrics r120 = this.f242431a.getFontMetrics();
        float r121 = 2;
        r100.drawText(r116, (this.f242434d - this.f242431a.measureText(r116)) / r121, (this.f242435e / 2) - ((r120.ascent + r120.descent) / r121), this.f242431a);
        return;
    L40:
        return;
    L8:
        if (r105.length() == 0) goto L11;
        r107 = false;
        goto L12
    }

    public final void setBitmapHeight(int r100) {
        this.f242435e = r100;
    }

    public final void setBitmapWidth(int r100) {
        this.f242434d = r100;
    }

    public final void setTextString(String r100) {
        this.f242432b = r100;
    }

    public final void setTintColor(Integer r100) {
        this.f242433c = r100;
    }

    public WikiSpaceIconView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f242431a = new Paint();
    }
}
