package com.ss.android.lark.flow.replyinthread.message;

import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.FileDetectBlock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ReplyInThreadBlueprintFactory$create$33 extends FunctionReferenceImpl implements Function1<g, FileDetectBlock> {
    public static final ReplyInThreadBlueprintFactory$create$33 INSTANCE = null;

    static {
        INSTANCE = new ReplyInThreadBlueprintFactory$create$33();
    }

    public ReplyInThreadBlueprintFactory$create$33() {
        super(1, FileDetectBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final FileDetectBlock invoke2(g r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return new FileDetectBlock(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ FileDetectBlock invoke(g r100) {
        return invoke2(r100);
    }
}
