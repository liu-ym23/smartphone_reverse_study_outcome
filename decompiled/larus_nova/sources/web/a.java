package web;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.shared.page.experiment.FeedCallbackExecutor;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f559445a = null;

    static {
        f559445a = new a();
    }

    public a() {
    }

    public static void a() {
        FeedCallbackExecutor.f421409a.getClass();
        if (FeedCallbackExecutor.d() != null) goto L6;
        Log.i("FeedCallbackExecutor", "flush skipped: recyclerView is null, clearing runnableMap");
        FeedCallbackExecutor.f421411c.clear();
        return;
    L6:
        Iterator<Map.Entry<String, Runnable>> r100 = FeedCallbackExecutor.f421411c.entrySet().iterator();
    L8:
        if (r100.hasNext() == false) goto L10;
        Map.Entry<String, Runnable> r101 = r100.next();
        String r102 = r101.getKey();
        Runnable r103 = r101.getValue();
        Log.i("FeedCallbackExecutor", "flush Runnable " + r102);
        r103.run();
        goto L8
    L10:
        FeedCallbackExecutor.f421411c.clear();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
