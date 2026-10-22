package com.ss.ttm.utils;

import android.content.Context;
import java.util.Locale;

/* JADX INFO: loaded from: classes40.dex */
public class AVErrorInfo {
    public static final String CRASH = "crash";
    public static final String ERROR = "error";
    private static StringBuilder PHONE_INFO;

    public AVErrorInfo() {
    }

    public static final void setupPhoneInfo(Context r110, StringBuilder r111) {
        String[] r100 = VersionInfo.getVersion();
        if (r100 == null) goto L5;
        r111.append(String.format("version:%s,%s,%s\r\n", new Object[]{r100[0], r100[1], r100[2]}));
        r111.append("\r\n");
    L5:
        long[] r101 = MemoryInfo.getRomMemroy();
        if (r101 == null) goto L8;
        r111.append(String.format(Locale.US, "rom memory totle:%d,availe:%d\r\n", new Object[]{Long.valueOf(r101[0]), Long.valueOf(r101[1])}));
        r111.append("\r\n");
    L8:
        long r102 = MemoryInfo.getAvailMemory(r110);
        long r103 = MemoryInfo.getTolalMemory();
        Locale r104 = Locale.US;
        r111.append(String.format(r104, "ram memory totle:%d,availe:%d\r\n", new Object[]{Long.valueOf(r103), Long.valueOf(r102)}));
        r111.append("\r\n");
        long[] r112 = HardWareInfo.getSDCardSize(r110);
        if (r112 == null) goto L12;
        r111.append(String.format(r104, "sdcard totle:%d,availe:%d\r\n", new Object[]{Long.valueOf(r112[0]), Long.valueOf(r112[1])}));
        r111.append("\r\n");
        return;
    }

    public static void setupErrorInfo(Context r100, StringBuilder r101, String r102, String r103, String r104) {
        if (PHONE_INFO != null) goto L5;
        StringBuilder r105 = new StringBuilder();
        PHONE_INFO = r105;
        setupPhoneInfo(r100, r105);
    L5:
        r101.append(PHONE_INFO);
        r101.append("\r\n");
        r101.append(r102);
        r101.append(":");
        r101.append(r103);
    }
}
