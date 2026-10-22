package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Pin;
import com.ss.android.lark.chat.entity.message.UniversalPinExtra;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.team.TeamUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class MessagePinInfoBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final jdb.g f412823h;

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412822g;
    }

    public MessagePinInfoBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412822g = IMMessageKeys$Blocks.PIN_INFO;
        this.f412823h = com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.f412673c).C();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        g(r101, this.f412822g, IMMessageKeys$Slots.BOTTOM);
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r210, com.ss.android.lark.blueprint.q<y6b.a<?>> r211, y6b.a<?> r212) {
        Intrinsics.checkNotNullParameter(r210, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r211, "layout");
        Intrinsics.checkNotNullParameter(r212, "data");
        y6b.c r100 = (y6b.c) r212;
        boolean r101 = true;
        if (r100.j() == false) goto L5;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L14;
    L128:
        g(r211, this.f412822g, IMMessageKeys$Slots.BOTTOM);
        return;
    L14:
        if (com.ss.android.lark.chat.utils.i.a(r100, com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.f412673c).C(), this.f412673c.getChat()) == false) goto L128;
        IMMessageKeys$Blocks r103 = this.f412822g;
        IMMessageKeys$Slots r104 = IMMessageKeys$Slots.BOTTOM;
        com.ss.android.lark.blueprint.k r105 = r211.c(r103, r104, new MessagePinInfoBlock$update$blockView$1(this));
        ((AppCompatTextView) r105.getView()).setMovementMethod(LinkMovementMethod.getInstance());
        ChatThemeInfo r106 = this.f412673c.r8();
        if (r106 == null) goto L19;
        ChatThemeInfo.Scene r107 = r106.getComponentScene();
    L21:
        if (com.ss.android.lark.chat.utils.p.g(r107) == false) goto L23;
        int r108 = R.color.get_pin_tip_color_in_dark_mode;
    L24:
        jdb.g r110 = this.f412823h;
        Chat r111 = this.f412673c.getChat();
        int r112 = l2b.b.f507192a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "fgService");
        Intrinsics.checkNotNullParameter(r110, "fgService");
        if (r111 != null) goto L28;
    L36:
        boolean r113 = false;
    L38:
        if (r113 == true) goto L40;
    L42:
        boolean r114 = false;
    L43:
        if (r114 == true) goto L45;
    L49:
        boolean r115 = false;
    L51:
        if (r115 == false) goto L69;
        UniversalPinExtra r109 = r100.f566512v2;
        if (r109 == null) goto L100;
        m2b.a r116 = this.f412673c;
        Function1<Chatter, Unit> r117 = new MessagePinInfoBlock$update$text$1(this);
        Intrinsics.checkNotNullParameter(r109, "<this>");
        Intrinsics.checkNotNullParameter(r116, "chatContext");
        ChatChatter r118 = r109.getPinChatter();
        if (r118 == null) goto L100;
        SpannableStringBuilder r119 = new SpannableStringBuilder();
        String r120 = com.ss.android.lark.chat.utils.m.b(r118, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true);
        if (r116.isGroup() == true) goto L64;
        if (r116.B8() == false) goto L64;
        r119.append(UIUtils.getString(r116.getContext(), R.string.Lark_IM_SuperApp_PinnedToYou_Text));
    L68:
        CharSequence r121 = new SpannedString(r119);
    L101:
        if (r121 != null) goto L103;
    L126:
        g(r211, this.f412822g, r104);
        return;
    L103:
        if (TextUtils.isEmpty(r121) == true) goto L126;
        ((AppCompatTextView) r105.getView()).setText(r121);
        ChatThemeInfo r122 = this.f412673c.r8();
        if (r122 == null) goto L107;
        ChatThemeInfo.Scene r123 = r122.getComponentScene();
    L108:
        boolean r124 = com.ss.android.lark.chat.utils.p.g(r123);
        if (r124 == false) goto L117;
        ChatThemeInfo r125 = this.f412673c.r8();
        if (r125 == null) goto L113;
        ChatThemeInfo.Scene r126 = r125.getComponentScene();
    L115:
        if (com.ss.android.lark.chat.utils.p.f(r126) == false) goto L117;
    L118:
        int r127 = zz7.b.g(getContext(), 12);
        Drawable r128 = UIUtils.getDrawable(getContext(), R.drawable.ic_svg_message_tag_pin);
        r128.setBounds(0, 0, r127, r127);
        if (r124 == true) goto L121;
    L124:
        int r129 = UIUtils.getColor(getContext(), R.color.imtoken_message_icon_pin);
        ((AppCompatTextView) r105.getView()).setTextColor(r129);
        r128.setTint(r129);
    L125:
        ((AppCompatTextView) r105.getView()).setCompoundDrawables(r128, null, null, null);
        return;
    L121:
        if (h18.f.a(getContext()) == true) goto L123;
        if (r101 == false) goto L124;
    L123:
        Context r130 = getContext();
        Intrinsics.checkNotNullParameter(r130, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r131 = UIUtils.getColor(r130, R.color.get_pin_tip_color_in_dark_mode);
        ((AppCompatTextView) r105.getView()).setTextColor(r131);
        r128.setTint(r131);
        goto L125
    L113:
        r126 = null;
    L117:
        r101 = false;
        goto L118
    L107:
        r123 = null;
    L64:
        if (r116.isGroup() == false) goto L66;
        String r132 = UIUtils.getString(r116.getContext(), R.string.Lark_IM_SuperApp_PinnedToAll_Text);
    L67:
        String r133 = r132;
        String r134 = ICUUtils.icuFormat(r133, "name", r120);
        Intrinsics.checkNotNull(r133);
        int r135 = StringsKt.indexOf$default(r133, "{name}", 0, false, 6, null);
        r119.append(r134);
        r119.setSpan(new l2b.a(r108, r117, r118, r116.getContext()), r135, r120.length() + r135, 33);
        goto L68
    L66:
        r132 = UIUtils.getString(r116.getContext(), R.string.Lark_IM_SuperApp_PinnedToBoth_Text);
    L100:
        r121 = null;
        goto L101
    L69:
        jdb.g r136 = this.f412823h;
        Chat r137 = this.f412673c.getChat();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r136, "fgService");
        Intrinsics.checkNotNullParameter(r136, "fgService");
        if (r137 != null) goto L73;
    L81:
        boolean r138 = false;
    L82:
        if (r138 == true) goto L84;
    L86:
        boolean r139 = false;
    L87:
        if (r139 == false) goto L90;
    L92:
        boolean r140 = false;
    L93:
        if (r140 == false) goto L100;
        Pin r141 = r100.f566510v;
        if (r141 == null) goto L100;
        m2b.a r142 = this.f412673c;
        Intrinsics.checkNotNullParameter(r141, "<this>");
        Intrinsics.checkNotNullParameter(r142, "chatContext");
        if (r142.isGroup() == false) goto L99;
        r121 = UIHelper.mustacheFormat(R.string.Lark_Pin_PinDiscriptionInGroup, "user", r141.getOperatorDisplayName());
        goto L101
    L99:
        r121 = UIHelper.mustacheFormat(R.string.Lark_Pin_PinDiscriptionInSingleChat, "user", r141.getOperatorDisplayName());
        goto L101
    L90:
        if (r100.f566510v == null) goto L92;
        r140 = true;
        goto L93
    L84:
        if (r136.isEnable("im.chat.pinned.msg") == false) goto L86;
        r139 = true;
        goto L87
    L73:
        if (r137.isSecret() == true) goto L81;
        TeamUtils.b(r137);
        if (r136.isEnable("im.chat.pinned.url") == false) goto L81;
        if (r137.isThread() == true) goto L81;
        if (r137.isOnCall() == true) goto L81;
        r138 = true;
        goto L82
    L45:
        if (r100.f566512v2 == null) goto L49;
        if (r100.j() == true) goto L49;
        r115 = true;
        goto L51
    L40:
        if (r110.isEnable("im.chat.pinned.msg") == false) goto L42;
        r114 = true;
        goto L43
    L28:
        if (r111.isSecret() == true) goto L36;
        TeamUtils.b(r111);
        if (r110.isEnable("im.chat.pinned.url") == false) goto L36;
        if (r111.isThread() == true) goto L36;
        if (r111.isOnCall() == true) goto L36;
        r113 = true;
        goto L38
    L23:
        r108 = R.color.imtoken_message_icon_pin;
        goto L24
    L19:
        r107 = null;
        goto L21
    L5:
        if (r100.Y == true) goto L11;
        if (r100.f566517y == true) goto L11;
        if (r100.f566520z == true) goto L11;
        r102 = true;
        goto L12
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
