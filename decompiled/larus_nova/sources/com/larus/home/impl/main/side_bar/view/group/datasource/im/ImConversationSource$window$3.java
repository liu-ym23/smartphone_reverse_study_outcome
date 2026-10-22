package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ImConversationSource$window$3 extends FunctionReferenceImpl implements Function1<String, Message> {
    public ImConversationSource$window$3(Object r100) {
        super(1, r100, j0.class, "peek", "peek(Ljava/lang/String;)Lcom/larus/im/bean/message/Message;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Message invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((j0) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        return j0.f345354b.get(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Message invoke(String r100) {
        return invoke2(r100);
    }
}
