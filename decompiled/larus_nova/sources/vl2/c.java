package vl2;

import android.util.SparseArray;
import java.util.Random;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<a> f555645a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f555646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f555647b;

        public a(String r100, String r101, String r102) {
            this.f555646a = r100;
            this.f555647b = r101;
        }
    }

    static {
        SparseArray<a> r100 = new SparseArray();
        f555645a = r100;
        r100.put(1, new a("livefreegift_v1.2", "https://lf1-xgcdn-tos.pstatp.com/obj/xigua-live/livefreegift_v1.2.zip", "live_freegift_resource"));
        r100.put(2, new a("livelottery_v1.1", "https://lf1-xgcdn-tos.pstatp.com/obj/xigua-live/livelottery_v1.1.zip", "live_lottery_resource"));
        r100.put(3, new a("fans_medal_v1.1", "https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/xigua/live/fans_medal_v1.1.zip", "live_fans_medal_resouce"));
        r100.put(4, new a("liveredpacket_v1.2", "https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/xigua/liveredpacket_v1.2.zip", "live_red_packet_resource"));
        String r101 = new String[]{"sf1-ttcdn-tos.pstatp.com", "sf3-ttcdn-tos.pstatp.com", "sf6-ttcdn-tos.pstatp.com"}[new Random().nextInt(3)];
        if (tb1.c.f545229a == false) goto L5;
        r100.put(5, new a("douyin_live_coupon_v1.1", "https://" + r101 + "/obj/cmp-ecom-alliance/douyin_live_coupon_v1.1.zip", "live_coupon_resource"));
    L6:
        r100.put(6, new a("live_coupon_v1.4", "https://sf1-ttcdn-tos.pstatp.com/obj/live-android/live_coupon_v1.4.zip", "live_new_coupon_resource"));
        return;
    L5:
        r100.put(5, new a("live_coupon_v1.2", "https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/xigua/live/live_coupon_v1.2.zip", "live_coupon_resource"));
        goto L6
    }
}
