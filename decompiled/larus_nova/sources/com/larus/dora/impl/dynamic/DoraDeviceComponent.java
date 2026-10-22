package com.larus.dora.impl.dynamic;

import com.bytedance.ee.bear.drive.biz.cache.manual.model.ManualOfflineSyncData;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/dynamic/DoraDeviceComponent;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", ManualOfflineSyncData.DRIVE_TYPE, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraDeviceComponent extends Enum<DoraDeviceComponent> {
    public static final DoraDeviceComponent BOX = null;
    public static final DoraDeviceComponent LEFT = null;
    public static final DoraDeviceComponent RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraDeviceComponent[] f335054a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335055b = null;

    public static EnumEntries<DoraDeviceComponent> getEntries() {
        return f335055b;
    }

    static {
        DoraDeviceComponent r100 = new DoraDeviceComponent("LEFT", 0);
        LEFT = r100;
        DoraDeviceComponent r101 = new DoraDeviceComponent("RIGHT", 1);
        RIGHT = r101;
        DoraDeviceComponent r102 = new DoraDeviceComponent(ManualOfflineSyncData.DRIVE_TYPE, 2);
        BOX = r102;
        DoraDeviceComponent[] r103 = {r100, r101, r102};
        f335054a = r103;
        f335055b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraDeviceComponent[] values() {
        return (DoraDeviceComponent[]) f335054a.clone();
    }

    public static DoraDeviceComponent valueOf(String r100) {
        return (DoraDeviceComponent) r27.a.a(DoraDeviceComponent.class, r100);
    }

    public DoraDeviceComponent(String r100, int r101) {
        super(r100, r101);
    }
}
