package q75;

import com.bytedance.ee.bear.drive.config.fg.DriveCacheConfig;
import com.bytedance.ee.bear.drive.config.fg.DriveImageThumbConfig;
import com.bytedance.ee.bear.drive.config.fg.DriveOfficeConfig;
import com.bytedance.ee.bear.drive.config.fg.DrivePreviewConfig;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f531958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f531959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f531960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f531961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f531962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f531963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f531964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile DrivePreviewConfig f531965h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f531966i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile DriveCacheConfig f531967j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile DriveImageThumbConfig f531968k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile DriveOfficeConfig f531969l;

    public final DrivePreviewConfig a() {
        if (this.f531965h != null) goto L6;
        return new DrivePreviewConfig();
    L6:
        return this.f531965h;
    }

    public final String toString() {
        return "DriveConfig{, mPreloadRecentCount=" + this.f531958a + ", mPreloadStarCount=" + this.f531959b + ", mPreloadPinCount=" + this.f531960c + ", mPreloadFileMaxSize=" + this.f531962e + ", mPdfKey='mHcowwObyiKEfLXnamrnCnjmGCoxo8dSe7N5TTpQcxE/bivsZEsqoNDxFGfOYMhGzopzZWB+xNhNoJ3otiHAmNkOIkG7yMJZzMh71EHBULE=', mImportFileMaxSize=" + this.f531964g + ", mDrivePreviewConfig=" + this.f531965h + ", mPreloadCacheVideoSize=" + this.f531963f + ", mDriveCacheConfig=" + this.f531967j + '}';
    }

    public a() {
        this.f531958a = 10;
        this.f531959b = 6;
        this.f531960c = 10;
        this.f531961d = 5;
        this.f531962e = 20971520;
        this.f531963f = 819200;
    }
}
