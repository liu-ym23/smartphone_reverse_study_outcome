package com.obric.assistant.live.receiver;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final class g implements oga.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f390180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f390181b;

    @Override // oga.a
    public final void onDismissFailed() {
        FLogger.f375446a.i("ObricLiveReceiver", "handleComplexTaskActionWithKeyguard: onDismissFailed, action=" + this.f390180a);
    }

    @Override // oga.a
    public final void onDismissSucceeded() {
        FLogger.f375446a.i("ObricLiveReceiver", "handleComplexTaskActionWithKeyguard: onDismissSucceeded, action=" + this.f390180a);
        this.f390181b.invoke();
    }

    public g(String r100, Function0<Unit> r101) {
        this.f390180a = r100;
        this.f390181b = r101;
    }
}
