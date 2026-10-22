package ua7;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class f extends c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f549265q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f549266r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f549267s;

    public f(b r100, String r101, String r102) {
        boolean r103 = r100.f549249c;
        super(r103);
        this.f549247a = r100.f549247a;
        this.f549248b = r100.f549248b;
        this.f549249c = r103;
        this.f549250d = r100.f549250d;
        this.f549251e = r100.f549251e;
        this.f549252f = r100.f549252f;
        this.f549253g = r100.f549253g;
        this.f549254h = r100.f549254h;
        this.f549255i = r100.f549255i;
        this.f549256j = r100.f549256j;
        this.f549257k = r100.f549257k;
        this.f549258l = r100.f549258l;
        this.f549259m = r100.f549259m;
        this.f549260n = r100.f549260n;
        if ((r100 instanceof c) == false) goto L5;
        c r104 = (c) r100;
    L5:
        this.f549267s = r101;
        this.f549262p = r102;
        JSONObject r105 = r100.f549259m;
        if (r105 == null) goto L11;
        JSONObject r106 = r105.optJSONObject("data");
        if (r106 == null) goto L12;
        this.f549265q = r106.optInt("multi_account_logout_type");
        this.f549266r = r106.optString("to_sec_uid");
        return;
    L12:
        return;
    }
}
