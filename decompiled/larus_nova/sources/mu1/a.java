package mu1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ju1.l;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import nu1.d;
import nu1.e;
import ou1.c;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, l> f515720a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<e> f515721b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<d> f515722c = null;

    static {
        f515720a = new LinkedHashMap();
        f515721b = new ArrayList();
        ArrayList r100 = new ArrayList();
        f515722c = r100;
        nu1.a r101 = nu1.a.f520601a;
        r100.add(new c());
    }

    @JvmStatic
    public static final boolean a(l r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "stateMap");
        Iterator<T> r102 = f515722c.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        d r103 = (d) r102.next();
        if (r103.b(r100) == false) goto L4;
        return r103.a(r100, r101);
    L10:
        return r100.a();
    }
}
