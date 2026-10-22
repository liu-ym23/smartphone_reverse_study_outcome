package sy5;

import com.bytedance.geckox.gson.BooleanTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f543888b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f543889c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f543890a;

    public static final class a {
        public a() {
        }
    }

    static {
        f543889c = new a();
        f543888b = new b();
    }

    public b() {
        f543889c.getClass();
        GsonBuilder r100 = new GsonBuilder();
        Class r101 = Boolean.TYPE;
        r100.registerTypeAdapter(r101, new BooleanTypeAdapter());
        r100.registerTypeAdapter(r101, new BooleanTypeAdapter());
        this.f543890a = r100.create();
    }
}
