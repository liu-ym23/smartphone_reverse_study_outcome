package ob6;

import java.util.Arrays;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f522601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f522602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f522603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f522604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f522605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f522606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f522607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f522608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f522609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f522610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f522611k;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("RtcEngineConfig(rtcExtInfo='");
        r100.append(this.f522601a);
        r100.append("', appId='");
        r100.append(this.f522602b);
        r100.append("', vendor=");
        r100.append(this.f522603c);
        r100.append(", vendorName='");
        r100.append(this.f522604d);
        r100.append("', appSignature=");
        byte[] r101 = this.f522605e;
        if (r101 == null) goto L5;
        String r102 = Arrays.toString(r101);
    L6:
        r100.append(r102);
        r100.append(", channelId='");
        r100.append(this.f522606f);
        r100.append("', token='");
        r100.append(this.f522607g);
        r100.append("', userId='");
        r100.append(this.f522608h);
        r100.append("', interactId='");
        r100.append(this.f522609i);
        r100.append("', interactIdMode=");
        r100.append(this.f522610j);
        r100.append(", businessId='");
        r100.append(this.f522611k);
        r100.append("')");
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public b() {
        this.f522601a = "";
        this.f522602b = "";
        this.f522604d = "";
        this.f522606f = "";
        this.f522607g = "";
        this.f522608h = "";
        this.f522609i = "";
        this.f522611k = "";
    }
}
