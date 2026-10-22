package g95;

import com.bytedance.ee.bear.drive.view.preview.audio.AudioView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioView f480517a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f480517a.f224745c.setPlayState(false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j(AudioView r100) {
        this.f480517a = r100;
    }
}
