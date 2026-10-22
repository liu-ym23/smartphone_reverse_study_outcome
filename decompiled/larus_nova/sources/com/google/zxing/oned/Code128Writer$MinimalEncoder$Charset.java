package com.google.zxing.oned;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes23.dex */
final enum Code128Writer$MinimalEncoder$Charset extends Enum<Code128Writer$MinimalEncoder$Charset> {
    public static final Code128Writer$MinimalEncoder$Charset A = null;
    public static final Code128Writer$MinimalEncoder$Charset B = null;
    public static final Code128Writer$MinimalEncoder$Charset C = null;
    public static final Code128Writer$MinimalEncoder$Charset NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Code128Writer$MinimalEncoder$Charset[] f275949a = null;

    static {
        Code128Writer$MinimalEncoder$Charset r100 = new Code128Writer$MinimalEncoder$Charset(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 0);
        A = r100;
        Code128Writer$MinimalEncoder$Charset r101 = new Code128Writer$MinimalEncoder$Charset("B", 1);
        B = r101;
        Code128Writer$MinimalEncoder$Charset r102 = new Code128Writer$MinimalEncoder$Charset("C", 2);
        C = r102;
        Code128Writer$MinimalEncoder$Charset r103 = new Code128Writer$MinimalEncoder$Charset(UserProfileEvent.POSITION_NONE, 3);
        NONE = r103;
        f275949a = new Code128Writer$MinimalEncoder$Charset[]{r100, r101, r102, r103};
    }

    public static Code128Writer$MinimalEncoder$Charset[] values() {
        return (Code128Writer$MinimalEncoder$Charset[]) f275949a.clone();
    }

    public static Code128Writer$MinimalEncoder$Charset valueOf(String r100) {
        return (Code128Writer$MinimalEncoder$Charset) r27.a.a(Code128Writer$MinimalEncoder$Charset.class, r100);
    }

    public Code128Writer$MinimalEncoder$Charset(String r100, int r101) {
        super(r100, r101);
    }
}
