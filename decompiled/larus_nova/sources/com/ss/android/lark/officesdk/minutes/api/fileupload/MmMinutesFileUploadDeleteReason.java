package com.ss.android.lark.officesdk.minutes.api.fileupload;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/fileupload/MmMinutesFileUploadDeleteReason;", "", "<init>", "(Ljava/lang/String;I)V", "DELETE_BY_USER", "DUPLICATE_IN_SERVER", "ACCOUNT_CHANGE", AccountType.OTHERS, "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmMinutesFileUploadDeleteReason extends Enum<MmMinutesFileUploadDeleteReason> {
    public static final MmMinutesFileUploadDeleteReason ACCOUNT_CHANGE = null;
    public static final MmMinutesFileUploadDeleteReason DELETE_BY_USER = null;
    public static final MmMinutesFileUploadDeleteReason DUPLICATE_IN_SERVER = null;
    public static final MmMinutesFileUploadDeleteReason OTHERS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmMinutesFileUploadDeleteReason[] f433476a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433477b = null;

    public static EnumEntries<MmMinutesFileUploadDeleteReason> getEntries() {
        return f433477b;
    }

    static {
        MmMinutesFileUploadDeleteReason r100 = new MmMinutesFileUploadDeleteReason("DELETE_BY_USER", 0);
        DELETE_BY_USER = r100;
        MmMinutesFileUploadDeleteReason r101 = new MmMinutesFileUploadDeleteReason("DUPLICATE_IN_SERVER", 1);
        DUPLICATE_IN_SERVER = r101;
        MmMinutesFileUploadDeleteReason r102 = new MmMinutesFileUploadDeleteReason("ACCOUNT_CHANGE", 2);
        ACCOUNT_CHANGE = r102;
        MmMinutesFileUploadDeleteReason r103 = new MmMinutesFileUploadDeleteReason(AccountType.OTHERS, 3);
        OTHERS = r103;
        MmMinutesFileUploadDeleteReason[] r104 = {r100, r101, r102, r103};
        f433476a = r104;
        f433477b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmMinutesFileUploadDeleteReason[] values() {
        return (MmMinutesFileUploadDeleteReason[]) f433476a.clone();
    }

    public static MmMinutesFileUploadDeleteReason valueOf(String r100) {
        return (MmMinutesFileUploadDeleteReason) a.a(MmMinutesFileUploadDeleteReason.class, r100);
    }

    public MmMinutesFileUploadDeleteReason(String r100, int r101) {
        super(r100, r101);
    }
}
