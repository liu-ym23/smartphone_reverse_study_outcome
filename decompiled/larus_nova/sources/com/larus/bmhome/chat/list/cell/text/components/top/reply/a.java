package com.larus.bmhome.chat.list.cell.text.components.top.reply;

import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.manager.l0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import dg8.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements tg8.b {
    public a() {
    }

    @Override // tg8.b
    public final boolean c(t1a.b r100, Message r101, q0 r102) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Integer r103 = null;
        if (r100 == null) goto L5;
        y r104 = (y) r100.getAbility(y.class);
    L6:
        int r105 = l0.f306756a;
        BotModel r106 = t.d(r104);
        if (r106 == null) goto L10;
        r103 = r106.getBotType();
    L10:
        if (l0.a(r103) == true) goto L22;
        BotModel r107 = t.d(r104);
        if (r107 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == true) goto L22;
        if (com.larus.bmhome.chat.bean.d.G0(r101) == false) goto L22;
        return false;
    L14:
        if (ce8.a.b(r107) != true) goto L16;
        r108 = true;
    L22:
        if (com.larus.bmhome.chat.bean.d.b1(r101) != null) goto L24;
        return false;
    L24:
        return true;
    L5:
        r104 = null;
        goto L6
    }
}
