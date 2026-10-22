package com.larus.dora.impl.guide.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/guide/common/GuideType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "PERMISSION", "BALLOON", "BOTTOM_SHEET", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GuideType extends Enum<GuideType> {
    public static final GuideType BALLOON = null;
    public static final GuideType BOTTOM_SHEET = null;
    public static final GuideType PERMISSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GuideType[] f335930a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335931b = null;
    private final int type;

    public static EnumEntries<GuideType> getEntries() {
        return f335931b;
    }

    static {
        GuideType r100 = new GuideType("PERMISSION", 0, 100001);
        PERMISSION = r100;
        GuideType r101 = new GuideType("BALLOON", 1, 100002);
        BALLOON = r101;
        GuideType r102 = new GuideType("BOTTOM_SHEET", 2, 100003);
        BOTTOM_SHEET = r102;
        GuideType[] r103 = {r100, r101, r102};
        f335930a = r103;
        f335931b = EnumEntriesKt.enumEntries(r103);
    }

    public static GuideType[] values() {
        return (GuideType[]) f335930a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static GuideType valueOf(String r100) {
        return (GuideType) a.a(GuideType.class, r100);
    }

    public GuideType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
