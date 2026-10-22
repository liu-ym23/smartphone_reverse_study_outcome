package io.noties.markwon.html.tag;

import io.noties.markwon.core.CoreProps;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import lsc.t;
import lsc.x;
import lsc.y;
import org.commonmark.node.ListItem;
import tsc.a0;
import tsc.v;

/* JADX INFO: loaded from: classes5.dex */
public final class h extends a0 {
    @Override // tsc.a0
    public final Collection<String> c() {
        return Arrays.asList(new String[]{"ol", "ul"});
    }

    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tsc.a0
    public final void a(lsc.m r110, v r111, tsc.l r112) {
        if (r112.isBlock() == true) goto L5;
        return;
    L5:
        tsc.l.a r113 = r112.a();
        boolean r100 = "ol".equals(r113.name());
        boolean r101 = "ul".equals(r113.name());
        if (r100 == true) goto L9;
        if (r101 == true) goto L9;
        return;
    L9:
        lsc.h r102 = r110.B();
        t r103 = r110.r();
        x r104 = ((lsc.l) r102.f510595e).a(ListItem.class);
        int r105 = 0;
        tsc.m.a r106 = r113;
    L10:
        r106 = r106.parent();
        if (r106 == 0) goto L17;
        if ("ul".equals(r106.f547459a) == true) goto L16;
        if ("ol".equals(r106.f547459a) == false) goto L10;
    L16:
        r105 = r105 + 1;
        goto L10
    L17:
        Iterator<tsc.l.a> r114 = r113.children().iterator();
        int r107 = 1;
    L19:
        if (r114.hasNext() == false) goto L29;
        tsc.l.a r108 = r114.next();
        a0.d(r110, r111, r108);
        if (r104 == null) goto L19;
        if ("li".equals(r108.name()) == false) goto L19;
        CoreProps.f492263e.c(r110.r(), Boolean.TRUE);
        if (r100 == false) goto L27;
        CoreProps.f492259a.c(r103, CoreProps.ListItemType.ORDERED);
        int r109 = r107 + 1;
        CoreProps.f492262d.c(r103, Integer.valueOf(r107));
        CoreProps.f492260b.c(r103, Integer.valueOf(r105));
        r107 = r109;
    L28:
        y.f(r110.builder(), r104.a(r102, r103), r108.start(), r108.end());
        goto L19
    L27:
        CoreProps.f492259a.c(r103, CoreProps.ListItemType.BULLET);
        CoreProps.f492260b.c(r103, Integer.valueOf(r105));
        goto L28
    }
}
