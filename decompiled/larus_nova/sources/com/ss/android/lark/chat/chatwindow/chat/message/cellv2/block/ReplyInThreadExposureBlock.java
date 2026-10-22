package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.message.MessageLink;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.l1;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import z5c.p3;
import z5c.t3;

/* JADX INFO: loaded from: classes35.dex */
public final class ReplyInThreadExposureBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.c<v5b.a<?>>, v5b.a<?>> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412920g;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<ConstraintLayout>, com.ss.android.lark.blueprint.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConstraintLayout f412921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Group f412922b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f412923c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f412924d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ThreadReplyExposureView f412925e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f412926f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ConstraintLayout f412927g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final View f412928h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final StackSlot.a.C4807a.C4808a f412929i;

        @Override // com.ss.android.lark.blueprint.t
        public final com.ss.android.lark.blueprint.s a() {
            return this.f412929i;
        }

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412921a;
        }

        public b(ConstraintLayout r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412921a = r100;
            this.f412922b = (Group) r100.findViewById(R.id.thread_reply_count_group);
            TextView r101 = (TextView) r100.findViewById(R.id.thread_reply_count);
            this.f412923c = r101;
            this.f412924d = r100.findViewById(R.id.no_more_reply_divider);
            this.f412925e = (ThreadReplyExposureView) r100.findViewById(R.id.replies);
            TextView r102 = (TextView) r100.findViewById(R.id.reply_thread_button);
            this.f412926f = r102;
            this.f412927g = r100;
            this.f412928h = r100.findViewById(R.id.reply_count_divider);
            StackSlot.a.f413325a.getClass();
            this.f412929i = StackSlot.a.C4807a.f413327b;
            zz7.a.c(r101, 12);
            zz7.a.c(r102, 14);
            Context r103 = r100.getContext();
            int r104 = zz7.b.g(r103, 16);
            Drawable r105 = UDIconUtils.getIconDrawable(r103, R.drawable.ud_icon_reply_cn_outlined, y9c.d.c(r103, R.color.text_placeholder));
            r105.setBounds(0, 0, r104, r104);
            r102.setCompoundDrawablePadding(UIUtils.dp2px(r103, 7.0f));
            r102.setCompoundDrawables(r105, null, null, null);
        }
    }

    public static final class c implements ThreadReplyExposureView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y6b.c<v5b.a<?>> f412930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ReplyInThreadExposureBlock f412931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View.OnLongClickListener f412932c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f412933d;

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView.b
        public final void a() {
            this.f412932c.onLongClick(this.f412933d.f412925e);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView.b
        public final void b(y6b.c<?> r110, com.ss.android.lark.biz.im.api.n0 r111) {
            Intrinsics.checkNotNullParameter(r110, "rootMessage");
            Intrinsics.checkNotNullParameter(r111, "replyMessage");
            String r100 = this.f412930a.f566482c;
            String r101 = r110.Q1;
            boolean r102 = false;
            if (r101 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L11;
            String r112 = r110.f566482c;
        L12:
            String r104 = this.f412931b.f412673c.getChatId();
            int r113 = r111.b();
            ReplyInThreadExposureBlock r105 = this.f412931b;
            v4b.c r106 = r105.f412676f;
            if (r106 == null) goto L15;
            MessageLink.ChatInfo r107 = r106.f553196g;
        L16:
            if (r107 == null) goto L24;
            MessageLink.ChatInfo r108 = r106.f553196g;
            if (r108 != null) goto L20;
        L22:
            if (r102 == false) goto L30;
            ReplyInThreadExposureBlock.h(this.f412931b, r112, r103, Integer.valueOf(r113), null);
            return;
        L30:
            return;
        L20:
            if (r108.isAuth() != true) goto L22;
            r102 = true;
            goto L22
        L24:
            b3b.f r109 = r105.f412674d;
            if (r109 == null) goto L32;
            if (r112 != null) goto L28;
            r112 = "";
        L28:
            r109.D(r100, r112, r104, Integer.valueOf(r113), null, this.f412931b.f412673c.R());
            return;
        L32:
            return;
        L15:
            r107 = null;
            goto L16
        L11:
            r112 = r110.Q1;
            goto L12
        L5:
            if (r101.length() == 0) goto L8;
            r103 = false;
            goto L9
        }

        public c(y6b.c r100, ReplyInThreadExposureBlock r101, e r102, b r103) {
            this.f412930a = r100;
            this.f412931b = r101;
            this.f412932c = r102;
            this.f412933d = r103;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f412934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.c<v5b.a<?>> f412935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReplyInThreadExposureBlock f412936c;

        public d(b r100, y6b.c<v5b.a<?>> r101, ReplyInThreadExposureBlock r102) {
            this.f412934a = r100;
            this.f412935b = r101;
            this.f412936c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            boolean r100 = Intrinsics.areEqual(r110, this.f412934a.f412926f);
            String r101 = this.f412935b.Q1;
            boolean r102 = false;
            if (r101 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            y6b.c<v5b.a<?>> r104 = this.f412935b;
            if (r103 == false) goto L12;
            String r105 = r104.f566482c;
        L15:
            ReplyInThreadExposureBlock r106 = this.f412936c;
            v4b.c r107 = r106.f412676f;
            ChatDisplayModeSetting r111 = null;
            if (r107 == null) goto L18;
            MessageLink.ChatInfo r108 = r107.f553196g;
        L19:
            if (r108 == null) goto L27;
            MessageLink.ChatInfo r109 = r107.f553196g;
            if (r109 != null) goto L23;
        L25:
            if (r102 == false) goto L31;
            ReplyInThreadExposureBlock.h(this.f412936c, r105, r103, null, Boolean.valueOf(r100));
        L31:
            if (Intrinsics.areEqual(r110, this.f412934a.f412926f) == false) goto L39;
            Chat r112 = this.f412936c.f412673c.getChat();
            if (r112 == null) goto L36;
            r111 = r112.getChatDisplayModeSetting();
        L36:
            if (r111 != ChatDisplayModeSetting.THREAD) goto L40;
            s5c.a r113 = z5c.r.f570323g1;
            s5c.a r114 = p3.f570286g;
            r113.getClass();
            Statistics.sendEvent("im_chat_main_click", s5c.d.b.b(r113, r114).plus(t3.f570376c.a(r105)).plus(ChatParamUtils.e()).toJson());
            return;
        L40:
            return;
        L39:
            return;
        L23:
            if (r109.isAuth() != true) goto L25;
            r102 = true;
            goto L25
        L27:
            b3b.f r115 = r106.f412674d;
            if (r115 == null) goto L31;
            r115.D(r104.f566482c, r105, r106.f412673c.getChatId(), null, Boolean.valueOf(r100), this.f412936c.f412673c.R());
            goto L31
        L18:
            r108 = null;
            goto L19
        L12:
            r105 = r104.Q1;
            if (r105 != null) goto L15;
            r105 = "";
            goto L15
        L5:
            if (r101.length() == 0) goto L8;
            r103 = false;
            goto L9
        }
    }

    public static final class e implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.c<v5b.a<?>>> f412937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ReplyInThreadExposureBlock f412938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y6b.c<v5b.a<?>> f412939c;

        public e(com.ss.android.lark.blueprint.m<y6b.c<v5b.a<?>>> r100, ReplyInThreadExposureBlock r101, y6b.c<v5b.a<?>> r102) {
            this.f412937a = r100;
            this.f412938b = r101;
            this.f412939c = r102;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            com.ss.android.lark.blueprint.m<y6b.c<v5b.a<?>>> r101 = this.f412937a;
            if ((r101 instanceof e6b.b) == false) goto L5;
            e6b.b r102 = (e6b.b) r101;
        L6:
            if (r102 == null) goto L10;
            r102.e(this.f412938b, this.f412939c);
            return true;
        L10:
            return true;
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412920g;
    }

    public ReplyInThreadExposureBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412920g = IMMessageKeys$Blocks.REPLY_IN_THREAD_EXPOSURE;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.c<v5b.a<?>>> r100, com.ss.android.lark.blueprint.q<y6b.c<v5b.a<?>>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        g(r101, this.f412920g, IMMessageKeys$Slots.FOOTER);
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.c<v5b.a<?>>> r110, com.ss.android.lark.blueprint.q<y6b.c<v5b.a<?>>> r111, y6b.c<v5b.a<?>> r112) {
        Intrinsics.checkNotNullParameter(r110, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r111, "layout");
        Intrinsics.checkNotNullParameter(r112, "data");
        boolean r100 = true;
        if (r112.d() == true) goto L5;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L13;
        g(r111, this.f412920g, IMMessageKeys$Slots.FOOTER);
        return;
    L13:
        b r113 = (b) r111.c(this.f412920g, IMMessageKeys$Slots.FOOTER, new ReplyInThreadExposureBlock$update$blockView$1(this));
        e r102 = new e(r110, this, r112);
        d r114 = new d(r113, r112, this);
        r113.f412921a.setOnClickListener(r114);
        r113.f412921a.setOnLongClickListener(r102);
        r113.f412925e.f(r112, r112.f566488g2);
        int r103 = r113.f412925e.getShowingReplyCount();
        if (r112.T1 > r103) goto L16;
        r113.f412922b.setVisibility(8);
        r113.f412924d.setVisibility(0);
        r113.f412923c.setOnClickListener(null);
    L17:
        if (r103 >= 1) goto L19;
        r113.f412925e.setVisibility(8);
    L20:
        r113.f412925e.setOnClickReplyListener(new c(r112, this, r102, r113));
        r113.f412926f.setOnClickListener(r114);
        r113.f412926f.setOnLongClickListener(r102);
        ViewGroup.LayoutParams r115 = r113.f412927g.getLayoutParams();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        int r104 = com.ss.android.lark.chat.utils.f0.f416667a;
        Intrinsics.checkNotNullParameter(r112, "messageVO");
        if (r112.f566481b2 != ChatDisplayModeSetting.THREAD) goto L23;
        boolean r105 = true;
    L24:
        if (r105 == true) goto L35;
        T r117 = r112.f566500o;
        if ((r117 instanceof com.ss.android.lark.message.card.view.a) == false) goto L28;
    L30:
        r100 = false;
    L32:
        if (l1.a() == false) goto L37;
        if (r100 == false) goto L38;
        Drawable r118 = UDIconUtils.getIconDrawable(this.f412673c.getContext(), R.drawable.ud_icon_reply_cn_outlined, y9c.d.c(this.f412673c.getContext(), R.color.icon_n2), new UDDimension.Dp(16));
        r113.f412926f.setCompoundDrawablePadding(UIUtils.dp2px(this.f412673c.getContext(), 7.0f));
        r113.f412926f.setCompoundDrawables(r118, null, null, null);
        r113.f412926f.setTextColor(UDColorUtils.getColor(this.f412673c.getContext(), R.color.icon_n2));
        r116.width = -2;
        r113.f412927g.setLayoutParams(r116);
        return;
    L38:
        return;
    L37:
        return;
    L28:
        if ((r117 instanceof LynxCardContentVO) == true) goto L30;
    L35:
        r113.f412925e.getLayoutParams().width = -1;
        r113.f412924d.getLayoutParams().width = -1;
        r113.f412928h.getLayoutParams().width = 0;
        r116.width = -1;
        r113.f412927g.setLayoutParams(r116);
        return;
    L23:
        r105 = false;
        goto L24
    L19:
        r113.f412925e.setVisibility(0);
        goto L20
    L16:
        r113.f412922b.setVisibility(0);
        r113.f412924d.setVisibility(8);
        int r106 = r112.T1 - r103;
        r113.f412923c.setText(UIHelper.getQuantityString(R.plurals.Lark_IM_SwitchedTopicGroup_ViewNumMoreTopicReplies_Text, r106));
        r113.f412923c.setOnClickListener(r114);
        goto L17
    L5:
        if (this.f412673c.q8() == false) goto L7;
    L8:
        r101 = true;
        goto L10
    L7:
        if (this.f412673c.e0() == false) goto L9;
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.c) r102);
    }

    public static final void h(ReplyInThreadExposureBlock r100, String r101, boolean r102, Integer r103, Boolean r104) {
        mya.t r105 = (mya.t) r100.f412673c.j5().b(mya.t.class);
        if (r105 == null) goto L8;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        r105.o(r101, r100.f412673c.getChatId(), r103, r104);
        return;
    }
}
