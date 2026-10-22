package com.ss.android.cert.manager.constants;

import android.util.Pair;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.ablity.INetWork;
import com.ss.bytertc.engine.type.WarningCode;
import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

/* JADX INFO: loaded from: classes34.dex */
public class ErrorConstant {

    public static class Client {
        public static Pair<Integer, String> ERROR_ALGORITHM_INIT_FAIL;
        public static Pair<Integer, String> ERROR_ALGORITHM_PARAMS_FAIL;
        public static Pair<Integer, String> ERROR_CAMERA_UN_SUPPORT;
        public static Pair<Integer, String> ERROR_CERT_IS_START;
        public static Pair<Integer, String> ERROR_CERT_MONITOR_CONFIG;
        public static Pair<Integer, String> ERROR_CERT_UNREGISTER;
        public static Pair<Integer, String> ERROR_FACE_DATA_ENCRYPT;
        public static Pair<Integer, String> ERROR_FACE_LIVE_FAIL;
        public static Pair<Integer, String> ERROR_FACE_LIVE_INTERRUPT;
        public static Pair<Integer, String> ERROR_FACE_LIVE_MAX_TIME;
        public static Pair<Integer, String> ERROR_FACE_LIVE_RETURN;
        public static Pair<Integer, String> ERROR_FACE_LIVE_TIMEOUT;
        public static Pair<Integer, String> ERROR_GREY_STRATEGY_BLOCK;
        public static int ERROR_ILLEGAL_ARGUMENT;
        public static int ERROR_IO_EXCEPTION;
        public static int ERROR_JSON;
        public static Pair<Integer, String> ERROR_JSON_PARSING;
        public static int ERROR_LOAD_LIB;
        public static Pair<Integer, String> ERROR_LOCAL_VERIFY_FAIL;
        public static Pair<Integer, String> ERROR_LOCAL_VERIFY_INIT_FAIL;
        public static Pair<Integer, String> ERROR_MULTI_WINDOW;
        public static Pair<Integer, String> ERROR_NETWORK_ERROR;
        public static int ERROR_NULL_POINTER;
        public static Pair<Integer, String> ERROR_PERMISSION_ERROR;
        public static Pair<Integer, String> ERROR_PICK_PHOTO_ERROR;
        public static int ERROR_RUNTIME;
        public static Pair<Integer, String> ERROR_SDK_INERT_NET_FAILED;
        public static Pair<Integer, String> ERROR_SET_TASK_FAIL;
        public static Pair<Integer, String> ERROR_STILL_FAIL;
        public static Pair<Integer, String> ERROR_STILL_INIT_FAIL;
        public static Pair<Integer, String> ERROR_TAKE_PHOTO_ERROR;
        public static Pair<Integer, String> ERROR_UNKNOWN;
        public static int ERROR_UNKNOWN_EXCEPTION;
        public static int ERROR_UNSUPPORTED_ENCODE;
        public static int ERROR_UN_SUPPORT_STRATEGY;
        public static Pair<Integer, String> ERROR_UPDATE_MODEL_ERROR;
        public static Pair<Integer, String> ERROR_UPDATE_MODEL_MD5;
        public static Pair<Integer, String> ERROR_UPDATE_NO_DOWNLOAD;
        public static Pair<Integer, String> ERROR_UPDATE_NO_MATCH_NEW;
        public static Pair<Integer, String> ERROR_UPDATE_NO_MODEL;
        public static Pair<Integer, String> ERROR_USER_CANCEL;
        public static int ERROR_VIDEO_ENCODE;
        public static Pair<Integer, String> ERROR_VIDEO_LIVENESS_FAIL;
        public static Pair<Integer, String> ERROR_VIDEO_RECORD_NO_FACE;
        public static Pair<Integer, String> ERROR_VIDEO_RECORD_UN_EXISTS;
        public static Pair<Integer, String> ERROR_VIDEO_RECORD_UPLOAD_FAIL;
        public static Pair<Integer, String> ERROR_VIDEO_VERIFY_FAIL;
        public static Pair<Integer, String> ERROR_WEB_LOAD_FAILED;

