package com.larus.avatar.impl.scan.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/avatar/impl/scan/view/ScanErrorType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FRONT_NO_FACE_ERROR", "FRONT_OTHER_ERROR", "RECORD_ERROR", "WER_CHECK_FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScanErrorType extends Enum<ScanErrorType> {
    public static final ScanErrorType FRONT_NO_FACE_ERROR = null;
    public static final ScanErrorType FRONT_OTHER_ERROR = null;
    public static final ScanErrorType RECORD_ERROR = null;
    public static final ScanErrorType WER_CHECK_FAILED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScanErrorType[] f291216a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291217b = null;
    private final int value;

    public static EnumEntries<ScanErrorType> getEntries() {
        return f291217b;
    }

    static {
        ScanErrorType r100 = new ScanErrorType("FRONT_NO_FACE_ERROR", 0, 1);
        FRONT_NO_FACE_ERROR = r100;
        ScanErrorType r101 = new ScanErrorType("FRONT_OTHER_ERROR", 1, 2);
        FRONT_OTHER_ERROR = r101;
        ScanErrorType r102 = new ScanErrorType("RECORD_ERROR", 2, 3);
        RECORD_ERROR = r102;
        ScanErrorType r103 = new ScanErrorType("WER_CHECK_FAILED", 3, 4);
        WER_CHECK_FAILED = r103;
        ScanErrorType[] r104 = {r100, r101, r102, r103};
        f291216a = r104;
        f291217b = EnumEntriesKt.enumEntries(r104);
    }

    public static ScanErrorType[] values() {
        return (ScanErrorType[]) f291216a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ScanErrorType valueOf(String r100) {
        return (ScanErrorType) r27.a.a(ScanErrorType.class, r100);
    }

    public ScanErrorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
