package com.bytedance.android.livesdk.livecommerce.intro.controller;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r2, String r3, String r4, boolean r5, boolean r6, int r7) {
            if ((r7 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r7 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r7 & 4) == 0) goto L12;
            r5 = false;
        L12:
            if ((r7 & 8) == 0) goto L14;
            r6 = false;
        L14:
            r2.l(r3, r4, r5, r6);
        }
    }

    void a(JSONObject r1);

    boolean i();

    String j();

    void k(boolean r1);

    void l(String r1, String r2, boolean r3, boolean r4);

    void m(uh2.a r1, boolean r2, boolean r3);

    boolean n();

    void o();

    void onDestroy();
}
