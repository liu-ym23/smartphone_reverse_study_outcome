package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/MoveSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FROM_DETAIL", "FROM_FOLDER_BLOCK", "FROM_OTHER", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MoveSource extends Enum<MoveSource> {
    public static final MoveSource FROM_DETAIL = null;
    public static final MoveSource FROM_FOLDER_BLOCK = null;
    public static final MoveSource FROM_OTHER = null;
    public static final /* synthetic */ MoveSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<MoveSource> getEntries() {
        return b;
    }

    static {
        MoveSource r0 = new MoveSource("FROM_DETAIL", 0, 1);
        FROM_DETAIL = r0;
        MoveSource r1 = new MoveSource("FROM_FOLDER_BLOCK", 1, 2);
        FROM_FOLDER_BLOCK = r1;
        MoveSource r4 = new MoveSource("FROM_OTHER", 2, 0);
        FROM_OTHER = r4;
        MoveSource[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static MoveSource[] values() {
        return (MoveSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MoveSource valueOf(String r1) {
        return (MoveSource) r27.a.a(MoveSource.class, r1);
    }

    public MoveSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
