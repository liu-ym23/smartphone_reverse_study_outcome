package com.ss.android.bytedcert.dialog.controller.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.bytedcert.dialog.controller.base.ICameraController;
import com.ss.android.bytedcert.flow.cert.BytedCertFlow;
import com.ss.android.bytedcert.model.LiveInfo;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.bytedcert.video.VideoUploadActivity;
import com.ss.android.cert.manager.utils.thread.BCThread;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import osa.b;
import psa.a;
import qsa.p;
import ssa.f;

/* JADX INFO: loaded from: classes34.dex */
public class VideoRecordController implements ICameraController {
    private int cameraStartType;
    private final BytedCertFlow mFlow;
    private final Map<String, String> mParams;
    private String mReadContext;
    private String mVideoPath;
    private SDKCallBack.VideoRecordCallback mVideoRecordCallback;
    private boolean sGLPause;
    private boolean sLiveSDKRunning;

    @Override // com.ss.android.bytedcert.dialog.controller.base.ICameraController
    public b getCertInfo() {
        return this.mFlow.getCertInfo();
    }

    @Override // com.ss.android.bytedcert.dialog.controller.base.ICameraController
    public LiveInfo getLiveInfo() {
        return this.mFlow.getLiveInfo();
    }

    public a getRequestUtils() {
        return this.mFlow.getRequestUtils();
    }

    @Override // com.ss.android.bytedcert.dialog.controller.base.ICameraController
    public ThemeConfig getThemeConfig() {
        return this.mFlow.getThemeConfig();
    }

    @Override // com.ss.android.bytedcert.dialog.controller.base.ICameraController
    public boolean isLiveSdkPaused() {
        return !this.sLiveSDKRunning;
    }

    public void onDestroy() {
        if (this.mVideoPath == null) goto L6;
        new BCThread(new AnonymousClass4(this)).start();
        return;
    }

    @Override // com.ss.android.bytedcert.dialog.controller.base.ICameraController
    public int getCameraStartType() {
        return this.cameraStartType;
    }

    public String getReadContext() {
        return this.mReadContext;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    @Override // com.ss.android.bytedcert.dialog.controller.base.ICameraController
    public boolean isGLPause() {
        return this.sGLPause;
    }

    public VideoRecordController(BytedCertFlow r100) {
        this.mParams = new HashMap();
        this.mFlow = r100;
    }

    public static /* synthetic */ String access$000(VideoRecordController r100) {
        return r100.mVideoPath;
    }

    public static Bitmap getThumbBitmap(String r100) {
        MediaMetadataRetriever r101 = new MediaMetadataRetriever();
        r101.setDataSource(r100);     // Catch: Exception -> L6
    L5:
        return r101.getFrameAtTime(0);
    }

    public Map<String, String> appendCommonRequestParams(Map<String, String> r100) {
        if (r100 == null) goto L5;
        this.mParams.putAll(r100);
    L5:
        return this.mFlow.appendCommonRequestParams(this.mParams);
    }

    public void onVideoRecordFinish(BDResponse r100) {
        if (this.mVideoRecordCallback == null) goto L14;
        String r101 = null;
        if (TextUtils.isEmpty(this.mVideoPath) == false) goto L7;
    L12:
        this.mVideoRecordCallback.onFinish(r100, this.mVideoPath, r101);
        return;
    L7:
        if (r100.success == false) goto L11;
        Bitmap r102 = getThumbBitmap(this.mVideoPath);
        if (r102 == null) goto L12;
        r101 = p.a(r102, 400, 85);
        goto L12
    L11:
        final String r103 = this.mVideoPath;
        new BCThread(new AnonymousClass3(this, r103)).start();
        this.mVideoPath = null;
        goto L12
    }

    public void saveVideo(String r100) {
        this.mVideoPath = r100;
    }

    public void setCameraStartType(int r100) {
        this.cameraStartType = r100;
    }

    public void setGLPause(boolean r100) {
        this.sGLPause = r100;
    }

    public void setLiveSDKRunning(boolean r100) {
        this.sLiveSDKRunning = r100;
    }

    public void setReadContext(String r100) {
        this.mReadContext = r100;
    }

    public void onEvent(String r100, JSONObject r101) {
        this.mFlow.onEvent(r100, r101);
    }

    @Override // com.ss.android.bytedcert.dialog.controller.base.ICameraController
    public void setTimestamp(String r100, String r101) {
        this.mFlow.setTimestamp(r100, r101);
    }

    public void startVideoRecord(Context r100, Map<String, String> r101, String r102, String r110, SDKCallBack.VideoRecordCallback r111) {
        this.mVideoRecordCallback = r111;
        this.mParams.clear();
        this.mParams.putAll(r101);
        String r103 = this.mFlow.getFlowId();
        int r112 = VideoUploadActivity.f407648j;
        BytedCertSdkAbsActivity.y1(r100, -1, r110, new f(r103, r110, r102), new AnonymousClass1(this), new AnonymousClass2(this));
    }
}
