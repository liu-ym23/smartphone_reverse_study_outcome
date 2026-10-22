package com.huawei.hms.common.data;

import com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class FreezableUtils {
    public FreezableUtils() {
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] r100) {
        return freezeIterable(Arrays.asList(r100));
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> r100) {
        MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1 r101 = (ArrayList<T>) new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<E> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r101.add(r102.next().freeze());
        goto L7
    L9:
        return r101;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> r100) {
        return freezeIterable(r100);
    }
}
