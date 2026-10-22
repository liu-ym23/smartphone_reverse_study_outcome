package com.obric.assistant.util;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes33.dex */
public final class l2 implements oga.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrionChatExtensionUtils f393764a;

    @Override // oga.b
    public final void onRequestDismissKeyguard() {
    }

    public l2(OrionChatExtensionUtils r100) {
        this.f393764a = r100;
    }

    @Override // oga.b
    public final void onDismissFailed(boolean r100) {
        OrionChatExtensionUtils r101 = this.f393764a;
        r101.getClass();
        FLogger.f375446a.i(r101.f393639a, "onDismissFailed");
        r101.f393644f.set(true);
    }

    @Override // oga.b
    public final void onDismissSucceeded(boolean r100) {
        OrionChatExtensionUtils r101 = this.f393764a;
        r101.getClass();
        FLogger.f375446a.i(r101.f393639a, "onDismissSucceeded");
        r101.f393644f.set(false);
    }
}
