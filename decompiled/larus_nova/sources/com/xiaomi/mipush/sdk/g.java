package com.xiaomi.mipush.sdk;

import com.xiaomi.push.gj;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<d, a> f463064a;

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.g$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f463065a = null;

        static {
            int[] r100 = new int[d.values().length];
            f463065a = r100;
            r100[d.f463055a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f463065a[d.f463056b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f463065a[d.f463057c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f463065a[d.f463058d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f463066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f463067b;

        public a(String r100, String r101) {
            this.f463066a = r100;
            this.f463067b = r101;
        }
    }

    static {
        f463064a = new HashMap();
        a(d.f463055a, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(d.f463056b, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(d.f463057c, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(d.f463058d, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static v m8769a(d r100) {
        int r101 = AnonymousClass1.f463065a[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 == 4) goto L17;
        return null;
    L17:
        return v.f463100f;
    L18:
        return v.f463099e;
    L19:
        return v.f463098d;
    L15:
        return v.f463097c;
    }

    public static a a(d r100) {
        return f463064a.get(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static gj m8770a(d r100) {
        return gj.f463726ao;
    }

    private static void a(d r100, a r101) {
        if (r101 == null) goto L5;
        f463064a.put(r100, r101);
        return;
    }
}
