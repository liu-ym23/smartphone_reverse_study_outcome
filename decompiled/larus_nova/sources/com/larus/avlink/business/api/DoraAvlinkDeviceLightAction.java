package com.larus.avlink.business.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/avlink/business/api/DoraAvlinkDeviceLightAction;", "", "<init>", "(Ljava/lang/String;I)V", "INDICATOR_RAPID_FLASHING", "dora_business_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraAvlinkDeviceLightAction extends Enum<DoraAvlinkDeviceLightAction> {
    public static final DoraAvlinkDeviceLightAction INDICATOR_RAPID_FLASHING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraAvlinkDeviceLightAction[] f291696a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291697b = null;

    public static EnumEntries<DoraAvlinkDeviceLightAction> getEntries() {
        return f291697b;
    }

    static {
        DoraAvlinkDeviceLightAction r100 = new DoraAvlinkDeviceLightAction();
        INDICATOR_RAPID_FLASHING = r100;
        DoraAvlinkDeviceLightAction[] r101 = {r100};
        f291696a = r101;
        f291697b = EnumEntriesKt.enumEntries(r101);
    }

    public DoraAvlinkDeviceLightAction() {
        super("INDICATOR_RAPID_FLASHING", 0);
    }

    public static DoraAvlinkDeviceLightAction[] values() {
        return (DoraAvlinkDeviceLightAction[]) f291696a.clone();
    }

    public static DoraAvlinkDeviceLightAction valueOf(String r100) {
        return (DoraAvlinkDeviceLightAction) a.a(DoraAvlinkDeviceLightAction.class, r100);
    }
}
