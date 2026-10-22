package com.obric.assistant.audio.service;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.IObricInteractionModeService;
import com.obric.assistant.state.api.multitask.ObricInteractionModeServiceDelegate;
import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import com.obric.assistant.state.api.multitask.state.ModeRefreshSource;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/audio/service/ManualHalfDuplexModeService;", "Lcom/obric/assistant/audio/service/IManualHalfDuplexModeService;", "<init>", "()V", "start", "", "botId", "", "conversationId", "hasAttachment", "", "startSession", "stop", "stopSession", "sessionId", "onQueryEnd", "text", "onQueryEndSession", "onCanceled", "onStarted", "onFailed", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ManualHalfDuplexModeService implements IManualHalfDuplexModeService {

    public static final class a {
    }

    static {
    }

    public ManualHalfDuplexModeService() {
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        FLogger.f375446a.d("ManualHalfDuplexModeService", "onObricModeStop sessionId:".concat(r100));
        IObricInteractionModeService.a.a(ObricInteractionModeServiceDelegate.f392941b, r100, ModeEndReason.NORMAL);
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        FLogger.f375446a.d("ManualHalfDuplexModeService", "ObricMode onStarted");
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void stop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        FLogger.f375446a.d("ManualHalfDuplexModeService", "onObricModeStop");
        ObricInteractionModeServiceDelegate r101 = ObricInteractionModeServiceDelegate.f392941b;
        zga.a r102 = r101.c(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.f572103d != ObricInteractionType.ManualHalfDuplex) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L15;
        IObricInteractionModeService.a.a(r101, r102.f572102c, ModeEndReason.NORMAL);
        return;
    L15:
        return;
    L7:
        r103 = false;
        goto L8
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "text");
        FLogger.f375446a.d("ManualHalfDuplexModeService", "ObricMode onQueryEnd");
        ObricInteractionModeServiceDelegate.f392941b.a(r100, ModeRefreshSource.BUSINESS, null, MapsKt.emptyMap());
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final String c(String r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "botId");
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        FLogger.f375446a.d("ManualHalfDuplexModeService", "onObricModeStart");
        return IObricInteractionModeService.a.b(ObricInteractionModeServiceDelegate.f392941b, r110, r111, ObricInteractionType.ManualHalfDuplex, MapsKt.mapOf(TuplesKt.to("has_attachment", Boolean.valueOf(r112))), 8);
    }
}
