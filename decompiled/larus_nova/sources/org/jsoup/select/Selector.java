package org.jsoup.select;

import java.util.IdentityHashMap;
import java.util.Iterator;
import org.jsoup.nodes.Element;

/* JADX INFO: loaded from: classes42.dex */
public final class Selector {

    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String r100) {
            super(r100);
        }

        public SelectorParseException(String r100, Object... r101) {
            super(String.format(r100, r101));
        }
    }

    public static Elements a(String r100, Iterable<Element> r101) {
        ewc.b.b(r100);
        ewc.b.d(r101);
        c r102 = e.j(r100);
        Elements r103 = new Elements();
        IdentityHashMap r104 = new IdentityHashMap();
        Iterator<Element> r105 = r101.iterator();
    L4:
        if (r105.hasNext() == false) goto L11;
        Element r106 = r105.next();
        ewc.b.d(r102);
        ewc.b.d(r106);
        Elements r107 = new Elements();
        d.b(new gwc.a(r106, r107, r102), r106);
        Iterator<Element> r108 = r107.iterator();
    L7:
        if (r108.hasNext() == false) goto L4;
        Element r109 = r108.next();
        if (r104.put(r109, Boolean.TRUE) != null) goto L7;
        r103.add(r109);
        goto L7
    L11:
        return r103;
    }
}
