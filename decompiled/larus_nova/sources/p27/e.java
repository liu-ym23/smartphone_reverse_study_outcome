package p27;

import android.content.Context;
import com.bytedance.mira.log.MiraLogger;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f527460c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile e f527461d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<d> f527462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f527463b;

    static {
        f527460c = "morpheus-".concat(e.class.getSimpleName());
    }

    public e(Context r100) {
        this.f527462a = new LinkedList();
        this.f527463b = r100;
    }

    public static e c(Context r100) {
        if (f527461d != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f527461d != null) goto L9;
        f527461d = new e(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f527461d;
    }

    public final void a(Integer r100) {
        Iterator<d> r101 = this.f527462a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r101.next().f527458a != r100.intValue()) goto L4;
        return;
    L8:
        this.f527462a.add(new d(r100.intValue()));
        Downloader.getInstance(this.f527463b).pause(r100.intValue());
    }

    public final void b(Integer r100) {
        Iterator<d> r101 = this.f527462a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        d r102 = r101.next();
        if (r102.f527458a != r100.intValue()) goto L4;
        r102.f527459b = true;
        MiraLogger.d(f527460c, "doResume resumeLock: id=" + r100);
        return;
    L9:
        MiraLogger.d(f527460c, "doResume : id=" + r100);
        Downloader.getInstance(this.f527463b).resume(r100.intValue());
    }
}
