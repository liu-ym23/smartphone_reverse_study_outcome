package com.bytedance.bdp.appbase.base.ipc;

import android.content.Context;
import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.bdpbase.ipc.c;
import com.bytedance.bdp.bdpbase.ipc.e;
import com.bytedance.bdp.bdpbase.ipc.extention.MainDefaultIpcService;
import com.bytedance.bdp.bdpbase.ipc.l;
import com.bytedance.bdp.bdpbase.ipc.t;
import com.bytedance.bdp.bdpbase.util.i;

/* JADX INFO: loaded from: classes3.dex */
public class BdpIpcServiceImpl implements BdpIpcService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f200563a;

    /* JADX INFO: loaded from: classes11.dex */
    public class a implements l {
        public a() {
        }

        @Override // com.bytedance.bdp.bdpbase.ipc.l
        public final void a(Runnable r100) {
            BdpPool.executeQuickly(r100);
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public class b implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BdpIpcServiceImpl f200564a;

        public final boolean a() {
            Context r100 = z84.a.a().getApplicationContext();
            return i.b(r100, r100.getPackageName());
        }

        public b(BdpIpcServiceImpl r100) {
            this.f200564a = r100;
        }
    }

    public BdpIpcServiceImpl() {
    }

    @Override // com.bytedance.bdp.appbase.base.ipc.BdpIpcService
    public final synchronized e getMainBdpIPC() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f200563a != null) goto L6;
        E2();     // Catch: Throwable -> L9
    L6:
        e r100 = this.f200563a;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final void E2() {
        Context r100 = z84.a.a().getApplicationContext();
        Context r101 = r100.getApplicationContext();
        String r102 = r100.getPackageName();
        String r103 = MainDefaultIpcService.class.getName();
        a r104 = new a();
        if (t.k(r102) == false) goto L6;
        r102 = r101.getPackageName();
    L6:
        if (t.k(r102) == true) goto L17;
        if (t.k(null) == true) goto L10;
    L14:
        e r105 = new e(r101, r102, r103, r104);
        this.f200563a = r105;
        r105.f201149n = new b(this);
        return;
    L10:
        if (t.k(r103) == false) goto L14;
        throw new IllegalStateException("You must set one of the action or className.");
    L17:
        throw new IllegalStateException("Package name required.");
    }
}
