package n45;

import com.bytedance.ee.bear.contract.b0;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static final String a() {
        b0 r0 = (b0) org.koin.java.a.c(b0.class, null, null, 6);
        StringBuilder r1 = new StringBuilder();
        r1.append(r0.h());
        r1.append(" Bytedance Docs/");
        r1.append(r0.getVersionName());
        r1.append(" Type/Default ");
        r1.append(r0.m());
        r1.append(" HostVersion/");
        String r2 = swb.b.a(LarkContext.getApplication());
        if (r2 != null) goto L5;
        r2 = "unknown";
    L5:
        r1.append(r2);
        return r1.toString();
    }
}
