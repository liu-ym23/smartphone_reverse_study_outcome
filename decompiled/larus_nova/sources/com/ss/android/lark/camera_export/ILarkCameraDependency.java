package com.ss.android.lark.camera_export;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H&J\"\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/camera_export/ILarkCameraDependency;", "", "getCKCamera", "", "activity", "Landroid/app/Activity;", "param", "Lcom/ss/android/lark/camera_export/CameraParam;", "callback", "Lcom/ss/android/lark/camera_export/ICameraIntentCallback;", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onTakeMedia", "path", "", "camera", "saveCameraResultToGallery", "openPhotoEditor", "requestCode", "", "onEditPhotoResult", "bundle", "Landroid/os/Bundle;", "lark-camera-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILarkCameraDependency {
    void getCKCamera(Activity r100, CameraParam r101, ICameraIntentCallback r102);

    void onCreate(Activity r100);

    void onDestroy(Activity r100);

    void onEditPhotoResult(Activity r100, Bundle r101, String r102);

    void onTakeMedia(Activity r100, String r101, String r102);

    void openPhotoEditor(Activity r100, String r101, int r102);

    void saveCameraResultToGallery(String r100);
}
