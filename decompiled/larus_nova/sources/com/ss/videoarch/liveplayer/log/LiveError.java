package com.ss.videoarch.liveplayer.log;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class LiveError extends Error {
    public static final int ABR_DEGRADE_URL = -200003;
    public static final int ABR_SWITCH_FIRST_FRAME = -200100;
    public static final int ABR_SWITCH_URL = -200015;
    public static final int AGAIN_ERROR = -100014;
    public static final int AUDIO_DECODER_WRITE_ERROR = -499978;
    public static final int AUDIO_DECODER_WRITE_ERROR_CONSUMED = -100026;
    public static final int AUTH_FAIL = -30001;
    public static final int AUTOMIC_SWITCH = -200014;
    public static final int AVERROR_DECODER_NOT_FOUND = -1128613112;
    public static final int AVERROR_DEMUXER_NOT_FOUND = -1296385272;
    public static final int AVERROR_HTTP_UNAUTHORIZED = -825242872;
    public static final int AVERROR_INVALIDDATA = -1094995529;
    public static final int AVERROR_PROTOCOL_NOT_FOUND = -1330794744;
    public static final int BACK_TO_MAIN = -200009;
    public static final int BYTEVC1_URL_IS_NULL = -100017;
    public static final int CMAF_LIBRARY_LOAD_FAILED = -499493;
    public static final int CMAF_PRELOAD_FAILED = -100022;
    public static final int CODEC_DEGRADE = -200007;
    public static final int DEGRADE_RESOLUTION = -200012;
    public static final int DNS_PARSE_ERROR = -100010;
    public static final int DRM_FAIL = -100019;
    public static final int EMPTY = -100011;
    public static final int END_OF_FILE = -499984;
    public static final int HDR10_DEC_EXPC = -499963;
    public static final int HDR_DEGRADE = -200010;
    public static final int HTTP_BAD_REQUEST = -499899;
    public static final int HTTP_CONTENT_TYPE_IS_INVALID = -499891;
    public static final int HTTP_FORBIDEN = -499897;
    public static final int HTTP_NOT_FOUND = -499896;
    public static final int HTTP_OTHER_4xx = -499894;
    public static final int HTTP_SERVER_ERROR = -499893;
    public static final int HTTP_TIMEOUT = -499895;
    public static final int HTTP_UNAUTHORIZED = -499898;
    public static final int HTTP_USER_INTERRUPT = -499892;
    public static final int INFO_DND_ERROR = -100012;
    public static final int INPUTER_OPEN_ERROR = -499975;
    public static final int IO_BLOCKED = -100018;
    public static final int IO_ERROR = -5;
    public static final int LIVEIO_PRECONNECT_TIMEOUT = -100020;
    public static final int LIVE_API_URL_INVALID = -100006;
    public static final int LIVE_DATA_EMPTY = -100005;
    public static final int MAIN_TO_BACK = -200008;
    public static final int NETWORK_IO_ERROR = -100008;
    public static final int NETWORK_UNREACHABLE = -101;
    public static final int NOT_STREAM = -499983;
    public static final int NO_ERROR = 0;
    public static final int NO_STREAM_INFO = -499971;
    public static final int OPEN_CODEC_FAIL = -499981;
    public static final int OPEN_DECODER_ERROR = -499996;
    public static final int OPEN_OUTLET_ERROR = -499992;
    public static final int PARSE_JSON = -100000;
    public static final int PLAYER_DATASOURCE = -100002;
    public static final int PLAYER_INTERNAL = -100003;
    public static final int PLAYER_PREPARE = -100001;
    public static final int PLAYER_STALL = -100015;
    public static final int PLAYER_STALL_Y_DURATION_IN_X_SECONDS = -100024;
    public static final int PLAYER_STALL_Y_TIMES_IN_X_SECONDS = -100023;
    public static final int PLAYER_SWITCH_URL = -200002;
    public static final int PLAY_DNS_ERROR = -100013;
    public static final int QUIC_CONN_DOWNGRADE_CODE = -499495;
    public static final int QUIC_CONN_NEED_RETRY_CODE = -499494;
    public static final int QUIC_LOAD_LIBRARY_ERROR = -499499;
    public static final int RECEIVE_CONTROL_MESSAGRE = -200011;
    public static final int RESPONSE_ERROR = -100004;
    public static final int RETRY_NETWORK_SWITCHING = -200005;
    public static final int RETRY_NEXT_URL = -200004;
    public static final int RETRY_RESET_PLAYER = -200001;
    public static final int RTM_FALLBACK = -200006;
    public static final int SEI_UPLOAD_TIME_OUT = -100016;
    public static final int SETTING_CODEC_ERROR = -499998;
    public static final int SETTING_INPUTER_ERROR = -499980;
    public static final int SETTING_URI_IS_ERROR = -499987;
    public static final int SETTING_URI_IS_NULL_ERROR = -499988;
    public static final int SMOOTH_SWITCH = -200013;
    public static final int STALL_RETRY_TIMEOUT = -100007;
    public static final int START_DECODER_ERROR = -499997;
    public static final int START_OUTLET_ERROR = -499990;
    public static final int START_PLAY = -200000;
    public static final int STREAM_DRYUP = -100009;
    public static final int TCP_FAILED_TO_RESOLVE_HOSTNAME = -499799;
    public static final int TCP_FAILED_TO_RESOLVE_HOSTNAME_TIMEOUT = -499798;
    public static final int VIDEO_DECODER_WRITE_ERROR = -499977;
    public static final int VIDEO_DROP_FRAME_PLAYER_RETRY = -100021;
    public int code;
    public Map info;
    public long timeStamp;

    public static int convertVeLivePlayerErrorCode(int r100) {
        switch(r100) {
            case -1330794744: goto L19;
            case -1296385272: goto L19;
            case -1128613112: goto L17;
            case -1094995529: goto L19;
            case -499998: goto L17;
            case -499997: goto L17;
            case -499996: goto L17;
            case -499992: goto L15;
            case -499990: goto L15;
            case -499988: goto L13;
            case -499987: goto L13;
            case -499984: goto L11;
            case -499983: goto L19;
            case -499981: goto L17;
            case -499978: goto L17;
            case -499977: goto L17;
            case -499975: goto L19;
            case -499971: goto L19;
            case -499898: goto L9;
            case -499897: goto L9;
            case -499896: goto L9;
            case -499895: goto L9;
            case -499894: goto L9;
            case -499893: goto L9;
            case -499892: goto L9;
            case -499891: goto L9;
            case -499799: goto L7;
            case -499798: goto L7;
            case -100011: goto L9;
            case -100010: goto L7;
            case -100009: goto L11;
            case -100002: goto L13;
            case -100001: goto L13;
            case -30001: goto L5;
            default: goto L3;
        };
    L3:
        return -999;
    L5:
        return -1;
    L7:
        return -200;
    L9:
        return -201;
    L11:
        return -101;
    L13:
        return -100;
    L15:
        return -302;
    L17:
        return -301;
    L19:
        return -300;
    }

    public String getInfoJSON() {
        if (this.info != null) goto L5;
        this.info = new HashMap();
    L5:
        JSONObject r100 = new JSONObject(this.info);
        r100.put("timestamp", this.timeStamp);     // Catch: JSONException -> L8
        r100.put("message", super.toString());     // Catch: JSONException -> L8
    L11:
        return r100.toString();
    L8:
        e = move-exception;
        c.d("Live Error", e.toString());
        goto L11
    }

    @Override // java.lang.Throwable
    public String toString() {
        if (this.info != null) goto L5;
        this.info = new HashMap();
    L5:
        JSONObject r100 = new JSONObject(this.info);
        r100.put("message", super.toString());     // Catch: JSONException -> L8
        r100.put("code", this.code);     // Catch: JSONException -> L8
        r100.put("timestamp", this.timeStamp);     // Catch: JSONException -> L8
    L11:
        return r100.toString();
    L8:
        e = move-exception;
        c.d("Live Error", e.toString());
        goto L11
    }

    public LiveError(int r100, String r101, Map<String, String> r102) {
        super(r101);
        this.code = r100;
        this.info = r102;
        this.timeStamp = System.currentTimeMillis();
    }
}
