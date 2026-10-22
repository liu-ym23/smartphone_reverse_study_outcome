package ra2;

import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.ConfrontMsgView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.GroupMsgView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConfrontMsgView f536817a;

    public d(ConfrontMsgView r100) {
        this.f536817a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GroupMsgView r100 = this.f536817a.f140061b;     // Catch: Throwable -> L9
        if (r100 == null) goto L5;
        r100.d();     // Catch: Throwable -> L9
    L5:
        GroupMsgView r101 = this.f536817a.f140062c;     // Catch: Throwable -> L9
        if (r101 == null) goto L12;
        r101.d();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
