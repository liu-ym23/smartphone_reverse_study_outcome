package org.apache.commons.net.imap;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum IMAPClient$STATUS_DATA_ITEMS extends Enum<IMAPClient$STATUS_DATA_ITEMS> {
    private static final /* synthetic */ IMAPClient$STATUS_DATA_ITEMS[] $VALUES = null;
    public static final IMAPClient$STATUS_DATA_ITEMS MESSAGES = null;
    public static final IMAPClient$STATUS_DATA_ITEMS RECENT = null;
    public static final IMAPClient$STATUS_DATA_ITEMS UIDNEXT = null;
    public static final IMAPClient$STATUS_DATA_ITEMS UIDVALIDITY = null;
    public static final IMAPClient$STATUS_DATA_ITEMS UNSEEN = null;

    static {
        IMAPClient$STATUS_DATA_ITEMS r100 = new IMAPClient$STATUS_DATA_ITEMS("MESSAGES", 0);
        MESSAGES = r100;
        IMAPClient$STATUS_DATA_ITEMS r101 = new IMAPClient$STATUS_DATA_ITEMS("RECENT", 1);
        RECENT = r101;
        IMAPClient$STATUS_DATA_ITEMS r102 = new IMAPClient$STATUS_DATA_ITEMS("UIDNEXT", 2);
        UIDNEXT = r102;
        IMAPClient$STATUS_DATA_ITEMS r103 = new IMAPClient$STATUS_DATA_ITEMS("UIDVALIDITY", 3);
        UIDVALIDITY = r103;
        IMAPClient$STATUS_DATA_ITEMS r104 = new IMAPClient$STATUS_DATA_ITEMS("UNSEEN", 4);
        UNSEEN = r104;
        $VALUES = new IMAPClient$STATUS_DATA_ITEMS[]{r100, r101, r102, r103, r104};
    }

    public static IMAPClient$STATUS_DATA_ITEMS[] values() {
        return (IMAPClient$STATUS_DATA_ITEMS[]) $VALUES.clone();
    }

    public static IMAPClient$STATUS_DATA_ITEMS valueOf(String r100) {
        return (IMAPClient$STATUS_DATA_ITEMS) a.a(IMAPClient$STATUS_DATA_ITEMS.class, r100);
    }

    private IMAPClient$STATUS_DATA_ITEMS(String r100, int r101) {
        super(r100, r101);
    }
}
