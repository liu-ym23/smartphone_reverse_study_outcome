package com.ss.android.lark.ai.lingo;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/ai/lingo/Page;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LingoCard", "MutipleSelection", "ai-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Page extends Enum<Page> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Page[] $VALUES = null;
    public static final Page LingoCard = null;
    public static final Page MutipleSelection = null;
    private final String value;

    private static final /* synthetic */ Page[] $values() {
        return new Page[]{LingoCard, MutipleSelection};
    }

    public static EnumEntries<Page> getEntries() {
        return $ENTRIES;
    }

    static {
        LingoCard = new Page("LingoCard", 0, "lingo_card");
        MutipleSelection = new Page("MutipleSelection", 1, "mutiple_selection");
        Page[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static Page[] values() {
        return (Page[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static Page valueOf(String r100) {
        return (Page) a.a(Page.class, r100);
    }

    private Page(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
