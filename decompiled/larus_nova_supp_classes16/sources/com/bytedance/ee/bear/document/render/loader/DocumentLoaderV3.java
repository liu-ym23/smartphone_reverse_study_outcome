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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DocumentLoaderV3 extends BaseDocumentLoader implements e {
    public final f c;
    public final ChameleonPluginHost d;
    public final v4 e;
    public String f;
    public Job g;
    public final o h;
    public final String i;
    public final u1 j;
    public final List<m0> k;

    public static final class a implements Runnable {
        public final /* synthetic */ DocumentLoaderV3 a;
        public final /* synthetic */ Function1<m0, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(DocumentLoaderV3 r1, Function1<? super m0, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.a.d.getFragment().getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
            tt5.a.h(this.a.f, this.a.i + " skip forEachRenderCallbacks because fragment is destroyed");
            return;
        L6:
            tt5.a.h(this.a.f, this.a.i + " forEachRenderCallbacks start");
            ArrayList r0 = new ArrayList();
            r0.addAll(this.a.k);
            DocumentLoaderV3 r1 = this.a;
            Function1<m0, Unit> r2 = this.b;
            Iterator r3 = r0.iterator();
        L8:
            if (r3.hasNext() == false) goto L17;
            m0 r4 = (m0) r3.next();
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L12
            r2.invoke(r4);     // Catch: Throwable -> L12
            Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
        L14:
            Throwable r7 = Result.exceptionOrNull-impl(r6);
            if (r7 == null) goto L8;
            tt5.a.l(r1.f, "forEachRenderCallbacks failed", r7);
            d.a(r1.f, r7);
        L12:
            th = move-exception;
            Result.Companion r8 = Result.Companion;
            r6 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L14
        L17:
            tt5.a.h(this.a.f, this.a.i + " forEachRenderCallbacks end");
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
    @DebugMetadata(c = "com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3$load$1", f = "DocumentLoaderV3.kt", i = {0, 0}, l = {94}, m = "invokeSuspend", n = {"nodeTag", "startTime"}, s = {"L$1", "J$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<l> $nodeList;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DocumentLoaderV3 this$0;

        public AnonymousClass1(DocumentLoaderV3 r1, List<l> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$nodeList = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$nodeList, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x01dd -> B:69:0x01e4). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r16) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            long r5 = this.J$0;
            n r2 = (n) this.L$1;
            Iterator<n> r7 = (Iterator) this.L$0;
            ResultKt.throwOnFailure(r16);     // Catch: Exception -> L61 CancellationException -> L64
            Iterator<n> r8 = r7;
            long r6 = r5;
            n r9 = r2;
            Object r3 = r0;
            AnonymousClass1 r4 = this;
        L69:
            q r17 = (q) r16;     // Catch: Exception -> L51 CancellationException -> L53
            String r10 = r4.this$0.f;     // Catch: Exception -> L51 CancellationException -> L53
            StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L51 CancellationException -> L53
            r11.append(r4.this$0.i);     // Catch: Exception -> L51 CancellationException -> L53
            r11.append(" after run, tag = ");     // Catch: Exception -> L51 CancellationException -> L53
            r11.append(r9);     // Catch: Exception -> L51 CancellationException -> L53
            r11.append(", result = ");     // Catch: Exception -> L51 CancellationException -> L53
            r11.append(r17);     // Catch: Exception -> L51 CancellationException -> L53
            r11.append(", cost = ");     // Catch: Exception -> L51 CancellationException -> L53
            r11.append(System.currentTimeMillis() - r6);     // Catch: Exception -> L51 CancellationException -> L53
            r11.append(", isCancel = ");     // Catch: Exception -> L51 CancellationException -> L53
            Job r12 = r4.this$0.g;     // Catch: Exception -> L51 CancellationException -> L53
            if (r12 == null) goto L45;
            Boolean r13 = Boxing.boxBoolean(r12.isCancelled());     // Catch: Exception -> L51 CancellationException -> L53
        L46:
            r11.append(r13);     // Catch: Exception -> L51 CancellationException -> L53
            tt5.a.h(r10, r11.toString());     // Catch: Exception -> L51 CancellationException -> L53
            if ((r17 instanceof q.b) == false) goto L50;
            e.a.a(r4.this$0, ((q.b) r17).b, ((q.b) r17).c);     // Catch: Exception -> L51 CancellationException -> L53
            return Unit.INSTANCE;
        L50:
            AnonymousClass1 r18 = r4;
            r0 = r3;
            Iterator<n> r14 = r8;
        L71:
        L57:
            CancellationException e = e;
        L66:
            tt5.a.h(r18.this$0.f, r18.this$0.i + " load render node cancelled, e = " + e);
        L68:
            return Unit.INSTANCE;
        L55:
            Exception e2 = e;
        L63:
            tt5.a.e(r18.this$0.f, r18.this$0.i + " load render node failed, e = " + e2, e2, false);
            e.a.a(r18.this$0, -1, e2);
            d.a(r18.this$0.f, e2);
            goto L68
        L31:
            if (r14.hasNext() == false) goto L59;
            n r19 = r14.next();     // Catch: Exception -> L55 CancellationException -> L57
            long r20 = System.currentTimeMillis();     // Catch: Exception -> L55 CancellationException -> L57
            tt5.a.h(r18.this$0.f, r18.this$0.i + " before run, tag = " + r19 + ", currentNodeCount=" + r18.$nodeList.size());     // Catch: Exception -> L55 CancellationException -> L57
            Map<sbb.e, v4> r21 = b4.a;     // Catch: Exception -> L55 CancellationException -> L57
            Intrinsics.checkNotNullParameter(r19, "tag");     // Catch: Exception -> L55 CancellationException -> L57
            m r22 = (m) ((LinkedHashMap) b4.b).get(r19);     // Catch: Exception -> L55 CancellationException -> L57
            if (r22 == null) goto L35;
            l r23 = r22.a();     // Catch: Exception -> L55 CancellationException -> L57
        L36:
            if (r23 != null) goto L38;
            tt5.a.k(r18.this$0.f, r18.this$0.i + " create render node failed, tag = " + r19);     // Catch: Exception -> L55 CancellationException -> L57
            d.a(r18.this$0.f, new Throwable("create render node failed, tag = " + r19));     // Catch: Exception -> L55 CancellationException -> L57
            goto L71
        L38:
            r18.$nodeList.add(r23);     // Catch: Exception -> L55 CancellationException -> L57
            DocumentLoaderV3 r24 = r18.this$0;     // Catch: Exception -> L55 CancellationException -> L57
            r18.L$0 = r14;     // Catch: Exception -> L55 CancellationException -> L57
            r18.L$1 = r19;     // Catch: Exception -> L55 CancellationException -> L57
            r18.J$0 = r20;     // Catch: Exception -> L55 CancellationException -> L57
            r18.label = 1;     // Catch: Exception -> L55 CancellationException -> L57
            Object r26 = r23.b(r24, r18);     // Catch: Exception -> L55 CancellationException -> L57
            if (r26 != r0) goto L41;
            return r0;
        L41:
            Object r110 = r0;
            r4 = r18;
            r16 = r26;
            r8 = r14;
            r6 = r20;
            r9 = r19;
            r3 = r110;
            goto L69
        L35:
            r23 = null;
            goto L36
        L59:
            tt5.a.h(r18.this$0.f, r18.this$0.i + " before dispatchLoadSuccess, nodeCount=" + r18.$nodeList.size());     // Catch: Exception -> L55 CancellationException -> L57
            r18.this$0.j();     // Catch: Exception -> L55 CancellationException -> L57
            tt5.a.h(r18.this$0.f, r18.this$0.i + " after dispatchLoadSuccess");     // Catch: Exception -> L55 CancellationException -> L57
        L45:
            r13 = null;
        L53:
            e = move-exception;
            AnonymousClass1 r111 = r4;
            e = e;
            r18 = r111;
        L51:
            e = move-exception;
            AnonymousClass1 r112 = r4;
            e2 = e;
            r18 = r112;
            goto L63
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r16);
            String r113 = this.this$0.f;     // Catch: Exception -> L61 CancellationException -> L64
            StringBuilder r27 = new StringBuilder();     // Catch: Exception -> L61 CancellationException -> L64
            r27.append(this.this$0.i);     // Catch: Exception -> L61 CancellationException -> L64
            r27.append(" load coroutine start loader=");     // Catch: Exception -> L61 CancellationException -> L64
            r27.append(System.identityHashCode(this.this$0));     // Catch: Exception -> L61 CancellationException -> L64
            r27.append(", fragmentState=");     // Catch: Exception -> L61 CancellationException -> L64
            Fragment r28 = this.this$0.d.getHostFragment();     // Catch: Exception -> L61 CancellationException -> L64
            if (r28 == null) goto L16;
            Lifecycle r29 = r28.getLifecycle();     // Catch: Exception -> L61 CancellationException -> L64
            if (r29 == null) goto L16;
            Lifecycle.State r30 = r29.getCurrentState();     // Catch: Exception -> L61 CancellationException -> L64
        L17:
            r27.append(r30);     // Catch: Exception -> L61 CancellationException -> L64
            r27.append(", thread=");     // Catch: Exception -> L61 CancellationException -> L64
            r27.append(ThreadMethodProxy.currentThread().getName());     // Catch: Exception -> L61 CancellationException -> L64
            tt5.a.h(r113, r27.toString());     // Catch: Exception -> L61 CancellationException -> L64
            if (((dn4.a) this.this$0.d.getUserComponent().a(dn4.a.class)).a().isCurrentEnable("ccm.mobile.webview_clear_view_v2") == false) goto L28;
            ChameleonWebView r114 = this.this$0.d.getWeb().getWebView();     // Catch: Exception -> L61 CancellationException -> L64
            if ((r114 instanceof ChameleonWebView) == false) goto L22;
            ChameleonWebView r115 = r114;     // Catch: Exception -> L61 CancellationException -> L64
        L23:
            if (r115 == null) goto L25;
            int r116 = r115.getUsedCount();     // Catch: Exception -> L61 CancellationException -> L64
        L26:
            if (r116 <= 0) goto L28;
            WebView r117 = this.this$0.d.getWeb().getWebView();     // Catch: Exception -> L61 CancellationException -> L64
            Intrinsics.checkNotNullParameter(r117, "<this>");     // Catch: Exception -> L61 CancellationException -> L64
            OneShotPreDrawListener.add(r117, new n45.e(r117, r117));     // Catch: Exception -> L61 CancellationException -> L64
            goto L28
        L25:
            r116 = 0;
            goto L26
        L22:
            r115 = null;
        L28:
            u1 r118 = this.this$0.j;     // Catch: Exception -> L61 CancellationException -> L64
            r118.getClass();     // Catch: Exception -> L61 CancellationException -> L64
            r118.a = DocLoadingState.INIT;     // Catch: Exception -> L61 CancellationException -> L64
            r118.b = RenderStage.RENDERING;     // Catch: Exception -> L61 CancellationException -> L64
            r118.c = false;     // Catch: Exception -> L61 CancellationException -> L64
            DocumentLoaderV3 r119 = this.this$0;     // Catch: Exception -> L61 CancellationException -> L64
            r119.c.f("unknown");     // Catch: Exception -> L61 CancellationException -> L64
            r119.c.d("unknown");     // Catch: Exception -> L61 CancellationException -> L64
            this.this$0.i();     // Catch: Exception -> L61 CancellationException -> L64
            DocumentLoaderV3 r120 = this.this$0;     // Catch: Exception -> L61 CancellationException -> L64
            List<n> r121 = r120.e.getRenderNode(r120.d);     // Catch: Exception -> L61 CancellationException -> L64
            tt5.a.h(this.this$0.f, this.this$0.i + " load render node, count=" + r121.size() + ", tag list = " + r121);     // Catch: Exception -> L61 CancellationException -> L64
            r14 = r121.iterator();     // Catch: Exception -> L61 CancellationException -> L64
            r18 = this;
        L16:
            r30 = null;
        L64:
            e = move-exception;
            e = e;
            r18 = this;
        L61:
            e = move-exception;
            e2 = e;
            r18 = this;
            goto L63
        }
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final com.bytedance.ee.bear.document.d getDocumentMetadata() {
        return ((e4) this.d.getHostAbility(e4.class)).getDocumentMetadata();
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void load() {
        StringBuilder r0 = new StringBuilder("DocumentLoaderV3#");
        r0.append(hashCode());
        r0.append("#web");
        WebView r1 = this.d.getWeb().getWebView();
        Job r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(r1.hashCode());
    L6:
        r0.append(r3);
        String r4 = r0.toString();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.f = r4;
        StringBuilder r5 = new StringBuilder();
        r5.append(this.i);
        r5.append(" load called loader=");
        r5.append(System.identityHashCode(this));
        r5.append(", host=");
        r5.append(System.identityHashCode(this.d));
        r5.append(", fragment=");
        Fragment r6 = this.d.getHostFragment();
        if (r6 == null) goto L9;
        String r7 = r6.getClass().getSimpleName();
    L10:
        r5.append(r7);
        r5.append('@');
        r5.append(System.identityHashCode(this.d.getHostFragment()));
        r5.append(", fragmentAdded=");
        Fragment r8 = this.d.getHostFragment();
        if (r8 == null) goto L13;
        Boolean r9 = Boolean.valueOf(r8.isAdded());
    L14:
        r5.append(r9);
        r5.append(", fragmentState=");
        Fragment r10 = this.d.getHostFragment();
        if (r10 == null) goto L19;
        Lifecycle r11 = r10.getLifecycle();
        if (r11 == null) goto L19;
        Lifecycle.State r12 = r11.getCurrentState();
    L20:
        r5.append(r12);
        r5.append(", webView=");
        r5.append(System.identityHashCode(this.d.getWeb().getWebView()));
        r5.append(", existingJob=");
        if (this.g == null) goto L23;
        boolean r13 = true;
    L24:
        r5.append(r13);
        r5.append(", thread=");
        r5.append(ThreadMethodProxy.currentThread().getName());
        tt5.a.h(r4, r5.toString());
        Job r14 = this.g;
        if (r14 == null) goto L27;
        Job.DefaultImpls.cancel$default(r14, null, 1, null);
    L27:
        final ArrayList r16 = new ArrayList();
        if (this.d.getHostFragment() != null) goto L30;
        tt5.a.k(this.f, this.i + " load skipped because hostFragment is null");
    L30:
        Fragment r17 = this.d.getHostFragment();
        if (r17 == null) goto L35;
        LifecycleCoroutineScope r18 = LifecycleOwnerKt.getLifecycleScope(r17);
        if (r18 == null) goto L35;
        r2 = BuildersKt.launch$default(r18, Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(this, r16, null), 2, null);
    L35:
        this.g = r2;
        if (r2 == null) goto L39;
        r2.invokeOnCompletion(new AnonymousClass2(this, r16));
        return;
    L39:
        return;
    L23:
        r13 = false;
    L19:
        r12 = null;
        goto L20
    L13:
        r9 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void onDestroy() {
        tt5.a.h(this.f, this.i + " onDestroy...");
        Job r0 = this.g;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        return;
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void onPause() {
        tt5.a.h(this.f, this.i + " onPause...");
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final f b() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final o e() {
        return this.h;
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final String f() {
        return this.i;
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final ChameleonPluginHost getPluginHost() {
        return this.d;
    }

    @Override // com.bytedance.ee.bear.document.render.loader.BaseDocumentLoader
    public final String l() {
        return this.f;
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final <T> T a(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "userScopeApi");
        return (T) this.d.getUserComponent().a(r2);
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void bi(boolean r11) {
        tt5.a.h(this.f, this.i + " cancelLoad, cancelByUser = " + r11);
        if (r11 == false) goto L28;
        Job r12 = this.g;
        if (r12 != null) goto L7;
    L9:
        boolean r13 = false;
    L10:
        if (r13 == false) goto L28;
        u1 r14 = this.j;
        DocLoadingState r2 = r14.a;
        r14.i();
        if (this.j.a != DocLoadingState.CANCELED) goto L28;
        String r7 = getDocumentMetadata().getEditionId();
        int r4 = this.c.c(r2, this.j);
        f r3 = this.c;
        boolean r5 = this.j.c;
        if (r7 != null) goto L16;
    L19:
        int r16 = 1;
    L20:
        r3.i(r4, r5, r16 ^ 1, r7, this.d.getWeb().getWebView(), ForsetiHelper.s(this.d.getHostFragment()));
        tt5.a.h(this.f, "dispatchLoadCancel count=" + this.b.size() + ", callbacks=" + h());
        Iterator r17 = CollectionsKt.toMutableList(this.b).iterator();
    L22:
        if (r17.hasNext() == false) goto L28;
        x2.b r6 = (x2.b) r17.next();
        tt5.a.h(this.f, "dispatchLoadCancel callback=" + BaseDocumentLoader.g(r6));
        r6.onLoadCancel();     // Catch: Exception -> L26
    L26:
        e = move-exception;
        tt5.a.e(this.f, "dispatchLoadCancel failed, e = " + e, e, false);
        d.a(this.f, e);
        goto L22
    L16:
        if (r7.length() == 0) goto L19;
        r16 = 0;
        goto L20
    L7:
        if (r12.isActive() != true) goto L9;
        r13 = true;
    L28:
        Job r18 = this.g;
        if (r18 == null) goto L38;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);
        return;
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final void c(Function1<? super m0, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "job");
        tt5.a.h(this.f, this.i + " before forEachRenderCallbacks");
        j.f(new a(this, r4));
    }

    public final void m(m0 r2) {
        Intrinsics.checkNotNullParameter(r2, "renderCallback");
        if (this.k.contains(r2) == true) goto L6;
        this.k.add(r2);
        return;
    }

    public final void n(m0 r2) {
        Intrinsics.checkNotNullParameter(r2, "renderCallback");
        ((ArrayList) this.k).remove(r2);
    }

    public DocumentLoaderV3(c r2, ChameleonPluginHost r3, v4 r4) {
        Intrinsics.checkNotNullParameter(r2, "mDocReport");
        Intrinsics.checkNotNullParameter(r3, "pluginHost");
        Intrinsics.checkNotNullParameter(r4, "baseDocOpenStrategy");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = "DocumentLoaderV3#" + hashCode();
        this.h = new o();
        StringBuilder r5 = new StringBuilder("==openDocs==render== DocumentLoaderV3");
        r5.append(hashCode());
        r5.append(", webView");
        WebView r6 = r3.getWeb().getWebView();
        if (r6 == null) goto L5;
        Integer r7 = Integer.valueOf(r6.hashCode());
    L6:
        r5.append(r7);
        r5.append(' ');
        this.i = r5.toString();
        this.j = new u1();
        this.k = new ArrayList();
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.render.node.e
    public final void d(int r7, Throwable r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r8, "throwable");
        Intrinsics.checkNotNullParameter(r9, "map");
        tt5.a.i(this.f, this.i + " terminate, code = " + r7, r8);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.d.getFragment()), Dispatchers.getMain().getImmediate(), null, new DocumentLoaderV3$terminate$1(this, r7, r8, null), 2, null);
    }
}
