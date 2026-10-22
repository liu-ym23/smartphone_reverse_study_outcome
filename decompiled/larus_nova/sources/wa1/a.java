package wa1;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public interface a {
    boolean a();

    void b();

    x60.c.a c();

    void e(String r100);

    void e(String r100, String r101, Throwable r102);

    void e(String r100, Throwable r101);

    void ensureNotReachHere(Throwable r100, String r101);

    Context getContext();

    void i(String r100, String r101);

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);
}
