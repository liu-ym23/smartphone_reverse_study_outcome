package com.larus.bmhome.chat.banner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerIconType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Default", "Percent", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActiveSwitchBannerIconType extends Enum<ActiveSwitchBannerIconType> {
    public static final ActiveSwitchBannerIconType Default = null;
    public static final ActiveSwitchBannerIconType Percent = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActiveSwitchBannerIconType[] f297395a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297396b = null;
    private final int value;

    public static EnumEntries<ActiveSwitchBannerIconType> getEntries() {
        return f297396b;
    }

    static {
        ActiveSwitchBannerIconType r100 = new ActiveSwitchBannerIconType("Default", 0, 0);
        Default = r100;
        ActiveSwitchBannerIconType r101 = new ActiveSwitchBannerIconType("Percent", 1, 1);
        Percent = r101;
        ActiveSwitchBannerIconType[] r102 = {r100, r101};
        f297395a = r102;
        f297396b = EnumEntriesKt.enumEntries(r102);
    }

    public static ActiveSwitchBannerIconType[] values() {
        return (ActiveSwitchBannerIconType[]) f297395a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ActiveSwitchBannerIconType valueOf(String r100) {
        return (ActiveSwitchBannerIconType) r27.a.a(ActiveSwitchBannerIconType.class, r100);
    }

    public ActiveSwitchBannerIconType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
