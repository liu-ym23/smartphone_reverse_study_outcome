package com.ss.android.ainote.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ainote/model/AINoteWriteError;", "", "<init>", "(Ljava/lang/String;I)V", "VERSION_LOW", "HAS_USE", "DELETED", "UNKNOWN", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AINoteWriteError extends Enum<AINoteWriteError> {
    public static final AINoteWriteError DELETED = null;
    public static final AINoteWriteError HAS_USE = null;
    public static final AINoteWriteError UNKNOWN = null;
    public static final AINoteWriteError VERSION_LOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AINoteWriteError[] f407150a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f407151b = null;

    public static EnumEntries<AINoteWriteError> getEntries() {
        return f407151b;
    }

    static {
        AINoteWriteError r100 = new AINoteWriteError("VERSION_LOW", 0);
        VERSION_LOW = r100;
        AINoteWriteError r101 = new AINoteWriteError("HAS_USE", 1);
        HAS_USE = r101;
        AINoteWriteError r102 = new AINoteWriteError("DELETED", 2);
        DELETED = r102;
        AINoteWriteError r103 = new AINoteWriteError("UNKNOWN", 3);
        UNKNOWN = r103;
        AINoteWriteError[] r104 = {r100, r101, r102, r103};
        f407150a = r104;
        f407151b = EnumEntriesKt.enumEntries(r104);
    }

    public static AINoteWriteError[] values() {
        return (AINoteWriteError[]) f407150a.clone();
    }

    public static AINoteWriteError valueOf(String r100) {
        return (AINoteWriteError) a.a(AINoteWriteError.class, r100);
    }

    public AINoteWriteError(String r100, int r101) {
        super(r100, r101);
    }
}
