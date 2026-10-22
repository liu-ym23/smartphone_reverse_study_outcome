package com.bytedance.ee.bear.doc.clientvar;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.offline.sync.opendoc.FetchClientVarExecutor;
import com.bytedance.ee.bear.document.offline.sync.opendoc.k;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb5.h;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u00032\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u0016H\u0016J!\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/doc/clientvar/FetchClientVarPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerRunOnNotUIThread;", "", "<init>", "()V", "mFetchClientVarExecutor", "Lcom/bytedance/ee/bear/document/offline/sync/opendoc/FetchClientVarExecutor;", "kotlin.jvm.PlatformType", "getMFetchClientVarExecutor", "()Lcom/bytedance/ee/bear/document/offline/sync/opendoc/FetchClientVarExecutor;", "mFetchClientVarExecutor$delegate", "Lkotlin/Lazy;", "disposableContainer", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposableContainer", "()Lio/reactivex/disposables/CompositeDisposable;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "handle", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "(Lkotlin/Unit;Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;)V", "onDetachFromHost", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FetchClientVarPlugin extends DocumentPluginV2 implements h<Unit> {
    public static final a Companion = null;
    public static final String TAG = "FetchClientVarPlugin";
    private final CompositeDisposable disposableContainer;
    private final Lazy mFetchClientVarExecutor$delegate;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements FlowableOnSubscribe {
        public final /* synthetic */ FetchClientVarPlugin a;
        public final /* synthetic */ BearUrl b;

        public static final class a implements FetchClientVarExecutor.b {
            public final /* synthetic */ FlowableEmitter<String> a;

            public a(FlowableEmitter<String> r1) {
                this.a = r1;
            }

            @Override // com.bytedance.ee.bear.document.offline.sync.opendoc.FetchClientVarExecutor.b
            public final void a(String r2) {
                Intrinsics.checkNotNullParameter(r2, "resultString");
                this.a.onNext(r2);
                this.a.onComplete();
            }
        }

        public b(FetchClientVarPlugin r1, BearUrl r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(FlowableEmitter<String> r4) {
            Intrinsics.checkNotNullParameter(r4, "emitter");
            this.a.getMFetchClientVarExecutor().c(this.b, new a(r4));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ m a;

        public c(m r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            m r0 = this.a;
            if (r0 == null) goto L6;
            r0.onCallBack(r3);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ m a;
        public final /* synthetic */ FetchClientVarPlugin b;

        public d(m r1, FetchClientVarPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.d(FetchClientVarPlugin.TAG, "getResult failed! is timeout " + (r4 instanceof TimeoutException));
            m r0 = this.a;
            if (r0 == null) goto L9;
            FetchClientVarExecutor r1 = this.b.getMFetchClientVarExecutor();
            String r5 = r4.getMessage();
            if (r5 != null) goto L7;
            r5 = "";
        L7:
            r1.getClass();
            r0.onCallBack(FetchClientVarExecutor.d(r5));
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ PluginHost a;
        public final /* synthetic */ FetchClientVarPlugin b;

        public e(PluginHost r1, FetchClientVarPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            BearUrl r5 = (BearUrl) r4;
            if (k.c(((h0) this.a.getUserComponent().a(h0.class)).G2(), r5.b, r5.getType()) != null) goto L6;
            tt5.a.h(FetchClientVarPlugin.TAG, "fetch clientVar when onAttachToHost");
            FetchClientVarExecutor r0 = this.b.getMFetchClientVarExecutor();
            Intrinsics.checkNotNull(r5);
            r0.b(r5);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f<T> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r3) {
            tt5.a.f(FetchClientVarPlugin.TAG, (Throwable) r3, false);
        }
    }

    static {
        Companion = new a();
    }

    @Override // tb5.h, tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public final FetchClientVarExecutor getMFetchClientVarExecutor() {
        return (FetchClientVarExecutor) this.mFetchClientVarExecutor$delegate.getValue();
    }

    public FetchClientVarPlugin() {
        this.mFetchClientVarExecutor$delegate = LazyKt.lazy(FetchClientVarPlugin$mFetchClientVarExecutor$2.INSTANCE);
        this.disposableContainer = new CompositeDisposable();
    }

    public final CompositeDisposable getDisposableContainer() {
        return this.disposableContainer;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlersHolder");
        r2.put("biz.docx.fetchClientVar", this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        super.onAttachToHost(r5);
        if (k.a() == true) goto L5;
        return;
    L5:
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L11;
        BearUrl r1 = r0.getBearUrl();
        if (r1 == null) goto L12;
        Flowable r2 = Flowable.just(r1);
        LarkContext.getApplication();
        new f25.i(j.a.a).b();
        Disposable r6 = r2.subscribeOn(new ExecutorScheduler(f25.i.e, false)).subscribe(new e(r5, this), f.a);
        this.disposableContainer.add(r6);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r7) {
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L5;
        BearUrl r1 = r0.getBearUrl();
    L6:
        if (r1 == null) goto L20;
        FetchClientVarExecutor r2 = getMFetchClientVarExecutor();
        monitor-enter(r2);
        Intrinsics.checkNotNullParameter(r1, "bearUrl");     // Catch: Throwable -> L17
        tt5.a.h("FetchClientVarExecutor", "clear url: " + du5.b.k(r1.b));     // Catch: Throwable -> L17
        FetchClientVarExecutor.d r3 = r2.e.remove(r1.b);     // Catch: Throwable -> L17
        if (r3 == null) goto L15;
        Disposable r4 = r3.c;     // Catch: Throwable -> L17
        if (r4 == null) goto L14;
        r4.dispose();     // Catch: Throwable -> L17
    L14:
        r3.b = null;     // Catch: Throwable -> L17
        r3.d.clear();     // Catch: Throwable -> L17
    L15:
        monitor-exit(r2);
    L17:
        th = move-exception;
        throw th;
    L20:
        this.disposableContainer.clear();
        super.onDetachFromHost(r7);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void handle(Unit r4, m r5) {
        tt5.a.h(TAG, "handle...");
        if (k.a() == true) goto L8;
        tt5.a.h(TAG, "enable is false, but was called from FE ");
        if (r5 == null) goto L19;
        getMFetchClientVarExecutor().getClass();
        r5.onCallBack(FetchClientVarExecutor.d("fg is not open"));
        return;
    L19:
        return;
    L8:
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L11;
        BearUrl r1 = r0.getBearUrl();
    L12:
        if (r1 != null) goto L17;
        tt5.a.k(TAG, "bear url is null");
        if (r5 == null) goto L20;
        getMFetchClientVarExecutor().getClass();
        r5.onCallBack(FetchClientVarExecutor.d("bear url is null"));
        return;
    L20:
        return;
    L17:
        Flowable r6 = Flowable.create(new b(this, r1), BackpressureStrategy.BUFFER);
        DocOpenConfig.a();
        Disposable r7 = r6.timeout(DocOpenConfig.g.fetchClientvarTimeout, TimeUnit.SECONDS).observeOn(fo5.d.d()).subscribe(new c(r5), new d(r5, this));
        this.disposableContainer.add(r7);
        return;
    L11:
        r1 = null;
        goto L12
    }

    @Override // tb5.h, tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((Unit) r1, r2);
    }
}
