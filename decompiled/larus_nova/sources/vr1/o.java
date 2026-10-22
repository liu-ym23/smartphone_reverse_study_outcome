package vr1;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomNode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public interface o {
    String a(Object r100, String r101);

    void c(DataCenter r100);

    void d(Class<?> r100, Map<String, String> r101);

    Map<String, String> f(VSLinkedRoomNode r100);

    Map<String, String> g(DataCenter r100);

    JSONObject getPlayerStatsLog();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.l> h(DataCenter r100);

    boolean i(Object r100);

    com.bytedance.android.livesdk.log.filter.o j(Class r100);

    Map<String, String> k(IRoom r100);

    void n(DataCenter r100, String r101, Map<String, String> r102);

    boolean o(Object r100, String r101);

    void q(DataCenter r100, String r101, Map<String, String> r102);

    void s(String r100, Map<String, String> r101, String r102, String r103, String r104);

    void sendLog(String r100, Map<String, String> r101, Object... r102);

    void w(DataCenter r100, int r101, long r102);
}
