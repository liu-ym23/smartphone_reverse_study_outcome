package eo0;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f473249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f473250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f473251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f473252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f473253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f473254f;

    public a() {
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{\"path\":\"");
        r100.append(this.f473249a);
        String r101 = "";
        if ("0".equals(this.f473250b) == false) goto L5;
        String r102 = "";
    L6:
        r100.append(r102);
        if (TextUtils.isEmpty(this.f473251c) == false) goto L9;
        String r103 = "";
    L10:
        r100.append(r103);
        if (this.f473254f == 0) goto L14;
        r101 = "\", \"time\":\"" + this.f473254f;
    L14:
        r100.append(r101);
        r100.append("\", \"latency\":\"");
        r100.append(this.f473253e);
        r100.append("\", \"id\":\"");
        r100.append(this.f473252d);
        r100.append("\"}");
        return r100.toString();
    L9:
        r103 = "\", \"msg\":\"" + this.f473251c;
        goto L10
    L5:
        r102 = "\", \"code\":\"" + this.f473250b;
        goto L6
    }
}
