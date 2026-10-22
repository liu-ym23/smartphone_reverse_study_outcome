package com.bytedance.ee.docsdk.impl.document.plugins.event;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/event/EventModel;", "Ljava/io/Serializable;", "()V", "event", "", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "message", "getMessage", "setMessage", ResourceData.KEY_TOKEN, "getToken", "setToken", ResourceData.KEY_TYPE, "getType", "setType", "toString", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventModel implements Serializable {

    @SerializedName("event")
    private String event;

    @SerializedName("message")
    private String message;

    @SerializedName(ResourceData.KEY_TOKEN)
    private String token;

    @SerializedName(ResourceData.KEY_TYPE)
    private String type;

    public String toString() {
        return "EventModel{event=" + this.event + ", token=" + this.token + ", type=" + this.type + ", message=" + this.message + '}';
    }

    public EventModel() {
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getType() {
        return this.type;
    }

    public final void setEvent(String r1) {
        this.event = r1;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }
}
