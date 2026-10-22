package com.ss.android.lark.flow.chat.message.block;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.ThreadMessageVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.p;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.UserGroupScene;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import kotlin.jvm.internal.Intrinsics;
import w4b.b0;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowRecalledSystemContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<v5b.a<?>>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f422315g;

    public static final class a {
    }

    public static final class b implements k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f422316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkEmojiTextView f422317b;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f422316a;
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f422316a = r100;
            LinkEmojiTextView r101 = (LinkEmojiTextView) r100.findViewById(R.id.recall_system_msg);
            this.f422317b = r101;
            r101.setHighlightColor(y9c.d.c(r101.getContext(), R.color.color_transparent));
            r101.setTextSize(0, itb.d.a.a((itb.d) LarkContext.spiByDwarf(itb.d.class), UIUtils.dp2px(r101.getContext(), 14.0f)));
        }
    }

    public static final class c implements LinkEmojiTextView.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowRecalledSystemContentBlock f422318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.a<v5b.a<?>> f422319b;

        @Override // com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView.f
        public final boolean c(View r100, String r101, String r102) {
            return false;
        }

        public c(FlowRecalledSystemContentBlock r100, y6b.a<v5b.a<?>> r101) {
            this.f422318a = r100;
            this.f422319b = r101;
        }

        @Override // com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView.f
        public final void d(View r100, String r101, String r102) {
            b0 r103 = ChatCoreModule.a().getProfileDependency();
            Context r104 = this.f422318a.getContext();
            ProfileSource.a r105 = new ProfileSource.a();
            r105.f420573e = r102;
            r105.f420572d = this.f422319b.getChatId();
            r105.f420570b = 2;
            r105.f420571c = com.ss.android.lark.chat.utils.k.a(this.f422318a.f412673c.getChat());
            r103.e(r104, r105.a());
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final j getKey() {
        return this.f422315g;
    }

    public FlowRecalledSystemContentBlock(g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f422315g = IMMessageKeys$Blocks.RECALLED_SYSTEM_CONTENT;
    }

    public void update(m<y6b.a<v5b.a<?>>> r110, q<y6b.a<v5b.a<?>>> r111, y6b.a<v5b.a<?>> r112) {
        Intrinsics.checkNotNullParameter(r110, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r111, "layout");
        Intrinsics.checkNotNullParameter(r112, "data");
        LinkEmojiTextView r113 = ((b) r111.c(this.f422315g, IMMessageKeys$Slots.CONTENT, FlowRecalledSystemContentBlock$update$blockView$1.INSTANCE)).f422317b;
        i3b.c.b(r113, this.f412671a, 12.0f);
        ChatThemeInfo r114 = this.f412673c.r8();
        boolean r100 = true;
        if (r114 != null) goto L5;
    L7:
        boolean r115 = false;
    L8:
        r112.b();
        y6b.b r101 = r112.D();
        y6b.b r102 = r112.a();
        String r103 = "";
        if (r101 == null) goto L11;
        String r104 = o.b(r101.f566452a, r101.f566456e);
    L12:
        if (r102 == null) goto L14;
        r103 = o.b(r102.f566452a, r102.f566456e);
    L14:
        StringBuilder r105 = new StringBuilder("getTvContent, recallChatter: ");
        if (r101 != null) goto L17;
        boolean r106 = true;
    L18:
        r105.append(r106);
        r105.append(", recalledChatter: ");
        if (r102 == null) goto L22;
        r100 = false;
    L22:
        r105.append(r100);
        r105.append(", recallerIdentity: ");
        r105.append(r112.E());
        Log.i("FlowRecalledSystemContentBlock", r105.toString());
        if (r102 != null) goto L25;
    L38:
        if (r102 != null) goto L40;
    L46:
        if (r101 == null) goto L62;
        if (r102 == null) goto L62;
        if ((r112 instanceof y6b.c) == true) goto L53;
        if ((r112 instanceof ThreadMessageVO) == false) goto L62;
    L53:
        if (r112.S() == false) goto L62;
        if (r102.f566461j != Chatter.ChatterType.DOUBAO) goto L58;
        String r107 = y9c.d.i(getContext(), R.string.Lark_IM_GroupAdminRecallMsg_System_Text);
        ICUUtils.FormatArgsBuilder r108 = new ICUUtils.FormatArgsBuilder();
        r108.b(UserGroupScene.DEFAULT_NAME_SPACE, r104);
        r108.b("name", r102.f566456e);
        String r109 = ICUUtils.icuFormat(r107, r108.f285892a);
    L61:
        Intrinsics.checkNotNull(r109);
    L91:
        r113.T(null, r109, false);
        r113.setAtStringClickListner(new c(this, r112));
        if (r115 == true) goto L95;
        return;
    L95:
        if (TextUtils.isEmpty(r109) == true) goto L97;
        r113.setBackground(y9c.d.e(getContext(), R.drawable.bg_system_msg));
        r113.setTextColor(p.c(getContext()));
        return;
    L97:
        Context r116 = getContext();
        int r117 = p.f416714a;
        Intrinsics.checkNotNullParameter(r116, PerfLog.PARAM_KEY_CONTEXT_ID);
        r113.setBackgroundColor(UIUtils.getColor(r116, R.color.transparent));
        r113.setTextColor(p.e(getContext()));
        return;
    L58:
        if (r112.h() == false) goto L60;
        String r118 = y9c.d.i(getContext(), R.string.Lark_IM_GroupAdminRecallMsgFromYou_System_Text);
        ICUUtils.FormatArgsBuilder r119 = new ICUUtils.FormatArgsBuilder();
        r119.b(UserGroupScene.DEFAULT_NAME_SPACE, r104);
        r109 = ICUUtils.icuFormat(r118, r119.f285892a);
        goto L61
    L60:
        String r120 = y9c.d.i(getContext(), R.string.Lark_IM_GroupAdminRecallMsg_System_Text);
        ICUUtils.FormatArgsBuilder r121 = new ICUUtils.FormatArgsBuilder();
        r121.b(UserGroupScene.DEFAULT_NAME_SPACE, r104);
        r121.b("name", r103);
        r109 = ICUUtils.icuFormat(r120, r121.f285892a);
    L62:
        if (r101 == null) goto L79;
        if (r102 == null) goto L79;
        if ((r112 instanceof y6b.c) == true) goto L69;
        if ((r112 instanceof ThreadMessageVO) == true) goto L69;
    L71:
        if (r102.f566461j != Chatter.ChatterType.DOUBAO) goto L74;
        String r122 = y9c.d.i(getContext(), R.string.Lark_IM_GroupOwnerRecallMsg_System_Text);
        ICUUtils.FormatArgsBuilder r123 = new ICUUtils.FormatArgsBuilder();
        r123.b("owner", r104);
        r123.b("name", r102.f566456e);
        r109 = ICUUtils.icuFormat(r122, r123.f285892a);
    L77:
        Intrinsics.checkNotNull(r109);
        goto L91
    L74:
        if (r112.h() == false) goto L76;
        String r124 = y9c.d.i(getContext(), R.string.Lark_IM_GroupOwnerRecallMsgFromYou_System_Text);
        ICUUtils.FormatArgsBuilder r125 = new ICUUtils.FormatArgsBuilder();
        r125.b("owner", r104);
        r109 = ICUUtils.icuFormat(r124, r125.f285892a);
        goto L77
    L76:
        String r126 = y9c.d.i(getContext(), R.string.Lark_IM_GroupOwnerRecallMsg_System_Text);
        ICUUtils.FormatArgsBuilder r127 = new ICUUtils.FormatArgsBuilder();
        r127.b("owner", r104);
        r127.b("name", r103);
        r109 = ICUUtils.icuFormat(r126, r127.f285892a);
    L69:
        if (r112.S() == false) goto L71;
    L79:
        if (r102 != null) goto L81;
    L85:
        if (r101 != null) goto L90;
        if (r102 == null) goto L90;
        if (r112.E() != Message.RecallerIdentity.UNKNOWN_IDENTITY) goto L90;
        String r128 = y9c.d.i(getContext(), R.string.Lark_IM_RecallMessage_SelectICU_Text);
        ICUUtils.FormatArgsBuilder r129 = new ICUUtils.FormatArgsBuilder();
        r129.b("noun", "you");
        r109 = ICUUtils.icuFormat(r128, r129.f285892a);
        Intrinsics.checkNotNull(r109);
    L90:
        r109 = y9c.d.i(getContext(), R.string.Lark_Legacy_MessageIsrecalled);
        Intrinsics.checkNotNull(r109);
        goto L91
    L81:
        if (r112.h() == true) goto L85;
        if (r112.E() != Message.RecallerIdentity.UNKNOWN_IDENTITY) goto L85;
        String r130 = y9c.d.i(getContext(), R.string.Lark_IM_RecallMessage_SelectICU_Text);
        ICUUtils.FormatArgsBuilder r131 = new ICUUtils.FormatArgsBuilder();
        r131.b("noun", "other");
        r131.b("name", r103);
        r109 = ICUUtils.icuFormat(r130, r131.f285892a);
        Intrinsics.checkNotNull(r109);
        goto L91
    L40:
        if (r112.E() != Message.RecallerIdentity.ENTERPRISE_ADMINISTRATOR) goto L46;
        if (r112.h() == false) goto L44;
        r109 = y9c.d.i(getContext(), R.string.Lark_IM_OrgAdminRecallMsgFromYou_System_Text);
    L45:
        Intrinsics.checkNotNull(r109);
        goto L91
    L44:
        String r132 = y9c.d.i(getContext(), R.string.Lark_IM_OrgAdminRecallMsg_System_Text);
        ICUUtils.FormatArgsBuilder r133 = new ICUUtils.FormatArgsBuilder();
        r133.b("name", r103);
        r109 = ICUUtils.icuFormat(r132, r133.f285892a);
        goto L45
    L25:
        if (r112.E() != Message.RecallerIdentity.DOUBAO_QUERY_OWNER) goto L38;
        if (r101 == null) goto L28;
        String r134 = r101.f566452a;
    L29:
        y6b.b r135 = this.f412673c.K8();
        if (r135 == null) goto L32;
        String r136 = r135.f566452a;
    L34:
        if (Intrinsics.areEqual(r134, r136) == false) goto L36;
        String r137 = y9c.d.i(getContext(), R.string.LarkIM_Msg_RecallDoubaoMsg_Text);
        ICUUtils.FormatArgsBuilder r138 = new ICUUtils.FormatArgsBuilder();
        r138.b("brandName", r102.f566456e);
        r109 = ICUUtils.icuFormat(r137, r138.f285892a);
    L37:
        Intrinsics.checkNotNull(r109);
        goto L91
    L36:
        String r139 = y9c.d.i(getContext(), R.string.LarkIM_Msg_NameRecallDoubaoMsg_Text);
        ICUUtils.FormatArgsBuilder r140 = new ICUUtils.FormatArgsBuilder();
        r140.b("name", r104);
        r140.b("brandName", r102.f566456e);
        r109 = ICUUtils.icuFormat(r139, r140.f285892a);
        goto L37
    L32:
        r136 = null;
        goto L34
    L28:
        r134 = null;
        goto L29
    L17:
        r106 = false;
        goto L18
    L11:
        r104 = "";
        goto L12
    L5:
        if (p.g(r114.getComponentScene()) == false) goto L7;
        r115 = true;
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(m r100, q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
