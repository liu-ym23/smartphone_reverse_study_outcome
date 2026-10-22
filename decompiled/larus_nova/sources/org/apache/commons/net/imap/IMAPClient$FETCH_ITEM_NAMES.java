package org.apache.commons.net.imap;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum IMAPClient$FETCH_ITEM_NAMES extends Enum<IMAPClient$FETCH_ITEM_NAMES> {
    private static final /* synthetic */ IMAPClient$FETCH_ITEM_NAMES[] $VALUES = null;
    public static final IMAPClient$FETCH_ITEM_NAMES ALL = null;
    public static final IMAPClient$FETCH_ITEM_NAMES BODY = null;
    public static final IMAPClient$FETCH_ITEM_NAMES BODYSTRUCTURE = null;
    public static final IMAPClient$FETCH_ITEM_NAMES ENVELOPE = null;
    public static final IMAPClient$FETCH_ITEM_NAMES FAST = null;
    public static final IMAPClient$FETCH_ITEM_NAMES FLAGS = null;
    public static final IMAPClient$FETCH_ITEM_NAMES FULL = null;
    public static final IMAPClient$FETCH_ITEM_NAMES INTERNALDATE = null;
    public static final IMAPClient$FETCH_ITEM_NAMES RFC822 = null;
    public static final IMAPClient$FETCH_ITEM_NAMES UID = null;

    static {
        IMAPClient$FETCH_ITEM_NAMES r100 = new IMAPClient$FETCH_ITEM_NAMES(AccountType.ALL, 0);
        ALL = r100;
        IMAPClient$FETCH_ITEM_NAMES r101 = new IMAPClient$FETCH_ITEM_NAMES("FAST", 1);
        FAST = r101;
        IMAPClient$FETCH_ITEM_NAMES r102 = new IMAPClient$FETCH_ITEM_NAMES("FULL", 2);
        FULL = r102;
        IMAPClient$FETCH_ITEM_NAMES r103 = new IMAPClient$FETCH_ITEM_NAMES("BODY", 3);
        BODY = r103;
        IMAPClient$FETCH_ITEM_NAMES r104 = new IMAPClient$FETCH_ITEM_NAMES("BODYSTRUCTURE", 4);
        BODYSTRUCTURE = r104;
        IMAPClient$FETCH_ITEM_NAMES r105 = new IMAPClient$FETCH_ITEM_NAMES("ENVELOPE", 5);
        ENVELOPE = r105;
        IMAPClient$FETCH_ITEM_NAMES r110 = new IMAPClient$FETCH_ITEM_NAMES("FLAGS", 6);
        FLAGS = r110;
        IMAPClient$FETCH_ITEM_NAMES r111 = new IMAPClient$FETCH_ITEM_NAMES("INTERNALDATE", 7);
        INTERNALDATE = r111;
        IMAPClient$FETCH_ITEM_NAMES r112 = new IMAPClient$FETCH_ITEM_NAMES("RFC822", 8);
        RFC822 = r112;
        IMAPClient$FETCH_ITEM_NAMES r113 = new IMAPClient$FETCH_ITEM_NAMES("UID", 9);
        UID = r113;
        $VALUES = new IMAPClient$FETCH_ITEM_NAMES[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static IMAPClient$FETCH_ITEM_NAMES[] values() {
        return (IMAPClient$FETCH_ITEM_NAMES[]) $VALUES.clone();
    }

    public static IMAPClient$FETCH_ITEM_NAMES valueOf(String r100) {
        return (IMAPClient$FETCH_ITEM_NAMES) a.a(IMAPClient$FETCH_ITEM_NAMES.class, r100);
    }

    private IMAPClient$FETCH_ITEM_NAMES(String r100, int r101) {
        super(r100, r101);
    }
}
