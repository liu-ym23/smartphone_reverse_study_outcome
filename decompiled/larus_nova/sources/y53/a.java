package y53;

import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ec.sdk.helper.r;
import m53.b;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f566237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f566238b = null;

    static {
        StringBuilder r100 = new StringBuilder("key_bff_comment_list_expired_time");
        r r101 = r.f48132a;
        r100.append(r101.getCurrentUserId());
        f566237a = "key_comment_bff_list_expired_time_2" + r101.getCurrentUserId();
        f566238b = "key_consumer_show_expired_time_v2" + r101.getCurrentUserId();
    }

    public static void a() {
        long r100 = System.currentTimeMillis() + (b.a("active", 30) * 86400000);
        q.f48131a.e(f566238b, r100);
    }
}
