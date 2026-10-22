package com.huawei.hms.common.data;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class DataBufferUtils {
    public static final int ARGS_BUNDLE = 4;
    public static final int ARGS_COLUMN = 1;
    public static final int ARGS_CURSOR = 2;
    public static final int ARGS_STATUS = 3;
    public static final int ARGS_VERSION = 1000;
    public static final String NEXT_PAGE = "next_page";
    public static final String PREV_PAGE = "prev_page";

    private DataBufferUtils() {
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> r100) {
        if (r100 == null) goto L4;
        MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1 r101 = (ArrayList<T>) new ArrayList(r100.getCount());
        Iterator<E> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r101.add(r102.next().freeze());
        goto L7
    L9:
        r100.release();
        return r101;
    L4:
        return new ArrayList();
    }

    public static boolean hasData(DataBuffer<?> r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getCount() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean hasNextPage(DataBuffer<?> r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return a(r100.getMetadata(), "next_page");
    }

    public static boolean hasPrevPage(DataBuffer<?> r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return a(r100.getMetadata(), PREV_PAGE);
    }

    private static boolean a(Bundle r100, String r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getString(r101) == null) goto L9;
        return true;
    L9:
        return false;
    }
}
