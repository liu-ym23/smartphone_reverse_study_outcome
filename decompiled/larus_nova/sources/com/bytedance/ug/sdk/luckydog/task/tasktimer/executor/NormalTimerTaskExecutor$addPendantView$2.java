package com.bytedance.ug.sdk.luckydog.task.tasktimer.executor;

import android.widget.FrameLayout;
import com.bytedance.ug.sdk.luckydog.task.pendant.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class NormalTimerTaskExecutor$addPendantView$2 implements com.bytedance.ug.sdk.luckydog.task.tasktimer.view.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalTimerTaskExecutor f272241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f272242b;

    @Override // com.bytedance.ug.sdk.luckydog.task.tasktimer.view.e
    public final void onAttach() {
    }

    @Override // com.bytedance.ug.sdk.luckydog.task.tasktimer.view.e
    public final void a(FrameLayout r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "addPendantView onDetach remove root = " + this.f272242b + ", view = " + r100);
        NormalTimerTaskExecutor r101 = this.f272241a;
        r101.f272230g = null;
        if (Intrinsics.areEqual(r101.f272227d.get(this.f272242b), r100) == false) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "addPendantView onDetach inner");
        f.a(new NormalTimerTaskExecutor$addPendantView$2$onDetach$1(this));
        gm7.d.f481696c.c(2);
        return;
    }

    public NormalTimerTaskExecutor$addPendantView$2(NormalTimerTaskExecutor r100, FrameLayout r101) {
        this.f272241a = r100;
        this.f272242b = r101;
    }
}
