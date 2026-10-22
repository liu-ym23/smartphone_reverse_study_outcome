package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowMessageList;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponentInner;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {

    public static final class a implements ChatWindowMessageList.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMessageListComponent f422779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f422780b;

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowMessageList.a
        public final void b() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowMessageList.a
        public final void a() {
            s2b.d r100 = this.f422779a.W2();
            b r101 = new b(this.f422779a);
            if (r100 == null) goto L24;
            IMessageListComponent r102 = this.f422779a;
            v r103 = null;
            if ((r102 instanceof IMessageListComponentInner) == false) goto L7;
            IMessageListComponentInner r104 = (IMessageListComponentInner) r102;
        L8:
            if (r104 == null) goto L10;
            a4b.b r105 = r104.Hq();
        L11:
            IMessageListComponent r106 = this.f422779a;
            if ((r106 instanceof IMessageListComponentInner) == false) goto L14;
            IMessageListComponentInner r107 = (IMessageListComponentInner) r106;
        L15:
            if (r107 == null) goto L17;
            a4b.b r108 = r107.Hq();
        L18:
            com.ss.android.lark.coremd.clickcompat.c.a r109 = new com.ss.android.lark.coremd.clickcompat.c.a(r105, r108);
            v r110 = this.f422780b.f412316d;
            if (r110 == null) goto L21;
            r103 = r110;
        L22:
            r100.h0(MapsKt.mapOf(TuplesKt.to(com.ss.android.lark.coremd.clickcompat.c.class, new com.ss.android.lark.flow.chat.coremd.clickcompat.a(r100, r101, r109, r103))));
            return;
        L21:
            Intrinsics.throwUninitializedPropertyAccessException("chatContainer");
            goto L22
        L17:
            r108 = null;
            goto L18
        L14:
            r107 = null;
            goto L15
        L10:
            r105 = null;
            goto L11
        L7:
            r104 = null;
            goto L8
        }

        public a(IMessageListComponent r100, g r101) {
            this.f422779a = r100;
            this.f422780b = r101;
        }
    }

    public static final class b implements com.ss.android.lark.coremd.clickcompat.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMessageListComponent f422781a;

        public b(IMessageListComponent r100) {
            this.f422781a = r100;
        }

        @Override // com.ss.android.lark.coremd.clickcompat.c.b
        public final y6b.a<?> getMessageById(String r100) {
            Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
            Iterator<T> r101 = this.f422781a.Oq().iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            Object r102 = r101.next();
            if (Intrinsics.areEqual(((y6b.c) r102).f566482c, r100) == false) goto L4;
        L10:
            return (y6b.a) r102;
        L8:
            r102 = null;
            goto L10
        }
    }

    public g() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        super.C(r100, r101);
        IMessageListComponent r102 = (IMessageListComponent) r100.a(IMessageListComponent.class);
        if (r102 == null) goto L6;
        r102.hg(new a(r102, this));
        return;
    }
}
