package com.larus.bot.impl.common.view;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/bot/impl/common/view/FastLinearSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "startPosition", "", "getStartPosition", "()I", "setStartPosition", "(I)V", "millisecondsPerInch", "", "speedUpPosition", "calculateSpeedPerPixel", "displayMetrics", "Landroid/util/DisplayMetrics;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FastLinearSmoothScroller extends LinearSmoothScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f317706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f317707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f317708c;

    public FastLinearSmoothScroller(Context r100) {
        super(r100);
        this.f317707b = 25.0f;
        this.f317708c = 15.0f;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final float calculateSpeedPerPixel(DisplayMetrics r100) {
        float r101 = (Math.abs(this.f317706a - getTargetPosition()) / this.f317708c) + 1;
        float r102 = this.f317707b;
        Intrinsics.checkNotNull(r100);
        return (r102 / r100.densityDpi) / r101;
    }
}
