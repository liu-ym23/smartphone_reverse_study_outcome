package com.ss.android.lark.chat.entity.location;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class LocationDescription implements Serializable {
    private static final long serialVersionUID = 8695143798508814510L;
    private String description;
    private String name;

    public LocationDescription() {
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }
}
