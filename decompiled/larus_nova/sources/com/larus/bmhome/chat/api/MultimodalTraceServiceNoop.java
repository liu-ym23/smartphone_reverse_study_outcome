package com.larus.bmhome.chat.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J.\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J8\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/api/MultimodalTraceServiceNoop;", "Lcom/larus/bmhome/chat/api/IMultimodalTraceService;", "<init>", "()V", "onProcessStart", "", "fileIdentifier", "", "localSendMsgId", "cvsId", "scene", "onLoadVideoSuccess", "msgID", "videoParam", "enterMethod", "onLoadVideoFail", "errorMsg", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultimodalTraceServiceNoop implements IMultimodalTraceService {
    public MultimodalTraceServiceNoop() {
    }

    @Override // com.larus.bmhome.chat.api.IMultimodalTraceService
    public final void a(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
    }

    @Override // com.larus.bmhome.chat.api.IMultimodalTraceService
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
    }

    @Override // com.larus.bmhome.chat.api.IMultimodalTraceService
    public final void c(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
    }
}
