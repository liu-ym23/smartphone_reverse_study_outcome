package com.bytedance.ee.bear.bitable.preload;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import com.bytedance.ee.bear.bitable.load.dataloader.BitableAppLoader;
import com.bytedance.ee.bear.bitable.preload.bean.BitableOfflineResultModel;
import com.bytedance.ee.bear.bitable.preload.util.BitablePreloadBridgeUtil;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements BitableAppLoader.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppLoader f214987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableAppLoader.AppResourceType f214988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableAppPreloadPlugin.GetClientVarsParams f214989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BitableAppPreloadPlugin f214990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ m f214991e;

    @Override // com.bytedance.ee.bear.bitable.load.dataloader.BitableAppLoader.c
    public final void a(BitableAppData r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        BitableAppLoader.a r101 = this.f214987a.k(this.f214988b);
        BitableAppPreloadPlugin.GetClientVarsParams r102 = this.f214989c;
        if (r102 == null) goto L5;
        String r103 = r102.getToken();
    L7:
        if (Intrinsics.areEqual(r103, r100.getToken()) == true) goto L10;
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214990d, r101, "Token not match", false), null), this.f214991e);
        tt5.a.k("BitableAppPreloadPlugin", "Token not match");
        return;
    L10:
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(true, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214990d, r101, null, true), r100.getDataJSON()), this.f214991e);
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.load.dataloader.BitableAppLoader.c
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        BitableAppLoader.a r101 = this.f214987a.k(this.f214988b);
        String r102 = r100.getMessage();
        if (r102 != null) goto L5;
        r102 = "No cached data available";
    L5:
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214990d, r101, r102, false), null), this.f214991e);
    }

    public d(BitableAppLoader r100, BitableAppLoader.AppResourceType r101, BitableAppPreloadPlugin.GetClientVarsParams r102, BitableAppPreloadPlugin r103, m r104) {
        this.f214987a = r100;
        this.f214988b = r101;
        this.f214989c = r102;
        this.f214990d = r103;
        this.f214991e = r104;
    }
}
