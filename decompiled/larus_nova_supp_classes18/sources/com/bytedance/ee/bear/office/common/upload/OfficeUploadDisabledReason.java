package com.bytedance.ee.bear.office.common.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadDisabledReason;", "", "<init>", "(Ljava/lang/String;I)V", "OWNER_NOT_READY", "NETWORK_UNAVAILABLE", "TARGET_INVALID", "FOLDER_NOT_WRITABLE", "MENU_CONFIG_DISABLED", "PERMISSION_HIDDEN", "PERMISSION_DISABLED", "PERMISSION_UNAVAILABLE", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUploadDisabledReason extends Enum<OfficeUploadDisabledReason> {
    public static final OfficeUploadDisabledReason FOLDER_NOT_WRITABLE = null;
    public static final OfficeUploadDisabledReason MENU_CONFIG_DISABLED = null;
    public static final OfficeUploadDisabledReason NETWORK_UNAVAILABLE = null;
    public static final OfficeUploadDisabledReason OWNER_NOT_READY = null;
    public static final OfficeUploadDisabledReason PERMISSION_DISABLED = null;
    public static final OfficeUploadDisabledReason PERMISSION_HIDDEN = null;
    public static final OfficeUploadDisabledReason PERMISSION_UNAVAILABLE = null;
    public static final OfficeUploadDisabledReason TARGET_INVALID = null;
    public static final /* synthetic */ OfficeUploadDisabledReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeUploadDisabledReason> getEntries() {
        return b;
    }

    static {
        OfficeUploadDisabledReason r0 = new OfficeUploadDisabledReason("OWNER_NOT_READY", 0);
        OWNER_NOT_READY = r0;
        OfficeUploadDisabledReason r1 = new OfficeUploadDisabledReason("NETWORK_UNAVAILABLE", 1);
        NETWORK_UNAVAILABLE = r1;
        OfficeUploadDisabledReason r3 = new OfficeUploadDisabledReason("TARGET_INVALID", 2);
        TARGET_INVALID = r3;
        OfficeUploadDisabledReason r5 = new OfficeUploadDisabledReason("FOLDER_NOT_WRITABLE", 3);
        FOLDER_NOT_WRITABLE = r5;
        OfficeUploadDisabledReason r7 = new OfficeUploadDisabledReason("MENU_CONFIG_DISABLED", 4);
        MENU_CONFIG_DISABLED = r7;
        OfficeUploadDisabledReason r9 = new OfficeUploadDisabledReason("PERMISSION_HIDDEN", 5);
        PERMISSION_HIDDEN = r9;
        OfficeUploadDisabledReason r11 = new OfficeUploadDisabledReason("PERMISSION_DISABLED", 6);
        PERMISSION_DISABLED = r11;
        OfficeUploadDisabledReason r13 = new OfficeUploadDisabledReason("PERMISSION_UNAVAILABLE", 7);
        PERMISSION_UNAVAILABLE = r13;
        OfficeUploadDisabledReason[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static OfficeUploadDisabledReason[] values() {
        return (OfficeUploadDisabledReason[]) a.clone();
    }

    public static OfficeUploadDisabledReason valueOf(String r1) {
        return (OfficeUploadDisabledReason) r27.a.a(OfficeUploadDisabledReason.class, r1);
    }

    public OfficeUploadDisabledReason(String r1, int r2) {
        super(r1, r2);
    }
}
