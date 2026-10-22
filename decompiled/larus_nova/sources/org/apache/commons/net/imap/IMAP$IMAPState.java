package org.apache.commons.net.imap;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum IMAP$IMAPState extends Enum<IMAP$IMAPState> {
    private static final /* synthetic */ IMAP$IMAPState[] $VALUES = null;
    public static final IMAP$IMAPState AUTH_STATE = null;
    public static final IMAP$IMAPState DISCONNECTED_STATE = null;
    public static final IMAP$IMAPState LOGOUT_STATE = null;
    public static final IMAP$IMAPState NOT_AUTH_STATE = null;

    static {
        IMAP$IMAPState r100 = new IMAP$IMAPState("DISCONNECTED_STATE", 0);
        DISCONNECTED_STATE = r100;
        IMAP$IMAPState r101 = new IMAP$IMAPState("NOT_AUTH_STATE", 1);
        NOT_AUTH_STATE = r101;
        IMAP$IMAPState r102 = new IMAP$IMAPState("AUTH_STATE", 2);
        AUTH_STATE = r102;
        IMAP$IMAPState r103 = new IMAP$IMAPState("LOGOUT_STATE", 3);
        LOGOUT_STATE = r103;
        $VALUES = new IMAP$IMAPState[]{r100, r101, r102, r103};
    }

    public static IMAP$IMAPState[] values() {
        return (IMAP$IMAPState[]) $VALUES.clone();
    }

    public static IMAP$IMAPState valueOf(String r100) {
        return (IMAP$IMAPState) a.a(IMAP$IMAPState.class, r100);
    }

    private IMAP$IMAPState(String r100, int r101) {
        super(r100, r101);
    }
}
