package com.larus.bmhome.chat.api;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/api/EmptyConversationFeedActionService;", "Lcom/larus/bmhome/chat/api/IConversationFeedActionService;", "<init>", "()V", "getSupportedActions", "", "Lcom/larus/bmhome/chat/api/ConversationFeedActionType;", "data", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "scene", "Lcom/larus/bmhome/chat/api/ConversationFeedActionScene;", "canShowAction", "", ReportConstant.COMMON_ACTION_TYPE, "createExecutor", "Lcom/larus/bmhome/chat/api/IConversationFeedActionExecutor;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/bmhome/chat/api/ConversationFeedActionContext;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyConversationFeedActionService implements IConversationFeedActionService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EmptyConversationFeedActionService f297163a = null;

    static {
        f297163a = new EmptyConversationFeedActionService();
    }

    private EmptyConversationFeedActionService() {
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final boolean a(ConversationFeedActionType r100, wh8.a r101, ConversationFeedActionScene r102) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r102, "scene");
        return false;
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final u b(i r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return p.f297243a;
    }

    @Override // com.larus.bmhome.chat.api.IConversationFeedActionService
    public final List<ConversationFeedActionType> c(wh8.a r100, ConversationFeedActionScene r101) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        return CollectionsKt.emptyList();
    }
}
