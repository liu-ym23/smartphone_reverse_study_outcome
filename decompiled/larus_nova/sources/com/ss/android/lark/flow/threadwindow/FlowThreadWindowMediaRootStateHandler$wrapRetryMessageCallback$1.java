package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.chat.entity.message.Message;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class FlowThreadWindowMediaRootStateHandler$wrapRetryMessageCallback$1 extends FunctionReferenceImpl implements Function1<Message, Unit> {
    public FlowThreadWindowMediaRootStateHandler$wrapRetryMessageCallback$1(Object r100) {
        super(1, r100, FlowThreadWindowMediaRootStateHandler.class, "patchRetryMediaRoot", "patchRetryMediaRoot(Lcom/ss/android/lark/chat/entity/message/Message;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        FlowThreadWindowMediaRootStateHandler.b((FlowThreadWindowMediaRootStateHandler) this.receiver, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Message r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
