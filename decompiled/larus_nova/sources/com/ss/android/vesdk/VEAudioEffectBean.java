package com.ss.android.vesdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioEffectBean implements Parcelable {
    public static final Parcelable.Creator<VEAudioEffectBean> CREATOR = null;
    public int blockSize;
    public float centtone;
    public boolean formatShiftOn;
    public float octative;
    public int phaseAdjustMethod;
    public int phaseResetMode;
    public int pitchTunerMode;
    public int processChMode;
    public float semiton;
    public boolean smoothOn;
    public float speedRatio;
    public int transientDetectMode;
    public int type;
    public int windowMode;

    public class a implements Parcelable.Creator<VEAudioEffectBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioEffectBean createFromParcel(Parcel r100) {
            return new VEAudioEffectBean(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioEffectBean[] newArray(int r100) {
            return new VEAudioEffectBean[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "VEAudioEffectBean{type=" + this.type + ", formatShiftOn=" + this.formatShiftOn + ", smoothOn=" + this.smoothOn + ", processChMode=" + this.processChMode + ", transientDetectMode=" + this.transientDetectMode + ", phaseResetMode=" + this.phaseResetMode + ", phaseAdjustMethod=" + this.phaseAdjustMethod + ", windowMode=" + this.windowMode + ", pitchTunerMode=" + this.pitchTunerMode + ", blockSize=" + this.blockSize + ", centtone=" + this.centtone + ", semiton=" + this.semiton + ", octative=" + this.octative + ", speedRatio=" + this.speedRatio + '}';
    }

    public VEAudioEffectBean(Parcel r100) {
        this.type = r100.readInt();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.formatShiftOn = r102;
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.smoothOn = r101;
        this.processChMode = r100.readInt();
        this.transientDetectMode = r100.readInt();
        this.phaseResetMode = r100.readInt();
        this.phaseAdjustMethod = r100.readInt();
        this.windowMode = r100.readInt();
        this.pitchTunerMode = r100.readInt();
        this.blockSize = r100.readInt();
        this.centtone = r100.readFloat();
        this.semiton = r100.readFloat();
        this.octative = r100.readFloat();
        this.speedRatio = r100.readFloat();
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.type);
        r100.writeByte(this.formatShiftOn ? 1 : 0);
        r100.writeByte(this.smoothOn ? 1 : 0);
        r100.writeInt(this.processChMode);
        r100.writeInt(this.transientDetectMode);
        r100.writeInt(this.phaseResetMode);
        r100.writeInt(this.phaseAdjustMethod);
        r100.writeInt(this.windowMode);
        r100.writeInt(this.pitchTunerMode);
        r100.writeInt(this.blockSize);
        r100.writeFloat(this.centtone);
        r100.writeFloat(this.semiton);
        r100.writeFloat(this.octative);
        r100.writeFloat(this.speedRatio);
    }

    public VEAudioEffectBean(int r100, boolean r101, boolean r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110, float r111, float r112, float r113, float r114) {
        this.type = r100;
        this.formatShiftOn = r101;
        this.smoothOn = r102;
        this.processChMode = r103;
        this.transientDetectMode = r104;
        this.phaseResetMode = r105;
        this.phaseAdjustMethod = r106;
        this.windowMode = r107;
        this.pitchTunerMode = r108;
        this.blockSize = r110;
        this.centtone = r111;
        this.semiton = r112;
        this.octative = r113;
        this.speedRatio = r114;
    }
}
