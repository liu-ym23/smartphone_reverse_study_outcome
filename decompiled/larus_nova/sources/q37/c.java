package q37;

import android.util.SparseArray;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f531527a = null;

    static {
        f531527a = new c();
    }

    public c() {
    }

    public static void a() {
        Object r100 = a.f531523g;
        monitor-enter(r100);
        HashMap r101 = new HashMap();     // Catch: Throwable -> L16
        int r102 = a.f531520d.size() - 1;     // Catch: Throwable -> L16
        if (r102 < 0) goto L13;
        int r103 = 0;
    L7:
        ConcurrentHashMap<String, HashMap<Integer, SparseArray<List<View>>>> r104 = a.f531518b;     // Catch: Throwable -> L16
        ArrayList<String> r105 = a.f531520d;     // Catch: Throwable -> L16
        if (r104.get(r105.get(r103)) == null) goto L10;
        r101.put(r105.get(r103), r104.get(r105.get(r103)));     // Catch: Throwable -> L16
    L10:
        int r106 = r37.c.f535886a;     // Catch: Throwable -> L16
        String r107 = r105.get(r103);     // Catch: Throwable -> L16
        o37.c.f521918e.getClass();     // Catch: Throwable -> L16
        o37.c.c();     // Catch: Throwable -> L16
        if (r103 == r102) goto L13;
        r103 = r103 + 1;     // Catch: Throwable -> L16
    L13:
        int r108 = r37.c.f535886a;     // Catch: Throwable -> L16
        ConcurrentHashMap<String, HashMap<Integer, SparseArray<List<View>>>> r109 = a.f531518b;     // Catch: Throwable -> L16
        r109.size();     // Catch: Throwable -> L16
        o37.c.f521918e.getClass();     // Catch: Throwable -> L16
        o37.c.c();     // Catch: Throwable -> L16
        r109.clear();     // Catch: Throwable -> L16
        r109.putAll(r101);     // Catch: Throwable -> L16
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r100);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
