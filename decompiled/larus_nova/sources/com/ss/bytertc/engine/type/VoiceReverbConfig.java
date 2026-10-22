package com.ss.bytertc.engine.type;

/* JADX INFO: loaded from: classes40.dex */
public class VoiceReverbConfig {
    public float damping;
    public float decayTime;
    public float dryGain;
    public float preDelay;
    public float roomSize;
    public float wetGain;

    public String toString() {
        return "VoiceReverbConfig, room_size: " + this.roomSize + ", decay_time: " + this.decayTime + ", damping: " + this.damping + ", wet_gain: " + this.wetGain + ", dry_gain: " + this.dryGain + ", pre_delay: " + this.preDelay;
    }

    public VoiceReverbConfig(float r100, float r101, float r102, float r103, float r104, float r105) {
        this.roomSize = r100;
        this.decayTime = r101;
        this.damping = r102;
        this.wetGain = r103;
        this.dryGain = r104;
        this.preDelay = r105;
    }
}
