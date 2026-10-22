package com.ss.cast.plugin.dy.factory;

import c56.b;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.cast.plugin.dy.plugin.DefaultInstallListener;
import com.ss.cast.plugin.dy.plugin.IByteCastPlugin;
import com.ss.cast.plugin.dy.plugin.IPluginInstallCallback;
import com.ss.cast.plugin.dy.source.ByteCastSourceController;
import com.ss.cast.plugin.dy.source.ISourceController;
import java.util.Objects;

/* JADX INFO: loaded from: classes40.dex */
public abstract class SourceFactory {
    private static final String TAG = "SourceFactory";

    public static class a implements b {
        public a() {
        }

        @Override // c56.b
        public final void onFailed(String r100, boolean r101, int r102) {
        }
    }

    public SourceFactory() {
    }

    public static /* synthetic */ ISourceController a(ISourceController r100, ISourceController r101) {
        return lambda$bind$0(r100, r101);
    }

    private static /* synthetic */ ISourceController lambda$bind$0(ISourceController r100, ISourceController r101) {
        return r100;
    }

    public abstract IPluginInstallCallback getInstallCallback();

    public abstract b56.a getInstallConfig(boolean r100);

    public abstract IByteCastPlugin getPlugin();

    public abstract void setInstallCallback(IPluginInstallCallback r100);

    private b56.a addInstallMonitor(b56.a r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        a r101 = new a();
        b56.a.C0266a r102 = new b56.a.C0266a();
        r102.f17765a = r100.getContext();
        r102.f17771g = r100.f17763g;
        r102.f17767c = r100.f17759c;
        r102.f17766b = r100.f17758b;
        r102.f17770f = r101;
        r102.f17768d = r100.f17760d;
        r102.f17769e = r100.f17761e;
        return new b56.a(r102);
    }

    public b getInstallListener(IPluginInstallCallback r100) {
        return new DefaultInstallListener(getPlugin(), r100);
    }

    private void bind(final ISourceController r100, final ISourceController r101) {
        Objects.toString(r101);
        if (r101 != null) goto L5;
        return;
    L5:
        ServiceManager.get().bind(ISourceController.class, new yjc.b(r101, r100));
    }

    private synchronized ISourceController newControllerInst(ISourceController r100, b56.a r101) {
        monitor-enter(this);
        ByteCastSourceController r102 = null;
        if (r101 != null) goto L25;
        monitor-exit(this);
        return null;
    L25:
        IByteCastPlugin r103 = getPlugin();     // Catch: Throwable -> L22
        if (r103 != null) goto L13;
        monitor-exit(this);
        return null;
    L13:
        boolean r104 = r103.checkInitialized(false);     // Catch: Throwable -> L22
        r103.needUpgradePlugin(r101.f17758b);     // Catch: Throwable -> L22
        boolean r105 = r103.checkPluginInstalled(r101.f17758b);     // Catch: Throwable -> L22
        boolean r106 = r103.isPluginLoaded(r101.f17758b);     // Catch: Throwable -> L22
        if (r104 == false) goto L20;
        if (r105 == false) goto L19;
        if (r106 == true) goto L18;
        r103.preload(r101.f17758b);     // Catch: Throwable -> L22
    L18:
        r102 = new ByteCastSourceController();     // Catch: Throwable -> L22
        goto L20
    L19:
        r103.installPlugin(addInstallMonitor(r101));     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return r102;
    L22:
        th = move-exception;
        throw th;
    }

    public ISourceController newControllerInst(ISourceController r100, boolean r101) {
        return newControllerInst(r100, getInstallConfig(r101));
    }
}
