package i9a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f488820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f488821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f488822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f488823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f488824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f488825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, String> f488826g;

    public final String toString() {
        return "UploadInfo{lastUploadTime=" + this.f488820a + ", isUploading=" + this.f488821b + ", commandId='" + this.f488822c + "', cloudMsgResponseCode=" + this.f488823d + ", errorMsg='" + this.f488824e + "', operateTime=" + this.f488825f + ", specificParams=" + this.f488826g + '}';
    }

    public b(String r100, HashMap r101) {
        this.f488823d = 2;
        this.f488824e = "no error";
        this.f488825f = 0;
        this.f488826g = null;
        this.f488820a = 0;
        this.f488821b = false;
        this.f488822c = r100;
        this.f488825f = System.currentTimeMillis();
        this.f488826g = r101;
    }
}
