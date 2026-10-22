package fra;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.account.share.data.read.ReadTempActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f478634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f478635b;

    public e(String r100, a r101) {
        this.f478634a = r100;
        this.f478635b = r101;
    }

    public final void a() {
        Intent r100 = new Intent(f.f478636a, ReadTempActivity.class);     // Catch: Exception -> L7
        r100.putExtra("EXTRA_KEY", this.f478634a);     // Catch: Exception -> L7
        r100.putExtra("READ_PKG", this.f478635b.f478619a);     // Catch: Exception -> L7
        r100.addFlags(268435456);     // Catch: Exception -> L7
        Context r101 = f.f478636a;     // Catch: Exception -> L7
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();     // Catch: Exception -> L7
    L5:
        r101.startActivity(r100);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f.f478641f = false;
        dra.b r102 = new dra.b();
        r102.b("share_sdk_read_data_err");
        r102.a(LocationMonitorConst.ERR_MSG, e.getMessage());
        r102.a("err_msg_stack", Log.getStackTraceString(e));
        r102.c();
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
