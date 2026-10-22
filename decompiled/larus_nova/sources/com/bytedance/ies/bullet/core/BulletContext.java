package com.bytedance.ies.bullet.core;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import com.bytedance.ies.bullet.secure.HybridSecureManager;
import com.bytedance.ies.bullet.service.base.i0;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.BulletMonitor;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes19.dex */
public final class BulletContext implements i0 {
    public Uri A;
    public boolean B;
    public boolean C;
    public ArgusContainerDelegate D;
    public boolean E;
    public Boolean F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f246433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f246434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AbsBulletMonitorCallback f246435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f246436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile t36.d f246437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f246438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t36.j f246439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f246440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Scenes f246441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Components f246442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Uri f246443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.ies.bullet.service.base.o f246444l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public s f246445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<s> f246446n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.ies.bullet.core.kit.bridge.f f246447o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public IBridge3Registry f246448p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile a36.a f246449q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public q26.h f246450r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f246451s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final n f246452t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j f246453u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final o f246454v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f246455w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final m f246456x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final l f246457y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final d f246458z;

    @Override // com.bytedance.ies.bullet.service.base.i0
    public final void release() {
        this.f246445m = null;
        this.f246446n.clear();
        this.f246453u.f246511a = null;
        this.f246454v.f246566c = null;
        this.f246450r = null;
        this.f246444l = null;
        b(null);
        this.f246447o = null;
        this.f246448p = null;
        ArgusContainerDelegate r100 = this.D;
        if (r100 == null) goto L10;
        BaseEventCenter r101 = r100.f245619a.f245842e;
        r101.getClass();
        int r102 = CommonUtils.f246248a;
        CoroutineScope r103 = r101.b();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        CoroutineContext r104 = r103.getCoroutineContext();
        Job.Key r105 = Job.Key;
        Job r106 = (Job) r104.get(r105);
        if (r106 == null) goto L7;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L7:
        CoroutineScope r107 = r101.c();
        Intrinsics.checkNotNullParameter(r107, "<this>");
        Job r108 = (Job) r107.getCoroutineContext().get(r105);
        if (r108 == null) goto L10;
        Job.DefaultImpls.cancel$default(r108, null, 1, null);
    L10:
        this.D = null;
    }

    public final com.bytedance.ies.bullet.base.utils.logger.a a() {
        return (com.bytedance.ies.bullet.base.utils.logger.a) this.f246434b.getValue();
    }

    public final String getSessionId() {
        String r100 = this.f246433a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("sessionId");
        return null;
    }

    public BulletContext() {
        this.f246434b = LazyKt.lazy(new BulletContext$logContext$2(this));
        this.f246435c = BulletMonitor.f247943a.invoke();
        this.f246436d = new k(0);
        this.f246438f = "default_bid";
        t36.d r100 = this.f246437e;
        if (r100 != null) goto L5;
        Lazy<SchemaService> r101 = SchemaService.f248116f;
        r100 = SchemaService.a.a().b(this.f246438f, Uri.EMPTY);
    L5:
        this.f246439g = new t36.j(r100);
        this.f246441i = Scenes.Card;
        this.f246442j = Components.View;
        this.f246446n = new ArrayList();
        this.f246451s = LazyKt.lazy(new BulletContext$iBulletAbility$2(this));
        this.f246452t = new n();
        this.f246453u = new j();
        this.f246454v = new o();
        this.f246455w = new e();
        this.f246456x = new m();
        Intrinsics.checkNotNullParameter(this, "mContext");
        this.f246457y = new l();
        this.f246458z = new d();
        Lazy<HybridSecureManager> r102 = HybridSecureManager.f247741c;
        this.D = HybridSecureManager.a.a().c();
    }

    public final Context getContext() {
        return this.f246440h;
    }

    public BulletContext(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f246434b = LazyKt.lazy(new BulletContext$logContext$2(this));
        this.f246435c = BulletMonitor.f247943a.invoke();
        this.f246436d = new k(0);
        this.f246438f = "default_bid";
        t36.d r101 = this.f246437e;
        if (r101 != null) goto L5;
        Lazy<SchemaService> r102 = SchemaService.f248116f;
        r101 = SchemaService.a.a().b(this.f246438f, Uri.EMPTY);
    L5:
        this.f246439g = new t36.j(r101);
        this.f246441i = Scenes.Card;
        this.f246442j = Components.View;
        this.f246446n = new ArrayList();
        this.f246451s = LazyKt.lazy(new BulletContext$iBulletAbility$2(this));
        this.f246452t = new n();
        this.f246453u = new j();
        this.f246454v = new o();
        this.f246455w = new e();
        this.f246456x = new m();
        Intrinsics.checkNotNullParameter(this, "mContext");
        this.f246457y = new l();
        this.f246458z = new d();
        Lazy<HybridSecureManager> r103 = HybridSecureManager.f247741c;
        this.D = HybridSecureManager.a.a().c();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f246433a = r100;
    }

    public final void b(Context r100) {
        s26.d r101 = s26.d.f540305c;
        m0 r102 = (m0) s26.d.f540305c.c(m0.class);
        if (r102 == null) goto L5;
        r102.a0();
    L5:
        this.f246440h = r100;
        if ((r100 instanceof Activity) == true) goto L8;
        return;
    L8:
        if ((r100 instanceof LifecycleOwner) == false) goto L14;
        m0 r103 = (m0) s26.d.f540305c.c(m0.class);
        if (r103 == null) goto L15;
        r103.a0();
        return;
    L15:
        return;
    }
}
