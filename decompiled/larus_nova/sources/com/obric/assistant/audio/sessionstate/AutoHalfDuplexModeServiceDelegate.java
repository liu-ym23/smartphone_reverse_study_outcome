package com.obric.assistant.audio.sessionstate;

import com.larus.audio.call.mgr.MajorState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u001b\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0013H\u0096\u0001¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/audio/sessionstate/AutoHalfDuplexModeServiceDelegate;", "Lcom/obric/assistant/audio/sessionstate/IAutoHalfDuplexModeService;", "<init>", "()V", "nextRound", "", "botId", "", "onCanceled", "onFailed", "onMajorStateChanged", "prev", "Lcom/larus/audio/call/mgr/MajorState;", "current", "onQueryBegin", "onQueryEnd", "onStarted", "setHasAttachments", "hasAttachment", "", "start", "conversationId", "stop", "roundEnd", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoHalfDuplexModeServiceDelegate implements IAutoHalfDuplexModeService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AutoHalfDuplexModeServiceDelegate f385683b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAutoHalfDuplexModeService f385684a;

    static {
        f385683b = new AutoHalfDuplexModeServiceDelegate();
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void e(MajorState r100, MajorState r101) {
        Intrinsics.checkNotNullParameter(r100, "prev");
        Intrinsics.checkNotNullParameter(r101, "current");
        this.f385684a.e(r100, r101);
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.f385684a.f(r100);
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.f385684a.g(r100);
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void h(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.f385684a.h(r100, r101);
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void start(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.f385684a.start(r100, r101);
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void stop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.f385684a.stop(r100);
    }

    private AutoHalfDuplexModeServiceDelegate() {
        this.f385684a = (IAutoHalfDuplexModeService) ServiceManager.get().getService(IAutoHalfDuplexModeService.class);
    }
}
