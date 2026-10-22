package y75;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public long k;
    public int l;
    public long m;
    public long n;
    public String o;
    public String p;
    public String q;
    public String r;
    public boolean s;
    public int t;
    public String u;
    public String v;
    public int w;
    public String x;
    public int y;

    public final DriveFilePath a() {
        DriveFilePath.a r0 = DriveFilePath.Companion;
        String r1 = this.h;
        r0.getClass();
        return DriveFilePath.a.b(r1);
    }

    public final String toString() {
        return "CacheModel{cacheKey='" + this.a + "', objToken='" + this.b + "', srcExt='" + this.c + "', previewExt='" + this.d + "', dataVersion='" + this.e + "', sourceFrom='" + this.f + "', cacheSourceFrom='" + this.g + "', filePath='" + this.h + "', fileSize=" + this.k + ", type=" + this.l + ", lastAccessTime=" + this.m + ", modificationTime=" + this.n + ", fileName='" + this.o + "', cachedUid='" + this.p + "', cacheTenantId='" + this.q + "', previewExtra=" + this.r + ", cacheHost='" + this.t + "', sdkAppId='" + this.u + "', sdkExtra='" + this.v + "', mimeType='" + this.x + "', riskStatus='" + this.y + "'}";
    }

    public a() {
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
    }

    public int getType() {
        return this.l;
    }
}
