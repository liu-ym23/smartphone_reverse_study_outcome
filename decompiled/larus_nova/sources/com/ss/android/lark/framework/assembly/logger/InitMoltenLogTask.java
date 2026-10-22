package com.ss.android.lark.framework.assembly.logger;

import android.content.Context;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.lark.sdk.log.MoltenLog;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.g;
import com.ss.android.lark.utils.a0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.rust.molten.ffi.MoltenLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/framework/assembly/logger/InitMoltenLogTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "<init>", "()V", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isAsync", "", "logger-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitMoltenLogTask extends AbstractLaunchTask<InitMoltenLogTask> {
    public InitMoltenLogTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r110) {
        String r100 = z.c(r110);
        boolean r101 = false;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r100 = PullConfiguration.PROCESS_NAME_MAIN;
    L8:
        boolean r103 = g.f431408a;
        boolean r104 = DevEnvUtil.isDebugMode(r110);
        String r111 = a0.d(r110);
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r111, "logDir");
        Intrinsics.checkNotNullParameter(r100, "processName");
        if (g.f431408a == true) goto L32;
        g.f431408a = true;
        long r105 = System.currentTimeMillis();     // Catch: Exception -> L27
        String r112 = System.getProperty(MoltenLogger.LIB_NAME_PROPERTY);     // Catch: Exception -> L27
        if (r112 != null) goto L15;
    L16:
        r101 = true;
    L17:
        if (r101 == false) goto L19;
        System.setProperty(MoltenLogger.LIB_NAME_PROPERTY, "lark");     // Catch: Exception -> L27
    L19:
        if (r104 == false) goto L21;
        int r106 = MoltenLog.f254200a;     // Catch: Exception -> L27
        MoltenLog.a.a(MoltenLog.Level.TRACE);     // Catch: Exception -> L27
    L22:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r111, "molten");     // Catch: Exception -> L27
        if (r107.exists() == true) goto L25;
        r107.mkdirs();     // Catch: Exception -> L27
    L25:
        String r113 = r107.getAbsolutePath();     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r113, "logPath");     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r100, "processName");     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r113, "logPath");     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r100, "processName");     // Catch: Exception -> L27
        Log.i("MoltenInitializer", "molten logger init status=" + MoltenLog.b(r100, r113) + " cost: " + (System.currentTimeMillis() - r105) + "ms");     // Catch: Exception -> L27
        return;
    L21:
        int r108 = MoltenLog.f254200a;     // Catch: Exception -> L27
        MoltenLog.a.a(MoltenLog.Level.INFO);     // Catch: Exception -> L27
        goto L22
    L15:
        if (r112.length() != 0) goto L17;
    L27:
        e = move-exception;
        Log.e("MoltenInitializer", "molten logger init error", e);
        return;
    L32:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
