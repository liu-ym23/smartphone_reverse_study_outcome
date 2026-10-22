package pgc;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f529224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ConcurrentHashMap<String, Object> f529225b;

    public a() {
    }

    static {
        f529224a = PullConfiguration.PROCESS_NAME_MAIN;
    }

    public static void c(String[] r100) {
        if (f529225b == null) goto L7;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        String r103 = r100[r102];
        f529225b.remove(r103);
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    public static void a(String r100, long r101) {
        ConcurrentHashMap<String, Object> r102 = f529225b;
        if (r102 == null) goto L6;
        r102.put(r100, Long.valueOf(r101));
        return;
    }

    public static void b(String r100, String r101) {
        ConcurrentHashMap<String, Object> r102 = f529225b;
        if (r102 == null) goto L8;
        r102.put(r100, r101);
        if (r100.equals("te_composition_video_hw_profile") == false) goto L9;
        f529224a = r101;
        return;
    L9:
        return;
    }
}
