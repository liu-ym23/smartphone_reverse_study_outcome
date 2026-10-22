package com.larus.bmhome.auth;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/auth/ColdStartTtsType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "INVALID", "ENABLED", "DISABLED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ColdStartTtsType extends Enum<ColdStartTtsType> {
    public static final ColdStartTtsType DISABLED = null;
    public static final ColdStartTtsType ENABLED = null;
    public static final ColdStartTtsType INVALID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ColdStartTtsType[] f295719a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f295720b = null;
    private final int type;

    public static EnumEntries<ColdStartTtsType> getEntries() {
        return f295720b;
    }

    static {
        ColdStartTtsType r100 = new ColdStartTtsType("INVALID", 0, 0);
        INVALID = r100;
        ColdStartTtsType r101 = new ColdStartTtsType("ENABLED", 1, 1);
        ENABLED = r101;
        ColdStartTtsType r102 = new ColdStartTtsType("DISABLED", 2, 2);
        DISABLED = r102;
        ColdStartTtsType[] r103 = {r100, r101, r102};
        f295719a = r103;
        f295720b = EnumEntriesKt.enumEntries(r103);
    }

    public static ColdStartTtsType[] values() {
        return (ColdStartTtsType[]) f295719a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static ColdStartTtsType valueOf(String r100) {
        return (ColdStartTtsType) r27.a.a(ColdStartTtsType.class, r100);
    }

    public ColdStartTtsType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
