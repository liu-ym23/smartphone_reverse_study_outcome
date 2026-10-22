package com.larus.home.impl.main.tab.config;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0015R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/home/impl/main/tab/config/BottomTabGradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startColor", "endColor", "colorArray", "", "startEndColorGradient", "Landroid/graphics/LinearGradient;", "colorArrayGradient", "init", "", "setTextColors", "onDraw", "canvas", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomTabGradientTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f345977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f345978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f345979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearGradient f345980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearGradient f345981e;

    public BottomTabGradientTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f345977a = -16777216;
        this.f345978b = -16777216;
        x(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int[] r100 = this.f345979c;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L11:
        if (r101 == false) goto L17;
        if (this.f345981e != null) goto L17;
        if (r100 == null) goto L17;
        this.f345981e = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, r100, null, Shader.TileMode.CLAMP);
    L17:
        if (this.f345977a != (-16777216)) goto L21;
        if (this.f345978b != (-16777216)) goto L21;
    L23:
        LinearGradient r102 = this.f345981e;
        if (r102 != null) goto L27;
        r102 = this.f345980d;
    L27:
        if (r102 == null) goto L29;
        getPaint().setShader(r102);
    L29:
        super.onDraw(r110);
        return;
    L21:
        if (this.f345980d != null) goto L23;
        this.f345980d = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.f345977a, this.f345978b, Shader.TileMode.CLAMP);
        goto L23
    L5:
        if (r100.length != 0) goto L7;
        boolean r103 = true;
    L9:
        if ((!r103) != true) goto L11;
        r101 = true;
        goto L11
    L7:
        r103 = false;
        goto L9
    }

    public final void setTextColors(int[] r110) {
        Intrinsics.checkNotNullParameter(r110, "colorArray");
        this.f345979c = r110;
        if (r110.length != 0) goto L5;
        boolean r100 = true;
    L7:
        if ((!r100) == true) goto L9;
    L11:
        invalidate();
        return;
    L9:
        if (getWidth() == 0) goto L11;
        this.f345981e = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, r110, null, Shader.TileMode.CLAMP);
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public BottomTabGradientTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f345977a = -16777216;
        this.f345978b = -16777216;
        x(r100, r101);
    }

    public final void x(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_endColor, R.attr.larus_startColor});
        this.f345977a = r102.getColor(1, this.f345977a);
        this.f345978b = r102.getColor(0, this.f345978b);
        r102.recycle();
    }

    public BottomTabGradientTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f345977a = -16777216;
        this.f345978b = -16777216;
        x(r100, r101);
    }
}
