package e62;

import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f471123a = null;

    static {
        f471123a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        HorizontalPlayEvent r100 = new HorizontalPlayEvent(1, HorizontalPlayEvent.SOURCE_FOR_CHAT_CHANNEL_INVITE_REQUEST_LANDSCAPE);     // Catch: Throwable -> L4
        r100.rotationType = 1;     // Catch: Throwable -> L4
        xs2.b.a().post(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
