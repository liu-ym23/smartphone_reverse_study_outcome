package com.larus.bmhome.chat.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J/\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J/\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/api/MultimodalTraceDelegate;", "Lcom/larus/bmhome/chat/api/IMultimodalTraceService;", "<init>", "()V", "onLoadVideoFail", "", "fileIdentifier", "", "msgID", "errorMsg", "videoParam", "enterMethod", "onLoadVideoSuccess", "onProcessStart", "localSendMsgId", "cvsId", "scene", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultimodalTraceDelegate implements IMultimodalTraceService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MultimodalTraceDelegate f297171b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IMultimodalTraceService f297172a;

    static {
        f297171b = new MultimodalTraceDelegate();
    }

    @Override // com.larus.bmhome.chat.api.IMultimodalTraceService
    public final void a(String r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        this.f297172a.a(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.bmhome.chat.api.IMultimodalTraceService
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        this.f297172a.b(r100, r101);
    }

    @Override // com.larus.bmhome.chat.api.IMultimodalTraceService
    public final void c(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        this.f297172a.c(r100, r101, r102, r103);
    }

    private MultimodalTraceDelegate() {
        IMultimodalTraceService r100 = (IMultimodalTraceService) ServiceManager.get().getService(IMultimodalTraceService.class);
        if (r100 != null) goto L5;
        r100 = new MultimodalTraceServiceNoop();
    L5:
        this.f297172a = r100;
    }
}
