package com.larus.office.plugins.statistics;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/larus/office/plugins/statistics/ReportEventData;", "Ljava/io/Serializable;", "<init>", "()V", ReportCardMonitorPlugin.EVENT_NAME, "", "getEvent_name", "()Ljava/lang/String;", "setEvent_name", "(Ljava/lang/String;)V", "noPrefix", "", "getNoPrefix", "()Z", "setNoPrefix", "(Z)V", "data", "", "", "getData", "()Ljava/util/Map;", "setData", "(Ljava/util/Map;)V", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportEventData implements Serializable {

    @SerializedName("data")
    private Map<String, ? extends Object> data;

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    private String event_name;

    @SerializedName("noPrefix")
    private boolean noPrefix;

    public ReportEventData() {
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("{ event_name = ");
        r100.append(this.event_name);
        r100.append(", noPrefix = ");
        r100.append(this.noPrefix);
        r100.append(", data = ");
        Map<String, ? extends Object> r101 = this.data;
        if (r101 == null) goto L5;
        String r102 = String.valueOf(r101);
    L6:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = "";
        goto L6
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public final String getEvent_name() {
        return this.event_name;
    }

    public final boolean getNoPrefix() {
        return this.noPrefix;
    }

    public final void setData(Map<String, ? extends Object> r100) {
        this.data = r100;
    }

    public final void setEvent_name(String r100) {
        this.event_name = r100;
    }

    public final void setNoPrefix(boolean r100) {
        this.noPrefix = r100;
    }
}
