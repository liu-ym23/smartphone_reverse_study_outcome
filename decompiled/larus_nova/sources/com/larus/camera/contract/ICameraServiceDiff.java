package com.larus.camera.contract;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J \u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/larus/camera/contract/ICameraServiceDiff;", "", "init", "", "isHideAlbumCover", "", "()Ljava/lang/Boolean;", "isHideSlideAlbumEntrance", "doAfterPreCameraRelease", "intent", "Landroid/content/Intent;", "action", "Lkotlin/Function0;", "finishActivitiesBeforeCaptureFirstLaunch", "canRetryOpenCamera", "maxRetryOpenCameraTimeMS", "", "camera_contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICameraServiceDiff {
    boolean canRetryOpenCamera();

    void doAfterPreCameraRelease(Intent r100, Function0<Unit> r101);

    void finishActivitiesBeforeCaptureFirstLaunch();

    void init();

    Boolean isHideAlbumCover();

    Boolean isHideSlideAlbumEntrance();

    int maxRetryOpenCameraTimeMS();
}
