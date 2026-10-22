package ud3;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static volatile int a;
    public static volatile int b;

    static {
    }

    public static void b(int r2) {
        a++;
        b += r2;
        dm.a.a("InnerFlowAdRequestHelper").i("handleResponse, " + a + ", " + b);
    }

    public static String a(JSONObject r3, boolean r4, boolean r5) {
        dm.a.a("InnerFlowAdRequestHelper").i("appendAdCntParams, aggreSequence: " + a + ", preSendCnt: " + b + ", fromGuessULike: " + r4 + ", preloadGuessULike: " + r5);
        if (r4 == true) goto L8;
        if (r3 == null) goto L6;
        r3.put("aggre_sequence", 0);
    L6:
        if (r3 == null) goto L14;
        r3.put("pre_send_cnt", 0);
    L14:
        if (r3 != null) goto L18;
        return null;
    L18:
        return r3.toString();
    L8:
        if (r5 == false) goto L10;
        a = 0;
        b = 1;
    L10:
        if (r3 == null) goto L12;
        r3.put("aggre_sequence", a);
    L12:
        if (r3 == null) goto L14;
        r3.put("pre_send_cnt", b);
        goto L14
    }
}
