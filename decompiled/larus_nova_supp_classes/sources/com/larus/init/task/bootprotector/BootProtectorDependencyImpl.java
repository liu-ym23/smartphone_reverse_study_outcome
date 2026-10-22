package com.larus.init.task.bootprotector;

import android.content.Context;
import android.util.EventsUtils;
import com.larus.account.base.api.IAccountService;
import com.larus.applog.api.IApplog;
import com.larus.bootprotector.BootProtectorDependency;
import com.larus.business.debug.api.IDebugService;
import com.larus.common.apphost.AppHost;
import com.larus.init.IAppLogInitiator;
import com.larus.init.task.InitSettingsTask;
import com.larus.init.task.accountsdk.c;
import com.larus.network.http.HttpExtKt;
import com.larus.network.m;
import com.obric.assistant.spi.bootprotector.ObricBootProtectorSPIServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nu8.a;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/larus/init/task/bootprotector/BootProtectorDependencyImpl;", "Lcom/larus/bootprotector/BootProtectorDependency;", "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "initBootProtectorLandingPageDependency", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "isDebug", XmlPullParser.NO_NAMESPACE, "()Z", "uid", "getUid", "()Ljava/lang/String;", "did", "getDid", "initTTNet", "initApplog", "initTTAccount", "initSettings", "exeUrgentCmdTask", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class BootProtectorDependencyImpl implements BootProtectorDependency {
    public final String a;

    @Override // com.larus.bootprotector.BootProtectorDependency
    public final void b() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        a.e(this.a, "exeUrgentCmdTask start");     // Catch: Throwable -> L4
        new InitUrgentCmdTask().runInternal();     // Catch: Throwable -> L4
        a.e(this.a, "exeUrgentCmdTask end");     // Catch: Throwable -> L4
        Object r1 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.m52exceptionOrNullimpl(r1);
        if (r2 == null) goto L12;
        a.c(this.a, "exeUrgentCmdTask failed!", r2);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final void c() {
        a.e(this.a, "initApplog start");
        AppHost.Companion r0 = AppHost.a;
        if (r0.isTestChannel() == false) goto L12;
        IDebugService r2 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L12;
        boolean r28 = true;
    L14:
        if (r0.isDebug() == false) goto L18;
        if (r28 == true) goto L18;
        boolean r29 = false;
    L32:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L25
        IAppLogInitiator r5 = (IAppLogInitiator) ServiceManager.get().getService(IAppLogInitiator.class);     // Catch: Throwable -> L25
        if (r5 == null) goto L22;
        r5.a(new v48.a(r0.getAppId(), r0.getAppName(), r0.getVersionCode(), r0.getVersionName(), r0.getUpdateVersionCode(), r0.getBuildChannel(), HttpExtKt.e().a, false, false, false, false, false, 100, 5000, 60000, false, false, false, 10, r29, r28));     // Catch: Throwable -> L25
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L23:
        Object r6 = Result.m49constructorimpl(r1);     // Catch: Throwable -> L25
    L27:
        Throwable r7 = Result.m52exceptionOrNullimpl(r6);
        if (r7 == null) goto L30;
        a.b(this.a, "initApplog fail " + r7);
    L30:
        a.e(this.a, "initApplog end");
        return;
    L22:
        r1 = null;
    L25:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m49constructorimpl(ResultKt.createFailure(th));
    L18:
        r29 = true;
        goto L32
    L7:
        if (r2.l() != true) goto L9;
        r3 = true;
    L12:
        r28 = false;
        goto L14
    }

    public final void d() {
        a.e(this.a, "initTTAccount start");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        IAccountService.Companion r1 = IAccountService.a;     // Catch: Throwable -> L5
        c r2 = c.a;     // Catch: Throwable -> L5
        r1.g();     // Catch: Throwable -> L5
        Object r3 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.m52exceptionOrNullimpl(r3);
        if (r4 == null) goto L10;
        a.b(this.a, "initTTAccount fail " + r4);
    L10:
        a.e(this.a, "initTTAccount end");
        return;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.bootprotector.BootProtectorDependency
    public final String getDid() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.m49constructorimpl(IApplog.a.getDeviceId());     // Catch: Throwable -> L4
    L7:
        if (Result.m55isFailureimpl(r1) == false) goto L10;
        r1 = XmlPullParser.NO_NAMESPACE;
    L10:
        return (String) r1;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.bootprotector.BootProtectorDependency
    public final String getUid() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.m49constructorimpl(IApplog.a.getUserID());     // Catch: Throwable -> L4
    L7:
        if (Result.m55isFailureimpl(r1) == false) goto L10;
        r1 = XmlPullParser.NO_NAMESPACE;
    L10:
        return (String) r1;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.bootprotector.BootProtectorDependency
    public final boolean isDebug() {
        AppHost.Companion r0 = AppHost.a;
        if (r0.isDebug() == false) goto L5;
    L8:
        return true;
    L5:
        if (r0.isTestChannel() == true) goto L8;
        return false;
    }

    public BootProtectorDependencyImpl() {
        this.a = "BootProtectorDepImpl";
    }

    @Override // com.larus.bootprotector.BootProtectorDependency
    public final void a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
        a.e(this.a, "initBootProtectorLandingPageDependency start");     // Catch: Throwable -> L15
        a.e(this.a, "initTTNet start");     // Catch: Exception -> L6 Throwable -> L15
        Lazy r7 = m.a;     // Catch: Exception -> L6 Throwable -> L15
        m.b(yo8.c.a, yo8.c.b, 0, null, 56);     // Catch: Exception -> L6 Throwable -> L15
        a.e(this.a, "initTTNet end");     // Catch: Exception -> L6 Throwable -> L15
    L8:
        c();     // Catch: Throwable -> L15
        ObricBootProtectorSPIServiceDelegate.b.c();     // Catch: Throwable -> L15
        d();     // Catch: Throwable -> L15
        a.e(this.a, "initSettings start");     // Catch: Exception -> L11 Throwable -> L15
        new InitSettingsTask().runInternal();     // Catch: Exception -> L11 Throwable -> L15
        a.e(this.a, "initSettings end");     // Catch: Exception -> L11 Throwable -> L15
    L13:
        a.e(this.a, "initBootProtectorLandingPageDependency end");     // Catch: Throwable -> L15
        Object r8 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r9 = Result.m52exceptionOrNullimpl(r8);
        if (r9 == null) goto L27;
        a.c(this.a, "initBootProtectorLandingPageDependency failed!", r9);
        return;
    L27:
        return;
    L11:
        e = move-exception;
        a.c(this.a, "initSettings failed!", e);     // Catch: Throwable -> L15
        goto L13
    L6:
        e = move-exception;
        a.c(this.a, "initTTNet failed!", e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r8 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
