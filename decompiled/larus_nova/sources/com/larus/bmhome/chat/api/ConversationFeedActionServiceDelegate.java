package com.larus.bmhome.chat.api;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/api/ConversationFeedActionServiceDelegate;", "Lcom/larus/bmhome/chat/api/IConversationFeedActionService;", "<init>", "()V", "canShowAction", "", ReportConstant.COMMON_ACTION_TYPE, "Lcom/larus/bmhome/chat/api/ConversationFeedActionType;", "data", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "scene", "Lcom/larus/bmhome/chat/api/ConversationFeedActionScene;", "createExecutor", "Lcom/larus/bmhome/chat/api/IConversationFeedActionExecutor;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/bmhome/chat/api/ConversationFeedActionContext;", "getSupportedActions", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationFeedActionServiceDelegate implements IConversationFeedActionService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConversationFeedActionServiceDelegate f297156b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IConversationFeedActionService f297157a;

    static {
        f297156b = new ConversationFeedActionServiceDelegate();
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final boolean a(ConversationFeedActionType r100, wh8.a r101, ConversationFeedActionScene r102) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r102, "scene");
        return this.f297157a.a(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final u b(i r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f297157a.b(r100);
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final List<ConversationFeedActionType> c(wh8.a r100, ConversationFeedActionScene r101) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        return this.f297157a.c(r100, r101);
    }

    private ConversationFeedActionServiceDelegate() {
        IConversationFeedActionService r100 = (IConversationFeedActionService) ServiceManager.get().getService(IConversationFeedActionService.class);
        if (r100 != null) goto L5;
        r100 = EmptyConversationFeedActionService.f297163a;
    L5:
        this.f297157a = r100;
    }
}
