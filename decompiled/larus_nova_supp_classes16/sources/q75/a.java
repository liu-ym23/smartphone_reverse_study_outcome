package q75;

import com.bytedance.ee.bear.drive.config.fg.DriveCacheConfig;
import com.bytedance.ee.bear.drive.config.fg.DriveImageThumbConfig;
import com.bytedance.ee.bear.drive.config.fg.DriveOfficeConfig;
import com.bytedance.ee.bear.drive.config.fg.DrivePreviewConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public volatile int a;
    public volatile int b;
    public volatile int c;
    public volatile int d;
    public volatile long e;
    public volatile long f;
    public volatile int g;
    public volatile DrivePreviewConfig h;
    public volatile boolean i;
    public volatile DriveCacheConfig j;
    public volatile DriveImageThumbConfig k;
    public volatile DriveOfficeConfig l;

    public final DrivePreviewConfig a() {
        if (this.h != null) goto L6;
        return new DrivePreviewConfig();
    L6:
        return this.h;
    }

    public final String toString() {
        return "DriveConfig{, mPreloadRecentCount=" + this.a + ", mPreloadStarCount=" + this.b + ", mPreloadPinCount=" + this.c + ", mPreloadFileMaxSize=" + this.e + ", mPdfKey='mHcowwObyiKEfLXnamrnCnjmGCoxo8dSe7N5TTpQcxE/bivsZEsqoNDxFGfOYMhGzopzZWB+xNhNoJ3otiHAmNkOIkG7yMJZzMh71EHBULE=', mImportFileMaxSize=" + this.g + ", mDrivePreviewConfig=" + this.h + ", mPreloadCacheVideoSize=" + this.f + ", mDriveCacheConfig=" + this.j + '}';
    }

    public a() {
        this.a = 10;
        this.b = 6;
        this.c = 10;
        this.d = 5;
        this.e = 20971520;
        this.f = 819200;
    }
}
