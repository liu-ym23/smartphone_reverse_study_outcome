package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drivesdk/plugin/model/menu/DriveProxyExtra;", "", "<init>", "(Ljava/lang/String;I)V", "FileId", "FileSize", "FileName", "FileType", "contentmanager-drive-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveProxyExtra extends Enum<DriveProxyExtra> {
    public static final DriveProxyExtra FileId = null;
    public static final DriveProxyExtra FileName = null;
    public static final DriveProxyExtra FileSize = null;
    public static final DriveProxyExtra FileType = null;
    public static final /* synthetic */ DriveProxyExtra[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DriveProxyExtra> getEntries() {
        return b;
    }

    static {
        DriveProxyExtra r0 = new DriveProxyExtra("FileId", 0);
        FileId = r0;
        DriveProxyExtra r1 = new DriveProxyExtra("FileSize", 1);
        FileSize = r1;
        DriveProxyExtra r3 = new DriveProxyExtra("FileName", 2);
        FileName = r3;
        DriveProxyExtra r5 = new DriveProxyExtra("FileType", 3);
        FileType = r5;
        DriveProxyExtra[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DriveProxyExtra[] values() {
        return (DriveProxyExtra[]) a.clone();
    }

    public static DriveProxyExtra valueOf(String r1) {
        return (DriveProxyExtra) r27.a.a(DriveProxyExtra.class, r1);
    }

    public DriveProxyExtra(String r1, int r2) {
        super(r1, r2);
    }
}
