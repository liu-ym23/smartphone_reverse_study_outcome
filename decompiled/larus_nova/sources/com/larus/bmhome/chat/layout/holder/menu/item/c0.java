package com.larus.bmhome.chat.layout.holder.menu.item;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c0 {
    public static com.larus.bmhome.view.screenmenu.l0 a(List r510) {
        Intrinsics.checkNotNullParameter(r510, "foldItems");
        MenuActionType r100 = MenuActionType.MORE;
        int r101 = r100.getType();
        int r110 = v19.c.b(R.attr.larus_ic_screen_menu_more, null, R.drawable.larus_ic_screen_menu_more);
        int r102 = v19.c.b(R.attr.larus_icon_search_more_arrow, null, R.drawable.larus_icon_search_more_arrow);
        int r111 = r100.getType();
        int r103 = v19.c.b(R.attr.larus_ic_screen_menu_more, null, R.drawable.larus_ic_screen_menu_more);
        ListProtector.add(r510, 0, new com.larus.bmhome.view.screenmenu.l0(r111, R.string.larus_sharesheet_more, null, null, null, null, null, Integer.valueOf(v19.c.b(R.attr.larus_ic_screen_menu_arrow_up, null, R.drawable.larus_ic_screen_menu_arrow_up)), null, false, false, null, Integer.valueOf(r103), null, false, false, null, null, "more", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528516, 127));
        com.larus.bmhome.view.screenmenu.l0 r104 = l.a();
        if (r104 == null) goto L6;
        r510.add(r104);
    L6:
        return new com.larus.bmhome.view.screenmenu.l0(r101, R.string.larus_sharesheet_more, null, null, null, null, null, Integer.valueOf(r102), null, false, false, r510, Integer.valueOf(r110), null, false, false, null, null, "more", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -530564, 127);
    }
}
