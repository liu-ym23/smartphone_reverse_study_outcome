package com.ss.android.vesdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public final enum ROTATE_DEGREE extends Enum<ROTATE_DEGREE> implements Parcelable {
    private static final /* synthetic */ ROTATE_DEGREE[] $VALUES = null;
    public static final Parcelable.Creator<ROTATE_DEGREE> CREATOR = null;
    public static final ROTATE_DEGREE ROTATE_180 = null;
    public static final ROTATE_DEGREE ROTATE_270 = null;
    public static final ROTATE_DEGREE ROTATE_90 = null;
    public static final ROTATE_DEGREE ROTATE_NONE = null;

    private static /* synthetic */ ROTATE_DEGREE[] $values() {
        return new ROTATE_DEGREE[]{ROTATE_NONE, ROTATE_90, ROTATE_180, ROTATE_270};
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        ROTATE_NONE = new ROTATE_DEGREE("ROTATE_NONE", 0);
        ROTATE_90 = new ROTATE_DEGREE("ROTATE_90", 1);
        ROTATE_180 = new ROTATE_DEGREE("ROTATE_180", 2);
        ROTATE_270 = new ROTATE_DEGREE("ROTATE_270", 3);
        $VALUES = $values();
        CREATOR = new a();
    }

    public static ROTATE_DEGREE[] values() {
        return (ROTATE_DEGREE[]) $VALUES.clone();
    }

    public static int[] toIntArray(ROTATE_DEGREE[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.length;
        int[] r102 = new int[r100.length];
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L12;
        ROTATE_DEGREE r104 = r100[r103];
        if (r104 != null) goto L10;
        r102[r103] = 0;
    L11:
        r103 = r103 + 1;
        goto L6
    L10:
        r102[r103] = r104.ordinal();
        goto L11
    L12:
        return r102;
    }

    public static ROTATE_DEGREE valueOf(String r100) {
        return (ROTATE_DEGREE) r27.a.a(ROTATE_DEGREE.class, r100);
    }

    private ROTATE_DEGREE(String r100, int r101) {
        super(r100, r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(ordinal());
    }
}
