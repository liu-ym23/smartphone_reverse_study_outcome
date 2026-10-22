package com.ss.android.lark.chameleonv2.lkapi.transport;

import android.app.Application;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v1.MGetChattersRequest;
import com.bytedance.lark.pb.contact.v1.MGetChattersResponse;
import com.bytedance.lark.pb.openplatform.v1.PullOpenAppBadgeNodesRequest;
import com.bytedance.lark.pb.openplatform.v1.PullOpenAppBadgeNodesResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.squareup.wire.Message;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import o1b.f;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends AbsChameleonHandler<ITransport$Internal$CallRustApiRequest> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f411453a;

    public a() {
        this.f411453a = LKAPIModules.Internal.Transport.CallRustApi.getValue();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final String getName() {
        return this.f411453a;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final void handle(ITransport$Internal$CallRustApiRequest r110, final Callback r111) {
        final ITransport$Internal$CallRustApiRequest r100 = r110;
        Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
        Intrinsics.checkNotNullParameter(r111, "callback");
        Application r101 = LarkContext.getApplication();
        Message.Builder r102 = null;
        if (r101 == null) goto L7;
        q1b.a r103 = (q1b.a) k.a(r101, q1b.a.class);
        if (r103 == null) goto L7;
        l r104 = r103.g();
    L9:
        if (r104 != null) goto L11;
        r111.error(new LKAPIError(-1, "rustClient is null"));
        return;
    L11:
        IChameleonHandlerContext r105 = getContext();
        if (r105 != null) goto L14;
        r111.error(new LKAPIError(-1, "chameleonContext is null"));
        return;
    L14:
        Application r106 = LarkContext.getApplication();
        if (r106 == null) goto L24;
        q1b.a r107 = (q1b.a) k.a(r106, q1b.a.class);
        if (r107 == null) goto L24;
        m r108 = r107.r9();
        if (r108 == null) goto L24;
        User r109 = r108.getUser();
        if (r109 == null) goto L24;
        final String r112 = r109.userId;
        if (r112 == null) goto L24;
    L25:
        String r113 = r105.getBizName();
        int r114 = WhiteMap.f411452a;
        if (WhiteMap.a(r113, r100.getCommand()) == true) goto L28;
        r111.error(new LKAPIError(-1, "not implement command=" + r100.getCommand() + " bizName=" + r113));
        return;
    L28:
        int r115 = r100.getCommand();
        Command r116 = Command.MGET_CHATTERS;
        if (r115 != r116.getValue()) goto L43;
        int r117 = f.f521735a;
        String r118 = r100.getParams();
        if (Intrinsics.areEqual(MGetChattersRequest.Builder.class, MGetChattersRequest.Builder.class) == false) goto L34;
        r102 = o1b.b.a(r118);
    L36:
        Message.Builder r119 = r102;
        if (r119 == null) goto L42;
        if (t.a(r104.h(new com.bytedance.lark.rustclient.api.d(r119, MGetChattersResponse.ADAPTER, r116, null, null, null, null, 248)).a(), new CallRustApiHandler$handle$1$1(r100, r112, r111), new CallRustApiHandler$handle$1$2(r111), new CallRustApiHandler$handle$1$3(r111)) == null) goto L42;
        return;
    L42:
        r111.error(new LKAPIError(-1, "invalid params"));
        Unit r120 = Unit.INSTANCE;
        return;
    L34:
        if (Intrinsics.areEqual(MGetChattersRequest.Builder.class, PullOpenAppBadgeNodesRequest.Builder.class) == false) goto L36;
        r102 = (MGetChattersRequest.Builder) o1b.c.a(r118);
        goto L36
    L43:
        Command r121 = Command.PULL_OPEN_APP_BADGE_NODES;
        if (r115 != r121.getValue()) goto L56;
        int r122 = f.f521735a;
        String r123 = r100.getParams();
        if (Intrinsics.areEqual(PullOpenAppBadgeNodesRequest.Builder.class, MGetChattersRequest.Builder.class) == false) goto L49;
        r102 = (PullOpenAppBadgeNodesRequest.Builder) o1b.b.a(r123);
    L51:
        Message.Builder r124 = r102;
        if (r124 != null) goto L54;
    L55:
        r111.error(new LKAPIError(-1, "invalid params"));
        Unit r125 = Unit.INSTANCE;
        return;
    L54:
        if (t.a(r104.h(new com.bytedance.lark.rustclient.api.d(r124, PullOpenAppBadgeNodesResponse.ADAPTER, r121, null, null, null, null, 248)).a(), new CallRustApiHandler$handle$3$1(r100, r112, r111), new CallRustApiHandler$handle$3$2(r111), new CallRustApiHandler$handle$3$3(r111)) == null) goto L55;
        return;
    L49:
        if (Intrinsics.areEqual(PullOpenAppBadgeNodesRequest.Builder.class, PullOpenAppBadgeNodesRequest.Builder.class) == false) goto L51;
        r102 = o1b.c.a(r123);
        goto L51
    L56:
        r111.error(new LKAPIError(-1, "not implement command " + r100.getCommand()));
        Unit r126 = Unit.INSTANCE;
        return;
    L24:
        r112 = "";
    L7:
        r104 = null;
        goto L9
    }
}
