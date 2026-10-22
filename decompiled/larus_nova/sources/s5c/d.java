package s5c;

import com.ss.android.lark.statistics.extensions.ParamsCollection;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public interface d {

    /* JADX INFO: renamed from: o2, reason: collision with root package name */
    public static final a f540773o2 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f540774a = null;

        public a() {
        }

        static {
            f540774a = new a();
        }
    }

    public static final class b {
        public static JSONObject c(d r100) {
            JSONObject r101 = new JSONObject();
            r101.put(r100.getKey(), r100.getValue());
            return r101;
        }

        public static d a(d r100, Map<String, ? extends Object> r101) {
            return new ParamsCollection(r100).plus(r101);
        }

        public static d b(d r100, d r101) {
            if ((r101 instanceof ParamsCollection) == false) goto L6;
            return r101.plus(r100);
        L6:
            return new ParamsCollection(r100).plus(r101);
        }
    }

    static {
        f540773o2 = a.f540774a;
    }

    String getKey();

    String getValue();

    d plus(Map<String, ? extends Object> r100);

    d plus(d r100);

    JSONObject toJson();
}
