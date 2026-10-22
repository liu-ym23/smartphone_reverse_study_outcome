package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.coremd.utils.MessageStyleHelper;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPoint;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
public class ReplyBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f412903h;

    public static final class a implements com.ss.android.lark.blueprint.k<View>, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f412904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f412905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f412906c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final EllipsizedEmojiconTextView f412907d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final EllipsizedEmojiconTextView f412908e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ImageView f412909f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final LKUIRoundableLayout f412910g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final View f412911h;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b
        public final EllipsizedEmojiconTextView a() {
            return this.f412908e;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b
        public final ImageView b() {
            return this.f412909f;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b
        public final LKUIRoundableLayout c() {
            return this.f412910g;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b
        public final EllipsizedEmojiconTextView d() {
            return this.f412907d;
        }

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412904a;
        }

        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412904a = r100;
            this.f412905b = r100.findViewById(R.id.reply_bubble);
            TextView r101 = (TextView) r100.findViewById(R.id.reply_name);
            this.f412906c = r101;
            EllipsizedEmojiconTextView r102 = (EllipsizedEmojiconTextView) r100.findViewById(R.id.reply_content_text);
            this.f412907d = r102;
            this.f412908e = (EllipsizedEmojiconTextView) r100.findViewById(R.id.reply_content_thread);
            this.f412909f = (ImageView) r100.findViewById(R.id.reply_content_image);
            LKUIRoundableLayout r103 = (LKUIRoundableLayout) r100.findViewById(R.id.reply_image_container);
            this.f412910g = r103;
            this.f412911h = r100.findViewById(R.id.reply_left_layout);
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

    public static final class b implements com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> f412912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ReplyBlock f412913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y6b.a<?> f412914c;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c.a
        public final boolean a(com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b r100, y6b.c<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            com.ss.android.lark.blueprint.m<y6b.a<?>> r102 = this.f412912a;
            if ((r102 instanceof e6b.b) == false) goto L5;
            e6b.b r103 = (e6b.b) r102;
        L6:
            if (r103 != null) goto L10;
            return false;
        L10:
            return r103.e(this.f412913b, this.f412914c);
        L5:
            r103 = null;
            goto L6
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c.a
        public final void b(com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b r100, y6b.c<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            ReplyBlock.h(this.f412913b, (y6b.c) this.f412914c);
        }

        public b(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, ReplyBlock r101, y6b.a<?> r102) {
            this.f412912a = r100;
            this.f412913b = r101;
            this.f412914c = r102;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplyBlock f412915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.a<?> f412916b;

        public c(ReplyBlock r100, y6b.a<?> r101) {
            this.f412915a = r100;
            this.f412916b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ReplyBlock.h(this.f412915a, (y6b.c) this.f412916b);
        }
    }

    public static final class d implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> f412917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ReplyBlock f412918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y6b.a<?> f412919c;

        public d(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, ReplyBlock r101, y6b.a<?> r102) {
            this.f412917a = r100;
            this.f412918b = r101;
            this.f412919c = r102;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            com.ss.android.lark.blueprint.m<y6b.a<?>> r101 = this.f412917a;
            if ((r101 instanceof e6b.b) == false) goto L5;
            e6b.b r102 = (e6b.b) r101;
        L6:
            if (r102 != null) goto L10;
            return false;
        L10:
            return r102.e(this.f412918b, this.f412919c);
        L5:
            r102 = null;
            goto L6
        }
    }

    public com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.h i() {
        return (com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.h) this.f412903h.getValue();
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412902g;
    }

    public ReplyBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412902g = IMMessageKeys$Blocks.REPLY;
        this.f412903h = LazyKt.lazy(new ReplyBlock$replyBlockRender$2(this));
    }

    public static final void h(ReplyBlock r100, y6b.c r101) {
        if (r100.f412673c.e0() == true) goto L12;
        Fragment r102 = r100.f412673c.R();
        if (r102 == null) goto L9;
        Lazy r103 = ForsetiConfig.f424749a;
        if (ForsetiConfig.a(r100.f412673c.getContext()) == false) goto L9;
        ChatCoreModule.a().getChatDependency().u(r100.f412673c.getContext(), r101.f566482c, z5c.u0.f570380d.f540772b, r102);
    L10:
        ChatHitPoint.a("parentMessage");
        return;
    L9:
        ChatCoreModule.a().getChatDependency().h(r100.f412673c.getContext(), r101.f566482c, z5c.u0.f570380d.f540772b);
        goto L10
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r110, com.ss.android.lark.blueprint.q<y6b.a<?>> r111, y6b.a<?> r210) {
        Intrinsics.checkNotNullParameter(r110, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r111, "layout");
        Intrinsics.checkNotNullParameter(r210, "data");
        y6b.b r100 = null;
        if ((r210 instanceof y6b.c) == false) goto L5;
        y6b.c r101 = (y6b.c) r210;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        a r102 = (a) r111.c(this.f412902g, IMMessageKeys$Slots.HEADER, new ReplyBlock$update$blockView$1(this));
        boolean r103 = MessageStyleHelper.b(r210);
        com.ss.android.lark.biz.im.api.message.params.v r104 = (com.ss.android.lark.biz.im.api.message.params.v) this.f412673c.d0(com.ss.android.lark.biz.im.api.message.params.v.class);
        int r105 = 0;
        if (r104 == null) goto L72;
        Context r106 = r102.f412904a.getContext();
        Float r107 = r104.f410384d;
        if (r107 == null) goto L14;
        float r108 = r107.floatValue();
    L15:
        float r109 = RangesKt.coerceIn(r108, 0.0f, 1.0f);
        Float r112 = r104.f410383c;
        if (r112 == null) goto L18;
        float r113 = r112.floatValue();
    L19:
        float r114 = RangesKt.coerceIn(r113, 0.0f, 1.0f);
        r102.f412906c.setAlpha(r109);
        r102.f412907d.setAlpha(r109);
        r102.f412908e.setAlpha(r109);
        r102.f412905b.setAlpha(r114);
        com.ss.android.lark.biz.im.api.message.params.o r115 = r104.f410381a;
        if (r115 == null) goto L25;
        if (r103 == false) goto L23;
        int r116 = r115.f410372a;
    L24:
        Intrinsics.checkNotNull(r106);
        int r117 = UDColorUtils.getColor(r106, r116);
        r102.f412906c.setTextColor(r117);
        r102.f412907d.setTextColor(r117);
        r102.f412908e.setTextColor(r117);
        goto L25
    L23:
        r116 = r115.f410373b;
    L25:
        com.ss.android.lark.biz.im.api.message.params.o r118 = r104.f410382b;
        if (r118 == null) goto L34;
        if (r103 == false) goto L29;
        int r119 = r118.f410372a;
    L30:
        Intrinsics.checkNotNull(r106);
        int r120 = UDColorUtils.getColor(r106, r119);
        Drawable r121 = r102.f412905b.getBackground();
        if (r121 == null) goto L72;
        Drawable r122 = DrawableCompat.wrap(r121).mutate();
        DrawableCompat.setTint(r122, r120);
        r102.f412905b.setBackground(r122);
        goto L34
    L29:
        r119 = r118.f410373b;
    L34:
        Float r123 = r104.f410385e;
        if (r123 == null) goto L37;
        float r124 = r123.floatValue();
        ViewGroup.LayoutParams r125 = r102.f412909f.getLayoutParams();
        int r126 = UIUtils.dp2px(getContext(), r124);
        r125.width = r126;
        r125.height = r126;
        r102.f412909f.setLayoutParams(r125);
    L37:
        Boolean r127 = r104.f410386f;
        if (r127 != null) goto L40;
    L66:
        Boolean r128 = r104.f410386f;
        if (r128 == null) goto L72;
        if (r128.booleanValue() == false) goto L71;
        r102.f412909f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        goto L72
    L71:
        r102.f412909f.setScaleType(ImageView.ScaleType.FIT_CENTER);
        goto L72
    L40:
        if (r127.booleanValue() == false) goto L54;
        ViewGroup.LayoutParams r129 = r102.f412909f.getLayoutParams();
        if ((r129 instanceof FrameLayout.LayoutParams) == false) goto L44;
        FrameLayout.LayoutParams r130 = (FrameLayout.LayoutParams) r129;
    L46:
        if (r130 == null) goto L48;
        r130.gravity = 16;
    L48:
        ViewGroup.LayoutParams r131 = r102.f412911h.getLayoutParams();
        if ((r131 instanceof FrameLayout.LayoutParams) == false) goto L51;
        FrameLayout.LayoutParams r132 = (FrameLayout.LayoutParams) r131;
    L52:
        if (r132 == null) goto L66;
        r132.gravity = 16;
        goto L66
    L51:
        r132 = null;
        goto L52
    L44:
        r130 = null;
        goto L46
    L54:
        ViewGroup.LayoutParams r133 = r102.f412909f.getLayoutParams();
        if ((r133 instanceof FrameLayout.LayoutParams) == false) goto L57;
        FrameLayout.LayoutParams r134 = (FrameLayout.LayoutParams) r133;
    L58:
        if (r134 == null) goto L60;
        r134.gravity = 0;
    L60:
        ViewGroup.LayoutParams r135 = r102.f412911h.getLayoutParams();
        if ((r135 instanceof FrameLayout.LayoutParams) == false) goto L63;
        FrameLayout.LayoutParams r136 = (FrameLayout.LayoutParams) r135;
    L64:
        if (r136 == null) goto L66;
        r136.gravity = 0;
        goto L66
    L63:
        r136 = null;
        goto L64
    L57:
        r134 = null;
        goto L58
    L18:
        r113 = 1.0f;
        goto L19
    L14:
        r108 = 1.0f;
    L72:
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.h r137 = i();
        y6b.c r138 = (y6b.c) r210;
        boolean r139 = MessageStyleHelper.b(r210);
        int r140 = p3b.a.W;
        if (r139 == false) goto L75;
        int r141 = v4b.a.f553171i;
    L76:
        if (r139 == false) goto L78;
        int r142 = v4b.a.f553186x;
    L79:
        Drawable r143 = UIHelper.getDrawable(r142);
        u5b.b r144 = u5b.b.f548898e;
        r144.f548899a = r141;
        r144.f548900b = r141;
        r144.f548901c = r143;
        r144.f548902d = new int[]{0, 0, 0, 0};
        b r145 = new b(r110, this, r210);
        r137.getClass();
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r138, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r144, "replyStyle");
        r137.f412158b.a(r145);
        r102.getClass();
        if (TextUtils.isEmpty(r138.R) == false) goto L85;
        View r146 = r102.f412904a;
        if (r146 == null) goto L84;
        r146.setVisibility(8);
    L84:
        r102.f412905b.setVisibility(8);
    L135:
        r102.f412904a.setOnClickListener(new c(this, r210));
        r102.f412904a.setOnLongClickListener(new d(r110, this, r210));
        return;
    L85:
        Chat r147 = r137.f412157a.getChat();
        boolean r148 = true;
        if (r147 != null) goto L89;
    L117:
        boolean r149 = false;
    L118:
        if (r149 == false) goto L134;
        r102.f412904a.setVisibility(0);
        int[] r150 = r144.f548902d;
        r102.f412904a.setPadding(r150[0], r150[1], r150[2], r150[3]);
        r102.f412905b.setVisibility(0);
        r102.f412905b.setBackground(r144.f548901c);
        r102.f412906c.setTextColor(r144.f548899a);
        r102.f412907d.setTextColor(r144.f548900b);
        r102.f412908e.setTextColor(r144.f548900b);
        r102.f412906c.setVisibility(0);
        y6b.c<T> r151 = r138.f566511v1;
        if (r151 == 0) goto L122;
        r100 = r151.f566508t;
    L122:
        if (r100 == null) goto L124;
        TextView r152 = r102.f412906c;
        StringCompanionObject r153 = StringCompanionObject.INSTANCE;
        r152.setText(String.format("%s: ", Arrays.copyOf(new Object[]{r137.f412158b.b(r100)}, 1)));
    L124:
        TextView r154 = r102.f412906c;
        if (r100 != null) goto L128;
        r148 = false;
    L128:
        if (r148 == true) goto L131;
        r105 = 8;
    L131:
        r154.setVisibility(r105);
        y6b.c r155 = r138.f566511v1;
        if (r155 == null) goto L135;
        r137.f412158b.c(r155, r138, r102);
        goto L135
    L134:
        r102.f412904a.setVisibility(8);
        goto L135
    L89:
        if (r138.f566499n < (r147.getFirstMessagePosition() + 1)) goto L91;
    L95:
        boolean r156 = false;
    L97:
        if (r156 == false) goto L100;
        Log.w("ReplyBlockRender", "reply message is preMsg, skip bind");
    L100:
        if (r137.f412157a.Y() == true) goto L102;
    L104:
        y6b.c<T> r157 = r138.f566511v1;
        if (r157 != 0) goto L107;
        Log.w("ReplyBlockRender", "reply message vo is null,  skip bind");
    L110:
        y6b.c<T> r158 = r138.f566511v1;
        if (r158 == 0) goto L113;
        boolean r159 = r158.f566494k;
    L114:
        if (r159 == false) goto L117;
        if (r156 == true) goto L117;
        r149 = true;
        goto L118
    L113:
        r159 = false;
        goto L114
    L107:
        if (r157.f566494k == true) goto L110;
        Log.w("ReplyBlockRender", "reply message is invisible, id is" + r157.f566482c + ", skip bind");
        goto L110
    L102:
        if (r138.getType() == Message.Type.DOUBAO) goto L104;
    L91:
        if (r137.f412157a.e0() == true) goto L95;
        if (r137.f412157a.Y() == true) goto L95;
        r156 = true;
        goto L97
    L78:
        r142 = v4b.a.T;
        goto L79
    L75:
        r141 = v4b.a.H;
        goto L76
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
