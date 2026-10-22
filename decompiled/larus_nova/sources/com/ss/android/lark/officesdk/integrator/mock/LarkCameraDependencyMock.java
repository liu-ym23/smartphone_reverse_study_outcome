package com.ss.android.lark.officesdk.integrator.mock;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.camera_export.ICameraIntentCallback;
import com.ss.android.lark.camera_export.ILarkCameraDependency;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(ILarkCameraDependency.class)
public class LarkCameraDependencyMock implements ILarkCameraDependency {
    private static final String TAG = "OfficeSdkMock";

    public LarkCameraDependencyMock() {
    }

    @Override // com.ss.android.lark.camera_export.ILarkCameraDependency
    public void getCKCamera(Activity r100, CameraParam r101, ICameraIntentCallback r102) {
    }

    @Override // com.ss.android.lark.camera_export.ILarkCameraDependency
    public void onCreate(Activity r100) {
    }

    @Override // com.ss.android.lark.camera_export.ILarkCameraDependency
    public void onDestroy(Activity r100) {
    }

    @Override // com.ss.android.lark.camera_export.ILarkCameraDependency
    public void onEditPhotoResult(Activity r100, Bundle r101, String r102) {
    }

    @Override // com.ss.android.lark.camera_export.ILarkCameraDependency
    public void onTakeMedia(Activity r100, String r101, String r102) {
    }

    @Override // com.ss.android.lark.camera_export.ILarkCameraDependency
    public void openPhotoEditor(Activity r100, String r101, int r102) {
    }

    @Override // com.ss.android.lark.camera_export.ILarkCameraDependency
    public void saveCameraResultToGallery(String r100) {
    }
}
