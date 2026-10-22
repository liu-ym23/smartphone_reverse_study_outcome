package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.widget.ToolBarView;
import com.bytedance.android.window.shop.widget.n;
import com.bytedance.android.window.shop.widget.r;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.ReplaySubject;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements e {
    public Disposable a;
    public final ObservableSource<ToolBarView> b;
    public final ObservableSource<Boolean> c;

    public static final class a<T1, T2, R> implements BiFunction {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2, Object r3) {
            ToolBarView r4 = (ToolBarView) r2;
            Intrinsics.checkNotNullParameter(r4, "toolbarView");
            Intrinsics.checkNotNullParameter((Boolean) r3, "<anonymous parameter 1>");
            return r4;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.home.tab.tabplugin.b$b, reason: collision with other inner class name */
    public static final class C0036b<T> implements Consumer {
        public static final C0036b a = null;

        static {
            a = new C0036b();
        }

        public C0036b() {
        }

        public final void accept(Object r3) {
            ToolBarView r4 = (ToolBarView) r3;
            e0 r0 = r4.j;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("toolBarVO");
        L5:
            List<com.bytedance.android.window.shop.repository.tab.entity.d> r1 = r0.l;
            if (r1 == null) goto L8;
            com.bytedance.android.window.shop.repository.tab.entity.d r2 = (com.bytedance.android.window.shop.repository.tab.entity.d) CollectionsKt.firstOrNull(r1);
        L9:
            if (r2 == null) goto L13;
            r4.e = bg4.b.b(Observable.create(new n(r4, r2))).subscribe(new r(r4));
            return;
        L13:
            return;
        L8:
            r2 = null;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r1) {
            ECExceptionMonitor.e((Throwable) r1);
        }
    }

    public static final class d implements Action {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void run() {
        }
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void a() {
        this.a = bg4.b.b(Observable.zip(this.b, this.c, a.a)).subscribe(C0036b.a, c.a, d.a);
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void b() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public b(ReplaySubject r2, ObservableSource r3) {
        Intrinsics.checkNotNullParameter(r2, "observable");
        Intrinsics.checkNotNullParameter(r3, "floatControl");
        this.b = r2;
        this.c = r3;
    }
}
