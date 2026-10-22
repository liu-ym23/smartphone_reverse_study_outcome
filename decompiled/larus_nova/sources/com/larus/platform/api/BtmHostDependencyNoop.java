package com.larus.platform.api;

import android.app.Application;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/larus/platform/api/BtmHostDependencyNoop;", "Lcom/larus/platform/api/IBtmHostDependency;", "<init>", "()V", "minimizeInit", "", "app", "Landroid/app/Application;", "setKevaProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "Lkotlin/Function0;", "", "isHostBtmInited", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BtmHostDependencyNoop implements IBtmHostDependency {
    public BtmHostDependencyNoop() {
    }

    @Override // com.larus.platform.api.IBtmHostDependency
    public final void a(mv8.c r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
    }

    @Override // com.larus.platform.api.IBtmHostDependency
    public final void minimizeInit(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "app");
    }
}
