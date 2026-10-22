package com.bytedance.ee.bear.rn.middleground.business.comment;

import com.bytedance.ee.bear.rn.middleground.protocol.Protocol;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$SetOpenApiSession;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CommentSDK$setOpenApiSession$jsonString$1 extends Lambda implements Function1<Protocol<CommentProtocol.Body.SetOpenApiSession>, Unit> {
    final /* synthetic */ String $session;

    public CommentSDK$setOpenApiSession$jsonString$1(String r100) {
        this.$session = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Protocol<CommentProtocol.Body.SetOpenApiSession> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        String r101 = this.$session;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.setBody(new CommentProtocol.Body.SetOpenApiSession(r101));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Protocol<CommentProtocol.Body.SetOpenApiSession> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
