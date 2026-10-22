package com.ss.android.lark.biz.im.extension;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/biz/im/extension/PageType;", "", "<init>", "(Ljava/lang/String;I)V", "CHAT_WINDOW", "CHAT_THREAD", "REPLY_IN_THREAD", "MERGE_FORWARD", "THREAD_WINDOW", "THREAD_DETAIL", "THREAD_FORWARD", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageType extends Enum<PageType> {
    public static final PageType CHAT_THREAD = null;
    public static final PageType CHAT_WINDOW = null;
    public static final PageType MERGE_FORWARD = null;
    public static final PageType REPLY_IN_THREAD = null;
    public static final PageType THREAD_DETAIL = null;
    public static final PageType THREAD_FORWARD = null;
    public static final PageType THREAD_WINDOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageType[] f410489a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410490b = null;

    public static EnumEntries<PageType> getEntries() {
        return f410490b;
    }

    static {
        PageType r100 = new PageType("CHAT_WINDOW", 0);
        CHAT_WINDOW = r100;
        PageType r101 = new PageType("CHAT_THREAD", 1);
        CHAT_THREAD = r101;
        PageType r102 = new PageType("REPLY_IN_THREAD", 2);
        REPLY_IN_THREAD = r102;
        PageType r103 = new PageType("MERGE_FORWARD", 3);
        MERGE_FORWARD = r103;
        PageType r104 = new PageType("THREAD_WINDOW", 4);
        THREAD_WINDOW = r104;
        PageType r105 = new PageType("THREAD_DETAIL", 5);
        THREAD_DETAIL = r105;
        PageType r110 = new PageType("THREAD_FORWARD", 6);
        THREAD_FORWARD = r110;
        PageType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f410489a = r111;
        f410490b = EnumEntriesKt.enumEntries(r111);
    }

    public static PageType[] values() {
        return (PageType[]) f410489a.clone();
    }

    public static PageType valueOf(String r100) {
        return (PageType) a.a(PageType.class, r100);
    }

    public PageType(String r100, int r101) {
        super(r100, r101);
    }
}
