package com.bytedance.ee.bear.bitable.preload;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import com.bytedance.ee.bear.bitable.load.dataloader.BitableAppLoader;
import com.bytedance.ee.bear.bitable.preload.bean.BitableOfflineResultModel;
import com.bytedance.ee.bear.bitable.preload.util.BitablePreloadBridgeUtil;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements BitableAppLoader.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppLoader f214992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableAppLoader.AppResourceType f214993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableAppPreloadPlugin.GetFirstScreenDataParams f214994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BitableAppPreloadPlugin f214995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ m f214996e;

    @Override // com.bytedance.ee.bear.bitable.load.dataloader.BitableAppLoader.c
    public final void a(BitableAppData r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        BitableAppLoader.a r101 = this.f214992a.k(this.f214993b);
        BitableAppPreloadPlugin.GetFirstScreenDataParams r102 = this.f214994c;
        if (r102 == null) goto L5;
        String r103 = r102.getToken();
    L7:
        if (Intrinsics.areEqual(r103, r100.getToken()) == true) goto L10;
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214995d, r101, "Token not match", false), null), this.f214996e);
        tt5.a.k("BitableAppPreloadPlugin", "Token not match");
        return;
    L10:
        BitableAppPreloadPlugin.GetFirstScreenDataParams r104 = this.f214994c;
        if (r104 == null) goto L13;
        String r105 = r104.getPageID();
    L15:
        if (Intrinsics.areEqual(r105, r100.getPageID()) == true) goto L18;
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214995d, r101, "PageID not match", false), null), this.f214996e);
        tt5.a.k("BitableAppPreloadPlugin", "PageID not match, request pageID: " + r105 + ", data pageID: " + r100.getPageID());
        return;
    L18:
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(true, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214995d, r101, null, true), r100.getDataJSON()), this.f214996e);
        tt5.a.h("BitableAppPreloadPlugin", "Successfully returned first screen data");
        return;
    L13:
        r105 = null;
        goto L15
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.load.dataloader.BitableAppLoader.c
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        BitableAppLoader.a r101 = this.f214992a.k(this.f214993b);
        String r102 = r100.getMessage();
        if (r102 != null) goto L5;
        r102 = "No cached data available";
    L5:
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, BitableAppPreloadPlugin.access$buildPrefetchMessageJson(this.f214995d, r101, r102, false), null), this.f214996e);
        tt5.a.k("BitableAppPreloadPlugin", "No cached first screen data available: ".concat(r102));
    }

    public e(BitableAppLoader r100, BitableAppLoader.AppResourceType r101, BitableAppPreloadPlugin.GetFirstScreenDataParams r102, BitableAppPreloadPlugin r103, m r104) {
        this.f214992a = r100;
        this.f214993b = r101;
        this.f214994c = r102;
        this.f214995d = r103;
        this.f214996e = r104;
    }
}
