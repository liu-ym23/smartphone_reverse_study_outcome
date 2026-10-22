package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.im.bean.bot.AnswerAction;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes25.dex */
public final class j {
    public static com.larus.bmhome.view.screenmenu.l0 a(AnswerAction r410) {
        if (r410 == null) goto L5;
        String r100 = r410.getName();
    L7:
        return new com.larus.bmhome.view.screenmenu.l0(R.string.larus_message_long_press_copy, R.string.larus_message_long_press_copy, r100, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(R.attr.larus_ic_screen_menu_copy, null, R.drawable.larus_ic_screen_menu_copy)), null, false, false, null, null, "copy", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528392, 127);
    L5:
        r100 = null;
        goto L7
    }
}
