package dfb;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedActionEvent f468334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f468335b;

    public f(FeedActionEvent r100, e r101) {
        this.f468334a = r100;
        this.f468335b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.f468334a == FeedActionEvent.RIGHT_SWIPE_LONG) goto L10;
        this.f468335b.f468332a.cH();     // Catch: Throwable -> L7
        return;
    }
}
