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
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001f B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002R\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxBadgeView;", "Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxTextView;", "", "dotSize", "", "setDotSize", "mode", "setMode", "getMode", "color", "setBadgeColor", UploadTypeInf.COUNT, "setCount", "", "useDefault", "setUseDefaultDraw", "maxNumber", "setMaxNumberInCount", "Landroid/graphics/Rect;", "m", "Landroid/graphics/Rect;", "getR", "()Landroid/graphics/Rect;", "r", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "Mode", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class DuxBadgeView extends DuxTextView {
    public int d;
    public int e;
    public int f;
    public CharSequence g;
    public boolean h;
    public int i;
    public final int j;
    public final float k;
    public int l;
    public final Rect m;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxBadgeView$Mode;", "", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Mode {
    }

    public static final class a {
    }

    static {
    }

    public DuxBadgeView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DuxBadgeView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        int r0 = this.e;
        if (r0 != 1) goto L5;
        float r1 = this.i;
        Resources r2 = Resources.getSystem();
        int r3 = MathKt.roundToInt(TypedValue.applyDimension(1, r1, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
    L13:
        int r4 = r3;
    L14:
        setMeasuredDimension(r4, r3);
        int r5 = getMeasuredHeight();
        if (this.f == r5) goto L18;
        this.f = r5;
        y(r5, this.d);
        return;
    L18:
        return;
    L5:
        if (r0 != 2) goto L7;
    L9:
        float r6 = this.j;
        Resources r7 = Resources.getSystem();
        r3 = MathKt.roundToInt(TypedValue.applyDimension(1, r6, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics())));
        r4 = getMeasuredWidth();
        if (r4 >= r3) goto L14;
    L7:
        if (r0 == 3) goto L9;
        float r8 = this.i;
        Resources r9 = Resources.getSystem();
        r3 = MathKt.roundToInt(TypedValue.applyDimension(1, r8, WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics())));
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z() {
        int r0 = this.e;
        if (r0 != 2) goto L5;
    L8:
        Resources r1 = Resources.getSystem();
        int r2 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
        int r3 = r2;
    L9:
        super/*android.widget.TextView*/.setPadding(r2, 0, r3, 0);
        return;
    L5:
        if (r0 == 3) goto L8;
        r2 = 0;
        r3 = 0;
        goto L9
    }

    public final int getMode() {
        return this.e;
    }

    public final Rect getR() {
        return this.m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r8) {
        if (this.h == false) goto L5;
        super/*android.widget.TextView*/.onDraw(r8);
        return;
    L5:
        getPaint().setTextAlign(Paint.Align.LEFT);
        getPaint().setColor(getCurrentTextColor());
        if (r8 == null) goto L8;
        r8.getClipBounds(this.m);
    L8:
        int r0 = this.m.height();
        int r1 = this.m.width();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), this.m);
        float r2 = (r1 / 2.0f) - (this.m.width() / 2.0f);
        Rect r3 = this.m;
        float r4 = r2 - r3.left;
        float r5 = ((r0 / 2.0f) + (r3.height() / 2.0f)) - this.m.bottom;
        if (r8 == null) goto L13;
        r8.drawText(getText().toString(), r4, r5, getPaint());
        return;
    }

    public final void setBadgeColor(int r2) {
        this.d = r2;
        y(this.f, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCount(int r1) {
        setText(String.valueOf(r1));
    }

    public final void setDotSize(int r1) {
        this.i = r1;
        x();
    }

    public final void setMaxNumberInCount(int r1) {
        this.l = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMode(int r2) {
        if (this.e != r2) goto L5;
        return;
    L5:
        this.e = r2;
        if (r2 == 2) goto L11;
        if (r2 == 3) goto L11;
        this.g = getText();
        setText("");
    L15:
        z();
        x();
        return;
    L11:
        if (TextUtils.isEmpty(getText()) == false) goto L15;
        if (TextUtils.isEmpty(this.g) == true) goto L15;
        CharSequence r3 = this.g;
        Intrinsics.checkNotNull(r3);
        setText(r3);
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setUseDefaultDraw(boolean r2) {
        new Throwable();
        this.h = r2;
        invalidate();
    }

    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        x();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r5, TextView.BufferType r6) {
        Intrinsics.checkNotNullParameter(r5, "inText");
        if (this.e == 2) goto L5;
    L14:
        this.g = r5;
        if (this.e == 3) goto L17;
    L16:
        r5 = "";
    L19:
    L13:
        throw new IllegalArgumentException("Excepted a int but get " + getText());
    L17:
        super/*android.widget.TextView*/.setText(r5, r6);
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L14;
        Integer r0 = CastIntegerProtector.valueOf(r5.toString());     // Catch: Exception -> L12
        if (r0.intValue() <= this.l) goto L10;
        StringBuilder r7 = new StringBuilder();     // Catch: Exception -> L12
        r7.append(this.l);     // Catch: Exception -> L12
        r7.append('+');     // Catch: Exception -> L12
        r5 = r7.toString();     // Catch: Exception -> L12
        goto L19
    L10:
        if (r0.intValue() >= 0) goto L19;
        goto L16
    }

    public final void setTextSize(int r1, float r2) {
        super.setTextSize(1, this.k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(int r4, int r5) {
        Resources r0 = Resources.getSystem();
        float r6 = TypedValue.applyDimension(1, r4, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
        Drawable r7 = DrawableCompat.wrap(new ShapeDrawable(new RoundRectShape(new float[]{r6, r6, r6, r6, r6, r6, r6, r6}, null, null)));
        DrawableCompat.setTint(r7, r5);
        setBackground(r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DuxBadgeView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        new LinkedHashMap();
        super(r3, r4, r5);
        this.e = -1;
        this.h = true;
        this.i = 7;
        this.j = 16;
        this.k = 11.0f;
        this.l = 99;
        this.m = new Rect();
        TypedArray r6 = getContext().obtainStyledAttributes(r4, new int[]{2130968752, 2130968912, 2130968914, 2130972546, 2130975009});
        this.d = r6.getColor(1, ContextCompat.getColor(getContext(), 2131100281));
        this.h = r6.getBoolean(4, true);
        setMode(r6.getInt(2, 1));
        r6.recycle();
        setTextSize(1, 11.0f);
        setTextColor(ContextCompat.getColor(getContext(), 2131099796));
        setGravity(17);
        setClickable(false);
        setIncludeFontPadding(false);
        setLines(1);
    }

    public /* synthetic */ DuxBadgeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void setPadding(int r1, int r2, int r3, int r4) {
        z();
    }
}
