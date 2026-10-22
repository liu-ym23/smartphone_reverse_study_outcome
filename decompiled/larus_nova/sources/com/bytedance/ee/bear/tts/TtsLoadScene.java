package com.bytedance.ee.bear.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsLoadScene;", "", "serverScene", "", "<init>", "(Ljava/lang/String;II)V", "getServerScene", "()I", "DEFAULT", "SWITCH_ITEM", "SWITCH_TONE", "PRELOAD_TONE_LIST", "SEEK_BACKWARD", "M3U8_EXPIRED", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsLoadScene extends Enum<TtsLoadScene> {
    public static final TtsLoadScene DEFAULT = null;
    public static final TtsLoadScene M3U8_EXPIRED = null;
    public static final TtsLoadScene PRELOAD_TONE_LIST = null;
    public static final TtsLoadScene SEEK_BACKWARD = null;
    public static final TtsLoadScene SWITCH_ITEM = null;
    public static final TtsLoadScene SWITCH_TONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsLoadScene[] f239447a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f239448b = null;
    private final int serverScene;

    public static EnumEntries<TtsLoadScene> getEntries() {
        return f239448b;
    }

    static {
        TtsLoadScene r100 = new TtsLoadScene("DEFAULT", 0, 0);
        DEFAULT = r100;
        TtsLoadScene r101 = new TtsLoadScene("SWITCH_ITEM", 1, 1);
        SWITCH_ITEM = r101;
        TtsLoadScene r102 = new TtsLoadScene("SWITCH_TONE", 2, 2);
        SWITCH_TONE = r102;
        TtsLoadScene r103 = new TtsLoadScene("PRELOAD_TONE_LIST", 3, 0);
        PRELOAD_TONE_LIST = r103;
        TtsLoadScene r104 = new TtsLoadScene("SEEK_BACKWARD", 4, 0);
        SEEK_BACKWARD = r104;
        TtsLoadScene r105 = new TtsLoadScene("M3U8_EXPIRED", 5, 0);
        M3U8_EXPIRED = r105;
        TtsLoadScene[] r110 = {r100, r101, r102, r103, r104, r105};
        f239447a = r110;
        f239448b = EnumEntriesKt.enumEntries(r110);
    }

    public static TtsLoadScene[] values() {
        return (TtsLoadScene[]) f239447a.clone();
    }

    public final int getServerScene() {
        return this.serverScene;
    }

    public static TtsLoadScene valueOf(String r100) {
        return (TtsLoadScene) r27.a.a(TtsLoadScene.class, r100);
    }

    public TtsLoadScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.serverScene = r102;
    }
}
