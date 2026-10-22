package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.concurrent.ScheduledFuture;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class q implements IIMCallback<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture<?> f345372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Object> f345373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f345374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f345375d;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return false;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f345372a.cancel(false);
        int r101 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.a(this.f345374c + "_fail", this.f345375d + " code=" + r100.getCode());
        if (this.f345373b.isActive() == false) goto L6;
        this.f345373b.resumeWith(Result.m9449constructorimpl(null));
        return;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f345372a.cancel(false);
        if (this.f345373b.isActive() == false) goto L6;
        this.f345373b.resumeWith(Result.m9449constructorimpl(r100));
        return;
    }

    public q(ScheduledFuture r100, kotlinx.coroutines.j r101, String r102, String r103) {
        this.f345372a = r100;
        this.f345373b = r101;
        this.f345374c = r102;
        this.f345375d = r103;
    }
}
