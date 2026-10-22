package com.obric.assistant.util;

import com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService;
import com.obric.assistant.state.api.multitask.VoiceCaptureStateProducerDelegate;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import com.obric.assistant.state.api.v2.core.IObricStateDispatcherService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes33.dex */
public final class e2 implements hca.c {
    public e2() {
    }

    @Override // hca.c
    public final void a(String r100, Integer r101, String r102) {
        IObricStateDispatcherService r103 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r103 == null) goto L6;
        r103.h(r100, r101);
        return;
    }

    @Override // hca.c
    public final void b(String r100, Integer r101, String r102) {
        IObricStateDispatcherService r103 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r103 == null) goto L5;
        r103.m(r100, r101);
    L5:
        IVoiceCaptureStateProducerService.a.a(VoiceCaptureStateProducerDelegate.f392947b, r100, VoiceCaptureScene.CLICK_TALK, r102, r101);
    }

    @Override // hca.c
    public final void c(String r100, Integer r101, String r102) {
        VoiceCaptureStateProducerDelegate.f392947b.c(r100, VoiceCaptureScene.CLICK_TALK, r102, r101);
    }

    @Override // hca.c
    public final void d(String r100, Integer r101, String r102) {
        IObricStateDispatcherService r103 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r103 == null) goto L5;
        r103.n(r100, r101);
    L5:
        VoiceCaptureStateProducerDelegate.f392947b.d(r100, VoiceCaptureScene.CLICK_TALK, r102, r101);
    }

    @Override // hca.c
    public final void e(String r100, Integer r101, String r102) {
        IObricStateDispatcherService r103 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r103 == null) goto L5;
        r103.b(r100, r101);
    L5:
        VoiceCaptureStateProducerDelegate.f392947b.e(r100, VoiceCaptureScene.CLICK_TALK, r102, r101);
    }
}
