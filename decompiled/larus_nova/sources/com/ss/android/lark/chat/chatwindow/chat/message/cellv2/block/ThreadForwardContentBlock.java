package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.base.view.vo.ThreadMessageVO;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;
import com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class ThreadForwardContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<ThreadForwardContentVOV2>, ThreadForwardContentVOV2> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f413006w = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f413007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f413008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f413009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f413010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f413011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f413012l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f413013m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f413014n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f413015o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f413016p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f413017q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f413018r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f413019s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f413020t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f413021u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f413022v;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f413023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FrameLayout f413024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f413025c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LKUIRoundedImageView2 f413026d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f413027e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f413028f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f413029g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final View f413030h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final TextView f413031i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ThreadReplyExposureView f413032j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final View f413033k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final TextView f413034l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final View f413035m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final TextView f413036n;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f413023a;
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f413023a = r100;
            this.f413024b = (FrameLayout) r100.findViewById(R.id.root_message_view);
            this.f413025c = r100.findViewById(R.id.top_layout);
            LKUIRoundedImageView2 r101 = (LKUIRoundedImageView2) r100.findViewById(R.id.thread_creator_avatar);
            this.f413026d = r101;
            TextView r102 = (TextView) r100.findViewById(R.id.thread_creator_name);
            this.f413027e = r102;
            this.f413028f = r100.findViewById(R.id.division_view);
            TextView r103 = (TextView) r100.findViewById(R.id.post_thread_desc);
            this.f413029g = r103;
            this.f413030h = r100.findViewById(R.id.thread_replies_layout);
            TextView r104 = (TextView) r100.findViewById(R.id.thread_reply_count);
            this.f413031i = r104;
            this.f413032j = (ThreadReplyExposureView) r100.findViewById(R.id.thread_replies);
            this.f413033k = r100.findViewById(R.id.thread_forward_mask);
            TextView r105 = (TextView) r100.findViewById(R.id.fallback_tip_tv);
            this.f413034l = r105;
            this.f413035m = r100.findViewById(R.id.bottom_space_view);
            this.f413036n = (TextView) r100.findViewById(R.id.source_msg_view);
            zz7.a.c(r102, 17);
            zz7.a.a(r101, 20);
            zz7.a.c(r103, 14);
            zz7.a.c(r105, 17);
            zz7.a.c(r104, 12);
        }
    }

    static {
    }

    public final int h() {
        return ((Number) this.f413009i.getValue()).intValue();
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f413007g;
    }

    public ThreadForwardContentBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f413007g = IMMessageKeys$Blocks.THREAD_FORWARD_CONTENT;
        this.f413008h = LazyKt.lazy(new ThreadForwardContentBlock$creatorAvatarSize$2(this));
        this.f413009i = LazyKt.lazy(new ThreadForwardContentBlock$chatAvatarSize$2(this));
        this.f413010j = LazyKt.lazy(new ThreadForwardContentBlock$chatDescTextSize$2(this));
        this.f413011k = LazyKt.lazy(ThreadForwardContentBlock$minRenderWidth$2.INSTANCE);
        this.f413012l = LazyKt.lazy(ThreadForwardContentBlock$horizontalPadding$2.INSTANCE);
        this.f413013m = LazyKt.lazy(ThreadForwardContentBlock$needHandleItalicType$2.INSTANCE);
        this.f413014n = LazyKt.lazy(ThreadForwardContentBlock$italicPadding$2.INSTANCE);
        this.f413015o = Integer.MIN_VALUE;
        this.f413017q = LazyKt.lazy(ThreadForwardContentBlock$maxHeightFactor$2.INSTANCE);
        this.f413018r = LazyKt.lazy(new ThreadForwardContentBlock$messageCellParams$2(this));
        this.f413019s = LazyKt.lazy(new ThreadForwardContentBlock$groupAvatarPlaceholder$2(this));
        this.f413020t = LazyKt.lazy(ThreadForwardContentBlock$boldSpan$2.INSTANCE);
        this.f413021u = LazyKt.lazy(new ThreadForwardContentBlock$replyInThreadCallback$2(this));
        this.f413022v = LazyKt.lazy(new ThreadForwardContentBlock$threadCallback$2(this));
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<ThreadForwardContentVOV2>> r210, com.ss.android.lark.blueprint.q<y6b.a<ThreadForwardContentVOV2>> r211, y6b.a<ThreadForwardContentVOV2> r212) {
        Intrinsics.checkNotNullParameter(r210, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r211, "layout");
        Intrinsics.checkNotNullParameter(r212, "data");
        b r100 = (b) r211.c(this.f413007g, IMMessageKeys$Slots.CONTENT, ThreadForwardContentBlock$update$blockView$1.INSTANCE);
        ThreadForwardContentVOV2 r101 = r212.b();
        ChatterInfo r102 = r101.f411940i;
        com.ss.android.lark.chat.utils.g.e(getContext(), r100.f413026d, r102.getAvatarKey(), r102.getId(), ((Number) this.f413008h.getValue()).intValue(), ((Number) this.f413008h.getValue()).intValue(), Scene.Chat);
        r100.f413027e.setText(r102.getName());
        if (r101.f411941j.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        String r104 = "";
        if (r103 == false) goto L9;
    L19:
        r100.f413029g.setText(UIHelper.getString(R.string.Lark_IM_ForwardCard_PostedATopicNoGroupName_Text));
    L20:
        String r105 = null;
        r100.f413032j.f(null, r101.f411946o);
        int r106 = r100.f413032j.getShowingReplyCount();
        if (r101.f411945n > r106) goto L23;
        r100.f413031i.setVisibility(8);
    L24:
        View r107 = r100.f413030h;
        if (r106 < 1) goto L27;
        boolean r108 = true;
    L28:
        if (r108 == false) goto L30;
        int r109 = 0;
    L31:
        r107.setVisibility(r109);
        String r110 = r212.getId();
        ThreadForwardContentVOV2 r111 = r212.b();
        Thread r112 = ((MergeForwardContent) r111.f553338a).getThread();
        if (r112 == null) goto L37;
        String r113 = r112.f253577id;
        if (r113 == null) goto L37;
        r104 = r113;
    L37:
        r100.f413033k.setOnClickListener(new t0(r111, this, r104, r110));
        r100.f413033k.setOnLongClickListener(new u0(r210, this, r212));
        if (this.f412673c.r() == false) goto L40;
    L41:
        r100.f413023a.setBackgroundResource(R.drawable.new_thread_forward_cell_bg);
    L42:
        v4b.d r114 = this.f412675e;
        if (r114 == null) goto L45;
        int r115 = r114.f553210d;
    L116:
        int r116 = r115 - (((Number) this.f413012l.getValue()).intValue() * 2);
        r100.f413023a.getLayoutParams().width = r115;
        if (r116 >= ((Number) this.f413011k.getValue()).intValue()) goto L119;
        boolean r117 = true;
    L120:
        FrameLayout r118 = r100.f413024b;
        if ((!r117) == false) goto L123;
        int r119 = 0;
    L124:
        r118.setVisibility(r119);
        TextView r120 = r100.f413034l;
        if (r117 == false) goto L127;
        int r121 = 0;
    L128:
        r120.setVisibility(r121);
        if (r117 == true) goto L163;
        Message r122 = r101.f411939h;
        MessageInfo r123 = new MessageInfo(r122, null);
        FrameLayout r124 = r100.f413024b;
        if (((List) this.f413013m.getValue()).contains(r122.getType()) == false) goto L133;
        int r125 = ((Number) this.f413014n.getValue()).intValue();
    L134:
        int r126 = r116 - r125;
        Log.i("ThreadForwardMessageCellV2", "bind root message, last width = " + this.f413015o + ", new width = " + r126);
        if (r122.isRecalled() == false) goto L137;
    L146:
        boolean r127 = true;
    L147:
        v4b.d.a r128 = new v4b.d.a();
        r128.f553218b = r126;
        r128.f553217a = false;
        ArrayList r129 = new ArrayList();
        Intrinsics.checkNotNullParameter(r129, "cardDown2TextList");
        r128.f553219c = r129;
        r128.f553221e = true;
        v4b.d r130 = new v4b.d(r128);
        if (r124.getChildCount() == 1) goto L150;
    L154:
        r124.removeAllViews();
        ((Map) this.f413018r.getValue()).put(com.ss.android.lark.biz.im.api.message.params.d.class, new com.ss.android.lark.biz.im.api.message.params.d(new com.ss.android.lark.biz.im.api.message.params.d.a()));
        Map r131 = (Map) this.f413018r.getValue();
        View r132 = ChatCoreModule.a().getChatDependency().c(r124, r123);
        if (r132 != null) goto L158;
    L165:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("message.message_sending_source") == true) goto L167;
        r100.f413036n.setVisibility(8);
        return;
    L167:
        boolean r133 = r212 instanceof ThreadMessageVO;
        if (r133 == false) goto L175;
        if (r133 == false) goto L171;
        ThreadMessageVO r134 = (ThreadMessageVO) r212;
    L172:
        if (r134 == null) goto L184;
        Intrinsics.checkNotNull(null);
    L184:
        if (r105 != null) goto L187;
        r100.f413036n.setVisibility(8);
        return;
    L187:
        if (r105.length() != 0) goto L189;
        boolean r135 = true;
    L190:
        if (r135 == false) goto L192;
        String r136 = UIUtils.getString(r100.f413023a.getContext(), R.string.Lark_IM_ThirdPartyApp_FromEnterpriseApp_Text);
    L193:
        r100.f413036n.setVisibility(0);
        zz7.a.d(r100.f413036n, LarkFont.CAPTION0);
        r100.f413036n.setText(r136);
        return;
    L192:
        String r137 = y9c.d.i(r100.f413023a.getContext(), R.string.Lark_IM_ThirdPartyApp_FromAppName_Text);
        ICUUtils.FormatArgsBuilder r138 = new ICUUtils.FormatArgsBuilder();
        r138.b("appName", r105);
        r136 = ICUUtils.icuFormat(r137, r138.f285892a);
        goto L193
    L189:
        r135 = false;
        goto L190
    L171:
        r134 = null;
        goto L172
    L175:
        if ((r212 instanceof y6b.c) == false) goto L177;
        y6b.c r139 = (y6b.c) r212;
    L178:
        if (r139 == null) goto L184;
        ThreadForwardContentVOV2 r140 = (ThreadForwardContentVOV2) r139.f566500o;
        if (r140 == null) goto L184;
        Message r141 = r140.f411939h;
        if (r141 == null) goto L184;
        r105 = r141.getAppInfoItemName();
        goto L184
    L177:
        r139 = null;
        goto L178
    L158:
        if (r122.getType() == Message.Type.IMAGE) goto L160;
    L162:
        r124.addView(r132);
        r122.getId();
        this.f413015o = r126;
        this.f413016p = r127;
        goto L165
    L160:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.message.thread_reply_bubble_optimize") == false) goto L162;
        ((LKUIRoundableLayout) r132.findViewById(R.id.content)).setRadius(4.0f);
        goto L162
    L150:
        if (this.f413016p != r127) goto L154;
        if (ChatCoreModule.a().getChatDependency().p(r124.getChildAt(0), r123, r130) == false) goto L154;
    L137:
        if (r122.isBurned() == true) goto L146;
        if (r122.isRemoved() == true) goto L146;
        if (r122.isSetGrey() == true) goto L143;
    L145:
        r127 = false;
        goto L147
    L143:
        if (r122.isCleaned() == true) goto L145;
    L133:
        r125 = 0;
        goto L134
    L163:
        Log.i("ThreadForwardMessageCellV2", "display fallback tip, message id = " + r212.getId() + ", cardRenderWidth = " + r115 + ", rootMessageWidth = " + r116);
        goto L165
    L127:
        r121 = 8;
        goto L128
    L123:
        r119 = 8;
        goto L124
    L119:
        r117 = false;
        goto L120
    L45:
        boolean r142 = this.f412673c.s8();
        if (this.f412673c.Y() == false) goto L74;
        boolean r143 = r212 instanceof y6b.c;
        if (r143 == true) goto L50;
    L52:
        boolean r144 = false;
    L53:
        if (r143 == true) goto L55;
    L57:
        boolean r145 = false;
    L58:
        if (r144 == false) goto L65;
        int r146 = u2b.j.f548512a;
        Context r147 = getContext();
        Integer r148 = f3b.b.a(this.f412673c);
        Intrinsics.checkNotNullParameter(r147, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r149 = u2b.j.n(r147, r148) - (u2b.j.f548518g * 2);
        if (r142 == false) goto L62;
        int r150 = u2b.j.f548526o;
    L63:
        if (r145 == false) goto L71;
        int r151 = u2b.j.f548527p;
    L72:
        int r152 = (r149 - r150) - r151;
        int r153 = 0;
    L76:
        int r154 = r152 - r153;
    L77:
        r115 = r154;
    L71:
        r151 = 0;
        goto L72
    L62:
        r150 = 0;
        goto L63
    L65:
        int r155 = u2b.j.f548512a;
        Context r156 = getContext();
        Integer r157 = f3b.b.a(this.f412673c);
        Intrinsics.checkNotNullParameter(r156, PerfLog.PARAM_KEY_CONTEXT_ID);
        r149 = ((u2b.j.n(r156, r157) - (u2b.j.f548518g * 2)) - zz7.b.g(r156, 36)) - u2b.j.f548522k;
        if (r142 == false) goto L68;
        r150 = u2b.j.f548526o;
    L69:
        if (r145 == false) goto L71;
        r151 = u2b.j.f548527p;
        goto L72
    L68:
        r150 = 0;
        goto L69
    L55:
        if (((y6b.c) r212).V1 == false) goto L57;
        r145 = true;
        goto L58
    L50:
        if (((y6b.c) r212).Y() == false) goto L52;
        r144 = true;
        goto L53
    L74:
        if (this.f412673c.m() == false) goto L79;
        int r158 = u2b.j.f548512a;
        Context r159 = getContext();
        Integer r160 = f3b.b.a(this.f412673c);
        Intrinsics.checkNotNullParameter(r159, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r161 = u2b.j.n(r159, r160) - (u2b.j.f548517f * 2);
        r153 = 0;
        r152 = r161 + 0;
        goto L76
    L79:
        if (this.f412673c.q() == false) goto L96;
        if ((r212 instanceof y6b.c) == true) goto L83;
    L85:
        boolean r162 = false;
    L86:
        if (r162 == false) goto L90;
        int r163 = u2b.j.f548512a;
        Context r164 = getContext();
        Integer r165 = f3b.b.a(this.f412673c);
        Intrinsics.checkNotNullParameter(r164, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r166 = u2b.j.n(r164, r165) - (u2b.j.f548518g * 2);
        if (r142 == false) goto L93;
        int r167 = u2b.j.f548526o;
    L94:
        r115 = r166 - r167;
    L93:
        r167 = 0;
        goto L94
    L90:
        int r168 = u2b.j.f548512a;
        Context r169 = getContext();
        Integer r170 = f3b.b.a(this.f412673c);
        Intrinsics.checkNotNullParameter(r169, PerfLog.PARAM_KEY_CONTEXT_ID);
        r166 = (u2b.j.n(r169, r170) - zz7.b.g(r169, 48)) - u2b.j.f548518g;
        if (r142 == false) goto L93;
        r167 = u2b.j.f548526o;
        goto L94
    L83:
        if (((y6b.c) r212).Z() == false) goto L85;
        r162 = true;
        goto L86
    L96:
        if (this.f412673c.r() == false) goto L99;
        int r171 = u2b.j.f548512a;
        Context r172 = getContext();
        Integer r173 = f3b.b.a(this.f412673c);
        Intrinsics.checkNotNullParameter(r172, PerfLog.PARAM_KEY_CONTEXT_ID);
        r115 = u2b.j.n(r172, r173);
        int r174 = u2b.j.f548518g;
    L111:
        r115 = r115 - (r174 * 2);
        goto L116
    L99:
        if (r212.d() == true) goto L101;
    L105:
        boolean r175 = false;
    L106:
        if (r142 == false) goto L112;
        int r176 = u2b.j.f548512a;
        Context r177 = getContext();
        Integer r178 = f3b.b.a(this.f412673c);
        Intrinsics.checkNotNullParameter(r177, PerfLog.PARAM_KEY_CONTEXT_ID);
        r115 = (((u2b.j.n(r177, r178) - zz7.b.g(r177, 56)) - u2b.j.f548515d) - zz7.b.g(r177, u2b.j.f548513b)) - u2b.j.f548514c;
        if (r175 == false) goto L116;
        r174 = u2b.j.f548516e;
        goto L111
    L112:
        Context r179 = getContext();
        Integer r180 = f3b.b.a(this.f412673c);
        int r181 = u2b.j.f548512a;
        Intrinsics.checkNotNullParameter(r179, PerfLog.PARAM_KEY_CONTEXT_ID);
        r154 = (((u2b.j.n(r179, r180) - (u2b.j.f548512a + (zz7.b.g(r179, 32) - UIHelper.dp2px(32.0f)))) - u2b.j.f548515d) - zz7.b.g(r179, u2b.j.f548513b)) - u2b.j.f548514c;
        if (r175 == false) goto L77;
        r154 = r154 - (u2b.j.f548516e * 2);
        goto L77
    L101:
        if (this.f412673c.q8() == false) goto L103;
    L104:
        r175 = true;
        goto L106
    L103:
        if (this.f412673c.e0() == false) goto L105;
    L40:
        if (this.f412673c.q() == false) goto L42;
    L30:
        r109 = 8;
        goto L31
    L27:
        r108 = false;
        goto L28
    L23:
        r100.f413031i.setVisibility(0);
        r100.f413031i.setText(UIHelper.getQuantityString(R.plurals.Lark_IM_SwitchedTopicGroup_ViewNumMoreTopicReplies_Text, r101.f411945n - r106));
        goto L24
    L9:
        if (r101.f() == false) goto L19;
        String r182 = UIUtils.getString(getContext(), R.string.Lark_IM_ForwardCard_TopicPostedInChatName_Text);
        StringBuilder r183 = new StringBuilder();
        if (r101.f411944m == false) goto L14;
        String r184 = "group_avatar ";
    L15:
        r183.append(r184);
        r183.append(r101.f411941j);
        String r185 = r183.toString();
        String r186 = ICUUtils.icuFormat(r182, "chatName", r185);
        getContext();
        ncc.g r187 = new ncc.g(r186);
        Intrinsics.checkNotNull(r182);
        int r188 = StringsKt.indexOf$default(r182, "{chatName}", 0, false, 6, null);
        r187.setSpan((StyleSpan) this.f413020t.getValue(), r188, r185.length() + r188, 33);
        if (r101.f411944m == false) goto L18;
        r187.setSpan(new com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.b(getContext(), (Drawable) this.f413019s.getValue(), new v0(r100), (int) ((Number) this.f413010j.getValue()).floatValue(), h(), r101.f411943l, r101.f411942k), r188, r188 + 12, 33);
    L18:
        r100.f413029g.setText(r187);
        goto L20
    L14:
        r184 = "";
        goto L15
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
