package com.obric.assistant.interaction.api.keyguard;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/api/keyguard/RequestSource;", "", "<init>", "(Ljava/lang/String;I)V", "WINDOW", "DISMISS_KEYGUARD", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RequestSource extends Enum<RequestSource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RequestSource[] $VALUES = null;
    public static final RequestSource DISMISS_KEYGUARD = null;
    public static final RequestSource WINDOW = null;

    private static final /* synthetic */ RequestSource[] $values() {
        return new RequestSource[]{WINDOW, DISMISS_KEYGUARD};
    }

    public static EnumEntries<RequestSource> getEntries() {
        return $ENTRIES;
    }

    static {
        WINDOW = new RequestSource("WINDOW", 0);
        DISMISS_KEYGUARD = new RequestSource("DISMISS_KEYGUARD", 1);
        RequestSource[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static RequestSource[] values() {
        return (RequestSource[]) $VALUES.clone();
    }

    public static RequestSource valueOf(String r100) {
        return (RequestSource) a.a(RequestSource.class, r100);
    }

    private RequestSource(String r100, int r101) {
        super(r100, r101);
    }
}
