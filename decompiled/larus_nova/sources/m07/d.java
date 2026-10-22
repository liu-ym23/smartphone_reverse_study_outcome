package m07;

import android.view.Surface;
import com.bytedance.lynx.media.view.VideoMediaView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoMediaView f511492a;

    @Override // java.lang.Runnable
    public final void run() {
        Surface r100 = this.f511492a.getSurface();     // Catch: Throwable -> L6
        f07.c r101 = this.f511492a.f264837b;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.f(r100);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public d(VideoMediaView r100) {
        this.f511492a = r100;
    }
}
