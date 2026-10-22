package com.larus.platform.api;

import android.app.Application;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0017\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/larus/platform/api/IBtmHostDependencyDelegate;", "Lcom/larus/platform/api/IBtmHostDependency;", "<init>", "()V", "isHostBtmInited", "", "minimizeInit", "", "app", "Landroid/app/Application;", "setKevaProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "Lkotlin/Function0;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IBtmHostDependencyDelegate implements IBtmHostDependency {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IBtmHostDependencyDelegate f364779b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBtmHostDependency f364780a;

    static {
        f364779b = new IBtmHostDependencyDelegate();
    }

    @Override // com.larus.platform.api.IBtmHostDependency
    public final void a(mv8.c r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f364780a.a(r100);
    }

    @Override // com.larus.platform.api.IBtmHostDependency
    public final void minimizeInit(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "app");
        this.f364780a.minimizeInit(r100);
    }

    private IBtmHostDependencyDelegate() {
        IBtmHostDependency r100 = (IBtmHostDependency) ServiceManager.get().getService(IBtmHostDependency.class);
        if (r100 != null) goto L5;
        r100 = new BtmHostDependencyNoop();
    L5:
        this.f364780a = r100;
    }
}
