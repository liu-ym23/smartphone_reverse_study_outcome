package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYApplogEvent;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "eventName", "", "args", "type", "Lcom/bytedance/pitaya/api/bean/PTYApplogEventType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/pitaya/api/bean/PTYApplogEventType;)V", "getArgs", "()Ljava/lang/String;", "getEventName", "timestamp", "", "getTimestamp", "()D", "getType", "()Lcom/bytedance/pitaya/api/bean/PTYApplogEventType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PTYApplogEvent implements ReflectionCall {
    private final String args;
    private final String eventName;
    private final double timestamp;
    private final PTYApplogEventType type;

    public static /* synthetic */ PTYApplogEvent copy$default(PTYApplogEvent r100, String r101, String r102, PTYApplogEventType r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.eventName;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.args;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.type;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.eventName;
    }

    public final String component2() {
        return this.args;
    }

    public final PTYApplogEventType component3() {
        return this.type;
    }

    public final PTYApplogEvent copy(String r100, String r101, PTYApplogEventType r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r102, "type");
        return new PTYApplogEvent(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PTYApplogEvent) == true) goto L8;
        return false;
    L8:
        PTYApplogEvent r101 = (PTYApplogEvent) r100;
        if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.args, r101.args) == true) goto L15;
        return false;
    L15:
        if (this.type == r101.type) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.eventName.hashCode() * 31;
        String r101 = this.args;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.type.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "PTYApplogEvent(eventName=" + this.eventName + ", args=" + this.args + ", type=" + this.type + ')';
    }

    public final String getArgs() {
        return this.args;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final double getTimestamp() {
        return this.timestamp;
    }

    public final PTYApplogEventType getType() {
        return this.type;
    }

    public PTYApplogEvent(String r100, String r101, PTYApplogEventType r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.eventName = r100;
        this.args = r101;
        this.type = r102;
        this.timestamp = System.currentTimeMillis() / 1000.0d;
    }

    public /* synthetic */ PTYApplogEvent(String r100, String r101, PTYApplogEventType r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = PTYApplogEventType.NORMAL;
    L8:
        this(r100, r101, r102);
    }
}
