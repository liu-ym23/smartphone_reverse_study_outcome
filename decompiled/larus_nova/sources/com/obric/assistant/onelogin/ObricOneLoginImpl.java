package com.obric.assistant.onelogin;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ContentProviderClient;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.account.base.api.UserAction;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.login.ObricLoginType;
import com.obric.assistant.login.e0;
import com.obric.assistant.login.f0;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.matrix.platform.sdk.ones.account.AppGlobals;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.ss.android.token.TokenFactory;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0004\u001a!$'\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eH\u0016J\u0016\u0010\u0015\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\tH\u0002R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/assistant/onelogin/ObricOneLoginImpl;", "Lcom/obric/assistant/onelogin/IObricOneLogin;", "<init>", "()V", "createObricLoginRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "initOAccountLoginState", "", "isMainActivityStarted", "", "setMainActivityStarted", "getOneLoginActivity", "", "getXttTokenMap", "", "hasInitOAccount", "pendingInitActionLock", "", "pendingInitAction", "", "Lkotlin/Function0;", "waitInitOAccount", "init", "drainPendingInitAction", "registerOAccountStatusListener", "oAccountStatusListener", "com/obric/assistant/onelogin/ObricOneLoginImpl$oAccountStatusListener$1", "Lcom/obric/assistant/onelogin/ObricOneLoginImpl$oAccountStatusListener$1;", "postQueryOLoginAndOneLogin", "registerAccountEventReceiver", "registerLogoutProcessor", "registerNetworkAvailableListener", "logger", "com/obric/assistant/onelogin/ObricOneLoginImpl$logger$1", "Lcom/obric/assistant/onelogin/ObricOneLoginImpl$logger$1;", "bridge", "com/obric/assistant/onelogin/ObricOneLoginImpl$bridge$1", "Lcom/obric/assistant/onelogin/ObricOneLoginImpl$bridge$1;", "doubaoAccountStatusListener", "com/obric/assistant/onelogin/ObricOneLoginImpl$doubaoAccountStatusListener$1", "Lcom/obric/assistant/onelogin/ObricOneLoginImpl$doubaoAccountStatusListener$1;", "doubaoAccountRemovedListener", "Lcom/larus/account/base/api/IMultiAccountService$AccountRemovedListener;", "settingsListener", "Lcom/bytedance/news/common/settings/SettingsUpdateListener;", "updateEnterpriseAccountSecureSetting", "isEnterpriseAccount", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOneLoginImpl implements IObricOneLogin {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f390882j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f390883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f390884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Function0<Unit>> f390885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f390886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f390887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f390888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f390889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k f390890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l f390891i;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class b {
        public b() {
        }
    }

    public static final class c implements n38.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricOneLoginImpl f390892a;

        public c(ObricOneLoginImpl r100) {
            this.f390892a = r100;
        }

        @Override // n38.j
        public final void a(n38.a r110) {
            Intrinsics.checkNotNullParameter(r110, "event");
            ObricOneLoginImpl.f(this.f390892a, false);
            f0.f390252a.getClass();
            Intrinsics.checkNotNullParameter(r110, "event");
            String r100 = r110.f516979b.f516994b;
            com.obric.assistant.login.u.f390269d.getClass();
            com.obric.assistant.login.u r101 = com.obric.assistant.login.u.f390270e;
            ObricLoginType r102 = r101.f390273c;
            FLogger.f375446a.i("ObricLoginStrategyCenter", "handleDoubaoAccountOffline, scene: " + r110.f516981d + ", offlineSecUserId: " + r100 + ", lastLoginType: " + r102);
            Iterator<T> r103 = f0.f390255d.iterator();
        L4:
            if (r103.hasNext() == false) goto L8;
            Object r104 = r103.next();
            if (((com.obric.assistant.login.v) r104).a(r102) == false) goto L4;
        L9:
            com.obric.assistant.login.v r105 = (com.obric.assistant.login.v) r104;
            FLogger r106 = FLogger.f375446a;
            StringBuilder r107 = new StringBuilder("handleDoubaoAccountOffline, lastLoginType: ");
            r107.append(r102);
            r107.append(", strategy: ");
            if (r105 == null) goto L12;
            String r108 = r105.getClass().getSimpleName();
        L13:
            r107.append(r108);
            r106.i("ObricLoginStrategyCenter", r107.toString());
            if (r105 == null) goto L16;
            r105.c(r110, r101);
        L16:
            com.obric.assistant.login.u.f390269d.getClass();
            com.obric.assistant.login.u.a.a();
            IObricNetworkService r111 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
            if (r111 == null) goto L23;
            r111.clearOmniTasks(MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", "logout"), TuplesKt.to("stop_scene", "logout")}), null);
            return;
        L23:
            return;
        L12:
            r108 = null;
            goto L13
        L8:
            r104 = null;
            goto L9
        }

        @Override // n38.j
        public final void b(n38.a r110) {
            Intrinsics.checkNotNullParameter(r110, "event");
            q38.a r100 = ILoginService.f286097a.getAccountInfo();
            ObricOneLoginImpl r101 = this.f390892a;
            if (r100.f531528a == true) goto L5;
        L7:
            boolean r102 = false;
        L8:
            ObricOneLoginImpl.f(r101, r102);
            f0.f390252a.getClass();
            Intrinsics.checkNotNullParameter(r110, "event");
            com.obric.assistant.login.u.f390269d.getClass();
            com.obric.assistant.login.u r103 = com.obric.assistant.login.u.a.a();
            Iterator<T> r104 = f0.f390255d.iterator();
        L9:
            Unit r105 = null;
            if (r104.hasNext() == false) goto L14;
            Object r106 = r104.next();
            if (((com.obric.assistant.login.v) r106).a(r103.f390273c) == false) goto L9;
        L15:
            com.obric.assistant.login.v r107 = (com.obric.assistant.login.v) r106;
            FLogger r108 = FLogger.f375446a;
            StringBuilder r109 = new StringBuilder("handleDoubaoAccountOnline, loginType: ");
            r109.append(r103.f390273c);
            r109.append(", strategy: ");
            if (r107 == null) goto L18;
            String r111 = r107.getClass().getSimpleName();
        L19:
            r109.append(r111);
            r109.append(", scene: ");
            r109.append(r110.f516981d);
            r108.i("ObricLoginStrategyCenter", r109.toString());
            if (r107 == null) goto L22;
            r107.b(r110);
        L22:
            IObricNetworkService r112 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
            if (r112 == null) goto L25;
            r112.clearOmniTasks(MapsKt.mapOf(TuplesKt.to("stop_scene", "clear_login_success")), null);
        L25:
            vaa.b.f553985a.getClass();
            Intrinsics.checkNotNullParameter(r110, "event");
            if (r110.f516980c == UserAction.ACCOUNT_SWITCH) goto L28;
        L30:
            q38.a r113 = ILoginService.f286097a.getAccountInfo();
            if (r113.f531528a == true) goto L33;
        L35:
            boolean r114 = false;
        L36:
            r108.i("ObricAccountTaskCleaner", "shouldCleanNonMainTasks by current account, shouldClean=" + r114 + ", isLogin=" + r113.f531528a + ", isEnterprise=" + r113.f531534g + ", action=" + r110.f516980c + ", businessScene=" + r110.f516981d);
        L37:
            if (r114 == true) goto L39;
            r108.i("ObricAccountTaskCleaner", "cleanNonMainTasksAfterAccountChanged ignored, action=" + r110.f516980c + ", businessScene=" + r110.f516981d);
            return;
        L39:
            List<Activity> r115 = AppHost.f326268a.a().g();
            ListIterator<Activity> r116 = r115.listIterator(r115.size());
        L41:
            if (r116.hasPrevious() == false) goto L51;
            Activity r117 = r116.previous();
            String r118 = r117.getClass().getName();
            if (Intrinsics.areEqual(r118, "com.larus.home.impl.MainActivity") == false) goto L45;
        L48:
            boolean r119 = true;
        L49:
            if (r119 == false) goto L41;
        L52:
            Activity r120 = r117;
            if (r120 == null) goto L55;
            Integer r121 = Integer.valueOf(r120.getTaskId());
        L56:
            FLogger.f375446a.i("ObricAccountTaskCleaner", "cleanNonMainTasksAfterAccountChanged, mainTaskId=" + r121 + ", activitySize=" + r115.size());
            Iterator<T> r122 = r115.iterator();
        L58:
            if (r122.hasNext() == false) goto L110;
            Activity r123 = (Activity) r122.next();
            int r124 = r123.getTaskId();
            if (r121 == null) goto L65;
            if (r124 == r121.intValue()) goto L58;
        L65:
            if (r123.isFinishing() == true) goto L58;
            FLogger.f375446a.i("ObricAccountTaskCleaner", "finishNonMainActivity, activity=" + r123.getClass().getName() + ", taskId=" + r123.getTaskId() + ", mainTaskId=" + r121);
            Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L69
            r123.finish();     // Catch: Throwable -> L69
            Object r126 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L69
        L71:
            Throwable r127 = Result.m9452exceptionOrNullimpl(r126);
            if (r127 == null) goto L58;
            FLogger.f375446a.w("ObricAccountTaskCleaner", "finishNonMainActivity failed, activity=".concat(r123.getClass().getName()), r127);
        L69:
            th = move-exception;
            Result.Companion r128 = Result.Companion;
            r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L71
        L110:
            Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L102
            Object r130 = AppHost.f326268a.getApplication().getSystemService("activity");     // Catch: Throwable -> L102
            if ((r130 instanceof ActivityManager) == false) goto L77;
            ActivityManager r131 = (ActivityManager) r130;     // Catch: Throwable -> L102
        L78:
            if (r131 == null) goto L100;
            List<ActivityManager.AppTask> r132 = r131.getAppTasks();     // Catch: Throwable -> L102
            if (r132 == null) goto L100;
            Iterator<T> r133 = r132.iterator();     // Catch: Throwable -> L102
        L83:
            if (r133.hasNext() == false) goto L99;
            ActivityManager.AppTask r134 = (ActivityManager.AppTask) r133.next();     // Catch: Throwable -> L102
            ActivityManager.RecentTaskInfo r135 = r134.getTaskInfo();     // Catch: Throwable -> L102
            if (r135 != null) goto L88;
            Integer r136 = null;
        L91:
            if (r136 != null) goto L92;
            FLogger.f375446a.i("ObricAccountTaskCleaner", "skip finishAndRemoveTask, taskInfo is null, mainTaskId=" + r121);     // Catch: Throwable -> L102
            goto L83
        L92:
            int r137 = r136.intValue();     // Catch: Throwable -> L102
            if (r121 == null) goto L97;
            if (r137 == r121.intValue()) goto L83;
        L97:
            FLogger.f375446a.i("ObricAccountTaskCleaner", "finishAndRemoveTask, taskId=" + r137 + ", mainTaskId=" + r121);     // Catch: Throwable -> L102
            r134.finishAndRemoveTask();     // Catch: Throwable -> L102
            goto L83
        L88:
            if (Build.VERSION.SDK_INT < 29) goto L90;
            r136 = Integer.valueOf(r135.taskId);     // Catch: Throwable -> L102
            goto L91
        L90:
            r136 = Integer.valueOf(r135.id);     // Catch: Throwable -> L102
            goto L91
        L99:
            r105 = Unit.INSTANCE;     // Catch: Throwable -> L102
        L100:
            Object r138 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L102
        L104:
            Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
            if (r139 == null) goto L139;
            FLogger.f375446a.w("ObricAccountTaskCleaner", "cleanNonMainTasksAfterAccountChanged failed: " + r139.getMessage(), r139);
            return;
        L139:
            return;
        L77:
            r131 = null;
        L102:
            th = move-exception;
            Result.Companion r140 = Result.Companion;
            r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L104
        L55:
            r121 = null;
            goto L56
        L45:
            if (Intrinsics.areEqual(r118, "com.larus.bmhome.chat.ChatActivity") == true) goto L48;
            r119 = false;
            goto L49
        L51:
            r117 = null;
            goto L52
        L33:
            if (r113.f531534g == false) goto L35;
            r114 = true;
            goto L36
        L28:
            if (Intrinsics.areEqual(r110.f516981d, "login_by_account_switch") == false) goto L30;
            r108.i("ObricAccountTaskCleaner", "shouldCleanNonMainTasks true by account switch, action=" + r110.f516980c + ", businessScene=" + r110.f516981d);
            r114 = true;
            goto L37
        L18:
            r111 = null;
            goto L19
        L14:
            r106 = null;
            goto L15
        L5:
            if (r100.f531534g == false) goto L7;
            r102 = true;
            goto L8
        }
    }

    public static final class d implements cka.b {
        public d() {
        }

        @Override // cka.b
        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            FLogger.f375446a.d(r100, r101 + null);
        }

        @Override // cka.b
        public final void i(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            FLogger.f375446a.i(r100, r101 + null);
        }

        @Override // cka.b
        public final void w(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            FLogger.f375446a.w(r100, r101, null);
        }

        @Override // cka.b
        public final void e(String r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            FLogger.f375446a.e(r100, r101, r102);
        }
    }

    public static final class e implements cka.a {
        public e() {
        }

        @Override // cka.a
        public final void a() {
            f0 r100 = f0.f390252a;
            Activity r101 = com.bytedance.sdk.account.utils.d.b();
            r100.getClass();
            com.obric.assistant.login.u.f390269d.getClass();
            com.obric.assistant.login.u r102 = com.obric.assistant.login.u.a.a();
            FLogger r103 = FLogger.f375446a;
            r103.i("ObricLoginStrategyCenter", "handleOAccountLogin, context: " + f0.c(r102) + ", topActivity: " + r101);
            if ((r101 instanceof ObricOneLoginActivity) == false) goto L5;
        L8:
            r103.i("ObricLoginStrategyCenter", "handleOAccountLogin ignore, already in one login activity");
            return;
        L5:
            if ((r101 instanceof ObricOneLoginTransparentActivity) == true) goto L8;
            f0.d(r100, "o_account_login", null, null, null, 62);
        }

        @Override // cka.a
        public final void b() {
            FLogger.f375446a.i("ObricOneLoginImpl", "onAccountInfoUpdate");
        }

        @Override // cka.a
        public final void c(int r100) {
            f0.f390252a.getClass();
            com.obric.assistant.login.u.f390269d.getClass();
            com.obric.assistant.login.u r101 = com.obric.assistant.login.u.a.a();
            FLogger.f375446a.i("ObricLoginStrategyCenter", "handleOAccountLogout, loginType: " + r101.f390273c + ", logoutScene: " + r100);
            String r102 = r101.f390272b.f390249b;
            Function0 r103 = new e0();
            List<q38.b> r104 = IMultiAccountService.f286100a.g();
            ArrayList r105 = new ArrayList();
            Iterator<T> r106 = r104.iterator();
        L3:
            boolean r107 = false;
            if (r106.hasNext() == false) goto L12;
            Object r108 = r106.next();
            q38.b r109 = (q38.b) r108;
            if (r109.k() == false) goto L8;
        L10:
            if (r107 == false) goto L3;
            r105.add(r108);
            goto L3
        L8:
            if (Intrinsics.areEqual(r109.g(), r102) == true) goto L10;
            r107 = true;
            goto L10
        L12:
            f0.b(r105, r103, 0);
        }
    }

    static {
    }

    @Override // com.obric.assistant.onelogin.IObricOneLogin
    public final q97.a d() {
        if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L7;
        return null;
    L7:
        return new com.obric.assistant.onelogin.a();
    }

    public final void g() {
        Object r100 = this.f390884b;
        monitor-enter(r100);
        this.f390883a = true;     // Catch: Throwable -> L14
        List<Function0<Unit>> r101 = this.f390885c;     // Catch: Throwable -> L14
        this.f390885c = null;     // Catch: Throwable -> L14
        monitor-exit(r100);
        if (r101 != null) goto L9;
        return;
    L9:
        Iterator<T> r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        ((Function0) r102.next()).invoke();
        goto L11
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void h() {
        OAccount.f396900a.getClass();
        OAccount.c(true);
        com.obric.matrix.platform.sdk.ones.account.g r100 = OAccount.f396903d;
        ContentProviderClient r101 = null;
        com.obric.matrix.platform.sdk.ones.account.g r102 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
        r100 = null;
    L5:
        r100.getClass();
        dka.a.c("AccountSDK_OAccountManager", "getMatrixVersionInfo");
        ContentProviderClient r103 = com.obric.matrix.platform.sdk.ones.account.g.d(AppGlobals.a().getContentResolver());     // Catch: Throwable -> L18 Exception -> L20
        if (r103 != null) goto L55;
        Bundle r104 = null;
    L14:
        if (r104 != null) goto L16;
        r104 = new Bundle();     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = e;
    L51:
        dka.a.f469052a.e("AccountSDK_OAccountManager", "setLoginPhoneNumber error: ", e);     // Catch: Throwable -> L45
        if (r103 == null) goto L25;
        r103.close();
    L25:
        r104 = new Bundle();
    L26:
        boolean r105 = r104.containsKey("supportStaticBroadcast");
        boolean r106 = t9a.b.a().c("obric_feature_matrix_secure_listener");
        boolean r107 = r104.containsKey("supportSecureAccountStatusListener");
        FLogger.f375446a.i("ObricOneLoginImpl", "registerOAccountStatusListener supportStaticAccountStatusListener:" + r105 + ", enableSecureAccountStatusListener:" + r106 + ", supportSecureAccountStatusListener:" + r107);
        if (r105 == false) goto L40;
        OAccount r108 = OAccount.f396900a;
        e r109 = this.f390886d;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "accountStatusListener");
        com.obric.matrix.platform.sdk.ones.account.g r110 = OAccount.f396903d;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
    L32:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r109, "accountStatusListener");
        Set<cka.a> r111 = com.obric.matrix.platform.sdk.ones.account.g.f396947i;
        monitor-enter(r111);
        ((CopyOnWriteArraySet) r111).add(r109);     // Catch: Throwable -> L37
        monitor-exit(r111);
        return;
    L37:
        th = move-exception;
        throw th;
    L31:
        r102 = r110;
        goto L32
    L40:
        if (r106 == false) goto L43;
        if (r107 == false) goto L43;
        OAccount r112 = OAccount.f396900a;
        e r113 = this.f390886d;
        r112.getClass();
        OAccount.b(r113);
        return;
    L43:
        OAccount r114 = OAccount.f396900a;
        e r115 = this.f390886d;
        r114.getClass();
        OAccount.a(r115);
        return;
    L45:
        th = th;
        r101 = r103;
    L47:
        r103 = r101;
    L48:
        if (r103 == null) goto L50;
        r103.close();
    L50:
        throw th;
    L9:
        th = th;
    L16:
        if (r103 == null) goto L26;
        r103.close();
        goto L26
    L55:
        r104 = r103.call("com.obric.common.account.provider", "getMatrixVersionInfo", null, null);     // Catch: Throwable -> L9 Exception -> L11
        goto L14
    L20:
        e = e;
        r103 = null;
    L18:
        th = th;
        goto L47
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.assistant.onelogin.k] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.assistant.onelogin.l] */
    public ObricOneLoginImpl() {
        this.f390884b = new Object();
        this.f390885c = new ArrayList();
        this.f390886d = new e();
        this.f390887e = new d();
        this.f390888f = new b();
        this.f390889g = new c(this);
        this.f390890h = new k();
        this.f390891i = new l();
    }

    @Override // com.obric.assistant.onelogin.IObricOneLogin
    public final void b() {
        boolean r100 = t9a.b.a().b();
        FLogger r101 = FLogger.f375446a;
        r101.i("ObricOneLoginImpl", "initOAccountLoginState supportObricOneLogin:" + r100);
        if (r100 == true) goto L5;
        return;
    L5:
        OAccount r102 = OAccount.f396900a;
        AppHost.Companion r103 = AppHost.f326268a;
        Application r104 = r103.getApplication();
        d r105 = this.f390887e;
        b r106 = this.f390888f;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "application");
        Intrinsics.checkNotNullParameter(r105, "logger");
        Intrinsics.checkNotNullParameter(r106, "bridge");
        dka.a.c("AccountSDK_OAccount", "init, asyncInit: false");
        AtomicBoolean r107 = OAccount.f396901b;
        monitor-enter(r107);
        ConnectivityManager r108 = null;
        if (OAccount.f396901b.get() == false) goto L12;
        dka.a.f("AccountSDK_OAccount", "Init already.");     // Catch: Throwable -> L44
        monitor-exit(r107);
    L17:
        f0.f390252a.getClass();
        com.obric.assistant.login.u.f390269d.getClass();
        r101.i("ObricLoginStrategyCenter", "initLoginContext, context: " + f0.c(com.obric.assistant.login.u.a.a()));
        SettingsManager.registerListener(this.f390891i, true);
        SettingsManager.updateSettings(true);
        h();
        ILoginService r109 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r109 == null) goto L20;
        r109.f(this.f390889g, Boolean.FALSE);
    L20:
        IMultiAccountService.f286100a.i(this.f390890h);
        int r110 = Build.VERSION.SDK_INT;     // Catch: Exception -> L26
        if (r110 < 33) goto L24;
        e(r103.getApplication(), new ObricAccountEventReceiver(), new IntentFilter("com.obric.assistant.onelogin.OBRIC_ACCOUNT_EVENT"));     // Catch: Exception -> L26
    L50:
    L28:
        n r111 = new n();
        if (com.ss.android.token.p.f() == false) goto L33;
        TokenFactory r112 = TokenFactory.j();
        if (r112.f449668h == null) goto L33;
        r112.f449668h.f449774h = r111;
    L33:
        f0.f390252a.getClass();
        f0.a("logout_by_check_account_on_init");
        t0.a(new m());
        Object r113 = AppHost.f326268a.getApplication().getSystemService("connectivity");     // Catch: Exception -> L40
        if ((r113 instanceof ConnectivityManager) == false) goto L37;
        r108 = (ConnectivityManager) r113;     // Catch: Exception -> L40
    L37:
        if (r108 == null) goto L42;
        r108.registerNetworkCallback(new NetworkRequest.Builder().build(), new o());     // Catch: Exception -> L40
    L42:
        FLogger.f375446a.i("ObricOneLoginImpl", "initOAccountLoginState");
        g();
        return;
    L40:
        e = move-exception;
        FLogger.f375446a.e("ObricOneLoginImpl", "registerNetworkAvailableListener failed: " + e);
        goto L42
    L24:
        r101.e("ObricOneLoginImpl", "registerAccountEventReceiver failed, current build sdk: " + r110);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        FLogger.f375446a.e("ObricOneLoginImpl", "registerAccountEventReceiver failed: " + e, e);
        goto L28
    L12:
        Intrinsics.checkNotNullParameter(r105, "<set-?>");     // Catch: Throwable -> L44
        dka.a.f469053b = r105;     // Catch: Throwable -> L44
        OAccount r114 = OAccount.f396900a;     // Catch: Throwable -> L44
        com.obric.matrix.platform.sdk.ones.account.g r115 = com.obric.matrix.platform.sdk.ones.account.g.f396941c;     // Catch: Throwable -> L44
        OAccount.f396903d = r115;     // Catch: Throwable -> L44
        if (r115 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");     // Catch: Throwable -> L44
        r115 = null;
    L15:
        r115.e();     // Catch: Throwable -> L44
        OAccount.f396901b.set(true);     // Catch: Throwable -> L44
        OAccount.f396902c.countDown();     // Catch: Throwable -> L44
        OAccount.d();     // Catch: Throwable -> L44
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L44
        monitor-exit(r107);
    L44:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.onelogin.IObricOneLogin
    public final String c() {
        if (c0.d() == false) goto L7;
        return ObricOneLoginActivity.class.getName();
    L7:
        return ObricOneLoginTransparentActivity.class.getName();
    }

    @Override // com.obric.assistant.onelogin.IObricOneLogin
    public final void a(p r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        Object r101 = this.f390884b;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f390883a == true) goto L11;
        List<Function0<Unit>> r102 = this.f390885c;     // Catch: Throwable -> L15
        if (r102 == null) goto L10;
        ((ArrayList) r102).add(r100);     // Catch: Throwable -> L15
    L10:
        r100 = null;
    L11:
        monitor-exit(r101);
        if (r100 == null) goto L20;
        r100.invoke();
        return;
    }

    public static final void f(ObricOneLoginImpl r100, boolean r101) {
        r100.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(Settings.Secure.putInt(AppHost.f326268a.getApplication().getContentResolver(), "doubao_account_is_enterprise", r101 ? 1 : 0)));     // Catch: Throwable -> L5
    L8:
        if (Result.m9456isSuccessimpl(r103) == false) goto L10;
        ((Boolean) r103).booleanValue();
        FLogger.f375446a.i("ObricOneLoginImpl", "updateEnterpriseAccountSecureSetting success, value=" + (r101 ? 1 : 0));
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        FLogger.f375446a.e("ObricOneLoginImpl", "updateEnterpriseAccountSecureSetting failed, value=" + (r101 ? 1 : 0), r104);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void e(Application r100, ObricAccountEventReceiver r110, IntentFilter r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L29;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L29:
    L23:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L28;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, "com.obric.assistant.onelogin.permission.OBRIC_ACCOUNT_EVENT_RECEIVER", null, 2);
        return;
    L28:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L9;
    L21:
        r100.registerReceiver(r110, r111, "com.obric.assistant.onelogin.permission.OBRIC_ACCOUNT_EVENT_RECEIVER", null, 2);     // Catch: Exception -> L23
        return;
    L9:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L21;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 2, "com.obric.assistant.onelogin.permission.OBRIC_ACCOUNT_EVENT_RECEIVER", null, 5, r100).result;     // Catch: Exception -> L23
        if (r101 == 1) goto L19;
        if (r101 != 2) goto L14;
        new Intent();     // Catch: Exception -> L23
        return;
    L14:
        if (r101 == 3) goto L30;
        r100.registerReceiver(r110, r111, "com.obric.assistant.onelogin.permission.OBRIC_ACCOUNT_EVENT_RECEIVER", null, 2);     // Catch: Exception -> L23
        return;
    L30:
        return;
    L19:
        r100.registerReceiver(r110, r111, "com.obric.assistant.onelogin.permission.OBRIC_ACCOUNT_EVENT_RECEIVER", null, 2);     // Catch: Exception -> L23
    }
}
