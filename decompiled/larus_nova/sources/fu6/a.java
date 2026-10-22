package fu6;

import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public interface a {
    JSONObject a(String r100);

    String b();

    void c(String r100, HashMap<String, String> r101, Function2<? super HashMap<String, String>, ? super ConcurrentHashMap<String, String>, Boolean> r102);

    void d(String r100, HashMap<String, String> r101, String r102);

    void e(String r100);

    boolean f(String r100, HashMap<String, String> r101, String r102);

    void g(String r100, PoiBundle r101, Map<String, String> r102, Map<String, String> r103);

    String generateSession(HashMap<String, String> r100);

    ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> h(String r100);
}
