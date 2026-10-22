package iwa;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes34.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f496247a;

    public /* synthetic */ e(f r100) {
        this.f496247a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = this.f496247a;
        r100.getClass();
        boolean r101 = false;
    L4:
        if (r101 == true) goto L9;
        r101 = ((Boolean) CoreThreadPool.getDefault().getScheduleThreadPool().schedule(r100.f496253f, 500, TimeUnit.MILLISECONDS).get()).booleanValue();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        Log.e("RecorderImpl", r100.f496251d + " query occurs wrong: " + e.getMessage());
        nwa.b.a.f521016a.a("inner_exception", e.getMessage());
    L9:
        Log.i("RecorderImpl", r100.f496251d + " record upload complete");
    }
}
