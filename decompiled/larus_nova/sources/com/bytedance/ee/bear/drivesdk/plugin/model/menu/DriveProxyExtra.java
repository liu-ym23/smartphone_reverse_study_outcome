package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import com.ss.ttvideoengine.model.BarrageMaskInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drivesdk/plugin/model/menu/DriveProxyExtra;", "", "<init>", "(Ljava/lang/String;I)V", BarrageMaskInfo.KEY_VER4_MASK_FILE_ID, BarrageMaskInfo.KEY_VER4_MASK_FILE_SIZE, "FileName", "FileType", "contentmanager-drive-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveProxyExtra extends Enum<DriveProxyExtra> {
    public static final DriveProxyExtra FileId = null;
    public static final DriveProxyExtra FileName = null;
    public static final DriveProxyExtra FileSize = null;
    public static final DriveProxyExtra FileType = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveProxyExtra[] f225999a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f226000b = null;

    public static EnumEntries<DriveProxyExtra> getEntries() {
        return f226000b;
    }

    static {
        DriveProxyExtra r100 = new DriveProxyExtra(BarrageMaskInfo.KEY_VER4_MASK_FILE_ID, 0);
        FileId = r100;
        DriveProxyExtra r101 = new DriveProxyExtra(BarrageMaskInfo.KEY_VER4_MASK_FILE_SIZE, 1);
        FileSize = r101;
        DriveProxyExtra r102 = new DriveProxyExtra("FileName", 2);
        FileName = r102;
        DriveProxyExtra r103 = new DriveProxyExtra("FileType", 3);
        FileType = r103;
        DriveProxyExtra[] r104 = {r100, r101, r102, r103};
        f225999a = r104;
        f226000b = EnumEntriesKt.enumEntries(r104);
    }

    public static DriveProxyExtra[] values() {
        return (DriveProxyExtra[]) f225999a.clone();
    }

    public static DriveProxyExtra valueOf(String r100) {
        return (DriveProxyExtra) r27.a.a(DriveProxyExtra.class, r100);
    }

    public DriveProxyExtra(String r100, int r101) {
        super(r100, r101);
    }
}
