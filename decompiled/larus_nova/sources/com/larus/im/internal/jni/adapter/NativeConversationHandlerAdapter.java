package com.larus.im.internal.jni.adapter;

import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.delegate.h1;
import hd9.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0096\u0001J!\u0010\u000b\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/larus/im/internal/jni/adapter/NativeConversationHandlerAdapter;", "Lcom/larus/im/dependency/IOmniConversationHandlerBridge;", "<init>", "()V", "updateConversationBadgeCount", "", "conversationId", "", "badgeCount", "", "readBadgeCount", "updateConversationLastMessage", "messages", "", "Lcom/larus/im/internal/database/entity/MessageEntity;", "needNotify", "", "verifyConversationConsistency", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeConversationHandlerAdapter implements j {
    private final /* synthetic */ j $$delegate_0;

    @Override // hd9.j
    public void updateConversationBadgeCount(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.$$delegate_0.updateConversationBadgeCount(r100, r101, r102);
    }

    @Override // hd9.j
    public void updateConversationLastMessage(List<MessageEntity> r100, boolean r101) {
        this.$$delegate_0.updateConversationLastMessage(r100, r101);
    }

    @Override // hd9.j
    public void verifyConversationConsistency() {
        this.$$delegate_0.verifyConversationConsistency();
    }

    public NativeConversationHandlerAdapter() {
        this.$$delegate_0 = h1.f348237b.a();
    }
}
