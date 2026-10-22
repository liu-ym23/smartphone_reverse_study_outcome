package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.bytedance.router.SmartRouter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bot.api.IBotRouteInterceptorService;
import com.larus.business.debug.api.IDebugOverseaService;
import com.larus.business.debug.api.IDebugService;
import com.larus.camera.api.IFlowCamera;
import com.larus.canvas.service.ICanvasService;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.commercemembership.impl.CommerceMembershipRouterInterceptor;
import com.larus.common.apphost.AppHost;
import com.larus.common.venue.api.IFlowCommonVenueService;
import com.larus.community.api.ICommunityService;
import com.larus.contextwindow.api.IContextWindowUsageService;
import com.larus.doc.api.IDocService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraRouterInterceptor;
import com.larus.e_commerce.api.ECommerceRouterInterceptor;
import com.larus.home.api.main.ILarkOfficeAppLinkInterceptorProvider;
import com.larus.home.api.route.HomeRouterServiceDelegate;
import com.larus.home.impl.route.c0;
import com.larus.home.impl.route.f0;
import com.larus.home.impl.sdk.d2;
import com.larus.ivykit.anniex.IContainerRedirectService;
import com.larus.livetutor.api.ILiveTutorService;
import com.larus.minor.api.IMinorService;
import com.larus.network.HttpConst;
import com.larus.office.card.urlpreview.IOfficeUrlPreviewActionInterceptorProvider;
import com.larus.office.card.urlpreview.OfficeUrlPreviewActionInterceptorProviderNoop;
import com.larus.office.container.api.IOfficeContainerService;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.n0;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.voicecall.api.VoiceCallRouterServiceDelegate;
import com.obric.assistant.spi.router.ObricRouterServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;
import p2a.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/larus/init/task/InitSmartRouterTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitSmartRouterTask extends d implements bg9.i {
    public static final /* synthetic */ int b = 0;
    public final String a;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        AppHost.Companion r0 = AppHost.a;
        SmartRouter.init(r0.getApplication());
        SmartRouter.setDebug(r0.isDebug());
        HttpConst.a.getClass();
        SmartRouter.configRouter(HttpConst.K).b(new String[]{"sslocal"});
        SmartRouter.setOnErrorListener(new i0());
        IMinorService.Companion r1 = IMinorService.a;
        q97.a r2 = r1.d();
        if (r2 == null) goto L5;
        SmartRouter.addInterceptor(r2);
    L5:
        q97.a r3 = r1.m();
        if (r3 == null) goto L8;
        SmartRouter.addInterceptor(r3);
    L8:
        ILarkOfficeAppLinkInterceptorProvider r4 = (ILarkOfficeAppLinkInterceptorProvider) ServiceManager.get().getService(ILarkOfficeAppLinkInterceptorProvider.class);
        if (r4 == null) goto L13;
        com.larus.home.impl.g r5 = r4.getInterceptor();
        if (r5 == null) goto L13;
        SmartRouter.addInterceptor(r5);
    L13:
        int r6 = com.larus.office.card.urlpreview.c.a;
        OfficeUrlPreviewActionInterceptorProviderNoop r7 = (IOfficeUrlPreviewActionInterceptorProvider) ServiceManager.get().getService(IOfficeUrlPreviewActionInterceptorProvider.class);
        if (r7 != null) goto L16;
        r7 = new OfficeUrlPreviewActionInterceptorProviderNoop();
    L16:
        q97.a r8 = r7.a();
        if (r8 == null) goto L19;
        SmartRouter.addInterceptor(r8);
    L19:
        SmartRouter.addInterceptor(new f0());
        q97.a r9 = n0.a.a();
        if (r9 == null) goto L22;
        SmartRouter.addInterceptor(r9);
    L22:
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r10 = ICommerceMembershipService.a.a();
        if (r10 == null) goto L27;
        CommerceMembershipRouterInterceptor r11 = r10.p();
        if (r11 == null) goto L27;
        SmartRouter.addInterceptor(r11);
    L27:
        IContextWindowUsageService.a.getClass();
        IContextWindowUsageService r12 = (IContextWindowUsageService) IContextWindowUsageService.a.b.getValue();
        if (r12 == null) goto L32;
        q97.a r13 = r12.c();
        if (r13 == null) goto L32;
        SmartRouter.addInterceptor(r13);
    L32:
        IUgcAIGCService.Companion r14 = IUgcAIGCService.a;
        q97.a r15 = r14.k();
        if (r15 == null) goto L35;
        SmartRouter.addInterceptor(r15);
    L35:
        HomeRouterServiceDelegate r16 = HomeRouterServiceDelegate.a;
        r16.b();
        IBotRouteInterceptorService.Companion r17 = IBotRouteInterceptorService.a;
        SmartRouter.addInterceptor(r17.a());
        SmartRouter.addInterceptor(r17.b());
        r16.d();
        r16.j();
        VoiceCallRouterServiceDelegate.a.a();
        SmartRouter.addInterceptor(((IFlowCamera) ServiceManager.get().getService(IFlowCamera.class)).u());
        IUgcAIGCService r18 = (IUgcAIGCService) ServiceManager.get().getService(IUgcAIGCService.class);
        q97.a r19 = null;
        if (r18 == null) goto L38;
        q97.a r20 = r18.a();
    L39:
        SmartRouter.addInterceptor(r20);
        r16.h();
        q97.a r21 = ICanvasService.a.b();
        if (r21 == null) goto L42;
        SmartRouter.addInterceptor(r21);
    L42:
        r16.i();
        q97.a r22 = r14.d();
        if (r22 == null) goto L45;
        SmartRouter.addInterceptor(r22);
    L45:
        IFlowCommonVenueService r23 = (IFlowCommonVenueService) ServiceManager.get().getService(IFlowCommonVenueService.class);
        if (r23 == null) goto L50;
        q97.a r24 = r23.c();
        if (r24 == null) goto L50;
        SmartRouter.addInterceptor(r24);
    L50:
        IDocService r25 = (IDocService) ServiceManager.get().getService(IDocService.class);
        if (r25 == null) goto L53;
        q97.a r26 = r25.H9();
    L54:
        SmartRouter.addInterceptor(r26);
        IDocService r28 = (IDocService) ServiceManager.get().getService(IDocService.class);
        if (r28 == null) goto L57;
        q97.a r29 = r28.W9();
    L58:
        SmartRouter.addInterceptor(r29);
        IDocService r30 = (IDocService) ServiceManager.get().getService(IDocService.class);
        if (r30 == null) goto L61;
        q97.a r31 = r30.J9();
    L62:
        SmartRouter.addInterceptor(r31);
        IDocService r32 = (IDocService) ServiceManager.get().getService(IDocService.class);
        if (r32 == null) goto L65;
        q97.a r33 = r32.Y9();
    L66:
        SmartRouter.addInterceptor(r33);
        IDocService r34 = (IDocService) ServiceManager.get().getService(IDocService.class);
        if (r34 == null) goto L69;
        q97.a r35 = r34.L9();
    L70:
        SmartRouter.addInterceptor(r35);
        IDocService r36 = (IDocService) ServiceManager.get().getService(IDocService.class);
        if (r36 == null) goto L73;
        q97.a r37 = r36.aa();
    L74:
        SmartRouter.addInterceptor(r37);
        IDocService r38 = (IDocService) ServiceManager.get().getService(IDocService.class);
        if (r38 == null) goto L77;
        q97.a r39 = r38.V9();
    L78:
        SmartRouter.addInterceptor(r39);
        IDoraService r40 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r40 == null) goto L81;
        DoraRouterInterceptor r41 = r40.E0();
    L82:
        SmartRouter.addInterceptor(r41);
        r16.g();
        IDebugService r42 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r42 == null) goto L85;
        q97.a r43 = r42.D();
    L86:
        SmartRouter.addInterceptor(r43);
        IDebugOverseaService r44 = (IDebugOverseaService) ServiceManager.get().getService(IDebugOverseaService.class);
        if (r44 == null) goto L89;
        q97.a r45 = r44.a();
    L90:
        SmartRouter.addInterceptor(r45);
        ICommunityService r46 = (ICommunityService) ServiceManager.get().getService(ICommunityService.class);
        if (r46 == null) goto L93;
        q97.a r47 = r46.q1();
    L94:
        SmartRouter.addInterceptor(r47);
        ObricRouterServiceDelegate.b.a();
        ICommunityService r48 = (ICommunityService) ServiceManager.get().getService(ICommunityService.class);
        if (r48 == null) goto L97;
        q97.a r49 = r48.t1();
    L98:
        SmartRouter.addInterceptor(r49);
        ILiveTutorService r50 = (ILiveTutorService) ServiceManager.get().getService(ILiveTutorService.class);
        if (r50 == null) goto L101;
        r19 = r50.a();
    L101:
        SmartRouter.addInterceptor(r19);
        r16.a();
        r16.c();
        SmartRouter.addInterceptor(new v());
        IFlowSdkDepend r51 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r51 == null) goto L104;
        r51.R();
        d2 r52 = d2.b;
        SmartRouter.addInterceptor(new c0());
    L104:
        IContainerRedirectService r53 = (IContainerRedirectService) ServiceManager.get().getService(IContainerRedirectService.class);
        if (r53 == null) goto L109;
        og9.a r54 = r53.a();
        if (r54 == null) goto L109;
        SmartRouter.addInterceptor(r54);
    L109:
        SmartRouter.addInterceptor(new ECommerceRouterInterceptor());
        SmartRouter.addInterceptor(new n89.b());
        SmartRouter.addInterceptor(new mi9.b());
        SmartRouter.addInterceptor(new gl6.a());
        r16.f();
        IOfficeContainerService r55 = (IOfficeContainerService) ServiceManager.get().getService(IOfficeContainerService.class);
        if (r55 == null) goto L115;
        xn9.a r56 = r55.c();
        if (r56 == null) goto L116;
        SmartRouter.addInterceptor(r56);
        return;
    L116:
        return;
    L115:
        return;
    L97:
        r49 = null;
        goto L98
    L93:
        r47 = null;
        goto L94
    L89:
        r45 = null;
        goto L90
    L85:
        r43 = null;
        goto L86
    L81:
        r41 = null;
        goto L82
    L77:
        r39 = null;
        goto L78
    L73:
        r37 = null;
        goto L74
    L69:
        r35 = null;
        goto L70
    L65:
        r33 = null;
        goto L66
    L61:
        r31 = null;
        goto L62
    L57:
        r29 = null;
        goto L58
    L53:
        r26 = null;
        goto L54
    L38:
        r20 = null;
        goto L39
    }

    public InitSmartRouterTask() {
        this.a = "Basic";
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.a;
    }
}
