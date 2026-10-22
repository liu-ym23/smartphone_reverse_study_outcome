package com.larus.common_ui.widget.input.audiowave.gradient;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.larus.common_ui.widget.input.audiowave.AudioWaveView;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0014J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e¨\u0006)"}, d2 = {"Lcom/larus/common_ui/widget/input/audiowave/gradient/AudioWaveGradientView;", "Lcom/larus/common_ui/widget/input/audiowave/AudioWaveView;", "Lcom/larus/common_ui/widget/input/audiowave/gradient/IAudioWaveGradientView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "EDIT_MODE", "", "visibleRect", "Landroid/graphics/RectF;", "debugPaint", "Landroid/graphics/Paint;", "maskPaint", "leftGradient", "Landroid/graphics/LinearGradient;", "rightGradient", "showGradient", "getShowGradient", "()Z", "setShowGradient", "(Z)V", "value", "", "gradientBarCount", "getGradientBarCount", "()I", "setGradientBarCount", "(I)V", "gradientWidth", "getGradientWidth", "setGradientWidth", "updateBars", "", "w", "h", "onDraw", "canvas", "Landroid/graphics/Canvas;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioWaveGradientView extends AudioWaveView {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RectF f328709q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Paint f328710r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public LinearGradient f328711s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LinearGradient f328712t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f328713u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f328714v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f328715w;

    public int getGradientBarCount() {
        return this.f328714v;
    }

    public int getGradientWidth() {
        return this.f328715w;
    }

    public boolean getShowGradient() {
        return this.f328713u;
    }

    public AudioWaveGradientView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.larus.common_ui.widget.input.audiowave.AudioWaveView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (getShowGradient() == true) goto L6;
        super.onDraw(r110);
        return;
    L6:
        LinearGradient r100 = null;
        int r101 = r110.saveLayer(this.f328709q, null);
        super.onDraw(r110);
        Paint r102 = this.f328710r;
        LinearGradient r103 = this.f328711s;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("leftGradient");
        r103 = null;
    L9:
        r102.setShader(r103);
        RectF r104 = this.f328709q;
        float r105 = r104.left;
        r110.drawRect(r105, r104.top, r105 + getGradientWidth(), this.f328709q.bottom, this.f328710r);
        Paint r106 = this.f328710r;
        LinearGradient r107 = this.f328712t;
        if (r107 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("rightGradient");
    L13:
        r106.setShader(r100);
        float r108 = this.f328709q.right - getGradientWidth();
        RectF r109 = this.f328709q;
        r110.drawRect(r108, r109.top, r109.right, r109.bottom, this.f328710r);
        r110.restoreToCount(r101);
        return;
    L12:
        r100 = r107;
        goto L13
    }

    public void setGradientBarCount(int r100) {
        this.f328714v = r100;
        setGradientWidth(r100 * (getBarWidth() + getBarGap()));
    }

    public void setGradientWidth(int r100) {
        this.f328715w = r100;
    }

    public void setShowGradient(boolean r100) {
        this.f328713u = r100;
    }

    public AudioWaveGradientView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 4, 0);
        this.f328709q = new RectF();
        Paint r102 = new Paint();
        r102.setColor(FakePickerAvatarCreator.GRAY);
        r102.setAntiAlias(true);
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f328710r = r103;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_gradientBarCount, R.attr.larus_gradientWidth, R.attr.larus_showGradient});
        setShowGradient(r104.getBoolean(2, getShowGradient()));
        if (r104.hasValue(1) == false) goto L6;
        setGradientWidth(r104.getInt(1, getGradientWidth()));
    L8:
        r104.recycle();
        return;
    L6:
        if (r104.hasValue(0) == false) goto L8;
        setGradientBarCount(r104.getInt(0, getGradientBarCount()));
        goto L8
    }

    @Override // com.larus.common_ui.widget.input.audiowave.AudioWaveView
    public final void c(int r210, int r211) {
        super.c(r210, r211);
        float r100 = (r210 - getWaveGroupTotalWidth()) / 2.0f;
        float r101 = (r211 - getWaveGroupTotalHeight()) / 2.0f;
        float r102 = 1;
        this.f328709q.set(Math.max(0.0f, r100 - r102), Math.max(0.0f, r101 - r102), Math.min(r210, (r100 + getWaveGroupTotalWidth()) + r102), Math.min(r211, (r101 + getWaveGroupTotalHeight()) + r102));
        float r110 = this.f328709q.left;
        this.f328711s = new LinearGradient(r110, 0.0f, r110 + getGradientWidth(), 0.0f, new int[]{0, -16777216}, null, Shader.TileMode.CLAMP);
        this.f328712t = new LinearGradient(this.f328709q.right - getGradientWidth(), 0.0f, this.f328709q.right, 0.0f, new int[]{-16777216, 0}, null, Shader.TileMode.CLAMP);
    }
}
