package com.bytedance.ee.bear.office.list.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.OfficeFolderDetailHostFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements Runnable {
    public final /* synthetic */ boolean[] a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ OfficeSpaceTab c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Function0<Unit> e;

    public d(boolean[] r1, Fragment r2, OfficeSpaceTab r3, boolean r4, Function0<Unit> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        boolean r1 = false;
        if (this.a[0] == false) goto L5;
    L37:
        tt5.a.k("OfficeCreateFolderAction", "skip create folder success because office owner is inactive");
        return;
    L5:
        if (this.b.isAdded() == false) goto L37;
        if (this.b.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) < 0) goto L37;
        e r0 = e.a;
        OfficeSpaceTab r3 = this.c;
        boolean r4 = this.d;
        r0.getClass();
        if (r4 == true) goto L15;
        if (r3 == OfficeSpaceTab.MINE) goto L15;
        r1 = true;
    L15:
        if (r1 == false) goto L19;
        Function0<Unit> r2 = this.e;
        if (r2 == null) goto L35;
        r2.invoke();
    L35:
        jw4.a.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), sbb.e.c(sbb.e.f.b));
        return;
    L19:
        Fragment r5 = this.b;
        OfficeSpaceTab r6 = this.c;
        if (this.d == false) goto L28;
        Fragment r7 = r5.getParentFragment();
    L22:
        if (r7 == null) goto L27;
        if ((r7 instanceof OfficeFolderDetailHostFragment) == true) goto L25;
        r7 = r7.getParentFragment();
        goto L22
    L25:
        ((OfficeFolderDetailHostFragment) r7).ba0();
        goto L35
    L27:
        tt5.a.k("OfficeCreateFolderAction", "refresh current folder after create failed, folder host missing");
        goto L35
    L28:
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r8 = com.bytedance.ee.bear.office.list.h.a;
        Bundle r9 = r5.getArguments();
        if (r9 == null) goto L31;
        String r10 = r9.getString("office_list_runtime_id");
    L33:
        if (com.bytedance.ee.bear.office.list.h.j(r10, OfficeSpaceTab.MINE) == true) goto L35;
        tt5.a.k("OfficeCreateFolderAction", "refresh mine root after create folder failed, sourceTab=" + r6);
        goto L35
    L31:
        r10 = null;
        goto L33
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
