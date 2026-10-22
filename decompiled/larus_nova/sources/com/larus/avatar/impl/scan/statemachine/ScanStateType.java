package com.larus.avatar.impl.scan.statemachine;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/avatar/impl/scan/statemachine/ScanStateType;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", ErrorCode.INIT, "FAIL", "COUNTING_DOWN", "SAYING", "WER_CHECKING", "NOT_UPLOAD", "UPLOADING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScanStateType extends Enum<ScanStateType> {
    public static final ScanStateType COUNTING_DOWN = null;
    public static final ScanStateType FAIL = null;
    public static final ScanStateType IDLE = null;
    public static final ScanStateType INIT = null;
    public static final ScanStateType NOT_UPLOAD = null;
    public static final ScanStateType SAYING = null;
    public static final ScanStateType UPLOADING = null;
    public static final ScanStateType WER_CHECKING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScanStateType[] f291037a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291038b = null;

    public static EnumEntries<ScanStateType> getEntries() {
        return f291038b;
    }

    static {
        ScanStateType r100 = new ScanStateType("IDLE", 0);
        IDLE = r100;
        ScanStateType r101 = new ScanStateType(ErrorCode.INIT, 1);
        INIT = r101;
        ScanStateType r102 = new ScanStateType("FAIL", 2);
        FAIL = r102;
        ScanStateType r103 = new ScanStateType("COUNTING_DOWN", 3);
        COUNTING_DOWN = r103;
        ScanStateType r104 = new ScanStateType("SAYING", 4);
        SAYING = r104;
        ScanStateType r105 = new ScanStateType("WER_CHECKING", 5);
        WER_CHECKING = r105;
        ScanStateType r110 = new ScanStateType("NOT_UPLOAD", 6);
        NOT_UPLOAD = r110;
        ScanStateType r111 = new ScanStateType("UPLOADING", 7);
        UPLOADING = r111;
        ScanStateType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f291037a = r112;
        f291038b = EnumEntriesKt.enumEntries(r112);
    }

    public static ScanStateType[] values() {
        return (ScanStateType[]) f291037a.clone();
    }

    public static ScanStateType valueOf(String r100) {
        return (ScanStateType) a.a(ScanStateType.class, r100);
    }

    public ScanStateType(String r100, int r101) {
        super(r100, r101);
    }
}
