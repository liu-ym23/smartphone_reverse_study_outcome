package com.larus.share.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/share/service/ShareDocType;", "", "<init>", "(Ljava/lang/String;I)V", "SLIDES", "SHEET", "DRIVE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ShareDocType extends Enum<ShareDocType> {
    public static final ShareDocType DRIVE = null;
    public static final ShareDocType SHEET = null;
    public static final ShareDocType SLIDES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareDocType[] f368884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f368885b = null;

    public static EnumEntries<ShareDocType> getEntries() {
        return f368885b;
    }

    static {
        ShareDocType r100 = new ShareDocType("SLIDES", 0);
        SLIDES = r100;
        ShareDocType r101 = new ShareDocType("SHEET", 1);
        SHEET = r101;
        ShareDocType r102 = new ShareDocType("DRIVE", 2);
        DRIVE = r102;
        ShareDocType[] r103 = {r100, r101, r102};
        f368884a = r103;
        f368885b = EnumEntriesKt.enumEntries(r103);
    }

    public static ShareDocType[] values() {
        return (ShareDocType[]) f368884a.clone();
    }

    public static ShareDocType valueOf(String r100) {
        return (ShareDocType) r27.a.a(ShareDocType.class, r100);
    }

    public ShareDocType(String r100, int r101) {
        super(r100, r101);
    }
}
