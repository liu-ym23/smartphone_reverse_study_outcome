package com.ss.android.lark.framework.assembly.rust;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import com.bytedance.lark.office_sdk_im_android.Office_sdk_imKt;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.appcontext.applifecycle.LifecycleHandler;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.framework.assembly.rust.bridge.OfficeSdkFeedCardProviderImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class InitImSdkTask extends AsyncLaunchTask {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f425669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Provider<IAppStateSyncService> f425670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Provider<com.bytedance.lark.sdk.refactor.n> f425671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Provider<c3c.d.b> f425672f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Provider<c3c.d.InterfaceC0400d> f425673g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public gpb.a f425674h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Provider<epb.a> f425675i;

    public class a implements com.ss.android.lark.appcontext.applifecycle.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InitImSdkTask f425676a;

        public a(InitImSdkTask r100) {
            this.f425676a = r100;
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.t
        public final void a(Activity r100) {
            if (com.ss.android.lark.featuregating.b.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L5;
            this.f425676a.f425670d.get().a(true);
            return;
        L5:
            com.ss.android.lark.rustinfrabridge.appstatesync.service.impl.b.C5276b.f439683a.a(true);
        }
    }

    public class b extends com.ss.android.lark.appcontext.applifecycle.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InitImSdkTask f425677a;

        public b(InitImSdkTask r100) {
            this.f425677a = r100;
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            if (com.ss.android.lark.featuregating.b.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L5;
            this.f425677a.f425670d.get().a(true);
            return;
        L5:
            com.ss.android.lark.rustinfrabridge.appstatesync.service.impl.b.C5276b.f439683a.a(true);
        }
    }

    public class c implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InitImSdkTask f425678a;

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public c(InitImSdkTask r100) {
            this.f425678a = r100;
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r100) {
            if (r100 >= 40) goto L5;
            return;
        L5:
            if (com.larksuite.framework.utils.z.e(LarkContext.getApplication()) == true) goto L7;
            return;
        L7:
            if (com.ss.android.lark.featuregating.b.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L9;
            this.f425678a.f425670d.get().b();
            return;
        L9:
            com.ss.android.lark.rustinfrabridge.appstatesync.service.impl.b.C5276b.f439683a.b();
        }
    }

    public interface d {
        void onInitFinish();
    }

    public final gpb.a j() {
        if (this.f425674h != null) goto L6;
        this.f425674h = (gpb.a) ApiUtils.getApi(gpb.a.class);
    L6:
        return this.f425674h;
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r110) {
        int r100 = Process.getThreadPriority(Process.myTid());
        Process.setThreadPriority(-4);     // Catch: Throwable -> L16
        Log.i("InitUtil", "start init Im sdk");     // Catch: Throwable -> L16
        gpb.a r101 = (gpb.a) ApiUtils.getApi(gpb.a.class);     // Catch: Throwable -> L16
        jcb.b.c().preload();     // Catch: Throwable -> L16
        f r102 = new f(this.f425672f.get(), this.f425673g.get());     // Catch: Throwable -> L16
        String r103 = ((epb.a) ApiUtils.getApi(epb.a.class)).getDeviceIdFromLocal();     // Catch: Throwable -> L16
        int r104 = r101.oldSdkEnv();     // Catch: Throwable -> L16
        r101.envType();     // Catch: Throwable -> L16
        String r105 = r101.getUserUnit();     // Catch: Throwable -> L16
        String r106 = r101.getTenantBrand();     // Catch: Throwable -> L16
        ApkUtil.getAppVersionName(r110);     // Catch: Throwable -> L16
        r102.a(r110, r103, r104, r105, r106);     // Catch: Throwable -> L16
        a r111 = new a(this);     // Catch: Throwable -> L16
        ((CopyOnWriteArrayList) LifecycleHandler.f408816a).add(r111);     // Catch: Throwable -> L16
        LifecycleHandler.f408819d = new b(this);     // Catch: Throwable -> L16
        c r112 = new c(this);     // Catch: Throwable -> L16
        ConcurrentLinkedDeque<ComponentCallbacks2> r107 = LifecycleHandler.f408821f;     // Catch: Throwable -> L16
        if (r107.contains(r112) == true) goto L6;
        r107.add(r112);     // Catch: Throwable -> L16
    L6:
        Process.setThreadPriority(r100);
        j().registerEnvChangeListener(new h(this));
        Object r113 = com.ss.android.lark.appcontext.applifecycle.b.f408824b;
        com.ss.android.lark.appcontext.applifecycle.b r114 = com.ss.android.lark.appcontext.applifecycle.b.a.f408826a;
        g r108 = new g();
        Map<Object, Object> r115 = r114.f408825a;
        ConcurrentHashMap r116 = (ConcurrentHashMap) r115;
        r116.put(r108, com.ss.android.lark.appcontext.applifecycle.b.f408824b);
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L9;
    L11:
        Iterator r117 = ((ArrayList) this.f425669c).iterator();
    L13:
        if (r117.hasNext() == false) goto L15;
        ((d) r117.next()).onInitFinish();
        goto L13
    L15:
        return;
    L9:
        if (LarkAppContext.inst().buildConfig().isOfficeSDKImIntegrated() == false) goto L11;
        Application r118 = LarkContext.getApplication();
        int r109 = com.ss.android.lark.framework.assembly.rust.bridge.a.f425690a;
        Intrinsics.checkNotNullParameter(r118, "application");
        Log.i("OfficeSdkBridgeRegister", "register molten bridge");
        Office_sdk_imKt.officeSdkRegisterHostSetting(new com.ss.android.lark.framework.assembly.rust.bridge.b(r118));
        Office_sdk_imKt.officeSdkRegisterFeedCardProvider(new OfficeSdkFeedCardProviderImpl(r118));
    L16:
        th = move-exception;
        Process.setThreadPriority(r100);
        throw th;
    }

    @Inject
    public InitImSdkTask(Provider<IAppStateSyncService> r100, Provider<com.bytedance.lark.sdk.refactor.n> r101, Provider<c3c.d.b> r102, Provider<c3c.d.InterfaceC0400d> r103, Provider<epb.a> r104) {
        this.f425669c = new ArrayList();
        this.f425670d = r100;
        this.f425671e = r101;
        this.f425672f = r102;
        this.f425673g = r103;
        this.f425675i = r104;
    }
}
