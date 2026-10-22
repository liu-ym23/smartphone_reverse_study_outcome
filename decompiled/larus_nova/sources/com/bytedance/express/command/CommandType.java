package com.bytedance.express.command;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/express/command/CommandType;", "", "", "code", "I", "getCode", "()I", "ValueCommand", "IdentifierCommand", "FunctionCommand", "OperateCommand", "Unsupported", "express_release"}, k = 1, mv = {1, 4, 0})
public final enum CommandType extends Enum<CommandType> {
    public static final CommandType FunctionCommand = null;
    public static final CommandType IdentifierCommand = null;
    public static final CommandType OperateCommand = null;
    public static final CommandType Unsupported = null;
    public static final CommandType ValueCommand = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommandType[] f243191a = null;
    private final int code;

    static {
        CommandType r100 = new CommandType("ValueCommand", 0, 0);
        ValueCommand = r100;
        CommandType r101 = new CommandType("IdentifierCommand", 1, 1);
        IdentifierCommand = r101;
        CommandType r102 = new CommandType("FunctionCommand", 2, 2);
        FunctionCommand = r102;
        CommandType r103 = new CommandType("OperateCommand", 3, 3);
        OperateCommand = r103;
        CommandType r104 = new CommandType("Unsupported", 4, Integer.MAX_VALUE);
        Unsupported = r104;
        f243191a = new CommandType[]{r100, r101, r102, r103, r104};
    }

    public static CommandType valueOf(String r100) {
        return (CommandType) r27.a.a(CommandType.class, r100);
    }

    public static CommandType[] values() {
        return (CommandType[]) f243191a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public CommandType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
