package com.ttnetuploader.uploader.slice_task;

import com.ttnetuploader.uploader.api.Parameters;

/* JADX INFO: loaded from: classes41.dex */
public class SliceConfig {
    public static final int LAN_MSG_TYPE_DATA = 2;
    public static final int LAN_MSG_TYPE_DEFAULT = 0;
    public static final int LAN_MSG_TYPE_DELETE = 3;
    public static final int LAN_MSG_TYPE_DISK_QUERY = 4;
    public static final int LAN_MSG_TYPE_KEEP_ALIVE = 6;
    public static final int LAN_MSG_TYPE_QUERY = 1;
    public static final int LAN_MSG_TYPE_SUSPEND = 5;
    private Parameters mParam;
    private Range mRange;
    private int mSliceType;
    private String mSliceUrl;

    public long getEnd() {
        Range r100 = this.mRange;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.end;
    }

    public long getStart() {
        Range r100 = this.mRange;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.start;
    }

    public Parameters getParam() {
        return this.mParam;
    }

    public int getSliceType() {
        return this.mSliceType;
    }

    public String getSliceUrl() {
        return this.mSliceUrl;
    }

    public void setSliceUrl(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mSliceUrl = r100;
    }

    public void updateRange(long r100, long r101) {
        Range r102 = this.mRange;
        r102.start = r100;
        r102.end = r101;
    }

    public SliceConfig(Parameters r100, Range r101, int r102) {
        this.mSliceUrl = "";
        this.mParam = r100;
        this.mRange = r101;
        this.mSliceType = r102;
        this.mSliceUrl = r101.rangeUrl;
    }
}
