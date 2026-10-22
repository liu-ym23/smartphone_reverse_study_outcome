package com.ss.android.lark.tab.service;

import com.bytedance.lark.pb.im.v1.PushChatTabs;
import com.larksuite.framework.thread.CoreThreadPool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ChatTabPush$startPush$2$1 extends FunctionReferenceImpl implements Function1<PushChatTabs, Unit> {
    public ChatTabPush$startPush$2$1(Object r100) {
        super(1, r100, ChatTabPush.class, "onPushChatTab", "onPushChatTab(Lcom/bytedance/lark/pb/im/v1/PushChatTabs;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PushChatTabs r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ChatTabPush r101 = (ChatTabPush) this.receiver;
        int r102 = ChatTabPush.f441127d;
        r101.getClass();
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new e(r101, r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PushChatTabs r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
