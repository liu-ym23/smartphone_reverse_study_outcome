package com.obric.assistant.session.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/session/bean/ErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "CONTINUE", "QUIT_SESSION", "LAUNCH_ASSISTANT_DIRECTLY", "END_ON_SHOW", "ONLY_END", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ErrorCode extends Enum<ErrorCode> {
    public static final ErrorCode CONTINUE = null;
    public static final ErrorCode END_ON_SHOW = null;
    public static final ErrorCode LAUNCH_ASSISTANT_DIRECTLY = null;
    public static final ErrorCode NA = null;
    public static final ErrorCode ONLY_END = null;
    public static final ErrorCode QUIT_SESSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorCode[] f391493a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391494b = null;

    public static EnumEntries<ErrorCode> getEntries() {
        return f391494b;
    }

    static {
        ErrorCode r100 = new ErrorCode("NA", 0);
        NA = r100;
        ErrorCode r101 = new ErrorCode("CONTINUE", 1);
        CONTINUE = r101;
        ErrorCode r102 = new ErrorCode("QUIT_SESSION", 2);
        QUIT_SESSION = r102;
        ErrorCode r103 = new ErrorCode("LAUNCH_ASSISTANT_DIRECTLY", 3);
        LAUNCH_ASSISTANT_DIRECTLY = r103;
        ErrorCode r104 = new ErrorCode("END_ON_SHOW", 4);
        END_ON_SHOW = r104;
        ErrorCode r105 = new ErrorCode("ONLY_END", 5);
        ONLY_END = r105;
        ErrorCode[] r110 = {r100, r101, r102, r103, r104, r105};
        f391493a = r110;
        f391494b = EnumEntriesKt.enumEntries(r110);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) f391493a.clone();
    }

    public static ErrorCode valueOf(String r100) {
        return (ErrorCode) a.a(ErrorCode.class, r100);
    }

    public ErrorCode(String r100, int r101) {
        super(r100, r101);
    }
}
