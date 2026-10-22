package com.bytedance.ee.bear.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsLoadScene;", "", "serverScene", "", "<init>", "(Ljava/lang/String;II)V", "getServerScene", "()I", "DEFAULT", "SWITCH_ITEM", "SWITCH_TONE", "PRELOAD_TONE_LIST", "SEEK_BACKWARD", "M3U8_EXPIRED", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsLoadScene extends Enum<TtsLoadScene> {
    public static final TtsLoadScene DEFAULT = null;
    public static final TtsLoadScene M3U8_EXPIRED = null;
    public static final TtsLoadScene PRELOAD_TONE_LIST = null;
    public static final TtsLoadScene SEEK_BACKWARD = null;
    public static final TtsLoadScene SWITCH_ITEM = null;
    public static final TtsLoadScene SWITCH_TONE = null;
    public static final /* synthetic */ TtsLoadScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int serverScene;

    public static EnumEntries<TtsLoadScene> getEntries() {
        return b;
    }

    static {
        TtsLoadScene r0 = new TtsLoadScene("DEFAULT", 0, 0);
        DEFAULT = r0;
        TtsLoadScene r1 = new TtsLoadScene("SWITCH_ITEM", 1, 1);
        SWITCH_ITEM = r1;
        TtsLoadScene r3 = new TtsLoadScene("SWITCH_TONE", 2, 2);
        SWITCH_TONE = r3;
        TtsLoadScene r5 = new TtsLoadScene("PRELOAD_TONE_LIST", 3, 0);
        PRELOAD_TONE_LIST = r5;
        TtsLoadScene r7 = new TtsLoadScene("SEEK_BACKWARD", 4, 0);
        SEEK_BACKWARD = r7;
        TtsLoadScene r9 = new TtsLoadScene("M3U8_EXPIRED", 5, 0);
        M3U8_EXPIRED = r9;
        TtsLoadScene[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static TtsLoadScene[] values() {
        return (TtsLoadScene[]) a.clone();
    }

    public final int getServerScene() {
        return this.serverScene;
    }

    public static TtsLoadScene valueOf(String r1) {
        return (TtsLoadScene) r27.a.a(TtsLoadScene.class, r1);
    }

    public TtsLoadScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.serverScene = r3;
    }
}
