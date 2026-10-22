package com.bytedance.pia.core.setting;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements i47.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f266299a;

    public d(Uri r100) {
        this.f266299a = r100;
    }

    @Override // i47.d
    public final /* synthetic */ Map getOptions() {
        return null;
    }

    @Override // i47.d
    public final /* synthetic */ Map getRequestHeaders() {
        return null;
    }

    @Override // i47.d
    public final /* synthetic */ boolean isForMainFrame() {
        return false;
    }

    @Override // i47.d
    public final Uri getUrl() {
        return this.f266299a;
    }
}
