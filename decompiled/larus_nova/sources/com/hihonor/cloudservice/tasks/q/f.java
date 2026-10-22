package com.hihonor.cloudservice.tasks.q;

import android.app.Fragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kw7.a;

/* JADX INFO: loaded from: classes23.dex */
public final class f extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<WeakReference<a<?>>> f276523a;

    static {
        new WeakHashMap();
    }

    public f() {
        this.f276523a = new ArrayList();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        List<WeakReference<a<?>>> r100 = this.f276523a;
        monitor-enter(r100);
        Iterator r101 = ((ArrayList) this.f276523a).iterator();     // Catch: Throwable -> L13
    L6:
        if (r101.hasNext() == false) goto L10;
        a r102 = (a) ((WeakReference) r101.next()).get();     // Catch: Throwable -> L13
        if (r102 == null) goto L6;
        r102.cancel();     // Catch: Throwable -> L13
        goto L6
    L10:
        ((ArrayList) this.f276523a).clear();     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
