package com.ss.android.lark.officesdk.minutes.api.hardware.upload;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/upload/MmHardwareFileUploadRuntimeDeleteReason;", "", "<init>", "(Ljava/lang/String;I)V", "DELETE_BY_USER", "UPLOAD_SUCCESS", "ACCOUNT_CHANGE", "DUPLICATE_IN_SERVER", AccountType.OTHERS, "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmHardwareFileUploadRuntimeDeleteReason extends Enum<MmHardwareFileUploadRuntimeDeleteReason> {
    public static final MmHardwareFileUploadRuntimeDeleteReason ACCOUNT_CHANGE = null;
    public static final MmHardwareFileUploadRuntimeDeleteReason DELETE_BY_USER = null;
    public static final MmHardwareFileUploadRuntimeDeleteReason DUPLICATE_IN_SERVER = null;
    public static final MmHardwareFileUploadRuntimeDeleteReason OTHERS = null;
    public static final MmHardwareFileUploadRuntimeDeleteReason UPLOAD_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmHardwareFileUploadRuntimeDeleteReason[] f433506a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433507b = null;

    public static EnumEntries<MmHardwareFileUploadRuntimeDeleteReason> getEntries() {
        return f433507b;
    }

    static {
        MmHardwareFileUploadRuntimeDeleteReason r100 = new MmHardwareFileUploadRuntimeDeleteReason("DELETE_BY_USER", 0);
        DELETE_BY_USER = r100;
        MmHardwareFileUploadRuntimeDeleteReason r101 = new MmHardwareFileUploadRuntimeDeleteReason("UPLOAD_SUCCESS", 1);
        UPLOAD_SUCCESS = r101;
        MmHardwareFileUploadRuntimeDeleteReason r102 = new MmHardwareFileUploadRuntimeDeleteReason("ACCOUNT_CHANGE", 2);
        ACCOUNT_CHANGE = r102;
        MmHardwareFileUploadRuntimeDeleteReason r103 = new MmHardwareFileUploadRuntimeDeleteReason("DUPLICATE_IN_SERVER", 3);
        DUPLICATE_IN_SERVER = r103;
        MmHardwareFileUploadRuntimeDeleteReason r104 = new MmHardwareFileUploadRuntimeDeleteReason(AccountType.OTHERS, 4);
        OTHERS = r104;
        MmHardwareFileUploadRuntimeDeleteReason[] r105 = {r100, r101, r102, r103, r104};
        f433506a = r105;
        f433507b = EnumEntriesKt.enumEntries(r105);
    }

    public static MmHardwareFileUploadRuntimeDeleteReason[] values() {
        return (MmHardwareFileUploadRuntimeDeleteReason[]) f433506a.clone();
    }

    public static MmHardwareFileUploadRuntimeDeleteReason valueOf(String r100) {
        return (MmHardwareFileUploadRuntimeDeleteReason) a.a(MmHardwareFileUploadRuntimeDeleteReason.class, r100);
    }

    public MmHardwareFileUploadRuntimeDeleteReason(String r100, int r101) {
        super(r100, r101);
    }
}
