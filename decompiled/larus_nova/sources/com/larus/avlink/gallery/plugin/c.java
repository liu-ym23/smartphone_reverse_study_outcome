package com.larus.avlink.gallery.plugin;

import com.larus.mirabridge.api.bean.PluginLoadBuilder;
import com.larus.mirabridge.api.pluginservice.IDoraPluginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements PluginLoadBuilder.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f292631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i<IDoraPluginService> f292632b;

    @Override // com.larus.mirabridge.api.bean.PluginLoadBuilder.b
    public final void onFailed() {
        if (this.f292631a.compareAndSet(false, true) == false) goto L6;
        this.f292632b.resumeWith(Result.m9449constructorimpl(null));
        return;
    }

    @Override // com.larus.mirabridge.api.bean.PluginLoadBuilder.b
    public final void onSuccess() {
        IDoraPluginService r100 = (IDoraPluginService) ServiceManager.get().getService(IDoraPluginService.class);
        f.b(r100);
        if (this.f292631a.compareAndSet(false, true) == false) goto L6;
        this.f292632b.resumeWith(Result.m9449constructorimpl(r100));
        return;
    }

    public c(AtomicBoolean r100, j r101) {
        this.f292631a = r100;
        this.f292632b = r101;
    }
}
