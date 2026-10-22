package zf2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public final String toString() {
        return "AudioEncodeConfig{codecType='" + this.a + "'encMode='" + this.b + "', channelNum='" + this.c + "', encBitrate='" + this.d + "', useDtx='" + this.e + "', useInbandfec='" + this.f + "', sampleRate='" + this.g + "', packetSize='" + this.h + "'}";
    }

    public e() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
    }

    public e(int r1, int r2, int r3, int r4, int r5, int r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = -1;
        this.h = r7;
    }
}
