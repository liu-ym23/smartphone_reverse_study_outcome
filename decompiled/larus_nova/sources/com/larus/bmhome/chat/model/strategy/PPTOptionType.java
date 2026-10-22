package com.larus.bmhome.chat.model.strategy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/model/strategy/PPTOptionType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "UNKNOWN", "PAGE_SIZE", "TEMPLATE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PPTOptionType extends Enum<PPTOptionType> {
    public static final PPTOptionType PAGE_SIZE = null;
    public static final PPTOptionType TEMPLATE = null;
    public static final PPTOptionType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PPTOptionType[] f307941a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f307942b = null;
    private final int type;

    public static EnumEntries<PPTOptionType> getEntries() {
        return f307942b;
    }

    static {
        PPTOptionType r100 = new PPTOptionType("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        PPTOptionType r101 = new PPTOptionType("PAGE_SIZE", 1, 0);
        PAGE_SIZE = r101;
        PPTOptionType r102 = new PPTOptionType("TEMPLATE", 2, 1);
        TEMPLATE = r102;
        PPTOptionType[] r103 = {r100, r101, r102};
        f307941a = r103;
        f307942b = EnumEntriesKt.enumEntries(r103);
    }

    public static PPTOptionType[] values() {
        return (PPTOptionType[]) f307941a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static PPTOptionType valueOf(String r100) {
        return (PPTOptionType) r27.a.a(PPTOptionType.class, r100);
    }

    public PPTOptionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
