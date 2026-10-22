package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import java.util.List;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface IPriorityAdjuster {
    List<Integer> adjust(c r1, List<Integer> r2);

    String getName();
}
