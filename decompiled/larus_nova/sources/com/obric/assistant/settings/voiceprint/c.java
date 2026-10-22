package com.obric.assistant.settings.voiceprint;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f392442a;

    public /* synthetic */ c(Function0 r100) {
        this.f392442a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r100 = this.f392442a;
        int r101 = ObricVoicePrintManagementActivity.f392409q;
        r100.invoke();
    }
}
