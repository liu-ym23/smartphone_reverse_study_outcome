package com.larus.common.location.impl;

import com.bytedance.bdlocation.utils.background.BackgroundProvider;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends BackgroundProvider {

    public static final class a implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f326330a;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            this.f326330a.onAppBackgroundSwitch(true);
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            this.f326330a.onAppBackgroundSwitch(false);
        }

        public a(d r100) {
            this.f326330a = r100;
        }
    }

    @Override // com.bytedance.bdlocation.utils.background.BackgroundProvider
    public final boolean isBackground() {
        return AppHost.f326268a.a().isAppBackground();
    }

    public d() {
        AppHost.f326268a.a().j(new a(this));
    }
}
