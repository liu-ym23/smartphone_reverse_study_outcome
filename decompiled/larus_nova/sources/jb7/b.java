package jb7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, a> f498009a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<a> f498010b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f498011c;

    static {
        f498009a = new HashMap();
        f498010b = new ArrayList();
        f498011c = "";
    }

    public static void a(a... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L13;
        a r103 = r100[r102];
        if (((HashMap) f498009a).containsValue(r103) == true) goto L12;
        if (((ArrayList) f498010b).contains(r103) == true) goto L12;
        String r104 = r103.getName();
        if (f498011c.length() <= 0) goto L11;
        f498011c += ",";
    L11:
        f498011c += r104;
    L12:
        r102 = r102 + 1;
        goto L3
    L13:
        Collections.addAll(f498010b, r100);
    }
}
