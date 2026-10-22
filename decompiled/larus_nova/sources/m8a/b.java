package m8a;

import android.content.Context;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f512494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f512495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d.a f512496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f512497d;

    public final void a() {
        String r100 = this.f512494a.f512512f;     // Catch: Throwable -> L15
        if (r100 != null) goto L5;
    L9:
        d.c r101 = d.b(this.f512497d, this.f512494a);     // Catch: Throwable -> L15
        if (r101 == null) goto L13;
        d r102 = this.f512497d;     // Catch: Throwable -> L15
        r102.f512504c.post(new a(r102, r101));     // Catch: Throwable -> L15
        return;
    L13:
        d.c(this.f512497d, this.f512495b, this.f512496c);     // Catch: Throwable -> L15
        return;
    L5:
        if (r100.startsWith(UriUtil.LOCAL_ASSET_SCHEME) == false) goto L9;
        d.c r103 = d.a(this.f512497d, this.f512495b, this.f512494a);     // Catch: Throwable -> L15
        if (r103 == null) goto L19;
        d r104 = this.f512497d;     // Catch: Throwable -> L15
        r104.f512504c.post(new a(r104, r103));     // Catch: Throwable -> L15
        return;
    L19:
        return;
    L15:
        th = move-exception;
        LLog.e("BigImageDrawingHelper", "loadOriginBitmap failed: " + th.toString());
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

    public b(d r100, d.a r101, Context r102, ImageRequest r103, d.a r104) {
        this.f512497d = r100;
        this.f512494a = r101;
        this.f512495b = r102;
        this.f512496c = r104;
    }
}
