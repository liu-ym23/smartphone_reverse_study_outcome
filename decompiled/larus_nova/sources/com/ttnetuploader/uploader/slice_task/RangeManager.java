package com.ttnetuploader.uploader.slice_task;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ttnetuploader.uploader.api.Parameters;
import com.ttnetuploader.uploader.api.ULLog;
import com.ttnetuploader.uploader.api.a;
import com.ttnetuploader.uploader.utils.CommonTools;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes41.dex */
public class RangeManager {
    public static final int SLICE_LEN_THRESHOLD = 1048576;
    private long mInitLen;
    private ArrayList<Range> mNeedUploadRangeArray;
    private Parameters mParam;

    public Range getRange() {
        monitor-enter(this);
        ArrayList<Range> r100 = this.mNeedUploadRangeArray;     // Catch: Throwable -> L19
        if (r100 != null) goto L6;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L19
        return null;
    L6:
        if (r100.isEmpty() == true) goto L16;
        Range r101 = this.mNeedUploadRangeArray.get(0);     // Catch: Throwable -> L19
        if ((r101.end - r101.start) <= (this.mParam.getSliceLen() + 1048576)) goto L13;
        long r102 = r101.start;     // Catch: Throwable -> L19
        Range r103 = new Range(r102, (this.mParam.getSliceLen() + r102) - 1);     // Catch: Throwable -> L19
        r101.start += this.mParam.getSliceLen();     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return r103;
    L13:
        this.mNeedUploadRangeArray.clear();     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return r101;
    L19:
        th = move-exception;
        throw th;
    }

    public boolean isCompleted() {
        monitor-enter(this);
        boolean r100 = this.mNeedUploadRangeArray.isEmpty();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public long getInitLen() {
        return this.mInitLen;
    }

    public RangeManager(ArrayList<Range> r100, Parameters r101) {
        this.mNeedUploadRangeArray = null;
        this.mParam = null;
        this.mInitLen = 0;
        if (ULLog.debug() == false) goto L9;
        long r102 = ((Long) CommonTools.getNonnullValue(this.mParam, new a(), 0L)).longValue();
        StringBuilder r103 = new StringBuilder("RangeManager,rangeList size=");
        if (r100 != null) goto L7;
        int r104 = 0;
    L8:
        r103.append(r104);
        ULLog.taskDebug("RangeManager", r102, "RangeManager", r103.toString());
        goto L9
    L7:
        r104 = r100.size();
    L9:
        this.mParam = r101;
        this.mNeedUploadRangeArray = r100;
        if (r100 != null) goto L12;
        return;
    L12:
        if (r100.isEmpty() == true) goto L16;
        this.mInitLen = ((Range) ListProtector.get(r100, 0)).start;
        return;
    }
}
