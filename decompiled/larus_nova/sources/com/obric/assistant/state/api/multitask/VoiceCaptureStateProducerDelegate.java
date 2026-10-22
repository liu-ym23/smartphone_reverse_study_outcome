package com.obric.assistant.state.api.multitask;

import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001¢\u0006\u0002\u0010\rJ4\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001¢\u0006\u0002\u0010\rJ4\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001¢\u0006\u0002\u0010\rJ<\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001¢\u0006\u0002\u0010\u0012J>\u0010\u0013\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/state/api/multitask/VoiceCaptureStateProducerDelegate;", "Lcom/obric/assistant/state/api/multitask/IVoiceCaptureStateProducerService;", "<init>", "()V", "end", "", "conversationId", "", "scene", "Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;", "sessionId", "sourceType", "", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/String;Ljava/lang/Integer;)V", "onAsrEnd", "onAsrStart", "onCallStateChanged", "callState", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;ILjava/lang/String;Ljava/lang/Integer;)V", "start", "botId", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCaptureStateProducerDelegate implements IVoiceCaptureStateProducerService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final VoiceCaptureStateProducerDelegate f392947b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IVoiceCaptureStateProducerService f392948a;

    static {
        f392947b = new VoiceCaptureStateProducerDelegate();
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void a(String r100, VoiceCaptureScene r101, int r110, String r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f392948a.a(r100, r101, r110, r111, r112);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void b(String r100, VoiceCaptureScene r101, String r110, Integer r111, String r112) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f392948a.b(r100, r101, r110, r111, r112);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void c(String r100, VoiceCaptureScene r101, String r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f392948a.c(r100, r101, r102, r103);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void d(String r100, VoiceCaptureScene r101, String r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f392948a.d(r100, r101, r102, r103);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void e(String r100, VoiceCaptureScene r101, String r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f392948a.e(r100, r101, r102, r103);
    }

    private VoiceCaptureStateProducerDelegate() {
        this.f392948a = (IVoiceCaptureStateProducerService) ServiceManager.get().getService(IVoiceCaptureStateProducerService.class);
    }
}
