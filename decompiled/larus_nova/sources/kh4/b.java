package kh4;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f503458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f503459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f503460c;

    public b(JSONArray r100) {
        this.f503458a = r100.optString(0).split(",");     // Catch: Throwable -> L14
        this.f503459b = r100.optString(1).split(",");     // Catch: Throwable -> L14
        this.f503460c = new JSONObject();     // Catch: Throwable -> L14
        int r101 = 2;
    L5:
        if (r101 >= r100.length()) goto L21;
        String r102 = r100.optString(r101);     // Catch: Throwable -> L14
        if ("".equals(r102) == true) goto L12;
        String[] r103 = r102.split(":");     // Catch: Throwable -> L14
        if (r103.length != 2) goto L12;
        this.f503460c.putOpt(r103[0], r103[1]);     // Catch: Throwable -> L14
    L12:
        r101 = r101 + 1;
        goto L5
    L21:
        return;
    }

    public static boolean a(String[] r100, String r101) {
        if (r100 != null) goto L5;
    L19:
        return false;
    L5:
        if (r100.length == 0) goto L19;
        if ("none".equals(r100[0]) == false) goto L11;
        return false;
    L11:
        if ("all".equals(r100[0]) == false) goto L13;
        return true;
    L13:
        int r102 = r100.length;
        int r103 = 0;
    L14:
        if (r103 >= r102) goto L19;
        if (r100[r103].equals(r101) == true) goto L17;
        r103 = r103 + 1;
        goto L14
    L17:
        return true;
    }
}
