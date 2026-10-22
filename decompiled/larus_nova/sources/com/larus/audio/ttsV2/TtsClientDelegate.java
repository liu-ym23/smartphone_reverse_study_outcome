package com.larus.audio.ttsV2;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/larus/audio/ttsV2/TtsClientDelegate;", "Lcom/larus/audio/ttsV2/ITtsClientService;", "<init>", "()V", "cancel", "", "reason", "", "isFromManual", "", "isTtsStopped", "setCurrentConversationId", "cvsId", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsClientDelegate implements ITtsClientService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TtsClientDelegate f289868b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ITtsClientService f289869a;

    static {
        f289868b = new TtsClientDelegate();
    }

    @Override // com.larus.audio.ttsV2.ITtsClientService
    public final void a() {
        this.f289869a.a();
    }

    @Override // com.larus.audio.ttsV2.ITtsClientService
    public final void cancel(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f289869a.cancel(r100, r101);
    }

    @Override // com.larus.audio.ttsV2.ITtsClientService
    public final boolean isTtsStopped() {
        return this.f289869a.isTtsStopped();
    }

    private TtsClientDelegate() {
        ITtsClientService r100 = (ITtsClientService) ServiceManager.get().getService(ITtsClientService.class);
        if (r100 != null) goto L5;
        r100 = new TtsClientServiceNoop();
    L5:
        this.f289869a = r100;
    }
}
