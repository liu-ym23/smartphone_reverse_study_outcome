package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmAINotePanelAnimator f436103a;

    public p(MmAINotePanelAnimator r100) {
        this.f436103a = r100;
    }

    public final void a() {
        if (this.f436103a.f435973f.isAttachedToWindow() == false) goto L14;
        MmAINotePanelAnimator r100 = this.f436103a;
        if (r100.f435982o == MmAINoteSheetState.CLOSED) goto L16;
        r100.f435977j.requestLayout();
        this.f436103a.f435968a.f516022q.requestLayout();
        MmAINotePanelAnimator r101 = this.f436103a;
        if (r101.f435982o == MmAINoteSheetState.HALF) goto L10;
    L12:
        MmAINotePanelAnimator r102 = this.f436103a;
        r102.g(r102.n(), this.f436103a.f435974g.getTranslationY());
        return;
    L10:
        if (r101.w() == false) goto L12;
        this.f436103a.p(MmAINotePanelAnimator.FullStateSource.INITIAL_SHOW, "content_height_changed");
        return;
    L16:
        return;
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
