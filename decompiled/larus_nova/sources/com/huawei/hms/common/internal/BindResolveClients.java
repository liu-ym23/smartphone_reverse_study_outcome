package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes23.dex */
public class BindResolveClients {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f277085b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<ResolveClientBean> f277086a;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final BindResolveClients f277087a = null;

        static {
            f277087a = new BindResolveClients(null);
        }

        public static /* synthetic */ BindResolveClients a() {
            return f277087a;
        }
    }

    static {
        f277085b = new Object();
    }

    public void notifyClientReconnect() {
        Object r100 = f277085b;
        monitor-enter(r100);
        ListIterator<ResolveClientBean> r101 = this.f277086a.listIterator();     // Catch: Throwable -> L11
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().clientReconnect();     // Catch: Throwable -> L11
        goto L6
    L8:
        this.f277086a.clear();     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void unRegisterAll() {
        Object r100 = f277085b;
        monitor-enter(r100);
        this.f277086a.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private BindResolveClients() {
        this.f277086a = new ArrayList();
    }

    public static BindResolveClients getInstance() {
        return b.a();
    }

    public /* synthetic */ BindResolveClients(a r100) {
        this();
    }

    public boolean isClientRegistered(ResolveClientBean r100) {
        Object r101 = f277085b;
        monitor-enter(r101);
        boolean r102 = this.f277086a.contains(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public void register(ResolveClientBean r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Object r101 = f277085b;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f277086a.contains(r100) == true) goto L9;
        this.f277086a.add(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public void unRegister(ResolveClientBean r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Object r101 = f277085b;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.f277086a.contains(r100) == false) goto L14;
        ListIterator<ResolveClientBean> r102 = this.f277086a.listIterator();     // Catch: Throwable -> L16
    L10:
        if (r102.hasNext() == false) goto L14;
        if (r100.equals(r102.next()) == false) goto L10;
        r102.remove();     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
    }
}
