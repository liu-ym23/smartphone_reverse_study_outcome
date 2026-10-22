package com.ss.android.lark.officesdk.integrator.core.corrupt;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import fab.c;
import fab.e;
import fab.f;
import fab.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wtb.b;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0002¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/integrator/core/corrupt/InitDbCorruptPushTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "<init>", "()V", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "registerPush", "Companion", "officesdk-integrator-im_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitDbCorruptPushTask extends AbstractLaunchTask<Object> {

    public static final class a {
    }

    static {
    }

    public InitDbCorruptPushTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Log.i("InitDbCorruptPushTask", "register db corrupt push before IM SDK init");
        if (b.f561273a == null) goto L5;
    L14:
        b.f561273a.getClass();
        g r101 = g.a.f476084a;
        final e r102 = e.a.f476082a;
        r102.f476081b = new f();
        if (r102.f476080a.compareAndSet(false, true) == true) goto L17;
        Log.i("DataCorruptPush", "PUSH_DATA_CORRUPT listener has already registered.");
        return;
    L17:
        com.ss.android.lark.sdk.g.e.f439875a.b(Command.PUSH_DATA_CORRUPT, new c(r102));
        return;
    L5:
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b.f561273a != null) goto L9;
        b.f561273a = new fab.a(b.a.f561274a);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
        goto L14
    }
}
