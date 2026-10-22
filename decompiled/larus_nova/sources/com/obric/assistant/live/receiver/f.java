package com.obric.assistant.live.receiver;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final class f implements oga.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f390177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f390178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f390179c;

    @Override // oga.a
    public final void onDismissFailed() {
        FLogger.f375446a.i("ObricLiveReceiver", "handleComplexTaskActionWithKeyguard: onDismissFailed, action=" + this.f390177a + ",isDeviceLocked=" + this.f390178b);
    }

    @Override // oga.a
    public final void onDismissSucceeded() {
        FLogger.f375446a.i("ObricLiveReceiver", "handleComplexTaskActionWithKeyguard: onDismissSucceeded, action=" + this.f390177a + ",isDeviceLocked=" + this.f390178b);
        this.f390179c.invoke();
    }

    public f(String r100, boolean r101, Function0<Unit> r102) {
        this.f390177a = r100;
        this.f390178b = r101;
        this.f390179c = r102;
    }
}
