package gu6;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f482790a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f482791a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final HashMap<String, String> f482792b = null;

        public a() {
        }

        static {
            f482791a = new a();
            HashMap<String, String> r100 = new HashMap();
            r100.put("scene", "life_service");
            f482792b = r100;
        }
    }

    static {
        f482790a = a.f482791a;
    }

    JSONObject a();

    String b();
}
