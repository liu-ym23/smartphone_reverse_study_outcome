package com.larus.avlink.chat;

import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.bmhome.chat.dora.IChatDoraService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/avlink/chat/ChatDoraServiceImpl;", "Lcom/larus/bmhome/chat/dora/IChatDoraService;", "<init>", "()V", "isDoraConnected", "", "onActiveSummaryGenerated", "", "summaryId", "", "biz", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatDoraServiceImpl implements IChatDoraService {
    public ChatDoraServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.dora.IChatDoraService
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "summaryId");
        DoraAVLinkDelegate.f291640b.I0(r100, r101);
    }
}
