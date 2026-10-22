package com.larus.avlink.rtc;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/larus/avlink/rtc/MMTDowngradeDevice;", "", "<init>", "(Ljava/lang/String;I)V", "G1", "G2", "LITE", FaceService.neutralLabel, "ANKER", "isHeadphoneDevice", "", "isDoraG", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MMTDowngradeDevice extends Enum<MMTDowngradeDevice> {
    public static final MMTDowngradeDevice ANKER = null;
    public static final MMTDowngradeDevice G1 = null;
    public static final MMTDowngradeDevice G2 = null;
    public static final MMTDowngradeDevice H = null;
    public static final MMTDowngradeDevice LITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MMTDowngradeDevice[] f294451a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294452b = null;

    public static EnumEntries<MMTDowngradeDevice> getEntries() {
        return f294452b;
    }

    static {
        MMTDowngradeDevice r100 = new MMTDowngradeDevice("G1", 0);
        G1 = r100;
        MMTDowngradeDevice r101 = new MMTDowngradeDevice("G2", 1);
        G2 = r101;
        MMTDowngradeDevice r102 = new MMTDowngradeDevice("LITE", 2);
        LITE = r102;
        MMTDowngradeDevice r103 = new MMTDowngradeDevice(FaceService.neutralLabel, 3);
        H = r103;
        MMTDowngradeDevice r104 = new MMTDowngradeDevice("ANKER", 4);
        ANKER = r104;
        MMTDowngradeDevice[] r105 = {r100, r101, r102, r103, r104};
        f294451a = r105;
        f294452b = EnumEntriesKt.enumEntries(r105);
    }

    public static MMTDowngradeDevice[] values() {
        return (MMTDowngradeDevice[]) f294451a.clone();
    }

    public final boolean isDoraG() {
        if (this != G1) goto L5;
    L8:
        return true;
    L5:
        if (this == G2) goto L8;
        return false;
    }

    public final boolean isHeadphoneDevice() {
        if (this != LITE) goto L5;
    L10:
        return true;
    L5:
        if (this == H) goto L10;
        if (this == ANKER) goto L10;
        return false;
    }

    public static MMTDowngradeDevice valueOf(String r100) {
        return (MMTDowngradeDevice) r27.a.a(MMTDowngradeDevice.class, r100);
    }

    public MMTDowngradeDevice(String r100, int r101) {
        super(r100, r101);
    }
}
