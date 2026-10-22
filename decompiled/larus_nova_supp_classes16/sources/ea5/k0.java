package ea5;

import com.bytedance.ee.bear.drive.view.preview.video.VideoView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k0 implements Runnable {
    public final /* synthetic */ VideoView a;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a.e == null) goto L9;
        tt5.a.h("DRIVE_VideoPlayer", "no permission, stop play video");     // Catch: Throwable -> L6
        this.a.e.setPlayState(false);     // Catch: Throwable -> L6
        return;
    }

    public k0(VideoView r1) {
        this.a = r1;
    }
}
