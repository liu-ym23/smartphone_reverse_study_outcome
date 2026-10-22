package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import java.util.List;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
public interface IPriorityAdjuster {
    List<Integer> adjust(c r100, List<Integer> r101);

    String getName();
}
