package com.larus.live.impl.bridge.download;

import android.content.Context;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend;

/* JADX INFO: loaded from: classes30.dex */
public final class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f355768c;

    private final Context getContext() {
        r56.c r100 = r56.c.f536312g;
        r56.c r101 = r56.c.f536312g;
        if (r101 == null) goto L9;
        IHostContextDepend r102 = r101.f536314b;
        if (r102 == null) goto L9;
        Context r103 = r102.getApplicationContext();
        if (r103 == null) goto L9;
        return r103;
    L9:
        return (Context) provideContext(Context.class);
    }

    public c() {
        this.f355768c = "XDownloadFileMethod";
    }
}
