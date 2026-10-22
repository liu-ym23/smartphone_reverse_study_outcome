package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class AudioPropertiesConfig {
    public AudioPropertiesMode audioReportMode;
    public boolean enableSpectrum;
    public boolean enableVad;
    public boolean enableVoicePitch;
    public int interval;
    public AudioReportMode localMainReportMode;
    public float smooth;

    public String toString() {
        return "AudioPropertiesConfig{interval='" + this.interval + "'enable_spectrum='" + this.enableSpectrum + "'enable_vad='" + this.enableVad + "'local_main_report_mode='" + this.localMainReportMode + "'audio_report_mode='" + this.audioReportMode.toString() + "'enable_voice_pitch='" + this.enableVoicePitch + "'}";
    }

    public AudioPropertiesConfig(int r100) {
        this.enableSpectrum = false;
        this.enableVad = false;
        this.localMainReportMode = AudioReportMode.AUDIO_REPORT_MODE_NORMAL;
        this.audioReportMode = AudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE;
        this.smooth = 1.0f;
        this.enableVoicePitch = false;
        this.interval = r100;
    }

    public AudioPropertiesConfig(int r100, boolean r101, boolean r102) {
        this.enableSpectrum = false;
        this.enableVad = false;
        this.localMainReportMode = AudioReportMode.AUDIO_REPORT_MODE_NORMAL;
        AudioPropertiesMode r103 = AudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE;
        this.smooth = 1.0f;
        this.enableVoicePitch = false;
        this.interval = r100;
        this.enableSpectrum = r101;
        this.enableVad = r102;
        this.audioReportMode = r103;
    }

    public AudioPropertiesConfig(int r100, boolean r101, boolean r102, AudioReportMode r103) {
        this.enableSpectrum = false;
        this.enableVad = false;
        this.localMainReportMode = AudioReportMode.AUDIO_REPORT_MODE_NORMAL;
        this.audioReportMode = AudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE;
        this.smooth = 1.0f;
        this.enableVoicePitch = false;
        this.interval = r100;
        this.enableSpectrum = r101;
        this.enableVad = r102;
        this.localMainReportMode = r103;
    }

    public AudioPropertiesConfig(int r100, boolean r101, boolean r102, AudioReportMode r103, float r104) {
        this.enableSpectrum = false;
        this.enableVad = false;
        this.localMainReportMode = AudioReportMode.AUDIO_REPORT_MODE_NORMAL;
        this.audioReportMode = AudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE;
        this.enableVoicePitch = false;
        this.interval = r100;
        this.enableSpectrum = r101;
        this.enableVad = r102;
        this.localMainReportMode = r103;
        this.smooth = r104;
    }

    public AudioPropertiesConfig(int r100, boolean r101, boolean r102, AudioReportMode r103, float r104, AudioPropertiesMode r105) {
        this.enableSpectrum = false;
        this.enableVad = false;
        this.localMainReportMode = AudioReportMode.AUDIO_REPORT_MODE_NORMAL;
        AudioPropertiesMode r106 = AudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE;
        this.enableVoicePitch = false;
        this.interval = r100;
        this.enableSpectrum = r101;
        this.enableVad = r102;
        this.localMainReportMode = r103;
        this.smooth = r104;
        this.audioReportMode = r105;
    }
}
