package com.larus.bmhome.chat.component.bottom.core.speaker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/speaker/SessionType;", "", "<init>", "(Ljava/lang/String;I)V", "INTERCOM", "CLICK_TALK", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SessionType extends Enum<SessionType> {
    public static final SessionType CLICK_TALK = null;
    public static final a Companion = null;
    public static final SessionType INTERCOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SessionType[] f299393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f299394b = null;

    public static EnumEntries<SessionType> getEntries() {
        return f299394b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.core.speaker.SessionType$a] */
    static {
        SessionType r100 = new SessionType("INTERCOM", 0);
        INTERCOM = r100;
        SessionType r101 = new SessionType("CLICK_TALK", 1);
        CLICK_TALK = r101;
        SessionType[] r102 = {r100, r101};
        f299393a = r102;
        f299394b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static SessionType[] values() {
        return (SessionType[]) f299393a.clone();
    }

    public static SessionType valueOf(String r100) {
        return (SessionType) r27.a.a(SessionType.class, r100);
    }

    public SessionType(String r100, int r101) {
        super(r100, r101);
    }
}
