package o35;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k25.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final Map<String, String> a = null;
    public static final List<String> b = null;

    static {
        a = new HashMap();
        b = new ArrayList();
    }

    public static synchronized boolean a(m0 r10) {
        monitor-enter(a.class);
    L41:
        th = move-exception;
        throw th;
    L5:
        boolean r6 = false;
        if (r10.a() == false) goto L9;
        monitor-exit(a.class);
        return false;
    L9:
        String r5 = r10.k + r10.b + r10.r;     // Catch: Throwable -> L41
        boolean r8 = true;
        if (TextUtils.isEmpty(r5) == true) goto L21;
        List<String> r7 = b;     // Catch: Throwable -> L41
        if (((ArrayList) r7).contains(r5) == false) goto L21;
        if ((r10.p + 1) != r10.q) goto L16;
        r6 = true;
    L16:
        if (r6 == false) goto L18;
        ((ArrayList) r7).remove(r5);     // Catch: Throwable -> L41
        tt5.a.h("DataPageSafeChecker", "Remove discardList batchNumber: " + r10.r);     // Catch: Throwable -> L41
    L18:
        tt5.a.h("DataPageSafeChecker", "Contains in discardList.");     // Catch: Throwable -> L41
        monitor-exit(a.class);
        return true;
    L21:
        String r3 = r10.k + r10.b;     // Catch: Throwable -> L41
        String r9 = r10.r;     // Catch: Throwable -> L41
        if (TextUtils.isEmpty(r3) == false) goto L24;
    L30:
        Map<String, String> r1 = a;     // Catch: Throwable -> L41
        String r11 = (String) ((HashMap) r1).get(r3);     // Catch: Throwable -> L41
        if (TextUtils.equals(r9, r11) == true) goto L33;
        ((ArrayList) b).add(r3 + r11);     // Catch: Throwable -> L41
        ((HashMap) r1).put(r3, r9);     // Catch: Throwable -> L41
        tt5.a.h("DataPageSafeChecker", "Discard batchNumber: " + r11 + " Save batchNumber: " + r9);     // Catch: Throwable -> L41
    L39:
        monitor-exit(a.class);
        return false;
    L33:
        if ((r10.p + 1) == r10.q) goto L36;
        r8 = false;
    L36:
        if (r8 == false) goto L39;
        tt5.a.h("DataPageSafeChecker", "Remove writing batchNumber: " + r9);     // Catch: Throwable -> L41
        ((HashMap) r1).remove(r3);     // Catch: Throwable -> L41
        goto L39
    L24:
        if (TextUtils.isEmpty(r9) == true) goto L30;
        Map<String, String> r12 = a;     // Catch: Throwable -> L41
        if (((HashMap) r12).keySet().contains(r3) == true) goto L30;
        ((HashMap) r12).put(r3, r9);     // Catch: Throwable -> L41
        tt5.a.h("DataPageSafeChecker", "Put curBatchNumber: " + r9);     // Catch: Throwable -> L41
        monitor-exit(a.class);
        return false;
    }
}
