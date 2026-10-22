package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.lark.pb.basic.v1.File;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.TextClickListenerProviderV2;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatTnsInfo;
import com.ss.android.lark.chat.entity.chat.ChatTnsOpKind;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.c1;
import com.ss.android.lark.chatbase.view.TextChatView2;
import com.ss.android.lark.chatwindow.view.widget.TouchInterceptionLayout;
import com.ss.android.lark.widget.light.LKUILightTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class TextContentBlock implements com.ss.android.lark.blueprint.i<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>, com.ss.android.lark.chat.base.view.vo.message.e>, e6b.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e6b.c f412983j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f412984k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.blueprint.g f412985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f412987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f412988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f412989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f412990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f412991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<com.ss.android.lark.blueprint.j> f412992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f412993i;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f412994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextChatView2 f412995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TouchInterceptionLayout f412996c;

        public final TextChatView2 a() {
            TextChatView2 r100 = this.f412995b;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("textChatView");
            return null;
        }

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412994a;
        }

        public b(TouchInterceptionLayout r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412994a = r100;
        }
    }

    public static final class c implements com.ss.android.lark.blueprint.k<View>, e9c.a, com.ss.android.lark.blueprint.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f412997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextChatView2 f412998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f412999c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f413000d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Group f413001e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f413002f;

        public static final class a implements StackSlot.a, StackSlot.b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ StackSlot.a.C4807a.C4808a f413003b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final StackSlot.b.a f413004c;

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final /* synthetic */ void a() {
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.a
            public final void c() {
                this.f413003b.getClass();
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final /* synthetic */ void f() {
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final /* synthetic */ void g() {
            }

            public a() {
                StackSlot.a.f413325a.getClass();
                this.f413003b = StackSlot.a.C4807a.f413327b;
                this.f413004c = new StackSlot.b.a(0);
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final StackSlot.b.a b() {
                return this.f413004c;
            }
        }

        @Override // com.ss.android.lark.blueprint.t
        public final com.ss.android.lark.blueprint.s a() {
            return this.f413002f;
        }

        @Override // e9c.a
        public final TextView d() {
            return this.f412999c;
        }

        @Override // e9c.a
        public final ImageView e() {
            return this.f413000d;
        }

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412997a;
        }

        public c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412997a = r100;
            this.f412998b = (TextChatView2) r100.findViewById(R.id.translate_content);
            this.f412999c = (TextView) r100.findViewById(R.id.translation_feedback_tv);
            this.f413000d = (ImageView) r100.findViewById(R.id.translate_more_action);
            this.f413001e = (Group) r100.findViewById(R.id.divider_group);
            this.f413002f = new a();
        }
    }

    @Override // com.ss.android.lark.blueprint.i
    public final Class<com.ss.android.lark.chat.base.view.vo.message.e> b() {
        return null;
    }

    static {
        f412983j = new e6b.c(null);
        f412984k = View.generateViewId();
    }

    public final b3b.f f() {
        return (b3b.f) this.f412989e.getValue();
    }

    public final m2b.a g() {
        return (m2b.a) this.f412988d.getValue();
    }

    public final Context getContext() {
        return this.f412987c;
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412986b;
    }

    public TextContentBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f412985a = r100;
        IMMessageKeys$Blocks r101 = IMMessageKeys$Blocks.TEXT_CONTENT;
        this.f412986b = r101;
        this.f412987c = r100.getContext();
        this.f412988d = LazyKt.lazy(new TextContentBlock$chatContext$2(this));
        this.f412989e = LazyKt.lazy(new TextContentBlock$callbackHub$2(this));
        this.f412990f = LazyKt.lazy(new TextContentBlock$messageCellConfig$2(this));
        this.f412991g = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, TextContentBlock$mPhoneDependency$2.INSTANCE);
        this.f412992h = CollectionsKt.listOf(new com.ss.android.lark.blueprint.j[]{r101, f412983j});
        this.f412993i = LazyKt.lazy(new TextContentBlock$spanClickListener$2(this));
    }

    @Override // e6b.a
    public final e6b.a.C5748a e(com.ss.android.lark.blueprint.j r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return new e6b.a.C5748a(this.f412992h.indexOf(r100), this.f412992h.size());
    }

    public static final void d(TextContentBlock r100, TextChatView2 r101) {
        r100.getClass();
        r101.setTextSize(zz7.b.h(r101.getContext(), 17));
        r101.setShowMoreTextSize(zz7.b.h(r101.getContext(), 14));
    }

    @Override // com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r100, com.ss.android.lark.blueprint.q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        com.ss.android.lark.blueprint.k<?> r102 = r101.f(this.f412986b, IMMessageKeys$Slots.CONTENT);
        TextChatView2 r103 = null;
        if (r102 == null) goto L5;
        View r104 = r102.getView();
    L7:
        if ((r104 instanceof TextChatView2) == false) goto L9;
        r103 = (TextChatView2) r104;
    L9:
        if (r103 == null) goto L14;
        LKUILightTextView r105 = r103.getLightTextView();
        if (r105 == null) goto L15;
        r105.w();
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r104 = null;
        goto L7
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(final com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r210, com.ss.android.lark.blueprint.q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r211, final y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r212) {
        Intrinsics.checkNotNullParameter(r210, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r211, "layout");
        Intrinsics.checkNotNullParameter(r212, "data");
        if ((!r212.b().f().isEmpty()) == false) goto L5;
        boolean r100 = false;
    L6:
        e6b.c r110 = f412983j;
        if (r100 == false) goto L15;
        IMMessageKeys$Blocks r101 = IMMessageKeys$Blocks.TEXT_CONTENT;
        IMMessageKeys$Slots r102 = IMMessageKeys$Slots.CONTENT;
        com.ss.android.lark.blueprint.k<?> r103 = r211.f(r101, r102);
        if (r103 == null) goto L11;
        r103.getView().setVisibility(8);
    L11:
        com.ss.android.lark.blueprint.k<?> r104 = r211.f(r110, r102);
        if (r104 == null) goto L167;
        r104.getView().setVisibility(8);
        return;
    L167:
        return;
    L15:
        m2b.a r105 = g();
        com.ss.android.lark.chat.base.view.vo.message.e r106 = r212.b();
        Intrinsics.checkNotNullParameter(r105, "<this>");
        if ((r105.k() & 16) <= 0) goto L18;
        boolean r107 = true;
    L20:
        if (h7b.l.d(r106) == true) goto L23;
        if (r107 == false) goto L23;
        boolean r108 = true;
    L25:
        if (r106.f411956f != 3) goto L27;
        boolean r109 = true;
    L28:
        if (r108 == false) goto L32;
        if (r109 == true) goto L32;
        boolean r111 = false;
    L34:
        if (r108 == false) goto L37;
        if (r109 == false) goto L37;
        char r112 = 2;
    L41:
        if (r112 == 0) goto L47;
        if (r112 == 2) goto L47;
        com.ss.android.lark.blueprint.k<?> r113 = r211.f(IMMessageKeys$Blocks.TEXT_CONTENT, IMMessageKeys$Slots.CONTENT);
        if (r113 == null) goto L46;
        r113.getView().setVisibility(8);
    L46:
        String r213 = "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.message.callbacks.BaseTextMessageCellCallback";
        char r114 = r112;
        e6b.c r214 = r110;
        String r215 = MapController.ITEM_LAYER_TAG;
        y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r115 = r212;
        boolean r116 = true;
        int r117 = 8;
    L134:
        if (r114 != r116) goto L136;
    L140:
        c r118 = (c) r211.c(r214, IMMessageKeys$Slots.CONTENT, new TextContentBlock$renderTranslationText$blockView$1(this));
        r118.f412997a.setVisibility(0);
        r118.f413000d.setVisibility(0);
        Group r119 = r118.f413001e;
        if (r114 != 2) goto L143;
        int r120 = 0;
    L144:
        r119.setVisibility(r120);
        if (e9c.b.a(r118, r115, g()) == true) goto L148;
        com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r121 = r210;
    L165:
        m2b.a r122 = g();
        TextChatView2 r123 = r118.f412998b;
        BaseTextContentRender.c r124 = (BaseTextContentRender.c) this.f412993i.getValue();
        TextClickListenerProviderV2 r125 = new TextClickListenerProviderV2(g(), r118.f412998b, new k0(false, this, r121));
        b3b.f r126 = f();
        Intrinsics.checkNotNull(r126, r213);
        new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.e(r122, r212, r123, r124, r125, r126).g();
        return;
    L148:
        if (g().q8() == false) goto L152;
        if (g().e0() == true) goto L152;
    L157:
        UIUtils.disableAllParentClipChild(r118.f412999c);
        TextView r127 = r118.f412999c;
        b3b.f r128 = f();
        m2b.a r129 = g();
        Intrinsics.checkNotNullParameter(r115, r215);
        if (r127 == null) goto L160;
        r127.setOnClickListener(new e9c.c(r128, r115, r129));
    L160:
        TextView r130 = r118.f412999c;
        if (r130 == null) goto L163;
        y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r131 = r115;
        r121 = r210;
        r130.setOnLongClickListener(new l0(r121, this, r131));
    L164:
        e9c.b.c(r118.f413000d, f(), r131, g());
        goto L165
    L163:
        r131 = r115;
        r121 = r210;
    L152:
        if (e9c.b.f471540a == false) goto L157;
        TextView r132 = r118.f412999c;
        if (r132 == null) goto L156;
        r132.setVisibility(r117);
    L156:
        r118.f413000d.setVisibility(r117);
        goto L157
    L143:
        r120 = 8;
        goto L144
    L136:
        if (r114 == 2) goto L140;
        com.ss.android.lark.blueprint.k<?> r133 = r211.f(r214, IMMessageKeys$Slots.CONTENT);
        if (r133 == null) goto L168;
        r133.getView().setVisibility(r117);
        return;
    L168:
        return;
    L47:
        b r134 = (b) r211.c(IMMessageKeys$Blocks.TEXT_CONTENT, IMMessageKeys$Slots.CONTENT, new TextContentBlock$renderOriginText$view$1(this));
        r134.f412994a.setVisibility(0);
        com.ss.android.lark.biz.im.api.message.params.y r135 = (com.ss.android.lark.biz.im.api.message.params.y) g().d0(com.ss.android.lark.biz.im.api.message.params.y.class);
        if (r135 == null) goto L60;
        Integer r136 = r135.f410400e;
        if (r136 == null) goto L60;
        int r137 = r136.intValue();
        TextChatView2 r138 = (TextChatView2) r134.f412994a.findViewById(f412984k);
        if (r138 == null) goto L56;
        LKUILightTextView r139 = r138.getLightTextView();
        if (r139 == null) goto L56;
        r139.setGravity(r137);
    L56:
        if (r138 == null) goto L60;
        LKUILightTextView r140 = r138.getLightTextView();
        if (r140 == null) goto L60;
        r140.setMinimumHeight(UIUtils.dp2px(this.f412987c, 24.0f));
    L60:
        if (r135 == null) goto L85;
        com.ss.android.lark.biz.im.api.message.params.a0 r141 = r135.f410401f;
        if (r141 == null) goto L85;
        if ((r212 instanceof y6b.c) == false) goto L85;
        Chat r142 = g().getChat();
        if (r142 == null) goto L70;
        ChatTnsInfo r143 = r142.getChatTnsInfo();
        if (r143 == null) goto L70;
        ChatTnsOpKind r144 = r143.getTnsOpKind();
    L72:
        if (r144 != ChatTnsOpKind.TNS_OP_BANNED) goto L74;
        boolean r145 = true;
    L75:
        TextChatView2 r146 = r134.a();
        y6b.c r147 = (y6b.c) r212;
        if (r147.K2 == true) goto L78;
    L81:
        boolean r148 = false;
    L82:
        int r149 = r141.f410332a;
        float r150 = r141.f410333b;
        float r151 = r141.f410334c;
        LKUILightTextView r152 = r146.f416909a;
        if (r152 == null) goto L85;
        r152.setEnableUnderline(r148);
        r152.setUnderlineOffsetY(r151);
        r152.setUnderlineColor(r149);
        r152.setUnderlineWidth(r150);
        goto L85
    L78:
        if (r147.f566492i == false) goto L81;
        if (r145 == true) goto L81;
        r148 = true;
        goto L82
    L74:
        r145 = false;
    L70:
        r144 = null;
    L85:
        if (r135 == null) goto L91;
        Integer r153 = r135.f410404i;
        if (r153 == null) goto L91;
        int r154 = r153.intValue();
        LKUILightTextView r155 = r134.a().getLightTextView();
        if (r155 == null) goto L91;
        r155.setSelectedColor(UIUtils.getColor(this.f412987c, r154));
    L91:
        m2b.a r156 = g();
        TextChatView2 r157 = r134.a();
        BaseTextContentRender.c r158 = (BaseTextContentRender.c) this.f412993i.getValue();
        m2b.a r159 = g();
        char r160 = r112;
        TextChatView2 r161 = r134.a();
        if (r135 == null) goto L94;
        boolean r162 = r135.f410403h;
    L95:
        TextClickListenerProviderV2 r163 = new TextClickListenerProviderV2(r159, r161, new k0(r162, this, r210));
        b3b.f r164 = f();
        Intrinsics.checkNotNull(r164, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.message.callbacks.BaseTextMessageCellCallback");
        TouchInterceptionLayout r165 = r134.f412996c;
        if (r165 == null) goto L98;
        TouchInterceptionLayout r166 = r165;
    L99:
        r213 = "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.message.callbacks.BaseTextMessageCellCallback";
        new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.d(r156, r212, r157, r158, r163, r164, r166).g();
        ArrayList<File> r167 = r212.b().f();
        if ((!r167.isEmpty()) == false) goto L117;
        TextChatView2 r168 = r134.a();
        if (r168.f416916h != null) goto L104;
        View r169 = View.inflate(r168.getContext(), R.layout.chat_message_attachment_list, null);
        r168.f416915g = r169;
        r168.f416914f.addView(r169, new LinearLayout.LayoutParams(-2, -2));
        r168.f416916h = (LinearLayout) r168.f416915g.findViewById(R.id.attachment_list);
    L104:
        LinearLayout r170 = r168.f416916h;
        String r171 = r212.getId();
        Chat r172 = g().getChat();
        int r173 = r212.A();
        boolean r174 = r212.isPreMessage();
        Function1<View, Boolean> r175 = new TextContentBlock$renderOriginText$4(r210, this, r212);
        if (r212.isPreMessage() == true) goto L107;
    L109:
        boolean r176 = false;
    L110:
        m2b.a r177 = g();
        v4b.d r178 = (v4b.d) this.f412990f.getValue();
        if (r178 == null) goto L115;
        MessageInfo r179 = r178.f553212f;
        if (r179 == null) goto L115;
        Message r180 = r179.getMessage();
    L116:
        v4b.d r181 = (v4b.d) this.f412990f.getValue();
        v4b.d r182 = (v4b.d) this.f412990f.getValue();
        char r216 = r160;
        r214 = r110;
        r215 = MapController.ITEM_LAYER_TAG;
        r115 = r212;
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.d.b(r170, r167, r171, r172, r173, r174, r175, r176, null, r212, r177, r180, 256);
        r117 = 8;
    L124:
        v4b.d r183 = (v4b.d) this.f412990f.getValue();
        if (r183 == null) goto L129;
        r116 = true;
        if (r183.f553215i != true) goto L130;
        boolean r184 = true;
    L131:
        if (r184 == false) goto L133;
        r134.a().setDisableTouchEvent(r116);
    L133:
        r114 = r216;
    L130:
        r184 = false;
        goto L131
    L129:
        r116 = true;
    L115:
        r180 = null;
        goto L116
    L107:
        if (r212.G() != SendStatus.FAIL) goto L109;
        r176 = true;
        goto L110
    L117:
        r216 = r160;
        r215 = MapController.ITEM_LAYER_TAG;
        r115 = r212;
        r214 = r110;
        TextChatView2 r185 = r134.a();
        LinearLayout r186 = r185.f416916h;
        if (r186 == null) goto L120;
        r186.removeAllViews();
        r117 = 8;
        r185.f416916h.setVisibility(8);
    L121:
        View r187 = r185.f416915g;
        if (r187 == null) goto L124;
        r187.setVisibility(r117);
        goto L124
    L120:
        r117 = 8;
        goto L121
    L98:
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
        r166 = null;
        goto L99
    L94:
        r162 = false;
    L37:
        if (r111 == false) goto L39;
        r112 = 0;
        goto L41
    L39:
        r112 = 1;
    L32:
        r111 = true;
        goto L34
    L27:
        r109 = false;
    L23:
        r108 = false;
        goto L25
    L18:
        r107 = false;
        goto L20
    L5:
        m2b.a r188 = g();
        v4b.d r189 = (v4b.d) this.f412990f.getValue();
        int r190 = c1.f416659a;
        Intrinsics.checkNotNullParameter(r212, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r188, "chatContext");
        r100 = ChatCoreModule.a().isHideRichTextView(r212, r188, r189);
        goto L6
    }

    @Override // com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r100, com.ss.android.lark.blueprint.q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r101, y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r102) {
        update2(r100, r101, r102);
    }

    @Override // com.ss.android.lark.blueprint.i
    public final void c(BlueprintCell r100, com.ss.android.lark.blueprint.q r101, Object r102, Object r103) {
        com.ss.android.lark.blueprint.i.a.b(this, r100, r101, (y6b.a) r102, (com.ss.android.lark.chat.base.view.vo.message.e) r103);
    }
}
