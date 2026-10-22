package com.larus.dora.impl.guide.service;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraGuideService;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.settings.d1;
import com.larus.dora.impl.util.t0;
import com.larus.platform.service.n0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016JT\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2$\u0010\u001d\u001a \u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0010H\u0016J4\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J4\u0010'\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010(\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0010H\u0016J\"\u0010)\u001a\u00020\n2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+H\u0086@¢\u0006\u0002\u0010-R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/dora/impl/guide/service/DoraGuideServiceImpl;", "Lcom/larus/dora/api/IDoraGuideService;", "<init>", "()V", "_config", "Lcom/larus/dora/impl/guide/common/DoraGuideConfig;", "config", "getConfig", "()Lcom/larus/dora/impl/guide/common/DoraGuideConfig;", "_isInit", "", "init", "", "isDoraGuideDegrade", "sessions", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/larus/dora/impl/guide/service/GuideSession;", "sessionIdGen", "Ljava/util/concurrent/atomic/AtomicInteger;", "launchGuideSession", "page", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "guideFilterList", "", "lifeCycleScope", "Lkotlinx/coroutines/CoroutineScope;", "guideListener", "Lkotlin/Function4;", "endGuideSession", "sessionId", "showGuide", "guideId", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "anchorView", "Landroid/view/View;", "dismissGuide", "requestGuide", "waitInitReady", "timeoutMs", "", "checkIntervalMs", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGuideServiceImpl implements IDoraGuideService {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f335950e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i59.b f335951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f335952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, GuideSession> f335953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f335954d;

    public static final class a {
    }

    public static final class b extends t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraGuideServiceImpl f335955a;

        public b(DoraGuideServiceImpl r100) {
            this.f335955a = r100;
        }

        @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
        public final void onBtConnectStateChanged(DoraDevice r100, int r101, int r102) {
            if (n0.f365775a.b() == false) goto L6;
            return;
        L6:
            if (r101 == 2) goto L15;
            if (r102 != 2) goto L15;
            Iterator<T> r103 = this.f335955a.f335953c.values().iterator();     // Catch: Exception -> L13
        L10:
            if (r103.hasNext() == false) goto L36;
            GuideSession r104 = (GuideSession) r103.next();     // Catch: Exception -> L13
            r104.g(DoraGuideMeta.DoraBindGuide);     // Catch: Exception -> L13
            r104.g(DoraGuideMeta.DoraConnectDeviceGuide);     // Catch: Exception -> L13
            r104.g(DoraGuideMeta.DoraDNULostUserGuide);     // Catch: Exception -> L13
            goto L10
        L36:
            return;
        L13:
            e = move-exception;
            g49.d.c("DoraGuideServiceImpl", "push bind/connect/dnu guide failed, " + e.getMessage(), e);
            return;
        L15:
            if (r101 != 2) goto L34;
            if (r102 == 2) goto L35;
            Iterator<T> r105 = this.f335955a.f335953c.values().iterator();     // Catch: Exception -> L22
        L19:
            if (r105.hasNext() == false) goto L37;
            GuideSession r106 = (GuideSession) r105.next();     // Catch: Exception -> L22
            r106.b(DoraGuideMeta.DoraBindGuide);     // Catch: Exception -> L22
            r106.b(DoraGuideMeta.DoraConnectDeviceGuide);     // Catch: Exception -> L22
            r106.b(DoraGuideMeta.DoraDNULostUserGuide);     // Catch: Exception -> L22
            goto L19
        L37:
            return;
        L22:
            e = move-exception;
            g49.d.c("DoraGuideServiceImpl", "dismiss bind/connect/dnu guide failed, " + e.getMessage(), e);
            return;
        L35:
            return;
        }

        @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
        public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
            if (n0.f365775a.b() == false) goto L6;
            return;
        L6:
            if (r102 != 2) goto L24;
            Iterator<T> r103 = this.f335955a.f335953c.values().iterator();     // Catch: Exception -> L12
        L9:
            if (r103.hasNext() == false) goto L31;
            ((GuideSession) r103.next()).g(DoraGuideMeta.DoraKeepAliveGuide);     // Catch: Exception -> L12
            goto L9
        L31:
            return;
        L12:
            e = move-exception;
            g49.d.c("DoraGuideServiceImpl", "push keep alive guide failed, " + e.getMessage(), e);
            return;
        L24:
            Iterator<T> r104 = this.f335955a.f335953c.values().iterator();     // Catch: Exception -> L19
        L16:
            if (r104.hasNext() == false) goto L32;
            ((GuideSession) r104.next()).b(DoraGuideMeta.DoraKeepAliveGuide);     // Catch: Exception -> L19
            goto L16
        L32:
            return;
        L19:
            e = move-exception;
            g49.d.c("DoraGuideServiceImpl", "dismiss keep alive guide failed, " + e.getMessage(), e);
        }
    }

    static {
    }

    @Override // com.larus.dora.api.IDoraGuideService
    public final boolean b() {
        IDoraAVLinkService r100 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.b();
    }

    @Override // com.larus.dora.api.IDoraGuideService
    public final void init() {
        Function0 r100 = new com.larus.dora.impl.guide.service.a(this);
        DoraSetting r101 = DoraSetting.f338023a;
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (DoraSetting.f338024b == false) goto L5;
        r100.invoke();
    L6:
        kj4.a.g().registerDoraLinkCallback(new b(this));
        return;
    L5:
        new d1(r100).start();
        goto L6
    }

    public DoraGuideServiceImpl() {
        this.f335953c = new ConcurrentHashMap();
        this.f335954d = new AtomicInteger(1);
    }

    @Override // com.larus.dora.api.IDoraGuideService
    public final void a(int r100) {
        GuideSession r101 = this.f335953c.remove(Integer.valueOf(r100));
        if (r101 != null) goto L11;
        g49.d.d("DoraGuideServiceImpl", "endGuideSession ignored: session not found id=" + r100);
        return;
    L11:
        r101.i();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        g49.d.c("DoraGuideServiceImpl", "endGuideSession failed: " + e.getMessage(), e);
    }

    public final Object c(long r100, long r101, Continuation<? super Boolean> r110) {
        if ((r110 instanceof DoraGuideServiceImpl$waitInitReady$1) == false) goto L7;
        DoraGuideServiceImpl$waitInitReady$1 r102 = (DoraGuideServiceImpl$waitInitReady$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        boolean r106 = false;
        if (r105 == 0) goto L17;
        if (r105 != 1) goto L16;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L13
    L24:
        Boolean r112 = (Boolean) r111;     // Catch: Exception -> L13
        if (r112 == null) goto L30;
        r106 = r112.booleanValue();     // Catch: Exception -> L13
    L30:
        return Boxing.boxBoolean(r106);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r111);
        if (this.f335952b == true) goto L20;
        DoraGuideServiceImpl$waitInitReady$2 r113 = new DoraGuideServiceImpl$waitInitReady$2(this, r101, null);     // Catch: Exception -> L13
        r102.label = 1;     // Catch: Exception -> L13
        r111 = TimeoutKt.c(r100, r113, r102);     // Catch: Exception -> L13
        if (r111 != r104) goto L24;
        return r104;
    L20:
        return Boxing.boxBoolean(true);
    L13:
        e = move-exception;
        g49.d.c("DoraGuideServiceImpl", "waitInitReady failed: " + e.getMessage(), e);
    L7:
        r102 = new DoraGuideServiceImpl$waitInitReady$1(this, r110);
        goto L8
    }

    @Override // com.larus.dora.api.IDoraGuideService
    public final void d(int r100, int r110, Fragment r111, View r112, LifecycleCoroutineScope r113) {
        Intrinsics.checkNotNullParameter(r113, "lifeCycleScope");
        GuideSession r114 = this.f335953c.get(Integer.valueOf(r100));     // Catch: Exception -> L12
        if (r114 != null) goto L15;
        g49.d.b("DoraGuideServiceImpl", "showGuide failed: session not found id=" + r100);
        return;
    L15:
        g49.d.d(r114.c(), "showGuide() start, guideId=" + r110);     // Catch: Exception -> L9
        r114.e(new GuideSession$showGuide$1(r114, r110, r111, r112, null));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        g49.d.c("DoraGuideServiceImpl", "showGuide failed: " + e.getMessage(), e);
        return;
    L12:
        e = move-exception;
        g49.d.c("DoraGuideServiceImpl", "showGuide failed: " + e.getMessage(), e);
    }

    @Override // com.larus.dora.api.IDoraGuideService
    public final int e(String r110, Context r111, List r112, LifecycleCoroutineScope r210, Function4 r211) {
        Intrinsics.checkNotNullParameter(r110, "page");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "guideFilterList");
        Intrinsics.checkNotNullParameter(r210, "lifeCycleScope");
        Intrinsics.checkNotNullParameter(r211, "guideListener");
        if (n0.f365775a.b() == false) goto L15;
        g49.d.d("DoraGuideServiceImpl", "launchGuideSession: ignore in enterprise mode, page=".concat(r110));
        return -1;
    L15:
        int r113 = this.f335954d.getAndIncrement();     // Catch: Exception -> L12
        final GuideSession r114 = new GuideSession(r113, r110, new WeakReference(r111), r112, r210, r211);     // Catch: Exception -> L12
        this.f335953c.put(Integer.valueOf(r113), r114);     // Catch: Exception -> L12
        Job r100 = (Job) r210.getCoroutineContext().get(Job.Key);
        if (r100 == null) goto L10;
        r100.invokeOnCompletion(new com.larus.dora.impl.guide.service.b(r114, this));
    L10:
        BuildersKt.launch$default(r210, null, null, new DoraGuideServiceImpl$launchGuideSession$2(this, r114, null), 3, null);
        g49.d.d("DoraGuideServiceImpl", "launchGuideSession created, id=" + r114.f335957a + ", page=" + r110 + ", filters=" + r112);
        return r114.f335957a;
    L12:
        e = move-exception;
        g49.d.c("DoraGuideServiceImpl", "launchGuideSession failed: " + e.getMessage(), e);
        return -1;
    }
}
