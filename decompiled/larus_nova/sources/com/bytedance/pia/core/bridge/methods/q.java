package com.bytedance.pia.core.bridge.methods;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class q implements i47.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n.c f266213a;

    @Override // i47.d
    public final boolean isForMainFrame() {
        return true;
    }

    @Override // i47.d
    public final Map<String, String> getOptions() {
        return this.f266213a.c();
    }

    @Override // i47.d
    public final Map<String, String> getRequestHeaders() {
        return this.f266213a.a();
    }

    @Override // i47.d
    public final Uri getUrl() {
        return UriProtector.parse(this.f266213a.d());
    }

    public q(n.c r100) {
        this.f266213a = r100;
    }
}
