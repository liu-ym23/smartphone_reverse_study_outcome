package com.larus.avlink.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/avlink/model/TimerScene;", "", "<init>", "(Ljava/lang/String;I)V", "OnStart", "QueryEnd", "OnTtsPlayFinished", "OnReplyNoContent", "AuthDialog", "LocationAuthDialog", "StartConversationInEnvObserve", "NaturalWakeupConfirmed", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TimerScene extends Enum<TimerScene> {
    public static final TimerScene AuthDialog = null;
    public static final TimerScene LocationAuthDialog = null;
    public static final TimerScene NaturalWakeupConfirmed = null;
    public static final TimerScene OnReplyNoContent = null;
    public static final TimerScene OnStart = null;
    public static final TimerScene OnTtsPlayFinished = null;
    public static final TimerScene QueryEnd = null;
    public static final TimerScene StartConversationInEnvObserve = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TimerScene[] f293417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f293418b = null;

    public static EnumEntries<TimerScene> getEntries() {
        return f293418b;
    }

    static {
        TimerScene r100 = new TimerScene("OnStart", 0);
        OnStart = r100;
        TimerScene r101 = new TimerScene("QueryEnd", 1);
        QueryEnd = r101;
        TimerScene r102 = new TimerScene("OnTtsPlayFinished", 2);
        OnTtsPlayFinished = r102;
        TimerScene r103 = new TimerScene("OnReplyNoContent", 3);
        OnReplyNoContent = r103;
        TimerScene r104 = new TimerScene("AuthDialog", 4);
        AuthDialog = r104;
        TimerScene r105 = new TimerScene("LocationAuthDialog", 5);
        LocationAuthDialog = r105;
        TimerScene r110 = new TimerScene("StartConversationInEnvObserve", 6);
        StartConversationInEnvObserve = r110;
        TimerScene r111 = new TimerScene("NaturalWakeupConfirmed", 7);
        NaturalWakeupConfirmed = r111;
        TimerScene[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f293417a = r112;
        f293418b = EnumEntriesKt.enumEntries(r112);
    }

    public static TimerScene[] values() {
        return (TimerScene[]) f293417a.clone();
    }

    public static TimerScene valueOf(String r100) {
        return (TimerScene) r27.a.a(TimerScene.class, r100);
    }

    public TimerScene(String r100, int r101) {
        super(r100, r101);
    }
}
