package oj4;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends PthreadThreadV2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Handler f523515v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final BluetoothServerSocket f523516w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a f523517x;

    public final void l() {
        long r100 = System.currentTimeMillis();
        qj4.a.a("BluetoothServerThread", "等待连接完成 startTime = " + r100);     // Catch: IOException -> L5
        BluetoothSocket r101 = this.f523516w.accept();     // Catch: IOException -> L5
        Handler r102 = this.f523515v;     // Catch: IOException -> L5
        r102.sendMessage(r102.obtainMessage(1, 0, 0, "与client连接完成"));     // Catch: IOException -> L5
        Handler r103 = this.f523515v;     // Catch: IOException -> L5
        r103.sendMessage(r103.obtainMessage(AuthCode.StatusCode.PERMISSION_EXPIRED, r101.getRemoteDevice()));     // Catch: IOException -> L5
        a r104 = new a(r101, this.f523515v);     // Catch: IOException -> L5
        this.f523517x = r104;     // Catch: IOException -> L5
        ThreadMethodProxy.start(r104);     // Catch: IOException -> L5
        qj4.a.a("BluetoothServerThread", "连接完成 startTime = " + r100);     // Catch: IOException -> L5
    L7:
        qj4.a.a("BluetoothServerThread", "退出循环");
        Handler r105 = this.f523515v;
        r105.sendMessage(r105.obtainMessage(6008));
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
        l();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(f.c r100, UUID r101) {
        super("BluetoothServerThread");
        BluetoothAdapter r102 = BluetoothAdapter.getDefaultAdapter();
        this.f523517x = null;
        this.f523515v = r100;
        qj4.a.c("BluetoothServerThread", "call BluetoothServerThread create");
        this.f523516w = r102.listenUsingRfcommWithServiceRecord("DATA", r101);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        qj4.a.a("BluetoothServerThread", "error" + e);
    }
}
