package fu6;

import android.content.Context;
import com.ss.android.ugc.aweme.etkit.IEventTrackInterceptor;
import java.util.List;
import java.util.Map;
import mq6.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public interface b {
    void a();

    void b();

    void c(Context r100, String r101, String r102, String r103, long r104, long r105, JSONObject r106);

    void d();

    List<IEventTrackInterceptor> e();

    void f(String r100, c r101);

    void g();

    void h();

    void i();

    void sendEvent(String r100, Map<String, String> r101);

    void sendEvent(String r100, JSONObject r101);
}
