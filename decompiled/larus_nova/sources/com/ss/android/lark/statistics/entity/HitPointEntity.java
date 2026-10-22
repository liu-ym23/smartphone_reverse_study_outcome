package com.ss.android.lark.statistics.entity;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class HitPointEntity implements Serializable {
    private static final long serialVersionUID = -420361234508834009L;
    private String event;
    private JSONObject params;

    public HitPointEntity() {
    }

    public String getEvent() {
        return this.event;
    }

    public JSONObject getParams() {
        return this.params;
    }

    public void setEvent(String r100) {
        this.event = r100;
    }

    public void setParams(JSONObject r100) {
        this.params = r100;
    }
}
