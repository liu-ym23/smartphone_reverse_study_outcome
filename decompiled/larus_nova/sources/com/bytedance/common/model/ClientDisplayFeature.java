package com.bytedance.common.model;

import com.bytedance.common.push.BaseJson;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ClientDisplayFeature extends BaseJson {
    private JSONObject extraParams;
    private String fontScale;
    private Boolean isDarkMode;
    private Boolean isFontFollowSystem;
    private Boolean isLargeMode;

    public ClientDisplayFeature() {
        Boolean r100 = Boolean.FALSE;
        this("", r100, r100, r100);
    }

    public JSONObject getExtraParams() {
        return this.extraParams;
    }

    public String getFontScale() {
        return this.fontScale;
    }

    public Boolean isDarkMode() {
        return this.isDarkMode;
    }

    public Boolean isFontFollowSystem() {
        return this.isFontFollowSystem;
    }

    public Boolean isLargeMode() {
        return this.isLargeMode;
    }

    public ClientDisplayFeature(String r100, Boolean r101, Boolean r102, Boolean r110) {
        this(r100, r101, r102, r110, new JSONObject());
    }

    public ClientDisplayFeature(String r100, Boolean r101, Boolean r102, Boolean r103, JSONObject r104) {
        this.fontScale = r100;
        this.isFontFollowSystem = r101;
        this.isLargeMode = r102;
        this.isDarkMode = r103;
        this.extraParams = r104;
    }
}
