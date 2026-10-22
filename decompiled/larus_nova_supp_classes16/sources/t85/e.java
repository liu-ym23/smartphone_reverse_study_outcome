package t85;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public String a;
    public String b;
    public Bundle c;
    public int d;
    public w75.a e;
    public boolean f;

    public final String a() {
        w75.a r0 = this.e;
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.c().k;
    }

    public final long b() {
        w75.a r0 = this.e;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.c().c;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.a) == false) goto L7;
        return "";
    L7:
        return this.a;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.b) == false) goto L7;
        return "";
    L7:
        return this.b;
    }

    public e() {
    }

    public static String e(String r1, int r2) {
        return r1 + OfflineDoc.DASH_DELIMITER + r2;
    }
}
