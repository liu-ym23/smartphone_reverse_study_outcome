package com.bytedance.ee.bear.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsDataSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DB", "DOC_META", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsDataSource extends Enum<TtsDataSource> {
    public static final TtsDataSource DB = null;
    public static final TtsDataSource DOC_META = null;
    public static final TtsDataSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsDataSource[] f239445a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f239446b = null;
    private final int value;

    public static EnumEntries<TtsDataSource> getEntries() {
        return f239446b;
    }

    static {
        TtsDataSource r100 = new TtsDataSource("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        TtsDataSource r101 = new TtsDataSource("DB", 1, 1);
        DB = r101;
        TtsDataSource r102 = new TtsDataSource("DOC_META", 2, 2);
        DOC_META = r102;
        TtsDataSource[] r103 = {r100, r101, r102};
        f239445a = r103;
        f239446b = EnumEntriesKt.enumEntries(r103);
    }

    public static TtsDataSource[] values() {
        return (TtsDataSource[]) f239445a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TtsDataSource valueOf(String r100) {
        return (TtsDataSource) r27.a.a(TtsDataSource.class, r100);
    }

    public TtsDataSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
