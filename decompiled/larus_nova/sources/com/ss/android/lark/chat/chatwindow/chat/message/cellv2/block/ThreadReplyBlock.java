package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larus.nova.R;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes35.dex */
public final class ThreadReplyBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f413037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IMMessageKeys$Slots f413038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f413039i;

    public static final class a implements com.ss.android.lark.blueprint.k<View>, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f413040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f413041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f413042c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final EllipsizedEmojiconTextView f413043d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f413044e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final LKUIRoundableLayout f413045f;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ThreadReplyBlock$a$a, reason: collision with other inner class name */
        public static final class C4805a {
        }

        static {
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b
        public final LKUIRoundableLayout a() {
            return this.f413045f;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b
        public final EllipsizedEmojiconTextView b() {
            return this.f413043d;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b
        public final ImageView c() {
            return this.f413044e;
        }

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f413040a;
        }

        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f413040a = r100;
            this.f413041b = r100.findViewById(R.id.thread_reply_bubble);
            TextView r101 = (TextView) r100.findViewById(R.id.thread_reply_name);
            this.f413042c = r101;
            EllipsizedEmojiconTextView r102 = (EllipsizedEmojiconTextView) r100.findViewById(R.id.thread_reply_content_text);
            this.f413043d = r102;
            this.f413044e = (ImageView) r100.findViewById(R.id.thread_reply_content_image);
            LKUIRoundableLayout r103 = (LKUIRoundableLayout) r100.findViewById(R.id.thread_reply_image_container);
            this.f413045f = r103;
            r103.setRadius(4.0f);
            r103.setBorderWidth(1.0f);
            Context r104 = r100.getContext();
            LarkFont r105 = LarkFont.BODY1;
            zz7.a.d(r101, r105);
            zz7.a.d(r102, r105);
            r102.setEmojiconSize(zz7.b.g(r104, 16));
            r102.setEmojiconTextSize((int) zz7.b.i(r104, r105));
        }
    }

    public static final class b implements com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> f413046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ThreadReplyBlock f413047b;

        public b(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, ThreadReplyBlock r101) {
            this.f413046a = r100;
            this.f413047b = r101;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.c
        public final void a(com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b r100, y6b.c<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            com.ss.android.lark.blueprint.m<y6b.a<?>> r102 = this.f413046a;
            if ((r102 instanceof e6b.b) == false) goto L5;
            e6b.b r103 = (e6b.b) r102;
        L6:
            if (r103 == null) goto L9;
            r103.j(this.f413047b, r101);
            return;
        L9:
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.c
        public final boolean b(com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b r100, y6b.c<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            com.ss.android.lark.blueprint.m<y6b.a<?>> r102 = this.f413046a;
            if ((r102 instanceof e6b.b) == false) goto L5;
            e6b.b r103 = (e6b.b) r102;
        L6:
            if (r103 != null) goto L10;
            return false;
        L10:
            return r103.e(this.f413047b, r101);
        L5:
            r103 = null;
            goto L6
        }
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f413037g;
    }

    public ThreadReplyBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f413037g = IMMessageKeys$Blocks.THREAD_REPLY;
        this.f413038h = IMMessageKeys$Slots.HEADER;
        this.f413039i = LazyKt.lazy(new ThreadReplyBlock$threadReplyContentRender$2(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        g(r101, this.f413037g, this.f413038h);
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r210, com.ss.android.lark.blueprint.q<y6b.a<?>> r211, y6b.a<?> r212) {
        Intrinsics.checkNotNullParameter(r210, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r211, "layout");
        Intrinsics.checkNotNullParameter(r212, "data");
        if ((r212 instanceof y6b.c) == false) goto L5;
        y6b.c r100 = (y6b.c) r212;
    L6:
        if (r100 != null) goto L10;
        g(r211, this.f413037g, this.f413038h);
        return;
    L10:
        if (r100.G1 == 0) goto L163;
        int r101 = com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.h.f412187a;
        m2b.a r102 = this.f412673c;
        Intrinsics.checkNotNullParameter(r102, "chatContext");
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Chat r103 = r102.getChat();
        boolean r110 = true;
        boolean r111 = false;
        if (r103 != null) goto L15;
        Log.w("ThreadReplyBlockRender", "stop binding for chat is null.");
    L26:
        boolean r104 = false;
    L28:
        if (r104 == false) goto L163;
        a r105 = (a) r211.c(this.f413037g, this.f413038h, new ThreadReplyBlock$update$blockView$1(this));
        if ((r211 instanceof l3b.a) == false) goto L33;
        l3b.a r106 = (l3b.a) r211;
    L34:
        if (r106 == null) goto L37;
        u5b.c r107 = r106.j();
        if (r107 == null) goto L37;
    L48:
        Intrinsics.checkNotNull(r107);
        int[] r108 = r107.f548907d;
        r105.f413040a.setPadding(r108[0], r108[1], r108[2], r108[3]);
        r105.f413041b.setVisibility(0);
        r105.f413041b.setBackground(r107.f548906c);
        r105.f413042c.setTextColor(r107.f548904a);
        r105.f413043d.setTextColor(r107.f548905b);
        y6b.c r112 = r100.f566518y1;
        if (r112 == null) goto L168;
        y6b.b r109 = r112.f566508t;
        if (r109 == null) goto L53;
        TextView r113 = r105.f413042c;
        StringCompanionObject r114 = StringCompanionObject.INSTANCE;
        ((com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d) this.f413039i.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r109, "chatterVO");
        r113.setText(String.format("%s: ", Arrays.copyOf(new Object[]{UIHelper.mustacheFormat(R.string.Lark_Legacy_ReplySomebody, "name", UIHelper.mustacheFormat(R.string.Lark_Group_NamesTopic, "name", r109.f566460i))}, 1)));
    L53:
        TextView r115 = r105.f413042c;
        if (r109 == null) goto L56;
        boolean r116 = true;
    L58:
        if (r116 == false) goto L60;
        int r117 = 0;
    L61:
        r115.setVisibility(r117);
        ((com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d) this.f413039i.getValue()).f412172c = new b(r210, this);
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d r118 = (com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d) this.f413039i.getValue();
        r118.getClass();
        Intrinsics.checkNotNullParameter(r112, "threadReplyMessageVO");
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r105, "holder");
        Intrinsics.checkNotNullParameter(r107, "threadReplyStyle");
        r105.f413043d.setVisibility(0);
        r105.f413044e.setVisibility(8);
        r105.f413045f.setVisibility(8);
        if (r112.j() == false) goto L69;
        if (r112.f566514x != Message.RecallerIdentity.ENTERPRISE_ADMINISTRATOR) goto L66;
        String r119 = UIHelper.getString(R.string.Lark_IM_MessageRecalledByAdmin_Text);
    L67:
        Function2<String, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b, Unit> r120 = r118.f412168a;
        Intrinsics.checkNotNull(r119);
        r120.invoke(r119, r105);
    L79:
        boolean r121 = true;
    L81:
        if (r121 == true) goto L169;
        r105.f413043d.setVisibility(8);
        r105.f413044e.setVisibility(0);
        r105.f413045f.setVisibility(0);
        int r122 = com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d.b.f412173a[r112.getType().ordinal()];
        if (r122 == 1) goto L88;
        if (r122 == 2) goto L87;
        String r123 = "threadReplyStyle";
        y6b.c r124 = r112;
    L119:
        if (r111 == true) goto L170;
        r105.f413043d.setVisibility(0);
        r105.f413044e.setVisibility(8);
        r105.f413045f.setVisibility(8);
        r105.f413043d.setTranslateEmojiCode(false);
        EllipsizedEmojiconTextView r125 = r105.f413043d;
        int r126 = h18.e.f483540a;
        FragmentActivity r127 = r118.f412171b.getContext();
        if (r124.getType() != Message.Type.POST) goto L124;
        int r128 = 1;
    L125:
        r125.setTypeface(h18.e.b(r127, r128));
        Intrinsics.checkNotNullParameter(r124, "<this>");
        CharSequence r129 = r124.H0;
        if (r129 != null) goto L128;
    L131:
        boolean r130 = true;
    L132:
        if (r130 == true) goto L134;
    L138:
        if (r129 == null) goto L148;
        MessageEditInfo r131 = r124.C;
        if (r131 != null) goto L142;
    L144:
        r110 = false;
    L145:
        if (r110 == false) goto L147;
        String r132 = UIHelper.getString(R.string.Lark_IM_EditMessage_Edited_Label);
        SpannableStringBuilder r133 = new SpannableStringBuilder(r132);
        Intrinsics.checkNotNull(r132);
        int r134 = 0;
        r133.setSpan(new com.ss.android.lark.widget.span.i0(r132, UIHelper.getColor(R.color.text_caption), h18.d.a(r118.f412171b.getContext(), 12.0f)), 0, r133.length(), 33);
        SpannableStringBuilder r135 = r133.insert(0, r129);
    L149:
        r129 = r135;
    L150:
        SpannableStringBuilder r136 = new SpannableStringBuilder(r129);
        Iterator r137 = ArrayIteratorKt.iterator((ncc.e[]) r136.getSpans(r134, r136.length(), ncc.e.class));
    L152:
        if (r137.hasNext() == false) goto L161;
        ncc.e r138 = (ncc.e) r137.next();
        Intrinsics.checkNotNull(r138);
        Intrinsics.checkNotNullParameter(r138, "span");
        String r139 = r123;
        Intrinsics.checkNotNullParameter(r107, r139);
        Intrinsics.checkNotNullParameter(r105, "holder");
        Drawable r140 = r138.f518726c;
        if (r140 == null) goto L156;
        r140.mutate();
        r140.setTint(r107.f548905b);
    L156:
        r138.a(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.a(r107, r105.f413043d));
        if (r138.f518725b == null) goto L160;
        Paint r141 = new Paint();
        r141.setColorFilter(new PorterDuffColorFilter(r107.f548905b, PorterDuff.Mode.SRC_IN));
        Bitmap r142 = Bitmap.createBitmap(r138.f518725b.getWidth(), r138.f518725b.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(r142).drawBitmap(r138.f518725b, 0.0f, 0.0f, r141);
        r138.f518725b = r142;
    L160:
        r123 = r139;
        goto L152
    L161:
        r105.f413043d.setText(r136);
        return;
    L147:
        r134 = 0;
        goto L150
    L142:
        if (r131.isEdited() != true) goto L144;
    L148:
        r134 = 0;
        r135 = null;
        goto L149
    L134:
        if (r124.L0 == null) goto L138;
        Log.d("CommonThreadReplyContentRender", "generator displayText.");
        y6b.c.b r143 = r124.L0;
        if (r143 == null) goto L138;
        u2b.b r144 = (u2b.b) r143;
        r129 = r144.f548489a.d(r144.f548490b);
        goto L138
    L128:
        if (r129.length() == 0) goto L131;
        r130 = false;
        goto L132
    L124:
        r128 = 0;
        goto L125
    L170:
        return;
    L87:
        r105.f413045f.setBorderColor(UIHelper.getColor(R.color.transparent));
        r105.f413045f.setBorderWidth(0.0f);
        r105.f413045f.setRadius(3.0f);
        ViewGroup.LayoutParams r145 = r105.f413044e.getLayoutParams();
        r145.width = -2;
        r145.height = -2;
        r105.f413044e.setLayoutParams(r145);
        r105.f413044e.setImageResource(R.drawable.icon_red_packet_reply_holder);
        r105.f413044e.setOnClickListener(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.g(r118, r105, r100));
        r123 = "threadReplyStyle";
        r124 = r112;
    L118:
        r111 = true;
        goto L119
    L88:
        LKUIRoundableLayout r146 = r105.f413045f;
        boolean r147 = r100.f566492i;
        int r148 = p3b.a.W;
        if (r147 == false) goto L91;
        int r149 = v4b.a.f553170h;
    L92:
        r146.setBorderColor(r149);
        ViewGroup.LayoutParams r150 = r105.f413044e.getLayoutParams();
        int r151 = UIHelper.dp2px(40.0f);
        if (r150.width == r151) goto L95;
    L96:
        r150.width = r151;
        r150.height = r151;
        r105.f413044e.setLayoutParams(r150);
    L97:
        ValidateResult r152 = MessagePermissionUtil.b();
        boolean r153 = MessagePermissionUtil.f(r112, r118.f412171b.getChat(), r152);
        ValidateIMFileResult r154 = r112.F;
        if (r154 == null) goto L100;
        IMFileResult r155 = r154.getResultType();
    L101:
        MessagePermissionUtil.ReceiveAuthorizationState r156 = MessagePermissionUtil.h(r155);
        ImageView r157 = r105.f413044e;
        r123 = "threadReplyStyle";
        r157.setOnClickListener(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.e(r112, r118, r156, r153, r152, r100, r157));
        r105.f413044e.setOnLongClickListener(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.f(r118, r105, r100));
        ResourceCleanScene r158 = lpc.a.b(r112);
        if (r158 != null) goto L104;
    L106:
        boolean r159 = false;
    L107:
        if (r159 == false) goto L109;
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d.a(r105);
        r124 = r112;
        goto L118
    L109:
        if (r153 == true) goto L111;
    L117:
        r124 = r112;
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.d.a(r105);
        goto L118
    L111:
        if (MessagePermissionUtil.g(r156) == true) goto L117;
        FragmentActivity r160 = r118.f412171b.getContext();
        ImageView r161 = r105.f413044e;
        r124 = r112;
        T r162 = r124.f566500o;
        if ((r162 instanceof ImageContentVO) == false) goto L115;
        ImageContentVO r163 = (ImageContentVO) r162;
    L116:
        h7b.i.e(r160, r161, r163);
        goto L118
    L115:
        r163 = null;
        goto L116
    L104:
        if (r158.isCSAMDelete() != true) goto L106;
        r159 = true;
        goto L107
    L100:
        r155 = null;
        goto L101
    L95:
        if (r150.height == r151) goto L97;
    L91:
        r149 = v4b.a.G;
        goto L92
    L169:
        return;
    L66:
        r119 = UIHelper.getString(R.string.Lark_Legacy_MessageIsrecalled);
        goto L67
    L69:
        if (r112.f566493j == false) goto L72;
        String r164 = UIHelper.getString(R.string.Lark_Legacy_MessageRemove);
        Function2<String, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b, Unit> r165 = r118.f412168a;
        Intrinsics.checkNotNull(r164);
        r165.invoke(r164, r105);
        goto L79
    L72:
        if (r112.f566517y == false) goto L75;
        String r166 = UIHelper.getString(R.string.Lark_IMSecureKey_InvalidChatSecureKeyCantDisplayContent_Text);
        Function2<String, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b, Unit> r167 = r118.f412168a;
        Intrinsics.checkNotNull(r166);
        r167.invoke(r166, r105);
        goto L79
    L75:
        if (r112.Y == true) goto L77;
    L80:
        r121 = false;
        goto L81
    L77:
        if (r112.f566502p0 == false) goto L80;
        String r168 = UIHelper.getString(R.string.Lark_IM_MsgDeleted_Desc);
        Function2<String, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply.b, Unit> r169 = r118.f412168a;
        Intrinsics.checkNotNull(r168);
        r169.invoke(r168, r105);
        goto L79
    L60:
        r117 = 8;
        goto L61
    L56:
        r116 = false;
        goto L58
    L168:
        return;
    L37:
        boolean r170 = r100.f566492i;
        int r171 = p3b.a.W;
        if (r170 == false) goto L40;
        int r172 = v4b.a.f553171i;
    L41:
        if (r170 == false) goto L43;
        int r173 = v4b.a.f553171i;
    L44:
        if (r170 == false) goto L46;
        int r174 = v4b.a.f553186x;
    L47:
        Drawable r175 = UIHelper.getDrawable(r174);
        u5b.c r176 = u5b.c.f548903e;
        r107 = u5b.c.a.a(r172, r173, r175, null);
        goto L48
    L46:
        r174 = v4b.a.T;
        goto L47
    L43:
        r173 = v4b.a.H;
        goto L44
    L40:
        r172 = v4b.a.H;
        goto L41
    L33:
        r106 = null;
        goto L34
    L15:
        if (r100.f566499n >= (r103.getFirstMessagePosition() + 1)) goto L17;
        boolean r177 = true;
    L18:
        if (r177 == false) goto L20;
        Log.w("ThreadReplyBlockRender", "stop binding for thread message is preMsg.");
        goto L26
    L20:
        y6b.c<T> r178 = r100.f566518y1;
        if (r178 != 0) goto L24;
        Log.w("ThreadReplyBlockRender", "stop binding for thread reply messageVO is null.");
        goto L26
    L24:
        if (r178.f566494k == true) goto L27;
        Log.w("ThreadReplyBlockRender", "stop binding for thread reply message is invisible, its id is " + r178.f566482c);
        goto L26
    L27:
        r104 = true;
        goto L28
    L17:
        r177 = false;
    L163:
        g(r211, this.f413037g, this.f413038h);
        return;
    L5:
        r100 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
