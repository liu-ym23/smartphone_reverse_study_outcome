package com.obric.assistant.live.receiver;

import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;

/* JADX INFO: loaded from: classes33.dex */
public final class h implements oga.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f390182a;

    @Override // oga.a
    public final void onDismissFailed() {
    }

    @Override // oga.a
    public final void onDismissSucceeded() {
        FLogger.f375446a.i("ObricLiveReceiver", "onDismissSucceeded");
        sea.e.c(true);
        ObricLiveServiceDelegate.f385676b.g(this.f390182a);
    }

    public h(Intent r100) {
        this.f390182a = r100;
    }
}
