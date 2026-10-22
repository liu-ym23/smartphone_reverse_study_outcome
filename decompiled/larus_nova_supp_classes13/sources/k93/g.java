package k93;

import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface g {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(g r2, Map r3, Map r4, j93.c r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 4) == 0) goto L8;
            r5 = null;
        L8:
            r2.b(r3, r4, r5, false);
        }
    }

    void a(com.bytedance.android.shopping.api.mall.common.feed.help.f r1);

    void adReport(String r1, String r2, String r3, String r4, String r5, Map<String, ? extends Object> r6, String r7, String r8);

    void adThirdTrackReport(String r1, List<String> r2, Long r3, String r4, JSONObject r5);

    void b(Map<String, ? extends Object> r1, Map<String, ? extends Object> r2, j93.c r3, boolean r4);
}
