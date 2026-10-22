package com.obric.assistant.live.gr.island.island;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/live/gr/island/island/GRLiveCardType;", "", "<init>", "(Ljava/lang/String;I)V", "CALL", "ASSISTANT", "OAUTO", "MEMORY_DATA", "SCREEN_CAP", "BATTERY", "VIBRATE", "RING_DOWN", "MUTE", "AUTO_DISMISS", "SOUND_RECORD", "TRANSFER_DATA", "ALARM", "COUNT_DOWN", "STOP_WATCH", "MUSIC", OpenNetMethod.LOCK, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GRLiveCardType extends Enum<GRLiveCardType> {
    public static final GRLiveCardType ALARM = null;
    public static final GRLiveCardType ASSISTANT = null;
    public static final GRLiveCardType AUTO_DISMISS = null;
    public static final GRLiveCardType BATTERY = null;
    public static final GRLiveCardType CALL = null;
    public static final GRLiveCardType COUNT_DOWN = null;
    public static final a Companion = null;
    public static final GRLiveCardType LOCK = null;
    public static final GRLiveCardType MEMORY_DATA = null;
    public static final GRLiveCardType MUSIC = null;
    public static final GRLiveCardType MUTE = null;
    public static final GRLiveCardType OAUTO = null;
    public static final GRLiveCardType RING_DOWN = null;
    public static final GRLiveCardType SCREEN_CAP = null;
    public static final GRLiveCardType SOUND_RECORD = null;
    public static final GRLiveCardType STOP_WATCH = null;
    public static final GRLiveCardType TRANSFER_DATA = null;
    public static final GRLiveCardType VIBRATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GRLiveCardType[] f390077a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f390078b = null;

    public static EnumEntries<GRLiveCardType> getEntries() {
        return f390078b;
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [com.obric.assistant.live.gr.island.island.GRLiveCardType$a] */
    static {
        GRLiveCardType r100 = new GRLiveCardType("CALL", 0);
        CALL = r100;
        GRLiveCardType r101 = new GRLiveCardType("ASSISTANT", 1);
        ASSISTANT = r101;
        GRLiveCardType r102 = new GRLiveCardType("OAUTO", 2);
        OAUTO = r102;
        GRLiveCardType r103 = new GRLiveCardType("MEMORY_DATA", 3);
        MEMORY_DATA = r103;
        GRLiveCardType r104 = new GRLiveCardType("SCREEN_CAP", 4);
        SCREEN_CAP = r104;
        GRLiveCardType r105 = new GRLiveCardType("BATTERY", 5);
        BATTERY = r105;
        GRLiveCardType r110 = new GRLiveCardType("VIBRATE", 6);
        VIBRATE = r110;
        GRLiveCardType r111 = new GRLiveCardType("RING_DOWN", 7);
        RING_DOWN = r111;
        GRLiveCardType r112 = new GRLiveCardType("MUTE", 8);
        MUTE = r112;
        GRLiveCardType r113 = new GRLiveCardType("AUTO_DISMISS", 9);
        AUTO_DISMISS = r113;
        GRLiveCardType r114 = new GRLiveCardType("SOUND_RECORD", 10);
        SOUND_RECORD = r114;
        GRLiveCardType r115 = new GRLiveCardType("TRANSFER_DATA", 11);
        TRANSFER_DATA = r115;
        GRLiveCardType r106 = new GRLiveCardType("ALARM", 12);
        ALARM = r106;
        GRLiveCardType r107 = new GRLiveCardType("COUNT_DOWN", 13);
        COUNT_DOWN = r107;
        GRLiveCardType r108 = new GRLiveCardType("STOP_WATCH", 14);
        STOP_WATCH = r108;
        GRLiveCardType r109 = new GRLiveCardType("MUSIC", 15);
        MUSIC = r109;
        GRLiveCardType r116 = new GRLiveCardType(OpenNetMethod.LOCK, 16);
        LOCK = r116;
        GRLiveCardType[] r117 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
        f390077a = r117;
        f390078b = EnumEntriesKt.enumEntries(r117);
        Companion = new a();
    }

    public static GRLiveCardType[] values() {
        return (GRLiveCardType[]) f390077a.clone();
    }

    public static GRLiveCardType valueOf(String r100) {
        return (GRLiveCardType) r27.a.a(GRLiveCardType.class, r100);
    }

    public GRLiveCardType(String r100, int r101) {
        super(r100, r101);
    }
}
