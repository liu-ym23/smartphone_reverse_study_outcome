package ms3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public long a;
    public final boolean b;
    public final long c;
    public final String d;
    public boolean e;
    public String f;
    public final long g;
    public final String h;
    public long i;
    public String j;
    public boolean k;
    public String l;

    public final String toString() {
        return "BatteryLogEntity{id=" + this.a + ", front=" + this.b + ", time=" + this.c + ", type='" + this.d + "', status=" + this.e + ", scene='" + this.f + "', accumulation=" + this.g + ", source='" + this.h + "', versionId=" + this.i + ", processName='" + this.j + "', mainProcess=" + this.k + ", startUuid='" + this.l + "', deleteFlag=false}";
    }

    public String getType() {
        return this.d;
    }

    public a(boolean r1, long r2, String r4, boolean r5, long r6, String r8) {
        this.b = r1;
        this.c = r2;
        this.d = r4;
        this.e = r5;
        this.g = r6;
        this.f = r8;
    }

    public a(boolean r1, long r2, String r4, boolean r5, long r6, String r8, String r9) {
        this.b = r1;
        this.c = r2;
        this.d = r4;
        this.e = r5;
        this.g = r6;
        this.f = r8;
        this.h = r9;
    }
}
