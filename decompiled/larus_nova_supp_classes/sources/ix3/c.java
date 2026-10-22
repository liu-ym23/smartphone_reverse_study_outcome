package ix3;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.b;
import com.bytedance.applog.r;
import com.bytedance.bdinstall.Level;
import nx3.d;
import rw3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public final b a;

    public c(b r1) {
        this.a = r1;
    }

    public final String a(Context r4, String r5) {
        if (this.a.v == false) goto L9;
        if (r5.contains("?") == false) goto L7;
        r5 = r5.concat("&tt_data=a");
        goto L9
    L7:
        r5 = r5.concat("?tt_data=a");
    L9:
        return a.d(this.a.w(r4, r5, true, Level.L1), d.d);
    }

    public final String[] b(f r8, boolean r9, com.bytedance.applog.priority.b r10) {
        r r0 = r8.h();
        if (r9 == false) goto L5;
        String[] r11 = r0.b;
    L6:
        int r1 = 0;
        if (r10 != null) goto L9;
    L50:
        Context r12 = r8.getContext();
        int r13 = r11.length;
        String[] r2 = new String[r13];
    L51:
        if (r1 >= r13) goto L53;
        r2[r1] = a(r12, r11[r1]);
        r1 = r1 + 1;
        goto L51
    L53:
        return r2;
    L9:
        if (TextUtils.isEmpty(r10.g) == false) goto L14;
        if (TextUtils.isEmpty(r10.h) == false) goto L14;
    L45:
        String[] r14 = null;
    L46:
        if (r14 == null) goto L50;
        if (r14.length <= 0) goto L50;
        r11 = r14;
    L14:
        if (r10.i != null) goto L38;
        r10.i = new String[r11.length];
        int r3 = 0;
    L17:
        if (r3 >= r11.length) goto L38;
        int r4 = r11[r3].indexOf("/service/2/app_log/");
        if (r4 <= 0) goto L35;
        String r5 = r11[r3].substring(0, r4);
        String r6 = r11[r3].substring(r4);
        if (TextUtils.isEmpty(r10.g) == true) goto L28;
        if (r10.g.startsWith("https://") == false) goto L28;
        if (r10.g.endsWith("/") == true) goto L28;
        r5 = r10.g;
    L28:
        if (TextUtils.isEmpty(r10.h) == false) goto L30;
    L34:
        r10.i[r3] = r5 + r6;
    L36:
        r3 = r3 + 1;
        goto L17
    L30:
        if (r10.h.startsWith("/") == false) goto L34;
        if (r10.h.endsWith("/") == false) goto L34;
        r6 = r10.h;
        goto L34
    L35:
        r10.i[r3] = r11[r3];
    L38:
        if (r10.j == true) goto L45;
        r14 = r10.i;
        if (r14 == null) goto L45;
        if (r14.length <= 0) goto L45;
    L5:
        r11 = r0.a;
        goto L6
    }
}
