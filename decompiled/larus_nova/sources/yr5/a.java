package yr5;

import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f568911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f568912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f568913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f568914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f568915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f568916f;

    public final String toString() {
        return "id:" + this.f568911a + ",type:" + this.f568912b + ",data:" + this.f568913c;
    }

    public String getType() {
        return this.f568912b;
    }

    public a(String r100, String r101, JSONObject r102) {
        this.f568914d = 0;
        this.f568911a = r100;
        this.f568912b = r101;
        this.f568913c = r102;
        if (r102 == null) goto L22;
        JSONObject r103 = r102.getJSONObject("style");
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.containsKey("backgroundColor") == false) goto L12;
        r103.getString("backgroundColor");
    L12:
        if (r103.containsKey("zIndex") == false) goto L15;
        this.f568914d = r103.getInteger("zIndex").intValue();
    L15:
        if (r103.containsKey("width") == false) goto L18;
        this.f568915e = r103.getFloatValue("width");
    L18:
        if (r103.containsKey("height") == false) goto L21;
        this.f568916f = r103.getFloatValue("height");
        return;
    L21:
        return;
    }
}
