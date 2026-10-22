package com.ss.android.lark.thirdshare.base.export;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class ShareRemoteConfig implements Serializable {
    private Map<String, String> answer_types;
    private List<String> items;

    public String toString() {
        return "ShareConfig{items=" + this.items + ", answer_types=" + this.answer_types + '}';
    }

    public ShareRemoteConfig() {
        this.items = new ArrayList();
        this.answer_types = new HashMap();
    }

    public Map<String, String> getAnswerTypes() {
        return this.answer_types;
    }

    public List<String> getItems() {
        return this.items;
    }

    public static Map<String, ShareRemoteConfig> parse(String r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
    L22:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L22;
        Gson r102 = new GsonBuilder().serializeNulls().create();
        Iterator<Map.Entry<String, JsonElement>> r103 = GsonProtectorUtils.parse(new JsonParser(), r100).getAsJsonObject().entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L22;
        Map.Entry<String, JsonElement> r104 = r103.next();
        String r105 = r104.getKey();
        JsonElement r106 = r104.getValue();
        JsonElement r107 = r106.getAsJsonObject().get("multiChannel");
        if (r107 == null) goto L21;
        if (Boolean.parseBoolean(r107.toString()) == false) goto L21;
        Iterator<Map.Entry<String, JsonElement>> r108 = r106.deepCopy().getAsJsonObject().entrySet().iterator();
    L16:
        if (r108.hasNext() == false) goto L9;
        Map.Entry<String, JsonElement> r109 = r108.next();
        String r110 = r109.getKey();
        if (r110.equals("multiChannel") == true) goto L16;
        r101.put(r105 + "." + r110, (ShareRemoteConfig) GsonProtectorUtils.fromJson(r102, r109.getValue(), ShareRemoteConfig.class));
    L21:
        r101.put(r105, (ShareRemoteConfig) GsonProtectorUtils.fromJson(r102, r104.getValue(), ShareRemoteConfig.class));
        goto L9
    }
}
