package com.larus.drive.biz.impl.view.fileselect;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/drive/biz/impl/view/fileselect/DriveSelectActionType;", "", "<init>", "(Ljava/lang/String;I)V", "ASK_AI", "SHARE", HttpMethod.DOWNLOAD, "RENAME", "MOVE", "DELETE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveSelectActionType extends Enum<DriveSelectActionType> {
    public static final DriveSelectActionType ASK_AI = null;
    public static final DriveSelectActionType DELETE = null;
    public static final DriveSelectActionType DOWNLOAD = null;
    public static final DriveSelectActionType MOVE = null;
    public static final DriveSelectActionType RENAME = null;
    public static final DriveSelectActionType SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveSelectActionType[] f341359a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f341360b = null;

    public static EnumEntries<DriveSelectActionType> getEntries() {
        return f341360b;
    }

    static {
        DriveSelectActionType r100 = new DriveSelectActionType("ASK_AI", 0);
        ASK_AI = r100;
        DriveSelectActionType r101 = new DriveSelectActionType("SHARE", 1);
        SHARE = r101;
        DriveSelectActionType r102 = new DriveSelectActionType(HttpMethod.DOWNLOAD, 2);
        DOWNLOAD = r102;
        DriveSelectActionType r103 = new DriveSelectActionType("RENAME", 3);
        RENAME = r103;
        DriveSelectActionType r104 = new DriveSelectActionType("MOVE", 4);
        MOVE = r104;
        DriveSelectActionType r105 = new DriveSelectActionType("DELETE", 5);
        DELETE = r105;
        DriveSelectActionType[] r110 = {r100, r101, r102, r103, r104, r105};
        f341359a = r110;
        f341360b = EnumEntriesKt.enumEntries(r110);
    }

    public static DriveSelectActionType[] values() {
        return (DriveSelectActionType[]) f341359a.clone();
    }

    public static DriveSelectActionType valueOf(String r100) {
        return (DriveSelectActionType) a.a(DriveSelectActionType.class, r100);
    }

    public DriveSelectActionType(String r100, int r101) {
        super(r100, r101);
    }
}
