package o35;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k25.m0;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f521876a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f521877b = null;

    static {
        f521876a = new HashMap();
        f521877b = new ArrayList();
    }

    public static synchronized boolean a(m0 r110) {
        monitor-enter(a.class);
    L41:
        th = move-exception;
        throw th;
    L5:
        boolean r100 = false;
        if (r110.a() == false) goto L9;
        monitor-exit(a.class);
        return false;
    L9:
        String r101 = r110.f501550k + r110.f501541b + r110.f501557r;     // Catch: Throwable -> L41
        boolean r102 = true;
        if (TextUtils.isEmpty(r101) == true) goto L21;
        List<String> r103 = f521877b;     // Catch: Throwable -> L41
        if (((ArrayList) r103).contains(r101) == false) goto L21;
        if ((r110.f501555p + 1) != r110.f501556q) goto L16;
        r100 = true;
    L16:
        if (r100 == false) goto L18;
        ((ArrayList) r103).remove(r101);     // Catch: Throwable -> L41
        tt5.a.h("DataPageSafeChecker", "Remove discardList batchNumber: " + r110.f501557r);     // Catch: Throwable -> L41
    L18:
        tt5.a.h("DataPageSafeChecker", "Contains in discardList.");     // Catch: Throwable -> L41
        monitor-exit(a.class);
        return true;
    L21:
        String r104 = r110.f501550k + r110.f501541b;     // Catch: Throwable -> L41
        String r105 = r110.f501557r;     // Catch: Throwable -> L41
        if (TextUtils.isEmpty(r104) == false) goto L24;
    L30:
        Map<String, String> r106 = f521876a;     // Catch: Throwable -> L41
        String r107 = (String) ((HashMap) r106).get(r104);     // Catch: Throwable -> L41
        if (TextUtils.equals(r105, r107) == true) goto L33;
        ((ArrayList) f521877b).add(r104 + r107);     // Catch: Throwable -> L41
        ((HashMap) r106).put(r104, r105);     // Catch: Throwable -> L41
        tt5.a.h("DataPageSafeChecker", "Discard batchNumber: " + r107 + " Save batchNumber: " + r105);     // Catch: Throwable -> L41
    L39:
        monitor-exit(a.class);
        return false;
    L33:
        if ((r110.f501555p + 1) == r110.f501556q) goto L36;
        r102 = false;
    L36:
        if (r102 == false) goto L39;
        tt5.a.h("DataPageSafeChecker", "Remove writing batchNumber: " + r105);     // Catch: Throwable -> L41
        ((HashMap) r106).remove(r104);     // Catch: Throwable -> L41
        goto L39
    L24:
        if (TextUtils.isEmpty(r105) == true) goto L30;
        Map<String, String> r108 = f521876a;     // Catch: Throwable -> L41
        if (((HashMap) r108).keySet().contains(r104) == true) goto L30;
        ((HashMap) r108).put(r104, r105);     // Catch: Throwable -> L41
        tt5.a.h("DataPageSafeChecker", "Put curBatchNumber: " + r105);     // Catch: Throwable -> L41
        monitor-exit(a.class);
        return false;
    }
}
