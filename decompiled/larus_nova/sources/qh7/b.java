package qh7;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.timonbase.scene.lifecycle.ForegroundState;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import ph7.d;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Integer, String> f532975a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashSet<a> f532976b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f532977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f532978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C7330b f532979e = null;

    public interface a {
        void a();

        void b();

        void onAppBackground();

        void onAppForeground();
    }

    /* JADX INFO: renamed from: qh7.b$b, reason: collision with other inner class name */
    public static final class C7330b extends c {
        public C7330b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            HashMap<Integer, String> r101 = b.f532975a;
            r101.remove(Integer.valueOf(r100.hashCode()));
            boolean r102 = !r101.isEmpty();
            if (r102 == false) goto L5;
        L10:
            boolean r103 = b.a().f270887b;
            if (r103 == false) goto L13;
        L18:
            b.f532978d = r103;
            b.f532977c = r102;
            return;
        L13:
            if (b.f532978d == r103) goto L18;
            Iterator<T> r104 = b.f532976b.iterator();
        L16:
            if (r104.hasNext() == false) goto L18;
            ((a) r104.next()).onAppBackground();
            goto L16
        L5:
            if (b.f532977c == r102) goto L10;
            qh7.a.d(false);
            Iterator<T> r105 = b.f532976b.iterator();
        L8:
            if (r105.hasNext() == false) goto L10;
            ((a) r105.next()).b();
            goto L8
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            b.f532975a.put(Integer.valueOf(r100.hashCode()), r100.getClass().getSimpleName());
            if (b.f532977c == true) goto L9;
            qh7.a.d(true);
            Iterator<T> r101 = b.f532976b.iterator();
        L6:
            if (r101.hasNext() == false) goto L9;
            ((a) r101.next()).a();
        L9:
            if (b.f532978d == true) goto L14;
            Iterator<T> r102 = b.f532976b.iterator();
        L12:
            if (r102.hasNext() == false) goto L14;
            ((a) r102.next()).onAppForeground();
        L14:
            b.f532977c = true;
            b.f532978d = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            HashMap<Integer, String> r101 = b.f532975a;
            r101.remove(Integer.valueOf(r100.hashCode()));
            boolean r102 = !r101.isEmpty();
            if (r102 == false) goto L5;
        L10:
            boolean r103 = b.a().f270887b;
            if (r103 == false) goto L13;
        L18:
            b.f532978d = r103;
            b.f532977c = r102;
            return;
        L13:
            if (b.f532978d == r103) goto L18;
            Iterator<T> r104 = b.f532976b.iterator();
        L16:
            if (r104.hasNext() == false) goto L18;
            ((a) r104.next()).onAppBackground();
            goto L16
        L5:
            if (b.f532977c == r102) goto L10;
            qh7.a.d(false);
            Iterator<T> r105 = b.f532976b.iterator();
        L8:
            if (r105.hasNext() == false) goto L10;
            ((a) r105.next()).b();
            goto L8
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            b.f532975a.put(Integer.valueOf(r100.hashCode()), r100.getClass().getSimpleName());
            if (b.f532977c == true) goto L9;
            qh7.a.d(true);
            Iterator<T> r102 = b.f532976b.iterator();
        L6:
            if (r102.hasNext() == false) goto L9;
            ((a) r102.next()).a();
        L9:
            if (b.f532978d == true) goto L14;
            Iterator<T> r103 = b.f532976b.iterator();
        L12:
            if (r103.hasNext() == false) goto L14;
            ((a) r103.next()).onAppForeground();
        L14:
            b.f532977c = true;
            b.f532978d = true;
        }
    }

    static {
        f532975a = new HashMap();
        f532976b = new LinkedHashSet();
        f532979e = new C7330b();
    }

    public static ForegroundState a() {
        ph7.c r100 = d.f529300a;
        if (r100 == null) goto L5;
        boolean r101 = r100.d();
    L6:
        if (r101 == false) goto L13;
        ForegroundState r102 = sh7.a.f541973a;
        if (r102 != null) goto L11;
        r102 = qh7.a.a();
    L11:
        sh7.a.f541973a = r102;
        return r102;
    L13:
        return qh7.a.a();
    L5:
        r101 = false;
        goto L6
    }
}
