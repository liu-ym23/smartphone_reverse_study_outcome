package com.larus.avlink.business.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/avlink/business/api/DoraAvlinkDeviceSound;", "", "<init>", "(Ljava/lang/String;I)V", "VUI_ERROR", "dora_business_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraAvlinkDeviceSound extends Enum<DoraAvlinkDeviceSound> {
    public static final DoraAvlinkDeviceSound VUI_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraAvlinkDeviceSound[] f291698a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291699b = null;

    public static EnumEntries<DoraAvlinkDeviceSound> getEntries() {
        return f291699b;
    }

    static {
        DoraAvlinkDeviceSound r100 = new DoraAvlinkDeviceSound();
        VUI_ERROR = r100;
        DoraAvlinkDeviceSound[] r101 = {r100};
        f291698a = r101;
        f291699b = EnumEntriesKt.enumEntries(r101);
    }

    public DoraAvlinkDeviceSound() {
        super("VUI_ERROR", 0);
    }

    public static DoraAvlinkDeviceSound[] values() {
        return (DoraAvlinkDeviceSound[]) f291698a.clone();
    }

    public static DoraAvlinkDeviceSound valueOf(String r100) {
        return (DoraAvlinkDeviceSound) a.a(DoraAvlinkDeviceSound.class, r100);
    }
}
