package com.larus.bmhome.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/utils/IMPageType;", "", "<init>", "(Ljava/lang/String;I)V", "IM_CHAT_BOT", "IM_CHAT_USER", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IMPageType extends Enum<IMPageType> {
    public static final IMPageType IM_CHAT_BOT = null;
    public static final IMPageType IM_CHAT_USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IMPageType[] f314897a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314898b = null;

    public static EnumEntries<IMPageType> getEntries() {
        return f314898b;
    }

    static {
        IMPageType r100 = new IMPageType("IM_CHAT_BOT", 0);
        IM_CHAT_BOT = r100;
        IMPageType r101 = new IMPageType("IM_CHAT_USER", 1);
        IM_CHAT_USER = r101;
        IMPageType[] r102 = {r100, r101};
        f314897a = r102;
        f314898b = EnumEntriesKt.enumEntries(r102);
    }

    public static IMPageType[] values() {
        return (IMPageType[]) f314897a.clone();
    }

    public static IMPageType valueOf(String r100) {
        return (IMPageType) r27.a.a(IMPageType.class, r100);
    }

    public IMPageType(String r100, int r101) {
        super(r100, r101);
    }
}
