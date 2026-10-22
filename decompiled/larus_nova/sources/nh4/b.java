package nh4;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f519177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f519178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f519179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kh4.b f519180d;

    public b(int r100, int r101, boolean r102, JSONArray r103) {
        this.f519177a = 60000;
        this.f519178b = r100;
        if (r101 <= 0) goto L5;
        this.f519177a = r101;
    L5:
        this.f519179c = r102;
        if (r103 != null) goto L8;
    L11:
        kh4.b r104 = null;
    L12:
        this.f519180d = r104;
        return;
    L8:
        if (r103.length() < 2) goto L11;
        r104 = new kh4.b(r103);
        goto L12
    }
}
