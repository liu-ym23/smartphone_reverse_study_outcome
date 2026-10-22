package xv1;

import com.bytedance.android.livesdk.feed.drawerfeed.autoplay.DrawerFeedPreviewHelper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DrawerFeedPreviewHelper f565145a;

    public a(DrawerFeedPreviewHelper r100) {
        this.f565145a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f565145a.c();     // Catch: Throwable -> L4
        this.f565145a.d();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
