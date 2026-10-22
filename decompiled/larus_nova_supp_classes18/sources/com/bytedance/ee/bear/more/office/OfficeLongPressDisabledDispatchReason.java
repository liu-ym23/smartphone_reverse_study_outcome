package com.bytedance.ee.bear.more.office;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/more/office/OfficeLongPressDisabledDispatchReason;", "", "<init>", "(Ljava/lang/String;I)V", "PERMISSION_PLATFORM_ACTION", "SECURITY_POLICY_DIALOG", "PREFETCH_IN_PROGRESS_RETRY", "PREFETCH_FAILED_RETRY", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeLongPressDisabledDispatchReason extends Enum<OfficeLongPressDisabledDispatchReason> {
    public static final OfficeLongPressDisabledDispatchReason PERMISSION_PLATFORM_ACTION = null;
    public static final OfficeLongPressDisabledDispatchReason PREFETCH_FAILED_RETRY = null;
    public static final OfficeLongPressDisabledDispatchReason PREFETCH_IN_PROGRESS_RETRY = null;
    public static final OfficeLongPressDisabledDispatchReason SECURITY_POLICY_DIALOG = null;
    public static final /* synthetic */ OfficeLongPressDisabledDispatchReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeLongPressDisabledDispatchReason> getEntries() {
        return b;
    }

    static {
        OfficeLongPressDisabledDispatchReason r0 = new OfficeLongPressDisabledDispatchReason("PERMISSION_PLATFORM_ACTION", 0);
        PERMISSION_PLATFORM_ACTION = r0;
        OfficeLongPressDisabledDispatchReason r1 = new OfficeLongPressDisabledDispatchReason("SECURITY_POLICY_DIALOG", 1);
        SECURITY_POLICY_DIALOG = r1;
        OfficeLongPressDisabledDispatchReason r3 = new OfficeLongPressDisabledDispatchReason("PREFETCH_IN_PROGRESS_RETRY", 2);
        PREFETCH_IN_PROGRESS_RETRY = r3;
        OfficeLongPressDisabledDispatchReason r5 = new OfficeLongPressDisabledDispatchReason("PREFETCH_FAILED_RETRY", 3);
        PREFETCH_FAILED_RETRY = r5;
        OfficeLongPressDisabledDispatchReason[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static OfficeLongPressDisabledDispatchReason[] values() {
        return (OfficeLongPressDisabledDispatchReason[]) a.clone();
    }

    public static OfficeLongPressDisabledDispatchReason valueOf(String r1) {
        return (OfficeLongPressDisabledDispatchReason) r27.a.a(OfficeLongPressDisabledDispatchReason.class, r1);
    }

    public OfficeLongPressDisabledDispatchReason(String r1, int r2) {
        super(r1, r2);
    }
}
