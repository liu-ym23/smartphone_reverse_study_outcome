package r62;

import com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.ChannelTrayListViewV2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChannelTrayListViewV2 f536327a;

    public b(ChannelTrayListViewV2 r100) {
        this.f536327a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f536327a.f134412a.smoothScrollToPosition(0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
