package com.bytedance.ee.bear.document.orientation;

import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum OrientationEnum extends Enum<OrientationEnum> {
    public static final OrientationEnum LANDSCAPE = null;
    public static final OrientationEnum PORTRAIT = null;
    public static final /* synthetic */ OrientationEnum[] a = null;
    private String type;

    static {
        OrientationEnum r0 = new OrientationEnum("LANDSCAPE", 0, "landscape");
        LANDSCAPE = r0;
        OrientationEnum r1 = new OrientationEnum("PORTRAIT", 1, "portrait");
        PORTRAIT = r1;
        a = new OrientationEnum[]{r0, r1};
    }

    public static OrientationEnum[] values() {
        return (OrientationEnum[]) a.clone();
    }

    public JSONObject toJsonObject() {
        JSONObject r0 = new JSONObject();
        r0.put("type", this.type);
        return r0;
    }

    public String getType() {
        return this.type;
    }

    public static OrientationEnum valueOf(String r1) {
        return (OrientationEnum) r27.a.a(OrientationEnum.class, r1);
    }

    public void setType(String r1) {
        this.type = r1;
    }

    public OrientationEnum(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
