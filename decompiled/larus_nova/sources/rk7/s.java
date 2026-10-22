package rk7;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements mm7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gk7.d f538371a;

    @Override // mm7.b
    public final void b() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogSDKApiManager", "addTokenInitListener onCommonPramsFirstSuccess() 回调");
        if (this.f538371a == null) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogSDKApiManager", "addTokenInitListener onCommonPramsFirstSuccess() 执行回调给宿主");
        this.f538371a.getClass();
        return;
    }

    @Override // mm7.b
    public final void c() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogSDKApiManager", "addTokenInitListener onUpdateCommonPrams()");
        if (this.f538371a == null) goto L11;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogSDKApiManager", "addTokenInitListener onUpdateCommonPrams() 执行回调给宿组");
        ((t) this.f538371a).getClass();
        com.bytedance.ug.sdk.luckydog.api.log.a.c("LuckyDogSDKApiManager", "onUpdateCommonPrams");
        bk7.a r100 = (bk7.a) hn7.d.b(bk7.a.class);
        if (r100 == null) goto L7;
        r100.d();
    L7:
        zl7.g r101 = (zl7.g) hn7.d.b(zl7.g.class);
        if (r101 == null) goto L12;
        com.bytedance.ug.sdk.luckydog.api.log.a.c("LuckyDogSDKApiManager", "onUpdateCommonPrams");
        r101.o();
        return;
    L12:
        return;
    }

    public s(t r100) {
        this.f538371a = r100;
    }

    @Override // mm7.b
    public final void a(boolean r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogSDKApiManager", "addTokenInitListener onSettingsStatusCallback() isEnable = " + r100);
        if (this.f538371a == null) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogSDKApiManager", "addTokenInitListener onSettingsStatusCallback() 执行回调给宿组");
        this.f538371a.getClass();
        return;
    }

    @Override // mm7.b
    public final void onTokenSuccess(boolean r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogSDKApiManager", "addTokenInitListener onTokenSuccess() isFirst = " + r100);
        if (this.f538371a == null) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogSDKApiManager", "addTokenInitListener onTokenSuccess() 执行回调 isFirst = " + r100);
        this.f538371a.getClass();
        return;
    }
}
