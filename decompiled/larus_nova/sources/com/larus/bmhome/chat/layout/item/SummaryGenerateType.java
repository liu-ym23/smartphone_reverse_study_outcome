package com.larus.bmhome.chat.layout.item;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/SummaryGenerateType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Normal", "EmptyAudio", "NotCompleteSentence", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SummaryGenerateType extends Enum<SummaryGenerateType> {
    public static final SummaryGenerateType EmptyAudio = null;
    public static final SummaryGenerateType Normal = null;
    public static final SummaryGenerateType NotCompleteSentence = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SummaryGenerateType[] f304225a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f304226b = null;
    private final int type;

    public static EnumEntries<SummaryGenerateType> getEntries() {
        return f304226b;
    }

    static {
        SummaryGenerateType r100 = new SummaryGenerateType("Normal", 0, 0);
        Normal = r100;
        SummaryGenerateType r101 = new SummaryGenerateType("EmptyAudio", 1, 1);
        EmptyAudio = r101;
        SummaryGenerateType r102 = new SummaryGenerateType("NotCompleteSentence", 2, 2);
        NotCompleteSentence = r102;
        SummaryGenerateType[] r103 = {r100, r101, r102};
        f304225a = r103;
        f304226b = EnumEntriesKt.enumEntries(r103);
    }

    public static SummaryGenerateType[] values() {
        return (SummaryGenerateType[]) f304225a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static SummaryGenerateType valueOf(String r100) {
        return (SummaryGenerateType) r27.a.a(SummaryGenerateType.class, r100);
    }

    public SummaryGenerateType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
