package dw;

import android.content.Context;
import com.bytedance.android.gamecp.business.download.GameCenterStrategy$doSubscribe$1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface f {
    void a(Context r100, JSONObject r101, JSONObject r102, GameCenterStrategy$doSubscribe$1 r103);

    void action(Context r100, JSONObject r101, JSONObject r102);

    void b();

    void cancelDownload(Context r100, JSONObject r101, JSONObject r102);

    void unSubscribe(Context r100, JSONObject r101, JSONObject r102);
}
