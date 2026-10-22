package com.larus.dora.obric.device_management.device_home;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeTabPage;", "", "<init>", "(Ljava/lang/String;I)V", FeatureConfigInfo.DEVICE_FEATURE_TYPE_ID, "DIARY", "HEALTH", "DISCOVER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceHomeTabPage extends Enum<DoraObricDeviceHomeTabPage> {
    public static final DoraObricDeviceHomeTabPage DEVICE = null;
    public static final DoraObricDeviceHomeTabPage DIARY = null;
    public static final DoraObricDeviceHomeTabPage DISCOVER = null;
    public static final DoraObricDeviceHomeTabPage HEALTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricDeviceHomeTabPage[] f339081a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339082b = null;

    public static EnumEntries<DoraObricDeviceHomeTabPage> getEntries() {
        return f339082b;
    }

    static {
        DoraObricDeviceHomeTabPage r100 = new DoraObricDeviceHomeTabPage(FeatureConfigInfo.DEVICE_FEATURE_TYPE_ID, 0);
        DEVICE = r100;
        DoraObricDeviceHomeTabPage r101 = new DoraObricDeviceHomeTabPage("DIARY", 1);
        DIARY = r101;
        DoraObricDeviceHomeTabPage r102 = new DoraObricDeviceHomeTabPage("HEALTH", 2);
        HEALTH = r102;
        DoraObricDeviceHomeTabPage r103 = new DoraObricDeviceHomeTabPage("DISCOVER", 3);
        DISCOVER = r103;
        DoraObricDeviceHomeTabPage[] r104 = {r100, r101, r102, r103};
        f339081a = r104;
        f339082b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoraObricDeviceHomeTabPage[] values() {
        return (DoraObricDeviceHomeTabPage[]) f339081a.clone();
    }

    public static DoraObricDeviceHomeTabPage valueOf(String r100) {
        return (DoraObricDeviceHomeTabPage) r27.a.a(DoraObricDeviceHomeTabPage.class, r100);
    }

    public DoraObricDeviceHomeTabPage(String r100, int r101) {
        super(r100, r101);
    }
}
