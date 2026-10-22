package com.bytedance.ee.bear.tts.lynx.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/tts/lynx/bean/TtsLynxPlayerAction;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "START_PLAYING", "RESUME", "PAUSE", "CHANGE_SPEED", "CHANGE_SPEAKER", "REMOVE_ITEM", "ON_CLICK_FLOAT_VIEW", "TERMINATE", "PLAY_PREVIOUS", "PLAY_NEXT", "OPEN_CONTENT", "OPEN_PLAYLIST", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsLynxPlayerAction extends Enum<TtsLynxPlayerAction> {
    public static final TtsLynxPlayerAction CHANGE_SPEAKER = null;
    public static final TtsLynxPlayerAction CHANGE_SPEED = null;
    public static final a Companion = null;
    public static final TtsLynxPlayerAction ON_CLICK_FLOAT_VIEW = null;
    public static final TtsLynxPlayerAction OPEN_CONTENT = null;
    public static final TtsLynxPlayerAction OPEN_PLAYLIST = null;
    public static final TtsLynxPlayerAction PAUSE = null;
    public static final TtsLynxPlayerAction PLAY_NEXT = null;
    public static final TtsLynxPlayerAction PLAY_PREVIOUS = null;
    public static final TtsLynxPlayerAction REMOVE_ITEM = null;
    public static final TtsLynxPlayerAction RESUME = null;
    public static final TtsLynxPlayerAction START_PLAYING = null;
    public static final TtsLynxPlayerAction TERMINATE = null;
    public static final /* synthetic */ TtsLynxPlayerAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<TtsLynxPlayerAction> getEntries() {
        return b;
    }

    static {
        TtsLynxPlayerAction r0 = new TtsLynxPlayerAction("START_PLAYING", 0, 0);
        START_PLAYING = r0;
        TtsLynxPlayerAction r1 = new TtsLynxPlayerAction("RESUME", 1, 1);
        RESUME = r1;
        TtsLynxPlayerAction r3 = new TtsLynxPlayerAction("PAUSE", 2, 2);
        PAUSE = r3;
        TtsLynxPlayerAction r5 = new TtsLynxPlayerAction("CHANGE_SPEED", 3, 3);
        CHANGE_SPEED = r5;
        TtsLynxPlayerAction r7 = new TtsLynxPlayerAction("CHANGE_SPEAKER", 4, 4);
        CHANGE_SPEAKER = r7;
        TtsLynxPlayerAction r9 = new TtsLynxPlayerAction("REMOVE_ITEM", 5, 5);
        REMOVE_ITEM = r9;
        TtsLynxPlayerAction r11 = new TtsLynxPlayerAction("ON_CLICK_FLOAT_VIEW", 6, 6);
        ON_CLICK_FLOAT_VIEW = r11;
        TtsLynxPlayerAction r13 = new TtsLynxPlayerAction("TERMINATE", 7, 7);
        TERMINATE = r13;
        TtsLynxPlayerAction r15 = new TtsLynxPlayerAction("PLAY_PREVIOUS", 8, 8);
        PLAY_PREVIOUS = r15;
        TtsLynxPlayerAction r14 = new TtsLynxPlayerAction("PLAY_NEXT", 9, 9);
        PLAY_NEXT = r14;
        TtsLynxPlayerAction r12 = new TtsLynxPlayerAction("OPEN_CONTENT", 10, 10);
        OPEN_CONTENT = r12;
        TtsLynxPlayerAction r10 = new TtsLynxPlayerAction("OPEN_PLAYLIST", 11, 11);
        OPEN_PLAYLIST = r10;
        TtsLynxPlayerAction[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
        Companion = new a();
    }

    public static TtsLynxPlayerAction[] values() {
        return (TtsLynxPlayerAction[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final TtsLynxPlayerAction from(int r6) {
        Companion.getClass();
        TtsLynxPlayerAction[] r0 = values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        TtsLynxPlayerAction r4 = r0[r3];
        if (r4.getValue() != r6) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L15;
        r3 = r3 + 1;
        goto L3
    L15:
        return r4;
    L7:
        r5 = false;
        goto L8
    L11:
        return null;
    }

    public static TtsLynxPlayerAction valueOf(String r1) {
        return (TtsLynxPlayerAction) r27.a.a(TtsLynxPlayerAction.class, r1);
    }

    public TtsLynxPlayerAction(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
