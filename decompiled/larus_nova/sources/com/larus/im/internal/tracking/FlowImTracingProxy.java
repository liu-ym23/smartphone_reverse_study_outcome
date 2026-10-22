package com.larus.im.internal.tracking;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.constant.CompensateScene;
import com.larus.im.constant.PullSingleChainScene;
import com.larus.im.internal.protocol.bean.BotReplyLoadingUpdateNotify;
import com.larus.im.internal.protocol.bean.DownlinkBody;
import com.larus.im.internal.protocol.bean.DownlinkMessage;
import com.larus.im.internal.protocol.bean.FetchChunkMessageUplinkBody;
import com.larus.im.internal.protocol.bean.NewMessageNotify;
import com.larus.im.internal.protocol.bean.PullCMDChainDownlinkBody;
import com.larus.im.internal.protocol.bean.PullSingleChainDownlinkBody;
import com.larus.im.internal.protocol.bean.PullSingleChainUplinkBody;
import com.larus.im.internal.protocol.bean.SendMessageAckDownlinkBody;
import com.larus.im.internal.protocol.bean.SuggestQuestion;
import com.larus.im.internal.protocol.bean.UplinkMessage;
import com.larus.im.internal.utils.LifecycleManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowImTracingProxy implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowImTracingProxy f350219a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<r> f350220b = null;

    public FlowImTracingProxy() {
    }

    static {
        f350219a = new FlowImTracingProxy();
        ArrayList r100 = new ArrayList();
        f350220b = r100;
        r100.add(new i());
        r100.add(new j());
        r100.add(new FlowImReceiveTracing());
        r100.add(new g());
        r100.add(new n());
        LifecycleManager r101 = LifecycleManager.f350518a;
        l r102 = new l();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "observer");
        LifecycleManager.f350520c.add(r102);
    }

    @Override // com.larus.im.internal.tracking.r
    public final void a(boolean r100) {
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onLifeCycleChange$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void b(BotReplyLoadingUpdateNotify r100) {
        Intrinsics.checkNotNullParameter(r100, "serverLoadingData");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onServerLoading$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void c(q r100) {
        Intrinsics.checkNotNullParameter(r100, "msgLinkData");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onMessageSendStart$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onChunkTimeout$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void h(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onUplinkMessageSendStart$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void i(a r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptInfo");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onChunkDataIntercept$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void j(b r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onChunkInterrupt$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void k(FetchChunkMessageUplinkBody r100) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onChunkStart$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void l(int r100) {
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onWsConnectChange$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void m(com.larus.im.internal.protocol.bean.c r100) {
        Intrinsics.checkNotNullParameter(r100, "cmd");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onReceiveAllCmd$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void n(b r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onChunkStreamDone$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void u(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onDBOperateException$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void v(b r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onChunkCancel$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void w(b r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onChunkError$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void x(UplinkMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "uplink");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onShortLinkRequest$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void y(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onUplinkMessageSendEnd$1(r100, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void d(UplinkMessage r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "uplink");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onWsChannelSend$1(r100, r101, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final Object g(b r100, Continuation<? super Unit> r101) {
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onReceiveReplyContentChunk$2(r100, null));
        return Unit.INSTANCE;
    }

    @Override // com.larus.im.internal.tracking.r
    public final void o(q r100, com.larus.im.internal.network.e<SendMessageAckDownlinkBody> r101) {
        Intrinsics.checkNotNullParameter(r100, "msgLinkData");
        Intrinsics.checkNotNullParameter(r101, "result");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onMessageSendEnd$1(r100, r101, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void r(DownlinkMessage r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "downlink");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onWsChannelReceive$1(r100, r101, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void p(long r100, PullSingleChainScene r110, PullSingleChainUplinkBody r111, com.larus.im.internal.network.e<PullSingleChainDownlinkBody> r112) {
        Intrinsics.checkNotNullParameter(r110, "from");
        Intrinsics.checkNotNullParameter(r111, "uplink");
        Intrinsics.checkNotNullParameter(r112, "result");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onSingleChainReport$1(r100, r110, r111, r112, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void s(int r100, String r110, long r111, d0 r112) {
        Intrinsics.checkNotNullParameter(r110, "errorDesc");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onShortLinkResponse$1(r100, r110, r111, r112, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void A(String r110, long r111, int r112, int r113, d0 r114) {
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onApiRequest$1(r110, r111, r112, r113, r114, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void f(MessageSuggestFrom r100, String r110, String r111, List<SuggestQuestion> r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r110, "messageId");
        Intrinsics.checkNotNullParameter(r111, "replyId");
        Intrinsics.checkNotNullParameter(r112, "suggest");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$messageReceiveSuggest$1(r100, r110, r111, r112, r113, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void t(String r100, Integer r110, NewMessageNotify r111, ReceiveMessageFrom r112, Long r113) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r112, "from");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onReceiveMessage$1(r100, r110, r111, r112, r113, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void q(boolean r110, int r111, int r112, com.larus.im.internal.network.e<PullCMDChainDownlinkBody> r113, long r114, CompensateScene r115) {
        Intrinsics.checkNotNullParameter(r113, "result");
        Intrinsics.checkNotNullParameter(r115, "from");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onCmdChainReport$1(r110, r111, r112, r113, r114, r115, null));
    }

    @Override // com.larus.im.internal.tracking.r
    public final void z(String r110, String r111, com.larus.im.internal.network.e<DownlinkBody> r112, ReceiveMessageFrom r113, Long r114, String r115) {
        Intrinsics.checkNotNullParameter(r111, "replyMsgId");
        Intrinsics.checkNotNullParameter(r112, "errorStatus");
        Intrinsics.checkNotNullParameter(r113, "from");
        com.larus.im.internal.database.utils.e.e(new FlowImTracingProxy$onReceiveMessageError$1(r110, r111, r112, r113, r114, r115, null));
    }
}
