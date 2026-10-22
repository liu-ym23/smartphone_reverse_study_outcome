package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import com.huawei.hmf.tasks.ExecuteResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class g extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<Activity, WeakReference<g>> f276796b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<WeakReference<ExecuteResult<?>>> f276797a;

    static {
        f276796b = new WeakHashMap();
    }

    public g() {
        this.f276797a = new ArrayList();
    }

    public final void a(ExecuteResult r100) {
        List<WeakReference<ExecuteResult<?>>> r101 = this.f276797a;
        monitor-enter(r101);
        this.f276797a.add(new WeakReference(r100));     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        List<WeakReference<ExecuteResult<?>>> r100 = this.f276797a;
        monitor-enter(r100);
        Iterator<WeakReference<ExecuteResult<?>>> r101 = this.f276797a.iterator();     // Catch: Throwable -> L13
    L6:
        if (r101.hasNext() == false) goto L10;
        ExecuteResult<?> r102 = r101.next().get();     // Catch: Throwable -> L13
        if (r102 == null) goto L6;
        r102.cancel();     // Catch: Throwable -> L13
        goto L6
    L10:
        this.f276797a.clear();     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static void a(Activity r100, ExecuteResult r101) {
        WeakReference<g> r102 = f276796b.get(r100);
        if (r102 != null) goto L5;
    L7:
        FragmentManager r103 = r100.getFragmentManager();
        g r104 = null;
        g r105 = (g) r103.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");     // Catch: ClassCastException -> L23
        if (r105 == null) goto L31;
        r104 = r105;
    L21:
        f276796b.put(r100, new WeakReference(r104));     // Catch: ClassCastException -> L23
    L25:
        g r106 = r104;
    L26:
        if (r106 == null) goto L37;
        r106.a(r101);
        return;
    L37:
        return;
    L31:
        g r107 = new g();     // Catch: Exception -> L15
        r103.beginTransaction().add(r107, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();     // Catch: Exception -> L13
        r104 = r107;
    L13:
        e = e;
        r104 = r107;
    L29:
        e.getMessage();     // Catch: ClassCastException -> L18
    L18:
        e = e;
        r104 = r105;
    L24:
        e.getMessage();
    L15:
        e = e;
    L23:
        e = e;
        goto L24
    L5:
        if (r102.get() == null) goto L7;
        r106 = r102.get();
        goto L26
    }
}
