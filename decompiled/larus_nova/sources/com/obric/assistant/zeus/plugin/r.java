package com.obric.assistant.zeus.plugin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.Zeus;

/* JADX INFO: loaded from: classes.dex */
public final class r implements com.volcengine.zeus.activity.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f395066a;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b implements com.volcengine.zeus.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f395067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f395068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ r f395069c;

        @Override // com.volcengine.zeus.c
        public final void onLoadSuccess() {
            Activity r100 = AppHost.f326268a.a().getCurrentActivity();
            FLogger.f375446a.i("ZeusStartActivityFallback", "plugin load success, try relaunch activity " + this.f395067a.getComponent() + ", currentActivity = " + r100);
            if (r100 == null) goto L5;
            r100.startActivity(this.f395068b);
        L5:
            this.f395069c.f395066a = false;
        }

        @Override // com.volcengine.zeus.c
        public final void a(String r100, long r101) {
            FLogger.f375446a.i("ZeusStartActivityFallback", "plugin load timeout, won't relaunch activity " + this.f395067a.getComponent());
            this.f395069c.f395066a = false;
        }

        @Override // com.volcengine.zeus.c
        public final void b(String r100, String r101) {
            FLogger.f375446a.i("ZeusStartActivityFallback", "plugin load failed, won't relaunch activity " + this.f395067a.getComponent());
            this.f395069c.f395066a = false;
        }

        public b(Intent r100, Intent r101, r r102) {
            this.f395067a = r100;
            this.f395068b = r101;
            this.f395069c = r102;
        }
    }

    static {
    }

    public r() {
    }

    @Override // com.volcengine.zeus.activity.c
    public final void a(String r100, Intent r101) {
        boolean r102 = false;
        if (r101 == null) goto L5;
        r102 = r101.getBooleanExtra("__zeus_relaunch_from_callback", false);
    L5:
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("zeus start activity failed, component = ");
        if (r101 == null) goto L8;
        ComponentName r105 = r101.getComponent();
    L9:
        r104.append(r105);
        r104.append(", isRelaunch = ");
        r104.append(r102);
        r103.w("ZeusStartActivityFallback", r104.toString());
        IObricLaunchService r106 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r106 == null) goto L12;
        r106.startLauncherIntent();
    L12:
        if (r101 != null) goto L14;
        return;
    L14:
        if (r102 == false) goto L17;
        return;
    L17:
        if (this.f395066a == false) goto L19;
        return;
    L19:
        this.f395066a = true;
        Intent r107 = new Intent(r101);
        r107.putExtra("__zeus_relaunch_from_callback", true);
        Zeus.runAfterLoad(r100, new b(r101, r107, this), 60000);
        return;
    L8:
        r105 = null;
        goto L9
    }
}
