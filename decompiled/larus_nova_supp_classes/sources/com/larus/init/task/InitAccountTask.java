package com.larus.init.task;

import android.app.NotificationManager;
import android.util.EventsUtils;
import android.util.Pair;
import bf6.d;
import com.bytedance.news.common.settings.SettingsManager;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.coreapi.ISecShareDataService;
import com.larus.account.saas.security.api.IAccountSecurityService;
import com.larus.account.saas.security.model.AccountSecurityEventType;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.applog.api.IApplog;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.taskskill.service.SkillServiceDelegate;
import com.larus.commercecredit.api.ICommerceCreditService;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.login.api.TouristManager;
import com.larus.minor.api.IMinorService;
import com.larus.pipo.pay.api.IPipoPayService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.spi.login.ILogoutSceneInterceptor;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.v2;
import hq9.x2;
import ic8.c0;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0003\u0011\u0019 \b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010$\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/init/task/InitAccountTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "tag", XmlPullParser.NO_NAMESPACE, "isFirst", XmlPullParser.NO_NAMESPACE, "scene", "getScene", "()Ljava/lang/String;", "firstStyle", "getFirstStyle", "runInternal", XmlPullParser.NO_NAMESPACE, "socialSettingsAccountStatusCallback", "com/larus/init/task/InitAccountTask$socialSettingsAccountStatusCallback$1", "Lcom/larus/init/task/InitAccountTask$socialSettingsAccountStatusCallback$1;", "writeSecShareAccountInfo", "secUserId", "userName", "avatarUrl", "preloadAppRes", "accountStatusCallback", "com/larus/init/task/InitAccountTask$accountStatusCallback$1", "Lcom/larus/init/task/InitAccountTask$accountStatusCallback$1;", "dispatchLogoutIfIntercepted", "event", "Lcom/larus/account/base/api/AccountStatusEvent;", "clearAllNotifications", "appBackgroundListener", "com/larus/init/task/InitAccountTask$appBackgroundListener$1", "Lcom/larus/init/task/InitAccountTask$appBackgroundListener$1;", "settingUpdateListener", "Lcom/bytedance/news/common/settings/SettingsUpdateListener;", "registerSettingsUpdate", "shouldDoraGUpdate", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitAccountTask extends d implements bg9.i {
    public final String a;
    public boolean b;
    public final String c;
    public final String d;
    public final e e;
    public final a f;
    public final b g;
    public final q h;

    public static final class a implements n38.j {
        public final /* synthetic */ InitAccountTask a;

        public a(InitAccountTask r1) {
            this.a = r1;
        }

        @Override // n38.j
        public final void a(n38.a r7) {
            Intrinsics.checkNotNullParameter(r7, "event");
            c0.a.evictAll();
            TouristManager.a.n();
            boolean r2 = false;
            IApplog.a.d(new Pair(0, 0L));
            this.a.getClass();
            String r0 = r7.d;
            Iterator r1 = ServiceManager.get().getServices(ILogoutSceneInterceptor.class).iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            Object r3 = r1.next();
            if (((ILogoutSceneInterceptor) r3).shouldIntercept(r0) == false) goto L4;
        L9:
            ILogoutSceneInterceptor r4 = (ILogoutSceneInterceptor) r3;
            if (r4 == null) goto L12;
            r4.a(r0);
        L12:
            if (r4 == null) goto L15;
            r2 = true;
        L15:
            if (Intrinsics.areEqual(r7.d, "logout_by_account_deletion") == false) goto L18;
            if (r2 == true) goto L18;
            RepoDispatcherDelegate.b.c().r(-1);
        L18:
            InitAccountTask.c(this.a);
            t0.a(new s());
            HomeService.a.T();
            return;
        L8:
            r3 = null;
            goto L9
        }

        @Override // n38.j
        public final void b(n38.a r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            c0.a.evictAll();
            RepoDispatcherDelegate.b.h().init();
            TouristManager.a.j();
            IApplog.Companion r0 = IApplog.a;
            ILoginService.Companion r2 = ILoginService.a;
            Integer r3 = Integer.valueOf(r2.getAccountInfo().e);
            Long r4 = StringsKt.toLongOrNull(r2.getAccountInfo().c);
            if (r4 == null) goto L5;
            long r5 = r4.longValue();
        L6:
            r0.d(new Pair(r3, Long.valueOf(r5)));
            InitAccountTask.c(this.a);
            if (AppHost.a.isOversea() == false) goto L12;
            IPipoPayService r1 = (IPipoPayService) ServiceManager.get().getService(IPipoPayService.class);
            if (r1 == null) goto L11;
            r1.init();
        L11:
            com.larus.bmhome.auth.a r6 = (com.larus.bmhome.auth.a) AuthModelDelegate.b.A().getValue();
            ap9.a r7 = ap9.a.a;
        L12:
            HomeService.a.T();
            IAccountSecurityService.a.h(new e48.d(AccountSecurityEventType.WAKE_UP_APP, r10.b.b, System.currentTimeMillis(), MapsKt.mapOf(TuplesKt.to("scene", r10.c.toString())), "InitAccountTask"));
            return;
        L5:
            r5 = 0;
            goto L6
        }
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ InitAccountTask a;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            ICommerceCreditService.a.getClass();
            ICommerceCreditService r0 = ICommerceCreditService.a.a();
            if (r0 == null) goto L5;
            r0.h("foreground", DowngradeSource.HOT_LAUNCH);
        L5:
            ICommerceMembershipService.a.getClass();
            ICommerceMembershipService r1 = ICommerceMembershipService.a.a();
            if (r1 == null) goto L8;
            r1.a("onAppForeground");
        L8:
            ICommerceMembershipService r2 = ICommerceMembershipService.a.a();
            if (r2 == null) goto L11;
            r2.g("LAUNCH");
        L11:
            q38.a r3 = ILoginService.a.getAccountInfo();
            boolean r4 = true;
            if (r3.a == false) goto L17;
            if ((!StringsKt.isBlank(r3.d)) == false) goto L17;
            IAccountSecurityService.a.h(new e48.d(AccountSecurityEventType.WAKE_UP_APP, r3.d, System.currentTimeMillis(), MapsKt.mapOf(TuplesKt.to("scene", "app_foreground")), "InitAccountTask"));
        L17:
            if (this.a.b == false) goto L19;
        L30:
            this.a.b = false;
            return;
        L19:
            if (Intrinsics.areEqual(AppHost.a.getApplication().getPackageName(), "com.larus.nova.dorag") == false) goto L25;
            IDoraAVLinkService r5 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
            if (r5 == null) goto L25;
            if (r5.E1(2) != true) goto L25;
        L26:
            if (r4 == false) goto L30;
            IDoraAVLinkService r6 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
            if (r6 == null) goto L30;
            r6.J0(2);
        L25:
            r4 = false;
            goto L26
        }

        public b(InitAccountTask r1) {
            this.a = r1;
        }
    }

    public static final class e implements n38.j {
        public e() {
        }

        @Override // n38.j
        public final void a(n38.a r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            ft9.k r0 = ft9.k.a;
            String r4 = r3.b.a;
            if ((!StringsKt.isBlank(r4)) == true) goto L6;
            r4 = null;
        L6:
            r0.getClass();
            ft9.k.a(r4);
        }

        @Override // n38.j
        public final void b(n38.a r9) {
            Intrinsics.checkNotNullParameter(r9, "event");
            ft9.k r0 = ft9.k.a;
            String r10 = r9.b.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r10, "uid");
            x2 r1 = null;
            if (StringsKt.isBlank(r10) == false) goto L5;
            ft9.k.a(null);
        L34:
            ft9.g.a();
            return;
        L5:
            Ref.BooleanRef r2 = new Ref.BooleanRef();
            Object r3 = ft9.k.e;
            monitor-enter(r3);
            Object r4 = ft9.k.d;     // Catch: Throwable -> L42
            monitor-enter(r4);     // Catch: Throwable -> L42
            v2 r5 = ft9.k.k;     // Catch: Throwable -> L39
            if (r5 == null) goto L12;
            Intrinsics.areEqual(r5.a, r10);     // Catch: Throwable -> L39
        L12:
            v2 r6 = new v2(r10, ft9.k.f.incrementAndGet());     // Catch: Throwable -> L39
            ft9.k.k = r6;     // Catch: Throwable -> L39
            ft9.k.l = null;     // Catch: Throwable -> L39
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L39
            monitor-exit(r4);     // Catch: Throwable -> L42
            x2 r11 = ft9.k.g(r10);     // Catch: Throwable -> L42
            if (r11 == null) goto L17;
            x2 r12 = x2.a(r11, r6);     // Catch: Throwable -> L42
        L18:
            monitor-enter(r4);     // Catch: Throwable -> L42
            boolean r8 = true;
            if (Intrinsics.areEqual(ft9.k.k, r6) == false) goto L22;
            ft9.k.l = r12;     // Catch: Throwable -> L36
            r1 = r12;
            boolean r13 = true;
        L23:
            Boolean r14 = Boolean.valueOf(r13);     // Catch: Throwable -> L36
            monitor-exit(r4);     // Catch: Throwable -> L42
            r2.element = r14.booleanValue();     // Catch: Throwable -> L42
            monitor-exit(r3);
            FLogger r15 = FLogger.a;
            StringBuilder r16 = new StringBuilder("beginSocialUserScope generation=");
            r16.append(r6.b);
            r16.append(" recreate=true installed=");
            r16.append(r2.element);
            r16.append(" cacheReady=");
            if (r1 != null) goto L31;
            r8 = false;
        L31:
            r16.append(r8);
            r15.i("SettingsManagerWrapper", r16.toString());
            if (r2.element == false) goto L34;
            ft9.k.b(r1);
            goto L34
        L22:
            r13 = false;
        L36:
            th = move-exception;
            throw th;     // Catch: Throwable -> L42
        L17:
            r12 = null;
            goto L18
        L39:
            th = move-exception;
            throw th;     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            throw th;
        }
    }

    @Override // bg9.i
    public final void runInternal() {
        IAccountService.Companion r0 = IAccountService.a;
        com.larus.init.task.accountsdk.c r1 = com.larus.init.task.accountsdk.c.a;
        r0.g();
        SkillServiceDelegate.a.a();
        ag9.a.a.execute(new r());
        ILoginService r2 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r2 == null) goto L5;
        r2.f(this.e, Boolean.TRUE);
    L5:
        ILoginService r3 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r3 == null) goto L8;
        r3.f(this.f, Boolean.FALSE);
    L8:
        AppHost.a.a().j(this.g);
        SettingsManager.registerListener(this.h, false);
        IMultiAccountService.a.init();
        FlowAccountSdk.h().b();
        ILoginService r4 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r4 == null) goto L11;
        r4.f(new c(this), Boolean.TRUE);
    L11:
        IMinorService.a.k(new d(this), Boolean.TRUE);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.init.task.q] */
    public InitAccountTask() {
        this.a = "INIT_ACCOUNT_TASK";
        this.b = true;
        this.c = "Basic";
        this.d = "asyncThreadWhenFirst";
        this.e = new e();
        this.f = new a(this);
        this.g = new b(this);
        this.h = new q();
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
        return this.c;
    }

    @Override // bg9.i
    public final String v() {
        return this.d;
    }

    public static final void c(InitAccountTask r1) {
        r1.getClass();
        Object r2 = AppHost.a.getApplication().getSystemService("notification");
        if ((r2 instanceof NotificationManager) == false) goto L5;
        NotificationManager r3 = (NotificationManager) r2;
    L6:
        if (r3 == null) goto L9;
        r3.cancelAll();
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static final void d(InitAccountTask r8, String r9, String r10, String r11) {
        r8.getClass();
        ISecShareDataService r12 = FlowAccountSdk.h();
        AppHost.Companion r0 = AppHost.a;
        r12.a(new b48.h(String.valueOf(r0.getAppId()), r0.getAppName(), r0.getApplication().getPackageName(), r9, r10, r11));
    }
}
