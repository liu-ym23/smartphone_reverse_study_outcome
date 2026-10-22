package com.bytedance.ee.bear.sheet.toolbar2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes18.dex */
public final class SheetBlockToolbarV2Deserializer implements ObjectDeserializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SheetBlockToolbarV2Deserializer f238449a = null;

    public SheetBlockToolbarV2Deserializer() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    static {
        f238449a = new SheetBlockToolbarV2Deserializer();
    }

    public static void a(JSONArray r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L33;
        int r101 = 0;
    L8:
        if (r101 >= r100.size()) goto L34;
        JSONObject r102 = r100.getJSONObject(r101);
        if (r102 == null) goto L26;
        Object r103 = r102.get("list");
        if (r103 == null) goto L23;
        JSONArray r104 = new JSONArray();
        if ((r103 instanceof JSONArray) == false) goto L21;
        JSONArray r105 = (JSONArray) r103;
        int r106 = 0;
    L19:
        if (r106 >= r105.size()) goto L22;
        r104.add(b(r105.get(r106)));
        r106 = r106 + 1;
    L22:
        r102.put2("list", r104);
        goto L23
    L21:
        r104.add(b(r103));
    L23:
        JSONObject r107 = r102.getJSONObject("children");
        if (r107 == null) goto L26;
        a(r107.getJSONArray("items"));
    L26:
        r101 = r101 + 1;
        goto L8
    L34:
        return;
    }

    public static String b(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof String) == false) goto L10;
        return (String) r100;
    L10:
        if ((r100 instanceof Number) == true) goto L19;
        if ((r100 instanceof Boolean) == true) goto L19;
        if ((r100 instanceof Character) == true) goto L19;
        return JSON.toJSONString(r100);
    L19:
        return String.valueOf(r100);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.ee.bear.document.model.toolbar.ToolbarV2, com.bytedance.ee.bear.sheet.toolbar2.SheetBlockToolbarV2] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public final <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        JSONObject r103 = (JSONObject) r100.parseObject(JSONObject.class);
        if (r103 != null) goto L5;
        return null;
    L5:
        if (r103.isEmpty() == true) goto L24;
        a(r103.getJSONArray("items"));
        JSONObject r104 = r103.getJSONObject("data");
        if (r104 == null) goto L18;
        JSONObject r105 = r104.getJSONObject("input");
        if (r105 == null) goto L18;
        Object r106 = r105.get("value");
        if ((r106 instanceof JSONObject) == false) goto L16;
    L17:
        r105.put2("value", JSON.toJSONString(r106));
        goto L18
    L16:
        if ((r106 instanceof JSONArray) == true) goto L17;
    L18:
        ?? r107 = (T) new SheetBlockToolbarV2((ToolbarV2) JSON.toJavaObject(r103, ToolbarV2.class));
        r107.setShowingItemId(r103.getString("showingItemId"));
        r107.setType(r103.getIntValue("type"));
        r107.setSrcObjToken(r103.getString("srcObjToken"));
        r107.setSrcObjType(r103.getIntValue("srcObjType"));
        JSONObject r108 = r103.getJSONObject("data");
        if (r108 == null) goto L21;
        r107.setData((SheetBlockToolbarV2.Data) JSON.toJavaObject(r108, SheetBlockToolbarV2.Data.class));
    L21:
        return r107;
    L24:
        return null;
    }
}