        public Client() {
        }

        static {
            ERROR_NETWORK_ERROR = new Pair(-1000, "网络异常，请稍后再试");
            ERROR_UNKNOWN = new Pair(-1001, "网络异常，请稍后再试");
            ERROR_FACE_LIVE_INTERRUPT = new Pair(-1002, "网络异常，请稍后再试");
            ERROR_FACE_LIVE_FAIL = new Pair(-1003, "活体识别失败，请再试一次");
            ERROR_ALGORITHM_INIT_FAIL = new Pair(-1004, "活体初始化失败，请稍后再试");
            ERROR_ALGORITHM_PARAMS_FAIL = new Pair(-1005, "网络异常，请稍后再试");
            ERROR_FACE_LIVE_RETURN = new Pair(-1006, "用户取消操作");
            ERROR_USER_CANCEL = new Pair(-1007, "");
            ERROR_FACE_DATA_ENCRYPT = new Pair(-1008, "");
            ERROR_VIDEO_RECORD_NO_FACE = new Pair(-1009, "人脸质量超时");
            ERROR_WEB_LOAD_FAILED = new Pair(-1011, "网络异常，请稍后再试");
            ERROR_FACE_LIVE_MAX_TIME = new Pair(Integer.valueOf(SpeechEngineDefines.ERR_AUTHENTICATION_FAILED), "超过活体最大次数");
            ERROR_FACE_LIVE_TIMEOUT = new Pair(Integer.valueOf(SpeechEngineDefines.ERR_GET_DEVICEID_FAILED), "活体超时");
            ERROR_PERMISSION_ERROR = new Pair(-3000, "无法使用相机，请检查是否打开相机权限");
            ERROR_JSON_PARSING = new Pair(-3001, "网络异常，请稍后再试");
            ERROR_MULTI_WINDOW = new Pair(-3002, "请退出多屏模式，再重试一次");
            ERROR_CAMERA_UN_SUPPORT = new Pair(-3003, "无法使用相机，请检查是否打开相机权限");
            ERROR_SET_TASK_FAIL = new Pair(-3004, "网络异常，请稍后再试");
            ERROR_PICK_PHOTO_ERROR = new Pair(-3006, "图片获取失败，请重新上传");
            ERROR_TAKE_PHOTO_ERROR = new Pair(-3007, "图片获取失败，请重新拍照");
            ERROR_SDK_INERT_NET_FAILED = new Pair(-4001, "网络请求注入失败 please call method setNetWork or depend on byted_cert_adapter");
            ERROR_CERT_MONITOR_CONFIG = new Pair(-4002, "埋点注入失败 please call method setCertMonitorConfig or depend on byted_cert_adapter");
            ERROR_CERT_IS_START = new Pair(-4003, "操作太频繁，请稍后再试");
            ERROR_CERT_UNREGISTER = new Pair(-4004, "初始化异常，请稍后再试");
            ERROR_UPDATE_MODEL_ERROR = new Pair(-5000, "下载解压模型失败");
            ERROR_UPDATE_NO_MATCH_NEW = new Pair(Integer.valueOf(WarningCode.WARNING_CODE_NO_CAMERA_PERMISSION), "无可用下载");
            ERROR_UPDATE_NO_DOWNLOAD = new Pair(Integer.valueOf(WarningCode.WARNING_CODE_RECODING_DEVICE_START_FAILED), "未下载");
            ERROR_UPDATE_NO_MODEL = new Pair(Integer.valueOf(WarningCode.WARNING_CODE_PLAYOUT_DEVICE_START_FAILED), " 对应模型不存在");
            ERROR_UPDATE_MODEL_MD5 = new Pair(Integer.valueOf(WarningCode.WARNING_CODE_NO_RECORDING_DEVICE), "模型校验失败");
            ERROR_STILL_INIT_FAIL = new Pair(Integer.valueOf(WarningCode.WARNING_CODE_SET_SCREEN_STREAM_INDEX_FAILED), "静默初始化失败");
            ERROR_STILL_FAIL = new Pair(Integer.valueOf(WarningCode.WARNING_CODE_SET_SCREEN_STREAM_INVALID_VOICE_PITCH), "静默失败");
            ERROR_LOCAL_VERIFY_INIT_FAIL = new Pair(-5020, "比对初始化失败");
            ERROR_LOCAL_VERIFY_FAIL = new Pair(-5021, "比对失败");
            ERROR_VIDEO_LIVENESS_FAIL = new Pair(7000, "视频活体失败");
            ERROR_VIDEO_VERIFY_FAIL = new Pair(7001, "视频比对失败");
            ERROR_VIDEO_RECORD_UPLOAD_FAIL = new Pair(-9001, "视频上传失败");
            ERROR_VIDEO_RECORD_UN_EXISTS = new Pair(-9002, "视频文件不存在");
            ERROR_GREY_STRATEGY_BLOCK = new Pair(-9003, "灰度策略拦截");
            ERROR_UNKNOWN_EXCEPTION = -200;
            ERROR_NULL_POINTER = -201;
            ERROR_ILLEGAL_ARGUMENT = -202;
            ERROR_RUNTIME = -203;
            ERROR_UNSUPPORTED_ENCODE = -204;
            ERROR_JSON = -205;
            ERROR_IO_EXCEPTION = -206;
            ERROR_LOAD_LIB = -207;
            ERROR_VIDEO_ENCODE = NetError.ERR_CERT_WEAK_SIGNATURE_ALGORITHM;
            ERROR_UN_SUPPORT_STRATEGY = -209;
        }
    }

