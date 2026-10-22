package com.obric.audio.continuous_talk;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/audio/continuous_talk/ObricContinuousTalkEndType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "TIMEOUT", "INTERRUPT", "MANUAL", "RESTART", "DESTROY", "STOP", "PAUSE", FlowDoraWifiScene.OTHER, "NETWORK_ERROR", "MEDIA_INTERRUPT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricContinuousTalkEndType extends Enum<ObricContinuousTalkEndType> {
    public static final ObricContinuousTalkEndType DESTROY = null;
    public static final ObricContinuousTalkEndType INTERRUPT = null;
    public static final ObricContinuousTalkEndType MANUAL = null;
    public static final ObricContinuousTalkEndType MEDIA_INTERRUPT = null;
    public static final ObricContinuousTalkEndType NETWORK_ERROR = null;
    public static final ObricContinuousTalkEndType OTHER = null;
    public static final ObricContinuousTalkEndType PAUSE = null;
    public static final ObricContinuousTalkEndType RESTART = null;
    public static final ObricContinuousTalkEndType STOP = null;
    public static final ObricContinuousTalkEndType TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricContinuousTalkEndType[] f395117a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f395118b = null;

    public static EnumEntries<ObricContinuousTalkEndType> getEntries() {
        return f395118b;
    }

    static {
        ObricContinuousTalkEndType r100 = new ObricContinuousTalkEndType("TIMEOUT", 0);
        TIMEOUT = r100;
        ObricContinuousTalkEndType r101 = new ObricContinuousTalkEndType("INTERRUPT", 1);
        INTERRUPT = r101;
        ObricContinuousTalkEndType r102 = new ObricContinuousTalkEndType("MANUAL", 2);
        MANUAL = r102;
        ObricContinuousTalkEndType r103 = new ObricContinuousTalkEndType("RESTART", 3);
        RESTART = r103;
        ObricContinuousTalkEndType r104 = new ObricContinuousTalkEndType("DESTROY", 4);
        DESTROY = r104;
        ObricContinuousTalkEndType r105 = new ObricContinuousTalkEndType("STOP", 5);
        STOP = r105;
        ObricContinuousTalkEndType r110 = new ObricContinuousTalkEndType("PAUSE", 6);
        PAUSE = r110;
        ObricContinuousTalkEndType r111 = new ObricContinuousTalkEndType(FlowDoraWifiScene.OTHER, 7);
        OTHER = r111;
        ObricContinuousTalkEndType r112 = new ObricContinuousTalkEndType("NETWORK_ERROR", 8);
        NETWORK_ERROR = r112;
        ObricContinuousTalkEndType r113 = new ObricContinuousTalkEndType("MEDIA_INTERRUPT", 9);
        MEDIA_INTERRUPT = r113;
        ObricContinuousTalkEndType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f395117a = r114;
        f395118b = EnumEntriesKt.enumEntries(r114);
    }

    public static ObricContinuousTalkEndType[] values() {
        return (ObricContinuousTalkEndType[]) f395117a.clone();
    }

    public static ObricContinuousTalkEndType valueOf(String r100) {
        return (ObricContinuousTalkEndType) r27.a.a(ObricContinuousTalkEndType.class, r100);
    }

    public ObricContinuousTalkEndType(String r100, int r101) {
        super(r100, r101);
    }
}
