package pg1;

import android.os.SystemClock;
import com.bytedance.android.livesdk.config.m2;
import com.bytedance.android.livesdk.config.n2;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f529140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f529141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f529142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Runnable f529143d;

    static {
        f529140a = CollectionsKt.listOf(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
    }

    public static long a() {
        Long r100 = com.bytedance.android.livesdk.sharedpref.b.C2.getValue();
        long r101 = m2.f120726a.getValue().longValue() * ((long) 1000);
        int r102 = ((n2.f120801a.getValue().intValue() * 1000) * 60) * 60;
        if (r100 == null) goto L9;
        if (r100.longValue() != 0) goto L9;
        return r101;
    L9:
        if ((SystemClock.elapsedRealtime() - r100.longValue()) < r102) goto L12;
        return r101;
    L12:
        return r101 - (SystemClock.elapsedRealtime() - r100.longValue());
    }

    public static void b() {
        if (f529142c == false) goto L7;
        Runnable r100 = f529143d;
        if (r100 == null) goto L7;
        r100.run();
    L7:
        f529142c = false;
        f529143d = null;
    }
}
