package com.larus.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/tts/TtsScene;", "", "<init>", "(Ljava/lang/String;I)V", "Auto_ReceiveMessage", "Auto_UpdateMessage", "Auto_Streaming", "Auto_OnBoarding", "Auto_Other", "Manual_ActionView", "Manual_LongPress", "Manual_Selector", "Manual_Other", "Default", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsScene extends Enum<TtsScene> {
    public static final TtsScene Auto_OnBoarding = null;
    public static final TtsScene Auto_Other = null;
    public static final TtsScene Auto_ReceiveMessage = null;
    public static final TtsScene Auto_Streaming = null;
    public static final TtsScene Auto_UpdateMessage = null;
    public static final TtsScene Default = null;
    public static final TtsScene Manual_ActionView = null;
    public static final TtsScene Manual_LongPress = null;
    public static final TtsScene Manual_Other = null;
    public static final TtsScene Manual_Selector = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsScene[] f370176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370177b = null;

    public static EnumEntries<TtsScene> getEntries() {
        return f370177b;
    }

    static {
        TtsScene r100 = new TtsScene("Auto_ReceiveMessage", 0);
        Auto_ReceiveMessage = r100;
        TtsScene r101 = new TtsScene("Auto_UpdateMessage", 1);
        Auto_UpdateMessage = r101;
        TtsScene r102 = new TtsScene("Auto_Streaming", 2);
        Auto_Streaming = r102;
        TtsScene r103 = new TtsScene("Auto_OnBoarding", 3);
        Auto_OnBoarding = r103;
        TtsScene r104 = new TtsScene("Auto_Other", 4);
        Auto_Other = r104;
        TtsScene r105 = new TtsScene("Manual_ActionView", 5);
        Manual_ActionView = r105;
        TtsScene r110 = new TtsScene("Manual_LongPress", 6);
        Manual_LongPress = r110;
        TtsScene r111 = new TtsScene("Manual_Selector", 7);
        Manual_Selector = r111;
        TtsScene r112 = new TtsScene("Manual_Other", 8);
        Manual_Other = r112;
        TtsScene r113 = new TtsScene("Default", 9);
        Default = r113;
        TtsScene[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f370176a = r114;
        f370177b = EnumEntriesKt.enumEntries(r114);
    }

    public static TtsScene[] values() {
        return (TtsScene[]) f370176a.clone();
    }

    public static TtsScene valueOf(String r100) {
        return (TtsScene) a.a(TtsScene.class, r100);
    }

    public TtsScene(String r100, int r101) {
        super(r100, r101);
    }
}
