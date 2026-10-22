package com.obric.assistant.special_input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/special_input/PhoneOperationModeRestoreResult;", "", "<init>", "(Ljava/lang/String;I)V", "READY", "NOT_READY", "UNAVAILABLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PhoneOperationModeRestoreResult extends Enum<PhoneOperationModeRestoreResult> {
    public static final PhoneOperationModeRestoreResult NOT_READY = null;
    public static final PhoneOperationModeRestoreResult READY = null;
    public static final PhoneOperationModeRestoreResult UNAVAILABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PhoneOperationModeRestoreResult[] f392628a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392629b = null;

    public static EnumEntries<PhoneOperationModeRestoreResult> getEntries() {
        return f392629b;
    }

    static {
        PhoneOperationModeRestoreResult r100 = new PhoneOperationModeRestoreResult("READY", 0);
        READY = r100;
        PhoneOperationModeRestoreResult r101 = new PhoneOperationModeRestoreResult("NOT_READY", 1);
        NOT_READY = r101;
        PhoneOperationModeRestoreResult r102 = new PhoneOperationModeRestoreResult("UNAVAILABLE", 2);
        UNAVAILABLE = r102;
        PhoneOperationModeRestoreResult[] r103 = {r100, r101, r102};
        f392628a = r103;
        f392629b = EnumEntriesKt.enumEntries(r103);
    }

    public static PhoneOperationModeRestoreResult[] values() {
        return (PhoneOperationModeRestoreResult[]) f392628a.clone();
    }

    public static PhoneOperationModeRestoreResult valueOf(String r100) {
        return (PhoneOperationModeRestoreResult) r27.a.a(PhoneOperationModeRestoreResult.class, r100);
    }

    public PhoneOperationModeRestoreResult(String r100, int r101) {
        super(r100, r101);
    }
}
