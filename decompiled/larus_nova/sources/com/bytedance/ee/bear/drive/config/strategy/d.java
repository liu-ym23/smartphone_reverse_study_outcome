package com.bytedance.ee.bear.drive.config.strategy;

import android.content.Context;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.platform.DownloadOptions;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority$DownloadPriority;

/* JADX INFO: loaded from: classes16.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DrivePriority$DownloadPriority f224092a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DrivePriority$DownloadPriority f224093b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DrivePriority$DownloadPriority f224094c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DrivePriority$DownloadPriority f224095d = null;

    boolean a(long r100);

    boolean b(long r100, w75.a r101, String r102, DownloadOptions r103);

    String c(String r100);

    String d();

    boolean e(long r100, String r101);

    boolean enableStreaming();

    DrivePriority$DownloadPriority f();

    boolean g(t r100, w75.c r101);

    String getPreviewFileSourceType();

    DriveFilePath h(Context r100);

    String i(w75.a r100);

    static {
        f224092a = DrivePriority$DownloadPriority.USER_INTERACTION;
        f224093b = DrivePriority$DownloadPriority.PREVIEW;
        f224094c = DrivePriority$DownloadPriority.MANUAL_OFFLINE;
        f224095d = DrivePriority$DownloadPriority.PRELOAD;
    }
}
