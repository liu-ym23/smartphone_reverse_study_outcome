package mqa;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.message.util.ToolUtils;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile d f514919e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uqa.a f514920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Application f514921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f514922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f514923d;

    public d(Context r100) {
        f r101 = new f();
        new Handler(Looper.getMainLooper());
        if ((r100 instanceof Application) == false) goto L5;
        this.f514921b = (Application) r100;
    L6:
        Application r102 = this.f514921b;
    L21:
        th = move-exception;
        th.printStackTrace();
        boolean r103 = false;
        r101.f514927b = false;
    L23:
        this.f514922c = r103;
        uqa.a r104 = new uqa.a(this.f514921b, r103);
        this.f514920a = r104;
        if (r103 == true) goto L31;
    L29:
        Application r105 = r104.f551344a;
        uqa.a.C7918a r106 = new uqa.a.C7918a(r104, r105);
        r104.f551345b = r106;
        r105.registerActivityLifecycleCallbacks(r106);
        return;
    L31:
        r104.f551346c.delete();     // Catch: Exception -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L8:
        if (r101.f514926a == false) goto L10;
        r103 = r101.f514927b;     // Catch: Throwable -> L21
        goto L23
    L10:
        r101.f514926a = true;     // Catch: Throwable -> L21
        PolarisFileWrapper r107 = new PolarisFileWrapper(r102.getFilesDir(), "process.lock");     // Catch: Throwable -> L21
        if (r107.isDirectory() == false) goto L14;
        r107.delete();     // Catch: Throwable -> L21
    L14:
        if (r107.exists() == true) goto L16;
        r107.createNewFile();     // Catch: Throwable -> L21
    L16:
        r101.f514927b = r101.a(r107);     // Catch: Throwable -> L21
        if (com.bytedance.push.utils.f.f267065a == false) goto L19;
        StringBuilder r108 = new StringBuilder("isFirstLockFile: sIsFirst = ");     // Catch: Throwable -> L21
        r108.append(r101.f514927b);     // Catch: Throwable -> L21
        r108.append("  process = ");     // Catch: Throwable -> L21
        List<String> r109 = vqa.a.f556785a;     // Catch: Throwable -> L21
        r108.append(ToolUtils.getCurProcessName(r102));     // Catch: Throwable -> L21
        r108.append(r107.getPath());     // Catch: Throwable -> L21
        com.bytedance.push.utils.f.b("ExclusiveFileLock", r108.toString());     // Catch: Throwable -> L21
    L19:
        r103 = r101.f514927b;     // Catch: Throwable -> L21
        goto L23
    L5:
        this.f514921b = (Application) r100.getApplicationContext();
        goto L6
    }

    public static d a(Context r100) {
        if (f514919e != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f514919e != null) goto L9;
        f514919e = new d(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f514919e;
    }
}
