package mqa;

import com.larus.apm.impl.protector.RunnableProtector;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RandomAccessFile f514924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f514925b;

    public final void a() {
        if (this.f514924a != null) goto L21;
        return;
    L21:
        com.bytedance.push.utils.f.b("ExclusiveFileLock", "pending lock file ...");     // Catch: Throwable -> L18
        FileLock r100 = this.f514924a.getChannel().lock();     // Catch: Throwable -> L18
        if (r100 == null) goto L8;
        this.f514925b.f514928c = r100;     // Catch: Throwable -> L18
    L8:
        StringBuilder r101 = new StringBuilder("lock file success!");     // Catch: Throwable -> L18
        FileLock r102 = this.f514925b.f514928c;     // Catch: Throwable -> L18
        if (r102 != null) goto L11;
    L15:
        boolean r103 = false;
    L16:
        r101.append(r103);     // Catch: Throwable -> L18
        com.bytedance.push.utils.f.b("ExclusiveFileLock", r101.toString());     // Catch: Throwable -> L18
        return;
    L11:
        if (r102.isValid() == false) goto L15;
        if (this.f514925b.f514928c.isShared() == true) goto L15;
        r103 = true;
    L18:
        th = move-exception;
        th.printStackTrace();
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

    public e(f r100, RandomAccessFile r101) {
        this.f514925b = r100;
        this.f514924a = r101;
    }
}
