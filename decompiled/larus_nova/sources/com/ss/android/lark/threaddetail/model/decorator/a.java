package com.ss.android.lark.threaddetail.model.decorator;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.RomUtils;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.g;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutRenderConfigs;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chatbase.i;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremdbiz.facade.p;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements i<MessageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC5314a f441309a;

    /* JADX INFO: renamed from: com.ss.android.lark.threaddetail.model.decorator.a$a, reason: collision with other inner class name */
    public interface InterfaceC5314a {
        m2b.a a();

        z2b.a b();

        int c(boolean r100);

        boolean d();

        ThreadTopic e();

        Chat getChat();

        int getContainerWidth();

        Context getContext();
    }

    public a(com.ss.android.lark.threaddetail.model.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f441309a = r100;
    }

    @Override // com.ss.android.lark.chatbase.i
    public final void a(f5b.b r110) {
        final MessageInfo r111 = (MessageInfo) r110;
        Intrinsics.checkNotNullParameter(r111, "messageInfo");
        if (this.f441309a.d() == false) goto L50;
        m2b.a r100 = this.f441309a.a();
        if (r100 == null) goto L51;
        w2b.b r101 = new w2b.b();
        r101.c(this.f441309a.b());
        r101.f558084b.f412464a = false;
        r101.f558085c.f412464a = false;
        Chat r102 = this.f441309a.getChat();
        ThreadTopic r103 = this.f441309a.e();
        boolean r104 = r102.isSuper();
        if (r111.getMessage().getType() != Message.Type.TEXT) goto L11;
    L12:
        BaseTextContent r105 = (BaseTextContent) r111.getMessage().getContent();
        boolean r106 = TextUtils.equals(r103.getId(), r111.getId());
        ValidateIMFileResult r107 = r111.getMessage().getValidateIMFileResult();
        String r108 = null;
        RichText r109 = null;
        if (r107 == null) goto L15;
        IMFileResult r112 = r107.getResultType();
    L16:
        MessagePermissionUtil.ReceiveAuthorizationState r113 = MessagePermissionUtil.h(r112);
        final ValidateResult r114 = MessagePermissionUtil.b();
        final boolean r115 = MessagePermissionUtil.c(r111.getMessage(), r102, r114);
        int r116 = TextLayoutRender.f412443j;
        if (TextLayoutRender.c.a() == false) goto L29;
        RichText r117 = r105.getRichText();
        com.ss.android.lark.coremd.base.parse.b r118 = com.ss.android.lark.coremd.base.parse.c.a(IMContextExtend.A, new ThreadDetailMessageDecorator$decorate$permissionApply$1(r114, r115, r111));
        if (r117 == null) goto L21;
        int r119 = g.f412476a;
        n r120 = g.a(r117, TextLayoutRenderConfigs.c(r100, r111, false));
        r120.a(r120.f412532f.b(r118));
        b(r101, r117, r120);
    L21:
        TranslateInfo r121 = r111.getTranslateInfo();
        if (r121 == null) goto L24;
        BaseTextContent r122 = (BaseTextContent) r121.getTranslateContent();
    L25:
        if (r122 == null) goto L27;
        r109 = r122.getRichText();
    L27:
        if (r109 == null) goto L46;
        int r123 = g.f412476a;
        n r124 = g.a(r109, TextLayoutRenderConfigs.c(r100, r111, true));
        r124.a(r124.f412532f.b(r118));
        b(r101, r109, r124);
        return;
    L46:
        return;
    L24:
        r122 = null;
        goto L25
    L29:
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r125 = new com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b();
        r125.f412431x = this.f441309a.c(r106);
        r125.f412423p = r111.getId();
        r125.a(r114);
        ChatChatter r126 = r111.getMessageSender();
        if (r126 == null) goto L32;
        String r127 = r126.getTenantId();
    L33:
        r125.f412424q = r127;
        r125.f412422o = r115;
        Intrinsics.checkNotNullParameter(r113, "receiveAuthorizationState");
        r125.B = r113;
        r125.C = r111.getMessage().getValidateIMFileResult();
        r125.G = new b(this);
        Layout r128 = TextLayoutRenderExtKt.c(r101, r111, r125, this.f441309a.getContext());
        int r129 = com.ss.android.lark.widget.light.g.f446038a;
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.richtext.textlayoutrender") == true) goto L37;
        r105.setContentLayout(r128);
    L37:
        if (r111.getTranslateInfo() == null) goto L48;
        BaseTextContent r130 = (BaseTextContent) r111.getTranslateInfo().getTranslateContent();
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r131 = new com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b();
        r131.f412418k = true;
        r131.f412415h = r104;
        Intrinsics.checkNotNullParameter(r114, "previewValidateResult");
        r131.f412421n = r114;
        r131.f412422o = r115;
        r131.f412423p = r111.getId();
        ChatChatter r132 = r111.getMessageSender();
        if (r132 == null) goto L41;
        r108 = r132.getTenantId();
    L41:
        r131.f412424q = r108;
        r131.f412431x = this.f441309a.c(r106);
        Intrinsics.checkNotNullParameter(r113, "receiveAuthorizationState");
        r131.B = r113;
        r131.C = r111.getMessage().getValidateIMFileResult();
        r131.G = new c(this);
        Layout r133 = TextLayoutRenderExtKt.c(r101, r111, r131, this.f441309a.getContext());
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.richtext.textlayoutrender") == true) goto L49;
        r130.setContentLayout(r133);
        return;
    L49:
        return;
    L48:
        return;
    L32:
        r127 = null;
        goto L33
    L15:
        r112 = null;
        goto L16
    L11:
        if (r111.getMessage().getType() == Message.Type.POST) goto L12;
        return;
    L51:
        return;
    }

    public final void b(w2b.b r100, RichText r101, n r102) {
        m2b.a r103 = this.f441309a.a();
        if (p.a() == false) goto L18;
        if (r103 == null) goto L18;
        if (r103.Y() == false) goto L18;
        if (r103.b0() == true) goto L18;
        int r104 = com.ss.android.lark.chat.chatwindow.chat.model.preload.a.f413368a;
        if (Build.VERSION.SDK_INT == 31) goto L12;
        boolean r105 = false;
    L13:
        if (r105 == true) goto L18;
        if (g.b(r101) == false) goto L18;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new d(r100, r101, r102));
        return;
    L12:
        r105 = RomUtils.g();
    L18:
        if (TextLayoutRenderExtKt.b(r101, r102) == true) goto L22;
        TextLayoutRenderExtKt.f(r100, r101, r102);
        return;
    }
}
