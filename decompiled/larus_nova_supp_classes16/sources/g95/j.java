package g95;

import com.bytedance.ee.bear.drive.view.preview.audio.AudioView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements Runnable {
    public final /* synthetic */ AudioView a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c.setPlayState(false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j(AudioView r1) {
        this.a = r1;
    }
}
