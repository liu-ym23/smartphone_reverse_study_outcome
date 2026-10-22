package com.ss.android.lark.storage.file.migration;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/storage/file/migration/ErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "NO_SPACE", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ErrorCode extends Enum<ErrorCode> {
    public static final ErrorCode NO_SPACE = null;
    public static final ErrorCode SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorCode[] f440979a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440980b = null;

    public static EnumEntries<ErrorCode> getEntries() {
        return f440980b;
    }

    static {
        ErrorCode r100 = new ErrorCode("SUCCESS", 0);
        SUCCESS = r100;
        ErrorCode r101 = new ErrorCode("NO_SPACE", 1);
        NO_SPACE = r101;
        ErrorCode[] r102 = {r100, r101};
        f440979a = r102;
        f440980b = EnumEntriesKt.enumEntries(r102);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) f440979a.clone();
    }

    public static ErrorCode valueOf(String r100) {
        return (ErrorCode) r27.a.a(ErrorCode.class, r100);
    }

    public ErrorCode(String r100, int r101) {
        super(r100, r101);
    }
}
