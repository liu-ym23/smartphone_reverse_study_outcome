package org.apache.commons.net.imap;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum IMAPCommand extends Enum<IMAPCommand> {
    private static final /* synthetic */ IMAPCommand[] $VALUES = null;
    public static final IMAPCommand APPEND = null;
    public static final IMAPCommand AUTHENTICATE = null;
    public static final IMAPCommand CAPABILITY = null;
    public static final IMAPCommand CHECK = null;
    public static final IMAPCommand CLOSE = null;
    public static final IMAPCommand COPY = null;
    public static final IMAPCommand CREATE = null;
    public static final IMAPCommand DELETE = null;
    public static final IMAPCommand EXAMINE = null;
    public static final IMAPCommand EXPUNGE = null;
    public static final IMAPCommand FETCH = null;
    public static final IMAPCommand LIST = null;
    public static final IMAPCommand LOGIN = null;
    public static final IMAPCommand LOGOUT = null;
    public static final IMAPCommand LSUB = null;
    public static final IMAPCommand NOOP = null;
    public static final IMAPCommand RENAME = null;
    public static final IMAPCommand SEARCH = null;
    public static final IMAPCommand SELECT = null;
    public static final IMAPCommand STARTTLS = null;
    public static final IMAPCommand STATUS = null;
    public static final IMAPCommand STORE = null;
    public static final IMAPCommand SUBSCRIBE = null;
    public static final IMAPCommand UID = null;
    public static final IMAPCommand UNSUBSCRIBE = null;
    public static final IMAPCommand XOAUTH = null;
    private final String imapCommand;
    private final int maxParamCount;
    private final int minParamCount;

    static {
        IMAPCommand r100 = new IMAPCommand("CAPABILITY", 0, 0);
        CAPABILITY = r100;
        IMAPCommand r101 = new IMAPCommand("NOOP", 1, 0);
        NOOP = r101;
        IMAPCommand r102 = new IMAPCommand("LOGOUT", 2, 0);
        LOGOUT = r102;
        IMAPCommand r103 = new IMAPCommand("STARTTLS", 3, 0);
        STARTTLS = r103;
        IMAPCommand r104 = new IMAPCommand("AUTHENTICATE", 4, 1);
        AUTHENTICATE = r104;
        IMAPCommand r105 = new IMAPCommand("LOGIN", 5, 2);
        LOGIN = r105;
        IMAPCommand r110 = new IMAPCommand("XOAUTH", 6, 1);
        XOAUTH = r110;
        IMAPCommand r111 = new IMAPCommand("SELECT", 7, 1);
        SELECT = r111;
        IMAPCommand r112 = new IMAPCommand("EXAMINE", 8, 1);
        EXAMINE = r112;
        IMAPCommand r113 = new IMAPCommand("CREATE", 9, 1);
        CREATE = r113;
        IMAPCommand r114 = new IMAPCommand("DELETE", 10, 1);
        DELETE = r114;
        IMAPCommand r106 = new IMAPCommand("RENAME", 11, 2);
        RENAME = r106;
        IMAPCommand r107 = new IMAPCommand("SUBSCRIBE", 12, 1);
        SUBSCRIBE = r107;
        IMAPCommand r115 = new IMAPCommand("UNSUBSCRIBE", 13, 1);
        UNSUBSCRIBE = r115;
        IMAPCommand r108 = new IMAPCommand("LIST", 14, 2);
        LIST = r108;
        IMAPCommand r109 = new IMAPCommand("LSUB", 15, 2);
        LSUB = r109;
        IMAPCommand r116 = new IMAPCommand(CommonConstant.RETKEY.STATUS, 16, 2);
        STATUS = r116;
        IMAPCommand r117 = new IMAPCommand("APPEND", 17, 2, 4);
        APPEND = r117;
        IMAPCommand r118 = new IMAPCommand("CHECK", 18, 0);
        CHECK = r118;
        IMAPCommand r119 = new IMAPCommand("CLOSE", 19, 0);
        CLOSE = r119;
        IMAPCommand r120 = new IMAPCommand("EXPUNGE", 20, 0);
        EXPUNGE = r120;
        IMAPCommand r121 = new IMAPCommand("SEARCH", 21, 1, Integer.MAX_VALUE);
        SEARCH = r121;
        IMAPCommand r122 = new IMAPCommand("FETCH", 22, 2);
        FETCH = r122;
        IMAPCommand r123 = new IMAPCommand("STORE", 23, 3);
        STORE = r123;
        IMAPCommand r124 = new IMAPCommand("COPY", 24, 2);
        COPY = r124;
        IMAPCommand r125 = new IMAPCommand("UID", 25, 2, Integer.MAX_VALUE);
        UID = r125;
        $VALUES = new IMAPCommand[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r115, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
    }

    public static IMAPCommand[] values() {
        return (IMAPCommand[]) $VALUES.clone();
    }

    public String getIMAPCommand() {
        String r100 = this.imapCommand;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return name();
    }

    public static final String getCommand(IMAPCommand r100) {
        return r100.getIMAPCommand();
    }

    public static IMAPCommand valueOf(String r100) {
        return (IMAPCommand) a.a(IMAPCommand.class, r100);
    }

    private IMAPCommand(String r100, int r101, int r102) {
        this(r100, r101, null, r102, r102);
    }

    private IMAPCommand(String r100, int r101, int r102, int r110) {
        this(r100, r101, null, r102, r110);
    }

    private IMAPCommand(String r100, int r101, String r102, int r103, int r104) {
        super(r100, r101);
        this.imapCommand = r102;
        this.minParamCount = r103;
        this.maxParamCount = r104;
    }
}
