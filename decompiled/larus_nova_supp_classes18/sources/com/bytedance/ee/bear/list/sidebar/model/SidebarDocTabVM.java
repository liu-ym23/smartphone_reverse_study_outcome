package com.bytedance.ee.bear.list.sidebar.model;

import androidx.lifecycle.ViewModel;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/list/sidebar/model/SidebarDocTabVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "refreshFlowableMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/ee/bear/list/sidebar/model/ICreateRefreshFlowable;", "addRefreshFlowable", "", "key", "creation", "removeRefreshFlowable", "refresh", "callback", "Lcom/bytedance/ee/bear/list/sidebar/model/SidebarDocTabVM$RefreshCallback;", "addDisposable", "disposable", "Lio/reactivex/disposables/Disposable;", "onCleared", "Companion", "RefreshCallback", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarDocTabVM extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "SidebarDocTabVM";
    private final CompositeDisposable compositeDisposable;
    private final ConcurrentHashMap<String, xd5.a> refreshFlowableMap;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a();

        void b(Throwable r1);
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ SidebarDocTabVM a;

        public c(SidebarDocTabVM r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Intrinsics.checkNotNullParameter((String) r5, "it");
            Collection r6 = SidebarDocTabVM.access$getRefreshFlowableMap$p(this.a).values();
            if (hu5.a.d(r6) == false) goto L5;
            tt5.a.h(SidebarDocTabVM.TAG, "refreshFlowableMap is empty");
            return "";
        L5:
            Iterator r7 = r6.iterator();
        L7:
            if (r7.hasNext() == false) goto L12;
            xd5.a r0 = (xd5.a) r7.next();
            SidebarDocTabVM.access$getCompositeDisposable$p(this.a).add(r0.generate().subscribe(com.bytedance.ee.bear.list.sidebar.model.a.a, com.bytedance.ee.bear.list.sidebar.model.b.a));
            goto L7
        L12:
            return "";
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            String r2 = (String) r1;
            this.a.a();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ b a;

        public e(b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "t");
            this.a.b(r3);
        }
    }

    static {
        Companion = new a();
    }

    public SidebarDocTabVM() {
        this.compositeDisposable = new CompositeDisposable();
        this.refreshFlowableMap = new ConcurrentHashMap();
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(SidebarDocTabVM r0) {
        return r0.compositeDisposable;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getRefreshFlowableMap$p(SidebarDocTabVM r0) {
        return r0.refreshFlowableMap;
    }

    public final void addDisposable(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.compositeDisposable.add(r2);
    }

    public final void refresh(b r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        Disposable r5 = Flowable.just("").subscribeOn(fo5.d.c()).map(new c(this)).subscribe(new d(r4), new e(r4));
        this.compositeDisposable.add(r5);
    }

    public final void removeRefreshFlowable(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        tt5.a.h(TAG, "removeRefreshFlowable, key=" + r3);
        this.refreshFlowableMap.remove(r3);
    }

    public final void addRefreshFlowable(String r3, xd5.a r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "creation");
        tt5.a.h(TAG, "addRefreshFlowable, key=" + r3);
        this.refreshFlowableMap.put(r3, r4);
    }
}
