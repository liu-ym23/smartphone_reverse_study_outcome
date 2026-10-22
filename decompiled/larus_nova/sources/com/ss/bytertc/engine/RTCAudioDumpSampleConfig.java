package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class RTCAudioDumpSampleConfig {
    public boolean aec_far_in_enable;
    public boolean aec_far_in_ref_enable;
    public boolean aec_near_in_enable;
    public boolean aec_out_enable;
    public boolean agc_out_enable;
    public boolean ainr_out_enable;
    public boolean audio_share_in_enable;
    public boolean audio_share_out_enable;
    public boolean audio_share_win_ref_enable;
    public boolean decoder_out_enable;
    public boolean external_audio_in_enable;
    public boolean front_aec_near_ref_enable;
    public boolean loopback_device_in_enable;
    public boolean mix_out_enable;
    public boolean ns_out_enable;
    public boolean pitchfilter_out_enable;
    public boolean postprocess_out_enable;
    public boolean push_audio_frame_in_enable;
    public boolean remotefilter_out_enable;
    public boolean send2encoder_enable;

    private void reset() {
        this.aec_near_in_enable = false;
        this.aec_far_in_enable = false;
        this.aec_far_in_ref_enable = false;
        this.aec_out_enable = false;
        this.agc_out_enable = false;
        this.ns_out_enable = false;
        this.ainr_out_enable = false;
        this.mix_out_enable = false;
        this.send2encoder_enable = false;
        this.audio_share_in_enable = false;
        this.audio_share_win_ref_enable = false;
        this.audio_share_out_enable = false;
        this.external_audio_in_enable = false;
        this.pitchfilter_out_enable = false;
        this.decoder_out_enable = false;
        this.front_aec_near_ref_enable = false;
        this.postprocess_out_enable = false;
        this.remotefilter_out_enable = false;
        this.push_audio_frame_in_enable = false;
        this.loopback_device_in_enable = false;
    }

    public void AllMode() {
        this.aec_near_in_enable = true;
        this.aec_far_in_enable = true;
        this.aec_far_in_ref_enable = true;
        this.aec_out_enable = true;
        this.agc_out_enable = true;
        this.ns_out_enable = true;
        this.ainr_out_enable = true;
        this.mix_out_enable = true;
        this.send2encoder_enable = true;
        this.audio_share_in_enable = true;
        this.audio_share_win_ref_enable = true;
        this.audio_share_out_enable = true;
        this.external_audio_in_enable = true;
        this.pitchfilter_out_enable = true;
        this.decoder_out_enable = true;
        this.front_aec_near_ref_enable = true;
        this.postprocess_out_enable = true;
        this.remotefilter_out_enable = true;
        this.push_audio_frame_in_enable = true;
        this.loopback_device_in_enable = true;
    }

    public String toString() {
        if (this.aec_near_in_enable == false) goto L5;
        String r100 = "[\"aec_near_in\",";
    L7:
        if (this.aec_far_in_enable == false) goto L10;
        r100 = r100 + "\"aec_far_in\",";
    L10:
        if (this.aec_far_in_ref_enable == false) goto L13;
        r100 = r100 + "\"aec_far_in_ref\",";
    L13:
        if (this.aec_out_enable == false) goto L16;
        r100 = r100 + "\"aec_out\",";
    L16:
        if (this.agc_out_enable == false) goto L19;
        r100 = r100 + "\"agc_out\",";
    L19:
        if (this.ns_out_enable == false) goto L22;
        r100 = r100 + "\"ns_out\",";
    L22:
        if (this.ainr_out_enable == false) goto L25;
        r100 = r100 + "\"ainr_out\",";
    L25:
        if (this.mix_out_enable == false) goto L28;
        r100 = r100 + "\"mix_out\",";
    L28:
        if (this.send2encoder_enable == false) goto L31;
        r100 = r100 + "\"send2encoder\",";
    L31:
        if (this.audio_share_in_enable == false) goto L34;
        r100 = r100 + "\"audio_share_in\",";
    L34:
        if (this.audio_share_win_ref_enable == false) goto L37;
        r100 = r100 + "\"audio_share_win_ref\",";
    L37:
        if (this.audio_share_out_enable == false) goto L40;
        r100 = r100 + "\"audio_share_out\",";
    L40:
        if (this.external_audio_in_enable == false) goto L43;
        r100 = r100 + "\"external_audio_in\",";
    L43:
        if (this.pitchfilter_out_enable == false) goto L46;
        r100 = r100 + "\"pitchfilter_out\",";
    L46:
        if (this.decoder_out_enable == false) goto L49;
        r100 = r100 + "\"decoder_out\",";
    L49:
        if (this.front_aec_near_ref_enable == false) goto L52;
        r100 = r100 + "\"front_aec_near_ref\",";
    L52:
        return r100 + "]";
    L5:
        r100 = "[";
        goto L7
    }

    public RTCAudioDumpSampleConfig() {
        this.aec_near_in_enable = false;
        this.aec_far_in_enable = false;
        this.aec_far_in_ref_enable = false;
        this.aec_out_enable = false;
        this.agc_out_enable = false;
        this.ns_out_enable = false;
        this.ainr_out_enable = false;
        this.mix_out_enable = false;
        this.send2encoder_enable = false;
        this.audio_share_in_enable = false;
        this.audio_share_win_ref_enable = false;
        this.audio_share_out_enable = false;
        this.external_audio_in_enable = false;
        this.pitchfilter_out_enable = false;
        this.decoder_out_enable = false;
        this.front_aec_near_ref_enable = false;
        this.postprocess_out_enable = false;
        this.remotefilter_out_enable = false;
        this.push_audio_frame_in_enable = false;
        this.loopback_device_in_enable = false;
        reset();
    }

    public void NormalMode() {
        reset();
        this.aec_near_in_enable = true;
        this.aec_far_in_ref_enable = true;
        this.mix_out_enable = true;
    }

    public boolean getAecFarIn() {
        return this.aec_far_in_enable;
    }

    public boolean getAecFarInRef() {
        return this.aec_far_in_ref_enable;
    }

    public boolean getAecNearIn() {
        return this.aec_near_in_enable;
    }

    public boolean getAecOut() {
        return this.aec_out_enable;
    }

    public boolean getAgcOut() {
        return this.agc_out_enable;
    }

    public boolean getAinrOut() {
        return this.ainr_out_enable;
    }

    public boolean getAudioShareIn() {
        return this.audio_share_in_enable;
    }

    public boolean getAudioShareOut() {
        return this.audio_share_out_enable;
    }

    public boolean getAudioShareWinRef() {
        return this.audio_share_win_ref_enable;
    }

    public boolean getDecodeOut() {
        return this.decoder_out_enable;
    }

    public boolean getExternalAudioIn() {
        return this.external_audio_in_enable;
    }

    public boolean getFrontAecRef() {
        return this.front_aec_near_ref_enable;
    }

    public boolean getLoopbackDeviceIn() {
        return this.loopback_device_in_enable;
    }

    public boolean getMixOut() {
        return this.mix_out_enable;
    }

    public boolean getNsOut() {
        return this.ns_out_enable;
    }

    public boolean getPitchFilterOut() {
        return this.pitchfilter_out_enable;
    }

    public boolean getPostProcessOut() {
        return this.postprocess_out_enable;
    }

    public boolean getPushAudioFrameIn() {
        return this.push_audio_frame_in_enable;
    }

    public boolean getRemoteFilterOut() {
        return this.remotefilter_out_enable;
    }

    public boolean getSend2encoder() {
        return this.send2encoder_enable;
    }
}
