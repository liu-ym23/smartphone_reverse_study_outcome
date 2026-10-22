package com.bytedance.ee.bear.more.office;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/more/office/OfficeLongPressDisabledDispatchReason;", "", "<init>", "(Ljava/lang/String;I)V", "PERMISSION_PLATFORM_ACTION", "SECURITY_POLICY_DIALOG", "PREFETCH_IN_PROGRESS_RETRY", "PREFETCH_FAILED_RETRY", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeLongPressDisabledDispatchReason extends Enum<OfficeLongPressDisabledDispatchReason> {
    public static final OfficeLongPressDisabledDispatchReason PERMISSION_PLATFORM_ACTION = null;
    public static final OfficeLongPressDisabledDispatchReason PREFETCH_FAILED_RETRY = null;
    public static final OfficeLongPressDisabledDispatchReason PREFETCH_IN_PROGRESS_RETRY = null;
    public static final OfficeLongPressDisabledDispatchReason SECURITY_POLICY_DIALOG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeLongPressDisabledDispatchReason[] f234678a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f234679b = null;

    public static EnumEntries<OfficeLongPressDisabledDispatchReason> getEntries() {
        return f234679b;
    }

    static {
        OfficeLongPressDisabledDispatchReason r100 = new OfficeLongPressDisabledDispatchReason("PERMISSION_PLATFORM_ACTION", 0);
        PERMISSION_PLATFORM_ACTION = r100;
        OfficeLongPressDisabledDispatchReason r101 = new OfficeLongPressDisabledDispatchReason("SECURITY_POLICY_DIALOG", 1);
        SECURITY_POLICY_DIALOG = r101;
        OfficeLongPressDisabledDispatchReason r102 = new OfficeLongPressDisabledDispatchReason("PREFETCH_IN_PROGRESS_RETRY", 2);
        PREFETCH_IN_PROGRESS_RETRY = r102;
        OfficeLongPressDisabledDispatchReason r103 = new OfficeLongPressDisabledDispatchReason("PREFETCH_FAILED_RETRY", 3);
        PREFETCH_FAILED_RETRY = r103;
        OfficeLongPressDisabledDispatchReason[] r104 = {r100, r101, r102, r103};
        f234678a = r104;
        f234679b = EnumEntriesKt.enumEntries(r104);
    }

    public static OfficeLongPressDisabledDispatchReason[] values() {
        return (OfficeLongPressDisabledDispatchReason[]) f234678a.clone();
    }

    public static OfficeLongPressDisabledDispatchReason valueOf(String r100) {
        return (OfficeLongPressDisabledDispatchReason) r27.a.a(OfficeLongPressDisabledDispatchReason.class, r100);
    }

    public OfficeLongPressDisabledDispatchReason(String r100, int r101) {
        super(r100, r101);
    }
}
