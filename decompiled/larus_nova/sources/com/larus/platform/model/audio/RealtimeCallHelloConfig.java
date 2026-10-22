package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeCallHelloConfig;", "", "audioHello", "Lcom/larus/platform/model/audio/EventConfig;", "onlyEnableMainBot", "", "<init>", "(Lcom/larus/platform/model/audio/EventConfig;Z)V", "getAudioHello", "()Lcom/larus/platform/model/audio/EventConfig;", "getOnlyEnableMainBot", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallHelloConfig {

    @SerializedName("audio_realtime_call_hello")
    private final EventConfig audioHello;

    @SerializedName("only_enable_main_bot")
    private final boolean onlyEnableMainBot;

    /* JADX WARN: Multi-variable type inference failed */
    public RealtimeCallHelloConfig() {
        EventConfig r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RealtimeCallHelloConfig copy$default(RealtimeCallHelloConfig r100, EventConfig r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.audioHello;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.onlyEnableMainBot;
    L9:
        return r100.copy(r101, r102);
    }

    public final EventConfig component1() {
        return this.audioHello;
    }

    public final boolean component2() {
        return this.onlyEnableMainBot;
    }

    public final RealtimeCallHelloConfig copy(EventConfig r100, boolean r101) {
        return new RealtimeCallHelloConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RealtimeCallHelloConfig) == true) goto L8;
        return false;
    L8:
        RealtimeCallHelloConfig r101 = (RealtimeCallHelloConfig) r100;
        if (Intrinsics.areEqual(this.audioHello, r101.audioHello) == true) goto L12;
        return false;
    L12:
        if (this.onlyEnableMainBot == r101.onlyEnableMainBot) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        EventConfig r100 = this.audioHello;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.onlyEnableMainBot == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RealtimeCallHelloConfig(audioHello=" + this.audioHello + ", onlyEnableMainBot=" + this.onlyEnableMainBot + ')';
    }

    public final EventConfig getAudioHello() {
        return this.audioHello;
    }

    public final boolean getOnlyEnableMainBot() {
        return this.onlyEnableMainBot;
    }

    public RealtimeCallHelloConfig(EventConfig r100, boolean r101) {
        this.audioHello = r100;
        this.onlyEnableMainBot = r101;
    }

    public /* synthetic */ RealtimeCallHelloConfig(EventConfig r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new EventConfig(false, 0.0f, 3, null);
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
