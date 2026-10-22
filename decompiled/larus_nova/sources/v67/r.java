package v67;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface r extends rgc.a {
    void ensureNotReachHere(Throwable r100);

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103);

    void onUserActive();
}
