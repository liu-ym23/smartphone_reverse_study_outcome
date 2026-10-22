package com.huawei.hms.healthlite;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class aabe {

    /* JADX INFO: renamed from: aab, reason: collision with root package name */
    private String f277487aab;
    private String aaba;
    private String aabb;

    public aabe(JSONObject r100) throws JSONException {
        this.f277487aab = JSONObjectProtectorUtils.getString(r100, "name");
        this.aaba = JSONObjectProtectorUtils.getString(r100, "h5Url");
        this.aabb = JSONObjectProtectorUtils.getString(r100, "callBackUrl");
    }

    public String aab() {
        return this.aabb;
    }

    public String aaba() {
        return this.aaba;
    }

    public String aabb() {
        return this.f277487aab;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f277487aab, this.aaba, this.aabb});
    }
}
