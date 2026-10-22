package t85;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f545041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f545042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f545043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f545044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w75.a f545045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f545046f;

    public final String a() {
        w75.a r100 = this.f545045e;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.c().f558567k;
    }

    public final long b() {
        w75.a r100 = this.f545045e;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.c().f558559c;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.f545041a) == false) goto L7;
        return "";
    L7:
        return this.f545041a;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f545042b) == false) goto L7;
        return "";
    L7:
        return this.f545042b;
    }

    public e() {
    }

    public static String e(String r100, int r101) {
        return r100 + "_" + r101;
    }
}
