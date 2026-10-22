package com.larus.avlink.rtc;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/avlink/rtc/DoraRtcDevice;", "", "<init>", "(Ljava/lang/String;I)V", FaceService.neutralLabel, "LITE", "DORA_G", "UNKNOWN", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraRtcDevice extends Enum<DoraRtcDevice> {
    public static final DoraRtcDevice DORA_G = null;
    public static final DoraRtcDevice H = null;
    public static final DoraRtcDevice LITE = null;
    public static final DoraRtcDevice UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraRtcDevice[] f294443a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294444b = null;

    public static EnumEntries<DoraRtcDevice> getEntries() {
        return f294444b;
    }

    static {
        DoraRtcDevice r100 = new DoraRtcDevice(FaceService.neutralLabel, 0);
        H = r100;
        DoraRtcDevice r101 = new DoraRtcDevice("LITE", 1);
        LITE = r101;
        DoraRtcDevice r102 = new DoraRtcDevice("DORA_G", 2);
        DORA_G = r102;
        DoraRtcDevice r103 = new DoraRtcDevice("UNKNOWN", 3);
        UNKNOWN = r103;
        DoraRtcDevice[] r104 = {r100, r101, r102, r103};
        f294443a = r104;
        f294444b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoraRtcDevice[] values() {
        return (DoraRtcDevice[]) f294443a.clone();
    }

    public static DoraRtcDevice valueOf(String r100) {
        return (DoraRtcDevice) r27.a.a(DoraRtcDevice.class, r100);
    }

    public DoraRtcDevice(String r100, int r101) {
        super(r100, r101);
    }
}
