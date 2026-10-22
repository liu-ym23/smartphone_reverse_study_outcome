package xi;

import android.content.Context;
import java.util.List;
import kotlin.Deprecated;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface a {
    void a(String r100);

    String addCommonParams(String r100);

    void b(Context r100, String r101, String r102, String r103, long r104, JSONObject r105);

    void c(long r100, long r101);

    void d(String r100, List<String> r101, Long r102, String r103);

    @Deprecated(message = "use ECLogService instead.")
    void e(Exception r100);

    void logV3(String r100, JSONObject r101);
}
