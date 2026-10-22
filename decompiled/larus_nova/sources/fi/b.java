package fi;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface b {
    void a(String r100);

    String addCommonParams(String r100);

    void b(Context r100, String r101, String r102, String r103, long r104, JSONObject r105);

    String getSessionKey();

    void onEventV3(String r100, JSONObject r101);
}
