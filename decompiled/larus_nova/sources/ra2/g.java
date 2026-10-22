package ra2;

import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.ConfrontMsgView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConfrontMsgView f536820a;

    public g(ConfrontMsgView r100) {
        this.f536820a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConfrontMsgView r100 = this.f536820a;     // Catch: Throwable -> L4
        r100.f140076q = r100.f140073n;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
