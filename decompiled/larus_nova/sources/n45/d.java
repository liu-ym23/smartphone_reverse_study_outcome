package n45;

import com.bytedance.ee.bear.contract.b0;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes16.dex */
public final class d {
    public static final String a() {
        b0 r100 = (b0) org.koin.java.a.c(b0.class, null, null, 6);
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.h());
        r101.append(" Bytedance Docs/");
        r101.append(r100.getVersionName());
        r101.append(" Type/Default ");
        r101.append(r100.m());
        r101.append(" HostVersion/");
        String r102 = swb.b.a(LarkContext.getApplication());
        if (r102 != null) goto L5;
        r102 = "unknown";
    L5:
        r101.append(r102);
        return r101.toString();
    }
}
