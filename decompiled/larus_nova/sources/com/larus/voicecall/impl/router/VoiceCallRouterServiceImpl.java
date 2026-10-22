package com.larus.voicecall.impl.router;

import com.bytedance.router.SmartRouter;
import com.larus.voicecall.api.IVoiceCallRouterService;
import com.larus.voicecall.impl.ui.r;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/voicecall/impl/router/VoiceCallRouterServiceImpl;", "Lcom/larus/voicecall/api/IVoiceCallRouterService;", "<init>", "()V", "addSmartRouterInterceptors", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCallRouterServiceImpl implements IVoiceCallRouterService {
    public VoiceCallRouterServiceImpl() {
    }

    @Override // com.larus.voicecall.api.IVoiceCallRouterService
    public final void a() {
        SmartRouter.addInterceptor(new r());
    }
}
