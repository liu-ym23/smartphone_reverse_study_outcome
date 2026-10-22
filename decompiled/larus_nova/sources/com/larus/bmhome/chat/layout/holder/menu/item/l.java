package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes25.dex */
public final class l {
    public static com.larus.bmhome.view.screenmenu.l0 a() {
        if (AppHost.f326268a.isTestChannel() == true) goto L13;
        if (AuthModelDelegate.f297134b.s() == true) goto L13;
        if (com.larus.platform.service.s.f365799a.h() == true) goto L13;
        if (com.larus.platform.service.g0.f365740a.m() == true) goto L13;
        return null;
    L13:
        return new com.larus.bmhome.view.screenmenu.l0(R.string.larus_message_long_press_debug, R.string.larus_message_long_press_debug, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(R.attr.larus_ic_screen_menu_more, null, R.drawable.larus_ic_screen_menu_more)), null, false, false, null, null, "debug", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528388, 127);
    }
}
