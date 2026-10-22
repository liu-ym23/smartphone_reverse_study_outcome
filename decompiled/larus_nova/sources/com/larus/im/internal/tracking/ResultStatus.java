package com.larus.im.internal.tracking;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/im/internal/tracking/ResultStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "ERROR", "TIMEOUT", "INTERRUPT", "CANCEL", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResultStatus extends Enum<ResultStatus> {
    public static final ResultStatus CANCEL = null;
    public static final ResultStatus ERROR = null;
    public static final ResultStatus INTERRUPT = null;
    public static final ResultStatus SUCCESS = null;
    public static final ResultStatus TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultStatus[] f350225a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350226b = null;

    public static EnumEntries<ResultStatus> getEntries() {
        return f350226b;
    }

    static {
        ResultStatus r100 = new ResultStatus("SUCCESS", 0);
        SUCCESS = r100;
        ResultStatus r101 = new ResultStatus("ERROR", 1);
        ERROR = r101;
        ResultStatus r102 = new ResultStatus("TIMEOUT", 2);
        TIMEOUT = r102;
        ResultStatus r103 = new ResultStatus("INTERRUPT", 3);
        INTERRUPT = r103;
        ResultStatus r104 = new ResultStatus("CANCEL", 4);
        CANCEL = r104;
        ResultStatus[] r105 = {r100, r101, r102, r103, r104};
        f350225a = r105;
        f350226b = EnumEntriesKt.enumEntries(r105);
    }

    public static ResultStatus[] values() {
        return (ResultStatus[]) f350225a.clone();
    }

    public static ResultStatus valueOf(String r100) {
        return (ResultStatus) r27.a.a(ResultStatus.class, r100);
    }

    public ResultStatus(String r100, int r101) {
        super(r100, r101);
    }
}
