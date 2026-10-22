package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.base.view.vo.message.ShareGroupChatContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.preview.components.view.TailDrawableTextView;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public class ShareGroupChatContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f412940h = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412941g;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f412942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f412943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TailDrawableTextView f412944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f412945d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final UDButton f412946e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f412947f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final View f412948g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final View f412949h;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412942a;
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412942a = r100;
            ImageView r101 = (ImageView) r100.findViewById(R.id.iv_avator);
            this.f412943b = r101;
            TailDrawableTextView r102 = (TailDrawableTextView) r100.findViewById(R.id.tv_group_chat_title);
            this.f412944c = r102;
            TextView r103 = (TextView) r100.findViewById(R.id.tv_group_chat_description);
            this.f412945d = r103;
            UDButton r104 = (UDButton) r100.findViewById(R.id.bt_group_chat_join);
            this.f412946e = r104;
            TextView r105 = (TextView) r100.findViewById(R.id.group_card_tv);
            this.f412947f = r105;
            this.f412948g = r100.findViewById(R.id.top_part_layout);
            this.f412949h = r100.findViewById(R.id.group_chat_content_root);
            zz7.a.a(r101, 40);
            zz7.a.d(r102, LarkFont.HEADLINE);
            zz7.a.d(r103, LarkFont.CAPTION0);
            LarkFont r106 = LarkFont.BODY1;
            zz7.a.d(r104, r106);
            zz7.a.d(r105, r106);
            ViewGroup.LayoutParams r107 = r104.getLayoutParams();
            r107.height = zz7.b.g(r104.getContext(), 28);
            r104.setLayoutParams(r107);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f412950a;

        public c(b r100) {
            this.f412950a = r100;
        }

        public final void a() {
            float r100 = Layout.getDesiredWidth(this.f412950a.f412947f.getText().toString(), 0, this.f412950a.f412947f.getText().length(), this.f412950a.f412947f.getPaint());
            float r101 = UIUtils.dp2px(this.f412950a.f412942a.getContext(), 26.0f);
            b r102 = this.f412950a;
            r102.f412946e.setMaxWidth((int) ((r102.f412942a.getWidth() - r100) - r101));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareGroupChatContentBlock f412951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.a<?> f412952b;

        public d(ShareGroupChatContentBlock r100, y6b.a<?> r101) {
            this.f412951a = r100;
            this.f412952b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            w4b.g r101 = ChatCoreModule.a().getChatDependency();
            m2b.a r102 = this.f412951a.f412673c;
            y6b.a<?> r103 = this.f412952b;
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.AbsMessageVO<com.ss.android.lark.chat.base.view.vo.message.ShareGroupChatContentVO>");
            r101.k(r102, r103);
        }
    }

    public static final class e implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> f412953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ShareGroupChatContentBlock f412954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y6b.a<?> f412955c;

        public e(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, ShareGroupChatContentBlock r101, y6b.a<?> r102) {
            this.f412953a = r100;
            this.f412954b = r101;
            this.f412955c = r102;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            com.ss.android.lark.blueprint.m<y6b.a<?>> r101 = this.f412953a;
            if ((r101 instanceof e6b.b) == false) goto L5;
            e6b.b r102 = (e6b.b) r101;
        L6:
            if (r102 != null) goto L10;
            return false;
        L10:
            return r102.e(this.f412954b, this.f412955c);
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
        f412940h = UIHelper.dp2px(8.0f);
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412941g;
    }

    public ShareGroupChatContentBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412941g = IMMessageKeys$Blocks.SHARE_GROUP_CHAT_CONTENT;
    }

    public final void h(b r110, Chat r111) {
        Intrinsics.checkNotNullParameter(r110, "blockView");
        Intrinsics.checkNotNullParameter(r111, "chat");
        String r100 = StringsKt.trim(r111.getName()).toString();
        TailDrawableTextView r112 = r110.f412944c;
        r112.setTailContent("…");
        Context r101 = r112.getContext();
        Intrinsics.checkNotNullParameter(r111, "chat");
        int r102 = LarkNameTag.f284333d;
        LarkNameTag.d r103 = LarkNameTag.f.a(this.f412671a.getContext());
        if (r111.isCrossWithKa() == false) goto L5;
        r103.f284345f = true;
        com.larksuite.component.ui.tag.d r113 = r103.f().b();
    L13:
        if (r113 == null) goto L15;
        ncc.g r104 = new ncc.g();
        r104.a(r100);
        Intrinsics.checkNotNull(r101);
        int r105 = r113.getIntrinsicWidth();
        int r106 = r113.getIntrinsicHeight();
        int r107 = f412940h;
        r104.b("$", new com.ss.android.lark.chat.preview.components.view.a(r101, r105, r106, r107, r113, null), 33);
        r112.f416154d = r113;
        r112.f416155e = r107;
        r112.f416156f = 0;
        r112.f416157g = false;
        r112.setText(r104);
        return;
    L15:
        r112.f416154d = null;
        r112.f416155e = 0;
        r112.f416156f = 0;
        r112.f416157g = false;
        r112.setText(r100);
        return;
    L5:
        Context r108 = this.f412671a.getContext();
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        LarkNameTag.e r109 = new LarkNameTag.e(r108);
        TagData r114 = r111.getTagData();
        if (r114 == null) goto L11;
        TagData.Companion.getClass();
        List r115 = TagData.a.b(r114);
        if (CollectionUtils.isEmpty(r115) == false) goto L10;
        r109.g(r115);
    L12:
        r113 = r109.f().b();
        goto L13
    L10:
        r109.g(((ArrayList) r115).subList(0, 1));
        goto L12
    L11:
        r109.f284344e = r111.isCrossTenant();
        goto L12
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r210, com.ss.android.lark.blueprint.q<y6b.a<?>> r211, y6b.a<?> r212) {
        Intrinsics.checkNotNullParameter(r210, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r211, "layout");
        Intrinsics.checkNotNullParameter(r212, "data");
        b r100 = (b) r211.c(this.f412941g, IMMessageKeys$Slots.CONTENT, ShareGroupChatContentBlock$update$blockView$1.INSTANCE);
        Object r101 = r212.b();
        if ((r101 instanceof ShareGroupChatContentVO) == false) goto L5;
        ShareGroupChatContentVO r102 = (ShareGroupChatContentVO) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        Chat r103 = (Chat) r102.f411928b.getValue();
        if (r103 != null) goto L11;
        return;
    L11:
        r100.f412949h.getLayoutParams().width = -1;
        r100.f412949h.setBackground(null);
        String r110 = r103.getAvatarKey();
        String r111 = r103.getEntityId();
        if (r103.isSecret() == false) goto L16;
        Scene r104 = Scene.SecretChat;
    L19:
        com.ss.android.lark.chat.utils.g.e(this.f412671a.getContext(), r100.f412943b, r110, r111, UIHelper.dp2px(40.0f), UIHelper.dp2px(40.0f), r104);
        String r105 = r103.getDescription();
        boolean r112 = true;
        if (TextUtils.isEmpty(r105) == false) goto L22;
        r100.f412944c.setMaxLines(2);
        r100.f412945d.setVisibility(8);
    L23:
        r100.f412942a.post(new c(r100));
        h(r100, r103);
        final Message r106 = new Message();
        r106.setType(r212.getType());
        r106.setMessageContent(r102.f553338a);
        r106.setId(r212.getId());
        IChatService r107 = com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.f412673c).j0();
        Context r113 = this.f412671a.getContext();
        UDButton r108 = r100.f412946e;
        TextView r109 = r100.f412947f;
        final d r114 = new d(this, r212);
        ShareGroupChatContent r115 = (ShareGroupChatContent) r106.getContent();
        r115.getExpireTime();
        String r213 = r115.getJoinToken();
        final Chat r116 = r115.getChat();
        boolean r117 = r107.checkLoginUserExistedInLocalChat(r116);
        if (r115.getJoinChatErrState() != null) goto L26;
        ShareGroupChatContent.GroupState r118 = ShareGroupChatContent.GroupState.CAN_JOIN_DIRECTLY;
    L27:
        if (r117 == false) goto L31;
        MessageHitPoint.b(r116, true);
        ShareGroupChatContent.GroupState r119 = ShareGroupChatContent.GroupState.ALREADY_IN_GROUP;
        r108.setOnClickListener(new com.ss.android.lark.share_group.n(r116, r106, r113, r114));
    L29:
        ShareGroupChatContent.GroupState r120 = r119;
    L48:
        com.ss.android.lark.share_group.q.c(r120, r108, r109);
        com.ss.android.lark.share_group.q.a(this.f412671a.getContext(), r107, r100.f412948g, r106);
        e r121 = new e(r210, this, r212);
        r100.f412948g.setOnLongClickListener(r121);
        r100.f412949h.setOnLongClickListener(r121);
        r100.f412949h.setBackground(null);
        r100.f412949h.setPadding(0, 0, 0, 0);
        return;
    L31:
        if (r118 == ShareGroupChatContent.GroupState.CAN_JOIN_DIRECTLY) goto L33;
        r108.setOnClickListener(new com.ss.android.lark.share_group.k(r116, r106, r114));
    L47:
        r120 = r118;
        goto L48
    L33:
        ShareGroupChatContent r122 = (ShareGroupChatContent) r106.getContent();
        if (r122 != null) goto L36;
    L44:
        if (r112 == false) goto L46;
        r119 = ShareGroupChatContent.GroupState.SHARE_EXPIRED;
        r108.setOnClickListener(new com.ss.android.lark.share_group.o(r116, r106, r114));
        goto L29
    L46:
        r108.setOnClickListener(new com.ss.android.lark.share_group.p(r114, r113, r116, r107, r108, r109, r115, r106, r213));
        goto L47
    L36:
        if (r122.getChat() == null) goto L44;
        long r123 = r122.getExpireTime();
        if (TextUtils.isEmpty(r122.getJoinToken()) == true) goto L44;
        if ((r123 * 1000) <= System.currentTimeMillis()) goto L44;
        r112 = false;
        goto L44
    L26:
        r118 = r115.getJoinChatErrState();
        goto L27
    L22:
        r100.f412944c.setMaxLines(1);
        r100.f412945d.setVisibility(0);
        r100.f412945d.setText(r105);
        goto L23
    L16:
        if (r103.isThread() == false) goto L18;
        r104 = Scene.Thread;
        goto L19
    L18:
        r104 = Scene.Chat;
        goto L19
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
