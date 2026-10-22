package com.ss.android.lark.im.sdk.usercontainer;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.p0;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.chat.service.impl.RecallInterceptCallback;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin$pullFollowingMessages$1;
import com.ss.android.lark.im.sdk.service.a0;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.im.sdk.service.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mergeforward.ParseMergeForwardDataUtils$wrapCallback$1;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends c0c.b implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f426202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f426203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<p> f426204d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void B8(String r100, boolean r101, RecallInterceptCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f426202b.B8(r100, r101, r102);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void Fe(List<String> r100, IGetDataCallback<Map<String, Message>> r101) {
        Intrinsics.checkNotNullParameter(r100, "ids");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426202b.Fe(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void Jc(String r100, List<String> r101, IGetDataCallback<Message> r102) {
        Intrinsics.checkNotNullParameter(r101, "ids");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f426202b.Jc(r100, r101, r102);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Executor P0() {
        return this.f426202b.P0();
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void Q5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cId");
        this.f426202b.Q5(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void W2(String r100, int r101, FlowMessageSelectPlugin$pullFollowingMessages$1 r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f426202b.W2(r100, r101, r102);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Map<String, MessageInfo> W5(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "messageIds");
        return this.f426202b.W5(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void X3(Message r100, IGetDataCallback<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426202b.X3(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void Z8(List r100, ParseMergeForwardDataUtils$wrapCallback$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "messages");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426202b.Z8(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void a7(p0 r100, MonitorMessageSendCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "messageParams");
        this.f426202b.a7(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void ac(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        this.f426202b.ac(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void e8(com.ss.android.lark.im.sdk.service.b r100, IGetDataCallback<List<MessageInfo>> r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426202b.e8(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void f1(String r100, SendStatus r101) {
        Intrinsics.checkNotNullParameter(r100, "cId");
        Intrinsics.checkNotNullParameter(r101, "sendStatus");
        this.f426202b.f1(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final ChatMessageResponse fd(String r100, List<Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "positions");
        return this.f426202b.fd(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void ib(MessageParams r100, MonitorMessageSendCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "messageParams");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426202b.ib(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Map<String, Message> ie(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "ids");
        return this.f426202b.ie(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void j6(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.f426202b.j6(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void k7(List<String> r100, IGetDataCallback<Map<String, Message>> r101) {
        Intrinsics.checkNotNullParameter(r100, "ids");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426202b.k7(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void l9(Message.b r100, IGetDataCallback<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426202b.l9(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void m5(Message r100, boolean r101, MessageFoldDetail r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f426202b.m5(r100, r101, r102);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void mb(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cId");
        this.f426202b.mb(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final MessageInfo p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        return this.f426202b.p(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void p2(Message.b r100, IGetDataCallback<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426202b.p2(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void sendImages(String r100, List<String> r101, boolean r102, IGetDataCallback<String> r103) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "imagePaths");
        this.f426202b.sendImages(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void sendMessage(MessageParams<?, ?> r100, IGetDataCallback<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "messageParams");
        this.f426202b.sendMessage(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Map<String, Message> ta(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "ids");
        return this.f426202b.ta(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final ChatMessageResponse x2(com.ss.android.lark.im.sdk.service.a r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        return this.f426202b.x2(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void yb(z r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f426202b.yb(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Message za(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        return this.f426202b.za(r100);
    }

    public c(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<p> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), p.class), p.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f426202b = r103.b();
        this.f426203c = r101;
        this.f426204d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        Log.i("ImSdkMessageServiceProxy", "preparing");
        v r102 = this.f426203c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        p r104 = (p) k.b(r102.c(r103), p.class);
        this.f426204d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
