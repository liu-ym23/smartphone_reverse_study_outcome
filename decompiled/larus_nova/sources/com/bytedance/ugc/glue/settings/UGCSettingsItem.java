package com.bytedance.ugc.glue.settings;

import com.bytedance.ugc.glue.UGCTools;
import com.bytedance.ugc.glue.json.UGCJson;
import fp7.a;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class UGCSettingsItem<T> {
    private final T defaultValue;
    private final String key;
    private String lastString;
    private final Type type;
    private T value;

    public T getValue() {
        int r100 = a.f478293a;
        int r101 = ep7.a.f473437a;
        if (UGCTools.equal("", this.lastString) == true) goto L5;
        this.value = parse("", this.type);
        this.lastString = "";
    L5:
        T r102 = this.value;
        if (r102 == null) goto L8;
        return r102;
    L8:
        return this.defaultValue;
    }

    public String getKey() {
        return this.key;
    }

    public UGCSettingsItem(String r100, T r101) {
        this(r100, r101, r101.getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T parse(String r100, Type r101) {
        if (UGCTools.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (r101 != String.class) goto L9;
        return r100;
    L9:
        if (r101 == JSONObject.class) goto L11;
        return (T) UGCJson.fromJson(r100, r101);
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        return (T) UGCJson.jsonObject(r100);
    }

    public UGCSettingsItem(String r100, T r101, Type r102) {
        this.key = r100;
        this.defaultValue = r101;
        this.type = r102;
    }
}
