package com.bytedance.ee.bear.bitable.preload;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import com.bytedance.ee.bear.bitable.load.dataloader.BitableAppLoader;
import com.bytedance.ee.bear.bitable.preload.bean.BitableOfflineResultModel;
import com.bytedance.ee.bear.bitable.preload.util.BitablePreloadBridgeUtil;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements BitableAppLoader.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppPreloadPlugin.GetTableSsrDataParams f214997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableAppLoader f214998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableAppPreloadPlugin f214999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m f215000d;

    @Override // com.bytedance.ee.bear.bitable.load.dataloader.BitableAppLoader.c
    public final void a(BitableAppData r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        BitableAppPreloadPlugin.GetTableSsrDataParams r101 = this.f214997a;
        if (r101 == null) goto L5;
        String r102 = r101.getToken();
    L6:
        boolean r103 = !Intrinsics.areEqual(r102, r100.getToken());
        BitableAppPreloadPlugin.GetTableSsrDataParams r104 = this.f214997a;
        if (r104 == null) goto L9;
        String r105 = r104.getPageID();
    L10:
        boolean r106 = !Intrinsics.areEqual(r105, r100.getPageID());
        BitableAppLoader.a r107 = this.f214998b.k(BitableAppLoader.AppResourceType.TableSsrData);
        if (r103 == false) goto L14;
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214999c, r107, "Token not match", false), null), this.f215000d);
        tt5.a.k("BitableAppPreloadPlugin", "Token not match");
        return;
    L14:
        if (r106 == false) goto L17;
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214999c, r107, "PageID not match", false), null), this.f215000d);
        tt5.a.k("BitableAppPreloadPlugin", "PageID not match, request pageID: " + r105 + ", data pageID: " + r100.getPageID());
        return;
    L17:
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(true, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214999c, r107, null, true), r100.getDataJSON()), this.f215000d);
        tt5.a.h("BitableAppPreloadPlugin", "Successfully returned cached table ssr data");
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.load.dataloader.BitableAppLoader.c
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        BitableAppLoader.a r101 = this.f214998b.k(BitableAppLoader.AppResourceType.TableSsrData);
        String r102 = r100.getMessage();
        if (r102 != null) goto L5;
        r102 = "No cached data available";
    L5:
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214999c, r101, r102, false), null), this.f215000d);
        tt5.a.k("BitableAppPreloadPlugin", "No cached table ssr data available: ".concat(r102));
    }

    public f(BitableAppPreloadPlugin.GetTableSsrDataParams r100, BitableAppLoader r101, BitableAppPreloadPlugin r102, m r103) {
        this.f214997a = r100;
        this.f214998b = r101;
        this.f214999c = r102;
        this.f215000d = r103;
    }
}
