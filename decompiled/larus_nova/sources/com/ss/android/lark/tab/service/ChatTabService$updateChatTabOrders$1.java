package com.ss.android.lark.tab.service;

import com.bytedance.lark.pb.im.v1.UpdateChatTabOrdersResponse;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/tab/service/entity/ChatTabsListResult;", "response", "Lcom/bytedance/lark/pb/im/v1/UpdateChatTabOrdersResponse;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatTabService$updateChatTabOrders$1 extends Lambda implements Function1<UpdateChatTabOrdersResponse, p6c.c> {
    final /* synthetic */ String $chatId;

    public ChatTabService$updateChatTabOrders$1(String r100) {
        this.$chatId = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final p6c.c invoke2(UpdateChatTabOrdersResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        return new p6c.c(r100.chat_id.longValue(), p6c.d.a(this.$chatId, r100.tabs), r100.version.longValue());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p6c.c invoke(UpdateChatTabOrdersResponse r100) {
        return invoke2(r100);
    }
}
