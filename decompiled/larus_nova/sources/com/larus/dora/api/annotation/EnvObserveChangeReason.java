package com.larus.dora.api.annotation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/api/annotation/EnvObserveChangeReason;", "", "reason", "", "<init>", "(Ljava/lang/String;II)V", "getReason", "()I", "setReason", "(I)V", "SWITCH_CHANGE", "TIMER_CHANGE", "WIFI_CHANGE", "CONNECT_CHANGE", "DEVICE_CHANGE", "NETWORK_CHANGE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnvObserveChangeReason extends Enum<EnvObserveChangeReason> {
    public static final EnvObserveChangeReason CONNECT_CHANGE = null;
    public static final EnvObserveChangeReason DEVICE_CHANGE = null;
    public static final EnvObserveChangeReason NETWORK_CHANGE = null;
    public static final EnvObserveChangeReason SWITCH_CHANGE = null;
    public static final EnvObserveChangeReason TIMER_CHANGE = null;
    public static final EnvObserveChangeReason WIFI_CHANGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnvObserveChangeReason[] f331734a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331735b = null;
    private int reason;

    public static EnumEntries<EnvObserveChangeReason> getEntries() {
        return f331735b;
    }

    static {
        EnvObserveChangeReason r100 = new EnvObserveChangeReason("SWITCH_CHANGE", 0);
        SWITCH_CHANGE = r100;
        EnvObserveChangeReason r101 = new EnvObserveChangeReason("TIMER_CHANGE", 1);
        TIMER_CHANGE = r101;
        EnvObserveChangeReason r102 = new EnvObserveChangeReason("WIFI_CHANGE", 2);
        WIFI_CHANGE = r102;
        EnvObserveChangeReason r103 = new EnvObserveChangeReason("CONNECT_CHANGE", 3);
        CONNECT_CHANGE = r103;
        EnvObserveChangeReason r104 = new EnvObserveChangeReason("DEVICE_CHANGE", 4);
        DEVICE_CHANGE = r104;
        EnvObserveChangeReason r105 = new EnvObserveChangeReason("NETWORK_CHANGE", 5);
        NETWORK_CHANGE = r105;
        EnvObserveChangeReason[] r110 = {r100, r101, r102, r103, r104, r105};
        f331734a = r110;
        f331735b = EnumEntriesKt.enumEntries(r110);
    }

    public static EnvObserveChangeReason[] values() {
        return (EnvObserveChangeReason[]) f331734a.clone();
    }

    public final int getReason() {
        return this.reason;
    }

    public static EnvObserveChangeReason valueOf(String r100) {
        return (EnvObserveChangeReason) a.a(EnvObserveChangeReason.class, r100);
    }

    public final void setReason(int r100) {
        this.reason = r100;
    }

    public EnvObserveChangeReason(String r100, int r101) {
        super(r100, r101);
        this.reason = 0;
    }
}
