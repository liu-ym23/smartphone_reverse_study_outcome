package com.bytedance.ee.bear.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsDataSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DB", "DOC_META", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsDataSource extends Enum<TtsDataSource> {
    public static final TtsDataSource DB = null;
    public static final TtsDataSource DOC_META = null;
    public static final TtsDataSource UNKNOWN = null;
    public static final /* synthetic */ TtsDataSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<TtsDataSource> getEntries() {
        return b;
    }

    static {
        TtsDataSource r0 = new TtsDataSource("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        TtsDataSource r1 = new TtsDataSource("DB", 1, 1);
        DB = r1;
        TtsDataSource r3 = new TtsDataSource("DOC_META", 2, 2);
        DOC_META = r3;
        TtsDataSource[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static TtsDataSource[] values() {
        return (TtsDataSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TtsDataSource valueOf(String r1) {
        return (TtsDataSource) r27.a.a(TtsDataSource.class, r1);
    }

    public TtsDataSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
