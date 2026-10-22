package com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender;

import android.net.Uri;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.keva.KevaImpl;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.biz.im.api.g0;
import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.chat.chatwindow.chat.data.content.MessageContentResolver;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.sticker.StickerFileInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.richtext.RichText;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import m5b.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0014J\"\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012H\u0016J\f\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0006\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/messagesender/MessageSenderComponent;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/messagesender/BaseMessageSenderComponent;", KtvSubElement.CONTAINER, "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "isEnableInterceptMixMessage", "", "()Z", "isEnableInterceptMixMessage$delegate", "Lkotlin/Lazy;", "getMessageContentResolver", "Lcom/ss/android/lark/chat/chatwindow/chat/data/content/MessageContentResolver;", "onQuasiMessageSendStart", "", "cId", "", "messageParams", "Lcom/ss/android/lark/chat/entity/message/MessageParams;", "getMessageSender", "Lcom/ss/android/lark/chat/chatwindow/keyboard/KeyboardMessageSender;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/model/IMessageSender;", "GuardMessageSender", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MessageSenderComponent extends BaseMessageSenderComponent {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f414345r = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f414346q;

    public static final class a implements q4b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q4b.a f414347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Chat> f414348b;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.MessageSenderComponent$a$a, reason: collision with other inner class name */
        public static final class C4837a {
        }

        static {
        }

        @Override // m5b.a
        public final String m() {
            return this.f414347a.m();
        }

        public final boolean v() {
            String r100 = null;
            Chat r101 = this.f414348b.invoke();     // Catch: Exception -> L5
        L7:
            String r102 = this.f414347a.m();
            if (r101 == null) goto L14;
            if (Intrinsics.areEqual(r102, r101.getId()) == false) goto L14;
            return true;
        L14:
            if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication()) == false) goto L20;
            StringBuilder r103 = new StringBuilder("Send message with wrong chat! send message chat id: ");
            r103.append(r102);
            r103.append(", current chat id: ");
            if (r101 == null) goto L18;
            r100 = r101.getId();
        L18:
            r103.append(r100);
            throw new IllegalStateException(r103.toString());
        L20:
            StringBuilder r104 = new StringBuilder("chat not match, cancel sending message. send message chat id: ");
            r104.append(r102);
            r104.append(", current chat id: ");
            if (r101 == null) goto L23;
            r100 = r101.getId();
        L23:
            r104.append(r100);
            Log.e("GuardMessageSender", r104.toString());
            JSONObject r105 = new JSONObject();
            r105.put("send_message_chat_id", m());
            if (r101 == null) goto L27;
            String r106 = r101.getId();
            if (r106 == null) goto L27;
        L28:
            r105.put("current_chat_id", r106);
            Statistics.sendEvent("im_send_message_chat_not_match", r105);
            return false;
        L27:
            r106 = "";
        L5:
            e = move-exception;
            Log.e("GuardMessageSender", "fail to get current chat, illegal state", e);
            r101 = null;
            goto L7
        }

        @Override // m5b.b
        public final Message a(d r100) {
            if (v() == true) goto L7;
            return null;
        L7:
            return this.f414347a.a(r100);
        }

        @Override // m5b.b
        public final void b(d r100) {
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.b(r100);
        }

        @Override // m5b.a
        public final void c(g0 r100) {
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.c(r100);
        }

        @Override // m5b.b
        public final void g(d r100) {
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.g(r100);
        }

        @Override // q4b.a
        public final void i(List<? extends File> r100) {
            Intrinsics.checkNotNullParameter(r100, KevaImpl.PrivateConstants.FILES_DIR_NAME);
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.i(r100);
        }

        @Override // m5b.b
        public final void j(d r100) {
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.j(r100);
        }

        @Override // m5b.b
        public final void l(d r100) {
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.l(r100);
        }

        @Override // m5b.b
        public final void n(d r100) {
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.n(r100);
        }

        @Override // m5b.b
        public final void p(d r100) {
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.p(r100);
        }

        @Override // q4b.a
        public final void q(List<? extends Uri> r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.q(r100);
        }

        @Override // m5b.a
        public final void s(g0 r100) {
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.s(r100);
        }

        public a(j4b.a r100, Function0 r101) {
            Intrinsics.checkNotNullParameter(r100, "real");
            Intrinsics.checkNotNullParameter(r101, "provideCurrentChat");
            this.f414347a = r100;
            this.f414348b = r101;
        }

        @Override // m5b.a
        public final void d(String r100, String r101, RichText r102) {
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.d(r100, r101, r102);
        }

        @Override // m5b.a
        public final void k(String r100, String r101, RichText r102) {
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.k(r100, r101, r102);
        }

        @Override // q4b.a
        public final void r(StickerFileInfo r100, String r101, String r102, PartialReplyInfo r103) {
            Intrinsics.checkNotNullParameter(r100, "stickerFileInfo");
            Intrinsics.checkNotNullParameter(r101, "rootMsgId");
            Intrinsics.checkNotNullParameter(r102, "parentMsgId");
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.r(r100, r101, r102, r103);
        }

        @Override // m5b.a
        public final void u(String r100, String r101, RichText r102, boolean r103) {
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.u(r100, r101, r102, r103);
        }

        @Override // q4b.a
        public final Message e(String r100, String r101, String r102, String r110, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r111) {
            Intrinsics.checkNotNullParameter(r100, "rootMsgId");
            Intrinsics.checkNotNullParameter(r101, "parentMsgId");
            Intrinsics.checkNotNullParameter(r102, "fileName");
            Intrinsics.checkNotNullParameter(r110, "cid");
            if (v() == true) goto L7;
            return null;
        L7:
            return this.f414347a.e(r100, r101, r102, r110, r111);
        }

        @Override // q4b.a
        public final void h(List<? extends Photo> r100, String r101, String r110, int r111, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r112) {
            Intrinsics.checkNotNullParameter(r100, "photos");
            Intrinsics.checkNotNullParameter(r101, "rootMsgId");
            Intrinsics.checkNotNullParameter(r110, "parentMsgId");
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.h(r100, r101, r110, r111, r112);
        }

        @Override // q4b.a
        public final void f(List<String> r110, boolean r111, String r112, String r113, int r114, String r115, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r116) {
            Intrinsics.checkNotNullParameter(r110, "photos");
            Intrinsics.checkNotNullParameter(r112, "rootMsgId");
            Intrinsics.checkNotNullParameter(r113, "parentMsgId");
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.f(r110, r111, r112, r113, r114, r115, r116);
        }

        @Override // m5b.c
        public final void o(String r100, String r110, RichText r111, boolean r112, PartialReplyInfo r113, boolean r114, boolean r115) {
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.o(r100, r110, r111, r112, r113, r114, false);
        }

        @Override // m5b.a
        public final void t(String r110, String r111, RichText r112, String r113, String r114, Boolean r115, PartialReplyInfo r116, boolean r117) {
            if (v() == true) goto L5;
            return;
        L5:
            this.f414347a.t(r110, r111, r112, r113, r114, r115, r116, r117);
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.BaseMessageSenderComponent, com.ss.android.lark.chat.chatwindow.biz.component.messengesender.IMessageSenderComponent
    public final q4b.a getMessageSender() {
        if (((Boolean) this.f414346q.getValue()).booleanValue() == false) goto L7;
        return new a((j4b.a) this.f414337n.getValue(), new AnonymousClass1(this));
    L7:
        return (j4b.a) this.f414337n.getValue();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.BaseMessageSenderComponent
    public final MessageContentResolver E0() {
        return com.ss.android.lark.chat.chatwindow.chat.data.content.a.f412391b;
    }

    public MessageSenderComponent(final v r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        super(r100);
        this.f414346q = LazyKt.lazy(new MessageSenderComponent$isEnableInterceptMixMessage$2(r100));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.BaseMessageSenderComponent, j4b.a.d
    public void g(String r100, MessageParams<?, ?> r101) {
        Intrinsics.checkNotNullParameter(r101, "messageParams");
        Intrinsics.checkNotNullParameter(r101, "messageParams");
        if ((r101 instanceof j1) == false) goto L6;
        RichText r102 = ((j1) r101).A;
    L10:
        if (r101.f415263v == false) goto L12;
    L14:
        this.f414335l.p0().a(r101.f415245d, r101.f415244c);
        return;
    L12:
        if (com.ss.android.lark.widget.richtext.d.f(r102, false).isEmpty() == false) goto L14;
        return;
    L6:
        if ((r101 instanceof kya.a) == false) goto L8;
        r102 = ((kya.a) r101).B;
        goto L10
    L8:
        r102 = null;
        goto L10
    }
}
