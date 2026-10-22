package com.ss.bytedance.ies.audiorecord.api.model;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/ss/bytedance/ies/audiorecord/api/model/KtvMidiData;", "", TextureRenderKeys.KEY_IS_PITCH, "", "startMs", "durationMs", "velocity", "(IIII)V", "getDurationMs", "()I", "getPitch", "getStartMs", "getVelocity", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "audiorecord-api-0.0.0.2-alpha.93@aar_release"}, k = 1, mv = {1, 1, 16})
public final class KtvMidiData {
    private final int durationMs;
    private final int pitch;
    private final int startMs;
    private final int velocity;

    public static /* synthetic */ KtvMidiData copy$default(KtvMidiData r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.pitch;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.startMs;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.durationMs;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.velocity;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.pitch;
    }

    public final int component2() {
        return this.startMs;
    }

    public final int component3() {
        return this.durationMs;
    }

    public final int component4() {
        return this.velocity;
    }

    public final KtvMidiData copy(int r100, int r101, int r102, int r103) {
        return new KtvMidiData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof KtvMidiData) == false) goto L14;
        KtvMidiData r101 = (KtvMidiData) r100;
        if (this.pitch == r101.pitch) goto L8;
        return false;
    L8:
        if (this.startMs == r101.startMs) goto L10;
        return false;
    L10:
        if (this.durationMs == r101.durationMs) goto L12;
        return false;
    L12:
        if (this.velocity == r101.velocity) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return (((((this.pitch * 31) + this.startMs) * 31) + this.durationMs) * 31) + this.velocity;
    }

    public String toString() {
        return "KtvMidiData(pitch=" + this.pitch + ", startMs=" + this.startMs + ", durationMs=" + this.durationMs + ", velocity=" + this.velocity + ")";
    }

    public final int getDurationMs() {
        return this.durationMs;
    }

    public final int getPitch() {
        return this.pitch;
    }

    public final int getStartMs() {
        return this.startMs;
    }

    public final int getVelocity() {
        return this.velocity;
    }

    public KtvMidiData(int r100, int r101, int r102, int r103) {
        this.pitch = r100;
        this.startMs = r101;
        this.durationMs = r102;
        this.velocity = r103;
    }
}
