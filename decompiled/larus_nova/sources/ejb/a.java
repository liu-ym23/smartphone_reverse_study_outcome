package ejb;

import cbb.d;
import com.bytedance.lark.pb.basic.v1.TriggerDataCleanRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.framework.assembly.diskmanage.RustCleanTask$onRemoteCleanOnce$1;
import com.ss.android.lark.framework.assembly.diskmanage.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import qpc.e;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements Runnable {
    public static void a() {
        Log.i("TaskLaunchStrategy", "begin execute rust clean task on condition backgroud + plugin");
        AtomicBoolean r100 = c.f425632a;
        c.b.f425633a.getClass();
        d r101 = c.b();
        Intrinsics.checkNotNullParameter(r101, "remoteConfig");
        final cbb.a r102 = new cbb.a(false, 0, 7);
        cbb.c r103 = r101.f23126a;
        int r104 = (int) r103.f23124e;
        int r105 = (int) r103.f23122c;
        ((e) ApiUtils.getApi(e.class)).triggerDataClean(Integer.valueOf(r104), Integer.valueOf(r105), TriggerDataCleanRequest.CleanType.AUTO, new RustCleanTask$onRemoteCleanOnce$1(r102));
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

    public a() {
    }
}
