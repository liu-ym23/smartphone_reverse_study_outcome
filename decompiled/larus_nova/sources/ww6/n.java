package ww6;

import com.ss.android.ugc.aweme.poi.mob.ConflictDetectResult;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public interface n {
    void a(String r100, Map<String, String> r101);

    HashMap<String, String> b();

    void c(Map<String, String> r100, String r101, Map<String, String> r102, boolean r103);

    void d(String r100, String r101, JSONObject r102);

    void e(String r100, Map<String, String> r101, String r102);

    void f(String r100, Map<String, String> r101, Map<String, String> r102);

    void g(Map<String, String> r100);

    void h(String r100, Function1<? super com.bytedance.locallife.biz.mob.f, Unit> r101, Map<String, String> r102);

    ConflictDetectResult i();

    void j(String r100, Map<String, String> r101, String r102);

    String k(String r100);
}
