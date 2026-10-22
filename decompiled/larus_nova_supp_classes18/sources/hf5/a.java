package hf5;

import gf5.c;
import gf5.d;
import gf5.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements d {
    public final Map<Class<? extends c>, TreeSet<e<c>>> a;

    /* JADX INFO: renamed from: hf5.a$a, reason: collision with other inner class name */
    public static final class C0244a {
    }

    static {
    }

    public a() {
        this.a = new LinkedHashMap();
    }

    @Override // gf5.d
    public final void a(c r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        tt5.a.b("Comment#OrderedEventManager", "dispatchEvent()... event = " + r3);
        TreeSet r0 = (TreeSet) ((LinkedHashMap) this.a).get(r3.getClass());
        if (r0 == null) goto L8;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((e) r1.next()).a(r3);
        goto L6
    L10:
        return;
    }
}
