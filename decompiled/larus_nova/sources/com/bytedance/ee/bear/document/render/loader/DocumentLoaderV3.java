package com.bytedance.ee.bear.document.render.loader;

import a05.c;
import android.webkit.WebView;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.m0;
import com.bytedance.ee.bear.document.b4;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.render.node.DocLoadingState;
import com.bytedance.ee.bear.document.render.node.RenderStage;
import com.bytedance.ee.bear.document.render.node.e;
import com.bytedance.ee.bear.document.render.node.f;
import com.bytedance.ee.bear.document.render.node.l;
import com.bytedance.ee.bear.document.render.node.m;
import com.bytedance.ee.bear.document.render.node.n;
import com.bytedance.ee.bear.document.render.node.o;
import com.bytedance.ee.bear.document.render.node.q;
import com.bytedance.ee.bear.document.u1;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import iu5.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes16.dex */
public final class DocumentLoaderV3 extends BaseDocumentLoader implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f221314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChameleonPluginHost f221315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v4 f221316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f221317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Job f221318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f221319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f221320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u1 f221321j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<m0> f221322k;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocumentLoaderV3 f221323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<m0, Unit> f221324b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(DocumentLoaderV3 r100, Function1<? super m0, Unit> r101) {
            this.f221323a = r100;
            this.f221324b = r101;
        }

        public final void a() {
            if (this.f221323a.f221315d.getFragment().getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
            tt5.a.h(this.f221323a.f221317f, this.f221323a.f221320i + " skip forEachRenderCallbacks because fragment is destroyed");
            return;
        L6:
            tt5.a.h(this.f221323a.f221317f, this.f221323a.f221320i + " forEachRenderCallbacks start");
            ArrayList r100 = new ArrayList();
            r100.addAll(this.f221323a.f221322k);
            DocumentLoaderV3 r101 = this.f221323a;
            Function1<m0, Unit> r102 = this.f221324b;
            Iterator r103 = r100.iterator();
        L8:
            if (r103.hasNext() == false) goto L17;
            m0 r104 = (m0) r103.next();
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L12
            r102.invoke(r104);     // Catch: Throwable -> L12
            Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
        L14:
            Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
            if (r107 == null) goto L8;
            tt5.a.l(r101.f221317f, "forEachRenderCallbacks failed", r107);
            d.a(r101.f221317f, r107);
        L12:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        L17:
            tt5.a.h(this.f221323a.f221317f, this.f221323a.f221320i + " forEachRenderCallbacks end");
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

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3$load$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3$load$1", f = "DocumentLoaderV3.kt", i = {0, 0}, l = {94}, m = "invokeSuspend", n = {"nodeTag", DyPayConstant.KEY_START_TIME}, s = {"L$1", "J$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<l> $nodeList;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DocumentLoaderV3 this$0;

        public AnonymousClass1(DocumentLoaderV3 r100, List<l> r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$nodeList = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$nodeList, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x01dd -> B:69:0x01e4). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 != 1) goto L9;
            long r102 = this.J$0;
            n r103 = (n) this.L$1;
            Iterator<n> r104 = (Iterator) this.L$0;
            ResultKt.throwOnFailure(r110);     // Catch: Exception -> L61 CancellationException -> L64
            Iterator<n> r105 = r104;
            long r106 = r102;
            n r107 = r103;
            Object r108 = r100;
            AnonymousClass1 r109 = this;
        L69:
            q r111 = (q) r110;     // Catch: Exception -> L51 CancellationException -> L53
            String r112 = r109.this$0.f221317f;     // Catch: Exception -> L51 CancellationException -> L53
            StringBuilder r113 = new StringBuilder();     // Catch: Exception -> L51 CancellationException -> L53
            r113.append(r109.this$0.f221320i);     // Catch: Exception -> L51 CancellationException -> L53
            r113.append(" after run, tag = ");     // Catch: Exception -> L51 CancellationException -> L53
            r113.append(r107);     // Catch: Exception -> L51 CancellationException -> L53
            r113.append(", result = ");     // Catch: Exception -> L51 CancellationException -> L53
            r113.append(r111);     // Catch: Exception -> L51 CancellationException -> L53
            r113.append(", cost = ");     // Catch: Exception -> L51 CancellationException -> L53
            r113.append(System.currentTimeMillis() - r106);     // Catch: Exception -> L51 CancellationException -> L53
            r113.append(", isCancel = ");     // Catch: Exception -> L51 CancellationException -> L53
            Job r114 = r109.this$0.f221318g;     // Catch: Exception -> L51 CancellationException -> L53
            if (r114 == null) goto L45;
            Boolean r115 = Boxing.boxBoolean(r114.isCancelled());     // Catch: Exception -> L51 CancellationException -> L53
        L46:
            r113.append(r115);     // Catch: Exception -> L51 CancellationException -> L53
            tt5.a.h(r112, r113.toString());     // Catch: Exception -> L51 CancellationException -> L53
            if ((r111 instanceof q.b) == false) goto L50;
            e.a.a(r109.this$0, ((q.b) r111).f221390b, ((q.b) r111).f221391c);     // Catch: Exception -> L51 CancellationException -> L53
            return Unit.INSTANCE;
        L50:
            AnonymousClass1 r116 = r109;
            r100 = r108;
            Iterator<n> r117 = r105;
        L71:
        L57:
            CancellationException e100 = e;
        L66:
            tt5.a.h(r116.this$0.f221317f, r116.this$0.f221320i + " load render node cancelled, e = " + e100);
        L68:
            return Unit.INSTANCE;
        L55:
            Exception e101 = e;
        L63:
            tt5.a.e(r116.this$0.f221317f, r116.this$0.f221320i + " load render node failed, e = " + e101, e101, false);
            e.a.a(r116.this$0, -1, e101);
            d.a(r116.this$0.f221317f, e101);
            goto L68
        L31:
            if (r117.hasNext() == false) goto L59;
            n r118 = r117.next();     // Catch: Exception -> L55 CancellationException -> L57
            long r119 = System.currentTimeMillis();     // Catch: Exception -> L55 CancellationException -> L57
            tt5.a.h(r116.this$0.f221317f, r116.this$0.f221320i + " before run, tag = " + r118 + ", currentNodeCount=" + r116.$nodeList.size());     // Catch: Exception -> L55 CancellationException -> L57
            Map<sbb.e, v4> r120 = b4.f219150a;     // Catch: Exception -> L55 CancellationException -> L57
            Intrinsics.checkNotNullParameter(r118, "tag");     // Catch: Exception -> L55 CancellationException -> L57
            m r121 = (m) ((LinkedHashMap) b4.f219151b).get(r118);     // Catch: Exception -> L55 CancellationException -> L57
            if (r121 == null) goto L35;
            l r122 = r121.a();     // Catch: Exception -> L55 CancellationException -> L57
        L36:
            if (r122 != null) goto L38;
            tt5.a.k(r116.this$0.f221317f, r116.this$0.f221320i + " create render node failed, tag = " + r118);     // Catch: Exception -> L55 CancellationException -> L57
            d.a(r116.this$0.f221317f, new Throwable("create render node failed, tag = " + r118));     // Catch: Exception -> L55 CancellationException -> L57
            goto L71
        L38:
            r116.$nodeList.add(r122);     // Catch: Exception -> L55 CancellationException -> L57
            DocumentLoaderV3 r123 = r116.this$0;     // Catch: Exception -> L55 CancellationException -> L57
            r116.L$0 = r117;     // Catch: Exception -> L55 CancellationException -> L57
            r116.L$1 = r118;     // Catch: Exception -> L55 CancellationException -> L57
            r116.J$0 = r119;     // Catch: Exception -> L55 CancellationException -> L57
            r116.label = 1;     // Catch: Exception -> L55 CancellationException -> L57
            Object r124 = r122.b(r123, r116);     // Catch: Exception -> L55 CancellationException -> L57
            if (r124 != r100) goto L41;
            return r100;
        L41:
            Object r125 = r100;
            r109 = r116;
            r110 = r124;
            r105 = r117;
            r106 = r119;
            r107 = r118;
            r108 = r125;
            goto L69
        L35:
            r122 = null;
            goto L36
        L59:
            tt5.a.h(r116.this$0.f221317f, r116.this$0.f221320i + " before dispatchLoadSuccess, nodeCount=" + r116.$nodeList.size());     // Catch: Exception -> L55 CancellationException -> L57
            r116.this$0.j();     // Catch: Exception -> L55 CancellationException -> L57
            tt5.a.h(r116.this$0.f221317f, r116.this$0.f221320i + " after dispatchLoadSuccess");     // Catch: Exception -> L55 CancellationException -> L57
        L45:
            r115 = null;
        L53:
            e = move-exception;
            AnonymousClass1 r126 = r109;
            e100 = e;
            r116 = r126;
        L51:
            e = move-exception;
            AnonymousClass1 r127 = r109;
            e101 = e;
            r116 = r127;
            goto L63
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r110);
            String r128 = this.this$0.f221317f;     // Catch: Exception -> L61 CancellationException -> L64
            StringBuilder r129 = new StringBuilder();     // Catch: Exception -> L61 CancellationException -> L64
            r129.append(this.this$0.f221320i);     // Catch: Exception -> L61 CancellationException -> L64
            r129.append(" load coroutine start loader=");     // Catch: Exception -> L61 CancellationException -> L64
            r129.append(System.identityHashCode(this.this$0));     // Catch: Exception -> L61 CancellationException -> L64
            r129.append(", fragmentState=");     // Catch: Exception -> L61 CancellationException -> L64
            Fragment r130 = this.this$0.f221315d.getHostFragment();     // Catch: Exception -> L61 CancellationException -> L64
            if (r130 == null) goto L16;
            Lifecycle r131 = r130.getLifecycle();     // Catch: Exception -> L61 CancellationException -> L64
            if (r131 == null) goto L16;
            Lifecycle.State r132 = r131.getCurrentState();     // Catch: Exception -> L61 CancellationException -> L64
        L17:
            r129.append(r132);     // Catch: Exception -> L61 CancellationException -> L64
            r129.append(", thread=");     // Catch: Exception -> L61 CancellationException -> L64
            r129.append(ThreadMethodProxy.currentThread().getName());     // Catch: Exception -> L61 CancellationException -> L64
            tt5.a.h(r128, r129.toString());     // Catch: Exception -> L61 CancellationException -> L64
            if (((dn4.a) this.this$0.f221315d.getUserComponent().a(dn4.a.class)).a().isCurrentEnable("ccm.mobile.webview_clear_view_v2") == false) goto L28;
            WebView r133 = this.this$0.f221315d.getWeb().getWebView();     // Catch: Exception -> L61 CancellationException -> L64
            if ((r133 instanceof ChameleonWebView) == false) goto L22;
            ChameleonWebView r134 = (ChameleonWebView) r133;     // Catch: Exception -> L61 CancellationException -> L64
        L23:
            if (r134 == null) goto L25;
            int r135 = r134.getUsedCount();     // Catch: Exception -> L61 CancellationException -> L64
        L26:
            if (r135 <= 0) goto L28;
            WebView r136 = this.this$0.f221315d.getWeb().getWebView();     // Catch: Exception -> L61 CancellationException -> L64
            Intrinsics.checkNotNullParameter(r136, "<this>");     // Catch: Exception -> L61 CancellationException -> L64
            OneShotPreDrawListener.add(r136, new n45.e(r136, r136));     // Catch: Exception -> L61 CancellationException -> L64
            goto L28
        L25:
            r135 = 0;
            goto L26
        L22:
            r134 = null;
        L28:
            u1 r137 = this.this$0.f221321j;     // Catch: Exception -> L61 CancellationException -> L64
            r137.getClass();     // Catch: Exception -> L61 CancellationException -> L64
            r137.f222434a = DocLoadingState.INIT;     // Catch: Exception -> L61 CancellationException -> L64
            r137.f222435b = RenderStage.RENDERING;     // Catch: Exception -> L61 CancellationException -> L64
            r137.f222436c = false;     // Catch: Exception -> L61 CancellationException -> L64
            DocumentLoaderV3 r138 = this.this$0;     // Catch: Exception -> L61 CancellationException -> L64
            r138.f221314c.f("unknown");     // Catch: Exception -> L61 CancellationException -> L64
            r138.f221314c.d("unknown");     // Catch: Exception -> L61 CancellationException -> L64
            this.this$0.i();     // Catch: Exception -> L61 CancellationException -> L64
            DocumentLoaderV3 r139 = this.this$0;     // Catch: Exception -> L61 CancellationException -> L64
            List<n> r140 = r139.f221316e.getRenderNode(r139.f221315d);     // Catch: Exception -> L61 CancellationException -> L64
            tt5.a.h(this.this$0.f221317f, this.this$0.f221320i + " load render node, count=" + r140.size() + ", tag list = " + r140);     // Catch: Exception -> L61 CancellationException -> L64
            r117 = r140.iterator();     // Catch: Exception -> L61 CancellationException -> L64
            r116 = this;
        L16:
            r132 = null;
        L64:
            e = move-exception;
            e100 = e;
            r116 = this;
        L61:
            e = move-exception;
            e101 = e;
            r116 = this;
            goto L63
        }
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final com.bytedance.ee.bear.document.d getDocumentMetadata() {
        return ((e4) this.f221315d.getHostAbility(e4.class)).getDocumentMetadata();
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void load() {
        StringBuilder r100 = new StringBuilder("DocumentLoaderV3#");
        r100.append(hashCode());
        r100.append("#web");
        WebView r101 = this.f221315d.getWeb().getWebView();
        Job r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.hashCode());
    L6:
        r100.append(r103);
        String r104 = r100.toString();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f221317f = r104;
        StringBuilder r105 = new StringBuilder();
        r105.append(this.f221320i);
        r105.append(" load called loader=");
        r105.append(System.identityHashCode(this));
        r105.append(", host=");
        r105.append(System.identityHashCode(this.f221315d));
        r105.append(", fragment=");
        Fragment r106 = this.f221315d.getHostFragment();
        if (r106 == null) goto L9;
        String r107 = r106.getClass().getSimpleName();
    L10:
        r105.append(r107);
        r105.append('@');
        r105.append(System.identityHashCode(this.f221315d.getHostFragment()));
        r105.append(", fragmentAdded=");
        Fragment r108 = this.f221315d.getHostFragment();
        if (r108 == null) goto L13;
        Boolean r109 = Boolean.valueOf(r108.isAdded());
    L14:
        r105.append(r109);
        r105.append(", fragmentState=");
        Fragment r110 = this.f221315d.getHostFragment();
        if (r110 == null) goto L19;
        Lifecycle r111 = r110.getLifecycle();
        if (r111 == null) goto L19;
        Lifecycle.State r112 = r111.getCurrentState();
    L20:
        r105.append(r112);
        r105.append(", webView=");
        r105.append(System.identityHashCode(this.f221315d.getWeb().getWebView()));
        r105.append(", existingJob=");
        if (this.f221318g == null) goto L23;
        boolean r113 = true;
    L24:
        r105.append(r113);
        r105.append(", thread=");
        r105.append(ThreadMethodProxy.currentThread().getName());
        tt5.a.h(r104, r105.toString());
        Job r114 = this.f221318g;
        if (r114 == null) goto L27;
        Job.DefaultImpls.cancel$default(r114, null, 1, null);
    L27:
        final ArrayList r115 = new ArrayList();
        if (this.f221315d.getHostFragment() != null) goto L30;
        tt5.a.k(this.f221317f, this.f221320i + " load skipped because hostFragment is null");
    L30:
        Fragment r116 = this.f221315d.getHostFragment();
        if (r116 == null) goto L35;
        LifecycleCoroutineScope r117 = LifecycleOwnerKt.getLifecycleScope(r116);
        if (r117 == null) goto L35;
        r102 = BuildersKt.launch$default(r117, Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(this, r115, null), 2, null);
    L35:
        this.f221318g = r102;
        if (r102 == null) goto L39;
        r102.invokeOnCompletion(new AnonymousClass2(this, r115));
        return;
    L39:
        return;
    L23:
        r113 = false;
    L19:
        r112 = null;
        goto L20
    L13:
        r109 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void onDestroy() {
        tt5.a.h(this.f221317f, this.f221320i + " onDestroy...");
        Job r100 = this.f221318g;
        if (r100 == null) goto L6;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
        return;
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void onPause() {
        tt5.a.h(this.f221317f, this.f221320i + " onPause...");
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final f b() {
        return this.f221314c;
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final o e() {
        return this.f221319h;
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final String f() {
        return this.f221320i;
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final ChameleonPluginHost getPluginHost() {
        return this.f221315d;
    }

    @Override // com.bytedance.ee.bear.document.render.loader.BaseDocumentLoader
    public final String l() {
        return this.f221317f;
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "userScopeApi");
        return (T) this.f221315d.getUserComponent().a(r100);
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void bi(boolean r110) {
        tt5.a.h(this.f221317f, this.f221320i + " cancelLoad, cancelByUser = " + r110);
        if (r110 == false) goto L28;
        Job r111 = this.f221318g;
        if (r111 != null) goto L7;
    L9:
        boolean r112 = false;
    L10:
        if (r112 == false) goto L28;
        u1 r113 = this.f221321j;
        DocLoadingState r100 = r113.f222434a;
        r113.i();
        if (this.f221321j.f222434a != DocLoadingState.CANCELED) goto L28;
        String r101 = getDocumentMetadata().getEditionId();
        int r102 = this.f221314c.c(r100, this.f221321j);
        f r103 = this.f221314c;
        boolean r104 = this.f221321j.f222436c;
        if (r101 != null) goto L16;
    L19:
        int r114 = 1;
    L20:
        r103.i(r102, r104, r114 ^ 1, r101, this.f221315d.getWeb().getWebView(), ForsetiHelper.s(this.f221315d.getHostFragment()));
        tt5.a.h(this.f221317f, "dispatchLoadCancel count=" + this.f221313b.size() + ", callbacks=" + h());
        Iterator r115 = CollectionsKt.toMutableList(this.f221313b).iterator();
    L22:
        if (r115.hasNext() == false) goto L28;
        x2.b r105 = (x2.b) r115.next();
        tt5.a.h(this.f221317f, "dispatchLoadCancel callback=" + BaseDocumentLoader.g(r105));
        r105.onLoadCancel();     // Catch: Exception -> L26
    L26:
        e = move-exception;
        tt5.a.e(this.f221317f, "dispatchLoadCancel failed, e = " + e, e, false);
        d.a(this.f221317f, e);
        goto L22
    L16:
        if (r101.length() == 0) goto L19;
        r114 = 0;
        goto L20
    L7:
        if (r111.isActive() != true) goto L9;
        r112 = true;
    L28:
        Job r116 = this.f221318g;
        if (r116 == null) goto L38;
        Job.DefaultImpls.cancel$default(r116, null, 1, null);
        return;
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final void c(Function1<? super m0, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "job");
        tt5.a.h(this.f221317f, this.f221320i + " before forEachRenderCallbacks");
        j.f(new a(this, r100));
    }

    public final void m(m0 r100) {
        Intrinsics.checkNotNullParameter(r100, "renderCallback");
        if (this.f221322k.contains(r100) == true) goto L6;
        this.f221322k.add(r100);
        return;
    }

    public final void n(m0 r100) {
        Intrinsics.checkNotNullParameter(r100, "renderCallback");
        ((ArrayList) this.f221322k).remove(r100);
    }

    public DocumentLoaderV3(c r100, ChameleonPluginHost r101, v4 r102) {
        Intrinsics.checkNotNullParameter(r100, "mDocReport");
        Intrinsics.checkNotNullParameter(r101, "pluginHost");
        Intrinsics.checkNotNullParameter(r102, "baseDocOpenStrategy");
        this.f221314c = r100;
        this.f221315d = r101;
        this.f221316e = r102;
        this.f221317f = "DocumentLoaderV3#" + hashCode();
        this.f221319h = new o();
        StringBuilder r103 = new StringBuilder("==openDocs==render== DocumentLoaderV3");
        r103.append(hashCode());
        r103.append(", webView");
        WebView r104 = r101.getWeb().getWebView();
        if (r104 == null) goto L5;
        Integer r105 = Integer.valueOf(r104.hashCode());
    L6:
        r103.append(r105);
        r103.append(' ');
        this.f221320i = r103.toString();
        this.f221321j = new u1();
        this.f221322k = new ArrayList();
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final void d(int r100, Throwable r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r102, "map");
        tt5.a.i(this.f221317f, this.f221320i + " terminate, code = " + r100, r101);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f221315d.getFragment()), Dispatchers.getMain().getImmediate(), null, new DocumentLoaderV3$terminate$1(this, r100, r101, null), 2, null);
    }
}
