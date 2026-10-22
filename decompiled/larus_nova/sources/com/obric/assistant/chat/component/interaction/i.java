package com.obric.assistant.chat.component.interaction;

import com.obric.assistant.audio.service.IManualHalfDuplexModeService;
import com.obric.assistant.state.api.multitask.VoiceCaptureStateProducerDelegate;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TouchSpeakerEventComponent f386873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TouchSpeakerEventComponent.b f386874b;

    public /* synthetic */ i(TouchSpeakerEventComponent r100, TouchSpeakerEventComponent.b r101) {
        this.f386873a = r100;
        this.f386874b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        TouchSpeakerEventComponent r101 = this.f386873a;
        TouchSpeakerEventComponent.b r102 = this.f386874b;
        String r103 = (String) r100;
        int r104 = TouchSpeakerEventComponent.f386848n;
        Intrinsics.checkNotNullParameter(r103, "botId");
        Object r105 = r101.f386853l;
        monitor-enter(r105);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r101.f386854m == r102) goto L7;
    L12:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r105);
        return r106;
    L7:
        if (r102.f386859e == false) goto L12;
        r102.f386860f = r103;     // Catch: Throwable -> L16
        r102.f386861g = ((IManualHalfDuplexModeService) r101.f386849h.getValue()).c(r103, r102.f386857c, r102.f386858d);     // Catch: Throwable -> L16
        VoiceCaptureStateProducerDelegate.f392947b.b(r102.f386857c, VoiceCaptureScene.TOUCH_SPEAK, r102.f386855a, Integer.valueOf(r102.f386856b), r103);     // Catch: Throwable -> L16
        r102.f386863i = true;     // Catch: Throwable -> L16
        r101.L2(r102);     // Catch: Throwable -> L16
        monitor-exit(r105);
        return Unit.INSTANCE;
    }
}
