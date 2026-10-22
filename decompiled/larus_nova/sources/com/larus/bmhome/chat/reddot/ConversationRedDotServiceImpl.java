package com.larus.bmhome.chat.reddot;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/reddot/ConversationRedDotServiceImpl;", "Lcom/larus/bmhome/chat/reddot/IConversationRedDotService;", "<init>", "()V", "observeRedDotCount", "", "observer", "Lcom/larus/bmhome/chat/reddot/OnRedDotCountObserver;", "unObserveRedDotCount", "refreshRedDotCount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationRedDotServiceImpl implements IConversationRedDotService {
    public ConversationRedDotServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.reddot.IConversationRedDotService
    public final void a() {
        f r100 = f.f308497a;
        FLogger.f375446a.i("ConversationRedDotManager", "refreshRedDotCount");
        f.c(f.f308502f);
    }

    @Override // com.larus.bmhome.chat.reddot.IConversationRedDotService
    public final void b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        f r101 = f.f308497a;
        f.d(r100);
    }
}
