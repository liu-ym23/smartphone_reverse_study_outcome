package wg4;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b implements d {
    public String a;

    public b() {
    }

    public b(String r1) {
        this.a = r1;
    }

    @Override // wg4.d
    public final List<String> a(String r23, long r24) {
        ArrayList r2 = new ArrayList();
        if (TextUtils.isEmpty(r23) == false) goto L65;
        return r2;
    L65:
        File[] r3 = new PolarisFileWrapper(r23).listFiles();     // Catch: Exception -> L62
        if (r3 != null) goto L9;
        return r2;
    L9:
        if (this.a != null) goto L12;
        this.a = com.bytedance.crash.util.b.c();     // Catch: Exception -> L62
    L12:
        if (this.a.contains(":") == true) goto L14;
        boolean r5 = true;
    L16:
        if (this.a.contains(":") == false) goto L18;
        String r0 = this.a.replace(":", "-");     // Catch: Exception -> L62
    L19:
        int r8 = r3.length;     // Catch: Exception -> L62
        File r11 = null;
        File r12 = null;
        int r13 = 0;
        long r14 = 0;
        long r16 = 0;
    L20:
        if (r13 >= r8) goto L53;
        File r18 = r3[r13];     // Catch: Exception -> L62
        String r9 = r18.getName();     // Catch: Exception -> L62
        if (r9.endsWith(".hot") == false) goto L52;
        if (r5 == true) goto L26;
    L27:
        if (r5 == true) goto L32;
        if (r18.getName().contains("-") == false) goto L52;
    L32:
        if (r9.contains(r0) == false) goto L52;
        String[] r10 = r9.split("_");     // Catch: Exception -> L62
        if (r10.length < 4) goto L38;
        long r15 = CastLongProtector.parseLong(r10[3]);     // Catch: Exception -> L62
    L42:
        if (r24 <= 0) goto L47;
        if (r15 > r24) goto L52;
    L47:
        if (r16 >= r15) goto L50;
        r11 = r12;
        r14 = r16;
        r12 = r18;
        r16 = r15;
        goto L52
    L50:
        if (r14 >= r15) goto L52;
        r14 = r15;
        r11 = r18;
        goto L52
    L38:
        if (r10.length <= 1) goto L40;
        r15 = CastLongProtector.parseLong(r10[0]);     // Catch: Exception -> L62
        goto L42
    L40:
        r15 = -1;
        goto L42
    L26:
        if (r18.getName().contains("-") == false) goto L27;
    L52:
        r13 = r13 + 1;     // Catch: Exception -> L62
        goto L20
    L53:
        if (r11 != null) goto L55;
    L57:
        if (r12 != null) goto L59;
    L64:
        return r2;
    L59:
        if (r12.length() <= 0) goto L64;
        r2.add(r12.getAbsolutePath());     // Catch: Exception -> L62
        goto L64
    L55:
        if (r11.length() <= 0) goto L57;
        r2.add(r11.getAbsolutePath());     // Catch: Exception -> L62
        goto L57
    L18:
        r0 = this.a;     // Catch: Exception -> L62
        goto L19
    L14:
        r5 = false;
    L62:
        e = move-exception;
        ch4.c.c(e);
        goto L64
    }
}
