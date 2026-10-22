package o53;

import com.bytedance.android.ec.sdk.helper.q;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f522099a = 0;

    public static void b() {
        long r100 = System.currentTimeMillis() + 2592000000L;
        q.f48131a.e("key_consumer_show_expired_time", r100);
    }

    static {
    }

    public static boolean a(int r100) {
        if (r100 != 0) goto L7;
        long r101 = q.f48131a.getLong("key_comment_list_expired_time", 0);
        if (System.currentTimeMillis() <= r101) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (r100 != 1) goto L13;
        long r102 = q.f48131a.getLong("key_consumer_show_expired_time", 0);
        if (System.currentTimeMillis() <= r102) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    }
}
