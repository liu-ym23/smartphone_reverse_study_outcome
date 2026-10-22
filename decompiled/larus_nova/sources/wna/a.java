package wna;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.sva.sdk.utils.InteractConst;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentMap<Integer, b> f560481a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f560482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HandlerC8138a f560483c = null;

    /* JADX INFO: renamed from: wna.a$a, reason: collision with other inner class name */
    public class HandlerC8138a extends Handler {
        public HandlerC8138a(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            if (r100.what != 1) goto L7;
            xna.a.b("Oneshot-AudioUtils", "===== TIME OUT FOR START RECORDING [Timing out in 5 s] ========");
            b r101 = (b) r100.obj;
            xna.a.b("Oneshot-AudioUtils", "===== EVENT_CLOSE_PIPE ==== session_id: " + r101.f560484a);
            r101.run();
            return;
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f560484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ParcelFileDescriptor f560485b;

        @Override // java.lang.Runnable
        public final void run() {
            xna.a.b("Oneshot-AudioUtils", "session will close ===== run ==== session_id : " + this.f560484a);     // Catch: Throwable -> L4
            a.b(this.f560484a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(int r100, ParcelFileDescriptor r101) {
            this.f560484a = r100;
            this.f560485b = r101;
        }
    }

    static {
        f560481a = new ConcurrentHashMap();
        f560482b = -1;
        f560483c = new HandlerC8138a(Looper.getMainLooper());
    }

    public static void a() {
        ConcurrentMap<Integer, b> r100 = f560481a;
        ((ConcurrentHashMap) r100).size();
        Iterator r101 = ((ConcurrentHashMap) r100).keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        b(((Integer) r101.next()).intValue());
        goto L4
    L6:
        ((ConcurrentHashMap) f560481a).clear();
    }

    public static void d() {
        f560483c.removeMessages(1);
        ConcurrentMap<Integer, b> r100 = f560481a;
        ConcurrentHashMap r101 = (ConcurrentHashMap) r100;
        b r102 = (b) r101.get(Integer.valueOf(f560482b));
        if (r102 == null) goto L6;
        r102.run();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.os.ParcelFileDescriptor$AutoCloseOutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.os.ParcelFileDescriptor$AutoCloseOutputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.os.ParcelFileDescriptor$AutoCloseOutputStream] */
    public static void b(int r100) {
        xna.a.b("Oneshot-AudioUtils", "============== close pipe start ================ session_id : " + r100);
        f560482b = -1;
        b r101 = (b) ((ConcurrentHashMap) f560481a).get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        return;
    L5:
        ?? r102 = "============== close pipe ================ session_id : " + r100;
        xna.a.b("Oneshot-AudioUtils", r102);
        ParcelFileDescriptor r103 = r101.f560485b;
        if (r103 == null) goto L34;
        ?? r104 = 0;
        r102 = new ParcelFileDescriptor.AutoCloseOutputStream(r103);     // Catch: Throwable -> L18 Exception -> L20
    L50:
        r102.write(0);     // Catch: Throwable -> L14 Exception -> L16
        r102.close();     // Catch: Throwable -> L14 Exception -> L16
        r103.close();     // Catch: Exception -> L36
    L39:
    L46:
        r102.close();     // Catch: IOException -> L38
    L16:
        Exception e100 = e;
    L22:
        e100.getMessage();     // Catch: Throwable -> L14
        r103.close();     // Catch: Exception -> L25
    L26:
        if (r102 == 0) goto L34;
    L14:
        th = th;
        r104 = r102;
    L44:
        r103.close();     // Catch: Exception -> L30
    L31:
        if (r104 == 0) goto L55;
        r104.close();     // Catch: IOException -> L37
        throw th;
    L56:
        throw th;
    L55:
        throw th;
    L20:
        e = move-exception;
        r102 = 0;
        e100 = e;
    L18:
        th = th;
    L34:
        ((ConcurrentHashMap) f560481a).remove(Integer.valueOf(r100));
    }

    public static void c(Bundle r100) {
        a();
        f560482b = -1;
        if (r100 == null) goto L13;
        ParcelFileDescriptor r101 = (ParcelFileDescriptor) r100.getParcelable(InteractConst.INTENT_PIPE);
        f560482b = r100.getInt(InteractConst.INTENT_SESSION_ID, -1);
        r100.remove(InteractConst.INTENT_PIPE);
        if (r101 != null) goto L7;
        f560482b = -1;
    L7:
        int r102 = f560482b;
        if (r102 == (-1)) goto L14;
        ConcurrentMap<Integer, b> r103 = f560481a;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        r104.put(Integer.valueOf(r102), new b(f560482b, r101));
        b r105 = (b) r104.get(Integer.valueOf(f560482b));
        if (r105 == null) goto L15;
        HandlerC8138a r106 = f560483c;
        r106.removeMessages(1);
        r106.sendMessageDelayed(Message.obtain(r106, 1, r105), 5000);
        return;
    L15:
        return;
    L14:
        return;
    }
}
