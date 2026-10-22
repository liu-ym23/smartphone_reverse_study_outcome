package com.flow.performance.perflog.scenario;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f274156a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f274157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArraySet<InterfaceC3840a> f274158c = null;

    /* JADX INFO: renamed from: com.flow.performance.perflog.scenario.a$a, reason: collision with other inner class name */
    public interface InterfaceC3840a {
        void a(boolean r100);
    }

    public static final class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "intent");
            a r102 = a.f274156a;
            int r103 = r101.getIntExtra("status", -1);
            if (r103 != 2) goto L5;
        L8:
            boolean r104 = true;
        L10:
            if (r104 == a.f274157b) goto L23;
            a.f274157b = r104;
            monitor-enter(r102);
            Iterator<InterfaceC3840a> r105 = a.f274158c.iterator();     // Catch: Throwable -> L20
        L15:
            if (r105.hasNext() == false) goto L17;
            r105.next().a(a.f274157b);     // Catch: Throwable -> L20
            goto L15
        L17:
            Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
            monitor-exit(r102);
            return;
        L20:
            th = move-exception;
            throw th;
        L23:
            return;
        L5:
            if (r103 == 5) goto L8;
            r104 = false;
            goto L10
        }
    }

    public a() {
    }

    static {
        f274156a = new a();
        f274158c = new CopyOnWriteArraySet();
    }
}
