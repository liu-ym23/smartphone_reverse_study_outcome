package com.bytedance.ee.bear.document.orientation;

import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final enum OrientationEnum extends Enum<OrientationEnum> {
    public static final OrientationEnum LANDSCAPE = null;
    public static final OrientationEnum PORTRAIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrientationEnum[] f220726a = null;
    private String type;

    static {
        OrientationEnum r100 = new OrientationEnum("LANDSCAPE", 0, "landscape");
        LANDSCAPE = r100;
        OrientationEnum r101 = new OrientationEnum("PORTRAIT", 1, "portrait");
        PORTRAIT = r101;
        f220726a = new OrientationEnum[]{r100, r101};
    }

    public static OrientationEnum[] values() {
        return (OrientationEnum[]) f220726a.clone();
    }

    public JSONObject toJsonObject() {
        JSONObject r100 = new JSONObject();
        r100.put2("type", this.type);
        return r100;
    }

    public String getType() {
        return this.type;
    }

    public static OrientationEnum valueOf(String r100) {
        return (OrientationEnum) r27.a.a(OrientationEnum.class, r100);
    }

    public void setType(String r100) {
        this.type = r100;
    }

    public OrientationEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
