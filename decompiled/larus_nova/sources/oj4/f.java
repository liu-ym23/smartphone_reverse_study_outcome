package oj4;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.os.Handler;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.LinkedBlockingQueue;
import rj4.g;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements tj4.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f523520f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public oj4.c f523521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<tj4.b> f523522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public oj4.a f523523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public oj4.b f523524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f523525e;

    public class a implements rj4.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f523526a;

        public a(f r100) {
            this.f523526a = r100;
        }

        @Override // rj4.d.a
        public final void a(int r100, byte[] r101, int r102) {
            this.f523526a.f523522b.add(new tj4.b(r100, r101, r102));
        }
    }

    public class b implements rj4.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f523527a;

        public b(f r100) {
            this.f523527a = r100;
        }

        @Override // rj4.e.a
        public final void a(byte[] r100, int r101, int r102) {
            oj4.a r103 = this.f523527a.f523523c;
            monitor-enter(r103);
            if (r100 != null) goto L24;
        L22:
            monitor-exit(r103);
            return;
        L24:
        L19:
            th = move-exception;
            throw th;
        L6:
            if (r100.length == 0) goto L22;
            OutputStream r104 = r103.f523514z;     // Catch: Throwable -> L19
            if (r104 != null) goto L25;
            monitor-exit(r103);
            return;
        L25:
            r104.write(r100, 0, r101);     // Catch: IOException -> L15 Throwable -> L19
            r103.f523514z.flush();     // Catch: IOException -> L15 Throwable -> L19
        L17:
            monitor-exit(r103);
            return;
        L15:
            e = move-exception;
            qj4.a.b("BluetoothClientThread", "sendData error " + e);     // Catch: Throwable -> L19
            goto L17
        }
    }

    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f523528a;

        public c(f r100) {
            this.f523528a = r100;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 6018) goto L5;
            qj4.a.c(f.f523520f, "MSG_SOCKET_RECEIVER_DATA, data is " + r100.obj);
            return;
        L5:
            switch(r101) {
                case 6006: goto L13;
                case 6007: goto L12;
                case 6008: goto L19;
                case 6009: goto L7;
                default: goto L25;
            };
        L7:
            this.f523528a.f523523c.l();
            this.f523528a.f523523c = null;
            return;
        L12:
            BluetoothDevice r102 = (BluetoothDevice) r100.obj;
            String r103 = r102.getName() + "__" + r102.getAddress() + "__已断开";
            qj4.a.c(f.f523520f, "MSG_SOCKET_DISCONNECTED, device name is " + r103);
            return;
        L13:
            BluetoothDevice r104 = (BluetoothDevice) r100.obj;
            String r105 = r104.getName() + "__" + r104.getAddress() + "__已连接";
            String r106 = f.f523520f;
            qj4.a.c(r106, "MSG_SOCKET_CONNECTED, device name is " + r105);
            this.f523528a.f523521a.getClass();
            f r107 = this.f523528a;
            oj4.b r108 = r107.f523524d;
            r107.f523521a.getClass();
            r107.f523523c = r108.f523517x;
            if (this.f523528a.f523523c != null) goto L16;
            qj4.a.b(r106, "server's client thread is null");
        L16:
            qj4.a.c(r106, "onConnectSemaphore release");
            e.f523519a.release();
            return;
        L19:
            qj4.a.c(f.f523520f, "MSG_SOCKET_STOP_LISTEN, mBluetoothServerThread.mServerSocket.close()");     // Catch: IOException -> L10
            this.f523528a.f523524d.f523516w.close();     // Catch: IOException -> L10
            return;
        L10:
            e = move-exception;
            qj4.a.a(f.f523520f, "error " + e);
            return;
        }
    }

    static {
        f523520f = f.class.getSimpleName();
    }

    @Override // tj4.a
    public final tj4.b a() {
        return this.f523522b.take();
    L4:
        e = move-exception;
        qj4.a.b(f523520f, "recvQueue take error " + e);
        return null;
    }

    @Override // tj4.a
    public final int close() {
        oj4.a r100 = this.f523523c;
        String r101 = f523520f;
        if (r100 == null) goto L6;
        qj4.a.c(r101, "Spp Channel close client thread");
        this.f523523c.l();
        this.f523523c = null;
    L6:
        if (this.f523524d == null) goto L21;
        qj4.a.c(r101, "Spp Channel close server thread");
        oj4.b r102 = this.f523524d;
        BluetoothServerSocket r103 = r102.f523516w;
        if (r103 != null) goto L19;
    L13:
        oj4.a r104 = r102.f523517x;
        if (r104 == null) goto L16;
        r104.l();
    L16:
        this.f523524d = null;
        return 0;
    L19:
        r103.close();     // Catch: IOException -> L11
    L11:
        e = move-exception;
        qj4.a.a("BluetoothServerThread", "error " + e);
        goto L13
    L21:
        return 0;
    }

    public f() {
        this.f523522b = new LinkedBlockingQueue();
        rj4.d r100 = rj4.d.e();
        g r101 = g.a();
        this.f523525e = new c(this);
        a r102 = new a(this);
        r100.j((byte) 0, r102);
        r100.j((byte) 1, r102);
        r100.j((byte) 2, r102);
        b r103 = new b(this);
        r101.b((byte) 0, r103);
        r101.b((byte) 1, r103);
        r101.b((byte) 2, r103);
    }

    @Override // tj4.a
    public final int b(tj4.b r100) {
        oj4.c r101 = this.f523521a;
        String r102 = f523520f;
        if (r101 != null) goto L7;
        qj4.a.b(r102, "mBrEdrChannelAttr is null");
        return -1;
    L7:
        if (this.f523523c != null) goto L10;
        qj4.a.b(r102, "mBluetoothClientThread is null");
        return -1;
    L10:
        byte[] r103 = r100.f546410b;
        new rj4.a(r103, (short) r103.length, (byte) r100.f546409a).l();
        return r100.f546410b.length;
    }

    @Override // tj4.a
    public final int open(Object r100) {
        if ((r100 instanceof oj4.c) == true) goto L6;
        qj4.a.b(f523520f, "attribute is not BrEdrChannelAttr");
        return -1;
    L6:
        oj4.c r101 = (oj4.c) r100;
        this.f523521a = r101;
        r101.getClass();
        oj4.b r102 = new oj4.b(this.f523525e, d.f523518a);
        this.f523524d = r102;
        ThreadMethodProxy.start(r102);
        return 0;
    }
}
