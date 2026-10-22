package io.noties.markwon.core;

import java.util.HashMap;
import lsc.m;
import lsc.q;
import lsc.t;
import org.commonmark.node.Block;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import uvc.b;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements m.c<ListItem> {
    public a() {
    }

    @Override // lsc.m.c
    public final void a(m r100, b r101) {
        ListItem r102 = (ListItem) r101;
        int r103 = r100.length();
        r100.c(r102);
        Block r104 = (Block) r102.f551900a;
        int r105 = 0;
        if (((HashMap) r102.f551906g).get("start_self") != null) goto L5;
        boolean r106 = true;
    L6:
        CoreProps.f492263e.c(r100.r(), Boolean.valueOf(r106));
        if ((r104 instanceof OrderedList) == false) goto L9;
        OrderedList r107 = (OrderedList) r104;
        int r108 = r107.f525779i;
        CoreProps.f492259a.c(r100.r(), CoreProps.ListItemType.ORDERED);
        CoreProps.f492262d.c(r100.r(), Integer.valueOf(r108));
        r107.f525779i++;
    L16:
        r100.G(r102, r103);
        if (r100.s(r102) == false) goto L23;
        r100.a();
        return;
    L23:
        return;
    L9:
        CoreProps.f492259a.c(r100.r(), CoreProps.ListItemType.BULLET);
        q<Integer> r109 = CoreProps.f492260b;
        t r110 = r100.r();
        b r111 = r102.c();
    L10:
        if (r111 == null) goto L15;
        if ((r111 instanceof ListItem) == false) goto L14;
        r105 = r105 + 1;
    L14:
        r111 = r111.c();
        goto L10
    L15:
        r109.c(r110, Integer.valueOf(r105));
        goto L16
    L5:
        r106 = false;
        goto L6
    }
}
