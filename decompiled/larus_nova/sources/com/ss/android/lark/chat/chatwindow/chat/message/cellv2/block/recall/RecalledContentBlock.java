package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import b3b.f;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.message.params.u;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.ThreadMessageVO;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.base.view.vo.message.e;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.coremd.utils.MessageStyleHelper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.o;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.android.lark.widget.richtext.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import w4b.d0;

/* JADX INFO: loaded from: classes35.dex */
public final class RecalledContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<v5b.a<?>>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f413208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f413209h;

    public static final class a {
    }

    public static final class b implements k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f413210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkEmojiTextView f413211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f413212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AppCompatImageView f413213d;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f413210a;
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f413210a = r100;
            LinkEmojiTextView r101 = (LinkEmojiTextView) r100.findViewById(R.id.recall_text);
            this.f413211b = r101;
            TextView r102 = (TextView) r100.findViewById(R.id.recall_re_edit);
            this.f413212c = r102;
            AppCompatImageView r103 = (AppCompatImageView) r100.findViewById(R.id.recall_re_edit_arrow);
            this.f413213d = r103;
            zz7.a.c(r101, 17);
            zz7.a.c(r102, 17);
            zz7.a.a(r103, 16);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final j getKey() {
        return this.f413208g;
    }

    public RecalledContentBlock(g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f413208g = IMMessageKeys$Blocks.RECALLED_CONTENT;
        this.f413209h = LazyKt.lazy(LazyThreadSafetyMode.NONE, RecalledContentBlock$ntpService$2.INSTANCE);
    }

    public void update(m<y6b.a<v5b.a<?>>> r100, q<y6b.a<v5b.a<?>>> r101, y6b.a<v5b.a<?>> r110) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r110, "data");
        b r102 = (b) r101.c(this.f413208g, IMMessageKeys$Slots.CONTENT, RecalledContentBlock$update$blockView$1.INSTANCE);
        boolean r103 = MessageStyleHelper.b(r110);
        int r104 = p3b.a.W;
        if (r103 == false) goto L5;
        int r105 = v4b.a.f553167e;
    L6:
        r102.f413211b.setTextColor(r105);
        LinkEmojiTextView r106 = r102.f413211b;
        boolean r107 = MessageStyleHelper.b(r110);
        Context r108 = r106.getContext();
        if (r107 == false) goto L9;
        int r109 = v4b.a.f553173k;
    L10:
        if (r107 == false) goto L12;
        int r111 = v4b.a.f553172j;
    L13:
        if (r107 == false) goto L15;
        int r112 = v4b.a.f553172j;
    L16:
        int r113 = v2c.a.b(r108, R.color.primary_fill_solid_03);
        int r114 = v2c.a.b(r108, R.color.imtoken_message_text_bubbles_blue);
        r106.setAtTextColor(R.color.imtoken_message_text_bubbles_blue);
        r106.setAtSelfTextColor(R.color.static_white);
        r106.setAtSelfBgColor(R.color.primary_fill_default);
        r106.setAtOtherChatUserTextColor(r109);
        r106.setUrlTextColor(r111);
        r106.setPhoneTextColor(r112);
        r106.setHighlightColor(r113);
        r106.setDefaultAtUserColor(r114);
        if (r107 == false) goto L19;
        int r115 = v4b.a.f553174l;
    L20:
        r106.setDotReadColor(r115);
        if (r107 == false) goto L23;
        int r116 = v4b.a.f553175m;
    L24:
        r106.setDotUnreadColor(r116);
        r106.setIsUrlShowUnderLine(false);
        if (MessageStyleHelper.b(r110) == false) goto L27;
        int r117 = v4b.a.f553172j;
    L28:
        r102.f413212c.getPaint().setFlags(r102.f413212c.getPaint().getFlags() & (-9));
        boolean r118 = true;
        r102.f413212c.getPaint().setAntiAlias(true);
        r102.f413212c.setTextColor(r117);
        TextView r119 = r102.f413212c;
        boolean r120 = MessageStyleHelper.b(r110);
        StateListDrawable r121 = new StateListDrawable();
        ColorDrawable r122 = new ColorDrawable();
        if (r120 == false) goto L31;
        int r123 = v4b.a.f553176n;
    L32:
        r122.setColor(r123);
        ColorDrawable r124 = new ColorDrawable();
        r124.setColor(UIHelper.getColor(R.color.lkui_transparent));
        r121.addState(new int[]{android.R.attr.state_pressed}, r122);
        r121.addState(new int[]{-16842919}, r124);
        r119.setBackground(r121);
        v5b.a<?> r125 = r110.b();
        y6b.b r126 = r110.D();
        if (r110.H() == false) goto L38;
        if ((r125 instanceof e) == false) goto L38;
        String r127 = i.g(((e) r125).g(), false);
    L61:
        r102.f413211b.T(null, r127, false);
        r102.f413211b.setAtStringClickListner(new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall.a(this, r110));
        f r128 = this.f412674d;
        u r129 = (u) this.f412673c.d0(u.class);
        if (r129 == null) goto L64;
        boolean r130 = r129.f410380a;
    L66:
        if (r110.R() == true) goto L68;
    L74:
        r102.f413212c.setVisibility(8);
        r102.f413213d.setVisibility(8);
        r102.f413212c.setOnClickListener(null);
    L76:
        if (r110.P() == true) goto L78;
        return;
    L78:
        if (this.f412673c.m() == false) goto L82;
        if (TextUtils.isEmpty(r110.F()) == false) goto L82;
    L87:
        if (r118 == false) goto L91;
        r102.f413211b.setVisibility(0);
        r102.f413211b.setText(R.string.Lark_Legacy_MessageRemove);
        return;
    L91:
        return;
    L82:
        if (this.f412673c.Y() == true) goto L87;
        if (this.f412673c.m() == false) goto L87;
        r118 = false;
        goto L87
    L68:
        if (r110.h() == false) goto L74;
        if (r110.D() != null) goto L74;
        if (r128 == null) goto L74;
        if (r130 == false) goto L74;
        r102.f413212c.setVisibility(0);
        r102.f413213d.setVisibility(0);
        r102.f413212c.setText(UIHelper.getString(R.string.Lark_Legacy_Reedit));
        r102.f413212c.setOnClickListener(new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall.b(r125, r128, r110));
        goto L76
    L64:
        r130 = true;
    L38:
        if (r110.U() == false) goto L43;
        if (r110.V(((d0) this.f413209h.getValue()).a()) == false) goto L43;
        r127 = UIHelper.getString(R.string.Lark_Legacy_MessageBurned);
    L43:
        if (Message.RecallerIdentity.ENTERPRISE_ADMINISTRATOR != r110.E()) goto L45;
        r127 = UIHelper.getString(R.string.Lark_IM_MessageRecalledByAdmin_Text);
        Log.i("RecalledContentBlock", "recallMessage by enterprise_administrator");
        goto L61
    L45:
        if (r126 == null) goto L56;
        String r131 = o.a(r126.f566452a, r126.f566453b);
        if ((r110 instanceof y6b.c) == true) goto L51;
        if ((r110 instanceof ThreadMessageVO) == true) goto L51;
    L53:
        r127 = UIHelper.mustacheFormat(R.string.Lark_Legacy_MessageGroupRecallMessage, "recaller", r131);
    L54:
        Intrinsics.checkNotNull(r127);
        Log.i("RecalledContentBlock", "recallMessage by recaller");
    L51:
        if (r110.S() == false) goto L53;
        r127 = UIHelper.mustacheFormat(R.string.Lark_Legacy_GroupAdminRecalledMsg, "GroupAdministrator", r131);
        goto L54
    L56:
        if ((r125 instanceof AudioContentVO) == true) goto L58;
    L60:
        r127 = UIHelper.getString(R.string.Lark_Legacy_MessageIsrecalled);
        Log.i("RecalledContentBlock", "recallMessage by myself");
        goto L61
    L58:
        if (r110.j() == true) goto L60;
        r127 = UIHelper.getString(R.string.Lark_Message_AudioMessageWithdraw);
        goto L61
    L31:
        r123 = v4b.a.M;
        goto L32
    L27:
        r117 = v4b.a.I;
        goto L28
    L23:
        r116 = v4b.a.L;
        goto L24
    L19:
        r115 = v4b.a.K;
        goto L20
    L15:
        r112 = v4b.a.I;
        goto L16
    L12:
        r111 = v4b.a.I;
        goto L13
    L9:
        r109 = v4b.a.f553162J;
        goto L10
    L5:
        r105 = v4b.a.D;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(m r100, q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
