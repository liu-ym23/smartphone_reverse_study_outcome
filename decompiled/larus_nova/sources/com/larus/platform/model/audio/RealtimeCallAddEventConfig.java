package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeCallAddEventConfig;", "", "helloEvent", "Lcom/larus/platform/model/audio/EventConfig;", "waitingEvent", "Lcom/larus/platform/model/audio/WaitingEventConfig;", "hangUpEvent", "<init>", "(Lcom/larus/platform/model/audio/EventConfig;Lcom/larus/platform/model/audio/WaitingEventConfig;Lcom/larus/platform/model/audio/EventConfig;)V", "getHelloEvent", "()Lcom/larus/platform/model/audio/EventConfig;", "getWaitingEvent", "()Lcom/larus/platform/model/audio/WaitingEventConfig;", "getHangUpEvent", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallAddEventConfig {

    @SerializedName("audio_realtime_call_hang_up")
    private final EventConfig hangUpEvent;

    @SerializedName("audio_realtime_call_hello")
    private final EventConfig helloEvent;

    @SerializedName("audio_realtime_call_waiting")
    private final WaitingEventConfig waitingEvent;

    public RealtimeCallAddEventConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ RealtimeCallAddEventConfig copy$default(RealtimeCallAddEventConfig r100, EventConfig r101, WaitingEventConfig r102, EventConfig r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.helloEvent;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.waitingEvent;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.hangUpEvent;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final EventConfig component1() {
        return this.helloEvent;
    }

    public final WaitingEventConfig component2() {
        return this.waitingEvent;
    }

    public final EventConfig component3() {
        return this.hangUpEvent;
    }

    public final RealtimeCallAddEventConfig copy(EventConfig r100, WaitingEventConfig r101, EventConfig r102) {
        return new RealtimeCallAddEventConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RealtimeCallAddEventConfig) == true) goto L8;
        return false;
    L8:
        RealtimeCallAddEventConfig r101 = (RealtimeCallAddEventConfig) r100;
        if (Intrinsics.areEqual(this.helloEvent, r101.helloEvent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.waitingEvent, r101.waitingEvent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.hangUpEvent, r101.hangUpEvent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        EventConfig r100 = this.helloEvent;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        WaitingEventConfig r104 = this.waitingEvent;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        EventConfig r107 = this.hangUpEvent;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RealtimeCallAddEventConfig(helloEvent=" + this.helloEvent + ", waitingEvent=" + this.waitingEvent + ", hangUpEvent=" + this.hangUpEvent + ')';
    }

    public final EventConfig getHangUpEvent() {
        return this.hangUpEvent;
    }

    public final EventConfig getHelloEvent() {
        return this.helloEvent;
    }

    public final WaitingEventConfig getWaitingEvent() {
        return this.waitingEvent;
    }

    public RealtimeCallAddEventConfig(EventConfig r100, WaitingEventConfig r101, EventConfig r102) {
        this.helloEvent = r100;
        this.waitingEvent = r101;
        this.hangUpEvent = r102;
    }

    public /* synthetic */ RealtimeCallAddEventConfig(EventConfig r110, WaitingEventConfig r111, EventConfig r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        EventConfig r100 = new EventConfig(false, 0.0f, 3, null);
    L7:
        if ((r113 & 2) == 0) goto L9;
        WaitingEventConfig r101 = new WaitingEventConfig(false, 0.0f, 0, 0, 15, null);
    L11:
        if ((r113 & 4) == 0) goto L13;
        EventConfig r102 = new EventConfig(false, 0.0f, 3, null);
    L14:
        this(r100, r101, r102);
        return;
    L13:
        r102 = r112;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
