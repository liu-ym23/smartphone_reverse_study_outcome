package com.larus.chat.job.impl.page.edit;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/chat/job/impl/page/edit/ChatJobEditOptionKey;", "", "<init>", "(Ljava/lang/String;I)V", "REPEAT", "FREQUENCY", "HOURLY_MINUTE", "DATE", "TIME", "RUN_TIME", "MODEL", "ENVIRONMENT", "PROJECT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatJobEditOptionKey extends Enum<ChatJobEditOptionKey> {
    public static final ChatJobEditOptionKey DATE = null;
    public static final ChatJobEditOptionKey ENVIRONMENT = null;
    public static final ChatJobEditOptionKey FREQUENCY = null;
    public static final ChatJobEditOptionKey HOURLY_MINUTE = null;
    public static final ChatJobEditOptionKey MODEL = null;
    public static final ChatJobEditOptionKey PROJECT = null;
    public static final ChatJobEditOptionKey REPEAT = null;
    public static final ChatJobEditOptionKey RUN_TIME = null;
    public static final ChatJobEditOptionKey TIME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatJobEditOptionKey[] f325187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f325188b = null;

    public static EnumEntries<ChatJobEditOptionKey> getEntries() {
        return f325188b;
    }

    static {
        ChatJobEditOptionKey r100 = new ChatJobEditOptionKey("REPEAT", 0);
        REPEAT = r100;
        ChatJobEditOptionKey r101 = new ChatJobEditOptionKey("FREQUENCY", 1);
        FREQUENCY = r101;
        ChatJobEditOptionKey r102 = new ChatJobEditOptionKey("HOURLY_MINUTE", 2);
        HOURLY_MINUTE = r102;
        ChatJobEditOptionKey r103 = new ChatJobEditOptionKey("DATE", 3);
        DATE = r103;
        ChatJobEditOptionKey r104 = new ChatJobEditOptionKey("TIME", 4);
        TIME = r104;
        ChatJobEditOptionKey r105 = new ChatJobEditOptionKey("RUN_TIME", 5);
        RUN_TIME = r105;
        ChatJobEditOptionKey r110 = new ChatJobEditOptionKey("MODEL", 6);
        MODEL = r110;
        ChatJobEditOptionKey r111 = new ChatJobEditOptionKey("ENVIRONMENT", 7);
        ENVIRONMENT = r111;
        ChatJobEditOptionKey r112 = new ChatJobEditOptionKey("PROJECT", 8);
        PROJECT = r112;
        ChatJobEditOptionKey[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f325187a = r113;
        f325188b = EnumEntriesKt.enumEntries(r113);
    }

    public static ChatJobEditOptionKey[] values() {
        return (ChatJobEditOptionKey[]) f325187a.clone();
    }

    public static ChatJobEditOptionKey valueOf(String r100) {
        return (ChatJobEditOptionKey) r27.a.a(ChatJobEditOptionKey.class, r100);
    }

    public ChatJobEditOptionKey(String r100, int r101) {
        super(r100, r101);
    }
}
