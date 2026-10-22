package com.ss.ttvideoengine.log;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class VegaCollector {
    private Map<String, Object> mParamMap;

    public void reset() {
        if (this.mParamMap.isEmpty() == true) goto L6;
        this.mParamMap = new HashMap();
        return;
    }

    public VegaCollector() {
        this.mParamMap = new HashMap();
    }

    public Map<String, Object> get() {
        return this.mParamMap;
    }

    public void retrieveEventParam(VideoEventBase r100, VideoEventOnePlay r101) {
        HashMap r102 = new HashMap();
        LoggerUtils.putToMap(r102, "setds_t", r101.setds_t);
        LoggerUtils.putToMap(r102, "surface_set_time", r101.surfaceSetTime);
        LoggerUtils.putToMap(r102, IVideoEventLogger.LOG_CALLBACK_PLAY_START_TIME, r101.ps_t);
        LoggerUtils.putToMap(r102, GXTemplateKey.GAIAX_PT, r101.f457086pt);
        LoggerUtils.putToMap(r102, INotificationHitPoint.NoticeType.AT, r101.f457078at);
        LoggerUtils.putToMap(r102, "prepare_start_time", r101.prepare_start_time);
        LoggerUtils.putToMap(r102, "formater_create_t", r101.formater_create_t);
        LoggerUtils.putToMap(r102, "demuxer_begin_t", r101.demuxer_begin_t);
        LoggerUtils.putToMap(r102, "tran_ct", r101.tranConnectT);
        LoggerUtils.putToMap(r102, "a_tran_ct", r101.audioTranConnectT);
        LoggerUtils.putToMap(r102, "tran_ft", r101.tranFirstPacketT);
        LoggerUtils.putToMap(r102, "a_tran_ft", r101.audioTranFirstPacketT);
        LoggerUtils.putToMap(r102, "avformat_open_t", r101.avformat_open_t);
        LoggerUtils.putToMap(r102, "demuxer_create_t", r101.demuxer_create_t);
        LoggerUtils.putToMap(r102, "dec_create_t", r101.dec_create_t);
        LoggerUtils.putToMap(r102, "outlet_create_t", r101.outlet_create_t);
        LoggerUtils.putToMap(r102, "prepare_end_time", r101.prepare_end_time);
        LoggerUtils.putToMap(r102, "dns_start_t", r101.dns_start_t);
        LoggerUtils.putToMap(r102, "a_dns_start_t", r101.a_dns_start_t);
        LoggerUtils.putToMap(r102, "dns_end_t", r101.dns_end_t);
        LoggerUtils.putToMap(r102, "a_dns_t", r101.audioDnsT);
        LoggerUtils.putToMap(r102, "v_dec_start_t", r101.v_dec_start_t);
        LoggerUtils.putToMap(r102, "a_dec_start_t", r101.a_dec_start_t);
        LoggerUtils.putToMap(r102, "v_dec_opened_t", r101.v_dec_opened_t);
        LoggerUtils.putToMap(r102, "a_dec_opened_t", r101.a_dec_opened_t);
        LoggerUtils.putToMap(r102, "video_device_start_t", r101.videoDeviceStartTime);
        LoggerUtils.putToMap(r102, "video_device_opened_t", r101.videoDeviceOpenedTime);
        LoggerUtils.putToMap(r102, "audio_device_start_t", r101.audioDeviceStartTime);
        LoggerUtils.putToMap(r102, "audio_device_opened_t", r101.audioDeviceOpenedTime);
        LoggerUtils.putToMap(r102, "re_f_videoframet", r101.receiveFirstVideoFrameT);
        LoggerUtils.putToMap(r102, "re_f_audioframet", r101.receiveFirstAudioFrameT);
        LoggerUtils.putToMap(r102, "de_f_videoframet", r101.decodeFirstVideoFrameT);
        LoggerUtils.putToMap(r102, "de_f_audioframet", r101.decodeFirstAudioFrameT);
        LoggerUtils.putToMap(r102, "v_render_f_t", r101.v_render_f_t);
        LoggerUtils.putToMap(r102, "a_render_f_t", r101.a_render_f_t);
        this.mParamMap.put("req_phase", Integer.valueOf(r101.leave_reason));
        this.mParamMap.put("req_phase_cost", r102);
        this.mParamMap.put("hw", Integer.valueOf(r100.mVideoHW));
        this.mParamMap.put(ITTVideoEngineEventSource.KEY_HW_USER, Integer.valueOf(r100.mVideoHWUser));
    }
}
