package com.ss.android.lark.chat.chatwindow.chat.v2.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f414671p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f414672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView.Adapter<?> f414673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<T> f414674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f414675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<d<T>> f414676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<InterfaceC4844c<T>> f414677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AndroidThrottle<T> f414678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f414679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f414680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f414681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.larksuite.framework.callback.c f414682k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f414683l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f414684m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f414685n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f414686o;

    public static final class a {
    }

    public interface b<T> {
        String a(T r100);

        y6b.c getItem(int r100);
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.widget.c$c, reason: collision with other inner class name */
    public interface InterfaceC4844c<T> {
        void a(List<? extends T> r100);

        void b(boolean r100, int r101, int r102);

        void c();
    }

    public interface d<T> {
        boolean a();
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c<T> f414687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList<T> f414688b;

        public e(c<T> r100, ArrayList<T> r101) {
            this.f414687a = r100;
            this.f414688b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<InterfaceC4844c<T>> r100 = this.f414687a.f414677f;     // Catch: Throwable -> L7
            ArrayList<T> r101 = this.f414688b;     // Catch: Throwable -> L7
            Iterator r102 = ((CopyOnWriteArrayList) r100).iterator();     // Catch: Throwable -> L7
        L4:
            if (r102.hasNext() == false) goto L16;
            ((InterfaceC4844c) r102.next()).a(new ArrayList(r101));     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    static {
        f414671p = UIHelper.dp2px(12.0f);
    }

    public final void b(Collection<? extends T> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<? extends T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        T r103 = r102.next();
        Iterator r104 = ((ArrayList) this.f414676e).iterator();
        boolean r105 = true;
    L7:
        if (r104.hasNext() == false) goto L9;
        r105 = r105 & ((d) r104.next()).a();
        goto L7
    L9:
        if (r105 == false) goto L4;
        r101.add(r103);
        goto L4
    L11:
        CoreThreadPool.getDefault().getUIExecutor().execute(new e(this, r101));
    }

    public final synchronized void c(InterfaceC4844c<T> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "listener");     // Catch: Throwable -> L6
        ((CopyOnWriteArrayList) this.f414677f).add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static final void a(c r100, boolean r101) {
        RecyclerView.LayoutManager r102 = r100.f414672a.getLayoutManager();
        if ((r102 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r103 = (LinearLayoutManager) r102;
        int r104 = r103.findFirstVisibleItemPosition();
        int r105 = r103.findLastVisibleItemPosition();
    L6:
        if (r104 < 0) goto L15;
        if (r105 < 0) goto L15;
        int r106 = r100.f414680i;
        if (r104 != r106) goto L18;
        int r107 = r100.f414681j;
        if (r105 != r107) goto L18;
        if ((r106 + r107) > 0) goto L15;
    L18:
        r100.f414680i = r104;
        r100.f414681j = r105;
        Log.d("RecyclerViewItemDetector", "collectCurrentPageData:" + r104 + '/' + r105 + '/' + r101 + '/' + f414671p);
        Iterator r108 = ((CopyOnWriteArrayList) r100.f414677f).iterator();
    L20:
        if (r108.hasNext() == false) goto L22;
        ((InterfaceC4844c) r108.next()).b(r101, r104, r105);
        goto L20
    L22:
        ArrayList r109 = new ArrayList();
        if (r104 > r105) goto L30;
    L24:
        y6b.c r110 = r100.f414674c.getItem(r104);
        if (r110 == null) goto L27;
        r109.add(r110);
    L27:
        if (r104 == r105) goto L30;
        r104 = r104 + 1;
    L30:
        if (r100.f414679h == false) goto L32;
        r100.b(r109);
        r100.f414679h = false;
        return;
    L32:
        r100.f414678g.e(r109);
        return;
    L15:
        if (((Boolean) r100.f414684m.getValue()).booleanValue() == false) goto L36;
        if (r101 == false) goto L18;
        return;
    L36:
        return;
    L5:
        r104 = -1;
        r105 = -1;
        goto L6
    }

    public c(SceneCoordinateRecyclerView r100, RecyclerView.Adapter r101, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.e r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "adapter");
        Intrinsics.checkNotNullParameter(r102, "dataProvider");
        this.f414672a = r100;
        this.f414673b = r101;
        this.f414674c = r102;
        this.f414676e = new ArrayList();
        this.f414677f = new CopyOnWriteArrayList();
        this.f414679h = true;
        Handler r103 = CoreThreadPool.getNonblockingHandler();
        this.f414683l = r103;
        this.f414684m = LazyKt.lazy(RecyclerViewItemDetector$isCardTranslateFg$2.INSTANCE);
        AndroidThrottle.a r104 = new AndroidThrottle.a();
        r104.f285878b = 300;
        r104.f285880d = new com.ss.android.lark.chat.chatwindow.chat.v2.widget.a(r102);
        r104.f285877a = r103;
        r104.f285881e = new com.ss.android.lark.chat.chatwindow.chat.v2.widget.b(this);
        this.f414678g = new AndroidThrottle(r104);
        this.f414682k = new com.larksuite.framework.callback.c(new Handler(Looper.getMainLooper()));
        this.f414685n = LazyKt.lazy(new RecyclerViewItemDetector$mScrollListener$2(this));
        this.f414686o = LazyKt.lazy(new RecyclerViewItemDetector$mDataObserver$2(this));
    }
}
