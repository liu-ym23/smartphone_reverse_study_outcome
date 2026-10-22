package com.ss.ttvideoengine.log;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoEventOneError {
    private static final String TAG = "VideoEventOneError";
    public static final String monitorName = "videoplayer_oneerror";
    public String mCDNIP;
    public String mCDNUrl;
    public int mDisAbleV3Async;
    public int mErrorCode;
    public String mErrorStage;
    public int mErrorType;
    public VideoEventBase mEventBase;
    public boolean mFirstFrameShown;
    public int mRetryCount;

    /* JADX INFO: renamed from: vsc, reason: collision with root package name */
    public int f457077vsc;
    public String vscMessage;

    public static class AsyncGetLogDataRunnable implements Runnable {
        private Context rContext;
        private VideoEventOneError rEvent;
        private VideoEventBase rEventBase;
        private Handler rHandler;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_ttvideoengine_log_VideoEventOneError$AsyncGetLogDataRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_ttvideoengine_log_VideoEventOneError$AsyncGetLogDataRunnable__run$___twin___() {
            if (this.rEvent != null) goto L5;
            return;
        L5:
            VideoEventBase r100 = this.rEventBase;
            if (r100 == null) goto L8;
            r100.updateMDLInfo();
            VideoEventBase r101 = this.rEventBase;
            r101.mNetworkType = VideoEventBase.getNetType();
        L8:
            VideoEventBase r102 = this.rEventBase;
            if (r102 != null) goto L11;
        L13:
            final boolean r103 = false;
        L14:
            final JSONObject r104 = VideoEventOneError.access$000(this.rEvent);
            Handler r105 = this.rHandler;
            if (r105 != null) goto L17;
        L21:
            VideoEventManager.instance.addEventV2(r103, r104, VideoEventOneError.monitorName);
            return;
        L17:
            if (r105.getLooper() == null) goto L21;
            this.rHandler.post(new AnonymousClass1(this, r103, r104));
            return;
        L11:
            if (r102.isUploadLogEnabled == false) goto L13;
            r103 = true;
            goto L14
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_ttvideoengine_log_VideoEventOneError$AsyncGetLogDataRunnable_com_larus_apm_impl_protector_RunnableLancet_run(AsyncGetLogDataRunnable r100) {
            r100.com_ss_ttvideoengine_log_VideoEventOneError$AsyncGetLogDataRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public AsyncGetLogDataRunnable(Context r100, VideoEventOneError r101, VideoEventBase r102) {
            this.rEvent = r101;
            this.rEventBase = r102;
            this.rContext = r100;
            this.rHandler = new Handler(Looper.getMainLooper());
        }
    }

    public void reset() {
        this.mRetryCount = 0;
        this.mFirstFrameShown = false;
    }

    public void showedFirstFrame() {
        this.mFirstFrameShown = true;
    }

    private JSONObject toJsonObject() {
        HashMap r100 = new HashMap();
        VideoEventBase r101 = this.mEventBase;
        if (r101 == null) goto L19;
        LoggerUtils.putToMap(r100, "player_sessionid", r101.mSessionID);
        String r102 = this.mEventBase.mCurURL;
        if (r102 != null) goto L7;
    L10:
        LoggerUtils.putToMap(r100, "cdn_url", this.mEventBase.mInitialURL);
    L11:
        String r103 = this.mEventBase.mCurIP;
        if (r103 != null) goto L14;
    L17:
        LoggerUtils.putToMap(r100, EventConstants.ExtraJson.KEY_CDN_IP, this.mEventBase.mInitialIP);
    L18:
        LoggerUtils.putToMap(r100, "resolution", this.mEventBase.mCurrentResolution);
        LoggerUtils.putToMap(r100, "source_type", this.mEventBase.mSourceTypeStr);
        LoggerUtils.putToMap(r100, BaseSwitches.V, this.mEventBase.mVid);
        LoggerUtils.putToMap(r100, "pv", this.mEventBase.f457073pv);
        LoggerUtils.putToMap(r100, BackupSeiMessage.SOURCE_PC, this.mEventBase.f457072pc);
        LoggerUtils.putToMap(r100, com.alipay.sdk.m.s.a.f25762t, this.mEventBase.f457074sv);
        LoggerUtils.putToMap(r100, "tag", this.mEventBase.mTag);
        LoggerUtils.putToMap(r100, ITTVideoEngineEventSource.KEY_SUBTAG, this.mEventBase.mSubTag);
        LoggerUtils.putToMap(r100, "sdk_version", this.mEventBase.sdk_version);
        LoggerUtils.putToMap(r100, "video_hw", this.mEventBase.mVideoHW);
        LoggerUtils.putToMap(r100, "vtype", this.mEventBase.vtype);
        LoggerUtils.putToMap(r100, "p2p_cdn_type", this.mEventBase.mP2PCDNType);
        LoggerUtils.putToMap(r100, "codec", this.mEventBase.codec_type);
        LoggerUtils.putToMap(r100, ITTVideoEngineEventSource.KEY_VIDEO_CODEC_NAME_ID, this.mEventBase.videoCodecNameId);
        LoggerUtils.putToMap(r100, ITTVideoEngineEventSource.KEY_AUDIO_CODEC_NAME_ID, this.mEventBase.audioCodecNameId);
        LoggerUtils.putToMap(r100, "format_type", this.mEventBase.formatType);
        LoggerUtils.putToMap(r100, "drm_type", this.mEventBase.mDrmType);
        LoggerUtils.putToMap(r100, "drm_token_url", this.mEventBase.mDrmTokenUrl);
        LoggerUtils.putToMap(r100, "cur_req_pos", this.mEventBase.mdlVideoInfo.mdl_cur_req_pos);
        LoggerUtils.putToMap(r100, "cur_end_pos", this.mEventBase.mdlVideoInfo.mdl_cur_end_pos);
        LoggerUtils.putToMap(r100, "cur_cache_pos", this.mEventBase.mdlVideoInfo.mdl_cur_cache_pos);
        LoggerUtils.putToMap(r100, "cache_type", this.mEventBase.mdlVideoInfo.mdl_cache_type);
        LoggerUtils.putToMap(r100, "cur_ip", this.mEventBase.mdlVideoInfo.mdl_cur_ip);
        LoggerUtils.putToMap(r100, "cur_host", this.mEventBase.mdlVideoInfo.mdl_cur_host);
        LoggerUtils.putToMap(r100, "reply_size", this.mEventBase.mdlVideoInfo.mdl_reply_size);
        LoggerUtils.putToMap(r100, "down_pos", this.mEventBase.mdlVideoInfo.mdl_down_pos);
        LoggerUtils.putToMap(r100, "player_wait_time", this.mEventBase.mdlVideoInfo.mdl_player_wait_time);
        LoggerUtils.putToMap(r100, "player_wait_num", this.mEventBase.mdlVideoInfo.mdl_player_wait_num);
        LoggerUtils.putToMap(r100, "mdl_stage", this.mEventBase.mdlVideoInfo.mdl_stage);
        LoggerUtils.putToMap(r100, "mdl_ec", this.mEventBase.mdlVideoInfo.mdl_error_code);
        LoggerUtils.putToMap(r100, "mdl_speed", this.mEventBase.mdlVideoInfo.mdl_speed);
        LoggerUtils.putToMap(r100, "mdl_file_key", this.mEventBase.mdlVideoInfo.mdl_file_key);
        LoggerUtils.putToMap(r100, "mdl_is_socrf", this.mEventBase.mdlVideoInfo.mdl_is_socrf);
        LoggerUtils.putToMap(r100, "mdl_req_num", this.mEventBase.mdlVideoInfo.mdl_req_num);
        LoggerUtils.putToMap(r100, "mdl_url_index", this.mEventBase.mdlVideoInfo.mdl_url_index);
        LoggerUtils.putToMap(r100, "mdl_re_url", this.mEventBase.mdlVideoInfo.mdl_re_url);
        LoggerUtils.putToMap(r100, "net_type", this.mEventBase.mNetworkType);
        LoggerUtils.putToMap(r100, "mdl_fs", this.mEventBase.mdlVideoInfo.mdl_fs);
        LoggerUtils.putToMap(r100, "req_t", this.mEventBase.mdlVideoInfo.mdl_req_t);
        LoggerUtils.putToMap(r100, "end_t", this.mEventBase.mdlVideoInfo.mdl_end_t);
        LoggerUtils.putToMap(r100, "dns_t", this.mEventBase.mdlVideoInfo.mdl_dns_t);
        LoggerUtils.putToMap(r100, "tcp_con_start_t", this.mEventBase.mdlVideoInfo.mdl_tcp_start_t);
        LoggerUtils.putToMap(r100, "tcp_con_t", this.mEventBase.mdlVideoInfo.mdl_tcp_end_t);
        LoggerUtils.putToMap(r100, "tcp_first_pack_t", this.mEventBase.mdlVideoInfo.mdl_ttfp);
        LoggerUtils.putToMap(r100, "http_first_body_t", this.mEventBase.mdlVideoInfo.mdl_httpfb);
        LoggerUtils.putToMap(r100, "http_open_end_t", this.mEventBase.mdlVideoInfo.mdl_http_open_end_t);
        LoggerUtils.putToMap(r100, "http_code", this.mEventBase.mdlVideoInfo.mdl_http_code);
        LoggerUtils.putToMap(r100, "mdl_extra_info", this.mEventBase.mdlVideoInfo.mdl_extra_info);
        LoggerUtils.putToMap(r100, "mdl_version", this.mEventBase.mMdlVersion);
        LoggerUtils.putToMap(r100, "mdl_ip_list", this.mEventBase.mdlVideoInfo.mdl_ip_list);
        LoggerUtils.putToMap(r100, "mdl_blocked_ips", this.mEventBase.mdlVideoInfo.mdl_blocked_ips);
        goto L19
    L14:
        if (r103.isEmpty() == true) goto L17;
        LoggerUtils.putToMap(r100, EventConstants.ExtraJson.KEY_CDN_IP, this.mEventBase.mCurIP);
        goto L18
    L7:
        if (r102.isEmpty() == true) goto L10;
        LoggerUtils.putToMap(r100, "cdn_url", this.mEventBase.mCurURL);
    L19:
        LoggerUtils.putToMap(r100, "errt", this.mErrorType);
        LoggerUtils.putToMap(r100, "errc", this.mErrorCode);
        LoggerUtils.putToMap(r100, "es", this.mErrorStage);
        LoggerUtils.putToMap(r100, "vsc", this.f457077vsc);
        LoggerUtils.putToMap(r100, "vsc_message", this.vscMessage);
        LoggerUtils.putToMap(r100, "retry_count", this.mRetryCount);
        return new JSONObject(r100);
    }

    public void sendErrorEvent() {
        if (this.mFirstFrameShown == false) goto L5;
        this.mErrorStage = "playing";
    L7:
        if (this.mDisAbleV3Async != 1) goto L9;
        TTVideoEngineLog.i(TAG, "report sync");
        VideoEventManager.instance.addEventV2(this.mEventBase.isUploadLogEnabled, toJsonObject(), monitorName);
        return;
    L9:
        TTVideoEngineLog.i(TAG, "report async");
        VideoEventBase r100 = this.mEventBase;
        EngineThreadPool.addExecuteTask(new AsyncGetLogDataRunnable(r100.mContext, this, r100));
        return;
    L5:
        this.mErrorStage = "beforePlay";
        goto L7
    }

    public VideoEventOneError(VideoEventBase r100) {
        this.mErrorCode = Integer.MIN_VALUE;
        this.mErrorType = Integer.MIN_VALUE;
        this.mErrorStage = "";
        this.mCDNUrl = "";
        this.mCDNIP = "";
        this.f457077vsc = Integer.MIN_VALUE;
        this.vscMessage = "";
        this.mDisAbleV3Async = 0;
        this.mEventBase = r100;
        this.mRetryCount = 0;
        this.mFirstFrameShown = false;
    }

    public static /* synthetic */ JSONObject access$000(VideoEventOneError r100) {
        return r100.toJsonObject();
    }

    public void errorHappened(Error r100) {
        this.mErrorCode = r100.code;
        this.mErrorType = r100.getType();
        sendErrorEvent();
    }

    public void errorHappened(int r100, String r101) {
        this.f457077vsc = r100;
        this.vscMessage = r101;
        sendErrorEvent();
    }

    public void movieShouldRetry(Error r100, int r101, int r102) {
        this.mRetryCount++;
    }
}
