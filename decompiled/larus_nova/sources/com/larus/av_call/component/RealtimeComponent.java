package com.larus.av_call.component;

import android.content.Intent;
import android.view.View;
import com.larus.audio.call.mgr.MajorState;
import com.larus.im.service.audio.z0;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.component.internal.attach.a;
import com.larus.utils.logger.FLogger;
import g88.r;
import jd9.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/av_call/component/IRealtimeComponentExt;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "getStringByFragment", "", "res", "getColorByFragment", "color", "onViewCreated", "", "view", "Landroid/view/View;", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class RealtimeComponent extends BaseContentWidget implements r {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f290501m;

    public void A0() {
    }

    @Override // g88.r
    public void onActivityResult(int r100, int r101, Intent r102) {
    }

    @Override // g88.r
    public void onAppBackground() {
    }

    @Override // g88.r
    public void onAppForeground() {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public RealtimeComponent() {
        this.f290501m = R.id.realtime_call_root;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f290501m;
    }

    public void D9(z0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // g88.r
    public void I6(c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f290501m = r100;
    }

    public final String Y2(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L4
        return a.b(this, this).getResources().getString(r100);
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Throwable r103 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r103 == null) goto L13;
        FLogger.f375446a.e("RealtimeComponent", "onErr=" + r103 + " res=" + r100 + " clazz=" + getClass());
        return "";
    L13:
        return "";
    }

    @Override // g88.r
    public void z2(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public void o1(MajorState r100, int r101, MajorState r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "currentMajorState");
        Intrinsics.checkNotNullParameter(r102, "newMajorState");
    }
}
