package q47;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class f<T, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f<T, V>.b f531665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f531666b;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f<T, V>.b f531667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f531668b;

        public a(b r100, int r101) {
            this.f531667a = r100;
            this.f531668b = r101;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<T, f<T, V>.b> f531669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f531670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f531671c;

        public b(f r100) {
            this.f531671c = r100;
            this.f531669a = new HashMap();
            this.f531670b = null;
        }
    }

    public f() {
        this.f531665a = new b(this);
        this.f531666b = "*";
    }

    public void insert(Iterable<T> r100, V r101) {
        f<T, V>.b r102 = this.f531665a;
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        T r104 = r103.next();
        f<T, V>.b r105 = (b) ((HashMap) r102.f531669a).get(r104);
        if (r105 != null) goto L8;
        r105 = new b(r102.f531671c);
        ((HashMap) r102.f531669a).put(r104, r105);
    L8:
        r102 = r105;
        goto L4
    L9:
        r102.f531670b = r101;
    }
}
