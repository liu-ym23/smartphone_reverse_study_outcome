package i27;

import android.app.PendingIntent;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f488047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f488048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f488049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f488050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f488051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f488052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f488053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PendingIntent f488054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Exception f488055i;

    public final String toString() {
        return "MorpheusState{packageName='" + this.f488047a + "', versionCode=" + this.f488048b + ", status=" + this.f488049c + ", totalBytesToDownload=" + this.f488050d + ", bytesDownloaded=" + this.f488051e + ", downloadTime=" + this.f488052f + ", errorCode=" + this.f488053g + ", resolutionIntent=" + this.f488054h + ", exception=" + this.f488055i + '}';
    }

    public a(String r100, int r101, int r102) {
        this.f488052f = 0;
        this.f488053g = 0;
        this.f488047a = r100;
        this.f488048b = r101;
        this.f488049c = r102;
    }
}
