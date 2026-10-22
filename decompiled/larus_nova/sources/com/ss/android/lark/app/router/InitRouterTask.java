package com.ss.android.lark.app.router;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.component.navroute.NavRouter;
import com.suite.lark.component.navroute.args.b;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import unc.d;
import unc.e;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/app/router/InitRouterTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "navRouteGraphRepository", "Ljavax/inject/Provider;", "Lcom/suite/lark/component/navroute/graph/BaseNavRouteGraphRepository;", "navArgsTypeRepository", "Lcom/suite/lark/component/navroute/args/NavArgsTypeRepository;", "uriRouteMapping", "Lcom/suite/lark/component/router/mapping/IUriAnnotationRouterMapping;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "router-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitRouterTask extends AbstractLaunchTask<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Provider<com.suite.lark.component.navroute.graph.a> f408748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Provider<b> f408749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Provider<xnc.a> f408750e;

    public static final class a implements wnc.a {
        public a() {
        }
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r101 = System.currentTimeMillis();
        NavRouter.b(r100, new InitRouterTask$execute$1(this, r100));
        d r102 = snc.a.f542685a;
        xnc.a r103 = this.f408750e.get();
        Intrinsics.checkNotNullParameter("lark", "defaultScheme");
        Intrinsics.checkNotNullParameter(r103, "routerMapping");
        if (snc.a.f542685a == null) goto L5;
        Log.w("Router", "Don't initialize Router repeatedly!");
    L6:
        a r104 = new a();
        Intrinsics.checkNotNullParameter(r104, "listener");
        if (snc.a.f542685a != null) goto L9;
        Log.e("Router", "Router has not been initialized!");
    L9:
        d r105 = snc.a.f542685a;
        if (r105 == null) goto L12;
        Intrinsics.checkNotNullParameter(r104, "listener");
        r105.f550894e = r104;
    L12:
        Log.i("Router", "Router init cost " + (System.currentTimeMillis() - r101) + " ms");
        return;
    L5:
        d r106 = new d("lark", r103);
        snc.a.f542685a = r106;
        e r107 = new e(r106.f550892c, r106.f550893d);
        r107.f550896c.init();
        Intrinsics.checkNotNullParameter(r107, "handler");
        ((ArrayList) r106.f550885b).add(r107);
        goto L6
    }

    @Inject
    public InitRouterTask(Provider<com.suite.lark.component.navroute.graph.a> r100, Provider<b> r101, Provider<xnc.a> r102) {
        Intrinsics.checkNotNullParameter(r100, "navRouteGraphRepository");
        Intrinsics.checkNotNullParameter(r101, "navArgsTypeRepository");
        Intrinsics.checkNotNullParameter(r102, "uriRouteMapping");
        this.f408748c = r100;
        this.f408749d = r101;
        this.f408750e = r102;
    }
}
