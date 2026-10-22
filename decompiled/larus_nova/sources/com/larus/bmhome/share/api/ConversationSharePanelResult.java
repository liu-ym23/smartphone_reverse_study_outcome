package com.larus.bmhome.share.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/share/api/ConversationSharePanelResult;", "", "<init>", "(Ljava/lang/String;I)V", "SHOWN", "FAILED", "UNSUPPORTED", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConversationSharePanelResult extends Enum<ConversationSharePanelResult> {
    public static final ConversationSharePanelResult FAILED = null;
    public static final ConversationSharePanelResult SHOWN = null;
    public static final ConversationSharePanelResult UNSUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConversationSharePanelResult[] f313827a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313828b = null;

    public static EnumEntries<ConversationSharePanelResult> getEntries() {
        return f313828b;
    }

    static {
        ConversationSharePanelResult r100 = new ConversationSharePanelResult("SHOWN", 0);
        SHOWN = r100;
        ConversationSharePanelResult r101 = new ConversationSharePanelResult("FAILED", 1);
        FAILED = r101;
        ConversationSharePanelResult r102 = new ConversationSharePanelResult("UNSUPPORTED", 2);
        UNSUPPORTED = r102;
        ConversationSharePanelResult[] r103 = {r100, r101, r102};
        f313827a = r103;
        f313828b = EnumEntriesKt.enumEntries(r103);
    }

    public static ConversationSharePanelResult[] values() {
        return (ConversationSharePanelResult[]) f313827a.clone();
    }

    public static ConversationSharePanelResult valueOf(String r100) {
        return (ConversationSharePanelResult) a.a(ConversationSharePanelResult.class, r100);
    }

    public ConversationSharePanelResult(String r100, int r101) {
        super(r100, r101);
    }
}
