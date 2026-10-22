package com.larus.bmhome.chat.api;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/api/SelectionRangeType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "WORD", "MARK_TEXT", "SENTENCE", "PARAGRAPH", "ENTIRE", "CUSTOM_RANGE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SelectionRangeType extends Enum<SelectionRangeType> {
    public static final SelectionRangeType CUSTOM_RANGE = null;
    public static final SelectionRangeType ENTIRE = null;
    public static final SelectionRangeType MARK_TEXT = null;
    public static final SelectionRangeType PARAGRAPH = null;
    public static final SelectionRangeType SENTENCE = null;
    public static final SelectionRangeType WORD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SelectionRangeType[] f297178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297179b = null;
    private final String value;

    public static EnumEntries<SelectionRangeType> getEntries() {
        return f297179b;
    }

    static {
        SelectionRangeType r100 = new SelectionRangeType("WORD", 0, EffectConfiguration.KEY_SEARCH_WORD);
        WORD = r100;
        SelectionRangeType r101 = new SelectionRangeType("MARK_TEXT", 1, "mark_text");
        MARK_TEXT = r101;
        SelectionRangeType r102 = new SelectionRangeType("SENTENCE", 2, "sentence");
        SENTENCE = r102;
        SelectionRangeType r103 = new SelectionRangeType("PARAGRAPH", 3, "paragraph");
        PARAGRAPH = r103;
        SelectionRangeType r104 = new SelectionRangeType("ENTIRE", 4, "entire");
        ENTIRE = r104;
        SelectionRangeType r105 = new SelectionRangeType("CUSTOM_RANGE", 5, "custom_range");
        CUSTOM_RANGE = r105;
        SelectionRangeType[] r110 = {r100, r101, r102, r103, r104, r105};
        f297178a = r110;
        f297179b = EnumEntriesKt.enumEntries(r110);
    }

    public static SelectionRangeType[] values() {
        return (SelectionRangeType[]) f297178a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static SelectionRangeType valueOf(String r100) {
        return (SelectionRangeType) r27.a.a(SelectionRangeType.class, r100);
    }

    public SelectionRangeType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
