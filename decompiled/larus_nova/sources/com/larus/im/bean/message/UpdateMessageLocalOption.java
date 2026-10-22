package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/bean/message/UpdateMessageLocalOption;", "", "<init>", "(Ljava/lang/String;I)V", "CONTENT", "LOCAL_STATUS", "LOCAL_MESSAGE_STATUS", "REPLACE_BIZ_EXT", "REPLACE_EXT", "MERGE_BIZ_EXT", "MERGE_EXT", "CREATE_TIME", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UpdateMessageLocalOption extends Enum<UpdateMessageLocalOption> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ UpdateMessageLocalOption[] $VALUES = null;
    public static final UpdateMessageLocalOption CONTENT = null;
    public static final UpdateMessageLocalOption CREATE_TIME = null;
    public static final UpdateMessageLocalOption LOCAL_MESSAGE_STATUS = null;
    public static final UpdateMessageLocalOption LOCAL_STATUS = null;
    public static final UpdateMessageLocalOption MERGE_BIZ_EXT = null;
    public static final UpdateMessageLocalOption MERGE_EXT = null;
    public static final UpdateMessageLocalOption REPLACE_BIZ_EXT = null;
    public static final UpdateMessageLocalOption REPLACE_EXT = null;

    private static final /* synthetic */ UpdateMessageLocalOption[] $values() {
        return new UpdateMessageLocalOption[]{CONTENT, LOCAL_STATUS, LOCAL_MESSAGE_STATUS, REPLACE_BIZ_EXT, REPLACE_EXT, MERGE_BIZ_EXT, MERGE_EXT, CREATE_TIME};
    }

    public static EnumEntries<UpdateMessageLocalOption> getEntries() {
        return $ENTRIES;
    }

    static {
        CONTENT = new UpdateMessageLocalOption("CONTENT", 0);
        LOCAL_STATUS = new UpdateMessageLocalOption("LOCAL_STATUS", 1);
        LOCAL_MESSAGE_STATUS = new UpdateMessageLocalOption("LOCAL_MESSAGE_STATUS", 2);
        REPLACE_BIZ_EXT = new UpdateMessageLocalOption("REPLACE_BIZ_EXT", 3);
        REPLACE_EXT = new UpdateMessageLocalOption("REPLACE_EXT", 4);
        MERGE_BIZ_EXT = new UpdateMessageLocalOption("MERGE_BIZ_EXT", 5);
        MERGE_EXT = new UpdateMessageLocalOption("MERGE_EXT", 6);
        CREATE_TIME = new UpdateMessageLocalOption("CREATE_TIME", 7);
        UpdateMessageLocalOption[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static UpdateMessageLocalOption[] values() {
        return (UpdateMessageLocalOption[]) $VALUES.clone();
    }

    public static UpdateMessageLocalOption valueOf(String r100) {
        return (UpdateMessageLocalOption) r27.a.a(UpdateMessageLocalOption.class, r100);
    }

    private UpdateMessageLocalOption(String r100, int r101) {
        super(r100, r101);
    }
}
