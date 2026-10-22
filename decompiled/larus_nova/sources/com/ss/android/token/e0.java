package com.ss.android.token;

/* JADX INFO: loaded from: classes5.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f449725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f449726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f449727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.sdk.account.utils.j<TicketTrackData> f449728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f449729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f449730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f449731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f449732h;

    public e0() {
        this("", "", "", null, "", -1);
    }

    public final String a() {
        return "TokenObject{token='" + TokenFactory.l(this.f449725a) + "', tsSign='" + TokenFactory.v(this.f449726b) + "', attestTsSign='" + TokenFactory.l(this.f449727c) + "', tokenHash='" + TokenFactory.l(this.f449729e) + "', tokenEncrypted='" + TokenFactory.l(this.f449730f) + "', tokenTlbTag='" + TokenFactory.l(this.f449731g) + "', isLogin=" + this.f449732h + ", trackData=" + this.f449728d + '}';
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("TokenObject{token='");
        r100.append(this.f449725a);
        r100.append("', tsSign='");
        r100.append(this.f449726b);
        r100.append("', attestTsSign='");
        r100.append(this.f449727c);
        r100.append("', hasTrackData=");
        com.bytedance.sdk.account.utils.j<TicketTrackData> r101 = this.f449728d;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        r100.append(r102);
        r100.append(", tokenHash='");
        r100.append(this.f449729e);
        r100.append("', tokenEncrypted='");
        r100.append(this.f449730f);
        r100.append("', tokenTlbTag='");
        r100.append(this.f449731g);
        r100.append("', isLogin=");
        r100.append(this.f449732h);
        r100.append('}');
        return r100.toString();
    L5:
        if (r101.isValid() == false) goto L7;
        r102 = true;
        goto L8
    }

    public e0(String r100, String r101, String r102, com.bytedance.sdk.account.utils.j<TicketTrackData> r103, String r104, int r105) {
        this.f449725a = r100;
        this.f449726b = r101;
        this.f449727c = r102;
        this.f449728d = r103;
        this.f449731g = r104;
        this.f449732h = r105;
    }
}
