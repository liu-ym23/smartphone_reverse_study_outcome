package db5;

import android.text.TextUtils;
import com.bytedance.ee.bear.utils.LinkUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class j implements Cloneable {
    public int a;
    public int b;
    public final String c;
    public final String d;

    public final j a() {
        return (j) super.clone();
    L4:
        e = move-exception;
        tt5.a.e("Link", "clone Links failed", e, false);
        return null;
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public j(int r1, int r2, String r3) {
        this.a = r1;
        this.b = r2;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        this.c = r3;
        this.d = LinkUtils.a(r3);
    }

    public j(int r1, int r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        this.c = r3;
        if (TextUtils.isEmpty(r4) == false) goto L8;
        r4 = r3;
    L8:
        this.d = LinkUtils.a(r4);
    }
}
