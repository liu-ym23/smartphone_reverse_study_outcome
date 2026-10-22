package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;

/* JADX INFO: loaded from: classes42.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f526106a = 0;

    public d() {
    }

    static {
    }

    public static NodeFilter.FilterResult a(NodeFilter r100, j r101) {
        j r102 = r101;
        int r103 = 0;
    L3:
        if (r102 == null) goto L49;
        a r104 = (a) r100;
        r104.getClass();
        if ((r102 instanceof Element) == false) goto L9;
        Element r105 = (Element) r102;
        if (r104.f526081c.a(r104.f526079a, r105) == false) goto L9;
        r104.f526080b = r105;
        NodeFilter.FilterResult r106 = NodeFilter.FilterResult.STOP;
    L11:
        if (r106 == NodeFilter.FilterResult.STOP) goto L12;
        if (r106 != NodeFilter.FilterResult.CONTINUE) goto L19;
        if (r102.i() <= 0) goto L19;
        r102 = r102.h(0);
        r103 = r103 + 1;
    L19:
        if (r102.s() != null) goto L34;
        if (r103 <= 0) goto L34;
        NodeFilter.FilterResult r107 = NodeFilter.FilterResult.CONTINUE;
        if (r106 == r107) goto L27;
        if (r106 == NodeFilter.FilterResult.SKIP_CHILDREN) goto L27;
    L30:
        j r108 = r102.f525933a;
        r103 = r103 - 1;
        if (r106 != NodeFilter.FilterResult.REMOVE) goto L33;
        r102.A();
    L33:
        r106 = r107;
        r102 = r108;
    L27:
        if (r107 == NodeFilter.FilterResult.STOP) goto L28;
        r106 = r107;
        goto L30
    L28:
        return r107;
    L34:
        NodeFilter.FilterResult r109 = NodeFilter.FilterResult.CONTINUE;
        if (r106 == r109) goto L39;
        if (r106 == NodeFilter.FilterResult.SKIP_CHILDREN) goto L39;
    L42:
        if (r102 == r101) goto L43;
        j r110 = r102.s();
        if (r106 != NodeFilter.FilterResult.REMOVE) goto L47;
        r102.A();
    L47:
        r102 = r110;
        goto L3
    L43:
        return r106;
    L39:
        if (r109 == NodeFilter.FilterResult.STOP) goto L40;
        r106 = r109;
        goto L42
    L40:
        return r109;
    L12:
        return r106;
    L9:
        r106 = NodeFilter.FilterResult.CONTINUE;
        goto L11
    L49:
        return NodeFilter.FilterResult.CONTINUE;
    }

    public static void b(gwc.b r100, j r101) {
        ewc.b.d(r100);
        ewc.b.d(r101);
        j r102 = r101;
        int r103 = 0;
    L3:
        if (r102 == null) goto L33;
        j r104 = r102.f525933a;
        if (r104 == null) goto L7;
        int r105 = r104.i();
    L8:
        j r106 = r102.s();
        r100.b(r102, r103);
        if (r104 == null) goto L22;
        if (r102.f525933a == null) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == true) goto L22;
        if (r105 != r104.i()) goto L18;
        r102 = r104.h(r102.f525934b);
        goto L22
    L18:
        if (r106 == null) goto L19;
        r102 = r106;
        goto L3
    L19:
        r103 = r103 - 1;
        r102 = r104;
        goto L3
    L13:
        r107 = false;
    L22:
        if (r102.i() > 0) goto L23;
    L25:
        if (r102.s() != null) goto L29;
        if (r103 <= 0) goto L29;
        r100.a(r102, r103);
        r102 = r102.f525933a;
        r103 = r103 - 1;
    L29:
        r100.a(r102, r103);
        if (r102 == r101) goto L51;
        r102 = r102.s();
        goto L3
    L51:
        return;
    L23:
        r102 = r102.h(0);
        r103 = r103 + 1;
        goto L3
    L7:
        r105 = 0;
        goto L8
    }
}
