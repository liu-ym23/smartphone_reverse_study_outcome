package xmc;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public interface b {
    long getInt64Value(int r100, long r101);

    void onDataLoaderError(int r100, String r101);

    void onLogInfo(int r100, String r101, JSONObject r102);

    void onNotify(int r100, long r101, long r102, String r103);

    void onSwitchLoaderType(int r100, String r101);
}
