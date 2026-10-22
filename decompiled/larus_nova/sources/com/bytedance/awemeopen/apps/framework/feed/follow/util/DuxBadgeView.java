package com.bytedance.awemeopen.apps.framework.feed.follow.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001f B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002R\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxBadgeView;", "Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxTextView;", "", "dotSize", "", "setDotSize", "mode", "setMode", "getMode", "color", "setBadgeColor", "count", "setCount", "", "useDefault", "setUseDefaultDraw", "maxNumber", "setMaxNumberInCount", "Landroid/graphics/Rect;", "m", "Landroid/graphics/Rect;", "getR", "()Landroid/graphics/Rect;", "r", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Mode", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class DuxBadgeView extends DuxTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f194760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f194761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f194762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f194763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f194764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f194765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f194766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f194767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f194768l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f194769m;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxBadgeView$Mode;", "", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Mode {
    }

    public static final class a {
    }

    static {
    }

    public DuxBadgeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DuxBadgeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void x() {
        int r100 = this.f194761e;
        if (r100 != 1) goto L5;
        float r101 = this.f194765i;
        Resources r102 = Resources.getSystem();
        int r103 = MathKt.roundToInt(TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
    L13:
        int r104 = r103;
    L14:
        setMeasuredDimension(r104, r103);
        int r105 = getMeasuredHeight();
        if (this.f194762f == r105) goto L18;
        this.f194762f = r105;
        y(r105, this.f194760d);
        return;
    L18:
        return;
    L5:
        if (r100 != 2) goto L7;
    L9:
        float r106 = this.f194766j;
        Resources r107 = Resources.getSystem();
        r103 = MathKt.roundToInt(TypedValue.applyDimension(1, r106, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics())));
        r104 = getMeasuredWidth();
        if (r104 >= r103) goto L14;
    L7:
        if (r100 == 3) goto L9;
        float r108 = this.f194765i;
        Resources r109 = Resources.getSystem();
        r103 = MathKt.roundToInt(TypedValue.applyDimension(1, r108, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics())));
        goto L13
    }

    public final void z() {
        int r100 = this.f194761e;
        if (r100 != 2) goto L5;
    L8:
        Resources r101 = Resources.getSystem();
        int r102 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
        int r103 = r102;
    L9:
        super.setPadding(r102, 0, r103, 0);
        return;
    L5:
        if (r100 == 3) goto L8;
        r102 = 0;
        r103 = 0;
        goto L9
    }

    public final int getMode() {
        return this.f194761e;
    }

    public final Rect getR() {
        return this.f194769m;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        if (this.f194764h == false) goto L5;
        super.onDraw(r100);
        return;
    L5:
        getPaint().setTextAlign(Paint.Align.LEFT);
        getPaint().setColor(getCurrentTextColor());
        if (r100 == null) goto L8;
        r100.getClipBounds(this.f194769m);
    L8:
        int r101 = this.f194769m.height();
        int r102 = this.f194769m.width();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), this.f194769m);
        float r103 = (r102 / 2.0f) - (this.f194769m.width() / 2.0f);
        Rect r104 = this.f194769m;
        float r105 = r103 - r104.left;
        float r106 = ((r101 / 2.0f) + (r104.height() / 2.0f)) - this.f194769m.bottom;
        if (r100 == null) goto L13;
        r100.drawText(getText().toString(), r105, r106, getPaint());
        return;
    }

    public final void setBadgeColor(int r100) {
        this.f194760d = r100;
        y(this.f194762f, r100);
    }

    public final void setCount(int r100) {
        setText(String.valueOf(r100));
    }

    public final void setDotSize(int r100) {
        this.f194765i = r100;
        x();
    }

    public final void setMaxNumberInCount(int r100) {
        this.f194768l = r100;
    }

    public final void setMode(int r100) {
        if (this.f194761e != r100) goto L5;
        return;
    L5:
        this.f194761e = r100;
        if (r100 == 2) goto L11;
        if (r100 == 3) goto L11;
        this.f194763g = getText();
        setText("");
    L15:
        z();
        x();
        return;
    L11:
        if (TextUtils.isEmpty(getText()) == false) goto L15;
        if (TextUtils.isEmpty(this.f194763g) == true) goto L15;
        CharSequence r101 = this.f194763g;
        Intrinsics.checkNotNull(r101);
        setText(r101);
        goto L15
    }

    public final void setUseDefaultDraw(boolean r100) {
        new Throwable();
        this.f194764h = r100;
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        x();
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        Intrinsics.checkNotNullParameter(r100, "inText");
        if (this.f194761e == 2) goto L5;
    L14:
        this.f194763g = r100;
        if (this.f194761e == 3) goto L17;
    L16:
        r100 = "";
    L19:
    L13:
        throw new IllegalArgumentException("Excepted a int but get " + getText());
    L17:
        super.setText(r100, r101);
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L14;
        Integer r102 = CastIntegerProtector.valueOf(r100.toString());     // Catch: Exception -> L12
        if (r102.intValue() <= this.f194768l) goto L10;
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L12
        r103.append(this.f194768l);     // Catch: Exception -> L12
        r103.append('+');     // Catch: Exception -> L12
        r100 = r103.toString();     // Catch: Exception -> L12
        goto L19
    L10:
        if (r102.intValue() >= 0) goto L19;
        goto L16
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextSize(int r100, float r101) {
        super.setTextSize(1, this.f194767k);
    }

    public final void y(int r100, int r101) {
        Resources r102 = Resources.getSystem();
        float r103 = TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
        Drawable r104 = DrawableCompat.wrap(new ShapeDrawable(new RoundRectShape(new float[]{r103, r103, r103, r103, r103, r103, r103, r103}, null, null)));
        DrawableCompat.setTint(r104, r101);
        setBackground(r104);
    }

    public DuxBadgeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f194761e = -1;
        this.f194764h = true;
        this.f194765i = 7;
        this.f194766j = 16;
        this.f194767k = 11.0f;
        this.f194768l = 99;
        this.f194769m = new Rect();
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.adaptLargeFontMode, R.attr.badgeColor, R.attr.badgeMode, R.attr.limitLargeFontScale, R.attr.useDefaultDraw});
        this.f194760d = r103.getColor(1, ContextCompat.getColor(getContext(), R.color.aos_custom_primary));
        this.f194764h = r103.getBoolean(4, true);
        setMode(r103.getInt(2, 1));
        r103.recycle();
        setTextSize(1, 11.0f);
        setTextColor(ContextCompat.getColor(getContext(), R.color.ConstTextInverse));
        setGravity(17);
        setClickable(false);
        setIncludeFontPadding(false);
        setLines(1);
    }

    public /* synthetic */ DuxBadgeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        z();
    }
}
