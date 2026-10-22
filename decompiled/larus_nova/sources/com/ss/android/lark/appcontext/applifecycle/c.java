package com.ss.android.lark.appcontext.applifecycle;

import android.app.Activity;
import com.larksuite.framework.callback.IGetDataCallback;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f408827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<Activity> f408828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<WeakReference<Activity>> f408829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<s> f408830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<IGetDataCallback<Activity>> f408831e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f408832a = null;

        static {
            f408832a = new c();
        }
    }

    public final Activity a() {
        return this.f408828b.peekLast();
    }

    public c() {
        this.f408827a = false;
        this.f408828b = new LinkedList();
        this.f408829c = new LinkedList();
        this.f408830d = new CopyOnWriteArrayList();
        this.f408831e = new CopyOnWriteArrayList();
    }

    public final void b(boolean r100) {
        if (this.f408827a == r100) goto L8;
        Iterator r101 = ((CopyOnWriteArrayList) this.f408830d).iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((s) r101.next()).a(r100);
    L8:
        this.f408827a = r100;
    }
}
