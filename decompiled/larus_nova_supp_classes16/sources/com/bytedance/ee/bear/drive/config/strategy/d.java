package com.bytedance.ee.bear.drive.config.strategy;

import android.content.Context;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.platform.DownloadOptions;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface d {
    public static final DrivePriority.DownloadPriority a = null;
    public static final DrivePriority.DownloadPriority b = null;
    public static final DrivePriority.DownloadPriority c = null;
    public static final DrivePriority.DownloadPriority d = null;

    boolean a(long r1);

    boolean b(long r1, w75.a r3, String r4, DownloadOptions r5);

    String c(String r1);

    String d();

    boolean e(long r1, String r3);

    boolean enableStreaming();

    DrivePriority.DownloadPriority f();

    boolean g(t r1, w75.c r2);

    String getPreviewFileSourceType();

    DriveFilePath h(Context r1);

    String i(w75.a r1);

    static {
        a = DrivePriority.DownloadPriority.USER_INTERACTION;
        b = DrivePriority.DownloadPriority.PREVIEW;
        c = DrivePriority.DownloadPriority.MANUAL_OFFLINE;
        d = DrivePriority.DownloadPriority.PRELOAD;
    }
}
