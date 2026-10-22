package com.larus.camera.contract;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\bJ \u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/larus/camera/contract/DefultCameraServiceImpl;", "Lcom/larus/camera/contract/ICameraServiceDiff;", "<init>", "()V", "init", "", "isHideAlbumCover", "", "()Ljava/lang/Boolean;", "isHideSlideAlbumEntrance", "doAfterPreCameraRelease", "intent", "Landroid/content/Intent;", "action", "Lkotlin/Function0;", "finishActivitiesBeforeCaptureFirstLaunch", "canRetryOpenCamera", "maxRetryOpenCameraTimeMS", "", "camera_contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefultCameraServiceImpl implements ICameraServiceDiff {
    public DefultCameraServiceImpl() {
    }

    @Override // com.larus.camera.contract.ICameraServiceDiff
    public final boolean canRetryOpenCamera() {
        return false;
    }

    @Override // com.larus.camera.contract.ICameraServiceDiff
    public final void finishActivitiesBeforeCaptureFirstLaunch() {
    }

    @Override // com.larus.camera.contract.ICameraServiceDiff
    public final void init() {
    }

    @Override // com.larus.camera.contract.ICameraServiceDiff
    public final Boolean isHideAlbumCover() {
        return null;
    }

    @Override // com.larus.camera.contract.ICameraServiceDiff
    public final Boolean isHideSlideAlbumEntrance() {
        return null;
    }

    @Override // com.larus.camera.contract.ICameraServiceDiff
    public final int maxRetryOpenCameraTimeMS() {
        return 0;
    }

    @Override // com.larus.camera.contract.ICameraServiceDiff
    public final void doAfterPreCameraRelease(Intent r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        r101.invoke();
    }
}
