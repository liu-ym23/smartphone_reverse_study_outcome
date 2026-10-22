package com.obric.assistant.audio.service;

import com.larus.audio.call.mgr.MajorState;
import com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService;
import com.obric.assistant.state.api.multitask.IObricInteractionModeService;
import com.obric.assistant.state.api.multitask.ObricInteractionModeServiceDelegate;
import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import com.obric.assistant.state.api.multitask.state.ModeRefreshSource;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J(\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u0002¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/audio/service/AutoHalfDuplexModeService;", "Lcom/obric/assistant/audio/sessionstate/IAutoHalfDuplexModeService;", "<init>", "()V", "start", "", "botId", "", "conversationId", "stop", "roundEnd", "", "onQueryEnd", "onCanceled", "onStarted", "onFailed", "setHasAttachments", "hasAttachment", "onMajorStateChanged", "prev", "Lcom/larus/audio/call/mgr/MajorState;", "current", "onQueryBegin", "nextRound", "endMode", "refreshMode", "ext", "", "", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoHalfDuplexModeService implements IAutoHalfDuplexModeService {

    public static final class a {
    }

    static {
    }

    public AutoHalfDuplexModeService() {
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void e(MajorState r100, MajorState r101) {
        Intrinsics.checkNotNullParameter(r100, "prev");
        Intrinsics.checkNotNullParameter(r101, "current");
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        a(r100, MapsKt.emptyMap());
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        a(r100, MapsKt.emptyMap());
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void stop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        ObricInteractionModeServiceDelegate r101 = ObricInteractionModeServiceDelegate.f392941b;
        zga.a r102 = r101.c(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.f572103d != ObricInteractionType.AutoHalfDuplex) goto L7;
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

    public static void a(String r100, Map r101) {
        ObricInteractionModeServiceDelegate r102 = ObricInteractionModeServiceDelegate.f392941b;
        zga.a r103 = r102.c(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.f572103d != ObricInteractionType.AutoHalfDuplex) goto L7;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L12;
        r103 = null;
    L12:
        if (r103 == null) goto L16;
        r102.a(r103.f572102c, ModeRefreshSource.BUSINESS, null, r101);
        return;
    L16:
        return;
    L7:
        r104 = false;
        goto L9
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void h(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        a(r100, MapsKt.mapOf(TuplesKt.to("has_attachment", Boolean.valueOf(r101))));
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void start(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        IObricInteractionModeService.a.b(ObricInteractionModeServiceDelegate.f392941b, r100, r101, ObricInteractionType.AutoHalfDuplex, null, 24);
    }
}
