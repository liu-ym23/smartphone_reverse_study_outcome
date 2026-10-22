package ws7;

import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.network.APICallback;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f561069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f561070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f561071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f561072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f561073e;

    public final void a() {
        File r100 = new PolarisFileWrapper(this.f561069a + File.separator + this.f561070b);
        String r101 = "UNKNOWN";
        if (r100.exists() == true) goto L8;
        Pair<File, String> r102 = e.b(this.f561071c, this.f561069a, this.f561070b, this.f561072d, this.f561073e);
        if (r102 == null) goto L7;
        File r103 = (File) r102.first;
        String r104 = (String) r102.second;
        Pair<File, String> r105 = r102;
        r100 = r103;
        r101 = r104;
    L10:
        monitor-enter(e.class);
        CopyOnWriteArrayList r106 = (CopyOnWriteArrayList) ((ConcurrentHashMap) e.f561074a).remove(this.f561071c);     // Catch: Throwable -> L23
        if (r100 == null) goto L17;
        Iterator r107 = r106.iterator();     // Catch: Throwable -> L23
    L15:
        if (r107.hasNext() == false) goto L21;
        ((APICallback) r107.next()).onSuccess(r105);     // Catch: Throwable -> L23
    L21:
        monitor-exit(e.class);     // Catch: Throwable -> L23
        return;
    L17:
        Iterator r108 = r106.iterator();     // Catch: Throwable -> L23
    L19:
        if (r108.hasNext() == false) goto L21;
        ((APICallback) r108.next()).onError("DOWNLOAD-ERROR", r101, null);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L7:
        r105 = r102;
        r100 = null;
        goto L10
    L8:
        r105 = new Pair(r100, r100.getAbsolutePath());
        goto L10
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

    public d(String r100, String r101, String r102, String r103) {
        this.f561069a = r100;
        this.f561070b = r101;
        this.f561071c = r102;
        this.f561072d = r103;
        this.f561073e = 0;
    }
}
