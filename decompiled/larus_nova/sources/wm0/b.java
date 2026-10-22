package wm0;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public interface b {
    void ensureNotReachHere(Throwable r100, String r101);

    void monitorCommonLog(String r100, String r101, JSONObject r102);

    void monitorCommonLog(String r100, JSONObject r101);

    void monitorDirectOnTimer(String r100, String r101, float r102);

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103);

    void monitorStatusRate(String r100, int r101, JSONObject r102);
}
