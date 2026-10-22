package gl;

import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface a {
    Integer a();

    void b(Pair<String, ? extends Object>[] r100, Function2<Object, Object, Boolean> r101);

    void c(a r100);

    void d(String[] r100);

    void delete(String... r100);

    JSONObject e();

    void f(Map<String, ? extends Object> r100, Function2<Object, Object, Boolean> r101);

    void g(Pair<String, ? extends Object>... r100);

    Object get(String r100);

    String getString(String r100);

    String h();

    void i(JSONObject r100);

    void j(Pair<String, ? extends Object>[] r100, Function1<Object, Boolean> r101);

    Iterator<String> keys();

    void putAll(Map<String, ? extends Object> r100);
}
