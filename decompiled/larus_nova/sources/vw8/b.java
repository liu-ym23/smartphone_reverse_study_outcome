package vw8;

import io.noties.markwon.core.CoreProps;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import lsc.l;
import lsc.m;
import lsc.q;
import lsc.t;
import lsc.x;
import lsc.y;
import nsc.j;
import org.commonmark.node.Document;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements m.c<ListItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f557450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f557451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final lw8.a f557452c;

    public static final class a {
    }

    static {
    }

    @Override // lsc.m.c
    public final void a(m r110, uvc.b r111) {
        ListItem r112 = (ListItem) r111;
        Intrinsics.checkNotNullParameter(r110, "visitor");
        Intrinsics.checkNotNullParameter(r112, "listItem");
        boolean r100 = false;
        if (((HashMap) r112.f551906g).get("start_self") != null) goto L5;
        boolean r101 = true;
    L6:
        Integer r102 = this.f557451b;
        if (r102 == null) goto L15;
        int r103 = r102.intValue();
        if (r112.f551903d != null) goto L14;
        uvc.b r104 = r112.f551900a;
        if ((r104.f551900a instanceof Document) == true) goto L15;
        if (r104.f551903d == null) goto L15;
    L14:
        r110.a();
        int r105 = r110.length();
        r110.builder().a(8203);
        r110.o(r105, dtc.a.a(r103));
        r110.a();
    L15:
        int r106 = r110.length();
        r110.c(r112);
        q<Integer> r107 = CoreProps.f492260b;
        t r108 = r110.r();
        uvc.b r109 = r112.f551900a;
        int r113 = 0;
    L16:
        if (r109 == null) goto L21;
        if ((r109 instanceof ListItem) == false) goto L20;
        r113 = r113 + 1;
    L20:
        r109 = r109.f551900a;
        goto L16
    L21:
        r107.c(r108, Integer.valueOf(r113));
        q<Integer> r114 = CoreProps.f492261c;
        t r115 = r110.r();
        if (this.f557450a == false) goto L33;
        uvc.b r116 = r112.f551900a;
        uvc.b r117 = r112;
        int r118 = 0;
    L25:
        if ((r116 instanceof Document) == true) goto L31;
        if ((r116 instanceof ListItem) == false) goto L29;
        r118 = r118 + 1;
    L29:
        r117 = r116;
        r116 = r116.f551900a;
        goto L25
    L31:
        if ((r117 instanceof ListBlock) == false) goto L34;
        r118 = r118 + (osc.a.a((ListBlock) r117) / 4);
    L34:
        r114.c(r115, Integer.valueOf(r118));
        uvc.b r119 = r112.f551900a;
        CoreProps.f492263e.c(r110.r(), Boolean.valueOf(r101));
        y r120 = null;
        if ((r119 instanceof OrderedList) == false) goto L44;
        Object r121 = ((HashMap) r112.f551906g).get("order_number");
        if ((r121 instanceof Integer) == false) goto L39;
        Integer r122 = (Integer) r121;
    L40:
        if (r122 == null) goto L42;
        int r123 = r122.intValue();
    L43:
        CoreProps.f492259a.c(r110.r(), CoreProps.ListItemType.ORDERED);
        CoreProps.f492262d.c(r110.r(), Integer.valueOf(r123));
        ((OrderedList) r119).f525779i = r123 + 1;
    L45:
        int r124 = r110.builder().length();
        if ((r112.f551901b instanceof ListBlock) == false) goto L55;
    L47:
        if (r106 >= r124) goto L53;
        if (r110.builder().charAt(r106) == 8203) goto L52;
        if (r110.builder().charAt(r106) != '\n') goto L53;
    L52:
        r106 = r106 + 1;
    L53:
        if (r106 < r124) goto L55;
        return;
    L55:
        lw8.a r125 = this.f557452c;
        if (r125 != null) goto L58;
    L60:
        if (r100 == false) goto L69;
        x r126 = ((l) r110.B().f510595e).a(r112.getClass());
        if ((r126 instanceof j) == false) goto L64;
        j r127 = (j) r126;
    L65:
        if (r127 == null) goto L67;
        r120 = r110.builder();
        r120.setSpan(r127.d(r110.B(), r110.r(), this.f557452c, r112), r106, r120.length(), 33);
    L67:
        if (r120 != null) goto L71;
        r110.G(r112, r106);
    L71:
        if (r110.s(r112) == false) goto L84;
        r110.a();
        return;
    L84:
        return;
    L64:
        r127 = null;
        goto L65
    L69:
        r110.G(r112, r106);
        goto L71
    L58:
        if (r125.f511046a != true) goto L60;
        r100 = true;
        goto L60
    L42:
        r123 = ((OrderedList) r119).f525779i;
        goto L43
    L39:
        r122 = null;
        goto L40
    L44:
        CoreProps.f492259a.c(r110.r(), CoreProps.ListItemType.BULLET);
        goto L45
    L33:
        r118 = 0;
        goto L34
    L5:
        r101 = false;
        goto L6
    }

    public b(boolean r100, Integer r101, lw8.a r102) {
        this.f557450a = r100;
        this.f557451b = r101;
        this.f557452c = r102;
    }
}
