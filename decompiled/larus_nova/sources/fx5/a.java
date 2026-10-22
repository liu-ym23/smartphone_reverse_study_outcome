package fx5;

import com.bytedance.forest.model.Response;
import java.util.Map;
import kotlin.Deprecated;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public a() {
    }

    @Deprecated(message = "use customReport with response instead")
    public void b(String r100, String r101, String r102, JSONObject r103, JSONObject r104, JSONObject r105, int r106) {
    }

    public void c(String r100, Map<String, ? extends Map<String, ? extends Object>> r101, Map<String, ? extends Object> r102, Response r103) {
    }

    public void a(Response r100, String r110, String r111, String r112, JSONObject r113, JSONObject r114, JSONObject r115, int r116) {
        b(r110, r111, r112, r113, r114, r115, r116);
    }
}
