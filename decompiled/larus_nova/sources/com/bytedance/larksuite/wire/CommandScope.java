package com.bytedance.larksuite.wire;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/larksuite/wire/CommandScope;", "", "<init>", "(Ljava/lang/String;I)V", "GlobalScope", "UserScope", "lark-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum CommandScope extends Enum<CommandScope> {
    public static final CommandScope GlobalScope = null;
    public static final CommandScope UserScope = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommandScope[] f254477a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f254478b = null;

    public static EnumEntries<CommandScope> getEntries() {
        return f254478b;
    }

    static {
        CommandScope r100 = new CommandScope("GlobalScope", 0);
        GlobalScope = r100;
        CommandScope r101 = new CommandScope("UserScope", 1);
        UserScope = r101;
        CommandScope[] r102 = {r100, r101};
        f254477a = r102;
        f254478b = EnumEntriesKt.enumEntries(r102);
    }

    public static CommandScope[] values() {
        return (CommandScope[]) f254477a.clone();
    }

    public static CommandScope valueOf(String r100) {
        return (CommandScope) a.a(CommandScope.class, r100);
    }

    public CommandScope(String r100, int r101) {
        super(r100, r101);
    }
}
