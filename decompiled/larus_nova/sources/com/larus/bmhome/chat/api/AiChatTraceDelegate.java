package com.larus.bmhome.chat.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0005H\u0096\u0001JC\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/api/AiChatTraceDelegate;", "Lcom/larus/bmhome/chat/api/IAiChatTraceService;", "<init>", "()V", "onCreateNewBot", "", "pageName", "", "enterMethod", "createWay", "creationId", "onEnterConversationPage", "reportConversationItemShow", "data", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "index", "", "currentPage", "previousPage", "recommendFrom", "docEnterFrom", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiChatTraceDelegate implements IAiChatTraceService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AiChatTraceDelegate f297126b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAiChatTraceService f297127a;

    static {
        f297126b = new AiChatTraceDelegate();
    }

    @Override // com.larus.bmhome.chat.api.IAiChatTraceService
    public final void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter("bot_list_profile", "pageName");
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        this.f297127a.a(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.api.IAiChatTraceService
    public final void b(wh8.a r100, int r101, String r102, String r110, String r111) {
        this.f297127a.b(r100, r101, r102, r110, r111);
    }

    private AiChatTraceDelegate() {
        IAiChatTraceService r100 = (IAiChatTraceService) ServiceManager.get().getService(IAiChatTraceService.class);
        if (r100 != null) goto L5;
        r100 = new AiChatTraceServiceNoop();
    L5:
        this.f297127a = r100;
    }
}
