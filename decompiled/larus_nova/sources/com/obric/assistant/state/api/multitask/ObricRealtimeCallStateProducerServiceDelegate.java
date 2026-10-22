package com.obric.assistant.state.api.multitask;

import com.huawei.hms.api.FailedBinderCallBack;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J)\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001J!\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\rH\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/state/api/multitask/ObricRealtimeCallStateProducerServiceDelegate;", "Lcom/obric/assistant/state/api/multitask/IObricRealtimeCallStateProducerService;", "<init>", "()V", "onCallEntered", "", "botId", "", "conversationId", "onCallExited", "onMajorStateChanged", FailedBinderCallBack.CALLER_ID, "prevState", "", "currentState", "onMuteStateChanged", "state", "onPluginStarted", "onPluginStopped", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRealtimeCallStateProducerServiceDelegate implements IObricRealtimeCallStateProducerService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricRealtimeCallStateProducerServiceDelegate f392945b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricRealtimeCallStateProducerService f392946a;

    static {
        f392945b = new ObricRealtimeCallStateProducerServiceDelegate();
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void a(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        this.f392946a.a(r100, r101, r102);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void b(String r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        this.f392946a.b(r100, r101, r102, r103);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        this.f392946a.c(r100, r101);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        this.f392946a.d(r100, r101);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        this.f392946a.e(r100, r101);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        this.f392946a.g(r100, r101);
    }

    private ObricRealtimeCallStateProducerServiceDelegate() {
        this.f392946a = (IObricRealtimeCallStateProducerService) ServiceManager.get().getService(IObricRealtimeCallStateProducerService.class);
    }
}
