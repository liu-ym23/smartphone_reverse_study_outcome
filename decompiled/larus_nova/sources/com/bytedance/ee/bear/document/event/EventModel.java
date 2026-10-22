package com.bytedance.ee.bear.document.event;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class EventModel implements Serializable {
    private String event;
    private String token;
    private String type;

    public String toString() {
        return "EventModel{event='" + this.event + "', type='" + this.type + "'}";
    }

    public EventModel() {
    }

    public String getEvent() {
        return this.event;
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public void setEvent(String r100) {
        this.event = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }
}
