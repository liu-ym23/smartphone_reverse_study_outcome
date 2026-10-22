package com.ss.android.lark.framework.assembly.appconfig;

import android.content.Context;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.launch.task.BaseWarmupTriggerState;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.util.concurrent.atomic.AtomicBoolean;
import jdb.e;
import yzb.b;

/* JADX INFO: loaded from: classes36.dex */
public class InitSettingsTask extends AsyncLaunchTask {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f425615c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f425616d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Boolean f425617e;

    static {
        f425615c = new AtomicBoolean(false);
        f425616d = new AtomicBoolean(false);
        f425617e = null;
    }

    public static void j() {
        AtomicBoolean r100 = f425616d;
        if (r100.get() == false) goto L6;
        return;
    L6:
        monitor-enter(InitSettingsTask.class);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (r100.get() == false) goto L11;
        monitor-exit(InitSettingsTask.class);     // Catch: Throwable -> L14
        return;
    L11:
        ((e) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(e.class)).Y9();     // Catch: Throwable -> L14
        r100.set(true);     // Catch: Throwable -> L14
        monitor-exit(InitSettingsTask.class);     // Catch: Throwable -> L14
    }

    public static void k() {
        if (f425617e != null) goto L5;
    L7:
        f425617e = Boolean.TRUE;
        com.ss.android.lark.larkconfig.userconfig.e.a.f431150a.b();
        return;
    L5:
        if (f425617e.booleanValue() != true) goto L7;
    }

    public static void l() {
        Log.i("InitSettingsTask", "runInternal");
        AtomicBoolean r100 = f425615c;
        if (r100.get() == false) goto L6;
    L13:
        j();
        if (((b) LarkContext.spiByDwarf(b.class)).isLogin() == false) goto L16;
        k();
        return;
    L16:
        opb.e.a.f524824a.e();
        return;
    L6:
        monitor-enter(InitSettingsTask.class);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (r100.get() == false) goto L11;
        monitor-exit(InitSettingsTask.class);     // Catch: Throwable -> L18
    L21:
        goto L13
    L11:
        h.a(new a((j) LarkContext.spiByDwarf(j.class)));     // Catch: Throwable -> L18
        r100.set(true);     // Catch: Throwable -> L18
        monitor-exit(InitSettingsTask.class);     // Catch: Throwable -> L18
        goto L21
    }

    public InitSettingsTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        Log.i("InitSettingsTask", "execute");
        if (BaseWarmupTriggerState.f285670a.get() == false) goto L6;
        Log.i("InitSettingsTask", "skip execute, BASE warmup already triggered");
        return;
    L6:
        l();
    }
}
