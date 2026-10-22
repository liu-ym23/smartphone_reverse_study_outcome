package i25;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.bytedance.ee.bear.middleground.feed.export.bean.k;
import k25.e0;
import k25.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements k {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Pair<Integer, String> c(String r4, String r5) {
        m0 r6 = e0.m().A(r4, r5, 0);
        if (r6 != null) goto L6;
        tt5.a.h("OffLineDataImpl", "update feed message : resourceData == null");
        return null;
    L6:
        tt5.a.h("OffLineDataImpl", "update feed message --hasNotPaged: " + r6.a());
        if (TextUtils.isEmpty(r6.c) == false) goto L9;
        return null;
    L9:
        if (r6.a() == true) goto L11;
        return null;
    L11:
        return new Pair(Integer.valueOf(r6.a), r6.c);
    }

    public final int a(String r2, String r3, String r4) {
        m0 r0 = new m0(r2, r3);
        r0.c = r4;
        return e0.m().H(r0);
    }

    public final int b(int r2, String r3, String r4, String r5) {
        m0 r0 = new m0(r3, r4);
        r0.a = r2;
        r0.c = r5;
        return e0.m().H(r0);
    }
}
