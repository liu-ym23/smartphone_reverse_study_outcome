package com.cronutils.model.field.value;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum SpecialChar extends Enum<SpecialChar> {
    public static final SpecialChar HASH = null;
    public static final SpecialChar L = null;
    public static final SpecialChar LW = null;
    public static final SpecialChar NONE = null;
    public static final SpecialChar QUESTION_MARK = null;
    public static final SpecialChar W = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SpecialChar[] f273562a = null;

    static {
        SpecialChar r100 = new SpecialChar("LW", 0);
        LW = r100;
        SpecialChar r101 = new SpecialChar("L", 1);
        L = r101;
        SpecialChar r102 = new SpecialChar(ExifInterface.LONGITUDE_WEST, 2);
        W = r102;
        SpecialChar r103 = new SpecialChar("HASH", 3);
        HASH = r103;
        SpecialChar r104 = new SpecialChar("QUESTION_MARK", 4);
        QUESTION_MARK = r104;
        SpecialChar r105 = new SpecialChar(UserProfileEvent.POSITION_NONE, 5);
        NONE = r105;
        f273562a = new SpecialChar[]{r100, r101, r102, r103, r104, r105};
    }

    public static SpecialChar[] values() {
        return (SpecialChar[]) f273562a.clone();
    }

    public static SpecialChar valueOf(String r100) {
        return (SpecialChar) a.a(SpecialChar.class, r100);
    }

    public SpecialChar(String r100, int r101) {
        super(r100, r101);
    }
}
