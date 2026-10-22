package com.larus.bmhome.instruction.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/instruction/core/model/ActionBarExecutionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "BOT_SEND_MSG", "USER_SEND_MSG", "OPEN_BY_SCHEMA", "SWITCH_SYNC", "MSG_TEMPLATE", "COMPLEX_SEARCH", "INSTRUCTION", "RECORD", "MULTI_SUGGEST_ACTION", "SWITCH_STATUS", "GENERATE_PODCAST", "OPEN_CAMERA", "OBRIC_ACTION", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionBarExecutionType extends Enum<ActionBarExecutionType> {
    public static final ActionBarExecutionType BOT_SEND_MSG = null;
    public static final ActionBarExecutionType COMPLEX_SEARCH = null;
    public static final ActionBarExecutionType GENERATE_PODCAST = null;
    public static final ActionBarExecutionType INSTRUCTION = null;
    public static final ActionBarExecutionType MSG_TEMPLATE = null;
    public static final ActionBarExecutionType MULTI_SUGGEST_ACTION = null;
    public static final ActionBarExecutionType OBRIC_ACTION = null;
    public static final ActionBarExecutionType OPEN_BY_SCHEMA = null;
    public static final ActionBarExecutionType OPEN_CAMERA = null;
    public static final ActionBarExecutionType RECORD = null;
    public static final ActionBarExecutionType SWITCH_STATUS = null;
    public static final ActionBarExecutionType SWITCH_SYNC = null;
    public static final ActionBarExecutionType UNKNOWN = null;
    public static final ActionBarExecutionType USER_SEND_MSG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionBarExecutionType[] f312049a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312050b = null;
    private final int value;

    public static EnumEntries<ActionBarExecutionType> getEntries() {
        return f312050b;
    }

    static {
        ActionBarExecutionType r100 = new ActionBarExecutionType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ActionBarExecutionType r101 = new ActionBarExecutionType("BOT_SEND_MSG", 1, 1);
        BOT_SEND_MSG = r101;
        ActionBarExecutionType r102 = new ActionBarExecutionType("USER_SEND_MSG", 2, 2);
        USER_SEND_MSG = r102;
        ActionBarExecutionType r103 = new ActionBarExecutionType("OPEN_BY_SCHEMA", 3, 3);
        OPEN_BY_SCHEMA = r103;
        ActionBarExecutionType r104 = new ActionBarExecutionType("SWITCH_SYNC", 4, 4);
        SWITCH_SYNC = r104;
        ActionBarExecutionType r105 = new ActionBarExecutionType("MSG_TEMPLATE", 5, 5);
        MSG_TEMPLATE = r105;
        ActionBarExecutionType r110 = new ActionBarExecutionType("COMPLEX_SEARCH", 6, 6);
        COMPLEX_SEARCH = r110;
        ActionBarExecutionType r111 = new ActionBarExecutionType("INSTRUCTION", 7, 7);
        INSTRUCTION = r111;
        ActionBarExecutionType r112 = new ActionBarExecutionType("RECORD", 8, 8);
        RECORD = r112;
        ActionBarExecutionType r113 = new ActionBarExecutionType("MULTI_SUGGEST_ACTION", 9, 10);
        MULTI_SUGGEST_ACTION = r113;
        ActionBarExecutionType r114 = new ActionBarExecutionType("SWITCH_STATUS", 10, 11);
        SWITCH_STATUS = r114;
        ActionBarExecutionType r115 = new ActionBarExecutionType("GENERATE_PODCAST", 11, 12);
        GENERATE_PODCAST = r115;
        ActionBarExecutionType r106 = new ActionBarExecutionType("OPEN_CAMERA", 12, 13);
        OPEN_CAMERA = r106;
        ActionBarExecutionType r107 = new ActionBarExecutionType("OBRIC_ACTION", 13, 3001);
        OBRIC_ACTION = r107;
        ActionBarExecutionType[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
        f312049a = r108;
        f312050b = EnumEntriesKt.enumEntries(r108);
    }

    public static ActionBarExecutionType[] values() {
        return (ActionBarExecutionType[]) f312049a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ActionBarExecutionType valueOf(String r100) {
        return (ActionBarExecutionType) a.a(ActionBarExecutionType.class, r100);
    }

    public ActionBarExecutionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
