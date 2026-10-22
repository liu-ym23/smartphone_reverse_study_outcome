package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.utils.w2;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d0 implements tg8.b {
    public d0() {
    }

    @Override // tg8.b
    public final boolean c(t1a.b r100, Message r101, com.larus.bmhome.chat.api.q0 r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Integer r103 = null;
        if (com.larus.bmhome.chat.bean.d.x0(r101) == false) goto L19;
        com.larus.bmhome.chat.helper.n0 r104 = com.larus.bmhome.chat.helper.n0.f303117a;
        String r105 = r101.getMessageId();
        r104.getClass();
        int r106 = w2.a(r105);
        List<Message> r107 = r101.getSubList();
        if (r107 == null) goto L10;
        if (r106 < 0) goto L10;
        if (r106 >= r107.size()) goto L10;
        Object r108 = ListProtector.get(r107, r106);
    L11:
        Message r109 = (Message) r108;
        if (r109 != null) goto L14;
    L17:
        return false;
    L14:
        if (r109.getMessageStatusLocal() != 21) goto L17;
        if (com.larus.bmhome.chat.bean.d.Q0(r109) == false) goto L19;
    L10:
        r108 = null;
    L19:
        if (com.larus.bmhome.chat.bean.d.v(r101) == false) goto L22;
        return false;
    L22:
        if (com.larus.bmhome.chat.bean.d.V(r101) == false) goto L25;
        return false;
    L25:
        if (hc8.c.f484552a.j(r101) == true) goto L87;
        Map<String, String> r110 = r101.getExt();
        if (r110 == null) goto L29;
        String r111 = r110.get("need_auth_identity");
    L31:
        if (Intrinsics.areEqual(r111, "1") == true) goto L87;
        if (r100 == null) goto L35;
        com.larus.bmhome.chat.component.cvs.y r112 = (com.larus.bmhome.chat.component.cvs.y) r100.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
    L36:
        BotModel r113 = dg8.t.d(r112);
        if (r113 == null) goto L39;
        List<AnswerAction> r114 = r113.getStreamingAnswerActions();
    L41:
        if (z2.f365865a.canShowAnswerActionBar() == false) goto L43;
    L46:
        if (r100 == null) goto L50;
        de8.c r115 = (de8.c) r100.a(de8.c.class);
        if (r115 == null) goto L50;
        r103 = r115.m();
    L50:
        if (r103 == null) goto L53;
        return false;
    L53:
        if (r100 == null) goto L59;
        com.larus.bmhome.chat.component.regen.a r116 = (com.larus.bmhome.chat.component.regen.a) r100.getAbility(com.larus.bmhome.chat.component.regen.a.class);
        if (r116 == null) goto L59;
        if (r116.tL(r101) != true) goto L59;
        boolean r117 = true;
    L61:
        if (dg8.t.i(r114, r101) == false) goto L63;
    L86:
        return true;
    L63:
        if (dg8.t.g(r102, r101, r114) == true) goto L86;
        if (dg8.t.f(r102, r101) == true) goto L86;
        if (r117 == true) goto L68;
    L85:
        return false;
    L68:
        if (com.larus.bmhome.chat.bean.d.Q0(r101) == true) goto L85;
        if (com.larus.bmhome.chat.bean.d.P0(r101) == true) goto L85;
        if (com.larus.bmhome.chat.bean.d.r0(r101) == true) goto L85;
        if (r101.getMessageStatusLocal() != 21) goto L76;
    L77:
        if (r100 == null) goto L83;
        com.larus.bmhome.chat.component.cvs.y r118 = (com.larus.bmhome.chat.component.cvs.y) r100.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r118 == null) goto L83;
        if (dg8.t.h(r118) != true) goto L83;
        boolean r119 = true;
    L84:
        if (r119 == false) goto L86;
    L83:
        r119 = false;
        goto L84
    L76:
        if (r101.getMessageStatusLocal() != 23) goto L85;
    L59:
        r117 = false;
        goto L61
    L43:
        if (dg8.t.b(r114) == true) goto L46;
        FLogger.f375446a.i("MessagePluginAuthComponent", "canShowAnswerActionBar() result is false");
        return false;
    L39:
        r114 = null;
        goto L41
    L35:
        r112 = null;
        goto L36
    L29:
        r111 = null;
    L87:
        return false;
    }
}
