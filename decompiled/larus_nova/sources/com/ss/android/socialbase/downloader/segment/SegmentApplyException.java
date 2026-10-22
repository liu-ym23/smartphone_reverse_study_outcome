package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.exception.BaseException;

/* JADX INFO: loaded from: classes6.dex */
class SegmentApplyException extends BaseException {
    public static final int ALREADY_APPLY_BY_OTHER = 1;
    public static final int BAD_SEGMENT = 6;
    public static final int CHANGE_SEGMENT = 5;
    public static final int PREV_END_ADJUST_FAIL = 4;
    public static final int PREV_OVERSTEP = 3;
    public static final int SEGMENT_NOT_EXIST = 2;
    private int applyCode;

    public int getSegmentApplyErrorCode() {
        return this.applyCode;
    }

    public SegmentApplyException(int r100, String r101) {
        super(1072, "applyCode=" + r100 + ", " + r101);
        this.applyCode = r100;
    }
}
