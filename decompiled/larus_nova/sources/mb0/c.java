package mb0;

import com.bytedance.android.live.ktv.common.util.MusicInfoError;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void c(c r100, String r101, long r102) {
            r100.i(r101, r102, MapsKt.emptyMap());
        }

        public static /* synthetic */ void a(c r100, LinkMonitorData r101, long r102, Throwable r110) {
            r100.a(r101, r102, r110, new JSONObject());
        }

        public static /* synthetic */ void b(c r100, LinkMonitorData r101, long r102, String r110) {
            r100.j(r101, r102, r110, new JSONObject());
        }
    }

    void a(LinkMonitorData r100, long r101, Throwable r102, JSONObject r103);

    void b(String r100, MusicPanel r101, HashMap<String, String> r102);

    void c(long r100, String r101, int r102, String r103);

    void d(MusicPanel r100, String r101, String r102, long r103);

    void e(MusicPanel r100);

    void f(MusicPanel r100, String r101, String r102, int r103, String r104);

    void g(long r100, String r101, long r102);

    void h(KtvMusic r100, MusicInfoError r101);

    void i(String r100, long r101, Map<String, String> r102);

    void j(LinkMonitorData r100, long r101, String r102, JSONObject r103);

    void k(String r100);
}
