package k93;

import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public interface g {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(g r100, Map r101, Map r102, j93.c r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r104 & 4) == 0) goto L8;
            r103 = null;
        L8:
            r100.b(r101, r102, r103, false);
        }
    }

    void a(com.bytedance.android.shopping.api.mall.common.feed.help.f r100);

    void adReport(String r100, String r101, String r102, String r103, String r104, Map<String, ? extends Object> r105, String r106, String r107);

    void adThirdTrackReport(String r100, List<String> r101, Long r102, String r103, JSONObject r104);

    void b(Map<String, ? extends Object> r100, Map<String, ? extends Object> r101, j93.c r102, boolean r103);
}
