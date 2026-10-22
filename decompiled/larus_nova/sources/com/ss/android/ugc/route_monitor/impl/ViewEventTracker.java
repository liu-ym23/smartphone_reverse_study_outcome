package com.ss.android.ugc.route_monitor.impl;

import android.view.View;
import com.ss.android.ugc.route_monitor.utils.Logger;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.LinkedList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/ViewEventTracker;", "", "Landroid/view/View;", BaseSwitches.V, "", "onViewClick", "<init>", "()V", "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final class ViewEventTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedList<n> f454398a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.ss.android.ugc.route_monitor.utils.j<jhc.m> f454399b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ViewEventTracker f454400c = null;

    public static final class a implements com.ss.android.ugc.route_monitor.utils.j.a<jhc.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f454401a;

        public a(View r100) {
            this.f454401a = r100;
        }

        public void call(jhc.m r100) {
            ViewEventTracker.f454400c.getClass();
            n r101 = (n) CollectionsKt.firstOrNull(ViewEventTracker.f454398a);
            r100.h();
        }

        @Override // com.ss.android.ugc.route_monitor.utils.j.a
        public /* bridge */ /* synthetic */ void call(com.ss.android.ugc.route_monitor.utils.j.b r100) {
            call((jhc.m) r100);
        }
    }

    public ViewEventTracker() {
    }

    static {
        f454400c = new ViewEventTracker();
        f454398a = new LinkedList();
        f454399b = new com.ss.android.ugc.route_monitor.utils.j();
    }

    @JvmStatic
    public static final void onViewClick(View r100) {
        Logger r101 = Logger.f454747c;
        Objects.toString(r100);
        r101.b();
        if (r100 != null) goto L14;
        return;
    L14:
        LinkedList<n> r102 = f454398a;     // Catch: Throwable -> L10
        if (r102.size() < 20) goto L8;
        r102.removeLast();     // Catch: Throwable -> L10
    L8:
        int r103 = n.f454487g;     // Catch: Throwable -> L10
        r102.addFirst(n.a.a(r100, System.currentTimeMillis()));     // Catch: Throwable -> L10
    L12:
        f454399b.b(new a(r100));
        return;
    L10:
        th = move-exception;
        Logger.f454747c.d(th);
        goto L12
    }
}
