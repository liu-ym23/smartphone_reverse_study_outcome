package my3;

import android.app.Application;
import com.bytedance.awemeopen.apps.framework.utils.w;
import p24.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements tx3.b {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public static void a(String r13, long r14, String r16, String r17, int r18, int r19, int r20, p24.c r21) {
        d14.a r0 = b14.a.a;
        e r1 = b14.a.a(e.class);
        Application r2 = y54.a.a();
        Integer r9 = Integer.valueOf(r19);
        Integer r10 = Integer.valueOf(r20);
        int[] r3 = w.a;
        if (r3 != null) goto L5;
        String r4 = "";
    L6:
        r1.I(r2, r13, r14, r16, r17, r18, r9, r10, r4, r21);
        return;
    L5:
        StringBuilder r5 = new StringBuilder();
        r5.append(r3[0]);
        r5.append('_');
        r5.append(r3[1]);
        r4 = r5.toString();
        goto L6
    }
}
