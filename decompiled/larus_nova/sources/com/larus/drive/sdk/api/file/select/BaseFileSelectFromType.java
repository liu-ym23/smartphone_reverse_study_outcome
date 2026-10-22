package com.larus.drive.sdk.api.file.select;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/drive/sdk/api/file/select/BaseFileSelectFromType;", "", "<init>", "(Ljava/lang/String;I)V", "DRIVE", "RECENT", AccountType.LOCAL, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BaseFileSelectFromType extends Enum<BaseFileSelectFromType> {
    public static final BaseFileSelectFromType DRIVE = null;
    public static final BaseFileSelectFromType LOCAL = null;
    public static final BaseFileSelectFromType RECENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BaseFileSelectFromType[] f341583a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f341584b = null;

    public static EnumEntries<BaseFileSelectFromType> getEntries() {
        return f341584b;
    }

    static {
        BaseFileSelectFromType r100 = new BaseFileSelectFromType("DRIVE", 0);
        DRIVE = r100;
        BaseFileSelectFromType r101 = new BaseFileSelectFromType("RECENT", 1);
        RECENT = r101;
        BaseFileSelectFromType r102 = new BaseFileSelectFromType(AccountType.LOCAL, 2);
        LOCAL = r102;
        BaseFileSelectFromType[] r103 = {r100, r101, r102};
        f341583a = r103;
        f341584b = EnumEntriesKt.enumEntries(r103);
    }

    public static BaseFileSelectFromType[] values() {
        return (BaseFileSelectFromType[]) f341583a.clone();
    }

    public static BaseFileSelectFromType valueOf(String r100) {
        return (BaseFileSelectFromType) a.a(BaseFileSelectFromType.class, r100);
    }

    public BaseFileSelectFromType(String r100, int r101) {
        super(r100, r101);
    }
}
