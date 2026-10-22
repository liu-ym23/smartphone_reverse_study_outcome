package oj4;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends PthreadThreadV2 {
    public final BluetoothSocket A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final BluetoothDevice f523510v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Handler f523511w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public InputStream f523512x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f523513y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public OutputStream f523514z;

    public final void l() {
        qj4.a.c("BluetoothClientThread", "close");
        InputStream r100 = this.f523512x;     // Catch: IOException -> L14
        if (r100 == null) goto L6;
        r100.close();     // Catch: IOException -> L14
        this.f523512x = null;     // Catch: IOException -> L14
    L6:
        OutputStream r101 = this.f523514z;     // Catch: IOException -> L14
        if (r101 == null) goto L9;
        r101.close();     // Catch: IOException -> L14
        this.f523514z = null;     // Catch: IOException -> L14
    L9:
        BluetoothSocket r102 = this.A;     // Catch: IOException -> L14
        if (r102 == null) goto L12;
        r102.close();     // Catch: IOException -> L14
    L12:
        Handler r103 = this.f523511w;     // Catch: IOException -> L14
        r103.sendMessage(r103.obtainMessage(6007, this.f523510v));     // Catch: IOException -> L14
        return;
    L14:
        e = move-exception;
        qj4.a.b("BluetoothClientThread", "sendData error " + e);
    }

    public final void m() {
        BluetoothSocket r100 = this.A;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isConnected() == false) goto L30;
    L11:
        new DataInputStream(this.f523512x);
    L13:
        if (this.f523513y == true) goto L26;
        byte[] r101 = new byte[2097152];     // Catch: IOException -> L24
        int r102 = this.f523512x.read(r101);     // Catch: IOException -> L24
        if (r102 == (-1)) goto L17;
        if (r102 < 0) goto L22;
        if (r102 > 2097152) goto L22;
        rj4.d.e().i(r101, (short) r102);     // Catch: IOException -> L24
    L22:
        qj4.a.c("BluetoothClientThread", "len is invalid, len " + r102);     // Catch: IOException -> L24
        goto L13
    L17:
        this.f523513y = true;     // Catch: IOException -> L24
    L24:
        e = move-exception;
        this.f523513y = true;
        qj4.a.b("BluetoothClientThread", "recv data error " + e);
        goto L13
    L26:
        l();
        return;
    L30:
        long r103 = System.currentTimeMillis();     // Catch: IOException -> L9
        this.A.connect();     // Catch: IOException -> L9
        long r104 = System.currentTimeMillis() - r103;     // Catch: IOException -> L9
        Handler r105 = this.f523511w;     // Catch: IOException -> L9
        r105.sendMessage(r105.obtainMessage(6003));     // Catch: IOException -> L9
        Handler r106 = this.f523511w;     // Catch: IOException -> L9
        r106.sendMessage(r106.obtainMessage(1, 0, (int) r104, "与server连接完成"));     // Catch: IOException -> L9
        Handler r107 = this.f523511w;     // Catch: IOException -> L9
        r107.sendMessage(r107.obtainMessage(6012, 0, 0, this.f523510v));     // Catch: IOException -> L9
    L9:
        e = move-exception;
        qj4.a.b("BluetoothClientThread", "connect error " + e);
        goto L11
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
        m();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(BluetoothSocket r100, Handler r101) {
        super("BluetoothClientThread");
        this.A = r100;
        this.f523510v = r100.getRemoteDevice();
        this.f523511w = r101;
        this.f523512x = r100.getInputStream();     // Catch: IOException -> L5
        this.f523514z = r100.getOutputStream();     // Catch: IOException -> L5
        return;
    }
}
