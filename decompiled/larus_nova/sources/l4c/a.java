package l4c;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f507357e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f507358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PolarisFileWrapper f507359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f507360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.lark.seccache.impl.b f507361d;

    /* JADX INFO: renamed from: l4c.a$a, reason: collision with other inner class name */
    public class RunnableC6649a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f507362a;

        @Override // java.lang.Runnable
        public final void run() {
            PolarisFileWriterWrapper r100 = new PolarisFileWriterWrapper(this.f507362a.f507359b);     // Catch: Throwable -> L4 IOException -> L6
            r100.write(1);     // Catch: Throwable -> L4 IOException -> L6
            r100.flush();     // Catch: Throwable -> L4 IOException -> L6
            r100.close();     // Catch: Throwable -> L4 IOException -> L6
            Log.d("SecCacheModule", "update local feature success -> 1");     // Catch: Throwable -> L4 IOException -> L6
        L16:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }

        public RunnableC6649a(a r100) {
            this.f507362a = r100;
        }
    }

    public final boolean a() {
        if (this.f507360c != null) goto L22;
    L16:
        e = move-exception;
        Log.e("SecCacheModule", e.getMessage());     // Catch: Throwable -> L14
        this.f507360c = new byte[0];
        goto L22
    L6:
        if (this.f507359b.exists() == false) goto L12;
        PolarisFileReaderWrapper r100 = new PolarisFileReaderWrapper(this.f507359b);     // Catch: Throwable -> L14 Exception -> L16
        int r101 = r100.read();     // Catch: Throwable -> L14 Exception -> L16
        r100.close();     // Catch: Throwable -> L14 Exception -> L16
        boolean r102 = true;
        if (r101 == 1) goto L11;
        r102 = false;
    L11:
        f507357e = r102;     // Catch: Throwable -> L14 Exception -> L16
    L13:
        this.f507360c = new byte[0];
        goto L22
    L12:
        f507357e = false;     // Catch: Throwable -> L14 Exception -> L16
    L14:
        th = move-exception;
        this.f507360c = new byte[0];
        throw th;
    L22:
        return f507357e;
    }

    public final void b() {
        byte[] r100 = com.ss.android.lark.seccache.impl.b.f440389a;
        this.f507361d = com.ss.android.lark.seccache.impl.b.a.f440391a;
        RunnableC6649a r101 = new RunnableC6649a(this);
        CoreThreadPool.getDefault().getScheduleThreadPool().schedule(r101, 10, TimeUnit.SECONDS);
        this.f507358a = com.larksuite.framework.utils.b.f285948a;
        File r102 = this.f507358a.getFilesDir();
        if (r102 == null) goto L5;
        String r103 = r102.getAbsolutePath().concat("/feature");
    L6:
        this.f507359b = new PolarisFileWrapper(r103);
        return;
    L5:
        r103 = "";
        goto L6
    }

    public a() {
        this.f507360c = null;
    }
}
