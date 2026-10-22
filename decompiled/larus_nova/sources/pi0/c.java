package pi0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.depend.xplay.IByteRtcVideoFrame;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IByteRtcVideoFrame f529316a;

    public c(IByteRtcVideoFrame r100) {
        this.f529316a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f529316a.release();     // Catch: Throwable -> L4
        ALogger.d("textureToLiveCoreVideoFame", "release");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
