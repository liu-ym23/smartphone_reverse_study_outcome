package n4a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f517238c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static e f517239d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f517240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f517241b;

    public class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ String f517242v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ int f517243w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final /* synthetic */ e f517244x;

        public a(e r100, String r101, int r102) {
            this.f517244x = r100;
            this.f517242v = r101;
            this.f517243w = r102;
            super("com/loc/ad$1");
        }

        public final void l() {
            String r100 = this.f517242v;
            byte[] r101 = k.f517415a;
            byte[] r102 = k.b(r100.getBytes("UTF-8"));     // Catch: Throwable -> L5
            byte[] r103 = f.f517274a;     // Catch: Throwable -> L5
            String r104 = f.a(r102, r102.length);
        L7:
            if (TextUtils.isEmpty(r104) == false) goto L9;
            return;
        L9:
            if ((this.f517243w & 1) <= 0) goto L21;
            if (Build.VERSION.SDK_INT >= 23) goto L13;
            ContentResolver r105 = this.f517244x.f517241b.getContentResolver();     // Catch: Exception -> L19
            e r106 = this.f517244x;     // Catch: Exception -> L19
        L17:
            Settings.System.putString(r105, r106.f517240a, r104);     // Catch: Exception -> L19
            goto L21
        L13:
            if (Settings.System.canWrite(this.f517244x.f517241b) == false) goto L21;
            r105 = this.f517244x.f517241b.getContentResolver();     // Catch: Exception -> L19
            r106 = this.f517244x;     // Catch: Exception -> L19
        L21:
            if ((this.f517243w & 16) <= 0) goto L24;
            e r107 = this.f517244x;
            g.a(r107.f517241b, r107.f517240a, r104);
        L24:
            if ((this.f517243w & 256) <= 0) goto L32;
            SharedPreferences.Editor r108 = this.f517244x.f517241b.getSharedPreferences(e.f517238c, 0).edit();
            r108.putString(this.f517244x.f517240a, r104);
            r108.apply();
            return;
        L32:
            return;
        L5:
            r104 = null;
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
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<e> f517245a;

        public b(Looper r100, e r101) {
            super(r100);
            this.f517245a = new WeakReference(r101);
        }

        public b(e r100) {
            this.f517245a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            e r101 = this.f517245a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r100 == null) goto L11;
            Object r102 = r100.obj;
            if (r102 == null) goto L12;
            r101.b((String) r102, r100.what);
            return;
        L12:
            return;
        }
    }

    static {
        f517238c = f5.o("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    }

    public e(Context r100) {
        this.f517241b = r100.getApplicationContext();
        if (Looper.myLooper() != null) goto L6;
        new b(Looper.getMainLooper(), this);
        return;
    L6:
        new b(this);
    }

    public static e a(Context r100) {
        if (f517239d != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f517239d != null) goto L9;
        f517239d = new e(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f517239d;
    }

    public final synchronized void b(String r100, int r101) {
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L4:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L8;
        ThreadMethodProxy.start(new a(this, r100, r101));     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L8:
        byte[] r102 = k.f517415a;     // Catch: Throwable -> L34
        byte[] r103 = k.b(r100.getBytes("UTF-8"));     // Catch: Throwable -> L11
        byte[] r104 = f.f517274a;     // Catch: Throwable -> L11
        String r105 = f.a(r103, r103.length);
    L13:
        if (TextUtils.isEmpty(r105) == false) goto L15;
    L32:
        monitor-exit(this);
        return;
    L15:
        if ((r101 & 1) <= 0) goto L25;
        if (Build.VERSION.SDK_INT < 23) goto L20;
        ContentResolver r106 = this.f517241b.getContentResolver();     // Catch: Exception -> L23 Throwable -> L34
    L21:
        Settings.System.putString(r106, this.f517240a, r105);     // Catch: Exception -> L23 Throwable -> L34
        goto L25
    L20:
        r106 = this.f517241b.getContentResolver();     // Catch: Exception -> L23 Throwable -> L34
    L25:
        if ((r101 & 16) <= 0) goto L28;
        g.a(this.f517241b, this.f517240a, r105);     // Catch: Throwable -> L34
    L28:
        if ((r101 & 256) <= 0) goto L32;
        SharedPreferences.Editor r107 = this.f517241b.getSharedPreferences(f517238c, 0).edit();     // Catch: Throwable -> L34
        r107.putString(this.f517240a, r105);     // Catch: Throwable -> L34
        r107.apply();     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L11:
        r105 = null;
        goto L13
    }
}
