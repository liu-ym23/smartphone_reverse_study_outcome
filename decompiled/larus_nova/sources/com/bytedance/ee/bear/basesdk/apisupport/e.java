package com.bytedance.ee.bear.basesdk.apisupport;

import android.content.Context;
import android.content.res.Configuration;
import com.bytedance.ee.bear.basesdk.api.IDarkMode;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements IDarkMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDarkMode f206549a;

    public e(IDarkMode r100) {
        this.f206549a = r100;
    }

    @Override // com.bytedance.ee.bear.basesdk.api.IDarkMode
    public final void a(Context r100, Configuration r101) {
        tt5.a.h("Apisupport", "api call: onConfigurationChanged");
        this.f206549a.a(r100, r101);
    }
}
