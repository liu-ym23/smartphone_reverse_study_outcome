package hf5;

import gf5.c;
import gf5.d;
import gf5.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends c>, TreeSet<e<c>>> f484923a;

    /* JADX INFO: renamed from: hf5.a$a, reason: collision with other inner class name */
    public static final class C6138a {
    }

    static {
    }

    public a() {
        this.f484923a = new LinkedHashMap();
    }

    @Override // gf5.d
    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        tt5.a.b("Comment#OrderedEventManager", "dispatchEvent()... event = " + r100);
        TreeSet r101 = (TreeSet) ((LinkedHashMap) this.f484923a).get(r100.getClass());
        if (r101 == null) goto L8;
        Iterator r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((e) r102.next()).a(r100);
        goto L6
    L10:
        return;
    }
}
