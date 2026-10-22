package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.messengesender.IMessageSenderComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.MessageListDecorationController;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.message.menu.v2.MessageActionPanelManager$keyboardEventCenterHandler$2;
import com.ss.android.lark.scaffold.IComponent;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements l3c.c {

    public interface a {
        <T extends IComponent> T a(Class<T> r100);
    }

    public static final class b implements IMessageListComponent.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IKeyboardComponent f413691a;

        public final void c() {
            this.f413691a.Xm();
        }

        public final Integer d() {
            View r100 = this.f413691a.getContainerView();
            if (r100 != null) goto L7;
            return null;
        L7:
            return Integer.valueOf(r100.getHeight());
        }

        public final int e() {
            return this.f413691a.UJ();
        }

        public final boolean g() {
            return this.f413691a.gI();
        }

        public final boolean h() {
            return this.f413691a.Hx();
        }

        public b(IKeyboardComponent r100) {
            Intrinsics.checkNotNullParameter(r100, "keyboardComponent");
            this.f413691a = r100;
        }

        public final void b(MessageActionPanelManager$keyboardEventCenterHandler$2.a r100) {
            Intrinsics.checkNotNullParameter(r100, "handler");
            this.f413691a.lD(r100);
        }

        public final void i(y6b.a<? extends v5b.a<?>> r100) {
            Intrinsics.checkNotNullParameter(r100, "messageVO");
            this.f413691a.K6(r100);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.f
        public final void a(MessageInfo r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "messageInfo");
            this.f413691a.oN(r100);
        }

        public final boolean f(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "chatterId");
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "chatterOriginName");
            return this.f413691a.m10(r100, r101, r102);
        }

        public final void j(MessageInfo r100, int r110, PartialReplyInfo r111) {
            Intrinsics.checkNotNullParameter(r100, "messageInfo");
            IKeyboardComponent.CC.onReplyMessage$default(this.f413691a, r100, r110, r111, null, 8, null);
        }

        public final void k(String r100, String r101, RichText r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            Intrinsics.checkNotNullParameter(r101, "title");
            Intrinsics.checkNotNullParameter(r102, "content");
            this.f413691a.P3(r100, r101, r102, r103);
        }
    }

    public static final class c implements IBannerComponent.a, ITitlebarComponent.b, ITitlebarComponent.f, ITitlebarComponent.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IMessageListComponent f413692a;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void c() {
            this.f413692a.cN(new MessageListDecorationController.c(MessageListDecorationController.Scene.SCENE_BANNER, new MessageListDecorationController.d(0, 14)));
        }

        public c(IMessageListComponent r100) {
            Intrinsics.checkNotNullParameter(r100, "messageListComponent");
            this.f413692a = r100;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void a(int r100) {
            this.f413692a.cN(new MessageListDecorationController.c(MessageListDecorationController.Scene.SCENE_BANNER, new MessageListDecorationController.d(Integer.valueOf(r100), 14)));
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void b(int r100) {
            this.f413692a.cN(new MessageListDecorationController.c(MessageListDecorationController.Scene.SCENE_BANNER, new MessageListDecorationController.d(Integer.valueOf(r100), 14)));
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d$d, reason: collision with other inner class name */
    public static final class C4824d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l3c.f f413693a;

        public C4824d(l3c.f r100) {
            this.f413693a = r100;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.a
        public final <T extends IComponent> T a(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "clz");
            return (T) this.f413693a.a(r100);
        }

        public final <T extends l3c.g> T b(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "clz");
            return (T) this.f413693a.b(r100);
        }
    }

    public d() {
    }

    @Override // l3c.c
    public final void a(l3c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "rt");
        C4824d r101 = new C4824d(r100);
        Intrinsics.checkNotNullParameter(r101, "dependency");
        IMessageListComponent r102 = (IMessageListComponent) r101.a(IMessageListComponent.class);
        if (r102 == null) goto L17;
        IMessageSenderComponent r103 = (IMessageSenderComponent) r101.a(IMessageSenderComponent.class);
        ChatWindowOpenViewModel r104 = (ChatWindowOpenViewModel) r101.b(ChatWindowOpenViewModel.class);
        r102.IB(new g(r103, r101));
        if (r104 == null) goto L8;
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(r104.getChat(), r102, new h(r101, r102));
    L8:
        if (r104 == null) goto L15;
        MutableLiveData<Chat> r105 = r104.getChat();
        if (r105 == null) goto L15;
        Chat r106 = r105.getValue();
        if (r106 == null) goto L15;
        if (r103 == null) goto L15;
        r103.updateChat(r106);
    L15:
        r102.m(new i(r103, r104));
        return;
    }
}
