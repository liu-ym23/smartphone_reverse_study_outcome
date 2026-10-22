package com.bytedance.ies.xbridge.event;

import com.bytedance.ies.xbridge.XReadableMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0000H\u0096\u0002J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010+\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010,\u001a\u00020%HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006."}, d2 = {"Lcom/bytedance/ies/xbridge/event/Event;", "", "eventName", "", "timestamp", "", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "(Ljava/lang/String;JLcom/bytedance/ies/xbridge/XReadableMap;)V", "containerID", "getContainerID", "()Ljava/lang/String;", "setContainerID", "(Ljava/lang/String;)V", "getEventName", "isBroadcast", "", "()Z", "setBroadcast", "(Z)V", "isLocal", "setLocal", "mapParams", "", "", "getMapParams", "()Ljava/util/Map;", "setMapParams", "(Ljava/util/Map;)V", "getParams", "()Lcom/bytedance/ies/xbridge/XReadableMap;", "targetContainerID", "getTargetContainerID", "setTargetContainerID", "getTimestamp", "()J", "compareTo", "", "other", "component1", "component2", "component3", "copy", "equals", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class Event implements Comparable<Event> {
    private String containerID;
    private final String eventName;
    private boolean isBroadcast;
    private boolean isLocal;
    private Map<String, ? extends Object> mapParams;
    private final XReadableMap params;
    private String targetContainerID;
    private final long timestamp;

    public static /* synthetic */ Event copy$default(Event r100, String r101, long r102, XReadableMap r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.eventName;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.timestamp;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.params;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.eventName;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final XReadableMap component3() {
        return this.params;
    }

    public final Event copy(String r100, long r101, XReadableMap r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        return new Event(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Event) == true) goto L8;
        return false;
    L8:
        Event r101 = (Event) r100;
        if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L12;
        return false;
    L12:
        if (this.timestamp == r101.timestamp) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.eventName.hashCode() * 31;
        long r101 = this.timestamp;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        XReadableMap r103 = this.params;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public String toString() {
        return "Event(eventName=" + this.eventName + ", timestamp=" + this.timestamp + ", params=" + this.params + ')';
    }

    public final String getContainerID() {
        return this.containerID;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final Map<String, Object> getMapParams() {
        return this.mapParams;
    }

    public final XReadableMap getParams() {
        return this.params;
    }

    public final String getTargetContainerID() {
        return this.targetContainerID;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final boolean isBroadcast() {
        return this.isBroadcast;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Event r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        long r101 = this.timestamp;
        if (r101 != r100.timestamp) goto L7;
        return -1;
    L7:
        return ComparisonsKt.compareValues(Long.valueOf(r101), Long.valueOf(r100.timestamp));
    }

    public final void setBroadcast(boolean r100) {
        this.isBroadcast = r100;
    }

    public final void setContainerID(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.containerID = r100;
    }

    public final void setLocal(boolean r100) {
        this.isLocal = r100;
    }

    public final void setMapParams(Map<String, ? extends Object> r100) {
        this.mapParams = r100;
    }

    public final void setTargetContainerID(String r100) {
        this.targetContainerID = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Event r100) {
        return compareTo2(r100);
    }

    public Event(String r100, long r101, XReadableMap r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.eventName = r100;
        this.timestamp = r101;
        this.params = r102;
        this.containerID = "";
    }

    public /* synthetic */ Event(String r100, long r101, XReadableMap r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
