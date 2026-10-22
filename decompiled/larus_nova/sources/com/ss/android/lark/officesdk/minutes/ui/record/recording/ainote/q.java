package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.ValueAnimator;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmAINotePanelAnimator f436104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f436105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f436106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f436107d;

    public q(MmAINotePanelAnimator r100, boolean r101, int r102, int r103) {
        this.f436104a = r100;
        this.f436105b = r101;
        this.f436106c = r102;
        this.f436107d = r103;
    }

    public final void a() {
        if (this.f436104a.f435973f.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        boolean r100 = this.f436105b;
        boolean r101 = false;
        if (r100 == false) goto L8;
        int r102 = this.f436106c;
    L9:
        if (r100 == false) goto L11;
        int r103 = this.f436107d;
    L12:
        MmAINotePanelAnimator r110 = this.f436104a;
        if (r110.f435988u == r102) goto L15;
    L17:
        String r111 = "ai_note_delegate(visible=" + this.f436105b + ')';
        if (r110.f435973f.getHeight() > 0) goto L20;
    L30:
        if (r101 == false) goto L42;
        int r104 = r110.f435988u;
        int r105 = r110.f435990w;
        if (r104 != r102) goto L35;
        if (r105 != r103) goto L35;
        return;
    L35:
        long r106 = RangesKt.coerceAtLeast(r110.M, 0);
        if (r106 != 0) goto L38;
        r110.f(r102, r103, r111, true);
        return;
    L38:
        ValueAnimator r107 = r110.f435986s;
        if (r107 == null) goto L41;
        r107.cancel();
    L41:
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r108.setDuration(r106);
        r108.setInterpolator(r110.N);
        r108.addUpdateListener(new h(r110, r104, r102, r105, r103, r111));
        r108.addListener(new i(r110, r102, r103, r111));
        r108.start();
        r110.f435986s = r108;
        return;
    L42:
        ValueAnimator r109 = r110.f435986s;
        if (r109 == null) goto L45;
        r109.cancel();
    L45:
        r110.f(r102, r103, r111, true);
        return;
    L20:
        if (ViewCompat.isLaidOut(r110.f435973f) == false) goto L30;
        if (r110.f435992y == true) goto L30;
        if (r110.K == true) goto L30;
        if (r110.f435988u == r102) goto L28;
    L29:
        r101 = true;
        goto L30
    L28:
        if (r110.f435990w == r103) goto L30;
    L15:
        if (r110.f435990w != r103) goto L17;
        return;
    L11:
        r103 = 0;
        goto L12
    L8:
        r102 = 0;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
