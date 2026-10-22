package com.larus.audio.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/bean/RecommendScene;", "", "<init>", "(Ljava/lang/String;I)V", "NULL", "BOT_FIRST_MET", "REAL_TIME", "CHAT_SETTING", "BOT_CREATE", "BOT_UPDATE", "ROUTER", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecommendScene extends Enum<RecommendScene> {
    public static final RecommendScene BOT_CREATE = null;
    public static final RecommendScene BOT_FIRST_MET = null;
    public static final RecommendScene BOT_UPDATE = null;
    public static final RecommendScene CHAT_SETTING = null;
    public static final RecommendScene NULL = null;
    public static final RecommendScene REAL_TIME = null;
    public static final RecommendScene ROUTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecommendScene[] f288726a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288727b = null;

    public static EnumEntries<RecommendScene> getEntries() {
        return f288727b;
    }

    static {
        RecommendScene r100 = new RecommendScene("NULL", 0);
        NULL = r100;
        RecommendScene r101 = new RecommendScene("BOT_FIRST_MET", 1);
        BOT_FIRST_MET = r101;
        RecommendScene r102 = new RecommendScene("REAL_TIME", 2);
        REAL_TIME = r102;
        RecommendScene r103 = new RecommendScene("CHAT_SETTING", 3);
        CHAT_SETTING = r103;
        RecommendScene r104 = new RecommendScene("BOT_CREATE", 4);
        BOT_CREATE = r104;
        RecommendScene r105 = new RecommendScene("BOT_UPDATE", 5);
        BOT_UPDATE = r105;
        RecommendScene r110 = new RecommendScene("ROUTER", 6);
        ROUTER = r110;
        RecommendScene[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f288726a = r111;
        f288727b = EnumEntriesKt.enumEntries(r111);
    }

    public static RecommendScene[] values() {
        return (RecommendScene[]) f288726a.clone();
    }

    public static RecommendScene valueOf(String r100) {
        return (RecommendScene) a.a(RecommendScene.class, r100);
    }

    public RecommendScene(String r100, int r101) {
        super(r100, r101);
    }
}
