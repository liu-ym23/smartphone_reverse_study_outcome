package com.larus.im.bean.bot;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/bot/BotUpdateType;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.OTHERS, "MODIFY_BOT_MODEL", "MODIFY_LANGUAGE", "MODIFY_MESSAGE_PUSH", "ACCESS_PERMISSION", "MODIFY_VOICE", "MODIFY_LTM_STATUS", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BotUpdateType extends Enum<BotUpdateType> {
    public static final BotUpdateType ACCESS_PERMISSION = null;
    public static final BotUpdateType MODIFY_BOT_MODEL = null;
    public static final BotUpdateType MODIFY_LANGUAGE = null;
    public static final BotUpdateType MODIFY_LTM_STATUS = null;
    public static final BotUpdateType MODIFY_MESSAGE_PUSH = null;
    public static final BotUpdateType MODIFY_VOICE = null;
    public static final BotUpdateType OTHERS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BotUpdateType[] f346451a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346452b = null;

    public static EnumEntries<BotUpdateType> getEntries() {
        return f346452b;
    }

    static {
        BotUpdateType r100 = new BotUpdateType(AccountType.OTHERS, 0);
        OTHERS = r100;
        BotUpdateType r101 = new BotUpdateType("MODIFY_BOT_MODEL", 1);
        MODIFY_BOT_MODEL = r101;
        BotUpdateType r102 = new BotUpdateType("MODIFY_LANGUAGE", 2);
        MODIFY_LANGUAGE = r102;
        BotUpdateType r103 = new BotUpdateType("MODIFY_MESSAGE_PUSH", 3);
        MODIFY_MESSAGE_PUSH = r103;
        BotUpdateType r104 = new BotUpdateType("ACCESS_PERMISSION", 4);
        ACCESS_PERMISSION = r104;
        BotUpdateType r105 = new BotUpdateType("MODIFY_VOICE", 5);
        MODIFY_VOICE = r105;
        BotUpdateType r110 = new BotUpdateType("MODIFY_LTM_STATUS", 6);
        MODIFY_LTM_STATUS = r110;
        BotUpdateType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f346451a = r111;
        f346452b = EnumEntriesKt.enumEntries(r111);
    }

    public static BotUpdateType[] values() {
        return (BotUpdateType[]) f346451a.clone();
    }

    public static BotUpdateType valueOf(String r100) {
        return (BotUpdateType) r27.a.a(BotUpdateType.class, r100);
    }

    public BotUpdateType(String r100, int r101) {
        super(r100, r101);
    }
}
