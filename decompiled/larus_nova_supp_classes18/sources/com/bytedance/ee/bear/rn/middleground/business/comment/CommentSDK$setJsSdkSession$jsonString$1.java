package com.bytedance.ee.bear.rn.middleground.business.comment;

import com.bytedance.ee.bear.rn.middleground.protocol.Protocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/business/comment/CommentProtocol$Body$SetJsSdkSession;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CommentSDK$setJsSdkSession$jsonString$1 extends Lambda implements Function1<Protocol<CommentProtocol.Body.SetJsSdkSession>, Unit> {
    final /* synthetic */ String $session;

    public CommentSDK$setJsSdkSession$jsonString$1(String r1) {
        this.$session = r1;
        super(1);
    }

    public final void invoke(Protocol<CommentProtocol.Body.SetJsSdkSession> r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        String r1 = this.$session;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r3.setBody(new CommentProtocol.Body.SetJsSdkSession(r1));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Protocol) r1);
        return Unit.INSTANCE;
    }
}
