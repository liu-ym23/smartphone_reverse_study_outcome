package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public class Error {
    public static final int AVErrorHttpForbidden = -499897;
    public static final int AVErrorInvalidData = -1094995529;
    public static final int AVErrorStartCodecFailed = -499981;
    public static final int AsyncIniting = -7898;
    public static final int AuthEmpty = -9970;
    public static final int AuthFail = -9969;
    public static final int BashCheckFailed = -310002;
    public static final int ByteVC1CheckFailed = -310000;
    public static final int ByteVC2CheckFailed = -310003;
    public static final int CreateDBFail = -9943;
    public static final int CreatePLuginPlayerFailed = -9989;
    public static final int CreatePlayerFailed = -9993;
    public static final int DashCheckFailed = -310001;
    public static final String DataLoaderPreload = "kTTVideoErrorDomainDataLoaderPreload";
    public static final int DecodeEncryptionKeyError = -9988;
    public static final int DnsParseError = -9968;
    public static final String Download = "kTTVideoErrorDomainDownload";
    public static final int DurationNotSupport = -7885;
    public static final int ERROR_DRM_EXPIRED = -499697;
    public static final int ERROR_DRM_LOCAL_TIME_DECRYPT = -499696;
    public static final int ERROR_TYPE_API = 1000;
    public static final int ERROR_TYPE_CDN = 1003;
    public static final int ERROR_TYPE_DNS = 1001;
    public static final int ERROR_TYPE_PLAYER = 1002;
    public static final int ExecuteFail = -7895;
    public static final int FPSNotSupport = -7892;
    public static final int FallbackApiEmpty = -10002;
    public static final int FetchDecryptError = -9977;
    public static final int FetchEncryptError = -9978;
    public static final int FetchStatusException = -10005;
    public static final String FetchingInfo = "kTTVideoErrorDomainFetchingInfo";
    public static final String FetchingSmartUrlInfo = "kTTVideoErrorDomainFetchingSmartUrlInfo";
    public static final int FileHashInvalid = -10003;
    public static final int FmtsOVERLAY = -9928;
    public static final int FormatNotSupport = -7887;
    public static final String HTTPDNS = "kTTVideoErrorDomainHTTPDNS";
    public static final int HTTPNotOK = -9994;
    public static final int HdrNotSupport = -7883;
    public static final int InitFail = -7896;
    public static final int InitedUseOtherRender = -7894;
    public static final String IntertrustDRM = "kTTVideoErrorDomainIntertrustDRM";
    public static final int IntertrustDrmInitializeFail = -9938;
    public static final int IntertrustDrmInternalError = -9935;
    public static final int IntertrustDrmInvalidTemplate = -9937;
    public static final int IntertrustDrmLibUnload = -9939;
    public static final int IntertrustDrmMakeUrlFail = -9936;
    public static final int IntertrustDrmPluginUnload = -9933;
    public static final int IntertrustDrmTokenProcessError = -9934;
    public static final int InvalidSource = -9965;
    public static final int InvalidUrl = -9966;
    public static final int InvalidVideoInfoRequest = -9990;
    public static final int LicenceFailed = -30001;
    public static final String LicenseCheck = "kTTVideoErrorDomainLicenseCheck";
    public static final String LocalDNS = "kTTVideoErrorDomainLocalDNS";
    public static final int MDLFetcherListenerEmpty = -10001;
    public static final String MDLRetry = "kTTVideoErrorDomainMDLRetry";
    public static final int MediaLoaderNeedStart = -9946;
    public static final int MissingSelectorConfig = -7998;
    public static final int ModelUrlExpired = -9959;
    public static final int NOTRETRY_IN_ERROR = 10;
    public static final int NetworkNotAvailable = -9960;
    public static final int NoSRBenchmark = -7878;
    public static final int NotEnoughDiskSpace = -9947;
    public static final int NotInit = -7889;
    public static final int ParameterNull = -9999;
    public static final int ParseApiStringError = -9980;
    public static final int ParseJsonError = -9979;
    public static final int ParsingResponse = -9998;
    public static final int PlayNotCall = -7897;
    public static final int PlayerStateIllegal = -9992;
    public static final int PowerTooLow = -7886;
    public static final int PreloadInvalidParameter = -100001;
    public static final int RETRY_STRATEGY_CHANGE_URL = 2;
    public static final int RETRY_STRATEGY_CLEAR_DONE = 11;
    public static final int RETRY_STRATEGY_CODEC_STRATEGY = 12;
    public static final int RETRY_STRATEGY_FETCH = 1;
    public static final int RETRY_STRATEGY_NONE = 0;
    public static final int RETRY_STRATEGY_RESTART_PLAYER = 3;
    public static final int RenderException = -8000;
    public static final int ResolutionChanged = -7879;
    public static final int ResolutionNotSupport = -7891;
    public static final int ResultEmpty = -9997;
    public static final int ResultExpired = -10004;
    public static final int ResultNotApplicable = -9996;
    public static final int SRDisabled = -7888;
    public static final int SRDowngradeSizeTooSmall = -7875;
    public static final int SRInstanceNotExist = -7877;
    public static final int SROpenFail = -7874;
    public static final int SRPercentNotSatisfied = -7881;
    public static final int SRReset = -7880;
    public static final int SRSizeOverMax = -7876;
    public static final int SaveTaskItem = -9949;
    public static final int SaveTaskWriteFile = -9948;
    public static final int SceneNotSupport = -7884;
    public static final String Selector = "kTTVideoSelector";
    public static final int ServiceInaccessible = -9944;
    public static final String SetStrategySource = "kTTVideoErrorDomainSetStrategySource";
    public static final int SourceRefreshError = -10006;
    public static final int SpeedNotSupport = -7882;
    public static final int StartupResultEmpty = -7997;
    public static final int SubAuthFail = -9929;
    public static final String SubFetchingInfo = "kTTVideoErrorDomainSubFetchingInfo";
    public static final int SubInvalidVideoInfoRequest = -9932;
    public static final int SubParameterNull = -9930;
    public static final int SubResultEmpty = -9931;
    public static final int TOPAUTHAccessDenied = 100013;
    public static final int TOPAUTHFlowLimitExceeded = 100018;
    public static final int TOPAUTHInternalError = 100014;
    public static final int TOPAUTHInternalServiceTimeout = 100016;
    public static final int TOPAUTHInvalidClientTokenId = 100009;
    public static final int TOPAUTHInvalidTimestamp = 100006;
    public static final int TOPAUTHLackPolicy = 100012;
    public static final int TOPAUTHMethodNotAllowed = 100020;
    public static final int TOPAUTHMissingSignature = 100005;
    public static final int TOPAUTHServiceUnavailableTemp = 100019;
    public static final int TOPAUTHSignatureDoesNotMatch = 100010;
    public static final String TextureRender = "kTTVideoErrorTextureRender";
    public static final int TextureRenderNotInit = -7893;
    public static final int Timeout = -10000;
    public static final int URLUnavailable = -9945;
    public static final int UrlEmpty = -9967;
    public static final int UserCancel = -9995;
    public static final int UserClose = -7890;
    public static final int UserNotCallOpen = -7899;
    public static final int VideoDecryptFailed = -9987;
    public static final String VideoExoPlayer = "kTTVideoErrorDomainVideoExoPlayer";
    public static final int VideoFormatOpenFailed = -499975;
    public static final int VideoInfoEmpty = -7999;
    public static final int VideoInfoStatusInvalid = -7996;
    public static final int VideoModelExtractError = -9976;
    public static final String VideoOSPlayer = "kTTVideoErrorDomainVideoOSPlayer";
    public static final String VideoOwnPlayer = "kTTVideoErrorDomainVideoOwnPlayer";
    public static final int VideoValiateFail = -9991;
    public int code;
    public String description;
    public String domain;
    public int internalCode;
    public Map parameters;

    public String toString() {
        Object[] r100 = new Object[4];
        r100[0] = this.domain;
        r100[1] = Integer.valueOf(this.code);
        r100[2] = Integer.valueOf(this.internalCode);
        String r101 = this.description;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        r100[3] = r101;
        return String.format("domain:%s, code:%d, internalCode:%d, description:%s", r100);
    }

    private boolean needChangeURL() {
        int r100 = this.code;
        if (r100 != (-499988)) goto L5;
        return true;
    L5:
        if (r100 != (-499987)) goto L7;
        return true;
    L7:
        if (r100 != (-499986)) goto L9;
        return true;
    L9:
        if (r100 != (-499985)) goto L11;
        return true;
    L11:
        if (r100 != (-499899)) goto L13;
        return true;
    L13:
        if (r100 != (-499898)) goto L15;
        return true;
    L15:
        if (r100 != (-499896)) goto L17;
        return true;
    L17:
        if (r100 != (-499894)) goto L19;
        return true;
    L19:
        if (r100 != (-499893)) goto L21;
        return true;
    L21:
        if (r100 != (-499891)) goto L23;
        return true;
    L23:
        if (r100 != 251658241) goto L25;
        return true;
    L25:
        if (r100 != (-499799)) goto L27;
        return true;
    L27:
        if (r100 != (-499795)) goto L29;
        return true;
    L29:
        if (r100 != (-499794)) goto L31;
        return true;
    L31:
        if (r100 != (-499793)) goto L33;
        return true;
    L33:
        if (r100 == (-499792)) goto L53;
        return false;
    L53:
        return true;
    }

    private boolean needFetch() {
        if (this.code != (-499897)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean needRestartPlayer() {
        int r100 = this.code;
        if (r100 != (-499999)) goto L5;
        return true;
    L5:
        if (r100 != (-499997)) goto L7;
        return true;
    L7:
        if (r100 != (-499996)) goto L9;
        return true;
    L9:
        if (r100 != (-499992)) goto L11;
        return true;
    L11:
        if (r100 != (-499991)) goto L13;
        return true;
    L13:
        if (r100 != (-499990)) goto L15;
        return true;
    L15:
        if (r100 != (-499989)) goto L17;
        return true;
    L17:
        if (r100 == (-2139062143)) goto L29;
        return false;
    L29:
        return true;
    }

    public int getRetryStrategy() {
        if (this.domain.equals(HTTPDNS) == false) goto L5;
    L27:
        return 2;
    L5:
        if (this.domain.equals(LocalDNS) == true) goto L27;
        if (this.domain.equals(FetchingInfo) == false) goto L11;
        return 1;
    L11:
        if (this.domain.equals(VideoOwnPlayer) == false) goto L23;
        if (needChangeURL() == false) goto L16;
        return 2;
    L16:
        if (needRestartPlayer() == false) goto L20;
        return 3;
    L20:
        if (needFetch() == false) goto L23;
        return 1;
    L23:
        if (this.domain.equals(VideoExoPlayer) == false) goto L27;
        if (needFetch() == false) goto L27;
        return 1;
    }

    public int getType() {
        if (this.domain.equals(FetchingInfo) == false) goto L7;
        return 1000;
    L7:
        if (this.domain.equals(LocalDNS) == false) goto L9;
        return 1001;
    L9:
        if (this.domain.equals(HTTPDNS) == false) goto L12;
        return 1001;
    L12:
        if (this.domain.equals(VideoOwnPlayer) == true) goto L14;
        return 1003;
    L14:
        if (needRestartPlayer() == false) goto L21;
        return 1002;
    L21:
        return 1003;
    }

    public boolean isPlayerErrorDomain() {
        if (TextUtils.isEmpty(this.domain) == false) goto L6;
        return false;
    L6:
        if (this.domain.equals(VideoOwnPlayer) == false) goto L8;
    L11:
        return true;
    L8:
        if (this.domain.equals(VideoOSPlayer) == true) goto L11;
        if (this.domain.equals(VideoExoPlayer) == true) goto L11;
        return false;
    }

    public HashMap toMap() {
        HashMap r100 = new HashMap();
        r100.put("domain", this.domain);
        r100.put("code", Integer.valueOf(this.code));
        int r101 = this.internalCode;
        if (r101 == 0) goto L5;
        r100.put("internalCode", Integer.valueOf(r101));
    L5:
        String r102 = this.description;
        if (r102 == null) goto L8;
        r100.put("description", r102);
    L8:
        return r100;
    }

    public static String getDomainForPlayer(MediaPlayer r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        int r101 = r100.getPlayerType();
        if (r101 != 0) goto L8;
        return VideoOSPlayer;
    L8:
        if (r101 != 1) goto L10;
        return VideoOwnPlayer;
    L10:
        if (r101 != 2) goto L12;
        return VideoOwnPlayer;
    L12:
        if (r101 != 3) goto L14;
        return VideoOwnPlayer;
    L14:
        if (r101 != 4) goto L16;
        return VideoOwnPlayer;
    L16:
        if (r101 == 5) goto L18;
        return "";
    L18:
        return VideoExoPlayer;
    }

    public Error(String r100, int r101) {
        this(r100, r101, 0);
    }

    public Error(String r100, int r101, int r102) {
        this(r100, r101, r102, null);
    }

    public static Error createForPlayer(MediaPlayer r100, int r101, String r102) {
        return new Error(getDomainForPlayer(r100), r101, r102);
    }

    public Error(String r100, int r101, String r102) {
        this(r100, r101, 0, r102);
    }

    public Error(String r100, int r101, int r102, String r103) {
        this.domain = r100;
        this.code = r101;
        this.internalCode = r102;
        this.description = r103;
        this.parameters = new HashMap();
    }
}
