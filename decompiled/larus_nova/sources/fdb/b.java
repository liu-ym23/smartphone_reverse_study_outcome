package fdb;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public interface b {
    void N8();

    int Ue();

    Boolean Y();

    boolean e6(String r100);

    boolean e9(String r100);

    Context getContext();

    String getUserId();

    void ic(Context r100, IGetDataCallback<Map<String, Boolean>> r101);

    int mc();

    void sendEvent(String r100, JSONObject r101);

    void ve(ndb.a r100);
}
