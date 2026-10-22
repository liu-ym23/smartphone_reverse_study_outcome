package com.bytedance.ee.bear.sheet.toolbar2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SheetBlockToolbarV2Deserializer implements ObjectDeserializer {
    public static final SheetBlockToolbarV2Deserializer a = null;

    public SheetBlockToolbarV2Deserializer() {
    }

    public int getFastMatchToken() {
        return 12;
    }

    static {
        a = new SheetBlockToolbarV2Deserializer();
    }

    public static void a(JSONArray r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L33;
        int r1 = 0;
    L8:
        if (r1 >= r8.size()) goto L34;
        JSONObject r2 = r8.getJSONObject(r1);
        if (r2 == null) goto L26;
        Object r4 = r2.get("list");
        if (r4 == null) goto L23;
        JSONArray r5 = new JSONArray();
        if ((r4 instanceof JSONArray) == false) goto L21;
        JSONArray r6 = (JSONArray) r4;
        int r7 = 0;
    L19:
        if (r7 >= r6.size()) goto L22;
        r5.add(b(r6.get(r7)));
        r7 = r7 + 1;
    L22:
        r2.put("list", r5);
        goto L23
    L21:
        r5.add(b(r4));
    L23:
        JSONObject r3 = r2.getJSONObject("children");
        if (r3 == null) goto L26;
        a(r3.getJSONArray("items"));
    L26:
        r1 = r1 + 1;
        goto L8
    L34:
        return;
    }

    public static String b(Object r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if ((r1 instanceof String) == false) goto L10;
        return (String) r1;
    L10:
        if ((r1 instanceof Number) == true) goto L19;
        if ((r1 instanceof Boolean) == true) goto L19;
        if ((r1 instanceof Character) == true) goto L19;
        return JSON.toJSONString(r1);
    L19:
        return String.valueOf(r1);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.ee.bear.document.model.toolbar.ToolbarV2, com.bytedance.ee.bear.sheet.toolbar2.SheetBlockToolbarV2] */
    public final <T> T deserialze(DefaultJSONParser r4, Type r5, Object r6) {
        JSONObject r7 = (JSONObject) r4.parseObject(JSONObject.class);
        if (r7 != null) goto L5;
        return null;
    L5:
        if (r7.isEmpty() == true) goto L24;
        a(r7.getJSONArray("items"));
        JSONObject r8 = r7.getJSONObject(WikiFolderPushPlugin.DATA);
        if (r8 == null) goto L18;
        JSONObject r9 = r8.getJSONObject("input");
        if (r9 == null) goto L18;
        Object r1 = r9.get("value");
        if ((r1 instanceof JSONObject) == false) goto L16;
    L17:
        r9.put("value", JSON.toJSONString(r1));
        goto L18
    L16:
        if ((r1 instanceof JSONArray) == true) goto L17;
    L18:
        ?? r0 = (T) new SheetBlockToolbarV2((ToolbarV2) JSON.toJavaObject(r7, ToolbarV2.class));
        r0.setShowingItemId(r7.getString("showingItemId"));
        r0.setType(r7.getIntValue(ResourceData.KEY_TYPE));
        r0.setSrcObjToken(r7.getString("srcObjToken"));
        r0.setSrcObjType(r7.getIntValue("srcObjType"));
        JSONObject r10 = r7.getJSONObject(WikiFolderPushPlugin.DATA);
        if (r10 == null) goto L21;
        r0.setData((SheetBlockToolbarV2.Data) JSON.toJavaObject(r10, SheetBlockToolbarV2.Data.class));
    L21:
        return r0;
    L24:
        return null;
    }
}
