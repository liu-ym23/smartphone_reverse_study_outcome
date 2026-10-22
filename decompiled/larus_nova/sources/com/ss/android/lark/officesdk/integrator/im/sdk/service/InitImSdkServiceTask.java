package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/integrator/im/sdk/service/InitImSdkServiceTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "<init>", "()V", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getTaskName", "", "Companion", "officesdk-integrator-im_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitImSdkServiceTask extends AbstractLaunchTask<InitImSdkServiceTask> {

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final String f() {
        return "InitImSdkService";
    }

    public InitImSdkServiceTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Log.i("InitImSdkService", "before init IM SDK");
        ikb.c.a r101 = new ikb.c.a(LarkContext.getApplication());
        f r102 = new f();
        Intrinsics.checkNotNullParameter(r102, "proxyFactory");
        r101.f490291b = r102;
        ikb.c r103 = new ikb.c(r101);
        ImSdk r104 = ImSdk.f425890a;
        monitor-enter(r104);
        Intrinsics.checkNotNullParameter(r103, "options");     // Catch: Throwable -> L13
        if (ImSdk.f425892c == false) goto L9;
        int r105 = com.ss.android.lark.im.sdk.a.f425904a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter("Duplicated init method call.", "message");     // Catch: Throwable -> L13
        Log.w("ImSdk", "Duplicated init method call.");     // Catch: Throwable -> L13
        monitor-exit(r104);
    L11:
        Log.i("InitImSdkService", "after init IM SDK");
        return;
    L9:
        int r106 = com.ss.android.lark.im.sdk.a.f425904a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter("init", "message");     // Catch: Throwable -> L13
        Log.i("ImSdk", "init");     // Catch: Throwable -> L13
        ImSdk.f425891b = r103.getContext();     // Catch: Throwable -> L13
        ikb.h r107 = ImSdkProxy.f425895a;     // Catch: Throwable -> L13
        ImSdkProxy.f425895a = r103.f490289b;     // Catch: Throwable -> L13
        ImSdk.f425892c = true;     // Catch: Throwable -> L13
        monitor-exit(r104);
    L13:
        th = move-exception;
        throw th;
    }
}
