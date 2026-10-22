package com.ss.ttvideoengine.portrait;

import android.text.TextUtils;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class LabelUsage {
    public static final String KEY_LABEL_USAGE = "label_usage";
    private static final String TAG = "LabelUsage";
    private final ConcurrentHashMap<String, Object> mLabelUsage;

    public LabelUsage() {
        this.mLabelUsage = new ConcurrentHashMap(3);
    }

    private Map<String, Object> jsonToMap(JSONObject r100) {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();
        Object r104 = r100.opt(r103);
        if (r104 == null) goto L4;
        r101.put(r103, r104);
        goto L4
    L8:
        return r101;
    }

    public void addUsage(Map<String, Object> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L9;
        this.mLabelUsage.putAll(r100);
        return;
    }

    public HashMap<String, Object> get(Map<String, Object> r100) {
        HashMap<String, Object> r101 = new HashMap(this.mLabelUsage);
        if (r100.containsKey(KEY_LABEL_USAGE) == true) goto L17;
    L16:
        return r101;
    L17:
        Object r102 = r100.get(KEY_LABEL_USAGE);     // Catch: Exception -> L14
        if ((r102 instanceof JSONObject) == false) goto L8;
        Map<String, Object> r103 = jsonToMap((JSONObject) r102);     // Catch: Exception -> L14
    L11:
        if (r103 == null) goto L16;
        r101.putAll(r103);     // Catch: Exception -> L14
        goto L16
    L8:
        if ((r102 instanceof Map) == false) goto L10;
        r103 = (Map) r102;     // Catch: Exception -> L14
        goto L11
    L10:
        TTVideoEngineLog.e(TAG, "invalid parameter type");     // Catch: Exception -> L14
        r103 = null;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public void updateByVideoModel(IVideoModel r100) {
        String r101 = r100.getVideoRefStr(245);
        if (TextUtils.isEmpty(r101) == true) goto L11;
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L6
        this.mLabelUsage.putAll(jsonToMap(r102));     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
