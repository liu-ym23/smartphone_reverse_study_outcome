package com.bytedance.sdk.account.platform;

import ua7.h;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements IPlatformBindAdapter.BindController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f269264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PlatformChangeBindAdapter.a f269265b;

    public class a extends sa7.h<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f269266a;

        public a(e r100) {
            this.f269266a = r100;
        }

        @Override // sa7.h
        public final void onSuccess(ua7.b r100) {
            PlatformChangeBindAdapter r101 = this.f269266a.f269265b.f269244a;
            r101.onChangeBindSuccess((h) r100);
        }

        @Override // sa7.h
        public final void onError(ua7.b r100, int r101) {
            PlatformChangeBindAdapter r102 = this.f269266a.f269265b.f269244a;
            r102.onChangeBindError((h) r100);
        }
    }

    @Override // com.bytedance.sdk.account.platform.IPlatformBindAdapter.BindController
    public final void doNext() {
        PlatformChangeBindAdapter r100 = this.f269265b.f269244a;
        r100.api.m(r100.platformId, r100.platform, this.f269264a.f549282s, PlatformChangeBindAdapter.access$100(r100), new a(this));
    }

    public e(PlatformChangeBindAdapter.a r100, h r101) {
        this.f269265b = r100;
        this.f269264a = r101;
    }
}
