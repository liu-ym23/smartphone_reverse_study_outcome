package com.ss.android.lark.feed.shared.page.experiment;

import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedCallbackExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FeedCallbackExecutor f421409a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile WeakReference<RecyclerView> f421410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Runnable> f421411c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FeedCallbackExecutor$onScrollListener$1 f421412d = null;

    public FeedCallbackExecutor() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.feed.shared.page.experiment.FeedCallbackExecutor$onScrollListener$1] */
    static {
        f421409a = new FeedCallbackExecutor();
        f421411c = new ConcurrentHashMap();
        f421412d = new FeedCallbackExecutor$onScrollListener$1();
    }

    public static RecyclerView d() {
        WeakReference<RecyclerView> r100 = f421410b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public static void b() {
        RecyclerView r100 = d();
        StringBuilder r101 = new StringBuilder("detach: ");
        if (r100 == null) goto L5;
        String r102 = r100.getClass().getSimpleName();
    L6:
        r101.append(r102);
        r101.append('@');
        if (r100 == null) goto L9;
        int r103 = r100.hashCode();
    L10:
        r101.append(r103);
        Log.i("FeedCallbackExecutor", r101.toString());
        if (r100 != null) goto L13;
        return;
    L13:
        monitor-enter(FeedCallbackExecutor.class);
        Log.i("FeedCallbackExecutor", "detach clear observingRecyclerViewRef");     // Catch: Throwable -> L20
        f421409a.getClass();     // Catch: Throwable -> L20
        RecyclerView r104 = d();     // Catch: Throwable -> L20
        if (r104 == null) goto L17;
        r104.removeOnScrollListener(f421412d);     // Catch: Throwable -> L20
    L17:
        f421410b = null;     // Catch: Throwable -> L20
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(FeedCallbackExecutor.class);
        return;
    L20:
        th = move-exception;
        throw th;
    L9:
        r103 = 0;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public static void a(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Log.i("FeedCallbackExecutor", "attach: " + r100.getClass().getSimpleName() + '@' + r100.hashCode());
        f421410b = new WeakReference(r100);
        r100.addOnScrollListener(f421412d);
    }

    public static void c(Runnable r100) {
        Intrinsics.checkNotNullParameter("afterDispatchDiff", "key");
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (d() != null) goto L5;
    L19:
        UICallbackExecutor.execute(r100);
        return;
    L5:
        monitor-enter(FeedCallbackExecutor.class);
        f421409a.getClass();     // Catch: Throwable -> L16
        RecyclerView r101 = d();     // Catch: Throwable -> L16
        if (r101 != null) goto L9;
    L14:
        monitor-exit(FeedCallbackExecutor.class);
        goto L19
    L9:
        if (r101.getScrollState() == 0) goto L13;
        f421411c.put("afterDispatchDiff", r100);     // Catch: Throwable -> L16
        monitor-exit(FeedCallbackExecutor.class);
        return;
    L13:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }
}
