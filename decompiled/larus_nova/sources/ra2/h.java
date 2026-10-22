package ra2;

import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.ConfrontMsgView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConfrontMsgView f536821a;

    public h(ConfrontMsgView r100) {
        this.f536821a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConfrontMsgView r100 = this.f536821a;     // Catch: Throwable -> L4
        r100.f140076q = r100.f140075p;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
