package com.ss.android.lark.tab.service;

import com.bytedance.lark.pb.im.v1.PushChatPinCountResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ChatTabExtraPush$startPush$1$1 extends FunctionReferenceImpl implements Function1<PushChatPinCountResponse, Unit> {
    public ChatTabExtraPush$startPush$1$1(Object r100) {
        super(1, r100, ChatTabExtraPush.class, "onPushChatPinCount", "onPushChatPinCount(Lcom/bytedance/lark/pb/im/v1/PushChatPinCountResponse;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PushChatPinCountResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ChatTabExtraPush r101 = (ChatTabExtraPush) this.receiver;
        int r102 = ChatTabExtraPush.f441112e;
        r101.getClass();
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new a(r101, r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PushChatPinCountResponse r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
