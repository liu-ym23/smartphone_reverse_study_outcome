package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.bytedance.ee.bear.bitable.card.view.cell.chatter.MentionGroupSelectPanel$afterChatterSelected$1$1;
import com.ss.android.lark.pb.chats.PullChatLinkTokenRequest;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class w0 implements com.bytedance.ee.bear.lark.dependency.n {

    public static final class a {
    }

    static {
    }

    @Inject
    public w0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.n
    public final void n(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatId");
    }

    @Override // com.bytedance.ee.bear.lark.dependency.n
    public final void p(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
    }

    @Override // com.bytedance.ee.bear.lark.dependency.n
    public final void q(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.n
    public final void o(String r100, final MentionGroupSelectPanel$afterChatterSelected$1$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).Y9().getClass();
        boolean r102 = km5.c.d();
        PullChatLinkTokenRequest.Builder r103 = new PullChatLinkTokenRequest.Builder().chat_id(r100).expired_day(0);
        if (r102 == false) goto L5;
        String r104 = "Lark";
    L6:
        PullChatLinkTokenRequest.Builder r105 = r103.app_name(r104).is_unlimited(Boolean.TRUE);
        SdkSender.sendPassThroughRequest(Command.PULL_CHAT_LINK_TOKEN, r105, new OfficeIMChatDependencyImpl$getGroupChatLinkToken$1(r101), x0.f427871a);
        return;
    L5:
        r104 = "Feishu";
        goto L6
    }
}
