package com.larus.im.internal.tracking;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/tracking/MessageSuggestFrom;", "", "<init>", "(Ljava/lang/String;I)V", "CHUNK", "CMD", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageSuggestFrom extends Enum<MessageSuggestFrom> {
    public static final MessageSuggestFrom CHUNK = null;
    public static final MessageSuggestFrom CMD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageSuggestFrom[] f350221a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350222b = null;

    public static EnumEntries<MessageSuggestFrom> getEntries() {
        return f350222b;
    }

    static {
        MessageSuggestFrom r100 = new MessageSuggestFrom("CHUNK", 0);
        CHUNK = r100;
        MessageSuggestFrom r101 = new MessageSuggestFrom("CMD", 1);
        CMD = r101;
        MessageSuggestFrom[] r102 = {r100, r101};
        f350221a = r102;
        f350222b = EnumEntriesKt.enumEntries(r102);
    }

    public static MessageSuggestFrom[] values() {
        return (MessageSuggestFrom[]) f350221a.clone();
    }

    public static MessageSuggestFrom valueOf(String r100) {
        return (MessageSuggestFrom) r27.a.a(MessageSuggestFrom.class, r100);
    }

    public MessageSuggestFrom(String r100, int r101) {
        super(r100, r101);
    }
}
