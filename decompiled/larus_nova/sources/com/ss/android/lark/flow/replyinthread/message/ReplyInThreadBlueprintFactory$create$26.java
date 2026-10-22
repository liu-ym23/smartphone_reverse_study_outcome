package com.ss.android.lark.flow.replyinthread.message;

import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MessagePinInfoBlock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ReplyInThreadBlueprintFactory$create$26 extends FunctionReferenceImpl implements Function1<g, MessagePinInfoBlock> {
    public static final ReplyInThreadBlueprintFactory$create$26 INSTANCE = null;

    static {
        INSTANCE = new ReplyInThreadBlueprintFactory$create$26();
    }

    public ReplyInThreadBlueprintFactory$create$26() {
        super(1, MessagePinInfoBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MessagePinInfoBlock invoke2(g r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return new MessagePinInfoBlock(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MessagePinInfoBlock invoke(g r100) {
        return invoke2(r100);
    }
}
