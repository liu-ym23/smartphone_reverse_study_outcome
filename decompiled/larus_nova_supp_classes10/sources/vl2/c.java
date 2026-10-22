package vl2;

import android.util.SparseArray;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final SparseArray<a> a = null;

    public static final class a {
        public final String a;
        public final String b;

        public a(String r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        SparseArray<a> r0 = new SparseArray();
        a = r0;
        r0.put(1, new a("livefreegift_v1.2", "https://lf1-xgcdn-tos.pstatp.com/obj/xigua-live/livefreegift_v1.2.zip", "live_freegift_resource"));
        r0.put(2, new a("livelottery_v1.1", "https://lf1-xgcdn-tos.pstatp.com/obj/xigua-live/livelottery_v1.1.zip", "live_lottery_resource"));
        r0.put(3, new a("fans_medal_v1.1", "https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/xigua/live/fans_medal_v1.1.zip", "live_fans_medal_resouce"));
        r0.put(4, new a("liveredpacket_v1.2", "https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/xigua/liveredpacket_v1.2.zip", "live_red_packet_resource"));
        String r1 = new String[]{"sf1-ttcdn-tos.pstatp.com", "sf3-ttcdn-tos.pstatp.com", "sf6-ttcdn-tos.pstatp.com"}[new Random().nextInt(3)];
        if (tb1.c.a == false) goto L5;
        r0.put(5, new a("douyin_live_coupon_v1.1", "https://" + r1 + "/obj/cmp-ecom-alliance/douyin_live_coupon_v1.1.zip", "live_coupon_resource"));
    L6:
        r0.put(6, new a("live_coupon_v1.4", "https://sf1-ttcdn-tos.pstatp.com/obj/live-android/live_coupon_v1.4.zip", "live_new_coupon_resource"));
        return;
    L5:
        r0.put(5, new a("live_coupon_v1.2", "https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/xigua/live/live_coupon_v1.2.zip", "live_coupon_resource"));
        goto L6
    }
}
