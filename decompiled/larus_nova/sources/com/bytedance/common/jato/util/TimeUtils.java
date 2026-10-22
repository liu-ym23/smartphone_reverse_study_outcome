package com.bytedance.common.jato.util;

/* JADX INFO: loaded from: classes15.dex */
public class TimeUtils {
    public TimeUtils() {
    }

    private static native float nProcessCpuTimeMultiplier();

    private static native long nSystemTime(int r100);
}
