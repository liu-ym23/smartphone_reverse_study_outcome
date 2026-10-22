package com.ss.android.vesdk.settings;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEVideoEncodePreset extends Enum<VEVideoEncodePreset> implements Parcelable {
    private static final /* synthetic */ VEVideoEncodePreset[] $VALUES = null;
    public static final Parcelable.Creator<VEVideoEncodePreset> CREATOR = null;
    public static final VEVideoEncodePreset ENCODE_LEVEL_FAST = null;
    public static final VEVideoEncodePreset ENCODE_LEVEL_FASTER = null;
    public static final VEVideoEncodePreset ENCODE_LEVEL_MEDIUM = null;
    public static final VEVideoEncodePreset ENCODE_LEVEL_PLACEBO = null;
    public static final VEVideoEncodePreset ENCODE_LEVEL_SLOW = null;
    public static final VEVideoEncodePreset ENCODE_LEVEL_SLOWER = null;
    public static final VEVideoEncodePreset ENCODE_LEVEL_SUPERFAST = null;
    public static final VEVideoEncodePreset ENCODE_LEVEL_ULTRAFAST = null;
    public static final VEVideoEncodePreset ENCODE_LEVEL_VERYFAST = null;
    public static final VEVideoEncodePreset ENCODE_LEVEL_VERYSLOW = null;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private static /* synthetic */ VEVideoEncodePreset[] $values() {
        return new VEVideoEncodePreset[]{ENCODE_LEVEL_ULTRAFAST, ENCODE_LEVEL_SUPERFAST, ENCODE_LEVEL_VERYFAST, ENCODE_LEVEL_FASTER, ENCODE_LEVEL_FAST, ENCODE_LEVEL_MEDIUM, ENCODE_LEVEL_SLOW, ENCODE_LEVEL_SLOWER, ENCODE_LEVEL_VERYSLOW, ENCODE_LEVEL_PLACEBO};
    }

    static {
        ENCODE_LEVEL_ULTRAFAST = new VEVideoEncodePreset("ENCODE_LEVEL_ULTRAFAST", 0);
        ENCODE_LEVEL_SUPERFAST = new VEVideoEncodePreset("ENCODE_LEVEL_SUPERFAST", 1);
        ENCODE_LEVEL_VERYFAST = new VEVideoEncodePreset("ENCODE_LEVEL_VERYFAST", 2);
        ENCODE_LEVEL_FASTER = new VEVideoEncodePreset("ENCODE_LEVEL_FASTER", 3);
        ENCODE_LEVEL_FAST = new VEVideoEncodePreset("ENCODE_LEVEL_FAST", 4);
        ENCODE_LEVEL_MEDIUM = new VEVideoEncodePreset("ENCODE_LEVEL_MEDIUM", 5);
        ENCODE_LEVEL_SLOW = new VEVideoEncodePreset("ENCODE_LEVEL_SLOW", 6);
        ENCODE_LEVEL_SLOWER = new VEVideoEncodePreset("ENCODE_LEVEL_SLOWER", 7);
        ENCODE_LEVEL_VERYSLOW = new VEVideoEncodePreset("ENCODE_LEVEL_VERYSLOW", 8);
        ENCODE_LEVEL_PLACEBO = new VEVideoEncodePreset("ENCODE_LEVEL_PLACEBO", 9);
        $VALUES = $values();
        CREATOR = new a();
    }

    public static VEVideoEncodePreset[] values() {
        return (VEVideoEncodePreset[]) $VALUES.clone();
    }

    public static VEVideoEncodePreset valueOf(String r100) {
        return (VEVideoEncodePreset) r27.a.a(VEVideoEncodePreset.class, r100);
    }

    private VEVideoEncodePreset(String r100, int r101) {
        super(r100, r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(ordinal());
    }
}
