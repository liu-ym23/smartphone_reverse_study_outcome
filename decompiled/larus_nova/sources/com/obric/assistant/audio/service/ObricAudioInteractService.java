package com.obric.assistant.audio.service;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/audio/service/ObricAudioInteractService;", "Lcom/obric/assistant/audio/service/IObricAudioInteractService;", "<init>", "()V", "realtimeCallStateServiceFunc", "Lkotlin/Function0;", "", "getRealtimeCallStateServiceFunc", "()Lkotlin/jvm/functions/Function0;", "setRealtimeCallStateServiceFunc", "(Lkotlin/jvm/functions/Function0;)V", "start", "readLatestMessage", "stop", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAudioInteractService implements IObricAudioInteractService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f385671a;

    public static final class a {
    }

    static {
    }

    public ObricAudioInteractService() {
    }

    @Override // com.obric.assistant.audio.service.IObricAudioInteractService
    public final void stop() {
        this.f385671a = null;
    }

    @Override // com.obric.assistant.audio.service.IObricAudioInteractService
    public final void a() {
        Function0<Unit> r100 = this.f385671a;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    @Override // com.obric.assistant.audio.service.IObricAudioInteractService
    public final void b(com.obric.assistant.chat.component.interaction.a r100) {
        FLogger.f375446a.d("ObricAudioInteractService", "start");
        this.f385671a = r100;
    }
}
