package com.larus.uaigc.createpage.component.digitalavatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/createpage/component/digitalavatar/GradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "colors", "", "positions", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GradientTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f371553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f371554b;

    public GradientTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GradientTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), this.f371553a, this.f371554b, Shader.TileMode.CLAMP));
        super.onDraw(r110);
    }

    public GradientTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int[] r103 = new int[4];
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor("#FF9851")));     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r105) == null) goto L11;
        r105 = -16777216;
    L11:
        r103[0] = ((Number) r105).intValue();
        Object r106 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor("#FF6C55")));     // Catch: Throwable -> L14
    L17:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L20;
        r106 = -16777216;
    L20:
        r103[1] = ((Number) r106).intValue();
        Object r107 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor("#BC72FF")));     // Catch: Throwable -> L23
    L26:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L29;
        r107 = -16777216;
    L29:
        r103[2] = ((Number) r107).intValue();
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor("#5083E5")));     // Catch: Throwable -> L32
    L35:
        if (Result.m9452exceptionOrNullimpl(r108) == null) goto L38;
        r108 = -16777216;
    L38:
        r103[3] = ((Number) r108).intValue();
        this.f371553a = r103;
        this.f371554b = new float[]{0.0f, 0.3f, 0.66f, 0.9f};
        return;
    L32:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L23:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public /* synthetic */ GradientTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
