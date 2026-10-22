package vo0;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.openplatform.impl.minigameanchor.widget.PreviewMiniGameWidgetDelegate;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public interface a extends xo0.a {
    boolean c();

    void d(String r100);

    dr0.a getAnchorMiniGameWidgetDescriptor();

    Map<String, String> getMiniGameAppCommonLogMap();

    PreviewMiniGameWidgetDelegate getPreviewMiniGameWidgetLifecycleObserver(Context r100, ViewGroup r101, PreviewSourceParam r102);

    void handleCommonJSBInvoke(String r100, JsonObject r101, Function1<? super JsonObject, Unit> r102);

    void mount(Context r100, u r101);

    void openBottomFeaturePanel(Context r100, JSONObject r101);

    void previewItemClick(Context r100);

    void previewSwitchTask(String r100, String r101);

    void reportMiniGameAppLog(String r100, HashMap<String, String> r101);

    void setMountStatus(boolean r100);

    void unmount();
}
