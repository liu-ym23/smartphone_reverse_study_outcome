package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class SystemManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SystemManager f276915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f276916b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static SystemNotifier f276917c;

    public class a implements SystemNotifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<SystemObserver> f276918a;

        public a() {
            this.f276918a = new ArrayList();
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyNoticeObservers(int r100) {
            Object r101 = SystemManager.a();
            monitor-enter(r101);
            Iterator<SystemObserver> r102 = this.f276918a.iterator();     // Catch: Throwable -> L12
        L6:
            if (r102.hasNext() == false) goto L10;
            if (r102.next().onNoticeResult(r100) == false) goto L6;
            r102.remove();     // Catch: Throwable -> L12
            goto L6
        L10:
            monitor-exit(r101);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(int r100) {
            Object r101 = SystemManager.a();
            monitor-enter(r101);
            Iterator<SystemObserver> r102 = this.f276918a.iterator();     // Catch: Throwable -> L12
        L6:
            if (r102.hasNext() == false) goto L10;
            if (r102.next().onUpdateResult(r100) == false) goto L6;
            r102.remove();     // Catch: Throwable -> L12
            goto L6
        L10:
            monitor-exit(r101);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void registerObserver(SystemObserver r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (this.f276918a.contains(r100) == true) goto L14;
            Object r101 = SystemManager.a();
            monitor-enter(r101);
            this.f276918a.add(r100);     // Catch: Throwable -> L11
            monitor-exit(r101);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void unRegisterObserver(SystemObserver r100) {
            Object r101 = SystemManager.a();
            monitor-enter(r101);
            this.f276918a.remove(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(Intent r100, String r101) {
            Object r102 = SystemManager.a();
            monitor-enter(r102);
            Iterator<SystemObserver> r103 = this.f276918a.iterator();     // Catch: Throwable -> L12
        L6:
            if (r103.hasNext() == false) goto L10;
            if (r103.next().onSolutionResult(r100, r101) == false) goto L6;
            r103.remove();     // Catch: Throwable -> L12
            goto L6
        L10:
            monitor-exit(r102);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    static {
        f276915a = new SystemManager();
        f276916b = new Object();
        f276917c = new a();
    }

    private SystemManager() {
    }

    public static /* synthetic */ Object a() {
        return f276916b;
    }

    public static SystemManager getInstance() {
        return f276915a;
    }

    public static SystemNotifier getSystemNotifier() {
        return f276917c;
    }

    public void notifyNoticeResult(int r100) {
        f276917c.notifyNoticeObservers(r100);
    }

    public void notifyUpdateResult(int r100) {
        f276917c.notifyObservers(r100);
    }

    public void notifyResolutionResult(Intent r100, String r101) {
        f276917c.notifyObservers(r100, r101);
    }
}
