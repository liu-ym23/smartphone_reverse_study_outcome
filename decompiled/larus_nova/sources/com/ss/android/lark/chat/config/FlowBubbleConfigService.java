package com.ss.android.lark.chat.config;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import itb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v4b.b;
import y9c.d;

/* JADX INFO: loaded from: classes35.dex */
@ClaymoreImpl(b.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/config/FlowBubbleConfigService;", "Lcom/ss/android/lark/chat/config/IBubbleConfigService;", "<init>", "()V", "UNUSED", "", "assignColor", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isDoubaoBUser", "", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowBubbleConfigService implements b {
    public static final int $stable = 0;
    private final int UNUSED;

    private final boolean isDoubaoBUser() {
        return ((a) LarkContext.spiByDwarf(a.class)).i1();
    }

    public FlowBubbleConfigService() {
        this.UNUSED = -1;
    }

    @Override // v4b.b
    public void assignColor(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        v4b.a.f553163a = UDColorUtils.getColor(r110, R.color.flow_ud_static_primary_50);
        v4b.a.f553165c = UDColorUtils.getColor(r110, R.color.flow_ud_static_primary_50);
        v4b.a.f553187y = R.color.flow_ud_static_white;
        v4b.a.U = R.color.flow_ud_static_primary_50;
        v4b.a.f553164b = j08.b.b(d.c(r110, R.color.imtoken_message_bg_show_more_blue), 0.0f);
        v4b.a.f553166d = d.c(r110, R.color.ud_B500_15);
        v4b.a.f553167e = d.c(r110, R.color.flow_ud_static_white_transparent_4);
        v4b.a.f553168f = d.c(r110, R.color.imtoken_message_bg_reaction_blue);
        v4b.a.f553169g = R.color.text_caption;
        v4b.a.f553170h = d.c(r110, R.color.line_divider_default);
        v4b.a.f553171i = j08.b.b(d.c(r110, R.color.flow_ud_static_white_transparent_3), 1.0f);
        v4b.a.f553172j = j08.b.b(d.c(r110, R.color.text_link_normal), 1.0f);
        j08.b.b(d.c(r110, R.color.lkui_B500), 1.0f);
        j08.b.b(d.c(r110, R.color.static_white), 1.0f);
        j08.b.b(d.c(r110, R.color.primary_pri_700), 1.0f);
        v4b.a.f553173k = R.color.text_caption;
        j08.b.b(d.c(r110, R.color.primary_pri_700), 1.0f);
        j08.b.b(d.c(r110, R.color.lkui_N900), 1.0f);
        v4b.a.f553174l = R.color.imtoken_message_icon_read_dot;
        v4b.a.f553175m = R.color.imtoken_message_icon_unread_dot;
        v4b.a.f553176n = j08.b.b(d.c(r110, R.color.ud_N900), 0.16f);
        v4b.a.f553177o = R.color.text_placeholder;
        v4b.a.f553178p = d.c(r110, R.color.ud_N600);
        v4b.a.f553179q = j08.b.b(d.c(r110, R.color.lkui_N00), 0.8f);
        v4b.a.f553180r = j08.b.b(d.c(r110, R.color.ud_N500), 0.5f);
        v4b.a.f553181s = j08.b.b(d.c(r110, R.color.lkui_N00), 0.5f);
        v4b.a.f553182t = R.color.text_link_normal;
        v4b.a.f553183u = d.c(r110, R.color.text_title);
        v4b.a.f553184v = d.c(r110, R.color.imtoken_message_selected_bg);
        v4b.a.f553185w = d.c(r110, R.color.text_caption);
        v4b.a.f553188z = UDColorUtils.getColor(r110, R.color.flow_ud_bg_base_2_overlay);
        v4b.a.A = j08.b.b(d.c(r110, R.color.imtoken_message_bg_show_more_grey), 0.0f);
        v4b.a.B = UDColorUtils.getColor(r110, R.color.imtoken_message_bg_bubbles_grey);
        v4b.a.C = d.c(r110, R.color.ud_N900_05);
        v4b.a.D = d.c(r110, R.color.flow_ud_neutral_50);
        v4b.a.E = d.c(r110, R.color.imtoken_message_bg_reaction_grey);
        v4b.a.F = R.color.text_caption;
        v4b.a.G = d.c(r110, R.color.line_divider_default);
        v4b.a.H = j08.b.b(d.c(r110, R.color.flow_ud_neutral_50), 1.0f);
        v4b.a.I = j08.b.b(d.c(r110, R.color.text_link_normal), 1.0f);
        j08.b.b(d.c(r110, R.color.lkui_B500), 1.0f);
        j08.b.b(d.c(r110, R.color.lkui_N00), 1.0f);
        j08.b.b(d.c(r110, R.color.lkui_B700), 1.0f);
        v4b.a.f553162J = R.color.text_caption;
        j08.b.b(d.c(r110, R.color.lkui_B700), 1.0f);
        j08.b.b(d.c(r110, R.color.lkui_N900), 1.0f);
        v4b.a.K = R.color.imtoken_message_icon_read_dot;
        v4b.a.L = R.color.imtoken_message_icon_unread_dot;
        v4b.a.M = j08.b.b(d.c(r110, R.color.ud_N900), 0.16f);
        v4b.a.N = d.c(r110, R.color.ud_N600);
        v4b.a.O = j08.b.b(d.c(r110, R.color.lkui_N00), 0.8f);
        v4b.a.P = j08.b.b(d.c(r110, R.color.ud_N500), 0.5f);
        v4b.a.Q = j08.b.b(d.c(r110, R.color.lkui_N00), 0.5f);
        v4b.a.R = d.c(r110, R.color.text_title);
        v4b.a.S = d.c(r110, R.color.text_caption);
        v4b.a.f553186x = R.drawable.flow_bg_mine_chat_bubble_reply_mark;
        v4b.a.T = R.drawable.flow_bg_other_chat_bubble_reply_mark;
    }
}
