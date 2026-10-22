package com.ss.cast.plugin.dy.factory;

import b56.a;
import com.bytedance.ies.ugc.appcontext.AppContextManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.cast.plugin.dy.plugin.DefaultByteCastPlugin;
import com.ss.cast.plugin.dy.plugin.DefaultInstallCallback;
import com.ss.cast.plugin.dy.plugin.IByteCastPlugin;
import com.ss.cast.plugin.dy.plugin.IPluginInstallCallback;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class DouYinSourceFactory extends SourceFactory {
    private static final String TAG = "DouYinSourceFactory";
    private volatile IPluginInstallCallback callback;
    private volatile IByteCastPlugin castPlugin;
    private volatile a installConfig;

    @Override // com.ss.cast.plugin.dy.factory.SourceFactory
    public IPluginInstallCallback getInstallCallback() {
        if (this.callback != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.callback != null) goto L8;
        this.callback = new DefaultInstallCallback();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.callback;
    }

    @Override // com.ss.cast.plugin.dy.factory.SourceFactory
    public IByteCastPlugin getPlugin() {
        if (this.castPlugin != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.castPlugin != null) goto L8;
        this.castPlugin = new DefaultByteCastPlugin();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.castPlugin;
    }

    public DouYinSourceFactory() {
    }

    private static /* synthetic */ void lambda$getInstallConfig$0(int r100) {
    }

    @Override // com.ss.cast.plugin.dy.factory.SourceFactory
    public a getInstallConfig(boolean r100) {
        a.C0266a r101 = new a.C0266a();
        Lazy r102 = AppContextManager.f248843a;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        r101.f17765a = null;
        r101.f17767c = r100;
        r101.f17766b = "com.ss.android.ugc.aweme.bytecast";
        r101.f17770f = getInstallListener(getInstallCallback());
        r101.f17771g = new yjc.a();
        return new a(r101);
    }

    @Override // com.ss.cast.plugin.dy.factory.SourceFactory
    public synchronized void setInstallCallback(IPluginInstallCallback r100) {
        monitor-enter(this);
        this.callback = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
