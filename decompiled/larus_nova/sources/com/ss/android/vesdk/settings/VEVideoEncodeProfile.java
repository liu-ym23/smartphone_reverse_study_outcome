package com.ss.android.vesdk.settings;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEVideoEncodeProfile extends Enum<VEVideoEncodeProfile> implements Parcelable {
    private static final /* synthetic */ VEVideoEncodeProfile[] $VALUES = null;
    public static final Parcelable.Creator<VEVideoEncodeProfile> CREATOR = null;
    public static final VEVideoEncodeProfile ENCODE_PROFILE_BASELINE = null;
    public static final VEVideoEncodeProfile ENCODE_PROFILE_HIGH = null;
    public static final VEVideoEncodeProfile ENCODE_PROFILE_MAIN = null;
    public static final VEVideoEncodeProfile ENCODE_PROFILE_UNKNOWN = null;

    private static /* synthetic */ VEVideoEncodeProfile[] $values() {
        return new VEVideoEncodeProfile[]{ENCODE_PROFILE_UNKNOWN, ENCODE_PROFILE_BASELINE, ENCODE_PROFILE_MAIN, ENCODE_PROFILE_HIGH};
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        ENCODE_PROFILE_UNKNOWN = new VEVideoEncodeProfile("ENCODE_PROFILE_UNKNOWN", 0);
        ENCODE_PROFILE_BASELINE = new VEVideoEncodeProfile("ENCODE_PROFILE_BASELINE", 1);
        ENCODE_PROFILE_MAIN = new VEVideoEncodeProfile("ENCODE_PROFILE_MAIN", 2);
        ENCODE_PROFILE_HIGH = new VEVideoEncodeProfile("ENCODE_PROFILE_HIGH", 3);
        $VALUES = $values();
        CREATOR = new a();
    }

    public static VEVideoEncodeProfile[] values() {
        return (VEVideoEncodeProfile[]) $VALUES.clone();
    }

    public static VEVideoEncodeProfile valueOf(String r100) {
        return (VEVideoEncodeProfile) r27.a.a(VEVideoEncodeProfile.class, r100);
    }

    public static VEVideoEncodeProfile valueOfString(String r100) {
        VEVideoEncodeProfile r101 = ENCODE_PROFILE_UNKNOWN;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        if ("baseline".equals(r100) == false) goto L8;
        return ENCODE_PROFILE_BASELINE;
    L8:
        if (PullConfiguration.PROCESS_NAME_MAIN.equals(r100) == false) goto L11;
        return ENCODE_PROFILE_MAIN;
    L11:
        if ("high".equals(r100) == true) goto L13;
        return r101;
    L13:
        return ENCODE_PROFILE_HIGH;
    }

    private VEVideoEncodeProfile(String r100, int r101) {
        super(r100, r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(ordinal());
    }
}
