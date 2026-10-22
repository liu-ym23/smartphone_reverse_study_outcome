package com.ss.android.lark.flow.replyinthread.message;

import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.DLPBlock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ReplyInThreadBlueprintFactory$create$32 extends FunctionReferenceImpl implements Function1<g, DLPBlock> {
    public static final ReplyInThreadBlueprintFactory$create$32 INSTANCE = null;

    static {
        INSTANCE = new ReplyInThreadBlueprintFactory$create$32();
    }

    public ReplyInThreadBlueprintFactory$create$32() {
        super(1, DLPBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final DLPBlock invoke2(g r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return new DLPBlock(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ DLPBlock invoke(g r100) {
        return invoke2(r100);
    }
}
