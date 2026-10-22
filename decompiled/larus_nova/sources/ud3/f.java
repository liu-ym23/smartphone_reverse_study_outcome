package ud3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f549731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f549732b;

    static {
    }

    public static void b(int r100) {
        f549731a++;
        f549732b += r100;
        dm.a.a("InnerFlowAdRequestHelper").i("handleResponse, " + f549731a + ", " + f549732b);
    }

    public static String a(JSONObject r100, boolean r101, boolean r102) {
        dm.a.a("InnerFlowAdRequestHelper").i("appendAdCntParams, aggreSequence: " + f549731a + ", preSendCnt: " + f549732b + ", fromGuessULike: " + r101 + ", preloadGuessULike: " + r102);
        if (r101 == true) goto L8;
        if (r100 == null) goto L6;
        r100.put("aggre_sequence", 0);
    L6:
        if (r100 == null) goto L14;
        r100.put("pre_send_cnt", 0);
    L14:
        if (r100 != null) goto L18;
        return null;
    L18:
        return r100.toString();
    L8:
        if (r102 == false) goto L10;
        f549731a = 0;
        f549732b = 1;
    L10:
        if (r100 == null) goto L12;
        r100.put("aggre_sequence", f549731a);
    L12:
        if (r100 == null) goto L14;
        r100.put("pre_send_cnt", f549732b);
        goto L14
    }
}
