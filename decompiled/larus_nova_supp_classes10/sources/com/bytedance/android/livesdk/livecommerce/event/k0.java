package com.bytedance.android.livesdk.livecommerce.event;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k0 {
    public final Map<String, String> a;

    public interface a {
        public static final C0061a a = null;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.event.k0$a$a, reason: collision with other inner class name */
        public class C0061a implements a {
            public C0061a() {
            }

            public final String a(String r2) {
                if (TextUtils.isEmpty(r2) == false) goto L5;
                return "";
            L5:
                if ("null".equals(r2) == true) goto L10;
                return r2;
            L10:
                return "";
            }
        }

        static {
            a = new C0061a();
        }
    }

    public k0() {
        this.a = new HashMap();
    }

    public final void d(Map r2) {
        if (r2 == null) goto L5;
        ((HashMap) this.a).putAll(r2);
        return;
    }

    public final String f(String r2) {
        return (String) ((HashMap) this.a).get(r2);
    }

    public final Boolean g(String r2) {
        return Boolean.valueOf(((HashMap) this.a).containsKey(r2));
    }

    public final void a(String r2, int r3) {
        String r4 = String.valueOf(r3);
        a.C0061a r0 = a.a;
        e(r2, r4);
    }

    public final void b(String r1, long r2) {
        String r3 = String.valueOf(r2);
        a.C0061a r4 = a.a;
        e(r1, r3);
    }

    public final void c(String r2, String r3) {
        a.C0061a r0 = a.a;
        e(r2, r3);
    }

    public final void e(String r3, String r4) {
        a.C0061a r0 = a.a;
        if (TextUtils.isEmpty(r4) == true) goto L6;
        Map<String, String> r1 = this.a;
        HashMap r2 = (HashMap) r1;
        r2.put(r3, r0.a(r4));
        return;
    }
}
