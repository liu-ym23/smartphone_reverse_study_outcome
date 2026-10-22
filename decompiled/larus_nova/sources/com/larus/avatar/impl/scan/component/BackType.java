package com.larus.avatar.impl.scan.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avatar/impl/scan/component/BackType;", "", "<init>", "(Ljava/lang/String;I)V", "CLOSE", "BACK", "HOST_BACK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BackType extends Enum<BackType> {
    public static final BackType BACK = null;
    public static final BackType CLOSE = null;
    public static final BackType HOST_BACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackType[] f290885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f290886b = null;

    public static EnumEntries<BackType> getEntries() {
        return f290886b;
    }

    static {
        BackType r100 = new BackType("CLOSE", 0);
        CLOSE = r100;
        BackType r101 = new BackType("BACK", 1);
        BACK = r101;
        BackType r102 = new BackType("HOST_BACK", 2);
        HOST_BACK = r102;
        BackType[] r103 = {r100, r101, r102};
        f290885a = r103;
        f290886b = EnumEntriesKt.enumEntries(r103);
    }

    public static BackType[] values() {
        return (BackType[]) f290885a.clone();
    }

    public static BackType valueOf(String r100) {
        return (BackType) r27.a.a(BackType.class, r100);
    }

    public BackType(String r100, int r101) {
        super(r100, r101);
    }
}
