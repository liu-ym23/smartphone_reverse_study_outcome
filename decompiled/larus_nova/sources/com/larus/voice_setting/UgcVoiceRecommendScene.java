package com.larus.voice_setting;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/voice_setting/UgcVoiceRecommendScene;", "", "<init>", "(Ljava/lang/String;I)V", "NULL", "BOT_FIRST_MET", "REAL_TIME", "CHAT_SETTING", "BOT_CREATE", "BOT_UPDATE", "ROUTER", "flow-voice-setting-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UgcVoiceRecommendScene extends Enum<UgcVoiceRecommendScene> {
    public static final UgcVoiceRecommendScene BOT_CREATE = null;
    public static final UgcVoiceRecommendScene BOT_FIRST_MET = null;
    public static final UgcVoiceRecommendScene BOT_UPDATE = null;
    public static final UgcVoiceRecommendScene CHAT_SETTING = null;
    public static final UgcVoiceRecommendScene NULL = null;
    public static final UgcVoiceRecommendScene REAL_TIME = null;
    public static final UgcVoiceRecommendScene ROUTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UgcVoiceRecommendScene[] f376050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f376051b = null;

    public static EnumEntries<UgcVoiceRecommendScene> getEntries() {
        return f376051b;
    }

    static {
        UgcVoiceRecommendScene r100 = new UgcVoiceRecommendScene("NULL", 0);
        NULL = r100;
        UgcVoiceRecommendScene r101 = new UgcVoiceRecommendScene("BOT_FIRST_MET", 1);
        BOT_FIRST_MET = r101;
        UgcVoiceRecommendScene r102 = new UgcVoiceRecommendScene("REAL_TIME", 2);
        REAL_TIME = r102;
        UgcVoiceRecommendScene r103 = new UgcVoiceRecommendScene("CHAT_SETTING", 3);
        CHAT_SETTING = r103;
        UgcVoiceRecommendScene r104 = new UgcVoiceRecommendScene("BOT_CREATE", 4);
        BOT_CREATE = r104;
        UgcVoiceRecommendScene r105 = new UgcVoiceRecommendScene("BOT_UPDATE", 5);
        BOT_UPDATE = r105;
        UgcVoiceRecommendScene r110 = new UgcVoiceRecommendScene("ROUTER", 6);
        ROUTER = r110;
        UgcVoiceRecommendScene[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f376050a = r111;
        f376051b = EnumEntriesKt.enumEntries(r111);
    }

    public static UgcVoiceRecommendScene[] values() {
        return (UgcVoiceRecommendScene[]) f376050a.clone();
    }

    public static UgcVoiceRecommendScene valueOf(String r100) {
        return (UgcVoiceRecommendScene) a.a(UgcVoiceRecommendScene.class, r100);
    }

    public UgcVoiceRecommendScene(String r100, int r101) {
        super(r100, r101);
    }
}
