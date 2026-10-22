package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b \b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/larus/im/bean/message/block/ActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ACTION_TYPE_UNKNOWN", "SEND_NEW_MSG", "SEND_NEW_MSG_WITH_REPLY", "SUGGEST_REPLY_COPY_TO_INPUTBOX", "SUGGEST_REPLY_SEND_TO_CHAT", "SKIP", "OPERATION", "VOICE_CALL", "UPLOAD_FILE", "AUTHORIZE", "PAYMENT", "CUA_ASK_REPLY", "CUA_ASK_SKIP", "CUA_REQUEST_ACTION_UPLOAD_FILE", "CUA_REQUEST_ACTION_BROWSER_OPERATION", "CUA_REQUEST_ACTION_SKIP", "CUA_WARN_ALLOW", "CUA_WARN_REFUSE", "CUA_AUTHORIZE_FOLDER_ALLOW", "CUA_AUTHORIZE_FOLDER_SELECT", "CUA_AUTHORIZE_FOLDER_REFUSE", "CUA_REQUEST_ACTION_PIP_OPERATION", "CUA_REQUEST_ACTION_PIP_SANDBOX_ENV_INIT", "CUA_ALWAYS_ALLOW", "OPEN_WEBSITE", "MOA_AUTH_ALLOW", "MOA_AUTH_REFUSE", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionType extends Enum<ActionType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ActionType[] $VALUES = null;
    public static final ActionType ACTION_TYPE_UNKNOWN = null;
    public static final ActionType AUTHORIZE = null;
    public static final ActionType CUA_ALWAYS_ALLOW = null;
    public static final ActionType CUA_ASK_REPLY = null;
    public static final ActionType CUA_ASK_SKIP = null;
    public static final ActionType CUA_AUTHORIZE_FOLDER_ALLOW = null;
    public static final ActionType CUA_AUTHORIZE_FOLDER_REFUSE = null;
    public static final ActionType CUA_AUTHORIZE_FOLDER_SELECT = null;
    public static final ActionType CUA_REQUEST_ACTION_BROWSER_OPERATION = null;
    public static final ActionType CUA_REQUEST_ACTION_PIP_OPERATION = null;
    public static final ActionType CUA_REQUEST_ACTION_PIP_SANDBOX_ENV_INIT = null;
    public static final ActionType CUA_REQUEST_ACTION_SKIP = null;
    public static final ActionType CUA_REQUEST_ACTION_UPLOAD_FILE = null;
    public static final ActionType CUA_WARN_ALLOW = null;
    public static final ActionType CUA_WARN_REFUSE = null;
    public static final ActionType MOA_AUTH_ALLOW = null;
    public static final ActionType MOA_AUTH_REFUSE = null;
    public static final ActionType OPEN_WEBSITE = null;
    public static final ActionType OPERATION = null;
    public static final ActionType PAYMENT = null;
    public static final ActionType SEND_NEW_MSG = null;
    public static final ActionType SEND_NEW_MSG_WITH_REPLY = null;
    public static final ActionType SKIP = null;
    public static final ActionType SUGGEST_REPLY_COPY_TO_INPUTBOX = null;
    public static final ActionType SUGGEST_REPLY_SEND_TO_CHAT = null;
    public static final ActionType UPLOAD_FILE = null;
    public static final ActionType VOICE_CALL = null;
    private final int value;

    private static final /* synthetic */ ActionType[] $values() {
        return new ActionType[]{ACTION_TYPE_UNKNOWN, SEND_NEW_MSG, SEND_NEW_MSG_WITH_REPLY, SUGGEST_REPLY_COPY_TO_INPUTBOX, SUGGEST_REPLY_SEND_TO_CHAT, SKIP, OPERATION, VOICE_CALL, UPLOAD_FILE, AUTHORIZE, PAYMENT, CUA_ASK_REPLY, CUA_ASK_SKIP, CUA_REQUEST_ACTION_UPLOAD_FILE, CUA_REQUEST_ACTION_BROWSER_OPERATION, CUA_REQUEST_ACTION_SKIP, CUA_WARN_ALLOW, CUA_WARN_REFUSE, CUA_AUTHORIZE_FOLDER_ALLOW, CUA_AUTHORIZE_FOLDER_SELECT, CUA_AUTHORIZE_FOLDER_REFUSE, CUA_REQUEST_ACTION_PIP_OPERATION, CUA_REQUEST_ACTION_PIP_SANDBOX_ENV_INIT, CUA_ALWAYS_ALLOW, OPEN_WEBSITE, MOA_AUTH_ALLOW, MOA_AUTH_REFUSE};
    }

    public static EnumEntries<ActionType> getEntries() {
        return $ENTRIES;
    }

    static {
        ACTION_TYPE_UNKNOWN = new ActionType("ACTION_TYPE_UNKNOWN", 0, 0);
        SEND_NEW_MSG = new ActionType("SEND_NEW_MSG", 1, 1);
        SEND_NEW_MSG_WITH_REPLY = new ActionType("SEND_NEW_MSG_WITH_REPLY", 2, 2);
        SUGGEST_REPLY_COPY_TO_INPUTBOX = new ActionType("SUGGEST_REPLY_COPY_TO_INPUTBOX", 3, 30);
        SUGGEST_REPLY_SEND_TO_CHAT = new ActionType("SUGGEST_REPLY_SEND_TO_CHAT", 4, 31);
        SKIP = new ActionType("SKIP", 5, 100);
        OPERATION = new ActionType("OPERATION", 6, 1000);
        VOICE_CALL = new ActionType("VOICE_CALL", 7, 1001);
        UPLOAD_FILE = new ActionType("UPLOAD_FILE", 8, 1002);
        AUTHORIZE = new ActionType("AUTHORIZE", 9, 1003);
        PAYMENT = new ActionType("PAYMENT", 10, 1004);
        CUA_ASK_REPLY = new ActionType("CUA_ASK_REPLY", 11, 1005);
        CUA_ASK_SKIP = new ActionType("CUA_ASK_SKIP", 12, 1006);
        CUA_REQUEST_ACTION_UPLOAD_FILE = new ActionType("CUA_REQUEST_ACTION_UPLOAD_FILE", 13, 1007);
        CUA_REQUEST_ACTION_BROWSER_OPERATION = new ActionType("CUA_REQUEST_ACTION_BROWSER_OPERATION", 14, 1008);
        CUA_REQUEST_ACTION_SKIP = new ActionType("CUA_REQUEST_ACTION_SKIP", 15, 1009);
        CUA_WARN_ALLOW = new ActionType("CUA_WARN_ALLOW", 16, 1010);
        CUA_WARN_REFUSE = new ActionType("CUA_WARN_REFUSE", 17, 1011);
        CUA_AUTHORIZE_FOLDER_ALLOW = new ActionType("CUA_AUTHORIZE_FOLDER_ALLOW", 18, 1012);
        CUA_AUTHORIZE_FOLDER_SELECT = new ActionType("CUA_AUTHORIZE_FOLDER_SELECT", 19, 1013);
        CUA_AUTHORIZE_FOLDER_REFUSE = new ActionType("CUA_AUTHORIZE_FOLDER_REFUSE", 20, 1014);
        CUA_REQUEST_ACTION_PIP_OPERATION = new ActionType("CUA_REQUEST_ACTION_PIP_OPERATION", 21, 1015);
        CUA_REQUEST_ACTION_PIP_SANDBOX_ENV_INIT = new ActionType("CUA_REQUEST_ACTION_PIP_SANDBOX_ENV_INIT", 22, 1016);
        CUA_ALWAYS_ALLOW = new ActionType("CUA_ALWAYS_ALLOW", 23, 1018);
        OPEN_WEBSITE = new ActionType("OPEN_WEBSITE", 24, 1020);
        MOA_AUTH_ALLOW = new ActionType("MOA_AUTH_ALLOW", 25, 1500);
        MOA_AUTH_REFUSE = new ActionType("MOA_AUTH_REFUSE", 26, 1501);
        ActionType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ActionType[] values() {
        return (ActionType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ActionType valueOf(String r100) {
        return (ActionType) a.a(ActionType.class, r100);
    }

    private ActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
