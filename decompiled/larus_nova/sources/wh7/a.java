package wh7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import vh7.e;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Class<?>, C8115a> f559703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Class<?>, C8115a> f559704b;

    /* JADX INFO: renamed from: wh7.a$a, reason: collision with other inner class name */
    public final class C8115a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<C8115a> f559705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<?> f559706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C8115a f559707c;

        public C8115a(a r100, Class<?> r101, C8115a r102) {
            Intrinsics.checkNotNullParameter(r101, "type");
            this.f559706b = r101;
            this.f559707c = r102;
            r100.f559704b.put(r101, this);
            this.f559705a = new ArrayList(1);
        }
    }

    public a() {
        this.f559703a = new LinkedHashMap();
        this.f559704b = new HashMap();
    }

    public final C8115a a(Class<?> r100) {
        LinkedHashMap<Class<?>, C8115a> r101 = this.f559703a;
        C8115a r102 = r101.get(r100);
        if (r102 != null) goto L6;
        r102 = new C8115a(this, r100, null);
        r101.put(r100, r102);
    L6:
        return r102;
    }

    public final C8115a b(C8115a r100, Class<?> r101) {
        Class<?>[] r102 = r101.getInterfaces();
        int r103 = r102.length;
        int r104 = 0;
        C8115a r105 = r100;
    L3:
        if (r104 >= r103) goto L16;
        Class<?> r106 = r102[r104];
        if (Intrinsics.areEqual(r106, e.class) == true) goto L15;
        if (e.class.isAssignableFrom(r106) == false) goto L15;
        C8115a r107 = this.f559704b.get(r106);
        if (r107 != null) goto L13;
        r107 = b(r100, r106);
    L13:
        if (r105.f559706b.isAssignableFrom(r106) == false) goto L15;
        r105 = r107;
    L15:
        r104 = r104 + 1;
        goto L3
    L16:
        C8115a r108 = new C8115a(this, r101, r105);
        ((ArrayList) r105.f559705a).add(r108);
        return r108;
    }
}
