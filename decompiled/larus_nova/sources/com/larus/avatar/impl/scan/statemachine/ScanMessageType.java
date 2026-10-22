package com.larus.avatar.impl.scan.statemachine;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/avatar/impl/scan/statemachine/ScanMessageType;", "", "<init>", "(Ljava/lang/String;I)V", "START_COUNT_DOWN", "START_SAY", "SAY_FINISH", "WER_CHECK_SUCCESS", "START_CREATE", "CREATE_SUCCESS", "CREATE_FAIL", ErrorCode.INIT, "CLEAR", "FAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScanMessageType extends Enum<ScanMessageType> {
    public static final ScanMessageType CLEAR = null;
    public static final ScanMessageType CREATE_FAIL = null;
    public static final ScanMessageType CREATE_SUCCESS = null;
    public static final ScanMessageType FAIL = null;
    public static final ScanMessageType INIT = null;
    public static final ScanMessageType SAY_FINISH = null;
    public static final ScanMessageType START_COUNT_DOWN = null;
    public static final ScanMessageType START_CREATE = null;
    public static final ScanMessageType START_SAY = null;
    public static final ScanMessageType WER_CHECK_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScanMessageType[] f291035a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291036b = null;

    public static EnumEntries<ScanMessageType> getEntries() {
        return f291036b;
    }

    static {
        ScanMessageType r100 = new ScanMessageType("START_COUNT_DOWN", 0);
        START_COUNT_DOWN = r100;
        ScanMessageType r101 = new ScanMessageType("START_SAY", 1);
        START_SAY = r101;
        ScanMessageType r102 = new ScanMessageType("SAY_FINISH", 2);
        SAY_FINISH = r102;
        ScanMessageType r103 = new ScanMessageType("WER_CHECK_SUCCESS", 3);
        WER_CHECK_SUCCESS = r103;
        ScanMessageType r104 = new ScanMessageType("START_CREATE", 4);
        START_CREATE = r104;
        ScanMessageType r105 = new ScanMessageType("CREATE_SUCCESS", 5);
        CREATE_SUCCESS = r105;
        ScanMessageType r110 = new ScanMessageType("CREATE_FAIL", 6);
        CREATE_FAIL = r110;
        ScanMessageType r111 = new ScanMessageType(ErrorCode.INIT, 7);
        INIT = r111;
        ScanMessageType r112 = new ScanMessageType("CLEAR", 8);
        CLEAR = r112;
        ScanMessageType r113 = new ScanMessageType("FAIL", 9);
        FAIL = r113;
        ScanMessageType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f291035a = r114;
        f291036b = EnumEntriesKt.enumEntries(r114);
    }

    public static ScanMessageType[] values() {
        return (ScanMessageType[]) f291035a.clone();
    }

    public static ScanMessageType valueOf(String r100) {
        return (ScanMessageType) a.a(ScanMessageType.class, r100);
    }

    public ScanMessageType(String r100, int r101) {
        super(r100, r101);
    }
}
