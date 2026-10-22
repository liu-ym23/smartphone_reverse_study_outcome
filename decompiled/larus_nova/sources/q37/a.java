package q37;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.nita.api.NitaSchdulerType;
import com.bytedance.nita.schduler.d;
import com.bytedance.nita.schduler.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f531517a = 100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, HashMap<Integer, SparseArray<List<View>>>> f531518b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, ArrayList<String>> f531519c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ArrayList<String> f531520d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, Integer> f531521e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f531522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f531523g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f531524h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f531525i = null;

    /* JADX INFO: renamed from: q37.a$a, reason: collision with other inner class name */
    public static final class ComponentCallbacks2C7275a implements ComponentCallbacks2 {
        public ComponentCallbacks2C7275a() {
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
            a.f531525i.getClass();
            r37.b.f535884e.c().execute(c.f531527a);
            int r100 = r37.c.f535886a;
            o37.c.f521918e.getClass();
            o37.c.c();
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r100) {
            int r101 = r37.c.f535886a;
            o37.c.f521918e.getClass();
            o37.c.c();
        }
    }

    public static final class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            monitor-enter(this);
            ArrayList<String> r101 = a.f531519c.remove(Integer.valueOf(r100.hashCode()));     // Catch: Throwable -> L17
            if (r101 == null) goto L9;
            Iterator<T> r102 = r101.iterator();     // Catch: Throwable -> L17
        L7:
            if (r102.hasNext() == false) goto L9;
            String r103 = (String) r102.next();     // Catch: Throwable -> L17
            a.f531525i.getClass();     // Catch: Throwable -> L17
            a.e(r103, r100);     // Catch: Throwable -> L17
        L9:
            o37.b r104 = o37.a.f521912a;     // Catch: Throwable -> L17
            if ((o37.a.a() & 8) == 0) goto L14;
            ConcurrentHashMap<NitaSchdulerType, d> r105 = f.f266015a;     // Catch: Throwable -> L17
            NitaSchdulerType r106 = NitaSchdulerType.IDEL;     // Catch: Throwable -> L17
            d r107 = f.f266015a.get(r106);     // Catch: Throwable -> L17
            if (r107 == null) goto L14;
            r107.a(r100);     // Catch: Throwable -> L17
        L14:
            Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L17
            monitor-exit(this);
            return;
        L17:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            o37.b r102 = o37.a.f521912a;
            if ((o37.a.a() & 8) == 0) goto L7;
            ConcurrentHashMap<Integer, ArrayList<String>> r103 = a.f531519c;
            if (r103.get(Integer.valueOf(r100.hashCode())) != null) goto L9;
            r103.put(Integer.valueOf(r100.hashCode()), new ArrayList());
            return;
        L9:
            return;
        L7:
            a.f531519c.put(Integer.valueOf(r100.hashCode()), new ArrayList());
        }
    }

    static {
        f531525i = new a();
        f531517a = 100;
        f531518b = new ConcurrentHashMap();
        f531519c = new ConcurrentHashMap();
        f531520d = new ArrayList();
        f531521e = new HashMap();
        f531522f = -1;
        f531523g = new Object();
        b r100 = new b();
        f531524h = r100;
        o37.c.f521918e.getClass();
        ((Application) o37.c.b()).registerActivityLifecycleCallbacks(r100);
        ((Application) o37.c.b()).registerComponentCallbacks(new ComponentCallbacks2C7275a());
    }

    public a() {
        super(Looper.getMainLooper());
    }

    public static int d(String r100) {
        HashMap<Integer, SparseArray<List<View>>> r101 = f531518b.get(r100);
        if (r101 == null) goto L19;
        monitor-enter(r101);
        Iterator<Map.Entry<Integer, SparseArray<List<View>>>> r102 = r101.entrySet().iterator();     // Catch: Throwable -> L16
        int r103 = 0;
    L7:
        if (r102.hasNext() == false) goto L14;
        SparseArray<List<View>> r104 = r102.next().getValue();     // Catch: Throwable -> L16
        if (r104 == null) goto L7;
        int r105 = r104.size();     // Catch: Throwable -> L16
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L7;
        r104.keyAt(r106);     // Catch: Throwable -> L16
        r103 = r103 + r104.valueAt(r106).size();
        r106 = r106 + 1;
        goto L11
    L14:
        monitor-exit(r101);
        return r103;
    L16:
        th = move-exception;
        throw th;
    L19:
        return 0;
    }

    public static void g(String r100) {
        Object r101 = f531523g;
        monitor-enter(r101);
        ArrayList<String> r102 = f531520d;     // Catch: Throwable -> L10
        if (r102.size() != 5) goto L7;
        r102.remove(0);     // Catch: Throwable -> L10
    L7:
        r102.add(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        ConcurrentHashMap<String, HashMap<Integer, SparseArray<List<View>>>> r101 = f531518b;
        Object r102 = r100.obj;
        if (r102 == null) goto L35;
        HashMap<Integer, SparseArray<List<View>>> r103 = r101.get((String) r102);
        if (r103 == null) goto L33;
        monitor-enter(r103);
        SparseArray<List<View>> r104 = r103.get(Integer.valueOf(r100.arg1));     // Catch: Throwable -> L30
        if (r104 != null) goto L10;
    L14:
        if (r104 == null) goto L16;
        r104.remove(r100.what);     // Catch: Throwable -> L30
    L16:
        a r105 = f531525i;     // Catch: Throwable -> L30
        Object r106 = r100.obj;     // Catch: Throwable -> L30
        if (r106 == null) goto L29;
        r105.getClass();     // Catch: Throwable -> L30
        d((String) r106);     // Catch: Throwable -> L30
        o37.c.f521918e.getClass();     // Catch: Throwable -> L30
        com.bytedance.nita.api.b r107 = o37.c.d();     // Catch: Throwable -> L30
        if (r107 == null) goto L25;
        Object r108 = r100.obj;     // Catch: Throwable -> L30
        if (r108 == null) goto L24;
        r107.a((String) r108, r100.what, "clear");     // Catch: Throwable -> L30
        goto L25
    L24:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L30
    L25:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r103);
        return;
    L29:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L30
    L10:
        if (r104.size() != 0) goto L12;
        boolean r110 = true;
    L13:
        if (r110 == true) goto L25;
    L12:
        r110 = false;
    L30:
        th = move-exception;
        throw th;
    L33:
        return;
    L35:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    public static void b(Context r100, com.bytedance.nita.api.c r101) {
        if ((r100 instanceof Activity) == false) goto L26;
        b r102 = f531524h;
        monitor-enter(r102);
        int r103 = r100.hashCode();     // Catch: Throwable -> L23
        o37.b r104 = o37.a.f521912a;     // Catch: Throwable -> L23
        if ((o37.a.a() & 8) == 0) goto L11;
        ConcurrentHashMap<Integer, ArrayList<String>> r105 = f531519c;     // Catch: Throwable -> L23
        if (r105.get(Integer.valueOf(r103)) != null) goto L11;
        r105.put(Integer.valueOf(r103), new ArrayList());     // Catch: Throwable -> L23
    L11:
        ConcurrentHashMap<Integer, ArrayList<String>> r106 = f531519c;     // Catch: Throwable -> L23
        ArrayList<String> r107 = r106.get(Integer.valueOf(r103));     // Catch: Throwable -> L23
        if (r107 != null) goto L15;
    L18:
        ArrayList<String> r108 = r106.get(Integer.valueOf(r103));     // Catch: Throwable -> L23
        if (r108 == null) goto L21;
        r108.add(r101.h());     // Catch: Throwable -> L23
    L21:
        monitor-exit(r102);
        return;
    L15:
        if (r107.contains(r101.h()) != true) goto L18;
        monitor-exit(r102);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static void e(String r100, Context r101) {
        HashMap<Integer, SparseArray<List<View>>> r102 = f531518b.get(r100);
        if (r102 == null) goto L11;
        monitor-enter(r102);
        SparseArray<List<View>> r103 = r102.remove(Integer.valueOf(f531525i.f(r100, r101, false)));     // Catch: Throwable -> L8
        monitor-exit(r102);
    L8:
        th = move-exception;
        throw th;
    L11:
        d(r100);
        o37.c.f521918e.getClass();
        com.bytedance.nita.api.b r104 = o37.c.d();
        if (r104 == null) goto L14;
        r104.a(r100, -1, "clear");
    L14:
        int r105 = r37.c.f535886a;
        o37.c.c();
    }

    public final void c(View r100, com.bytedance.nita.api.c r101, int r102) {
        String r103 = r101.h();
        ConcurrentHashMap<String, HashMap<Integer, SparseArray<List<View>>>> r104 = f531518b;
        HashMap<Integer, SparseArray<List<View>>> r105 = r104.get(r103);
        if (r105 != null) goto L15;
        monitor-enter(this);
        r105 = new HashMap();     // Catch: Throwable -> L12
        if ((r100.getContext() instanceof p37.a) == false) goto L8;
        int r106 = f531522f - 1;     // Catch: Throwable -> L12
        f531522f = r106;     // Catch: Throwable -> L12
        f531521e.put(r103, Integer.valueOf(r106));     // Catch: Throwable -> L12
        SparseArray<List<View>> r107 = r105.put(Integer.valueOf(f531522f), new SparseArray());     // Catch: Throwable -> L12
    L9:
        r104.put(r103, r105);     // Catch: Throwable -> L12
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        goto L15
    L8:
        SparseArray<List<View>> r109 = r105.put(Integer.valueOf(r100.getContext().hashCode()), new SparseArray());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        Context r110 = r100.getContext();
        if (r37.d.a(r110) == true) goto L18;
        return;
    L18:
        monitor-enter(r105);
        int r111 = f531525i.f(r103, r110, false);     // Catch: Throwable -> L35
        if (r105.get(Integer.valueOf(r111)) != null) goto L22;
        r105.put(Integer.valueOf(r111), new SparseArray());     // Catch: Throwable -> L35
    L22:
        SparseArray<List<View>> r112 = r105.get(Integer.valueOf(r111));     // Catch: Throwable -> L35
        if (r112 != null) goto L25;
    L33:
        monitor-exit(r105);
        return;
    L25:
        if (r112.get(r102) != null) goto L27;
        r112.put(r102, new ArrayList());     // Catch: Throwable -> L35
    L27:
        List<View> r113 = r112.get(r102);     // Catch: Throwable -> L35
        if (r113 != null) goto L30;
        Intrinsics.throwNpe();     // Catch: Throwable -> L35
    L30:
        r113.add(r100);     // Catch: Throwable -> L35
        d(r103);     // Catch: Throwable -> L35
        o37.c.f521918e.getClass();     // Catch: Throwable -> L35
        com.bytedance.nita.api.b r114 = o37.c.d();     // Catch: Throwable -> L35
        if (r114 == null) goto L33;
        r114.a(r103, r102, "add");     // Catch: Throwable -> L35
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    }

    public final int f(String r100, Context r101, boolean r102) {
        if ((r101 instanceof p37.a) == true) goto L10;
        if (r101 == null) goto L10;
        if (r102 == true) goto L10;
        if ((r101 instanceof Application) == true) goto L10;
        return r101.hashCode();
    L10:
        monitor-enter(this);
        HashMap<String, Integer> r103 = f531521e;     // Catch: Throwable -> L17
        Integer r104 = r103.get(r100);     // Catch: Throwable -> L17
        if (r104 != null) goto L14;
        int r105 = f531522f - 1;     // Catch: Throwable -> L17
        f531522f = r105;     // Catch: Throwable -> L17
        r104 = Integer.valueOf(r105);     // Catch: Throwable -> L17
        r103.put(r100, r104);     // Catch: Throwable -> L17
    L14:
        int r106 = r104.intValue();     // Catch: Throwable -> L17
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r106;
    L17:
        th = move-exception;
        throw th;
    }

    public final View a(String r100, int r101, Context r102, boolean r103) {
        HashMap<Integer, SparseArray<List<View>>> r104 = f531518b.get(r100);
        monitor-enter(this);
        View r105 = null;
        if (r104 != null) goto L32;
        monitor-exit(this);
        return null;
    L32:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(this);
        monitor-enter(r104);
        SparseArray<List<View>> r107 = r104.get(Integer.valueOf(f531525i.f(r100, r102, r103)));     // Catch: Throwable -> L24
        if (r107 == null) goto L14;
        List<View> r108 = r107.get(r101);     // Catch: Throwable -> L24
    L15:
        int r109 = d(r100);     // Catch: Throwable -> L24
        o37.c.f521918e.getClass();     // Catch: Throwable -> L24
        com.bytedance.nita.api.b r110 = o37.c.d();     // Catch: Throwable -> L24
        if (r110 == null) goto L18;
        Math.max(r109 - 1, 0);     // Catch: Throwable -> L24
        r110.a(r100, r101, "require");     // Catch: Throwable -> L24
    L18:
        if (r108 != null) goto L20;
    L22:
        monitor-exit(r104);
        return r105;
    L20:
        if (r108.size() <= 0) goto L22;
        r105 = r108.remove(0);     // Catch: Throwable -> L24
        goto L22
    L14:
        r108 = null;
    L24:
        th = move-exception;
        throw th;
    L27:
        th = move-exception;
        throw th;
    }
}
