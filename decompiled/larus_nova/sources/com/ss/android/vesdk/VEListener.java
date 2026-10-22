package com.ss.android.vesdk;

import android.graphics.Bitmap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class VEListener {

    public interface AudioCommonFilterListener {
        void onPreprocess(String r100, int r101, byte[] r102);
    }

    public static final enum DownloadErrorCode extends Enum<DownloadErrorCode> {
        public static final DownloadErrorCode DOWNLOAD_ERROR_NETWORK_CONNECT_FAILED = null;
        public static final DownloadErrorCode DOWNLOAD_ERROR_NONE = null;
        public static final DownloadErrorCode DOWNLOAD_ERROR_NON_RETRYABLE = null;
        public static final DownloadErrorCode DOWNLOAD_ERROR_NO_SPACE = null;
        public static final DownloadErrorCode DOWNLOAD_ERROR_SERVER_ERROR = null;
        public static final DownloadErrorCode DOWNLOAD_ERROR_START_DOWNLOAD_FAILED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DownloadErrorCode[] f455628a = null;

        static {
            DownloadErrorCode r100 = new DownloadErrorCode("DOWNLOAD_ERROR_NONE", 0);
            DOWNLOAD_ERROR_NONE = r100;
            DownloadErrorCode r101 = new DownloadErrorCode("DOWNLOAD_ERROR_NETWORK_CONNECT_FAILED", 1);
            DOWNLOAD_ERROR_NETWORK_CONNECT_FAILED = r101;
            DownloadErrorCode r102 = new DownloadErrorCode("DOWNLOAD_ERROR_SERVER_ERROR", 2);
            DOWNLOAD_ERROR_SERVER_ERROR = r102;
            DownloadErrorCode r103 = new DownloadErrorCode("DOWNLOAD_ERROR_NO_SPACE", 3);
            DOWNLOAD_ERROR_NO_SPACE = r103;
            DownloadErrorCode r104 = new DownloadErrorCode("DOWNLOAD_ERROR_START_DOWNLOAD_FAILED", 4);
            DOWNLOAD_ERROR_START_DOWNLOAD_FAILED = r104;
            DownloadErrorCode r105 = new DownloadErrorCode("DOWNLOAD_ERROR_NON_RETRYABLE", 5);
            DOWNLOAD_ERROR_NON_RETRYABLE = r105;
            f455628a = new DownloadErrorCode[]{r100, r101, r102, r103, r104, r105};
        }

        public static DownloadErrorCode[] values() {
            return (DownloadErrorCode[]) f455628a.clone();
        }

        public static DownloadErrorCode valueOf(String r100) {
            return (DownloadErrorCode) r27.a.a(DownloadErrorCode.class, r100);
        }

        public DownloadErrorCode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum DownloadInfoCode extends Enum<DownloadInfoCode> {
        public static final DownloadInfoCode DOWNLOAD_INFO_READ_TIMEOUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DownloadInfoCode[] f455629a = null;

        static {
            DownloadInfoCode r100 = new DownloadInfoCode();
            DOWNLOAD_INFO_READ_TIMEOUT = r100;
            f455629a = new DownloadInfoCode[]{r100};
        }

        public DownloadInfoCode() {
            super("DOWNLOAD_INFO_READ_TIMEOUT", 0);
        }

        public static DownloadInfoCode[] values() {
            return (DownloadInfoCode[]) f455629a.clone();
        }

        public static DownloadInfoCode valueOf(String r100) {
            return (DownloadInfoCode) r27.a.a(DownloadInfoCode.class, r100);
        }
    }

    public interface VEApplogListener {
        void onInternalEventV3(String r100, JSONObject r101, String r102, String r103, String r104);
    }

    public interface VEBeginVideoFrameListener {
        void onProgress(float r100);
    }

    public interface VECallListener {
        void onDone(int r100);
    }

    public interface VECameraStateExtListener extends VECameraStateListener {

        /* JADX INFO: renamed from: com.ss.android.vesdk.VEListener$VECameraStateExtListener$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onInfoForTrack(VECameraStateExtListener r100, int r101, int r102, String r103, long r104) {
            }
        }

        void onError(int r100, String r101);

        void onInfo(int r100, int r101, String r102);

        void onInfoForTrack(int r100, int r101, String r102, long r103);
    }

    public interface VECameraStateListener {
        void cameraOpenFailed(int r100);

        void cameraOpenSuccess();
    }

    public interface VEConcatListener {
        void onDone(int r100, String r101, String r102);
    }

    public interface VEEditorAsyncReleaseEngineUnitResourceListener {
        void onReleaseEngineUnitResourceError(int r100);

        void onReleaseEngineUnitResourceSuccess();
    }

    public interface VEEditorCompileListener {
        void onCompileDone();

        void onCompileError(int r100, int r101, float r102, String r103);

        void onCompileProgress(float r100);
    }

    public interface VEEditorEffectListener {
        void onDone();
    }

    public interface VEEditorGenReverseListener {
        void onReverseDone(int r100);

        void onReverseProgress(double r100);
    }

    public interface VEEditorSeekListener {
        void onSeekDone(int r100);
    }

    public interface VEEncoderListener {
        void onEncoderDataAvailable(byte[] r100, long r101, int r102, boolean r103);
    }

    public interface VEExceptionMonitorListener {
        void onException(Throwable r100);
    }

    public interface VEFirstFrameListener {
        void onRendered();
    }

    public interface VEGetImageListener {
        int onGetImageData(byte[] r100, int r101, int r102, int r103, float r104);
    }

    public interface VEInfoStickerBufferListener {
        Bitmap onGetBuffer(int r100);
    }

    public interface VEMVInitListener {
        void onInited();
    }

    public interface VEMessageCenterListener {
    }

    public interface VEMonitorListener {
        void monitorLog(String r100, JSONObject r101);
    }

    public interface VERecorderStateExtListener extends VERecorderStateListener {
        void onError(int r100, String r101);

        void onInfo(int r100, int r101, String r102);
    }

    public interface VERecorderStateListener {
        void onHardEncoderInit(boolean r100);

        void onNativeInit(int r100, String r101);
    }

    public interface VEVideoOutputListener {
        void onRefresh(int r100, int r101);
    }

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
    }

    public interface f {
    }

    public interface g {
    }

    public interface h {
        void onDone();
    }

    public interface i {
    }

    public interface j {
    }

    public interface k {
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
    }

    public interface o {
    }

    public interface p {
        boolean getState();
    }

    public interface q {
    }

    public interface r {
    }

    public interface s {
        VESize a(List<VESize> r100);
    }

    public interface t {
    }

    public interface u {
    }

    public interface v {
        void a();
    }

    public interface w {
    }

    public interface x {
    }

    public interface y {
    }

    public VEListener() {
    }
}