    public interface Network {
        public static final int ERROR_CONNECT_TIME_OUT = -101;
        public static final int ERROR_HTTP_RESPONSE_ERROR = 105;
        public static final int ERROR_IO_ERROR = -106;
        public static final int ERROR_SOCKET_ERROR = -103;
        public static final int ERROR_SOCKET_TIME_OUT = -102;
        public static final int ERROR_SSL_ERROR = -104;
        public static final int ERROR_UNKNOWN = -100;
    }

    public ErrorConstant() {
    }

    public static int checkApiException(Throwable r100) {
        INetWork r101 = CertManager.getInstance().getNetWork();     // Catch: Exception -> L7
        if (r101 == null) goto L10;
        int r102 = r101.checkResponseException(r100);     // Catch: Exception -> L7
        if (r102 == 0) goto L10;
        return r102;
    L10:
        if ((r100 instanceof ConnectTimeoutException) == false) goto L13;
        return -101;
    L13:
        if ((r100 instanceof SocketTimeoutException) == false) goto L16;
        return -102;
    L16:
        if ((r100 instanceof SocketException) == false) goto L19;
        return -103;
    L19:
        if ((r100 instanceof SSLPeerUnverifiedException) == false) goto L22;
        return -104;
    L22:
        if ((r100 instanceof IOException) == false) goto L24;
        return -106;
    L24:
        return -100;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static int checkClientException(Throwable r100) {
        if ((r100 instanceof NullPointerException) == false) goto L6;
        return Client.ERROR_NULL_POINTER;
    L6:
        if ((r100 instanceof IllegalArgumentException) == false) goto L9;
        return Client.ERROR_ILLEGAL_ARGUMENT;
    L9:
        if ((r100 instanceof RuntimeException) == false) goto L12;
        return Client.ERROR_RUNTIME;
    L12:
        if ((r100 instanceof UnsupportedEncodingException) == false) goto L15;
        return Client.ERROR_UNSUPPORTED_ENCODE;
    L15:
        if ((r100 instanceof JSONException) == false) goto L18;
        return Client.ERROR_JSON;
    L18:
        if ((r100 instanceof IOException) == false) goto L21;
        return Client.ERROR_IO_EXCEPTION;
    L21:
        return Client.ERROR_UNKNOWN_EXCEPTION;
    }
}
