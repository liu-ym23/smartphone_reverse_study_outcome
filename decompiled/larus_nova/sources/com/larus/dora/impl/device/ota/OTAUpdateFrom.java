package com.larus.dora.impl.device.ota;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/device/ota/OTAUpdateFrom;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "UI", "StartAutoOta", "DoraLinkStateChanged", "BudsChanged", "AutoSwitch", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OTAUpdateFrom extends Enum<OTAUpdateFrom> {
    public static final OTAUpdateFrom AutoSwitch = null;
    public static final OTAUpdateFrom BudsChanged = null;
    public static final OTAUpdateFrom DoraLinkStateChanged = null;
    public static final OTAUpdateFrom StartAutoOta = null;
    public static final OTAUpdateFrom UI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OTAUpdateFrom[] f334186a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334187b = null;
    private final String scene;

    public static EnumEntries<OTAUpdateFrom> getEntries() {
        return f334187b;
    }

    static {
        OTAUpdateFrom r100 = new OTAUpdateFrom("UI", 0, "UI");
        UI = r100;
        OTAUpdateFrom r101 = new OTAUpdateFrom("StartAutoOta", 1, "StartAutoOta");
        StartAutoOta = r101;
        OTAUpdateFrom r102 = new OTAUpdateFrom("DoraLinkStateChanged", 2, "onDoraLinkStateChanged");
        DoraLinkStateChanged = r102;
        OTAUpdateFrom r103 = new OTAUpdateFrom("BudsChanged", 3, "BudsChanged");
        BudsChanged = r103;
        OTAUpdateFrom r104 = new OTAUpdateFrom("AutoSwitch", 4, "AutoSwitch");
        AutoSwitch = r104;
        OTAUpdateFrom[] r105 = {r100, r101, r102, r103, r104};
        f334186a = r105;
        f334187b = EnumEntriesKt.enumEntries(r105);
    }

    public static OTAUpdateFrom[] values() {
        return (OTAUpdateFrom[]) f334186a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static OTAUpdateFrom valueOf(String r100) {
        return (OTAUpdateFrom) r27.a.a(OTAUpdateFrom.class, r100);
    }

    public OTAUpdateFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
