package com.bytedance.ee.bear.document.event;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setEvent(String r1) {
        this.event = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setType(String r1) {
        this.type = r1;
    }
}
