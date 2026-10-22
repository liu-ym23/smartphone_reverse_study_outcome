package com.ss.android.lark.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 o2\u00020\u0001:\u0001oB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020<H\u0016J\u0006\u0010A\u001a\u00020\u000bJ\u000e\u0010B\u001a\u00020<2\u0006\u00101\u001a\u00020\u000bJ\u0006\u0010C\u001a\u00020\u000bJ\u000e\u0010D\u001a\u00020<2\u0006\u00102\u001a\u00020\u000bJ\b\u0010E\u001a\u00020\u000bH\u0002J\u0006\u0010F\u001a\u00020\u000bJ\u000e\u0010G\u001a\u00020<2\u0006\u0010,\u001a\u00020\u000bJ\u0006\u0010H\u001a\u00020\u0007J\u000e\u0010I\u001a\u00020<2\u0006\u0010-\u001a\u00020\u0007J\u0006\u0010J\u001a\u00020\u000bJ\u000e\u0010K\u001a\u00020<2\u0006\u0010)\u001a\u00020\u000bJ\u0006\u0010L\u001a\u00020\u0007J\u000e\u0010M\u001a\u00020<2\u0006\u0010*\u001a\u00020\u0007J\u0006\u0010N\u001a\u00020\u0007J\u000e\u0010O\u001a\u00020<2\u0006\u0010.\u001a\u00020\u0007J\u0006\u0010P\u001a\u00020\u0007J\u000e\u0010Q\u001a\u00020<2\u0006\u0010/\u001a\u00020\u0007J\b\u0010R\u001a\u0004\u0018\u000105J\u0010\u0010S\u001a\u00020<2\b\u00107\u001a\u0004\u0018\u000105J\b\u0010T\u001a\u0004\u0018\u000105J\u0010\u0010U\u001a\u00020<2\b\u00106\u001a\u0004\u0018\u000105J\b\u0010V\u001a\u0004\u0018\u000105J\u0010\u0010W\u001a\u00020<2\b\u00104\u001a\u0004\u0018\u000105J\u0006\u0010X\u001a\u00020\u0007J\u000e\u0010Y\u001a\u00020<2\u0006\u00103\u001a\u00020\u0007J\b\u0010Z\u001a\u0004\u0018\u000105J\u0010\u0010[\u001a\u00020<2\b\u00109\u001a\u0004\u0018\u000105J\u0006\u0010\\\u001a\u00020\u000bJ\u000e\u0010]\u001a\u00020<2\u0006\u00108\u001a\u00020\u000bJ\u0006\u0010^\u001a\u00020\u0007J\u000e\u0010_\u001a\u00020<2\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010`\u001a\u00020\u0007J\u000e\u0010a\u001a\u00020<2\u0006\u00100\u001a\u00020\u0007J\u0018\u0010b\u001a\u00020<2\u0006\u0010c\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u0007H\u0014J\u0010\u0010e\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u0007H\u0002J\u0010\u0010g\u001a\u00020<2\u0006\u0010h\u001a\u00020iH\u0014J\n\u0010j\u001a\u0004\u0018\u00010kH\u0014J\u0010\u0010l\u001a\u00020<2\u0006\u0010m\u001a\u00020kH\u0014J\u000e\u0010G\u001a\u00020<2\u0006\u0010n\u001a\u000205R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006p"}, d2 = {"Lcom/ss/android/lark/widget/DonutProgress;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "default_stroke_width", "", "default_finished_color", "default_unfinished_color", "default_text_color", "default_inner_bottom_text_color", "default_inner_background_color", "default_max", "default_startingDegree", "default_text_size", "default_inner_bottom_text_size", "min_size", "textPaint", "Landroid/graphics/Paint;", "innerBottomTextPaint", "finishedPaint", "unfinishedPaint", "innerCirclePaint", "finishedOuterRect", "Landroid/graphics/RectF;", "unfinishedOuterRect", "attributeResourceId", "getAttributeResourceId", "()I", "setAttributeResourceId", "(I)V", "isShowText", "", "()Z", "setShowText", "(Z)V", "textSize", "textColor", "innerBottomTextColor", "progress", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "finishedStrokeColor", "unfinishedStrokeColor", "startingDegree", "finishedStrokeWidth", "unfinishedStrokeWidth", "innerBackgroundColor", "prefixText", "", "suffixText", "text", "innerBottomTextSize", "innerBottomText", "innerBottomTextHeight", "initPainters", "", "initByAttributes", "attributes", "Landroid/content/res/TypedArray;", "invalidate", "getFinishedStrokeWidth", "setFinishedStrokeWidth", "getUnfinishedStrokeWidth", "setUnfinishedStrokeWidth", "getProgressAngle", "getProgress", "setProgress", "getMax", "setMax", "getTextSize", "setTextSize", "getTextColor", "setTextColor", "getFinishedStrokeColor", "setFinishedStrokeColor", "getUnfinishedStrokeColor", "setUnfinishedStrokeColor", "getText", "setText", "getSuffixText", "setSuffixText", "getPrefixText", "setPrefixText", "getInnerBackgroundColor", "setInnerBackgroundColor", "getInnerBottomText", "setInnerBottomText", "getInnerBottomTextSize", "setInnerBottomTextSize", "getInnerBottomTextColor", "setInnerBottomTextColor", "getStartingDegree", "setStartingDegree", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "measure", "measureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSaveInstanceState", "Landroid/os/Parcelable;", "onRestoreInstanceState", "state", "percent", "Companion", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DonutProgress extends View {
    public float A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f445575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f445576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f445577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f445578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f445579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f445580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f445581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f445582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f445583i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f445584j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f445585k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f445586l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f445587m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f445588n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f445589o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f445590p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f445591q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f445592r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f445593s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f445594t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f445595u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f445596v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f445597w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f445598x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f445599y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f445600z;

    public static final class a {
    }

    static {
    }

    public DonutProgress(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DonutProgress(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (this.f445584j == false) goto L5;
        TextPaint r100 = new TextPaint();
        r100.setColor(this.f445586l);
        r100.setTextSize(r100.getTextSize());
        r100.setAntiAlias(true);
        this.f445576b = r100;
        TextPaint r101 = new TextPaint();
        r101.setColor(this.f445587m);
        r101.setTextSize(this.f445599y);
        r101.setAntiAlias(true);
        this.f445577c = r101;
    L5:
        Paint r102 = new Paint();
        r102.setColor(this.f445590p);
        r102.setStyle(Paint.Style.STROKE);
        r102.setAntiAlias(true);
        r102.setStrokeWidth(this.f445593s);
        this.f445578d = r102;
        Paint r103 = new Paint();
        r103.setColor(this.f445591q);
        r103.setStyle(Paint.Style.STROKE);
        r103.setAntiAlias(true);
        r103.setStrokeWidth(this.f445594t);
        this.f445579e = r103;
        Paint r104 = new Paint();
        r104.setColor(this.f445595u);
        r104.setAntiAlias(true);
        this.f445580f = r104;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("saved_instance", super.onSaveInstanceState());
        r100.putInt("text_color", getTextColor());
        r100.putFloat("text_size", getTextSize());
        r100.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
        r100.putFloat("inner_bottom_text_color", getInnerBottomTextColor());
        r100.putString("inner_bottom_text", getInnerBottomText());
        r100.putInt("inner_bottom_text_color", getInnerBottomTextColor());
        r100.putInt("finished_stroke_color", getFinishedStrokeColor());
        r100.putInt("unfinished_stroke_color", getUnfinishedStrokeColor());
        r100.putInt(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, getMax());
        r100.putInt("starting_degree", getStartingDegree());
        r100.putFloat("progress", getProgress());
        r100.putString("suffix", getSuffixText());
        r100.putString("prefix", getPrefixText());
        r100.putString("text", getText());
        r100.putFloat("finished_stroke_width", getFinishedStrokeWidth());
        r100.putFloat("unfinished_stroke_width", getUnfinishedStrokeWidth());
        r100.putInt("inner_background_color", getInnerBackgroundColor());
        r100.putInt("inner_drawable", this.f445583i);
        return r100;
    }

    private final float getProgressAngle() {
        return (getProgress() / this.f445589o) * 360.0f;
    }

    @Override // android.view.View
    public final void invalidate() {
        a();
        super.invalidate();
    }

    public final int getAttributeResourceId() {
        return this.f445583i;
    }

    public final int getFinishedStrokeColor() {
        return this.f445590p;
    }

    public final float getFinishedStrokeWidth() {
        return this.f445593s;
    }

    public final int getInnerBackgroundColor() {
        return this.f445595u;
    }

    public final String getInnerBottomText() {
        return this.f445600z;
    }

    public final int getInnerBottomTextColor() {
        return this.f445587m;
    }

    public final float getInnerBottomTextSize() {
        return this.f445599y;
    }

    public final int getMax() {
        return this.f445589o;
    }

    public final String getPrefixText() {
        return this.f445596v;
    }

    public final float getProgress() {
        return this.f445588n;
    }

    public final int getStartingDegree() {
        return this.f445592r;
    }

    public final String getSuffixText() {
        return this.f445597w;
    }

    public final String getText() {
        return this.f445598x;
    }

    public final int getTextColor() {
        return this.f445586l;
    }

    public final float getTextSize() {
        return this.f445585k;
    }

    public final int getUnfinishedStrokeColor() {
        return this.f445591q;
    }

    public final float getUnfinishedStrokeWidth() {
        return this.f445594t;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = Math.max(this.f445593s, this.f445594t);
        this.f445581g.set(r101, r101, getWidth() - r101, getHeight() - r101);
        this.f445582h.set(r101, r101, getWidth() - r101, getHeight() - r101);
        float r102 = ((getWidth() - Math.min(this.f445593s, this.f445594t)) + Math.abs(this.f445593s - this.f445594t)) / 2.0f;
        Paint r103 = this.f445580f;
        if (r103 == null) goto L5;
        r100.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, r102, r103);
    L5:
        Paint r104 = this.f445578d;
        if (r104 == null) goto L8;
        r100.drawArc(this.f445581g, getStartingDegree(), getProgressAngle(), false, r104);
    L8:
        Paint r105 = this.f445579e;
        if (r105 == null) goto L12;
        r100.drawArc(this.f445582h, getProgressAngle() + getStartingDegree(), 360 - getProgressAngle(), false, r105);
    L12:
        if (this.f445584j == false) goto L37;
        String r106 = this.f445598x;
        if (r106 != null) goto L18;
        r106 = this.f445596v + this.f445588n + this.f445597w;
    L18:
        if (TextUtils.isEmpty(r106) == true) goto L25;
        Paint r107 = this.f445576b;
        if (r107 == null) goto L25;
        float r108 = r107.descent() + r107.ascent();
        if (r106 == null) goto L25;
        r100.drawText(r106, (getWidth() - r107.measureText(r106)) / 2.0f, (getWidth() - r108) / 2.0f, r107);
    L25:
        if (TextUtils.isEmpty(getInnerBottomText()) == true) goto L37;
        Paint r109 = this.f445576b;
        if (r109 == null) goto L37;
        Paint r110 = this.f445577c;
        if (r110 == null) goto L31;
        r110.setTextSize(this.f445599y);
    L31:
        float r111 = (getHeight() - this.A) - ((r109.descent() + r109.ascent()) / 2);
        String r112 = getInnerBottomText();
        if (r112 == null) goto L37;
        Paint r113 = this.f445577c;
        if (r113 == null) goto L37;
        r100.drawText(r112, (getWidth() - r113.measureText(getInnerBottomText())) / 2.0f, r111, r113);
    L37:
        if (this.f445583i == 0) goto L40;
        Bitmap r114 = BitmapFactory.decodeResource(getResources(), this.f445583i);
        r100.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        r100.drawBitmap(r114, (getWidth() - r114.getWidth()) / 2.0f, (getHeight() - r114.getHeight()) / 2.0f, null);
        return;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if ((r100 instanceof Bundle) == false) goto L6;
        Bundle r101 = (Bundle) r100;
        this.f445586l = r101.getInt("text_color");
        this.f445585k = r101.getFloat("text_size");
        this.f445599y = r101.getFloat("inner_bottom_text_size");
        this.f445600z = r101.getString("inner_bottom_text");
        this.f445587m = r101.getInt("inner_bottom_text_color");
        this.f445590p = r101.getInt("finished_stroke_color");
        this.f445591q = r101.getInt("unfinished_stroke_color");
        this.f445593s = r101.getFloat("finished_stroke_width");
        this.f445594t = r101.getFloat("unfinished_stroke_width");
        this.f445595u = r101.getInt("inner_background_color");
        this.f445583i = r101.getInt("inner_drawable");
        a();
        setMax(r101.getInt(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX));
        setStartingDegree(r101.getInt("starting_degree"));
        setProgress(r101.getFloat("progress"));
        this.f445596v = r101.getString("prefix");
        this.f445597w = r101.getString("suffix");
        this.f445598x = r101.getString("text");
        super.onRestoreInstanceState(r101.getParcelable("saved_instance"));
        return;
    L6:
        super.onRestoreInstanceState(r100);
    }

    public final void setAttributeResourceId(int r100) {
        this.f445583i = r100;
    }

    public final void setFinishedStrokeColor(int r100) {
        this.f445590p = r100;
        invalidate();
    }

    public final void setFinishedStrokeWidth(float r100) {
        this.f445593s = r100;
        invalidate();
    }

    public final void setInnerBackgroundColor(int r100) {
        this.f445595u = r100;
        invalidate();
    }

    public final void setInnerBottomText(String r100) {
        this.f445600z = r100;
        invalidate();
    }

    public final void setInnerBottomTextColor(int r100) {
        this.f445587m = r100;
        invalidate();
    }

    public final void setInnerBottomTextSize(float r100) {
        this.f445599y = r100;
        invalidate();
    }

    public final void setMax(int r100) {
        if (r100 <= 0) goto L5;
        this.f445589o = r100;
        invalidate();
        return;
    }

    public final void setPrefixText(String r100) {
        this.f445596v = r100;
        invalidate();
    }

    public final void setProgress(float r100) {
        this.f445588n = r100;
        if (r100 <= getMax()) goto L5;
        this.f445588n %= getMax();
    L5:
        invalidate();
    }

    public final void setShowText(boolean r100) {
        this.f445584j = r100;
    }

    public final void setStartingDegree(int r100) {
        this.f445592r = r100;
        invalidate();
    }

    public final void setSuffixText(String r100) {
        this.f445597w = r100;
        invalidate();
    }

    public final void setText(String r100) {
        this.f445598x = r100;
        invalidate();
    }

    public final void setTextColor(int r100) {
        this.f445586l = r100;
        invalidate();
    }

    public final void setTextSize(float r100) {
        this.f445585k = r100;
        invalidate();
    }

    public final void setUnfinishedStrokeColor(int r100) {
        this.f445591q = r100;
        invalidate();
    }

    public final void setUnfinishedStrokeWidth(float r100) {
        this.f445594t = r100;
        invalidate();
    }

    public final void setProgress(String r100) {
        Intrinsics.checkNotNullParameter(r100, "percent");
        if (TextUtils.isEmpty(r100) == true) goto L6;
        setProgress(CastIntegerProtector.parseInt(r100));
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        if (r102 == 1073741824) goto L9;
        int r104 = this.f445575a;
        if (r102 != Integer.MIN_VALUE) goto L8;
        r103 = Math.min(r104, r103);
        goto L9
    L8:
        r103 = r104;
    L9:
        int r105 = View.MeasureSpec.getMode(r101);
        int r106 = View.MeasureSpec.getSize(r101);
        if (r105 == 1073741824) goto L16;
        int r107 = this.f445575a;
        if (r105 != Integer.MIN_VALUE) goto L15;
        r106 = Math.min(r107, r106);
        goto L16
    L15:
        r106 = r107;
    L16:
        setMeasuredDimension(r103, r106);
        this.A = getHeight() - ((getHeight() * 3) / 4);
    }

    public DonutProgress(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        int r100 = Color.rgb(66, 145, 241);
        int r101 = Color.rgb(204, 204, 204);
        int r102 = Color.rgb(66, 145, 241);
        int r103 = Color.rgb(66, 145, 241);
        this.f445581g = new RectF();
        this.f445582h = new RectF();
        this.f445596v = "";
        this.f445597w = GXTemplateKey.GAIAX_PE;
        float r104 = UIUtils.sp2px(getContext(), 18.0f);
        this.f445575a = UIUtils.dp2px(getContext(), 100.0f);
        float r105 = UIUtils.dp2px(getContext(), 10.0f);
        float r106 = UIUtils.sp2px(getContext(), 18.0f);
        TypedArray r113 = r110.getTheme().obtainStyledAttributes(r111, new int[]{R.attr.donut_background_color, R.attr.donut_circle_starting_degree, R.attr.donut_finished_color, R.attr.donut_finished_stroke_width, R.attr.donut_inner_bottom_text, R.attr.donut_inner_bottom_text_color, R.attr.donut_inner_bottom_text_size, R.attr.donut_inner_drawable, R.attr.donut_max, R.attr.donut_prefix_text, R.attr.donut_progress, R.attr.donut_show_text, R.attr.donut_suffix_text, R.attr.donut_text, R.attr.donut_text_color, R.attr.donut_text_size, R.attr.donut_unfinished_color, R.attr.donut_unfinished_stroke_width}, r112, 0);
        this.f445590p = r113.getColor(2, r100);
        this.f445591q = r113.getColor(16, r101);
        this.f445584j = r113.getBoolean(11, true);
        this.f445583i = r113.getResourceId(7, 0);
        setMax(r113.getInt(8, 100));
        setProgress(r113.getFloat(10, 0.0f));
        this.f445593s = r113.getDimension(3, r105);
        this.f445594t = r113.getDimension(17, r105);
        if (this.f445584j == true) goto L5;
    L14:
        this.f445599y = r113.getDimension(6, r106);
        this.f445587m = r113.getColor(5, r103);
        this.f445600z = r113.getString(4);
        this.f445592r = r113.getInt(1, 0);
        this.f445595u = r113.getColor(0, 0);
        r113.recycle();
        a();
        return;
    L5:
        if (r113.getString(9) == null) goto L8;
        this.f445596v = r113.getString(9);
    L8:
        if (r113.getString(12) == null) goto L11;
        this.f445597w = r113.getString(12);
    L11:
        if (r113.getString(13) == null) goto L13;
        this.f445598x = r113.getString(13);
    L13:
        this.f445586l = r113.getColor(14, r102);
        this.f445585k = r113.getDimension(15, r104);
        this.f445599y = r113.getDimension(6, r106);
        this.f445587m = r113.getColor(5, r103);
        this.f445600z = r113.getString(4);
        goto L14
    }

    public /* synthetic */ DonutProgress(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
