package com.larus.asr.session.clicktalk;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/asr/session/clicktalk/ClickTalkAsrRoute;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO_STOP", "FLOW_ASR_TASK", "REALTIME_SERVICE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ClickTalkAsrRoute extends Enum<ClickTalkAsrRoute> {
    public static final ClickTalkAsrRoute AUTO_STOP = null;
    public static final ClickTalkAsrRoute FLOW_ASR_TASK = null;
    public static final ClickTalkAsrRoute REALTIME_SERVICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClickTalkAsrRoute[] f287585a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f287586b = null;

    public static EnumEntries<ClickTalkAsrRoute> getEntries() {
        return f287586b;
    }

    static {
        ClickTalkAsrRoute r100 = new ClickTalkAsrRoute("AUTO_STOP", 0);
        AUTO_STOP = r100;
        ClickTalkAsrRoute r101 = new ClickTalkAsrRoute("FLOW_ASR_TASK", 1);
        FLOW_ASR_TASK = r101;
        ClickTalkAsrRoute r102 = new ClickTalkAsrRoute("REALTIME_SERVICE", 2);
        REALTIME_SERVICE = r102;
        ClickTalkAsrRoute[] r103 = {r100, r101, r102};
        f287585a = r103;
        f287586b = EnumEntriesKt.enumEntries(r103);
    }

    public static ClickTalkAsrRoute[] values() {
        return (ClickTalkAsrRoute[]) f287585a.clone();
    }

    public static ClickTalkAsrRoute valueOf(String r100) {
        return (ClickTalkAsrRoute) r27.a.a(ClickTalkAsrRoute.class, r100);
    }

    public ClickTalkAsrRoute(String r100, int r101) {
        super(r100, r101);
    }
}
