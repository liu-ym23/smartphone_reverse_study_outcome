package com.bytedance.android.livesdk.livecommerce.ability;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ void a(e r1, int r2, String r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            r1.onFail(r2, r3);
        }
    }

    void onFail(int r1, String r2);

    void onSuccess();
}
