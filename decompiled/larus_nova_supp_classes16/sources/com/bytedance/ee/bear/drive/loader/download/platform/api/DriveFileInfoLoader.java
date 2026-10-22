package com.bytedance.ee.bear.drive.loader.download.platform.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/DriveFileInfoLoader;", "Lcom/bytedance/ee/bear/drive/loader/IDriveFileInfoLoader;", "<init>", "()V", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "netService$delegate", "Lkotlin/Lazy;", "fetchFileInfo", "Lcom/bytedance/ee/bear/drive/callback/ICancelable;", "fileToken", "", "caller", "callback", "Lcom/bytedance/ee/bear/drive/callback/IDriveFileInfoCallBack;", "params", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/drive/FileInfoV1Puller$Params;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFileInfoLoader implements a85.a {
    private final Lazy netService$delegate;

    private final NetService getNetService() {
        return (NetService) this.netService$delegate.getValue();
    }

    public DriveFileInfoLoader() {
        this.netService$delegate = LazyKt.lazy(DriveFileInfoLoader$netService$2.INSTANCE);
    }

    public final h75.a fetchFileInfo(FileInfoV1Puller.Params r4, final h75.b r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        final io.reactivex.disposables.a r0 = new io.reactivex.disposables.a();
        r0.b(new FileInfoV1Puller(getNetService()).pull(r4).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribeWith(new AnonymousClass1(r5)));
        return new AnonymousClass3(r0);
    }

    @Override // a85.a
    public h75.a fetchFileInfo(String r9, String r10, h75.b r11) {
        Intrinsics.checkNotNullParameter(r9, "fileToken");
        Intrinsics.checkNotNullParameter(r11, "callback");
        return fetchFileInfo(new FileInfoV1Puller.Params(r9, null, FileInfoPuller.CALLER_EXPLORER, r10, null, null), r11);
    }
}
