package cf5;

import gf5.b;
import gf5.c;
import gf5.e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final List<b> a;
    public final hf5.a b;
    public gf5.a c;
    public boolean d;

    /* JADX INFO: renamed from: cf5.a$a, reason: collision with other inner class name */
    public static final class C0010a {
    }

    static {
    }

    public final gf5.a a() {
        gf5.a r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("addinContext");
        return null;
    L6:
        return r0;
    }

    public a() {
        this.a = new ArrayList();
        this.b = new hf5.a();
    }

    public final void b(Class r4, ff5.a r5) {
        Intrinsics.checkNotNullParameter(r4, "actionClass");
        Intrinsics.checkNotNullParameter(r5, "handler");
        if (this.d == false) goto L6;
        tt5.a.k("Comment#CommentAddinHost", "can not register handler after host is destroyed!");
        return;
    L6:
        hf5.a r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "eventClass");
        Intrinsics.checkNotNullParameter(r5, "handler");
        tt5.a.b("Comment#OrderedEventManager", "registerHandler()... eventClass = " + r4 + ", handler = " + r5);
        TreeSet<e<c>> r0 = (TreeSet) ((LinkedHashMap) r1.a).get(r4);
        if (r0 != null) goto L9;
        r0 = new TreeSet(hf5.b.a);
        r1.a.put(r4, r0);
    L9:
        r0.add(r5);
    }
}
