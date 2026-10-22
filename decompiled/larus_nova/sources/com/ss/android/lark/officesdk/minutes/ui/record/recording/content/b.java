package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmRecordingContentController f436325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f436326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f436327c;

    public b(MmRecordingContentController r100, l r101, int r102) {
        this.f436325a = r100;
        this.f436326b = r101;
        this.f436327c = r102;
    }

    public final void a() {
        if (this.f436325a.f436299a.b().isAttachedToWindow() == true) goto L7;
        int r100 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.CONTENT, "goToSubtitle", "skip detached pager, request=" + this.f436326b, this.f436325a.c());
        return;
    L7:
        if (this.f436325a.f436299a.b().getCurrentItem() == this.f436327c) goto L9;
        int r101 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.CONTENT, "goToSubtitle", "force sync tab, currentItem=" + this.f436325a.f436299a.b().getCurrentItem() + ", subtitlePosition=" + this.f436327c, this.f436325a.c());
        this.f436325a.f436299a.b().setCurrentItem(this.f436327c, false);
    L9:
        this.f436325a.e(this.f436327c, "goToSubtitle_post", true);
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
