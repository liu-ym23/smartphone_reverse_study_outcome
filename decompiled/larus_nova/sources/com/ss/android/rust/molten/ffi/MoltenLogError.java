package com.ss.android.rust.molten.ffi;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/rust/molten/ffi/MoltenLogError;", "", "<init>", "(Ljava/lang/String;I)V", "IOError", "InvalidName", "InvalidPath", "InvalidEncrpytKey", "molten-log_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MoltenLogError extends Enum<MoltenLogError> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MoltenLogError[] $VALUES = null;
    public static final MoltenLogError IOError = null;
    public static final MoltenLogError InvalidEncrpytKey = null;
    public static final MoltenLogError InvalidName = null;
    public static final MoltenLogError InvalidPath = null;

    private static final /* synthetic */ MoltenLogError[] $values() {
        return new MoltenLogError[]{IOError, InvalidName, InvalidPath, InvalidEncrpytKey};
    }

    public static EnumEntries<MoltenLogError> getEntries() {
        return $ENTRIES;
    }

    static {
        IOError = new MoltenLogError("IOError", 0);
        InvalidName = new MoltenLogError("InvalidName", 1);
        InvalidPath = new MoltenLogError("InvalidPath", 2);
        InvalidEncrpytKey = new MoltenLogError("InvalidEncrpytKey", 3);
        MoltenLogError[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static MoltenLogError[] values() {
        return (MoltenLogError[]) $VALUES.clone();
    }

    public static MoltenLogError valueOf(String r100) {
        return (MoltenLogError) a.a(MoltenLogError.class, r100);
    }

    private MoltenLogError(String r100, int r101) {
        super(r100, r101);
    }
}
