package com.ss.android.socialbase.downloader.segment;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class SegmentUtils {
    public SegmentUtils() {
    }

    public static long getDownloadedBytes(List<Segment> r110) {
        Iterator<Segment> r111 = r110.iterator();
        long r100 = 0;
    L3:
        long r101 = -1;
        long r102 = -1;
    L5:
        if (r111.hasNext() == false) goto L20;
        Segment r112 = r111.next();
        if (r101 == (-1)) goto L9;
        if (r112.getStartOffset() <= r102) goto L14;
        r100 = r100 + (r102 - r101);
        if (r112.getDownloadBytes() <= 0) goto L3;
        r101 = r112.getStartOffset();
        r102 = r112.getCurrentOffset();
        goto L5
    L14:
        if (r112.getCurrentOffset() <= r102) goto L5;
        r102 = r112.getCurrentOffset();
        goto L5
    L9:
        if (r112.getDownloadBytes() <= 0) goto L5;
        r101 = r112.getStartOffset();
        r102 = r112.getCurrentOffset();
        goto L5
    L20:
        if (r101 >= 0) goto L22;
        return r100;
    L22:
        if (r102 > r101) goto L24;
        return r100;
    L24:
        return r100 + (r102 - r101);
    }

    public static long getFirstOffset(List<Segment> r100) {
        int r101 = r100.size();
        long r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L10;
        Segment r104 = (Segment) ListProtector.get(r100, r103);
        if (r104.getStartOffset() > r102) goto L10;
        if (r104.getCurrentOffsetRead() <= r102) goto L9;
        r102 = r104.getCurrentOffsetRead();
    L9:
        r103 = r103 + 1;
    L10:
        return r102;
    }
}
