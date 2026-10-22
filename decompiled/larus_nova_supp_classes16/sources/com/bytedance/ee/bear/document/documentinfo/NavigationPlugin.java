package com.bytedance.ee.bear.document.documentinfo;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.h;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mc5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/document/documentinfo/NavigationPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "loadTitle", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "onDetachFromHost", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NavigationPlugin extends DocumentPlugin {
    public static final a Companion = null;
    private static final String TAG = "NavigationPlugin";
    private final CompositeDisposable compositeDisposable;

    public static final class a {
        public a() {
        }
    }

    public static final class b<V> implements Callable {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final String call() {
            String r0 = ((j) new ce5.a().a(j.class)).F(this.a);
            if (TextUtils.isEmpty(r0) == true) goto L6;
            tt5.a.h(NavigationPlugin.TAG, "loadTitle: docName from db ");
            return r0;
        L6:
            String r1 = com.bytedance.ee.bear.route.c.b(this.a);
            if (TextUtils.isEmpty(r1) == true) goto L10;
            tt5.a.h(NavigationPlugin.TAG, "loadTitle: cacheTitle ");
            return r1;
        L10:
            tt5.a.h(NavigationPlugin.TAG, "loadTitle: defaultTitle ");
            return com.bytedance.ee.bear.route.c.e(LarkContext.getApplication().getApplicationContext());
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ h a;
        public final /* synthetic */ String b;

        public c(h r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            h r0 = this.a;
            String r1 = this.b;
            r0.H6(r1, (String) r3);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ h a;
        public final /* synthetic */ String b;

        public d(h r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            this.a.H6(this.b, com.bytedance.ee.bear.route.c.e(LarkContext.getApplication().getApplicationContext()));
            tt5.a.e(NavigationPlugin.TAG, "loadTitle error", (Throwable) r4, false);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ h a;
        public final /* synthetic */ String b;

        public e(h r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            tt5.a.h(NavigationPlugin.TAG, "deleted");
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L6;
            this.a.D4(this.b);
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ h a;
        public final /* synthetic */ String b;

        public f(h r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            tt5.a.h(NavigationPlugin.TAG, "onRename");
            h r0 = this.a;
            String r1 = this.b;
            r0.H6(r1, (String) r3);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public NavigationPlugin() {
        this.compositeDisposable = new CompositeDisposable();
    }

    private final void loadTitle(BearUrl r6) {
        String r2 = com.bytedance.ee.bear.route.c.f(r6);     // Catch: Throwable -> L7
        tt5.a.h(TAG, "loadTitle() called with: bearUrl = " + du5.b.k(r6.e) + ", objToken = " + du5.b.k(r2));     // Catch: Throwable -> L7
        h r7 = (h) org.koin.java.a.c(h.class, null, null, 6);     // Catch: Throwable -> L7
        if (r7.Xb(r2) == false) goto L12;
        this.compositeDisposable.add(Observable.fromCallable(new b(r2)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new c(r7, r2), new d(r7, r2)));     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        tt5.a.e(TAG, "loadTitle", th, false);
    }

    public void onAttachToHost(DocumentPluginHost r8) {
        super.onAttachToHost(r8);
        tt5.a.h(TAG, "onAttachToHost: ");
        if (r8 == null) goto L12;
        DocViewModel r9 = r8.a();
        if (r9 == null) goto L13;
        BearUrl r10 = r9.getOriginBearUrl();
        if (r10 == null) goto L14;
        loadTitle(r10);
        h r0 = (h) org.koin.java.a.c(h.class, null, null, 6);
        String r3 = com.bytedance.ee.bear.route.c.f(r10);
        getDocViewModel().getDeleted().observe(getLifecycleOwner(), new e(r0, r3));
        getDocViewModel().getDocName().observe(getLifecycleOwner(), new f(r0, r3));
        h r1 = (h) org.koin.java.a.c(h.class, null, null, 6);
        if (r1 == null) goto L15;
        r1.g3(r10.b, getDocViewModel().getToken());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public void onDetachFromHost(DocumentPluginHost r1) {
        super.onDetachFromHost(r1);
        this.compositeDisposable.dispose();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }
}
