package com.google.zxing.oned;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes23.dex */
final enum Code128Writer$MinimalEncoder$Latch extends Enum<Code128Writer$MinimalEncoder$Latch> {
    public static final Code128Writer$MinimalEncoder$Latch A = null;
    public static final Code128Writer$MinimalEncoder$Latch B = null;
    public static final Code128Writer$MinimalEncoder$Latch C = null;
    public static final Code128Writer$MinimalEncoder$Latch NONE = null;
    public static final Code128Writer$MinimalEncoder$Latch SHIFT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Code128Writer$MinimalEncoder$Latch[] f275950a = null;

    static {
        Code128Writer$MinimalEncoder$Latch r100 = new Code128Writer$MinimalEncoder$Latch(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 0);
        A = r100;
        Code128Writer$MinimalEncoder$Latch r101 = new Code128Writer$MinimalEncoder$Latch("B", 1);
        B = r101;
        Code128Writer$MinimalEncoder$Latch r102 = new Code128Writer$MinimalEncoder$Latch("C", 2);
        C = r102;
        Code128Writer$MinimalEncoder$Latch r103 = new Code128Writer$MinimalEncoder$Latch("SHIFT", 3);
        SHIFT = r103;
        Code128Writer$MinimalEncoder$Latch r104 = new Code128Writer$MinimalEncoder$Latch(UserProfileEvent.POSITION_NONE, 4);
        NONE = r104;
        f275950a = new Code128Writer$MinimalEncoder$Latch[]{r100, r101, r102, r103, r104};
    }

    public static Code128Writer$MinimalEncoder$Latch[] values() {
        return (Code128Writer$MinimalEncoder$Latch[]) f275950a.clone();
    }

    public static Code128Writer$MinimalEncoder$Latch valueOf(String r100) {
        return (Code128Writer$MinimalEncoder$Latch) r27.a.a(Code128Writer$MinimalEncoder$Latch.class, r100);
    }

    public Code128Writer$MinimalEncoder$Latch(String r100, int r101) {
        super(r100, r101);
    }
}
