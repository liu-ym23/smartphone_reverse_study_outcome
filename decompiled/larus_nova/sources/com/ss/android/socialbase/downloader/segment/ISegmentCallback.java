package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.HttpResponse;

/* JADX INFO: loaded from: classes38.dex */
interface ISegmentCallback {
    void applySegment(SegmentReader r100, Segment r101) throws BaseException;

    IOutput createOutput(SegmentReader r100, Segment r101) throws BaseException;

    Segment obtainSegment(SegmentReader r100, UrlRecord r101);

    void onReaderExit(SegmentReader r100);

    void onReaderRun(SegmentReader r100);

    void onSegmentConnected(SegmentReader r100, Segment r101, UrlRecord r102, HttpResponse r103) throws BaseException;

    void onSegmentFailed(SegmentReader r100, UrlRecord r101, Segment r102, BaseException r103);

    boolean onSegmentRetry(SegmentReader r100, UrlRecord r101, Segment r102, BaseException r103, int r104, int r105);

    void unApplySegment(SegmentReader r100, Segment r101);

    void unObtainSegment(SegmentReader r100, Segment r101);
}
