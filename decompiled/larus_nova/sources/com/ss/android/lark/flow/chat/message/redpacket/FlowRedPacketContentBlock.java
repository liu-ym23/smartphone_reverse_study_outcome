package com.ss.android.lark.flow.chat.message.redpacket;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.content.RedPacketContent;
import com.ss.android.lark.chat.entity.redpacket.RedPacketCover;
import com.ss.android.lark.chat.entity.redpacket.RedPacketDisplayName;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.databinding.FlowChatMessageV2BlockRedPacketContentBinding;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowRedPacketContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<com.ss.android.lark.flow.chat.message.redpacket.c>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f422662g;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f422663a = null;

        static {
            int[] r100 = new int[RedPacketContent.Type.values().length];
            r100[RedPacketContent.Type.DESIGNATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[RedPacketContent.Type.GROUP_RANDOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f422663a = r100;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowRedPacketContentBlock f422664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.a<com.ss.android.lark.flow.chat.message.redpacket.c> f422665b;

        public c(FlowRedPacketContentBlock r100, y6b.a<com.ss.android.lark.flow.chat.message.redpacket.c> r101) {
            this.f422664a = r100;
            this.f422665b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = this.f422664a.f412673c.getChatId();
            if (r101 != null) goto L6;
            Log.w("FlowRedPacketContentBlock", "onRedPacketClick, chatId is null, skip jump");
            return;
        L6:
            Log.i("FlowRedPacketContentBlock", "onRedPacketClick, jump to feishu chat, position: " + this.f422665b.A());
            int r102 = FlowChatModule.f422022d;
            FlowChatModule.a.a().a().getBrowserDependency().openUrl(this.f422664a.getContext(), "https://applink.feishu.cn/client/chat/open?chatId=" + r101 + "&position=" + this.f422665b.A());
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final j getKey() {
        return this.f422662g;
    }

    public FlowRedPacketContentBlock(g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f422662g = IMMessageKeys$Blocks.FLOW_RED_PACKET_CONTENT;
    }

    public void update(m<y6b.a<com.ss.android.lark.flow.chat.message.redpacket.c>> r110, q<y6b.a<com.ss.android.lark.flow.chat.message.redpacket.c>> r111, y6b.a<com.ss.android.lark.flow.chat.message.redpacket.c> r112) {
        Intrinsics.checkNotNullParameter(r110, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r111, "layout");
        Intrinsics.checkNotNullParameter(r112, "data");
        FlowChatMessageV2BlockRedPacketContentBinding r113 = (FlowChatMessageV2BlockRedPacketContentBinding) ((com.ss.android.lark.blueprint.b) r111.c(this.f422662g, IMMessageKeys$Slots.CONTENT, FlowRedPacketContentBlock$update$blockView$1.INSTANCE)).f410635a;
        RedPacketContent r100 = (RedPacketContent) r112.b().f553338a;
        boolean r101 = r112.h();
        if (r101 == true) goto L5;
    L7:
        RedPacketContent.Type r102 = r100.getType();
        RedPacketContent.Type r103 = RedPacketContent.Type.DESIGNATED;
        if (r102 != r103) goto L15;
        if (r100.getCanGrab() == true) goto L15;
        if (r100.isExpired() == false) goto L15;
        Pair r104 = TuplesKt.to(Boolean.FALSE, UIUtils.getString(getContext(), R.string.Lark_Legacy_HongbaoExpired));
    L39:
        boolean r105 = ((Boolean) r104.component1()).booleanValue();
        String r106 = (String) r104.component2();
        Intrinsics.checkNotNull(r106);
        Intrinsics.checkNotNullParameter(r106, "statusText");
        r113.f422126a.setClipToOutline(true);
        if (r112.l() == false) goto L42;
    L47:
        float r107 = 8.0f;
    L48:
        Iterator r108 = CollectionsKt.listOf(new LKUIRoundedImageView2[]{r113.f422138m, r113.f422136k, r113.f422134i, r113.f422135j}).iterator();
    L50:
        if (r108.hasNext() == false) goto L52;
        ((LKUIRoundedImageView2) r108.next()).setRadiusInDp(r107);
        goto L50
    L52:
        r113.f422139n.setText(r100.getSubject());
        TextView r109 = r113.f422139n;
        RedPacketContent.Type r114 = r100.getType();
        RedPacketContent.Type r115 = RedPacketContent.Type.DESIGNATED;
        if (r114 != r115) goto L55;
        int r116 = 1;
    L56:
        r109.setMaxLines(r116);
        if (r100.getType() != RedPacketContent.Type.B2C_RANDOM) goto L59;
    L68:
        RedPacketCover r117 = r100.getCover();
        if (r117 == null) goto L71;
        String r118 = r117.getName();
    L72:
        if (r118 != null) goto L74;
    L77:
        boolean r119 = true;
    L78:
        if (r119 == false) goto L80;
        r113.f422137l.setText(R.string.Lark_OrgRedPacket_RedPacketAssistant_PacketCoverOrg);
    L82:
        if (r105 == true) goto L84;
        r113.f422133h.setAlpha(0.5f);
        r113.f422131f.setEnabled(false);
        r113.f422138m.setVisibility(0);
        r113.f422138m.setBackgroundColor(UIUtils.getColor(getContext(), R.color.bg_body));
    L85:
        r113.f422132g.setText(r106);
        TextView r120 = r113.f422132g;
        if (r106.length() <= 0) goto L88;
        boolean r121 = true;
    L89:
        if (r121 == false) goto L91;
        int r122 = 0;
    L92:
        r120.setVisibility(r122);
        RedPacketCover r123 = r100.getCover();
        if (r123 == null) goto L95;
        PassThroughImage r124 = r123.getMessageCover();
    L97:
        if (r124 != null) goto L103;
        r113.f422136k.setImageResource(R.drawable.fc_red_packet_message_cell_content_bg);
        TextView r125 = r113.f422139n;
        ViewGroup.LayoutParams r126 = r125.getLayoutParams();
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r127 = (ViewGroup.MarginLayoutParams) r126;
        Context r128 = getContext();
        if (r100.getType() != r115) goto L101;
        float r129 = 24.0f;
    L102:
        r127.topMargin = UIUtils.dp2px(r128, r129);
        r125.setLayoutParams(r127);
        r113.f422128c.setVisibility(8);
    L104:
        LKUIRoundedImageView2 r130 = r113.f422134i;
        if (r124 == null) goto L107;
    L112:
        boolean r131 = true;
    L113:
        if (r131 == false) goto L115;
        int r132 = 0;
    L116:
        r130.setVisibility(r132);
        LKUIRoundedImageView2 r133 = r113.f422134i;
        ViewGroup.LayoutParams r134 = r133.getLayoutParams();
        Context r135 = getContext();
        if (r100.getType() != r115) goto L119;
        float r136 = 176.0f;
    L120:
        r134.height = UIUtils.dp2px(r135, r136);
        r133.setLayoutParams(r134);
        RedPacketCover r137 = r100.getCover();
        if (r137 == null) goto L125;
        RedPacketDisplayName r138 = r137.getDisplayName();
        if (r138 == null) goto L125;
        String r139 = r138.getDisplayName();
    L126:
        RedPacketCover r140 = r100.getCover();
        if (r140 == null) goto L129;
        String r141 = r140.getCompanyName();
    L131:
        if (r100.getType().isB2C() == false) goto L133;
        r139 = r141;
    L133:
        TextView r142 = r113.f422128c;
        if (r139 != null) goto L136;
    L139:
        boolean r143 = true;
    L140:
        if (r143 == false) goto L142;
        int r144 = 8;
    L143:
        r142.setVisibility(r144);
        r113.f422128c.setText(r139);
        RedPacketCover r145 = r100.getCover();
        if (r145 == null) goto L148;
        RedPacketDisplayName r146 = r145.getDisplayName();
        if (r146 == null) goto L148;
        PassThroughImage r147 = r146.getBackgroundImage();
    L149:
        if (r147 == null) goto L151;
        ImageLoader.with(getContext()).load(r147).into(new com.ss.android.lark.flow.chat.message.redpacket.b(this, r113));
    L151:
        RedPacketCover r148 = r100.getCover();
        if (r148 == null) goto L154;
        PassThroughImage r149 = r148.getCompanyLogo();
    L155:
        if (r149 != null) goto L157;
        r113.f422127b.setImageDrawable(null);
    L162:
        if (r100.getType() == r115) goto L165;
        r113.f422129d.setVisibility(8);
        r113.f422130e.setVisibility(8);
    L178:
        r113.f422126a.setOnClickListener(new c(this, r112));
        f(r113.f422126a, r110, r112);
        return;
    L165:
        if (r100.getTotalNum() == 1) goto L167;
    L169:
        String r150 = UIHelper.mustacheFormat(R.string.Lark_DesignatedRedPacket_DesignatedToNumMembers_Text, "num", String.valueOf(r100.getTotalNum()));
    L170:
        TextView r151 = r113.f422130e;
        if ((true ^ r100.getPreviewUsers().isEmpty()) == false) goto L173;
        int r152 = 0;
    L174:
        r151.setVisibility(r152);
        r113.f422130e.setText(r150);
        if (r100.getPreviewUsers().isEmpty() == false) goto L177;
        r113.f422129d.setVisibility(8);
        goto L178
    L177:
        r113.f422129d.setVisibility(0);
        r113.f422129d.setAdapter(new com.ss.android.lark.flow.chat.message.redpacket.a(UIUtils.dp2px(getContext(), 24.0f), r100.getPreviewUsers()));
        r113.f422129d.setOverlapWidth(new UDDimension.Dp(6.0f));
        goto L178
    L173:
        r152 = 8;
        goto L174
    L167:
        if (CollectionsKt.firstOrNull(r100.getPreviewUsers()) == null) goto L169;
        r150 = UIHelper.mustacheFormat(R.string.Lark_DesignatedRedPacket_DesignatedToName_Text, "name", ((ChatterInfo) CollectionsKt.first(r100.getPreviewUsers())).getName());
        goto L170
    L157:
        ImageLoader.with(getContext()).load(r149).into(r113.f422127b);
        if (r100.getType().isB2C() == false) goto L160;
        r113.f422127b.setOval(true);
        r113.f422127b.setBackgroundColor(UDColorUtils.getColor(getContext(), R.color.static_white));
        goto L162
    L160:
        r113.f422127b.setOval(false);
        r113.f422127b.setBackground(null);
        goto L162
    L154:
        r149 = null;
    L148:
        r147 = null;
        goto L149
    L142:
        r144 = 0;
        goto L143
    L136:
        if (r139.length() == 0) goto L139;
        r143 = false;
        goto L140
    L129:
        r141 = null;
    L125:
        r139 = null;
        goto L126
    L119:
        r136 = 108.0f;
        goto L120
    L115:
        r132 = 8;
        goto L116
    L107:
        if (r100.getType() == r115) goto L112;
        if (r100.getType().isB2C() == true) goto L112;
        r131 = false;
        goto L113
    L101:
        r129 = 36.0f;
        goto L102
    L103:
        ImageLoader.with(getContext()).load(r124).placeholder(R.drawable.fc_red_packet_message_cell_content_bg).dontAnimate(!r105).into(r113.f422136k);
        TextView r153 = r113.f422139n;
        ViewGroup.LayoutParams r154 = r153.getLayoutParams();
        Intrinsics.checkNotNull(r154, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r155 = (ViewGroup.MarginLayoutParams) r154;
        r155.topMargin = UIUtils.dp2px(getContext(), 24.0f);
        r153.setLayoutParams(r155);
        goto L104
    L95:
        r124 = null;
        goto L97
    L91:
        r122 = 8;
        goto L92
    L88:
        r121 = false;
        goto L89
    L84:
        r113.f422133h.setAlpha(1.0f);
        r113.f422131f.setEnabled(true);
        r113.f422138m.setVisibility(8);
        goto L85
    L80:
        r113.f422137l.setText(r118);
        goto L82
    L74:
        if (r118.length() == 0) goto L77;
        r119 = false;
        goto L78
    L71:
        r118 = null;
        goto L72
    L59:
        if (r100.getType() == RedPacketContent.Type.B2C_FIX) goto L68;
        TextView r156 = r113.f422137l;
        int r157 = b.f422663a[r100.getType().ordinal()];
        if (r157 == 1) goto L66;
        if (r157 == 2) goto L65;
        int r158 = R.string.Lark_Legacy_NormalAmount;
    L67:
        r156.setText(r158);
        goto L82
    L65:
        r158 = R.string.Lark_Legacy_RandomHongbao;
        goto L67
    L66:
        r158 = R.string.Lark_DesignateRedPacket_DesignatedRedPacket_Label;
        goto L67
    L55:
        r116 = 2;
        goto L56
    L42:
        if (r112.d() == true) goto L47;
        if (this.f412673c.Y() == true) goto L47;
        r107 = 0.0f;
    L15:
        if (r100.getType() != r103) goto L22;
        if (r100.getCanGrab() == true) goto L22;
        if (r100.isGrabbedFinish() == false) goto L22;
        r104 = TuplesKt.to(Boolean.FALSE, "");
    L22:
        if (r100.isGrabbed() == false) goto L25;
        r104 = TuplesKt.to(Boolean.FALSE, UIUtils.getString(getContext(), R.string.Lark_Legacy_HongbaoOpened));
        goto L39
    L25:
        if (r100.isGrabbedFinish() == false) goto L28;
        r104 = TuplesKt.to(Boolean.FALSE, UIUtils.getString(getContext(), R.string.Lark_Legacy_HongbaoNoneLeft));
        goto L39
    L28:
        if (r100.isExpired() == false) goto L31;
        r104 = TuplesKt.to(Boolean.FALSE, UIUtils.getString(getContext(), R.string.Lark_Legacy_HongbaoExpired));
        goto L39
    L31:
        if (r100.getType() == r103) goto L33;
    L38:
        r104 = TuplesKt.to(Boolean.TRUE, "");
        goto L39
    L33:
        if (r100.getCanGrab() == true) goto L38;
        if (r101 == true) goto L38;
        if (r100.isClicked() == false) goto L38;
        r104 = TuplesKt.to(Boolean.FALSE, "");
        goto L39
    L5:
        if (r100.isGrabbedFinish() == false) goto L7;
        r104 = TuplesKt.to(Boolean.FALSE, UIUtils.getString(getContext(), R.string.Lark_Legacy_HongbaoNoneLeft));
        goto L39
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(m r100, q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
