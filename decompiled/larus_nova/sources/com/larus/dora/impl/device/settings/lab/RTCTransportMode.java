package com.larus.dora.impl.device.settings.lab;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/RTCTransportMode;", "", "<init>", "(Ljava/lang/String;I)V", "OFF", "BLUETOOTH", "WIFI", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RTCTransportMode extends Enum<RTCTransportMode> {
    public static final RTCTransportMode BLUETOOTH = null;
    public static final a Companion = null;
    public static final RTCTransportMode OFF = null;
    public static final RTCTransportMode WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RTCTransportMode[] f334560a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334561b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<RTCTransportMode> getEntries() {
        return f334561b;
    }

    static {
        RTCTransportMode r100 = new RTCTransportMode("OFF", 0);
        OFF = r100;
        RTCTransportMode r101 = new RTCTransportMode("BLUETOOTH", 1);
        BLUETOOTH = r101;
        RTCTransportMode r102 = new RTCTransportMode("WIFI", 2);
        WIFI = r102;
        RTCTransportMode[] r103 = {r100, r101, r102};
        f334560a = r103;
        f334561b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static RTCTransportMode[] values() {
        return (RTCTransportMode[]) f334560a.clone();
    }

    public static RTCTransportMode valueOf(String r100) {
        return (RTCTransportMode) r27.a.a(RTCTransportMode.class, r100);
    }

    public RTCTransportMode(String r100, int r101) {
        super(r100, r101);
    }
}
