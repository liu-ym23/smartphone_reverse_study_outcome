package hr7;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f486889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f486892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f486893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f486894f;

    public a(String r100, String r101, String r102) {
        this.f486889a = System.currentTimeMillis();
        this.f486890b = r100;
        this.f486891c = r101;
        this.f486892d = r102;
    }

    public static String a(String r100, String r101, String r102) {
        StringBuilder r103 = new StringBuilder();
        if (TextUtils.isEmpty(r100) == true) goto L6;
        r103.append(r100);
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        if (r103.length() <= 0) goto L10;
        r103.append("_");
    L10:
        r103.append(r101);
    L12:
        if (TextUtils.isEmpty(r102) == true) goto L18;
        if (r103.length() <= 0) goto L16;
        r103.append("_");
    L16:
        r103.append(r102);
    L18:
        return r103.toString();
    }
}
