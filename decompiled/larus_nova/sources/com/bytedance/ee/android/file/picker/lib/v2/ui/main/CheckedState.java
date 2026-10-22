package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/ui/main/CheckedState;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "FAILED_WITH_DIALOG", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CheckedState extends Enum<CheckedState> {
    public static final CheckedState FAILED = null;
    public static final CheckedState FAILED_WITH_DIALOG = null;
    public static final CheckedState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckedState[] f206108a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f206109b = null;

    public static EnumEntries<CheckedState> getEntries() {
        return f206109b;
    }

    static {
        CheckedState r100 = new CheckedState("SUCCESS", 0);
        SUCCESS = r100;
        CheckedState r101 = new CheckedState("FAILED", 1);
        FAILED = r101;
        CheckedState r102 = new CheckedState("FAILED_WITH_DIALOG", 2);
        FAILED_WITH_DIALOG = r102;
        CheckedState[] r103 = {r100, r101, r102};
        f206108a = r103;
        f206109b = EnumEntriesKt.enumEntries(r103);
    }

    public static CheckedState[] values() {
        return (CheckedState[]) f206108a.clone();
    }

    public static CheckedState valueOf(String r100) {
        return (CheckedState) r27.a.a(CheckedState.class, r100);
    }

    public CheckedState(String r100, int r101) {
        super(r100, r101);
    }
}
