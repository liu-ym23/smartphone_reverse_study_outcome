package com.lynx.tasm.event;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class EventsListener {
    private static final String FUNCTION = "function";
    private static final String LEPUS_FUNCTION = "lepusFunction";
    private static final String LEPUS_TYPE = "lepusType";
    private static final String NAME = "name";
    private static final String TYPE = "type";
    public String functionName;
    public String lepusFunctionName;
    public String lepusType;
    public String name;
    public String type;

    public static Map<String, EventsListener> convertEventListeners(ReadableArray r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        HashMap r100 = new HashMap();
        int r101 = 0;
    L7:
        if (r101 >= r110.size()) goto L22;
        ReadableMap r102 = r110.getMap(r101);
        String r103 = r102.getString("name");
        EventsListener r104 = (EventsListener) r100.get(r103);
        if (r104 != null) goto L12;
        r104 = new EventsListener(r103, r102.getString("type"), r102.getString(FUNCTION), r102.getString(LEPUS_TYPE), r102.getString(LEPUS_FUNCTION));
    L21:
        r100.put(r104.name, r104);
        r101 = r101 + 1;
        goto L7
    L12:
        if (r104.type != null) goto L17;
        if (r104.functionName != null) goto L17;
        r104.type = r102.getString("type");
        r104.functionName = r102.getString(FUNCTION);
    L17:
        if (r104.lepusType != null) goto L21;
        if (r104.lepusFunctionName != null) goto L21;
        r104.lepusType = r102.getString(LEPUS_TYPE);
        r104.lepusFunctionName = r102.getString(LEPUS_FUNCTION);
        goto L21
    L22:
        return r100;
    }

    public EventsListener(String r100, String r101, String r102, String r103, String r104) {
        this.name = r100;
        this.type = r101;
        this.functionName = r102;
        this.lepusType = r103;
        this.lepusFunctionName = r104;
    }
}
