package com.ss.android.lark.flow.replyinthread.message;

import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.TextContentBlock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ReplyInThreadBlueprintFactory$create$5 extends FunctionReferenceImpl implements Function1<g, TextContentBlock> {
    public static final ReplyInThreadBlueprintFactory$create$5 INSTANCE = null;

    static {
        INSTANCE = new ReplyInThreadBlueprintFactory$create$5();
    }

    public ReplyInThreadBlueprintFactory$create$5() {
        super(1, TextContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TextContentBlock invoke2(g r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return new TextContentBlock(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TextContentBlock invoke(g r100) {
        return invoke2(r100);
    }
}
