package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes37.dex */
public final class j implements MmAINotePanelGestureInterceptLayout.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmAINotePanelAnimator f436096a;

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINotePanelGestureInterceptLayout.a
    public final boolean a() {
        if (this.f436096a.f435982o != MmAINoteSheetState.HALF) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINotePanelGestureInterceptLayout.a
    public final void d() {
        MmAINotePanelAnimator r100 = this.f436096a;
        if (r100.f435992y == false) goto L13;
        r100.j();
        r100.f435992y = false;
        if (r100.f435988u == 0) goto L8;
        return;
    L8:
        if (r100.L == false) goto L12;
        r100.L = false;
        return;
    L12:
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINotePanelGestureInterceptLayout.a
    public final boolean onDragStart() {
        MmAINotePanelAnimator r100 = this.f436096a;
        if (r100.K == false) goto L5;
    L14:
        return false;
    L5:
        if (r100.f435982o == MmAINoteSheetState.CLOSED) goto L14;
        ValueAnimator r101 = r100.f435984q;
        if (r101 == null) goto L10;
        r101.cancel();
    L10:
        ValueAnimator r102 = r100.f435985r;
        if (r102 == null) goto L13;
        r102.cancel();
    L13:
        r100.y("content");
        int r103 = r100.m();
        r100.f435993z = r103;
        r100.B(r103);
        r100.i();
        r100.f435992y = true;
        return true;
    }

    public j(MmAINotePanelAnimator r100) {
        this.f436096a = r100;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINotePanelGestureInterceptLayout.a
    public final void b(float r100) {
        MmAINotePanelAnimator r101 = this.f436096a;
        if (r101.f435992y == false) goto L6;
        r101.G(r100);
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINotePanelGestureInterceptLayout.a
    public final void c(float r100) {
        MmAINotePanelAnimator r101 = this.f436096a;
        if (r101.f435992y == false) goto L13;
        r101.D(r100, 0.0f);
        r101.f435992y = false;
        if (r101.f435988u == 0) goto L8;
        return;
    L8:
        if (r101.L == false) goto L12;
        r101.L = false;
        return;
    L12:
        return;
    }
}
