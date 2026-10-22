package com.larus.extension.summary_card.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/extension/summary_card/api/model/SummaryCardItemType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "VIDEO", "ARTICLE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SummaryCardItemType extends Enum<SummaryCardItemType> {
    public static final SummaryCardItemType ARTICLE = null;
    public static final SummaryCardItemType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SummaryCardItemType[] f342911a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f342912b = null;
    private final int value;

    public static EnumEntries<SummaryCardItemType> getEntries() {
        return f342912b;
    }

    static {
        SummaryCardItemType r100 = new SummaryCardItemType("VIDEO", 0, 0);
        VIDEO = r100;
        SummaryCardItemType r101 = new SummaryCardItemType("ARTICLE", 1, 1);
        ARTICLE = r101;
        SummaryCardItemType[] r102 = {r100, r101};
        f342911a = r102;
        f342912b = EnumEntriesKt.enumEntries(r102);
    }

    public static SummaryCardItemType[] values() {
        return (SummaryCardItemType[]) f342911a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SummaryCardItemType valueOf(String r100) {
        return (SummaryCardItemType) a.a(SummaryCardItemType.class, r100);
    }

    public SummaryCardItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
