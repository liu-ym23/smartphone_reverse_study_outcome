package to7;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static Activity[] a() {
        Set<String> r100 = a.f546943k;
        a r101 = a.d.f546961a;
        Activity[] r102 = new Activity[r101.f546950g.size()];
        return (Activity[]) r101.f546950g.toArray(r102);
    }

    public static Activity b() {
        Set<String> r100 = a.f546943k;
        return a.d.f546961a.e();
    }

    public static boolean c() {
        Set<String> r100 = a.f546943k;
        return a.d.f546961a.f546946c;
    }

    public static void d(uo7.a r100) {
        Set<String> r101 = a.f546943k;
        a r102 = a.d.f546961a;
        if (r100 == null) goto L13;
        Iterator<WeakReference<uo7.a>> r103 = r102.f546951h.iterator();
    L6:
        if (r103.hasNext() == false) goto L12;
        WeakReference<uo7.a> r104 = r103.next();
        if (r104 == null) goto L6;
        if (r100.equals(r104.get()) == false) goto L6;
        return;
    L12:
        WeakReference<uo7.a> r105 = new WeakReference(r100);
        r102.f546951h.add(r105);
        return;
    L13:
        r102.getClass();
    }

    public static void e(uo7.a r100) {
        Set<String> r101 = a.f546943k;
        a r102 = a.d.f546961a;
        if (r100 != null) goto L5;
        r102.getClass();
        return;
    L5:
        Iterator<WeakReference<uo7.a>> r103 = r102.f546951h.iterator();
    L7:
        if (r103.hasNext() == false) goto L21;
        WeakReference<uo7.a> r104 = r103.next();
        if (r104 == null) goto L7;
        if (r104.get() != r100) goto L7;
        r102.f546951h.remove(r104);
        goto L7
    }
}
