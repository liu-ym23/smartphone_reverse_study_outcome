package com.larus.office.card.urlpreview;

import com.larus.im.bean.message.block.ArtifactBlock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OfficeUrlPreviewListAnalyzer$analyze$1 extends FunctionReferenceImpl implements Function1<ArtifactBlock, String> {
    public OfficeUrlPreviewListAnalyzer$analyze$1(Object r100) {
        super(1, r100, h2.class, "resolveUrl", "resolveUrl(Lcom/larus/im/bean/message/block/ArtifactBlock;)Ljava/lang/String;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(ArtifactBlock r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((h2) this.receiver).getClass();
        return h2.i(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(ArtifactBlock r100) {
        return invoke2(r100);
    }
}
