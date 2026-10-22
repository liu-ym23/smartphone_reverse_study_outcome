package com.larus.office.card.minutes.model;

import com.larus.im.bean.message.block.AudioRecordErrorCode;

/* JADX INFO: loaded from: classes29.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f361510a = 0;

    static {
    }

    public static boolean a(Integer r100) {
        if (r100 == null) goto L13;
        int r101 = AudioRecordErrorCode.NO_ERROR.getValue();
        if (r100.intValue() == r101) goto L13;
        int r102 = AudioRecordErrorCode.ERROR_AUTH_FINISHED.getValue();
        if (r100.intValue() == r102) goto L13;
        int r103 = AudioRecordErrorCode.ERROR_AUTH_FAILED.getValue();
        if (r100.intValue() == r103) goto L13;
        int r104 = AudioRecordErrorCode.ERROR_START_FAILED_IN_SAME_DEVICE.getValue();
        if (r100.intValue() == r104) goto L13;
        return true;
    L13:
        return false;
    }
}
