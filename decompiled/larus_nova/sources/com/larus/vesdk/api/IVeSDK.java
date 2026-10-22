package com.larus.vesdk.api;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.bmhome.upload.k;
import com.larus.camera.impl.ui.component.capture.scan.d;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.platform.model.camera.ve.VeCameraInputParam;
import com.larus.vesdk.impl.camera.VeCameraImpl;
import com.tencent.connect.share.QzonePublish;
import java.util.Map;
import kotlin.Metadata;
import pq9.h;
import pq9.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J#\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J$\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u001aH&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u001aH&J3\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00030\u001fH&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0012H&J0\u0010%\u001a\u00020&2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020+H&J2\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00122\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000300H&J.\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u000105H&J\u001e\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u0001052\u0006\u00102\u001a\u00020\u0012H&J\b\u00107\u001a\u00020\u0003H&J\n\u00108\u001a\u0004\u0018\u000109H&¨\u0006:"}, d2 = {"Lcom/larus/vesdk/api/IVeSDK;", "", "checkInit", "", "startVeInitAsync", "level", "", "timeoutMs", "", "(Ljava/lang/Integer;J)V", "loadVesdkModelFromGecko", "getCamera", "Lcom/larus/platform/model/camera/ve/IVeCamera;", "activity", "Landroid/app/Activity;", "param", "Lcom/larus/platform/model/camera/ve/VeCameraInputParam;", "savePhotoToCameraDir", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "sensorOrientation", "callback", "Lcom/larus/platform/model/camera/ve/ISaveBitmapResultCallback;", "hasTxtOnImage", "localFilePath", "Lcom/larus/platform/api/IVeSdkService$IVeOCRCallback;", "scanQrCode", "uri", "Landroid/net/Uri;", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "cancelTransCoding", LocationMonitorConst.IDENTIFIER, "transcodeVideo", "", QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, "outPath", "transcodeParam", "Lcom/larus/platform/model/camera/ve/VideoTranscodeParam;", "Lcom/larus/platform/api/IVeSdkService$IVideoEditorCallback;", "getFrames", "originVideoInfo", "Lcom/larus/platform/api/IVeSdkService$SROriginVideoInfo;", "inputVideoPath", "Lkotlin/Function2;", "setMetaData", "srcPath", "dstPath", "metadata", "", "getMetaData", "initEffectPlatform", "getEffectPlatformService", "Lcom/larus/platform/api/IFlowEffectPlatformService;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IVeSDK {
    void a(Integer r100, long r101);

    void b();

    void c();

    boolean d(String r100, String r101, Map<String, String> r102);

    void e();

    VeCameraImpl f(FragmentActivity r100, VeCameraInputParam r101);

    Map<String, String> g(String r100);

    void h(String r100);

    void i(Uri r100, d r101);

    void j(Bitmap r100, CameraCaptureViewModel.f r101);

    String k(Bitmap r100, int r101, h r102);

    boolean l(String r100, String r101, String r102, l r103, k r104);
}
