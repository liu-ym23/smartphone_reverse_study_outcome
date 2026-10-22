package com.larus.im.bean.conversation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/im/bean/conversation/UpdateConversationLocalOption;", "", "<init>", "(Ljava/lang/String;I)V", "TTS_ENABLE", "SECTION_ID", "REPLACE_BIZ_EXT", "REPLACE_EXT", "MERGE_BIZ_EXT", "MERGE_EXT", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UpdateConversationLocalOption extends Enum<UpdateConversationLocalOption> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ UpdateConversationLocalOption[] $VALUES = null;
    public static final UpdateConversationLocalOption MERGE_BIZ_EXT = null;
    public static final UpdateConversationLocalOption MERGE_EXT = null;
    public static final UpdateConversationLocalOption REPLACE_BIZ_EXT = null;
    public static final UpdateConversationLocalOption REPLACE_EXT = null;
    public static final UpdateConversationLocalOption SECTION_ID = null;
    public static final UpdateConversationLocalOption TTS_ENABLE = null;

    private static final /* synthetic */ UpdateConversationLocalOption[] $values() {
        return new UpdateConversationLocalOption[]{TTS_ENABLE, SECTION_ID, REPLACE_BIZ_EXT, REPLACE_EXT, MERGE_BIZ_EXT, MERGE_EXT};
    }

    public static EnumEntries<UpdateConversationLocalOption> getEntries() {
        return $ENTRIES;
    }

    static {
        TTS_ENABLE = new UpdateConversationLocalOption("TTS_ENABLE", 0);
        SECTION_ID = new UpdateConversationLocalOption("SECTION_ID", 1);
        REPLACE_BIZ_EXT = new UpdateConversationLocalOption("REPLACE_BIZ_EXT", 2);
        REPLACE_EXT = new UpdateConversationLocalOption("REPLACE_EXT", 3);
        MERGE_BIZ_EXT = new UpdateConversationLocalOption("MERGE_BIZ_EXT", 4);
        MERGE_EXT = new UpdateConversationLocalOption("MERGE_EXT", 5);
        UpdateConversationLocalOption[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static UpdateConversationLocalOption[] values() {
        return (UpdateConversationLocalOption[]) $VALUES.clone();
    }

    public static UpdateConversationLocalOption valueOf(String r100) {
        return (UpdateConversationLocalOption) a.a(UpdateConversationLocalOption.class, r100);
    }

    private UpdateConversationLocalOption(String r100, int r101) {
        super(r100, r101);
    }
}
