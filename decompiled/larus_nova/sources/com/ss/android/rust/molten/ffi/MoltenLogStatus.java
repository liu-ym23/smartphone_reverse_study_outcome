package com.ss.android.rust.molten.ffi;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/rust/molten/ffi/MoltenLogStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Ok", "BadParam", "Locked", "Limited", "MultiFileCountLimited", "MultiFileCreateFailed", "MultiFileFirstWriteFailed", "Unknown", "molten-log_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MoltenLogStatus extends Enum<MoltenLogStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MoltenLogStatus[] $VALUES = null;
    public static final MoltenLogStatus BadParam = null;
    public static final MoltenLogStatus Limited = null;
    public static final MoltenLogStatus Locked = null;
    public static final MoltenLogStatus MultiFileCountLimited = null;
    public static final MoltenLogStatus MultiFileCreateFailed = null;
    public static final MoltenLogStatus MultiFileFirstWriteFailed = null;
    public static final MoltenLogStatus Ok = null;
    public static final MoltenLogStatus Unknown = null;

    private static final /* synthetic */ MoltenLogStatus[] $values() {
        return new MoltenLogStatus[]{Ok, BadParam, Locked, Limited, MultiFileCountLimited, MultiFileCreateFailed, MultiFileFirstWriteFailed, Unknown};
    }

    public static EnumEntries<MoltenLogStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        Ok = new MoltenLogStatus("Ok", 0);
        BadParam = new MoltenLogStatus("BadParam", 1);
        Locked = new MoltenLogStatus("Locked", 2);
        Limited = new MoltenLogStatus("Limited", 3);
        MultiFileCountLimited = new MoltenLogStatus("MultiFileCountLimited", 4);
        MultiFileCreateFailed = new MoltenLogStatus("MultiFileCreateFailed", 5);
        MultiFileFirstWriteFailed = new MoltenLogStatus("MultiFileFirstWriteFailed", 6);
        Unknown = new MoltenLogStatus("Unknown", 7);
        MoltenLogStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static MoltenLogStatus[] values() {
        return (MoltenLogStatus[]) $VALUES.clone();
    }

    public static MoltenLogStatus valueOf(String r100) {
        return (MoltenLogStatus) a.a(MoltenLogStatus.class, r100);
    }

    private MoltenLogStatus(String r100, int r101) {
        super(r100, r101);
    }
}
