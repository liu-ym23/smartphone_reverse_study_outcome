package com.larus.platform.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/platform/model/ApmScene;", "", "<init>", "(Ljava/lang/String;I)V", "DORA_QUERY", "TTS_PLAY", "REALTIME_CALL", "NAVIGATION_LOCATING", "MUSIC_PLAY", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ApmScene extends Enum<ApmScene> {
    public static final ApmScene DORA_QUERY = null;
    public static final ApmScene MUSIC_PLAY = null;
    public static final ApmScene NAVIGATION_LOCATING = null;
    public static final ApmScene REALTIME_CALL = null;
    public static final ApmScene TTS_PLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ApmScene[] f365449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365450b = null;

    public static EnumEntries<ApmScene> getEntries() {
        return f365450b;
    }

    static {
        ApmScene r100 = new ApmScene("DORA_QUERY", 0);
        DORA_QUERY = r100;
        ApmScene r101 = new ApmScene("TTS_PLAY", 1);
        TTS_PLAY = r101;
        ApmScene r102 = new ApmScene("REALTIME_CALL", 2);
        REALTIME_CALL = r102;
        ApmScene r103 = new ApmScene("NAVIGATION_LOCATING", 3);
        NAVIGATION_LOCATING = r103;
        ApmScene r104 = new ApmScene("MUSIC_PLAY", 4);
        MUSIC_PLAY = r104;
        ApmScene[] r105 = {r100, r101, r102, r103, r104};
        f365449a = r105;
        f365450b = EnumEntriesKt.enumEntries(r105);
    }

    public static ApmScene[] values() {
        return (ApmScene[]) f365449a.clone();
    }

    public static ApmScene valueOf(String r100) {
        return (ApmScene) a.a(ApmScene.class, r100);
    }

    public ApmScene(String r100, int r101) {
        super(r100, r101);
    }
}
